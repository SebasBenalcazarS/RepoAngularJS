/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.util;

import static ec.com.smx.corpv2.common.util.CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL;
import static ec.com.smx.corpv2.common.util.TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE;
import static ec.com.smx.sic.cliente.common.SICConstantes.ESTADO_ACTIVO_NUMERICO;
import static ec.com.smx.sic.cliente.common.SICConstantes.ESTADO_INACTIVO_NUMERICO;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TreeSet;

import org.apache.commons.lang3.BooleanUtils;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.corpv2.common.util.CorporativoConstantes;
import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.framework.common.util.ConverterUtil;
import ec.com.smx.framework.utilitario.nosql.common.constants.AuditoriaFields;
import ec.com.smx.framework.utilitario.nosql.common.exception.NoSQLException;
import ec.com.smx.framework.utilitario.nosql.common.util.ODocumentUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.EnumClasesArticuloAlcanceNoSql;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloAreaTrabajoBitacoraFields;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloEstablecimientoFields;
import ec.com.smx.sic.cliente.common.nosql.articulo.ArticuloLocalFields;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEstablecimientoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.ArticuloAreaTrabajoNoSqlDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.VistaArticuloLocalNoSqlDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloLocalPrecioVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.resources.SICMessages;

/**
 * 
 * @author wcaiza
 *
 */
public final class ArticuloAlcanceNoSqlUtil implements Logeable {
	
	private ArticuloAlcanceNoSqlUtil () {}
	
	/**
	 * Obtener el nombre del cluster para la clase ArticuloLocalDTO
	 * @param className
	 * @param codigoLocal
	 * @return
	 */
	public static String obtenerNombreClusterArticuloLocal (String className, Integer codigoLocal) {
		return new StringBuilder().append(className).append(codigoLocal).toString();
	}
	
	/**
	 * Obtener el nombre del cluster para la clase ArticuloAreaTrabajoBitacoraDTO
	 * @param className
	 * @param anio
	 * @param numeroMes numero del mes: 0 Enero, 1 Febrero...
	 * @return
	 */
	public static String obtenerNombreClusterArticuloLocalBitacora (String className, Date date) {
		Calendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(date);
		return new StringBuilder().append(className).append(fechaCalendario.get(GregorianCalendar.YEAR)).append(fechaCalendario.get(GregorianCalendar.MONTH)).toString();
	}
	
	/**
	 * Obtener el nombre del cluster para la clase ArticuloEstablecimientoDTO
	 * @param className
	 * @param codigoEstablecimiento
	 * @return
	 */
	public static String obtenerNombreClusterArticuloEstablecimiento (String className, Integer codigoEstablecimiento) {
		return new StringBuilder().append(className).append(codigoEstablecimiento).toString();
	}
	
	/**
	 * Verificar si existe el cluster para la clase ArticuloLocalDTO y crear en caso de no existir
	 * @param db
	 * @param className
	 * @param codigoLocal
	 */
	public static synchronized String validarCrearClusterPorLocal (ODatabaseDocumentTx db, String className, Integer codigoLocal) throws SICException {
		
		try {
			
			String clusterName = obtenerNombreClusterArticuloLocal(className, codigoLocal);
			ODocumentUtil.addClusterToClass(db, className, clusterName);
			return clusterName;
			
		} catch (NoSQLException e) {
			LOG_SICV2.error("Error al validarCrearClusterPorLocal: {}", e.toString());
			throw new SICException(e);
		}
		
	}
	
	/**
	 * Verificar si existe el cluster para la clase ArticuloAreaTrabajoBitacoraDTO y crear en caso de no existir
	 * @param db
	 * @param className
	 * @param clusterName 
	 * @return
	 * @throws SICException
	 */
	public static synchronized void validarCrearClusterArticuloLocalBitacora (ODatabaseDocumentTx db, String className, String clusterName) throws SICException {
		
		try {
			
			ODocumentUtil.addClusterToClass(db, className, clusterName);
			
		} catch (NoSQLException e) {
			LOG_SICV2.error("Error al validarCrearClusterPorLocal: {}", e.toString());
			throw new SICException(e);
		}
		
	}
	
	/**
	 * Verificar si existe el cluster para la clase ArticuloEstablecimientoDTO y crear en caso de no existir
	 * @param db
	 * @param className
	 * @param codigoEstablecimiento
	 */
	public static synchronized String validarCrearClusterPorArticuloEstablecimiento (ODatabaseDocumentTx db, String className, Integer codigoEstablecimiento) throws SICException {
		
		try {
			
			String clusterName = obtenerNombreClusterArticuloEstablecimiento(className, codigoEstablecimiento);
			ODocumentUtil.addClusterToClass(db, className, clusterName);
			return clusterName;
			
		} catch (NoSQLException e) {
			LOG_SICV2.error("Error al validarCrearClusterPorLocal: {}", e.toString());
			throw new SICException(e);
		}
		
	}
	
