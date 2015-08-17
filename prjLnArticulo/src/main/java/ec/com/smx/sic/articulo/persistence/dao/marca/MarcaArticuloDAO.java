package ec.com.smx.sic.articulo.persistence.dao.marca;

import java.util.Collection;

import javax.persistence.criteria.JoinType;

import org.codehaus.plexus.util.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.marca.IMarcaArticuloDAO;

public class MarcaArticuloDAO implements IMarcaArticuloDAO {
	
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<MarcaArticuloDTO> findMarcaArticuloFiltro(Integer first, Integer pageSize, Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException {
		Collection<MarcaArticuloDTO> marcaArticuloCol = null;
		try {
			Criteria criteria = criteriaMarcaArticulo(codigoCompania, busquedaSimpleArticuloVO);
			criteria.add(Restrictions.eq("marca.id.codigoCompania", codigoCompania));
			criteria.setFirstResult(first);
			criteria.setMaxResults(pageSize);
			marcaArticuloCol = criteria.list();
		} catch (Exception e) {
			throw new SICException(e);
		}
		return marcaArticuloCol;
	}
	
	
	public Integer totalMarcaArticuloFiltro(Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException{
		Integer totalRegistrosMarca;
		try {
			Criteria criteria = null;
			criteria = criteriaMarcaArticulo(codigoCompania, busquedaSimpleArticuloVO);
			criteria.setProjection(Projections.countDistinct("marca.id.secuencialMarca"));
			Long totalRegistros = (Long) criteria.uniqueResult();
			totalRegistrosMarca = totalRegistros.intValue();
			Logeable.LOG_SICV2.info("Total registros : "+totalRegistros.intValue());
		} catch (Exception e) {
			throw new SICException(e);
		}
		
		return totalRegistrosMarca;
		
	}
	
	
	public Criteria criteriaMarcaArticulo(Integer codigoCompania, BusquedaSimpleArticuloVO busquedaSimpleArticuloVO){
		Criteria criteria = null;
		Session session = null;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
			criteria = session.createCriteria(MarcaArticuloDTO.class, "marca");
			criteria.createAlias("marca.tipoMarca" , "catalogoValor" , JoinType.LEFT.ordinal());
//			//relacion con MarcaProveedor
//			criteria.createAlias("marca.proveedorMarcaCol" , "marcaProveedor" , JoinType.LEFT.ordinal());
//			//relacion con Proveedor
//			criteria.createAlias("marcaProveedor.proveedor" , "proveedor" , JoinType.LEFT.ordinal());
//			//relacion con CatalogoValor
//			criteria.createAlias("marca.tipoMarca", "tipoMarca" , JoinType.LEFT.ordinal());
			DetachedCriteria subselect = DetachedCriteria.forClass(MarcaArticuloDTO.class);
			subselect.setProjection(Projections.property("id.secuencialMarca"));
			subselect.createAlias("tipoMarca" , "catalogoValor" , JoinType.LEFT.ordinal());
			
			if (busquedaSimpleArticuloVO != null) {
				//relacion con ArticuloComercial
				subselect.createAlias("articuloComercialCol", "articuloComercial", JoinType.LEFT.ordinal());
				//relacion con Articulo
				subselect.createAlias("articuloComercial.articulo", "articulo", JoinType.LEFT.ordinal());
				//relacion con ArticuloProveedor
				subselect.createAlias("articulo.articuloProveedorCol","articuloProveedor",JoinType.LEFT.ordinal());
				
				//codigoProveedor
				subselect.add(Restrictions.eq("articuloProveedor.id.codigoProveedor", busquedaSimpleArticuloVO.getCodigoProveedor()));
				//codigo Clasificacion
				if(busquedaSimpleArticuloVO.getCodigoClasificacion() != null){
					subselect.add(Restrictions.eq("articulo.codigoClasificacion", busquedaSimpleArticuloVO.getCodigoClasificacion()));
				}
				//codigo SubClasificacion
				if(busquedaSimpleArticuloVO.getCodigoSubClasificacion() != null){
					subselect.add(Restrictions.eq("codigoSubClasificacion", busquedaSimpleArticuloVO.getCodigoSubClasificacion()));
				}
				//Departamento y subBodega
				if(busquedaSimpleArticuloVO.getCodigoDepartamento() != null || busquedaSimpleArticuloVO.getCodigoSubbodega() != null){
					//relacion con Clasificacion 
					subselect.createAlias("articulo.clasificacionDTO" , "clasificacionDTO" , JoinType.LEFT.ordinal());
					if(busquedaSimpleArticuloVO.getCodigoDepartamento() != null){
						subselect.add(Restrictions.eq("clasificacionDTO.codigoClasificacionPadre", busquedaSimpleArticuloVO.getCodigoDepartamento()));
					}
					if(busquedaSimpleArticuloVO.getCodigoSubbodega() != null){
						subselect.add(Restrictions.eq("clasificacionDTO.codigoBodega", busquedaSimpleArticuloVO.getCodigoSubbodega()));
					}
				}
				
				if (busquedaSimpleArticuloVO.getTipoMarca() != null) {
					subselect.add(Restrictions.in("catalogoValor.id.codigoCatalogoValor", busquedaSimpleArticuloVO.getTipoMarca()));
				}
				
				if (busquedaSimpleArticuloVO.getMarcaComercial() != null) {
					subselect.add(Restrictions.eq("id.secuencialMarca", busquedaSimpleArticuloVO.getMarcaComercial()));
				}
				
				if (busquedaSimpleArticuloVO.getNombreMarca() != null && StringUtils.isNotEmpty(busquedaSimpleArticuloVO.getNombreMarca())) {
					subselect.add(Restrictions.eq("nombre", busquedaSimpleArticuloVO.getNombreMarca()));
				}
			}	
			
			subselect.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			
			criteria.add(Property.forName("id.secuencialMarca").in(subselect));
			
			
		} catch (Exception e) {
			throw new SICException(e);
		}finally{
			session = null;
		}
		return criteria;
	}
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	

}
