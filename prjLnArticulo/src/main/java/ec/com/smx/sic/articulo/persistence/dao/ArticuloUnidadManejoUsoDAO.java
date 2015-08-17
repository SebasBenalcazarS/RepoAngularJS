/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloUnidadManejoUsoDAO;

/**
 * @author jdvasquez
 *
 */
public class ArticuloUnidadManejoUsoDAO implements IArticuloUnidadManejoUsoDAO{
	
	SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloUnidadManejoUsoDTO> obtenerArticuloUnidadManejoUso(Integer codigoCompania, Long codigoArticuloUnidadManejo)throws SICException{
		Collection<ArticuloUnidadManejoUsoDTO> articuloUnidadManejoUsoCol;
		Session session;
		Criteria criteria;
		try{
			session = sessionFactory.getCurrentSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloUnidadManejoUsoDTO.class,"AUMU");
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("AUMU.id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("AUMU.id.valorTipoUso"),"id.valorTipoUso")
					.add(Projections.property("AUMU.id.codigoUnidadManejo"),"id.codigoUnidadManejo"));
			
			criteria.add(Restrictions.eq("AUMU.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("AUMU.id.codigoUnidadManejo", codigoArticuloUnidadManejo));
			criteria.add(Restrictions.eq("AUMU.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloUnidadManejoUsoDTO.class));
			
			articuloUnidadManejoUsoCol = (Collection<ArticuloUnidadManejoUsoDTO>) criteria.list();
			
			return articuloUnidadManejoUsoCol;
			
		}catch(Exception e){
			throw new SICException(e);
		}
	}
}