	public static ODocument generarODocumentMigrarArticuloLocal (VistaArticuloLocalNoSqlDTO vistaArticuloLocalDTO, String sufijoTabla) {
		
		ODocument oDocumentArticuloLocalDTO = new ODocument();
		oDocumentArticuloLocalDTO.setClassName(EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName());
		
		//Clave primaria en DB2
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_COMPANIA, vistaArticuloLocalDTO.getId().getCodigoCompania());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_ARTICULO, vistaArticuloLocalDTO.getId().getCodigoArticulo());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_LOCAL, vistaArticuloLocalDTO.getId().getCodigoLocal());
		
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL, vistaArticuloLocalDTO.getEstadoArticuloLocal());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE, vistaArticuloLocalDTO.getFechaInicialAlcance());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE, vistaArticuloLocalDTO.getFechaFinalAlcance());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.MINIMO_STOCK, vistaArticuloLocalDTO.getMinimoStock());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.MAXIMO_STOCK, vistaArticuloLocalDTO.getMaximoStock());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_REFERENCIA, vistaArticuloLocalDTO.getCodigoReferencia());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_CODIGO_REFERENCIA, vistaArticuloLocalDTO.getEstadoCodigoReferencia());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_INTEGRACION_ALCANCE, vistaArticuloLocalDTO.getEstadoIntegracionAlcance());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ID_USUARIO_ACTIVACION, vistaArticuloLocalDTO.getIdUsuarioActivacion());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_ACTIVACION, vistaArticuloLocalDTO.getFechaActivacion());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ID_USUARIO_INACTIVACION, vistaArticuloLocalDTO.getIdUsuarioInactivacion());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INACTIVACION, vistaArticuloLocalDTO.getFechaInactivacion());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_SISTEMA, vistaArticuloLocalDTO.getCodigoSistema());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_OPCION, vistaArticuloLocalDTO.getCodigoOpcion());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.VALOR_TIPO_ASIGNACION, vistaArticuloLocalDTO.getValorTipoAsignacion());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_TIPO_ASIGNACION, vistaArticuloLocalDTO.getCodigoTipoAsignacion());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.NOTIFICAR_LOCAL, vistaArticuloLocalDTO.getNotificarLocal());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.APERTURA_LOCAL, vistaArticuloLocalDTO.getAperturaLocal());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_TIPO_AREA_TRABAJO, TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO, sufijoTabla);
		
		//Campos de auditoria
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO, BooleanUtils.toBoolean(Integer.valueOf(vistaArticuloLocalDTO.getEstadoArticuloLocal())));
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.USUARIO_REGISTRO, vistaArticuloLocalDTO.getIdUsuarioRegistro());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_REGISTRO, vistaArticuloLocalDTO.getFechaRegistro());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.USUARIO_MODIFICACION, vistaArticuloLocalDTO.getIdUsuarioModificacion());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_MODIFICACION, vistaArticuloLocalDTO.getFechaModificacion());
		

