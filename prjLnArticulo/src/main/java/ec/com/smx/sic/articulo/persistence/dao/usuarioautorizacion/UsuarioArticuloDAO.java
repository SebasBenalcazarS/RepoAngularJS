package ec.com.smx.sic.articulo.persistence.dao.usuarioautorizacion;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.usuarioautorizacion.IUsuarioArticuloDAO;

/**
 * 
 * @author cortiz
 *
 */
public class UsuarioArticuloDAO implements IUsuarioArticuloDAO {

	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/************************************************************************************************************************************************
	 * METODOS DE autorizacion usuario
	 * ***********************************************************************************************************************************************
	 */
	
	/**
	 * Metodo para la busqueda de articulos que no estan asignados al usuario ingresado
	 * @param areaTrabajoVO
	 * @return
	 */
	@Override
	public  Collection<ArticuloDTO> obtenerArticulos(ArticuloVO articuloVO, String userId, Boolean paginador, Collection<String> codigoArticulosCol, Collection<String> codigoClasificacionAsignadasCol)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : obtenerArticulos");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+articuloVO.getBaseDTO().getId().getCodigoCompania());
		Logeable.LOG_SICV2.info("codigo codigoEstado: "+articuloVO.getBaseDTO().getCodigoEstado());
		Logeable.LOG_SICV2.info("codigo barras: "+articuloVO.getBaseDTO().getNpCodigoBarras());
		Logeable.LOG_SICV2.info("descripcion: "+articuloVO.getBaseDTO().getDescripcionArticulo());
		Logeable.LOG_SICV2.info("codigo clasificacion: "+articuloVO.getBaseDTO().getCodigoClasificacion());
		Logeable.LOG_SICV2.info("codigo claseArticulo: "+articuloVO.getBaseDTO().getNpClases());
		Logeable.LOG_SICV2.info("userId: "+userId);
		try{
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ArticuloDTO.class);
			
			
			restricccionArticulo(criteria, articuloVO, userId, codigoArticulosCol, codigoClasificacionAsignadasCol);
			
//			if (StringUtils.isNotBlank(articuloVO.getBaseDTO().getNpCodigoBarras())){
//				criteria.add(Restrictions.eq("codigoBarras", articuloVO.getBaseDTO().getNpCodigoBarras()));
//			}
			
