package ec.com.smx.sic.articulo.persistence.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.MultiLevelResultTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloLocalPrecioDAO;


public class ArticuloLocalPrecioDAO implements Logeable, IArticuloLocalPrecioDAO{

	private IHibernateH<ArticuloLocalPrecioDTO> hibernateH;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param estado
	 * @throws SICException
	 */
	@Override
	public void actualizarArticuloLocalPrecio(ArticuloLocalGestionPrecioDTO precioPlanificado, String estado, String userId) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ")
			.append(ArticuloLocalPrecioDTO.class.getName())
			.append(" al set al.estadoPrecio = :pEstArtLoc, al.idUsuarioModificacion = :pUserId, al.fechaModificacion = :pFechaModificacion, al.secuencialPrecioDiferenciado = :pSecuencialPrecioDiferenciado ");
			if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				query.append(", al.valorActual = :pValorActual ");
			}
			query.append("where al.id.codigoCompania = :pCodigoCompania and al.id.codigoArticulo = :pCodigoArticulo and al.id.codigoLocal = :pCodigoLocal");
			
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pEstArtLoc", estado);
			hqlQuery.setInteger("pCodigoCompania", precioPlanificado.getId().getCodigoCompania());
			hqlQuery.setString("pCodigoArticulo", precioPlanificado.getCodigoArticulo());
			hqlQuery.setInteger("pCodigoLocal", precioPlanificado.getCodigoLocal());
			hqlQuery.setDate("pFechaModificacion", new Timestamp(System.currentTimeMillis()));
			if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				hqlQuery.setDouble("pValorActual", precioPlanificado.getArticuloPrecioDif().getValor());
			}
			hqlQuery.setLong("pSecuencialPrecioDiferenciado", precioPlanificado.getArticuloPrecioDif().getId().getSecuencial());
			hqlQuery.setString("pUserId", userId);
			hqlQuery.executeUpdate();
		}catch (Exception e) {
			throw new SICException(e);
		}
	}

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param tipoPrecio
	 * @param clase
	 * @throws SICException
	 */
	private void desactivarTipoPrecio(Integer codigoCompania, String codigoArticulo, String tipoPrecio, Class<? extends SearchDTO> clase) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ").append(clase.getName()).append(" ap set ap.estadoPrecio=:pInactivo ")
			.append("where ap.id.codigoCompania=:pCodigoCompania and ap.id.codigoArticulo=:pCodigoArticulo and ap.id.codigoTipoPrecio=:pTipoPrecio and ap.estadoPrecio=:pActivo");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pInactivo", SICConstantes.ESTADO_INACTIVO_NUMERICO);
			hqlQuery.setString("pActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
			hqlQuery.setString("pTipoPrecio", tipoPrecio);
			hqlQuery.executeUpdate();
			
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}
	}
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param tipoPrecio
	 * @throws SICException
	 */
	@Override
	public void desactivarTipoPrecio(Integer codigoCompania, String codigoArticulo, String tipoPrecio) throws SICException{
		desactivarTipoPrecio(codigoCompania, codigoArticulo, tipoPrecio, ArticuloPrecioDTO.class);
		desactivarTipoPrecio(codigoCompania, codigoArticulo, tipoPrecio, ArticuloLocalPrecioDTO.class);
	}
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @param estado
	 * @throws SICException
	 */
	@Override
	public void actualizarEstadoPorArticuloLocal(Integer codigoCompania, Integer codigoLocal, String codigoArticulo, String nuevoEstado) throws SICException{
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
			query.append("update ").append(ArticuloLocalPrecioDTO.class.getName()).append(" al set al.estadoPrecio = :pEstArtLoc where al.id.codigoCompania = :pCodigoCompania and al.id.codigoArticulo = :pCodigoArticulo and al.id.codigoLocal = :pCodigoLocal ")
				.append("and al.estadoPrecio=:pFiltroEstado");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pEstArtLoc", nuevoEstado);
			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
			hqlQuery.setInteger("pCodigoLocal", codigoLocal);
			hqlQuery.setString("pFiltroEstado", filtroEstado);
			hqlQuery.executeUpdate();
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}
	}
	
	/**
	 * 
	 * @param alp
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<ArticuloLocalPrecioDTO> obtenerArticuloLocalPrecio(ArticuloLocalPrecioDTO alp) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("from ").append(ArticuloLocalPrecioDTO.class.getName()).append(" a where a.id.codigoCompania = :pCodigoCompania and a.id.codigoArticulo = :pCodigoArticulo and al.id.codigoLocal = :pCodigoLocal");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setInteger("pCodigoCompania", alp.getId().getCodigoCompania());
			hqlQuery.setString("pCodigoArticulo", alp.getId().getCodigoArticulo());
			hqlQuery.setInteger("pCodigoLocal", alp.getId().getCodigoLocal());
			return hqlQuery.list();
			
		}catch (Exception e) {
			LOG_SICV2.error("",e);
			throw new SICException(e);
		}
	}
	
	public void setHibernateH(IHibernateH<ArticuloLocalPrecioDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}

	@Override
	public Collection<ArticuloLocalPrecioDTO> obtenerArticulosLocalPrecio(Integer codigoCompania, Set<String> codigosArticulo, Set<Integer> codigosLocal) throws SICException {
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			Criteria cr = session.createCriteria(ArticuloLocalPrecioDTO.class, "alp");
				
			//where
			cr.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			cr.add(Restrictions.eq("estadoPrecio", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			cr.add(Restrictions.eq("id.codigoTipoPrecio", SICArticuloConstantes.TIPO_PRECIO_BASE));
			cr.add(Restrictions.in("id.codigoArticulo", codigosArticulo));
			cr.add(Restrictions.in("id.codigoLocal", codigosLocal));
			
			return cr.list();
		} catch (Exception e) {
			throw new SICException("Error al obtener los articulos local precios");
		}
	}

	@Override
	public void registrarArticuloLocalPrecio(ArticuloLocalPrecioDTO articuloLocalPrecio) throws SICException {
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			
			session.save(articuloLocalPrecio);
		} catch (Exception e) {
			throw new SICException("Error al registrar el articuloLocalPrecio");
		}
		
	}

	@Override
	public List<ArticuloPrecioDTO> obtenerDatosArticulosPreciosPorTiposPrecios(Integer codigoCompania,
			Set<String> codigosArticulo, Set<EnumTipoPrecio> tiposPrecios) throws SICException {

		Session session;
		List<String> tiposPrecio = new ArrayList<String>(0);

		try {

			session = hibernateH.getHibernateSession();
			session.clear();
			
			if (CollectionUtils.isNotEmpty(tiposPrecios)) {
				for (EnumTipoPrecio tipoPrecio : tiposPrecios) {
					tiposPrecio.add(tipoPrecio.getCodigoTipoPrecio());
				}				
			}

			Criteria cr = session.createCriteria(ArticuloPrecioDTO.class, "ap");
			//campos
			ProjectionList projections = Projections.projectionList();
			projections.add(Projections.property("ap.id.codigoArticulo"),"id_codigoArticulo");
			projections.add(Projections.property("ap.id.codigoTipoPrecio"),"id_codigoTipoPrecio");
			projections.add(Projections.property("ap.valorActual"),"valorActual");
			cr.setProjection(projections);

			//where
			cr.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			cr.add(Restrictions.eq("estadoPrecio", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			cr.add(Restrictions.in("id.codigoTipoPrecio", tiposPrecio));
			cr.add(Restrictions.in("id.codigoArticulo", codigosArticulo));
			cr.setResultTransformer( new MultiLevelResultTransformer(ArticuloPrecioDTO.class));

			return cr.list();

		} catch (Exception e) {
			throw new SICException("Error al obtener los articulos precios descuentos y recuperacion");
		}

	}
	
	@Override
	public void registrarPrecioArticuloPorTipoPrecio(Collection<ArticuloPrecioDTO> articulosPrecio) throws SICException{
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			if(CollectionUtils.isNotEmpty(articulosPrecio)){

				for (ArticuloPrecioDTO articuloPrecio : articulosPrecio) {
					try {
						if(BooleanUtils.isTrue(articuloPrecio.getIsNew())){
							articuloPrecio.setFechaCambioPrecio(new Timestamp(System.currentTimeMillis()));
							articuloPrecio.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
							session.save(articuloPrecio);
						} else {
							query = new StringBuilder();
							query.append("update ").append(ArticuloPrecioDTO.class.getName()).append(" ap set ap.valorAnterior = :pValorAnterior,")
							.append("ap.valorActual = :pValorActual, ap.idUsuarioModificacion = :pUserId, ap.fechaModificacion = :pFechaModificacion, ")
							.append("ap.fechaCambioPrecio = :pFechaCambioPrecio ")
							.append("where ap.id.codigoArticulo = :pCodigoArticulo ")
							.append("and ap.id.codigoCompania = :pCodigoCompania ")
							.append("and ap.id.codigoTipoPrecio = :pCodigoTipoPrecio");
							
							hqlQuery = session.createQuery(query.toString());
							hqlQuery.setInteger("pCodigoCompania", articuloPrecio.getId().getCodigoCompania());
							hqlQuery.setString("pCodigoArticulo", articuloPrecio.getId().getCodigoArticulo());
							hqlQuery.setString("pCodigoTipoPrecio", articuloPrecio.getId().getCodigoTipoPrecio());
							hqlQuery.setDouble("pValorAnterior", articuloPrecio.getValorAnterior());
							hqlQuery.setDouble("pValorActual", articuloPrecio.getValorActual());
							hqlQuery.setString("pUserId", articuloPrecio.getUserId());
							hqlQuery.setDate("pFechaModificacion", new Timestamp(System.currentTimeMillis()));
							hqlQuery.setDate("pFechaCambioPrecio", new Timestamp(System.currentTimeMillis()));
							hqlQuery.executeUpdate();
						}
						session.flush();
						articuloPrecio.setEjecutado(Boolean.TRUE);
					} catch (Exception e) {
						continue;
					}
				}
			}
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Ocurrio un ERROR al actualizar el precio del articulo ");
			throw new SICException(e);
		}
	}
}
