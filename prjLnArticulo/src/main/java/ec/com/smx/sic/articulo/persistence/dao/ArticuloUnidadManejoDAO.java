package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.JoinType;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.bodega.SICBodegaConstantes;
import ec.com.smx.sic.cliente.common.ordenCompra.SICOrdenCompraConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorEquivalenciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EquivalenciaPorcentajeDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloUnidadManejoDAO;

public class ArticuloUnidadManejoDAO implements Logeable, IArticuloUnidadManejoDAO {
	private IHibernateH<ArticuloUnidadManejoDTO> hibernateH;
	
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.persistence.dao.IArticuloUnidadManejoDAO#obtenerUnidadesManejoActivasPorArticulo(java.lang.String)
	 */
	/**
	 * @param sessionFactoy the sessionFactoy to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoActivasPorArticulo(String codigoArticulo){
		Session session;		
		try{
			
			if( StringUtils.isNotEmpty(codigoArticulo) ){
				
				session = hibernateH.getHibernateSession();
				session.clear();
				
				Criteria criteria = session.createCriteria(ArticuloUnidadManejoDTO.class);
				// agrega las restricciones
				criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
				criteria.add(Restrictions.eq("estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.add(Restrictions.isNull("codigoUnidadManejoContenida"));
//				criteria.add(Restrictions.isNotNull("codigoProveedor"));
				
				//agregar proyeccions sobre valorTipoUnidadEmpaque, valorTipoUnidadEmpaque
				ProjectionList projectionList = Projections.projectionList();
				projectionList.add(Projections.alias(Projections.property("id.codigoArticulo"), "id.codigoArticulo"));
				projectionList.add(Projections.alias(Projections.property("valorTipoUnidadEmpaque"), "valorTipoUnidadEmpaque"));
				projectionList.add(Projections.alias(Projections.property("valorUnidadManejo"), "valorUnidadManejo"));
				projectionList.add(Projections.alias(Projections.property("id.codigoUnidadManejo"), "id.codigoUnidadManejo"));

				// agrega las proyecciones
				criteria.setProjection(Projections.distinct(projectionList));
				
				//transformo de objeto a ArticuloUnidadManejoDTO
				criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoDTO.class));
//				criteria.setResultTransformer( Transformers.aliasToBean(ArticuloUnidadManejoDTO.class) );
				
				return criteria.list();
			}
			
			return null;
			
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			session = null;
		}
	}
	
	

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.persistence.dao.IArticuloUnidadManejoDAO#obtenerUnidadesManejoEnOtrosArticulosPorEAN(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO, java.util.Collection)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoEnOtrosArticulosPorEAN(ArticuloDTO articulo,Collection<ArticuloUnidadManejoDTO> unidadesManejo)throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			Collection<String> eans = new ArrayList<String>();
			for(ArticuloUnidadManejoDTO aum : unidadesManejo){
				if(aum.getEstadoUnidadManejo().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) && 
						StringUtils.isNotEmpty(aum.getCodigoBarrasUnidadManejo()) && !eans.contains(aum.getCodigoBarrasUnidadManejo())){
					eans.add(aum.getCodigoBarrasUnidadManejo());
				}
			}
			if(!eans.isEmpty()){
				query = new StringBuilder();
				query.append("from ").append(ArticuloUnidadManejoDTO.class.getName()).append(" au join fetch au.articulo a join fetch a.artBitCodBarCol ab left join fetch au.articuloUnidadManejoProveedorCol ump ")
				.append("left join fetch ump.vistaProveedorDTO where au.id.codigoCompania=:pCompania and au.id.codigoArticulo <> :pCodigoArticulo and au.estadoUnidadManejo=:pEstado and au.codigoBarrasUnidadManejo in (:pEANs) ")
				.append("and a.estadoArticulo=:pEstado and a.codigoEstado <> :pCodigoEstado and ab.estadoArticuloBitacora=:pEstado order by au.id.codigoArticulo, au.prioridad");
				hqlQuery = session.createQuery(query.toString());
				hqlQuery.setInteger("pCompania", articulo.getId().getCodigoCompania());
				hqlQuery.setString("pCodigoArticulo", articulo.getId().getCodigoArticulo());
				hqlQuery.setString("pEstado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				hqlQuery.setString("pCodigoEstado", SICArticuloConstantes.getInstancia().ESTADOARTICULO_PRECODIFICADO);
				hqlQuery.setParameterList("pEANs", eans);
				hqlQuery.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
				return hqlQuery.list();
			}
			return null;
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			session = null;
			query = null;
			hqlQuery = null;
		}
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.persistence.dao.IArticuloUnidadManejoDAO#obtenerUnidadesManejoEnOtrosArticulosPorEAN(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO, java.util.Collection)
	 */
	@Override
	public void eliminarEANs(Collection<ArticuloUnidadManejoDTO> unidadesManejo, String userID, Integer codigoCompania)throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			if(!CollectionUtils.isEmpty(unidadesManejo)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				Collection<Long> codigosUnidades = new ArrayList<Long>();
				for(ArticuloUnidadManejoDTO aum : unidadesManejo){
					codigosUnidades.add(aum.getId().getCodigoUnidadManejo());
				}
				
				//se consulta la menor secuencia disponible si existe
				query = new StringBuilder();
				query.append("update ").append(ArticuloUnidadManejoDTO.class.getName()).append(" um set um.codigoBarrasUnidadManejo=null, um.idUsuarioModificacion=:pUserID, um.fechaModificacion=:pFechaActual ")
				.append("where um.id.codigoCompania=:pCompania and um.id.codigoUnidadManejo in (:pCodigos)");
				hqlQuery = session.createQuery(query.toString());
				hqlQuery.setInteger("pCompania", codigoCompania);
				hqlQuery.setString("pUserID", userID);
				hqlQuery.setTimestamp("pFechaActual", new Timestamp(System.currentTimeMillis()));
				hqlQuery.setParameterList("pCodigos", codigosUnidades);
				hqlQuery.executeUpdate();
			}
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			session = null;
			query = null;
			hqlQuery = null;
		}
	}
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @param uso
	 * @param estado
	 * @throws SICException
	 */
	public void cambiarEstadoUso(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String uso, String estado)throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			//se consulta la menor secuencia disponible si existe
			query = new StringBuilder();
			query.append("update ").append(ArticuloUnidadManejoUsoDTO.class.getName()).append(" ums set ums.estado=:pEstado, ums.idUsuarioModificacion=:pUserID, ums.fechaModificacion=:pFechaActual ")
			.append("where ums.id.codigoCompania=:pCompania and ums.id.codigoUnidadManejo=:pCodigoUnidadManejo and ums.id.valorTipoUso=:pUso");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setInteger("pCompania", articuloUnidadManejoDTO.getId().getCodigoCompania());
			hqlQuery.setLong("pCodigoUnidadManejo", articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
			hqlQuery.setString("pUserID", articuloUnidadManejoDTO.getUserId());
			hqlQuery.setTimestamp("pFechaActual", new Timestamp(System.currentTimeMillis()));
			hqlQuery.setString("pEstado", estado);
			hqlQuery.setString("pUso", uso);
			hqlQuery.executeUpdate();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			session = null;
			query = null;
			hqlQuery = null;
		}
	}
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean tieneAsignadoProveedores(ArticuloUnidadManejoDTO articuloUnidadManejoDTO)throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			//se consulta la menor secuencia disponible si existe
			query = new StringBuilder();
			query.append("select count(ump.id.codigoUnidadManejo) from ").append(ArticuloUnidadManejoProveedorDTO.class.getName()).append(" ump ")
			.append("where ump.id.codigoCompania=:pCompania and ump.id.codigoUnidadManejo=:pCodigoUnidadManejo and ump.estado=:pEstadoActivo");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setInteger("pCompania", articuloUnidadManejoDTO.getId().getCodigoCompania());
			hqlQuery.setLong("pCodigoUnidadManejo", articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
			hqlQuery.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			if((Long)hqlQuery.uniqueResult() > 0){
				return Boolean.TRUE;
			}
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			session = null;
			query = null;
			hqlQuery = null;
		}
		return Boolean.FALSE;
	}
	
	//Actualiza los valores de la unidad de manejo para BODEGA. 
	@Override
	public void actualizarUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException{
		Session session;
		StringBuilder query; 
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("update ").append(ArticuloUnidadManejoDTO.class.getName()).append(" artUniMan ")
			.append("set artUniMan.peso = :pPeso, artUniMan.alto = :pAlto, artUniMan.ancho =:pAncho,  artUniMan.profundidad =:pProfundidad, artUniMan.valorUnidadManejo =:pCantidad ")
			.append("where artUniMan.id.codigoCompania = :pCodigoCompania and artUniMan.id.codigoArticulo = :pCodigoArticulo and artUniMan.id.codigoUnidadManejo = :pCodigoUnidadManejo ");
			
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setParameter("pPeso", articuloUnidadManejoDTO.getPeso());
			hqlQuery.setParameter("pAlto", articuloUnidadManejoDTO.getAlto());
			hqlQuery.setParameter("pAncho", articuloUnidadManejoDTO.getAncho());
			hqlQuery.setParameter("pProfundidad", articuloUnidadManejoDTO.getProfundidad());
			hqlQuery.setParameter("pCantidad", articuloUnidadManejoDTO.getValorUnidadManejo());
			hqlQuery.setParameter("pCodigoArticulo", articuloUnidadManejoDTO.getId().getCodigoArticulo());
			hqlQuery.setParameter("pCodigoCompania", articuloUnidadManejoDTO.getId().getCodigoCompania());
			hqlQuery.setParameter("pCodigoUnidadManejo", articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
			
			hqlQuery.executeUpdate();
		}catch (Exception e) {			
			throw new SICException("Error al actualizar los valores de la unidad de manejo");
		}
	}
	
	/**
	* @see IArticuloUnidadManejoDAO#obtenerUMporCodigoEAN(String, Integer, String)
	*/ 
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<ArticuloUnidadManejoDTO> obtenerUMporCodigoEAN(String codigoEAN, Integer codigoCompania, String estado) throws SICException {
		
		List<ArticuloUnidadManejoDTO> unidadesManejo;
		
		Session session;
		Criteria criteria;
		try{
			session = hibernateH.getHibernateSession();
			criteria = session.createCriteria(ArticuloUnidadManejoDTO.class,"AUM");
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("AUM.id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("AUM.id.codigoUnidadManejo"),"id.codigoUnidadManejo")
					.add(Projections.property("AUM.id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("AR.id.codigoArticulo"),"articulo.id.codigoArticulo")
					.add(Projections.property("AC.verFecCadRec"),"articulo.articuloComercialDTO.verFecCadRec")
					.add(Projections.property("AR.codigoBarras"),"articulo.codigoBarras")
					.add(Projections.property("CL.codigoBodega"),"articulo.clasificacionDTO.codigoBodega"));
			
			criteria.createAlias("AUM.articulo", "AR");
			criteria.createAlias("AR.articuloComercialDTO", "AC");
			criteria.createAlias("AR.clasificacionDTO", "CL");
			
			criteria.add(Restrictions.eq("AUM.codigoBarrasUnidadManejo" , codigoEAN));
			if (codigoCompania != null){
				criteria.add(Restrictions.eq("AUM.id.codigoCompania" , codigoCompania));
			}if (estado != null){
				criteria.add(Restrictions.eq("AUM.estadoUnidadManejo" , estado));
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoDTO.class));
			
			unidadesManejo = (List<ArticuloUnidadManejoDTO>) criteria.list();
			
			return CollectionUtils.isEmpty(unidadesManejo) ? null : unidadesManejo;
		}catch(Exception e){
			throw new SICException(e.getMessage());
		}
		
		
	}
	
/************************************************************************************************************************************************
 *METODOS DE LA ESTRUCTURA LOGISTICA
 * ***********************************************************************************************************************************************
 */
	public Criterion addRestriccionClasificacionFuncionarioLineaComercial(String codigoFuncionario,String propertyIn){
		Criterion criterion = null;
		try {
			DetachedCriteria subSelectClaFun = DetachedCriteria.forClass(LineaComercialFuncionarioClasificacionDTO.class,"linComFunCla");
			subSelectClaFun.setProjection(Projections.property("linComFunCla.codigoClasificacion"));
			subSelectClaFun.add(Restrictions.eq("linComFunCla.codigoFuncionario", codigoFuncionario));
			subSelectClaFun.add(Restrictions.eq("linComFunCla.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criterion = Subqueries.propertyIn(propertyIn, subSelectClaFun);
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}
		return criterion;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloUnidadManejoDTO> buscarArticuloUnidadManejo(String codigoBarras,Integer codigoAreaTrabajo,String codigoFuncionario)throws SICException{
		Logeable.LOG_SICV2.info(" Metodo :  buscarArticuloUnidadManejo ");
		Logeable.LOG_SICV2.info(" Param: ");
		Logeable.LOG_SICV2.info(" codigoBarras : "+codigoBarras);
		Logeable.LOG_SICV2.info(" codigoAreaTrabajo : "+codigoAreaTrabajo);
		Logeable.LOG_SICV2.info(" codigoFuncionario : "+codigoFuncionario);
		
		try{
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(ArticuloUnidadManejoDTO.class, "artUnMan");
			criteria.setProjection(Projections.projectionList()
					
					.add(Projections.property("artUnMan.id.codigoUnidadManejo"),"id.codigoUnidadManejo")
					.add(Projections.property("artUnMan.id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("artUnMan.codigoBarrasUnidadManejo"),"codigoBarrasUnidadManejo")
					.add(Projections.property("artUnMan.valorUnidadManejo"),"valorUnidadManejo")
					.add(Projections.property("artMed.referenciaMedida"),"articulo.articuloMedidaDTO.referenciaMedida")
					.add(Projections.property("articulo.descripcionArticulo"),"articulo.descripcionArticulo")
					.add(Projections.property("articulo.codigoBarras"),"articulo.codigoBarras")					
					.add(Projections.property("unidadManConten.valorUnidadManejo"),"articuloUnidadManejoContenedora.valorUnidadManejo"));
				
			Criterion citeriaLeft = Restrictions.and(Restrictions.and(Restrictions.eq("unidadManConten.valorTipoUnidadEmpaque",SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PALLET), Restrictions.eq("unidadManConten.codigoTipoUnidadEmpaque",SICBodegaConstantes.CODIGO_TIPO_UNIDAD_EMPAQUE)),Restrictions.eq("unidadManConten.estadoUnidadManejo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criteria.createAlias("artUnMan.articuloUnidadManejoContenedoraCol", "unidadManConten",CriteriaSpecification.LEFT_JOIN,citeriaLeft);
			
			criteria.createAlias("artUnMan.tipoUnidadEmpaque", "tipoUnidadEmpaque");
			criteria.createAlias("artUnMan.articulo", "articulo");
			criteria.createAlias("articulo.articuloMedidaDTO", "artMed");
			criteria.createAlias("articulo.clasificacionDTO", "clasif");
			criteria.createAlias("clasif.bodegaDTO", "bodega");
			criteria.createAlias("bodega.areaTrabajo", "areaTrab");
			
			//permite añadir las restricciones de linea comercial
			criteria.add(addRestriccionClasificacionFuncionarioLineaComercial(codigoFuncionario, "articulo.codigoClasificacion"));
			
			criteria.add(Restrictions.eq("tipoUnidadEmpaque.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criteria.add(Restrictions.eq("clasif.estadoClasificacion",SICConstantes.ESTADO_ACTIVO_NUMERICO ));
			criteria.add(Restrictions.eq("bodega.estadoBodega",SICConstantes.ESTADO_ACTIVO_NUMERICO ));
			criteria.add(Restrictions.eq("areaTrab.estadoAreaTrabajo",SICConstantes.ESTADO_ACTIVO_LITERAL ));
			
			criteria.add(Restrictions.eq("areaTrab.tipoAreaTrabajoValor",CorporativoConstantes.TIPO_AREATRABAJO_SUBBODEGA ));
			criteria.add(Restrictions.eq("areaTrab.tipoAreaTrabajoTIC",TiposCatalogoConstantes.TIPO_AREA_TRABAJO ));
			criteria.add(Restrictions.eq("areaTrab.id.codigoAreaTrabajo",codigoAreaTrabajo ));
			
			criteria.add(Restrictions.eq("artUnMan.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.ne("artUnMan.valorTipoUnidadEmpaque",SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PALLET));
			criteria.add(Restrictions.eq("artUnMan.codigoTipoUnidadEmpaque",SICBodegaConstantes.CODIGO_TIPO_UNIDAD_EMPAQUE));
			criteria.add(Restrictions.eq("articulo.estadoArticulo",SICConstantes.ESTADO_ACTIVO_NUMERICO ));
			criteria.add(Restrictions.eq("articulo.codigoEstado", SICArticuloConstantes.getInstancia().ESTADOARTICULO_CODIFICADO));
			criteria.add(Restrictions.eq("articulo.codigoBarras",codigoBarras ));
			criteria.add(Restrictions.isNull("artUnMan.codigoUnidadManejoContenida"));
			criteria.add(Restrictions.ne("artUnMan.valorTipoUnidadEmpaque", SICArticuloConstantes.TIPOEMPAQUE_MAYORISTA));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoDTO.class));
			
			Collection<ArticuloUnidadManejoDTO> articuloUnidadManejoDTOCol =  criteria.list();
			
			return articuloUnidadManejoDTOCol;
			
		}catch(SICException e){
			throw new SICException(" Error buscarArticuloUnidadManejo: ",e);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloUnidadManejoDTO> buscarUnidadesManejo(ArticuloDTO articuloDTO)throws SICException{
		try{
			Logeable.LOG_SICV2.info("Metodo : exsiteDetalleSeccion");
			Logeable.LOG_SICV2.info("Parametros : ");
			Logeable.LOG_SICV2.info("codigo articulo : "+articuloDTO.getId().getCodigoArticulo());
			Logeable.LOG_SICV2.info("codigo compania : "+articuloDTO.getId().getCodigoCompania());
			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(ArticuloUnidadManejoDTO.class,"artUM");
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("artUM.codigoBarrasUnidadManejo"),"codigoBarrasUnidadManejo")
					.add(Projections.property("artUM.id.codigoUnidadManejo"),"id.codigoUnidadManejo")
					.add(Projections.property("artUM.id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("artUM.valorUnidadManejo"),"valorUnidadManejo")
					.add(Projections.property("artUM.codigoTipoUnidadEmpaque"),"codigoTipoUnidadEmpaque")
					.add(Projections.property("artUM.valorTipoUnidadEmpaque"),"valorTipoUnidadEmpaque")
					.add(Projections.property("artUM.id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("cv.nombreCatalogoValor"),"tipoUnidadEmpaque.nombreCatalogoValor")
					.add(Projections.property("art.codigoBarras"),"articulo.codigoBarras")
					.add(Projections.property("umc.valorUnidadManejo"),"articuloUnidadManejoContenedora.valorUnidadManejo"));
			criteria.createAlias("artUM.tipoUnidadEmpaque", "cv");
			criteria.createAlias("artUM.articulo", "art");
			//dentro de inner join 
			Criterion citeriaLeft =Restrictions.and(Restrictions.eq("umc.valorTipoUnidadEmpaque", SICArticuloConstantes.TIPOEMPAQUE_PALLET), Restrictions.eq("umc.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.createAlias("artUM.articuloUnidadManejoContenedoraCol","umc", CriteriaSpecification.LEFT_JOIN,citeriaLeft);
			
			criteria.add(Restrictions.eq("artUM.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("cv.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.ne("artUM.valorTipoUnidadEmpaque", SICArticuloConstantes.TIPOEMPAQUE_PALLET));
			criteria.add(Restrictions.eq("artUM.codigoTipoUnidadEmpaque", SICBodegaConstantes.CODIGO_TIPO_UNIDAD_EMPAQUE));
			criteria.add(Restrictions.eq("artUM.id.codigoArticulo", articuloDTO.getId().getCodigoArticulo()));
			criteria.add(Restrictions.eq("artUM.id.codigoCompania", articuloDTO.getId().getCodigoCompania()));
			criteria.add(Restrictions.isNull("artUM.codigoUnidadManejoContenida"));
			criteria.add(Restrictions.ne("artUM.valorTipoUnidadEmpaque", SICArticuloConstantes.TIPOEMPAQUE_MAYORISTA));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoDTO.class));
			Collection<ArticuloUnidadManejoDTO> articuloUMCol = criteria.list();
			return articuloUMCol;
		}catch(SICException e){
			LOG_SICV2.info("Error consultando las unidades de manejo");
			throw new SICException("Error consultando las unidades de manejo",e);
		}
	}
	
	@Override
	public Collection<ArticuloUnidadManejoDTO> obtenerArticuloUnidadManejoCodigoBarrasArticulo(Integer codigoCompania, String codigoBarras) throws SICException{
		Collection<ArticuloUnidadManejoDTO> unidadManejoCol = null;
		try{
			Session session = hibernateH.getHibernateSession();
			Criteria criteria = session.createCriteria(ArticuloUnidadManejoDTO.class, "AUM");
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("AUM.id.codigoUnidadManejo"),"id.codigoUnidadManejo")
					.add(Projections.property("AUM.id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("AUM.id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("AUM.valorUnidadManejo"),"valorUnidadManejo")
					.add(Projections.property("AUM.valorTipoUnidadEmpaque"),"valorTipoUnidadEmpaque")
					.add(Projections.property("ARTICULO.descripcionArticulo"),"articulo.descripcionArticulo")
					.add(Projections.property("ARTICULO.codigoBarras"),"articulo.codigoBarras")
					.add(Projections.property("COMERCIAL.verFecCadRec"),"articulo.articuloComercialDTO.verFecCadRec")
					.add(Projections.property("CLASIFICACION.codigoBodega"),"articulo.clasificacionDTO.codigoBodega"));
			
			criteria.createAlias("AUM.articulo", "ARTICULO");
			criteria.createAlias("ARTICULO.clasificacionDTO", "CLASIFICACION");
			criteria.createAlias("ARTICULO.articuloComercialDTO", "COMERCIAL");
			
			criteria.add(Restrictions.eq("AUM.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("AUM.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("ARTICULO.codigoBarras", codigoBarras));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoDTO.class));
			
			unidadManejoCol = (Collection<ArticuloUnidadManejoDTO>) criteria.list();
			
			return unidadManejoCol;
			
		}catch(Exception e){
			throw new SICException("Error al obtener las unidades de manejo por codigo de barras del articulo " , e);
		}
	}
	
	
	@Override
	public ArticuloUnidadManejoDTO buscarUnidadManejo(Integer codigoCompania, String codigoArticulo, Long codigoUniMan )throws SICException{
		try{
			Logeable.LOG_SICV2.info("Metodo : exsiteDetalleSeccion");
			Logeable.LOG_SICV2.info("Parametros : ");
			Logeable.LOG_SICV2.info("codigo articulo : "+codigoArticulo);
			Logeable.LOG_SICV2.info("codigo compania : "+codigoCompania);
			Logeable.LOG_SICV2.info("codigo uni man : "+codigoUniMan);
			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(ArticuloUnidadManejoDTO.class,"artUM");
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("artUM.codigoBarrasUnidadManejo"),"codigoBarrasUnidadManejo")
					.add(Projections.property("artUM.id.codigoUnidadManejo"),"id.codigoUnidadManejo")
					.add(Projections.property("artUM.id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("artUM.valorUnidadManejo"),"valorUnidadManejo")
					.add(Projections.property("artUM.codigoTipoUnidadEmpaque"),"codigoTipoUnidadEmpaque")
					.add(Projections.property("artUM.valorTipoUnidadEmpaque"),"valorTipoUnidadEmpaque")
					.add(Projections.property("artUM.id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("art.codigoBarras"),"articulo.codigoBarras"));
			criteria.createAlias("artUM.articulo", "art");
			//dentro de inner join 
			
			criteria.add(Restrictions.eq("artUM.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.ne("artUM.valorTipoUnidadEmpaque", SICArticuloConstantes.TIPOEMPAQUE_PALLET));
			criteria.add(Restrictions.eq("artUM.codigoTipoUnidadEmpaque", SICBodegaConstantes.CODIGO_TIPO_UNIDAD_EMPAQUE));
			criteria.add(Restrictions.eq("artUM.id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("artUM.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("artUM.id.codigoUnidadManejo", codigoUniMan));
			criteria.add(Restrictions.isNull("artUM.codigoUnidadManejoContenida"));
			criteria.add(Restrictions.ne("artUM.valorTipoUnidadEmpaque", SICArticuloConstantes.TIPOEMPAQUE_MAYORISTA));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoDTO.class));
			ArticuloUnidadManejoDTO articuloUM = (ArticuloUnidadManejoDTO)criteria.uniqueResult();
			return articuloUM;
		}catch(SICException e){
			LOG_SICV2.info("Error consultando la unidad de manejo");
			throw new SICException("Error consultando la unidad de manejo",e);
		}
	}
/*************************************************************************************************************************************************
 * FIN
 * ***********************************************************************************************************************************************
 */
	@Override
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadManejoPorArticulo(ArticuloDTO articuloDTO, Integer maxResult)throws SICException{
		try{
			Logeable.LOG_SICV2.info("Metodo : obtenerUnidadManejoPorArticulo");
			Logeable.LOG_SICV2.info("Parametros : ");
			Logeable.LOG_SICV2.info("codigo articulo : "+articuloDTO.getId().getCodigoArticulo());
			Logeable.LOG_SICV2.info("codigo compania : "+articuloDTO.getId().getCodigoCompania());
			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(ArticuloUnidadManejoDTO.class,"artUM");
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("artUM.id.codigoUnidadManejo"),"id.codigoUnidadManejo")
					.add(Projections.property("artUM.valorUnidadManejo"),"valorUnidadManejo"));
			
			criteria.add(Restrictions.eq("artUM.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("artUM.id.codigoArticulo", articuloDTO.getId().getCodigoArticulo()));
			criteria.add(Restrictions.eq("artUM.id.codigoCompania", articuloDTO.getId().getCodigoCompania()));
			criteria.add(Restrictions.eq("artUM.prioridad", 1));
			
			criteria.setMaxResults(maxResult);
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoDTO.class));
			Collection<ArticuloUnidadManejoDTO> articuloUMCol = criteria.list();
			
			return articuloUMCol;
		}catch(SICException e){
			LOG_SICV2.info("Error consultando la obtenerUnidadManejoPorArticulo");
			throw new SICException("Error consultando la obtenerUnidadManejoPorArticulo",e);
		}
	}
	
	public void actualizarCodigoBarrasArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String codigoBarrasUnidadManejo) throws SICException {
		Session session;
		StringBuilder sql;
		Query query = null;
		Boolean clearCache = Boolean.TRUE; 
		
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			sql = new StringBuilder();
			
			sql.append(" UPDATE ");
			sql.append(" ArticuloUnidadManejoDTO ");
			sql.append(" SET ");
			sql.append(" codigoBarrasUnidadManejo = :codigoBarrasUnidadManejo, ");
			sql.append(" idUsuarioModificacion = :idUsuarioModificacion, ");
			sql.append(" fechaModificacion = :fechaModificacion ");
			sql.append(" WHERE ");					
			sql.append(" id.codigoCompania = :codigoCompania");
			sql.append(" AND id.codigoArticulo = :codigoArticulo");
			sql.append(" AND id.codigoUnidadManejo = :codigoUnidadManejo");
	
			query = hibernateH.createQuery(sql.toString(), clearCache);
			
			query.setParameter("codigoCompania", articuloUnidadManejoDTO.getId().getCodigoCompania());
			query.setParameter("codigoArticulo", articuloUnidadManejoDTO.getId().getCodigoArticulo());
			query.setParameter("codigoUnidadManejo", articuloUnidadManejoDTO.getId().getCodigoUnidadManejo());
			query.setParameter("codigoBarrasUnidadManejo", codigoBarrasUnidadManejo);
			query.setParameter("idUsuarioModificacion", articuloUnidadManejoDTO.getUserId());
			query.setParameter("fechaModificacion", new Date(System.currentTimeMillis()));
			
			query.executeUpdate();
			
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}finally{
			session = null;
			query = null;
			sql = null;
		}
	}
	
	@Override
	public ArticuloUnidadManejoProveedorEquivalenciaDTO buscarArticuloUnidadManejoProveedorEquivalecia(ArticuloUnidadManejoProveedorEquivalenciaDTO articuloEquivalencia) throws SICException{
		Logeable.LOG_SICV2.info(":: actualizarArticuloUnidadManejoProveedorEquivalecia ::");
		Session session;
		ArticuloUnidadManejoProveedorEquivalenciaDTO articuloUnidadManejoProveedorEquivalenciaDTO = null;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			Criteria criteria = session.createCriteria(ArticuloUnidadManejoProveedorEquivalenciaDTO.class);
			//proyecciones
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.property("id.codigoEquivalencia"),("id.codigoEquivalencia"));
			//proList.add(Projections.property("id.codigoTipoDescuento"),("id.codigoTipoDescuento"));
			proList.add(Projections.property("estado"),("estado"));
			criteria.setProjection(proList);
			//join
			criteria.createAlias("equivalenciaPorcentajeDescuento", "equivalenciaPorcentajeDescuento",JoinType.LEFT.ordinal());
			criteria.createAlias("equivalenciaPorcentajeDescuento.asignacionTipoDescuento", "asignacionTipoDescuento",JoinType.LEFT.ordinal());
			//restricciones
			criteria.add(Restrictions.eq("id.codigoCompaniaArtUniManPro", articuloEquivalencia.getId().getCodigoCompaniaArtUniManPro()));
			criteria.add(Restrictions.eq("id.codigoUnidadManejo", articuloEquivalencia.getId().getCodigoUnidadManejo()));
			criteria.add(Restrictions.eq("id.codigoProveedor", articuloEquivalencia.getId().getCodigoProveedor()));
			criteria.add(Restrictions.eq("asignacionTipoDescuento.codigoAplicacionTipoDescuento", EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO));
			criteria.add(Restrictions.eq("asignacionTipoDescuento.valorAplicacionTipoDescuento", EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento()));
			
			//transformando
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoProveedorEquivalenciaDTO.class));
			articuloUnidadManejoProveedorEquivalenciaDTO = (ArticuloUnidadManejoProveedorEquivalenciaDTO) criteria.uniqueResult();
			
			return articuloUnidadManejoProveedorEquivalenciaDTO;
			
		} catch (Exception e) {
			throw new SICException("Error al actualizar el art\u00EDculo.", e);
		}
	}
	
	@Override
	public void actualizarArticuloUnidadManejoProveedorEquivalecia(ArticuloUnidadManejoProveedorEquivalenciaDTO articuloEquivalencia) throws SICException{
		Logeable.LOG_SICV2.info(":: actualizarArticuloUnidadManejoProveedorEquivalecia ::");
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
						
			StringBuilder query = new StringBuilder();
			query.append("update ").append(ArticuloUnidadManejoProveedorEquivalenciaDTO.class.getName())
			.append(" set codigoEquivalencia = :pCodigoEquivalencia " )
			.append(" , idUsuarioModificacion = :pIdUsuarioModificacion " )
			.append(" , fechaModificacion = :pFechaModificacion " )
			.append(" , estado = :pEstado " )
			.append("where codigoCompaniaArtUniManPro = :pCodigoCompaniaArtUniManPro ")
			.append("and codigoCompaniaEquPorDes = :pCodigoCompaniaEquPorDes ")
			.append("and codigoUnidadManejo = :pCodigoUnidadManejo ")
			.append("and codigoProveedor = :pCodigoProveedor ")
			.append("and (codigoEquivalencia) " )
			.append("in (select equ.id.codigoEquivalencia FROM " ).append(EquivalenciaPorcentajeDescuentoDTO.class.getName()).append(" equ")
			.append(" inner join equ.asignacionTipoDescuento atd ")
			.append(" where atd.codigoAplicacionTipoDescuento = :pCodigoAplicacionTipoDescuento AND atd.valorAplicacionTipoDescuento = :pValorAplicacionTipoDescuento) " ); 
			
			Query update = session.createQuery(query.toString());
						
			//parametros 
			//update.setString("pCodigoTipoDescuento", articuloEquivalencia.getId().getCodigoTipoDescuento());
			update.setInteger("pCodigoEquivalencia", articuloEquivalencia.getId().getCodigoEquivalencia());
			update.setString("pEstado", articuloEquivalencia.getEstado());
			update.setDouble("pCodigoCompaniaArtUniManPro", articuloEquivalencia.getId().getCodigoCompaniaArtUniManPro());
			update.setInteger("pCodigoCompaniaEquPorDes", articuloEquivalencia.getId().getCodigoCompaniaEquPorDes());
			update.setLong("pCodigoUnidadManejo", articuloEquivalencia.getId().getCodigoUnidadManejo());
			update.setString("pCodigoProveedor", articuloEquivalencia.getId().getCodigoProveedor());
			update.setInteger("pCodigoAplicacionTipoDescuento", EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
			update.setString("pValorAplicacionTipoDescuento", EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento());
			update.setString("pIdUsuarioModificacion", articuloEquivalencia.getIdUsuarioModificacion());
			update.setTimestamp("pFechaModificacion", articuloEquivalencia.getFechaModificacion());
			
			
			Integer total = update.executeUpdate();
			LOG_SICV2.info("Se actualizo articuloEquivalencia = ", total);
					
			session.flush();
			
		} catch (Exception e) {
			throw new SICException("Error al actualizar el art\u00EDculo.", e);
		}
	}
	
	@Override
	public void removerUnidadManejoProveedorEquivalecia(ArticuloUnidadManejoProveedorEquivalenciaDTO articuloEquivalencia) throws SICException{
		Logeable.LOG_SICV2.info(":: actualizarArticuloUnidadManejoProveedorEquivalecia ::");
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
						
			StringBuilder query = new StringBuilder();
			query.append("delete from ").append(ArticuloUnidadManejoProveedorEquivalenciaDTO.class.getName())
			.append(" where codigoCompaniaArtUniManPro = :pCodigoCompaniaArtUniManPro ")
			.append("and codigoCompaniaEquPorDes = :pCodigoCompaniaEquPorDes ")
			.append("and codigoUnidadManejo = :pCodigoUnidadManejo ")
			.append("and codigoProveedor = :pCodigoProveedor ")
			.append("and codigoEquivalencia = :pCodigoEquivalencia ");
			//.append("and codigoTipoDescuento = :pCodigoTipoDescuento ");
			
			Query update = session.createQuery(query.toString());
						
			//parametros 
			update.setInteger("pCodigoEquivalencia", articuloEquivalencia.getId().getCodigoEquivalencia());
			update.setDouble("pCodigoCompaniaArtUniManPro", articuloEquivalencia.getId().getCodigoCompaniaArtUniManPro());
			update.setInteger("pCodigoCompaniaEquPorDes", articuloEquivalencia.getId().getCodigoCompaniaEquPorDes());
			update.setLong("pCodigoUnidadManejo", articuloEquivalencia.getId().getCodigoUnidadManejo());
			update.setString("pCodigoProveedor", articuloEquivalencia.getId().getCodigoProveedor());
			//update.setString("pCodigoTipoDescuento", articuloEquivalencia.getId().getCodigoTipoDescuento());
			
			Integer total = update.executeUpdate();
			LOG_SICV2.info("Se actualizo articuloEquivalencia = ", total);
					
			session.flush();
			
		} catch (Exception e) {
			throw new SICException("Error al actualizar el art\u00EDculo.", e);
		}
	}
	
	/**
	 * metodo que valida si no existe la unidad manejo proveedor le crea
	 * @param articuloUnidadManejoProveedorDTO
	 * @throws SICException
	 */
	public void crearUnidadManejoProveedor(ArticuloUnidadManejoProveedorDTO articuloUnidadManejoProveedorDTO) throws SICException{
		//verificamos si existe la unidad manejo proveedor en base
		try {
			Session session;
			session = hibernateH.getHibernateSession();
			session.clear();
			
			Criteria criteria = session.createCriteria(ArticuloUnidadManejoProveedorDTO.class);
			//restricciones
			criteria.add(Restrictions.eq("id.codigoCompania", articuloUnidadManejoProveedorDTO.getId().getCodigoCompania()));
			criteria.add(Restrictions.eq("id.codigoProveedor", articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor()));
			criteria.add(Restrictions.eq("id.codigoUnidadManejo", articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo()));
			//proyecciones
			ProjectionList proList = Projections.projectionList();
			proList.add(Projections.rowCount());
			criteria.setProjection(proList);
			Object numUniManPro = criteria.uniqueResult();
			Long cantUniManPro = (Long)numUniManPro;
			if(cantUniManPro == 0){
				//si no existe creamos en base
				session.clear();
				
				StringBuilder queryCreate = new StringBuilder();
				queryCreate.append("INSERT INTO SCSADTARTUNIMANPRO");
				queryCreate.append(" (CODIGOCOMPANIA,CODIGOUNIDADMANEJO,CODIGOPROVEEDOR,CODIGOARTICULO,ESTADO,IDUSUARIOREGISTRO,FECHAREGISTRO) VALUES");
				queryCreate.append(" ("+articuloUnidadManejoProveedorDTO.getId().getCodigoCompania()+","+articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo()+",");
				queryCreate.append(" '"+articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor()+"','"+articuloUnidadManejoProveedorDTO.getCodigoArticulo()+"',");
				queryCreate.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
				queryCreate.append(" '"+articuloUnidadManejoProveedorDTO.getIdUsuarioRegistro()+"','"+articuloUnidadManejoProveedorDTO.getFechaRegistro()+"')");
				Query sqlQueryCreate = session.createSQLQuery(queryCreate.toString());
				sqlQueryCreate.executeUpdate();
				
			}else{
				StringBuilder update = new StringBuilder();
				update.append("update ").append(ArticuloUnidadManejoProveedorDTO.class.getName()).append(" aump ");
				update.append(" set aump.estado = :pEstado, aump.idUsuarioModificacion =:pIdUsuarioModificacion, aump.fechaModificacion =:pFechaModificacion where aump.id.codigoCompania = :pCodigoCompania ");
				update.append(" and aump.id.codigoProveedor = :pCodigoProveedor and aump.id.codigoUnidadManejo = :pCodigoUnidadManejo");
				
				Query query = session.createQuery(update.toString());
				// params
				query.setString("pEstado", articuloUnidadManejoProveedorDTO.getEstado());
				query.setInteger("pCodigoCompania", articuloUnidadManejoProveedorDTO.getId().getCodigoCompania());
				query.setString("pCodigoProveedor", articuloUnidadManejoProveedorDTO.getId().getCodigoProveedor());
				query.setLong("pCodigoUnidadManejo", articuloUnidadManejoProveedorDTO.getId().getCodigoUnidadManejo());
				query.setString("pIdUsuarioModificacion", articuloUnidadManejoProveedorDTO.getIdUsuarioModificacion()==null?articuloUnidadManejoProveedorDTO.getIdUsuarioRegistro():articuloUnidadManejoProveedorDTO.getIdUsuarioModificacion());
				query.setTimestamp("pFechaModificacion", new Timestamp(System.currentTimeMillis()));
				
				query.executeUpdate();
			}
			session.flush();
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Ocurrio un error al registrar la unidad manejo proveedor: "+e.getMessage());
			throw new SICException("Ocurrio un error al registrar la unidad manejo proveedor");
		}
	}
	
	@Override
	public ArticuloUnidadManejoDTO obtenerUnidadManejoHija(Integer codigoCompania, Long codigoUnidadManejoPadre, String valorTipoUnidadEmpaque) throws SICException{
		ArticuloUnidadManejoDTO unidadManejoHija = null;
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloUnidadManejoDTO.class);
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoUnidadManejo"),"id.codigoUnidadManejo")
					.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("valorUnidadManejo"),"valorUnidadManejo")
					.add(Projections.property("valorTipoUnidadEmpaque"),"valorTipoUnidadEmpaque")
					);
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("codigoUnidadManejoContenida", codigoUnidadManejoPadre));
			criteria.add(Restrictions.eq("valorTipoUnidadEmpaque", valorTipoUnidadEmpaque));
			criteria.add(Restrictions.eq("estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoDTO.class));
			
			unidadManejoHija = (ArticuloUnidadManejoDTO) criteria.uniqueResult();
			
			return unidadManejoHija;
		}catch(SICException e){
			Logeable.LOG_SICV2.error("Ocurrio un error al obtener la unidad de manejo hija: " + e.getMessage());
			throw new SICException("Ocurrio un error al obtener la unidad de manejo hija:", e.getMessage());
		}
	}
	
	public void aumentarPrioridadUnidadManejo(Integer prioridad , Integer codigoCompania , String codigoArticulo) throws SICException{
		try{
			Session session;
			session = hibernateH.getHibernateSession();
			session.clear();
			StringBuilder queryUpdate = new StringBuilder();
			queryUpdate.append("UPDATE SCSADTARTUNIMAN SET PRIORIDAD = PRIORIDAD + 1 WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOARTICULO = '"+codigoArticulo+"' AND ESTADOUNIDADMANEJO = '1' AND PRIORIDAD >= "+prioridad);
			Query query = session.createSQLQuery(queryUpdate.toString());
			query.executeUpdate();
		}catch(Exception e){
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException("error");
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
		LOG_SICV2.info("==> Inactivar unidad de manejo por prioridad");
		try{
			final Session session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			final StringBuilder hql = new StringBuilder("update ").append(ArticuloUnidadManejoDTO.class.getName()).append(" au")
			.append(" set estadoUnidadManejo = :pEstadoInactivo, idUsuarioModificacion = :pUserId, fechaModificacion = current_timestamp()")
			.append(" where codigoCompania = :pCodigoCompania and codigoArticulo = :pCodigoArticulo and prioridad = :pPrioridad")
			.append(" and codigoUnidadManejo not in (")
				.append("select ocde.codigoUnidadManejo from ").append(OrdenCompraDetalleEstadoDTO.class.getName()).append(" ocde")
				.append(" inner join ocde.ordenCompraEstado oce")
				.append(" where ocde.id.codigoCompania = :pCodigoCompania and ocde.estado = :pEstadoActivo and oce.estado = :pEstadoActivo")
				.append(" and oce.codigoEstadoCatVal in (:pCodigosEstado) and oce.codigoEstadoCatTip = :pCodigoTipoEstado")
			.append(")");
			if(codigoUnidadManejo instanceof Object[] && codigoUnidadManejo.length > 1){
				hql.append(" and codigoUnidadManejo not in (:pCodigoUnidadManejo)");	
			}else if(codigoUnidadManejo.length == 1){
				hql.append(" and codigoUnidadManejo <> :pCodigoUnidadManejo");
			}
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			query.setParameter("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			query.setParameter("pEstadoInactivo", SICConstantes.ESTADO_INACTIVO_NUMERICO);	
			query.setParameter("pUserId", userId);
			query.setParameter("pCodigoCompania", codigoCompania);
			query.setParameter("pCodigoArticulo", codigoArticulo);
			query.setParameter("pPrioridad", prioridad);
			query.setParameterList("pCodigosEstado", new String[]{SICOrdenCompraConstantes.CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENVIADA, 
					SICOrdenCompraConstantes.CODIGO_VALOR_ESTADO_ORDENCOMPRA_PLANIFICADA, SICOrdenCompraConstantes.CODIGO_VALOR_ESTADO_ORDENCOMPRA_ENTREGADA, 
					SICOrdenCompraConstantes.CODIGO_VALOR_ESTADO_ORDENCOMPRA_NOTAPEDIDO});
			query.setParameter("pCodigoTipoEstado", Integer.valueOf(SICOrdenCompraConstantes.CODIGO_TIPO_ESTADO_ORDENCOMPRA));
			
			if(codigoUnidadManejo instanceof Object[] && codigoUnidadManejo.length > 1){
				query.setParameterList("pCodigoUnidadManejo", codigoUnidadManejo);	
			}else if(codigoUnidadManejo.length == 1){
				query.setParameter("pCodigoUnidadManejo", codigoUnidadManejo[0]);
			}
			Integer total = query.executeUpdate();
			LOG_SICV2.info(MessageFormat.format("Se han inactivado: {0} unidades de manejo del articulo: {1} excepto la unidad de manejo {2}", total, codigoArticulo, codigoUnidadManejo));
			return total;
			
		}catch(Exception e){
			LOG_SICV2.error(MessageFormat.format("Ha ocurrido un error al Inactivar unidad de manejo del articulo {0} excepto la unidad de manejo {1}", codigoArticulo, codigoUnidadManejo));
			LOG_SICV2.error(MessageFormat.format("Ha ocurrido un error al Inactivar unidad de manejo por prioridad: {0}", e.getMessage()));			
			throw new SICException("Ha ocurrido un error al Inactivar unidad de manejo por prioridad.", e);
		}
	}
	
	/**
	 * Metodo que permite asignar la máxima prioridad al codigo de unidad de manejo de prioridad 1000
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param userId
	 * @param codigoUnidadManejo
	 * @return
	 * @throws SICException
	 */
	@Override
	public Integer asignarMaximaPrioridadUnidadManejo(Integer codigoCompania, String codigoArticulo, String userId, Long codigoUnidadManejo) throws SICException{
		LOG_SICV2.info("==> Asignar maxima prioridad a unidad de manejo");
		try{
			final Session session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			final StringBuilder hql = new StringBuilder("update ").append(ArticuloUnidadManejoDTO.class.getName()).append(" au set")
			.append(" prioridad = (")
				.append("select max(prioridad) + 1 from ").append(ArticuloUnidadManejoDTO.class.getName()).append(" uniman")
				.append(" inner join uniman.articuloUnidadManejoUsoCol unimanuso")
				.append(" where uniman.id.codigoCompania = :pCodigoCompania and uniman.id.codigoArticulo = :pCodigoArticulo and uniman.estadoUnidadManejo = :pEstadoActivo")
				.append(" and unimanuso.estado = :pEstadoActivo and unimanuso.id.valorTipoUso = :pValorUsoCompra and unimanuso.codigoTipoUso = :pCodigoTipoUso and uniman.prioridad <> :pPrioridad),")
			.append(" idUsuarioModificacion = :pUserId, fechaModificacion = current_timestamp()");
			hql.append(" where au.id.codigoCompania = :pCodigoCompania and au.id.codigoArticulo = :pCodigoArticulo");
			hql.append(" and au.id.codigoUnidadManejo = :pCodigoUnidadManejo and au.prioridad = :pPrioridad");
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			query.setParameter("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			query.setParameter("pValorUsoCompra", SICArticuloConstantes.VALORUSOUNIMANCOMPRA);	
			query.setParameter("pCodigoTipoUso", SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);	
			query.setParameter("pUserId", userId);
			query.setParameter("pCodigoCompania", codigoCompania);
			query.setParameter("pCodigoArticulo", codigoArticulo);
			query.setParameter("pCodigoUnidadManejo", codigoUnidadManejo);
			query.setParameter("pPrioridad", SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO);
			
			Integer total = query.executeUpdate();
			LOG_SICV2.info(MessageFormat.format("Se han asignado la maxima prioridad a unidad de manejo: {0} unidad de manejo del articulo: {1}", total, codigoArticulo, codigoUnidadManejo));
			return total;
			
		}catch(Exception e){
			LOG_SICV2.error(MessageFormat.format("Ha ocurrido un error al Asignar maxima prioridad a unidad de manejo {0} codigo unidad de manejo {1}", codigoArticulo, codigoUnidadManejo));
			LOG_SICV2.error(MessageFormat.format("Ha ocurrido un error al Asignar maxima prioridad a unidad de manejo: {0}", e.getMessage()));			
			throw new SICException("Ha ocurrido un error al Asignar maxima prioridad a unidad de manejo", e);
		}
	}
	
	/**
	 * Metodo para obtener las prioridades de las unidades de manejo de compra de un articulo
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<Integer> obtenerPrioridadesUnidadManejo(Integer codigoCompania, String codigoArticulo) throws SICException{
		LOG_SICV2.info("==> Obtener prioridades de unidad de manejo por articulo");
		try{
			final Session session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			final StringBuilder hql = new StringBuilder("select au.prioridad from ").append(ArticuloUnidadManejoDTO.class.getName()).append(" au");
			hql.append(" inner join au.articuloUnidadManejoUsoCol aumu");
			hql.append(" where au.id.codigoCompania = :pCodigoCompania and au.id.codigoArticulo = :pCodigoArticulo and prioridad <> :pPrioridad");
			hql.append(" and estadoUnidadManejo = :pEstadoActivo and aumu.estado = :pEstadoActivo and aumu.id.valorTipoUso = :pValorUsoCompra and aumu.codigoTipoUso = :pCodigoTipoUso");
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			query.setParameter("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);	
			query.setParameter("pCodigoCompania", codigoCompania);
			query.setParameter("pCodigoArticulo", codigoArticulo);
			query.setParameter("pPrioridad", SICArticuloConstantes.MAX_PRIORIDAD_ARTICULOUNIDADMANEJO);
			query.setParameter("pValorUsoCompra", SICArticuloConstantes.VALORUSOUNIMANCOMPRA);	
			query.setParameter("pCodigoTipoUso", SICArticuloConstantes.CODIGOTIPOUSOUNIMAN);	
			
			Collection<Integer> prioridades = query.list();
			
			if(CollectionUtils.isNotEmpty(prioridades)){
				LOG_SICV2.info(MessageFormat.format("Obtener prioridades de unidad de manejo por articulo{0}: {1}", codigoArticulo, prioridades.size()));
			}else{
				LOG_SICV2.info("No existen prioridades de unidad de manejo por articulo: {0}", codigoArticulo);
			}
			
			return prioridades;
			
		}catch(Exception e){
			LOG_SICV2.error(MessageFormat.format("Obtener prioridades de unidad de manejo por articulo {0}: {1}",	codigoArticulo, e.getMessage()));			
			throw new SICException("Ha ocurrido un error al Obtener prioridades de unidad de manejo por articulo.", e);
		}
	}
	
	/**
	 * @param hibernateH the hibernateH to set
	 */
	public void setHibernateH(IHibernateH<ArticuloUnidadManejoDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}

}
