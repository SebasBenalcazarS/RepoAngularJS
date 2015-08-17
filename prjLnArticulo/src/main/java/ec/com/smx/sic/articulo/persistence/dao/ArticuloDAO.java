package ec.com.smx.sic.articulo.persistence.dao;

import static org.hibernate.criterion.Projections.groupProperty;

import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.JoinType;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.QueryException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.impl.CriteriaImpl;

import ec.com.kruger.utilitario.dao.commons.constants.BooleanClauseEnum;
import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.kruger.utilitario.dao.commons.exception.HibernateDAOException;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.MultiLevelResultTransformer;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.bodega.SICBodegaConstantes;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoGestionPrecio;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionRelacionadaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoVentaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.SegmentoCreacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloDAO;
import ec.com.smx.sic.cliente.resources.SICMessages;

public class ArticuloDAO implements Logeable, IArticuloDAO {
	private IHibernateH<SearchDTO> hibernateH;
	private final Boolean ACTIVAR_LIKE = Boolean.TRUE;
	private final Boolean BORRAR_CACHE = Boolean.TRUE;
	private SessionFactory sessionFactory;
	
	@Override
	public SearchResultDTO<ArticuloDTO> obtenerArticulosAgrupados(ArticuloVO articuloVO) throws SICException {
		return obtenerArticulosAgrupados(articuloVO, SICArticuloConstantes.MAXIMO_ARTICULOS_BUSQUEDA);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ClaseArticuloDTO> consultarClaseArticulos( Integer codigoCompania)throws SICException{
		try {
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ClaseArticuloDTO.class);
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoClaseArticulo"),"id.codigoClaseArticulo")
					.add(Projections.property("name"),"name")
					.add(Projections.property("status"),"status")
					);
			
			criteria.add(Restrictions.eq("status", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
//			criteria.add(Restrictions.ilike("id.codigoClaseArticulo", "R", MatchMode.EXACT));//eq("id.codigoClaseArticulo", "R"));
			criteria.addOrder(Order.asc("name"));
			
			criteria.setResultTransformer(new DtoResultTransformer(ClaseArticuloDTO.class));
			Collection<ClaseArticuloDTO> claseArticuloDTOCol = criteria.list();
			
			/*
			for(ClaseArticuloDTO claseArticuloDTO: claseArticuloDTOCol){
				Logeable.LOG_SICV2.info(""+claseArticuloDTO.getId().getCodigoCompania()+" - "+claseArticuloDTO.getId().getCodigoClaseArticulo()+" - "+claseArticuloDTO.getName()+" - "+claseArticuloDTO.getStatus());
			}
			*/
			
			return claseArticuloDTOCol;
			
		} catch (HibernateException e) {
			throw new SICException("Error consultarClaseArticulos: ",e);
		}catch (Exception e) {
			throw new SICException("Error consultarClaseArticulos ",e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<ArticuloDTO> buscarArticulosPersonalizado(ArticuloDTO articuloDTO) throws SICException{
		ArticuloVO articuloVO = new ArticuloVO();
		articuloVO.setBaseDTO(articuloDTO);
		Collection<ArticuloDTO> articuloDTOs = null;
		Criteria select;
		Session session;
		Boolean enableLike = Boolean.TRUE;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			select = hibernateH.getCriteriaQuery(articuloVO, BORRAR_CACHE, ACTIVAR_LIKE);
			hibernateH.addRelations(articuloDTO, select, enableLike);
			ProjectionList projections = Projections.projectionList()
						.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo")
						.add(Projections.property("id.codigoCompania"), "id.codigoCompania")
						.add(Projections.property("artBitCodBarCol.id.codigoBarras"), "codigoBarrasActivo.id.codigoBarras")
						.add(Projections.property("artBitCodBarCol.pendienteCodigoBarras"), "codigoBarrasActivo.pendienteCodigoBarras")
						.add(Projections.property("artBitCodBarCol.estadoArticuloBitacora"), "codigoBarrasActivo.estadoArticuloBitacora")
						.add(Projections.property("artBitCodBarCol.codigoTipoCodigoArticulo"), "codigoBarrasActivo.codigoTipoCodigoArticulo")
						.add(Projections.property("codigoClasificacion"), "codigoClasificacion")
						.add(Projections.property("codigoSubClasificacion"), "codigoSubClasificacion")
						.add(Projections.property("descripcionArticulo"), "descripcionArticulo")
						.add(Projections.property("aplicaRegistroSanitario"), "aplicaRegistroSanitario")
						.add(Projections.property("codigoEstado"), "codigoEstado")
						.add(Projections.property("estadoArticulo"), "estadoArticulo")
						.add(Projections.property("articuloMedidaDTO.cantidadMedida"), "articuloMedidaDTO.cantidadMedida")
						.add(Projections.property("articuloMedidaDTO.valorTipoMedida"), "articuloMedidaDTO.valorTipoMedida")
						.add(Projections.property("claseArticulo"), "claseArticulo")
						.add(Projections.property("articuloComercialDTOmarcaComercialArticulo.nombre"), "articuloComercialDTO.marcaComercialArticulo.nombre")
						.add(Projections.property("articuloComercialDTO.marcaParticipaciones"), "articuloComercialDTO.marcaParticipaciones")
						.add(Projections.property("clasificacionDTO.descripcionClasificacion"), "clasificacionDTO.descripcionClasificacion")
						.add(Projections.property("subClasificacionDTO.descripcionSubClasificacion"), "subClasificacionDTO.descripcionSubClasificacion")
						.add(Projections.property("clasificacionDTObodegaDTO.descripcionBodega"), "clasificacionDTO.bodegaDTO.descripcionBodega")
						.add(Projections.property("grupoAlcanceDTO.codigoReferencia"), "grupoAlcanceDTO.codigoReferencia")
						;
			
			select.setProjection(Projections.distinct(projections));
			select.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			articuloDTOs = 	hibernateH.list(articuloVO.getBaseDTO(),select);
			return articuloDTOs;
		} catch (SICException e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException(e);
		}finally{
			articuloVO = null;
			select = null;
			session = null;			
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public SearchResultDTO<ArticuloDTO> obtenerArticulosAgrupados(ArticuloVO articuloVO, Integer maximoArticulos) throws SICException {
		SearchResultDTO<ArticuloDTO> resultDTO = new SearchResultDTO<ArticuloDTO>();
		Criteria select;
		Session session;
		Boolean enableLike = Boolean.TRUE;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			select = hibernateH.getCriteriaQuery(articuloVO, BORRAR_CACHE, ACTIVAR_LIKE);
			Criteria criteriaRowcount = select;

			hibernateH.addRelations(articuloVO, select, enableLike);
			if (articuloVO.getIsPaginable()) {
				if (articuloVO.getCountAgain()) {
					CriteriaImpl criteriaImpl = (CriteriaImpl) criteriaRowcount;
					List<Object> orderClauses = new ArrayList<Object>();
					// almacenar temporalmente los criterios de ordenacion
					Iterator<?> orderings = criteriaImpl.iterateOrderings();
					while (orderings.hasNext()) {
						Order ordering = ((CriteriaImpl.OrderEntry) orderings.next()).getOrder();
						orderings.remove();
						orderClauses.add(ordering);
					}

					criteriaRowcount.setProjection(Projections.countDistinct("id.codigoArticulo"));
					resultDTO.setCountResults((Long) hibernateH.uniqueResult(articuloVO.getBaseDTO(),criteriaRowcount));
					// establecer los criterios de ordenacion originales
					orderings = orderClauses.iterator();
					while (orderings.hasNext()) {
						criteriaRowcount.addOrder((Order) orderings.next());
					}
					if (resultDTO.getCountResults() > (maximoArticulos == null ? SICArticuloConstantes.MAXIMO_ARTICULOS_BUSQUEDA : maximoArticulos)) {
						throw new SICException("01", SICMessages.getInstancia().getString("mensaje.articulo.alcance.asignacion.valormaximo"));
					}
				}

				if (articuloVO.getFirstResult() != null) {
					select.setFirstResult(articuloVO.getFirstResult());
				}
				if (articuloVO.getMaxResults() != null) {
					select.setMaxResults(articuloVO.getMaxResults());
				}
				ProjectionList projections = Projections.projectionList()
						.add(Projections.property("id.codigoCompania"), "id.codigoCompania")
						.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo");

				// Relaciones por necesidad en el ordenamiento
				OrderBy orden = articuloVO.getOrderByField() != null ? articuloVO.getOrderByField() : (articuloVO.getBaseDTO().getOrderByField() != null ? articuloVO.getBaseDTO().getOrderByField() : null);
				
				
				if (orden != null) {
					if (StringUtils.contains(orden.getSecuenceOrderClause(), "codigoBarras")) {
						projections.add(Projections.property("codigoBarras"), "codigoBarras");
					}
					if (StringUtils.contains(orden.getSecuenceOrderClause(), "descripcionArticulo")) {
						projections.add(Projections.property("descripcionArticulo"), "descripcionArticulo");
					}
					if (StringUtils.contains(orden.getSecuenceOrderClause(), "codigoClasificacion")) {
						projections.add(Projections.property("codigoClasificacion"), "codigoClasificacion");
					}
					if (StringUtils.contains(orden.getSecuenceOrderClause(), "codigoSubClasificacion")) {
						projections.add(Projections.property("codigoSubClasificacion"), "codigoSubClasificacion");
					}
					if (StringUtils.contains(orden.getSecuenceOrderClause(), "clasificacionDTO.descripcionClasificacion")) {
						projections.add(Projections.property("clasificacionDTO.descripcionClasificacion"), "clasificacionDTO.descripcionClasificacion");
					}
					if (StringUtils.contains(orden.getSecuenceOrderClause(), "subClasificacionDTO.descripcionSubClasificacion")) {
						projections.add(Projections.property("subClasificacionDTO.descripcionSubClasificacion"), "subClasificacionDTO.descripcionSubClasificacion");
					}
					if (StringUtils.contains(orden.getSecuenceOrderClause(), "articuloMedidaDTO.referenciaMedida")) {
						projections.add(Projections.property("articuloMedidaDTO.referenciaMedida"), "articuloMedidaDTO.referenciaMedida");
					}
				}

				select.setProjection(Projections.distinct(projections));
				hibernateH.paginarDatos(select, articuloVO);
			}
			select.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			resultDTO.setResults(hibernateH.list(articuloVO.getBaseDTO(),select));
			if (resultDTO.getCountResults() == null || resultDTO.getCountResults() == 0L) {
				resultDTO.setCountResults(Long.valueOf(resultDTO.getResults().size()));
			}
			return resultDTO;
		} catch (SICException e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException("Ha ocurrido un error al consultar art\u00EDculos", e);
		}

	}
	
	@Override
	public int cambiarEstadoArticulo(Collection<ArticuloDTO> articuloDTOCol, String estado, UserDto userDto) {

		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("update ").append(ArticuloDTO.class.getName()).append(" a set a.estadoArticulo = :pEstadoArticulo, usuarioActualizacion = :pUserAuditId, fechaUltimaActualizacion = :pDate where a.id.codigoCompania=:pCompania and a.id.codigoArticulo in ").append("(:pCodArticulos) ");
			Query update = session.createQuery(query.toString());
			update.setString("pEstadoArticulo", estado);
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
			update.setString("pUserAuditId", userDto.getUserId());
			update.setInteger("pCompania", articuloDTOCol.iterator().next().getId().getCodigoCompania());
			Collection<String> articuloIDList = new ArrayList<String>();
			for (ArticuloDTO articuloDTO : articuloDTOCol) {
				articuloIDList.add(articuloDTO.getId().getCodigoArticulo());
			}
			update.setParameterList("pCodArticulos", articuloIDList);
			return update.executeUpdate();
		} catch (Exception e) {
			throw new SICException("Error al cambiar de estado en los articulos", e);
		}
	}

	@Override
	public void actualizarAplicaRegistroSanitario(String userId, String codigoClasificacion) throws SICException {

		StringBuilder query = new StringBuilder();
		Session session;

		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("update ").append(ArticuloDTO.class.getName()).append(" a set a.aplicaRegistroSanitario = :pAplicaRegistroSanitario, a.usuarioActualizacion = :pUserAuditId, a.fechaUltimaActualizacion = :pDate  where a.codigoClasificacion = :pCodigoClasificacion and a.aplicaRegistroSanitario = '0'");
			Query update = session.createQuery(query.toString());
			update.setBoolean("pAplicaRegistroSanitario", Boolean.TRUE);
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
			update.setString("pUserAuditId", userId);

			update.setParameter("pAplicaRegistroSanitario", Boolean.FALSE);
			update.setParameter("pCodigoClasificacion", codigoClasificacion);
			update.executeUpdate();
		} catch (Exception e) {
			throw new SICException("Error al cambiar aplicaRegistroSanitario", e);
		}
	}
	
	@Override
	public void actualizarAplicaRegistroSanitario(String userId, String codigoClasificacion, Integer codigoAplicaRegistroSanitario, String valorAplicaRegistroSanitario) throws SICException {

		StringBuilder query = new StringBuilder();
		Session session;

		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("update ").append(ArticuloDTO.class.getName())
			.append(" a set a.valorAplicaRegistroSanitario = :pValorAplicaRegistroSanitario," +
					"a.codigoAplicaRegistroSanitario = :pCodigoAplicaRegistroSanitario," +
					"a.usuarioActualizacion = :pUserAuditId," +
					"a.fechaUltimaActualizacion = :pDate " +
					"where a.codigoClasificacion = :pCodigoClasificacion " +
					"and a.valorAplicaRegistroSanitario != :pValorAplicaRegistroSanitario " +
					"and a.estadoArticulo = :pEstadoArticulo");
			Query update = session.createQuery(query.toString());//param
			//Parametros para el set
			
			update.setString("pValorAplicaRegistroSanitario", valorAplicaRegistroSanitario);
			update.setInteger("pCodigoAplicaRegistroSanitario", codigoAplicaRegistroSanitario);
			update.setString("pUserAuditId", userId);
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
			update.setParameter("pCodigoClasificacion", codigoClasificacion);
			update.setString("pEstadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			update.executeUpdate();
		} catch (Exception e) {
			throw new SICException("Error al cambiar aplicaRegistroSanitario", e);
		}
	}
	

	@Override
	public int cambiarEstadoArticuloProveeedor(Collection<ArticuloProveedorDTO> articuloProveedorDTOCol, String estado, UserDto userDto) {

		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("update ").append(ArticuloProveedorDTO.class.getName()).append(" ap set ap.estadoArticuloProveedor = :pEstadoArticuloProveedor, ap.idUsuarioModificacion = :pUserAuditId, ap.fechaModificacion = :pDate where ap.id.codigoArticulo in ").append("(:pCodArticulosProveedor) and ap.id.codigoCompania = :pCompania and ap.id.codigoProveedor = :pCodigoProveedor");
			Query update = session.createQuery(query.toString());
			update.setString("pEstadoArticuloProveedor", estado);
			update.setTimestamp("pDate", new Timestamp(System.currentTimeMillis()));
			update.setString("pUserAuditId", userDto.getUserId());
			ArticuloProveedorDTO articuloProveedorDTO = articuloProveedorDTOCol.iterator().next();
			update.setInteger("pCompania", articuloProveedorDTO.getId().getCodigoCompania());
			Collection<String> articuloIDList = new ArrayList<String>();
			for (ArticuloProveedorDTO aproveedorDTO : articuloProveedorDTOCol) {
				articuloIDList.add(aproveedorDTO.getId().getCodigoArticulo());
			}
			update.setParameterList("pCodArticulosProveedor", articuloIDList);
			update.setString("pCodigoProveedor", articuloProveedorDTO.getId().getCodigoProveedor());
			return update.executeUpdate();
		} catch (Exception e) {
			throw new SICException("Error al cambiar de estado en los articulos-proveedor", e);
		}
	}

	/**
	 * Obtiene la lista de artículos que no están en promoción
	 * 
	 * @param articuloDTO
	 *            el/los par&aacute;metros de consulta
	 * @return la informaci&oacute;n solicitada
	 * @throws SICException
	 *             en caso de error al ejecutar el m&eacute;todo
	 */
	@Override
	public SearchResultDTO<ArticuloDTO> obtenerArticulosSinPromocionPorLocal(ArticuloDTO articuloDTO) throws SICException {

		SearchResultDTO<ArticuloDTO> articuloDTOResult = new SearchResultDTO<ArticuloDTO>();

		// Obtener la lista de articulos
		Collection<ArticuloDTO> articuloDTOCol = obtenerArticulos(articuloDTO);
		articuloDTOResult.setResults(articuloDTOCol);

		// Obtener el tamano de la consulta
		articuloDTOResult.setCountResults(0L);

		// si existen resultados de la consulta, contar el total de registros
		if (articuloDTOCol != null && !articuloDTOCol.isEmpty()) {
			articuloDTOResult.setCountResults(obtenerTotalArticulos(articuloDTO).longValue());
		}

		return articuloDTOResult;
	}

	private Long obtenerTotalArticulos(ArticuloDTO articuloDTO) throws SICException {
		try {
			Criteria criteria = crearCriterio(articuloDTO);
			criteria.setProjection(Projections.rowCount());
			return (Long) criteria.uniqueResult();
		} catch (Exception e) {
			throw new SICException(e);
		}
	}

	@SuppressWarnings("unchecked")
	private Collection<ArticuloDTO> obtenerArticulos(ArticuloDTO articuloDTO) throws SICException {
		Collection<ArticuloDTO> articulos = null;

		try {
			Criteria criteria = crearCriterio(articuloDTO);

			if (articuloDTO.getFirstResult() != null && articuloDTO.getMaxResults() != null) {
				criteria.setFirstResult(articuloDTO.getFirstResult());
				criteria.setMaxResults(articuloDTO.getMaxResults());
			}

			criteria.addOrder(Order.asc("id.codigoArticulo"));
			articulos = criteria.list();

		} catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException(e);
		}
		return articulos;
	}
	