//		if (sufijoTabla.equalsIgnoreCase(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA)
//				|| sufijoTabla.equalsIgnoreCase(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_OFICINA)){
//		//	oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_GRUPO_ALCANCE, -1);
//		}else{
//		//	oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_GRUPO_ALCANCE, vistaArticuloLocalDTO.getCodigoGrupoAlcance());
//		}	
//		
		return oDocumentArticuloLocalDTO;
	}
	
	public static ODocument generarODocumentMigrarArticuloLocalBitacora (ArticuloAreaTrabajoBitacoraDTO articuloAreaTrabajoBitacoraDTO, String sufijoTabla) {
		
		ODocument oDocumentArticuloLocalBitacoraDTO = new ODocument();
		oDocumentArticuloLocalBitacoraDTO.setClassName(EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName());
		
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA, articuloAreaTrabajoBitacoraDTO.getId().getCodigoCompania());
		
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO, articuloAreaTrabajoBitacoraDTO.getCodigoAreaTrabajo());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO, articuloAreaTrabajoBitacoraDTO.getCodigoArticulo());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_SISTEMA, articuloAreaTrabajoBitacoraDTO.getCodigoSistema());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_OPCION, articuloAreaTrabajoBitacoraDTO.getCodigoOpcion());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.ESTADO_ALCANCE, articuloAreaTrabajoBitacoraDTO.getEstadoAlcance());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.USUARIO_ALCANCE, articuloAreaTrabajoBitacoraDTO.getUsuarioAlcance());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_ALCANCE, articuloAreaTrabajoBitacoraDTO.getFechaAlcance());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_INICIAL_ALCANCE, articuloAreaTrabajoBitacoraDTO.getFechaInicialAlcance());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_FIN_ALCANCE, articuloAreaTrabajoBitacoraDTO.getFechaFinalAlcance());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_BITACORA, articuloAreaTrabajoBitacoraDTO.getTipoBitacoraValor());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_TIPO_BITACORA, articuloAreaTrabajoBitacoraDTO.getCodigoTipoBitacora());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_ASIGNACION, articuloAreaTrabajoBitacoraDTO.getTipoAsignacionValor());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_TIPO_ASIGNACION, articuloAreaTrabajoBitacoraDTO.getCodigoTipoAsignacion());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_AREA_TRABAJO, sufijoTabla);
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_TIPO_AREA_TRABAJO, TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		
		//Campos de auditoria
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.ESTADO, BooleanUtils.toBoolean(Integer.valueOf(articuloAreaTrabajoBitacoraDTO.getEstado())));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_REGISTRO, articuloAreaTrabajoBitacoraDTO.getFechaRegistro());
		
		return oDocumentArticuloLocalBitacoraDTO;
	}
	
	public static ODocument generarODocumentMigrarArticuloEstablecimiento (ArticuloEstablecimientoDTO articuloEstablecimientoDTO) {
		
		ODocument oDocumentArticuloEstablecimientoDTO = new ODocument();
		oDocumentArticuloEstablecimientoDTO.setClassName(EnumClasesArticuloAlcanceNoSql.ArticuloEstablecimientoDTO.getName());
		
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.CODIGO_COMPANIA, articuloEstablecimientoDTO.getId().getCodigoCompania());
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO, articuloEstablecimientoDTO.getId().getCodigoArticulo());
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.CODIGO_ESTABLECIMIENTO, articuloEstablecimientoDTO.getId().getCodigoEstablecimiento());
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.ESTADO_ARTICULO_ESTABLECIMIENTO, articuloEstablecimientoDTO.getEstadoArticuloEstablecimiento());
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO_EXTERNO, articuloEstablecimientoDTO.getCodigoArticuloExterno());
		
		//Campos de auditoria
		oDocumentArticuloEstablecimientoDTO.field(ArticuloAreaTrabajoBitacoraFields.ESTADO, BooleanUtils.toBoolean(Integer.valueOf(articuloEstablecimientoDTO.getEstadoArticuloEstablecimiento())));
		oDocumentArticuloEstablecimientoDTO.field(ArticuloAreaTrabajoBitacoraFields.USUARIO_REGISTRO, articuloEstablecimientoDTO.getIdUsuarioRegistro());
		oDocumentArticuloEstablecimientoDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_REGISTRO, articuloEstablecimientoDTO.getFechaRegistro());
		oDocumentArticuloEstablecimientoDTO.field(ArticuloAreaTrabajoBitacoraFields.USUARIO_MODIFICACION, articuloEstablecimientoDTO.getIdUsuarioModificacion());
		oDocumentArticuloEstablecimientoDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_MODIFICACION, articuloEstablecimientoDTO.getFechaModificacion());
		
		return oDocumentArticuloEstablecimientoDTO;
	}
	
	/**
	 * Establece los valores de una plantilla de articulo local previo a la actualizacion o insercion 
	 * @param articuloLocalInsertarActualizar
	 * @param articuloVO
	 */
	@Deprecated
	public static void setearPlantilla(ODocument oDocumentArticuloLocalDTO, ArticuloLocalDTO articuloLocalEnviado, ArticuloVO articuloVO, boolean estadoActivacion){
		
		Date fechaActual = new Date(System.currentTimeMillis());
		
		//Verifica si se va a actualizar un registro existente
		if(articuloLocalEnviado != null){
			//Se setean valores nuevos en el registro consultado a actualizar
//			articuloLocalInsertarActualizar.setFechaInicialAlcance(articuloLocalEnviado.getFechaInicialAlcance());
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE, articuloLocalEnviado.getFechaInicialAlcance());
//			articuloLocalInsertarActualizar.setFechaFinalAlcance(articuloLocalEnviado.getFechaFinalAlcance());
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE, articuloLocalEnviado.getFechaFinalAlcance());
//			articuloLocalInsertarActualizar.setEstadoArticuloLocal(articuloLocalEnviado.getEstadoArticuloLocal()==null? 
//					SICConstantes.ESTADO_INACTIVO_NUMERICO : articuloLocalEnviado.getEstadoArticuloLocal());
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL, 
					articuloLocalEnviado.getEstadoArticuloLocal()==null ? ESTADO_INACTIVO_NUMERICO : articuloLocalEnviado.getEstadoArticuloLocal());
		}
