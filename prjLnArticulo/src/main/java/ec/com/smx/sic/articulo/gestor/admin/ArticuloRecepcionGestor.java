/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin;

import java.sql.Timestamp;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloValidacion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.articuloImportacion.IArticuloProveedorImportacionGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author gaortiz, mgranda
 *
 */
public class ArticuloRecepcionGestor extends BaseArticuloGestor{
	
	
	private IArticuloProveedorImportacionGestor articuloProveedorImportacionGestor;
	private IHibernateH<ArticuloDTO> hibernateH;

	@SuppressWarnings("unchecked")
	@Override
	public ArticuloVO registrarArticulo(ArticuloVO articuloVO) throws SICException {
		Logeable.LOG_SICV2.info(" ");
		Logeable.LOG_SICV2.info(" => Inicio registrando el articulo {}", articuloVO.getBaseDTO().getDescripcionArticulo());
		
		try{
			//this.validarArticuloGeneral(articuloVO);
			Boolean omitirIntegracion = articuloVO.hasDynamicProperty(ArticuloTransient.OMITIR_INTEGRACION_ARTICULO) ? Boolean.FALSE: Boolean.TRUE;
			
			if(SICArticuloConstantes.ESTADOARTICULO_PRECODIFICADO.equals(articuloVO.getBaseDTOAnterior().getCodigoEstado())
					&& SICArticuloConstantes.ESTADOARTICULO_CODIFICADO.equals(articuloVO.getBaseDTO().getCodigoEstado())){
				Logeable.LOG_SICV2.info("==> Registrando bitacora codigo barras");
				this.articuloBitacoraGestor.registrar(articuloVO);
				omitirIntegracion = Boolean.FALSE;
			}
			
			if (articuloVO.getBaseDTO().getCodigoEstado() != null || articuloVO.getBaseDTO().getCodigoSubClasificacion() != null 
					|| articuloVO.getDynamicProperty("isChangeGrupoTrabajo", Boolean.class)) {
				Logeable.LOG_SICV2.info("==> Registrando articulo");
				this.registrarArticuloGeneral(articuloVO, Boolean.FALSE);
				omitirIntegracion = Boolean.FALSE;
			}
			
			if(articuloVO.getBaseDTO().getArticuloComercialDTO() != null){
				Logeable.LOG_SICV2.info("==> Registrando articulo comercial");
				this.validarArticuloComercial(articuloVO.getBaseDTO().getArticuloComercialDTO());
				this.articuloComercialGestor.actualizarMarcaComercial(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId(), articuloVO.getBaseDTO().getArticuloComercialDTO().getCodigoMarcaComercial());
				omitirIntegracion = Boolean.FALSE;
			}
			
			if (articuloVO.getBaseDTO().getTieneUnidadManejoCol()) {
				Logeable.LOG_SICV2.info("==> Registrando asignacion de unidades de manejo");
				
				Collection<Long> ids = CollectionUtils.collect(articuloVO.getBaseDTO().getArticuloUnidadManejoCol(), new Transformer() {
					@Override
					public Object transform(Object input) {
						ArticuloUnidadManejoDTO articuloUnidadManejoDTO = (ArticuloUnidadManejoDTO) input;
						return articuloUnidadManejoDTO.getId().getCodigoUnidadManejo();
					}
				});
				
				for(ArticuloUnidadManejoDTO articuloUnidadManejoDTO : articuloVO.getBaseDTO().getArticuloUnidadManejoCol()){
					this.articuloUnidadManejoGestor.asignarMaximaPrioridadUnidadManejo(articuloVO.getBaseDTO().getId().getCodigoCompania(), articuloVO.getBaseDTO().getId().getCodigoArticulo(), articuloVO.getBaseDTO().getUserId(), articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
				}
				
				omitirIntegracion = Boolean.FALSE;
			}

			if (CollectionUtils.isNotEmpty(articuloVO.getArticuloImportacionCol())) {
				Logeable.LOG_SICV2.info("==> Registrando datos de importacion");
				this.articuloProveedorImportacionGestor.registrarArticuloImportacion(articuloVO.getArticuloImportacionCol(), articuloVO.getBaseDTO().getDescripcionArticulo());
				omitirIntegracion = Boolean.FALSE;
			}
			
			if(articuloVO.getArticuloProveedorDTO() != null){
				Boolean esCreacion = articuloVO.getArticuloProveedorDTO().hasDynamicProperty(SICConstantes.EVENTO_INSERTAR);
				articuloVO.getArticuloProveedorDTO().setUserId(articuloVO.getBaseDTO().getUserId());
				this.articuloProveedorGestor.registrarArticuloProveedorImpuesto(articuloVO.getArticuloProveedorDTO(), esCreacion);
				omitirIntegracion = Boolean.FALSE;
			}
			
			if(articuloVO.getBaseDTO().getCodigoGrupoAlcance()!= null){
				Logeable.LOG_SICV2.info("==> Registrando cambios de prototipos");
				this.articuloAlcanceGestor.insertarAlcancesCambioPrototipo(articuloVO);				
				//solo si es un articulo nuevo se toman en cuenta las siguientes relaciones
				if(CollectionUtils.isNotEmpty(articuloVO.getAreasTrabajoCol())){
					@SuppressWarnings("unchecked")
					Collection<ArticuloLocalDTO> articuloLocalCol = CollectionUtils.collect(articuloVO.getAreasTrabajoCol(), new Transformer() {
						
						@Override
						public Object transform(Object input) {
							AreaTrabajoDTO areaTrabajoDTO = (AreaTrabajoDTO) input;
							ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
							articuloLocalDTO.getId().setCodigoLocal(areaTrabajoDTO.getId().getCodigoAreaTrabajo());
							articuloLocalDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
							return articuloLocalDTO;
						}
					});
					articuloVO.getBaseDTO().setArticuloLocalCol(articuloLocalCol);
				}
				
				this.calculoArticuloGestor.asignarPrototipoAlcance(articuloVO.getBaseDTO());
				omitirIntegracion = Boolean.FALSE;
			}
			
			if(BooleanUtils.isFalse(omitirIntegracion)){
				this.calculoArticuloGestor.registrarArticuloPendienteIntegracion(articuloVO);
			}
			
		}catch (SICException e) {
			if(articuloVO != null && articuloVO.getBaseDTO() != null){
				Logeable.LOG_SICV2.error("Ha ocurrido un error al registrar articulo recepcion: codigo articulo:{0}, codigobarras: {1}", (articuloVO.getBaseDTO().getId() != null ? articuloVO.getBaseDTO().getId().getCodigoArticulo() : "N/D"), ((articuloVO.getBaseDTO().getCodigoBarrasActivo() != null && articuloVO.getBaseDTO().getCodigoBarrasActivo().getId() != null) ? articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras() : "N/D"));
			}
			throw e;
		}catch (Exception e) {
			if(articuloVO != null && articuloVO.getBaseDTO() != null){
				Logeable.LOG_SICV2.error("Ha ocurrido un error al registrar articulo recepcion: codigo articulo:{0}, codigobarras: {1}", (articuloVO.getBaseDTO().getId() != null ? articuloVO.getBaseDTO().getId().getCodigoArticulo() : "N/D"), ((articuloVO.getBaseDTO().getCodigoBarrasActivo() != null && articuloVO.getBaseDTO().getCodigoBarrasActivo().getId() != null) ? articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras() : "N/D"));
			}
			throw new SICException(SICArticuloValidacion.MENSAJE_ERROR_REGISTRAR_ARTICULO, e);
		}
		
		Logeable.LOG_SICV2.info(" => Fin registrando el articulo ");
		
		return null;
	}
	
	public void validarArticuloGeneral(ArticuloVO articuloVO) throws SICException {
		if(articuloVO.getBaseDTO() == null){
			throw new SICException("El art\u00EDculo base es necesario.");
		}
		if(articuloVO.getBaseDTO().getId().getCodigoCompania() == null){
			throw new SICException("El codigo de compania en art\u00EDculo es requerido.");
		}
		if(articuloVO.getBaseDTO().getId().getCodigoArticulo() == null){
			throw new SICException("El codigo del art\u00EDculo es requerido.");
		}
		if(articuloVO.getAccessItemId() == null){
			throw new SICException("El campo accessItemId es necesario para el registro del art\u00EDculo.");
		}
		if(articuloVO.getSystemId() == null){
			throw new SICException("El campo systemId es necesario para el registro del art\u00EDculo.");
		}
		if(articuloVO.getBaseDTO().getUserId() == null){
			throw new SICException("El campo userId es necesario para el registro del art\u00EDculo.");
		}
		
		if(!articuloVO.getBaseDTO().getTieneArticuloProveedor()){
			throw new SICException("La relacion art\u00EDculo-proveedor es necesario para el registro del art\u00EDculo.");	
		}
	}
	
	private void validarArticuloComercial(ArticuloComercialDTO articuloComercialDTO) throws SICException {
		if(articuloComercialDTO.getCodigoMarcaComercial() == null){
			throw new SICException("El art\u00EDculoComercial no tiene una marca asignada.");
		}
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void registrarArticuloGeneral(ArticuloVO articuloVO, Boolean esCreacion) throws SICException {
		
		
		Logeable.LOG_SICV2.info("==> Registrando articulo");
		
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			
			if(articuloVO.getBaseDTO().getCodigoBarrasActivo() != null && articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoBarrasPOS() != null && !StringUtils.equals(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo(), SICArticuloConstantes.ESTADOARTICULO_CODIFICADO)){
				articuloVO.getBaseDTO().setCodigoBarras(articuloVO.getBaseDTO().getCodigoBarrasActivo().getId().getCodigoBarras());
				articuloVO.getBaseDTO().setCodigoBarrasPOS(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoBarrasPOS());
				articuloVO.getBaseDTO().setCodigoTipoCodigoArticulo(articuloVO.getBaseDTO().getCodigoBarrasActivo().getCodigoTipoCodigoArticulo());
			}
			
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("update ").append(ArticuloDTO.class.getName()).append(" art ")
			.append("set ");
			if(articuloVO.getBaseDTO().getCodigoEstado() != null){
				query.append("art.codigoEstado = :pCodigoEstado, ");
			}
			if(articuloVO.getBaseDTO().getCodigoSubClasificacion() != null){
				query.append("art.codigoSubClasificacion = :pCodigoSubClasificacion, ");
			}
			if(articuloVO.getBaseDTO().getCodigoGrupoAlcance() != null){
				query.append("art.codigoGrupoAlcance = :pCodigoGrupoAlcance, ");
			}
			if(articuloVO.getBaseDTO().getCodigoBarras() != null){
				query.append("art.codigoBarras = :pCodigoBarras, ");
			}
			if(articuloVO.getBaseDTO().getCodigoBarrasPOS() != null){
				query.append("art.codigoBarrasPOS = :pCodigoBarrasPOS, ");
			}
			if(articuloVO.getBaseDTO().getCodigoTipoCodigoArticulo() != null){
				query.append("art.codigoTipoCodigoArticulo = :pCodigoTipoCodigoArticulo, ");
			}
			
			
			query.append("art.usuarioActualizacion = :pUsuarioActualizacion, ")
			.append("art.fechaUltimaActualizacion = :pDate ")
			.append("where art.id.codigoCompania = :pCompania ")
			.append("and art.id.codigoArticulo = :pCodigoArticulo ");
			
			Query update = session.createQuery(query.toString());
			
			//parametros actualizar
			if(articuloVO.getBaseDTO().getCodigoEstado() != null){
				update.setString("pCodigoEstado", articuloVO.getBaseDTO().getCodigoEstado());
			}
			if(articuloVO.getBaseDTO().getCodigoSubClasificacion() != null){
				update.setString("pCodigoSubClasificacion", articuloVO.getBaseDTO().getCodigoSubClasificacion());
			}
			if(articuloVO.getBaseDTO().getCodigoGrupoAlcance() != null){
				update.setLong("pCodigoGrupoAlcance", articuloVO.getBaseDTO().getCodigoGrupoAlcance());
			}
			if(articuloVO.getBaseDTO().getCodigoBarras() != null){
				update.setString("pCodigoBarras", articuloVO.getBaseDTO().getCodigoBarras());
			}
			if(articuloVO.getBaseDTO().getCodigoBarrasPOS() != null){
				update.setString("pCodigoBarrasPOS", articuloVO.getBaseDTO().getCodigoBarrasPOS());
			}
			if(articuloVO.getBaseDTO().getCodigoTipoCodigoArticulo() != null){
				update.setString("pCodigoTipoCodigoArticulo", articuloVO.getBaseDTO().getCodigoTipoCodigoArticulo());
			}
			
			update.setString("pUsuarioActualizacion", articuloVO.getBaseDTO().getUserId());
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
			
			//parametros where
			update.setInteger("pCompania", articuloVO.getBaseDTO().getId().getCodigoCompania());
			update.setString("pCodigoArticulo", articuloVO.getBaseDTO().getId().getCodigoArticulo());
			
			update.executeUpdate();
			
		} catch (Exception e) {
			throw new SICException("Error al actualizar la informacion de articulo.", e);
		}
		
	}
	
	/**
	 * Metodo que inactiva las unidades de manejo por una prioridad especifica y puede omitir una unidad de manejo especifica.
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param prioridad
	 * @param codigoUnidadManejo codigo de unidad de manejo que se omite puede anularse este parametro
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	@Override
	public Integer inactivarUnidadManejoPorPrioridad(Integer codigoCompania, String codigoArticulo, Integer prioridad, String userId, Long... codigoUnidadManejo) throws SICException{
		return this.articuloUnidadManejoGestor.inactivarUnidadManejoPorPrioridad(codigoCompania, codigoArticulo, SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO, userId, new Long[0]);
	}


	/**
	 * @param hibernateH the hibernateH to set
	 */
	public final void setHibernateH(IHibernateH<ArticuloDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}

	public final void setArticuloProveedorImportacionGestor(IArticuloProveedorImportacionGestor articuloProveedorImportacionGestor) {
		this.articuloProveedorImportacionGestor = articuloProveedorImportacionGestor;
	}
}