package ec.com.smx.sic.articulo.persistence.dao;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import ec.com.kruger.utilitario.dao.commons.dao.BaseDAO;
import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.exception.HibernateDAOException;
import ec.com.kruger.utilitario.dao.commons.hibernate.HibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.kruger.utilitario.dao.commons.shard.ShardNamingStrategy;
import ec.com.smx.corpv2.common.factory.CorporativoFactory;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EstablecimientoCiudadDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.vo.GrupoTrabajoVO;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloGrupoAlcanceDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaBodegaSubbodegaAlcanceDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaGrupoAlcanceLocalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceIntegracionTransient;
import ec.com.smx.sic.cliente.mdl.nopersistente.PrototipoArticuloTrasient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloLocalPrecioVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloAlcanceDAO;
import ec.com.smx.sic.cliente.resources.SICMessages;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * Permite activar,desactivar,insertar masivamente articulos en articulo area de trabajo
 * @author fcollaguazo
 * @author dalmeida
 * @author jdvasquez
 */
public class ArticuloAlcanceDAO implements IArticuloAlcanceDAO {
	private BaseDAO baseDAO;
	private HibernateH<SearchDTO> hibernateH;
	private SessionFactory sessionFactory;

	/**
	 * Obtiene una lista de areasTrabajo por asignar y una lista de areasTrabajo
	 * para desactivar
	 * @param grupoTrabajoDTO
	 * @param areasAsignar
	 * @param areasDesactivar
	 * @param areasActivar
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	@Override
	public void actualizarGrupoAlcance(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasAsignar, Collection<GrupoAreaTrabajoDTO> areasDesactivar, Collection<GrupoAreaTrabajoDTO> areasActivar,Timestamp fechaAplicacion,String codigoFuncionario) throws SICException {
		try{	
			Logeable.LOG_SICV2.info("Entro a ArticuloAlcanceDAO.actualizarGrupoAlcance()");
			
			//Si el estado es activo
			if(grupoTrabajoDTO.getEstadoGrupoTrabajo().equals(CorporativoConstantes.ESTADO_ACTIVO)){
				if (CollectionUtils.isNotEmpty(areasDesactivar)) {
					desactivarGrupoAreasTrabajo(accessItemId,systemId,grupoTrabajoDTO, areasDesactivar,fechaAplicacion,codigoFuncionario);
				}
				if (CollectionUtils.isNotEmpty(areasAsignar)) {
					insertarAreasTrabajoPrototipo(accessItemId,systemId,grupoTrabajoDTO, areasAsignar,fechaAplicacion,codigoFuncionario,grupoTrabajoDTO.getId().getCodigoCompania());
				}
				if (CollectionUtils.isNotEmpty(areasActivar)) {
					activarAreasTrabajoPrototipo(accessItemId,systemId,grupoTrabajoDTO, areasActivar,fechaAplicacion,codigoFuncionario,grupoTrabajoDTO.getId().getCodigoCompania());
				}
			}else{
				//Se inactiva los articulo-local
				inactivarPrototipoAlcance(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo(), grupoTrabajoDTO.getUserId(), fechaAplicacion,codigoFuncionario,grupoTrabajoDTO.getId().getCodigoCompania());
				
				//Se quita el prototipo a los articulos
				inactivarArticulosPrototipo(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo(), grupoTrabajoDTO.getUserId(), fechaAplicacion,codigoFuncionario,grupoTrabajoDTO.getId().getCodigoCompania());
				
				//Se inactiva masivamente las areas de trabajo del prototipo, 
				inactivarAreasTrabajoPrototipo(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo(), grupoTrabajoDTO.getUserId(),grupoTrabajoDTO.getId().getCodigoCompania());
			}
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Se inactiva las area de trabajo que pertenecen al prototipo
	 * @param codigoGrupoTrabajo
	 * @param userId
	 */
	public void inactivarAreasTrabajoPrototipo(Long codigoGrupoTrabajo, String userId,Integer codigoCompania)throws SICException{
			Logeable.LOG_SICV2.info("Entr\u00F3 a ArticuloAlcanceDAO.inactivarAreasTrabajoPrototipo");
			if(codigoGrupoTrabajo==null
					|| StringUtils.isEmpty(userId)){
				throw new SICException("Existen datos vacios al inactivarAreasTrabajoPrototipo");
			}
			
			StringBuilder query = null;
			Query sqlQuery = null;

			try {
				Session session = hibernateH.getHibernateSession();
				session.clear();

				query = new StringBuilder();
				query.append("UPDATE SSPCOTARETRAGRUTRA SET");
				query.append(" ESTADOGRUPOAREATRABAJO = '"+CorporativoConstantes.ESTADO_INACTIVO+"',");
				query.append(" USUARIOMODIFICACION = '" + userId +"',");
				query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP");
				query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOGRUPOTRABAJO = "+codigoGrupoTrabajo);
				query.append(" AND ESTADOGRUPOAREATRABAJO = '"+CorporativoConstantes.ESTADO_ACTIVO+"'");

				sqlQuery = session.createSQLQuery(query.toString());
				sqlQuery.executeUpdate();
				session.flush();

			}catch (HibernateException e) {
				throw new SICException(e);
			}catch (Exception e) {
				throw new SICException(e);
			}
	}
	
