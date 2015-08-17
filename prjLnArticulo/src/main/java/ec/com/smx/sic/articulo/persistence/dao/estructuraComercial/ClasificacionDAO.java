package ec.com.smx.sic.articulo.persistence.dao.estructuraComercial;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.UsuarioClasificacionProcesoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ClasificacionVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.estructuracomercial.IClasificacionDAO;

/**
 * 
 * @author cortiz
 *
 */
public class ClasificacionDAO implements IClasificacionDAO{

private SessionFactory sessionFactory;

	
	/************************************************************************************************************************************************
	 * METODOS DE autorizacion usuario
	 * ***********************************************************************************************************************************************
	 */

	/**
	 * Metodo para la busqueda de clasificaciones que no estan asigandas al usuario ingresado
	 * @param areaTrabajoVO
	 * @return
	 */
	@Override
	public  Collection<ClasificacionDTO> obtenerClasificaciones(ClasificacionVO clasificacionVO, String userId, Boolean paginador)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : obtenerClasificaciones");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+clasificacionVO.getBaseDTO().getId().getCodigoCompania());
		Logeable.LOG_SICV2.info("userId: "+userId);
		Logeable.LOG_SICV2.info("código de Estructura Comercial: "+clasificacionVO.getBaseDTO().getId().getCodigoClasificacion());
		Logeable.LOG_SICV2.info("código de Sub Bodega: "+clasificacionVO.getBaseDTO().getCodigoBodega());
		
		try{
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClasificacionDTO.class);
			