	public Integer buscarCantidadArticulosEdicionInterna(String sqlQuery)throws SICException{
		try {
			String sqlBuild = StringUtils.replace(sqlQuery, "ART.CODIGOBARRAS AS {vista.codigoBarras} , ART.CODIGOARTICULO AS {vista.codigoArticulo}", "ART.CODIGOBARRAS , ART.CODIGOARTICULO");
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(" SELECT COUNT(1) FROM (");
			stringBuilder.append(sqlBuild);
			stringBuilder.append(") AS TMP");
			Session session;
			session = hibernateH.getHibernateSession();
			session.clear();
			Query query = session.createSQLQuery(stringBuilder.toString());
			Object cantObject=  query.uniqueResult();
			Integer numeroArticulos = Integer.parseInt(cantObject.toString());
			session.flush();
			return numeroArticulos;
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * obtiene los articulos encontrados en la edicion masiva, segun el criterio de busqueda
	 */
	@SuppressWarnings("unchecked")
	public Collection<ArticuloEdicionMasivaVO> obtenerArticulosEdicion(ArticuloVO articuloVO , Criterion criterion)throws SICException {
		Collection<ArticuloEdicionMasivaVO> articulos= new ArrayList<ArticuloEdicionMasivaVO>();
		try {
			Criteria criteria = null;
			criteria = crearCriterioEdicion(articuloVO,criterion,Boolean.FALSE);
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloEdicionMasivaVO.class));
			articulos = criteria.list();
		} catch (Exception e) {
			throw new SICException(e);
		}
		return articulos;
	}
	