	/**
	 * Permite actualizar masivamente los articulos de los locales que pertenecen al prototipo a desactivar
	 * @param grupoTrabajoDTO
	 * @param fechaAplicacion
	 */
	public void inactivarPrototipoAlcance(Long codigoGrupoTrabajo, String userId, Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania)throws SICException{
		Logeable.LOG_SICV2.info("Entr\u00F3 a ArticuloAlcanceDAO.inactivarPrototipoAlcance");
		if(codigoGrupoTrabajo==null
				|| StringUtils.isEmpty(userId)
				|| fechaAplicacion == null){
			throw new SICException("Existen datos vacios al inactivarPrototipoAlcance");
		}
		
		StringBuilder query = null;
		Query sqlQuery = null;
		//Obtenemos la fecha final del alcance
//		String fechaFinAlcance = obtenerFechaFinAlcances();

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE "+SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL+" SET");//SCSADTARTLOC
			query.append(" ESTADOARTICULOLOCAL = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
			query.append(" NOTIFICARLOCAL = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"', ");
			query.append(" APERTURALOCAL = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"', ");
			query.append(" IDUSUARIOMODIFICACION = '" + userId +"',");
			query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP,");
			query.append(" FECHAINACTIVACION = '"+fechaAplicacion+"',");
			query.append(" USUARIOINACTIVACION = '" + userId +"',");
			
			query.append("  VALORTIPOASIGNACION = '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"', ");
			query.append("  CODIGOTIPOASIGNACION = "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+", ");
			
			query.append(" ESTADOINTEGRACIONALCANCE = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
			query.append(" FECHAINICIALALCANCE = "+SICConstantes.INACTIVACION_FECHA_INICIAL+",");
			query.append(" FECHAFINALALCANCE = "+SICConstantes.INACTIVACION_FECHA_FINAL+" ");
			query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOLOCAL IN(");
			query.append(" 	SELECT CODIGOAREATRABAJO FROM SSPCOTARETRAGRUTRA");
			query.append("		WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOGRUPOTRABAJO = "+codigoGrupoTrabajo);
			query.append(" 		AND ESTADOGRUPOAREATRABAJO = '"+CorporativoConstantes.ESTADO_ACTIVO+"')");
			query.append(" AND CODIGOARTICULO IN ("+addPermisosDeLineaComercial(codigoFuncionario,codigoCompania)+")");

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * 
	 * @param codigoGrupoTrabajo
	 * @param userId
	 * @param fechaAplicacion
	 */
	public void inactivarArticulosPrototipo(Long codigoGrupoTrabajo, String userId, Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania)throws SICException{
		//Se quita el prototipo a los articulos
		Logeable.LOG_SICV2.info("Entr\u00F3 a ArticuloAlcanceDAO.inactivarArticulosPrototipo");
		if(codigoGrupoTrabajo==null
				|| StringUtils.isEmpty(userId)
				|| fechaAplicacion == null){
			throw new SICException("Existen datos vacios al inactivarArticulosPrototipo");
		}
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCSPETARTICULO SET");
			query.append(" CODIGOGRUPOALCANCE = NULL,");
			query.append(" USUARIOACTUALIZACION = '" + userId +"',");
			query.append(" FECHAULTIMAACTUALIZACION = '"+fechaAplicacion+"'");
			query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOGRUPOALCANCE = "+codigoGrupoTrabajo);
			query.append(" AND ESTADOARTICULO = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'");
			query.append(" AND CODIGOARTICULO IN ("+addPermisosDeLineaComercial(codigoFuncionario,codigoCompania)+")");

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}

	private void desactivarGrupoAreasTrabajo(GrupoAreaTrabajoDTO grupoAreaTrabajoDTO){
		
		try {
		if(SearchDTO.isLoaded(grupoAreaTrabajoDTO)){
			if(grupoAreaTrabajoDTO.getId().getCodigoAreaTrabajo() == null || grupoAreaTrabajoDTO.getId().getCodigoGrupoTrabajo() == null){
				Logeable.LOG_SICV2.info("Los codigos de area trabajo = "+ grupoAreaTrabajoDTO.getId().getCodigoAreaTrabajo()+" y grupo trabajo = "+grupoAreaTrabajoDTO.getId().getCodigoGrupoTrabajo());
			}else {
			
			StringBuilder query = null;
			Query sqlQuery = null;

			
				Session session = hibernateH.getHibernateSession();
				session.clear();

				query = new StringBuilder();
				query.append("UPDATE SSPCOTARETRAGRUTRA SET");
				query.append(" ESTADOGRUPOAREATRABAJO = '"+SICConstantes.ESTADO_INACTIVO_LITERAL+"',");
				query.append(" USUARIOMODIFICACION = '" + grupoAreaTrabajoDTO.getUserId() +"',");
				query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP");
				query.append(" WHERE CODIGOGRUPOTRABAJO =  "+grupoAreaTrabajoDTO.getId().getCodigoGrupoTrabajo());
				query.append(" AND CODIGOAREATRABAJO = "+grupoAreaTrabajoDTO.getId().getCodigoAreaTrabajo());
				query.append(" AND ESTADOGRUPOAREATRABAJO = '"+SICConstantes.ESTADO_ACTIVO_LITERAL+"'");

				sqlQuery = session.createSQLQuery(query.toString());
				sqlQuery.executeUpdate();
				session.flush();
			}
		}
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	
	/**
	 * Desactiva las areas de trabajo
	 * @param grupoTrabajoDTO
	 * @param areasDesactivar
	 */
	@Override
	public void desactivarGrupoAreasTrabajo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasDesactivar, Timestamp fechaAplicacion,String codigoFuncionario)throws SICException {
		Logeable.LOG_SICV2.info("Entr\u00F3 a ArticuloAlcanceDAO.desactivarGrupoAreasTrabajo()");

		try {
			for (GrupoAreaTrabajoDTO areaDesactivar : areasDesactivar) {
				areaDesactivar.getId().setCodigoGrupoTrabajo(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo());
				areaDesactivar.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_INACTIVO);
				areaDesactivar.getId().setCodigoCompania(grupoTrabajoDTO.getId().getCodigoCompania());
				areaDesactivar.setUserId(grupoTrabajoDTO.getUserId());
//				baseDAO.update(areaDesactivar);
				desactivarGrupoAreasTrabajo(areaDesactivar);
				//Desactivar los articulos que pertenecen al prototipo seleccionado en la tabla SCSADTARTLOC
				activarInactivarArticulosEnLocal(accessItemId,systemId,grupoTrabajoDTO, areaDesactivar, fechaAplicacion,codigoFuncionario);
			}
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite direccionar si los articulos de la tabla SCSADTARTLOC, van a ser activados o inactivados
	 * @param grupoTrabajoDTO
	 * @param areaAsignar
	 * @param fechaAplicacion
	 */
	@Override
	public void activarInactivarArticulosEnLocal(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, GrupoAreaTrabajoDTO areaAsignar, Timestamp fechaAplicacion,String codigoFuncionario)throws SICException{
		try{
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  activarInactivarArticulosEnLocal(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, GrupoAreaTrabajoDTO areaAsignar, Timestamp fechaAplicacion)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			
			if(areaAsignar.getId().getCodigoAreaTrabajo()!=null && StringUtils.isNotBlank(grupoTrabajoDTO.getUserId())){
				ArticuloVO articuloVO=new ArticuloVO();
				articuloVO.setAccessItemId(accessItemId);
				articuloVO.setSystemId(systemId);
				articuloVO.setCodigoLocalAsignar(areaAsignar.getId().getCodigoAreaTrabajo());
				articuloVO.setUserId(grupoTrabajoDTO.getUserId());
				articuloVO.setFechaAplicacion(fechaAplicacion);
				articuloVO.setCodigofuncionario(codigoFuncionario);
				articuloVO.setCodigoCompania(grupoTrabajoDTO.getId().getCodigoCompania());
				
				boolean isNotificarLocal = areaAsignar.getAreaTrabajoDTO().isNotificarLocal();
				boolean isAperturaLocal = areaAsignar.getAreaTrabajoDTO().isAperturaLocal();
				
				actualizarEstadoArticuloLocal(articuloVO, areaAsignar.getEstadoGrupoAreaTrabajo().equals(CorporativoConstantes.ESTADO_INACTIVO) ? 
						CorporativoConstantes.ESTADO_INACTIVO_BOOLEANO : CorporativoConstantes.ESTADO_ACTIVO_BOOLEANO, BooleanUtils.toInteger(isNotificarLocal), BooleanUtils.toInteger(isAperturaLocal),
						grupoTrabajoDTO.getId().getCodigoGrupoTrabajo());
			}
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite direccionar si los articulos de la tabla SCSADTARTLOC, van a ser activados o inactivados de forma masiva
	 * @param grupoTrabajoDTO
	 * @param areaAsignar
	 */
	@Override
	public void activarInactivarArticulosEnLocalMasivo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, GrupoAreaTrabajoDTO areaAsignar,Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania)throws SICException{
		try{
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  activarInactivarArticulosEnLocalMasivo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, GrupoAreaTrabajoDTO areaAsignar,Timestamp fechaAplicacion)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");

			actualizarEstadoArticuloLocalMasivo(accessItemId,systemId,areaAsignar, areaAsignar.getEstadoGrupoAreaTrabajo().equals(CorporativoConstantes.ESTADO_INACTIVO) ? CorporativoConstantes.ESTADO_INACTIVO_BOOLEANO : CorporativoConstantes.ESTADO_ACTIVO_BOOLEANO, grupoTrabajoDTO.getUserId(),fechaAplicacion,codigoFuncionario,codigoCompania);

		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * Actualiza el estado de los articulos en la tabla SCSADTARTLOC en forma masiva 
	 * Si el estado es es 1 -> Se asigna la fechaInicio y fechaFin
	 * @param areaAsignar
	 * @param estado
	 * @param userId
	 */
	public void actualizarEstadoArticuloLocalMasivo(String accessItemId,String systemId,GrupoAreaTrabajoDTO areaAsignar, String estado, String userId, Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania){
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  actualizarEstadoArticuloLocalMasivo(String accessItemId,String systemId,GrupoAreaTrabajoDTO areaAsignar, String estado, String userId, Timestamp fechaAplicacion)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		StringBuilder query = null;
		Query sqlQuery = null;
		//Obtenemos la fecha final del alcance
//		String fechaFinAlcance = obtenerFechaFinAlcances();

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE "+SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL+" SET");//SCSADTARTLOC
			query.append(" CODIGOSISTEMA = '"+systemId+"' ,");
			query.append(" CODIGOOPCION = '"+accessItemId+"' ,");
			query.append(" NOTIFICARLOCAL = '"+((areaAsignar.getAreaTrabajoDTO().isNotificarLocal())?SICConstantes.ESTADO_ACTIVO_NUMERICO:SICConstantes.ESTADO_INACTIVO_NUMERICO)+"', ");
			query.append(" APERTURALOCAL = '"+((areaAsignar.getAreaTrabajoDTO().isAperturaLocal())?SICConstantes.ESTADO_ACTIVO_NUMERICO:SICConstantes.ESTADO_INACTIVO_NUMERICO)+"', ");
			query.append(" ESTADOARTICULOLOCAL= " + estado +",");
			query.append(" IDUSUARIOMODIFICACION= '" + userId +"',");
			query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP,");
			
			query.append("  VALORTIPOASIGNACION = '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"', ");
			query.append("  CODIGOTIPOASIGNACION = "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+", ");

			if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				query.append(" FECHAACTIVACION = '"+fechaAplicacion+"',");
				query.append(" USUARIOACTIVACION = '" + userId +"',");
			}else{
				query.append(" FECHAINACTIVACION = '"+fechaAplicacion+"',");
				query.append(" USUARIOINACTIVACION = '" + userId +"',");
			}
			
			
			query.append(" ESTADOINTEGRACIONALCANCE = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"'");
			//Si el estado es 1 se activa al instante con fechaInicio y fechaFin del alcance
			if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				query.append(", FECHAINICIALALCANCE = CURRENT_DATE, ");
				query.append(" FECHAFINALALCANCE = NULL ");//"+(fechaFinAlcance==null?"NULL":"'"+fechaFinAlcance+"'")+"
			}
			
			query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOLOCAL = " + areaAsignar.getId().getCodigoAreaTrabajo());
			query.append(" AND CODIGOARTICULO IN (SELECT CODIGOARTICULO FROM SCSPETARTICULO WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOGRUPOALCANCE = "+areaAsignar.getId().getCodigoGrupoTrabajo()+"");
			query.append(" AND CODIGOARTICULO IN ("+addPermisosDeLineaComercial(codigoFuncionario,codigoCompania)+") )");
			
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Actualiza el estado del alcance de los articulos-local por local
	 * @param accessItemId
	 * @param systemId
	 * @param codigoAreaTrabajo
	 * @param estado
	 * @param userId
	 * @param fechaAplicacion
	 * @param estadoIntegracion
	 */
	@Override
	public void actualizarEstadoArticuloLocal(ArticuloVO articuloVO, String estado, Integer notificarLocal, Integer aperturaLocal,long codigoGrupoTrabajo)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  actualizarEstadoArticuloLocal(ArticuloVO articuloVO, String estado)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		
		String accessItemId=articuloVO.getAccessItemId();
		String systemId=articuloVO.getSystemId();
		Integer codigoAreaTrabajo=articuloVO.getCodigoLocalAsignar();		
		String userId=articuloVO.getUserId(); 
		Timestamp fechaAplicacion=articuloVO.getFechaAplicacion();
		
		String nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL;//"SCSADTARTLOC"

		if( StringUtils.isNotEmpty(articuloVO.getOpcionTipoAsignacionAlcance()) && (articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
				articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega")))){
			nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;//"SCSADTARTBODAUX1"
		}
		
		StringBuilder query = null;
		Query sqlQuery = null;
		//Obtenemos la fecha final del alcance
		String fechaFinAlcance = obtenerFechaAlcance(articuloVO.getFechaFinAlcance());
		String fechaInicioAlcance= obtenerFechaAlcance(articuloVO.getFechaInicioAlcance());
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE "+nameTable+" SET");
			
			query.append(" CODIGOSISTEMA = '"+systemId+"' ,");
			query.append(" CODIGOOPCION = '"+accessItemId+"' ,");
			query.append(" ESTADOARTICULOLOCAL = " + estado +",");
			query.append(" IDUSUARIOMODIFICACION = '" + userId +"',");
			query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP,");
			query.append(" NOTIFICARLOCAL = "+notificarLocal+", ");
			query.append(" APERTURALOCAL = "+aperturaLocal+" , ");
			
			query.append("  VALORTIPOASIGNACION = '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"', ");
			query.append("  CODIGOTIPOASIGNACION = "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+", ");

			if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				query.append(" FECHAACTIVACION = '"+fechaAplicacion+"',");
				query.append(" USUARIOACTIVACION = '" + userId +"',");
			}else{
				query.append(" FECHAINACTIVACION = '"+fechaAplicacion+"',");
				query.append(" USUARIOINACTIVACION = '" + userId +"',");
			}
			
			query.append(" ESTADOINTEGRACIONALCANCE = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'");
			//Si el estado es 1 se activa al instante con fechaInicio y fechaFin del alcance
			if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				query.append(", FECHAINICIALALCANCE = "+(fechaInicioAlcance==null? "CURRENT_DATE" : "'"+fechaInicioAlcance+"' "));
				query.append(", FECHAFINALALCANCE = "+(fechaFinAlcance==null? "NULL" : "'"+fechaFinAlcance+"' "));
			}
			query.append(" WHERE CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND CODIGOLOCAL = " + codigoAreaTrabajo);
			query.append(" AND CODIGOARTICULO IN( "+addPermisosDeLineaComercial(articuloVO.getCodigofuncionario(),articuloVO.getCodigoCompania())+" AND CODIGOGRUPOALCANCE = "+codigoGrupoTrabajo+" )");
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite actualizar los datos de articulo local que se encuentran en un local base a un local destino
	 * @param codigoLocalBase
	 * @param codigoLocalDestino
	 * @param userId
	 * @param fechaAplicacion
	 */
	
	public void actualizarDatosArticuloLocal(ArticuloVO articuloVO)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando actualizarDatosArticuloLocal(ArticuloVO articuloVO)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		String accessItemId =articuloVO.getAccessItemId();
		String systemId=articuloVO.getSystemId();
		Integer codigoLocalBase=articuloVO.getCodigoLocalBase();
		Integer codigoLocalDestino=articuloVO.getCodigoLocalAsignar();
		String userId=articuloVO.getUserId();
		Timestamp fechaAplicacion=articuloVO.getFechaAplicacion();
		
		
		String nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL,//"SCSADTARTLOC"
				tipTable="LOCAL";

		if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
				articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega"))){
			nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;//"SCSADTARTBODAUX1"			
		}
		
		String sqlSubselect = "FROM "+nameTable+" ALB WHERE  ALB.CODIGOCOMPANIA = ALD.CODIGOCOMPANIA AND ALB.CODIGOARTICULO=ALD.CODIGOARTICULO AND ALB.CODIGO"+tipTable+" = "+codigoLocalBase+"),";
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE "+nameTable+" ALD SET");
			query.append(" ESTADOARTICULO"+tipTable+" = (SELECT ALB.ESTADOARTICULO"+tipTable+" ".concat(sqlSubselect));
			query.append(" CODIGOSISTEMA = '"+systemId+"' ,");
			query.append(" CODIGOOPCION = '"+accessItemId+"' ,");
			query.append(" IDUSUARIOMODIFICACION = '"+userId+"',");
			query.append(" NOTIFICARLOCAL = "+SICConstantes.ESTADO_ACTIVO_NUMERICO+", ");
			query.append(" APERTURALOCAL = "+SICConstantes.ESTADO_ACTIVO_NUMERICO+" , ");
			query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP,");
			query.append(" FECHAINICIALALCANCE = (SELECT ALB.FECHAINICIALALCANCE ".concat(sqlSubselect));
			query.append(" FECHAFINALALCANCE = (SELECT ALB.FECHAFINALALCANCE ".concat(sqlSubselect));
			 
			query.append("  VALORTIPOASIGNACION = '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"', ");
			query.append("  CODIGOTIPOASIGNACION = "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+", ");
			
			query.append(" FECHAACTIVACION =  ");	
			query.append(" (SELECT CASE WHEN  ALB.ESTADOARTICULO"+tipTable+" = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'  ");
			query.append(" THEN '"+fechaAplicacion+"' ELSE ALD.FECHAACTIVACION END AS FECHAACTIVACION  ".concat(sqlSubselect)+"  "); 
			
			query.append(" USUARIOACTIVACION =  ");	
			query.append(" (SELECT CASE WHEN  ALB.ESTADOARTICULO"+tipTable+" = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'  ");
			query.append(" THEN '"+userId+"' ELSE ALD.USUARIOACTIVACION END AS USUARIOACTIVACION  ".concat(sqlSubselect)+"  "); 
			
			query.append(" FECHAINACTIVACION =  ");	
			query.append(" (SELECT CASE WHEN  ALB.ESTADOARTICULO"+tipTable+" = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"'  ");
			query.append(" THEN '"+fechaAplicacion+"' ELSE ALD.FECHAINACTIVACION END AS FECHAINACTIVACION  ".concat(sqlSubselect)+"  "); 
			
			query.append(" USUARIOINACTIVACION =  ");	
			query.append(" (SELECT CASE WHEN  ALB.ESTADOARTICULO"+tipTable+" = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"'  ");
			query.append(" THEN '"+userId+"' ELSE ALD.USUARIOINACTIVACION END AS USUARIOINACTIVACION  ".concat(sqlSubselect)+"  ");
			
			query.append(" ESTADOINTEGRACIONALCANCE = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"'");
			query.append(" WHERE CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND CODIGO"+tipTable+" = "+codigoLocalDestino);
			query.append(" AND CODIGOARTICULO IN(SELECT CODIGOARTICULO FROM "+nameTable+" ALB WHERE ALB.CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND ALB.CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND ALB.CODIGO"+tipTable+" = "+codigoLocalBase+")");

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException("Error al actualizarDatosArticuloLocal", e);
		}catch (Exception e) {
			throw new SICException("Error al actualizarDatosArticuloLocal", e);
		}
	}
	
	/**
	 * Inserta las nuevas areas de trabajo al prototipo e inserta en articulo local
	 * @param grupoTrabajoDTO
	 * @param areasAsignar
	 */
	@Override
	public void insertarAreasTrabajoPrototipo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasAsignar,Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania)throws SICException {
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  insertarAreasTrabajoPrototipo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasAsignar,Timestamp fechaAplicacion)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		try {
			for (GrupoAreaTrabajoDTO areaAsignar : areasAsignar) {
				areaAsignar.getId().setCodigoGrupoTrabajo(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo());
				areaAsignar.getId().setCodigoCompania(grupoTrabajoDTO.getId().getCodigoCompania());
				areaAsignar.getId().setCodigoAreaTrabajo(areaAsignar.getAreaTrabajoDTO().getId().getCodigoAreaTrabajo());
				areaAsignar.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
				areaAsignar.setUserId(grupoTrabajoDTO.getUserId());
				baseDAO.create(areaAsignar);
				//Actualizar los locales 
				activarInactivarArticulosEnLocal(accessItemId,systemId,grupoTrabajoDTO, areaAsignar, fechaAplicacion,codigoFuncionario);
				//Insertar los articulos que corresponden al local a\u00F1adido al prototipo
				insertarArticulosEnLocal(accessItemId,systemId,grupoTrabajoDTO,areaAsignar,fechaAplicacion,codigoFuncionario,codigoCompania);
			}
		}catch (HibernateDAOException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite insertar los articulos que pertenecen al prototipo enviado a la tabla de relacion SCSADTARTLOC
	 * @param grupoTrabajoDTO
	 * @param areaAsignar
	 */
	@Override
	public void insertarArticulosEnLocal(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO,GrupoAreaTrabajoDTO areaAsignar,Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania){
		Logeable.LOG_SICV2.info("Entr\u00F3 a ArticuloAlcanceDAO.insertarArticulosEnLocal()");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			//Obtenemos la fecha final del alcance
//			String fechaFinAlcance = obtenerFechaFinAlcances();
			
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			Integer codigoLocal = null;
			if(SearchDTO.isLoaded(areaAsignar.getAreaTrabajoDTO())){
				codigoLocal = areaAsignar.getAreaTrabajoDTO().getId().getCodigoAreaTrabajo();
			}else{
				codigoLocal = areaAsignar.getId().getCodigoAreaTrabajo();
			}
				
			query = new StringBuilder();
			query.append("INSERT INTO "+SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL+" ");//SCSADTARTLOC
			query.append("	(CODIGOARTICULOLOCAL,CODIGOCOMPANIA,NOTIFICARLOCAL,APERTURALOCAL ,VALORTIPOASIGNACION,CODIGOTIPOASIGNACION,CODIGOSISTEMA,CODIGOOPCION, CODIGOLOCAL, CODIGOARTICULO, ESTADOARTICULOLOCAL,IDUSUARIOREGISTRO,");
			query.append("	FECHAREGISTRO,FECHAINICIALALCANCE, ESTADOINTEGRACIONALCANCE) ");
			
			query.append(" SELECT NEXT VALUE FOR "+SICConstantes.SECUENCE_TABLA_ARTICULO_LOCAL_BODEGA+",CODIGOCOMPANIA,'"+BooleanUtils.toInteger(areaAsignar.getAreaTrabajoDTO().isNotificarLocal())+"','"+BooleanUtils.toInteger(areaAsignar.getAreaTrabajoDTO().isAperturaLocal())+"', '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"',"+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+",'"+systemId+"','"+accessItemId+"',"+ codigoLocal + ",");//SCADMSECARTLOC
			query.append("		CODIGOARTICULO,"+SICConstantes.ESTADO_ACTIVO_NUMERICO+",'"+grupoTrabajoDTO.getUserId()+"','"+fechaAplicacion+"'");
			query.append("		, CURRENT_DATE,'"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"' ");
			query.append(" FROM SCSPETARTICULO ARTICULO WHERE ARTICULO.CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOGRUPOALCANCE = "+grupoTrabajoDTO.getId().getCodigoGrupoTrabajo()+" AND ESTADOARTICULO = "+CorporativoConstantes.ESTADO_ACTIVO_BOOLEANO);
			query.append(" AND CODIGOARTICULO IN ("+addPermisosDeLineaComercial(codigoFuncionario,codigoCompania)+")  ");
			query.append(" AND CODIGOARTICULO NOT IN(SELECT CODIGOARTICULO FROM "+SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL+" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOLOCAL ="+codigoLocal+")");//SCSADTARTLOC

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Activa las areas de trabajo al prototipo
	 * @param grupoTrabajoDTO
	 * @param areasActivar
	 */
	@Override
	public void activarAreasTrabajoPrototipo(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO, Collection<GrupoAreaTrabajoDTO> areasActivar,Timestamp fechaAplicacion,String codigoFuncionario,Integer codigoCompania){
		Logeable.LOG_SICV2.info("Entr\u00F3 a ArticuloAlcanceDAO.activarAreasTrabajoPrototipo()");
		try {
			for (GrupoAreaTrabajoDTO areaActivar : areasActivar) {
				areaActivar.getId().setCodigoGrupoTrabajo(grupoTrabajoDTO.getId().getCodigoGrupoTrabajo());
				areaActivar.getId().setCodigoCompania(grupoTrabajoDTO.getId().getCodigoCompania());
				areaActivar.getId().setCodigoAreaTrabajo(areaActivar.getId().getCodigoAreaTrabajo());
				areaActivar.setEstadoGrupoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
				areaActivar.setUserId(grupoTrabajoDTO.getUserId());
				baseDAO.update(areaActivar);
				//Activar los registros inactivos
				activarInactivarArticulosEnLocal(accessItemId,systemId,grupoTrabajoDTO, areaActivar,fechaAplicacion,codigoFuncionario);
				//Insertar los registros que se a\u00F1adieron al prototipo mientras estaba inactivo
				insertarArticulosEnLocal(accessItemId,systemId,grupoTrabajoDTO,areaActivar,fechaAplicacion,codigoFuncionario,codigoCompania);
			}
		}catch (HibernateDAOException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}

	
	//---------------------------------------------------------------------------------------------------------------------------
	// FIN DE METODOS ADMINISTRACION DE ALCANCES
	//---------------------------------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------------------------------
	// INICIO METODOS DE ASIGNACION MASIVO DE ALCANCES
	//---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Permite copiar los articulos de un local base a otro local
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	@Override
	public void copiarLocal(ArticuloVO articuloVO) throws SICException {
		Logeable.LOG_SICV2.info("Entr\u00F3 a ArticuloAlcanceDAO.copiarLocal()");
		try{
	
			//Copiar articulos del local base que no existan en el local destino
			copiarArticuloLocalBaseLocalDestino(articuloVO);
			
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite copiar articulos del local base que no existan en el local destino
	 * @param prototipoAlcanceVO
	 */
	public void copiarArticuloLocalBaseLocalDestino(ArticuloVO articuloVO){
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando copiarArticuloLocalBaseLocalDestino(ArticuloVO articuloVO)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		StringBuilder query = null;
		Query sqlQuery = null;
		//Obtenemos la fecha fin del alcance
		String fechaFinAlcance =  obtenerFechaAlcance(articuloVO.getFechaFinAlcance());
		String nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL,secuenceName=SICConstantes.SECUENCE_TABLA_ARTICULO_LOCAL_BODEGA;//"SCADMSECARTLOC",//"SCSADTARTLOC"

		if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
				articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega"))){
			
			nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;//"SCSADTARTBOD"
			
		}else if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina")) ||
				articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina"))){
			
			nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA;//"SCSADTARTOFI"
		}	
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("INSERT INTO "+nameTable+"(CODIGOARTICULOLOCAL,CODIGOCOMPANIA,NOTIFICARLOCAL,APERTURALOCAL, VALORTIPOASIGNACION,CODIGOTIPOASIGNACION,ESTADOCODIGOREFERENCIA,CODIGOSISTEMA,CODIGOOPCION,CODIGOLOCAL,CODIGOARTICULO,ESTADOARTICULOLOCAL ");
			query.append(" ,IDUSUARIOREGISTRO,FECHAREGISTRO,FECHAINICIALALCANCE,");			
			if(articuloVO.getFechaFinAlcance()!=null){
				query.append("FECHAFINALALCANCE, ");
			}
			query.append("ESTADOINTEGRACIONALCANCE,USUARIOACTIVACION,FECHAACTIVACION)");
			//CODIGOARTICULO LOCAL O BODEGA
			query.append("SELECT NEXT VALUE FOR "+secuenceName+" ");
			//CODIGOCOMPANIA
			query.append(" ,T1.CODIGOCOMPANIA ,");

			if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia"))){
				//NOTIFICARLOCAL
				query.append(" '"+articuloVO.getNotificarLocal()+"',");
				//APERTURALOCAL
				query.append(" '"+articuloVO.getEsApertura()+"',");
			}else{
				//NOTIFICARLOCAL
				query.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
				//APERTURALOCAL
				query.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
			}
			//VALORTIPOASIGNACION
			query.append(" '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"' ,");
			//CODIGOTIPOASIGNACION
			query.append("  "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+" , ");
			//ESTADOCODIGOREFERENCIA
			query.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"', ");
			//CODIGOSISTEMA
			query.append("'"+articuloVO.getSystemId()+"', ");
			//CODIGOOPCION
			query.append("'"+articuloVO.getAccessItemId()+"', ");
			//CODIGO LOCAL O BODEGA
			query.append(articuloVO.getCodigoLocalAsignar()+ ", ");
			//CODIGOARTICULO
			query.append(" T1.CODIGOARTICULO, ");
			//ESTADOARTICULO LOCAL O BODEGA
			query.append(" ESTADOARTICULOLOCAL, ");
			//IDUSUARIOREGISTRO
			query.append("'" + articuloVO.getUserId() + "', ");
			//FECHAREGISTRO
			query.append("'"+articuloVO.getFechaAplicacion()+"', ");
			//FECHAINICIALALCANCE
			query.append(" CASE WHEN ESTADOARTICULOLOCAL ='"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' THEN '" + ConverterUtil.parseDateToString(articuloVO.getFechaAplicacion()) + "' ");
			query.append(" ELSE FECHAINICIALALCANCE END AS FECHAINICIALALCANCE, ");
			//FECHAFINALALCANCE
			if(articuloVO.getFechaFinAlcance()!=null){
				query.append("'"+fechaFinAlcance+"', ");
			}
			//ESTADOINTEGRACIONALCANCE
			query.append("'"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"', ");
			//USUARIOACTIVACION
			query.append(" CASE WHEN ESTADOARTICULOLOCAL ='"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' THEN '" + articuloVO.getUserId() + "' ");
			query.append(" ELSE NULL END AS USUARIOACTIVACION, ");
			//FECHAACTIVACION
			query.append(" CASE WHEN ESTADOARTICULOLOCAL ='"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' THEN '" + articuloVO.getFechaAplicacion() + "' ");
			query.append(" ELSE NULL END AS FECHAACTIVACION ");
						
			// WHERE Y FROM
			query.append(" FROM "+nameTable+"  T1, SCSPETARTICULO T2  WHERE T1.CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND CODIGOLOCAL=" + articuloVO.getCodigoLocalBase() + " ");
			query.append(" AND (FECHAFINALALCANCE > CURRENT_DATE OR FECHAFINALALCANCE IS NULL)  ");
			
			query.append(" AND T1.CODIGOARTICULO = T2.CODIGOARTICULO ");
			query.append(" AND T1.CODIGOCOMPANIA = T2.CODIGOCOMPANIA ");
			query.append(" AND T2.CODIGOESTADO  = '"+SICConstantes.ESTADO_ARTICULO_CODIFICADO+"' ");
			
			query.append(" AND T1.CODIGOCOMPANIA = " + articuloVO.getBaseDTO().getId().getCodigoCompania() +" AND T1.CODIGOARTICULO NOT IN ( ");
			query.append(" SELECT CODIGOARTICULO FROM "+nameTable+" WHERE CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND CODIGOLOCAL=" + articuloVO.getCodigoLocalAsignar() + ")");
			query.append(" AND T2.CODIGOARTICULO IN ("+addPermisosDeLineaComercial(articuloVO.getCodigofuncionario(),articuloVO.getCodigoCompania())+") ");
			
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public Collection<Integer> buscarBodegasPorCD(Collection<Integer> codigosHijos)throws SICException{
		Collection<Integer> codigosPadre;
		
		Collection<Integer> codigoAreasSubLugarTrabajo=new ArrayList<Integer>();
		AreaSublugarTrabajoDTO areaSublugarTrabajoDTO=new AreaSublugarTrabajoDTO();
		areaSublugarTrabajoDTO.setEstado(true);
		
		areaSublugarTrabajoDTO.addCriteriaSearchParameter("id.codigoAreaSublugarTrabajo",ComparatorTypeEnum.IN_COMPARATOR,codigosHijos);
		Collection<AreaSublugarTrabajoDTO> areaSublugarTrabajoDTOs = baseDAO.findObjects(areaSublugarTrabajoDTO);
		codigosPadre=((Collection<Integer>)CollectionUtils.collect(areaSublugarTrabajoDTOs, new GetInvokerTransformer("id.codigoAreaTrabajo")));
		
		areaSublugarTrabajoDTO.setCriteriaSearch(null);
		areaSublugarTrabajoDTO.addCriteriaSearchParameter("id.codigoAreaSublugarTrabajo",ComparatorTypeEnum.NOT_IN_COMPARATOR,codigosHijos);
		areaSublugarTrabajoDTO.addCriteriaSearchParameter("id.codigoAreaTrabajo",ComparatorTypeEnum.IN_COMPARATOR,codigosPadre);
		areaSublugarTrabajoDTO.setSubLugarTrabajoDTO(new AreaTrabajoDTO());
		
		Collection<AreaSublugarTrabajoDTO> areaSublugarTrabajoDTOs2 = baseDAO.findObjects(areaSublugarTrabajoDTO);
		codigoAreasSubLugarTrabajo=((Collection<Integer>)CollectionUtils.collect(areaSublugarTrabajoDTOs2, new GetInvokerTransformer("id.codigoAreaSublugarTrabajo")));
		
		return codigoAreasSubLugarTrabajo;
	}
	
	/**
	 * Permite remover el alcance a las bodegas 
	 * @param areaTrabajoDTOs
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	private void removerArticulosBodega(ArticuloVO articuloVO,String cadenaArticulos,String cadenaArticuloAreatrabajo) throws SICException{
		
		
		Logeable.LOG_SICV2.info("**************************************************---------------***********************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando removerArticulosBodega(ArticuloVO articuloVO,String cadenaArticulos,String cadenaArticuloAreatrabajo)");
		Logeable.LOG_SICV2.info("**************************************************---------------***********************************************************************");
		try {
			Collection<Integer> codigoAreasSubLugarTrabajo=new ArrayList<Integer>();
			AreaSublugarTrabajoDTO areaSublugarTrabajoDTO=new AreaSublugarTrabajoDTO();
			areaSublugarTrabajoDTO.setEstado(true);
			
					
			if(CollectionUtils.isNotEmpty(articuloVO.getBodegasSeleccionadas())){
				codigoAreasSubLugarTrabajo = ((Collection<Integer>)CollectionUtils.collect(articuloVO.getBodegasSeleccionadas(), new GetInvokerTransformer("id.codigoAreaTrabajo")));
			}

			if(CollectionUtils.isNotEmpty(codigoAreasSubLugarTrabajo)){

				String codigosBodegas=StringUtils.join(codigoAreasSubLugarTrabajo,",");
					remplazarArticulosLocalesMasivo(articuloVO, codigosBodegas, cadenaArticulos, cadenaArticuloAreatrabajo,null,null,null);
			}	
		} catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}

	/**
	 * permite consultar los alcances que un funcionario tenga permisos
	 * @param codigoFuncionario
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigosArticuloAreaTrabajo
	 * @param codigosAreaTrabajo
	 * @return
	 * @throws SICException
	 */
	private Collection<ArticuloLocalDTO> consultarAlcancesActivos(String codigoFuncionario,Integer codigoCompania,String codigoArticulo,Collection<Long> codigosArticuloAreaTrabajo,Collection<Integer> codigosAreaTrabajo)throws SICException{
		try {
			
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = null;
			
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class);
			
			//restriccion de alcances activos o programados
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.gt("fechaFinalAlcance", ConverterUtil.getCurrentTruncDate()));
			disjunction.add(Restrictions.isNull("fechaFinalAlcance"));
			
			criteria.createAlias("local", "local");
			
			criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("local.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_LOCAL));
			
			
			criteria.createAlias("articulo", "articulo");
			
			criteria.add(disjunction);
			criteria.add(Subqueries.propertyIn("articulo.codigoClasificacion", addRestrictionFuncionarioClasificacion(codigoFuncionario)));
			
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			
			
			criteria.setProjection(Projections.projectionList()
							.add(Projections.property("codigoArticuloLocal"),"codigoArticuloLocal")
							.add(Projections.property("id.codigoLocal"),"id.codigoLocal")
							.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo")
					);
			//permite ignorar los alcances seleccionados			
			if(CollectionUtils.isNotEmpty(codigosArticuloAreaTrabajo)){
				criteria.add(Restrictions.not(Restrictions.in("codigoArticuloLocal", codigosArticuloAreaTrabajo)));
			}
			//permite ignorar los locales seleccionados
			if(CollectionUtils.isNotEmpty(codigosAreaTrabajo)){
				criteria.add(Restrictions.not(Restrictions.in("id.codigoLocal", codigosAreaTrabajo)));
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
			
			articuloLocalDTOCol = criteria.list();
			
			return articuloLocalDTOCol;
			
			
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	private void remplazarArticulosLocalesMasivo (String nameTable,String systemId,String accessItemId,String notificarLocal, String aperturaLocal,Timestamp fechaAplicacion,String userId, Long codigoArticuloLocal){
		try {
			StringBuilder query = null;
			Query sqlQuery = null;
			
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			
			query.append("UPDATE "+nameTable+" AL ");
		
			query.append("SET AL.CODIGOSISTEMA = '").append(systemId).append("'  "); 
			query.append(",AL.CODIGOOPCION =  '").append(accessItemId).append("'  ");
			query.append(",AL.VALORTIPOASIGNACION =  '").append(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL).append("'  ");
			query.append(",AL.CODIGOTIPOASIGNACION = ").append(TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE).append("  ");
			query.append(",AL.NOTIFICARLOCAL = '").append(notificarLocal).append("'  "); 
			query.append(",AL.APERTURALOCAL =  '").append(aperturaLocal).append("'  "); 			
			query.append(",AL.ESTADOARTICULOLOCAL = '").append(SICConstantes.ESTADO_INACTIVO_NUMERICO).append("'  "); 
			query.append(",AL.FECHAINICIALALCANCE = ").append(SICConstantes.INACTIVACION_FECHA_INICIAL).append("  ");  
			query.append(",AL.FECHAFINALALCANCE =  ").append(SICConstantes.INACTIVACION_FECHA_FINAL).append("  ");  
			query.append(",AL.FECHAINACTIVACION = '").append(fechaAplicacion).append("'  ");  
			query.append(",AL.USUARIOINACTIVACION = '").append(userId).append("'  ");  
			query.append(",AL.IDUSUARIOMODIFICACION = '").append(userId).append("'  "); 
			query.append(",AL.FECHAMODIFICACION = CURRENT_TIMESTAMP"); 
			query.append(",AL.ESTADOINTEGRACIONALCANCE = '").append(SICConstantes.ESTADO_INACTIVO_NUMERICO).append("' ");
			query.append("WHERE   AL.CODIGOARTICULOLOCAL =  ").append(codigoArticuloLocal).append("  "); 
		
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite inactivar de uno en uno los alcances de los articulos en los locales que no se hayan seleccionado
	 * @param articuloVO
	 * @param codigoArticulo
	 * @param articuloLocalPrecioVOCol
	 */
	private void remplazarArticulosLocalesMasivo(ArticuloVO articuloVO,String codigoArticulo,Collection<ArticuloLocalPrecioVO> articuloLocalPrecioVOCol){
		try {
			//variables
			String accessItemId = articuloVO.getAccessItemId();
			String systemId = articuloVO.getSystemId();		 		 
			String userId = articuloVO.getUsuarioAlcance();
			Timestamp fechaAplicacion = articuloVO.getFechaAplicacion();  
			String codigoFuncionario = articuloVO.getCodigofuncionario();
			Integer codigoCompania = articuloVO.getCodigoCompania();
			Collection<Long> codigosArticuloAreaTrabajo = articuloVO.getCodigosArticuloAreaTrabajo();//obtenemos la coleccion de los alcances a no ser afectados
			Collection<Integer> codigosAreaTrabajo = CollectionUtils.collect(articuloLocalPrecioVOCol, new GetInvokerTransformer("localDTO.id.codigoAreaTrabajo"));//permite optener los locales los cuales no se removera el alcance
			
			//consultamos los alcances activos en base para ser remplazados
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = consultarAlcancesActivos(codigoFuncionario, codigoCompania, codigoArticulo,codigosArticuloAreaTrabajo,codigosAreaTrabajo);
			
			for (ArticuloLocalDTO articuloLocalDTO: articuloLocalDTOCol) {
				//permite terminar el alcance
				remplazarArticulosLocalesMasivo(
						SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL, 
						systemId, 
						accessItemId, 
						SICConstantes.ESTADO_ACTIVO_NUMERICO, 
						SICConstantes.ESTADO_ACTIVO_NUMERICO, 
						fechaAplicacion, 
						userId, 
						articuloLocalDTO.getCodigoArticuloLocal());
			}
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite a\u00F1adir, quitar, remplazar articulos de los locales masivamente
	 * @param articuloCol
	 * @param grupoTrabajoDTO
	 */
	@Override
	public void asignarQuitarRemplazarMasivaArticulosLocales(List<? extends ArticuloDTO> articuloCol, ArticuloVO articuloVO)throws SICException{
		String codigoArticulo = null;
		try{
			Logeable.LOG_SICV2.info("**************************************************---------------***********************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando asignarQuitarRemplazarMasivaArticulosLocales(List<? extends ArticuloDTO> articuloCol, ArticuloVO articuloVO)");
			Logeable.LOG_SICV2.info("**************************************************---------------***********************************************************************");
			
			String userId = articuloVO.getUsuarioAlcance();
			Timestamp fechaAplicacion = articuloVO.getFechaAplicacion();
			String opcion = articuloVO.getOpcionAlcance();
			String opcionTipoAsignacionAlcance = articuloVO.getOpcionTipoAsignacionAlcance();
			Collection<String> cadenasCodigosArticulos = cadenaCodigosArticulos(articuloCol);
			String cadenaArticuloAreatrabajo="";
			boolean asiganarAlcances = true;
			Collection<ArticuloLocalPrecioVO> localesAsignarAlcanceCol = new ArrayList<ArticuloLocalPrecioVO>();
			
			if(! articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia")) ){
				articuloVO.setNotificarLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				articuloVO.setEsApertura(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			}
			
			for(ArticuloLocalPrecioVO artLocPreVO : articuloVO.getLocales()){
				if(! articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia")) ){
					artLocPreVO.setNotificarLocal(true);
					artLocPreVO.setAperturaLocal(true);
				}
				localesAsignarAlcanceCol.add(artLocPreVO);
			}
			
			
			if(CollectionUtils.isNotEmpty(articuloVO.getCodigosArticuloAreaTrabajo())){
				cadenaArticuloAreatrabajo = StringUtils.join(articuloVO.getCodigosArticuloAreaTrabajo(),",");
			}
			
			if(CollectionUtils.isNotEmpty(cadenasCodigosArticulos)){
				for(String cadenaCodigoArticulo : cadenasCodigosArticulos){
					
					codigoArticulo = cadenaCodigoArticulo.substring(1, cadenaCodigoArticulo.length()-1);
					
					//remplaza todos los articulos pertenceciente al mismo CD
					if((opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) || 
							opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega"))) &&
							! opcion.equals(SICConstantes.ALCANCE_OPCION_QUITAR)){
						removerArticulosBodega(articuloVO, cadenaCodigoArticulo,cadenaArticuloAreatrabajo);
						
						if(CollectionUtils.isNotEmpty(articuloVO.getCodigosArticuloAreaTrabajo())){
							Collection<ArticuloLocalPrecioVO> artLocPCol = new ArrayList<ArticuloLocalPrecioVO>();
							for(ArticuloLocalPrecioVO articuloLocalPrecioVO :  localesAsignarAlcanceCol){
								asiganarAlcances = comprobarBodegaMismoCDT(articuloVO.getCodigoCompania(), articuloVO.getCodigosArticuloAreaTrabajo(), codigoArticulo, articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo());
								if(asiganarAlcances){
									artLocPCol.add(articuloLocalPrecioVO);
								}
							}
							
							localesAsignarAlcanceCol.removeAll(artLocPCol);
						}
					}
					
						//A\u00F1adir articulos a locales
						if(opcion.equals(SICConstantes.ALCANCE_OPCION_ANADIR)){
							for(ArticuloLocalPrecioVO articuloLocalPrecioVO :  localesAsignarAlcanceCol){
								activarDesactivarArticulosMasivoLocales(articuloVO, cadenaCodigoArticulo, articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo().toString(), 
										cadenaArticuloAreatrabajo, BooleanUtils.toInteger(articuloLocalPrecioVO.getNotificarLocal()),BooleanUtils.toInteger(articuloLocalPrecioVO.getAperturaLocal()));
							}
							if(!(StringUtils.isNotEmpty(articuloVO.getTipResolucionConflicto()) && articuloVO.getTipResolucionConflicto().equals(SICConstantes.ALCANCE_CONFLICTO_RESPETE_FECHA))){
								//iteramos los locales
								if(CollectionUtils.isNotEmpty(localesAsignarAlcanceCol)){
									for(ArticuloLocalPrecioVO articuloLocalPrecioVO : localesAsignarAlcanceCol){
										insertarArticulosMasivoLocales(articuloVO.getAccessItemId(),articuloVO.getSystemId(),cadenaCodigoArticulo,cadenaArticuloAreatrabajo,articuloVO,articuloLocalPrecioVO);
									}
								}	
								
							}
						}
						//Quitar articulos a locales
						else if(opcion.equals(SICConstantes.ALCANCE_OPCION_QUITAR)){
							for(ArticuloLocalPrecioVO articuloLocalPrecioVO :  localesAsignarAlcanceCol){
								activarDesactivarArticulosMasivoLocales(articuloVO, cadenaCodigoArticulo, articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo().toString(), 
										cadenaArticuloAreatrabajo, BooleanUtils.toInteger(articuloLocalPrecioVO.getNotificarLocal()),BooleanUtils.toInteger(articuloLocalPrecioVO.getAperturaLocal()));
							}
						}
						//Remplazar articulos a locales
						else if(opcion.equals(SICConstantes.ALCANCE_OPCION_REMPLAZAR)){
							remplazarArticulosLocalesMasivo(articuloVO, codigoArticulo,localesAsignarAlcanceCol);
							

							for(ArticuloLocalPrecioVO articuloLocalPrecioVO :  localesAsignarAlcanceCol){
								activarDesactivarArticulosMasivoLocales(articuloVO, cadenaCodigoArticulo, articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo().toString(), 
										cadenaArticuloAreatrabajo, BooleanUtils.toInteger(articuloLocalPrecioVO.getNotificarLocal()),BooleanUtils.toInteger(articuloLocalPrecioVO.getAperturaLocal()));
							}
							//iteramos los locales
							if(CollectionUtils.isNotEmpty(localesAsignarAlcanceCol)){
								for(ArticuloLocalPrecioVO articuloLocalPrecioVO : localesAsignarAlcanceCol){
									insertarArticulosMasivoLocales(articuloVO.getAccessItemId(),articuloVO.getSystemId(),cadenaCodigoArticulo,cadenaArticuloAreatrabajo,articuloVO,articuloLocalPrecioVO);
								}
							}
						}
						
	//					Si son las opciones de alcances por locales
						if(StringUtils.isNotBlank(cadenaCodigoArticulo) && 
								(opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.local"))
								|| opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia"))
								|| opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.prototipo")))){
							
							activarDesactivarArticulosEstablecimientos(articuloVO.getUsuarioAlcance(), cadenaCodigoArticulo, null);
							insertarArticulosMasivoEstablecimientos(articuloVO.getUsuarioAlcance(), cadenaCodigoArticulo, null);
							/**actualizar prototipo**/
							modificarPrototipoAlcance(articuloVO.getCodigoCompania(), codigoArticulo, articuloVO.getUserId(), articuloVO.getFechaAplicacion(), articuloVO.getVistaGrupoAlcanceLocalDTOs());
						}
						/**Actualizamos la bitacora**/
						insertarBitacoraArticuloAreaTrabajo(articuloVO.getFechaAplicacion(), articuloVO.getOpcionTipoAsignacionAlcance(), articuloVO.getCodigoCompania(), codigoArticulo);
				}
			}
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	

	
	@Override
	public void actulaizarArticuloEstablecimientoPrototipo(ArticuloVO articuloVO)throws SICException{
		try {
			
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = consultarAlcancesModificados(articuloVO.getFechaAplicacion());
			
			if(CollectionUtils.isNotEmpty(articuloLocalDTOCol)){
				
				for(ArticuloLocalDTO articuloLocalDTO : articuloLocalDTOCol){
					
					activarDesactivarArticulosEstablecimientos(articuloVO.getUsuarioAlcance(), articuloLocalDTO.getId().getCodigoArticulo(), null);
					insertarArticulosMasivoEstablecimientos(articuloVO.getUsuarioAlcance(), "'"+articuloLocalDTO.getId().getCodigoArticulo()+"'", null);
					/**actualizar prototipo**/
					modificarPrototipoAlcance(articuloVO.getCodigoCompania(), articuloLocalDTO.getId().getCodigoArticulo(),
							articuloVO.getUserId(), articuloVO.getFechaAplicacion(), articuloVO.getVistaGrupoAlcanceLocalDTOs());
				}
			}
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	@Override
	public void quitarAlcancesAsignacionMasiva(String nameTable,String accessItemId,String systemId,String userId,Timestamp fechaAplicacion,String cadenaArticuloAreatrabajoNoQuit
			,String notificarLocal, String aperturaLocal,Long codigoArticuloAreatrabajo,Boolean isRemplazarAlcances,Date fechaFinAlcance)throws SICException{
		try {
			StringBuilder query = null;
			Query sqlQuery = null;
			String fechaFAlcance = null;
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			
			query.append("UPDATE ").append(nameTable).append(" AL ");


			query.append("SET AL.CODIGOSISTEMA = '").append(systemId).append("' ");
			query.append(",AL.CODIGOOPCION = '").append(accessItemId).append("' ");
			query.append(",AL.VALORTIPOASIGNACION = '").append(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL).append("' ");
			query.append(",AL.CODIGOTIPOASIGNACION = ").append(TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE).append("  ");
			query.append(",AL.NOTIFICARLOCAL = '").append(notificarLocal).append("' ");
			query.append(",AL.APERTURALOCAL = '").append(aperturaLocal).append("' ");			
			
			if(isRemplazarAlcances){
				fechaFAlcance = obtenerFechaAlcance(fechaFinAlcance);
				
				if(StringUtils.isNotBlank(fechaFAlcance)){
					query.append(" ,AL.FECHAFINALALCANCE = '").append(fechaFAlcance).append("'  ");
				}else{
					query.append(" ,AL.FECHAFINALALCANCE =  NULL ");
				}
				
			}else{
				query.append(",AL.ESTADOARTICULOLOCAL = '").append(SICConstantes.ESTADO_INACTIVO_NUMERICO).append("' ");
				query.append(",AL.FECHAINICIALALCANCE = ").append(SICConstantes.INACTIVACION_FECHA_INICIAL).append("  ");
				query.append(",AL.FECHAFINALALCANCE = ").append(SICConstantes.INACTIVACION_FECHA_FINAL).append(" ");
				query.append(",AL.FECHAINACTIVACION = '").append(fechaAplicacion).append("' ");
				query.append(",AL.USUARIOINACTIVACION = '").append(userId).append("'  ");
			}
			query.append(",AL.IDUSUARIOMODIFICACION = '").append(userId).append("'  ");
			query.append(",AL.FECHAMODIFICACION = CURRENT_TIMESTAMP");
			query.append(" WHERE CODIGOARTICULOLOCAL = ").append(codigoArticuloAreatrabajo);
			
			if(StringUtils.isNotBlank(cadenaArticuloAreatrabajoNoQuit)){
				query.append(" AND CODIGOARTICULOLOCAL NOT IN (").append(cadenaArticuloAreatrabajoNoQuit).append(") ");
			}
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	
	/**
	 * Permite conservar solo los articulos locales que se encuentran en cadenaCodigoArticulo 
	 * y al resto que pertenecen a este local se les modificara el fechafinal y fechainicio 
	 * de esta manera solo se conservara los articuloslocal que se selecciono
	 * @param articuloVO
	 * @param cadenaCodigoArticulo
	 * @param cadenaLocales
	 * @param cadenaArticuloAreatrabajo
	 */
	@Override
	public void remplazarArticulosLocalesMasivo(ArticuloVO articuloVO,String cadenaLocales,String cadenaArticulos,String cadenaArticuloAreatrabajoNoQuit, Integer notificarLocal, Integer aperturaLocal,Long cadenaArticuloAreatrabajo) throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando remplazarArticulosLocalesMasivo(ArticuloVO articuloVO,String cadenaLocales,String cadenaArticulos,String cadenaArticuloAreatrabajo)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		String accessItemId = articuloVO.getAccessItemId();
		String systemId = articuloVO.getSystemId();		 		 
		String userId = articuloVO.getUsuarioAlcance();
		Timestamp fechaAplicacion = articuloVO.getFechaAplicacion();  
		String opcionAsigancionLocal = articuloVO.getOpcionTipoAsignacionAlcance();
		
		
		StringBuilder query = null;
		Query sqlQuery = null;
		
		String nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL;//"SCSADTARTLOC"
				
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			if(StringUtils.isNotEmpty(opcionAsigancionLocal)){
				if(opcionAsigancionLocal.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
						opcionAsigancionLocal.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega"))){
					nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;//"SCSADTARTBODAUX1"
				}else if(opcionAsigancionLocal.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina")) ||
						opcionAsigancionLocal.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina"))){
					nameTable = SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA;//"SCSADTARTOFI"
				}
			}
			
			query = new StringBuilder();
			
			query.append("UPDATE "+nameTable+" AL ");
			query.append(" SET ");
			query.append("  AL.CODIGOSISTEMA = '"+systemId+"' ");
			
			query.append(" ,AL.VALORTIPOASIGNACION = '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"' ");
			query.append(" ,AL.CODIGOTIPOASIGNACION = "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+" ");
			if(notificarLocal == null && aperturaLocal == null){
				query.append(" ,AL.NOTIFICARLOCAL = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
				query.append(" ,AL.APERTURALOCAL = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			}else{
				query.append(" ,AL.NOTIFICARLOCAL = '"+notificarLocal+"' ");
				query.append(" ,AL.APERTURALOCAL = '"+aperturaLocal+"' ");
			}
			query.append(" ,AL.CODIGOOPCION = '"+accessItemId+"' ");
			
			if(articuloVO.isRemplazarAlcances()){
				String fechaFinAlcance = obtenerFechaAlcance(articuloVO.getFechaFinAlcance());
				query.append(" ,AL.FECHAFINALALCANCE =  "+(fechaFinAlcance==null?"NULL":"'"+fechaFinAlcance+"'")+" ");
			}else{
				query.append(" ,AL."+"ESTADOARTICULOLOCAL = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"' ");
				query.append(" ,AL.FECHAINICIALALCANCE =   "+SICConstantes.INACTIVACION_FECHA_INICIAL+" ");	
				query.append(" ,AL.FECHAFINALALCANCE =  "+SICConstantes.INACTIVACION_FECHA_FINAL+" ");
				query.append(" ,AL.FECHAINACTIVACION = '"+fechaAplicacion+"' ");
				query.append(" ,AL.USUARIOINACTIVACION = '"+userId+"' ");
			}
			
			query.append(" ,AL.IDUSUARIOMODIFICACION = '"+userId +"' ");
			query.append(" ,AL.FECHAMODIFICACION = CURRENT_TIMESTAMP");
			query.append(" WHERE AL.CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND ");
			query.append(" CODIGOARTICULO IN ("+addPermisosDeLineaComercial(articuloVO.getCodigofuncionario(),articuloVO.getCodigoCompania())+") AND ");
			
			//solo afectara a los articulo area de trabajo que tengan alcance
			query.append("  (AL.FECHAFINALALCANCE > '"+ConverterUtil.parseDateToString(fechaAplicacion)+"'");
			query.append(" OR AL.FECHAFINALALCANCE IS NULL ) ");
			
			if(cadenaArticuloAreatrabajo != null){
				query.append(" AND AL.CODIGOARTICULOLOCAL = ").append(cadenaArticuloAreatrabajo).append(" ");
			}else{
				if(StringUtils.isNotEmpty(cadenaLocales)){
					query.append(" AND AL.CODIGOLOCAL IN ("+cadenaLocales+") ");
				}
				//permite quitar el alcance solo a los articulos area de trabajo que se necesite cambiar
				if(StringUtils.isNotEmpty(cadenaArticulos)){
					query.append(" AND AL.CODIGOARTICULO IN("+cadenaArticulos+") ");
				}
			}	
			//se omite algunos articulos area de trabajo 
			if(StringUtils.isNotEmpty(cadenaArticuloAreatrabajoNoQuit)){	
				query.append(" AND AL.CODIGOARTICULOLOCAL NOT IN("+cadenaArticuloAreatrabajoNoQuit+") ");
			}
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	private String addPermisosDeLineaComercial(String codigoFuncionario,Integer codigoCompania){
		StringBuilder sqlQuery=new StringBuilder();
		
		sqlQuery.append("  SELECT CODIGOARTICULO FROM SCSPETARTICULO WHERE    ");
		sqlQuery.append(" CODIGOCLASIFICACION IN (   ");
		sqlQuery.append(" SELECT CODIGOCLASIFICACION   ");
		sqlQuery.append(" FROM SCADMTLINCOMFUNCLA   ");
		sqlQuery.append(" WHERE CODIGOFUNCIONARIO =  '").append(codigoFuncionario).append("'  "); 
		sqlQuery.append(" AND ESTADO =  '").append(SICConstantes.ESTADO_ACTIVO_NUMERICO).append("')  ");
		sqlQuery.append(" AND ESTADOARTICULO = '").append(SICConstantes.ESTADO_ACTIVO_NUMERICO).append("' ");
		sqlQuery.append(" AND CODIGOCOMPANIA = ").append(codigoCompania).append("  "); 
		
		return sqlQuery.toString();
	}
	
	/**
	 * Permite actualizar o insertar un reguistro en articuloLocal o bodega o oficina 
	 * para que el articulo seleccionado pierda o tenga alcance en el local seleccionado
	 * @param articuloVO
	 * @param articuloLocalDTO
	 * @throws SICException
	 */
	private void establecerAlcance(ArticuloVO articuloVO,ArticuloLocalDTO articuloLocalDTO)throws SICException{
		try {
			String nameTable=((articuloLocalDTO.getTipoAreaTrabajo().equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL))?
					SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL:(articuloLocalDTO.getTipoAreaTrabajo().equals(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA))?
							SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA:SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA);
			//permite establecer que el alcances tipo de alcance en caso de no tener un tipo 
			if(StringUtils.isEmpty(articuloLocalDTO.getValorTipoAsignacion())){
				articuloLocalDTO.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL);
			}
			if(StringUtils.isEmpty(articuloLocalDTO.getCodigoSistema()) && StringUtils.isEmpty(articuloLocalDTO.getCodigoOpcion())){
				articuloLocalDTO.setCodigoOpcion(articuloVO.getAccessItemId());
				articuloLocalDTO.setCodigoSistema(articuloVO.getSystemId());
			}
			
			
			actualizarArticuloAreaTrabajo(articuloVO, articuloLocalDTO,nameTable);
			insertarArticuloAreaTrabajo(articuloVO, articuloLocalDTO,nameTable);
		} catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
		
	}
	
	
	/**
	 * Permite dar alcance a un articulo 
	 * @param articuloVO
	 * @param articuloLocalDTO
	 * @throws SICException
	 */
	private void actualizarArticuloAreaTrabajo(ArticuloVO articuloVO,ArticuloLocalDTO articuloLocalDTO,String nameTable)throws SICException{
		StringBuilder query = null;
		Query sqlQuery = null;
		String fechaFinAlcance=obtenerFechaAlcance(articuloLocalDTO.getFechaFinalAlcance()); 
		String fechaInicioAlcance=obtenerFechaAlcance(articuloLocalDTO.getFechaInicialAlcance());

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			query.append("UPDATE "+nameTable+" AL ");
			query.append(" SET AL.CODIGOSISTEMA = '"+articuloLocalDTO.getCodigoSistema()+"' ");
			query.append(" ,AL.VALORTIPOASIGNACION = '"+articuloLocalDTO.getValorTipoAsignacion()+"' ");//CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL
			query.append(" ,AL.CODIGOTIPOASIGNACION = "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+" ");
			query.append(" ,AL.CODIGOOPCION = '"+articuloLocalDTO.getCodigoOpcion()+"' ");
			query.append(" ,AL.ESTADOARTICULOLOCAL = '"+articuloLocalDTO.getEstadoArticuloLocal()+"' ");
			query.append(" ,AL.FECHAINICIALALCANCE = "+(fechaInicioAlcance==null?"NULL":"'"+fechaInicioAlcance+"'")+" ");
			query.append(" ,AL.FECHAFINALALCANCE = "+(fechaFinAlcance==null?"NULL":"'"+fechaFinAlcance+"'")+" ");
			query.append(" ,AL.IDUSUARIOMODIFICACION = '"+articuloVO.getUserId()+"' ");
			query.append(" ,AL.FECHAMODIFICACION = '"+articuloVO.getFechaAplicacion()+"' ");
			
			if(articuloLocalDTO.getEstadoArticuloLocal().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				query.append(" ,AL.FECHAACTIVACION = '"+articuloVO.getFechaAplicacion()+"'");
				query.append(" ,AL.USUARIOACTIVACION = '"+articuloVO.getUserId()+"'");
			}else{
				query.append(" ,AL.FECHAINACTIVACION = '"+articuloVO.getFechaAplicacion()+"'");
				query.append(" ,AL.USUARIOINACTIVACION = '"+articuloVO.getUserId()+"'");
			}
			
			query.append(" ,AL.ESTADOINTEGRACIONALCANCE = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" ,AL.NOTIFICARLOCAL = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" ,AL.APERTURALOCAL = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" WHERE AL.CODIGOCOMPANIA = "+articuloLocalDTO.getId().getCodigoCompania()+" ");
			query.append(" AND AL.CODIGOARTICULO = '"+articuloLocalDTO.getId().getCodigoArticulo()+"' ");
			query.append(" AND AL.CODIGOLOCAL = "+articuloLocalDTO.getId().getCodigoLocal()+" ");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch(HibernateException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	/**
	 *  *En caso de no existir en base da alcance a un articulo 
	 * @param articuloVO
	 * @param articuloLocalDTO
	 * @throws SICException
	 */
	private void insertarArticuloAreaTrabajo(ArticuloVO articuloVO,ArticuloLocalDTO articuloLocalDTO,String nameTable)throws SICException{
		StringBuilder query = null;
		Query sqlQuery = null;
		String fechaFinAlcance=obtenerFechaAlcance(articuloLocalDTO.getFechaFinalAlcance()); 
		String fechaInicioAlcance=obtenerFechaAlcance(articuloLocalDTO.getFechaInicialAlcance());

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder();
			
			query.append(" INSERT INTO "+nameTable+" ( ");
			query.append(" CODIGOARTICULOLOCAL ");
			
			query.append(" ,NOTIFICARLOCAL ");
			query.append(" ,APERTURALOCAL ");
			
			query.append(" ,CODIGOCOMPANIA ");
			query.append(" ,VALORTIPOASIGNACION ");
			query.append(" ,CODIGOTIPOASIGNACION ");
			query.append(" ,ESTADOCODIGOREFERENCIA ");
			query.append(" ,CODIGOSISTEMA ");
			query.append(" ,CODIGOOPCION ");
			query.append(" ,CODIGOLOCAL ");
			query.append(" ,CODIGOARTICULO ");
			query.append(" ,ESTADOARTICULOLOCAL ");
			query.append(" ,IDUSUARIOREGISTRO ");
			query.append(" ,FECHAREGISTRO ");
			query.append(" ,FECHAINICIALALCANCE ");
			if(fechaFinAlcance!=null){
				query.append(" ,FECHAFINALALCANCE ");
			}
			if(articuloLocalDTO.getEstadoArticuloLocal().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
				query.append(" ,FECHAACTIVACION ");
				query.append(" ,USUARIOACTIVACION ");
			}
			query.append(" ,ESTADOINTEGRACIONALCANCE) ");
			query.append(" SELECT NEXT VALUE ");
			query.append(" FOR SCSADSECARTLOC ");
		
			query.append(" ,'").append(SICConstantes.ESTADO_ACTIVO_NUMERICO).append("' ");
			query.append(" ,'").append(SICConstantes.ESTADO_ACTIVO_NUMERICO).append("' ");
			
			query.append(" ,CODIGOCOMPANIA ");
			query.append(" ,'"+articuloLocalDTO.getValorTipoAsignacion()+"' ");//CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL
			query.append(" ,"+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+" ");
			if(SICArticuloConstantes.getInstancia().CODIGO_TIPOARTICULO_CUPON.equals(articuloVO.getBaseDTO().getCodigoTipoArticulo())){
				query.append(" ,'"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			}else{
				query.append(" ,'"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"' ");
			}
			query.append(" ,'"+articuloLocalDTO.getCodigoSistema()+"' ");
			query.append(" ,'"+articuloLocalDTO.getCodigoOpcion()+"' ");
			query.append(" ,"+articuloLocalDTO.getId().getCodigoLocal()+" ");
			query.append(" ,CODIGOARTICULO ");			
			query.append(" ,'"+articuloLocalDTO.getEstadoArticuloLocal()+"' ");			
			query.append(" ,'"+articuloVO.getUserId()+"' ");
			query.append(" ,'"+articuloVO.getFechaAplicacion()+"' ");
			if(fechaInicioAlcance == null){
				fechaInicioAlcance = obtenerFechaAlcance(new Timestamp(System.currentTimeMillis()));
			}
			query.append(" ,'"+fechaInicioAlcance+"' ");
			if(fechaFinAlcance!=null){
				query.append(" ,'"+fechaFinAlcance+"' ");
			}
			if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(articuloLocalDTO.getEstadoArticuloLocal())){
				query.append(" ,'"+articuloVO.getFechaAplicacion()+"' ");
				query.append(" ,'"+articuloVO.getUserId()+"' ");
			}
			
			query.append(" ,'"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" FROM SCSPETARTICULO A ");
			query.append(" WHERE A.CODIGOCOMPANIA = "+articuloLocalDTO.getId().getCodigoCompania()+" ");
			query.append(" AND A.CODIGOARTICULO = '"+articuloLocalDTO.getId().getCodigoArticulo()+"' ");
			query.append(" AND A.CODIGOARTICULO NOT IN ( ");
			query.append(" SELECT CODIGOARTICULO ");
			query.append(" FROM SCSADTARTLOC ");
			query.append(" WHERE CODIGOCOMPANIA = "+articuloLocalDTO.getId().getCodigoCompania()+" ");
			query.append(" AND CODIGOLOCAL = "+articuloLocalDTO.getId().getCodigoLocal()+"   ");
			query.append(" AND CODIGOARTICULO = '"+articuloLocalDTO.getId().getCodigoArticulo()+"' )");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch(HibernateException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	private boolean comprobarBodegaMismoCDT(Integer codigoCompania,Collection<Long> codigoArticuloLocalCol,String codigoArticulo,final Integer codigoLocal)throws SICException{
		try {
			
			Collection<ArticuloLocalDTO> artLoc =  consultarArticuloBodegaAlcance(codigoCompania,codigoArticuloLocalCol,codigoArticulo);
			
			if(CollectionUtils.isNotEmpty(artLoc)){
				
				Collection<Integer> codBod = CollectionUtils.collect(artLoc, new GetInvokerTransformer("id.codigoLocal"));
				
				codBod.add(codigoLocal);
				
				Collection<AreaSublugarTrabajoDTO> areaSubTraCol = consultarCDTdeBOD(codBod);
				
				if(CollectionUtils.isNotEmpty(areaSubTraCol)){
				
					AreaSublugarTrabajoDTO arSubTra = (AreaSublugarTrabajoDTO) CollectionUtils.find(areaSubTraCol, new Predicate() {
						@Override
						public boolean evaluate(Object object) {
							AreaSublugarTrabajoDTO arSubTraAux = (AreaSublugarTrabajoDTO)object;
							return arSubTraAux.getId().getCodigoAreaSublugarTrabajo().toString().equals(codigoLocal.toString());
						}
					});
					
					if(arSubTra != null){
					
						final Integer codigolocalAux =  arSubTra.getId().getCodigoAreaTrabajo();
						areaSubTraCol.remove(arSubTra);
						
						AreaSublugarTrabajoDTO arSubTra2 = (AreaSublugarTrabajoDTO) CollectionUtils.find(areaSubTraCol, new Predicate() {
							@Override
							public boolean evaluate(Object object) {
								AreaSublugarTrabajoDTO arSubTraAux = (AreaSublugarTrabajoDTO)object;
								return arSubTraAux.getId().getCodigoAreaTrabajo().toString().equals(codigolocalAux.toString());
							}
						});
						
						if(arSubTra2 != null){
							return true;
						}
					}
				}
			}
			return false;
			
		} catch (SICException e) {
			throw new SICException(e);
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	private Collection<AreaSublugarTrabajoDTO> consultarCDTdeBOD(Collection<Integer> codBod)throws SICException{
		try {
		
	        Criteria criteria = hibernateH.getHibernateSession().createCriteria(AreaSublugarTrabajoDTO.class);
	        criteria.setProjection(Projections.projectionList()
	                	.add(Projections.property("id.codigoAreaTrabajo"),"id.codigoAreaTrabajo")
	                	.add(Projections.property("id.codigoAreaSublugarTrabajo"),"id.codigoAreaSublugarTrabajo")
	                	.add(Projections.property("cdt.codigoReferencia"),"areaTrabajoDTO.codigoReferencia")
	                );
	        criteria.createAlias("areaTrabajoDTO","cdt");
	        criteria.createAlias("subLugarTrabajoDTO","bod");
	        criteria.add(Restrictions.in("id.codigoAreaSublugarTrabajo", codBod));
	        criteria.add(Restrictions.eq("estado",true));
	        criteria.add(Restrictions.eq("bod.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_BODEGA));
	        criteria.add(Restrictions.eq("bod.tipoAreaTrabajoTIC", TiposCatalogoConstantes.TIPO_AREA_TRABAJO));
	        criteria.add(Restrictions.eq("bod.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
	        criteria.add(Restrictions.eq("cdt.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DE_DISTRIBUCION));
	        criteria.add(Restrictions.eq("cdt.tipoAreaTrabajoTIC", TiposCatalogoConstantes.TIPO_AREA_TRABAJO));
	        criteria.add(Restrictions.eq("cdt.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
	        criteria.add(Restrictions.eq("tipoRelacionValor", CorporativoConstantes.TIPO_RELACION_JERARQUIA_AREA_TRABAJO));
	        
	        criteria.setResultTransformer(new DtoResultTransformer(AreaSublugarTrabajoDTO.class));
			
			Collection<AreaSublugarTrabajoDTO> areaSublugarTrabajoDTOCol =  criteria.list();
			
			return areaSublugarTrabajoDTOCol;
			
			
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	
	private Collection<ArticuloLocalDTO> consultarArticuloBodegaAlcance(Integer codigoCompania,Collection<Long> codigoArticuloLocalCol,String codigoArticulo){
		try {
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class,"artloc");
			
			
			criteria.createAlias("artloc.local", "local");
			
			criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			
			criteria.createAlias("artloc.articulo", "articulo");
			
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criteria.add(Restrictions.eq("artloc.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("artloc.id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.in("artloc.codigoArticuloLocal", codigoArticuloLocalCol));
			
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("artloc.id.codigoArticulo"),"id.codigoArticulo");
	    	projectionList.add(Projections.property("artloc.id.codigoLocal"),"id.codigoLocal");
	    	
	    	criteria.setProjection(projectionList);
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
	    	Collection<ArticuloLocalDTO> artLocalDTOCol = criteria.list();
			
	    	return artLocalDTOCol;
			
		}catch (HibernateException e) {
			throw new SICException(e);
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	private ArticuloLocalDTO consultarArticuloLocalAlcance(Integer codigoCompania,String codigoArticulo,Integer codigoLocal,String tipoAreaTrabajo){
		try {
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(tipoAreaTrabajo);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class,"artloc");
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("id.codigoLocal",codigoLocal));
			
			criteria.createAlias("artloc.local", "local");
			
			if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA.equals(tipoAreaTrabajo)){
				criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_INACTIVO_LITERAL));
			}else{
				criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			}
			
			criteria.createAlias("artloc.articulo", "articulo");
			
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("codigoArticuloLocal"),"codigoArticuloLocal");
	    	
	    	criteria.setProjection(projectionList);
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
	    	ArticuloLocalDTO artLocalDTO = (ArticuloLocalDTO) criteria.uniqueResult();
			
	    	return artLocalDTO;
			
		}catch (HibernateException e) {
			throw new SICException(e);
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Activamos los articulos de locales que se encuentran inactivos,
	 * Si la fechaInicioAlcance es mayor a la fecha actual se inactiva los articulos del local
	 * @param articuloVO
	 * @param cadenasCodigosArticulos
	 * @param cadenaLocales
	 * @param cadenaArticuloAreatrabajo
	 */
	private void activarDesactivarArticulosMasivoLocales(ArticuloVO articuloVO,String cadenasCodigosArticulos,String cadenaLocales,String cadenaArticuloAreatrabajo, Integer notificarLocal, Integer aperturaLocal)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------****************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando activarDesactivarArticulosMasivoLocales(ArticuloVO articuloVO,String cadenasCodigosArticulos,String cadenaLocales,String cadenaArticuloAreatrabajo)");
		Logeable.LOG_SICV2.info("************************************************************************---------------****************************************************************************************");
		
		String accessItemId=articuloVO.getAccessItemId();
		String systemId=articuloVO.getSystemId();		 		 
		String userId=articuloVO.getUsuarioAlcance();
		Timestamp fechaAplicacion=articuloVO.getFechaAplicacion(); 
		Date fechaInicioAlcance=articuloVO.getFechaInicioAlcance();
		String fechaFinAlcance=obtenerFechaAlcance(articuloVO.getFechaFinAlcance()); 
		String opcion=articuloVO.getOpcionAlcance();
		String opcionTipoAsignacionAlcance=articuloVO.getOpcionTipoAsignacionAlcance();
		String tipoConflicto=articuloVO.getTipResolucionConflicto();
		

		
		StringBuilder query = null;
		Query sqlQuery = null;
		String estado=SICConstantes.ESTADO_ACTIVO_NUMERICO;
		
		String nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL;//"SCSADTARTLOC"
		String tipoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL;
		try {
			Session session = hibernateH.getHibernateSession();
//			session.clear();

			query = new StringBuilder();
			
			if(opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
					opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega"))){
				nameTable = SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;//"SCSADTARTBODAUX1"
				tipoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA;
			}else if(opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina")) ||
					opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina"))){
				nameTable = SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA;//"SCSADTARTOFI"
				tipoAreaTrabajo = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA;
			}
			/**permite consultar el alcance que se le quiere realizar el update */
			String codArt = cadenasCodigosArticulos.substring(1, cadenasCodigosArticulos.length()-1);				
			ArticuloLocalDTO artLocDto = consultarArticuloLocalAlcance(articuloVO.getCodigoCompania(), codArt, Integer.valueOf(cadenaLocales),tipoAreaTrabajo);
			/***permite realizar la comparacion que valida que se tiene en base*/
			if(artLocDto != null){
			
					query.append("UPDATE "+nameTable+" AL ");
					query.append(" SET ");
					query.append("  AL.CODIGOSISTEMA = '"+systemId+"' ");
					
					query.append(" ,AL.VALORTIPOASIGNACION = '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"' ");
					query.append(" ,AL.CODIGOTIPOASIGNACION = "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+" ");
					
					if(opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia"))){
						query.append(" ,AL.NOTIFICARLOCAL = '"+articuloVO.getNotificarLocal()+"' ");
						query.append(" ,AL.APERTURALOCAL = '"+articuloVO.getEsApertura()+"' ");
					}else{
						query.append(" ,AL.NOTIFICARLOCAL = '"+notificarLocal+"' ");
						query.append(" ,AL.APERTURALOCAL = '"+aperturaLocal+"' ");
					}
					
					
					query.append(" ,AL.CODIGOOPCION = '"+accessItemId+"' ");
					if(opcion.equals(SICConstantes.ALCANCE_OPCION_ANADIR) || opcion.equals(SICConstantes.ALCANCE_OPCION_REMPLAZAR)){
						
					/*
					 * Permite establecer el estado pendiendo de que si este articulo 
					 * ya este dado alcance con anterioridad asi 
					 * se conservara el estado que tenga este articulo dependiendo de que si 
					 * FECHAINICIALALCANCE en base sea >= fechaInicioAlcance ingresada se mantenga 
					 * FECHAINICIALALCANCE o caso contrario se establece '0'
					 */
					Logeable.LOG_SICV2.info("Fecha inicio "+ConverterUtil.getTruncDate(fechaInicioAlcance)+" fecha actual "+ConverterUtil.getTruncDate(new Date(fechaAplicacion.getTime())));	
					if( ConverterUtil.getTruncDate(fechaInicioAlcance).compareTo(ConverterUtil.getTruncDate(new Date(fechaAplicacion.getTime()))) <= 0){
						
						query.append(" ,AL."+"ESTADOARTICULOLOCAL = '"+estado+"'");
						
					}else if(ConverterUtil.getTruncDate(fechaInicioAlcance).compareTo(ConverterUtil.getTruncDate(new Date(fechaAplicacion.getTime()))) > 0){
						estado=SICConstantes.ESTADO_INACTIVO_NUMERICO;
						query.append(" ,AL."+"ESTADOARTICULOLOCAL = '"+estado+"'");
						/**
						 * --no borrar esto es para analisis--
						 */
		//				query.append(" AL."+estadoTable+" = ");
		//					query.append(" (SELECT CASE WHEN FECHAINICIALALCANCE >= '"+ConverterUtil.parseDateToString(fechaInicioAlcance)+"' "); 
		//					query.append(" THEN "+estadoTable+" ELSE '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"' END AS "+estadoTable+" "); 
		//					query.append(" FROM "+nameTable+" WHERE CODIGOARTICULO IN(AL.CODIGOARTICULO) ");
		//					query.append(" AND "+codigoIdTable+" IN(AL."+codigoIdTable+")) ");
						/**
						 * --------------
						 */
					}		
					/*
					 * Se modifica la FECHAFINALALCANCE y si la FECHAFINALALCANCE en base  > fechaFinAlcance ingresado
					 * se conserva la 	FECHAFINALALCANCE caso contrario fechaFinAlcance
					 * esto es para tener la fecha mayor a que se de alcance
					 */
					
					if(StringUtils.isNotEmpty(tipoConflicto) && tipoConflicto.equals(SICConstantes.ALCANCE_CONFLICTO_AMPLIAR_DESDE_HASTA_FECHA)){
						addRestricciones(query, 1,  fechaFinAlcance, fechaInicioAlcance, nameTable ,fechaAplicacion);
						addRestricciones(query, 2,  fechaFinAlcance, fechaInicioAlcance, nameTable ,fechaAplicacion);
					}else if(StringUtils.isNotEmpty(tipoConflicto) && (tipoConflicto.equals(SICConstantes.ALCANCE_CONFLICTO_AMPLIAR_HASTA_FECHA)
							|| tipoConflicto.equals(SICConstantes.ALCANCE_CONFLICTO_AMPLIAR_DESDE_FECHA))){
						
						if(tipoConflicto.equals(SICConstantes.ALCANCE_CONFLICTO_AMPLIAR_HASTA_FECHA)){
							addRestricciones(query, 1,  fechaFinAlcance, fechaInicioAlcance, nameTable ,fechaAplicacion);
						}else{
							query.append(" ,AL.FECHAFINALALCANCE = "+(fechaFinAlcance==null?"NULL":"'"+fechaFinAlcance+"'")+" ");
						}
							
						if(tipoConflicto.equals(SICConstantes.ALCANCE_CONFLICTO_AMPLIAR_DESDE_FECHA)){
							addRestricciones(query, 2,  fechaFinAlcance, fechaInicioAlcance, nameTable,fechaAplicacion);
						}else{
							query.append(" ,AL.FECHAINICIALALCANCE = '"+ConverterUtil.parseDateToString(fechaInicioAlcance)+"' ");
						}
					}else{
						query.append(" ,AL.FECHAINICIALALCANCE = '"+ConverterUtil.parseDateToString(fechaInicioAlcance)+"' ");
						query.append(" ,AL.FECHAFINALALCANCE = "+(fechaFinAlcance==null?"NULL":"'"+fechaFinAlcance+"'")+" ");
					}
					
		//				query.append(" ,AL.FECHAFINALALCANCE = ");	
		//					query.append(" (SELECT CASE WHEN FECHAFINALALCANCE > '"+fechaFinAlcance+"' ");
		//					query.append(" THEN FECHAFINALALCANCE ELSE '"+fechaFinAlcance+"' END AS FECHAFINALALCANCE  ");
		//					query.append(" FROM "+nameTable+" WHERE CODIGOARTICULO IN(AL.CODIGOARTICULO)  ");
		//					query.append(" AND "+codigoIdTable+" IN(AL."+codigoIdTable+")) ");
		//					
		//			query.append(" ,AL.FECHAINICIALALCANCE = '"+ConverterUtil.parseDateToString(fechaInicioAlcance)+"' ");
		//			query.append(" ,AL.FECHAFINALALCANCE = '"+fechaFinAlcance+"' ");
					
							
					}else if(opcion.equals(SICConstantes.ALCANCE_OPCION_QUITAR)){
						
						SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
						if(formatoFecha.parse(fechaFinAlcance).compareTo(ConverterUtil.getTruncDate(new Date(fechaAplicacion.getTime())))==0){
							/*
							 * Permite inactivar el alcance si la fecha de fechaFinAlcance ingresada es = a la actual  
							 */
							estado=SICConstantes.ESTADO_INACTIVO_NUMERICO;
							query.append(" ,AL."+"ESTADOARTICULOLOCAL = '"+estado+"' ");
						}
						/*
						 * Se establece FECHAINICIALALCANCE dependiendo de que la FECHAINICIALALCANCE en base >= fechaFinAlcance
						 * si esto se da se resta un dia de la fecha de ingreso para que asi la FECHAINICIALALCANCE ya haya pasado y no se vuelva activar 
						 * luego y se cree un alcance sin un final  
						 */
						query.append(" ,AL.FECHAINICIALALCANCE = ");
						query.append("  (SELECT CASE WHEN SAL.FECHAINICIALALCANCE >= '"+fechaFinAlcance +"' ");
						query.append("  THEN CURRENT_DATE - 1 DAYS ELSE SAL.FECHAINICIALALCANCE END AS FECHAINICIALALCANCE ");
						query.append("  FROM "+nameTable+" SAL WHERE SAL.CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND ");
						query.append("   SAL.CODIGOARTICULOLOCAL IN(AL.CODIGOARTICULOLOCAL))	 ");
						
						query.append(" ,AL.FECHAFINALALCANCE = '"+fechaFinAlcance+"'");
					}
					
					query.append(" ,AL.IDUSUARIOMODIFICACION = '"+userId +"'");
					query.append(" ,AL.FECHAMODIFICACION = '"+fechaAplicacion+"'");
		
					if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
						query.append(" ,AL.FECHAACTIVACION = '"+fechaAplicacion+"'");
						query.append(" ,AL.USUARIOACTIVACION = '"+userId+"'");
					}else{
						query.append(" ,AL.FECHAINACTIVACION = '"+fechaAplicacion+"'");
						query.append(" ,AL.USUARIOINACTIVACION = '"+userId+"'");
					}
					
					query.append(" ,AL.ESTADOINTEGRACIONALCANCE = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"'");
					query.append(" WHERE AL.CODIGOARTICULOLOCAL = ").append(artLocDto.getCodigoArticuloLocal()).append("  ");
						
						/**comparacion con primary key**/
//						query.append(" WHERE AL.CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND AL.CODIGOARTICULO IN("+cadenasCodigosArticulos+")");
//						query.append(" AND AL."+"CODIGOLOCAL IN("+cadenaLocales+")");
					
					if(StringUtils.isNotEmpty(tipoConflicto) && tipoConflicto.equals(SICConstantes.ALCANCE_CONFLICTO_RESPETE_FECHA)){
						query.append(" AND (AL.FECHAFINALALCANCE > '"+ConverterUtil.parseDateToString(new Date(fechaAplicacion.getTime()))+"'");
						query.append(" OR AL.FECHAFINALALCANCE IS NULL ) ");
					}
					/**Permite la comparacion de los alcances que no se pueden quitar seleccionados por el usuario**/
					if (StringUtils.isNotEmpty(cadenaArticuloAreatrabajo)  && 
							(opcion.equals(SICConstantes.ALCANCE_OPCION_QUITAR) || 
									opcion.equals(SICConstantes.ALCANCE_OPCION_REMPLAZAR) ||
									opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
										opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega")))){
						
						query.append(" AND AL.CODIGOARTICULOLOCAL NOT IN("+cadenaArticuloAreatrabajo+") ");
					}
					
					sqlQuery = session.createSQLQuery(query.toString());
					sqlQuery.executeUpdate();
			}

		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	private Collection<ArticuloLocalDTO>  consultarEstablecimientosArticulo(String codigoArticulo)throws SICException{
		try {
			
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
			
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			codigoArticulo = codigoArticulo.substring(1, codigoArticulo.length()-1);
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class,"artloc");
			
			criteria.createAlias("local", "areaT");
			
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("estadoArticuloLocal", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("areaT.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.groupProperty("id.codigoArticulo"),"id.codigoArticulo");
	    	projectionList.add(Projections.groupProperty("areaT.codigoEstablecimiento"),"codigoEstablecimiento");	    	
	    	criteria.setProjection(projectionList);
	    	
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
	    	Collection<ArticuloLocalDTO> articuloLocalDTOCol = criteria.list();
			
			return articuloLocalDTOCol;
	    	
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	private void activarDesactivarArticulosMasivoEstablecimientos(String userId,Long codigosArticuloEstablecimiento,String estado){
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			
			Session session = hibernateH.getHibernateSession();

			query = new StringBuilder();
			
			query.append("UPDATE SCARTTARTEST AE SET IDUSUARIOMODIFICACION = '").append(userId).append("', FECHAMODIFICACION = CURRENT_TIMESTAMP, ");
			query.append(" ESTADOARTICULOESTABLECIMIENTO =  ").append(estado);
			query.append(" WHERE ");
			query.append("  CODIGOARTICULOESTABLECIMIENTO = ").append(codigosArticuloEstablecimiento).append(" ");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();

		}catch (HibernateException e) {
			throw new SICException(e);
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	private Collection<ArticuloEstablecimientoDTO> consularArticuloEstablecimiento(String codigoArticulo,Collection<Integer> codigoEstCol,String estado ){
		try {
			
			codigoArticulo = codigoArticulo.substring(1, codigoArticulo.length()-1);
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloEstablecimientoDTO.class,"artEst");
			
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("estadoArticuloEstablecimiento", estado));
			
			if(SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(estado)){
				criteria.add(Restrictions.in("id.codigoEstablecimiento", codigoEstCol));
			}else{
				criteria.add(Restrictions.not(Restrictions.in("id.codigoEstablecimiento", codigoEstCol)));
			}
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo");
	    	projectionList.add(Projections.property("id.codigoEstablecimiento"),"id.codigoEstablecimiento");
	    	projectionList.add(Projections.property("codigoArticuloEstablecimiento"),"codigoArticuloEstablecimiento");
	    	projectionList.add(Projections.property("estadoArticuloEstablecimiento"),"estadoArticuloEstablecimiento");
	    	criteria.setProjection(projectionList);
	    	
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloEstablecimientoDTO.class));
	    	Collection<ArticuloEstablecimientoDTO> articuloEstDTOCol = criteria.list();
			
	    	return articuloEstDTOCol;
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Activamos e inactivamos los establecimientos dependiendo de los alcances
	 * @param userId
	 * @param cadenasCodigosArticulos
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	@Override
	public void activarDesactivarArticulosMasivoEstablecimientos(String userId,String cadenasCodigosArticulos,Timestamp fechaAplicacion)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------****************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando activarDesactivarArticulosMasivoEstablecimientos(ArticuloVO articuloVO,String cadenasCodigosArticulos)");
		Logeable.LOG_SICV2.info("************************************************************************---------------****************************************************************************************");
		Logeable.LOG_SICV2.info("Metodo: activarDesactivarArticulosMasivoEstablecimientos");
		Logeable.LOG_SICV2.info("Parametros: ");
		Logeable.LOG_SICV2.info("userId: "+userId);
		Logeable.LOG_SICV2.info("codigosArticulo:  "+cadenasCodigosArticulos);
		Logeable.LOG_SICV2.info("fechaAplicacion:  "+fechaAplicacion);
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			
			query.append("UPDATE SCARTTARTEST AE SET IDUSUARIOMODIFICACION = '"+userId+"', FECHAMODIFICACION = CURRENT_TIMESTAMP, ");
			query.append(" ESTADOARTICULOESTABLECIMIENTO = ");
			query.append(" CASE WHEN (SELECT COUNT(1) FROM SCSADTARTLOC AL INNER JOIN SSPCOTAREATRABAJO A ON A.CODIGOCOMPANIA=AL.CODIGOCOMPANIA AND A.CODIGOAREATRABAJO=AL.CODIGOLOCAL ");
			query.append(" WHERE AL.CODIGOCOMPANIA=1 AND CODIGOARTICULO = AE.CODIGOARTICULO AND ESTADOARTICULOLOCAL='1' AND AE.CODIGOESTABLECIMIENTO=A.CODIGOESTABLECIMIENTO) = 0 THEN '0' ELSE '1' END ");
			query.append(" WHERE");
			if(StringUtils.isNotBlank(cadenasCodigosArticulos)){
				query.append(" CODIGOARTICULO IN("+cadenasCodigosArticulos+")");
			}
			if(fechaAplicacion != null){
				query.append(" CODIGOARTICULO IN(SELECT CODIGOARTICULO FROM SCSADTARTLOC WHERE FECHAACTIVACION='"+fechaAplicacion+"' OR FECHAINACTIVACION='"+fechaAplicacion+"')");
			}
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (HibernateException e) {			
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.establecimiento"),e);
		}catch (Exception e) {			
			throw new SICException(SICArticuloMessages.getInstancia().getString("mensaje.error.registro.articulo.establecimiento"),e);
		}
	}
	
	/**
	 * Activamos e inactivamos los establecimientos dependiendo de los alcances
	 * @param userId
	 * @param cadenasCodigosArticulos
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	private  void activarDesactivarArticulosEstablecimientos(String userId,String codigosArticulo,Timestamp fechaAplicacion)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------****************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando activarDesactivarArticulosMasivoEstablecimientos(ArticuloVO articuloVO,String cadenasCodigosArticulos)");
		Logeable.LOG_SICV2.info("************************************************************************---------------****************************************************************************************");
		Logeable.LOG_SICV2.info("Metodo: activarDesactivarArticulosMasivoEstablecimientos");
		Logeable.LOG_SICV2.info("Parametros: ");
		Logeable.LOG_SICV2.info("userId: "+userId);
		Logeable.LOG_SICV2.info("codigosArticulo:  "+codigosArticulo);
		Logeable.LOG_SICV2.info("fechaAplicacion:  "+fechaAplicacion);
		try {
			/**PERMITE CONSULTAR LOS ESTABLECIMIENTOS DEL ARTICULO CON ALCANCES ACTUALMENTE**/
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = consultarEstablecimientosArticulo(codigosArticulo);
			if(CollectionUtils.isNotEmpty(articuloLocalDTOCol)){
				Collection<Integer> codigoEstaCol = CollectionUtils.collect(articuloLocalDTOCol, new GetInvokerTransformer("codigoEstablecimiento"));
				
				Logeable.LOG_SICV2.info(""+fechaAplicacion);
				/**PERMITE CONSULTAR LOS ESTABLECIMIENTOS QUE SE ENCUENTRAN EN BASE**/
				Collection<ArticuloEstablecimientoDTO> artEstDtoCol = consularArticuloEstablecimiento(codigosArticulo, codigoEstaCol,SICConstantes.ESTADO_INACTIVO_NUMERICO);
				
				if(CollectionUtils.isNotEmpty(artEstDtoCol)){
					/**PERMITE ACTUALIZAR EL ESTADO DEL ARTICULOESTABLECIMIENTO TOMANDO EN CUENTA LOS ESTADOS **/
					for(ArticuloEstablecimientoDTO artEst: artEstDtoCol){						
							activarDesactivarArticulosMasivoEstablecimientos(userId,  artEst.getCodigoArticuloEstablecimiento(),SICConstantes.ESTADO_ACTIVO_NUMERICO);
					}
				}
				
				artEstDtoCol = null;
				/**PERMITE CONSULTAR LOS ESTABLECIMIENTOS QUE SE ENCUENTRAN EN BASE**/
				 artEstDtoCol = consularArticuloEstablecimiento(codigosArticulo, codigoEstaCol,SICConstantes.ESTADO_ACTIVO_NUMERICO);
				
				if(CollectionUtils.isNotEmpty(artEstDtoCol)){
					/**PERMITE ACTUALIZAR EL ESTADO DEL ARTICULOESTABLECIMIENTO TOMANDO EN CUENTA LOS ESTADOS **/
					for(ArticuloEstablecimientoDTO artEst: artEstDtoCol){
							activarDesactivarArticulosMasivoEstablecimientos(userId, artEst.getCodigoArticuloEstablecimiento(),SICConstantes.ESTADO_INACTIVO_NUMERICO);
					}
				}
			}
		} catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Insertamos los establecimientos dependiendo de los alcances
	 * @param userId
	 * @param cadenasCodigosArticulos
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	public void insertarArticulosMasivoEstablecimientos(String userId, String cadenasCodigosArticulos,Timestamp fechaAplicacion)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------****************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando insertarArticulosMasivoEstablecimientos(ArticuloVO articuloVO,String cadenasCodigosArticulos)");
		Logeable.LOG_SICV2.info("************************************************************************---------------****************************************************************************************");
		
		Logeable.LOG_SICV2.info("Metodo: insertarArticulosMasivoEstablecimientos");
		Logeable.LOG_SICV2.info("Parametros: ");
		Logeable.LOG_SICV2.info("userId: "+userId);
		Logeable.LOG_SICV2.info("cadenasCodigosArticulos:  "+cadenasCodigosArticulos);
		Logeable.LOG_SICV2.info("fechaAplicacion:  "+fechaAplicacion);
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();

			query = new StringBuilder();
			
			query.append("INSERT INTO SCARTTARTEST( CODIGOARTICULOESTABLECIMIENTO, CODIGOCOMPANIA,CODIGOARTICULO,CODIGOESTABLECIMIENTO,ESTADOARTICULOESTABLECIMIENTO,IDUSUARIOREGISTRO,FECHAREGISTRO)");
			query.append(" SELECT NEXT VALUE FOR ").append(SICMessages.getInstancia().getString("ec.com.smx.sic.commons.esquema.nombre")).append(".").append("SCARTSECARTEST");

			query.append(" ,T1.CODIGOCOMPANIA,T1.CODIGOARTICULO,T1.CODIGOESTABLECIMIENTO,T1.ESTADOARTICULOESTABLECIMIENTO ");
			query.append(" ,'"+userId+"',CURRENT_TIMESTAMP ");
			query.append("FROM (");
			query.append(" SELECT  ");
			query.append(" ARTLOC.CODIGOCOMPANIA,ARTLOC.CODIGOARTICULO, CODIGOESTABLECIMIENTO,");
			query.append(" CASE WHEN (SELECT CODIGOARTICULOLOCAL FROM SCSADTARTLOC AL INNER JOIN SSPCOTAREATRABAJO A ON A.CODIGOCOMPANIA=AL.CODIGOCOMPANIA AND A.CODIGOAREATRABAJO=AL.CODIGOLOCAL WHERE AL.CODIGOCOMPANIA=1 AND CODIGOARTICULO = ARTLOC.CODIGOARTICULO AND ESTADOARTICULOLOCAL='1' AND ATR.CODIGOESTABLECIMIENTO=A.CODIGOESTABLECIMIENTO FETCH FIRST ROWS ONLY) IS NULL THEN '0' ELSE '1' END ESTADOARTICULOESTABLECIMIENTO ");
			query.append(" FROM  SCSADTARTLOC ARTLOC");
			query.append(" INNER JOIN SSPCOTAREATRABAJO ATR ON ARTLOC.CODIGOCOMPANIA = ATR.CODIGOCOMPANIA AND ARTLOC.CODIGOLOCAL = ATR.CODIGOAREATRABAJO");
			query.append(" WHERE NOT EXISTS (SELECT 1 FROM SCARTTARTEST ARTEST WHERE ARTEST.CODIGOARTICULO = ARTLOC.CODIGOARTICULO AND ARTEST.CODIGOESTABLECIMIENTO = ATR.CODIGOESTABLECIMIENTO)");
			if(StringUtils.isNotBlank(cadenasCodigosArticulos)){
				query.append(" AND CODIGOARTICULO = "+cadenasCodigosArticulos+"");
			}
			if(fechaAplicacion != null){
				query.append(" AND (FECHAACTIVACION='"+fechaAplicacion+"' OR FECHAINACTIVACION='"+fechaAplicacion+"')");
			}

			query.append(" GROUP BY ARTLOC.CODIGOCOMPANIA ,ARTLOC.CODIGOARTICULO ,CODIGOESTABLECIMIENTO	");

			query.append(" ) T1 ");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();

		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * permite a\u00F1adir partes de sql que permitira realizar validaciones individuales
	 * dentro del update 
	 * @param query
	 * @param key
	 * @param fechaFinAlcance
	 * @param fechaInicioAlcance
	 * @param nameTable
	 * @param codigoIdTable
	 * @throws Exception
	 */
	private void addRestricciones(StringBuilder query,int key,String fechaFinAlcance, Date fechaInicioAlcance,String nameTable,Timestamp fechaAplicacion) throws Exception{
		switch (key) {
		/**
		 * en este case 1 se valida si el articulolocal entra dentro de un articulo en conflicto
		 * tambien se valida fechafinal es mayor que la ingresada ya que si es asi se conservara
		 * la fecha mayor este caso se da cuando el usuario decidio apliar fecha hasta
		 */
		case 1:{
			query.append(" ,AL.FECHAFINALALCANCE = ");
			
			if(fechaFinAlcance!=null){
				query.append(" (SELECT CASE WHEN (SAL.FECHAFINALALCANCE > '"+ConverterUtil.parseDateToString(new Date(fechaAplicacion.getTime()))+"'");
				query.append(" OR SAL.FECHAFINALALCANCE IS NULL ) THEN ");
				query.append(" (SELECT CASE WHEN (SSAL.FECHAFINALALCANCE > '"+fechaFinAlcance+"' OR SSAL.FECHAFINALALCANCE IS NULL )");
				query.append(" THEN SSAL.FECHAFINALALCANCE ELSE '"+fechaFinAlcance+"' END AS FECHAFINALALCANCE  ");
				
				query.append(" FROM "+nameTable+" AS SSAL WHERE SSAL.CODIGOARTICULOLOCAL = SAL.CODIGOARTICULOLOCAL) ");
				
//				query.append(" FROM "+nameTable+" AS SSAL WHERE SSAL.CODIGOCOMPANIA = "+codigoCompania+" AND SSAL.CODIGOARTICULO IN(SAL.CODIGOARTICULO)  ");
//				query.append(" AND SSAL."+codigoIdTable+" IN(SAL."+codigoIdTable+")) ");
				
				query.append(" ELSE '"+fechaFinAlcance+"' END AS FECHAFINALALCANCE  ");
				
				query.append(" FROM "+nameTable+" AS SAL WHERE SAL.CODIGOARTICULOLOCAL = AL.CODIGOARTICULOLOCAL) ");
				
//				query.append(" FROM "+nameTable+" AS SAL WHERE SAL.CODIGOCOMPANIA = "+codigoCompania+" AND SAL.CODIGOARTICULO IN(AL.CODIGOARTICULO)  ");
//				query.append(" AND SAL."+codigoIdTable+" IN(AL."+codigoIdTable+")) ");
				
				
			}else{
				query.append(" NULL ");
			}
		}
			break;
		/**
		 * en este case 2 se valida si el articulolocal entra dentro de un articulo en conflicto
		 * tambien se valida fechainicio es menor que la ingresada ya que si es asi se conservara
		 * la fecha menor este caso se da cuando el usuario decidio apliar fecha desde
		 */
		case 2:{
			query.append(" ,AL.FECHAINICIALALCANCE = ");
			//--
			query.append(" (SELECT CASE WHEN (SAL.FECHAFINALALCANCE > '"+ConverterUtil.parseDateToString(new Date(fechaAplicacion.getTime()))+"'");
			query.append(" OR SAL.FECHAFINALALCANCE IS NULL ) THEN ");
			//--
			query.append(" (SELECT CASE WHEN SSAL.FECHAINICIALALCANCE < '"+ConverterUtil.parseDateToString(fechaInicioAlcance)+"' ");
			query.append(" THEN SSAL.FECHAINICIALALCANCE ELSE '"+ConverterUtil.parseDateToString(fechaInicioAlcance)+"' END AS FECHAINICIALALCANCE  ");
			//--
			query.append(" FROM "+nameTable+" AS SSAL WHERE SSAL.CODIGOARTICULOLOCAL = SAL.CODIGOARTICULOLOCAL)  ");
			
			
//			query.append(" FROM "+nameTable+" AS SSAL WHERE SSAL.CODIGOCOMPANIA = "+codigoCompania+" AND SSAL.CODIGOARTICULO IN(SAL.CODIGOARTICULO)  ");
//			query.append(" AND SSAL."+codigoIdTable+" IN(SAL."+codigoIdTable+")) ");
			//-----
			query.append(" ELSE '"+ConverterUtil.parseDateToString(fechaInicioAlcance)+"' END AS FECHAINICIALALCANCE  ");
			
			query.append(" FROM "+nameTable+" AS SAL WHERE SAL.CODIGOARTICULOLOCAL = AL.CODIGOARTICULOLOCAL )  ");
			
//			query.append(" FROM "+nameTable+" AS SAL WHERE SAL.CODIGOCOMPANIA = "+codigoCompania+" AND SAL.CODIGOARTICULO IN(AL.CODIGOARTICULO)  ");
//			query.append(" AND SAL."+codigoIdTable+" IN(AL."+codigoIdTable+")) ");
		}	
		break;
		
		default:
			break;
		}
	}
	
	
	/**
	 * Inserta los articulos en la tabla articulo local
	 * @param accessItemId
	 * @param systemId
	 * @param cadenasCodigosArticulos
	 * @param articuloVO
	 */
	private void insertarArticulosMasivoLocales(String accessItemId,String systemId,String cadenasCodigosArticulos,String cadenaArticuloAreatrabajo, ArticuloVO articuloVO,ArticuloLocalPrecioVO articuloLocalPrecioVO)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando insertarArticulosMasivoLocales(String accessItemId,String systemId,String cadenasCodigosArticulos,String cadenaArticuloAreatrabajo, ArticuloVO articuloVO)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		
		StringBuilder query = null;
		Query sqlQuery = null;
		
		String nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL,//"SCSADTARTLOC"
				secuenceName=SICConstantes.SECUENCE_TABLA_ARTICULO_LOCAL_BODEGA;//"SCADMSECARTLOC";
		Timestamp fechaAplicacion = articuloVO.getFechaAplicacion();
		try {
			
			if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
					articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega"))){
				nameTable=SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;//"SCSADTARTBODAUX1"
			}else if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina")) || 
					articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina"))){
				nameTable = SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA;//"SCSADTARTOFI"
			}
			
			
			//Obtenemos la fecha fin del alcance
			String fechaFinAlcance =  obtenerFechaAlcance(articuloVO.getFechaFinAlcance());
			
			//Si la fecha de inicio del alcance es igual a la fecha actual el estado es 1 caso contrario el estado es 0
			String estado=null;
			if(ConverterUtil.parseDateToString(articuloVO.getFechaInicioAlcance()).equals(ConverterUtil.parseDateToString(new Date(fechaAplicacion.getTime())))){
				estado = SICConstantes.ESTADO_ACTIVO_NUMERICO;
				Logeable.LOG_SICV2.info("La fecha inicio del alcance es igual a la fecha actual");
			}else{
				estado = SICConstantes.ESTADO_INACTIVO_NUMERICO;
				Logeable.LOG_SICV2.info("La fecha inicio del alcance es diferente a la fecha actual");
			}
			
					Session session = hibernateH.getHibernateSession();
//					session.clear();

					query = new StringBuilder();
					query.append("INSERT INTO "+nameTable+"(CODIGOARTICULOLOCAL, CODIGOCOMPANIA, NOTIFICARLOCAL,APERTURALOCAL,   VALORTIPOASIGNACION,CODIGOTIPOASIGNACION,ESTADOCODIGOREFERENCIA,CODIGOSISTEMA,CODIGOOPCION,"+"CODIGOLOCAL,CODIGOARTICULO,"+"ESTADOARTICULOLOCAL,IDUSUARIOREGISTRO,");
					query.append(" FECHAREGISTRO,FECHAINICIALALCANCE"+(fechaFinAlcance==null?" ":",FECHAFINALALCANCE"));
					
					if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
						query.append(" ,FECHAACTIVACION ,USUARIOACTIVACION ");
					}
					
					query.append(" ,ESTADOINTEGRACIONALCANCE) ");
					query.append(" SELECT NEXT VALUE FOR "+secuenceName+" ");
					query.append(" ,CODIGOCOMPANIA ");
					
					if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia"))){
						//NOTIFICARLOCAL
						query.append(" ,'"+articuloVO.getNotificarLocal()+"' ");
						//APERTURALOCAL
						query.append(" ,'"+articuloVO.getEsApertura()+"' ");
					}else{
						//NOTIFICARLOCAL
//						query.append(" ,'"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"' ");
						query.append(" ,'"+BooleanUtils.toInteger(articuloLocalPrecioVO.getNotificarLocal())+"' ");
						//APERTURALOCAL
//						query.append(" ,'"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"' ");
						query.append(" ,'"+BooleanUtils.toInteger(articuloLocalPrecioVO.getAperturaLocal())+"' ");
					}
					
					query.append(" ,'"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"' ");
					query.append(" ,"+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+" ");
					
					query.append(" ,'"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
					query.append(" ,'"+systemId+"'  ");
					query.append(" ,'"+accessItemId+"'  ");
					query.append("," + articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo());
					query.append(",CODIGOARTICULO");
					query.append(",'"+estado+"'");
					query.append(",'" + articuloVO.getUsuarioAlcance()+"'");
					query.append(",'"+articuloVO.getFechaAplicacion()+"'");
					query.append(",'"+ConverterUtil.parseDateToString(articuloVO.getFechaInicioAlcance())+"' ");
					query.append(" "+(fechaFinAlcance==null?" ": ",'"+fechaFinAlcance+"'")+"  ");
					
					if(estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
						query.append(",'"+articuloVO.getFechaAplicacion()+"'");
						query.append(",'"+articuloVO.getUsuarioAlcance()+"'");
					}
					
					query.append(",'"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"'");
					query.append(" FROM SCSPETARTICULO A");
					query.append(" WHERE A.CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND A.CODIGOARTICULO IN("+cadenasCodigosArticulos+")");
					query.append(" AND A.CODIGOARTICULO NOT IN(");
					query.append(" SELECT CODIGOARTICULO FROM "+nameTable+" WHERE CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND "+"CODIGOLOCAL = "+articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo()+")");
					
					if (StringUtils.isNotEmpty(cadenaArticuloAreatrabajo)  && 
							(articuloVO.getOpcionAlcance().equals(SICConstantes.ALCANCE_OPCION_ANADIR) ||
								articuloVO.getOpcionAlcance().equals(SICConstantes.ALCANCE_OPCION_REMPLAZAR)) &&
									(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) ||
									articuloVO.getOpcionTipoAsignacionAlcance().equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega")))){
						
						query.append(" AND A.CODIGOARTICULO NOT IN(SELECT CODIGOARTICULO FROM "+nameTable+" WHERE CODIGOCOMPANIA = "+articuloVO.getCodigoCompania()+" AND CODIGOARTICULOLOCAL IN("+cadenaArticuloAreatrabajo+")) ");
					}
						
					sqlQuery = session.createSQLQuery(query.toString());
					sqlQuery.executeUpdate();
//					session.flush();
			

		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * Obtiene los codigos de los articulos, concatenado en forma de cadena
	 * @param articuloCol
	 * @return
	 */
	private Collection<String> cadenaCodigosArticulos(List<? extends ArticuloDTO> articuloCol) throws SICException{
		try{
			Collection<String> cadenaCodigosArticulos = new ArrayList<String>();
			int max = 1000;
			StringBuilder cadenaCodigoArticulo = new StringBuilder();
			if(CollectionUtils.size(articuloCol)>=max){
				for(int i=0;i<articuloCol.size();i++){
					//Verificamos is es multiplo del maximo numero de registros
					if(i!=0 && i % max == 0){
						//Removemos la ultima coma
						cadenaCodigoArticulo.deleteCharAt(cadenaCodigoArticulo.length() - 1);
						//Agregamos a la coleccion de cadenas
						cadenaCodigosArticulos.add(cadenaCodigoArticulo.toString());
						//Iniciamos la cadena
						cadenaCodigoArticulo.delete(0, cadenaCodigoArticulo.length());
						cadenaCodigoArticulo.append("'"+articuloCol.get(i).getId().getCodigoArticulo()+"',");
					}
					//Concatenamos los valores
					else{
						cadenaCodigoArticulo.append("'"+articuloCol.get(i).getId().getCodigoArticulo()+"',");
					}
				}

				if(StringUtils.isNotEmpty(cadenaCodigoArticulo)){
					//Removemos la ultima coma y agregamos a la lista
					cadenaCodigoArticulo.deleteCharAt(cadenaCodigoArticulo.length()-1);
					cadenaCodigosArticulos.add(cadenaCodigoArticulo.toString());
				}
				
			}else{
				//Obtenemos la cadena de articulos concatenados
				for(int i=0;i<articuloCol.size();i++){
					cadenaCodigoArticulo.append("'"+articuloCol.get(i).getId().getCodigoArticulo()+"',");
				}
				
				//Removemos la ultima coma y agregamos a la lista
				cadenaCodigoArticulo.deleteCharAt(cadenaCodigoArticulo.length()-1);;
				cadenaCodigosArticulos.add(cadenaCodigoArticulo.toString());
			}
			return cadenaCodigosArticulos;
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * 
	 * @param codigoGrupoAlcance
	 * @param codigosArticulos
	 * @param userId
	 */
	public void actualizarPrototipoArticulo(Long codigoGrupoAlcance,String codigosArticulos,String userId, Timestamp fechaAplicacion,String codigoFuncionario,String opcionAsignacionAlcance,Integer codigoCompania)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando actualizarPrototipoArticulo(Long codigoGrupoAlcance,String codigosArticulos,String userId, Timestamp fechaAplicacion)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCSPETARTICULO ");
			query.append(" SET  FECHAULTIMAACTUALIZACION = '"+fechaAplicacion+"' ,");
			query.append(" USUARIOACTUALIZACION ='"+userId+"' ,");
			query.append(" CODIGOGRUPOALCANCE = "+codigoGrupoAlcance);
			query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOARTICULO IN("+codigosArticulos+")");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite cambiar el articulo al prototipo de coincidencia atravez de la combinacion de ariticuloLocal sea igual a la vista de grupoAlcance
	 */
	@Override
	public void actualizarPrototipoArticulo(Collection<PrototipoArticuloTrasient> prototipoArticuloTrasients, Timestamp fechaAplicacion,String userId,String codigoFuncionario,String opcionAsignacionAlcance,Integer codigoCompania)throws SICException{
		try{	
			Logeable.LOG_SICV2.info("antes del update");
			for(PrototipoArticuloTrasient p: prototipoArticuloTrasients){
				Logeable.LOG_SICV2.info("update-----"+p.getCodigoGrupoAlcance()+"---------"+ p.getCadenaArticulos());
				actualizarPrototipoArticulo(p.getCodigoGrupoAlcance(), p.getCadenaArticulos(), userId, fechaAplicacion,codigoFuncionario,opcionAsignacionAlcance,codigoCompania);
			}
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------------
	// FIN METODOS DE ASIGNACION MASIVO DE ALCANCES
	//---------------------------------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------------------------------
	// INICIO DE METODOS DE COMUNICACION DE ARTICULO-LOCAL AL SIC
	//---------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Permite actualizar masivamente los articulo-local que se comunicaron con exito o error al SIC
	 * @param articuloLocalCol
	 * @param estado
	 * @param userId
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void cambiarEstadoIntegracionArticuloLocal(Collection<ArticuloLocalDTO> articuloLocalCol, Integer codigoLocal, String estado, String userId,String opcionTipoAsignacionAlcance,Integer codigoCompania)throws SICException{
		try{	
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  cambiarEstadoIntegracionArticuloLocal(Collection<ArticuloLocalDTO> articuloLocalCol, String estado, String userId,String opcionTipoAsignacionAlcance)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			//Obtenemos los codigos de los articulos
			Transformer codigoArticuloTransformer=new GetInvokerTransformer("codigoArticuloLocal");
			ArrayList<Long> listCodigosArticulos = (ArrayList<Long>) CollectionUtils.collect(articuloLocalCol, codigoArticuloTransformer);
			HashSet<Long> codigosArticulos=new HashSet<Long>();
			codigosArticulos.addAll(listCodigosArticulos);
			
			String nombreTabla=SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL;
			
			if(StringUtils.isNotEmpty(opcionTipoAsignacionAlcance) ){
				if((opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina")) || 
						opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina")))){

					nombreTabla=SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA;
					if(codigoLocal < 0){
						codigoLocal = codigoLocal * -1;
					}
				}else if((opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) || 
						opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega")))){
					
					nombreTabla=SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;
				}
			}
			//Concatenamos los codigos de articulos 
			String cadenaCodigosArticulos = StringUtils.join(codigosArticulos,",");
						
			StringBuilder query = null;
			Query sqlQuery = null;

			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE "+nombreTabla+" ");//SCSADTARTLOC, SCSADTARTOFI, SCSADTARTBOD
			query.append(" SET  ESTADOINTEGRACIONALCANCE = '"+estado+"' ,");
			query.append(" IDUSUARIOMODIFICACION ='"+userId+"' ,");
			query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOARTICULOLOCAL IN("+cadenaCodigosArticulos+")");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * Permite actualizar masivamente los articulo-local que se comunicaron con exito o error al SIC
	 * @param articuloLocalCol
	 * @param estado
	 * @param userId
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void cambiarEstadoIntegracionArticuloBodega(Collection<ArticuloLocalDTO> articuloBodegaCol, String estado, String userId,Integer codigoCompania)throws SICException{
		try{	
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  cambiarEstadoIntegracionArticuloBodega(Collection<ArticuloLocalDTO> articuloBodegaCol, String estado, String userId)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			//Obtenemos los codigos de los articulos
			Transformer codigoArticuloTransformer=new GetInvokerTransformer("id.codigoArticulo");
			ArrayList<String> listCodigosArticulos = (ArrayList<String>) CollectionUtils.collect(articuloBodegaCol, codigoArticuloTransformer);
			HashSet<String> codigosArticulos=new HashSet<String>();
			codigosArticulos.addAll(listCodigosArticulos);
			
			//Obtenemos los codigos de los articulos
			Transformer codigoLocalTransformer=new GetInvokerTransformer("id.codigoLocal");
			ArrayList<Integer> listCodigosBodegas = (ArrayList<Integer>) CollectionUtils.collect(articuloBodegaCol, codigoLocalTransformer);
			HashSet<Integer> codigosBodegas= new HashSet<Integer>();
			codigosBodegas.addAll(listCodigosBodegas);
			
			//Concatenamos los codigos de articulos 
			String cadenaCodigosArticulos = StringUtils.join(codigosArticulos,"','");
			cadenaCodigosArticulos = "'"+cadenaCodigosArticulos+"'";
			
			//Concatenamos los codigos de bodegas 
			String cadenaCodigosBodegas = StringUtils.join(codigosBodegas,",");
			
			StringBuilder query = null;
			Query sqlQuery = null;

			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE "+SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA+" ");//SCSADTARTBODAUX1
			query.append(" SET  ESTADOINTEGRACIONALCANCE = '"+estado+"' ,");
			query.append(" IDUSUARIOMODIFICACION ='"+userId+"' ,");
			query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP");
			query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOARTICULO IN("+cadenaCodigosArticulos+")");
			query.append(" AND CODIGOLOCAL IN("+cadenaCodigosBodegas+")");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch (HibernateException e) {			
			throw new SICException(e);
		}catch (Exception e) {			
			throw new SICException(e);
		}
	}
	//---------------------------------------------------------------------------------------------------------------------------
	// FIN DE METODOS DE COMUNICACION DE ARTICULO-LOCAL AL SIC
	//---------------------------------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------------------------------------
	// INICIO DE METODOS LLENADO DE BITACORA
	//---------------------------------------------------------------------------------------------------------------------------
	/**
	 * Permite insertar la bitacora de activacion o desactivacion de alcances
	 * @param fechaAplicacion
	 */
	public void insertarBitacoraArticuloAreaTrabajo(Timestamp fechaAplicacion,String opcionTipoAsignacionAlcance,Integer codigoCompania, String codigoArticulo) throws SICException{
		try{
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando insertarBitacoraArticuloAreaTrabajo(Timestamp fechaAplicacion,String opcionTipoAsignacionAlcance)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			
			StringBuilder query = null;
			Query sqlQuery = null;

			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			if(StringUtils.isBlank(opcionTipoAsignacionAlcance)){
				opcionTipoAsignacionAlcance = SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_LOCALES_ESPECIFICOS;
			}
			
			String tipName = this.obtenerSufijoAreaTrabajo(opcionTipoAsignacionAlcance);

			query = new StringBuilder();
			query.append("INSERT INTO SCSADTARTARETRABIT"+ tipName +" (CODIGOCOMPANIA,CODARTARETRABIT,CODIGOAREATRABAJO,CODIGOARTICULO,CODIGOSISTEMA,CODIGOOPCION,ESTADOALCANCE,USUARIOALCANCE,FECHAALCANCE,ESTADO,FECHAINICIALALCANCE,FECHAFINALALCANCE,TIPOBITACORAVALOR,CODIGOTIPOBITACORA,TIPOASIGNACIONVALOR,CODIGOTIPOASIGNACION)");

			query.append(" SELECT CODIGOCOMPANIA,");
			query.append(" NEXT VALUE FOR "+SICMessages.getInstancia().getString("ec.com.smx.sic.commons.esquema.nombre")+".SCSADSECARTARETRABIT,");
			query.append(" CODIGOLOCAL,");
			query.append(" CODIGOARTICULO,");
			query.append(" CODIGOSISTEMA,");
			query.append(" CODIGOOPCION,");
			query.append(" ESTADOARTICULOLOCAL,");
			query.append(" CASE WHEN FECHAACTIVACION='"+fechaAplicacion+"' THEN USUARIOACTIVACION ELSE USUARIOINACTIVACION END AS USUARIOALCANCE,");
			query.append(" '"+fechaAplicacion+"' , ");
			query.append(" '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' AS ESTADO,");
			query.append(" FECHAINICIALALCANCE,");
			query.append(" FECHAFINALALCANCE,");
			query.append(" '"+SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_BITACORA_NORMAL+"' AS TIPOBITACORAVALOR,");
			query.append(" '"+SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_BITACORA+"' AS CODIGOTIPOBITACORA,");
			query.append(" '"+opcionTipoAsignacionAlcance+"' AS TIPOASIGNACIONVALOR,");
			query.append(" '"+SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_ASIGNACION+"' AS CODIGOTIPOASIGNACION");
			query.append(" FROM SCSADTART"+tipName+" ");
			query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND (FECHAACTIVACION='"+fechaAplicacion+"' OR FECHAINACTIVACION='"+fechaAplicacion+"')");
			if(StringUtils.isNotBlank(codigoArticulo)){
				query.append(" AND CODIGOARTICULO = '" + codigoArticulo+"'");
			}
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch(HibernateException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	private Collection<ArticuloLocalDTO> consultarAlcancesActivarDesactivar(Integer codigoCompania,String estado,String sufijoTipoAreaTrabajo)throws SICException{
		Collection<ArticuloLocalDTO> articuloLocalDTOCol;
		try {
			
			String estadoArticuloLocal = SICConstantes.ESTADO_ACTIVO_NUMERICO;
			if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(estado)){
				estadoArticuloLocal = SICConstantes.ESTADO_INACTIVO_NUMERICO;
			}
			
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(sufijoTipoAreaTrabajo);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class);
			
			ProjectionList projectionList = Projections.projectionList();
			projectionList
				.add(Projections.property("codigoArticuloLocal"),"codigoArticuloLocal")				
				.add(Projections.property("idUsuarioRegistro"),"idUsuarioRegistro")
				.add(Projections.property("idUsuarioModificacion"),"idUsuarioModificacion");
			
			criteria.setProjection(projectionList);

			criteria.createAlias("local", "local");
			
			
			if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA.equals(sufijoTipoAreaTrabajo)){
				criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_INACTIVO_LITERAL));
			}else{
				criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			}
			
			criteria.createAlias("articulo", "articulo");
			
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("estadoArticuloLocal", estadoArticuloLocal));
			criteria.add(Restrictions.isNotNull("codigoOpcion"));
			
			if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(estadoArticuloLocal)){
				criteria.add(Restrictions.le("fechaFinalAlcance", ConverterUtil.getCurrentTruncDate()));
				
			}else{
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.gt("fechaFinalAlcance", ConverterUtil.getCurrentTruncDate()));
				disjunction.add(Restrictions.isNull("fechaFinalAlcance"));
				
				criteria.add(Restrictions.le("fechaInicialAlcance", ConverterUtil.getCurrentTruncDate()));
				criteria.add(disjunction);
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
			
			articuloLocalDTOCol = criteria.list();
					
			
			return articuloLocalDTOCol;
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	

	
	/**
	 * Permite activar e inactivar alcances dependiendo de las fechas
	 * @param fechaActual
	 * @param fechaActualTime
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	@Override
	public void activarDesactivarArticulosAlcance(String fechaActual, String fechaActualTime, String sufijoTipoAreaTrabajo, String estado,Integer codigoCompania)throws SICException{
		try {
			
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = consultarAlcancesActivarDesactivar(codigoCompania, estado,sufijoTipoAreaTrabajo);
			
			for(ArticuloLocalDTO articuloLocalDTO: articuloLocalDTOCol){
				
				String idUsuario = articuloLocalDTO.getIdUsuarioRegistro();
				
				if(StringUtils.isNotEmpty(articuloLocalDTO.getIdUsuarioModificacion())){
					idUsuario = articuloLocalDTO.getIdUsuarioModificacion();
				}
				
				activarDesactivarArticulosAlcance(codigoCompania, fechaActualTime, sufijoTipoAreaTrabajo, estado, articuloLocalDTO.getCodigoArticuloLocal(), idUsuario);
			}
			
		} catch (SICException e) {
			throw new SICException(e);
		}
	}

	@SuppressWarnings("deprecation")
	public void insertarBitacoraArticuloAreaTrabajoError(ArticuloVO articuloVO, String codigoArticulo, String errorMsg) throws SICException{
		
		try {
			StringBuilder query = null;
			Query sqlQuery = null;

			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			if(StringUtils.isBlank(articuloVO.getOpcionTipoAsignacionAlcance())){
				articuloVO.setOpcionTipoAsignacionAlcance(SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_LOCALES_ESPECIFICOS);
			}
			
			String tipName = this.obtenerSufijoAreaTrabajo(articuloVO.getOpcionTipoAsignacionAlcance());
			String fechaInicioAlcance=obtenerFechaAlcance(articuloVO.getFechaInicioAlcance()); 
			String fechaFinAlcance=obtenerFechaAlcance(articuloVO.getFechaFinAlcance()); 
			
			for(ArticuloLocalPrecioVO alcance : articuloVO.getLocales()){
				
				Long secuencial = this.obtenerSecuncia(SICMessages.getInstancia().getString("ec.com.smx.sic.commons.esquema.nombre").concat(".SCSADSECARTARETRABIT"));
				
				query = new StringBuilder();
				query.append("INSERT INTO SCSADTARTARETRABIT"+ tipName +" (CODIGOCOMPANIA,CODARTARETRABIT,CODIGOAREATRABAJO,CODIGOARTICULO,CODIGOSISTEMA,CODIGOOPCION,ESTADOALCANCE,USUARIOALCANCE,FECHAALCANCE,ESTADO,");
				query.append("FECHAINICIALALCANCE,");
				if(fechaFinAlcance != null){
					query.append("FECHAFINALALCANCE,");
				}				
				query.append("TIPOBITACORAVALOR,CODIGOTIPOBITACORA,TIPOASIGNACIONVALOR,CODIGOTIPOASIGNACION)");

				query.append(" VALUES ('"+articuloVO.getCodigoCompania()+"',");
				query.append(" '"+secuencial+"',");
				query.append(" '"+alcance.getLocalDTO().getId().getCodigoAreaTrabajo()+"',");
				query.append(" '"+codigoArticulo+"',");
				query.append(" '"+articuloVO.getCodigoSistemaOrigen()+"',");
				query.append(" '"+articuloVO.getAccessItemId()+"',");
				query.append(" '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
				query.append(" '"+articuloVO.getUsuarioAlcance()+"',");
				query.append(" '"+articuloVO.getFechaAplicacion()+"',");
				query.append(" '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
				query.append(" '"+fechaInicioAlcance+"',");
				if(fechaFinAlcance != null){
					query.append(" '"+fechaFinAlcance+"',");
				}
				query.append(" '"+SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_BITACORA_ERROR+"',");
				query.append(" '"+SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_BITACORA+"',");
				query.append(" '"+articuloVO.getOpcionTipoAsignacionAlcance()+"',");
				query.append(" '"+SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_ASIGNACION+"')");
				
				sqlQuery = session.createSQLQuery(query.toString());
				sqlQuery.executeUpdate();

				
				// Insert detalles en tabla de alcances
				query = new StringBuilder();
				query.append("INSERT INTO SCSADTALCBITDET"+ tipName +" (CODIGOCOMPANIA,CODARTARETRABIT,DESCRIPCIONERROR)");
				query.append(" VALUES ('"+articuloVO.getCodigoCompania()+"',");
				query.append(" '"+secuencial+"',");
				query.append(" '"+errorMsg+"')");
				
				sqlQuery = session.createSQLQuery(query.toString());
				sqlQuery.executeUpdate();
				session.flush();
			}
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}

	}
	
	public Long obtenerSecuncia(String nombreSecuencia)throws SICException{
		//SQL Inicial.
		StringBuilder query = new StringBuilder();
		Long totalResultados = null;
		Session session = null;
		Query hqlQuery;
		try{
			String consultaHQL;
			// Reiniciar consulta
			consultaHQL = "";
			
			// Obtiene la sesion.
			session = this.sessionFactory.getCurrentSession();
			session.clear();

			// Determina la consulta.
			consultaHQL = consultaHQL.concat("SELECT NEXT VALUE FOR ");
			consultaHQL = consultaHQL.concat(nombreSecuencia);							
			consultaHQL = consultaHQL.concat(" from SYSIBM.SYSDUMMY1");
			
			// Agregar la consulta
			query.append(consultaHQL);
			// Realizar la consulta.
			hqlQuery = session.createSQLQuery(query.toString());
			
			// Obtener el resultado.
			BigDecimal total = (BigDecimal)hqlQuery.uniqueResult();
			String resultado = String.valueOf(total);
			totalResultados = Long.parseLong(resultado)	;				
			Logeable.LOG_SICV2.info("Total resultados:"+ totalResultados);
			
			//	Atrapa las excepciones originadas por este bloque de codigo try.
		}catch(SICException ex){
			throw new SICException("Error al obtener valor secuencia "+nombreSecuencia+", "+ex);
		}
		// Retornar el resultado.
		return totalResultados;		
	}  
	
	private String obtenerSufijoAreaTrabajo(String opcionTipoAsignacionAlcance){
		
		String tipName = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL;

		if(opcionTipoAsignacionAlcance!=null && 
				(opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega")) 
						||	opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.bodega")))){
					tipName=SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA;
		}else if(opcionTipoAsignacionAlcance!=null && 
				(opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"))
						||	opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.copia.oficina")))){
					tipName = SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA;
		}
		return tipName;
	}
	
	/**
	 * Permite activar e inactivar alcances dependiendo de las fechas
	 * @param fechaActual
	 * @param fechaActualTime
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	private void activarDesactivarArticulosAlcance(Integer codigoCompania,String fechaActualTime, String sufijoTipoAreaTrabajo, String estado,Long codigoArticuloLocal,String idUsuario)throws SICException{
		try {
			
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  activarDesactivarArticulosAlcance ****************");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			StringBuilder query = null;
			Query sqlQuery = null;
			
			String tabla ="";
			
			if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL.equals(sufijoTipoAreaTrabajo)){
				tabla =  SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL;//"SCSADTARTLOC"
			}

			if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA.equals(sufijoTipoAreaTrabajo)){
				tabla = SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA;//"SCSADTARTOFI"
			}
			if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA.equals(sufijoTipoAreaTrabajo)){
				tabla = SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA; //"SCSADTARTBODAUX1"
			}

			//Se valida si no existe alcances para el tipo de area de trabajo
			if(StringUtils.isEmpty(tabla))throw new SICException("No se ha definido alcances para el tipos de area trabajo: "+sufijoTipoAreaTrabajo);
				
			Session session = hibernateH.getHibernateSession();
			session.clear();

				query = new StringBuilder();

				query.append("UPDATE ").append(tabla).append(" ALU ");
				query.append(" SET ");
				query.append("ESTADOINTEGRACIONALCANCE = '").append(SICConstantes.ESTADO_INACTIVO_NUMERICO).append("', ");
				query.append("IDUSUARIOMODIFICACION = '").append(idUsuario).append("' , ");
				query.append("FECHAMODIFICACION = '").append(fechaActualTime).append("' ,");
				
				if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(estado)){
					query.append("ESTADOARTICULOLOCAL = '").append(SICConstantes.ESTADO_ACTIVO_NUMERICO).append("' , ");
					query.append("USUARIOACTIVACION =  '").append(idUsuario).append("' , ");
					query.append("FECHAACTIVACION = '").append(fechaActualTime).append("' ");
				}else{
					query.append("ESTADOARTICULOLOCAL = '").append(SICConstantes.ESTADO_INACTIVO_NUMERICO).append("' , ");
					query.append("USUARIOINACTIVACION =  '").append(idUsuario).append("' , ");
					query.append("FECHAINACTIVACION = '").append(fechaActualTime).append("' ");
				}
				
				query.append(" WHERE ");
				query.append(" CODIGOARTICULOLOCAL = ").append(String.valueOf(codigoArticuloLocal)).append(" ");
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	


	//---------------------------------------------------------------------------------------------------------------------------
	// FIN DE METODOS LLENADO DE BITACORA
	//---------------------------------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------------------------------------
	// INICIO DE METODOS DE ALCANCE PARA LA ADMINISTRACION DE ARTICULOS
	//---------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Permite registrar alcances temporales
	 * @param articuloVO
	 * @throws SICException
	 */
	@Override
	public void registrarAlcanceTemporal(ArticuloVO articuloVO)throws SICException{
		try{
			
			for(String codigoArticulo:articuloVO.getCodigosArticulos()){
				//Se llena los campos requeridos
				ArticuloLocalDTO articuloLocalInsertarDTO = new ArticuloLocalDTO();
				articuloLocalInsertarDTO.getId().setCodigoCompania(articuloVO.getCodigoCompania());
				articuloLocalInsertarDTO.getId().setCodigoLocal(articuloVO.getCodigoLocalAlcance());
				articuloLocalInsertarDTO.getId().setCodigoArticulo(codigoArticulo);
				
				ArticuloLocalDTO articuloLocalActualizarDTO = baseDAO.findUnique(articuloLocalInsertarDTO);
				if(articuloLocalActualizarDTO==null){//Si no existe el registro se procede a crear
					setearPlantilla(articuloLocalInsertarDTO, null, articuloVO, Boolean.TRUE);
					articuloLocalInsertarDTO.setEstadoIntegracionAlcance(SICConstantes.ESTADO_INACTIVO_NUMERICO);
					articuloLocalInsertarDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloLocalInsertarDTO.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_EMERGENTE);
					articuloLocalInsertarDTO.setFechaFinalAlcance(articuloVO.getFechaFinAlcance());
					articuloLocalInsertarDTO.setAperturaLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloLocalInsertarDTO.setNotificarLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					
					baseDAO.create(articuloLocalInsertarDTO);
				}else{//Caso contrario se actualiza el registro
					//se define la fecha final del alcance
					articuloLocalActualizarDTO.setFechaFinalAlcance(articuloVO.getFechaFinAlcance());
					articuloLocalActualizarDTO.setAperturaLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					articuloLocalActualizarDTO.setNotificarLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					
					if(SICConstantes.ESTADO_INACTIVO_NUMERICO.equals(articuloLocalActualizarDTO.getEstadoArticuloLocal())){
						setearPlantilla(articuloLocalActualizarDTO, null, articuloVO, Boolean.TRUE);
						articuloLocalActualizarDTO.setEstadoIntegracionAlcance(SICConstantes.ESTADO_INACTIVO_NUMERICO);
						articuloLocalActualizarDTO.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_EMERGENTE);
						articuloLocalActualizarDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						articuloLocalActualizarDTO.setFechaInicialAlcance(new Date());
//						articuloLocalActualizarDTO.setFechaFinalAlcance(null);
						baseDAO.update(articuloLocalActualizarDTO);
					}else if(!CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_EMERGENTE.equals(articuloLocalActualizarDTO.getValorTipoAsignacion())) {
							articuloLocalActualizarDTO.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_EMERGENTE);
							articuloLocalActualizarDTO.setUserId(articuloVO.getUserId());
							articuloLocalActualizarDTO.setCodigoSistema(articuloVO.getSystemId());
							articuloLocalActualizarDTO.setCodigoOpcion(articuloVO.getAccessItemId());
							articuloLocalActualizarDTO.setFechaActivacion(articuloVO.getFechaAplicacion());
							articuloLocalActualizarDTO.setIdUsuarioActivacion(articuloVO.getUserId());
//							articuloLocalActualizarDTO.setFechaFinalAlcance(null);
							baseDAO.update(articuloLocalActualizarDTO);
					}
				}
			}
		}catch(HibernateDAOException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
		
	}
	
	/**
	 * Permite registrar el alcance a las bodegas padres de una subbodega especifica
	 * @param articuloVO
	 * @throws SICException
	 */
	@Override
	public void registrarAlcanceBodegasSubbodega(ArticuloVO articuloVO, Collection<Integer> codigosAreaTrabajo) throws SICException{
		try{
			ArticuloLocalDTO articuloLocalActualizarDTO;
//			Collection<VistaBodegaSubbodegaAlcanceDTO> vistaBodegasDTO = obtenerBodegasSubbodegaAlcance(articuloVO.getCodigoSubbodega(),codigosCDPredeterminados);
			if(CollectionUtils.isNotEmpty(codigosAreaTrabajo)){
				for(Integer bodega : codigosAreaTrabajo){
					//Se llena los campos requeridos
					ArticuloLocalDTO articuloLocalInsertarDTO = new ArticuloLocalDTO();
					articuloLocalInsertarDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					articuloLocalInsertarDTO.getId().setCodigoLocal(bodega);
					articuloLocalInsertarDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					articuloLocalInsertarDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
					//Se verifica si existe el registro antes de insertar
					articuloLocalActualizarDTO = baseDAO.findUnique(articuloLocalInsertarDTO);
					if(articuloLocalActualizarDTO==null){//Si no existe se procede a crear
						setearPlantilla(articuloLocalInsertarDTO, null, articuloVO, Boolean.TRUE);
						articuloLocalInsertarDTO.setEstadoArticuloLocal(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						baseDAO.create(articuloLocalInsertarDTO);
					}else{//Caso contrario se actualiza el registro
						setearPlantilla(articuloLocalActualizarDTO, null, articuloVO, Boolean.TRUE);
						articuloLocalActualizarDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
						baseDAO.update(articuloLocalActualizarDTO);
					}
				}
			}
			
		}catch(HibernateDAOException e){
			throw new SICException(e);
		}catch(SICException e){
			throw new SICException(e);
		}
	}
	/**
	 * Establece los valores de una plantilla de articulo local previo a la actualizacion o insercion 
	 * @param articuloLocalInsertarActualizar
	 * @param articuloVO
	 */
	private void setearPlantilla(ArticuloLocalDTO articuloLocalInsertarActualizar, ArticuloLocalDTO articuloLocalEnviado, ArticuloVO articuloVO, boolean estadoActivacion){
		//Verifica si se va a actualizar un registro existente
		if(articuloLocalEnviado != null){
			//Se setean valores nuevos en el registro consultado a actualizar
			articuloLocalInsertarActualizar.setFechaInicialAlcance(articuloLocalEnviado.getFechaInicialAlcance());
			articuloLocalInsertarActualizar.setFechaFinalAlcance(articuloLocalEnviado.getFechaFinalAlcance());
			articuloLocalInsertarActualizar.setEstadoArticuloLocal(articuloLocalEnviado.getEstadoArticuloLocal()==null? 
					SICConstantes.ESTADO_INACTIVO_NUMERICO : articuloLocalEnviado.getEstadoArticuloLocal());
		}
		articuloLocalInsertarActualizar.setCodigoSistema(articuloVO.getSystemId());
		articuloLocalInsertarActualizar.setCodigoOpcion(articuloVO.getAccessItemId());
		articuloLocalInsertarActualizar.setUserId(articuloVO.getUserId());
		articuloLocalInsertarActualizar.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL);
		articuloLocalInsertarActualizar.setCodigoTipoAsignacion(TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE);
		articuloLocalInsertarActualizar.setEstadoCodigoReferencia(SICConstantes.ESTADO_INACTIVO_NUMERICO);
		articuloLocalInsertarActualizar.setEstadoIntegracionAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		if(estadoActivacion){//si se crea o activa un alcance
			articuloLocalInsertarActualizar.setIdUsuarioActivacion(articuloVO.getUserId());
			articuloLocalInsertarActualizar.setFechaActivacion(articuloVO.getFechaAplicacion());
			if(articuloLocalInsertarActualizar.getFechaInicialAlcance() == null){
				articuloLocalInsertarActualizar.setFechaInicialAlcance(new Date());
			}
		}else{
			if (articuloLocalInsertarActualizar.getFechaInicialAlcance().compareTo(new Date()) < 0) {//Si no es un alcance programado
				articuloLocalInsertarActualizar.setIdUsuarioInactivacion(articuloVO.getUserId());
				articuloLocalInsertarActualizar.setFechaInactivacion(articuloVO.getFechaAplicacion());
			}
		}
	}
	
	/**
	 * Permite obtener una coleccion de codigos de las bodegas padres de una subbodega en especifica 
	 * @param codigoSubbodega
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	private Collection<VistaBodegaSubbodegaAlcanceDTO> obtenerBodegasSubbodegaAlcance(String codigoSubbodega, String codigosCDPredeterminados) throws SICException{
		Session session;
		StringBuilder query;
		SQLQuery sqlQuery = null;
		try{
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  obtenerBodegasSubbodegaAlcance(String codigoSubbodega)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			//String cdPredeterminados = obtenerCodigosCDSPredeterminadosAlcance();
			query = new StringBuilder();
			session = hibernateH.getHibernateSession();
			session.clear();
			//Armamos el query
			query.append(" SELECT AST.codigoareatrabajo AS {vista.codigoAreaTrabajoBodega}, ASTCD.codigoareatrabajo as {vista.codigoAreaTrabajoSubbodega}");
			query.append(" FROM scspetbodega B ");
			query.append(" INNER JOIN sspcotareatrabajo A ON B.CODIGOCOMPANIA = A.CODIGOCOMPANIA ");
			query.append(" AND B.codigoareatrabajo = A.codigoareatrabajo ");
			query.append(" INNER JOIN sspcotaresublugtra AST ON AST.CODIGOCOMPANIA = A.CODIGOCOMPANIA ");
			query.append(" AND AST.codigoareasublugartrabajo = A.codigoareatrabajo ");
			query.append(" INNER JOIN sspcotareatrabajo ATR ON AST.CODIGOCOMPANIA = ATR.CODIGOCOMPANIA ");
			query.append(" AND AST.codigoareatrabajo = ATR.codigoareatrabajo			 ");
			query.append(" INNER JOIN sspcotaresublugtra ASTCD ON ASTCD.CODIGOCOMPANIA = AST.CODIGOCOMPANIA ");
			query.append(" AND ASTCD.codigoareasublugartrabajo = AST.codigoareatrabajo ");
			query.append(" INNER JOIN sspcotareatrabajo ATRCD ON ASTCD.CODIGOCOMPANIA = ATRCD.CODIGOCOMPANIA ");
			query.append(" AND ASTCD.codigoareatrabajo = ATRCD.codigoareatrabajo							 ");
			query.append(" WHERE B.codigobodega = '"+codigoSubbodega+"' ");
			query.append(" AND A.estadoareatrabajo = '"+SICConstantes.ESTADO_ACTIVO_LITERAL+"' ");
			query.append(" AND ATR.estadoareatrabajo = '"+SICConstantes.ESTADO_ACTIVO_LITERAL+"' ");
			query.append(" AND ATRCD.estadoareatrabajo = '"+SICConstantes.ESTADO_ACTIVO_LITERAL+"' ");
			query.append(" AND AST.estado = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" AND ASTCD.estado = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" AND ATR.tipoareatrabajovalor = '"+CorporativoConstantes.TIPO_AREATRABAJO_BODEGA+"' ");
			query.append(" AND ATRCD.tipoareatrabajovalor = '"+CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DISTRIBUCION+"' ");
			query.append(" AND AST.tiporelacionvalor = '"+CorporativoConstantes.TIPO_RELACION_JERARQUIA_AREA_TRABAJO+"'			 ");
			query.append(" AND ASTCD.tiporelacionvalor = '"+CorporativoConstantes.TIPO_RELACION_JERARQUIA_AREA_TRABAJO+"'	 		 ");
			query.append(" AND ASTCD.codigoareatrabajo IN ("+codigosCDPredeterminados+") ");

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.addEntity("vista",VistaBodegaSubbodegaAlcanceDTO.class);
			return sqlQuery.list();
			
		}catch(HibernateException e){
			throw new SICException(e);
		}catch(SICException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	private Collection<String> consultarCodigosAreasTrabajo(String codigosReferencia )throws SICException{
		Session session;
		StringBuilder query;
		SQLQuery sqlQuery = null;
		Collection<String> codigosAreaTrabajo;
		try {
			query = new StringBuilder();
			session = hibernateH.getHibernateSession();
			session.clear();
			//Armamos el query
			query.append(" SELECT codigoAreaTrabajo FROM sspcotareatrabajo WHERE codigoReferencia in ("+codigosReferencia+")");
			query.append(" AND tipoareatrabajovalor = '"+CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DISTRIBUCION+"'" );
			sqlQuery = session.createSQLQuery(query.toString());
			codigosAreaTrabajo= sqlQuery.list();
		} catch (SICException e) {
			throw new  SICException(e);
		}catch (Exception e) {
			throw new  SICException(e);
		}
		
		return codigosAreaTrabajo;
	}
	
	/**
	 * Retorna los codigos de los CD predeterminados para dar alcance a las bodegas
	 * @return
	 */
	public String obtenerCodigosCDSPredeterminadosAlcance(Integer codigoCompania)throws SICException{
		try{
			ParametroDTO parametroDTO = new ParametroDTO();
			parametroDTO.getId().setCodigoCompania(codigoCompania);
			parametroDTO.getId().setCodigoParametro(SICParametros.getInstancia().PARAMETRO_CDS_PREDETERMINADOS_ALCANCE_BODEGAS);
			parametroDTO = baseDAO.findUnique(parametroDTO);
			Collection<String> codigosAreaTrabajo=consultarCodigosAreasTrabajo(parametroDTO.getValorParametro());
			return StringUtils.join(codigosAreaTrabajo, ",");
			
		}catch(HibernateDAOException e){
			throw new SICException(e);
		}catch(SICException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	/**
	 * Retorna el codigo Area Trabajo de la bodega de acuerdo a su clasificacion
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public Integer obtenerCodigoAreaSublugarTrabajo(Integer codigoCompania, String codigoClasificacion)throws SICException{
		
		try {
			  Integer codigoAreaTrabajo = null;
			  
			  Criteria criteria = hibernateH.getHibernateSession().createCriteria(ClasificacionDTO.class);
			  criteria.setProjection(Projections.distinct(Projections.projectionList().add(Projections.property("bodega.codigoAreaTrabajo"))));
			  criteria.createAlias("bodegaDTO", "bodega");
			  criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			  criteria.add(Restrictions.eq("id.codigoClasificacion", codigoClasificacion));
			  criteria.add(Restrictions.eq("estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			  criteria.add(Restrictions.eq("bodega.estadoBodega", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			  codigoAreaTrabajo = (Integer) criteria.uniqueResult();
			  return codigoAreaTrabajo;
			
		}catch (HibernateException e) {			
			throw new SICException(e);
		}catch (SICException e) {			
			throw new SICException(e);
		} catch (Exception e) {			
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite asignar alcance del articulo a los locales
	 * @param articuloVO
	 * @param articuloLocalCol
	 * @throws SICException
	 */
	public void asignarArticuloAlcanceLocal(ArticuloVO articuloVO, Collection<ArticuloLocalDTO> articuloLocalCol)throws SICException{
		try{
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  asignarArticuloAlcanceLocal(ArticuloVO articuloVO, Collection<ArticuloLocalDTO> articuloLocalCol)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			if(articuloVO.getBaseDTO().getUserId() == null){
				throw new SICException("No existe el usuario de registro para el alcance");
			}
			if(CollectionUtils.isNotEmpty(articuloLocalCol)){
				for(ArticuloLocalDTO articuloLocalDTO:articuloLocalCol){
					establecerAlcance(articuloVO, articuloLocalDTO);
				}
			}
		}catch(SICException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
		
	}
	
	/**
	 * Permite asignar alcance del articulo a las bodegas
	 * @param articuloVO
	 * @param articuloLocalCol
	 * @throws SICException
	 */
	public void asignarArticuloAlcanceBodega(ArticuloVO articuloVO, Collection<ArticuloLocalDTO> articuloBodegaCol)throws SICException{
		try{
			ArticuloLocalDTO articuloLocalActualizarDTO;
			if(CollectionUtils.isNotEmpty(articuloBodegaCol)){
				for(ArticuloLocalDTO articuloBodegaDTO:articuloBodegaCol){
					//Se llena los campos requeridos
					String estadoArticuloLocalAux = articuloBodegaDTO.getEstadoArticuloLocal(); 
					articuloBodegaDTO.getId().setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
					articuloBodegaDTO.getId().setCodigoArticulo(articuloVO.getBaseDTO().getId().getCodigoArticulo());
					articuloBodegaDTO.setEstadoArticuloLocal(null);
					articuloLocalActualizarDTO = baseDAO.findUnique(articuloBodegaDTO);
					articuloBodegaDTO.setEstadoArticuloLocal(estadoArticuloLocalAux);
					if(articuloLocalActualizarDTO==null){//Si no existe el registro se procede a crear
						if(articuloBodegaDTO.getEstadoArticuloLocal().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
							setearPlantilla(articuloBodegaDTO, null, articuloVO, Boolean.TRUE);
						}else{
							setearPlantilla(articuloBodegaDTO, null, articuloVO, Boolean.FALSE);
						}
						baseDAO.create(articuloBodegaDTO);
					}else{//Caso contrario se actualiza el registro
						articuloLocalActualizarDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
						if(articuloBodegaDTO.getEstadoArticuloLocal().equals(SICConstantes.ESTADO_ACTIVO_NUMERICO)){
							setearPlantilla(articuloLocalActualizarDTO, articuloBodegaDTO, articuloVO, Boolean.TRUE);
						}else{
							setearPlantilla(articuloLocalActualizarDTO, articuloBodegaDTO, articuloVO, Boolean.FALSE);
						}
						baseDAO.update(articuloLocalActualizarDTO);
					}
				}
			}
		}catch(HibernateDAOException e){
			throw new SICException(e);
		}catch(SICException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}		
	}
	
	
	/**
	 * Inserta, activa o desactiva subbodegas en AreaSublugarTrabajo
	 * @param userId
	 * @param codigosBodega
	 * @param estadoSet
	 * @param fechaAplicacion
	 * @throws SICException
	 */
	@Override
	public void actualizacionSubbodegas(String userId, String codigosBodega, String estadoSet, Timestamp fechaAplicacion,String opcionTipoAsignacionAlcance, String codigoArticulo,Integer codigoCompania)throws SICException{
		Logeable.LOG_SICV2.info("actualizacionSubbodegas");
		Logeable.LOG_SICV2.info("codigosBodega {}",codigosBodega);
		Logeable.LOG_SICV2.info("estadoSet {}",estadoSet);
		Logeable.LOG_SICV2.info("fechaAplicacion {}",fechaAplicacion);
		Logeable.LOG_SICV2.info("opcionTipoAsignacionAlcance {}",opcionTipoAsignacionAlcance);
		Logeable.LOG_SICV2.info("codigoArticulo {}",codigoArticulo);
		Logeable.LOG_SICV2.info("codigoCompania {}",codigoCompania);
		
		/*try{
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando actualizacionSubbodegas(String userId, String codigosBodega, String estadoSet, Timestamp fechaAplicacion,String opcionTipoAsignacionAlcance)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			//Actualizamos las subbodegas en areaSubLugarTrabajo
			activarDesactivarAreaSubLugarTrabajo(userId, codigosBodega, estadoSet,opcionTipoAsignacionAlcance, fechaAplicacion, codigoArticulo,codigoCompania);
			//Insertamos las subbodegas faltantes
			if(estadoSet.equals(CorporativoConstantes.ESTADO_ACTIVO_BOOLEANO)){
				insertarSubBodegas(userId, fechaAplicacion,opcionTipoAsignacionAlcance,codigoCompania);
			}
		}catch(Exception e){
			Logeable.LOG_SICV2.error("Error en la actualizacion de Subbodegas {}", e);
			throw new SICException("Ocurri\u00F3 un error en la asignaci\u00F3n o actualizaci\u00F3n de subbodegas a bodegas ", e);
		}*/
	}
	
	//---------------------------------------------------------------------------------------------------------------------------
	// FIN DE METODOS DE ALCANCE PARA LA ADMINISTRACION DE ARTICULOS
	//---------------------------------------------------------------------------------------------------------------------------
	
	
	//---------------------------------------------------------------------------------------------------------------------------
	// INICIO DE METODOS DE ALCANCE PARA RESOLVER CONFLICTOS
	//---------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Permite actualizar el prototipo de los articulos que se dio alcance
	 * @param userId
	 * @param articuloLocalESTCol
	 * @param fechaAplicacion
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void actualizarPrototipoAlcance(String userId, Collection<ArticuloAlcanceEST> articuloLocalESTCol, Timestamp fechaAplicacion,String codigoFuncionario,String opcionAsignacionAlcance,Integer codigoCompania)throws SICException{
		try{
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  actualizarPrototipoAlcance(String userId, Collection<ArticuloAlcanceEST> articuloLocalESTCol, Timestamp fechaAplicacion)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			String codigosArticulo = obtenerCodigosArticulos(articuloLocalESTCol);
			if(StringUtils.isNotEmpty(codigosArticulo)){
				//Se obtiene la combinacion de locales que posee los articulos
			   Collection<VistaArticuloGrupoAlcanceDTO> vistaArticuloGrupoAlcanceCol = obtenerArticuloLocalCodigosArticulos(codigosArticulo,codigoCompania);
			   if(CollectionUtils.isNotEmpty(vistaArticuloGrupoAlcanceCol)){
				   //Se obtiene los combinaciones de los locales
					Transformer codigosLocalesTransformer=new GetInvokerTransformer("codigosLocales");
					ArrayList<String> listCodigosLocales = (ArrayList<String>) CollectionUtils.collect(vistaArticuloGrupoAlcanceCol, codigosLocalesTransformer);
					
					//Se obtiene los prototipos de la combinacion de locales
					VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocalDTO = new VistaGrupoAlcanceLocalDTO();
					vistaGrupoAlcanceLocalDTO.addCriteriaSearchParameter("areasTrabajo", ComparatorTypeEnum.IN_COMPARATOR, listCodigosLocales);
					Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalCol = baseDAO.findObjects(vistaGrupoAlcanceLocalDTO);
					if(CollectionUtils.isNotEmpty(vistaGrupoAlcanceLocalCol)){
						boolean seActualizo=false;
						//Iteramos la lista de articulos
						for(VistaArticuloGrupoAlcanceDTO vistaArticuloGrupoAlcanceDTO:vistaArticuloGrupoAlcanceCol){
							//Iteramos la lista de combinaciones de locales
							for(VistaGrupoAlcanceLocalDTO vistaGrupoAlcanceLocal:vistaGrupoAlcanceLocalCol){
								//Se valida que sea la misma combinacion de locales e las dos vistas
								if(vistaArticuloGrupoAlcanceDTO.getCodigosLocales().equals(vistaGrupoAlcanceLocal.getAreasTrabajo())){
									actualizarPrototipoArticulo(vistaGrupoAlcanceLocal.getId().getCodigoGrupoTrabajo(), vistaArticuloGrupoAlcanceDTO.getCodigoArticulo(), userId, fechaAplicacion,codigoFuncionario,opcionAsignacionAlcance,codigoCompania);
									seActualizo=true;
									break;
								}
							}
							if(!seActualizo){
								actualizarPrototipoArticulo(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO, vistaArticuloGrupoAlcanceDTO.getCodigoArticulo(), userId, fechaAplicacion,codigoFuncionario,opcionAsignacionAlcance,codigoCompania);
							}seActualizo=false;
						}
					}else{
						for(VistaArticuloGrupoAlcanceDTO vistaArtGrAlc: vistaArticuloGrupoAlcanceCol){
							actualizarPrototipoArticulo(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO,vistaArtGrAlc.getCodigoArticulo(), userId, fechaAplicacion,codigoFuncionario,opcionAsignacionAlcance,codigoCompania);
						}
						
					}
			   }
			}
		}catch (HibernateDAOException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	//---------------------------------------------------------------------------------------------------------------------------
	// FIN DE METODOS DE ALCANCE PARA RESOLVER CONFLICTOS
	//---------------------------------------------------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------------------------------------------------
	// INICIO DE METODOS DE PRIVADOS
	//---------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Obtiene la fecha de fin del alcance
	 * @param articuloVO
	 * @return
	 */
	private String obtenerFechaAlcance(Date fechaFinAlcance)throws SICException{
		try{
			String fechaFinAlcanceString = null;
			//Obtenemos la fecha fin del alcance
			if(fechaFinAlcance!=null){
				fechaFinAlcanceString = ""+ConverterUtil.parseDateToString(fechaFinAlcance)+"";
			}
			return fechaFinAlcanceString;
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * Permite obtener los codigos de los articulos
	 * @param articuloLocalESTCol
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String obtenerCodigosArticulos(Collection<ArticuloAlcanceEST> articuloLocalESTCol)throws SICException{
		try{
			//Obtenemos los codigos de los articulos
			Transformer codigoArticuloTransformer=new GetInvokerTransformer("id.codigoArticulo");
			ArrayList<String> listCodigosArticulos = (ArrayList<String>) CollectionUtils.collect(articuloLocalESTCol, codigoArticuloTransformer);
			
			HashSet<String> codigosArticulos=new HashSet<String>();
			codigosArticulos.addAll(listCodigosArticulos);
			
			//Concatenamos los codigos de articulos 
			String cadenaCodigosArticulos = StringUtils.join(codigosArticulos,"','");
			cadenaCodigosArticulos = "'"+cadenaCodigosArticulos+"'";
			
			return cadenaCodigosArticulos;
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Obtiene la combinacion de locales de los articulos
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private  Collection<VistaArticuloGrupoAlcanceDTO> obtenerArticuloLocalCodigosArticulos(String codigosArticulos,Integer codigoCompania)throws SICException{
		try{
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  obtenerArticuloLocalCodigosArticulos(String codigosArticulos)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");

			StringBuilder sqlQueryString = new StringBuilder("SELECT CODIGOARTICULO AS {vista.codigoArticulo}, FUNARTLOC(CODIGOARTICULO) AS {vista.codigosLocales} ");
		    sqlQueryString.append(" FROM  "+SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL+" ");//SCSADTARTLOC
		    sqlQueryString.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND CODIGOARTICULO IN("+codigosArticulos+") GROUP BY CODIGOARTICULO");
		    
		    SQLQuery sqlQuery = this.hibernateH.getHibernateSession().createSQLQuery(sqlQueryString.toString());
		    sqlQuery.addEntity("vista", VistaArticuloGrupoAlcanceDTO.class);
		    return sqlQuery.list();
		    
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	/**
	 * Permite actualizar el estado de los locales de un prototipo seleccionado
	 * @param estadoGrupoAreaTrabajo
	 * @param codigoGrupoTrabajo
	 * @param usuarioModificacion
	 * @param codigoCompania
	 * @throws SICException
	 */
	@Override
	public void actualizarRelacionGrupoTrabajoAreaTrabajo(String estadoGrupoAreaTrabajo,long codigoGrupoTrabajo,String usuarioModificacion,Integer codigoCompania)throws SICException{
		Session session;
		StringBuilder query = new StringBuilder();
		try{
			session = hibernateH.getHibernateSession();
			session.clear();
			query.append("update ").append(GrupoAreaTrabajoDTO.class.getName());
			query.append(" set estadoGrupoAreaTrabajo = :paramSetEstadoGrupoAreaTrabajo ");
			query.append("   , fechaModificacion = :paramFechaModificacion ");
			query.append("   , usuarioModificacion = :paramUsuarioModificacion ");
			query.append(" where ");
			query.append("     codigoCompania = :paramCodigoCompania ");
			query.append(" and codigoGrupoTrabajo = :paramCodigoGrupoTrabajo ");
			query.append(" and estadoGrupoAreaTrabajo = :paramEstadoGrupoAreaTrabajo ");
			
			Query update = session.createQuery(query.toString());
			update.setString("paramSetEstadoGrupoAreaTrabajo", estadoGrupoAreaTrabajo);
			update.setDate("paramFechaModificacion", new Date());
			update.setString("paramUsuarioModificacion", usuarioModificacion);
			update.setInteger("paramCodigoCompania", codigoCompania);
			update.setLong("paramCodigoGrupoTrabajo", codigoGrupoTrabajo);
			update.setString("paramEstadoGrupoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL);
			
			update.executeUpdate();
			
		}catch(HibernateException e){			
			throw new SICException(e);
		}catch(SICException e){			
			throw new SICException(e);
		}catch(Exception e){			
			throw new SICException(e);
		}
	}
	
	@Override
	public Boolean consultarExistenciaAlcanceArticulo(Integer codigoCompania, String codigoArticulo, Integer codigoLocal) throws SICException {
		Session session;
		StringBuilder query;
		SQLQuery sqlQuery = null;
		try {
			query = new StringBuilder();
			session = hibernateH.getHibernateSession();
			session.clear();
			//Se arma el query
			query.append(" SELECT count(codigoArticulo) FROM scsadtartbod WHERE codigoCompania = :pcodigoCompania ");
			query.append(" and codigoArticulo = :pcodigoArticulo ");
			query.append(" and codigoLocal = :pcodigoLocal ");
			query.append(" and estadoArticuloLocal = :pestadoArticuloLocal ");
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.setInteger("pcodigoCompania", codigoCompania);
			sqlQuery.setString("pcodigoArticulo", codigoArticulo);
			sqlQuery.setInteger("pcodigoLocal", codigoLocal);
			sqlQuery.setString("pestadoArticuloLocal", SICConstantes.ESTADO_ACTIVO_NUMERICO);
			//Resultado
			if (sqlQuery.uniqueResult() instanceof Integer) {
				return ((Integer)sqlQuery.uniqueResult()) > 0 ? Boolean.TRUE : Boolean.FALSE;
			} else {
				return ((Long)sqlQuery.uniqueResult()) > 0 ? Boolean.TRUE : Boolean.FALSE;
			}
			
		}catch(HibernateException e) {
			throw new  SICException(e);
		}catch (SICException e) {
			throw new  SICException(e);
		}catch (Exception e) {
			throw new  SICException(e);
		}
	}
	
	
	
	@Override
	public void insertarCodigoBarrasNoExistentesMigracion(String codigoBarras)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  insertarCodigoBarrasNoExistentesMigracion(String codigoBarras)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		
		
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append(" INSERT INTO SCSADTCODIGOBARRAS (CODIGOBARRAS) VALUES('"+codigoBarras+"')");

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite cambiar el estado de integracion del alcance a travez de los estados de error que retorna el sic
	 * @param alcanceIntegracionTransients
	 * @throws SICException
	 */
	public void cambiarEstadoIntegracionArticuloLocal(Collection<ArticuloAlcanceIntegracionTransient> alcanceIntegracionTransients, String opcionTipoAsignacionAlcance)throws SICException{
		try {
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("***************  Ejecutando  cambiarEstadoIntegracionArticuloLocal(Collection<ArticuloAlcanceIntegracionTransient> alcanceIntegracionTransients)");
			Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
			
			//Obtenemos los registros por tipo de error del sic
			Collection<ArticuloAlcanceIntegracionTransient> noExisteLocal = new ArrayList<ArticuloAlcanceIntegracionTransient>();
			Collection<ArticuloAlcanceIntegracionTransient> noExisteArticulo = new ArrayList<ArticuloAlcanceIntegracionTransient>();
			Collection<ArticuloAlcanceIntegracionTransient> noExistePrototipo = new ArrayList<ArticuloAlcanceIntegracionTransient>();
			if(CollectionUtils.isNotEmpty(alcanceIntegracionTransients)){
				for(ArticuloAlcanceIntegracionTransient artAlcIntTra:alcanceIntegracionTransients){
					if(artAlcIntTra.getTipoError().equals(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_LOCAL_NO_EXISTE)){
						noExisteLocal.add(artAlcIntTra);
					}else if(artAlcIntTra.getTipoError().equals(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_PROTOTIPO_NO_EXISTE)){
						noExistePrototipo.add(artAlcIntTra);
					}else if(artAlcIntTra.getTipoError().equals(SICConstantes.CODIGO_ERROR_INTEGRACION_SIC_ARTICULO_NO_EXISTE)){
						noExisteArticulo.add(artAlcIntTra);
					}
				}
			}
			
			//Se define la tabla de integracion
			String nombreTabla=SICConstantes.NOMBRE_TABLA_ARTICULO_LOCAL;
			if(StringUtils.isNotEmpty(opcionTipoAsignacionAlcance) ){
				if(opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"))){
					nombreTabla=SICConstantes.NOMBRE_TABLA_ARTICULO_BODEGA;
				}else if(opcionTipoAsignacionAlcance.equals(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.oficina"))){
					nombreTabla=SICConstantes.NOMBRE_TABLA_ARTICULO_OFICINA;
				}
			}
			
			//Procedemos a modificar los registros
			if(CollectionUtils.isNotEmpty(noExisteLocal)){
				Logeable.LOG_SICV2.info("Registros sin locales {}",noExisteLocal.size());
				cambiarEstadoIntegracionAlcanceErroSIC(noExisteLocal,nombreTabla,SICConstantes.CODIGO_ESTADO_SIC_LOCAL_NO_EXISTE);
			}
			if(CollectionUtils.isNotEmpty(noExistePrototipo)){
				Logeable.LOG_SICV2.info("Registros sin prototipo {}",noExistePrototipo.size());
				cambiarEstadoIntegracionAlcanceErroSIC(noExistePrototipo,nombreTabla,SICConstantes.CODIGO_ESTADO_SIC_PROTOTIPO_NO_EXISTE);
			}
			if(CollectionUtils.isNotEmpty(noExisteArticulo)){
				Logeable.LOG_SICV2.info("Registros sin articulo {}",noExisteArticulo.size());
				cambiarEstadoIntegracionAlcanceErroSIC(noExisteArticulo,nombreTabla,SICConstantes.CODIGO_ESTADO_SIC_ARTICULO_NO_EXISTE);
			}
			
		}catch(SICException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
	}
	
	/**
	 * Actualiza masivamente el estado de la integracion de alcances dependiendo de los errores desde SIC
	 * @param alcanceIntegracionTransients
	 * @param nombreTabla
	 * @param estadoIntegracionAlcance
	 */
	@SuppressWarnings("unchecked")
	private void cambiarEstadoIntegracionAlcanceErroSIC(Collection<ArticuloAlcanceIntegracionTransient> alcanceIntegracionTransients, String nombreTabla, String estadoIntegracionAlcance)throws SICException{
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			//Obtenemos los codigos de los articulos local
			Transformer codigoArticuloTransformer=new GetInvokerTransformer("codigoArticuloLocal");
			ArrayList<String> listCodigosArticulos = (ArrayList<String>) CollectionUtils.collect(alcanceIntegracionTransients, codigoArticuloTransformer);
			String codigosArticuloLocal=StringUtils.join(listCodigosArticulos,",");
			
			
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append(" UPDATE ");
			query.append(nombreTabla);
			query.append(" SET ESTADOINTEGRACIONALCANCE = '"+estadoIntegracionAlcance+ "'");
			query.append(" WHERE CODIGOARTICULOLOCAL IN("+codigosArticuloLocal+")");

			sqlQuery = session.createSQLQuery(query.toString());		
			sqlQuery.executeUpdate();
			session.flush();

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite registrar alcance a los locales de un prototipo
	 * @param codigoPrototipo
	 * @param userId
	 */
	public void insertarAlcancePorPrototipo(ArticuloVO articuloVO)throws SICException{
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  insertarAlcancePorPrototipo(Integer codigoPrototipo, String userId)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");
		
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			
				Logeable.LOG_SICV2.info("Param:  "+articuloVO.getBaseDTO().getId().getCodigoCompania());
				Logeable.LOG_SICV2.info("Param:  "+articuloVO.getSystemId());
				Logeable.LOG_SICV2.info("Param:  "+articuloVO.getAccessItemId());
				Logeable.LOG_SICV2.info("Param:  "+articuloVO.getBaseDTO().getId().getCodigoArticulo());
				Logeable.LOG_SICV2.info("Param:  "+articuloVO.getBaseDTO().getUserId());
				Logeable.LOG_SICV2.info("Param:  "+articuloVO.getFechaAplicacion());
				Logeable.LOG_SICV2.info("Param:  "+articuloVO.getBaseDTO().getCodigoGrupoAlcance());
				
				
				Session session = hibernateH.getHibernateSession();
				session.clear();
				
				query = new StringBuilder();
				query.append("INSERT INTO SCSADTARTLOC(CODIGOARTICULOLOCAL,CODIGOCOMPANIA,NOTIFICARLOCAL,APERTURALOCAL ,VALORTIPOASIGNACION,CODIGOTIPOASIGNACION,CODIGOSISTEMA,");
				query.append("CODIGOOPCION, CODIGOLOCAL, CODIGOARTICULO, ESTADOARTICULOLOCAL,IDUSUARIOREGISTRO,FECHAREGISTRO,FECHAINICIALALCANCE, ESTADOINTEGRACIONALCANCE, FECHAACTIVACION, USUARIOACTIVACION) ");
				query.append(" SELECT NEXT VALUE FOR "+SICMessages.getInstancia().getString("ec.com.smx.sic.commons.esquema.nombre")+".SCSADSECARTLOC,");
				query.append(articuloVO.getBaseDTO().getId().getCodigoCompania()+","+SICConstantes.ESTADO_INACTIVO_NUMERICO+","+SICConstantes.ESTADO_INACTIVO_NUMERICO+",");
				query.append("'"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"',"+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+",'"+articuloVO.getSystemId()+"',");
				query.append("'"+articuloVO.getAccessItemId()+"',CODIGOAREATRABAJO,'"+articuloVO.getBaseDTO().getId().getCodigoArticulo()+"',"+SICConstantes.ESTADO_ACTIVO_NUMERICO+",'");
				query.append(articuloVO.getBaseDTO().getUserId()+"','"+articuloVO.getFechaAplicacion()+"',CURRENT_DATE,"+SICConstantes.ESTADO_ACTIVO_NUMERICO+",'"+articuloVO.getFechaAplicacion()+"','"+articuloVO.getBaseDTO().getUserId()+"'");
				query.append(" FROM SSPCOTARETRAGRUTRA WHERE CODIGOGRUPOTRABAJO = "+articuloVO.getBaseDTO().getCodigoGrupoAlcance()+" AND ESTADOGRUPOAREATRABAJO='"+SICConstantes.ESTADO_ACTIVO_LITERAL+"'");
	
				sqlQuery = session.createSQLQuery(query.toString());
				sqlQuery.executeUpdate();
				session.flush();
			

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	@Override
	public Integer countAlcancesSinIntegrar(Integer codigoCompania,String tipAreaTrab, String aperturaLocal) throws SICException{
		
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("***************  Ejecutando  insertarAlcancePorPrototipo(Integer codigoPrototipo, String userId)");
		Logeable.LOG_SICV2.info("************************************************************************---------------***********************************************************************************************");		
		
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("SELECT COUNT(CODIGOARTICULOLOCAL) AS NUMALC FROM SCSADTART"+tipAreaTrab+" WHERE CODIGOCOMPANIA = "+codigoCompania+" AND APERTURALOCAL = "+aperturaLocal+" AND ESTADOINTEGRACIONALCANCE = '"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"' ");
			

			sqlQuery = hibernateH.getHibernateSession().createSQLQuery(query.toString());
			Object objectsNum = sqlQuery.uniqueResult();
			
		
			return (Integer)objectsNum;

		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	
	@Override
	public void cambiarEstadoIntegracionAlcances(StringBuilder cadenaCodigosBarras, Integer codigoLocal, String estado, String userId,String nombreTabla,Integer codigoCompania)throws SICException{
		try{	
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("************************************************************************Ejecutando  CAMBIO DE ESTADO INTEGRACION******************************************************************");
			Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
			Logeable.LOG_SICV2.info("Parametros : cadenaCodigosArticulos: "+cadenaCodigosBarras+" codigolocal: "+codigoLocal+" estadoIntegracion: "+estado+" userId: "+userId+" nombreTabla: "+nombreTabla+"  ");
			
			StringBuilder query = null;
			Query sqlQuery = null;
			
			
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCSADTART"+nombreTabla+" ");//SCSADTARTLOC, SCSADTARTOFI, SCSADTARTBOD
			query.append(" SET  ESTADOINTEGRACIONALCANCE = '"+estado+"' ,");
			query.append(" IDUSUARIOMODIFICACION ='"+userId+"' ,");
			query.append("  VALORTIPOASIGNACION = '"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"', ");
			query.append("  CODIGOTIPOASIGNACION = "+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+", ");
			query.append(" FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOCOMPANIA = "+codigoCompania+" ");
			query.append(" AND  CODIGOBARRAS IN (").append(cadenaCodigosBarras.toString()).append(") ");
			query.append(" AND CODIGOLOCAL = "+codigoLocal+" ");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		Logeable.LOG_SICV2.info("************************************************************************fin de  CAMBIO DE ESTADO INTEGRACION******************************************************************");
		Logeable.LOG_SICV2.info("************************************************************************---------------**********************************************************************************************");
		
	}
	@Override
	@SuppressWarnings("unchecked")
	public Collection<Object[]> validarPrototiposLocales(Collection<String> refProt,Collection<Integer> codLoc) throws SICException{
		try {
			/**
			 * GT.CODIGOGRUPOTRABAJO,GT.CODIGOREFERENCIA
			 */
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(GrupoTrabajoDTO.class);
			criteria.setProjection(Projections.projectionList().add(Projections.groupProperty("codigoReferencia"),"codigoReferencia")
					.add(Projections.groupProperty("id.codigoGrupoTrabajo"),"id.codigoGrupoTrabajo"));
			
			criteria.createAlias("grupoAreasTrabajo", "grupoAreasT",CriteriaSpecification.LEFT_JOIN);	
			
			criteria.add(Restrictions.eq("estadoGrupoTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("grupoAreasT.estadoGrupoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("tipoGrupoTrabajo", CorporativoConstantes.TIPO_GRUPOTRABAJO_ALCANCE));
			criteria.add(Restrictions.eq("tipoGrupoTrabajoTIC", TiposCatalogoConstantes.TIPO_GRUPO_TRABAJO));
			criteria.add(Restrictions.in("codigoReferencia", refProt));
			criteria.add(Restrictions.not(Restrictions.in("grupoAreasT.id.codigoAreaTrabajo", codLoc)));
			
			Collection<Object[]> objCol = criteria.list();
			
			return objCol;
			
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * Permite inactivar los alcances del prototipo anterior que no existen en el prototipo actual
	 * @param codigoCompania
	 * @param userId
	 * @param fechaAplicacion
	 * @param codigoSistema
	 * @param codigoOpcion
	 * @param codigoArticulo
	 * @param codigoGrupoAlcance
	 * @throws SICException
	 */
	public void inactivarAlcancesCambioPrototipo(Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion, String codigoArticulo, Long codigoGrupoAlcance, Collection<AreaTrabajoDTO> areaTrabajoCol)throws SICException{
		try{	
			
			Collection<Integer> codigoAreasTrabajoCol = new ArrayList<Integer>();
			
			
			if(CollectionUtils.isEmpty(areaTrabajoCol)
					&& !codigoGrupoAlcance.equals(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO)){
				Collection<GrupoAreaTrabajoDTO> grupoAreaTrabajoDTOCol = consultarAreaTrabajoPorPrototipo(codigoGrupoAlcance);
				if(CollectionUtils.isNotEmpty(grupoAreaTrabajoDTOCol)){
					codigoAreasTrabajoCol = CollectionUtils.collect(grupoAreaTrabajoDTOCol, new GetInvokerTransformer("id.codigoAreaTrabajo"));
				}
				
			}else{
				codigoAreasTrabajoCol = CollectionUtils.collect(areaTrabajoCol, new GetInvokerTransformer("id.codigoAreaTrabajo"));
			}
			
			if(CollectionUtils.isNotEmpty(codigoAreasTrabajoCol)){
				
				inactivarAlcancesPrototipo(codigoAreasTrabajoCol, codigoArticulo, SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL, SICConstantes.ESTADO_ACTIVO_NUMERICO,
						codigoCompania, userId, fechaAplicacion, codigoSistema, codigoOpcion);
			}
			
		}catch (SICException e) {			
			throw new SICException(e);
		}catch (Exception e) {			
			throw new SICException(e);
		}
	}
	
	@Override
	public void inactivarAlcancesPrototipo(Collection<Integer> codigoAreaTrabajoCol,String codigoArticulo,String sufAreaTrabajo,
			String estado,Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion)throws SICException{
		try {
			
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = consultarCodigosUnicosAlcances(codigoAreaTrabajoCol, codigoArticulo,sufAreaTrabajo,estado);
		
			for(ArticuloLocalDTO articuloLocalDTO : articuloLocalDTOCol){
				Logeable.LOG_SICV2.info("codigoArticuloLocal : "+articuloLocalDTO.getCodigoArticuloLocal());
				inactivarAlcancesCambioPrototipo(codigoCompania, userId, fechaAplicacion, codigoSistema, codigoOpcion,articuloLocalDTO.getCodigoArticuloLocal());
			}
			
		}catch (SICException e) {
			throw new SICException("",e); 
		}catch (Exception e) {
			throw new SICException("",e); 
		}
	}



	private void inactivarAlcancesCambioPrototipo(Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion,Long codigoArticuloLocal)throws SICException{
		try {
			
			Logeable.LOG_SICV2.info("Inactivar alcances cambio de prototipo");
			
			StringBuilder query = null;
			Query sqlQuery = null;
			
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("UPDATE SCSADTARTLOC SET ESTADOARTICULOLOCAL='"+SICConstantes.ESTADO_INACTIVO_NUMERICO+"',");
			query.append("FECHAINICIALALCANCE = CURRENT_DATE - 2 DAY,");
			query.append("FECHAFINALALCANCE=CURRENT_DATE - 1 DAY,");
			query.append("USUARIOINACTIVACION='"+userId+"',");
			query.append("FECHAINACTIVACION='"+fechaAplicacion+"',");
			query.append("IDUSUARIOMODIFICACION='"+userId+"',");
			query.append("FECHAMODIFICACION='"+fechaAplicacion+"',");
			query.append("CODIGOSISTEMA='"+codigoSistema+"',");
			query.append("CODIGOOPCION='"+codigoOpcion+"'");
			
			query.append(" WHERE CODIGOARTICULOLOCAL = '"+codigoArticuloLocal+"'");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	
	private Collection<GrupoAreaTrabajoDTO> consultarAreaTrabajoPorPrototipo(Long codigoGrupoAlcance)throws SICException{
		try {
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GrupoAreaTrabajoDTO.class);
			criteria.setProjection(Projections.projectionList()
						.add(Projections.property("id.codigoAreaTrabajo"),"id.codigoAreaTrabajo")
					);
			
			criteria.createAlias("areaTrabajoDTO", "areaTrabajo");
			
			criteria.add(Restrictions.eq("id.codigoGrupoTrabajo", codigoGrupoAlcance));
			criteria.add(Restrictions.eq("estadoGrupoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			
			criteria.add(Restrictions.eq("areaTrabajo.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_LOCAL));
			criteria.add(Restrictions.eq("areaTrabajo.tipoAreaTrabajoTIC", TiposCatalogoConstantes.TIPO_AREA_TRABAJO));
			
			criteria.setResultTransformer(new DtoResultTransformer(GrupoAreaTrabajoDTO.class));	
			
			Collection<GrupoAreaTrabajoDTO> grupoAreaTrabajoDTOCol = criteria.list();
			
			return grupoAreaTrabajoDTOCol;
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	private Collection<ArticuloLocalDTO> consultarCodigosUnicosAlcances(Collection<Integer> codigoAreaTrabajoCol,String codigoArticulo,String sufAreaTrabajo,String estado)throws SICException{
		try {
			
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();

			articuloLocalDTO.setTipoAreaTrabajo(sufAreaTrabajo);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class);
			criteria.setProjection(Projections.projectionList()
						.add(Projections.property("codigoArticuloLocal"),"codigoArticuloLocal")
					);
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			
			criteria.createAlias("local", "local");
			
			
			if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA.equals(sufAreaTrabajo)){
				criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_INACTIVO_LITERAL));
			}else{
				criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			}
			
			criteria.createAlias("articulo", "articulo");
			
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
				
			if(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(estado)){

				if(CollectionUtils.isNotEmpty(codigoAreaTrabajoCol)){
					criteria.add(Restrictions.not(Restrictions.in("id.codigoLocal", codigoAreaTrabajoCol)));
				}
				
				Disjunction disjunction = Restrictions.disjunction();
				disjunction.add(Restrictions.gt("fechaFinalAlcance", ConverterUtil.getCurrentTruncDate()));
				disjunction.add(Restrictions.isNull("fechaFinalAlcance"));
				criteria.add(disjunction);
			}else{
				criteria.add(Restrictions.in("id.codigoLocal", codigoAreaTrabajoCol));
				criteria.add(Restrictions.eq("estadoArticuloLocal", estado));
			}
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));	
			
			Collection<ArticuloLocalDTO> articuloLocalDTOCol = criteria.list();
			
			return articuloLocalDTOCol;
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	/**
	 * Permite activar los alcances del prototipo anterior que existen en el prototipo actual
	 * @param codigoCompania
	 * @param userId
	 * @param fechaAplicacion
	 * @param codigoSistema
	 * @param codigoOpcion
	 * @param codigoArticulo
	 * @param codigoGrupoAlcance
	 * @throws SICException
	 */
	public void activarAlcancesCambioPrototipo(Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion, String codigoArticulo, Long codigoGrupoAlcance, Collection<AreaTrabajoDTO> areaTrabajoCol)throws SICException{
		try{	
			Collection<Integer> codigoAreasTrabajoCol = new ArrayList<Integer>();
			
			if(CollectionUtils.isEmpty(areaTrabajoCol)
					&& !codigoGrupoAlcance.equals(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO)){
				Collection<GrupoAreaTrabajoDTO> grupoAreaTrabajoDTOCol = consultarAreaTrabajoPorPrototipo(codigoGrupoAlcance);
				if(CollectionUtils.isNotEmpty(grupoAreaTrabajoDTOCol)){
					codigoAreasTrabajoCol = CollectionUtils.collect(grupoAreaTrabajoDTOCol, new GetInvokerTransformer("id.codigoAreaTrabajo"));
				}
			}else{
				codigoAreasTrabajoCol = CollectionUtils.collect(areaTrabajoCol, new GetInvokerTransformer("id.codigoAreaTrabajo"));
			}
			
			if(CollectionUtils.isNotEmpty(codigoAreasTrabajoCol)){
				
				Collection<ArticuloLocalDTO> articuloLocalDTOCol = consultarCodigosUnicosAlcances(codigoAreasTrabajoCol, codigoArticulo,SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL,SICConstantes.ESTADO_INACTIVO_NUMERICO);
				for(ArticuloLocalDTO articuloLocalDTO : articuloLocalDTOCol){
					Logeable.LOG_SICV2.info("codigoArticuloLocal : "+articuloLocalDTO.getCodigoArticuloLocal());
					activarAlcancesCambioPrototipo(codigoCompania, userId, fechaAplicacion, codigoSistema, codigoOpcion,articuloLocalDTO.getCodigoArticuloLocal());
				}
			}
			
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	private void activarAlcancesCambioPrototipo(Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion,Long codigoArticuloLocal)throws SICException{
		try {
			Logeable.LOG_SICV2.info("Activar alcances cambio de prototipo");
			
			StringBuilder query = null;
			Query sqlQuery = null;
			
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("UPDATE SCSADTARTLOC SET ESTADOARTICULOLOCAL='"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
			query.append("FECHAINICIALALCANCE = CURRENT_DATE,");
			query.append("FECHAFINALALCANCE=NULL,");
			query.append("USUARIOACTIVACION='"+userId+"',");
			query.append("FECHAACTIVACION='"+fechaAplicacion+"',");
			query.append("IDUSUARIOMODIFICACION='"+userId+"',");
			query.append("FECHAMODIFICACION='"+fechaAplicacion+"',");
			query.append("CODIGOSISTEMA='"+codigoSistema+"',");
			query.append("CODIGOOPCION='"+codigoOpcion+"'");
			
			query.append(" WHERE CODIGOARTICULOLOCAL = "+codigoArticuloLocal+" ");
						
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite insertar los alcances del prototipo actual que no existen en el prototipo anterior
	 * @param codigoCompania
	 * @param userId
	 * @param fechaAplicacion
	 * @param codigoSistema
	 * @param codigoOpcion
	 * @param codigoArticulo
	 * @param codigoGrupoAlcance
	 * @throws SICException
	 */
	public void insertarAlcancesCambioPrototipo(Integer codigoCompania, String userId, Timestamp fechaAplicacion, String codigoSistema, String codigoOpcion, String codigoArticulo, Long codigoGrupoAlcance, Collection<AreaTrabajoDTO> areaTrabajoCol)throws SICException{
		try{	
			Logeable.LOG_SICV2.info("Activar alcances cambio de prototipo");
			
			StringBuilder query = null;
			Query sqlQuery = null;
			
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("INSERT INTO SCSADTARTLOC(CODIGOARTICULOLOCAL,CODIGOCOMPANIA,NOTIFICARLOCAL,APERTURALOCAL,VALORTIPOASIGNACION,CODIGOTIPOASIGNACION,");
			query.append("CODIGOSISTEMA,CODIGOOPCION, CODIGOLOCAL, CODIGOARTICULO, ESTADOARTICULOLOCAL,IDUSUARIOREGISTRO,FECHAREGISTRO,USUARIOACTIVACION,");
			query.append("FECHAACTIVACION,FECHAINICIALALCANCE, ESTADOINTEGRACIONALCANCE)");
			query.append("SELECT NEXT VALUE FOR "+SICMessages.getInstancia().getString("ec.com.smx.sic.commons.esquema.nombre")+".SCSADSECARTLOC,");
			query.append(codigoCompania+","+SICConstantes.ESTADO_INACTIVO_NUMERICO+","+SICConstantes.ESTADO_INACTIVO_NUMERICO+",");
			query.append("'"+CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL+"',"+TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE+",");
			query.append("'"+codigoSistema+"','"+codigoOpcion+"',A.CODIGOAREATRABAJO,'"+codigoArticulo+"','"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"',");
			query.append("'"+userId+"','"+fechaAplicacion+"','"+userId+"','"+fechaAplicacion+"',CURRENT_DATE,"+SICConstantes.ESTADO_ACTIVO_NUMERICO);
			if(!codigoGrupoAlcance.equals(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO)){
				query.append(" FROM SSPCOTARETRAGRUTRA A INNER JOIN SSPCOTAREATRABAJO B ON A.CODIGOAREATRABAJO = B.CODIGOAREATRABAJO");
				query.append(" AND A.CODIGOCOMPANIA = B.CODIGOCOMPANIA");
				query.append(" WHERE CODIGOGRUPOTRABAJO="+codigoGrupoAlcance+" AND ESTADOGRUPOAREATRABAJO='"+SICConstantes.ESTADO_ACTIVO_LITERAL+"'");
				query.append(" AND B.TIPOAREATRABAJOVALOR = '"+CorporativoConstantes.TIPO_AREATRABAJO_LOCAL+"'");
				query.append(" AND B.TIPOAREATRABAJOTIC = '"+TiposCatalogoConstantes.TIPO_AREA_TRABAJO+"'");
			}else{
				query.append(" FROM SSPCOTAREATRABAJO A WHERE A.ESTADOAREATRABAJO='"+SICConstantes.ESTADO_ACTIVO_LITERAL+"'");
			}
			if(CollectionUtils.isEmpty(areaTrabajoCol)
					&& !codigoGrupoAlcance.equals(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO)){
				query.append(" AND A.CODIGOAREATRABAJO NOT IN(SELECT CODIGOLOCAL FROM SCSADTARTLOC WHERE CODIGOCOMPANIA="+codigoCompania+" AND CODIGOARTICULO='"+codigoArticulo+"')");
			}else{
				if(codigoGrupoAlcance.equals(SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO)){
					query.append(" AND A.CODIGOAREATRABAJO IN("+obtenerCodigosAreasTrabajo(areaTrabajoCol)+") ");
					query.append(" AND NOT EXISTS (SELECT 1 FROM SCSADTARTLOC ARTLOC WHERE ARTLOC.CODIGOARTICULO='"+codigoArticulo+"' AND ARTLOC.CODIGOLOCAL=A.CODIGOAREATRABAJO)");
				}else{
					query.append(" AND A.CODIGOAREATRABAJO NOT IN("+obtenerCodigosAreasTrabajo(areaTrabajoCol)+")");
				}
			}
			
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite obtener los codigos de las areas de trabajo
	 * @param areaTrabajoCol
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String obtenerCodigosAreasTrabajo(Collection<AreaTrabajoDTO> areaTrabajoCol)throws SICException{
		try{
			//Obtenemos los codigos de las areas de trabajo
			ArrayList<Integer> codigosAreasTrabajo = (ArrayList<Integer>) CollectionUtils.collect(areaTrabajoCol, new GetInvokerTransformer("id.codigoAreaTrabajo"));
			//Concatenamos los codigos de areas de trabajo 
			return StringUtils.join(codigosAreasTrabajo,",");
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/**
	 * Permite obtener los datos de BodegaDTO
	 * @param codigoCompania Codigo de la compania
	 * @param codigoBodega Codigo de la bodega
	 * @return BodegaDTO
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public Collection<BodegaDTO> obtenerBodegasPorCodigoBodega(Integer codigoCompania, String codigoBodega)throws SICException{
		Collection<BodegaDTO> bodegaList = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BodegaDTO.class,"root");
			criteria.add(Restrictions.eq("root.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("root.id.codigoBodega", codigoBodega));
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("root.descripcionBodega"),"descripcionBodega");
	    	projectionList.add(Projections.property("root.codigoReferencia"),"codigoReferencia");
	    	criteria.setProjection(Projections.distinct(projectionList));
	    	criteria.setResultTransformer(new DtoResultTransformer(BodegaDTO.class));
	    	bodegaList = criteria.list();
		}catch(HibernateException e){
			throw new  SICException(e);
		}catch(Exception e){
			throw new  SICException(e);
		}		
    	return bodegaList;
	}
	
	
	public ScrollableResults scrollArticuloLocal(ArticuloLocalDTO articuloLocal, Integer maxResults)throws SICException{
		Boolean clearCache = Boolean.TRUE;
		Boolean enableLike = Boolean.TRUE;
		Criteria criteria = hibernateH.getCriteriaQuery(articuloLocal, clearCache, enableLike);
		hibernateH.addRelations(articuloLocal, criteria);
		criteria.setFetchSize(maxResults);
		return criteria.scroll();
	}
	@Override
	public ParametroDTO consultarPrototiposANoAsignar()throws SICException{
		ParametroDTO param = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ParametroDTO.class,"param");
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("param.valorParametro"),"valorParametro");
			criteria.add(Restrictions.eq("param.id.codigoParametro", SICParametros.getInstancia().PARAMETRO_CODIGO_PROTOTIPOS_A_IGNORAR));
			criteria.add(Restrictions.eq("param.estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
	    	criteria.setProjection(projectionList);
	    	criteria.setResultTransformer(new DtoResultTransformer(ParametroDTO.class));
	    	param = (ParametroDTO)criteria.uniqueResult();
			
	    	return param;
		}catch (HibernateException e) {
			throw new SICException(e);
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	@Override
	public Collection<ArticuloLocalDTO> consultarLocalesArticulo(Integer codigoCompania, String codigoArticulo)throws SICException{
		Collection<ArticuloLocalDTO> articuloLocalDTOCol = null;
		try {
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class,"artloc");
			
			criteria.createAlias("artloc.local", "local");
			
			criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("local.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_LOCAL));
			
			criteria.createAlias("artloc.articulo", "articulo");
			
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("id.codigoArticulo", codigoArticulo));
			criteria.add(Restrictions.eq("estadoArticuloLocal", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("id.codigoLocal"),"id.codigoLocal");
	    	criteria.setProjection(projectionList);
	    	criteria.addOrder(Order.asc("id.codigoLocal"));
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
	    	articuloLocalDTOCol = criteria.list();
			
			return articuloLocalDTOCol;
		} catch (HibernateException e) {
			throw new SICException(e);
		} catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	private DetachedCriteria addRestrictionFuncionarioClasificacion(String codigoFuncionario)throws SICException{
		try {
			
			//restriccion de permisos de funcionario
			DetachedCriteria subSelectClaFun = DetachedCriteria.forClass(LineaComercialFuncionarioClasificacionDTO.class,"linComFunCla");
			subSelectClaFun.setProjection(Projections.property("linComFunCla.codigoClasificacion"));
			subSelectClaFun.add(Restrictions.eq("linComFunCla.codigoFuncionario", codigoFuncionario));
			subSelectClaFun.add(Restrictions.eq("linComFunCla.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			return subSelectClaFun;
			
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	@Override
	public Collection<ArticuloLocalDTO> consultarAlcancesPorLocal(Integer codigoCompania, Integer codigoLocal,String tipoAreaTrabajo,String codigoFuncionario)throws SICException{
		Collection<ArticuloLocalDTO> articuloLocalDTOCol = null;
		try {
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(tipoAreaTrabajo);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class,"artloc");
			
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("id.codigoLocal", codigoLocal));
			
						
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.gt("fechaFinalAlcance", ConverterUtil.getCurrentTruncDate()));
			disjunction.add(Restrictions.isNull("fechaFinalAlcance"));
			
			criteria.createAlias("artloc.local", "local");
			
			if(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA.equals(tipoAreaTrabajo)){
				criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_INACTIVO_LITERAL));
			}else{
				criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			}
									
			
			criteria.createAlias("artloc.articulo", "articulo");
			
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(disjunction);
			criteria.add(Subqueries.propertyIn("articulo.codigoClasificacion", addRestrictionFuncionarioClasificacion(codigoFuncionario)));
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("codigoArticuloLocal"),"codigoArticuloLocal");
	    	projectionList.add(Projections.property("id.codigoArticulo"),"id.codigoArticulo");
	    	criteria.setProjection(projectionList);
	    	criteria.addOrder(Order.asc("id.codigoArticulo"));
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
	    	articuloLocalDTOCol = criteria.list();
			
			return articuloLocalDTOCol;
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	
	
	@Override
	public void modificarPrototipoAlcance(Integer codigoCompania,String codigoArticulo,String userID,Timestamp fechaAplicacion,Collection<VistaGrupoAlcanceLocalDTO> vistaGrupoAlcanceLocalDTOs)throws SICException{
		try {
			VistaGrupoAlcanceLocalDTO vistaGrAl = null;
			Collection<ArticuloLocalDTO> artLocCol = consultarLocalesArticulo(codigoCompania, codigoArticulo);
			Long codigoPrototipo = null;
			
			
			//se valida si existen locales asignados a este prototipo
			if(CollectionUtils.isNotEmpty(artLocCol)){
				
				Collection<Integer> codigoLocalCol = CollectionUtils.collect(artLocCol, new GetInvokerTransformer("id.codigoLocal"));				
				final String codiglocales = StringUtils.join(codigoLocalCol,",");
				
				//se obtiene el prototipo que coincida con la convinacion de prototipos del articulo
				vistaGrAl = (VistaGrupoAlcanceLocalDTO)CollectionUtils.find(vistaGrupoAlcanceLocalDTOs, new Predicate() {
					@Override
					public boolean evaluate(Object object) {
						VistaGrupoAlcanceLocalDTO vistaGrAlcDto = (VistaGrupoAlcanceLocalDTO) object;
						return vistaGrAlcDto.getAreasTrabajo().equals(codiglocales);
					}
				});
				//se valida si existe un prototipo para asignar
				if(vistaGrAl != null){
					
					codigoPrototipo = vistaGrAl.getId().getCodigoGrupoTrabajo();
					
//					ParametroDTO param = consultarPrototiposANoAsignar();
//					
//					/**permite la validacion de prototipos que tengan bodegas los cuales se deben ignorar al modificar CodigoGrupoTrabajo del articulo**/
//					if(param != null && SearchDTO.isLoaded(param) && StringUtils.isNotBlank(param.getValorParametro())){
//						Collection<String> codProtCol = new ArrayList<String>(Arrays.asList(param.getValorParametro().split(",")));
//						for(String codigProt : codProtCol){
//							if(StringUtils.isNotBlank(codigProt) && vistaGrAl.getId().getCodigoGrupoTrabajo().toString().equals(codigProt)){
//								codigoPrototipo = null; //SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO;
//							}
//						}
//					}
					//solo si el articulo consta con alcances activos y no se encontro un prototipo se le asigna al personalizado
				}else{
					codigoPrototipo = SICArticuloConstantes.getInstancia().CODIGOPROTOTIPOPERSONALIZADO;
				}
			}
		//se asignara el prototipo dependiendo  de las validaciones anteriores
			if(StringUtils.isNotBlank(codigoArticulo)){
				StringBuilder cadenaCodigoArticulo = new StringBuilder();
				cadenaCodigoArticulo.append("'").append(codigoArticulo).append("'");

				actualizarPrototipoArticulo(codigoPrototipo,cadenaCodigoArticulo.toString(),userID,fechaAplicacion,null,null,codigoCompania);
			}
			
		} catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<AreaTrabajoDTO> consultarOficinas(String tipoAreaTrabajo, Integer codigoCompania)throws SICException{
		Collection<AreaTrabajoDTO> oficinasList;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AreaTrabajoDTO.class,"oficina");
	    	criteria.createAlias("ciudadDTO", "dp",CriteriaSpecification.INNER_JOIN);
	    	criteria.add(Restrictions.eq("oficina.id.codigoCompania", codigoCompania));
	    	criteria.add(Restrictions.eq("oficina.estadoAreaTrabajo",SICConstantes.ESTADO_INACTIVO_LITERAL));
	    	criteria.add(Restrictions.eq("oficina.tipoAreaTrabajoValor", tipoAreaTrabajo));
	    	criteria.add(Restrictions.le("oficina.codigoReferencia", 0));
	    	ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("oficina.id.codigoAreaTrabajo"),"id.codigoAreaTrabajo");
	    	projectionList.add(Projections.property("oficina.tipoAreaTrabajoValor"),"tipoAreaTrabajoValor");
	    	projectionList.add(Projections.property("oficina.codigoReferencia"),"codigoReferencia");
	    	projectionList.add(Projections.property("oficina.nombreAreaTrabajo"),"nombreAreaTrabajo");
	    	projectionList.add(Projections.property("dp.nombreDivGeoPol"),"ciudadDTO.nombreDivGeoPol");
	    	criteria.addOrder(Order.desc("oficina.codigoReferencia"));
	    	criteria.setProjection(Projections.distinct(projectionList));
	    	criteria.setResultTransformer(new DtoResultTransformer(AreaTrabajoDTO.class));
	    	oficinasList = criteria.list();
		}catch(HibernateException e){
			throw new  SICException(e);
		}catch(Exception e){
			throw new  SICException(e);
		}		
		return oficinasList;
		
	}
	
	
	public Collection<ArticuloLocalDTO> obtenerBodegasParaCentroDistribucion(ArticuloDTO articuloDto, String tipoAreaTrabajo)throws SICException{
		
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();

			articuloLocalDTO.setTipoAreaTrabajo(tipoAreaTrabajo);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
		
		try {
			
			Criteria cr = hibernateH.getHibernateSession().createCriteria(ArticuloLocalDTO.class, "bodega");
			cr.createAlias("bodega.local", "areaTrabajo");
			cr.add(Restrictions.eq("bodega.id.codigoCompania", articuloDto.getId().getCodigoCompania()));
			cr.add(Restrictions.eq("bodega.id.codigoArticulo", articuloDto.getId().getCodigoArticulo()));
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("bodega.id.codigoLocal"),"id.codigoLocal");
	    	projectionList.add(Projections.property("bodega.estadoArticuloLocal"),"estadoArticuloLocal");
	    	cr.setProjection(Projections.distinct(projectionList));
	    	cr.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
			Collection<ArticuloLocalDTO> bodegas = cr.list();
			
			return bodegas;
			
		}catch (HibernateException e) {
			throw new  SICException(e);
		}catch (Exception e) {
			throw new  SICException(e);
		}
	}
	
	@Override
	public Collection<AreaSublugarTrabajoDTO> obtenerCentrosDeDistribucionConEstados(Set<Integer> codigosBodegas)throws SICException{
		
		try {
			// Consulta los centros de distribucion a partir de codigos de bodegas 
			return this.consultarCDTdeBOD(codigosBodegas);
			
		}catch (SICException e) {
			throw new  SICException(e);
		}catch (Exception e) {
			throw new  SICException(e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Collection<ArticuloLocalDTO> consultarAreasTrabajoAsignadas(ArticuloDTO articuloDto, String tipoAreaTrabajo, Boolean validarEstado)throws SICException{
		ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();

		articuloLocalDTO.setTipoAreaTrabajo(tipoAreaTrabajo);

		Collection<Object> entities = new ArrayList<Object>();

		entities.add(articuloLocalDTO);

		ShardNamingStrategy.SHARD_RESOLVER.set(entities);
		
		Collection<ArticuloLocalDTO> areaTrabajoList;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class,"articuloLocal");
			criteria.createAlias("local", "areTrabajo",CriteriaSpecification.INNER_JOIN);
			criteria.add(Restrictions.eq("articuloLocal.id.codigoCompania", articuloDto.getId().getCodigoCompania()));
			criteria.add(Restrictions.eq("articuloLocal.id.codigoArticulo", articuloDto.getId().getCodigoArticulo()));
			if(validarEstado)
				criteria.add(Restrictions.eq("articuloLocal.estadoArticuloLocal", SICConstantes.ESTADO_ACTIVO_NUMERICO));
	    	ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("articuloLocal.id.codigoCompania"),"id.codigoCompania");
	    	projectionList.add(Projections.property("articuloLocal.id.codigoArticulo"),"id.codigoArticulo");
	    	projectionList.add(Projections.property("articuloLocal.id.codigoLocal"),"id.codigoLocal");
	    	projectionList.add(Projections.property("articuloLocal.estadoArticuloLocal"),"estadoArticuloLocal");
	    	projectionList.add(Projections.property("articuloLocal.fechaInicialAlcance"),"fechaInicialAlcance");
	    	projectionList.add(Projections.property("articuloLocal.fechaFinalAlcance"),"fechaFinalAlcance");
	    	projectionList.add(Projections.property("areTrabajo.codigoAreaTrabajoPadre"),"local.codigoAreaTrabajoPadre");
	    	projectionList.add(Projections.property("areTrabajo.codigoReferencia"),"local.codigoReferencia");
	    	criteria.setProjection(Projections.distinct(projectionList));
	    	criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
	    	areaTrabajoList = criteria.list();
	    	
		}catch(HibernateException e){
			throw new  SICException(e);
		}catch(Exception e){
			throw new  SICException(e);
		}		
		return areaTrabajoList;
	}
	
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajo()throws SICException{
		
		try {
			
			Collection<AreaTrabajoDTO> bodegaCol = null;
			
			AreaSublugarTrabajoDTO areaSublugarTrabajoDTO = new AreaSublugarTrabajoDTO();
			areaSublugarTrabajoDTO.setSubLugarTrabajoDTO(new AreaTrabajoDTO());
			areaSublugarTrabajoDTO.getSubLugarTrabajoDTO().setTipoAreaTrabajoRestriction(null);
			areaSublugarTrabajoDTO.getSubLugarTrabajoDTO().setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_BODEGA);
			areaSublugarTrabajoDTO.setEstado(Boolean.TRUE);
			// permite la consulta de todos las area trabajo logisticas
			EstablecimientoDTO establecimientoDTO = new EstablecimientoDTO();
			establecimientoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_LITERAL);
			establecimientoDTO.setTipoEstablecimiento(CorporativoConstantes.TIPO_ESTABLECIMIENTO_LOGISTICO);

			EstablecimientoCiudadDTO establecimientoCiudadDTO = new EstablecimientoCiudadDTO();
			establecimientoCiudadDTO.setEstado(SICConstantes.ESTADO_ACTIVO_LITERAL);
			establecimientoCiudadDTO.setEstablecimientoDTO(establecimientoDTO);

			AreaTrabajoDTO areaTrabajoDTO = new AreaTrabajoDTO();
			areaTrabajoDTO.setTipoAreaTrabajoRestriction(null);
			areaTrabajoDTO.setTipoAreaTrabajoValor(CorporativoConstantes.TIPO_AREATRABAJO_CENTRO_DISTRIBUCION);
			areaTrabajoDTO.setEstadoAreaTrabajo(CorporativoConstantes.ESTADO_ACTIVO);
			areaTrabajoDTO.setAreaLugarTrabajoCol(new ArrayList<AreaSublugarTrabajoDTO>());
			areaTrabajoDTO.getAreaLugarTrabajoCol().add(areaSublugarTrabajoDTO);
			areaTrabajoDTO.setEstablecimientoCiudadDTO(establecimientoCiudadDTO);
			areaTrabajoDTO.setOrderByField(OrderBy.orderAsc("id.codigoAreaTrabajo"));

			bodegaCol = CorporativoFactory.getInstancia().getDataService().findObjects(areaTrabajoDTO);
			
			return bodegaCol;
			
		}catch (HibernateDAOException e) {
			throw new  SICException(e);
		}catch (SICException e) {
			throw new  SICException(e);
		}catch (Exception e) {
			throw new  SICException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<AreaTrabajoDTO> consultarBodegas(String tipoAreaTrabajo, Integer codigoCompania)throws SICException{
		Collection<AreaTrabajoDTO> bodegasList;
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AreaTrabajoDTO.class,"cdt");
			criteria.createAlias("areaLugarTrabajoCol","areTra",CriteriaSpecification.INNER_JOIN);
			criteria.createAlias("areTra.subLugarTrabajoDTO", "sub", CriteriaSpecification.INNER_JOIN);
			criteria.createAlias("establecimientoCiudadDTO", "estCiu", CriteriaSpecification.INNER_JOIN);
			criteria.createAlias("estCiu.establecimientoDTO","estab", CriteriaSpecification.INNER_JOIN);
			criteria.add(Restrictions.eq("cdt.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("cdt.tipoAreaTrabajoValor", tipoAreaTrabajo));
			criteria.add(Restrictions.eq("cdt.estadoAreaTrabajo", CorporativoConstantes.ESTADO_ACTIVO));
			criteria.add(Restrictions.eq("sub.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_BODEGA));
			criteria.add(Restrictions.eq("areTra.estado", Boolean.TRUE));
			criteria.add(Restrictions.eq("estab.estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("estab.tipoEstablecimiento", CorporativoConstantes.TIPO_ESTABLECIMIENTO_LOGISTICO));
			criteria.add(Restrictions.eq("estCiu.estado",SICConstantes.ESTADO_ACTIVO_LITERAL));
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("cdt.codigoReferencia"),"codigoReferencia");
			projectionList.add(Projections.property("cdt.nombreAreaTrabajo"),"nombreAreaTrabajo");	
			projectionList.add(Projections.property("sub.codigoReferencia"),"sub.codigoReferencia");
			projectionList.add(Projections.property("sub.nombreAreaTrabajo"),"sub.nombreAreaTrabajo");
			projectionList.add(Projections.property("sub.codigoAreaTrabajoPadre"),"sub.codigoAreaTrabajoPadre");
			projectionList.add(Projections.property("cdt.codigoAreaTrabajoPadre"),"codigoAreaTrabajoPadre");
//			criteria.addOrder(Order.asc("bodega.id.codigoAreaTrabajo"));
			criteria.setProjection(Projections.distinct(projectionList));
	    	criteria.setResultTransformer(new DtoResultTransformer(AreaTrabajoDTO.class));
			bodegasList = criteria.list();
			
		}catch(HibernateException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
		return bodegasList;
	}
	
	public Collection<AreaSublugarTrabajoDTO> obtenerBodegaPorCodigoSubBodega(Integer codigoCompania, Integer codigoSubBod)throws SICException{
		Collection<AreaSublugarTrabajoDTO>  bodega = new ArrayList<AreaSublugarTrabajoDTO>();
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AreaSublugarTrabajoDTO.class,"root");
			criteria.createAlias("areaTrabajoDTO", "areaTrabajo",CriteriaSpecification.INNER_JOIN);
			criteria.createAlias("subLugarTrabajoDTO", "sublugar",CriteriaSpecification.INNER_JOIN);
			criteria.add(Restrictions.eq("root.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("root.estado", Boolean.TRUE));
			criteria.add(Restrictions.eq("sublugar.id.codigoAreaTrabajo", codigoSubBod));
			criteria.add(Restrictions.eq("sublugar.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("areaTrabajo.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_BODEGA));
			criteria.add(Restrictions.eq("areaTrabajo.tipoAreaTrabajoTIC", TiposCatalogoConstantes.TIPO_AREA_TRABAJO));
			criteria.add(Restrictions.eq("areaTrabajo.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			
			ProjectionList projectionList = Projections.projectionList();
	    	projectionList.add(Projections.property("areaTrabajoDTO.id.codigoAreaTrabajo"),"id.codigoAreaTrabajo");
	    	criteria.setProjection(Projections.distinct(projectionList));
	    	criteria.setResultTransformer(new DtoResultTransformer(AreaSublugarTrabajoDTO.class));
	    	bodega = criteria.list();
	    	
		}catch(HibernateException e){
			throw new  SICException(e);
		}catch(Exception e){
			throw new  SICException(e);
		}		
    	return bodega; 
	}
	
	@Override
	public Collection<EstablecimientoDTO> obtenerEstablecimientos(Integer codigoCompania) throws SICException {
		Collection<EstablecimientoDTO> establecimientoCollection = new ArrayList<EstablecimientoDTO>();
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EstablecimientoDTO.class,"establecimiento");
			
			criteria.createAlias("lstEstablecimientoCiudadDTOs", "ec");
			criteria.createAlias("ec.areasTrabajo", "ars");
			
			criteria.add(Restrictions.eq("establecimiento.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.isNotNull("establecimiento.nombreEstablecimiento"));
			criteria.add(Restrictions.eq("ars.tipoAreaTrabajoTIC", TiposCatalogoConstantes.TIPO_AREA_TRABAJO));
			criteria.add(Restrictions.eq("ars.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_LOCAL));
			criteria.add(Restrictions.eq("ars.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));

			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.property("establecimiento.id.codigoEstablecimiento"),"id.codigoEstablecimiento");
			projectionList.add(Projections.property("establecimiento.abreviaturaEstablecimiento"),"abreviaturaEstablecimiento");
			projectionList.add(Projections.property("establecimiento.nombreEstablecimiento"),"nombreEstablecimiento");
			criteria.setProjection(Projections.distinct(projectionList));
			criteria.setResultTransformer(new DtoResultTransformer(EstablecimientoDTO.class));
			criteria.addOrder(Order.asc("establecimiento.id.codigoEstablecimiento"));
			establecimientoCollection = criteria.list();
			
		}catch(HibernateException e){
			throw new SICException(e);
		}catch(Exception e){
			throw new SICException(e);
		}
		return establecimientoCollection;
	}

	@Override
	public Collection<ArticuloLocalDTO> consultarAlcancesModificados(Timestamp fechaAplicacion)throws SICException{
		Collection<ArticuloLocalDTO> articuloLocalDTOCol = null;
		try {
			
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
			articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class,"articuloLocalDTO");
			
			criteria.createAlias("articuloLocalDTO.local", "local");
			
			criteria.add(Restrictions.eq("local.estadoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.add(Restrictions.eq("local.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_LOCAL));
			
			criteria.createAlias("articuloLocalDTO.articulo", "articulo");
			
			criteria.add(Restrictions.eq("articulo.estadoArticulo", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.groupProperty("id.codigoArticulo"),"id.codigoArticulo");
			
			criteria.setProjection(projectionList);
			
			Disjunction disjunction = Restrictions.disjunction();
			disjunction.add(Restrictions.eq("fechaRegistro", fechaAplicacion));
			disjunction.add(Restrictions.eq("fechaActivacion", fechaAplicacion));
			disjunction.add(Restrictions.eq("fechaInactivacion", fechaAplicacion));
			
			criteria.add(disjunction);			
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
			
			
			articuloLocalDTOCol = criteria.list();
			
			return articuloLocalDTOCol;
			
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}		
	}
	@Override
	public Collection<GrupoTrabajoDTO> obtenerGruposTrabajo(GrupoTrabajoVO grupoTrabajoVO) throws SICException{
		Collection<GrupoTrabajoDTO> grupoTrabajoCol =  null;
		try{
			grupoTrabajoCol = baseDAO.findObjects(grupoTrabajoVO);
			if(grupoTrabajoVO.getContarGrupoAreaTrabajo()){
				contarPrototiposAlcance(grupoTrabajoCol,grupoTrabajoVO.getBaseDTO().getId().getCodigoCompania());
			}
		}catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al consultar grupos de trabajo {}", e);
			throw new SICException("Error al consultar grupos de trabajo", e);
		}
		return grupoTrabajoCol;		
	}
	
	/**
	 * Permite contar los grupos de trabajo
	 * @param grupoTrabajoCol
	 * @param codigoCompania
	 * @throws SICException
	 */
	private void contarPrototiposAlcance(Collection<GrupoTrabajoDTO> grupoTrabajoCol, Integer codigoCompania) throws SICException{
		try {
			if(CollectionUtils.isNotEmpty(grupoTrabajoCol)){
				
				this.sessionFactory.getCurrentSession().clear();
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(GrupoAreaTrabajoDTO.class,"grupoAreaTrabajo");
				criteria.createAlias("areaTrabajoDTO", "areaTrabajo");
				
				Map<Long, GrupoTrabajoDTO> detalleGrupoMap = new HashMap<Long, GrupoTrabajoDTO>();
				
				for(GrupoTrabajoDTO grupoTrabajoDto: grupoTrabajoCol){
					detalleGrupoMap.put(grupoTrabajoDto.getId().getCodigoGrupoTrabajo(), grupoTrabajoDto);
				}
				Collection<Long> codigoList = detalleGrupoMap.keySet();
				
				criteria.add(Restrictions.in("id.codigoGrupoTrabajo", codigoList));
				criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));			
				criteria.add(Restrictions.eq("estadoGrupoAreaTrabajo", SICConstantes.ESTADO_ACTIVO_LITERAL));			
				criteria.add(Restrictions.eq("areaTrabajo.tipoAreaTrabajoValor", CorporativoConstantes.TIPO_AREATRABAJO_LOCAL));
				criteria.add(Restrictions.eq("areaTrabajo.estadoAreaTrabajo",  CorporativoConstantes.ESTADO_ACTIVO));
				Projection projection = Projections.projectionList().add(Projections.groupProperty("id.codigoGrupoTrabajo"))
																	.add(Projections.rowCount());
				criteria.setProjection(projection);
				
				Collection<Object> conteoGruposTrabajo = criteria.list();
				
				for(Object obj : conteoGruposTrabajo){
					Object[] resultados = (Object[]) obj;
					Long codigo = (Long) resultados[0];
					Integer tamanio = (int) ((Long) resultados[1]).longValue();
					detalleGrupoMap.get(codigo).setNumeroLocales(tamanio);
				}			
			}
		}catch (HibernateException e) {
			throw new SICException(e);
		}catch (SICException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}

	public Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerArticuloAreaTrabajoBitacoraError(ArticuloVO articuloVO, String sufijoAreaTrabajo)throws SICException{		
		ArticuloAreaTrabajoBitacoraDTO artAreTraBit = new ArticuloAreaTrabajoBitacoraDTO();
		artAreTraBit.setTipoAreaTrabajo(sufijoAreaTrabajo);
		Collection<Object> entities = new ArrayList<Object>();
		entities.add(artAreTraBit);
		ShardNamingStrategy.SHARD_RESOLVER.set(entities);
		try {
			this.sessionFactory.getCurrentSession().clear();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(ArticuloAreaTrabajoBitacoraDTO.class,"areTraBit");
			criteria.createAlias("areaTrabajo", "areTra");
			
			criteria.add(Restrictions.eq("id.codigoCompania", articuloVO.getCodigoCompania()));
			criteria.add(Restrictions.eq("codigoTipoBitacora", SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_BITACORA));
			criteria.add(Restrictions.eq("tipoBitacoraValor", SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_BITACORA_ERROR));
			criteria.add(Restrictions.eq("fechaAlcance", articuloVO.getFechaAplicacion()));
			
			//criteria.add(Restrictions.eq("codigoArticulo", "9876543318115"));
			//criteria.add(Restrictions.eq("fechaAlcance", "2015-04-15 13:41:07.042744"));//articuloVO.getFechaAplicacion()));
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("codigoArticulo"),"codigoArticulo")
					.add(Projections.property("areTra.codigoReferencia"),"areaTrabajo.codigoReferencia")
					.add(Projections.property("areTra.nombreAreaTrabajo"),"areaTrabajo.nombreAreaTrabajo"));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloAreaTrabajoBitacoraDTO.class));
			
			return (Collection<ArticuloAreaTrabajoBitacoraDTO>)criteria.list();
		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}
	}
	
	/*
	 * Metodos que se utilizan en la base de datos no relacional orienDB
	 * */
	
	@Override
	public Collection<ArticuloLocalDTO> obtenerColArticuloLocalDTO(Integer codigoCompania, String sufijoTabla) throws SICException {
		
		Collection<ArticuloLocalDTO> colArticuloLocalDTO = Collections.emptyList();
		
		Criteria criteria = null;
		
		try {
			
			ArticuloLocalDTO articuloLocalDTO = new ArticuloLocalDTO();
//			articuloLocalDTO.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL);
			articuloLocalDTO.setTipoAreaTrabajo(sufijoTabla);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloLocalDTO);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
//			select this_.CODIGOLOCAL, COUNT(this_.CODIGOLOCAL) as TOTAL from SCSADTARTBOD this_ where (this_.CODIGOCOMPANIA=1) group by this_.CODIGOLOCAL order by TOTAL DESC;
			
			this.sessionFactory.getCurrentSession().clear();
			criteria = this.sessionFactory.getCurrentSession().createCriteria(ArticuloLocalDTO.class, "ARTLOC");
			
//			criteria.setProjection(Projections.projectionList().add(Projections.distinct(Projections.property("ARTLOC.id.codigoLocal"))));
			criteria.setProjection(Projections.projectionList()
					.add(Projections.count("ARTLOC.id.codigoLocal").as("npTotalRegistros"))
					.add(Projections.groupProperty("ARTLOC.id.codigoLocal").as("id.codigoLocal"))
			);
			
			Map<String, Object> mapAllEqSelect = new HashMap<String, Object>();
			mapAllEqSelect.put("ARTLOC.id.codigoCompania", codigoCompania);
			criteria.add(Restrictions.allEq(mapAllEqSelect));
			
			criteria.addOrder(Order.desc("npTotalRegistros"));
			
			criteria.setResultTransformer(new DtoResultTransformer(ArticuloLocalDTO.class));
			
			colArticuloLocalDTO = criteria.list();
			
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al ejecutar obtenerColCodigoArticuloLocal: {}", e.toString());
			throw new SICException(e);
		} finally {
			criteria = null;
		}
		
		return colArticuloLocalDTO;
	}
	
	@Override
	public Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerColArticuloAreaTrabajoBitacoraDTO(String sufijoTabla, Integer codigoCompania, Integer codigoLocal, String... colCodigoArticulo) throws SICException {
		
		Criteria criteria = null;
		
		try {
			
			ArticuloAreaTrabajoBitacoraDTO articuloAreaTrabajoBitacora = new ArticuloAreaTrabajoBitacoraDTO();
			articuloAreaTrabajoBitacora.setTipoAreaTrabajo(sufijoTabla);
			Collection<Object> entities = new ArrayList<Object>();
			entities.add(articuloAreaTrabajoBitacora);
			ShardNamingStrategy.SHARD_RESOLVER.set(entities);
			
			this.sessionFactory.getCurrentSession().clear();
			criteria = this.sessionFactory.getCurrentSession().createCriteria(ArticuloAreaTrabajoBitacoraDTO.class, "ARTBITTRA");
			
			criteria.add(Restrictions.eq("ARTBITTRA.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.in("ARTBITTRA.codigoArticulo", colCodigoArticulo));
//			criteria.setResultTransformer(new DtoResultTransformer(ArticuloAreaTrabajoBitacoraDTO.class));
			
			return criteria.list();
			
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al obtenerColArticuloAreaTrabajoBitacoraDTO: {}", e.toString());
			throw new SICException(e);
		} finally {
			criteria = null;
		}
		
	}
	
	@Override
	public Collection<AreaTrabajoDTO> consultarDatosAreaTrabajo(Integer codigoCompania, Integer... colCodigoAreaTrabajo) throws SICException {
		
		Criteria criteria = null;
		
		try {
			
			this.sessionFactory.getCurrentSession().clear();
			criteria = this.sessionFactory.getCurrentSession().createCriteria(AreaTrabajoDTO.class, "ART");
			
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("ART.id.codigoCompania"), "id.codigoCompania")
					.add(Projections.property("ART.id.codigoAreaTrabajo"), "id.codigoAreaTrabajo")
					.add(Projections.property("ART.codigoAreaTrabajoPadre"), "codigoAreaTrabajoPadre")
					.add(Projections.property("ART.codigoReferencia"), "codigoReferencia")
			);
			
			criteria.add(Restrictions.eq("ART.id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.in("ART.id.codigoAreaTrabajo", colCodigoAreaTrabajo));
			criteria.setResultTransformer(new DtoResultTransformer(AreaTrabajoDTO.class));
			
			return criteria.list();
			
		} catch (HibernateException e) {
			Logeable.LOG_SICV2.error("Ocurrio un error al consultarDatosAreaTrabajo: {}", e.toString());
			throw new SICException(e);
		} finally {
			criteria = null;
		}
		
	}
	
	@Override
	public Object[] searchLocalesInVistaPrototipoAlcanceLocal(Integer codigoCompania, String combinacionLocales) throws SICException {
		try {
			StringBuilder strQuery=new StringBuilder();
			strQuery.append("SELECT CODIGOGRUPOTRABAJO,AREASTRABAJO FROM SCSADVPROALCLOC")
			.append(" WHERE CODIGOCOMPANIA = :pCodCompania")
			.append(" AND AREASTRABAJO= :pCombiLocales");
			this.sessionFactory.getCurrentSession().clear();
			final Query sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(strQuery.toString());
			sqlQuery.setParameter("pCodCompania", codigoCompania);
			sqlQuery.setParameter("pCombiLocales", combinacionLocales);
    		List<Object[]> lis=sqlQuery.list();
			if (!CollectionUtils.isEmpty(lis)){
				return lis.get(0);
			}
		} catch (Exception e) {
			throw new SICException(e);
		}
		return new Object[0];
	}
	
	@Override
	public void updateGrupoAlcanceArticulo(Integer codigoCompania, Integer codigoGrupoAlcance, List<String> setCodArticulos,Timestamp fechaAplicacion,String userActualizacion) throws SICException {

		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append("UPDATE SCSPETARTICULO ")
			.append(" SET FECHAULTIMAACTUALIZACION = '").append(fechaAplicacion).append("',")
			.append(" USUARIOACTUALIZACION = '").append(userActualizacion).append("',")
			.append(" CODIGOGRUPOALCANCE = ").append(codigoGrupoAlcance)
			.append(" WHERE CODIGOCOMPANIA = ").append(codigoCompania)
			.append(" AND CODIGOARTICULO IN :pLisCodArt");
			
			sqlQuery = session.createSQLQuery(query.toString());
			
			sqlQuery.setParameterList("pLisCodArt", setCodArticulos);
			sqlQuery.executeUpdate();
			session.flush();

		} catch (HibernateException e) {
			throw new SICException(e);
		}catch (Exception e) {
			throw new SICException(e);
		}

		
	}

	@Override
	public Set<String> getArticulosPruebaAlcance() throws SICException {
		Set<String> setArt=new HashSet<String>();
		try {
			StringBuilder strQuery=new StringBuilder();
			strQuery.append("SELECT CODIGOARTICULO FROM SCSPETARTICULO where codigoclasificacion=1000");
			this.sessionFactory.getCurrentSession().clear();
			final Query sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(strQuery.toString());
    		List lis=sqlQuery.list();
    		setArt=new HashSet<String>(lis);
    		    		
		} catch (Exception e) {
			throw new SICException(e);
		}
		return setArt;
	}

	@Override
	public Map<String, Integer> getMapVistaPrototipoAlcance(Integer codigoCompania) throws SICException {
		Map<String, Integer> mapRes=new HashMap<>();
		try {
			StringBuilder strQuery=new StringBuilder();
			strQuery.append("SELECT CODIGOGRUPOTRABAJO,AREASTRABAJO FROM SCSADVPROALCLOC")
			.append(" WHERE CODIGOCOMPANIA = :pCodCompania");
			this.sessionFactory.getCurrentSession().clear();
			final Query sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(strQuery.toString());
			sqlQuery.setParameter("pCodCompania", codigoCompania);
    		List<Object[]> lis=sqlQuery.list();
    		
    		for (Object[] obj:lis){
    			mapRes.put(String.valueOf(obj[1]), Integer.parseInt(String.valueOf(obj[0])));
    		}
    		
		} catch (Exception e) {
			throw new SICException(e);
		}
		return mapRes;	
	}

	@Override
	public Map<Integer, Integer> getMapLocalEstablecimiento(Integer codigoCompania) throws SICException {
		Map<Integer, Integer> mapLocEst=new HashMap<>(); // clave:codigoAreaTrabajo; valor:codigoEstablecimiento
		try{
			StringBuilder strQuery=new StringBuilder();
			strQuery.append("SELECT ATR.CODIGOAREATRABAJO,ATR.CODIGOESTABLECIMIENTO") 
			.append(" FROM SSPCOTAREATRABAJO ATR") 
			.append(" INNER JOIN SSPCOTESTABLECIMIENTO EST ON EST.CODIGOESTABLECIMIENTO=ATR.CODIGOESTABLECIMIENTO")
			.append(" WHERE ATR.TIPOAREATRABAJOVALOR = '").append(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_LOCAL).append("'")
			.append(" ORDER BY CODIGOAREATRABAJO");
			this.sessionFactory.getCurrentSession().clear();
			final Query sqlQuery=this.sessionFactory.getCurrentSession().createSQLQuery(strQuery.toString());
			List<Object[]> lis=sqlQuery.list();
			for (Object[] obj:lis){
				mapLocEst.put(Integer.parseInt(String.valueOf(obj[0])), Integer.parseInt(String.valueOf(obj[1])));
			}
		} catch (Exception e) {
			throw new SICException(e);
		}
		return mapLocEst;
	}
	
	//---------------------------------------------------------------------------------------------------------------------------
	// FIN DE METODOS DE PRIVADOS
	//---------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Setters
	 */
	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	public void setHibernateH(HibernateH<SearchDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}