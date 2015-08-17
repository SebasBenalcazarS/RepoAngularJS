/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.frameworkv2.util.constants.CatalogTypeConstant;
import ec.com.smx.frameworkv2.util.constants.FrameworkConstants;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroSanitarioDAO;

/**
 * @author fmunoz
 *
 */
public class ArticuloRegistroSanitarioDAO implements Logeable, IArticuloRegistroSanitarioDAO{

	private IHibernateH<ArticuloRegistroSanitarioDTO> hibernateH;
	
	/**
	 * Desactiva los archivos relacionados a un registro sanitario
	 * @throws SICException
	 */
	@Override
	public void desactivarArchivosRegistroSanitario(RelacionArticuloRegistroSanitarioDTO ars, String usuarioModificacion) throws SICException{
		Session session;
		StringBuilder query;
		Query queryUpdate;
		String [] tiposArchivo;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder("update ");
			query.append(ArticuloDefinicionArchivoDTO.class.getName()).append(" set estadoArchivo = :pEstadoInactivo, idUsuarioModificacion=:pUsuarioModificacion, fechaModificacion=:pFechaModificacion");
			query.append(" where id.codigoCompania = :codigoCompania and estadoArchivo = :pEstadoActivo");
			if(ars.getId().getCodigoRegistroSanitario() == null){
				query.append(" and valorTipoArchivo in (:pTiposArchivo)");
			}else{
				query.append(" and codigoRegistroSanitarioArticulo = :codigoRegistroSanitarioArticulo");
			}
			
			queryUpdate = session.createQuery(query.toString());
			queryUpdate.setString("pEstadoInactivo", SICConstantes.ESTADO_INACTIVO_NUMERICO);
			queryUpdate.setString("pUsuarioModificacion", usuarioModificacion);
			queryUpdate.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			queryUpdate.setTimestamp("pFechaModificacion", new Date());
			queryUpdate.setInteger("codigoCompania", ars.getId().getCodigoCompania());
			if(ars.getId().getCodigoRegistroSanitario() != null)
				queryUpdate.setString("codigoRegistroSanitarioArticulo", ars.getId().getCodigoRegistroSanitario());
			else{
				//solo los tipos de archivo para el registro sanitario se deben desactivar
				tiposArchivo = new String [] {SICArticuloConstantes.getInstancia().TIPOARCHIVO_IMGREGSAN,SICArticuloConstantes.getInstancia().TIPOARCHIVO_DOCREGSAN};
				queryUpdate.setParameterList("pTiposArchivo", tiposArchivo);
			}
			queryUpdate.executeUpdate();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			queryUpdate = null;
		}
	}
	
	/**
	 * Desactiva los registros sanitarios de un art�culo 
	 * @throws SICException
	 */
	@Override
	public void desactivarRegistroSanitarioArticulo(RelacionArticuloRegistroSanitarioDTO ars) throws SICException{
		Session session;
		StringBuilder query;
		Query queryUpdate;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder("update ").append(RelacionArticuloRegistroSanitarioDTO.class.getName())
					.append(" ra set ra.estado=:pEstadoInactivo, ra.idUsuarioModificacion = :pUserId, ra.fechaModificacion=:pFechaActual")
					.append(" where ra.id.codigoCompania=:pCodigoCompania and ra.id.codigoArticulo=:pCodigoArticulo and ra.estado=:pEstadoActivo");
					
			
			if(StringUtils.isNotEmpty(ars.getId().getCodigoRegistroSanitario())){
				query.append(" and ra.id.codigoRegistroSanitario = :pCodRegSan");
			}else{
				query.append(" and ra.id.codigoRegistroSanitario in (select rs.id.codigoRegistroSanitario from ")
				.append(ArticuloRegistroSanitarioDTO.class.getName()).append(" rs where rs.id.codigoCompania=:pCodigoCompania and rs.id.codigoRegistroSanitario=ra.id.codigoRegistroSanitario and rs.valorTipoEstudioNutricional=:pEstudioNutricional)");
			}
			
			queryUpdate = session.createQuery(query.toString());
			queryUpdate.setString("pEstadoInactivo", SICConstantes.ESTADO_INACTIVO_NUMERICO);
			queryUpdate.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			queryUpdate.setString("pUserId", StringUtils.isNotEmpty(ars.getUserId()) ? ars.getUserId() : "FRM0");
			queryUpdate.setDate("pFechaActual", new Date());
			queryUpdate.setInteger("pCodigoCompania", ars.getId().getCodigoCompania());
			queryUpdate.setString("pCodigoArticulo", ars.getId().getCodigoArticulo());
			if(StringUtils.isNotEmpty(ars.getId().getCodigoRegistroSanitario())){
				queryUpdate.setString("pCodRegSan", ars.getId().getCodigoRegistroSanitario());
			}else{
				queryUpdate.setString("pEstudioNutricional", ars.getRegistroSanitario().getValorTipoEstudioNutricional());
			}
			queryUpdate.executeUpdate();

		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			queryUpdate = null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloRegistroSanitarioDAO#desactivarEtiquetasRegistroSanitario(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO)
	 */
	public void desactivarEtiquetasRegistroSanitario(ArticuloDTO articuloDTO) throws SICException{
		Session session;
		StringBuilder query;
		Query queryUpdate;
		StringBuilder select = null;
		Query querySelect = null;
		Collection<Long> tagCodes =  null;
		try{
			
			session = hibernateH.getHibernateSession();
			session.clear();
			
			select = new StringBuilder()
			.append("SELECT articuloEtiqueta.id.tagCode ")
			.append("FROM ArticuloEtiquetaDTO  articuloEtiqueta JOIN articuloEtiqueta.tagDTO tag ")
			.append("WHERE articuloEtiqueta.id.codigoCompania = :codigoCompania ")
			.append("AND articuloEtiqueta.id.codigoArticulo = :codigoArticulo ")
			.append("AND articuloEtiqueta.estado = :estado ")
			.append("AND tag.groupTagValue = :groupTagValue ")
			.append("AND tag.groupTagType = :groupTagType ");
			
			querySelect = session.createQuery(select.toString())
			.setParameter("codigoCompania", articuloDTO.getId().getCodigoCompania())
			.setParameter("codigoArticulo", articuloDTO.getId().getCodigoArticulo())
			.setParameter("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO)
			.setParameter("groupTagValue", FrameworkConstants.ETIQUETA_REGISTRO_SANITARIO)
			.setParameter("groupTagType", CatalogTypeConstant.TIPO_ETIQUETAS);
			
			
			tagCodes = querySelect.list();
			
			if( CollectionUtils.isNotEmpty(tagCodes) ){
				query = new StringBuilder("UPDATE ")
				.append(ArticuloEtiquetaDTO.class.getName())
				.append(" SET estado=:pEstadoInactivo, idUsuarioModificacion = :pUserId, fechaModificacion=:pFechaActual ")
				.append("WHERE id.codigoCompania=:pCodigoCompania AND id.codigoArticulo=:pCodigoArticulo AND id.tagCode IN (:ptagCodes)");
				
				queryUpdate = session.createQuery(query.toString());
				queryUpdate.setString("pEstadoInactivo", SICConstantes.ESTADO_INACTIVO_NUMERICO);
				queryUpdate.setString("pUserId", StringUtils.isNotEmpty(articuloDTO.getUserId()) ? articuloDTO.getUserId() : "FRM0");
				queryUpdate.setDate("pFechaActual", new Date());
				queryUpdate.setInteger("pCodigoCompania", articuloDTO.getId().getCodigoCompania());
				queryUpdate.setString("pCodigoArticulo", articuloDTO.getId().getCodigoArticulo());
				queryUpdate.setParameterList("ptagCodes", tagCodes);
				
				queryUpdate.executeUpdate();
			}
			
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			queryUpdate = null;
		}
	}
	
	
	/**
	 * Actualiza los datos de auditor�a
	 * @throws SICException
	 */
	@Override
	public void actualizarDatosAuditoria(RelacionArticuloRegistroSanitarioDTO ars) throws SICException{
		Session session;
		StringBuilder query;
		Query queryUpdate;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder("update ");
			query.append(RelacionArticuloRegistroSanitarioDTO.class.getName()).append(" set idUsuarioModificacion=:pUsuarioModificacion, fechaModificacion=:pFechaModificacion");
			query.append(" where id.codigoCompania = :pCodigoCompania and id.codigoArticulo = :pCodigoArticulo and id.codigoRegistroSanitario = :pCodRegSan");
			
			queryUpdate = session.createQuery(query.toString());
			queryUpdate.setString("pUsuarioModificacion", ars.getUserId());
			queryUpdate.setTimestamp("pFechaModificacion", new Date());
			queryUpdate.setInteger("pCodigoCompania", ars.getId().getCodigoCompania());
			queryUpdate.setString("pCodigoArticulo", ars.getId().getCodigoArticulo());
			queryUpdate.setString("pCodRegSan", ars.getId().getCodigoRegistroSanitario());
			queryUpdate.executeUpdate();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			queryUpdate = null;
		}
	}
	
	@Override
	public SearchResultDTO<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitarioPaginados(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException {
		Boolean enableLike = Boolean.FALSE;
		Boolean clearCache = Boolean.TRUE;
		return this.hibernateH.findPagedResults(articuloRegistroSanitarioDTO, clearCache, enableLike);
	}
	
	@Override
	public Collection<ArticuloRegistroSanitarioDTO> obtenerArticulosRegistroSanitario(ArticuloRegistroSanitarioDTO articuloRegistroSanitarioDTO) throws SICException {
		Boolean enableLike = Boolean.FALSE;
		Boolean clearCache = Boolean.TRUE;
		return this.hibernateH.findBySimpleCriteriaQuery(articuloRegistroSanitarioDTO, clearCache, enableLike);
	}

	public void setHibernateH(IHibernateH<ArticuloRegistroSanitarioDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
	
	/**
	 * Busca los registros sanitarios activos de un articulo
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public Collection<ArticuloRegistroSanitarioDTO> buscarRegistrosSanitariosActivos(ArticuloDTO articuloDTO) throws SICException{
		Collection<ArticuloRegistroSanitarioDTO> articuloRegistroSanitarioDTOs = null;
		Criteria select;
		Session session;
		try {			
			session = hibernateH.getHibernateSession();
			session.clear();
			select = session.createCriteria(ArticuloRegistroSanitarioDTO.class);
			
			DetachedCriteria subquery = DetachedCriteria.forClass(RelacionArticuloRegistroSanitarioDTO.class);
			subquery.add(Restrictions.eq("id.codigoArticulo", articuloDTO.getId().getCodigoArticulo()));				
			subquery.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			subquery.setProjection(Projections.property("id.codigoRegistroSanitario"));
			subquery.setResultTransformer(new DtoResultTransformer(RelacionArticuloRegistroSanitarioDTO.class));
			
			ProjectionList projections = Projections.projectionList()
					.add(Projections.property("fechaCaducidadRegistroSanitario"), "fechaCaducidadRegistroSanitario")
					.add(Projections.property("registroSanitario"), "registroSanitario");			
			select.setProjection(projections);
			select.add(Restrictions.eq("valorTipoEstudioNutricional", TipoCatalogoArticulo.ESTUDIO_NUTRICIONAL_REGISTRO_SANITARIO));
			select.add(Restrictions.eq("codigoTipoEstudioNutricional", TipoCatalogoArticulo.TIPO_ESTUDIO_NUTRICIONAL));
			select.add(Subqueries.propertyIn("id.codigoRegistroSanitario", subquery));
			
			select.setProjection(projections);
			select.setResultTransformer(new DtoResultTransformer(ArticuloRegistroSanitarioDTO.class));
			articuloRegistroSanitarioDTOs =	select.list();
			return articuloRegistroSanitarioDTOs;
		} catch (SICException e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException(e);
		}finally{
			select = null;
			session = null;			
		}
	}

	
	/**
	 * METODO QUE PERMITE AGREGA EL VALOR DE TRUE EN EL CAMPO CONFIRMAREGISTROSANITARIO EN LA TABLA {@link ArticuloProveedorDTO}
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param idUsuarioModificacion
	 * @throws SICException
	 * @author eharo
	 */
	@Override
	public void asignarConfirmaRegistroSanitarioArticuloProveedor(Integer codigoCompania, String codigoArticulo, String idUsuarioModificacion) throws SICException {
		Session session = null;
		StringBuilder update = null;
		Query query = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			update = new StringBuilder("update ");
			update.append(ArticuloProveedorDTO.class.getName())
			.append(" set esConfirmadoRegistroSanitario = :pEsConfirmadoRegistroSanitario, ")
			.append(" idUsuarioModificacion = :pIdUsuarioModificacion, ")
			.append(" fechaModificacion = :pFechaModificacion ")
			.append(" where ")
			.append(" id.codigoCompania = :pCodigoCompania ")
			.append(" and ")
			.append(" id.codigoArticulo = :pcodigoArticulo ")
			.append(" and ")
			.append(" (esConfirmadoRegistroSanitario = :pEsConfirmadoRegistroSanitarioInactivo ")
			.append(" or esConfirmadoRegistroSanitario is null)");
			
			query = session.createQuery(update.toString());
			query.setInteger("pCodigoCompania", codigoCompania);
			query.setString("pcodigoArticulo", codigoArticulo);
			query.setBoolean("pEsConfirmadoRegistroSanitario", Boolean.TRUE);
			query.setString("pIdUsuarioModificacion", idUsuarioModificacion);
			query.setTimestamp("pFechaModificacion", Calendar.getInstance().getTime());
			query.setString("pEsConfirmadoRegistroSanitarioInactivo", SICConstantes.getInstancia().ESTADO_INACTIVO_NUMERICO);
			
			query.executeUpdate();
			
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error a insertar el campo CONFIRMARAREGRISTROSANITARIOS en la entidad ARTICULOPROVEEDORDTO", e);
		}finally{
			session = null;
			update = null;
			query = null;
		}
		
	}
}