	/**
	 * obtiene la cantidad de articulos encontrados en la edicion masiva
	 */
	public Long obtenerCantidadArticulosEdicion(ArticuloVO articuloVO , Criterion criterion)throws SICException {
		Long cantidadBusqueda = 0L;
		try {
			Criteria criteria = crearCriterioEdicion(articuloVO,criterion,Boolean.TRUE);

			cantidadBusqueda  = (Long) criteria.uniqueResult();
			
		} catch (Exception e) {
			throw new SICException(e);
		}
		return cantidadBusqueda;
	}
	
	
	/**
	 * crea el criterio de busqueda, en base a los filtros de busqueda en la edicion masiva
	 * @param articuloVO
	 * @param criterion
	 * @param findCount
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private Criteria crearCriterioEdicion(ArticuloVO articuloVO , Criterion criterion , Boolean findCount) throws Exception {

		hibernateH.getHibernateSession().clear();
		Criteria criteria = hibernateH.getHibernateSession().createCriteria(ArticuloDTO.class).add(Restrictions.eq("id.codigoCompania", articuloVO.getBaseDTO().getId().getCodigoCompania()));
		Criterion criterioCaracteristicaEspecial = null;
		//true = comparador caracteristica especial and
		//false = comparador caracteristica especial or
		Boolean comparatorCaracteristicaEspecial = Boolean.TRUE;
		ProjectionList proList = Projections.projectionList();
		if(findCount){
			proList.add(Projections.rowCount());
		}
		else{
			proList.add(Projections.property("id.codigoCompania"),("codigoCompania"));
			proList.add(Projections.property("id.codigoArticulo"),("codigoArticulo"));
			proList.add(Projections.property("descripcionArticulo"),("descripcion"));
			proList.add(Projections.property("codigoBarras"), "codigoBarrasArticulo");
			proList.add(Projections.property("claseArticulo"), "codigoClase");
			proList.add(Projections.property("claseArticulo"), "claseArticuloAnterior");
	        proList.add(Projections.property("codigoClasificacion"),("clasificacion"));
	        proList.add(Projections.property("codigoSubClasificacion"),("subClasificacion"));
	        proList.add(Projections.property("codigoGrupoAlcance"),("codigoPrototipoAlcance"));
	        proList.add(Projections.property("articuloProveedorCol.id.codigoProveedor"), "codigoProveedor");
	        proList.add(Projections.property("articuloProveedorCol.codigoReferenciaProveedor"), "referenciaExterna");
	        proList.add(Projections.property("articuloProveedorCol.codigoReferenciaInterna"), "referenciaInterna");
	        proList.add(Projections.property("articuloProveedorColproveedor.origenProveedor"), "origenProveedor");
	        proList.add(Projections.property("articuloProveedorColproveedorproveedorImportado.esImportador"), "esImportador");
	        proList.add(Projections.property("articuloImpuestoCol.esParaVenta"), "esParaVenta");
	        proList.add(Projections.property("articuloImpuestoCol.esParaCompra"), "esParaCompra");
	        proList.add(Projections.property("articuloImpuestoCol.id.codigoTipoImpuesto"), "codigoTipoImpuesto");
//	        proList.add(Projections.property("articuloImpuestoColtipoImpuestoArticulo.codigoGrupoImpuesto"), "codigoGrupoImpuesto");
	        proList.add(Projections.property("articuloClaseDTO.secuencialArtCla"), "secuencialArtCla");
	        proList.add(Projections.property("articuloClaseDTO.codigoTipoCausal"), "codigoTipoCausal");
			proList.add(Projections.property("articuloClaseDTO.valorTipoCausal"), "valorTipoCausal");
			proList.add(Projections.property("articuloClaseDTOtipoCausal.nombreCatalogoValor"), "causal");
		}
		
		// estado articulo
		criteria.add(Restrictions.eq("estadoArticulo", articuloVO.getBaseDTO().getEstadoArticulo()));
		// estado articulo
		criteria.add(Restrictions.eq("codigoEstado", articuloVO.getBaseDTO().getCodigoEstado()));
		// estado articulo
		criteria.add(Restrictions.ne("codigoTipoArticulo", articuloVO.getBaseDTO().getCodigoTipoArticulo()));
		// estado articulo
		criteria.add(Restrictions.isNotNull("codigoBarras"));
		// estado articulo
		criteria.add(Restrictions.eq("articuloProveedorCol.estadoArticuloProveedor", articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getEstadoArticuloProveedor()));
		
		// relacion con agrupador
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloAgrupador")) 
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroCaracteristicaEspecial"))){
			
			//consultamos los agrupadores 311 a nivel de where
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroCaracteristicaEspecial"))){
				//obtengo los valores del criterio de busqueda
				CriteriaSearchParameter<String []> criteriaSearchParameter = (CriteriaSearchParameter<String []>) articuloVO.getDynamicProperty("restriccionCaracteristicaEspecial");
				String [] parametrosValor = (String[]) criteriaSearchParameter.getParameterValues();
				//armo el subselect
				DetachedCriteria subselect = DetachedCriteria.forClass(ArticuloAgrupadorDTO.class);
				subselect.setProjection(Projections.property("id.codigoArticulo"));		
				subselect.add(Restrictions.eq("id.codigoTipoAgrupador", TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES));
				subselect.add(Restrictions.eq("estado", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				subselect.add(Restrictions.in("id.valorTipoAgrupador", parametrosValor));
				//creo la consulta del agrupador
				criteria.createAlias("articuloAgrupadorCol", "articuloAgrupadorCol",JoinType.LEFT.ordinal(),
				Restrictions.and(Restrictions.eq("articuloAgrupadorCol.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), Restrictions.in("articuloAgrupadorCol.id.codigoTipoAgrupador", new Integer []{SICArticuloConstantes.getInstancia().CATALOGOTIPO_AGRUPADOR,TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES})) );
				criteria.createCriteria("articuloAgrupadorCol.tipoAgrupador", "articuloAgrupadortipoAgrupador",JoinType.LEFT.ordinal());
				
				criterioCaracteristicaEspecial = Subqueries.propertyIn("id.codigoArticulo", subselect);
				if(criteriaSearchParameter.getBooleanClauseEnum().equals(BooleanClauseEnum.OR)) comparatorCaracteristicaEspecial = Boolean.FALSE;
				
			}else{
				//consultamos los agrupadores 311 y 240 a nivel de join
				criteria.createAlias("articuloAgrupadorCol", "articuloAgrupadorCol",JoinType.LEFT.ordinal(),
				Restrictions.and(Restrictions.eq("articuloAgrupadorCol.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), Restrictions.in("articuloAgrupadorCol.id.codigoTipoAgrupador", new Integer []{SICArticuloConstantes.getInstancia().CATALOGOTIPO_AGRUPADOR,TipoCatalogoArticulo.TIPO_MARCAS_ESPECIALES})) );
				criteria.createCriteria("articuloAgrupadorCol.tipoAgrupador", "articuloAgrupadortipoAgrupador",JoinType.LEFT.ordinal());
			}
			
			if(!findCount){
				proList.add(Projections.property("articuloAgrupadorCol.id.codigoTipoAgrupador"), "codigoTipoAgrupador");
				proList.add(Projections.property("articuloAgrupadorCol.id.valorTipoAgrupador"), "valorTipoAgrupador");
				proList.add(Projections.property("articuloAgrupadortipoAgrupador.nombreCatalogoValor"), "agrupador");
			}
		}
		// relacion con articulo clase
		criteria.createAlias("articuloClaseDTO", "articuloClaseDTO",JoinType.LEFT.ordinal());
		criteria.createAlias("articuloClaseDTO.tipoCausal", "articuloClaseDTOtipoCausal",JoinType.LEFT.ordinal());
			
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroMarcaComercial"))
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroPaisOrigen"))
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroFechaCaducidad"))
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroMarcaParticipacion"))
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloControlPrecio"))
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroLugarCompra"))){
			criteria.createAlias("articuloComercialDTO", "articuloComercialDTO",JoinType.LEFT.ordinal());
			if(!findCount && BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroMarcaParticipacion"))){
				proList.add(Projections.property("articuloComercialDTO.marcaParticipaciones"), "marcaParticipacion");
			}
			if(!findCount && BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroFechaCaducidad"))){
				proList.add(Projections.property("articuloComercialDTO.verFecCadRec"), "verificaFechaCaducidad");
			}
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroMarcaComercial"))){
				criteria.createAlias("articuloComercialDTO.marcaComercialArticulo", "articuloComercialDTOmarcaComercialArticulo",JoinType.LEFT.ordinal());
				if(!findCount){
					proList.add(Projections.property("articuloComercialDTOmarcaComercialArticulo.nombre"), "marcaComercial");
				}
				if(!findCount){
					proList.add(Projections.property("articuloComercialDTO.codigoMarcaComercial"), "codigoMarcaComercial");
				}
			}
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroPaisOrigen"))){
				criteria.createAlias("articuloComercialDTO.paisOrigen", "articuloComercialDTOpaisOrigen",JoinType.LEFT.ordinal());
				if(!findCount){
					proList.add(Projections.property("articuloComercialDTOpaisOrigen.nombreDivGeoPol"), "paisOrigen");
					proList.add(Projections.property("articuloComercialDTO.codigoPaisOrigen"), "codigoPaisOrigen");
				}
			}
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloControlPrecio"))){
				criteria.createAlias("articuloComercialDTO.tipoControlCosto", "articuloComercialDTOtipoControlCosto",JoinType.LEFT.ordinal());
				if(!findCount){
					proList.add(Projections.property("articuloComercialDTOtipoControlCosto.nombreCatalogoValor"), "tipoControlPrecio");					
				}
				if(!findCount){
					proList.add(Projections.property("articuloComercialDTO.valorTipoControlCosto"), "codigoTipoControlPrecio");					
				}
			}
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroLugarCompra"))){
				criteria.createAlias("articuloComercialDTO.ubicacionTransaccionDivisionGeoPoliticaDTO", "articuloComercialLugarCompra",JoinType.LEFT.ordinal());
				if(!findCount){
					proList.add(Projections.property("articuloComercialLugarCompra.nombre"), "lugarCompra");
					proList.add(Projections.property("articuloComercialDTO.codigoLugarCompra"), "codigoLugarCompra");
				}
			}			
		}
		
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloVidaUtil"))
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoRefrigeracion"))
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoCongelacion"))){
			
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloVidaUtil"))
				&& BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoRefrigeracion"))
				&& BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoCongelacion"))){
				criteria.createAlias("articuloDuracionConservacionCol", "articuloDuracionConservacionCol",JoinType.LEFT.ordinal(), 
						Restrictions.and(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), 
						Restrictions.and(Restrictions.eq("id.codigoTipoConservacion", SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),
						Restrictions.eq("id.valorTipoConservacion", SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL)) ));
			}
			if(BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloVidaUtil"))
				&& BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoRefrigeracion"))
				&& BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoCongelacion"))){
				criteria.createAlias("articuloDuracionConservacionCol", "articuloDuracionConservacionCol",JoinType.LEFT.ordinal(), 
						Restrictions.and(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), 
						Restrictions.and(Restrictions.eq("id.codigoTipoConservacion", SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),
						Restrictions.eq("id.valorTipoConservacion", SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO)) ));
			}
			if(BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloVidaUtil"))
				&& BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoRefrigeracion"))
				&& BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoCongelacion"))){
				criteria.createAlias("articuloDuracionConservacionCol", "articuloDuracionConservacionCol",JoinType.LEFT.ordinal(), 
						Restrictions.and(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), 
						Restrictions.and(Restrictions.eq("id.codigoTipoConservacion", SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),
						Restrictions.eq("id.valorTipoConservacion", SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO))) );
			}
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloVidaUtil"))
				&& BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoRefrigeracion"))
				&& BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoCongelacion"))){
				criteria.createAlias("articuloDuracionConservacionCol", "articuloDuracionConservacionCol",JoinType.LEFT.ordinal(), 
						Restrictions.and(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), 
						Restrictions.and(Restrictions.eq("id.codigoTipoConservacion", SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),
						Restrictions.in("id.valorTipoConservacion", new String []{SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL,SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO})) ));
			}
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloVidaUtil"))
				&& BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoRefrigeracion"))
				&& BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoCongelacion"))){
				criteria.createAlias("articuloDuracionConservacionCol", "articuloDuracionConservacionCol",JoinType.LEFT.ordinal(), 
						Restrictions.and(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), 
						Restrictions.and(Restrictions.eq("id.codigoTipoConservacion", SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),
						Restrictions.in("id.valorTipoConservacion", new String []{SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL,SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO})) ));
			}
			if(BooleanUtils.isNotTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloVidaUtil"))
				&& BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoRefrigeracion"))
				&& BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoCongelacion"))){
				criteria.createAlias("articuloDuracionConservacionCol", "articuloDuracionConservacionCol",JoinType.LEFT.ordinal(), 
						Restrictions.and(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), 
						Restrictions.and(Restrictions.eq("id.codigoTipoConservacion", SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),
						Restrictions.in("id.valorTipoConservacion", new String []{SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO,SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO})) ));
			}
			if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloVidaUtil"))
				&& BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoRefrigeracion"))
				&& BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTiempoCongelacion"))){
				criteria.createAlias("articuloDuracionConservacionCol", "articuloDuracionConservacionCol",JoinType.LEFT.ordinal(),
						Restrictions.and(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO), 
						Restrictions.and(Restrictions.eq("id.codigoTipoConservacion", SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION),		
						Restrictions.in("id.valorTipoConservacion", new String []{SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONLOCAL,SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONCONGELADO,SICArticuloConstantes.getInstancia().VALORARTICULOCONSERVACIONREFRIGERADO})) ));
			}
			if(!findCount){
				proList.add(Projections.property("articuloDuracionConservacionCol.diasVidaUtil"), "tiempoDuracionConservacion");
				proList.add(Projections.property("articuloDuracionConservacionCol.id.codigoTipoConservacion"), "codigoTipoConservacion");
				proList.add(Projections.property("articuloDuracionConservacionCol.id.valorTipoConservacion"), "valorTipoConservacion");
			}
		}
		// relacion con impuesto
		criteria.createAlias("articuloImpuestoCol", "articuloImpuestoCol",JoinType.LEFT.ordinal(), Restrictions.eq("articuloImpuestoCol.estadoArticuloImpuesto", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
		criteria.createAlias("articuloImpuestoCol.tipoImpuestoArticulo", "articuloImpuestoColtipoImpuestoArticulo",JoinType.LEFT.ordinal(), Restrictions.eq("articuloImpuestoColtipoImpuestoArticulo.estadoTipoImpuesto", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
				
		// relacion con material
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloMaterial"))){
			criteria.createAlias("articuloMaterialDTOs", "articuloMaterialDTOs",JoinType.LEFT.ordinal(),Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			if(!findCount){
				proList.add(Projections.property("articuloMaterialDTOs.observacion"), "material");
			}
		}
		// relacion con medida
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTamanio"))){
			criteria.createAlias("articuloMedidaDTO", "articuloMedidaDTO",JoinType.LEFT.ordinal());
			if(!findCount){
				proList.add(Projections.property("articuloMedidaDTO.referenciaMedida"), "tamanio");
			}
		}
		//relacion con proveedor
		criteria.createAlias("articuloProveedorCol", "articuloProveedorCol",JoinType.LEFT.ordinal());
		criteria.createAlias("articuloProveedorCol.proveedor", "articuloProveedorColproveedor",JoinType.LEFT.ordinal());
		criteria.createAlias("articuloProveedorColproveedor.proveedorImportado", "articuloProveedorColproveedorproveedorImportado",JoinType.LEFT.ordinal());
		
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloMonedaOrigen"))
				|| BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloPorcentajeComision"))){
			criteria.createAlias("articuloProveedorCol.articuloImportacion", "articuloProveedorarticuloImportacion",JoinType.LEFT.ordinal());
			if(!findCount && BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloMonedaOrigen"))){
				proList.add(Projections.property("articuloProveedorarticuloImportacion.costoMonedaOrigen"), "costoMonedaOrigen");
			}
			if(!findCount && BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloPorcentajeComision"))){
				proList.add(Projections.property("articuloProveedorarticuloImportacion.porcentajeComision"), "porcentajeComision");
			}
		}
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroProveedor"))){
			criteria.createAlias("articuloProveedorCol.vistaProveedor", "articuloProveedorColvistaProveedor",JoinType.LEFT.ordinal());
		}
		// relacion con temporada
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroArticuloTemporada"))){
			criteria.createAlias("articuloTemporadaDTO", "articuloTemporadaDTO",JoinType.LEFT.ordinal());
			criteria.createAlias("claseArticuloDTO", "claseArticuloDTO",JoinType.LEFT.ordinal());
			if(!findCount){
				proList.add(Projections.property("articuloTemporadaDTO.fechaInicioTemporada"), "fechaInicialTemporada");
				proList.add(Projections.property("articuloTemporadaDTO.fechaFinTemporada"), "fechaFinalTemporada");
				proList.add(Projections.property("claseArticuloDTO.name"), "clase");
			}
		}
		
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroClasificacion"))){
			criteria.createAlias("clasificacionDTO", "clasificacionDTO",JoinType.LEFT.ordinal());
			criteria.createAlias("clasificacionDTO.clasificacionPadre", "clasificacionDTOclasificacionPadre",JoinType.LEFT.ordinal());
		}
		
		if(BooleanUtils.isTrue((Boolean)articuloVO.getDynamicProperty("filtroPrototipo"))){
			criteria.createAlias("grupoAlcanceDTO", "grupoAlcanceDTO",JoinType.LEFT.ordinal());
			if(!findCount){
				proList.add(Projections.property("grupoAlcanceDTO.nombreGrupoTrabajo"), "prototipoAlcance");
			}
		}
		
		//validamos el numero de restricciones en la busqueda, dependiendo de esto aplicamos el comparador or en caso que haya
		//esta condicion se valida solo cuando existe filtro de caracteristica especial
		if(criterioCaracteristicaEspecial != null){
			Integer contadorRestricciones = (Integer) articuloVO.getDynamicProperty("contadorRestricciones");
			if(contadorRestricciones > 1 && !comparatorCaracteristicaEspecial){
				criteria.add(Restrictions.or(criterion, criterioCaracteristicaEspecial));
			}else{
				criteria.add(Restrictions.and(criterion, criterioCaracteristicaEspecial));
			}
		}else{
			criteria.add(criterion);
		}
		
		criteria.setProjection(proList);
		
		return criteria;
	}
	
	private Criteria crearCriterio(ArticuloDTO articuloDTO) throws Exception {

		hibernateH.getHibernateSession().clear();
		Example articuloExample = Example.create(articuloDTO);

		Criteria criteria = hibernateH.getHibernateSession().createCriteria(ArticuloDTO.class).add(Restrictions.eq("id.codigoCompania", articuloDTO.getId().getCodigoCompania()));

		// estado articulo
		if (articuloDTO.getEstadoArticulo() != null && !articuloDTO.getEstadoArticulo().equals("")) {
			criteria.add(Restrictions.eq("estadoArticulo", articuloDTO.getEstadoArticulo()));
		}

		// Clasificaciones
		if (articuloDTO.getNpClasificaciones() != null && !articuloDTO.getNpClasificaciones().isEmpty()) {
			criteria.add(Restrictions.in("codigoClasificacion", articuloDTO.getNpClasificaciones()));
		}

		// TRAER LA RELACION CON CLASIFICACION
		criteria.createAlias("clasificacionDTO", "clasificacion", CriteriaSpecification.LEFT_JOIN);

		// CONDICION MODIFICADA POR EL NUEVO MODELO
		if (articuloDTO.getArticuloLocalCol() != null && !articuloDTO.getArticuloLocalCol().isEmpty()) {
			ArticuloLocalDTO articuloLocalDTO = articuloDTO.getArticuloLocalCol().iterator().next();

			DetachedCriteria subQuery = DetachedCriteria.forClass(ArticuloLocalPrecioDTO.class);
			subQuery.setProjection(Projections.property("id.codigoArticulo"));
			subQuery.createAlias("articuloPrecio", "ap");
			subQuery.add(Restrictions.eq("id.codigoLocal", articuloLocalDTO.getId().getCodigoLocal()));
			subQuery.add(Restrictions.eq("id.codigoTipoPrecio", SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE));
			subQuery.add(Restrictions.eq("estadoPrecio", articuloLocalDTO.getEstadoArticuloLocal()));
			subQuery.add(Restrictions.ne("ap.valorActual", 0D));

			criteria.add(Subqueries.propertyNotIn("id.codigoArticulo", subQuery));
		}

		criteria.add(articuloExample);

		return criteria;
	}

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param estado
	 *            - valor del campe estado
	 * @param campoEstado
	 *            - Nombre del campo que hace referencia al estado
	 * @param clase
	 *            - Clase de la entidad que se desea actualizar
	 */
	@Override
	public void actualizarEstadoRelacion(Integer codigoCompania, String codigoArticulo, String campoArticulo, String nuevoEstado, String campoEstado, Class<? extends SearchDTO> clase) throws SICException {
		Session session;
		StringBuilder query;
		Query hqlQuery;
		try {
			String filtroEstado = SICConstantes.ESTADO_ACTIVO_NUMERICO;
			if (nuevoEstado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)) {
				filtroEstado = SICConstantes.ESTADO_INACTIVO_NUMERICO;
			} else if (nuevoEstado.equals(SICConstantes.ESTADO_ACTIVO_LITERAL)) {
				filtroEstado = SICConstantes.ESTADO_INACTIVO_LITERAL;
			} else if (nuevoEstado.equals(SICConstantes.ESTADO_INACTIVO_LITERAL)) {
				filtroEstado = SICConstantes.ESTADO_ACTIVO_LITERAL;
			}

			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ").append(clase.getName()).append(" rel set rel.").append(campoEstado).append("= :pEstado where rel.id.codigoCompania = :pCodigoCompania and rel.").append(campoArticulo).append("= :pCodigoArticulo and rel.").append(campoEstado).append("=:pFiltroEstado");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pEstado", nuevoEstado);
			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
			hqlQuery.setString("pFiltroEstado", filtroEstado);
			hqlQuery.executeUpdate();
		} catch (Exception e) {
			LOG_SICV2.error("", e);
			throw new SICException("Error al actualizar el estado de la entidad " + clase.getSimpleName(), e);
		} finally {
			session = null;
			query = null;
			hqlQuery = null;
		}
	}

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 */
	@Override
	public int completarCodificacionArticulo(ArticuloDTO articuloDTO) throws SICException {
		Session session;
		StringBuilder query;
		Query hqlQuery;
		int registros = 0;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();

			// se eliminan todos los segmentos de la codificacion porque ya no
			// se necesitan
			query = new StringBuilder();
			query.append("delete from ").append(SegmentoCreacionArticuloDTO.class.getName()).append(" a where a.id.codigoCompania = :pCodigoCompania and a.id.codigoArticulo = :pCodigoArticulo");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setParameter("pCodigoCompania", articuloDTO.getId().getCodigoCompania());
			hqlQuery.setParameter("pCodigoArticulo", articuloDTO.getId().getCodigoArticulo());
			registros = hqlQuery.executeUpdate();

		} catch (Exception e) {
			LOG_SICV2.error("", e);
			throw new SICException("Error al borrar los segmentos de la creaci\u00F3n del art\u00EDculo", e);
		} finally {
			session = null;
			query = null;
			hqlQuery = null;
		}
		return registros;
	}


	public void actualizarEstadoArticuloRelacion(Integer codigoCompania, String codigoArticulo, String nuevoEstado, String codigoProveedor, String filtroEstado, String userId) throws SICException {
		Session session;
		StringBuilder query;
		Query hqlQuery;
		Date fechaActual = new Date();
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("update ").append(ArticuloRelacionDTO.class.getName()).append(" artRel set artRel.estado").append("= :pEstado,").append(" artRel.idUsuarioModificacion = :pUserId, artRel.fechaModificacion = :pFechaModificacion").append(" where artRel.id.codigoArticuloRelacionado not in (").append("select artPro.id.codigoArticulo from ").append(ArticuloProveedorDTO.class.getName())
					.append(" artPro").append(" where artPro.id.codigoProveedor = :pCodigoProveedor and artPro.id.codigoCompania = :pCodigoCompania and artPro.estadoArticuloProveedor = :pEstadoActivo)").append(" and artRel.id.codigoCompania = :pCodigoCompania").append(" and artRel.id.codigoArticulo = :pCodigoArticulo").append(" and artRel.estado =:pFiltroEstado");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setString("pEstado", nuevoEstado);
			hqlQuery.setString("pUserId", userId);
			hqlQuery.setDate("pFechaModificacion", fechaActual);
			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
			hqlQuery.setString("pCodigoProveedor", codigoProveedor);
			hqlQuery.setString("pFiltroEstado", filtroEstado);
			hqlQuery.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			hqlQuery.executeUpdate();
		} catch (Exception e) {
			LOG_SICV2.error("", e);
			throw new SICException("Error al actualizar el estado de los art\u00EDculos relacionados", e);
		} finally {
			session = null;
			query = null;
			hqlQuery = null;
		}
	}

	public void actualizarDatosPrecioDescuentos(Integer codigoCompania, String codigoArticulo, String userId) throws SICException {
		Session session;
		StringBuilder query;
		StringBuilder queryPrecio;
		StringBuilder queryDescuentos;
		Query hqlQuery;
		Query hqlQueryPrecio;
		Query hqlQueryDescuentos;
		Date fechaActual = new Date();
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("select count(artRel.id.codigoArticulo) from ").append(ArticuloRelacionDTO.class.getName()).append(" artRel").append(" where artRel.id.codigoCompania = :pCodigoCompania").append(" and artRel.id.codigoArticulo = :pCodigoArticulo").append(" and artRel.estado =:pEstadoActivo");
			hqlQuery = session.createQuery(query.toString());
			hqlQuery.setInteger("pCodigoCompania", codigoCompania);
			hqlQuery.setString("pCodigoArticulo", codigoArticulo);
			hqlQuery.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			Long count = (Long) hqlQuery.uniqueResult();
			if (count.compareTo(0L) == 0) {

				queryPrecio = new StringBuilder();
				queryPrecio.append("update ").append(ArticuloPrecioDTO.class.getName()).append(" artPre set artPre.valorActual").append("= :pValorActual,").append(" artPre.idUsuarioModificacion").append("= :pUserId,").append(" artPre.fechaModificacion = :pFechaModificacion").append(" where artPre.id.codigoCompania = :pCodigoCompania").append(" and artPre.id.codigoArticulo = :pCodigoArticulo")
						.append(" and artPre.estadoPrecio =:pEstadoActivo");
				hqlQueryPrecio = session.createQuery(queryPrecio.toString());
				hqlQueryPrecio.setInteger("pCodigoCompania", codigoCompania);
				hqlQueryPrecio.setString("pCodigoArticulo", codigoArticulo);
				hqlQueryPrecio.setDouble("pValorActual", 0.0100);
				hqlQueryPrecio.setString("pUserId", userId);
				hqlQueryPrecio.setDate("pFechaModificacion", fechaActual);
				hqlQueryPrecio.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				hqlQueryPrecio.executeUpdate();

				queryDescuentos = new StringBuilder();
				queryDescuentos.append("update ").append(DescuentoVentaArticuloDTO.class.getName()).append(" desArtVen set desArtVen.estado").append("= :pEstadoActualizacion,").append(" desArtVen.idUsuarioModificacion").append("= :pUserId,").append(" desArtVen.fechaModificacion = :pFechaModificacion").append(" where desArtVen.id.codigoCompania = :pCodigoCompania")
						.append(" and desArtVen.id.codigoArticulo = :pCodigoArticulo").append(" and desArtVen.estado =:pEstadoActivo");
				hqlQueryDescuentos = session.createQuery(queryDescuentos.toString());
				hqlQueryDescuentos.setInteger("pCodigoCompania", codigoCompania);
				hqlQueryDescuentos.setString("pCodigoArticulo", codigoArticulo);
				hqlQueryDescuentos.setString("pUserId", userId);
				hqlQueryDescuentos.setDate("pFechaModificacion", fechaActual);
				hqlQueryDescuentos.setString("pEstadoActualizacion", SICConstantes.ESTADO_INACTIVO_NUMERICO);
				hqlQueryDescuentos.setString("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				hqlQueryDescuentos.executeUpdate();

			}
		} catch (Exception e) {
			LOG_SICV2.error("", e);
			throw new SICException("Error al actualizar los datos de los precios y descuentos del art\u00EDculo", e);
		} finally {
			session = null;
			query = null;
			queryPrecio = null;
			queryDescuentos = null;
			hqlQuery = null;
			hqlQueryPrecio = null;
			hqlQueryDescuentos = null;
		}
	}

	/**
	 * Permite obtener registros de art&iacute;culo local a partir de los
	 * filtros de b&uacute;squeda de art&iacute;culos
	 * 
	 * @author dalmeida
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	@Override
	@SuppressWarnings("unchecked")
	public SearchResultDTO<ArticuloAlcanceEST> obtenerArticulosLocalAlcance(ArticuloVO articuloVO) throws SICException {
		Integer maximoArticulos = SICArticuloConstantes.getInstancia().MAXIMO_ARTICULOS_BUSQUEDA_ALCANCES;
		
		SearchResultDTO<ArticuloAlcanceEST> resultDTO = new SearchResultDTO<ArticuloAlcanceEST>();
		Criteria select;
		Session session;
		Boolean enableLike = Boolean.TRUE;
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			select = hibernateH.getCriteriaQuery(articuloVO, BORRAR_CACHE, ACTIVAR_LIKE);
			Criteria criteriaRowcount = select;

			hibernateH.addRelations(articuloVO, select, enableLike);
			if (articuloVO.getIsPaginable()) {
				if (articuloVO.getCountAgain()) {
					CriteriaImpl criteriaImpl = (CriteriaImpl) criteriaRowcount;
					List<Object> orderClauses = new ArrayList<Object>();
					// almacenar temporalmente los criterios de ordenacion
					Iterator<?> orderings = criteriaImpl.iterateOrderings();
					while (orderings.hasNext()) {
						Order ordering = ((CriteriaImpl.OrderEntry) orderings.next()).getOrder();
						orderings.remove();
						orderClauses.add(ordering);
					}
					criteriaRowcount.setProjection(Projections.countDistinct("articuloLocalCol.codigoArticuloLocal"));
					resultDTO.setCountResults((Long) hibernateH.uniqueResult(articuloVO.getBaseDTO(), criteriaRowcount));
					// establecer los criterios de ordenacion originales
					orderings = orderClauses.iterator();
					while (orderings.hasNext()) {
						criteriaRowcount.addOrder((Order) orderings.next());
					}
					if (resultDTO.getCountResults() > maximoArticulos) {
						throw new SICException("01", SICMessages.getInstancia().getString("mensaje.articulo.alcance.asignacion.valormaximo"));
					}
				}

				if (articuloVO.getFirstResult() != null) {
					select.setFirstResult(articuloVO.getFirstResult());
				}
				if (articuloVO.getMaxResults() != null) {
					select.setMaxResults(articuloVO.getMaxResults());
				}

				ProjectionList projections = Projections.projectionList().add(Projections.property("id.codigoCompania"), "id.codigoCompania")
						.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo")
						.add(Projections.property("descripcionArticulo"), "descripcionArticulo")
						.add(Projections.property("articuloLocalCol.estadoArticuloLocal"), "estadoArticuloAlcance")
						.add(Projections.property("articuloLocalCol.estadoIntegracionAlcance"), "estadoIntegracionAlcance")
						.add(Projections.property("articuloLocalCol.id.codigoLocal"), "codigoAreaTrabajo")
						.add(Projections.property(SearchDTO.getPropertyAlias("articuloLocalCol.local") + ".codigoReferencia"), "codigosReferencia")
						.add(Projections.property(SearchDTO.getPropertyAlias("articuloLocalCol.local") + ".nombreAreaTrabajo"), "nombreAreaTrabajo")

						.add(Projections.property("articuloLocalCol.idUsuarioRegistro"), "idUsuarioRegistro")
						.add(Projections.property("articuloLocalCol.fechaRegistro"), "fechaRegistro")
						.add(Projections.property("articuloLocalCol.idUsuarioActivacion"), "idUsuarioActivacion")
						.add(Projections.property("articuloLocalCol.fechaActivacion"), "fechaActivacion")
						.add(Projections.property("articuloLocalCol.idUsuarioInactivacion"), "idUsuarioInactivacion")
						.add(Projections.property("articuloLocalCol.fechaInactivacion"), "fechaInactivacion")
						.add(Projections.property("articuloLocalCol.fechaInicialAlcance"), "fechaInicialAlcance")
						.add(Projections.property("articuloLocalCol.fechaFinalAlcance"), "fechaFinalAlcance")
						.add(Projections.property("articuloLocalCol.codigoArticuloLocal"), "codigoArticuloAreaTrabajo")
						.add(Projections.property("grupoAlcanceDTO.codigoReferencia"), "codigoReferenciaPrototipo")
						.add(Projections.property("articuloMedidaDTO.cantidadMedida"), "articuloMedidaDTO.cantidadMedida")
						.add(Projections.property("articuloMedidaDTO.valorTipoMedida"), "articuloMedidaDTO.valorTipoMedida")
						.add(Projections.property("codigoBarras"), "codigoBarras")
						.add(Projections.property("clasificacionDTO.id.codigoClasificacion"), "codigoClasificacion");
						
				if (!articuloVO.getIsConflictoArticuloALcance()) {
//					projections.add(Projections.property("artBitCodBarCol.id.codigoBarras"), "codigoBarrasActivo.id.codigoBarras")
					projections.add(Projections.property(SearchDTO.getPropertyAlias("articuloLocalCol.usuarioRegistro") + ".userCompleteName"), "nombreUsuarioRegistro")
					.add(Projections.property(SearchDTO.getPropertyAlias("articuloLocalCol.usuarioActivacion") + ".userCompleteName"), "nombreUsuarioActivacion")
					.add(Projections.property(SearchDTO.getPropertyAlias("articuloLocalCol.usuarioInactivacion") + ".userCompleteName"), "nombreUsuarioInactivacion")
					.add(Projections.property(SearchDTO.getPropertyAlias("articuloLocalCol.opcion") + ".accessItemName"), "nombreOpcion")
					.add(Projections.property(SearchDTO.getPropertyAlias("articuloLocalCol.opcion") + ".id.systemId"), "codigoSistema")
					.add(Projections.property(SearchDTO.getPropertyAlias("articuloLocalCol.tipoAsignacion") + ".nombreCorto"), "tipoAsignacion");
					
				}
				
				if(articuloVO.getIsReporteAlcance()){
					projections.add(Projections.property("clasificacionDTO.id.codigoClasificacion"), "clasificacionDTO.id.codigoClasificacion")
					.add(Projections.property("subClasificacionDTO.id.codigoSubClasificacion"), "subClasificacionDTO.id.codigoSubClasificacion")
					.add(Projections.property("clasificacionDTO.descripcionClasificacion"), "clasificacionDTO.descripcionClasificacion")
					.add(Projections.property("subClasificacionDTO.descripcionSubClasificacion"), "subClasificacionDTO.descripcionSubClasificacion")
					.add(Projections.property("clasificacionDTO.bodegaDTO.id.codigoBodega"), "clasificacionDTO.bodegaDTO.id.codigoBodega")
					.add(Projections.property(SearchDTO.getPropertyAlias("clasificacionDTO.bodegaDTO")+".descripcionBodega"), "clasificacionDTO.bodegaDTO.descripcionBodega");
					//articuloVO.setIsReporteAlcance(Boolean.FALSE);
				}

				// Relaciones por necesidad en el ordenamiento
				if (articuloVO.getOrderByField() != null) {
					if (StringUtils.contains(articuloVO.getOrderByField().getSecuenceOrderClause(), "clasificacionDTO.descripcionClasificacion")) {
						projections.add(Projections.property("clasificacionDTO.descripcionClasificacion"), "clasificacionDTO.descripcionClasificacion");
					}
					if (StringUtils.contains(articuloVO.getOrderByField().getSecuenceOrderClause(), "subClasificacionDTO.descripcionSubClasificacion")) {
						projections.add(Projections.property("subClasificacionDTO.descripcionSubClasificacion"), "subClasificacionDTO.descripcionSubClasificacion");
					}
					if (StringUtils.contains(articuloVO.getOrderByField().getSecuenceOrderClause(), "articuloMedidaDTO.referenciaMedida")) {
						projections.add(Projections.property("articuloMedidaDTO.referenciaMedida"), "articuloMedidaDTO.referenciaMedida");
					}
				}
				
				if(articuloVO.getIsReporteAlcance()){
					select.setProjection(projections);
				}else{
					select.setProjection(Projections.distinct(projections));
				}
				
				hibernateH.paginarDatos(select, articuloVO);
			}
			select.setResultTransformer(new DtoResultTransformer(ArticuloAlcanceEST.class));
			resultDTO.setResults(hibernateH.list(articuloVO.getBaseDTO(), select));
			if (resultDTO.getResults()!=null && (resultDTO.getCountResults() == null || resultDTO.getCountResults() == 0L)) {
				resultDTO.setCountResults(Long.valueOf(resultDTO.getResults().size()));
			}
			return resultDTO;
		} catch (HibernateDAOException e) {
			throw new SICException(e);
		}catch (QueryException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		}catch (Exception e) {
			Logeable.LOG_SICV2.error(e.getMessage());
			throw new SICException("Ha ocurrido un error al obtener los alcances, favor comuniquese con su administrador");
		}
	}
	/**
	 * Retorna un listado de los codigos de los articulos que tienen relacionado una clasificacion especifica
	 * @param clasificacion
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> obtenerCodigosArticulosClasificaciones(ClasificacionDTO clasificacion) throws SICException{
		Session session;
		StringBuilder query;
		SQLQuery sqlQuery = null;
		try{
			query = new StringBuilder();
			session = hibernateH.getHibernateSession();
			session.clear();
			//Armamos el query
			query.append("SELECT codigoarticulo AS {vista.codigoArticulo} ");
			query.append("FROM   scspetarticulo ");
			query.append("WHERE  codigoclasificacion ");
			if(clasificacion.getNivelClasificacion() == 1){//En el caso de ser una division
				query.append("IN (SELECT codigoclasificacion ");
				query.append("FROM   scspetclasificacion C ");
				query.append("WHERE  codigoclasificacionpadre IN (SELECT codigoclasificacion ");
				query.append("FROM   scspetclasificacion ");
				query.append("WHERE  codigoclasificacionpadre IN (SELECT codigoclasificacion ");
				query.append("FROM scspetclasificacion WHERE codigoclasificacion IN( '"+clasificacion.getId().getCodigoClasificacion()+"' ) ");
				query.append("AND estadoclasificacion = "+SICConstantes.ESTADO_ACTIVO_NUMERICO+") ");
				query.append("AND estadoclasificacion = "+SICConstantes.ESTADO_ACTIVO_NUMERICO+"))  FETCH FIRST 1 ROWS ONLY");
			}else if(clasificacion.getNivelClasificacion() == 2){ //En el caso de ser Departamento
				query.append("IN (SELECT codigoclasificacion ");
				query.append("FROM   scspetclasificacion C ");
				query.append("WHERE  codigoclasificacionpadre IN (SELECT codigoclasificacion ");
				query.append("FROM   scspetclasificacion ");
				query.append("WHERE codigoclasificacion IN( '"+clasificacion.getId().getCodigoClasificacion()+"' ) ");
				query.append("AND estadoclasificacion = "+SICConstantes.ESTADO_ACTIVO_NUMERICO+"))  FETCH FIRST 1 ROWS ONLY");
			}else if(clasificacion.getNivelClasificacion() == 3){ //En el caso de ser Clasificacion
				query.append("IN (SELECT codigoclasificacion ");
				query.append("FROM   scspetclasificacion C ");
				query.append("WHERE  codigoclasificacion IN( '"+clasificacion.getId().getCodigoClasificacion()+"' ) ");
				query.append("AND estadoclasificacion = "+SICConstantes.ESTADO_ACTIVO_NUMERICO+")  FETCH FIRST 1 ROWS ONLY");
			}
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.addEntity("vista",VistaArticuloClasificacionDTO.class);
			return sqlQuery.list();
		}catch(Exception e){
			LOG_SICV2.error("Ocurrio un error al obtener los articulos de la clasificacion: " + e);
			throw new SICException("Ocurrio un error al obtener los articulos de la clasificacion");
		}
	}
	/**
	  * Retorna un listado de los codigos de los articulos que tienen relacionado una subclasificacion especifica
	 * @param subClasificacion
	 * @return
	 * @throws SICException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<String> obtenerCodigosArticulosSubClasificaciones(SubClasificacionDTO subClasificacion) throws SICException{
		Session session;
		StringBuilder query;
		SQLQuery sqlQuery = null;
		try{
			query = new StringBuilder();
			session = hibernateH.getHibernateSession();
			session.clear();
			//Armamos el query
			query.append("SELECT a.codigoarticulo AS {vista.codigoArticulo} ");
			query.append("FROM   scspetarticulo a ");
			query.append("INNER JOIN scsadtartbitcodbar ab ");
			query.append("ON a.codigoarticulo = ab.codigoarticulo ");
			query.append("WHERE  a.codigosubclasificacion = " + subClasificacion.getId().getCodigoSubClasificacion());
			query.append(" AND a.codigoclasificacion = " + subClasificacion.getClasificacionDTO().getId().getCodigoClasificacion());
			query.append(" AND ab.estadoarticulobitacora=" + SICConstantes.ESTADO_ACTIVO_NUMERICO);
			query.append(" AND a.estadoarticulo=" + SICConstantes.ESTADO_ACTIVO_NUMERICO + " FETCH FIRST 1 ROWS ONLY");
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.addEntity("vista",VistaArticuloClasificacionDTO.class);
			return sqlQuery.list();
		}catch(Exception e){
			LOG_SICV2.error("Ocurrio un error al obtener los articulos de la clasificacion: " + e);
			throw new SICException("Ocurrio un error al obtener los articulos de la clasificacion");
		}
	}
	
	public Long obtenerPrototipoAlcance(Integer codigoCompania , String codigoArticulo)throws SICException{
		try{
			Session session = this.sessionFactory.getCurrentSession();
			session.clear();
			Criteria criteria = session.createCriteria(ArticuloDTO.class);
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("codigoGrupoAlcance"),("codigoGrupoAlcance"));
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			criteria.setProjection(projectionList);
			Long prototipo = (Long) criteria.uniqueResult();
			return prototipo;
		}catch(Exception e){
			LOG_SICV2.error("Ocurrio un error al consultar el prototipo " + e);
			throw new SICException("Ocurrio un error al consultar el prototipo");
		}
	}
	
	@Override
	public Collection<ClasificacionDTO> obtenerEstWRTRelacionada(ClasificacionDTO estComercialDTO)throws SICException{
		try{
			if(estComercialDTO.getId().getCodigoClasificacion()==null){
				Criteria criteria=hibernateH.getHibernateSession().createCriteria(ClasificacionDTO.class);
				criteria.setProjection(Projections.projectionList().add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion")
						.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
						.add(Projections.property("descripcionClasificacion"),"descripcionClasificacion")
						.add(Projections.property("estadoClasificacion"),"estadoClasificacion"));
				criteria.add(Restrictions.eq("valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_WRT));
				criteria.add(Restrictions.eq("id.codigoCompania", estComercialDTO.getId().getCodigoCompania()));
				criteria.add(Restrictions.eq("estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.setResultTransformer(new DtoResultTransformer(ClasificacionDTO.class));
				Collection<ClasificacionDTO> clasificacionWRT=criteria.list();
				return clasificacionWRT;
			}
			else{
				Criteria criteria=hibernateH.getHibernateSession().createCriteria(ClasificacionDTO.class);
				criteria.setProjection(Projections.projectionList().add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion")
						.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
						.add(Projections.property("descripcionClasificacion"),"descripcionClasificacion")
						.add(Projections.property("relacion.estadoClasificacionRelacionada"),"estadoClasificacion"));
				criteria.createAlias("clasificacionRelacionadaPrincipal", "relacion",CriteriaSpecification.INNER_JOIN);
				criteria.add(Restrictions.eq("relacion.codigoClasificacionRelacionada", estComercialDTO.getId().getCodigoClasificacion()));
				criteria.add(Restrictions.eq("valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_WRT));
				criteria.add(Restrictions.eq("id.codigoCompania", estComercialDTO.getId().getCodigoCompania()));
				criteria.add(Restrictions.eq("relacion.estadoClasificacionRelacionada", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				criteria.setResultTransformer(new DtoResultTransformer(ClasificacionDTO.class));
				Collection<ClasificacionDTO> clasificacionWRT=criteria.list();
				return clasificacionWRT;
			}
		} catch (SICException e) {
			throw new SICException(e);
		}
	}
	
	@Override
	public Collection<ClasificacionDTO> obtenerECdesdeWRT(ClasificacionDTO estWRT)throws SICException{
		try{
			Criteria criteria=hibernateH.getHibernateSession().createCriteria(ClasificacionDTO.class);
			criteria.setProjection(Projections.projectionList().add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion")
					.add(Projections.property("descripcionClasificacion"),"descripcionClasificacion")
					.add(Projections.property("porcentajeNoAfiliado"),"porcentajeNoAfiliado")
					.add(Projections.property("relacion.estadoClasificacionRelacionada"),"estadoClasificacion")
					.add(Projections.property("codigoBodega"),"codigoBodega")
					.add(Projections.property("estadoClasificacion"),"estadoClasificacion")
					.add(Projections.property("esPublicadoInternet"),"esPublicadoInternet")
					.add(Projections.property("valorTipoDeducible"),"valorTipoDeducible")
					.add(Projections.property("codigoTipoDeducible"),"codigoTipoDeducible")
					.add(Projections.property("valorTipoDistribucion"),"valorTipoDistribucion")
					.add(Projections.property("codigoTipoDistribucion"),"codigoTipoDistribucion")
					.add(Projections.property("valorAplicaRegistroSanitario"),"valorAplicaRegistroSanitario")
					.add(Projections.property("codigoAplicaRegistroSanitario"),"codigoAplicaRegistroSanitario")
					.add(Projections.property("aplicaTransgenico"),"aplicaTransgenico"));
			
			criteria.createAlias("clasificacionRelacionadaSecundaria", "relacion",CriteriaSpecification.INNER_JOIN);
			criteria.add(Restrictions.eq("relacion.codigoClasificacion", estWRT.getId().getCodigoClasificacion()));
			criteria.add(Restrictions.eq("valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
			criteria.add(Restrictions.eq("id.codigoCompania", estWRT.getId().getCodigoCompania()));
			criteria.add(Restrictions.eq("relacion.estadoClasificacionRelacionada", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.addOrder(Order.asc("id.codigoClasificacion"));
			criteria.setResultTransformer(new DtoResultTransformer(ClasificacionDTO.class));
			Collection<ClasificacionDTO>  clasificacionesEC= criteria.list();
//			if(CollectionUtils.isEmpty(clasificacionesEC)){
//				return null;
//			}else{
//			return (ClasificacionDTO) CollectionUtils.get(clasificacionesEC, 0);
//			}
			return clasificacionesEC;
		}catch(SICException e){
			throw new SICException(e);
		}
	}
	
	@Override
	public Boolean existeArticuloUnificarCosto(ClasificacionDTO clasificacionDTO)throws SICException{
		try{
			Boolean existe=Boolean.FALSE;
			Collection<String> estadoPrecios=new ArrayList<String>();
			estadoPrecios.add(EstadoGestionPrecio.CONFIRMADO.getValorEstadoGestionPrecio());
			estadoPrecios.add(EstadoGestionPrecio.PENDIENTE.getValorEstadoGestionPrecio());
			estadoPrecios.add(EstadoGestionPrecio.AUTORIZADO.getValorEstadoGestionPrecio());
			
			Criteria criteria=hibernateH.getHibernateSession().createCriteria(ArticuloGestionPrecioDTO.class);
			criteria.setProjection(Projections.projectionList().add(Projections.property("id.codigoArticulo"),"id.codigoArticulo"));
			criteria.createAlias("articulo", "articulo",CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("gestionPrecio", "gestionPrecio", CriteriaSpecification.LEFT_JOIN);
			criteria.add(Restrictions.eq("articulo.codigoClasificacion", clasificacionDTO.getId().getCodigoClasificacion()));
			criteria.add(Restrictions.eq("gestionPrecio.valorTipoGestionPrecio", TipoGestionPrecio.CAMBIO_PRECIO.getValorTipoGestionPrecio()));
			criteria.add(Restrictions.in("valorTipoEstado", estadoPrecios));
//			criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			Integer count= criteria.list().size();
			if(count>0){
				existe= Boolean.TRUE;
			}
			return existe;
		}catch(SICException e){
			throw new SICException(e);
		}
	}
	
	@Override
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, String codigoValorCaracteristica, Integer codigoCompania) throws SICException {
		Boolean existeCaracteristica = null;
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			StringBuilder squery = new StringBuilder();
			squery.append("select count(*) ");
			squery.append("from CaracteristicaDinamicaDTO cd ");
			squery.append("where cd.estado = :estado ");
			squery.append("and cd.codigoClasificacion = :codigoClasificacion ");
			squery.append("and cd.codigoTipoCaracteristica = :codigoTipoCaracteristica ");
			squery.append("and cd.codigoValorCaracteristica = :codigoValorCaracteristica ");
			squery.append("and cd.codigoCompania = :codigoCompania");
			
			Query hquery = session.createQuery(squery.toString());
			hquery.setParameter("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			hquery.setParameter("codigoClasificacion", codigoClasificacion);
			hquery.setParameter("codigoTipoCaracteristica", codigoTipoCaracteristica);
			hquery.setParameter("codigoValorCaracteristica", codigoValorCaracteristica);
			hquery.setParameter("codigoCompania", codigoCompania);
			Long numeroConincidencias = (Long) hquery.uniqueResult();
			existeCaracteristica = numeroConincidencias > 0;
		} catch (SICException e) {
			throw new SICException(e);
		}
		return existeCaracteristica;
	}
	
	@Override
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, Integer codigoCompania) throws SICException {
		Session session = null;
		Boolean existe = Boolean.FALSE;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			StringBuilder squery = new StringBuilder();
			squery.append("select count(*) ");
			squery.append("from CaracteristicaDinamicaDTO cd ");
			squery.append("where cd.estado = :estado ");
			squery.append("and cd.codigoClasificacion = :codigoClasificacion ");
			squery.append("and cd.codigoTipoCaracteristica = :codigoTipoCaracteristica ");
			squery.append("and cd.codigoCompania = :codigoCompania");
			
			Query hquery = session.createQuery(squery.toString());
			hquery.setParameter("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			hquery.setParameter("codigoClasificacion", codigoClasificacion);
			hquery.setParameter("codigoTipoCaracteristica", codigoTipoCaracteristica);
			hquery.setParameter("codigoCompania", codigoCompania);
			Long numeroConincidencias = (Long) hquery.uniqueResult();
			existe = numeroConincidencias > 0;
			
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener la existencia de la caracteristica dinamica. {}", e.getMessage());
			throw new SICException(e);
		}
		return existe;
	}

	@Override
	public Boolean validarDescripcionClasificacion(ClasificacionDTO clasificacion)throws SICException{
		try {
			Boolean existe=Boolean.FALSE;
			Criteria criteria;
			Integer count=0;
				if(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL.equals(clasificacion.getValorTipoEstructura()) || 
						(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE.equals(clasificacion.getValorTipoEstructura()) && 
								SICConstantes.TIPCLA_DIVISION.equals(clasificacion.getCodigoTipoClasificacion())) || 
								CorporativoConstantes.TIPO_ESTRUCTURA_WRT.equals(clasificacion.getValorTipoEstructura())){
					criteria=hibernateH.getHibernateSession().createCriteria(ClasificacionDTO.class);
					criteria.setProjection(Projections.projectionList().add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion"));
					criteria.add(Restrictions.eq("id.codigoCompania", clasificacion.getId().getCodigoCompania()));
					
					criteria.add(Restrictions.ilike("descripcionClasificacion", clasificacion.getDescripcionClasificacion(), MatchMode.EXACT));
					criteria.add(Restrictions.eq("codigoTipoClasificacion", clasificacion.getCodigoTipoClasificacion()));
					criteria.add(Restrictions.eq("valorTipoEstructura", clasificacion.getValorTipoEstructura()));
					
					if(clasificacion.getCodigoClasificacionPadre()!=null){
						criteria.add(Restrictions.eq("codigoClasificacionPadre", clasificacion.getCodigoClasificacionPadre()));
					}
					if(clasificacion.getId().getCodigoClasificacion()!=null){
						criteria.add(Restrictions.ne("id.codigoClasificacion", clasificacion.getId().getCodigoClasificacion()));
					}
					
					count= criteria.list().size();
				}else if(CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL_CLIENTE.equals(clasificacion.getValorTipoEstructura())){
					criteria=hibernateH.getHibernateSession().createCriteria(ClasificacionRelacionadaDTO.class);
					criteria.setProjection(Projections.projectionList().add(Projections.property("codigoClasificacionRelacionada"),"codigoClasificacionRelacionada"));
					criteria.createAlias("clasificacionRelacionada", "claHijo");
					criteria.add(Restrictions.eq("estadoClasificacionRelacionada", SICConstantes.ESTADO_ACTIVO_NUMERICO));
					criteria.add(Restrictions.eq("claHijo.codigoTipoClasificacion", clasificacion.getCodigoTipoClasificacion()));
					criteria.add(Restrictions.eq("codigoClasificacion", clasificacion.getCodigoClasificacionPadre()));
					criteria.add(Restrictions.eq("claHijo.valorTipoEstructura", clasificacion.getValorTipoEstructura()));
					criteria.add(Restrictions.ilike("claHijo.descripcionClasificacion", clasificacion.getDescripcionClasificacion(), MatchMode.EXACT));
					
					if(clasificacion.getId().getCodigoClasificacion()!=null){
						criteria.add(Restrictions.ne("claHijo.id.codigoClasificacion", clasificacion.getId().getCodigoClasificacion()));
					}
					count= criteria.list().size();
				}
				
			if(count>0){
				existe= Boolean.TRUE;
			}
			return existe;
		} catch (SICException e) {
			throw new SICException(e);
		}
	}
	
	@Override
	public Collection<SubClasificacionDTO> validarDescripcionSubclasificacion( SubClasificacionDTO subcla)throws SICException{
		try {
			Criteria criteria;
			criteria=hibernateH.getHibernateSession().createCriteria(SubClasificacionDTO.class);
			criteria.setProjection(Projections.projectionList().add(Projections.property("id.codigoSubClasificacion"),"id.codigoSubClasificacion")
					.add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion"));
			criteria.add(Restrictions.eq("id.codigoCompania", subcla.getId().getCodigoCompania()));
			criteria.add(Restrictions.eq("id.codigoClasificacion", subcla.getId().getCodigoClasificacion()));
			criteria.add(Restrictions.ilike("descripcionSubClasificacion", subcla.getDescripcionSubClasificacion(), MatchMode.EXACT));
			criteria.setResultTransformer(new DtoResultTransformer(SubClasificacionDTO.class));
			Collection<SubClasificacionDTO> subclaCol=criteria.list();
			return subclaCol;
		} catch (SICException e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * M\u00E9todo que permite actualizar el c\u00F3digo de cliente asociado al art\u00EDculo
	 * @author mgranda
	 * @param codigoCompania
	 * @param userId
	 * @param codigoClienteImportacion
	 * @param codigosArticulo
	 * @return Retorna el total de art\u00EDculos actualizados.
	 * @throws SICException
	 */
	@Override
	public Integer actualizarClienteImportacionArticulo(Integer codigoCompania, String userId, Long codigoClienteImportacion, String... codigosArticulo) throws SICException{
		LOG_SICV2.info("==> Actualizando codigo de cliente en articulo");
		try{
			/*Se prepara el hql de actualizacion*/
			final StringBuilder hql = new StringBuilder("update ").append(ArticuloDTO.class.getName()).append(" a");
			hql.append(" set codigoClienteImportacion = :pCodigoClienteImportacion, usuarioActualizacion = :pUsuarioActualizacion,");
			hql.append(" fechaUltimaActualizacion = current_timestamp()");
			hql.append(" where id.codigoCompania = :pCodigoCompania and id.codigoArticulo");
			if(ArrayUtils.isNotEmpty(codigosArticulo) && codigosArticulo instanceof Object[] && codigosArticulo.length > 1){
				hql.append(" in (:pCodigoArticulo)");
			}else{
				hql.append(" = :pCodigoArticulo");
			}
			
			/*Se obtiene la sesion de hibernate y se limpia*/
			final Session session = hibernateH.getHibernateSession();	
			session.clear();	
			
			/*Se prepara el query de actualizacion*/
			Query query = session.createQuery(hql.toString()); 
			
			/*Se asignan los parametros al query*/
			query.setParameter("pCodigoClienteImportacion", codigoClienteImportacion);
			query.setParameter("pUsuarioActualizacion", userId);
			query.setParameter("pCodigoCompania", codigoCompania);
			if(ArrayUtils.isNotEmpty(codigosArticulo) && codigosArticulo instanceof Object[] && codigosArticulo.length > 1){
				query.setParameterList("pCodigoArticulo", codigosArticulo);
			}else{
				query.setParameter("pCodigoArticulo", codigosArticulo[0]);
			}
			
			/*Ejecutamos y realizamos commit del registro*/
			Integer total = query.executeUpdate();
			LOG_SICV2.info(MessageFormat.format("==> Se actualizo {0} registro.", total));
			return total;
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al actualizar ArticuloClase.", e.getMessage());
		}
	}
	
	