			criteria.setProjection(Projections.projectionList() 
					.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("descripcionArticulo"),"descripcionArticulo")
					.add(Projections.property("codigoBarras"),"codigoBarras")
					.add(Projections.property("claseArticulo"),"claseArticulo")
					.add(Projections.property("artMed.referenciaMedida"),"articuloMedidaDTO.referenciaMedida")
					.add(Projections.property("codigoClasificacion"),"codigoClasificacion")
					);
			if(paginador){
				criteria.setMaxResults(articuloVO.getMaxResults());
				criteria.setFirstResult(articuloVO.getFirstResult());
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			
			Collection<ArticuloDTO> articuloDTOCol = criteria.list(); 
			
			return articuloDTOCol;
			
		}catch(HibernateException e){
			throw new SICException("Error al buscar UsuarioArticulos ",e);
		}catch(SICException e){
			throw new SICException("Error al buscar UsuarioArticulos ",e);
		}
	}
	
	private void restricccionArticulo(Criteria criteria, ArticuloVO articuloVO, String userId, Collection<String> codigoArticulosCol, Collection<String> codigoClasificacionAsignadasCol){
		
		criteria.add(criteriaUsuarioArticulo(articuloVO));
		
		criteria.createAlias("articuloMedidaDTO", "artMed");
		
		if(StringUtils.isNotBlank(userId)){
			
			/**restringir las articulo que ya estan asignadas al usuario mensionado */
			if(CollectionUtils.isNotEmpty(codigoArticulosCol) && codigoArticulosCol.size() >= 1000){
				
				criteria.add(Subqueries.propertyNotIn("id.codigoArticulo", obtenerArtUsu(userId)));
				
			}else if(CollectionUtils.isNotEmpty(codigoArticulosCol) && codigoArticulosCol.size() < 1000){
				
				criteria.add(Restrictions.not(Restrictions.in("id.codigoArticulo", codigoArticulosCol)));
				
			}
			
			/**restringir las clasificaciones que ya estan asignadas al usuario mensionado */
			if(CollectionUtils.isNotEmpty(codigoClasificacionAsignadasCol) && codigoClasificacionAsignadasCol.size() >= 1000){
				
				DetachedCriteria subSelect = DetachedCriteria.forClass(UsuarioClasificacionProcesoDTO.class,"usucla");
				subSelect.add(Restrictions.eq("usucla.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				subSelect.add(Restrictions.eq("usucla.id.codigoUsuario", userId));
				subSelect.setProjection(Projections.property("id.codigoClasificacion"));
				criteria.add(Subqueries.propertyNotIn("codigoClasificacion", subSelect));
				
			}else if(CollectionUtils.isNotEmpty(codigoClasificacionAsignadasCol) && codigoClasificacionAsignadasCol.size() < 1000){
				
				criteria.add(Restrictions.not(Restrictions.in("codigoClasificacion", codigoClasificacionAsignadasCol)));
			}
		}
	}
	
	
	
	@Override
	public  Integer cuentaArticulos(ArticuloVO articuloVO, String userId,Collection<String> codigoArticulosCol,Collection<String> codigoClasificacionAsignadasCol)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : cuentaArticulos");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+articuloVO.getBaseDTO().getId().getCodigoCompania());
		Logeable.LOG_SICV2.info("codigo codigoEstado: "+articuloVO.getBaseDTO().getCodigoEstado());
		Logeable.LOG_SICV2.info("userId: "+userId);
		try {
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ArticuloDTO.class);
			
			restricccionArticulo(criteria, articuloVO, userId, codigoArticulosCol, codigoClasificacionAsignadasCol);
			
			criteria.setProjection(Projections.rowCount());
			Long count = (Long)criteria.uniqueResult(); 
			Integer numReg = count.intValue();
			return numReg;
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar cuentaArticulos ");
			throw new SICException("Error al buscar cuentaClasificaciones ",e);
		}
	}
	
	/**
	 * Metodo que devuelve el subselect para obtener los codigos de las clasificaciones del usuario insertado
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	private DetachedCriteria obtenerArtUsu(String userId)throws SICException{
		try {
			/**SUBSELECT para restringir los articulos que ya estan asignadas al usuario insertado */
			DetachedCriteria subSelect = DetachedCriteria.forClass(UsuarioArticuloDTO.class,"usuArt");
			
			subSelect.add(Restrictions.eq("usuArt.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			subSelect.add(Restrictions.eq("usuArt.id.codigoUsuario", userId));
			
			subSelect.setProjection(Projections.property("id.codigoArticulo"));
			
			return subSelect;
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar obtenerArtUsu ");
			throw new SICException("Error al buscar obtenerArtUsu ",e);
		}
	}
	@Override
	public Collection<String> consultarCodigosArticulosAsignados(String userId)throws SICException{
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UsuarioArticuloDTO.class,"usuArt");
			criteria.add(Restrictions.eq("usuArt.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("usuArt.id.codigoUsuario", userId));
			
			criteria.setProjection(Projections.property("id.codigoArticulo"));
			
			Collection<String> codigoArticulosCol = criteria.list();
			return codigoArticulosCol;
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}
	}
	
	@Override
	public Collection<String> consultarCodigosClasificacionesAsignados(String userId)throws SICException{
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UsuarioClasificacionProcesoDTO.class,"usucla");
			
			criteria.add(Restrictions.eq("usucla.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("usucla.id.codigoUsuario", userId));
			
			criteria.setProjection(Projections.property("id.codigoClasificacion"));
			
			Collection<String> codigoClasificacionAsignadasCol = criteria.list();
			
			return codigoClasificacionAsignadasCol;
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * Metodo que devuelve el criteria para obtener clasificaciones de la estructura comercial activas 
	 * @param clasificacionVO
	 * @param userId
	 * @return
	 */
	private Criterion criteriaUsuarioArticulo(ArticuloVO articuloVO){
		
		Conjunction conjunction = Restrictions.conjunction();
		/*
		if(StringUtils.isNotBlank(articuloVO.getBaseDTO().getClaseArticulo())){
			conjunction.add(Restrictions.eq("claseArticulo", articuloVO.getBaseDTO().getClaseArticulo()));
		}*/
		if(StringUtils.isNotEmpty(articuloVO.getBaseDTO().getCodigoBarras())){
			conjunction.add(Restrictions.eq("codigoBarras", articuloVO.getBaseDTO().getCodigoBarras()));
		}
		if(StringUtils.isNotEmpty(articuloVO.getBaseDTO().getDescripcionArticulo())){
			conjunction.add(Restrictions.ilike("descripcionArticulo", articuloVO.getBaseDTO().getDescripcionArticulo(),MatchMode.ANYWHERE));
		}
		if(StringUtils.isNotEmpty(articuloVO.getBaseDTO().getCodigoClasificacion())){
			conjunction.add(Restrictions.eq("codigoClasificacion", articuloVO.getBaseDTO().getCodigoClasificacion()));
		}
		if(CollectionUtils.isNotEmpty(articuloVO.getBaseDTO().getNpClases())){
			conjunction.add(Restrictions.in("claseArticulo", articuloVO.getBaseDTO().getNpClases()));
		}
		
		conjunction.add(Restrictions.eq("codigoEstado", articuloVO.getBaseDTO().getCodigoEstado()));
		conjunction.add(Restrictions.eq("id.codigoCompania", articuloVO.getBaseDTO().getId().getCodigoCompania()));
		conjunction.add(Restrictions.eq("estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		
		return conjunction;
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerArticulosUsuario(ArticuloVO articuloVO, String userId)throws SICException{
		try {
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ArticuloDTO.class);
			
			criteria.add(criteriaUsuarioArticulo(articuloVO));
			
			if(StringUtils.isNotBlank(userId)){
				criteria.add(Subqueries.propertyIn("id.codigoArticulo", obtenerArtUsu(userId)));
			}
			
			criteria.createAlias("articuloMedidaDTO", "artMed");
			
			criteria.setProjection(Projections.projectionList() 
					.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("descripcionArticulo"),"descripcionArticulo")
					.add(Projections.property("codigoBarras"),"codigoBarras")
					.add(Projections.property("claseArticulo"),"claseArticulo")
					.add(Projections.property("artMed.referenciaMedida"),"articuloMedidaDTO.referenciaMedida")
					.add(Projections.property("codigoClasificacion"),"codigoClasificacion"));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			Collection<ArticuloDTO> articulos = criteria.list();
			return articulos;
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar obtenerClasificacionesUsuario ");
			throw new SICException("Error al buscar obtenerClasificacionesUsuario ",e);
		}
	}
	
	@Override
	public UsuarioArticuloDTO buscarUsuarioArticulo(UsuarioArticuloDTO usuArtDTO)throws SICException{
		try {
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UsuarioArticuloDTO.class);
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("codigoUsuarioArticulo"),"codigoUsuarioArticulo")
					.add(Projections.property("codigoProceso"),"codigoProceso")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("id.codigoUsuario"),"id.codigoUsuario"));
					
			criteria.add(Restrictions.eq("id.codigoCompania",usuArtDTO.getId().getCodigoCompania()));
			criteria.add(Restrictions.eq("id.codigoArticulo",usuArtDTO.getId().getCodigoArticulo()));
			criteria.add(Restrictions.eq("id.codigoUsuario",usuArtDTO.getId().getCodigoUsuario()));
			
			criteria.setResultTransformer(new DtoResultTransformer(UsuarioArticuloDTO.class));
			UsuarioArticuloDTO usuArt= (UsuarioArticuloDTO) criteria.uniqueResult();
			
			return usuArt;
			
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.info("Error al buscarUsuarioArticulo ");
			throw new SICException("Error al buscarUsuarioArticulo ",e);
		}
	}
	
	@Override
	public void actualizarUsuarioArticulo(UsuarioArticuloDTO usuArtDTO)throws SICException{
		StringBuilder query = new StringBuilder();
		Query update;
		try {
			if(usuArtDTO.getEstado() == null){
				throw new SICException("El estado de la relacion usuario articulo no puede ser nulo");
			}else{
				this.sessionFactory.getCurrentSession().clear();
				query.append("update ").append(UsuarioArticuloDTO.class.getName())
					.append(" a  set ")
					.append("a.estado = :pEstado ,")
					.append("a.fechaModificacion = CURRENT_TIMESTAMP , " )
					.append("a.usuarioModificacion = :pUsuarioModificacion ")
					.append("where  " )
					.append("a.id.codigoArticulo = :pCodigoArticulo " )
					.append("and a.id.codigoCompania = :pCodigoCompania " )
					.append("and a.id.codigoUsuario = :pCodigoUsuario " )
					.append("and a.estado != :pEstado " );
				
				update = this.sessionFactory.getCurrentSession().createQuery(query.toString());
				
				update.setString("pUsuarioModificacion",usuArtDTO.getUserId());			
				update.setString("pCodigoArticulo",usuArtDTO.getId().getCodigoArticulo());
				update.setInteger("pCodigoCompania", usuArtDTO.getId().getCodigoCompania());
				update.setString("pCodigoUsuario", usuArtDTO.getId().getCodigoUsuario());
				update.setString("pEstado", usuArtDTO.getEstado());
				
				update.executeUpdate();

			}
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.info("Error al actualizarUsuarioClasificacion ");
			throw new SICException("Error al actualizarUsuarioClasificacion ",e);
		}
	}
	
	/************************************************************************************************************************************************
	 * fin METODOS DE autorizacion usuario
	 * ***********************************************************************************************************************************************
	 */
}
