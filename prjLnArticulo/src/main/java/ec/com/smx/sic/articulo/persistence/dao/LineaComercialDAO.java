package ec.com.smx.sic.articulo.persistence.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanToPropertyValueTransformer;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.IHibernateH;
import ec.com.kruger.utilitario.dao.commons.hibernate.criterion.Subqueries;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.DtoResultTransformer;
import ec.com.kruger.utilitario.dao.commons.hibernate.transformers.MultiLevelResultTransformer;
import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.EstablecimientosConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.ProcesoPerfilDTO;
import ec.com.smx.corpv2.dto.VistaAreaTrabajoPerfilDTO;
import ec.com.smx.corpv2.dto.id.AreaTrabajoID;
import ec.com.smx.frameworkv2.util.constants.FrameworkConstants;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.ClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.vo.LineaComercialVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.ILineaComercialDAO;

/**
 * 
 * @author fcollaguazo
 * @author jdvasquez
 */
public class LineaComercialDAO implements ILineaComercialDAO {
	
	private IHibernateH<SearchDTO> hibernateH;
	private IHibernateH<LineaComercialClasificacionDTO> hibernateHLineaComercialClasificacion;
	private SessionFactory sessionFactory;
	
	/**
	 * Inactivar las sublineas comerciales que pertenecen a un padre
	 * @param grupoTrabajoDTO
	 * @param areaAsignar
	 */
	@Override
	public void eliminarSubLineasComerciales(String userId, Long codigoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Entr� a inactivar sublineas comerciales del padre: {}",codigoLineaComercial);
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOM ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOLINEACOMERCIALPADRE = " + codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar las sublineas comerciales {}", e);
			throw new SICException("Error al inactivar las sublineas comerciales {}", e);
		}
	}
	
	/**
	 * Inactivar la clasificacion de las sublineas comerciales
	 * @param lineaComercialPadre
	 * @param codigoClasificacion
	 * @throws SICException
	 */
	@Override
	public void eliminarClasificacionSubLineasComerciales(String userId, LineaComercialDTO lineaComercialPadre, String codigoClasificacion)throws SICException{
		Logeable.LOG_SICV2.info("Inactivar la clasificacion de las sublineas comerciales: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			String codigosLineaComercial = "";			
			//Obtenemos los codigos de las sublineas
			for(LineaComercialDTO subLineaComercialDTO:lineaComercialPadre.getSubLineaComercialCol()){
				codigosLineaComercial=codigosLineaComercial + subLineaComercialDTO.getId().getCodigoLineaComercial()+"," ;
			}
			codigosLineaComercial = codigosLineaComercial.substring(0, codigosLineaComercial.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosLineaComercial);
			
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMCLA ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOCLASIFICACION = '" + codigoClasificacion + "'");
			query.append(" AND CODIGOLINEACOMERCIAL IN(" + codigosLineaComercial + ")" );

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
			//remover las relaciones lineacomercial, funcionario, clasificacion
			removerLineaComercialFuncionarioClasificacion(codigosLineaComercial, Arrays.asList(codigoClasificacion));
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar la clasificacion de las sublineas comerciales {}", e);
			throw new SICException("Error al inactivar la clasificacion de las sublineas comerciales {}", e);
		}
	}
	
	/**
	 * Inactiva la clasificacion de la linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @param codigoClasificacion
	 * @throws SICException
	 */
	public void eliminarClasificacionLineaComercial(String userId, Long codigoLineaComercial, String codigoClasificacion)throws SICException{
		Logeable.LOG_SICV2.info("Inactivar la clasificacion de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMCLA ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOCLASIFICACION = '" + codigoClasificacion + "'");
			query.append(" AND CODIGOLINEACOMERCIAL = " + codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

			//remover las relaciones lineacomercial, funcionario, clasificacion
			removerLineaComercialFuncionarioClasificacion(codigoLineaComercial.toString(), Arrays.asList(codigoClasificacion));
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar la clasificacion de las sublineas comerciales {}", e);
			throw new SICException("Error al inactivar la clasificacion de las sublineas comerciales {}", e);
		}
	}
	
	/**
	 * Elimina las clasificaciones de las sublineas comerciales
	 * @param subLineas
	 */
	@Override
	public void eliminarClasificacionesSubLineasComerciales(String userId, Collection<LineaComercialDTO> subLineas)throws SICException{
		Logeable.LOG_SICV2.info("Inactivar las clasificaciones de las sublineas comerciales: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			String codigosLineaComercial = "";
			
			//Obtenemos los codigos de las sublineas
			for(LineaComercialDTO subLineaComercialDTO:subLineas){
				codigosLineaComercial=codigosLineaComercial + subLineaComercialDTO.getId().getCodigoLineaComercial()+"," ;
			}
			codigosLineaComercial = codigosLineaComercial.substring(0, codigosLineaComercial.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosLineaComercial);
			
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMCLA ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOLINEACOMERCIAL IN(" + codigosLineaComercial + ")" );

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar las clasificaciones de las sublineas comerciales {}", e);
			throw new SICException("Error al inactivar las clasificaciones de las sublineas comerciales {}", e);
		}
	}

	
	/**
	 * Inactivar las clasificaciones de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	@Override
	public void eliminarClasificacionesLineaComercial(String userId, Long codigoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Inactivar las clasificaciones de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMCLA ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOLINEACOMERCIAL = " + codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar las clasificaciones de la linea comercial {}", e);
			throw new SICException("Error al inactivar las clasificaciones de la linea comercial {}", e);
		}
	}
	
	/**
	 * Inactivar la linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	@Override
	public void eliminarLineaComercial(String userId, Long codigoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Inactivar la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOM ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOLINEACOMERCIAL = " + codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar la linea comercial {}", e);
			throw new SICException("Error al inactivar la linea comercial {}", e);
		}
	}
	
	/**
	 * Inactivar el funcionario asignado a la linea comercial
	 * @param lineaComercialFuncionarioDTO
	 * @throws SICException
	 */
	@Override
	public void eliminarFuncionarioLineaComercial(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)throws SICException{
		String userId = lineaComercialFuncionarioDTO.getUserId();
		
		Logeable.LOG_SICV2.info("Inactivar el funcionario de la linea comercial");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMFUN ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODLINCOMFUN = " + lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario());

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

			//Eliminar las marcar del funcionario de la linea comercial
			eliminarFuncionarioTipoMarcas(userId, lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario());
			
			//Eliminar las relaciones, linea comercial, clasificacion, funcionario
			removerLineaComercialFuncionarioClasificacion(lineaComercialFuncionarioDTO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar el funcionario de la linea comercial {}", e);
			throw new SICException("Error al inactivar el funcionario de la linea comercial {}", e);
		}
	}
	
	/**
	 * Inactivar los tipos de marca del funcionario de la linea comercial
	 * @param codigoLineaComercialFuncionario
	 */
	private void eliminarFuncionarioTipoMarcas(String userId, Long codigoLineaComercialFuncionario){
		Logeable.LOG_SICV2.info("Inactivar las marcas del funcionario: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMFUNTIPMAR ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODLINCOMFUN = " + codigoLineaComercialFuncionario);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar las marcas del funcionario de la linea comercial {}", e);
			throw new SICException("Error al inactivar las marcas del funcionario de la linea comercial {}", e);
		}
	}
	
	/**
	 * Activa las clasificaciones de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @param lineaComercialClasificacionCol
	 * @param estado
	 * @throws SICException
	 */
	public void activarInactivarClasificacionesLineaComercial(String userId, Long codigoLineaComercial,Long codigoLineaComercialCambio, Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol, String estado)throws SICException{
		Logeable.LOG_SICV2.info("Activa o inactiva las clasificaciones de una linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			String codigosClasificaciones = "";
			List<String> codigosList = new ArrayList<String>();			
			//Obtenemos los codigos de las clasificaciones
			for(LineaComercialClasificacionDTO lineaComercialClasificacionDTO:lineaComercialClasificacionCol){
				codigosList.add(lineaComercialClasificacionDTO.getId().getCodigoClasificacion());
				codigosClasificaciones = codigosClasificaciones + "'" + lineaComercialClasificacionDTO.getId().getCodigoClasificacion()+"'," ;
			}
			codigosClasificaciones = codigosClasificaciones.substring(0, codigosClasificaciones.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosClasificaciones);
			
			// se remueve las relaciones entre clasificacion, funcionario y la linea comercial a la que se esta reasignando
			removerLineaComercialFuncionarioClasificacion(codigoLineaComercial.toString(), codigosList);		
			
			Session session = hibernateH.getHibernateSession();
			session.clear();

				query = new StringBuilder();
										
				query.append("UPDATE SCADMTLINCOMCLA ");
			if(codigoLineaComercialCambio==null){
				query.append(" SET ESTADO = '"+estado+"' ");
			}else{
				query.append(" SET CODIGOLINEACOMERCIAL = '"+codigoLineaComercialCambio+"' ");		
			}
				query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
				query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
				query.append(" WHERE CODIGOCLASIFICACION IN(" + codigosClasificaciones +") ");
				query.append(" AND CODIGOLINEACOMERCIAL = '"+codigoLineaComercial+"'");
				
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
			//se agrega las relaciones entre clasificacion
			agregarLineaComercialFuncionarioClasificacion(codigoLineaComercialCambio, userId, codigosList);
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activar las clasificaciones de la linea comercial {}", e);
			throw new SICException("Error al activar las clasificaciones de la linea comercial {}", e);
		}
	}


	
	
	/**
	 * Activa las clasificaciones de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	public void activarClasificacionesLineaComercial(String userId, Long codigoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Activa las clasificaciones de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMCLA ");
			query.append(" SET ESTADO = '1' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOLINEACOMERCIAL = " + codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activar las clasificaciones de la linea comercial {}", e);
			throw new SICException("Error al activar las clasificaciones de la linea comercial {}", e);
		}
	}
	
	
	/**
	 * Activa los funcionarios de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	public void activarFuncionariosLineaComercial(String userId, Long codigoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Activa los funcionarios de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMFUN ");
			query.append(" SET ESTADO = '1' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOLINEACOMERCIAL = " + codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

			//Activa las marcas de los funcionarios de la linea comercial
			activarDesactivaFuncionariosTipoMarca(userId, codigoLineaComercial, SICConstantes.ESTADO_ACTIVO_NUMERICO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activar las clasificaciones de la linea comercial {}", e);
			throw new SICException("Error al activar las clasificaciones de la linea comercial {}", e);
		}
	}
	
	/**
	 * Activa o desactiva las marcas de los funcionarios de una linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 */
	public void activarDesactivaFuncionariosTipoMarca(String userId, Long codigoLineaComercial, String estado){
		Logeable.LOG_SICV2.info("Activa o desactiva las marcas de los funcionarios de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			String estadoWhere = estado.equals(SICConstantes.ESTADO_ACTIVO_NUMERICO) ? SICConstantes.ESTADO_INACTIVO_NUMERICO : SICConstantes.ESTADO_ACTIVO_NUMERICO;
			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMFUNTIPMAR ");
			query.append(" SET ESTADO = '"+estado+"' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE ESTADO = '"+ estadoWhere +"' ");
			query.append(" AND CODLINCOMFUN IN (SELECT CODLINCOMFUN FROM SCADMTLINCOMFUN WHERE CODIGOLINEACOMERCIAL = "+codigoLineaComercial+")");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activar o desactivar las marcas de los funcionarios de la linea comercial {}", e);
			throw new SICException("Error al activar o desactivar las marcas de los funcionarios de la linea comercial {}", e);
		}
	}
	
	
	/**
	 * Elimina los funcionarios de las sublineas comerciales
	 * @param subLineas
	 */
	@Override
	public void eliminarFuncionariosSubLineasComerciales(String userId, Collection<LineaComercialDTO> subLineas)throws SICException{
		Logeable.LOG_SICV2.info("Inactivar los funcionarios de las sublineas comerciales: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			String codigosLineaComercial = "";
			
			//Obtenemos los codigos de las sublineas
			for(LineaComercialDTO subLineaComercialDTO:subLineas){
				codigosLineaComercial=codigosLineaComercial + subLineaComercialDTO.getId().getCodigoLineaComercial()+"," ;
			}
			codigosLineaComercial = codigosLineaComercial.substring(0, codigosLineaComercial.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosLineaComercial);
			
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMFUN ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOLINEACOMERCIAL IN(" + codigosLineaComercial + ")" );

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

			//Eliminar las marcas de los funcionarios de las sublineas comerciales
			eliminarMarcasFuncionariosSubLineasComerciales(userId, codigosLineaComercial);
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar los funcionarios de las sublineas comerciales {}", e);
			throw new SICException("Error al inactivar los funcionarios de las sublineas comerciales {}", e);
		}
	}
	
	/**
	 * Elimina los funcionarios de las sublineas comerciales
	 * @param subLineas
	 */
	public void eliminarMarcasFuncionariosSubLineasComerciales(String userId, String codigosLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Inactivar los marcas de los funcionarios de las sublineas comerciales: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMFUNTIPMAR ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODLINCOMFUN IN (SELECT CODLINCOMFUN FROM SCADMTLINCOMFUN WHERE CODIGOLINEACOMERCIAL IN(" + codigosLineaComercial + "))" );

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar las marcas de los funcionarios de las sublineas comerciales {}", e);
			throw new SICException("Error al inactivar las marcas de los funcionarios de las sublineas comerciales {}", e);
		}
	}
	
	/**
	 * Inactiva los funcionario de la linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 */
	public void eliminarFuncionariosLineaComercial(String userId, Long codigoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Inactivar los funcionario de linea comerciales: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMFUN ");
			query.append(" SET ESTADO = '0' ");
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" WHERE CODIGOLINEACOMERCIAL = " + codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

			//Inactivar las marcas de los funcionarios de la linea comercial
			activarDesactivaFuncionariosTipoMarca(userId, codigoLineaComercial, SICConstantes.ESTADO_INACTIVO_NUMERICO);
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al inactivar los funcionarios de la linea comercial {}", e);
			throw new SICException("Error al inactivar los funcionarios de la linea comercial {}", e);
		}
	}
	
	/**
	 * Actualiza el establecimiento de las sublineas comerciales
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	public void actualizarEstablecimientoSubLineasComerciales(String userId, Long codigoLineaComercial, Integer codigoEstablecimiento,String valorTipoLineaComercial, Integer codigoTipoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Actualizar el establecimiento de las lineas comerciales: {}");
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOM ");
			query.append(" SET CODIGOESTABLECIMIENTO = "+codigoEstablecimiento);
			query.append(" ,IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" ,FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" ,VALORTIPOLINEACOMERCIAL = '"+valorTipoLineaComercial+"' ");
			query.append(" ,CODIGOTIPOLINEACOMERCIAL = "+codigoTipoLineaComercial);
			query.append(" WHERE CODIGOLINEACOMERCIALPADRE = " + codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al actualizar el establecimiento de las sublineas comerciales {}", e);
			throw new SICException("Error al actualizar el establecimiento de las sublineas comerciales {}", e);
		}
	}
	
	/**
	 * @return the hibernateH
	 */
	public IHibernateH<SearchDTO> getHibernateH() {
		return hibernateH;
	}

	/**
	 * @param hibernateH the hibernateH to set
	 */
	public void setHibernateH(IHibernateH<SearchDTO> hibernateH) {
		this.hibernateH = hibernateH;
	}
	

	/**
	 * @param hibernateHLineaComercialClasificacion
	 */
	@Override
	public void setHibernateHLineaComercialClasificacion(IHibernateH<LineaComercialClasificacionDTO> hibernateHLineaComercialClasificacion) {
		this.hibernateHLineaComercialClasificacion = hibernateHLineaComercialClasificacion;
	}
	@Override
	public IHibernateH<LineaComercialClasificacionDTO> getHibernateHLineaComercialClasificacion() {
		return hibernateHLineaComercialClasificacion;
	}

	
	

	/**
	 * Activar las Clasificaciones de las Divisiones
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	@Override
	public void activarClasificacionesDivision(String userId, Long codigoLineaComercial, Collection<ClasificacionDTO> clasificacionCol) throws SICException {
		Logeable.LOG_SICV2.info("Activa las clasificaciones de las divisiones de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		try {
			String codigosClasificaciones = "";
			
			//Obtenemos los codigos de las clasificaciones
			for(ClasificacionDTO clasificacionDTO:clasificacionCol){
				codigosClasificaciones = codigosClasificaciones + "'" + clasificacionDTO.getId().getCodigoClasificacion()+"'," ;
			}
			codigosClasificaciones = codigosClasificaciones.substring(0, codigosClasificaciones.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosClasificaciones);
		
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMCLA ");
			query.append("SET ESTADO = '1' ");
			query.append("WHERE CODIGOCLASIFICACION");
			query.append(" IN (SELECT CODIGOCLASIFICACION FROM  SCSPETCLASIFICACION C WHERE CODIGOCLASIFICACIONPADRE");
			query.append(" IN(SELECT CODIGOCLASIFICACION FROM SCSPETCLASIFICACION");
			query.append(" WHERE CODIGOCLASIFICACIONPADRE IN(SELECT CODIGOCLASIFICACION FROM SCSPETCLASIFICACION WHERE CODIGOCLASIFICACION IN(" + codigosClasificaciones +")");
			query.append(" AND ESTADOCLASIFICACION='1')");
			query.append(" AND ESTADOCLASIFICACION='1')");
			query.append(" AND C.CODIGOCLASIFICACION");
			query.append(" IN(SELECT CODIGOCLASIFICACION FROM SCADMTLINCOMCLA WHERE CODIGOLINEACOMERCIAL='"+codigoLineaComercial+"' AND ESTADO ='0'))");
			query.append("AND CODIGOLINEACOMERCIAL ="+codigoLineaComercial);

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
			//Asignar Clasificaciones de la linea comercial
			asignarClasificacionesDivisones(userId, codigoLineaComercial, clasificacionCol);
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activar las clasificaciones de las divisiones {}", e);
			throw new SICException("Error al activar las clasificaciones de las divisiones {}", e);
		}
		
	}
	/**
	 * Asignar clasificaciones de las Divisiones
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	public void asignarClasificacionesDivisones(String userId, Long codigoLineaComercial, Collection<ClasificacionDTO> clasificacionCol)throws SICException{
		Logeable.LOG_SICV2.info("Asignar clasificaciones de las Divisiones: {}");
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			String codigosClasificaciones = "";
			
			//Obtenemos los codigos de las clasificaciones
			for(ClasificacionDTO clasificacionDTO:clasificacionCol){
				codigosClasificaciones = codigosClasificaciones + "'" + clasificacionDTO.getId().getCodigoClasificacion()+"'," ;
			}
			codigosClasificaciones = codigosClasificaciones.substring(0, codigosClasificaciones.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosClasificaciones);
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("INSERT INTO SCADMTLINCOMCLA  ");
			query.append(" (CODIGOCLASIFICACION, CODIGOCOMPANIA, CODIGOLINEACOMERCIAL, ESTADO, IDUSUARIOREGISTRO, FECHAREGISTRO)");
			query.append("  SELECT CODIGOCLASIFICACION, CODIGOCOMPANIA, '"+codigoLineaComercial+"', 1, '"+userId+"', CURRENT_TIMESTAMP");
			query.append(" FROM SCSPETCLASIFICACION C");
			query.append(" WHERE CODIGOCLASIFICACIONPADRE");
			query.append(" IN (SELECT CODIGOCLASIFICACION");
			query.append(" FROM SCSPETCLASIFICACION ");
			query.append(" WHERE CODIGOCLASIFICACIONPADRE");
			query.append(" IN( SELECT CODIGOCLASIFICACION");
			query.append(" FROM SCSPETCLASIFICACION");
			query.append(" WHERE CODIGOCLASIFICACION");
			query.append(" IN("+ codigosClasificaciones +")");
			query.append(" AND ESTADOCLASIFICACION=1)");
			query.append(" AND ESTADOCLASIFICACION=1)");
			query.append(" AND ESTADOCLASIFICACION=1 AND C.CODIGOCLASIFICACION");
			query.append(" NOT IN(SELECT CODIGOCLASIFICACION FROM SCADMTLINCOMCLA");
			query.append("  WHERE CODIGOLINEACOMERCIAL='"+codigoLineaComercial+"' AND ESTADO ='1')");
//			Logeable.LOG_SICV2.info("Codigos: {}",query);
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al ingresar  clasificaciones de las divisiones {}", e);
			throw new SICException("Error al ingresar  clasificaciones de las divisiones {}", e);
		}
	}
	/**
	 * Activa las Clasificaciones de los Departamentos
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	@Override
	public void activarClasificacionesDepartamento(String userId, Long codigoLineaComercial, Collection<ClasificacionDTO> clasificacionCol) throws SICException {
		Logeable.LOG_SICV2.info("Activar las clasificaciones de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		try {
			String codigosClasificaciones = "";
			
			//Obtenemos los codigos de las clasificaciones
			for(ClasificacionDTO clasificacionDTO:clasificacionCol){
				codigosClasificaciones = codigosClasificaciones + "'" + clasificacionDTO.getId().getCodigoClasificacion()+"'," ;
			}
			codigosClasificaciones = codigosClasificaciones.substring(0, codigosClasificaciones.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosClasificaciones);
		
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMCLA ");
			query.append("SET ESTADO = '1' ");
			query.append("WHERE CODIGOCLASIFICACION");
			query.append(" IN (SELECT CODIGOCLASIFICACION FROM  SCSPETCLASIFICACION C WHERE ESTADOCLASIFICACION='1'");
			query.append("AND CODIGOCLASIFICACIONPADRE");
			query.append(" IN(SELECT CODIGOCLASIFICACION FROM SCSPETCLASIFICACION");
			query.append(" WHERE CODIGOCLASIFICACION IN(" + codigosClasificaciones +")");
			query.append("AND ESTADOCLASIFICACION='1')");
			query.append("AND C.CODIGOCLASIFICACION");
			query.append(" IN(SELECT CODIGOCLASIFICACION FROM SCADMTLINCOMCLA WHERE CODIGOLINEACOMERCIAL='"+codigoLineaComercial+"' AND ESTADO ='0'))");
			query.append("AND CODIGOLINEACOMERCIAL ="+codigoLineaComercial);
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
			//Asignar Clasificaciones de la linea comercial
			asignarClasificacionesDepartamento(userId, codigoLineaComercial, clasificacionCol);
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activar las clasificaciones de la linea comercial {}", e);
			throw new SICException("Error al activar las clasificaciones de la linea comercial {}", e);
		}		
	}
	/**
	 * Asiganar clasificaciones de los departamentos
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	public void asignarClasificacionesDepartamento(String userId, Long codigoLineaComercial, Collection<ClasificacionDTO> clasificacionCol)throws SICException{
		Logeable.LOG_SICV2.info("Asignar clasificaciones de los departamentos: {}");
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			String codigosClasificaciones = "";
			
			//Obtenemos los codigos de las clasificaciones
			for(ClasificacionDTO clasificacionDTO:clasificacionCol){
				codigosClasificaciones = codigosClasificaciones + "'" + clasificacionDTO.getId().getCodigoClasificacion()+"'," ;
			}
			codigosClasificaciones = codigosClasificaciones.substring(0, codigosClasificaciones.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosClasificaciones);
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("INSERT INTO SCADMTLINCOMCLA  ");
			query.append(" (CODIGOCLASIFICACION, CODIGOCOMPANIA, CODIGOLINEACOMERCIAL, ESTADO, IDUSUARIOREGISTRO, FECHAREGISTRO) ");
			query.append(" SELECT CODIGOCLASIFICACION, CODIGOCOMPANIA, '"+codigoLineaComercial+"', 1,'"+userId+"', CURRENT_TIMESTAMP");
			query.append("  FROM  SCSPETCLASIFICACION C ");
			query.append(" WHERE ESTADOCLASIFICACION='1' AND CODIGOCLASIFICACIONPADRE");
			query.append("  IN(SELECT CODIGOCLASIFICACION FROM SCSPETCLASIFICACION");
			query.append("  WHERE CODIGOCLASIFICACION IN(" + codigosClasificaciones +")");
			query.append("  AND ESTADOCLASIFICACION='1')");
			query.append("  AND C.CODIGOCLASIFICACION");
			query.append("  NOT IN(SELECT CODIGOCLASIFICACION");
			query.append("  FROM SCADMTLINCOMCLA");
			query.append("  WHERE CODIGOLINEACOMERCIAL='"+codigoLineaComercial+"' AND ESTADO ='1')");

			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al ingresar  clasificaciones de los departamentos {}", e);
			throw new SICException("Error al ingresar  clasificaciones de los departamentos {}", e);
		}
	}
	/**
	 * Activa las clasificaciones
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	
	@Override
	public  void activarClasificaciones(String userId, Long codigoLineaComercial, Collection<String> clasificacionCol)throws SICException{
		Logeable.LOG_SICV2.info("Activa las clasificaciones de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
			String codigosClasificaciones = "";
			
			//Obtenemos los codigos de las clasificaciones
//			for(String cl: clasificacionCol ){
//				codigosClasificaciones = codigosClasificaciones + "'" + cl+"'," ;
//			}
//			codigosClasificaciones = codigosClasificaciones.substring(0, codigosClasificaciones.length()-1);
			codigosClasificaciones=StringUtils.join(clasificacionCol,"','");
			codigosClasificaciones="'"+codigosClasificaciones+"'";
			
			
			Logeable.LOG_SICV2.info("Codigos: {}",codigosClasificaciones);
			
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE SCADMTLINCOMCLA ");
			query.append(" SET IDUSUARIOMODIFICACION = '"+userId+"' ");
			query.append(" , FECHAMODIFICACION = CURRENT_TIMESTAMP ");
			query.append(" , ESTADO = '1' ");
			query.append(" WHERE CODIGOCLASIFICACION ");
			query.append(" IN (SELECT CODIGOCLASIFICACION");
			query.append(" FROM SCSPETCLASIFICACION");
			query.append(" WHERE CODIGOCLASIFICACION");
			query.append(" IN(" + codigosClasificaciones +")");
			query.append(" AND ESTADOCLASIFICACION=1");
			query.append(" AND CODIGOCLASIFICACION");
			query.append(" IN(SELECT CODIGOCLASIFICACION");
			query.append(" FROM SCADMTLINCOMCLA");
			query.append(" WHERE CODIGOLINEACOMERCIAL='"+codigoLineaComercial+"' AND ESTADO ='0'))");
			query.append(" AND CODIGOLINEACOMERCIAL ="+codigoLineaComercial);
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			//Asignar Clasificaciones de la linea comercial
			asignarClasificaciones(userId, codigoLineaComercial, codigosClasificaciones);
			
			agregarLineaComercialFuncionarioClasificacion(codigoLineaComercial, userId, clasificacionCol);
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activar las clasificaciones de la linea comercial {}", e);
			throw new SICException("Error al activar las clasificaciones de la linea comercial {}", e);
		}
	}
	/**
	 * Asignar Clasificaciones a linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	private void asignarClasificaciones(String userId, Long codigoLineaComercial, String codigosClasificaciones)throws SICException{
		Logeable.LOG_SICV2.info("Asignar clasificaciones de los departamentos: {}");
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
//			String codigosClasificaciones = "";
//			
//			//Obtenemos los codigos de las clasificaciones
//			for(String cl: clasificacionCol ){
//				codigosClasificaciones = codigosClasificaciones + "'" + cl+"'," ;
//			}
//			codigosClasificaciones = codigosClasificaciones.substring(0, codigosClasificaciones.length()-1);
			Logeable.LOG_SICV2.info("Codigos: {}",codigosClasificaciones);
			Session session = hibernateH.getHibernateSession();
			session.clear();
// 
			query = new StringBuilder();
			query.append("INSERT INTO SCADMTLINCOMCLA  ");
			query.append(" (CODLINCOMCLA,CODIGOCLASIFICACION, CODIGOCOMPANIA, CODIGOLINEACOMERCIAL,");
			query.append(" ESTADO, IDUSUARIOREGISTRO, FECHAREGISTRO)");
			query.append(" SELECT NEXT VALUE FOR SCADMSECLINCOMCLA, CODIGOCLASIFICACION, CODIGOCOMPANIA, '"+codigoLineaComercial+"', ");
			query.append(" 1, '"+userId+"', CURRENT_TIMESTAMP");
			query.append("  FROM  SCSPETCLASIFICACION");
			query.append(" WHERE CODIGOCLASIFICACION");
			query.append(" IN(SELECT CODIGOCLASIFICACION ");
			query.append(" FROM SCSPETCLASIFICACION");
			query.append(" WHERE CODIGOCLASIFICACION IN(" + codigosClasificaciones +") ");
			query.append(" AND ESTADOCLASIFICACION=1");
			query.append(" )AND CODIGOCLASIFICACION");
			query.append(" NOT IN(SELECT CODIGOCLASIFICACION");
			query.append(" FROM SCADMTLINCOMCLA");
			query.append(" WHERE CODIGOLINEACOMERCIAL="+codigoLineaComercial+")");
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al ingresar  clasificaciones en la liena comercial {}", e);
			throw new SICException("Error al ingresar  clasificaciones en la liena comercial {}", e);
		}
	}
	
	/**
	 * Activa las clasificaciones asignadas a un funcionario en caso de que se encuentren desactivadas
	 * @param userId
	 * @param codigoLineaComercial
	 * @param clasificacionCol
	 * @throws SICException
	 */
	@Override
	public void activarClasificacionesFuncionario(String userId, Long codigoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Activa las clasificaciones del funcionario de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;
		
		try {
					
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("UPDATE scspetclausu ");
			query.append(" SET    idusuariomodificacion = '"+userId+"' ");
			query.append(" , fechamodificacion = CURRENT_TIMESTAMP ");
			query.append(" , estadoclausu = '1' ");
			query.append(" WHERE codigoclasificacion IN (SELECT codigoclasificacion ");
			query.append(" FROM   scspetclasificacion ");
			query.append(" WHERE  estadoclasificacion = '1'");
			query.append(" AND codigoclasificacion IN");
			query.append(" (SELECT LCC.codigoclasificacion");
			query.append(" FROM   scadmtlincom LC");
			query.append(" INNER JOIN scadmtlincomfun LCF");
			query.append(" ON LC.codigolineacomercial =  LCF.codigolineacomercial");
			query.append(" INNER JOIN scadmtlincomcla LCC");
			query.append(" ON LC.codigolineacomercial =  LCC.codigolineacomercial");
			query.append(" INNER JOIN sspcotfuncionario F");
			query.append(" ON F.codigofuncionario =  LCF.codigofuncionario");
			query.append(" INNER JOIN kssegtuser U");
			query.append(" ON U.userid =");
			query.append(" F.usuariofuncionario");
			query.append(" WHERE  LC.estado = '1' AND LCF.estado = '1' AND LCC.estado = '1'");
			query.append(" AND LC.codigolineacomercial =  "+codigoLineaComercial);
			query.append(" AND LCC.codigoclasificacion IN");
			query.append(" (SELECT  codigoclasificacion ");
			query.append(" FROM  scspetclausu ");
			query.append(" WHERE  userid = U.userid ");
			query.append(" AND estadoclausu = '0')))");
			query.append(" AND userid IN (SELECT U.userid ");
			query.append(" FROM   scadmtlincom LC");
			query.append(" INNER JOIN scadmtlincomfun LCF");
			query.append("  ON LC.codigolineacomercial = LCF.codigolineacomercial");
			query.append("  INNER JOIN scadmtlincomcla LCC");
			query.append("  ON LC.codigolineacomercial = LCC.codigolineacomercial");
			query.append("  INNER JOIN sspcotfuncionario F");
			query.append("  ON F.codigofuncionario =  LCF.codigofuncionario");
			query.append("  INNER JOIN kssegtuser U");
			query.append("  ON U.userid = F.usuariofuncionario");
			query.append("  WHERE  LC.estado = '1' AND LCF.estado = '1' AND LCC.estado = '1' ");
			query.append(" AND LC.codigolineacomercial =  "+codigoLineaComercial);
			query.append(" AND LCC.codigoclasificacion IN");
			query.append(" (SELECT  codigoclasificacion ");
			query.append(" FROM  scspetclausu ");
			query.append(" WHERE  userid = U.userid ");
			query.append(" AND estadoclausu = '0'))");
			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
			//Asignar Clasificaciones al funcionario
			asignarClasificacionesFuncionario(userId, codigoLineaComercial);
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al activar las clasificaciones del funcionario de la linea comercial {}", e);
			throw new SICException("Error al activar las clasificaciones del funcionario de la linea comercial {}", e);
		}
	}
	/**
	 * Asigna las clasificaciones a todos los funcionarios de la linea comercial
	 * @param userId
	 * @param codigoLineaComercial
	 * @throws SICException
	 */
	private void asignarClasificacionesFuncionario(String userId, Long codigoLineaComercial)throws SICException{
		Logeable.LOG_SICV2.info("Asignar clasificaciones a funcionario de la linea comercial: {}");
		StringBuilder query = null;
		Query sqlQuery = null;

		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();

			query = new StringBuilder();
			query.append("INSERT INTO scspetclausu (CODIGOCOMPANIA,CODIGOCLASIFICACION,USERID,ESTADOCLAUSU,IDUSUARIOREGISTRO,FECHAREGISTRO)");
			query.append(" SELECT");
			query.append(" '1' CODIGOCOMPANIA,");
			query.append(" LCC.codigoclasificacion,");
			query.append(" U.userid,");
			query.append(" '1' ESTADOCLAUSU,");
			query.append(" '"+userId+"' IDUSUARIOREGISTRO,");
			query.append(" CURRENT_TIMESTAMP FECHAREGISTRO");
			query.append(" FROM   scadmtlincom LC");
			query.append(" INNER JOIN scadmtlincomfun LCF");
			query.append(" ON LC.codigolineacomercial = LCF.codigolineacomercial");
			query.append(" INNER JOIN scadmtlincomcla LCC");
			query.append(" ON LC.codigolineacomercial = LCC.codigolineacomercial");
			query.append(" INNER JOIN sspcotfuncionario F");
			query.append(" ON F.codigofuncionario = LCF.codigofuncionario");
			query.append(" INNER JOIN kssegtuser U");
			query.append(" ON U.userid = F.usuariofuncionario");
			query.append(" WHERE  LC.estado = '1'");
			query.append(" AND LCF.estado = '1' AND LCC.estado = '1'");
			query.append(" AND LC.codigolineacomercial="+codigoLineaComercial);
			query.append(" AND LCC.codigoclasificacion NOT IN(SELECT codigoclasificacion");
			query.append(" FROM   scspetclausu");
			query.append(" WHERE  userid = U.userid)");
			query.append(" ORDER  BY LC.codigolineacomercial");
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al ingresar  clasificaciones al funcionario de la linea comercial {}", e);
			throw new SICException("Error al ingresar  clasificaciones al funcionario de la linea comercial {}", e);
		}
	}
	/**
	 * este metodo permite obtener las clasificaciones 
	 * que no se encuentran en SCADMTLINCOMCLA
	 * para de esta manera saber cuales cumplen con la regla establecisa 
	 * que una clasificacion solo puede estar en linea comercial de distinto tipo
	 * 
	 */
	@Override
	public Collection<String> consultarLineaComercialClasificacionAsignacionMasivaIngresar(String codigoClasificacion,String nivelClasificacion,String valorTipoLineaComercial,Long codigoLinPad,Long codigoLinCom)throws SICException{
		Logeable.LOG_SICV2.info("Entr� a consultar Linea Comercial Clasificacion Asignacion Masiva Ingresar : {}",codigoClasificacion);
		StringBuilder query = null;
		SQLQuery sqlQuery = null;
		Session session=null;
		String divDep=" ) ";
		try {
			session = hibernateH.getHibernateSession();
			session.clear();
			query = new StringBuilder(" SELECT   t1.CODIGOCLASIFICACION   ");
			
			query.append("  FROM ( ");
			if(nivelClasificacion.equals(SICConstantes.TIPCLA_DIVISION)){
				query.append(" select  clasificac2_.CODIGOCLASIFICACION  ");
				query.append(" from SCSPETCLASIFICACION clasificac2_  ");
				query.append(" where clasificac2_.estadoClasificacion = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
				
				query.append(" and ( clasificac2_.codigoClasificacionPadre in ( ");
				divDep+=" ) ) ";
			}
			
			query.append(" select clasificac3_.CODIGOCLASIFICACION  ");
			query.append(" from SCSPETCLASIFICACION clasificac3_  ");
			query.append(" where clasificac3_.estadoClasificacion = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'  ");
			
			if(nivelClasificacion.equals(SICConstantes.TIPCLA_CLASIFICACION)){
				query.append(" and clasificac3_.codigoClasificacion IN ("+codigoClasificacion+") "+divDep+"  t1 ");
			}else{
				query.append(" and clasificac3_.codigoClasificacionPadre IN ("+codigoClasificacion+") "+divDep+"  t1 ");	
			}
			
			
			
			query.append(" where t1.CODIGOCLASIFICACION NOT  IN(	 ");
			query.append(" select distinct lineacomer0_.CODIGOCLASIFICACION        ");
			query.append(" from SCADMTLINCOMCLA lineacomer0_, SCADMTLINCOM lineacomer1_  ");
			query.append(" where lineacomer1_.CODIGOLINEACOMERCIAL=lineacomer0_.CODIGOLINEACOMERCIAL  ");
			query.append(" and lineacomer1_.NIVEL=0 and lineacomer1_.ESTADO='"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'  ");
			if(codigoLinPad != null){
				query.append(" and  lineacomer1_.CODIGOLINEACOMERCIAL NOT IN( "+codigoLinPad+" ) ");
			}
			query.append(" and lineacomer0_.ESTADO='"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' and lineacomer1_.VALORTIPOLINEACOMERCIAL='"+valorTipoLineaComercial+"'  ");
			query.append(" and ( lineacomer0_.CODIGOCLASIFICACION in ( ");
			if(nivelClasificacion.equals(SICConstantes.TIPCLA_DIVISION)){
				query.append(" select clasificac2_.CODIGOCLASIFICACION  ");
				query.append(" from SCSPETCLASIFICACION clasificac2_  ");
				query.append(" where clasificac2_.estadoClasificacion = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'  ");
				query.append(" and ( clasificac2_.codigoClasificacionPadre in ( ");
			}
			
			query.append(" select clasificac3_.CODIGOCLASIFICACION  ");
			query.append(" from SCSPETCLASIFICACION clasificac3_  ");
			query.append(" where clasificac3_.estadoClasificacion = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'  ");
			if(nivelClasificacion.equals(SICConstantes.TIPCLA_CLASIFICACION)){
				query.append(" and clasificac3_.codigoClasificacion IN ("+codigoClasificacion+") "+divDep+"   ) )");
			}else{
				query.append(" and clasificac3_.codigoClasificacionPadre IN ("+codigoClasificacion+") "+divDep+"  ) ) ");
			}
			
			
			///CODIGO EXTRA
			if(codigoLinPad != null){
				query.append(" and  t1.CODIGOCLASIFICACION NOT  IN(	 ");
				query.append(" SELECT  CODIGOCLASIFICACION  FROM SCADMTLINCOMCLA LCC, SCADMTLINCOM LC	 ");
				query.append(" where LCC.CODIGOCLASIFICACION IN(	 ");
				if(nivelClasificacion.equals(SICConstantes.TIPCLA_DIVISION)){
					query.append(" select clasificac2_.CODIGOCLASIFICACION  ");
					query.append(" from SCSPETCLASIFICACION clasificac2_  ");
					query.append(" where clasificac2_.estadoClasificacion = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'  ");
					query.append(" and ( clasificac2_.codigoClasificacionPadre in ( ");
				}
				query.append(" select clasificac3_.CODIGOCLASIFICACION  ");
				query.append(" from SCSPETCLASIFICACION clasificac3_  ");
				query.append(" where clasificac3_.estadoClasificacion = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"'  ");
				
				if(nivelClasificacion.equals(SICConstantes.TIPCLA_CLASIFICACION)){
					query.append(" and clasificac3_.codigoClasificacion IN ("+codigoClasificacion+""+divDep+"    ");
				}else{
					query.append(" and clasificac3_.codigoClasificacionPadre IN ("+codigoClasificacion+") "+divDep+"    ");	
				}
				
				
				query.append(" AND LCC.ESTADO='1' ");
				query.append(" AND LCC.CODIGOLINEACOMERCIAL=LC.CODIGOLINEACOMERCIAL ");
				query.append(" AND LC.CODIGOLINEACOMERCIALPADRE =  "+codigoLinPad);
				query.append(" AND LCC.CODIGOLINEACOMERCIAL NOT IN ("+codigoLinCom+") )");
				if(nivelClasificacion.equals(SICConstantes.TIPCLA_CLASIFICACION)){
					query.append(" ) ");
				}
			}
				
		
//			sqlQuery.setParameter("estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO);
//			sqlQuery.setParameter("codigoClasificacion", codigoClasificacion);
//			sqlQuery.setParameter("valorTipoLineaComercial", valorTipoLineaComercial);
			
			sqlQuery = hibernateH.getHibernateSession().createSQLQuery(query.toString());
//			sqlQuery.addEntity("vista", ClasificacionDTO.class);
			
//			clasificacionDTOs =sqlQuery.list();
			return sqlQuery.list();

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al consultar clasificaciones asignacion masiva {}", e);
			throw new SICException("Error al consultar clasificaciones asignacion masiva {}", e);
		}
//		return clasificacionDTOs;
		
	}
	
	/**
	 * en este metodo nos permite obtener la 
	 * LineaComercialClasificacionDTO para poderla mostrar 
	 * estos datos son los que no se ingresaran por motivo de que ya an sido asignadas
	 * a una linea comercial del mismo tipo
	 */
	@Override
	public Collection<LineaComercialClasificacionDTO> consultarLineaComercialClasificacionAsignacionMasivaNoIngresar(String codigoClasificacion,String nivelClasificacion,String valorTipoLineaComercial,String codigoLinCom)throws SICException{
		Logeable.LOG_SICV2.info("Entr� a consultar Linea Comercial Clasificacion Asignacion Masiva No Ingresar: {}",codigoClasificacion);
		StringBuilder query = null;
		Query sqlQuery = null;
		Session session=null;
		Boolean clearCache = Boolean.TRUE;
		Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionDTOs = new ArrayList<LineaComercialClasificacionDTO>();
		try {
			session = hibernateHLineaComercialClasificacion.getHibernateSession();
			session.clear();
		
			
			query = new StringBuilder();
			query.append(" SELECT  LC, L, C, CV ");
			query.append(" FROM LineaComercialClasificacionDTO LC, LineaComercialDTO L, ClasificacionDTO C, CatalogoValorDTO CV ");
			query.append(" WHERE L.id.codigoLineaComercial = LC.codigoLineaComercial ");
//			query.append(" AND L.nivel = 0 ");
			query.append(" AND L.estado =  '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" AND LC.estado =  '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" AND L.valorTipoLineaComercial = '"+valorTipoLineaComercial+"' ");
			query.append(" AND LC.id.codigoClasificacion = C.id.codigoClasificacion ");
		if(!codigoLinCom.equals("null")){	
			query.append(" AND L.id.codigoLineaComercial !=  "+codigoLinCom);
		}	
			query.append(" AND L.valorTipoLineaComercial = CV.id.codigoCatalogoValor   ");
			query.append(" AND L.codigoTipoLineaComercial = CV.id.codigoCatalogoTipo   ");
			query.append(" AND LC.id.codigoClasificacion  IN (  ");
			if(!nivelClasificacion.equals(SICConstantes.TIPCLA_CLASIFICACION)){
			if(nivelClasificacion.equals(SICConstantes.TIPCLA_DIVISION)){
				query.append(" SELECT id.codigoClasificacion FROM ClasificacionDTO  ");
				query.append(" WHERE estadoClasificacion = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
				query.append(" AND codigoClasificacionPadre IN( ");
			}
			query.append(" SELECT id.codigoClasificacion FROM  ClasificacionDTO ");
			query.append(" WHERE estadoClasificacion = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ");
			query.append(" AND codigoClasificacionPadre IN ("+codigoClasificacion+") "+" )) ");
			}else{
				query.append(" "+codigoClasificacion+")  ");
			}

			sqlQuery = hibernateHLineaComercialClasificacion.createQuery(query.toString(), clearCache);
			
			/**
			 * aqui se asigna al objeto LineaComercialClasificacionDTO los objetos (ClasificacionDTO,LineaComercialDTO)
			 *  que nos entrego la consulta por separado
			 */
			Collection<Object[]> var = sqlQuery.list();
			for(Object[] object:var){
				LineaComercialClasificacionDTO l=(LineaComercialClasificacionDTO)object[0];
				l.setLineaComercial((LineaComercialDTO)object[1]);
				l.setClasificacion((ClasificacionDTO)object[2]);
				l.getLineaComercial().setTipoLineaComercial((CatalogoValorDTO)object[3]);
				lineaComercialClasificacionDTOs.add(l);				
			}
			

		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al consultar clasificaciones asignacion masiva {}", e);
			throw new SICException("Error al consultar clasificaciones asignacion masiva {}", e);
		}
		
		
		return lineaComercialClasificacionDTOs;
	}
	
	@Override
	public Collection<LineaComercialClasificacionDTO> consultarClaificacionesFuncionario(Long codigoLineaComercial, Long codigoLineaComercialFuncionario){
//		Logeable.LOG_SICV2.info("Entr� a consultar Linea Comercial Clasificacion Asignacion Masiva No Ingresar: {}",null);
		StringBuilder query = null;
		Query sqlQuery = null;
		Session session=null;
		Boolean clearCache = Boolean.TRUE;
		Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionDTOs = new ArrayList<LineaComercialClasificacionDTO>();
		try {
			session = hibernateHLineaComercialClasificacion.getHibernateSession();
			session.clear();
		
			
			query = new StringBuilder();
			query.append(" SELECT  LC, C FROM LineaComercialClasificacionDTO LC, ClasificacionDTO C ");
			query.append(" WHERE LC.codigoLineaComercial =  "+codigoLineaComercial+" ");
			query.append(" AND C.id.codigoClasificacion = LC.id.codigoClasificacion ");
			query.append(" AND LC.id.codigoLineaComercialClasificacion ");
			query.append(" NOT IN (SELECT LCF.codigoLineaComercialClasificacion FROM  LineaComercialFuncionarioClasificacionDTO LCF ");
			query.append(" WHERE LCF.codigoLineaComercialFuncionario = "+codigoLineaComercialFuncionario+"  ");
			query.append(" AND LCF.estado = '"+SICConstantes.ESTADO_ACTIVO_NUMERICO+"' ) ");
			 
			
			sqlQuery = hibernateHLineaComercialClasificacion.createQuery(query.toString(), clearCache);
			
			
			Collection<Object[]> var = sqlQuery.list();
			for(Object[] object:var){
				LineaComercialClasificacionDTO l=(LineaComercialClasificacionDTO)object[0];
				l.setClasificacion((ClasificacionDTO)object[1]);				
				lineaComercialClasificacionDTOs.add(l);				
			}
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al consultar clasificaciones asignacion masiva {}", e);
			throw new SICException("Error al consultar clasificaciones asignacion masiva {}", e);
		}	
		return lineaComercialClasificacionDTOs;	
	}
	
	@SuppressWarnings("unchecked")
	public Collection<VistaAreaTrabajoDTO> findAreasTrabajo(AreaTrabajoDTO areaTrabajoDTO, Collection<String> tiposAreaTrabajo)throws SICException
	  {
		try{
			StringBuilder sqlQueryString = new StringBuilder("SELECT A.CODIGOAREATRABAJO as {vista.codigoAreaTrabajo}, A.TIPOAREATRABAJOVALOR as {vista.tipoAreaTrabajo}, A.NOMBREAREATRABAJO as {vista.nombreAreaTrabajo},");
		    sqlQueryString.append(" CASE WHEN (SELECT CODIGOPERFIL FROM SSPCOTARETRAPER ATP INNER JOIN KSSEGTPROFILE P ON ATP.CODIGOPERFIL = P.PROFILEID  WHERE CODIGOAREATRABAJO=A.CODIGOAREATRABAJO");
		    sqlQueryString.append(" AND (P.REFERENCECODE <> 'PCOL' OR P.REFERENCECODE IS NULL) AND ESTADO='ACT' FETCH FIRST ROWS ONLY) IS NULL THEN 0 ELSE 1 END AS {vista.tienePerfiles}");
		    sqlQueryString.append(" FROM SSPCOTAREATRABAJO A INNER JOIN SSPCOTCATALOGOVALOR CV ON A.TIPOAREATRABAJOTIC = CV.CODIGOCATALOGOTIPO AND A.TIPOAREATRABAJOVALOR = CV.CODIGOCATALOGOVALOR");
		    sqlQueryString.append(" WHERE CODIGOCOMPANIA=:pCodigoCompania AND ESTADOAREATRABAJO=:pEstadoArea AND TIPOAREATRABAJOVALOR IN(:pTiposAreaTrabajo) ORDER BY NOMBREAREATRABAJO ASC");
		    SQLQuery sqlQuery = this.hibernateH.getHibernateSession().createSQLQuery(sqlQueryString.toString());
		    sqlQuery.setParameter("pCodigoCompania", areaTrabajoDTO.getId().getCodigoCompania());
		    sqlQuery.setParameter("pEstadoArea", areaTrabajoDTO.getEstadoAreaTrabajo());
		    sqlQuery.setParameterList("pTiposAreaTrabajo", tiposAreaTrabajo);
		    sqlQuery.addEntity("vista", VistaAreaTrabajoDTO.class);
		    return sqlQuery.list();
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al consultar las areas de trabajo", e);
			throw new SICException("Error al consultar las areas de trabajo", e);
		} 
	  }

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Integer> consultarAreaTrabajoPorFuncionario(Collection<Integer> listaCodigoReferencia, String tipoAreaTrabajoValor, Integer tipoAreaTrabajoTIC, String codigoFuncionario) throws SICException {
		try{
			StringBuilder sqlQueryString = new StringBuilder("SELECT DISTINCT BAT.CODIGOREFERENCIA FROM SSPCOTAREATRABAJO BAT ");
			sqlQueryString.append(" LEFT JOIN SSPCOTARESUBLUGTRA AST ON BAT.CODIGOCOMPANIA=AST.CODIGOCOMPANIA AND BAT.CODIGOAREATRABAJO=AST.CODIGOAREATRABAJO");
			sqlQueryString.append(" LEFT JOIN SSPCOTAREATRABAJO SAT ON AST.CODIGOCOMPANIA=SAT.CODIGOCOMPANIA AND AST.CODIGOAREASUBLUGARTRABAJO=SAT.CODIGOAREATRABAJO");
			sqlQueryString.append(" LEFT JOIN SCSPETBODEGA BOD ON BOD.CODIGOCOMPANIA=SAT.CODIGOCOMPANIA AND BOD.CODIGOAREATRABAJO=SAT.CODIGOAREATRABAJO");
			sqlQueryString.append(" LEFT JOIN SCSPETCLASIFICACION CLA ON CLA.CODIGOCOMPANIA=BOD.CODIGOCOMPANIA AND BOD.CODIGOBODEGA=CLA.CODIGOBODEGA");
			sqlQueryString.append(" LEFT JOIN SCADMTLINCOMCLA LCC ON LCC.CODIGOCOMPANIA=CLA.CODIGOCOMPANIA AND LCC.CODIGOCLASIFICACION = CLA.CODIGOCLASIFICACION");
			sqlQueryString.append(" LEFT JOIN SCADMTLINCOM LIC ON LCC.CODIGOCOMPANIA=LIC.CODIGOCOMPANIA AND LIC.CODIGOLINEACOMERCIAL = LCC.CODIGOLINEACOMERCIAL");
			sqlQueryString.append(" LEFT JOIN SCADMTLINCOMFUN LCF ON LIC.CODIGOCOMPANIA=LCF.CODIGOCOMPANIA AND LCF.CODIGOLINEACOMERCIAL = LIC.CODIGOLINEACOMERCIAL");
			sqlQueryString.append(" WHERE BAT.CODIGOREFERENCIA IN (:pCodigosReferencia)");
			sqlQueryString.append(" AND BAT.TIPOAREATRABAJOVALOR=:pTipoAreaTrabajoValor");
			sqlQueryString.append(" AND BAT.TIPOAREATRABAJOTIC=:pTipoAreaTrabajoTIC");
			sqlQueryString.append(" AND LCF.CODIGOFUNCIONARIO=:pCodigoFuncionario");
			sqlQueryString.append(" AND LCF.ESTADO=:pEstadoActivo");
			sqlQueryString.append(" AND LCC.ESTADO=:pEstadoActivo");
			sqlQueryString.append(" AND AST.ESTADO=:pEstadoActivo");
			
			SQLQuery sqlQuery = this.hibernateH.getHibernateSession().createSQLQuery(sqlQueryString.toString());
		    sqlQuery.setParameterList("pCodigosReferencia", listaCodigoReferencia);
		    sqlQuery.setParameter("pTipoAreaTrabajoValor", tipoAreaTrabajoValor);
		    sqlQuery.setParameter("pTipoAreaTrabajoTIC", tipoAreaTrabajoTIC);
			sqlQuery.setParameter("pCodigoFuncionario", codigoFuncionario);
			sqlQuery.setParameter("pEstadoActivo", SICConstantes.ESTADO_ACTIVO_NUMERICO);
//		    sqlQuery.addEntity("vista", VistaAreaTrabajoDTO.class);
		    return sqlQuery.list();
		} catch (Exception e) {
			Logeable.LOG_SICV2.info("Error al consultar las areas de trabajo", e);
			throw new SICException("Error al consultar las areas de trabajo", e);
		} 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<VistaAreaTrabajoPerfilDTO> findAreasTrabajoPerfil(AreaTrabajoID areaTrabajoID)throws SICException
	  {
		try {
			 Collection<String> codigosProFil =  buscarProcesoPerfil();
			 
			  StringBuilder sqlQueryString = new StringBuilder("SELECT  AP.CODIGOCOMPANIA AS {vista.id.codigoCompania} , P.PROFILEID AS {vista.id.codigoPerfil} , AP.CODIGOAREATRABAJO AS {vista.id.codigoAreaTrabajo} , P.PROFILENAME AS {vista.nombrePerfil} , P.PROFILEDESCRIPTION AS {vista.descripcionPerfil}");
			    sqlQueryString.append(" , CASE WHEN (SELECT CODIGOPERFIL FROM SSPCOTFUNPER WHERE CODIGOPERFIL = P.PROFILEID AND ESTADO = 'ACT' AND P.PROFILESTATUS='1' FETCH FIRST ROWS ONLY) IS NULL THEN '0' ELSE '1' END  AS {vista.esAsignado}");
			    sqlQueryString.append(" , P.REFERENCECODE AS {vista.codigoReferencia} ");
			    sqlQueryString.append(" FROM SSPCOTARETRAPER AP INNER JOIN KSSEGTPROFILE P ON AP.CODIGOPERFIL = P.PROFILEID");
			    sqlQueryString.append(" WHERE AP.ESTADO='ACT' AND P.PROFILESTATUS='1' AND AP.CODIGOCOMPANIA = :pCodigoCompania  AND CODIGOAREATRABAJO = :pCodigoAreaTrabajo AND P.PROFILETYPEVALUE = :pProfileTypeValue");
			    if(CollectionUtils.isNotEmpty(codigosProFil)){
			    	sqlQueryString.append(" AND  P.PROFILEID NOT IN (:pCodigosProFil) ");
			    }
			    SQLQuery sqlQuery = this.hibernateH.getHibernateSession().createSQLQuery(sqlQueryString.toString());
			    sqlQuery.setParameter("pCodigoCompania", areaTrabajoID.getCodigoCompania());
			    sqlQuery.setParameter("pCodigoAreaTrabajo", areaTrabajoID.getCodigoAreaTrabajo());
			    sqlQuery.setParameter("pProfileTypeValue", FrameworkConstants.PERFIL_INTERNO);
			    if(CollectionUtils.isNotEmpty(codigosProFil)){
			    	sqlQuery.setParameter("pCodigosProFil",StringUtils.join(codigosProFil,"','"));
				 }
			    
			    
			    sqlQuery.addEntity("vista", VistaAreaTrabajoPerfilDTO.class);
			    Collection<VistaAreaTrabajoPerfilDTO> vistArTraPerCol = sqlQuery.list();
			    
			    return vistArTraPerCol;
			    
			    
		} catch (SICException e) {
			throw new SICException(" Error findAreasTrabajoPerfil :",e);
		}
	  }
	
	@Override
	public  Collection<String> buscarProcesoPerfil()throws SICException{
		try {
			Criteria criteria=hibernateH.getHibernateSession().createCriteria(ProcesoPerfilDTO.class);
			criteria.setProjection(Projections.projectionList()
									.add(Projections.property("id.codigoPerfil"),"id.codigoPerfil")
					);

			criteria.add(Restrictions.eq("id.codigoProceso", SICConstantes.CODIGO_PROCESO_PERFIL_LINEA_COMERCIAL.longValue()));
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			Collection<String> codPerfCol =criteria.list();

			return codPerfCol;
			
		} catch (SICException e) {
			throw new SICException("Error buscarProcesoPerfil: ",e);
		}
	}
	/**
	 * Permite la busqueda de las lineas comercial activas utilizando filtros 
	 * de clasificacion, funcionario, descripcion , nombre
	 * @param lineaComercialVO
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<LineaComercialDTO> buscarLineaComercial(LineaComercialVO lineaComercialVO)throws SICException{
		try {
			Collection<LineaComercialDTO> lineaComercialCol = new ArrayList<LineaComercialDTO>();
			
			Criteria criteria=hibernateH.getHibernateSession().createCriteria(LineaComercialDTO.class,"lineaComercialDTO");
			criteria.setProjection(Projections.projectionList()
									.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
									.add(Projections.property("id.codigoLineaComercial"),"id.codigoLineaComercial")
									.add(Projections.property("nombre"),"nombre")
									.add(Projections.property("estado"),"estado")
									
									.add(Projections.property("codigoLineaComercialRaiz"),"codigoLineaComercialRaiz")
									.add(Projections.property("codigoTipoLineaComercial"),"codigoTipoLineaComercial")
									.add(Projections.property("valorTipoLineaComercial"),"valorTipoLineaComercial")
									.add(Projections.property("nivel"),"nivel")
									.add(Projections.property("codigoReferencia"),"codigoReferencia")
									.add(Projections.property("descripcion"),"descripcion")
									.add(Projections.property("codigoEstablecimiento"),"codigoEstablecimiento")
									.add(Projections.property("codigoLineaComercialPadre"),"codigoLineaComercialPadre")
									
									.add(Projections.property("lineaComercialPadre.estado"),"lineaComercialPadre.estado")
									.add(Projections.property("lineaComercialPadre.id.codigoCompania"),"lineaComercialPadre.id.codigoCompania")
									.add(Projections.property("lineaComercialPadre.id.codigoLineaComercial"),"lineaComercialPadre.id.codigoLineaComercial")
									.add(Projections.property("lineaComercialPadre.nombre"),"lineaComercialPadre.nombre")
									.add(Projections.property("lineaComercialPadre.estado"),"lineaComercialPadre.estado")
									.add(Projections.property("lineaComercialPadre.codigoLineaComercialRaiz"),"lineaComercialPadre.codigoLineaComercialRaiz")
									.add(Projections.property("lineaComercialPadre.codigoTipoLineaComercial"),"lineaComercialPadre.codigoTipoLineaComercial")
									.add(Projections.property("lineaComercialPadre.valorTipoLineaComercial"),"lineaComercialPadre.valorTipoLineaComercial")
									.add(Projections.property("lineaComercialPadre.nivel"),"lineaComercialPadre.nivel")
									.add(Projections.property("lineaComercialPadre.codigoReferencia"),"lineaComercialPadre.codigoReferencia")
									.add(Projections.property("lineaComercialPadre.descripcion"),"lineaComercialPadre.descripcion")
									.add(Projections.property("lineaComercialPadre.codigoEstablecimiento"),"lineaComercialPadre.codigoEstablecimiento")
									.add(Projections.property("lineaComercialPadre.codigoLineaComercialPadre"),"lineaComercialPadre.codigoLineaComercialPadre")
									
					);
			/**permite validar si el usuario selecciono algun filtro de busqueda**/
			if(! lineaComercialVO.getBusquedaSinFiltros()){
				/**validamos si necesita agragar la restriccion de la clasificacion**/
				if(lineaComercialVO.getHasMapCriteriaRestriction().containsKey("linComCla")){
					
					DetachedCriteria subCriterio = DetachedCriteria.forClass(LineaComercialClasificacionDTO.class, "lineaComercialClasificacionDTO")
				            .add(Restrictions.eq("lineaComercialClasificacionDTO.estado",  SICConstantes.ESTADO_ACTIVO_NUMERICO))
				            .add(Restrictions.eqProperty("lineaComercialClasificacionDTO.codigoLineaComercial", "lineaComercialDTO.id.codigoLineaComercial"))
				            /**se agrega las restricciones ingresadas por el usuario**/
				            .add(lineaComercialVO.getHasMapCriteriaRestriction().get("linComCla").getCriteriaRestriction())
				            .setProjection(Projections.property("lineaComercialClasificacionDTO.codigoLineaComercial"));
					/**Se agrega un exist el cual valida si existe una relacion con la clasificacion que se encuentre activa**/
					criteria.add(Subqueries.exists(subCriterio));
				}
				
				/**validamos si necesita agragar la restriccion del funcionario**/
				if(lineaComercialVO.getHasMapCriteriaRestriction().containsKey("linComFun")){
					
//					DetachedCriteria subCriterio = DetachedCriteria.forClass(LineaComercialFuncionarioDTO.class, "lineaComercialFuncionarioDTO")
//					        .createAlias("lineaComercialFuncionarioDTO.funcionario", "funcionario")
//					        .createAlias("funcionario.usuarioDTO", "usuarioDTO")
//							
//					        .add(Restrictions.eqProperty("lineaComercialFuncionarioDTO.codigoLineaComercial", "lineaComercialDTO.id.codigoLineaComercial"))
//					        /**se valida  que los valores a retornar sean activos**/
//					        .add(Restrictions.eq("lineaComercialFuncionarioDTO.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO))
//							.add(Restrictions.eq("funcionario.estadoFuncionario", SICConstantes.ESTADO_ACTIVO_LITERAL))
//							/**se agrega las restricciones ingresadas por el usuario**/
//				            .add(lineaComercialVO.getHasMapCriteriaRestriction().get("linComFun").getCriteriaRestriction())
//				            .setProjection(Projections.property("lineaComercialFuncionarioDTO.codigoLineaComercial"));
//					/**Se agrega un exist el cual valida si existe una relacion con el funcionario que se encuentre activa**/
//					criteria.add(Subqueries.exists(subCriterio));
					Collection<Long> codigoLinComFunCol = consultarCodigosLineaComercialesFuncionario(lineaComercialVO);
					if(CollectionUtils.isNotEmpty(codigoLinComFunCol)){
						criteria.add(Restrictions.in("lineaComercialDTO.id.codigoLineaComercial", codigoLinComFunCol));
					}else{
						return lineaComercialCol;
					}
				}
				
				if(lineaComercialVO.getHasMapCriteriaRestriction().containsKey("linComCliImp")){
					Collection<Long> codigoLinComCliImpCol = consultarCodigosLineaComercialesClienteImportacion(lineaComercialVO);
					if(CollectionUtils.isNotEmpty(codigoLinComCliImpCol)){
						criteria.add(Restrictions.in("lineaComercialDTO.id.codigoLineaComercial", codigoLinComCliImpCol));
					}else{
						return lineaComercialCol;
					}
				}
			}
			/**permite la traer la linea comercial padre **/
			criteria.createAlias("lineaComercialDTO.lineaComercialPadre", "lineaComercialPadre",CriteriaSpecification.LEFT_JOIN);

			/**se agrega las restricciones basicas de la linea comercial mas las que ingreso el usuario**/
			criteria.add(lineaComercialVO.getHasMapCriteriaRestriction().get("linCom").getCriteriaRestriction());
			
			criteria.setResultTransformer(new DtoResultTransformer(LineaComercialDTO.class));
			
			
			lineaComercialCol = criteria.list();
			/**validamos si es necesario contar si la linea comercial tiene sublineas **/
			if(lineaComercialVO.getContarSubLineas()){
				contarLineaComercial(lineaComercialCol);
			}
			/**al consultar una sublinea comercial se modifica el parametro indica que cuenta con sublineas para que asi se pinte en pantalla sin necesidad de consultar**/
			for(LineaComercialDTO linCom: lineaComercialCol){
				if(SearchDTO.isLoaded(linCom.getLineaComercialPadre())){
					linCom.getLineaComercialPadre().setNumeroSubLineas(1);
				}
			}
			
			return lineaComercialCol;
			
		} catch (SICException e) {
			throw new SICException("Error buscarLineaComercial:",e);
		}
	}
	
	/*gnolivos*/
	@SuppressWarnings("unchecked")
	@Override
	public Collection<LineaComercialFuncionarioDTO> obtenerFuncionariosPorLineaComercial(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction> restrictionMap)throws SICException{
		try {
			Collection<LineaComercialFuncionarioDTO> lineaComercialCol = new ArrayList<LineaComercialFuncionarioDTO>();
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LineaComercialFuncionarioDTO.class, "lineaComercialFuncionario");
			
			// Filtro de busqueda de funcionario
			if(restrictionMap != null && restrictionMap.containsKey("linComFun")){
				criteria.add(restrictionMap.get("linComFun").getCriteriaRestriction());
			}
			
			// Projections
			criteria.setProjection(Projections.projectionList()
				// LineaComercialFuncionarioDTO
				.add(Projections.property("id.codigoCompania"),"id_codigoCompania")
				.add(Projections.property("id.codigoLineaComercialFuncionario"),"id_codigoLineaComercialFuncionario")
				.add(Projections.property("id.codigoFuncionario"),"id_codigoFuncionario")
				.add(Projections.property("fechaModificacion"),"fechaModificacion")
				.add(Projections.property("fechaRegistro"),"fechaRegistro")
				.add(Projections.property("estado"),"estado")
				// Funcionario
				.add(Projections.property("funcionario.id.codigoCompania"),"funcionario_id_codigoCompania")
				.add(Projections.property("funcionario.id.codigoFuncionario"),"funcionario_id_codigoFuncionario")
				.add(Projections.property("funcionario.usuarioFuncionario"),"funcionario_usuarioFuncionario")
				.add(Projections.property("funcionario.estadoFuncionario"),"funcionario_estadoFuncionario")
				// Usuario
				.add(Projections.property("funcionariousuarioDTO.userName"),"funcionario_usuarioDTO_userName")
				.add(Projections.property("funcionariousuarioDTO.userCompleteName"),"funcionario_usuarioDTO_userCompleteName")
				// lineaComercialFuncionarioTipoMarcaCol 
				.add(Projections.property("lineaComercialFuncionarioTipoMarcaCol.id.codigoCompania"), "lineaComercialFuncionarioTipoMarcaCol_id_codigoCompania")
				.add(Projections.property("lineaComercialFuncionarioTipoMarcaCol.id.codigoLineaComercialFuncionarioTipoMargen"), "lineaComercialFuncionarioTipoMarcaCol_id_codigoLineaComercialFuncionarioTipoMargen")
				.add(Projections.property("lineaComercialFuncionarioTipoMarcaCol.codigoLineaComercialFuncionario"), "lineaComercialFuncionarioTipoMarcaCol_codigoLineaComercialFuncionario")
				.add(Projections.property("lineaComercialFuncionarioTipoMarcaCol.codigoFuncionarioTipoMarca"), "lineaComercialFuncionarioTipoMarcaCol_codigoFuncionarioTipoMarca")
				.add(Projections.property("lineaComercialFuncionarioTipoMarcaCol.estado"), "lineaComercialFuncionarioTipoMarcaCol_estado")
				// funcionarioTipoMarca
				.add(Projections.property("funcionarioTipoMarca.id.codigoCompania"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_id_codigoCompania")
				.add(Projections.property("funcionarioTipoMarca.id.codigoFuncionarioTipoMarca"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_id_codigoFuncionarioTipoMarca")
				.add(Projections.property("funcionarioTipoMarca.codigoFuncionario"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_codigoFuncionario")
				.add(Projections.property("funcionarioTipoMarca.valorTipoMarca"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_valorTipoMarca")
				.add(Projections.property("funcionarioTipoMarca.codigoTipoMarca"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_codigoTipoMarca")
				.add(Projections.property("funcionarioTipoMarca.estado"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_estado")
				.add(Projections.property("funcionarioTipoMarca.fechaRegistro"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_fechaRegistro")
				.add(Projections.property("funcionarioTipoMarca.fechaModificacion"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_fechaModificacion")
				// marcaFuncionarioTipoMarcaCol
				.add(Projections.property("marcaFuncionarioTipoMarcaCol.id.codigoCompania"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_id_codigoCompania")
				.add(Projections.property("marcaFuncionarioTipoMarcaCol.id.codigoMarcaFuncionarioTipoMarca"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_id_codigoMarcaFuncionarioTipoMarca")
				.add(Projections.property("marcaFuncionarioTipoMarcaCol.codigoFuncionarioTipoMarca"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_codigoFuncionarioTipoMarca")
				.add(Projections.property("marcaFuncionarioTipoMarcaCol.codigoMarca"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_codigoMarca")
				.add(Projections.property("marcaFuncionarioTipoMarcaCol.estado"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_estado")
				.add(Projections.property("marcaFuncionarioTipoMarcaCol.idUsuarioRegistro"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_idUsuarioRegistro")
				.add(Projections.property("marcaFuncionarioTipoMarcaCol.fechaRegistro"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_fechaRegistro")
				.add(Projections.property("marcaFuncionarioTipoMarcaCol.fechaModificacion"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_fechaModificacion")
				// marcaArticulo
				.add(Projections.property("marcaArticulo.nombre"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_marcaFuncionarioTipoMarcaCol_marcaArticulo_nombre")
				// catalogoValor
				.add(Projections.property("catalogoValor.id.codigoCatalogoValor"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_id_codigoCatalogoValor")
				.add(Projections.property("catalogoValor.id.codigoCatalogoTipo"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_id_codigoCatalogoTipo")
				.add(Projections.property("catalogoValor.nombreCatalogoValor"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_nombreCatalogoValor")
				.add(Projections.property("catalogoValor.valorNumerico"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_valorNumerico")
				.add(Projections.property("catalogoValor.orden"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_orden")
				.add(Projections.property("catalogoValor.esValorPorDefecto"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_esValorPorDefecto")
				.add(Projections.property("catalogoValor.esVisible"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_esVisible")
				.add(Projections.property("catalogoValor.color"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_color")
				.add(Projections.property("catalogoValor.nombreCorto"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_nombreCorto")
				.add(Projections.property("catalogoValor.estado"), "lineaComercialFuncionarioTipoMarcaCol_funcionarioTipoMarca_tipoMarca_estado")
				
				);
			
			// Funcionario
			criteria.createAlias("lineaComercialFuncionario.funcionario", "funcionario", CriteriaSpecification.LEFT_JOIN);
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("codigoLineaComercial", codigoLineaComercial));
			criteria.add(Restrictions.eq("estado", estado));
			// Usuario
			criteria.createAlias("funcionario.usuarioDTO", "funcionariousuarioDTO", CriteriaSpecification.LEFT_JOIN);
			// FuncionarioTipoMarca
			criteria.createAlias("lineaComercialFuncionario.lineaComercialFuncionarioTipoMarcaCol", "lineaComercialFuncionarioTipoMarcaCol", CriteriaSpecification.LEFT_JOIN, Restrictions.eq("estado", estado));
			// TipoMarca
			criteria.createAlias("lineaComercialFuncionarioTipoMarcaCol.funcionarioTipoMarca", "funcionarioTipoMarca", CriteriaSpecification.LEFT_JOIN, Restrictions.eq("estado", estado));
			// MarcaTipoMarca
			criteria.createAlias("funcionarioTipoMarca.marcaFuncionarioTipoMarcaCol", "marcaFuncionarioTipoMarcaCol", CriteriaSpecification.LEFT_JOIN, Restrictions.eq("estado", estado));
			// Marca
			criteria.createAlias("marcaFuncionarioTipoMarcaCol.marcaArticulo", "marcaArticulo", CriteriaSpecification.LEFT_JOIN);
			// Catalogo valor
			criteria.createAlias("funcionarioTipoMarca.tipoMarca", "catalogoValor", CriteriaSpecification.LEFT_JOIN);
			
			criteria.setResultTransformer(new MultiLevelResultTransformer(LineaComercialFuncionarioDTO.class));
			
			lineaComercialCol = criteria.list();
			
			return lineaComercialCol;
			
		} catch (SICException e) {
			throw new SICException("Error al buscar funcionarios por linea comercial:",e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Collection<LineaComercialFuncionarioDTO> obtenerLineaComercialPorFuncionario(Integer codigoCompania, String codigoFuncionario)throws SICException{
		
		Collection<LineaComercialFuncionarioDTO> resultado;
		
		try {
			
			Criteria cr = hibernateH.getHibernateSession().createCriteria(LineaComercialFuncionarioDTO.class,"lineaComerciaFuncionario");
			
			cr.createAlias("lineaComerciaFuncionario.lineaComercial", "lineaComercial");
			// LineaComercialFuncionario
			cr.add(Restrictions.eq("lineaComerciaFuncionario.id.codigoCompania", codigoCompania));
			cr.add(Restrictions.eq("lineaComerciaFuncionario.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			cr.add(Restrictions.eq("lineaComerciaFuncionario.id.codigoFuncionario", codigoFuncionario));
			// LineaComercial
			cr.add(Restrictions.eq("lineaComercial.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			cr.add(Restrictions.eq("lineaComercial.codigoEstablecimiento", Integer.parseInt(EstablecimientosConstantes.ESTABLECIMIENTO_CORPORACION_FAVORITA)));
			cr.add(Restrictions.eq("lineaComercial.codigoTipoLineaComercial", (Integer.valueOf(SICConstantes.TIPO_LINEA_COMERCIAL))));
			cr.add(Restrictions.eq("lineaComercial.valorTipoLineaComercial", SICConstantes.VALOR_LINEA_COMERCIAL_COMERCIAL));
			cr.add(Restrictions.isNull("lineaComercial.codigoLineaComercialPadre"));
			
			resultado = (Collection<LineaComercialFuncionarioDTO>) cr.list();
			
			return resultado;
			
		} catch (Exception e) {
			throw new SICException("Error buscarLineaComercialPorFuncionario:",e);
		}
	}
	
	@SuppressWarnings({ "unchecked", "unused", "deprecation" })
	private void contarLineaComercial(Collection<LineaComercialDTO> linComCol) throws SICException {
		if (CollectionUtils.isNotEmpty(linComCol)) {
			try {
				LineaComercialDTO lineaComercialDTO = new LineaComercialDTO();
				Criteria qbcCountFunction = hibernateH.createCriteria(lineaComercialDTO, Boolean.TRUE);
				
				//Llenar la lista con los codigos de las areas
				Map<Long, LineaComercialDTO> linComMap = new HashMap<Long, LineaComercialDTO>();
				for (LineaComercialDTO linComTMP: linComCol) {
					linComMap.put(linComTMP.getId().getCodigoLineaComercial(), linComTMP);
				}
				Collection<Long> codigoLinComIdList = linComMap.keySet();
								
				qbcCountFunction.add(Restrictions.in("codigoLineaComercialPadre", codigoLinComIdList));				
				
				
				Projection projection = Projections.projectionList().add(Projections.groupProperty("codigoLineaComercialPadre")).add(Projections.rowCount());
				qbcCountFunction.setProjection(projection);

				Collection<Object> tuplaConteoLinCom = qbcCountFunction.list();
				
				for(Object obj : tuplaConteoLinCom){
					Object[] resultadoSubLinCom = (Object[]) obj;
					Long optionId = (Long) resultadoSubLinCom[0];
					Integer sizeSubLinCom = (int) ((Long) resultadoSubLinCom[1]).longValue();
					linComMap.get(optionId).setNumeroSubLineas(sizeSubLinCom);
				}
				
			} catch (SICException e) {
				throw new SICException("Error contarLineaComercial ",e);
			} catch (Exception e) {
				throw new SICException("Error contarLineaComercial ",e);
			}
		}
	}
	
	public void actualizarLineaComercial(LineaComercialDTO lineaComercialDTO)throws SICException{
		try {
			Logeable.LOG_SICV2.info("Metodo actualizarLineaComercial  ");
			Logeable.LOG_SICV2.info("Parametros : ");
			Logeable.LOG_SICV2.info("Nombre : "+lineaComercialDTO.getNombre());
			Logeable.LOG_SICV2.info("Descripcion : "+lineaComercialDTO.getDescripcion());
			Logeable.LOG_SICV2.info("userID : "+lineaComercialDTO.getUserId());
			Logeable.LOG_SICV2.info("CodigoReferencia : "+lineaComercialDTO.getCodigoReferencia());
			Logeable.LOG_SICV2.info("ValorTipoLineaComercial : "+lineaComercialDTO.getValorTipoLineaComercial());
			Logeable.LOG_SICV2.info("CodigoEstablecimiento : "+lineaComercialDTO.getCodigoEstablecimiento());
			
			StringBuilder query = new StringBuilder();
			Query update;
				
			hibernateH.getHibernateSession().clear();
				
			query.append("update ").append(LineaComercialDTO.class.getName()).append(" d ")
				.append(" set  ")
				.append(" d.fechaModificacion = CURRENT_TIMESTAMP, ")
				.append(" d.nombre = :pNombreLinCom, ");
			
			if(StringUtils.isNotBlank(lineaComercialDTO.getDescripcion())){
				query.append("d.descripcion = :pDescripcionLinCom, ");
			}
			if(StringUtils.isNotBlank(lineaComercialDTO.getCodigoReferencia())){
				query.append("d.codigoReferencia = :pCodigoReferencia, ");
			}	
			
			query.append("d.valorTipoLineaComercial = :pValorTipoLineaComercial, ");
			query.append("d.codigoEstablecimiento = :pCodigoEstablecimiento, ");
			
			query.append("d.idUsuarioModificacion = :pUsuarioModificacion ");
			
			query.append(" where ")
				.append("  d.id.codigoLineaComercial = :pCodigoLineaComercial ");
			
			update = hibernateH.getHibernateSession().createQuery(query.toString());
			
			if(StringUtils.isNotBlank(lineaComercialDTO.getDescripcion())){
				update.setString("pDescripcionLinCom", lineaComercialDTO.getDescripcion());
			}
			if(StringUtils.isNotBlank(lineaComercialDTO.getCodigoReferencia())){
				update.setString("pCodigoReferencia",lineaComercialDTO.getCodigoReferencia());
			}
			
			update.setString("pNombreLinCom", lineaComercialDTO.getNombre());
			update.setString("pValorTipoLineaComercial", lineaComercialDTO.getValorTipoLineaComercial());
			update.setInteger("pCodigoEstablecimiento", lineaComercialDTO.getCodigoEstablecimiento());
			
			update.setString("pUsuarioModificacion", lineaComercialDTO.getUserId());
			update.setLong("pCodigoLineaComercial",lineaComercialDTO.getId().getCodigoLineaComercial());
			
			update.executeUpdate();	
			
		} catch (SICException e) {
			throw new SICException("Error actualizarLineaComercial: ",e);
		}
	}
	
	
	private Collection<Long> consultarCodigosLineaComercialesFuncionario(LineaComercialVO lineaComercialVO) throws SICException{
		try {
			Logeable.LOG_SICV2.info("Metodo consultarCodigosLineaComercialesFuncionario  ");
			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(LineaComercialDTO.class, "lineaComercialDTO");
					
			criteria.setProjection(Projections.projectionList()
		            .add(Projections.property("lineaComercialDTO.id.codigoLineaComercial"),"id.codigoLineaComercial")
		            .add(Projections.property("lineaComercialDTO.id.codigoCompania"),"id.codigoCompania")
		            .add(Projections.property("lineaComercialDTO.codigoLineaComercialPadre"),"codigoLineaComercialPadre"));
		            
			criteria.createAlias("lineaComercialDTO.lineaComercialFuncionarios", "lineaComercialFuncionarioDTO");
	        criteria.createAlias("lineaComercialFuncionarioDTO.funcionario", "funcionario");
	        criteria.createAlias("funcionario.usuarioDTO", "usuarioDTO");
								        
			        /**se valida  que los valores a retornar sean activos**/
	        criteria.add(Restrictions.eq("lineaComercialFuncionarioDTO.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("funcionario.estadoFuncionario", SICConstantes.ESTADO_ACTIVO_LITERAL));
					/**se agrega las restricciones ingresadas por el usuario**/
			criteria.add(lineaComercialVO.getHasMapCriteriaRestriction().get("linComFun").getCriteriaRestriction());
	
			
			criteria.setResultTransformer(new DtoResultTransformer(LineaComercialDTO.class));
		    
			Collection<LineaComercialDTO> lineaComercialDTOCol = criteria.list();
			
			HashSet<Long> codigoLineaComercial = new HashSet<Long>();
			
			if(lineaComercialVO.hasDynamicProperty("validaCodigosPadre") && !(Boolean)lineaComercialVO.getDynamicProperty("validaCodigosPadre")){
				CollectionUtils.collect(lineaComercialDTOCol, new BeanToPropertyValueTransformer("id.codigoLineaComercial"), codigoLineaComercial);
			}else{
				for(LineaComercialDTO linCom :lineaComercialDTOCol){
					if(linCom.getCodigoLineaComercialPadre() == null){
						codigoLineaComercial.add(linCom.getId().getCodigoLineaComercial());
					}else{
						Long codigoLinCom = obtenerCodigoLineaComercialPadre(linCom);
						codigoLineaComercial.add(codigoLinCom);
					}
				}	
			}			
			return codigoLineaComercial;
			
			
		} catch (SICException e) {
			throw new SICException("Error consultarCodigosLineaComercialesFuncionario: ",e);
		}
	}
	
	/**
	 * Permite obtener los codigos de lineas comerciales asociados a clientes importacion
	 * @param lineaComercialVO
	 * @return
	 * @throws SICException
	 */
	private Collection<Long> consultarCodigosLineaComercialesClienteImportacion(LineaComercialVO lineaComercialVO) throws SICException{
		try {
			Logeable.LOG_SICV2.info("Metodo consultarCodigosLineaComercialesClienteImportacion  ");
			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(LineaComercialDTO.class, "lineaComercialDTO");
					
			criteria.setProjection(Projections.projectionList()
		            .add(Projections.property("lineaComercialDTO.id.codigoLineaComercial"),"id.codigoLineaComercial")
		            .add(Projections.property("lineaComercialDTO.id.codigoCompania"),"id.codigoCompania")
		            .add(Projections.property("lineaComercialDTO.codigoLineaComercialPadre"),"codigoLineaComercialPadre"));
		            
			criteria.createAlias("lineaComercialDTO.lineaComercialClienteImportacionCol", "LineaComercialClienteImportacionDTO");
	        criteria.createAlias("LineaComercialClienteImportacionDTO.clienteImportacionDTO", "clienteImportacionDTO");
								        
			/**se valida  que los valores a retornar sean activos**/
	        criteria.add(Restrictions.eq("LineaComercialClienteImportacionDTO.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("clienteImportacionDTO.estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
			
			/**se agrega las restricciones ingresadas por el cliente importacion**/
			criteria.add(lineaComercialVO.getHasMapCriteriaRestriction().get("linComCliImp").getCriteriaRestriction());
	
			
			criteria.setResultTransformer(new DtoResultTransformer(LineaComercialDTO.class));
		    
			Collection<LineaComercialDTO> lineaComercialDTOCol = criteria.list();
			
			HashSet<Long> codigoLineaComercial = new HashSet<Long>();
			
			if(lineaComercialVO.hasDynamicProperty("validaCodigosPadre") && !(Boolean)lineaComercialVO.getDynamicProperty("validaCodigosPadre")){
				CollectionUtils.collect(lineaComercialDTOCol, new BeanToPropertyValueTransformer("id.codigoLineaComercial"), codigoLineaComercial);
			}else{
				for(LineaComercialDTO linCom :lineaComercialDTOCol){
					if(linCom.getCodigoLineaComercialPadre() == null){
						codigoLineaComercial.add(linCom.getId().getCodigoLineaComercial());
					}else{
						Long codigoLinCom = obtenerCodigoLineaComercialPadre(linCom);
						codigoLineaComercial.add(codigoLinCom);
					}
				}
			}	
			return codigoLineaComercial;
			
		} catch (SICException e) {
			throw new SICException("Error consultarCodigosLineaComercialesClienteImportacion: ",e);
		}
	}
	
	private Long obtenerCodigoLineaComercialPadre(LineaComercialDTO lineaComercialDTO) throws SICException{
		try {
			Long codigoLineaComercialPadre = null;
			if(lineaComercialDTO.getCodigoLineaComercialPadre() == null){
				codigoLineaComercialPadre =  lineaComercialDTO.getId().getCodigoLineaComercial();
			}else{
				LineaComercialDTO lineaComercialDTOAux = consultarLineaComercial(lineaComercialDTO.getCodigoLineaComercialPadre());
				codigoLineaComercialPadre = obtenerCodigoLineaComercialPadre(lineaComercialDTOAux);
			}
			
			return codigoLineaComercialPadre;
					
		} catch (SICException e) {
			throw new SICException("Error obtenerCodigoLineaComercialPadre: ",e);
		}
	}
	
	
	/**
	 * Permite consultar la linea comercial tomando encuenta solo el codigoLineaComercial
	 * @param codigoLineaComercial
	 * @return
	 */
	private LineaComercialDTO consultarLineaComercial(Long codigoLineaComercial) throws SICException{
		try {
			Logeable.LOG_SICV2.info("Metodo consultarLineaComercial  ");
			Logeable.LOG_SICV2.info("Parametros : ");
			Logeable.LOG_SICV2.info("codigoLineaComercial : "+codigoLineaComercial);
			
			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(LineaComercialDTO.class);
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoLineaComercial"),"id.codigoLineaComercial")
					.add(Projections.property("codigoLineaComercialPadre"),"codigoLineaComercialPadre")
					);
			
			criteria.add(Restrictions.eq("id.codigoLineaComercial", codigoLineaComercial));
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.setResultTransformer(new DtoResultTransformer(LineaComercialDTO.class));
			
			LineaComercialDTO lineaComercialDTO = (LineaComercialDTO)criteria.uniqueResult();
			
			
			return lineaComercialDTO;
		} catch (SICException e) {
			throw new SICException("Error consultarLineaComercial: ",e);
		}
	}
	
	@Override
	public Collection<ClienteImportacionDTO> consultarClienteImportacion()throws SICException{
		try {
			Logeable.LOG_SICV2.info("Metodo consultarClienteImportacion  ");
			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(ClienteImportacionDTO.class);
			criteria.setProjection(Projections.projectionList()
						.add(Projections.property("id.codigoClienteImportacion"),"id.codigoClienteImportacion")
						.add(Projections.property("nombre"),"nombre")
						.add(Projections.property("siglas"),"siglas")
					);
			
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
			criteria.setResultTransformer(new DtoResultTransformer(ClienteImportacionDTO.class));
			
			Collection<ClienteImportacionDTO> clienteImportacionDTOCol = criteria.list();
			
			return clienteImportacionDTOCol;
		} catch (SICException e) {
			throw new SICException("Error consultarClienteImportacion: ",e);
		}
	}
	/**
	 * Permite la busqueda de LinComClieImp 
	 */
	@Override
	public Collection<LineaComercialClienteImportacionDTO> consultarLinComClienImp(LineaComercialClienteImportacionDTO linComCliImpDTO)throws SICException{
		try {
			Logeable.LOG_SICV2.info("Metodo consultarLinComClienImp  ");
			Logeable.LOG_SICV2.info("Parametros : ");
			Logeable.LOG_SICV2.info("codigoClienteImportacion() : "+linComCliImpDTO.getId().getCodigoClienteImportacion());
			Logeable.LOG_SICV2.info("estado : "+linComCliImpDTO.getEstado());
			Logeable.LOG_SICV2.info("codigoLineaComercial : "+ linComCliImpDTO.getId().getCodigoLineaComercial());

			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(LineaComercialClienteImportacionDTO.class);
			ProjectionList projectionList = Projections.projectionList()
						.add(Projections.property("id.codigoLineaComercial"),"id.codigoLineaComercial")
						.add(Projections.property("id.codigoClienteImportacion"),"id.codigoClienteImportacion")
						.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
						.add(Projections.property("estado"),"estado");
			
			if(linComCliImpDTO.getId().getCodigoClienteImportacion() == null){
				/**si la validacion es verdadera se trae de base las descripciones de (lineaComercialDTO,clienteImportacionDTO) para presentar en pantalla estas descripciones**/
				projectionList.add(Projections.property("linCom.nombre"),"lineaComercialDTO.nombre");
				projectionList.add(Projections.property("linCom.descripcion"),"lineaComercialDTO.descripcion");
				projectionList.add(Projections.property("clienImp.nombre"),"clienteImportacionDTO.nombre");
				projectionList.add(Projections.property("clienImp.siglas"),"clienteImportacionDTO.siglas");
				
				/**se agrega restricciones para cliente importacion clienImp*/
				if(linComCliImpDTO.hasDynamicProperty("linComCliImp") && linComCliImpDTO.getDynamicProperty("linComCliImp") != null){					
					DetachedCriteria subCriterio = DetachedCriteria.forClass(ClienteImportacionDTO.class, "clienteImportacionDTO")
				            .add(Restrictions.eq("estado",  SICConstantes.ESTADO_ACTIVO_LITERAL))
				            /**se agrega las restricciones ingresadas por el usuario**/
				            .add(((DynamicCriteriaRestriction)linComCliImpDTO.getDynamicProperty("linComCliImp")).getCriteriaRestriction())
				            .setProjection(Projections.property("id.codigoClienteImportacion"));
					/**Se agrega un exist el cual valida si existe una relacion**/
					criteria.add(Subqueries.propertyIn("id.codigoClienteImportacion", subCriterio));
				}				
				
				criteria.createAlias("lineaComercialDTO", "linCom");
				criteria.createAlias("clienteImportacionDTO", "clienImp");
				
				
			}else{
				/**si la validacion es false no se une a otra tabla porque lo que se requiere es un solo registro**/
				criteria.add(Restrictions.eq("id.codigoClienteImportacion", linComCliImpDTO.getId().getCodigoClienteImportacion()));
			}
			/**al no agreagar esta restriccion se puede traer de base los estados(1,0)**/
			if(StringUtils.isNotBlank(linComCliImpDTO.getEstado())){
				criteria.add(Restrictions.eq("estado", linComCliImpDTO.getEstado()));
			}
			
			criteria.add(Restrictions.eq("id.codigoLineaComercial", linComCliImpDTO.getId().getCodigoLineaComercial()));
			
			criteria.setProjection(projectionList);
			
			criteria.setResultTransformer(new DtoResultTransformer(LineaComercialClienteImportacionDTO.class));
			
			Collection<LineaComercialClienteImportacionDTO> linComCliImpDTOResultCol = criteria.list();
			
			return linComCliImpDTOResultCol;
			
		} catch (SICException e) {
			throw new SICException("Error consultarLinComClienImp: ",e);
		}
	}
	/**
	 * Permite actualizar el estado (0,1) y el usuario modificacion y fecha modificacion 
	 */
	@Override
	public void actualizarLinComClienImp(LineaComercialClienteImportacionDTO linComCliImpDTO)throws SICException{
		try {
			Logeable.LOG_SICV2.info("Metodo actualizarLinComClienImp  ");
			Logeable.LOG_SICV2.info("Parametros : ");
			Logeable.LOG_SICV2.info("userId : "+linComCliImpDTO.getUserId());
			Logeable.LOG_SICV2.info("estado : "+linComCliImpDTO.getEstado());
			Logeable.LOG_SICV2.info("codigoLineaComercial : "+ linComCliImpDTO.getId().getCodigoLineaComercial());
			Logeable.LOG_SICV2.info("codigoClienteImportacion : "+ linComCliImpDTO.getId().getCodigoClienteImportacion());
			
			StringBuilder query = new StringBuilder();
			Query update;
				
			hibernateH.getHibernateSession().clear();
				
			query.append("update ").append(LineaComercialClienteImportacionDTO.class.getName()).append(" d ")
				.append(" set  ")
				.append(" d.fechaModificacion = CURRENT_TIMESTAMP, ")
				.append(" d.estado = :pEstado, ")
				.append("d.idUsuarioModificacion = :pUsuarioModificacion ");
			
			query.append(" where ")
				.append("  d.id.codigoLineaComercial = :pCodigoLineaComercial ");
			
			if(linComCliImpDTO.getId().getCodigoClienteImportacion() != null){
				query.append("  and d.id.codigoClienteImportacion = :pCodigoClienteImportacion ");
			}else{
				query.append("  and d.estado = :pEstadoDiferente ");
			}
			
			update = hibernateH.getHibernateSession().createQuery(query.toString());
			
			update.setString("pUsuarioModificacion", linComCliImpDTO.getUserId());
			update.setString("pEstado",linComCliImpDTO.getEstado());
			update.setLong("pCodigoLineaComercial", linComCliImpDTO.getId().getCodigoLineaComercial());
			if(linComCliImpDTO.getId().getCodigoClienteImportacion() != null){
				update.setLong("pCodigoClienteImportacion",linComCliImpDTO.getId().getCodigoClienteImportacion());
			}else{
				update.setString("pEstadoDiferente",(SICConstantes.ESTADO_ACTIVO_NUMERICO.equals(linComCliImpDTO.getEstado())?SICConstantes.ESTADO_INACTIVO_NUMERICO:SICConstantes.ESTADO_ACTIVO_NUMERICO));
			}
			update.executeUpdate();	
			
			
		} catch (SICException e) {
			throw new SICException("Error actualizarLinComClienImp: ",e);
		}
	}
	/**
	 * este metodo retorna true si el cliente existe en una linea comercial de tipo filial
	 * @param clienteImportacionDTO
	 */
	public boolean validarClienImpLinComEstFilial(Long codigoClienteImportacion,Integer codigoCompania)throws SICException{
		try {
			Logeable.LOG_SICV2.info("Metodo validarClienImpLinComEstFilial  ");
			Logeable.LOG_SICV2.info("Parametros : ");
			Logeable.LOG_SICV2.info("codigoClienteImportacion : "+codigoClienteImportacion);
			Logeable.LOG_SICV2.info("codigoCompania : "+codigoCompania);
			
			Criteria criteria = hibernateH.getHibernateSession().createCriteria(LineaComercialClienteImportacionDTO.class);
			criteria.setProjection(Projections.count("id.codigoClienteImportacion"));
			criteria.createAlias("lineaComercialDTO", "lineaComercialDTO");
			criteria.createAlias("lineaComercialDTO.establecimiento", "establecimiento");
			criteria.add(Restrictions.eq("establecimiento.tipoEstablecimiento",CorporativoConstantes.TIPO_ESTABLECIMIENTO_FILIAL));
			criteria.add(Restrictions.eq("id.codigoClienteImportacion", codigoClienteImportacion));
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("lineaComercialDTO.estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("establecimiento.estado", SICConstantes.ESTADO_ACTIVO_LITERAL));
			
			Long resulCount = (Long)criteria.uniqueResult();
			
			if(resulCount > 0){
				return true;
			}
			
			return false;
			
		} catch (SICException e) {
			throw new SICException("Error validarClienImpLinComEstFilial",e);
		}
	}
	
	public void agregarLineaComercialFuncionarioClasificacion(LineaComercialDTO lineaComercialDTO, LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)
			throws SICException{
		Logeable.LOG_SICV2.info("Entro a agregarLineaComercialFuncionarioClasificacion()");
		StringBuilder query = null;
		Query sqlQuery = null;		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();			
			query = new StringBuilder();
			query.append(" INSERT INTO SCADMTLINCOMFUNCLA ");
			query.append(" ( CODLINCOMFUNCLA, CODIGOCOMPANIA, CODLINCOMCLA, CODLINCOMFUN, ESTADO, IDUSUARIOREGISTRO, FECHAREGISTRO, CODIGOCLASIFICACION, CODIGOFUNCIONARIO )");
			query.append(" SELECT NEXT VALUE FOR SCADMSECLINCOMFUNCLA, LCC.CODIGOCOMPANIA, LCC.CODLINCOMCLA, " + lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario() + ", ");
			query.append(" '" + SICConstantes.ESTADO_ACTIVO_NUMERICO + "','" + lineaComercialDTO.getUserId() + "',CURRENT_TIMESTAMP, LCC.CODIGOCLASIFICACION, " + lineaComercialFuncionarioDTO.getId().getCodigoFuncionario());
			query.append(" FROM SCADMTLINCOMCLA LCC INNER JOIN SCSPETCLASIFICACION CL ON ");
			query.append(" LCC.CODIGOCOMPANIA = CL.CODIGOCOMPANIA AND LCC.CODIGOCLASIFICACION = CL.CODIGOCLASIFICACION ");
			query.append(" WHERE LCC.CODIGOLINEACOMERCIAL = " + lineaComercialDTO.getId().getCodigoLineaComercial() + " ");
			query.append(" AND LCC.CODIGOCOMPANIA = " + lineaComercialDTO.getId().getCodigoCompania() + " ");
			query.append(" AND LCC.ESTADO = '" + SICConstantes.ESTADO_ACTIVO_NUMERICO + "' ");		
			query.append(" AND CL.ESTADOCLASIFICACION = '" + SICConstantes.ESTADO_ACTIVO_NUMERICO + "' ");	
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();		
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al crearLineaComercialFuncionarioClasificacion {0}", e);
			throw new SICException("Error al crearLineaComercialFuncionarioClasificacion", e);
		}
	}
	/**
	 *Busca las clasificaciones segun la linea comercial
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public Collection<LineaComercialClasificacionDTO> buscarClasificacionesLinCom(Integer codigoCompania, Long codigoLineaComercial, String estado, Map<String, DynamicCriteriaRestriction>  restrictionMap)throws SICException{
		
		try{
		
			this.sessionFactory.getCurrentSession().clear();
			Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(LineaComercialClasificacionDTO.class, "root");		
			criteria.createAlias("clasificacion", "clasificacion", CriteriaSpecification.LEFT_JOIN);
			criteria.setProjection(Projections.projectionList()
					.add(Projections.property("clasificacion.id.codigoClasificacion"),"clasificacion.id.codigoClasificacion")
					.add(Projections.property("codigoLineaComercial"),"codigoLineaComercial")
					.add(Projections.property("id.codigoClasificacion"),"id.codigoClasificacion")
					.add(Projections.property("idUsuarioRegistro"),"idUsuarioRegistro")
					.add(Projections.property("idUsuarioModificacion"),"idUsuarioModificacion")
					.add(Projections.property("fechaRegistro"),"fechaRegistro")
					.add(Projections.property("id.codigoCompania"),"id.codigoCompania")
					.add(Projections.property("id.codigoLineaComercialClasificacion"),"id.codigoLineaComercialClasificacion")
					.add(Projections.property("clasificacion.descripcionClasificacion"),"clasificacion.descripcionClasificacion")
				);
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("codigoLineaComercial",codigoLineaComercial));
			criteria.add(Restrictions.eq("estado", estado));
			criteria.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("clasificacion.valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
			criteria.add(Restrictions.eq("clasificacion.codigoTipoEstructura", TiposCatalogoConstantes.TIPO_ESTRUCTURA));
			
			if(restrictionMap != null && restrictionMap.containsKey("linComCla")){
				criteria.add(restrictionMap.get("linComCla").getCriteriaRestriction());
			}
			
			criteria.addOrder(Order.asc("clasificacion.id.codigoClasificacion"));
			
			criteria.setResultTransformer(new DtoResultTransformer(LineaComercialClasificacionDTO.class));
			
			return (Collection<LineaComercialClasificacionDTO>)criteria.list();
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al consultar clasificaciones en lineas comerciales {0}", e);
			throw new SICException("Error al consultar clasificaciones en lineas comerciales", e);
		}
	}
	
	@Override
	public Long contarLineaComercialClasificacion(Integer codigoCompania, Long codigoLineaComercial) throws SICException {		
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LineaComercialClasificacionDTO.class, "root");
			criteria.createAlias("clasificacion", "clasificacion", CriteriaSpecification.LEFT_JOIN);
			criteria.add(Restrictions.eq("id.codigoCompania", codigoCompania));
			criteria.add(Restrictions.eq("codigoLineaComercial",codigoLineaComercial));
			criteria.add(Restrictions.eq("estado", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("clasificacion.estadoClasificacion", SICConstantes.ESTADO_ACTIVO_NUMERICO));
			criteria.add(Restrictions.eq("clasificacion.valorTipoEstructura", CorporativoConstantes.TIPO_ESTRUCTURA_COMERCIAL));
			criteria.add(Restrictions.eq("clasificacion.codigoTipoEstructura", TiposCatalogoConstantes.TIPO_ESTRUCTURA));
	
			ProjectionList projectionList = Projections.projectionList();
			projectionList.add(Projections.count("clasificacion.id.codigoClasificacion"), "clasificacion.id.codigoClasificacion");
			criteria.setProjection(projectionList);
	
			return ((Long) criteria.uniqueResult());
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al contar las clasificaciones asignadas a la linea comercial {0}", e);
			throw new SICException("Error al contar las clasificaciones asignadas a la linea comercial", e);
		}
	}
	
	/**
	 * Permite obtener el codigo de la linea comercial clasificacion
	 * @param codigoLineaComercial Codigo de la linea comercial
	 * @param codigoClasificacion Codigo de la clasificacion
	 * @return Codigo linea comercial clasificacion
	 * @throws SICException
	 */
	private Long obtenerCodigoLineaComercialClasificacion(Long codigoLineaComercial, String codigoClasificacion) throws SICException{
		StringBuilder query = null;
		Query sqlQuery = null;		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();
			
			query = new StringBuilder();
			query.append(" SELECT CODLINCOMCLA FROM SCADMTLINCOMCLA LCC INNER JOIN SCSPETCLASIFICACION CL ON LCC.CODIGOCOMPANIA = CL.CODIGOCOMPANIA AND LCC.CODIGOCLASIFICACION = CL.CODIGOCLASIFICACION");
			query.append(" WHERE LCC.CODIGOLINEACOMERCIAL = " + codigoLineaComercial + " AND LCC.CODIGOCLASIFICACION = " + codigoClasificacion + " AND CL.ESTADOCLASIFICACION = '" + SICConstantes.ESTADO_ACTIVO_NUMERICO + "'");						
			sqlQuery = session.createSQLQuery(query.toString());
			
			Object codLinComCla = sqlQuery.uniqueResult();			
			if(codLinComCla != null){
				if(codLinComCla instanceof BigDecimal){
					return ((BigDecimal)codLinComCla).longValue();
				}else{
					return (Long)codLinComCla;
				}	
			}
			return null;
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error obtenerCodigoLineaComercialClasificacion {0}", e);
			throw new SICException("Error al obtener el codigo linea comercial clasificacion", e);
		}
	}
	
	public void agregarLineaComercialFuncionarioClasificacion(Long codigoLineaComercial, String userId, Collection<String> codigosClasificacion) throws SICException{
		Logeable.LOG_SICV2.info("Entro a agregarLineaComercialFuncionarioClasificacion()");
		StringBuilder query = null;
		Query sqlQuery = null;		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();			
			if(CollectionUtils.isNotEmpty(codigosClasificacion)){
				Long codLinComCla = null;
				for(String codigoClasificacion : codigosClasificacion){
					codLinComCla = this.obtenerCodigoLineaComercialClasificacion(codigoLineaComercial, codigoClasificacion);
					if(codLinComCla != null){
						query = new StringBuilder();					
						query.append(" INSERT INTO SCADMTLINCOMFUNCLA");
						query.append(" (CODLINCOMFUNCLA, CODIGOCOMPANIA, CODLINCOMCLA, CODLINCOMFUN, ESTADO, IDUSUARIOREGISTRO, FECHAREGISTRO, CODIGOCLASIFICACION, CODIGOFUNCIONARIO)");
						query.append(" SELECT NEXT VALUE FOR SCADMSECLINCOMFUNCLA, LCF.CODIGOCOMPANIA," + codLinComCla + ","); 
						query.append(" LCF.CODLINCOMFUN, '" + SICConstantes.ESTADO_ACTIVO_NUMERICO + "','" + userId + "',CURRENT_TIMESTAMP, " + codigoClasificacion + ", LCF.CODIGOFUNCIONARIO");
						query.append(" FROM SCADMTLINCOMFUN LCF INNER JOIN SSPCOTFUNCIONARIO FUN ON LCF.CODIGOCOMPANIA = FUN.CODIGOCOMPANIA AND LCF.CODIGOFUNCIONARIO = FUN.CODIGOFUNCIONARIO");
						query.append(" WHERE LCF.CODIGOLINEACOMERCIAL = " + codigoLineaComercial);
						query.append(" AND LCF.ESTADO = '" + SICConstantes.ESTADO_ACTIVO_NUMERICO + "' ");
						query.append(" AND LCF.CODLINCOMFUN NOT IN (SELECT CODLINCOMFUN FROM SCADMTLINCOMFUNCLA WHERE CODLINCOMCLA = " + codLinComCla + ")");
						query.append(" AND FUN.ESTADOFUNCIONARIO = '" + SICConstantes.ESTADO_ACTIVO_LITERAL + "'");			
						sqlQuery = session.createSQLQuery(query.toString());
						sqlQuery.executeUpdate();	
					}
				}
			}
			session.flush();		
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al crearLineaComercialFuncionarioClasificacion {0}", e);
			throw new SICException("Error al crearLineaComercialFuncionarioClasificacion", e);
		}
	}
	
	public void removerLineaComercialFuncionarioClasificacion(LineaComercialFuncionarioDTO lineaComercialFuncionarioDTO)
			throws SICException{
		Logeable.LOG_SICV2.info("Entro a removerLineaComercialFuncionarioClasificacion()");
		StringBuilder query = null;
		Query sqlQuery = null;		
		try {
			Session session = hibernateH.getHibernateSession();
			session.clear();			
			query = new StringBuilder();			
			query.append(" DELETE FROM SCADMTLINCOMFUNCLA WHERE CODLINCOMCLA in ( ");
			query.append(" SELECT CODLINCOMCLA FROM SCADMTLINCOMCLA WHERE CODIGOLINEACOMERCIAL = " + lineaComercialFuncionarioDTO.getLineaComercial().getId().getCodigoLineaComercial());
			query.append(" AND CODIGOCOMPANIA = " + lineaComercialFuncionarioDTO.getLineaComercial().getId().getCodigoCompania() + " ) ");
			query.append(" AND CODLINCOMFUN = " + lineaComercialFuncionarioDTO.getId().getCodigoLineaComercialFuncionario() + " ");
			query.append(" AND CODIGOCOMPANIA = " + lineaComercialFuncionarioDTO.getLineaComercial().getId().getCodigoCompania() + " ");			
			sqlQuery = session.createSQLQuery(query.toString());
			sqlQuery.executeUpdate();
			session.flush();		
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al removerLineaComercialFuncionarioClasificacion {0}", e);
			throw new SICException("Error al removerLineaComercialFuncionarioClasificacion", e);
		}
	}
	
	public void removerLineaComercialFuncionarioClasificacion(String codigosLineaComercial, Collection<String> codigosClasificacion)throws SICException{
		Logeable.LOG_SICV2.info("Entro a removerLineaComercialFuncionarioClasificacion()");
		StringBuilder query = null;
		Query sqlQuery = null;		
		try {	
			if(StringUtils.isNotEmpty(codigosLineaComercial) && CollectionUtils.isNotEmpty(codigosClasificacion)){
				Session session = hibernateH.getHibernateSession();
				session.clear();	
				for(String codigoClasificacion : codigosClasificacion){					
					query = new StringBuilder();			
					query.append(" DELETE FROM SCADMTLINCOMFUNCLA WHERE CODLINCOMCLA IN (");
					query.append(" SELECT CODLINCOMCLA FROM SCADMTLINCOMCLA WHERE CODIGOLINEACOMERCIAL IN (" + codigosLineaComercial + ")");
					query.append(" AND CODIGOCLASIFICACION = " + codigoClasificacion + ")");
					query.append(" AND CODLINCOMFUN IN ( SELECT CODLINCOMFUN FROM SCADMTLINCOMFUN WHERE CODIGOLINEACOMERCIAL IN (" + codigosLineaComercial + "))");					
					sqlQuery = session.createSQLQuery(query.toString());
					sqlQuery.executeUpdate();	
				}
				session.flush();
			}
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("Error al removerLineaComercialFuncionarioClasificacion {0}", e);
			throw new SICException("Error al removerLineaComercialFuncionarioClasificacion", e);
		}
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
