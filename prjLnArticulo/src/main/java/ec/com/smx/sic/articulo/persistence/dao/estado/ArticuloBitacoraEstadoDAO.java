package ec.com.smx.sic.articulo.persistence.dao.estado;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraEstadoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.estado.IArticuloBitacoraEstadoDAO;

public class ArticuloBitacoraEstadoDAO implements IArticuloBitacoraEstadoDAO, Logeable {
	
	private SessionFactory sessionFactory;
	 
	@Override
	public ArticuloBitacoraEstadoDTO buscarPrimerEstadoRegistrado(Integer codigoCompania, String codigoArticulo, String codigoEstado, String... camposProyeccion) throws SICException {
		LOG_SICV2.info("==> Busqueda estado de articulo por Id");
		try{
			ArticuloBitacoraEstadoDTO articuloBitacoraEstadoDTO = null;
			final Session session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			final Criteria select = session.createCriteria(ArticuloBitacoraEstadoDTO.class);
			
			ProjectionList projections = Projections.projectionList();
			for(String propiedad : camposProyeccion){
				projections.add(Projections.property(propiedad), propiedad);
			}
			select.setProjection(projections);
			
			select.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			select.add(Restrictions.eq("codigoArticulo", codigoArticulo));
			select.add(Restrictions.eq("codigoEstado", codigoEstado));
			
			select.setFirstResult(0);
			select.setMaxResults(1);
			
			select.addOrder(Order.asc(CriteriaSpecification.ROOT_ALIAS.concat(".fechaRegistro")));
			select.setResultTransformer(new DtoResultTransformer(ArticuloBitacoraEstadoDTO.class));
			
			List<ArticuloBitacoraEstadoDTO> articuloBitacoraEstadoDTOs = select.list();
			
			if(CollectionUtils.isNotEmpty(articuloBitacoraEstadoDTOs)){
				articuloBitacoraEstadoDTO = articuloBitacoraEstadoDTOs.get(0);
			}
			
			return articuloBitacoraEstadoDTO; 
			
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al consultar articulo por Id.", e);
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
