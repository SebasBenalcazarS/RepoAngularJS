/**
 * 
 */
package ec.com.smx.sic.articulo.persistence.dao.etiquetado;

import java.math.BigDecimal;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.smx.corpv2.etiquetado.exception.EtiquetadoException;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoArticuloDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloControlEtiquetadoDAO;

/**
 * @author eharo
 *
 */
public class ArticuloControlEtiquetadoDAO implements IArticuloControlEtiquetadoDAO {
	
	SessionFactory sessionFactory;

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloControlEtiquetadoDAO#obtenerInformacionTraRegSanSem(java.lang.Integer, java.lang.String)
	 */
	@Override
	public ArticuloDTO obtenerInformacionTraRegSanSem(Integer codigoCompania, String codigoArticulo) throws SICException {
		ArticuloDTO articuloDTO = null;
		Session session = null;
		Criteria criteria = null;
		try {
			if (codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)) {

				session = this.sessionFactory.getCurrentSession();
				session.clear();

				criteria = session.createCriteria(ArticuloDTO.class, "art");
				criteria.add(Restrictions.eq("art.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("art.id.codigoArticulo", codigoArticulo));
				criteria.add(Restrictions.eq("art.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				ProjectionList projections = Projections.projectionList()
						.add(Projections.property("id.codigoCompania"), "id.codigoCompania")
						.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo")
						.add(Projections.property("estadoArticulo"), "estadoArticulo")
						.add(Projections.property("aplicaTransgenico"), "aplicaTransgenico")
						.add(Projections.property("valorEstadoTransgenico"), "valorEstadoTransgenico")
						.add(Projections.property("valorAplicaRegistroSanitario"), "valorAplicaRegistroSanitario");
				criteria.setProjection(projections);

				criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));

				articuloDTO = (ArticuloDTO) criteria.uniqueResult();
			}
		} catch (Exception e) {
			throw new SICException("No se ha podido consultar la informacion del transgenico, registro sanitario y semaforo del articulo", e.getMessage());
		} finally {
			session = null;
			criteria = null;
		}
		
		return articuloDTO;
	}
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloControlEtiquetadoDAO#obtenerArticuloPoseeEtiquetaSemaforo(java.lang.Integer, java.lang.String)
	 */
	@Override
	public ArticuloEtiquetaDTO obtenerArticuloPoseeEtiquetaSemaforo(Integer codigoCompania, String codigoArticulo) throws SICException {
		ArticuloEtiquetaDTO articuloEtiquetaDTO = null;
		Session session = null;
		Criteria criteria = null;
		try {
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloEtiquetaDTO.class, "artEti");
				criteria.add(Restrictions.eq("artEti.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("artEti.id.codigoArticulo", codigoArticulo));
				criteria.add(Restrictions.eq("artEti.id.tagCode", SICArticuloConstantes.getInstancia().ETIQUETA_SEMAFORO));
				
				ProjectionList projectionList = Projections.projectionList()
						.add(Projections.property("id.codigoCompania"), "id.codigoCompania")
						.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo")
						.add(Projections.property("id.tagCode"), "id.tagCode")
						.add(Projections.property("estado"), "estado");
				
				criteria.setProjection(projectionList);
				
				criteria.setResultTransformer(new DtoResultTransformer(ArticuloEtiquetaDTO.class));
				
				articuloEtiquetaDTO = (ArticuloEtiquetaDTO) criteria.uniqueResult();
			}
		} catch (Exception e) {
			throw new SICException("No se ha podido obtener si el articulo posee semaforo ", e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return articuloEtiquetaDTO;
	}

	@SuppressWarnings("unchecked")
	public Collection<ArticuloEtiquetaDTO> obtenerArticuloEtiquetaPorTipo(Integer codigoCompania, Long codigoEtiqueta, String codigoTipoArticulo)throws SICException{
		Collection<ArticuloEtiquetaDTO> articuloEtiquetaCol = null;
//		Session session = null;
		Criteria criteria = null;
//		StringBuilder select = null;
		Session session = null;
//		SQLQuery query = null;	
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			
//			criteria = session.createCriteria(ArticuloEtiquetaDTO.class, "artEti");
//			criteria.createAlias("artEti.articulo", "art", JoinType.INNER.ordinal());
//			criteria.createAlias("art.artBitCodBarCol", "artCodBar", JoinType.INNER.ordinal());
//			criteria.add(Restrictions.eq("artEti.id.tagCode", codigoEtiqueta));
//			
//			articuloEtiquetaCol = criteria.list();
			
			criteria = session.createCriteria(ArticuloEtiquetaDTO.class, "articuloEtiqueta");
			//Relacion con scsadtartbitcodbar
			criteria.createCriteria("articuloEtiqueta.articulo","articulo",CriteriaSpecification.LEFT_JOIN);
			criteria.createCriteria("articulo.artBitCodBarCol","articuloBitacora",CriteriaSpecification.LEFT_JOIN);
			criteria.add(Restrictions.eq("articuloEtiqueta.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("articuloEtiqueta.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("articuloEtiqueta.id.tagCode", codigoEtiqueta));
			criteria.add(Restrictions.eq("articuloBitacora.estadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
			
			articuloEtiquetaCol = criteria.list();
//			
//			select = new StringBuilder();
//			
//			select.append("SELECT * ")
//			.append(" FROM SCSADTARTETI  artEti ")
//			.append(" INNER JOIN SCSPETARTICULO articulo ")
//			.append(" 	ON artEti.codigoarticulo = articulo.codigoarticulo")
//			.append(" 		AND artEti.codigocompania = articulo.codigocompania ")
//			.append(" 		AND ( articulo.estadoarticulo =:pEstadoArticulo ) ")
//			.append(" INNER JOIN scsadtartbitcodbar articulobit ")
//			.append(" 	ON articulo.codigoarticulo = articulobit.codigoarticulo ")
//			.append(" 		AND articulo.codigocompania = articulobit.codigocompania  ")
//			.append(" 		AND ( articulobit.estadoarticulobitacora =:pEstadoArticuloBitacora )  ")
//			.append(" WHERE ")
//			.append(" artEti.codigocompania = :pCodigoCompania ")
//			.append(" AND artEti.estado = :pEstado ")
//			.append(" AND artEti.tagCode = :pCodigoEtiqueta");
//			
//			session = this.sessionFactory.getCurrentSession();
//			session.clear();
//			
//			query = session.createSQLQuery(String.valueOf(select));
//			query.setString("pEstadoArticulo", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
//			query.setString("pEstadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
//			query.setInteger("pCodigoCompania", codigoCompania);
//			query.setString("pEstado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
//			query.setLong("pCodigoEtiqueta", codigoEtiqueta);
//			
//			
//			query.addEntity("tipArt",ArticuloEtiquetaDTO.class);
//			query.addEntity("articulo",ArticuloDTO.class);
//			query.addEntity("articulobit",ArticuloBitacoraCodigoBarrasDTO.class);
//			articuloEtiquetaCol = query.list();
			
		} catch (Exception e) {
			throw new SICException("No se ha podido obtener los articulos por etiqueta ", e.getMessage());
		}finally{
			session = null;
//			criteria = null;
		}
		return articuloEtiquetaCol;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<TipoArticuloDTO> obtenerArticuloRecipientes(Integer codigoCompania, String codigoArticuloTipoPadre)throws SICException{
		Collection<TipoArticuloDTO> tipoArticuloRecipienteCol = null;
		StringBuilder select = null;
		Session session = null;
		SQLQuery query = null;	
		try {
				select = new StringBuilder();
				
				select.append("SELECT * ")
				.append(" FROM SCSPETTIPART  tipArt ")
				.append(" WHERE ")
				.append(" tipArt.codigocompania = :pCodigoCompania ")
				.append(" AND tipArt.codigoTipoArticuloPadre = :pCodigoTipoArticuloPadre");
				
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				query = session.createSQLQuery(String.valueOf(select));
				query.setInteger("pCodigoCompania", codigoCompania);
				query.setString("pCodigoTipoArticuloPadre", codigoArticuloTipoPadre);
				
				
				query.addEntity("tipArt",TipoArticuloDTO.class);
				
				tipoArticuloRecipienteCol = query.list();

		} catch (Exception e) {
			throw new SICException("No se ha podido obtener los articulos recipiente ", e.getMessage());
		}finally{
			session = null;
			query = null;
			select = null;
		}
		return tipoArticuloRecipienteCol;
	}
	
	public synchronized Integer obtenerSecuencialArticuloEtiqueta(Integer codigoCompania, String codigoArticulo, Long codigoEtiqueta)throws SICException{
		Integer secuencial = null;
		BigDecimal valSecuencia = null;
		StringBuilder select = null;
		Session session = null;
		SQLQuery query = null;	
		try {
				select = new StringBuilder();
				
				select.append("SELECT artEti.VALORSECUENCIA ")
				.append(" FROM SCSADTARTETI  artEti ")
				.append(" WHERE ")
				.append(" artEti.codigoArticulo = :pCodigoArticulo")
				.append(" AND artEti.codigocompania = :pCodigoCompania ")
				.append(" AND artEti.tagCode = :pCodigoEtiqueta ")
				.append(" AND artEti.estado = :pEstado");
				
				session = this.sessionFactory.getCurrentSession();
				session.clear();
				
				query = session.createSQLQuery(String.valueOf(select));
				query.setString("pCodigoArticulo", codigoArticulo);
				query.setInteger("pCodigoCompania", codigoCompania);
				query.setLong("pCodigoEtiqueta", codigoEtiqueta);
				query.setString("pEstado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO);
				
				valSecuencia = (BigDecimal) query.uniqueResult();
				secuencial = valSecuencia == null ? null:Integer.valueOf(valSecuencia.toString());

		} catch (Exception e) {
			throw new SICException("No se ha podido obtener los articulos recipiente ", e.getMessage());
		}finally{
			session = null;
			query = null;
			select = null;
		}
		return secuencial;
	}

	
	public synchronized  void  actualizarArticuloEtiquetaDTO(ArticuloEtiquetaDTO articuloEtiquetaDTO)throws SICException{
		try {
			sessionFactory.getCurrentSession().update(articuloEtiquetaDTO);
			sessionFactory.getCurrentSession().flush();
			sessionFactory.getCurrentSession().clear();
		} catch (Exception e) {
			throw new EtiquetadoException(e);
		}
	}
	

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
