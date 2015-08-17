/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.UbicacionTransaccionDivisionGeoPoliticaDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.proveedor.TipoCatalogosProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoClaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloCreacionPorArchivoDAO;

/**
 * @author eharo
 *
 */
public class ArticuloCreacionPorArchivoDAO implements Logeable, IArticuloCreacionPorArchivoDAO{
	
	private IHibernateH<ArticuloVO> hibernateH;
	

	/**
	 * Metodo que permite verificar si existe el proveedor ingresado
	 * @param codigoJDEProveedor
	 * @param codigoCompania
	 * @param condicionesProveedor [0] : IndicadorI, [1] : codigoProveedor, [2] : origen, [3] : esImportador
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	@Override
	public String validarExisteProveedor(String codigoJDEProveedor, Integer codigoCompania, String[] condicionesProveedor) throws SICException {
		String codigoProveedor = StringUtils.EMPTY;
		Session session = null;
		ProveedorDTO proveedorDTO = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			Criteria criteria = session.createCriteria(ProveedorDTO.class, "proveedor");
			criteria.createAlias("proveedor.proveedorComercial", "proveedorComercial");
			criteria.createAlias("proveedor.proveedorImportado", "proveedorImportado");
			
			ProjectionList projections = Projections.projectionList()
			.add(Projections.property("id.codigoProveedor"), "id.codigoProveedor")
			.add(Projections.property("origenProveedor"), "origenProveedor")
			.add(Projections.property("proveedorComercial.interproveedor"), "proveedorComercial.interproveedor")
			.add(Projections.property("proveedorImportado.esImportador"), "proveedorImportado.esImportador");
			
			criteria.setProjection(projections);
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("codigoJDEProveedor", codigoJDEProveedor));
			criteria.add(Restrictions.eq("estadoProveedor", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.setResultTransformer(new DtoResultTransformer(ProveedorDTO.class));
			
			proveedorDTO = (ProveedorDTO) criteria.uniqueResult();
			
			if(proveedorDTO != null){
				codigoProveedor = proveedorDTO.getId().getCodigoProveedor();
				condicionesProveedor[0] = proveedorDTO.getProveedorComercial().getInterproveedor();
				condicionesProveedor[2] = proveedorDTO.getOrigenProveedor();
				condicionesProveedor[3] = proveedorDTO.getProveedorImportado().getEsImportador();
			}
			
		}catch(Exception e){
			LOG_SICV2.error("Error al buscar el proveedor. {}", e.getMessage());
		}finally{
			session = null;
			proveedorDTO = null;
		}
		return codigoProveedor == null ? codigoJDEProveedor : codigoProveedor;
	}

	@Override
	public boolean validarExisteClasificacion(String codigoClasificacion, Integer codigoCompania, List<HashMap<String, LinkedList<String>>> listaClasificaciones, Criterion usuarioClasificacion, String [] condicionesClasificacion) throws SICException {
		boolean existeClasificacion = Boolean.FALSE;
		ClasificacionDTO clasificacionDTO = null;
		Session session = null;
		try{
			if(StringUtils.isNotEmpty(codigoClasificacion) && codigoCompania != null && listaClasificaciones != null){
				if(CollectionUtils.exists(listaClasificaciones, PredicateUtils.equalPredicate(codigoClasificacion))){
					existeClasificacion = Boolean.TRUE;
				}else{
					clasificacionDTO = new ClasificacionDTO();
					session = hibernateH.getHibernateSession();
					session.clear();
					
					Criteria criteria = session.createCriteria(ClasificacionDTO.class, "clasificacion");
					criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
					criteria.add(Restrictions.eq("id.codigoClasificacion", codigoClasificacion));
					criteria.add(Restrictions.eq("estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
					criteria.add(usuarioClasificacion);
					clasificacionDTO = (ClasificacionDTO) criteria.uniqueResult();
					existeClasificacion = (clasificacionDTO != null ? Boolean.TRUE : Boolean.FALSE);
					if(existeClasificacion){
						condicionesClasificacion[0] = codigoClasificacion;
						condicionesClasificacion[1] = clasificacionDTO.getPorcentajeNoAfiliado() == null ? "5"  : String.valueOf(clasificacionDTO.getPorcentajeNoAfiliado());
					}
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al buscar si existe la clasificacion : ".concat(codigoClasificacion). concat(" ingresado. {}"), e.getMessage());
//			throw new SICException("Error al buscar si existe la clasificacion : ".concat(codigoClasificacion). concat(" ingresado."), e.getMessage());
		}finally{
			clasificacionDTO = null;
			session = null;
		}
		return existeClasificacion;
	}

	@Override
	public boolean validarExisteSubClasifiacion(String codigoClasificacion, String codigoSubClasificacion, Integer codigoCompania) throws SICException {
		boolean existeSubClasificacion = Boolean.FALSE;
		SubClasificacionDTO subClasificacionDTO = null;
		Session session = null;
		try{
			if(StringUtils.isNotEmpty(codigoClasificacion) && StringUtils.isNotEmpty(codigoSubClasificacion) && codigoCompania != null){
				subClasificacionDTO = new SubClasificacionDTO();
				session = hibernateH.getHibernateSession();
				session.clear();
				
				Criteria criteria = session.createCriteria(SubClasificacionDTO.class, "subClasificacion");
				criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("id.codigoClasificacion", codigoClasificacion));
				criteria.add(Restrictions.eq("id.codigoSubClasificacion", codigoSubClasificacion));
				criteria.add(Restrictions.eq("estadoSubClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				subClasificacionDTO = (SubClasificacionDTO) criteria.uniqueResult();
				existeSubClasificacion = (subClasificacionDTO != null ? Boolean.TRUE : Boolean.FALSE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al buscar si existe la clasificacion : ".concat(codigoClasificacion). concat(" ingresado. {}"), e.getMessage());
//			throw new SICException("Error al buscar si existe la clasificacion : ".concat(codigoClasificacion). concat(" ingresado."), e.getMessage());
		}finally{
			subClasificacionDTO = null;
			session = null;
		}
		return existeSubClasificacion;
	}

	@Override
	public boolean validarCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException {
		boolean existeCodigoBarras = Boolean.FALSE;
		ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO = null;
		Session session = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoBarras)){
				articuloBitacoraCodigoBarrasDTO = new ArticuloBitacoraCodigoBarrasDTO();
				session = hibernateH.getHibernateSession();
				session.clear();
					
				Criteria criteria = session.createCriteria(ArticuloBitacoraCodigoBarrasDTO.class, "bitCodigoBarras");
				criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("id.codigoBarras", codigoBarras));
				criteria.add(Restrictions.eq("estadoArticuloBitacora", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				
				articuloBitacoraCodigoBarrasDTO = (ArticuloBitacoraCodigoBarrasDTO) criteria.uniqueResult();
				existeCodigoBarras = (articuloBitacoraCodigoBarrasDTO != null ? Boolean.TRUE : Boolean.FALSE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al buscar si existe el codigo de barras  : ".concat(codigoBarras). concat(" ingresado. {}"), e.getMessage());
//			throw new SICException("Error al buscar si existe el codigo de barras : ".concat(codigoBarras). concat(" ingresado."), e.getMessage());
		}finally{
			articuloBitacoraCodigoBarrasDTO = null;
			session = null;
		}
		return existeCodigoBarras;
	}

	@Override
	public boolean validarExisteClaseArticulo(String codigoClaseArticulo, Integer codigoCompania, Set<String> listaClaseArticulos, Boolean esCreacion) throws SICException {
		boolean existeClaseArticulo = Boolean.FALSE;
		ClaseArticuloDTO claseArticuloDTO = null;
		Session session = null;
		Criteria criteria = null;
		ProcesoClaseDTO procesoClaseDTO = null;
		
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(codigoClaseArticulo)) && codigoCompania != null && listaClaseArticulos != null){
				if(CollectionUtils.exists(listaClaseArticulos, PredicateUtils.equalPredicate(codigoClaseArticulo))){
					existeClaseArticulo = Boolean.TRUE;
				}else{
					session = hibernateH.getHibernateSession();
					session.clear();
					if(esCreacion){
						criteria = session.createCriteria(ProcesoClaseDTO.class, "proCla");
						criteria.add(Restrictions.eq("proCla.id.codigoCompania", codigoCompania));
						criteria.add(Restrictions.eq("proCla.id.codigoClaseArticulo", codigoClaseArticulo));
						criteria.add(Restrictions.eq("proCla.id.codigoProceso", Long.valueOf(SICArticuloConstantes.getInstancia().CODIGOPROCESO_CODIFICACIONARTICULO)));
						criteria.add(Restrictions.eq("proCla.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
						
						procesoClaseDTO = (ProcesoClaseDTO) criteria.uniqueResult();
						
						existeClaseArticulo = (procesoClaseDTO != null ? Boolean.TRUE : Boolean.FALSE);
						
						if (existeClaseArticulo) {
							listaClaseArticulos.add(codigoClaseArticulo);
						}
					}else{
						claseArticuloDTO = new ClaseArticuloDTO();
						
						criteria = session.createCriteria(ClaseArticuloDTO.class, "claseArticulo");
						criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
						criteria.add(Restrictions.eq("id.codigoClaseArticulo", codigoClaseArticulo));
						criteria.add(Restrictions.eq("status", SICConstantes.ESTADO_ACTIVO_LITERAL));
						claseArticuloDTO = (ClaseArticuloDTO) criteria.uniqueResult();
						
						existeClaseArticulo = (claseArticuloDTO != null ? Boolean.TRUE : Boolean.FALSE);
						if(existeClaseArticulo){
							listaClaseArticulos.add(codigoClaseArticulo);
						}
					}
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar si existe la clase articulo. {}", e.getMessage());
//			throw new SICException("Error al validar si existe la clase articulo. {}", e.getMessage());
		}finally{
			claseArticuloDTO = null;
			session = null;
			procesoClaseDTO = null;
		}
		
		return existeClaseArticulo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean validarEAN14(String codigoEan14, Integer codigoCompania) throws SICException {
		boolean existeEan14 = Boolean.FALSE;
		Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoDTO = null;
		Session session = null;
		try{
			if(StringUtils.isNotEmpty(codigoEan14)){
				articuloUnidadManejoDTO = new ArrayList<ArticuloUnidadManejoDTO>();
				session = hibernateH.getHibernateSession();
				session.clear();
				
				Criteria criteria = session.createCriteria(ArticuloUnidadManejoDTO.class, "unidadManejo");
				criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("codigoBarrasUnidadManejo", codigoEan14));
				criteria.add(Restrictions.eq("estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				articuloUnidadManejoDTO = criteria.list();
				
				existeEan14 = (articuloUnidadManejoDTO.size() == 1 ? Boolean.TRUE : Boolean.FALSE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar si existe el EAN14. {}", e.getMessage());
//			throw new SICException("Error al validar si existe el EAN14. {}", e.getMessage());
		}finally{
			articuloUnidadManejoDTO = null;
			session = null;
		}
		return existeEan14;
	}

	@Override
	public String validarExisteMarca(Integer codigoCompania, String nombreMarca, String codigoProveedor) throws SICException {
		String secuencialMarca = StringUtils.EMPTY;
		Session session = null;
		Query select = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(nombreMarca) && StringUtils.isNotEmpty(codigoProveedor)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				StringBuilder hql = new StringBuilder();
				hql.append("select m.id.secuencialMarca from ").append(ProveedorMarcaDTO.class.getName()).append(" pm ")
				.append(" left join pm.marcaArticuloDTO as m ")
				.append(" where ")
				.append(" pm.id.codigoCompania = :pCodigoCompania ")
				.append(" and pm.id.codigoProveedor = :pCodigoProveedor ")
				.append(" and m.nombre = :pNombreMarca ")
				.append(" and pm.estado = :pEstadoActivo ")
				.append(" and m.estado = :pEstadoActivo ");
				
				select = session.createQuery(String.valueOf(hql));
				select.setInteger("pCodigoCompania", codigoCompania);
				select.setString("pNombreMarca", nombreMarca);
				select.setString("pCodigoProveedor", codigoProveedor);
				select.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				secuencialMarca = String.valueOf(select.uniqueResult());
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar si existe la marca articulo. {}", e.getMessage());
//			throw new SICException("Error al validar si existe la marca articulo. {}", e.getMessage());
		}finally{
			session = null;
			select = null;
		}
		return (secuencialMarca == null || StringUtils.equals(nombreMarca, "null")) ? nombreMarca : secuencialMarca;
	}

	@Override
	public String validarExisteAlcancePrototipo(Integer codigoCompania, String nombreGrupoTrabajo, String tipoGrupoTrabajo) throws SICException {
		Query query = null;
		Session session = null;
		String codigoGrupoTrabajo = StringUtils.EMPTY;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
						
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT gru.id.codigoGrupoTrabajo FROM GrupoTrabajoDTO gru ");
			hql.append(" WHERE gru.id.codigoCompania = :pCodigoCompania ");
			hql.append(" AND gru.nombreGrupoTrabajo = :pNombreGrupoTrabajo ");
			hql.append(" AND gru.tipoGrupoTrabajo = :pTipoGrupoTrabajo ");
			hql.append(" AND gru.estadoGrupoTrabajo = :pEstadoGrupoTrabajo ");
			
			query = session.createQuery(String.valueOf(hql));
			query.setParameter("pCodigoCompania", codigoCompania);
			query.setParameter("pNombreGrupoTrabajo", nombreGrupoTrabajo.toUpperCase());
			query.setParameter("pTipoGrupoTrabajo", tipoGrupoTrabajo.toUpperCase());
			query.setParameter("pEstadoGrupoTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL);
			
			codigoGrupoTrabajo = String.valueOf(query.uniqueResult());
			
		} catch (SICException e) {
			LOG_SICV2.error("Error al consultar codigo del alcance prototipo {}", e.getMessage());
//			throw new SICException("Error al consultar codigo del alcance prototipo", e.getMessage());
		}finally{
			session = null;
			query = null;
		}
		return (codigoGrupoTrabajo == null || StringUtils.equals(codigoGrupoTrabajo, "null") ) ? nombreGrupoTrabajo : codigoGrupoTrabajo;
	}

	@Override
	public String validarExisteAgrupador(String nombreAgrupador) throws SICException {
		String codigoAgrupador = StringUtils.EMPTY;
		try{
			codigoAgrupador = obtenerConsultaCatalogoValor(SICArticuloConstantes.getInstancia().CATALOGOTIPO_AGRUPADOR, nombreAgrupador, Boolean.FALSE);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al buscar el agrupador. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al buscar el agrupador. {}",e.getMessage());
		}
		return (codigoAgrupador == null || StringUtils.equals(codigoAgrupador, "null") || StringUtils.isEmpty(StringUtils.trim(codigoAgrupador))) ? nombreAgrupador : codigoAgrupador;
	}
	
	@Override
	public String validarExisteEmpaque(String empaque) throws SICException {
		String codigoEmpaque = StringUtils.EMPTY;
		try{
			if(StringUtils.isNotEmpty(empaque)){
				codigoEmpaque = obtenerConsultaCatalogoValor(SICArticuloConstantes.getInstancia().CODIGOTIPOEMPAQUE, empaque, Boolean.FALSE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al buscar el empaque. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al buscar el empaque. {}",e.getMessage());
		}
		return (codigoEmpaque == null || StringUtils.equals(codigoEmpaque, "null")|| StringUtils.isEmpty(StringUtils.trim(codigoEmpaque))) ? empaque : codigoEmpaque;
	}

	@Override
	public String validarExisteImportancia(Integer codigoCompania, String importancia) throws SICException {
		String codigoImportancia = StringUtils.EMPTY;
		Query select = null;
		Session session = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			StringBuilder hql = new StringBuilder();
			hql.append("select es.id.codigoEstablecimiento from ").append(EstablecimientoDTO.class.getName()).append(" es ")
			.append(" where ")
			.append(" es.id.codigoCompania = :pCodigoCompania ")
			.append(" and es.nombreCorto = :pNombreCorto")
			.append(" and es.estado = :pEstadoActivo ");
			
			select = session.createQuery(String.valueOf(hql));
			select.setInteger("pCodigoCompania", codigoCompania);
			select.setString("pNombreCorto", importancia);
			select.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_LITERAL);
			
			codigoImportancia = String.valueOf(select.uniqueResult());
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al buscar la importancia. {}", e.getMessage());
//			throw new SICException("Ha ocurrido un error al buscar la importancia. {}",e.getMessage());
		}finally{
			session = null;
			select = null;
		}
		return (codigoImportancia == null || StringUtils.equals(codigoImportancia, "null")) ? importancia : codigoImportancia;
	}

	@Override
	public String validarExistePlazoPago(String plazoPago) throws SICException {
		String codigoPlazoPago = StringUtils.EMPTY;
		try{
			codigoPlazoPago = obtenerConsultaCatalogoValor(TipoCatalogosProveedor.TIPO_PLAZO_PAGO_DIAS, plazoPago, Boolean.FALSE);
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el plazo pago {}", e.getMessage());
//			throw new SICException("Error al consultar el plazo pago {}", e.getMessage());
		}
		return (codigoPlazoPago == null || StringUtils.equals(codigoPlazoPago, "null") || StringUtils.isEmpty(StringUtils.trim(codigoPlazoPago))) ? plazoPago : codigoPlazoPago;
	}
	
	@Override
	public Double obtenerPorcentajeDescuento(Integer codigoCompania, String codigoJDEProveedor,  String codigoClasificacion, String codigoTipoDescuento, String valorAplicacionTipoDescuento) throws SICException {
		Query query = null;
		Session session = null;
		Double porcentajeDescuento = null;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
						
			StringBuilder hql = new StringBuilder();
			hql.append("SELECT des.porcentajeDescuento FROM DescuentoProveedorClasificacionDTO des ");
			hql.append(" inner join des.asignacionTipoDescuento atd ");
			hql.append(" WHERE des.id.codigoCompania = :pCodigoCompania ");
			hql.append(" AND des.codigoProveedor = :pCodigoProveedor ");
			hql.append(" AND des.codigoClasificacion = :pCodigoClasificacion ");
			hql.append(" AND atd.codigoTipoDescuento = :pCodigoTipoDescuento ");
			hql.append(" AND des.estado = :pEstado ");
			hql.append(" AND atd.codigoAplicacionTipoDescuento = :pCodigoAplicacionTipoDescuento ");
			hql.append(" AND atd.valorAplicacionTipoDescuento = :pValorAplicacionTipoDescuento ");
			 
			
			query = session.createQuery(hql.toString());
			query.setParameter("pCodigoCompania", codigoCompania);
			query.setParameter("pCodigoProveedor", codigoJDEProveedor);
			query.setParameter("pCodigoClasificacion", codigoClasificacion);
			query.setParameter("pCodigoTipoDescuento", codigoTipoDescuento);
			query.setParameter("pEstado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			query.setParameter("pCodigoAplicacionTipoDescuento", EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
			query.setParameter("pValorAplicacionTipoDescuento", valorAplicacionTipoDescuento);
			
			porcentajeDescuento = (Double) query.uniqueResult();
		} catch (SICException e) {
			LOG_SICV2.error("Error al consultar el descuento por proveedor", e.getMessage());
//			throw new SICException("Error al consultar el descuento por proveedor", e.getMessage());
		}
		return porcentajeDescuento;
	}

	@Override
	public String obtenerParametroRequerido(Integer codigoCompania, String parametroId) throws SICException {
		String valorParametro = StringUtils.EMPTY;
		Query query = null;
		Session session = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(parametroId)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				StringBuilder hql = new StringBuilder();
				hql.append("select p.valorParametro from ").append(ParametroDTO.class.getName()).append(" p ")
				.append(" where ")
				.append(" p.id.codigoCompania = :pCodigoCompania ")
				.append(" and p.id.codigoParametro = :pCodigoParametro ")
				.append(" and p.estado = :pEstadoActivo");
				
				query = session.createQuery(String.valueOf(hql));
				query.setInteger("pCodigoCompania", codigoCompania);
				query.setString("pCodigoParametro", parametroId);
				query.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_LITERAL);
				
				valorParametro = String.valueOf(query.uniqueResult());
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el parametro. {}", e.getMessage());
//			throw new SICException("Error al consultar el parametro. {}", e.getMessage());
		}finally{
			query = null;
			session = null;
		}
		return valorParametro;
	}
	
	@Override
	public String validarExisteUnidadMedida(String unidadMedida, String [] condicionesUnidadMedida) throws SICException {
		String unidadMedidaCampo = StringUtils.EMPTY;
		String unidadMedidaCatalogoTipo = StringUtils.EMPTY;
		Session session = null;
		CatalogoValorDTO catalogoValorDTO = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			Criteria criteria = session.createCriteria(CatalogoValorDTO.class, "cv");
			criteria.createAlias("catalogoTipoDTO", "catalogoTipoDTO");
			criteria.add(Restrictions.eq("id.codigoCatalogoValor", unidadMedida));
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("catalogoTipoDTO.codigoCatalogoTipoPadre", SICConstantes.CODIGOCATALOGO_UNIDADESMEDIDA));
			criteria.add(Restrictions.isNotNull("codigoExterno"));			
			catalogoValorDTO = (CatalogoValorDTO) criteria.uniqueResult();
			if(catalogoValorDTO != null){
				unidadMedidaCampo = catalogoValorDTO.getId().getCodigoCatalogoValor();
				unidadMedidaCatalogoTipo = String.valueOf(catalogoValorDTO.getId().getCodigoCatalogoTipo());
				condicionesUnidadMedida[1] = unidadMedidaCatalogoTipo; 
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar si existe la unidad de medida. {}", e.getMessage());
//			throw new SICException("Error al validar si existe la unidad de medida. {}", e.getMessage());
		}finally{
			session = null;
			catalogoValorDTO = null;
		}
		return (unidadMedidaCampo == null || StringUtils.equals(unidadMedidaCampo, "null") || StringUtils.isEmpty(StringUtils.trim(unidadMedidaCampo))) ? unidadMedidaCampo : unidadMedidaCampo;
	}

	@Override
	public String validarExisteControlPrecios(String controlPrecio) throws SICException {
		String codigoControlPrecios = StringUtils.EMPTY;
		try{
			codigoControlPrecios = obtenerConsultaCatalogoValor(SICConstantes.getInstancia().TIPO_CONTROL_COSTO, controlPrecio, Boolean.FALSE);
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el plazo pago {}", e.getMessage());
//			throw new SICException("Error al consultar el plazo pago {}", e.getMessage());
		}
		return (codigoControlPrecios == null || StringUtils.equals(codigoControlPrecios, "null") || StringUtils.isEmpty(StringUtils.trim(codigoControlPrecios))) ? controlPrecio : codigoControlPrecios;
	}

	@Override
	public String validarExisteTransgenico(String transgenico) throws SICException {
		String codigoTransgenico = StringUtils.EMPTY;
		try{
			codigoTransgenico = obtenerConsultaCatalogoValor(TipoCatalogoArticulo.TIPO_CARACTERISTICA_TRANSGENICO, transgenico, Boolean.FALSE);
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el transgenico {}", e.getMessage());
//			throw new SICException("Error al consultar el transgenico {}", e.getMessage());
		}
		return (codigoTransgenico == null || StringUtils.equals(codigoTransgenico, "null") ) ? transgenico : codigoTransgenico;
	}

	@Override
	public String validarExisteUso(String uso) throws SICException {
		String codigoUso = StringUtils.EMPTY;
		try{
			codigoUso = obtenerConsultaCatalogoValor(TipoCatalogoArticulo.TIPOS_USO_CARNES, uso, Boolean.FALSE);
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el uso {}", e.getMessage());
//			throw new SICException("Error al consultar el uso {}", e.getMessage());
		}
		return (codigoUso == null || StringUtils.equals(codigoUso, "null") || StringUtils.isEmpty(StringUtils.trim(codigoUso))) ? uso : codigoUso;
	}

	@Override
	public String validarExistePaisOrigen(String nombrePais) throws SICException {
		String codigoPaisOrigen = StringUtils.EMPTY;
		Query select = null;
		Session session = null;
		StringBuilder hql = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			hql = new StringBuilder();
			hql.append("select po.id.codigoDivGeoPol from ").append(DivisionGeoPoliticaDTO.class.getName()).append(" po ")
			.append(" where ")
			.append(" (po.nombreDivGeoPol = :pNombreDivGeoPol ")
			.append(" or po.id.codigoDivGeoPol = :pNombreDivGeoPol ) ")
			.append(" and po.tipoDivGeoPol = :pTipoDivGeoPol ")
			.append(" and po.estado = :pEstadoActivoLiteral ");
			
			select = session.createQuery(String.valueOf(hql));
			select.setString("pNombreDivGeoPol", nombrePais);
			select.setString("pTipoDivGeoPol", CorporativoConstantes.TIPO_DIVGEOPOL_PAIS);
			select.setString("pEstadoActivoLiteral", SICConstantes.ESTADO_ACTIVO_LITERAL);
			
			codigoPaisOrigen = String.valueOf(select.uniqueResult());
			
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el pais de origen {}", e.getMessage());
//			throw new SICException("Error al consultar el pais de origen {}", e.getMessage());
		}finally{
			select = null;
			session = null;
			hql = null;
		}
		return (codigoPaisOrigen == null || StringUtils.equals(codigoPaisOrigen, "null") || StringUtils.isEmpty(StringUtils.trim(codigoPaisOrigen))) ? "null" : codigoPaisOrigen;
	}

	@Override
	public String validarExisteLugarCompra(String lugarCompra, Integer codigoCompania) throws SICException {
		String codigoLugarCompra = StringUtils.EMPTY;
		Query select = null;
		Session session = null;
		StringBuilder hql = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			hql = new StringBuilder();
			hql.append("SELECT lc.id.codigoUbicacionTransaccionDivisionGeoPolitica FROM ").append(UbicacionTransaccionDivisionGeoPoliticaDTO.class.getName()).append(" lc ")
			.append(" WHERE ")
			.append(" lc.id.codigoCompania = :pCodigoCompania ")
			.append(" AND lc.nombre = :pNombreLugarCompra ")
			.append(" AND lc.codigoUbicacionTipo = :pCodigoUbicacionTipo ")
			.append(" AND lc.codigoUbicacionValor in (:pCodigosUbicacionValor) ")
			.append(" AND lc.estado = :pEstadoActivoNumerico ");
			
			select = session.createQuery(String.valueOf(hql));
			select.setInteger("pCodigoCompania", codigoCompania);
			select.setString("pNombreLugarCompra", lugarCompra.toUpperCase());
			select.setInteger("pCodigoUbicacionTipo", SICConstantes.TIPO_CATALOGO_LUGARES_TRANSACCION);
			String[] ubicacionesValor = {SICConstantes.VALOR_CATALOGO_LUGAR_TRANSACCION_FERIA,SICConstantes.VALOR_CATALOGO_LUGAR_TRANSACCION_AGENDA};
			select.setParameterList("pCodigosUbicacionValor", ubicacionesValor);
			select.setString("pEstadoActivoNumerico", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			codigoLugarCompra = String.valueOf(select.uniqueResult());
			
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el pais de origen {}", e.getMessage());
//			throw new SICException("Error al consultar el pais de origen {}", e.getMessage());
		}finally{
			select = null;
			session = null;
			hql = null;
		}
		return (codigoLugarCompra == null || StringUtils.equals(codigoLugarCompra, "null") || StringUtils.isEmpty(StringUtils.trim(codigoLugarCompra))) ? lugarCompra : codigoLugarCompra;
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloCreacionPorArchivoDAO#validarExisteTipoSecuencia(java.lang.String)
	 */
	@Override
	public String validarExisteTipoSecuencia(String nombreSecuencia) throws SICException {
		String codigoSecuencia = StringUtils.EMPTY;
		try{
			codigoSecuencia = obtenerConsultaCatalogoValor(SICArticuloConstantes.getInstancia().TIPOCATALOGO_SECUENCIAINTERNA, nombreSecuencia, Boolean.FALSE);
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el tipo secuencia {}", e.getMessage());
//			throw new SICException("Error al consultar el tipo secuencia {}", e.getMessage());
		}
		return (codigoSecuencia == null || StringUtils.equals(codigoSecuencia, "null") || StringUtils.isEmpty(StringUtils.trim(codigoSecuencia))) ? nombreSecuencia : codigoSecuencia;
	}
	