//		articuloLocalInsertarActualizar.setCodigoSistema(articuloVO.getSystemId());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_SISTEMA, articuloVO.getSystemId());
//		articuloLocalInsertarActualizar.setCodigoOpcion(articuloVO.getAccessItemId());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_OPCION, articuloVO.getAccessItemId());
//		articuloLocalInsertarActualizar.setUserId(articuloVO.getUserId());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.USUARIO_REGISTRO, articuloVO.getUserId());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_REGISTRO, fechaActual);
//		articuloLocalInsertarActualizar.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL);
//		articuloLocalInsertarActualizar.setCodigoTipoAsignacion(TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE);
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.VALOR_TIPO_ASIGNACION, TIPO_ASIGNACION_ALCANCE_NORMAL);
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_TIPO_ASIGNACION, TIPO_ASIGNACION_ALCANCE);
//		articuloLocalInsertarActualizar.setEstadoCodigoReferencia(ESTADO_INACTIVO_NUMERICO);
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_CODIGO_REFERENCIA, ESTADO_INACTIVO_NUMERICO);
//		articuloLocalInsertarActualizar.setEstadoIntegracionAlcance(ESTADO_ACTIVO_NUMERICO);
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_INTEGRACION_ALCANCE, ESTADO_ACTIVO_NUMERICO);
		if(estadoActivacion){//si se crea o activa un alcance
//			articuloLocalInsertarActualizar.setIdUsuarioActivacion(articuloVO.getUserId());
//			articuloLocalInsertarActualizar.setFechaActivacion(articuloVO.getFechaAplicacion());
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ID_USUARIO_ACTIVACION, articuloVO.getUserId());
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_ACTIVACION, articuloVO.getFechaAplicacion());
//			if(articuloLocalInsertarActualizar.getFechaInicialAlcance() == null){
			if (oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE) == null) {
//				articuloLocalInsertarActualizar.setFechaInicialAlcance(fechaActual);
				oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE, fechaActual);
			}
		} else if (((Date)(oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE))).compareTo(fechaActual) < 0) { //Si no es un alcance programado
//		} else if (articuloLocalInsertarActualizar.getFechaInicialAlcance().compareTo(fechaActual) < 0) { //Si no es un alcance programado
//				articuloLocalInsertarActualizar.setIdUsuarioInactivacion(articuloVO.getUserId());
//				articuloLocalInsertarActualizar.setFechaInactivacion(articuloVO.getFechaAplicacion());
				oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ID_USUARIO_INACTIVACION, articuloVO.getUserId());
				oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INACTIVACION, articuloVO.getFechaAplicacion());
		}
	}
	
	/**
	 * Retornar la plantilla para dar alcances a bodega y subbodegas (desde ArticuloAlcanceGestor.registrarAlcanceBodegasSubbodega)
	 * @param articuloVO
	 * @param colCodigoAreaTrabajo
	 * @param colCodigoArticulo
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static ArticuloAreaTrabajoNoSqlDTO getPlantillaAlcanceBodegasSubbodega (ArticuloVO articuloVO, Collection<Integer> colCodigoAreaTrabajo, Collection<String> colCodigoArticulo) {
		
		ArticuloAreaTrabajoNoSqlDTO artAreTraNoSql = new ArticuloAreaTrabajoNoSqlDTO();
		artAreTraNoSql.setCodigoCompania(articuloVO.getBaseDTO().getId().getCodigoCompania());
		
		artAreTraNoSql.setSetCodArt(new TreeSet<>(colCodigoArticulo));
		artAreTraNoSql.setSetCodAreTra(new TreeSet<>(colCodigoAreaTrabajo));
		
		artAreTraNoSql.setTipoAreaTrabajo(SICConstantes.SUFIJO_TIPO_AREA_TRABAJO_BODEGA);
		artAreTraNoSql.setTipoAsignacionAlcance(SICMessages.getInstancia().getString("valor.articulo.alcance.asignacion.bodega"));
		artAreTraNoSql.setOpcionAsignacion(SICConstantes.ALCANCE_OPCION_ANADIR);
		
		artAreTraNoSql.setEstadoAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		artAreTraNoSql.setFechaInicialAlcance(articuloVO.getFechaAplicacion());
//		artAreTraNoSql.setCodigoReferencia("");
		artAreTraNoSql.setEstadoCodigoReferencia(SICConstantes.ESTADO_INACTIVO_NUMERICO);
		artAreTraNoSql.setEstadoIntegracionAlcance(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		
		artAreTraNoSql.setIdUsuarioActivacion(articuloVO.getUserId());
		artAreTraNoSql.setFechaActivacion(articuloVO.getFechaAplicacion());
		
		artAreTraNoSql.setCodigoSistema(articuloVO.getSystemId());
		artAreTraNoSql.setCodigoOpcion(articuloVO.getAccessItemId());
		artAreTraNoSql.setValorTipoAsignacion(CorporativoConstantes.TIPO_ASIGNACION_ALCANCE_NORMAL);
		artAreTraNoSql.setCodigoTipoAsignacion(TiposCatalogoConstantes.TIPO_ASIGNACION_ALCANCE);
		
		artAreTraNoSql.setIdUsuario(articuloVO.getUserId());
		artAreTraNoSql.setFechaRegistro(articuloVO.getFechaAplicacion());
		
		return artAreTraNoSql;
	}
	
	public static ODocument generarODocumentRegistarArticuloLocal (String accessItemId,String systemId,
			String codigoArticulo, String cadenaArticuloAreatrabajo, ArticuloVO articuloVO, ArticuloLocalPrecioVO articuloLocalPrecioVO) throws Exception {
		
		//Si la fecha de inicio del alcance es igual a la fecha actual el estado es 1 caso contrario el estado es 0
		String estado = SICConstantes.ESTADO_INACTIVO_NUMERICO;
		
		if(ConverterUtil.parseDateToString(articuloVO.getFechaInicioAlcance()).equals(
				ConverterUtil.parseDateToString(new Date(articuloVO.getFechaAplicacion().getTime())))){
			Logeable.LOG_SICV2.info("La fecha inicio del alcance es igual a la fecha actual");
			estado = ESTADO_ACTIVO_NUMERICO;
		}
		
		ODocument oDocumentArticuloLocalDTO = new ODocument();
		oDocumentArticuloLocalDTO.setClassName(EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName());
		
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_COMPANIA, articuloVO.getCodigoCompania());
//	FIXME	oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_ARTICULO, vistaArticuloLocalDTO.getId().getCodigoArticulo());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_LOCAL, articuloLocalPrecioVO.getLocalDTO().getId().getCodigoAreaTrabajo());
		
		if(articuloVO.getOpcionTipoAsignacionAlcance().equals(SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_ASIGNACION_LOCALES_COPIA)) {
			
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.NOTIFICAR_LOCAL, articuloVO.getNotificarLocal());
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.APERTURA_LOCAL, articuloVO.getEsApertura());
			
		}else{
			
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.NOTIFICAR_LOCAL, articuloLocalPrecioVO.getNotificarLocal());
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.APERTURA_LOCAL, articuloLocalPrecioVO.getAperturaLocal());
			
		}
		
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.VALOR_TIPO_ASIGNACION, TIPO_ASIGNACION_ALCANCE_NORMAL);
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_TIPO_ASIGNACION, TIPO_ASIGNACION_ALCANCE);
		
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_CODIGO_REFERENCIA, ESTADO_ACTIVO_NUMERICO);
		
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_SISTEMA, systemId);
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_OPCION, accessItemId);
		
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL, estado);
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.USUARIO_REGISTRO, articuloVO.getUsuarioAlcance());
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_REGISTRO, articuloVO.getFechaAplicacion());
		
		oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE, ConverterUtil.parseDateToString(articuloVO.getFechaInicioAlcance()));
		
		if (articuloVO.getFechaFinAlcance() != null) {
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE, ConverterUtil.parseDateToString(articuloVO.getFechaFinAlcance()));
		}
		
		if(estado.equals(ESTADO_ACTIVO_NUMERICO)){
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.ID_USUARIO_ACTIVACION, articuloVO.getUsuarioAlcance());
			oDocumentArticuloLocalDTO.field(ArticuloLocalFields.FECHA_ACTIVACION, articuloVO.getFechaAplicacion());
		}
		
		return oDocumentArticuloLocalDTO;
		
	}
	
	public void generarODocumentActivarDesactivarArticuloLocal(ODocument oDocumentArticuloLocalDTO, ArticuloVO articuloVO, 
			String cadenasCodigosArticulos,String cadenaLocales,String cadenaArticuloAreatrabajo, Integer notificarLocal, Integer aperturaLocal) throws SICException {
		
	}
	
	/**
	 * llena el objeto de tipo oDocument para la clase articuloEstablecimientoDTO
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoEstablecimiento
	 * @param estado
	 * @param rid
	 * @return
	 */
	public static ODocument getODocumentArticuloEstablecimiento (Integer codigoCompania,String codigoArticulo,Integer codigoEstablecimiento,Integer estado,
			ArticuloAreaTrabajoNoSqlDTO artAreTraDTO, ORID rid) {
		
		ODocument oDocumentArticuloEstablecimientoDTO;
		if (rid!=null){
			// actualiza
			oDocumentArticuloEstablecimientoDTO = new ODocument(rid);
			oDocumentArticuloEstablecimientoDTO.field(AuditoriaFields.USUARIO_MODIFICACION, artAreTraDTO.getIdUsuario());
			oDocumentArticuloEstablecimientoDTO.field(AuditoriaFields.FECHA_MODIFICACION, artAreTraDTO.getFechaRegistro());
			
		}else{
			// crea
			oDocumentArticuloEstablecimientoDTO = new ODocument(EnumClasesArticuloAlcanceNoSql.ArticuloEstablecimientoDTO.getName());
			oDocumentArticuloEstablecimientoDTO.field(AuditoriaFields.USUARIO_REGISTRO, artAreTraDTO.getIdUsuario());
			oDocumentArticuloEstablecimientoDTO.field(AuditoriaFields.FECHA_REGISTRO, artAreTraDTO.getFechaRegistro());
		}
		
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.CODIGO_COMPANIA, codigoCompania);
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO, codigoArticulo);
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.CODIGO_ESTABLECIMIENTO, codigoEstablecimiento);
		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.ESTADO_ARTICULO_ESTABLECIMIENTO, estado);