/************************************************************************************************************************************************
 * METODOS DE LA ESTRUCTURA LOGISTICA
 * ***********************************************************************************************************************************************
 */
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<ArticuloDTO> buscarArticulos(ArticuloDTO articuloDTO)throws SICException{
		final Boolean BORRAR_CACHE = Boolean.TRUE;
		final Boolean ACTIVAR_LIKE = Boolean.TRUE;
		Criteria select;
		try{
			if(cuentaResultado(articuloDTO)<SICBodegaConstantes.NUMERO_MAXIMO_RESULTADOS){
				select = hibernateH.getCriteriaQuery(articuloDTO, BORRAR_CACHE, ACTIVAR_LIKE);
				hibernateH.addRelations(articuloDTO, select, ACTIVAR_LIKE);
				ProjectionList projections = Projections.projectionList()
						.add(Projections.property("codigoBarras"),"codigoBarras")
						.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
						.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
						.add(Projections.property("descripcionArticulo"),"descripcionArticulo")
						.add(Projections.property("articuloMedidaDTO.referenciaMedida"),"articuloMedidaDTO.referenciaMedida")
						.add(Projections.property("estadoArticulo"),"estadoArticulo")
						.add(groupProperty("codigoBarras"))
						.add(groupProperty("id.codigoCompania"))
						.add(groupProperty("id.codigoArticulo"))
						.add(groupProperty("descripcionArticulo"))
						.add(groupProperty("articuloMedidaDTO.referenciaMedida"))
						.add(groupProperty("estadoArticulo"));
				
				select.setProjection(projections);
				if(articuloDTO.getDynamicProperties().containsKey("restriccionLineaComercial")){
					select.add((Criterion)articuloDTO.getDynamicProperties().get("restriccionLineaComercial"));
				}
				select.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
				Collection<ArticuloDTO> articuloDTOCol = hibernateH.list(articuloDTO, select);
				
				return articuloDTOCol;
			}else{
				throw new SICException("01",SICMessages.getInstancia().getString("mensaje.articulo.estructura.logistica.valormaximo"));
			}
		}catch(SICException e){
			LOG_SICV2.info("Error consultando los articulos");
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		}
	}
	
	private Long cuentaResultado(ArticuloDTO articuloDTO)throws SICException{
		Criteria select;
		Long a;
		try{
			select = hibernateH.getCriteriaQuery(articuloDTO, Boolean.TRUE, Boolean.TRUE);
			hibernateH.addRelations(articuloDTO, select, true);
			Criteria criteriaRowcount = select;
			criteriaRowcount.setProjection(Projections.countDistinct("id.codigoArticulo"));
			a=(Long) hibernateH.uniqueResult(articuloDTO,criteriaRowcount);
		}catch(SICException e){
			LOG_SICV2.info("Error contando los articulos");
			throw new SICException("Error contando los articulos",e);
		}
		return a;
	}

	@Override
	public Collection<ArticuloDTO> buscarArticulo(Integer valorUniMan, String codigoBarras)throws SICException{
		try{
			Criteria select =this.sessionFactory.getCurrentSession().createCriteria(ArticuloDTO.class, "art");
			select.setProjection(Projections.projectionList()
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("um.id.codigoUnidadManejo"), "codigoUnidadManejo"));
				
			select.createAlias("art.articuloUnidadManejoCol", "um");
			select.createAlias("art.artBitCodBarCol", "cb");
			select.add(Restrictions.eq("um.estadoUnidadManejo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			select.add(Restrictions.eq("um.valorUnidadManejo", valorUniMan));
			select.add(Restrictions.eq("cb.id.codigoBarras", codigoBarras));
			select.add(Restrictions.eq("cb.estadoArticuloBitacora", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			select.add(Restrictions.eq("art.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			select.add(Restrictions.isNull("um.codigoUnidadManejoContenida"));
			select.add(Restrictions.ne("um.valorTipoUnidadEmpaque", SICArticuloConstantes.TIPOEMPAQUE_MAYORISTA));
			select.add(Restrictions.ne("um.valorTipoUnidadEmpaque",SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PALLET));
			select.add(Restrictions.eq("um.codigoTipoUnidadEmpaque",SICBodegaConstantes.CODIGO_TIPO_UNIDAD_EMPAQUE));
			
			select.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			Collection<ArticuloDTO> articulo = select.list();
				
			return articulo;
		}catch(SICException e){
			LOG_SICV2.info("Error consultando los articulos");
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		}
	}
	
	@Override
	public ArticuloDTO buscarArticuloId(Integer codigoCompania, String codigoArticulo)throws SICException{
		try{
			Criteria select =this.sessionFactory.getCurrentSession().createCriteria(ArticuloDTO.class, "art");
			select.setProjection(Projections.projectionList()
					.add(Projections.property("codigoBarras"),"codigoBarras")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
					.add(Projections.property("descripcionArticulo"),"descripcionArticulo")
					.add(Projections.property("articuloMedidaDTO.referenciaMedida"),"articuloMedidaDTO.referenciaMedida")
					.add(Projections.property("estadoArticulo"),"estadoArticulo"));
				
			select.add(Restrictions.eq("art.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			select.add(Restrictions.eq("art.id.codigoArticulo", codigoArticulo));
			select.add(Restrictions.eq("art.id.codigoCompania", codigoCompania));
			
			select.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			ArticuloDTO articuloDTO = (ArticuloDTO)select.uniqueResult();
				
			return articuloDTO;
		}catch(SICException e){
			LOG_SICV2.info("Error consultando los articulos");
			throw new SICException(e.getCodigoError(), e.getDescripcionError());
		}
	}
/*************************************************************************************************************************************************
 * FIN
 * ***********************************************************************************************************************************************
 */
	
	
	@Override
	public Date obtenerFechaCreacionArticulo(Integer codigoCompania, String codigoArticulo){
		Date fechaCreacionArticulo = null;
		Session session = null;
		Criteria criteria = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloDTO.class, "a");
				criteria.setProjection(Projections.property("fechaCreacion"));
				criteria.add(Restrictions.eq("a.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("a.id.codigoArticulo", codigoArticulo));
				fechaCreacionArticulo = (Date) criteria.uniqueResult();
			}
		}catch(Exception e ){
			throw new SICException("No se ha podido obtener el articulo clase ", e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return fechaCreacionArticulo;
	}	
	
	/**
	 * Metodo que permite obtener el estado de un articulo
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo	 * 
	 * @return
	 */
	@Override
	public String obtenerEstadoArticulo(Integer codigoCompania, String codigoArticulo){
		Session session = null;
		Criteria criteria = null;
		String estadoArticulo = null;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(codigoArticulo)){
				session = hibernateH.getHibernateSession();
				session.clear();
				
				criteria = session.createCriteria(ArticuloDTO.class, "a");
				criteria.setProjection(Projections.property("estadoArticulo"));
				criteria.add(Restrictions.eq("a.id.codigoCompania", codigoCompania));
				criteria.add(Restrictions.eq("a.id.codigoArticulo", codigoArticulo));
				estadoArticulo = (String) criteria.uniqueResult();
			}
		}catch(Exception e ){
			throw new SICException("No se ha podido obtener el articulo clase ", e.getMessage());
		}finally{
			session = null;
			criteria = null;
		}
		return estadoArticulo;
	}	
	
	public SearchResultDTO<ArticuloDTO> buscarArticuloBasico(Criterion criterioBusqueda , Integer firstResult ,Integer maxResults , Boolean findNum , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO)throws SICException{
		try{
			SearchResultDTO<ArticuloDTO> searchResultDTO = new SearchResultDTO<ArticuloDTO>();
			Session session = hibernateH.getHibernateSession();
			
			//buscamos el numero total de resultados
			if(findNum){
				ProjectionList projectionListCount = Projections.projectionList();
				projectionListCount.add(Projections.countDistinct("id.codigoArticulo"));
				Criteria criteriaCount = crearCriterioBusquedaBasico(criterioBusqueda , busquedaSimpleArticuloVO , session);
				criteriaCount.setProjection(projectionListCount);
				Long countResults = (Long) criteriaCount.uniqueResult();
				searchResultDTO.setCountResults(countResults);
			}
			
			//buscamos los datos de los articulos
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("id.codigoArticulo"),("id.codigoArticulo"));
			projectionList.add(Projections.property("descripcionArticulo"),("descripcionArticulo"));
			projectionList.add(Projections.property("artBitCodBarCol.id.codigoBarras"),("codigoBarrasActivo.id.codigoBarras"));
			if(busquedaSimpleArticuloVO != null){
				projectionList.add(Projections.property("articuloComercialDTOmarcaComercialArticulo.nombre"),("nombreMarca"));
				projectionList.add(Projections.property("articuloProveedorCol.codigoReferenciaInterna"),("codRefIntProv"));
			}
			
			Criteria criteriaBusqueda = crearCriterioBusquedaBasico(criterioBusqueda , busquedaSimpleArticuloVO , session);
			criteriaBusqueda.setFirstResult(firstResult);
			criteriaBusqueda.setMaxResults(maxResults);
			criteriaBusqueda.setProjection(Projections.distinct(projectionList));
			criteriaBusqueda.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			searchResultDTO.setResults(criteriaBusqueda.list());
			searchResultDTO.setCountResults(searchResultDTO.getCountResults());
			session.clear();
			
			return searchResultDTO;
		}catch(Exception e){
			LOG_SICV2.error("ocurrio un error en la busqueda de articulos: "+e.getMessage());
			throw new SICException("ocurrio un error en la busqueda de articulos");
		}
	}
	
	/**
	 * arma un criterio de busqueda personalizado
	 * @param criterion
	 * @param busquedaSimpleArticuloVO
	 * @param session
	 * @param projectionList
	 * @return
	 */
	private Criteria crearCriterioBusquedaBasico(Criterion criterion , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO , Session session){
		session.clear();
		Criteria criteria = session.createCriteria(ArticuloDTO.class);
		criteria.createAlias("artBitCodBarCol" , "artBitCodBarCol" , JoinType.LEFT.ordinal());
		//agregamos las condiciones de busqueda personalizadas
		if(busquedaSimpleArticuloVO != null){
			//el codigo proveedor es requerido, y realizamos el join con articulo proveedor y con articulo marca
			criteria.createAlias("articuloComercialDTO" , "articuloComercialDTO" , JoinType.LEFT.ordinal());
			criteria.createAlias("articuloComercialDTO.marcaComercialArticulo" , "articuloComercialDTOmarcaComercialArticulo" , JoinType.LEFT.ordinal());
			criteria.createAlias("articuloProveedorCol" , "articuloProveedorCol" , JoinType.LEFT.ordinal());
			criteria.add(Restrictions.eq("articuloProveedorCol.id.codigoProveedor", busquedaSimpleArticuloVO.getCodigoProveedor()));
			//codigo Clasificacion
			if(busquedaSimpleArticuloVO.getCodigoClasificacion() != null){
				criteria.add(Restrictions.eq("codigoClasificacion", busquedaSimpleArticuloVO.getCodigoClasificacion()));
			}
			//codigo SubClasificacion
			if(busquedaSimpleArticuloVO.getCodigoSubClasificacion() != null){
				criteria.add(Restrictions.eq("codigoSubClasificacion", busquedaSimpleArticuloVO.getCodigoSubClasificacion()));
			}
			//Departamento y subBodega
			if(busquedaSimpleArticuloVO.getCodigoDepartamento() != null || busquedaSimpleArticuloVO.getCodigoSubbodega() != null){
				criteria.createAlias("clasificacionDTO" , "clasificacionDTO" , JoinType.LEFT.ordinal());
				if(busquedaSimpleArticuloVO.getCodigoDepartamento() != null){
					criteria.add(Restrictions.eq("clasificacionDTO.codigoClasificacionPadre", busquedaSimpleArticuloVO.getCodigoDepartamento()));
				}
				if(busquedaSimpleArticuloVO.getCodigoSubbodega() != null){
					criteria.add(Restrictions.eq("clasificacionDTO.codigoBodega", busquedaSimpleArticuloVO.getCodigoSubbodega()));
				}
			}
			//Marca comercial y tipo marca
			if(busquedaSimpleArticuloVO.getMarcaComercial() != null || ArrayUtils.isNotEmpty(busquedaSimpleArticuloVO.getTipoMarca())){
				if(busquedaSimpleArticuloVO.getMarcaComercial() != null){
					criteria.add(Restrictions.eq("articuloComercialDTO.codigoMarcaComercial", busquedaSimpleArticuloVO.getMarcaComercial()));
				}
				if(busquedaSimpleArticuloVO.getTipoMarca() != null){
					criteria.add(Restrictions.in("articuloComercialDTOmarcaComercialArticulo.valorTipoMarca", busquedaSimpleArticuloVO.getTipoMarca()));
				}
			}
		}
		
		criteria.add(criterion);			

		return criteria;
	}
	
	/**
	 * Metodo que permite obtener la información general de artículos, costos
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @param codigoProveedores
	 * @return
	 */
	@Override
	public Collection<ArticuloDTO> obtenerInformacionGeneral(Integer codigoCompania, String[] codigoArticulos, String[] codigoProveedores){
		LOG_SICV2.info("==> obtener informacion general articulo.");
		Collection<ArticuloDTO> articuloInfoVOCol;
		try{
			/*Se prepara el hql de busqueda*/
			final StringBuilder hql = new StringBuilder("select art.id.codigoCompania as id_codigoCompania, art.id.codigoArticulo as id_codigoArticulo,")
					.append(" art.descripcionArticulo as descripcionArticulo, art.claseArticulo as claseArticulo,")
					.append(" art.codigoClasificacion as codigoClasificacion, artpro.id.codigoProveedor as articuloProveedorCol_id_codigoProveedor,")
					.append(" codbar.id.codigoBarras as artBitCodBarCol_id_codigoBarras, codbar.estadoArticuloBitacora as artBitCodBarCol_estadoArticuloBitacora,")
					
					/* Articulo Comercial */
					.append(" artcom.porcentajeNoAfiliado as articuloComercialDTO_porcentajeNoAfiliado,")
					.append(" artcom.ventaPrecioAfiliado as articuloComercialDTO_ventaPrecioAfiliado,")
					/* Costos */
					.append(" artpro.costoBruto as articuloProveedorCol_costoBruto,")
					.append(" pro.id.codigoProveedor as articuloProveedorCol_proveedor_id_codigoProveedor, pro.nombreProveedor as articuloProveedorCol_proveedor_nombreProveedor,")
					.append(" atd.prioridad as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_prioridad,")
					.append(" atd.valorAplicacionTipoDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_valorAplicacionTipoDescuento,")// <>TIPODESCUENTO
					.append(" des.estado as articuloProveedorCol_descuentoProveedorArticuloCol_estado,")
					.append(" des.porcentajeDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_porcentajeDescuento,")
					.append(" equi.descuento as articuloProveedorCol_descuentoProveedorArticuloCol_equivalenciaPorcentajeDescuento_descuento,")
					.append(" uniman.estado as articuloProveedorCol_unidadesManejo_estado,")
					.append(" unimanequi.descuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_descuento,")
					/* Precios */
						.append(" artpre.id.codigoTipoPrecio as articuloPrecioCol_id_codigoTipoPrecio,")
						.append(" artpre.codigoUnidadManejo as articuloPrecioCol_codigoUnidadManejo,")
						.append(" artpre.estadoPrecio as articuloPrecioCol_estadoPrecio,")
						.append(" artpre.valorActual as articuloPrecioCol_valorActual,")
						/* Impuestos */
						.append(" artimp.id.codigoTipoImpuesto as articuloImpuestoCol_id_codigoTipoImpuesto,")
						.append(" artimp.estadoArticuloImpuesto as articuloImpuestoCol_estadoArticuloImpuesto,")
						.append(" artimp.esParaVenta as articuloImpuestoCol_esParaVenta,")
						.append(" artimp.esParaCompra as articuloImpuestoCol_esParaCompra,")
						/* Tipos de impuestos */
						.append(" tipimp.codigoGrupoImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_codigoGrupoImpuesto,")
						.append(" tipimp.porcentajeImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_porcentajeImpuesto,")
						.append(" tipimp.estadoTipoImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_estadoTipoImpuesto,")
						.append(" tipimp.valorImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_valorImpuesto,")	
						/* Unidades de Manejo*/
						.append(" aumpre.estadoUnidadManejo as articuloPrecioCol_articuloUnidadManejo_estadoUnidadManejo,")
						.append(" aumpre.valorUnidadManejo as articuloPrecioCol_articuloUnidadManejo_valorUnidadManejo,")
						.append(" aumpre.descuentoVenta as articuloPrecioCol_articuloUnidadManejo_descuentoVenta,")
						.append(" aumusopre.id.valorTipoUso as articuloPrecioCol_articuloUnidadManejo_articuloUnidadManejoUsoCol_id_valorTipoUso,")
						.append(" aumusopre.estado as articuloPrecioCol_articuloUnidadManejo_articuloUnidadManejoUsoCol_estado")
					
					.append(" from ").append(ArticuloDTO.class.getName()).append(" art")
					/* Codigo Barras */
					.append(" inner join art.artBitCodBarCol codbar ")
					/* Comercial */
					.append(" inner join art.articuloComercialDTO artcom ")
					/* Precios */
					.append(" left join art.articuloPrecioCol artpre ")					
					/* Impuestos */
					.append(" left join art.articuloImpuestoCol artimp ")
					/* Tipos Impuestos */
					.append(" left join artimp.tipoImpuestoArticulo tipimp ")
					/* Unidades de Manejo */
					.append(" left join artpre.articuloUnidadManejo aumpre ")
					.append(" left join aumpre.articuloUnidadManejoUsoCol aumusopre ")
					
					/* Costos */
					.append(" inner join art.articuloProveedorCol artpro ")
					.append(" inner join artpro.proveedor pro ")
					.append(" left join artpro.descuentoProveedorArticuloCol des ")
					.append(" left join des.equivalenciaPorcentajeDescuento equi ")
					.append(" left join des.asignacionTipoDescuento atd")					
					.append(" left join artpro.unidadesManejo uniman ")	
					.append(" left join uniman.equivalenciaPorcentajeDescuentoCol unimanequi ")
					.append(" where art.id.codigoCompania = :pCodigoCompania ");
			
			if(codigoArticulos != null && codigoArticulos.length > 0){
				hql.append(" and art.id.codigoArticulo in (:pCodigoArticulos) ");
			}			
					
			hql.append("and art.estadoArticulo = :pEstado and codbar.estadoArticuloBitacora = :pEstado ");
			
			if(codigoProveedores != null && codigoProveedores.length > 0){	
				hql.append("and artpro.id.codigoProveedor in (:pCodigoProveedores) ");
			}
			
			hql.append("and artpro.estadoArticuloProveedor = :pEstado");
		
			/*Se obtiene la sesion de hibernate y se limpia*/
			final Session session = this.sessionFactory.getCurrentSession();	
			session.clear();	
			
			/*Se prepara el query de busqueda*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			query.setParameter("pCodigoCompania", codigoCompania);
			if(codigoArticulos != null && codigoArticulos.length > 0){
				query.setParameterList("pCodigoArticulos", codigoArticulos);
			}
			if(codigoProveedores != null && codigoProveedores.length > 0){
				query.setParameterList("pCodigoProveedores", codigoProveedores);
			}
			query.setParameter("pEstado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			
			/*Nuevo transformador multinivel*/
			query.setResultTransformer(new MultiLevelResultTransformer(ArticuloDTO.class));
			
			/*Ejecutamos la consulta*/
			articuloInfoVOCol = query.list();
			return articuloInfoVOCol;
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al obtener informacion general articulo.", e);
		}	
	}
	
	/**
	 * Obtener el listado de codigos de barras de los articulos con error en la asignacion de alcance
	 */
	public Collection<ArticuloDTO> obtenerArticulos(Collection<String> codigosArticulo) throws SICException {
		try {
			this.sessionFactory.getCurrentSession().clear();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloDTO.class,"articulo");
			criteria.createAlias("artBitCodBarCol", "artBitCodBarCol");
			
			criteria.add(Restrictions.in("id.codigoArticulo", codigosArticulo));
			criteria.add(Restrictions.eq("artBitCodBarCol.estadoArticuloBitacora", SICConstantes.getInstancia().ESTADO_ACTIVO_NUMERICO));
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo")
					.add(Projections.property("descripcionArticulo"),"descripcionArticulo")
					.add(Projections.property("artBitCodBarCol.id.codigoBarras"), "codigoBarrasActivo.id.codigoBarras"));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));
			
			return (Collection<ArticuloDTO>)criteria.list();
		} catch (SICException e) {
			throw new SICException("Error al obtener articulos : ",e);
		}
	}
	
	/**
	 * Metodo que permite obtener la informacion general de articulos, costos
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @param codigoProveedores
	 * @return
	 */
	@Override
	public Collection<ArticuloDTO> obtenerInformacionArticulo(Integer codigoCompania, String[] codigoArticulos, String[] codigoBarras, String[] codigoClasificacion, String[] codigoProveedores, EnumTipoRelacionArticulo... tiposRelacion){
		LOG_SICV2.info("==> obtener informacion general articulo.");
		Collection<ArticuloDTO> articuloInfoVOCol;
		try{
			/*Se prepara el hql de busqueda*/
			final StringBuilder hql = new StringBuilder("select art.id.codigoCompania as id_codigoCompania, art.id.codigoArticulo as id_codigoArticulo,")
					.append(" art.descripcionArticulo as descripcionArticulo, art.claseArticulo as claseArticulo,")
					.append(" art.codigoClasificacion as codigoClasificacion, art.leyendaArticulo as leyendaArticulo,");
					
					/* Codigo Barras */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_BITACORA)){
						hql.append(" codbar.id.codigoBarras as artBitCodBarCol_id_codigoBarras, codbar.estadoArticuloBitacora as artBitCodBarCol_estadoArticuloBitacora,");	
					}
					
					/* Articulo Comercial */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_COMERCIAL)){
						hql.append(" artcom.porcentajeNoAfiliado as articuloComercialDTO_porcentajeNoAfiliado,")
						.append(" artcom.ventaPrecioAfiliado as articuloComercialDTO_ventaPrecioAfiliado,")
						.append(" artcom.codigoMarcaComercial as articuloComercialDTO_codigoMarcaComercial,");
					}
					
					/* Marca */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_MARCA)){
						hql.append(" artmar.nombre as articuloComercialDTO_marcaComercialArticulo_nombre,");
					}
					
					/* Articulo Medida */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_MEDIDA)){
						hql.append(" artmed.referenciaMedida as articuloMedidaDTO_referenciaMedida,")
						.append(" artmed.cantidadMedida as articuloMedidaDTO_cantidadMedida,")
						.append(" artmed.valorTipoMedida as articuloMedidaDTO_valorTipoMedida,")
						.append(" artmed.presentacion as articuloMedidaDTO_presentacion,");
					}
					
					/* Proveedores - Costos */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_COSTO)){
						/* Proveedores */
						hql.append(" artpro.id.codigoProveedor as articuloProveedorCol_id_codigoProveedor,")
						.append(" artpro.codigoReferenciaProveedor as articuloProveedorCol_codigoReferenciaProveedor,")
						.append(" artpro.codigoReferenciaInterna as articuloProveedorCol_codigoReferenciaInterna,")
						.append(" pro.id.codigoProveedor as articuloProveedorCol_proveedor_id_codigoProveedor, pro.nombreProveedor as articuloProveedorCol_proveedor_nombreProveedor,")
						
						/* Costos */
						.append(" artpro.costoBruto as articuloProveedorCol_costoBruto,")						
						.append(" atd.prioridad as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_prioridad,")
						.append(" atd.valorAplicacionTipoDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_valorAplicacionTipoDescuento,")//<>TIPODESCUENTO
						.append(" des.estado as articuloProveedorCol_descuentoProveedorArticuloCol_estado,")
						.append(" des.porcentajeDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_porcentajeDescuento,")
						.append(" equi.descuento as articuloProveedorCol_descuentoProveedorArticuloCol_equivalenciaPorcentajeDescuento_descuento,")
						.append(" uniman.estado as articuloProveedorCol_unidadesManejo_estado,")
						.append(" unimanequi.descuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_descuento,");
					}
					
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_PRECIO_COMPLETO)){
					/* Precios */
						hql.append(" artpre.id.codigoTipoPrecio as articuloPrecioCol_id_codigoTipoPrecio,")
						.append(" artpre.codigoUnidadManejo as articuloPrecioCol_codigoUnidadManejo,")
						.append(" artpre.estadoPrecio as articuloPrecioCol_estadoPrecio,")
						.append(" artpre.valorActual as articuloPrecioCol_valorActual,")
						/* Impuestos */
						.append(" artimp.id.codigoTipoImpuesto as articuloImpuestoCol_id_codigoTipoImpuesto,")
						.append(" artimp.estadoArticuloImpuesto as articuloImpuestoCol_estadoArticuloImpuesto,")
						.append(" artimp.esParaVenta as articuloImpuestoCol_esParaVenta,")
						.append(" artimp.esParaCompra as articuloImpuestoCol_esParaCompra,")
						/* Tipos de impuestos */
						.append(" tipimp.codigoGrupoImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_codigoGrupoImpuesto,")
						.append(" tipimp.porcentajeImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_porcentajeImpuesto,")
						.append(" tipimp.estadoTipoImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_estadoTipoImpuesto,")
						.append(" tipimp.valorImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_valorImpuesto,")	
						/* Unidades de Manejo*/
						.append(" aumpre.estadoUnidadManejo as articuloPrecioCol_articuloUnidadManejo_estadoUnidadManejo,")
						.append(" aumpre.valorUnidadManejo as articuloPrecioCol_articuloUnidadManejo_valorUnidadManejo,")
						.append(" aumpre.descuentoVenta as articuloPrecioCol_articuloUnidadManejo_descuentoVenta,")
						.append(" aumusopre.id.valorTipoUso as articuloPrecioCol_articuloUnidadManejo_articuloUnidadManejoUsoCol_id_valorTipoUso,")
						.append(" aumusopre.estado as articuloPrecioCol_articuloUnidadManejo_articuloUnidadManejoUsoCol_estado");
					}
					
					
					hql.append(" from ").append(ArticuloDTO.class.getName()).append(" art");
					
					/* Codigo Barras */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_BITACORA)){
						hql.append(" inner join art.artBitCodBarCol codbar ");
					}
					
					/* Comercial */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_COMERCIAL)){
						hql.append(" inner join art.articuloComercialDTO artcom ");
					}
					
					/* Marca */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_MARCA)){
						hql.append(" left join artcom.marcaComercialArticulo artmar ");
					}
					
					/* Articulo Medida */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_MEDIDA)){
						hql.append(" inner join art.articuloMedidaDTO artmed ");
					}
					
					/* Precios */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_PRECIO_COMPLETO)){
						hql.append(" left join art.articuloPrecioCol artpre ")					
						/* Impuestos */
						.append(" left join art.articuloImpuestoCol artimp ")
						/* Tipos Impuestos */
						.append(" left join artimp.tipoImpuestoArticulo tipimp ")
						/* Unidades de Manejo */
						.append(" left join artpre.articuloUnidadManejo aumpre ")
						.append(" left join aumpre.articuloUnidadManejoUsoCol aumusopre ");
					}
					
					/* Costos */
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_COSTO)){
						hql.append(" inner join art.articuloProveedorCol artpro ")
						.append(" inner join artpro.proveedor pro ")
						.append(" left join artpro.descuentoProveedorArticuloCol des ")
						.append(" left join des.equivalenciaPorcentajeDescuento equi ")
						.append(" left join des.asignacionTipoDescuento atd")
						.append(" left join artpro.unidadesManejo uniman ")	
						.append(" left join uniman.equivalenciaPorcentajeDescuentoCol unimanequi ");
						
					}
					
					hql.append(" where art.id.codigoCompania = :pCodigoCompania ");
			
					if(codigoArticulos != null && codigoArticulos.length > 1){
						hql.append(" and art.id.codigoArticulo in (:pCodigoArticulos) ");
					}
					if(codigoArticulos != null && codigoArticulos.length == 1){
						hql.append(" and art.id.codigoArticulo = :pCodigoArticulos ");
					}
					
					hql.append("and art.estadoArticulo = :pEstado ");
					
					if(codigoClasificacion != null && codigoClasificacion.length > 1){
						hql.append(" and art.codigoClasificacion in (:pCodigoClasificacion) ");
					}
					if(codigoClasificacion != null && codigoClasificacion.length == 1){
						hql.append(" and art.codigoClasificacion = :pCodigoClasificacion ");
					}
					
					if(ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_BITACORA)){
						if(codigoBarras != null && codigoBarras.length > 1){
							hql.append(" and codbar.id.codigoBarras in (:pCodigoBarras) ");
						}
						if(codigoBarras != null && codigoBarras.length == 1){
							hql.append(" and codbar.id.codigoBarras = :pCodigoBarras ");
						}
						hql.append("and codbar.estadoArticuloBitacora = :pEstado ");
					}
					
					if(codigoProveedores != null && codigoProveedores.length > 0 && ArrayUtils.contains(tiposRelacion, EnumTipoRelacionArticulo.ARTICULO_COSTO)){	
						hql.append("and artpro.id.codigoProveedor in (:pCodigoProveedores) ")
						.append("and artpro.estadoArticuloProveedor = :pEstado");
					}
				
					/*Se obtiene la sesion de hibernate y se limpia*/
					final Session session = this.sessionFactory.getCurrentSession();	
					session.clear();	
					
					/*Se prepara el query de busqueda*/
					Query query = session.createQuery(hql.toString());
					
					/*Se asignan los parametros al query*/
					query.setParameter("pCodigoCompania", codigoCompania);
					if(codigoArticulos != null && codigoArticulos.length > 1){
						query.setParameterList("pCodigoArticulos", codigoArticulos);
					}
					
					if(codigoArticulos != null && codigoArticulos.length == 1){
						query.setParameter("pCodigoArticulos", codigoArticulos[0]);
					}
					
					if(codigoBarras != null && codigoBarras.length > 1){
						query.setParameterList("pCodigoBarras", codigoBarras);
					}
					
					if(codigoBarras != null && codigoBarras.length == 1){
						query.setParameter("pCodigoBarras", codigoBarras[0]);
					}
					
					if(codigoClasificacion != null && codigoClasificacion.length > 1){
						query.setParameterList("pCodigoClasificacion", codigoClasificacion);
					}
					
					if(codigoClasificacion != null && codigoClasificacion.length == 1){
						query.setParameter("pCodigoClasificacion", codigoClasificacion[0]);
					}
					
					if(codigoProveedores != null && codigoProveedores.length > 0){
						query.setParameterList("pCodigoProveedores", codigoProveedores);
					}
					query.setParameter("pEstado", SICConstantes.ESTADO_ACTIVO_NUMERICO);
					
					/*Nuevo transformador multinivel*/
					query.setResultTransformer(new MultiLevelResultTransformer(ArticuloDTO.class));
					
					/*Ejecutamos la consulta*/
					articuloInfoVOCol = query.list();
					return articuloInfoVOCol;
		}catch(Exception e){
			throw new SICException("Ha ocurrido un error al obtener informacion general articulo.", e);
		}	
	}
	
	/**
	 * metodo que obtiene la informacion de costos del articulo
	 * @author adgonzalez
	 * @param codigoArticulos
	 * @return costosPorArticulos
	 * @throws SICException
	 */
	
	public Collection<ArticuloDTO> obtenerCostosArticulos(String[] codigoArticulos)throws SICException{
		LOG_SICV2.info("==> obtener costos por articulo.");
		Collection<ArticuloDTO> costosPorArticulos=new ArrayList<ArticuloDTO>();
		Criteria select;
		try{
			final StringBuilder hql = new StringBuilder("select art.id.codigoCompania as id_codigoCompania, ")
			.append(" art.descripcionArticulo as descripcionArticulo, ")
			.append(" codbar.id.codigoBarras as artBitCodBarCol_id_codigoBarras, codbar.estadoArticuloBitacora as artBitCodBarCol_estadoArticuloBitacora, ")
			.append(" art.id.codigoArticulo as id_codigoArticulo, art.codigoTipoArticulo as codigoTipoArticulo, ")
			.append(" artpro.costoBruto as articuloProveedorCol_costoBruto, ")
			.append(" pim.codigoMonedaOrigen as articuloProveedorCol_articuloImportacion_codigoMonedaOrigen, ")
			.append(" pim.costoMonedaOrigen as articuloProveedorCol_articuloImportacion_costoMonedaOrigen, ")
			.append(" pim.porcentajeComision as articuloProveedorCol_articuloImportacion_porcentajeComision, ")
			.append(" api.esParaVenta as articuloProveedorCol_articuloProveedorImpuestoCol_esParaVenta, ")
			.append(" api.esParaCompra as articuloProveedorCol_articuloProveedorImpuestoCol_esParaCompra, ")
			.append(" api.estado as articuloProveedorCol_articuloProveedorImpuestoCol_estado, ")
			.append(" tim.porcentajeImpuesto as articuloProveedorCol_articuloProveedorImpuestoCol_tipoImpuestoDTO_porcentajeImpuesto, ")
			.append(" tim.codigoGrupoImpuesto as articuloProveedorCol_articuloProveedorImpuestoCol_tipoImpuestoDTO_codigoGrupoImpuesto ")
			.append(" from ").append(ArticuloDTO.class.getName()).append(" art")
			.append(" left join art.articuloProveedorCol artpro ")
			.append(" left join artpro.articuloImportacion pim ")
			.append(" left join artpro.articuloProveedorImpuestoCol api ")
			.append(" left join api.tipoImpuestoDTO tim ");
			
			if(codigoArticulos != null && codigoArticulos.length > 0){
				hql.append(" where art.id.codigoArticulo in (:pCodigoArticulos) ");
			}		
			
			/*Se obtiene la sesion de hibernate y se limpia*/
			final Session session = this.sessionFactory.getCurrentSession();	
			session.clear();	
			
			/*Se prepara el query de busqueda*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			if(codigoArticulos != null && codigoArticulos.length > 0){
				query.setParameterList("pCodigoArticulos", codigoArticulos);
			}
			
			/*Nuevo transformador multinivel*/
			query.setResultTransformer(new MultiLevelResultTransformer(ArticuloDTO.class));
			/*Ejecutamos la consulta*/
			costosPorArticulos = query.list();
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error(e.getMessage());
			//throw new SICException("Ha ocurrido un error al obtener los costos del artículo.", e);
		}
		
		
		return costosPorArticulos;
	}

	/**
	 * Metodo que obtiene la informacion de costos netos del articulo
	 * @param codigoArticulos
	 * @return costosPorArticulos
	 * @author adgonzalez, rali
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerCostosNetosArticulos(String[] codigoArticulos,String[] codigoProveedor)throws SICException{
		LOG_SICV2.info("==> obtener costos netos por articulo.");
		Collection<ArticuloDTO> costosPorArticulos=new ArrayList<ArticuloDTO>();
		Criteria select;
		try{
			final StringBuilder hql = new StringBuilder("select art.id.codigoCompania as id_codigoCompania, art.id.codigoArticulo as id_codigoArticulo, ")
			.append(" art.descripcionArticulo as descripcionArticulo, ")
			.append(" art.codigoBarras as codigoBarras,")
			.append(" artcla.id.codigoCompania as clasificacionDTO_id_codigoCompania, ")			
			.append(" artcla.codigoClasificacionPadre as clasificacionDTO_codigoClasificacionPadre,")			
			.append(" artpro.id.codigoCompania as articuloProveedorCol_id_codigoCompania, ")
			.append(" artpro.id.codigoArticulo as articuloProveedorCol_id_codigoArticulo, ")
			.append(" artpro.id.codigoProveedor as articuloProveedorCol_id_codigoProveedor, ")
			.append(" artpro.codigoReferenciaProveedor as articuloProveedorCol_codigoReferenciaProveedor,")
			.append(" artpro.costoBruto as articuloProveedorCol_costoBruto, ")
			.append(" pim.id.codigoCompania as articuloProveedorCol_articuloImportacion_id_codigoCompania, ")
			.append(" pim.id.codigoArticulo as articuloProveedorCol_articuloImportacion_id_codigoArticulo, ")
			.append(" pim.id.codigoProveedor as articuloProveedorCol_articuloImportacion_id_codigoProveedor, ")			
			.append(" pim.codigoMonedaOrigen as articuloProveedorCol_articuloImportacion_codigoMonedaOrigen, ")
			.append(" pim.costoMonedaOrigen as articuloProveedorCol_articuloImportacion_costoMonedaOrigen, ")
			.append(" pim.porcentajeComision as articuloProveedorCol_articuloImportacion_porcentajeComision, ")		
			.append(" dpa.id.codigoCompania as articuloProveedorCol_descuentoProveedorArticuloCol_id_codigoCompania, ")			
			.append(" dpa.id.secuencialDescuentoArticuloProveedor as articuloProveedorCol_descuentoProveedorArticuloCol_id_secuencialDescuentoArticuloProveedor, ")
			.append(" dpa.codigoArticulo as articuloProveedorCol_descuentoProveedorArticuloCol_codigoArticulo, ")
			.append(" dpa.codigoProveedor as articuloProveedorCol_descuentoProveedorArticuloCol_codigoProveedor, ")			
			.append(" dpa.estado as articuloProveedorCol_descuentoProveedorArticuloCol_estado, ")
			.append(" dpa.porcentajeDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_porcentajeDescuento, ")												
			.append(" dpa.secuencialAsignacionTipoDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_secuencialAsignacionTipoDescuento, ")						
			.append(" atdp.id.codigoCompania as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_id_codigoCompania, ")
			.append(" atdp.id.secuencialAsignacionTipoDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_id_secuencialAsignacionTipoDescuento, ")								
			.append(" atdp.valorAplicacionTipoDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_valorAplicacionTipoDescuento, ")			
			.append(" atdp.codigoTipoDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_codigoTipoDescuento, ")			
			.append(" tdp.id.codigoCompania as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_tipoDescuento_id_codigoCompania, ")
			.append(" tdp.id.codigoTipoDescuento as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_tipoDescuento_id_codigoTipoDescuento, ")
			.append(" tdp.valorTipoUso as articuloProveedorCol_descuentoProveedorArticuloCol_asignacionTipoDescuento_tipoDescuento_valorTipoUso, ")			
			.append(" epd.id.codigoCompania as articuloProveedorCol_descuentoProveedorArticuloCol_equivalenciaPorcentajeDescuento_id_codigoCompania, ")
			.append(" epd.id.codigoEquivalencia as articuloProveedorCol_descuentoProveedorArticuloCol_equivalenciaPorcentajeDescuento_id_codigoEquivalencia, ")			
			.append(" epd.descuento as articuloProveedorCol_descuentoProveedorArticuloCol_equivalenciaPorcentajeDescuento_descuento, ")									
			.append(" um.id.codigoCompania as articuloProveedorCol_unidadesManejo_id_codigoCompania, ")
			.append(" um.id.codigoProveedor as articuloProveedorCol_unidadesManejo_id_codigoProveedor, ")
			.append(" um.id.codigoUnidadManejo as articuloProveedorCol_unidadesManejo_id_codigoUnidadManejo, ")			
			.append(" um.codigoArticulo as articuloProveedorCol_unidadesManejo_codigoArticulo, ")			
			.append(" um.estado as articuloProveedorCol_unidadesManejo_estado, ")			
			.append(" epdum.id.codigoCompania as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_id_codigoCompania, ")
			.append(" epdum.id.codigoEquivalencia as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_id_codigoEquivalencia, ")
			.append(" epdum.valorPorcentaje as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_valorPorcentaje, ")			
			.append(" epdum.descuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_descuento, ")
			.append(" epdum.estado as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_estado, ")
			.append(" atd.id.codigoCompania as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_id_codigoCompania, ")			
			.append(" atd.id.secuencialAsignacionTipoDescuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_id_secuencialAsignacionTipoDescuento, ")			
			.append(" atd.codigoAsignacionTipoDescuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_codigoAsignacionTipoDescuento, ")			
			.append(" atd.valorAsignacionTipoDescuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_valorAsignacionTipoDescuento, ")
			.append(" atd.estado as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_estado, ")
			.append(" atd.codigoTipoDescuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_codigoTipoDescuento, ")
			.append(" atd.codigoAplicacionTipoDescuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_codigoAplicacionTipoDescuento, ")			
			.append(" atd.valorAplicacionTipoDescuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_valorAplicacionTipoDescuento, ")			
			.append(" td.id.codigoCompania as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_tipoDescuento_id_codigoCompania, ")
			.append(" td.id.codigoTipoDescuento as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_tipoDescuento_id_codigoTipoDescuento, ")
			.append(" td.valorTipoUso as articuloProveedorCol_unidadesManejo_equivalenciaPorcentajeDescuentoCol_asignacionTipoDescuento_tipoDescuento_valorTipoUso, ")						
			.append(" apc.id.codigoCompania as articuloProveedorCol_articuloProveedorCostoCol_id_codigoCompania, ")
			.append(" apc.id.codigoArticulo as articuloProveedorCol_articuloProveedorCostoCol_id_codigoArticulo, ")
			.append(" apc.id.codigoProveedor as articuloProveedorCol_articuloProveedorCostoCol_id_codigoProveedor, ")
			.append(" apc.id.valorTipoCosto as articuloProveedorCol_articuloProveedorCostoCol_id_valorTipoCosto, ")			
			.append(" apc.id.codigoTipoCosto as articuloProveedorCol_articuloProveedorCostoCol_id_codigoTipoCosto, ")
			.append(" apc.valor as articuloProveedorCol_articuloProveedorCostoCol_valor ")						
			.append(" from ").append(ArticuloDTO.class.getName()).append(" art")
			.append(" left join art.clasificacionDTO artcla ")
			.append(" left join art.articuloProveedorCol artpro ")
			.append(" left join artpro.articuloImportacion pim ")				
			.append(" left join artpro.descuentoProveedorArticuloCol dpa ")
			.append(" left join dpa.asignacionTipoDescuento atdp ")
			.append(" left join atdp.tipoDescuento tdp ")			
			.append(" left join dpa.equivalenciaPorcentajeDescuento epd ")			
			.append(" left join artpro.unidadesManejo um ")			
			.append(" left join um.equivalenciaPorcentajeDescuentoCol epdum ")
			.append(" left join epdum.asignacionTipoDescuento atd ")			
			.append(" left join atd.tipoDescuento td ")						
			.append(" left join artpro.articuloProveedorCostoCol apc ");
			
			if(codigoArticulos != null && codigoArticulos.length > 0){
				hql.append(" where art.id.codigoArticulo in (:pCodigoArticulos) ");
				if(codigoProveedor != null && codigoProveedor.length > 0){
					hql.append(" and artpro.id.codigoProveedor in (:pCodigoProveedor) ");
				}	
			}	
			
			/*Se obtiene la sesion de hibernate y se limpia*/
			final Session session = this.sessionFactory.getCurrentSession();	
			session.clear();	
			
			/*Se prepara el query de busqueda*/
			Query query = session.createQuery(hql.toString());
			
			/*Se asignan los parametros al query*/
			if(codigoArticulos != null && codigoArticulos.length > 0){
				query.setParameterList("pCodigoArticulos", codigoArticulos);
			}
			if(codigoProveedor != null && codigoProveedor.length > 0){
				query.setParameterList("pCodigoProveedor", codigoProveedor);
			}
			
			/*Nuevo transformador multinivel*/
			query.setResultTransformer(new MultiLevelResultTransformer(ArticuloDTO.class));
			/*Ejecutamos la consulta*/
			costosPorArticulos = query.list();
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error(e.getMessage());
			//throw new SICException("Ha ocurrido un error al obtener los costos del artículo.", e);
		}
		
		
		return costosPorArticulos;
	}
	
	/**
	 * Autor rali Metodo que permite obtener la información de precios de un
	 * artículo, dados sus códigos
	 * 
	 * @param codigoArticulos
	 * @return
	 */
	@Override
	public Collection<ArticuloDTO> obtenerPreciosPorCodigo(Integer codigoCompania,String[] codigoArticulos) {
		LOG_SICV2.info("==> obtener informacion de precios de articulos ");
		ArticuloDTO articulo = null;
		try {
			// /*hql para la busqueda*/
			final StringBuilder hql = new StringBuilder("select art.id.codigoArticulo as id_codigoArticulo, ")
			        .append(" codbar.id.codigoBarras as artBitCodBarCol_id_codigoBarras, art.descripcionArticulo as descripcionArticulo, art.claseArticulo as claseArticulo,")
					.append(" art.codigoClasificacion as codigoClasificacion,")
					.append(" articuloMedidaDTO.presentacion as articuloMedidaDTO_presentacion, ")
					.append(" articuloComercialDTO.ventaPrecioAfiliado as articuloComercialDTO_ventaPrecioAfiliado, ")
					.append(" articuloComercialDTO.porcentajeNoAfiliado as articuloComercialDTO_porcentajeNoAfiliado, ")					
							
					.append(" articuloPrecioCol.id.codigoCompania as articuloPrecioCol_id_codigoCompania, ")
					.append(" articuloPrecioCol.id.codigoArticulo as articuloPrecioCol_id_codigoArticulo, ")
					.append(" articuloPrecioCol.id.codigoTipoPrecio as articuloPrecioCol_id_codigoTipoPrecio, ")
					.append(" articuloPrecioCol.valorActual as articuloPrecioCol_valorActual, ")
					.append(" articuloPrecioCol.estadoPrecio as articuloPrecioCol_estadoPrecio, ")
					
					.append(" articuloImpuestoCol.estadoArticuloImpuesto as articuloImpuestoCol_estadoArticuloImpuesto, ")
					.append(" articuloImpuestoCol.esParaVenta as articuloImpuestoCol_esParaVenta, ")
					.append(" articuloImpuestoCol.esParaCompra as articuloImpuestoCol_esParaCompra, ")
					
					.append(" tipoImpuestoArticulo.codigoGrupoImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_codigoGrupoImpuesto, ")
					.append(" tipoImpuestoArticulo.porcentajeImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_porcentajeImpuesto, ")
					.append(" tipoImpuestoArticulo.valorImpuesto as articuloImpuestoCol_tipoImpuestoArticulo_valorImpuesto, ")	
					
					.append(" articuloUnidadManejo.estadoUnidadManejo as articuloPrecioCol_articuloUnidadManejo_estadoUnidadManejo, ")
					.append(" articuloUnidadManejo.valorUnidadManejo as articuloPrecioCol_articuloUnidadManejo_valorUnidadManejo, ")
					.append(" articuloUnidadManejo.descuentoVenta as articuloPrecioCol_articuloUnidadManejo_descuentoVenta, ")
					.append(" articuloUnidadManejoUsoCol.id.valorTipoUso as articuloPrecioCol_articuloUnidadManejo_articuloUnidadManejoUsoCol_id_valorTipoUso, ")
					.append(" articuloUnidadManejoUsoCol.estado as articuloPrecioCol_articuloUnidadManejo_articuloUnidadManejoUsoCol_estado ")
					
					.append(" from ")
					.append(ArticuloDTO.class.getName()).append(" art")
					.append(" inner join art.artBitCodBarCol codbar ")
					.append(" inner join art.articuloComercialDTO articuloComercialDTO ")
					.append(" left join art.articuloMedidaDTO articuloMedidaDTO ")
					.append(" left join art.articuloPrecioCol articuloPrecioCol ")
					.append(" left join articuloPrecioCol.articuloUnidadManejo articuloUnidadManejo ")
					.append(" left join articuloUnidadManejo.articuloUnidadManejoUsoCol articuloUnidadManejoUsoCol ")
					
					.append(" left join art.articuloImpuestoCol articuloImpuestoCol ")
					.append(" left join articuloImpuestoCol.tipoImpuestoArticulo tipoImpuestoArticulo ")	
					
					.append(" where art.id.codigoCompania = :pCodigoCompania ");

			if (codigoArticulos != null && codigoArticulos.length > 0) {
				hql.append(" and art.id.codigoArticulo in (:pCodigoArticulos) ");
			}
			//
			 hql.append("and art.estadoArticulo = :pEstado and codbar.estadoArticuloBitacora = :pEstado ");
			//
			/* Se obtiene la sesion de hibernate y se limpia */
			final Session session = this.sessionFactory.getCurrentSession();
			session.clear();

			 Query query = session.createQuery(hql.toString());
			 query.setParameter("pEstado",SICConstantes.ESTADO_ACTIVO_NUMERICO);
			 query.setParameter("pCodigoCompania",codigoCompania);
			 query.setParameterList("pCodigoArticulos", codigoArticulos);
			//
			// /*Nuevo transformador multinivel*/
			 query.setResultTransformer(new MultiLevelResultTransformer(ArticuloDTO.class));
			 return query.list();
		} catch (Exception e) {
			throw new SICException("Ha ocurrido un error al obtener informacion general articulo.", e);
		}

	}
	/**
	 * M&eacute;todo para ejecutar el procedimiento almacenado en la base de datos invalidar articulos anteriores a la fecha indicada
	 * 
	 * @author adgonzalez
	 * @throws SICException
	 */
	public void invalidarArticulosFecha(Integer codigoCompania, String codigoEstado, Integer habilitaFechaCreacion,String codigoLineaComercial) throws SICException {
		Session session = hibernateH.getHibernateSession();
		try {
			Logeable.LOG_SICV2.info("Iniciando invalidarArticulosFecha");
			
			// Tiene 4 parametros
			// Parametros
			// 1 - codigoCompania
			// 2 - habilitaFechaCreacion
			// 3 - codigoLineaComercial
			// 4 - estado
			session.clear();
			Query query = session.createSQLQuery("call PROINVARTFEC(?,?,?,?)")
					.setInteger(0, codigoCompania)
					.setString(1, codigoEstado)
					.setInteger(2, habilitaFechaCreacion)
					.setString(3, codigoLineaComercial);								
			query.executeUpdate();

			Logeable.LOG_SICV2.info("1 - codigoCompania: {}", codigoCompania);
			Logeable.LOG_SICV2.info("2 - codigoEstado: {}", codigoEstado);
			Logeable.LOG_SICV2.info("3 - habilitaFechaCreacion: {}", habilitaFechaCreacion);
			Logeable.LOG_SICV2.info("4 - codigoLineaComercial: {}", codigoLineaComercial);			
			Logeable.LOG_SICV2.info("Fin ejecutarInvalidarArticulosFecha");
			
		} catch (Exception ex) {
			ex.getStackTrace();
			throw new SICException(ex.getMessage(),ex);
		}finally{
			session = null;
		}
	}

	/**
	 * metodo que obtiene la informacion del articulo en base al codigo dereferencia y codigo de articulo
	 * @author adgonzalez
	 * @param codigoArticulos
	 * @return costosPorArticulos
	 * @throws SICException
	 */
	
	public Collection<ArticuloDTO> validarArticuloRelacion(ArticuloVO articuloVO)throws SICException{
		LOG_SICV2.info("==> validar articulos relacion.");
		Collection<ArticuloDTO> articulosRelacionados=new ArrayList<ArticuloDTO>();
		Criteria select;
		try{
			if(articuloVO.getArticuloProveedorDTO().getCodigoReferenciaProveedor() != null){
				final StringBuilder hql = new StringBuilder("select art.id.codigoCompania as id_codigoCompania, ")
				.append(" art.id.codigoArticulo as id_codigoArticulo, ")
				.append(" art.descripcionArticulo as descripcionArticulo, ")
				.append(" art.fechaUltimaActualizacion as fechaUltimaActualizacion, ")
				.append(" art.usuarioActualizacion as usuarioActualizacion, ")
				.append(" art.valorTipoEstadoRegistro as valorTipoEstadoRegistro, ")
				.append(" art.codigoTipoArticulo as codigoTipoArticulo, ")
				.append(" artpro.codigoReferenciaProveedor as articuloProveedorCol_codigoReferenciaProveedor, ")
				.append(" artpro.id.codigoProveedor as articuloProveedorCol_id_codigoProveedor, ")
				.append(" codbar.estadoArticuloBitacora as artBitCodBarCol_estadoArticuloBitacora, ")
				.append(" codbar.id.codigoBarras as artBitCodBarCol_id_codigoBarras, ")
				.append(" cla.descripcionClasificacion as clasificacionDTO_descripcionClasificacion, ")
				.append(" cla.id.codigoClasificacion as clasificacionDTO_id_codigoClasificacion, ")
				.append(" usu.userCompleteName as usuarioActualizacionDTO_userCompleteName ")
				.append(" from ").append(ArticuloDTO.class.getName()).append(" art")
				.append(" left join art.articuloProveedorCol artpro ")
				.append(" left join art.artBitCodBarCol codbar ")
				.append(" left join art.clasificacionDTO cla ")
				.append(" left join art.usuarioActualizacionDTO usu ")
				.append(" where art.id.codigoCompania = :pCodigoCompania ")
				.append(" and art.estadoArticulo = :pEstadoArticulo ");
				
				if(articuloVO.getArticuloProveedorDTO().getCodigoReferenciaProveedor() != null){
					hql.append(" and artpro.codigoReferenciaProveedor = :pCodigoReferenciaProveedor ");
				}
				if(articuloVO.getArticuloProveedorDTO().getId().getCodigoProveedor() != null){
					hql.append(" and artpro.id.codigoProveedor = :pCodigoProveedor ");
				}
				if(articuloVO.getBaseDTO().getCodigoEstado() != null){
					hql.append(" and art.codigoEstado = :pCodigoEstado ");
				}
				
				if(articuloVO.getBaseDTO().getCodigoTipoArticulo() != null){
					hql.append(" and art.codigoTipoArticulo != :pTipoArticuloCupon ");
				}
				
				hql.append(" order by art.fechaUltimaActualizacion desc ");
				
				/*Se obtiene la sesion de hibernate y se limpia*/
				final Session session = this.sessionFactory.getCurrentSession();	
				session.clear();	
				
				/*Se prepara el query de busqueda*/
				Query query = session.createQuery(hql.toString());
				
				/*Se asignan los parametros al query*/
				query.setParameter("pCodigoCompania", articuloVO.getBaseDTO().getId().getCodigoCompania());
				
				query.setParameter("pEstadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				query.setParameter("pTipoArticuloCupon",SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON);
				
				if(articuloVO.getBaseDTO().getCodigoEstado() != null){
				query.setParameter("pCodigoEstado", articuloVO.getBaseDTO().getCodigoEstado());
				}
				if(articuloVO.getArticuloProveedorDTO().getId().getCodigoProveedor() != null){
				query.setParameter("pCodigoProveedor", articuloVO.getArticuloProveedorDTO().getId().getCodigoProveedor());
				}
				if(articuloVO.getArticuloProveedorDTO().getCodigoReferenciaProveedor() != null){
					query.setParameter("pCodigoReferenciaProveedor", articuloVO.getArticuloProveedorDTO().getCodigoReferenciaProveedor());
				}
				
				/*Nuevo transformador multinivel*/
				query.setResultTransformer(new MultiLevelResultTransformer(ArticuloDTO.class));
				/*Ejecutamos la consulta*/
				articulosRelacionados = query.list();

			}else{
				articulosRelacionados=null;
			}
			
		}catch(Exception e){
			Logeable.LOG_SICV2.error(e.getMessage());
		}	
		return articulosRelacionados;
	}
	
	@Override
	public void inactivarArticulo(Integer codigoCompania, String codigoArticulo, String userId) throws SICException{
		StringBuilder query = new StringBuilder();
		Session session;
		try {
			session = this.sessionFactory.getCurrentSession();
			session.clear();
			query.append("update ").append(ArticuloDTO.class.getName()).append(" art")
			.append(" set art.estadoArticulo = :pEstadoInactivo, art.usuarioActualizacion = :pUserId, art.fechaUltimaActualizacion = current_timestamp()")
			.append(" where art.id.codigoCompania = :pCompania and art.id.codigoArticulo = :pCodigoArticulo");
			Query update = session.createQuery(query.toString());
			update.setInteger("pCompania", codigoCompania);
			update.setString("pCodigoArticulo", codigoArticulo);
			update.setString("pEstadoInactivo", SICConstantes.ESTADO_INACTIVO_NUMERICO);
			update.setString("pUserId", userId);
			update.executeUpdate();
		} catch (Exception e) {
			LOG_SICV2.error("Error al inactivar el articulo: {0}", codigoArticulo);
			throw new SICException("Error al inactivar el articulo: " + codigoArticulo, e);
		}
	}
	
	/**
	 * Obtiene la coleccion de articulos en base del articuloVO
	 * @param articuloVO
	 * @param codigoCompania
	 * @param obtenerRelaciones valor booleano que trae las relaciones de ArticuloDTO
	 * @param colClasificacionLeyMercado clasificaciones a las aplica la ley de mercado
	 * @return
	 * @throws SICException
	 * @author derazo
	 */
	@Override
	public Collection<ArticuloDTO> obtenerArticulosSinPaginar (ArticuloVO articuloVO, Integer codigoCompania, Boolean obtenerRelaciones, Collection <String> colClasificacionLeyMercado)throws SICException{
		Collection<ArticuloDTO> articulosCol = null;
		Session session = null;
		Criteria criteria = null;
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			
			criteria = session.createCriteria(ArticuloDTO.class, "art");
			criteria.add(Restrictions.eq("art.id.codigoCompania", codigoCompania));
			criteria.createAlias("clasificacionDTO", "clasificacionDTO",JoinType.LEFT.ordinal());
			criteria.createAlias("clasificacionDTO.bodegaDTO", "bodegaDTO",JoinType.LEFT.ordinal());
			criteria.createAlias("articuloImpuestoCol", "articuloImpuestoCol",JoinType.LEFT.ordinal());
			criteria.createAlias("articuloImpuestoCol.tipoImpuestoArticulo", "tipoImpuestoArticulo",JoinType.LEFT.ordinal());
			criteria.createAlias("articuloMedidaDTO", "articuloMedidaDTO",JoinType.LEFT.ordinal());
			criteria.createAlias("articuloPrecioCol", "articuloPrecioCol",JoinType.LEFT.ordinal());
			criteria.createAlias("articuloProveedorCol" , "articuloProveedorCol" , JoinType.LEFT.ordinal());
			criteria.createAlias("articuloProveedorCol.bitacoraArticuloProveedorCol" , "bitacoraArticuloProveedorCol" , JoinType.LEFT.ordinal());
			criteria.createAlias("bitacoraArticuloProveedorCol.bitacoraPrecio" , "bitacoraPrecio" , JoinType.LEFT.ordinal());
			criteria.createAlias("bitacoraPrecio.estadosBitacoraPrecio" , "estadosBitacoraPrecio" , JoinType.LEFT.ordinal());
			criteria.createAlias("claseArticuloDTO", "claseArticuloDTO",JoinType.LEFT.ordinal());
			criteria.createAlias("artBitCodBarCol", "artBitCodBarCol",JoinType.LEFT.ordinal());
			
			criteria.add(Restrictions.eq("articuloProveedorCol.id.codigoProveedor",articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getId().getCodigoProveedor()));
			if (articuloVO.getBaseDTO().getArtBitCodBarCol() != null && articuloVO.getBaseDTO().getArtBitCodBarCol().iterator().next().getId().getCodigoBarras() != null && StringUtils.isNotBlank(articuloVO.getBaseDTO().getArtBitCodBarCol().iterator().next().getId().getCodigoBarras())) {
				criteria.add(Restrictions.eq("artBitCodBarCol.id.codigoBarras", articuloVO.getBaseDTO().getArtBitCodBarCol().iterator().next().getId().getCodigoBarras() ));
			}
			if (articuloVO.getBaseDTO().getArticuloProveedorCol() != null && articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getCodigoReferenciaProveedor() != null && StringUtils.isNotBlank(articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getCodigoReferenciaProveedor())) {
				criteria.add(Restrictions.eq("articuloProveedorCol.codigoReferenciaProveedor", articuloVO.getBaseDTO().getArticuloProveedorCol().iterator().next().getCodigoReferenciaProveedor() ));
			}
			if (articuloVO.getBaseDTO().getDescripcionArticulo() != null && StringUtils.isNotBlank(articuloVO.getBaseDTO().getDescripcionArticulo())) {
				criteria.add(Restrictions.like("art.descripcionArticulo", articuloVO.getBaseDTO().getDescripcionArticulo().toUpperCase(), MatchMode.ANYWHERE ));
			}
			if (articuloVO.getBaseDTO().getCodigoClasificacion() != null && StringUtils.isNotBlank(articuloVO.getBaseDTO().getCodigoClasificacion())) {
				criteria.add(Restrictions.eq("art.codigoClasificacion", articuloVO.getBaseDTO().getCodigoClasificacion() ));
			}
			if (articuloVO.getBaseDTO().getClasificacionDTO() != null && articuloVO.getBaseDTO().getClasificacionDTO().getCodigoClasificacionPadre() != null && StringUtils.isNotBlank(articuloVO.getBaseDTO().getClasificacionDTO().getCodigoClasificacionPadre())) {
				criteria.add(Restrictions.eq("clasificacionDTO.codigoClasificacionPadre", articuloVO.getBaseDTO().getClasificacionDTO().getCodigoClasificacionPadre() ));
			}
			if(colClasificacionLeyMercado != null &&  !colClasificacionLeyMercado.isEmpty()){
				criteria.add(Restrictions.in("art.codigoClasificacion", colClasificacionLeyMercado ));
			}
			criteria.add(Restrictions.eq("art.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO ));
			if(obtenerRelaciones){
				criteria.setFetchMode("clasificacionDTO", FetchMode.JOIN);
				criteria.setFetchMode("bodegaDTO", FetchMode.JOIN);
				criteria.setFetchMode("articuloImpuestoCol", FetchMode.JOIN);
				criteria.setFetchMode("tipoImpuestoArticulo", FetchMode.JOIN);
				criteria.setFetchMode("articuloMedidaDTO", FetchMode.JOIN);
				criteria.setFetchMode("articuloPrecioCol", FetchMode.JOIN);
				criteria.setFetchMode("articuloProveedorCol", FetchMode.JOIN);
				criteria.setFetchMode("bitacoraArticuloProveedorCol", FetchMode.JOIN);
				criteria.setFetchMode("bitacoraPrecio", FetchMode.JOIN);
				criteria.setFetchMode("estadosBitacoraPrecio", FetchMode.JOIN);
				criteria.setFetchMode("claseArticuloDTO", FetchMode.JOIN);
				criteria.setFetchMode("artBitCodBarCol", FetchMode.JOIN);
				
				criteria.addOrder(Order.asc("art.descripcionArticulo"));
				criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				
			}else{
				ProjectionList proList = Projections.projectionList()
						.add(Projections.property("id.codigoArticulo"), "id.codigoArticulo")
						.add(Projections.property("id.codigoCompania"), "id.codigoCompania")
						.add(Projections.property("codigoEstado"), "codigoEstado")
						.add(Projections.property("descripcionArticulo"), "descripcionArticulo")
						;
				criteria.setProjection(Projections.distinct(proList));
				criteria.setResultTransformer(new DtoResultTransformer(ArticuloDTO.class));

			}
			
			articulosCol = criteria.list();
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error al consultar articulos en base articuloVO ",e);
			throw new  SICException("Error al consultar articulos ",e);
		}finally{
			if(articulosCol!=null && articulosCol.isEmpty()){
				articulosCol= null;
			}
			session = null; criteria = null;
		}
		
		return articulosCol;
	}
	
	public void setHibernateH(IHibernateH<SearchDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