	@Override
	public String obtenerCatalogoValor(Integer codigoCatalogoTipo, String nombreCatalogoValor, Boolean esCodigoCatalogo) throws SICException {
		String catalogoValor = StringUtils.EMPTY;
		try{
			
			catalogoValor = obtenerConsultaCatalogoValor(codigoCatalogoTipo, nombreCatalogoValor, esCodigoCatalogo);
			
		}catch(Exception e){
			LOG_SICV2.error(e.getMessage());
		}
		return catalogoValor;
	}
	
	/**METODO QUE REALIZA LA CONSULTA AL CATALOGO VALOR Y SE OBTIENE EL CODIGO DE CATALOGO VALOR
	 * @param codigoCatalogoTipo
	 * @param nombreCatalogoValor
	 * @return
	 */
	private String obtenerConsultaCatalogoValor(Integer codigoCatalogoTipo, String nombreCatalogoValor, Boolean esCodigoCatalogo){
		String codigoCatalogoValor = StringUtils.EMPTY;
		Query select = null;
		Session session = null;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(nombreCatalogoValor)) && codigoCatalogoTipo != null){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				StringBuilder hql = new StringBuilder();
				
				hql.append("select cv.id.codigoCatalogoValor from ").append(CatalogoValorDTO.class.getName()).append(" cv ")
				.append(" where ")
				.append(" cv.id.codigoCatalogoTipo = :pCodigoCatalogoTipo ");
				if(esCodigoCatalogo){
					hql.append(" and cv.id.codigoCatalogoValor = :pNombreCatalogoValor ");
				}else{
					hql.append(" and cv.nombreCatalogoValor = :pNombreCatalogoValor ");
				}
				hql.append(" and cv.estado = :pEstadoActivo ");
				
				select = session.createQuery(String.valueOf(hql));
				select.setInteger("pCodigoCatalogoTipo",  codigoCatalogoTipo);
				select.setString("pNombreCatalogoValor", nombreCatalogoValor);
				select.setString("pEstadoActivo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
				
				codigoCatalogoValor = String.valueOf(select.uniqueResult());
			}
					
		}catch(Exception e){
			LOG_SICV2.error("Error al consultar el catalogo valor. {}", e.getMessage());
//			throw new SICException("Error al consultar el catalogo valor. {}", e.getMessage());
		}finally{
			select = null;
			session = null;
		}
		return codigoCatalogoValor;
	}
	
	/************************************************************/
	/*********SETTERS********************************************/
	/************************************************************/
	
	/**
	 * @param hibernateH the hibernateH to set
	 */
	public void setHibernateH(IHibernateH<ArticuloVO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