//		oDocumentArticuloEstablecimientoDTO.field(ArticuloEstablecimientoFields.CODIGO_ARTICULO_EXTERNO, articuloEstablecimientoDTO.getCodigoArticuloExterno()); TODO
		
		//Campos de auditoria
		oDocumentArticuloEstablecimientoDTO.field(AuditoriaFields.ESTADO, BooleanUtils.toBoolean(estado));
		
		return oDocumentArticuloEstablecimientoDTO;
	}
	
	
	/**
	 * llena el objeto de tipo oDocument para la clase ArticuloLocalDTO
	 * @return ODocument
	 * @author bymontesdeoca
	 */
	public static ODocument getODocumentArticuloAreaTrabajo (String codigoArticulo,Integer codigoAreTra,ArticuloAreaTrabajoNoSqlDTO artAreTraDTO,ORID rid) {
		
		ODocument oDocArtAreTraDTO;
		
		if (rid!=null){
			// actualiza
			oDocArtAreTraDTO = new ODocument(rid);
			oDocArtAreTraDTO.field(AuditoriaFields.USUARIO_MODIFICACION, artAreTraDTO.getIdUsuario());
			oDocArtAreTraDTO.field(AuditoriaFields.FECHA_MODIFICACION, artAreTraDTO.getFechaRegistro());
			
		}else{
			// crea
			oDocArtAreTraDTO = new ODocument(EnumClasesArticuloAlcanceNoSql.ArticuloLocalDTO.getName());
			oDocArtAreTraDTO.field(AuditoriaFields.USUARIO_REGISTRO, artAreTraDTO.getIdUsuario());
			oDocArtAreTraDTO.field(AuditoriaFields.FECHA_REGISTRO, artAreTraDTO.getFechaRegistro());
		}
		
		//Clave primaria en DB2
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_COMPANIA, artAreTraDTO.getCodigoCompania());
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_ARTICULO, codigoArticulo);
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_LOCAL, codigoAreTra);
		
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE, artAreTraDTO.getFechaInicialAlcance());
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE, artAreTraDTO.getFechaFinalAlcance());

		
		oDocArtAreTraDTO.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL, artAreTraDTO.getEstadoAlcance());

		
		
		oDocArtAreTraDTO.field(ArticuloLocalFields.MINIMO_STOCK, artAreTraDTO.getMinimoStock());
		oDocArtAreTraDTO.field(ArticuloLocalFields.MAXIMO_STOCK, artAreTraDTO.getMaximoStock());
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_REFERENCIA, artAreTraDTO.getCodigoReferencia());
		oDocArtAreTraDTO.field(ArticuloLocalFields.ESTADO_CODIGO_REFERENCIA, artAreTraDTO.getEstadoCodigoReferencia());
		oDocArtAreTraDTO.field(ArticuloLocalFields.ESTADO_INTEGRACION_ALCANCE, artAreTraDTO.getEstadoIntegracionAlcance());
		oDocArtAreTraDTO.field(ArticuloLocalFields.ID_USUARIO_ACTIVACION, artAreTraDTO.getIdUsuarioActivacion());
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_ACTIVACION, artAreTraDTO.getFechaActivacion());
		oDocArtAreTraDTO.field(ArticuloLocalFields.ID_USUARIO_INACTIVACION, artAreTraDTO.getIdUsuarioInactivacion());
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_INACTIVACION, artAreTraDTO.getFechaInactivacion());
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_SISTEMA, artAreTraDTO.getCodigoSistema());
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_OPCION, artAreTraDTO.getCodigoOpcion());
		oDocArtAreTraDTO.field(ArticuloLocalFields.VALOR_TIPO_ASIGNACION, artAreTraDTO.getValorTipoAsignacion());
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_TIPO_ASIGNACION, artAreTraDTO.getCodigoTipoAsignacion());
		oDocArtAreTraDTO.field(ArticuloLocalFields.NOTIFICAR_LOCAL, artAreTraDTO.getNotificarLocal());
		//oDocArtAreTraDTO.field(ArticuloLocalFields.APERTURA_LOCAL, artAreTraDTO.getAperturaLocal());
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_TIPO_AREA_TRABAJO, TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		oDocArtAreTraDTO.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO, artAreTraDTO.getTipoAreaTrabajo());
		
		//Campos de auditoria
		oDocArtAreTraDTO.field(ArticuloLocalFields.ESTADO, BooleanUtils.toBoolean(Integer.valueOf(artAreTraDTO.getEstadoAlcance())));
		//oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_GRUPO_ALCANCE, artAreTraDTO.getCodigoGrupoAlcance());
		
		return oDocArtAreTraDTO;
	}
	
	/**
	 * llena el objeto de tipo oDocument para la clase ArticuloLocalDTO
	 * @return ODocument
	 * @author bymontesdeoca
	 */
	public static ODocument getODocumentArticuloAreaTrabajo (String codigoArticulo,Integer codigoAreTra,ODocument artAreTraSaved) {
		
		ODocument oDocArtAreTraDTO;
		
		// actualiza
		oDocArtAreTraDTO = new ODocument(((ODocument)artAreTraSaved.field("rid")).getIdentity());
		oDocArtAreTraDTO.field(ArticuloLocalFields.USUARIO_MODIFICACION, artAreTraSaved.field(ArticuloLocalFields.USUARIO_MODIFICACION));
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_MODIFICACION, artAreTraSaved.field(ArticuloLocalFields.FECHA_MODIFICACION));
		//Clave primaria en DB2
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_COMPANIA, artAreTraSaved.field(ArticuloLocalFields.CODIGO_COMPANIA));
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_ARTICULO, codigoArticulo);
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_LOCAL, codigoAreTra);
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE, artAreTraSaved.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE));
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE, artAreTraSaved.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE));
		oDocArtAreTraDTO.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL, artAreTraSaved.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL));
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_REFERENCIA, artAreTraSaved.field(ArticuloLocalFields.CODIGO_REFERENCIA));
		oDocArtAreTraDTO.field(ArticuloLocalFields.ESTADO_CODIGO_REFERENCIA, artAreTraSaved.field(ArticuloLocalFields.ESTADO_CODIGO_REFERENCIA));
		oDocArtAreTraDTO.field(ArticuloLocalFields.ESTADO_INTEGRACION_ALCANCE, artAreTraSaved.field(ArticuloLocalFields.ESTADO_INTEGRACION_ALCANCE));
		oDocArtAreTraDTO.field(ArticuloLocalFields.ID_USUARIO_ACTIVACION, artAreTraSaved.field(ArticuloLocalFields.ID_USUARIO_ACTIVACION));
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_ACTIVACION, artAreTraSaved.field(ArticuloLocalFields.FECHA_ACTIVACION));
		oDocArtAreTraDTO.field(ArticuloLocalFields.ID_USUARIO_INACTIVACION, artAreTraSaved.field(ArticuloLocalFields.ID_USUARIO_INACTIVACION));
		oDocArtAreTraDTO.field(ArticuloLocalFields.FECHA_INACTIVACION, artAreTraSaved.field(ArticuloLocalFields.FECHA_INACTIVACION));
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_SISTEMA, artAreTraSaved.field(ArticuloLocalFields.CODIGO_SISTEMA));
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_OPCION, artAreTraSaved.field(ArticuloLocalFields.CODIGO_OPCION));
		oDocArtAreTraDTO.field(ArticuloLocalFields.VALOR_TIPO_ASIGNACION, artAreTraSaved.field(ArticuloLocalFields.VALOR_TIPO_ASIGNACION));
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_TIPO_ASIGNACION, artAreTraSaved.field(ArticuloLocalFields.CODIGO_TIPO_ASIGNACION));
		oDocArtAreTraDTO.field(ArticuloLocalFields.NOTIFICAR_LOCAL, artAreTraSaved.field(ArticuloLocalFields.NOTIFICAR_LOCAL));
		oDocArtAreTraDTO.field(ArticuloLocalFields.CODIGO_TIPO_AREA_TRABAJO, TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		oDocArtAreTraDTO.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO, artAreTraSaved.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO));
		
		//Campos de auditoria
		oDocArtAreTraDTO.field(ArticuloLocalFields.ESTADO, BooleanUtils.toBoolean(Integer.valueOf(artAreTraSaved.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL)+"")));
		return oDocArtAreTraDTO;
	}
	
	
	/**
	 * llena el objeto de tipo oDocument para la clase ArticuloAreaTrabajoBitacoraDTO
	 * @param oDocArticuloLocalDTO
	 * @return
	 * @author bymontesdeoca
	 */
	public static ODocument getODocumentBitacoraArticuloAreaTrabajo(ODocument oDocArticuloLocalDTO){
		ODocument oDocumentArticuloLocalBitacoraDTO = new ODocument();
		oDocumentArticuloLocalBitacoraDTO.setClassName(EnumClasesArticuloAlcanceNoSql.ArticuloAreaTrabajoBitacoraDTO.getName());
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_COMPANIA, oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_COMPANIA));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_AREA_TRABAJO, oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_LOCAL));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_ARTICULO, oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_ARTICULO));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_SISTEMA, oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_SISTEMA));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_OPCION, oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_OPCION));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.ESTADO_ALCANCE, oDocArticuloLocalDTO.field(ArticuloLocalFields.ESTADO_ARTICULO_LOCAL));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.USUARIO_ALCANCE, oDocArticuloLocalDTO.field(ArticuloLocalFields.USUARIO_REGISTRO));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_ALCANCE, oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_REGISTRO));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_INICIAL_ALCANCE, oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_INICIAL_ALCANCE));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.FECHA_FIN_ALCANCE, oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_FINAL_ALCANCE));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_BITACORA, SICConstantes.ALCANCE_CATALOGO_VALOR_TIPO_BITACORA_NORMAL);
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_TIPO_BITACORA, SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_BITACORA);
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_ASIGNACION, oDocArticuloLocalDTO.field(ArticuloLocalFields.VALOR_TIPO_ASIGNACION));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_TIPO_ASIGNACION, SICConstantes.ALCANCE_CATALOGO_CODIGO_TIPO_ASIGNACION);
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.VALOR_TIPO_AREA_TRABAJO, oDocArticuloLocalDTO.field(ArticuloLocalFields.VALOR_TIPO_AREA_TRABAJO));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.CODIGO_TIPO_AREA_TRABAJO, TiposCatalogoConstantes.TIPO_AREA_TRABAJO);
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloAreaTrabajoBitacoraFields.RID_ARTICULO_LOCAL, oDocArticuloLocalDTO.getIdentity());
		//oDocumentArticuloLocalBitacoraDTO.field(ArticuloLocalFields.CODIGO_GRUPO_ALCANCE, oDocArticuloLocalDTO.field(ArticuloLocalFields.CODIGO_GRUPO_ALCANCE));
		
		
		//Campos de auditoria
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloLocalFields.ESTADO, oDocArticuloLocalDTO.field(ArticuloLocalFields.ESTADO));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloLocalFields.FECHA_REGISTRO, oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_REGISTRO));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloLocalFields.USUARIO_REGISTRO, oDocArticuloLocalDTO.field(ArticuloLocalFields.USUARIO_REGISTRO));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloLocalFields.USUARIO_MODIFICACION, oDocArticuloLocalDTO.field(ArticuloLocalFields.USUARIO_MODIFICACION));
		oDocumentArticuloLocalBitacoraDTO.field(ArticuloLocalFields.FECHA_MODIFICACION, oDocArticuloLocalDTO.field(ArticuloLocalFields.FECHA_MODIFICACION));
		
		return oDocumentArticuloLocalBitacoraDTO;
	}
	
	/**
	 * metodo q recibe una fecha y retorna un String concatenado el añoMesDia(201582) para la busqueda en los indices para la tarea programada de activar desactivar alcances
	 * @param fecha
	 * @return
	 */
	public static String getFechaAsStringToIndex(Date fecha){
		StringBuilder strFecha=new StringBuilder();
		if (fecha!=null){
			Calendar calendar = Calendar.getInstance(new Locale("es", "ES"));
			calendar.setTime(fecha);
			strFecha.append(calendar.get(Calendar.YEAR));
			strFecha.append((calendar.get(Calendar.MONTH)+1));
			strFecha.append(calendar.get(Calendar.DAY_OF_MONTH));
		}
		return strFecha.toString();
	}

}
