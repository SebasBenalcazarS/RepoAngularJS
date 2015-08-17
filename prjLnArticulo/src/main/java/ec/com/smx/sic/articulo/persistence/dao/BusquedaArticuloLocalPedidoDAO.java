package ec.com.smx.sic.articulo.persistence.dao;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloAsignacionLocalVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IBusquedaArticuloLocalPedidoDAO;

public class BusquedaArticuloLocalPedidoDAO implements IBusquedaArticuloLocalPedidoDAO{
	private SessionFactory sessionFactory;
	
	@SuppressWarnings({ "unchecked" })
	public Collection<ArticuloAsignacionLocalVO> obtenerArticuloLocal(ArticuloID articuloId , Integer tipoAreaTrabajoTic , String tipoAreaTrabajoValor)throws SICException{
		try{
			Collection<ArticuloAsignacionLocalVO> locales;
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			StringBuilder query = null;
			Query sqlQuery = null;
			query = new StringBuilder();
			query.append("SELECT ARTLOC.CODIGOLOCAL as \"codigoLocal\" , LOC.CODIGOESTABLECIMIENTO as \"codigoEstablecimiento\", LOC.NOMBREAREATRABAJO as \"nombreLocal\", EST.NOMBREESTABLECIMIENTO as \"nombreEstablecimiento\""); 
			query.append(" FROM SCSADTARTLOC ARTLOC");
			query.append(" LEFT JOIN SSPCOTAREATRABAJO LOC ON ARTLOC.CODIGOCOMPANIA = LOC.CODIGOCOMPANIA AND ARTLOC.CODIGOLOCAL = LOC.CODIGOAREATRABAJO"); 
			query.append(" LEFT JOIN SSPCOTESTABLECIMIENTOCIUDAD CIU ON LOC.CODIGOCOMPANIA = CIU.CODIGOCOMPANIA AND LOC.CODIGOESTABLECIMIENTO = CIU.CODIGOESTABLECIMIENTO AND LOC.CODIGOCIUDAD = CIU.CODIGOCIUDAD"); 
			query.append(" LEFT JOIN SSPCOTESTABLECIMIENTO EST ON CIU.CODIGOCOMPANIA = EST.CODIGOCOMPANIA AND CIU.CODIGOESTABLECIMIENTO = EST.CODIGOESTABLECIMIENTO"); 
			query.append(" WHERE ARTLOC.CODIGOARTICULO = '"+articuloId.getCodigoArticulo()+"'");
			query.append(" AND ARTLOC.CODIGOCOMPANIA = "+articuloId.getCodigoCompania());
			query.append(" AND ARTLOC.ESTADOARTICULOLOCAL = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'");
			query.append(" AND LOC.TIPOAREATRABAJOTIC = "+tipoAreaTrabajoTic);
			query.append(" AND LOC.TIPOAREATRABAJOVALOR = '"+tipoAreaTrabajoValor+"'");
			query.append(" AND LOC.ESTADOAREATRABAJO = '"+SICConstantes.ESTADO_ACTIVO_LITERAL+"'");
			query.append(" ORDER BY LOC.CODIGOESTABLECIMIENTO, ARTLOC.CODIGOLOCAL");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.setResultTransformer(new DtoResultTransformer(ArticuloAsignacionLocalVO.class));
			
			locales = sqlQuery.list();
			session.flush(); 
			return locales;
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public Collection<ArticuloLocalPedidoDTO> obtenerArticuloLocalPedido(ArticuloID articuloId)throws SICException{
		try{
			Collection<ArticuloLocalPedidoDTO> localAsignacionPedidoCol;
			Session session = sessionFactory.getCurrentSession();
			session.clear();
			Criteria criteria = session.createCriteria(ArticuloLocalPedidoDTO.class);
			criteria.add(Restrictions.eq("id.codigoCompania", articuloId.getCodigoCompania()));
			criteria.add(Restrictions.eq("id.codigoArticulo", articuloId.getCodigoArticulo()));
			localAsignacionPedidoCol = criteria.list();
			return localAsignacionPedidoCol;
		}catch(Exception e){
			throw new SICException(e);
		}
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
