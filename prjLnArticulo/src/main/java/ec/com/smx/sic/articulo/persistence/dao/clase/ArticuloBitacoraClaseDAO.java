package ec.com.smx.sic.articulo.persistence.dao.clase;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloBitacoraClaseDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.clase.IArticuloBitacoraClaseDAO;

public class ArticuloBitacoraClaseDAO implements IArticuloBitacoraClaseDAO,Logeable{

private IHibernateH<ArticuloBitacoraClaseDTO> hibernateH;
	
	/**
	 * @author mgranda
	 * @param articuloClaseDTO
	 * @throws SICException
	 */
	@Override
	public void crearArticuloBitacoraClase(ArticuloBitacoraClaseDTO articuloBitacoraClaseDTO) throws SICException{
		LOG_SICV2.info("==> Registrando ArticuloBitacoraClase");
		try{
			final Session session = hibernateH.getHibernateSession();
			session.clear();
			hibernateH.crearObjeto(articuloBitacoraClaseDTO);
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public Long obtenerTotalHistoricoClase(Integer codigoCompania, String codigoArticulo) throws SICException{
		Session session = null;
		Long totalRegistros = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			StringBuilder squery = new StringBuilder();
			squery.append(" select count(*) from ArticuloBitacoraClaseDTO artBit ");
			squery.append(" where artBit.id.codigoCompania = :codigoCompania ");
			squery.append(" and artBit.codigoArticulo = :codigoArticulo ");
			
			Query hquery = session.createQuery(squery.toString());
			hquery.setParameter("codigoCompania", codigoCompania);
			hquery.setParameter("codigoArticulo", codigoArticulo);
			totalRegistros = (Long)hquery.uniqueResult();
			
			if(totalRegistros == null)
				totalRegistros = Long.valueOf(0);
			
		}catch(Exception e){
			LOG_SICV2.error("Error al obtener el total de registros de hist\u00F3rico de clase del art\u00EDculo {}", e.getMessage());
			throw new SICException(e);
		}
		return totalRegistros;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<ArticuloBitacoraClaseDTO> obtenerHistoricoClase(int first, int pageSize, String sortField, Map<String, String> filters) throws SICException{
		Session session;
		Criteria criteria;
		List<ArticuloBitacoraClaseDTO> articuloBitacoraClaseList =  null;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloBitacoraClaseDTO.class, "artBit");
			criteria.createAlias("tipoCausal", "tipoCausal", CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("usuarioCambioClase", "usuarioCambioClase", CriteriaSpecification.LEFT_JOIN);
			
			criteria.add(Restrictions.eq("artBit.id.codigoCompania", Integer.valueOf(filters.get("codigoCompania"))));
			criteria.add(Restrictions.eq("artBit.codigoArticulo", filters.get("codigoArticulo")));
			
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("artBit.claseArticulo"), "claseArticulo");
			projectionList.add(Projections.property("tipoCausal.nombreCatalogoValor"), "tipoCausal.nombreCatalogoValor");
			projectionList.add(Projections.property("artBit.fechaInicio"), "fechaInicio");
			projectionList.add(Projections.property("artBit.fechaFin"), "fechaFin");
			projectionList.add(Projections.property("usuarioCambioClase.userCompleteName"), "usuarioCambioClase.userCompleteName");
			criteria.setProjection(projectionList);
			
			criteria.setFirstResult(first);
			criteria.setMaxResults(pageSize);
			
			if(StringUtils.isEmpty(sortField))
			{
				criteria.addOrder(Order.asc("artBit.fechaFin"));
			}else{
				criteria.addOrder(Order.asc("artBit." + sortField));				
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloBitacoraClaseDTO.class));			
			articuloBitacoraClaseList = criteria.list();	
		}catch(SICException e) {
			LOG_SICV2.error("Error al consulta el hist\u00F3rico de clase del art\u00EDculo", e);
			throw new SICException(e);
		} catch(Exception ex) {
			LOG_SICV2.error("Error al consulta el hist\u00F3rico de clase del art\u00EDculo", ex);
			throw new SICException(ex);
		}
		return articuloBitacoraClaseList;
	}

	public void setHibernateH(IHibernateH<ArticuloBitacoraClaseDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
