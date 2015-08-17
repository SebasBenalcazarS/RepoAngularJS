/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.validacion;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import ec.com.smx.framework.common.constantes.IApplicationUtilResourceConstant;
import ec.com.smx.framework.common.validator.Validator;
import ec.com.smx.framework.common.validator.ValidatorImpl;
import ec.com.smx.sic.administracion.gestor.IParametroGestor;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.SICParametros;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.proveedor.ProveedorConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloCamposCreacionPorArchivoGestor;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloCreacionPorArchivoDAO;
import ec.com.smx.sic.cliente.persistencia.ordenCompra.restricciones.ClasificacionesPorClasificacionFuncionarioCompradorRestriction;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

/**
 * @author eharo
 *
 */
public class ValidacionArticuloCamposCreacionPorArchivoGestor implements IValidacionArticuloCamposCreacionPorArchivoGestor, Logeable{
	IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO;
	private IParametroGestor parametroGestor;
	
	@Override
	public String validacionesProveedor(Cell celdaExcel, List<String> observaciones, List<HashMap<String, LinkedList<String>>> listaProveedores, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, String[] condicionesProveedor, boolean esFilaValida [], String codigoCabecera) throws SICException {
		String codigoJDEProveedor = StringUtils.EMPTY;
		String codigoProveedor = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, LinkedList<String>> mapProvedores = null;
		LinkedList<String> lstCondicionesProveedor = null;
		try{
			codigoJDEProveedor = (StringUtils.isEmpty(obtenerValorCeldaString(celdaExcel).trim())) ? "" : (new BigDecimal(obtenerValorCeldaString(celdaExcel))).toPlainString();
			codigoJDEProveedor = parsearValor(codigoJDEProveedor);
			if(CollectionUtils.isNotEmpty(listaProveedores)){
				//Agrego el primer mapa de la lista para utilziarlo
				mapProvedores = new HashMap<String, LinkedList<String>>();
				mapProvedores.putAll(listaProveedores.get(0) == null ? new HashMap<String, LinkedList<String>>() : listaProveedores.get(0));
			}else{
				mapProvedores = new HashMap<String, LinkedList<String>>();
			}
			if(!mapProvedores.containsKey(codigoJDEProveedor)){
				codigoProveedor = this.validarExisteProveedor(codigoJDEProveedor, codigoCompania, condicionesProveedor);
				if(StringUtils.isEmpty(StringUtils.trim(codigoProveedor)) || codigoProveedor == null){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoProveedor = codigoJDEProveedor;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					lstCondicionesProveedor = new LinkedList<String>();
					condicionesProveedor[1] = codigoProveedor;
					lstCondicionesProveedor.add(condicionesProveedor[0]);
					lstCondicionesProveedor.add(condicionesProveedor[1]);
					lstCondicionesProveedor.add(condicionesProveedor[2]);
					lstCondicionesProveedor.add(condicionesProveedor[3]);
					mapProvedores.put(codigoJDEProveedor, lstCondicionesProveedor);
					listaProveedores.clear();
					listaProveedores.add(mapProvedores);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}else{
				lstCondicionesProveedor = mapProvedores.get(codigoJDEProveedor);
				codigoProveedor = lstCondicionesProveedor.get(1);
				condicionesProveedor[0] = lstCondicionesProveedor.get(0);
				condicionesProveedor[1] = codigoProveedor;
				condicionesProveedor[2] = lstCondicionesProveedor.get(2);
				condicionesProveedor[3] = lstCondicionesProveedor.get(3);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error en las validaciones de proveedor. {}", e.getMessage());
		}
		return codigoProveedor;
	}
	
	@Override
	public String validacionesClasificacion(Cell celdaExcel, List<String> observaciones, List<HashMap<String, LinkedList<String>>> listaClasificaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, boolean esFilaValida [], String codigoFuncionario, String codigoCabecera, String [] condicionesClasificacion) throws SICException{
		String codigoClasificacion = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		boolean existeClasificacion = Boolean.FALSE;
		HashMap<String, LinkedList<String>> mapClasifiaciones = null;
		LinkedList<String> lstCondicionesClasificacion = null;
		try{
			codigoClasificacion = parsearValor(obtenerValorCeldaString(celdaExcel));
			if(CollectionUtils.isNotEmpty(listaClasificaciones)){
				mapClasifiaciones = new HashMap<String, LinkedList<String>>();
				mapClasifiaciones.putAll(listaClasificaciones.get(0) == null ? new HashMap<String, LinkedList<String>>() : listaClasificaciones.get(0));
			}else{
				mapClasifiaciones = new HashMap<String, LinkedList<String>>();
			}
			if(mapClasifiaciones.containsKey(codigoClasificacion)){
				lstCondicionesClasificacion = mapClasifiaciones.get(codigoClasificacion);
				condicionesClasificacion[0] = codigoClasificacion;
				condicionesClasificacion[1] = lstCondicionesClasificacion.get(1);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}else{
				existeClasificacion = validarExisteClasificacion(codigoClasificacion, codigoCompania, listaClasificaciones, codigoFuncionario, condicionesClasificacion);
				if(existeClasificacion){
					lstCondicionesClasificacion = new LinkedList<String>();
					lstCondicionesClasificacion.add(condicionesClasificacion[0]);
					lstCondicionesClasificacion.add(condicionesClasificacion[1]);
					mapClasifiaciones.put(codigoClasificacion, lstCondicionesClasificacion);
					listaClasificaciones.clear();
					listaClasificaciones.add(mapClasifiaciones);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}else{
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.clasificacion"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Error en las validaciones de clasificacion. {}",e.getMessage());
			throw new SICException(e.getMessage());
		}
		return codigoClasificacion;
	}
	
	@Override
	public String validacionesSubClasificacion(Cell celdaExcel, List<String> observaciones, String clasificacion, Integer numeroFila, Integer numeroColumna, List<MultiKeyMap> listaSubClasificaciones, Integer codigoCompania, boolean[] esFilaValida, String codigoCabecera) throws SICException {
		String observacion = StringUtils.EMPTY;
		String codigoSubClasificacion = StringUtils.EMPTY;
		MultiKeyMap keyMapSubClasificaciones = null;
		boolean existeSubClasificacion = Boolean.FALSE;
		try{
			codigoSubClasificacion = parsearValor(obtenerValorCeldaString(celdaExcel));
			if(CollectionUtils.isNotEmpty(listaSubClasificaciones)){
				keyMapSubClasificaciones = new MultiKeyMap();
				keyMapSubClasificaciones.putAll(listaSubClasificaciones.get(0) == null ? new MultiKeyMap() : listaSubClasificaciones.get(0));
			}else{
				keyMapSubClasificaciones = new MultiKeyMap();
			}
			if(!keyMapSubClasificaciones.containsKey(clasificacion, codigoSubClasificacion)){
				existeSubClasificacion = validarExisteSubClasifiacion(clasificacion, codigoSubClasificacion, codigoCompania);
				if(!existeSubClasificacion){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					keyMapSubClasificaciones.put(clasificacion, codigoSubClasificacion, existeSubClasificacion);
					listaSubClasificaciones.clear();
					listaSubClasificaciones.add(keyMapSubClasificaciones);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}else{
				existeSubClasificacion = (Boolean) keyMapSubClasificaciones.get(clasificacion, codigoSubClasificacion);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en  la validacion de subclasificacion {}", e.getMessage());
		}
		
		return codigoSubClasificacion;
	}

	@Override
	public String validacionesCodigoBarras(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, Set<String> listaCodigosBarras, boolean esFilaValida []) throws SICException {
		String codigoBarras = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		boolean codigoBarrasValido = Boolean.FALSE;
		boolean existeCodigoBarras = Boolean.FALSE;
		try{
			codigoBarras = (StringUtils.isEmpty(obtenerValorCeldaString(celdaExcel).trim())) ? "" : (new BigDecimal(obtenerValorCeldaString(celdaExcel))).toPlainString();//Big Decimal en formato decimal
			if(StringUtils.isNotBlank(codigoBarras)){
					if(!CollectionUtils.exists(listaCodigosBarras, PredicateUtils.equalPredicate(codigoBarras))){
						codigoBarrasValido = validarCodigoEAN(codigoBarras);
						if(codigoBarrasValido){
							existeCodigoBarras = validarExisteCodigoBarras(codigoCompania, codigoBarras);
							if(existeCodigoBarras){
								observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
									      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.codigo.barras"), String.valueOf(numeroFila), numeroColumna);
								LOG_SICV2.error(observacion.substring(4));
								observaciones.add(observacion);
								agregarEsFilaValida(esFilaValida, Boolean.FALSE);
							}else{
								agregarEsFilaValida(esFilaValida, Boolean.TRUE);
								listaCodigosBarras.add(codigoBarras);
							}
						}else{
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
								      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.codigo.barras.ean"), String.valueOf(numeroFila), numeroColumna);
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						}
					}else{
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.codigo.barras.duplicado"), String.valueOf(numeroFila), numeroColumna, codigoBarras);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}
			}else{
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion del codigo de barras {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return codigoBarras;
	}
	
	@Override
	public String validacionesDescripcion(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida []) throws SICException {
		String descripcion = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try{
			descripcion = obtenerValorCeldaString(celdaExcel);
			//Validar que la descripcion no este vacia
			if(StringUtils.isBlank(descripcion)){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
					      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.descripcion"), String.valueOf(numeroFila), numeroColumna);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}
			//Validar que la descripcion no tenga caracteres especiales
			ParametroDTO parametro = parametroGestor.obtenerParametro(SICConstantes.CODIGO_COMPANIA, SICParametros.PARAMETRO_CARACTERES_ESPECIALES_DESCRIPCION_ARTICULO, SICConstantes.getInstancia().CODIGO_SISTEMA_MAX);						
			String fil = parametro.getValorParametro().replace("\\","");
			String[] filtros = fil.split("u");		
			String filtro = "";								
			for(int i = 1; i< filtros.length; i++){
				int hexVal = Integer.parseInt(filtros[i],16);
				filtro += (char)hexVal;			
				Boolean validar = StringUtils.contains(descripcion, filtro);						
				if(validar){				
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							getString("ec.com.smx.sic.articulo.validacion.archivo.columna.descripcion.caracter"), String.valueOf(numeroFila), numeroColumna);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					break;
				}				
				filtro = "";
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la descripcion {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return descripcion;
	}
	
	
	@Override
	public String validacionesFechaInicioFinTemporada(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFechaInicio, boolean esFilaValida [], Map<String, String> codigosCabeceras) throws SICException {
		String fecha = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		String cabecera = StringUtils.EMPTY;
		try{
			fecha = parsearValor(obtenerValorCeldaString(celdaExcel));
			cabecera = esFechaInicio ? codigosCabeceras.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA) : codigosCabeceras.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA);
			if(StringUtils.isBlank(fecha)){
				if(esFechaInicio){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.fecha.inicio.temporada"), String.valueOf(numeroFila), numeroColumna);
				}else{
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.fecha.fin.temporada"), String.valueOf(numeroFila), numeroColumna);
				}
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				if(esFechaValida(fecha, observaciones, numeroFila, numeroColumna, cabecera, esFilaValida)){
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}else{
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la fecha inicio o fin de temporada. {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return fecha;
	}

	private boolean esFechaValida(String fecha, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String cabecera, boolean esFilaValida []){
		boolean esValida = Boolean.TRUE;
		String observacion = StringUtils.EMPTY;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(fecha))){
				SimpleDateFormat formatoFecha = new SimpleDateFormat(IApplicationUtilResourceConstant.FORMAT_DATE);
	            formatoFecha.setLenient(Boolean.FALSE);
	            formatoFecha.parse(fecha);
			}
		} catch(ParseException e) {
            esValida = Boolean.FALSE;
            observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
				      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.validar.formato.fecha"), String.valueOf(numeroFila), numeroColumna, cabecera, IApplicationUtilResourceConstant.FORMAT_DATE);
            observaciones.add(observacion);
            agregarEsFilaValida(esFilaValida, Boolean.FALSE);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar que la fecha sea valida. {}", e.getMessage());
		}
		return esValida;
	}
	
	@Override
	public String validacionesClase(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, Set<String> listaClaseArticulos, Integer codigoCompania, boolean esFilaValida [], String codigoCabecera, Boolean esCreacion) throws SICException {
		String claseArticulo = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		boolean existeClase = Boolean.FALSE;
		try{
			claseArticulo = parsearValor(obtenerValorCeldaString(celdaExcel));
			//Validar que la clase articulo exista
			if (claseArticulo.length() == 1) {
				existeClase = validarExisteClaseArticulo(claseArticulo, codigoCompania, listaClaseArticulos, esCreacion);
			}
			if (existeClase) {
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			} else {
				if (esCreacion) {
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe.mensaje.extra"), String.valueOf(numeroFila), numeroColumna, codigoCabecera, " o no est\u00E1 disponible para la creaci\u00F3n");
				} else {
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe.mensaje.extra"), String.valueOf(numeroFila), numeroColumna, codigoCabecera, "");
				}
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la clase articulo {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return claseArticulo;
	}
	
	@Override
	public String validacionesUnidadManejo(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String empaque, String codigoCabecera) throws SICException {
		String unidadManejo = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		String temp = StringUtils.EMPTY;
		boolean existeUnidadManejo = Boolean.FALSE;
		try{
			
			unidadManejo = obtenerValorCeldaString(celdaExcel);
			int posi = StringUtils.indexOf(unidadManejo, ".");
			temp = StringUtils.substring(unidadManejo, posi, StringUtils.length(unidadManejo));
			
			if(StringUtils.contains(unidadManejo, ".0") && StringUtils.length(temp) == 2){
				unidadManejo = parsearValor(obtenerValorCeldaString(celdaExcel));
				existeUnidadManejo = validarExisteUnidadManejo(unidadManejo);
				if(!existeUnidadManejo){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.unidad.manejo"), String.valueOf(numeroFila), numeroColumna, 0);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else {
					if(StringUtils.equals(empaque, SICArticuloConstantes.getInstancia().TIPOEMPAQUE_PIEZA) || StringUtils.equals(empaque, SICArticuloConstantes.getInstancia().TIPOEMPAQUE_BULTO)
							|| StringUtils.equals(empaque, SICArticuloConstantes.getInstancia().VALOREMPAQUEUNIDAD)){
						if(Integer.valueOf(unidadManejo) != 1){
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
								      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.unidad.manejo.bulto.pieza"), String.valueOf(numeroFila), numeroColumna);
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						}else{
							agregarEsFilaValida(esFilaValida, Boolean.TRUE);
						}
					}else{
						if(Integer.valueOf(unidadManejo) == 1){
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
								      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.unidad.manejo"), String.valueOf(numeroFila), numeroColumna, 1);
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						}else{
							agregarEsFilaValida(esFilaValida, Boolean.TRUE);
						}
					}
					if(StringUtils.length(unidadManejo) > 4){
						validarTamanioEnterosDecimales(codigoCabecera, unidadManejo, 4, 0, observaciones, numeroFila, numeroColumna);
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}else{
						agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}
				}
			}else{
				validarTamanioEnterosDecimales(codigoCabecera, unidadManejo, 4, 0, observaciones, numeroFila, numeroColumna);
			}
			
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la unidad de manejo {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return unidadManejo;
	}

	
	@Override
	public String validacionesEAN14(Cell celdaExcel, List<String> observaciones, String codigoBarras, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, Set<String> listaEAN14, boolean esFilaValida []) throws SICException {
		String ean14 = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		boolean ean14Valido = Boolean.FALSE;
		boolean existeEAN14 = Boolean.FALSE;
		Boolean existeEAN14CodigoBarras = Boolean.FALSE;
		try{
			ean14 = (StringUtils.isEmpty(obtenerValorCeldaString(celdaExcel).trim())) ? "" : (new BigDecimal(obtenerValorCeldaString(celdaExcel))).toPlainString();//Big Decimal en formato decimal
			if(StringUtils.isNotEmpty(StringUtils.trim(ean14))){
				if(StringUtils.equals(ean14, codigoBarras)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.ean.igual.codigo.barras"), String.valueOf(numeroFila), numeroColumna, ean14);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					if(CollectionUtils.exists(listaEAN14, PredicateUtils.equalPredicate(ean14))){
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.ean.duplicado"), String.valueOf(numeroFila), numeroColumna, ean14);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}else{
						ean14Valido = validarCodigoEAN(ean14);
						if(ean14Valido){
							existeEAN14 = creacionPorArchivoDAO.validarEAN14(ean14, codigoCompania);
							if(existeEAN14){
								observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
									      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.ean"), String.valueOf(numeroFila), numeroColumna);
								LOG_SICV2.error(observacion.substring(4));
								observaciones.add(observacion);
								agregarEsFilaValida(esFilaValida, Boolean.FALSE);
							}else{
								existeEAN14CodigoBarras = creacionPorArchivoDAO.validarCodigoBarras(codigoCompania, ean14);
								if(existeEAN14CodigoBarras){
									observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
										      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.ean.duplicado"), String.valueOf(numeroFila), numeroColumna, ean14);
									LOG_SICV2.error(observacion.substring(4));
									observaciones.add(observacion);
									agregarEsFilaValida(esFilaValida, Boolean.FALSE);
									listaEAN14.add(ean14);
								}else{
									agregarEsFilaValida(esFilaValida, Boolean.TRUE);
									listaEAN14.add(ean14);
								}
							}
						}else{
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
								      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.ean.valido"), String.valueOf(numeroFila), numeroColumna);
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						}
					}
				}
			}else {
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion del EAN14 {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return ean14;
	}
	

	public String validacionesCostoMonedaOrigen(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, String origenProveedor, String proveedorImportador, boolean esFilaValida[], LinkedList<String> codigosCabeceras) throws SICException {
		String costoMonedaOrigen = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try {
			if ((StringUtils.equals(origenProveedor, ProveedorConstantes.PROVEEDOR_IMPORTADO)) || (StringUtils.equals(proveedorImportador, ProveedorConstantes.PROVEEDOR_IMPORTADOR_ACTIVO))) {
				costoMonedaOrigen = obtenerValorCeldaString(celdaExcel);
			}
			if ((StringUtils.equals(origenProveedor, ProveedorConstantes.PROVEEDOR_IMPORTADO) || StringUtils.equals(proveedorImportador, SICConstantes.ESTADO_ACTIVO_NUMERICO)) && StringUtils.isEmpty(StringUtils.trim(costoMonedaOrigen))) {
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.otro.campo.requerido"), String.valueOf(numeroFila), numeroColumna, codigosCabeceras.get(1), codigosCabeceras.get(0));
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			} else {
				validarTamanioEnterosDecimales(codigosCabeceras.get(1), costoMonedaOrigen, 10, 4, observaciones, numeroFila, numeroColumna);
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en la validacion del costo moneda origen {}", e.getMessage());
			// throw new SICException(e.getMessage());
		}
		return costoMonedaOrigen;
	}
	

	@Override
	public String validacionesTamanio(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException {
		String tamanio = StringUtils.EMPTY;		
		try{
			tamanio = parsearValor(obtenerValorCeldaString(celdaExcel));
			if(validarCaracteristicaDinamica(tamanio, numeroFila, numeroColumna, codigoCabecera, EnumCaracteristicaDinamica.CARACTERISTICA_TIENEPRESENTACIONES, observaciones, esFilaValida)){
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion del tamanio {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return tamanio;
	}
	

	@Override
	public String validacionesMarca(Cell celdaExcel, List<MultiKeyMap> listaMarcas, List<String> observaciones, Integer codigoCompania, Integer numeroFila, Integer numeroColumna, String codigoProveedor, boolean esFilaValida [], LinkedList<String> codigosCabeceras) throws SICException {
		String nombreMarca = StringUtils.EMPTY;
		String secuencialMarca = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		MultiKeyMap mapMarcas = null;
		try{
			nombreMarca = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaMarcas)){
				mapMarcas = new MultiKeyMap();
				mapMarcas.putAll(listaMarcas.get(0) == null ? new HashMap<String, String>() : listaMarcas.get(0));
			}else{
				mapMarcas = new MultiKeyMap();
			}
			if(!mapMarcas.containsKey(nombreMarca)){
				if(StringUtils.isNotEmpty(codigoProveedor)){
					secuencialMarca = creacionPorArchivoDAO.validarExisteMarca(codigoCompania, nombreMarca, codigoProveedor);
				}else{
					secuencialMarca = StringUtils.EMPTY;
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.celda.vacia"), String.valueOf(numeroFila), numeroColumna, codigosCabeceras.get(0), indiceAlfabeticoColumna(numeroColumna).concat(String.valueOf(numeroFila)));
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					secuencialMarca = nombreMarca;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}
				if(secuencialMarca == null || StringUtils.isEmpty(secuencialMarca) 
						|| StringUtils.equals(secuencialMarca, "null") || StringUtils.equals(secuencialMarca, nombreMarca)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe.mensaje.extra"), String.valueOf(numeroFila), numeroColumna, codigosCabeceras.get(1), " o el proveedor "+ codigoProveedor +" no posee la Marca " + nombreMarca);
					LOG_SICV2.error(observacion.substring(5));
					observaciones.add(observacion);
					secuencialMarca = nombreMarca;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					mapMarcas.put(nombreMarca, codigoProveedor, secuencialMarca);
					
					listaMarcas.clear();
					listaMarcas.add(mapMarcas);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}else{
				secuencialMarca = String.valueOf(mapMarcas.get(nombreMarca, codigoProveedor));
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en las validaciones de la marca. {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return secuencialMarca;
	}

	@Override
	public String validacionesMarcaParticipacion(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida []) throws SICException {
		String maracaParticipacion = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try{
			if(celdaExcel.getCellType() == Cell.CELL_TYPE_NUMERIC){
				maracaParticipacion = parsearValor(obtenerValorCeldaString(celdaExcel));
			}else{
				maracaParticipacion = obtenerValorCeldaString(celdaExcel);
			}
			
			//Validar que la descripcion no este vacia
			if(StringUtils.length(StringUtils.trim(maracaParticipacion)) > 1){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
					      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.marca.participacion"), String.valueOf(numeroFila), numeroColumna);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en las validaciones de la marca participacion {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return maracaParticipacion;
	}

	@Override
	public String validacionesGarantia(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException {
		String garantia = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;	
		try{
			garantia = parsearValor(obtenerValorCeldaString(celdaExcel));
			//Validar que la descripcion no este vacia
			if(StringUtils.length(StringUtils.trim(garantia)) > 2){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
					      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.descripcion"), String.valueOf(numeroFila), numeroColumna);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				if(validarCaracteristicaDinamica(garantia, numeroFila, numeroColumna, codigoCabecera, EnumCaracteristicaDinamica.CARACTERISTICA_TIENEGARANTIA, observaciones, esFilaValida)){
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la garantia. {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return garantia;
	}

	@Override
	public String validacionesReferencia(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida []) throws SICException {
		String referencia = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try{
			referencia = setearValorCelda(obtenerValorCeldaString(celdaExcel));
			if(StringUtils.isEmpty(referencia)){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
					      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.referencia"), String.valueOf(numeroFila), numeroColumna);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la referencia {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return referencia;
	}
	@Override
	public String validacionesReferenciaInterna(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean[] esFilaValida) throws SICException {
		String referenciaInterna = StringUtils.EMPTY;		
		try{
			referenciaInterna = setearValorCelda(obtenerValorCeldaString(celdaExcel));
			if(StringUtils.isNotEmpty(referenciaInterna)){				
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la referencia interna {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return referenciaInterna;
	}
	@Override
	public String validacionesAlcancePrototipo(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaAlcancePrototipo, Integer numeroFila, Integer numeroColumna, Integer codigoCompania, boolean esFilaValida [], String codigoCabecera , boolean omisionValidacionAlcances) throws SICException {
		String alcancePrototipo = StringUtils.EMPTY;
		String nombreGrupoTrabajo = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapAlcancesPrototipos = null;
		try{
			nombreGrupoTrabajo = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaAlcancePrototipo)){
				mapAlcancesPrototipos = new HashMap<String, String>();
				mapAlcancesPrototipos.putAll(listaAlcancePrototipo.get(0) == null ? new HashMap<String, String>() : listaAlcancePrototipo.get(0));
			}else{
				mapAlcancesPrototipos = new HashMap<String, String>();
			}
			if(!mapAlcancesPrototipos.containsKey(nombreGrupoTrabajo)){
				alcancePrototipo = creacionPorArchivoDAO.validarExisteAlcancePrototipo(codigoCompania, nombreGrupoTrabajo, SICArticuloConstantes.getInstancia().ASIGNACION_TIPO_GRUPO_TRABAJO);
				
				if(((alcancePrototipo == null || StringUtils.isEmpty(alcancePrototipo) || StringUtils.equals(alcancePrototipo, "null")) && !omisionValidacionAlcances)
						|| (StringUtils.equals(alcancePrototipo, nombreGrupoTrabajo) && StringUtils.isNotBlank(alcancePrototipo)) ){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					alcancePrototipo = nombreGrupoTrabajo;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					
				}else if(validarPrototipoAlcancePersonalizado(nombreGrupoTrabajo, alcancePrototipo, observaciones, numeroFila, numeroColumna, esFilaValida, codigoCabecera)) {
					mapAlcancesPrototipos.put(nombreGrupoTrabajo, alcancePrototipo);
					listaAlcancePrototipo.clear();
					listaAlcancePrototipo.add(mapAlcancesPrototipos);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}else{
				alcancePrototipo = mapAlcancesPrototipos.get(nombreGrupoTrabajo);
				if(validarPrototipoAlcancePersonalizado(nombreGrupoTrabajo, alcancePrototipo, observaciones, numeroFila, numeroColumna, esFilaValida, codigoCabecera)) {
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de los prototipos alcance {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}finally{
			mapAlcancesPrototipos = null;
		}
		return alcancePrototipo;
	}
	
	/**
	 * Valida si el prototipo de Alcance es Personalizado
	 * @param alcancePrototipo C\u00F3digo del Alcance
	 * @param observaciones Lista de observaciones con los errores de validaci\u00F3n
	 * @param numeroFila N\u00FAmero de la Fila que se esta validando
	 * @param numeroColumna N\u00FAmero de la columna que se esta validando
	 * @param esFilaValida Para la validacion del campo
	 * @return
	 */
	private Boolean validarPrototipoAlcancePersonalizado(String nombreGrupoTrabajo, String alcancePrototipo, List<String> observaciones, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) {
		String observacion = StringUtils.EMPTY;
		if(!alcancePrototipo.equals(SICArticuloConstantes.CODIGO_PROTOTIPO_ALCANCE_PERSONALIZADO.toString()))
		{
			return Boolean.TRUE;
		}
		
		observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
				      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.alcance.prototipox"), String.valueOf(numeroFila), numeroColumna, codigoCabecera, nombreGrupoTrabajo);
		LOG_SICV2.error(observacion.substring(4));
		observaciones.add(observacion);
		agregarEsFilaValida(esFilaValida, Boolean.FALSE);
		return Boolean.FALSE;
	}

	@Override
	public String validacionesAgrupador(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaAgrupadores, Integer numeroFila, Integer numeroColumna, boolean esFilaValida [], String codigoCabecera) throws SICException {
		String codigoAgrupador = StringUtils.EMPTY;
		String nombreAgrupador = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapAgrupadores = null;
		try{
			nombreAgrupador = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaAgrupadores)){
				mapAgrupadores = new HashMap<String, String>();
				mapAgrupadores.putAll(listaAgrupadores.get(0) == null ? new HashMap<String, String>() : listaAgrupadores.get(0));
			}else{
				mapAgrupadores = new HashMap<String, String>();
			}
			if(!mapAgrupadores.containsKey(nombreAgrupador)){
				codigoAgrupador = creacionPorArchivoDAO.validarExisteAgrupador(nombreAgrupador);
				if(codigoAgrupador == null || StringUtils.isEmpty(codigoAgrupador) 
						|| StringUtils.equals(codigoAgrupador, "null") || StringUtils.equals(codigoAgrupador, nombreAgrupador)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoAgrupador = nombreAgrupador;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					mapAgrupadores.put(nombreAgrupador, codigoAgrupador);
					listaAgrupadores.clear();
					listaAgrupadores.add(mapAgrupadores);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}else{
				codigoAgrupador = mapAgrupadores.get(nombreAgrupador);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el agrupador. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar el agrupador. {}",e.getMessage());
		}finally{
			mapAgrupadores = null;
		}
		return codigoAgrupador;
	}

	@Override
	public String validacionesCostoBruto(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException {
		String costoBruto = StringUtils.EMPTY;
		try{
			costoBruto = obtenerValorCeldaString(celdaExcel);
			validarTamanioEnterosDecimales(nombreCampo,costoBruto, maxEnteros, maxDecimales, observaciones, numeroFila, numeroColumna);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de costo bruto {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return costoBruto;
	}

	@Override
	public String validacionesDescuentos(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException {
		String descuento = StringUtils.EMPTY;
		try{
			descuento = obtenerValorCeldaString(celdaExcel);
			validarTamanioEnterosDecimales(nombreCampo,descuento, maxEnteros, maxDecimales, observaciones, numeroFila, numeroColumna);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en validacion de descuento {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return descuento;
	}

	@Override
	public String validacionesPrecios(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException {
		String descuento = StringUtils.EMPTY;
		try{
			descuento = obtenerValorCeldaString(celdaExcel);
			if(StringUtils.isNotEmpty(StringUtils.trim(descuento))){
				validarTamanioEnterosDecimales(nombreCampo, descuento, maxEnteros, maxDecimales, observaciones, numeroFila, numeroColumna);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de precios {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return descuento;
	}

	@Override
	public String validacionesMedidas(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales, String codigoCabecera) throws SICException{
		String medida = StringUtils.EMPTY;		
		try{
			medida = obtenerValorCeldaString(celdaExcel);
			if(validarCaracteristicaDinamica(medida, numeroFila, numeroColumna, codigoCabecera, EnumCaracteristicaDinamica.CARACTERISTICA_TIENEPRESENTACIONES, observaciones, esFilaValida)){
				validarTamanioEnterosDecimales(nombreCampo, medida, maxEnteros, maxDecimales, observaciones, numeroFila, numeroColumna);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la medida. {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return medida;
	}
	
	@Override
	public String validacionesEmpaque(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaEmpaques, Integer numeroFila, Integer numeroColumna,  boolean[] esFilaValida, String codigoCabecera) throws SICException {
		String empaque = StringUtils.EMPTY;
		String codigoEmpaque = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapEmpaques = null;
		
		try{
			empaque = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaEmpaques)){
				mapEmpaques = new HashMap<String, String>();
				mapEmpaques.putAll(listaEmpaques.get(0) == null ? new HashMap<String, String>() : listaEmpaques.get(0));
			}else{
				mapEmpaques = new HashMap<String, String>();
			}
			
			if(!mapEmpaques.containsKey(empaque)){
				codigoEmpaque = creacionPorArchivoDAO.validarExisteEmpaque(empaque);
				if(codigoEmpaque == null || StringUtils.isEmpty(codigoEmpaque)
						|| StringUtils.equals(codigoEmpaque, "null") || StringUtils.equals(codigoEmpaque, empaque)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoEmpaque = empaque;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					mapEmpaques.put(empaque, codigoEmpaque);
					listaEmpaques.clear();
					listaEmpaques.add(mapEmpaques);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}else{
				codigoEmpaque = mapEmpaques.get(empaque);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el empaque. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar el empaque. {}",e.getMessage());
		}finally{
			mapEmpaques = null;
		}
		return codigoEmpaque;
	}

	@Override
	public String validacionesImportancia(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaImportancias, Integer codigoCompania, Integer numeroFila, Integer numeroColumna, boolean[] esFilaValida, String codigoCabecera) throws SICException {
		String codigoImportancia = StringUtils.EMPTY;
		String nombreImportancia = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapImportancias = null;
		try{
			nombreImportancia = obtenerValorCeldaString(celdaExcel);
			if(StringUtils.length(nombreImportancia) > 1){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
					      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.maximo.caracteres"), String.valueOf(numeroFila), numeroColumna, codigoCabecera, 1);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				codigoImportancia = nombreImportancia;
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			} else {
				if(CollectionUtils.isNotEmpty(listaImportancias)){
					mapImportancias = new HashMap<String, String>();
					mapImportancias.putAll(listaImportancias.get(0) == null ? new HashMap<String, String>() : listaImportancias.get(0));
				}else{
					mapImportancias = new HashMap<String, String>();
				}
				
				if(!mapImportancias.containsKey(nombreImportancia)){
					if(StringUtils.isEmpty(StringUtils.trim(nombreImportancia))){
						codigoImportancia = null;
						agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}else{
						codigoImportancia = creacionPorArchivoDAO.validarExisteImportancia(codigoCompania, nombreImportancia);
						if(codigoImportancia == null || StringUtils.equals(codigoImportancia, "null") || StringUtils.equals(codigoImportancia, nombreImportancia)){
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
								      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							codigoImportancia = nombreImportancia;
							agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						}else{
							mapImportancias.put(nombreImportancia, codigoImportancia);
							listaImportancias.clear();
							listaImportancias.add(mapImportancias);
							agregarEsFilaValida(esFilaValida, Boolean.TRUE);
						}
					}
					
				}else{
					codigoImportancia = mapImportancias.get(nombreImportancia);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}
			
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar la importancia. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar la importancia. {}",e.getMessage());
		}finally{
			mapImportancias = null;
		}
		return codigoImportancia;
	}
	
	@Override
	public String validacionesPlazoPago(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaPlazosPagos, Integer codigoCompania, Integer numeroFila, Integer numeroColumna, boolean[] esFilaValida, String codigoCabecera) throws SICException {
		String codigoPlazoPago = StringUtils.EMPTY;
		String plazoPago = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapPlazoPago = null;
		try{
			plazoPago = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaPlazosPagos)){
				mapPlazoPago = new HashMap<String, String>();
				mapPlazoPago.putAll(listaPlazosPagos.get(0) == null ? new HashMap<String, String>() : listaPlazosPagos.get(0));
			}else{
				mapPlazoPago = new HashMap<String, String>();
			}
			
			if(!mapPlazoPago.containsKey(plazoPago)){
				codigoPlazoPago = creacionPorArchivoDAO.validarExistePlazoPago(plazoPago);
				if(codigoPlazoPago == null || StringUtils.isEmpty(codigoPlazoPago)
						|| StringUtils.equals(codigoPlazoPago, "null") || StringUtils.equals(codigoPlazoPago, plazoPago)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoPlazoPago = plazoPago;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					mapPlazoPago.put(plazoPago, codigoPlazoPago);
					listaPlazosPagos.clear();
					listaPlazosPagos.add(mapPlazoPago);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}else{
				codigoPlazoPago = mapPlazoPago.get(plazoPago);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar los plazos de pagos. {}", e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar los plazos de pagos. {}",e.getMessage());
		}finally{
			mapPlazoPago = null;
		}
		return codigoPlazoPago;
	}

	@Override
	public String validacionesUnidadMedida(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaUnidadMedida, Integer numeroFila, Integer numeroColumna, String nombreCampo, String [] condicionesUnidadMedida, boolean[] esFilaValida) throws SICException {
		String codigoUnidadMediad = StringUtils.EMPTY;
		String unidadMedida = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapUnidadesMedida = null;
		try{
			unidadMedida = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaUnidadMedida)){
				mapUnidadesMedida = new HashMap<String, String>();
				mapUnidadesMedida.putAll(listaUnidadMedida.get(0) == null ? new HashMap<String, String>() : listaUnidadMedida.get(0));
			}else {
				mapUnidadesMedida = new HashMap<String, String>();
			}
			if(!mapUnidadesMedida.containsKey(unidadMedida)){
				if(validarCaracteristicaDinamica(unidadMedida, numeroFila, numeroColumna, nombreCampo, EnumCaracteristicaDinamica.CARACTERISTICA_TIENEPRESENTACIONES, observaciones, esFilaValida)){
					codigoUnidadMediad = creacionPorArchivoDAO.validarExisteUnidadMedida(unidadMedida, condicionesUnidadMedida);
					if(codigoUnidadMediad == null || StringUtils.isEmpty(codigoUnidadMediad) || StringUtils.equals(codigoUnidadMediad, "null")){
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, nombreCampo);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}else{
						mapUnidadesMedida.put(unidadMedida, condicionesUnidadMedida[1]);
						listaUnidadMedida.clear();
						listaUnidadMedida.add(mapUnidadesMedida);
						agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}
				}
			}else{
				condicionesUnidadMedida[1] = mapUnidadesMedida.get(unidadMedida);
				codigoUnidadMediad = unidadMedida;
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar las unidades de medida. {}", e.getMessage());
//			throw new SICException("Error al validar las unidades de medida. {}", e.getMessage()); 
		}finally{
			mapUnidadesMedida = null;
		}
		return codigoUnidadMediad;
	}

	@Override//TODO
	public String validacionesVentaPrecioAfiliado(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, String parametroIngresoDatos, boolean[] esFilaValida) throws SICException {
		String ventaPrecioAfiliado = StringUtils.EMPTY;
		String celdaVentaPrecioAfiliado = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try{
			celdaVentaPrecioAfiliado = obtenerValorCeldaString(celdaExcel);
			if(StringUtils.length(StringUtils.trim(celdaVentaPrecioAfiliado)) > 1){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
					      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.tamanio.maximo.mensaje.extra"), String.valueOf(numeroFila), numeroColumna, "campo ".concat(nombreCampo), " 1 caracter");
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				celdaVentaPrecioAfiliado = StringUtils.upperCase(celdaVentaPrecioAfiliado);
				if (StringUtils.isNotEmpty(StringUtils.trim(celdaVentaPrecioAfiliado))) {
					if(StringUtils.equals(celdaVentaPrecioAfiliado, "S")){
						ventaPrecioAfiliado = String.valueOf(Boolean.TRUE);
						agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}else if(StringUtils.equals(celdaVentaPrecioAfiliado, "N")){
						ventaPrecioAfiliado = String.valueOf(Boolean.FALSE);
						agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}else{
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, nombreCampo);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
					}
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar la venta a precio solo afiliado. {}", e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar la venta a precio solo afiliado. {}",e.getMessage());
		}
		return ventaPrecioAfiliado;
	}

	@Override
	public String validacionesControlPrecios(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaControlPrecios, Integer numeroFila, Integer numeroColumna, boolean[] esFilaValida, String tipoSecuencia, String codigoCabecera) throws SICException {
		String controlPrecios = StringUtils.EMPTY;
		String codigoControlPrecios = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapControlPrecios = null;
		try{
			controlPrecios = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaControlPrecios)){
				mapControlPrecios = new HashMap<String, String>();
				mapControlPrecios.putAll(listaControlPrecios.get(0) == null ? new HashMap<String, String>() : listaControlPrecios.get(0));
			}else{
				mapControlPrecios = new HashMap<String, String>();
			}
			if(!mapControlPrecios.containsKey(controlPrecios)){
				codigoControlPrecios = creacionPorArchivoDAO.validarExisteControlPrecios(controlPrecios);
				if(codigoControlPrecios == null || StringUtils.isEmpty(codigoControlPrecios)
						|| StringUtils.equals(codigoControlPrecios, "null") || StringUtils.equals(codigoControlPrecios, controlPrecios)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoControlPrecios = controlPrecios;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					if(StringUtils.equals(tipoSecuencia, SICArticuloConstantes.getInstancia().TIPSECART_PESOFIJO) 
							&& !StringUtils.equals(codigoControlPrecios, SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE)){
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.control.costos.secuencia"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
						codigoControlPrecios = controlPrecios;
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}else if(StringUtils.equals(tipoSecuencia, SICArticuloConstantes.getInstancia().TIPSECART_PESOPRECIO) 
							&& StringUtils.equals(codigoControlPrecios, SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE)){
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.control.costos.secuencia"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
						codigoControlPrecios = controlPrecios;
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}else{
						mapControlPrecios.put(controlPrecios, codigoControlPrecios);
						listaControlPrecios.clear();
						listaControlPrecios.add(mapControlPrecios);
						agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}
				}
			}else{
				codigoControlPrecios = mapControlPrecios.get(controlPrecios);
				if(StringUtils.equals(tipoSecuencia, SICArticuloConstantes.getInstancia().TIPSECART_PESOFIJO) 
						&& !StringUtils.equals(codigoControlPrecios, SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.control.costos.secuencia"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoControlPrecios = controlPrecios;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else if(StringUtils.equals(tipoSecuencia, SICArticuloConstantes.getInstancia().TIPSECART_PESOPRECIO) 
						&& StringUtils.equals(codigoControlPrecios, SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.control.costos.secuencia"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoControlPrecios = controlPrecios;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el control de precios. {}", e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar el control de precios. {}", e.getMessage());
		}finally{
			mapControlPrecios = null;
		}
		return codigoControlPrecios;
	}

	@Override
	public String validacionesDuracionConservacion(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException {
		String duracion = StringUtils.EMPTY;
		try{
			duracion = parsearValor(obtenerValorCeldaString(celdaExcel));
			validarTamanioEnterosDecimales(nombreCampo, duracion, maxEnteros, maxDecimales, observaciones, numeroFila, numeroColumna);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de duracion conservacion {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return duracion;
	}

	@Override
	public String validacionesLugarCompra(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaLugaresCompra, Integer codigoCompania, Integer numeroFila, Integer numeroColumna, boolean[] esFilaValida, String codigoCabecera, String codigoDivGeoPol) throws SICException {
		String codigoLugarCompra = StringUtils.EMPTY;
		String nombreLugarCompra = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapLugaresCompra = null;
		try{
			nombreLugarCompra = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaLugaresCompra)){
				mapLugaresCompra = new HashMap<String, String>();
				mapLugaresCompra.putAll(listaLugaresCompra.get(0) == null ? new HashMap<String, String>() : listaLugaresCompra.get(0));
			}else{
				mapLugaresCompra = new HashMap<String, String>();
			}
			//Se verifica si anteriormente no se ha revisado, ese lugar de compra
			if(!mapLugaresCompra.containsKey(nombreLugarCompra)){
				//Verificamos si el lugar de compra existe en la base de datos
				codigoLugarCompra = creacionPorArchivoDAO.validarExisteLugarCompra(nombreLugarCompra, codigoCompania);
				//Si no existe el lugar de compra agregamos una observacion
				if(codigoLugarCompra == null || StringUtils.isEmpty(codigoLugarCompra)
						|| StringUtils.equals(codigoLugarCompra, "null") || StringUtils.equals(codigoLugarCompra, nombreLugarCompra)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoLugarCompra = nombreLugarCompra;
					//No es una fila valida
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else if(this.esLugarCompraExteriorYPaisEcuador(codigoDivGeoPol, codigoLugarCompra, observaciones, numeroFila, numeroColumna, codigoCabecera)) {
					codigoLugarCompra = nombreLugarCompra;
					//No es una fila valida
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				} else {
					mapLugaresCompra.put(nombreLugarCompra, codigoLugarCompra);
					listaLugaresCompra.clear();
					listaLugaresCompra.add(mapLugaresCompra);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			} else {
				//Si el c\u00F3digo del lugar ya fue consultado, obtenemos del mapa
				codigoLugarCompra = mapLugaresCompra.get(nombreLugarCompra);
				//Si el codigo del pa\u00EDs de fabricaci\u00F3n es Ecuador, debe ser el lugar de compra Ecuador
				if(this.esLugarCompraExteriorYPaisEcuador(codigoDivGeoPol, codigoLugarCompra, observaciones, numeroFila, numeroColumna, codigoCabecera)) {
					codigoLugarCompra = nombreLugarCompra;
					//No es una fila valida
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				} else {
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el lugar de compra. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar el lugar de compra. {}",e.getMessage());
		}finally{
			mapLugaresCompra = null;
		}
		return codigoLugarCompra;
	}
	
	/**
	 * Valida:
	 * Si lugar de compra es exterior y el pa\u00EDs de fabricaci\u00F3n es Ecuador, no es valido 
	 * Si lugar de compra es exterior y el pa\u00EDs de fabricaci\u00F3n no es Ecuador, es valido
	 * Si lugar de compra es Ecuador y el pa\u00EDs de fabricaci\u00F3n no es Ecuador, es valido
	 * @author bcueva
	 * @param codigoDivGeoPol C\u00F3digo del pa\u00EDs
	 * @param codigoLugarCompra C\u00F3digo del lugar de compra
	 * @param observaciones Lista de Observaciones, de errores del documento
	 * @param numeroFila N\u00FAmero de la fila que se esta validando
	 * @param numeroColumna N\u00FAmero de la columna que se esta validando
	 * @param codigoCabecera C\u00F3digo de la cabecera que se esta validando
	 * @return
	 */
	private Boolean esLugarCompraExteriorYPaisEcuador(String codigoDivGeoPol, String codigoLugarCompra, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String codigoCabecera) {
		String observacion = StringUtils.EMPTY;
		//Si el c\u00F3digo del pa\u00EDs es Ecuador y el c\u00F3digo del lugar de compra no es Ecuador
		if(codigoDivGeoPol.equals(SICArticuloConstantes.PAISORIGEN_OMISION) && !codigoLugarCompra.equals(SICArticuloConstantes.CODIGO_LUGAR_COMPRA_ECUADOR.toString())) {
			//Se registra el error
			observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.lugar.compra.no.pais.origen"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
			LOG_SICV2.error(observacion.substring(4));
			//Se agrega a la lista de observaciones
			observaciones.add(observacion);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public String validacionesPaisOrigen(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaPaisOrigen, Integer numeroFila, Integer numeroColumna, boolean[] esFilaValida, String codigoCabecera) throws SICException {
		String codigoPaisOrigen = StringUtils.EMPTY;
		String nombrePais = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapPaisOrigen = null;
		try{
			nombrePais = StringUtils.upperCase(obtenerValorCeldaString(celdaExcel));
			if(CollectionUtils.isNotEmpty(listaPaisOrigen)){
				mapPaisOrigen = new HashMap<String, String>();
				mapPaisOrigen.putAll(listaPaisOrigen.get(0) == null ? new HashMap<String, String>() : listaPaisOrigen.get(0));
			}else{
				mapPaisOrigen = new HashMap<String, String>();
			}
			
			if (mapPaisOrigen.containsKey(nombrePais)) {
				codigoPaisOrigen = mapPaisOrigen.get(nombrePais);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			} else {
				codigoPaisOrigen = creacionPorArchivoDAO.validarExistePaisOrigen(nombrePais);
				if(codigoPaisOrigen == null || StringUtils.isEmpty(codigoPaisOrigen)
						|| StringUtils.equals(codigoPaisOrigen, "null")){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoPaisOrigen = nombrePais;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					mapPaisOrigen.put(nombrePais, codigoPaisOrigen);
					listaPaisOrigen.clear();
					listaPaisOrigen.add(mapPaisOrigen);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el pais de origen. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar el pais de origen. {}",e.getMessage());
		}finally{
			mapPaisOrigen = null;
		}
		return codigoPaisOrigen;
	}

	@Override
	public String validacionesPesoAproximado(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales, String controlPrecio, String codigoCabecera) throws SICException {
		String pesoAprox = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try{
			pesoAprox = obtenerValorCeldaString(celdaExcel);
			if((!StringUtils.equals(controlPrecio, SICArticuloConstantes.getInstancia().TIPCONCOS_PIEPIE) && !StringUtils.equals(controlPrecio, SICArticuloConstantes.getInstancia().TIPCONCOS_PESPES)) && StringUtils.isEmpty(StringUtils.trim(pesoAprox))){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
					      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.otro.campo.requerido"), String.valueOf(numeroFila), numeroColumna, nombreCampo, codigoCabecera);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				validarTamanioEnterosDecimales(nombreCampo, pesoAprox, maxEnteros, maxDecimales, observaciones, numeroFila, numeroColumna);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el peso aproximado {}. {}", nombreCampo, e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar el peso aproximado {}. {}", nombreCampo, e.getMessage());
		}
		return pesoAprox;
	}

	@Override
	public String validacionesPresentacion(Cell celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean esFilaValida [], Integer maxEnteros, Integer maxDecimales) throws SICException {
		String presentacion = StringUtils.EMPTY;
		try{
			presentacion = parsearValor(obtenerValorCeldaString(celdaExcel));
			validarTamanioEnterosDecimales(nombreCampo, presentacion, maxEnteros, maxDecimales, observaciones, numeroFila, numeroColumna);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de la presentacion. {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return presentacion;
	}

	@Override
	public String validacionesTransgenico(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaTransgenicos, Integer numeroFila, Integer numeroColumna, boolean[] esFilaValida, String codigoCabecera) throws SICException {
		String codigoTransgenico = StringUtils.EMPTY;
		String transgenico = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapTrangenicos = null;
		try{
			transgenico = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaTransgenicos)){
				mapTrangenicos = new HashMap<String, String>();
				mapTrangenicos.putAll(listaTransgenicos.get(0) == null ? new HashMap<String, String>() : listaTransgenicos.get(0));
			}else{
				mapTrangenicos = new HashMap<String, String>();
			}
			if(!mapTrangenicos.containsKey(transgenico)){
				if(StringUtils.isEmpty(StringUtils.trim(transgenico))){
					codigoTransgenico = null;
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}else{
					codigoTransgenico = creacionPorArchivoDAO.validarExisteTransgenico(transgenico);
					if(codigoTransgenico == null || StringUtils.equals(codigoTransgenico, "null") || codigoTransgenico == transgenico
							|| StringUtils.isEmpty(StringUtils.trim(codigoTransgenico))){
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);					
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}else{
						mapTrangenicos.put(transgenico, codigoTransgenico);
						listaTransgenicos.clear();
						listaTransgenicos.add(mapTrangenicos);
						agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}
				}				
			}else{
				codigoTransgenico = mapTrangenicos.get(transgenico);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el transgenico. {}", e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar el transgenico. {}",e.getMessage());
		}finally{
			mapTrangenicos = null;
		}
		return codigoTransgenico;
	}

	@Override
	public String validacionesUsos(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaUsos, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean[] esFilaValida) throws SICException {
		String codigoUso = StringUtils.EMPTY;
		String uso = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapUsos = null;
		try{
			uso = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaUsos)){
				mapUsos = new HashMap<String, String>();
				mapUsos.putAll(listaUsos.get(0) == null ? new HashMap<String, String>() : listaUsos.get(0));
			}else{
				mapUsos = new HashMap<String, String>();
			}
			if(!mapUsos.containsKey(uso)){
				if(validarCaracteristicaDinamica(uso, numeroFila, numeroColumna, nombreCampo, EnumCaracteristicaDinamica.CARACTERISTICA_TIENEUSOS, observaciones, esFilaValida)){
					codigoUso = creacionPorArchivoDAO.validarExisteUso(uso);
					if(codigoUso == null || StringUtils.isEmpty(codigoUso)
							|| StringUtils.equals(codigoUso, "null") || StringUtils.equals(codigoUso, uso)){
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
							      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, nombreCampo);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
						codigoUso = uso;
						agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}else{
						mapUsos.put(uso, codigoUso);
						listaUsos.clear();
						listaUsos.add(mapUsos);
						agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}				
			}else{
				codigoUso = mapUsos.get(uso);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar los usos. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar los usos. {}",e.getMessage());
		}
		return codigoUso;
	}

	@Override
	public String validacionesTipoSecuncia(Cell celdaExcel, List<String> observaciones, List<HashMap<String, String>> listaTipoSecuencias, Integer numeroFila, Integer numeroColumna, boolean[] esFilaValida, String codigoCabecera) throws SICException {
		String codigoSecuencia = StringUtils.EMPTY;
		String nombreSecuencia = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		HashMap<String, String> mapSecuencias = null;
		try{
			nombreSecuencia = obtenerValorCeldaString(celdaExcel);
			if(CollectionUtils.isNotEmpty(listaTipoSecuencias)){
				mapSecuencias = new HashMap<String, String>();
				mapSecuencias.putAll(listaTipoSecuencias.get(0) == null ? new HashMap<String, String>() : listaTipoSecuencias.get(0));
			}else{
				mapSecuencias = new HashMap<String, String>();
			}
			if(!mapSecuencias.containsKey(nombreSecuencia)){
				codigoSecuencia = creacionPorArchivoDAO.validarExisteTipoSecuencia(nombreSecuencia);
				if(codigoSecuencia == null || StringUtils.isEmpty(codigoSecuencia)
						|| StringUtils.equals(codigoSecuencia, "null") || StringUtils.equals(codigoSecuencia, nombreSecuencia)){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, codigoCabecera);
					LOG_SICV2.error(observacion.substring(4));
					observaciones.add(observacion);
					codigoSecuencia = nombreSecuencia;
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}else{
					mapSecuencias.put(nombreSecuencia, codigoSecuencia);
					listaTipoSecuencias.clear();
					listaTipoSecuencias.add(mapSecuencias);
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}
			}else{
				codigoSecuencia = mapSecuencias.get(nombreSecuencia);
				agregarEsFilaValida(esFilaValida, Boolean.TRUE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el tipo secuencia. {}",e.getMessage());
//			throw new SICException("Ha ocurrido un error al validar el tipo secuencia. {}",e.getMessage());
		}finally{
			mapSecuencias = null;
		}
		return codigoSecuencia;
	}

	@Override
	public String validacionesRegistroSanitario(String celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean[] esFilaValida) throws SICException {
		String presentacion = StringUtils.EMPTY;
		try{
			presentacion = celdaExcel;
			validacionesFechaCaducidadRegSan(presentacion, observaciones, numeroFila, numeroColumna, nombreCampo, esFilaValida);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion del registro sanitario {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return presentacion;
	}

 
	private String validacionesFechaCaducidadRegSan(String celdaExcel, List<String> observaciones, Integer numeroFila, Integer numeroColumna, String nombreCampo, boolean[] esFilaValida) throws SICException {
		String fecha = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try{
			fecha = celdaExcel;
			if(StringUtils.isBlank(fecha)){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
				      getString("ec.com.smx.sic.articulo.validacion.archivo.celda.vacia"), String.valueOf(numeroFila), numeroColumna, nombreCampo, indiceAlfabeticoColumna(numeroColumna).concat(String.valueOf(numeroFila)));
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				if(esFechaValida(fecha, observaciones, numeroFila, numeroColumna, nombreCampo, esFilaValida)){
					agregarEsFilaValida(esFilaValida, Boolean.TRUE);
				}else{
					agregarEsFilaValida(esFilaValida, Boolean.FALSE);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en la validacion de fecha caducidad registro sanitario {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return fecha;
	}

	@Override
	public String obtenerValorCeldaString(Cell celda) throws SICException{
		String valorCelda = null;
		if(celda != null){
			switch (celda.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				 if (DateUtil.isCellDateFormatted(celda)) {
					 	DateFormat dateformat = new SimpleDateFormat(IApplicationUtilResourceConstant.FORMAT_DATE);
					 	valorCelda = dateformat.format(celda.getDateCellValue());
				    } else {
				    	valorCelda = String.valueOf(celda.getNumericCellValue());
				    }
				 break;
			case Cell.CELL_TYPE_STRING:
				valorCelda = celda.getStringCellValue();
				break;
			case Cell.CELL_TYPE_BLANK:
				valorCelda = " ";
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				valorCelda = String.valueOf(celda.getBooleanCellValue());
				break;
			}
		}
		return valorCelda;
	}
	
	@Override
	public String parsearValor(String cellValue) throws SICException {
		if (StringUtils.contains(cellValue, ".") && StringUtils.length(cellValue) > 1){
			String[] arrayFomato = StringUtils.split(cellValue,"\\.");
			return arrayFomato[0];
		} else {
			return cellValue;
		}
	}
	
	
	/**
	 * Metodo que devuelve el indice alfabetico de las columnas
	 * @param indiceColumna
	 * @return
	 */
	@Override
	public String indiceAlfabeticoColumna(int indiceColumna) throws SICException {
		String indice = "";
		if(Integer.valueOf(indiceColumna) != null){
			switch (indiceColumna) {
			case  0: indice = "A"; break;
			case  1: indice = "B"; break;
			case  2: indice = "C"; break;
			case  3: indice = "D"; break;
			case  4: indice = "E"; break;
			case  5: indice = "F"; break;
			case  6: indice = "G"; break;
			case  7: indice = "H"; break;
			case  8: indice = "I"; break;
			case  9: indice = "J"; break;
			case 10: indice = "K"; break;
			case 11: indice = "L"; break;
			case 12: indice = "M"; break;
			case 13: indice = "N"; break;
			case 14: indice = "O"; break;
			case 15: indice = "P"; break;
			case 16: indice = "Q"; break;
			case 17: indice = "R"; break;
			case 18: indice = "S"; break;
			case 19: indice = "T"; break;
			case 20: indice = "U"; break;
			case 21: indice = "V"; break;
			case 22: indice = "W"; break;
			case 23: indice = "X"; break;
			case 24: indice = "Y"; break;
			case 25: indice = "Z"; break;
			case 26: indice = "AA"; break;
			case 27: indice = "AB"; break;
			case 28: indice = "AC"; break;
			case 29: indice = "AD"; break;
			case 30: indice = "AE"; break;
			case 31: indice = "AF"; break;
			case 32: indice = "AG"; break;
			case 33: indice = "AH"; break;
			case 34: indice = "AI"; break;
			case 35: indice = "AJ"; break;
			}
		}
		return indice;
	}
	
	@Override
	public void agregarEsFilaValida(boolean esFilaValida[], boolean esValido) throws SICException{
		Boolean condicion = Boolean.FALSE;
		try{
			if(esFilaValida.length == 0){
				esFilaValida[0] = esValido;
			}else{
				condicion = Boolean.valueOf(esFilaValida[0]);
				if(condicion){
					esFilaValida[0] = esValido;
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al agregar si la fila es valida", e.getMessage());
		}
	}
	
	/******************************************************************************************************************/
	/***************************************METODOS*****PRIVADOS*******************************************************/
	/******************************************************************************************************************/
	

	/*****METODOS*PARA*VERIFICAR*EXISTENCIA*DE*DATOS**/
	
	/**
	 * Metodo que permite verificar si existe el proveedor
	 * @param codigoProveedor
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	private String validarExisteProveedor(String codigoJDEProveedor, Integer codigoCompania, String[] condicionesProveedor) throws SICException {
		String codigoProveedor = null;
		try{
			if(StringUtils.isNotBlank(codigoJDEProveedor) && codigoCompania != null){
				codigoProveedor =  this.creacionPorArchivoDAO.validarExisteProveedor(codigoJDEProveedor, codigoCompania, condicionesProveedor);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al buscar si existe el proveedor: ".concat(codigoJDEProveedor).concat(" ingresado. ").concat(e.getMessage()));
		}
		return codigoProveedor;
	}
	
	/**
	 * Metodo que permite verificar si existe la clasificacion
	 * @param codigoClasificacion
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	private boolean validarExisteClasificacion(String codigoClasificacion, Integer codigoCompania, List<HashMap<String, LinkedList<String>>> listaClasificaciones, String codigoFuncionario, String [] condicionesClasificacion) throws SICException {
		boolean existeClasificacion = Boolean.FALSE;
		ClasificacionesPorClasificacionFuncionarioCompradorRestriction cpcf = null;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(codigoClasificacion)) && codigoCompania != null){
				cpcf = new ClasificacionesPorClasificacionFuncionarioCompradorRestriction(codigoFuncionario, null, null, null, null, "id.codigoClasificacion");
				existeClasificacion = creacionPorArchivoDAO.validarExisteClasificacion(codigoClasificacion, codigoCompania, listaClasificaciones, cpcf.getCriteriaRestriction(), condicionesClasificacion);
			}
		}catch (Exception e) {
			LOG_SICV2.error("Error al validar si existe la clasificacion. {}",e.getMessage());
//			throw new SICException("Error al validar si existe la clasificacion. {}",e.getMessage());
		}
		return existeClasificacion;
	}
	
	/**
	 * Metodo que valida si existe la subclasificacion con el codigo de la
	 * subclasificacion y la clasificacion
	 * @param codigoClasificacion
	 * @param codigoSubClasificacion
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	
	private boolean validarExisteSubClasifiacion(String codigoClasificacion, String codigoSubClasificacion, Integer codigoCompania) throws SICException {
		boolean existeSubClasificacion = Boolean.FALSE;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(codigoClasificacion)) && StringUtils.isNotEmpty(StringUtils.trim(codigoSubClasificacion)) && codigoCompania != null){
				existeSubClasificacion = creacionPorArchivoDAO.validarExisteSubClasifiacion(codigoClasificacion, codigoSubClasificacion, codigoCompania);
			}
		}catch (Exception e) {
			LOG_SICV2.error("Error al validar si existe la subclasificacion. {}",e.getMessage());
//			throw new SICException("Error al validar si existe la subclasificacion. {}",e.getMessage());
		}
		return existeSubClasificacion;
	}
	
	/**
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 */
	private boolean validarExisteCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException {
		boolean existeCodigoBarras = Boolean.FALSE;
		try{
			if(codigoCompania != null && StringUtils.isNotEmpty(StringUtils.trim(codigoBarras))){
				existeCodigoBarras = creacionPorArchivoDAO.validarCodigoBarras(codigoCompania, codigoBarras);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error la validar si existe el codigo de barras. {}", e.getMessage());
//			throw new SICException("Error la validar si existe el codigo de barras. {}", e.getMessage());
		}
		return existeCodigoBarras;
	}
	
	private boolean validarCodigoEAN(String codigoBarras) throws SICException {
		boolean eanValido = Boolean.FALSE;
		Validator validator = null;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(codigoBarras))){
				validator = new ValidatorImpl();
				eanValido = validator.validateEAN(codigoBarras);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar el EAN. {}", e.getMessage());
//			throw new SICException("Error al validar el EAN. {}", e.getMessage());
		}finally{
			validator = null;
		}
		return eanValido;
	}
	
	/**
	 * Metodo que verifica si existe la clase articulo ingresada
	 * @param codigoClaseArticulo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	private boolean validarExisteClaseArticulo(String codigoClaseArticulo, Integer codigoCompania, Set<String> listaClaseArticulos, Boolean esCreacion)throws SICException{
		boolean existeClaseArticulo = Boolean.FALSE;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(codigoClaseArticulo)) && codigoCompania != null){
				existeClaseArticulo = creacionPorArchivoDAO.validarExisteClaseArticulo(codigoClaseArticulo, codigoCompania, listaClaseArticulos, esCreacion);
			}
		}catch (Exception e) {
			LOG_SICV2.error("Error al validar si existe la clase articulo. {}",e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return existeClaseArticulo;
	}
	
	/**
	 * Validar que la unidad de manejo sea valida.
	 * Mayor a 0 y entero
	 * @param unidadManejo
	 * @return
	 * @author eharo
	 */
	private boolean validarExisteUnidadManejo(final String unidadManejo) throws SICException {
		boolean existeUnidadManejo = Boolean.FALSE;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(unidadManejo))){
				Integer uniManejo = Integer.valueOf(unidadManejo);
				if(uniManejo > 0){
					existeUnidadManejo = Boolean.TRUE;
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar la unidad de manejo. {}", e.getMessage());
		}
		return existeUnidadManejo;
	}
	
	@SuppressWarnings("unused")
	private String validarExisteMarca(String nombreMarca, Integer codigoCompania, String codigoProveedor, Set<String> listaMarcas) throws SICException {
		String codigoMarcaArticulo = StringUtils.EMPTY;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(nombreMarca)) && codigoCompania != null && StringUtils.isNotEmpty(StringUtils.trim(codigoProveedor))){
				codigoMarcaArticulo = creacionPorArchivoDAO.validarExisteMarca(codigoCompania, nombreMarca, codigoProveedor);
			}
		}catch(Exception e){
			LOG_SICV2.error("Error al validar la marca. {}", e.getMessage());
//			throw new SICException(e.getMessage());
		}
		return codigoMarcaArticulo;
	}
	/**
	 * Permite validar el tamanio de los enteros y decimales, de acuerdo a los permitidos
	 * @param numeroIngresado
	 * @param cantidaMaxEnteros
	 * @param cantidaMaxDecimales
	 * @param observaciones
	 * @param numeroFila
	 * @param numeroColumna
	 * @author eharo
	 */
	private void validarTamanioEnterosDecimales(String campo,String numeroIngresado, Integer cantidaMaxEnteros, Integer cantidaMaxDecimales, List<String> observaciones, Integer numeroFila, Integer numeroColumna){
		String observacion = StringUtils.EMPTY;
		String enteros = StringUtils.EMPTY;
		String numeroEvaluado []= null;
		String decimales = StringUtils.EMPTY;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(numeroIngresado)) && StringUtils.isNotEmpty(campo) && cantidaMaxEnteros != null && cantidaMaxDecimales != null){
				if(StringUtils.contains(numeroIngresado, ".")){
					numeroEvaluado = StringUtils.split(numeroIngresado,".");
				}else{
					numeroEvaluado = new String[1];
					numeroEvaluado[0] = numeroIngresado;
				}
				enteros = numeroEvaluado[0];
				if(enteros.length() > cantidaMaxEnteros){
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.cantidad.maxima.enteros"), String.valueOf(numeroFila), numeroColumna, campo, cantidaMaxEnteros);
					LOG_SICV2.error(observacion.substring(5));
					observaciones.add(observacion);
				}
				if(StringUtils.contains(numeroIngresado, ".")){
					
					decimales = numeroEvaluado[1];
					if(decimales.length() > cantidaMaxDecimales){
						if(cantidaMaxDecimales == 0){
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
									getString("ec.com.smx.sic.articulo.validacion.archivo.columna.validar.formato.fecha"), String.valueOf(numeroFila), numeroColumna, campo, "SOLO ENTEROS");
						}else{
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
									getString("ec.com.smx.sic.articulo.validacion.archivo.columna.cantidad.maxima.decimales"), String.valueOf(numeroFila), numeroColumna, campo, cantidaMaxDecimales);
						}
						LOG_SICV2.error(observacion.substring(5));
						observaciones.add(observacion);
					}
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en validar el tamanio enteros decimales. {}", e.getMessage());
		}
	}
	
	@Override
	public Boolean validarCaracteristicaDinamica(String campo, Integer numeroFila, Integer numeroColumna, String cabecera, EnumCaracteristicaDinamica caracteristicaDinamica, List<String> observaciones, boolean esFilaValida []){
		String observacion = StringUtils.EMPTY;
		boolean validacion = Boolean.FALSE;
		try{
			if(StringUtils.isNotEmpty(StringUtils.trim(campo))){
				validacion = Boolean.TRUE;
			}else{
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
						getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.caracteristica.dinamica"), String.valueOf(numeroFila), numeroColumna, cabecera, caracteristicaDinamica);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en validar la caracteristica dinamica. {}", e.getMessage());
		}
		return validacion;
	}
	
	/**
	 * METODO QUE PERMITE SETEAR EL VALOR CORRECTO DE LA CELDA,
	 * SE USUA PARA LOS CAMPOS DE REFERENCIAS
	 * @param valorCelda
	 * @return
	 */
	private String setearValorCelda(String valorCelda){
		String valorRemplazado = StringUtils.EMPTY;
		String valorCeldaRetorno = StringUtils.EMPTY;
		String lastChar = StringUtils.EMPTY;
		String nuevoValorCelda = StringUtils.EMPTY;
		try{
			if(!valorCelda.substring(0,1).equals(".")) {
				if(NumberUtils.isNumber(valorCelda)){
					lastChar = StringUtils.substring(valorCelda, -1);
					if(StringUtils.equals(lastChar.toUpperCase(), "D") || StringUtils.equals(lastChar.toUpperCase(), "F") || StringUtils.equals(lastChar.toUpperCase(), "L")){
						valorCeldaRetorno = valorCelda;
					}else{
						nuevoValorCelda = new BigDecimal(valorCelda).toPlainString();
						if(StringUtils.equals(String.valueOf(nuevoValorCelda.charAt(0)), "0")){
							valorCeldaRetorno = nuevoValorCelda;
						}else if (StringUtils.indexOf(nuevoValorCelda, ".") != -1){
							valorRemplazado = StringUtils.substring(nuevoValorCelda, 0, StringUtils.indexOf(nuevoValorCelda, "."));
							nuevoValorCelda = StringUtils.substring(nuevoValorCelda, StringUtils.indexOf(nuevoValorCelda, "."), StringUtils.length(nuevoValorCelda));
							if(this.tieneNumeroDiferenteDeCero(nuevoValorCelda)) {
								valorCeldaRetorno = valorRemplazado + nuevoValorCelda;
							} else {
								valorCeldaRetorno = valorRemplazado;
							}
						}else{
							valorCeldaRetorno = nuevoValorCelda;
						}
					}
				}else{
					valorCeldaRetorno = valorCelda;
				}
		} else {
			valorCeldaRetorno = valorCelda;
		}
			
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al setear el valor de la celda. {}",e.getMessage());
		}
		return valorCeldaRetorno;
	}
	
	/**
	 * Permite si existe un valor diferente de cero en la cadena
	 * @param valorCelda String a verificar si tiene valores diferentes de cero
	 * @author bcueva
	 * @return
	 */
	private Boolean tieneNumeroDiferenteDeCero(String valorCelda) {
		for(Integer numero = 1; numero < 10; numero ++) {
			if(StringUtils.contains(valorCelda, numero.toString())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	
	/****************************************************************************/
	/*******SETTERS**************************************************************/
	/****************************************************************************/
	
	/**
	 * @param creacionPorArchivoDAO the creacionPorArchivoDAO to set
	 */
	public void setCreacionPorArchivoDAO(IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO) {
		this.creacionPorArchivoDAO = creacionPorArchivoDAO;
	}

	public void setParametroGestor(IParametroGestor parametroGestor) {
		this.parametroGestor = parametroGestor;
	}
}