			criteria.add(criteriaUsuarioClasificacion(clasificacionVO));
			if(StringUtils.isNotBlank(userId)){
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClaUsu(userId)));
			}
			
			criteria.createAlias("clasificacionDTOs","clasificacionDTOs");
			criteria.createAlias("clasificacionDTOs.clasificacionDTOs","clasificacionDTOsArticulos");
			if (StringUtils.isNotBlank(clasificacionVO.getBaseDTO().getId().getCodigoClasificacion())){
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.eq("id.codigoClasificacion", clasificacionVO.getBaseDTO().getId().getCodigoClasificacion()));
				disjunction.add(Restrictions.eq("clasificacionDTOs.id.codigoClasificacion", clasificacionVO.getBaseDTO().getId().getCodigoClasificacion()));
				disjunction.add(Restrictions.eq("clasificacionDTOsArticulos.id.codigoClasificacion", clasificacionVO.getBaseDTO().getId().getCodigoClasificacion()));
				criteria.add(disjunction);
			}
			
			if (StringUtils.isNotBlank(clasificacionVO.getBaseDTO().getCodigoBodega())){
				criteria.createAlias("clasificacionDTOsArticulos.bodegaDTO", "bodega");
				//criteria.createAlias("bodegaDTO", "bodega");
				criteria.createAlias("bodega.areaTrabajo", "areaDeTrabajo");
				criteria.add(Restrictions.eq("areaDeTrabajo.codigoReferencia", Integer.parseInt(clasificacionVO.getBaseDTO().getCodigoBodega())));
			}
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("clasificacionDTOsArticulos.descripcionClasificacion"),"descripcionClasificacion")
					.add(Projections.property("clasificacionDTOsArticulos.id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("clasificacionDTOsArticulos.id.codigoClasificacion"),"id.codigoClasificacion"));
			
			if(paginador){
				criteria.setMaxResults(clasificacionVO.getMaxResults());
				criteria.setFirstResult(clasificacionVO.getFirstResult());
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ClasificacionDTO.class));
			Collection<ClasificacionDTO> clasificacionCol = criteria.list();
			return clasificacionCol;
			
		}catch(HibernateException e){
			Logeable.LOG_SICV2.info("Error al buscar obtenerClasificaciones ");
			throw new SICException("Error al buscar obtenerClasificaciones ",e);
		}
	}
	
	@Override
	public  Integer cuentaClasificaciones(ClasificacionVO clasificacionVO, String userId)throws SICException{
		Logeable.LOG_SICV2.info("Metodo : obtenerClasificaciones");
		Logeable.LOG_SICV2.info("Parametros : ");
		Logeable.LOG_SICV2.info("codigo compania: "+clasificacionVO.getBaseDTO().getId().getCodigoCompania());
		Logeable.LOG_SICV2.info("userId: "+userId);
		try {
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClasificacionDTO.class);
			
			criteria.add(criteriaUsuarioClasificacion(clasificacionVO));
			criteria.add(Restrictions.eq("codigoTipoClasificacion", clasificacionVO.getBaseDTO().getCodigoTipoClasificacion()));
			if(StringUtils.isNotBlank(userId)){
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClaUsu(userId)));
			}
			
			criteria.setProjection(Projections.rowCount());
			
			Long count = (Long)criteria.uniqueResult();
			Integer numReg = count.intValue();
			return numReg;
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar cuentaClasificaciones ");
			throw new SICException("Error al buscar cuentaClasificaciones ",e);
		}
	}
	
	/**
	 * Metodo que devuelve el subselect para obtener los codigos de las clasificaciones del usuario insertado
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	private DetachedCriteria obtenerClaUsu(String userId)throws SICException{
		try {
			/**SUBSELECT para restringir las clasificaciones que ya estan asignadas al usuario mensionado */
			DetachedCriteria subSelect = DetachedCriteria.forClass(UsuarioClasificacionProcesoDTO.class,"usucla");
			
			subSelect.add(Restrictions.eq("usucla.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			subSelect.add(Restrictions.eq("usucla.id.codigoUsuario", userId));
			
			subSelect.setProjection(Projections.property("id.codigoClasificacion"));
			
			return subSelect;
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar obtenerClaUsu ");
			throw new SICException("Error al buscar obtenerClaUsu ",e);
		}
	}
	
	/**
	 * Metodo que devuelve el criteria para obtener clasificaciones de la estructura comercial activas 
	 * @param clasificacionVO
	 * @param userId
	 * @return
	 */
	private Criterion criteriaUsuarioClasificacion(ClasificacionVO clasificacionVO){
		
		Conjunction conjunction = Restrictions.conjunction();
		
		conjunction.add(Restrictions.eq("codigoTipoEstructura", clasificacionVO.getBaseDTO().getCodigoTipoEstructura()));
		conjunction.add(Restrictions.eq("valorTipoEstructura", clasificacionVO.getBaseDTO().getValorTipoEstructura()));
		conjunction.add(Restrictions.eq("id.codigoCompania", clasificacionVO.getBaseDTO().getId().getCodigoCompania()));
		conjunction.add(Restrictions.eq("estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
		
		return conjunction;
	}
	
	@Override
	public Collection<ClasificacionDTO> obtenerClasificacionesUsuario(ClasificacionVO clasificacionVO, String userId)throws SICException{
		try {

			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClasificacionDTO.class);
			
			criteria.add(criteriaUsuarioClasificacion(clasificacionVO));
			criteria.add(Restrictions.eq("codigoTipoClasificacion", clasificacionVO.getBaseDTO().getCodigoTipoClasificacion()));
			if(StringUtils.isNotBlank(userId)){
				criteria.add(Subqueries.propertyIn("id.codigoClasificacion", obtenerClaUsu(userId)));
			}
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("descripcionClasificacion"),"descripcionClasificacion")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion"));
			
			criteria.setResultTransformer(new DtoResultTransformer(ClasificacionDTO.class));
			Collection<ClasificacionDTO> clasificacionCol = criteria.list();
			return clasificacionCol;
			
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar obtenerClasificacionesUsuario ");
			throw new SICException("Error al buscar obtenerClasificacionesUsuario ",e);
		}
	}
	
	@Override
	public Collection<ClasificacionDTO> repotesClasificaciones(ClasificacionVO clasificacionVO, String codigoClasificacion, Integer codigoCompania, String usuario, Boolean disponible, String parametro)throws SICException{
		try {
			
			this.sessionFactory.getCurrentSession().clear();
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClasificacionDTO.class);
			
			criteria.add(criteriaUsuarioClasificacion(clasificacionVO));
			criteria.add(Restrictions.eq("codigoTipoClasificacion", clasificacionVO.getBaseDTO().getCodigoTipoClasificacion()));
			if(StringUtils.isNotBlank(usuario) && disponible && StringUtils.isNotBlank(codigoClasificacion)){
				
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClaUsu(usuario)));
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClasificacionesContarUsuario(codigoCompania, parametro)));
				criteria.add(Restrictions.eq("id.codigoClasificacion", codigoClasificacion));
			}else if(StringUtils.isNotBlank(usuario) && disponible && StringUtils.isBlank(codigoClasificacion)){
				
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClaUsu(usuario)));
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClasificacionesContarUsuario(codigoCompania, parametro)));
			}else if(StringUtils.isNotBlank(usuario) && !disponible && StringUtils.isBlank(codigoClasificacion)){
				
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClaUsu(usuario)));
			}else if(StringUtils.isNotBlank(usuario) && !disponible && StringUtils.isNotBlank(codigoClasificacion)){
				
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClaUsu(usuario)));
				criteria.add(Restrictions.eq("id.codigoClasificacion", codigoClasificacion));
			}else if(StringUtils.isBlank(usuario) && disponible && StringUtils.isNotBlank(codigoClasificacion)){
				
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClasificacionesContarUsuario(codigoCompania, parametro)));
				criteria.add(Restrictions.eq("id.codigoClasificacion", codigoClasificacion));
			}else if(StringUtils.isBlank(usuario) && !disponible && StringUtils.isNotBlank(codigoClasificacion)){
				
				criteria.add(Restrictions.eq("id.codigoClasificacion", codigoClasificacion));
			}else if(StringUtils.isBlank(usuario) && disponible && StringUtils.isBlank(codigoClasificacion)){
				
				criteria.add(Subqueries.propertyNotIn("id.codigoClasificacion", obtenerClasificacionesContarUsuario(codigoCompania, parametro)));
			}
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("descripcionClasificacion"),"descripcionClasificacion")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion"));
			
			criteria.setResultTransformer(new DtoResultTransformer(ClasificacionDTO.class));
			Collection<ClasificacionDTO> clasificacionCol = criteria.list();
			return clasificacionCol;
		} catch (SICException e) {
			Logeable.LOG_SICV2.info("Error al buscar repotesClasificaciones ");
			throw new SICException("Error al buscar repotesClasificaciones ",e);
		}
	}
	
	/**
	 * Metodo que devuelve el criteria para ver las clasificaciones segun el parametro
	 * @param codigoCompania
	 * @param parametro
	 * @return
	 * @throws SICException
	 */
	private DetachedCriteria obtenerClasificacionesContarUsuario(Integer codigoCompania, String parametro)throws SICException{
			
		DetachedCriteria subSelect = DetachedCriteria.forClass(UsuarioClasificacionProcesoDTO.class);
		subSelect.add(Restrictions.eq("id.codigoCompania",codigoCompania));
		subSelect.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			String having = "codigoClasificacion" + " having " + "count(codigoUsuario) >= " + parametro;

			String[] alias = new String[1]; 
			alias[0] = "codigoClasificacion"; 
			Type[] types = new Type[1]; 
			types[0] = StandardBasicTypes.STRING;

		subSelect.setProjection(Projections.projectionList()
				.add(Projections.alias(Projections.sqlGroupProjection("codigoClasificacion", having, alias , types), "usuCLa")));
		return subSelect;
			
	}
	/*************************************************************************************************************************************************
	* FIN metodos de autorizacion usuario
	* ***********************************************************************************************************************************************
	*/
	
	/**
	 * Obtener la clasificacion con la colecion de subclasificacion correspondiente.
	 * @author aquingaluisa
	 * @param codigoCompania
	 * @param codigoClasificacion en el caso de no traer este dato trae todas las clasificaciones
	 * @param codigoBodega
	 * @param codigoProveedor 
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ClasificacionDTO> obtenerClasificacionesConSubClasificion(Integer codigoCompania,String codigoClasificacion,String codigoBodega,String codigoProveedor) throws SICException{
		try{
			//dto princial
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClasificacionDTO.class,"cla");
			
			//agregar la relacion con subclasificacion
				criteria.createAlias("cla.subClasificacionCol", "subClasificacionCol",CriteriaSpecification.LEFT_JOIN);
			
			//agregar la relacion con proveedor
			if(codigoProveedor != null){
				criteria.createAlias("cla.proveedorClasificacionCol", "proveedorClasificacionCol",CriteriaSpecification.INNER_JOIN);
			}
			
			//agregar las resticiones
			criteria.add(Restrictions.eq("cla.estadoClasificacion",SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("cla.valorTipoEstructura",CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
			criteria.add(Restrictions.eq("cla.codigoTipoEstructura",TiposCatalogoConstantes.TIPO_ESTRUCTURA));
			criteria.add(Restrictions.eq("cla.id.codigoCompania",codigoCompania));
			criteria.add(Restrictions.eq("cla.codigoTipoClasificacion","03"));
			
			//agregar la restricion con bodega 
			if(codigoBodega != null){
				criteria.add(Restrictions.eq("cla.codigoBodega",codigoBodega));
			}
			
			//agregar la restricion por proveedor
			if(codigoProveedor != null){
				criteria.add(Restrictions.eq("proveedorClasificacionCol.id.codigoProveedor",codigoProveedor));
			}
			
			//
			if(codigoClasificacion != null){
				criteria.add(Restrictions.eq("cla.id.codigoClasificacion",codigoClasificacion));
			}
			
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			Collection<ClasificacionDTO> clasificacionCol = criteria.list();
			return clasificacionCol;
		}catch(Exception ex){
			throw new SICException("Error al buscar obtenerClasificaciones ",ex);
		}
	}
	
	@Override
	public SubClasificacionDTO  obtenerSubClasificacionDTO(Integer codigoCompania,String codigoClasificacion,String codigoSubClasificacion) throws SICException{
		//dto princial
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SubClasificacionDTO.class,"subCla");
		
		//agregar las resticiones
		criteria.add(Restrictions.eq("subCla.estadoSubClasificacion",SICConstantes.ESTADO_ACTIVO_NUMERICO));
		criteria.add(Restrictions.eq("subCla.id.codigoCompania",codigoCompania));
		criteria.add(Restrictions.eq("subCla.id.codigoClasificacion",codigoClasificacion));
		criteria.add(Restrictions.eq("subCla.id.codigoSubClasificacion",codigoSubClasificacion));
		
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		SubClasificacionDTO subClasificacion =(SubClasificacionDTO)criteria.uniqueResult();
		return subClasificacion;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
