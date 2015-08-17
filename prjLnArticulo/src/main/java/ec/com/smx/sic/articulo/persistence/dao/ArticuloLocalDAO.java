package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import ec.com.kruger.utilitario.dao.commons.hibernate.HibernateH;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.CantidadCuponLocal;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloLocalDAO;


public class ArticuloLocalDAO implements Logeable, IArticuloLocalDAO{

	private HibernateH<ArticuloLocalDTO> hibernateH;
	
	/**
	 * 
	 * @param articuloLocalDTO
	 * @throws SICException
	 */
	@Override
	public void actualizarEstadoPorArticulo(Integer codigoCompania, String codigoArticulo, String nuevoEstado, String userId, Collection<Integer> codigosLocal) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			String filtroEstado = SICConstantes.ESTADO_ACTIVO_NUMERICO;
			if(nuevoEstado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				filtroEstado = SICConstantes.ESTADO_INACTIVO_NUMERICO;
			}
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ").append(ArticuloLocalDTO.class.getName()).append(" al set al.estadoArticuloLocal = :pEstArtLoc, al.idUsuarioModificacion=:pUserId, al.fechaModificacion=:pDate where al.id.codigoCompania = :pCodigoCompania and al.id.codigoArticulo = :pCodigoArticulo ")
				.append("and al.estadoArticuloLocal=:pFiltroEstado");
			if(!CollectionUtils.isEmpty(codigosLocal)){
				query.append(" and al.id.codigoLocal in (:pCodigosLocal)");
			}
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pEstArtLoc", nuevoEstado);
			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
			hqlQuery.setString("pFiltroEstado", filtroEstado);
			hqlQuery.setString("pUserId", userId);
			hqlQuery.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
			if(!CollectionUtils.isEmpty(codigosLocal)){
				hqlQuery.setParameterList("pCodigosLocal", codigosLocal);
			}
			
			hqlQuery.executeUpdate();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}
	}

	/**
	 * 
	 * @param locales
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<CantidadCuponLocal> obtenerCantidadCuponesLocal(Collection<Integer> locales, Date fechaInicial, Date fechaFinal) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("select al.codigolocal as {alo.codigoLocal}, count(al.codigolocal) as {alo.cantidadCupones} from scsadtartloc al ")
			.append("join scsadtartbitcodbar ab on al.codigocompania=ab.codigocompania and al.codigoarticulo = ab.codigoarticulo ")
			.append("join scsadtarttem atm on al.codigocompania=atm.codigocompania and al.codigoarticulo=atm.codigoarticulo ")
			.append("where al.codigocompania = 1 and al.codigolocal in (:pLocales) and ab.estadoarticulobitacora=:pEstadoActivo and ab.valortiposecuencia=:pValorSecuencia and al.estadoArticuloLocal=:pEstadoActivo ")
			.append("and ((:pfechainicial >= atm.fechainiciotemporada and :pfechainicial <= atm.fechafintemporada) or (:pfechafinal >= atm.fechainiciotemporada and :pfechafinal <= atm.fechafintemporada) or (:pfechainicial < atm.fechainiciotemporada and :pfechafinal > atm.fechafintemporada)) ")
			.append("group by al.codigolocal");
			hqlQuery = session.createSQLQuery(query.toString()).addEntity("alo", CantidadCuponLocal.class);
			hqlQuery.setParameterList("pLocales", locales);
			hqlQuery.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			hqlQuery.setString("pValorSecuencia", SICArticuloConstantes.getInstancia().TIPSECART_CUPONESPECIAL);
			hqlQuery.setDate("pfechainicial", fechaInicial);
			hqlQuery.setDate("pfechafinal", fechaFinal);
			return hqlQuery.list();
			
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}
	}
	
	/**
	 * 
	 * @param articuloLocalDTO
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloLocalDTO> obtenerArticuloLocal(Integer codigoCompania, String codigoArticulo) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("from ").append(ArticuloLocalDTO.class.getName()).append(" a where a.id.codigoCompania = :pCodigoCompania and a.id.codigoArticulo = :pCodigoArticulo");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
			return hqlQuery.list();
			
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}
	}
	/**
	 * @param hibernateH the hibernateH to set
	 */
	public void setHibernateH(HibernateH<ArticuloLocalDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
}
