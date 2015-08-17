/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.validacion;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.com.kruger.utilitario.dao.commons.dto.OrderBy;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.ManejoFechas;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.framework.reports.excel.poi.util.PoiExcelStyleUtil;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.common.articulo.CaracteristicaDinamicaUtil;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.common.articulo.EnumCreacionPorArchivoCabecera;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.common.articulo.TipoCatalogoArticulo;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAplicacionDescuento;
import ec.com.smx.sic.cliente.common.articulo.constantes.EnumTipoAsignacionDescuento;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloCamposCreacionPorArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloCreacionPorArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.precios.IValidacionArticuloReglasComercialesGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionTipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloCreacionPorArchivoDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * Gestor que agrupa los datos que ingresan desde el excel, validando que los
 * datos ingresados sean correctos tambien genera un excel con los errores.
 * 
 * @author eharo
 * 
 */
@SuppressWarnings("rawtypes")
public class ValidacionArticuloCreacionPorArchivoGestor implements IValidacionArticuloCreacionPorArchivoGestor, Logeable {

	private DataGestor dataGestor;
	// Variable de acceso al DAO de la creacion por archivo
	private IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO;
	// Varialble de acceso a la validacion de los campos del archivo
	private IValidacionArticuloCamposCreacionPorArchivoGestor validacionArticuloCampos;
	// Variable de acceso a validaciones de las reglas comerciales del articulo
	private IValidacionArticuloReglasComercialesGestor validacionReglasComerciales;

	@Override
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoArticulo(ArticuloVO articuloVOPlantillaValores, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException {
		LOG_SICV2.info("--------------INICIO DE LA VALIDACION DEL ARCHIVO EXCEL------------");
		Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidosArchivo = null;
		try {
			datosValidosArchivo = validarArchivoArticulo(articuloVOPlantillaValores, inputStreamArchivo, tipoCabeceras);
		} catch (Exception e) {
			throw new SICException(e.getMessage());
		}
		return datosValidosArchivo;
	}

	/**
	 * METODO QUE PERMITE GENERAR UN OBJETO Workbook CON EL INPUTSTREAM DEL
	 * ARCHIVO EXCEL
	 * 
	 * @param inputStreamArchivo
	 * @return
	 * @author eharo
	 */
	private Workbook archivoArticulosCargado(InputStream inputStreamArchivo) {
		Workbook workbook = null;
		try {
			if (inputStreamArchivo != null) {
				workbook = WorkbookFactory.create(inputStreamArchivo);
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al cargar el archivo. {}", e.getMessage());
			throw new SICException("Error al cargar el archivo. {}", e.getMessage());
		}
		return workbook;
	}

	@Override
	public String validacionesFechaInicioFinTemporada(String fechaInicio, String fechaFinal, Map<String, String> cabecerasMapa, String nombreCatalogoValor, Integer numeroFila, Integer numeroColumna, List<String> observaciones, boolean[] esFilaValida) throws SICException {
		return this.validacionesFechaInicioFin(fechaInicio, fechaFinal, cabecerasMapa, nombreCatalogoValor, numeroFila, numeroColumna, observaciones, esFilaValida);
	}

	@Override
	public MultiKeyMap agruparDatosMapaValidados(MultiKeyMap datosValidados, Integer numeroFila, boolean esFilaValida, Collection<CatalogoValorDTO> lstCabecerasCatalogoValorDTO) throws SICException {
		return this.agruparDatosMapa(datosValidados, numeroFila, esFilaValida, lstCabecerasCatalogoValorDTO);
	}

	/**
	 * Metodo que verifica que el archivo tenga datos validos y la cabecera este
	 * correcta
	 * 
	 * @param articuloVO
	 * @param inputStreamArchivo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> validarArchivoArticulo(ArticuloVO articuloVOPlantillaValores, InputStream inputStreamArchivo, Integer tipoCabeceras) {
		Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidosArchivo = null;
		Collection<CatalogoValorDTO> lstCatalogoValorDTO = null;
		// LinkedHashMap<String, LinkedList> datosValidos = null;
		// LISTA EN LA CUAL SE ALMACENAN TODAS LAS OBSERVACIONES QUE GENERA LA
		// VALIDACION
		List<String> observaciones = null;
		// LISTA CON LOS DATOS DEL EXCEL POR CADA FILA
		List datosCeldaTmp = new ArrayList();
		// VARIABLE PARA ASIGNAR LA OBSERVACION DE CADA VALIDACION
		String observacion = " ";
		// VARIABLE DE LA HOJA QUE SE GENERAR CON REPORTES DE ERRORES O LA
		// PLANTILLA DEL ARCHIVO EXCEL
		Sheet sheet = null;
		// ITERADOR DE LAS FILAS DEL ARCHIVO EXCEL
		Iterator<Row> rowIteratorArchivo = null;
		// VARIABLE QUE IDENTIFICA EL VALOR DE LA FILA PROCESADA
		Integer numeroFila = 1;
		// VARIABLE QUE IDENTIFICA EL NUMERO DE COLUMNAS DEL ARHIVO EXCEL
		Integer numeroColumnas = 0;
		// VARIABLE QUE IDENTIFICA EL NUMERO MAXIMO DE FILAS DE ACUERDO AL
		// PARAMETRO PARA DATOS EN EL EXCEL
		Integer numeroMaximoFilas = 0;
		// NUMERO DE FILAS QUE ESTA EN EL EXCEL QUE SE SUBIO
		Integer numeroFilasExcelSubido = 0;
		// PARAMETRO CON EL NUMERO MAXIMO DE REGISTROS
		String numeroMaximoRegistros = StringUtils.EMPTY;
		try {
			if (inputStreamArchivo != null) {
				LOG_SICV2.info("SE INICIA LA VALIDACION DEL ARCHIVO");

				observaciones = new ArrayList<String>();
				datosValidosArchivo = new Duplex<Collection<CatalogoValorDTO>, MultiKeyMap>();
				Workbook wb = archivoArticulosCargado(inputStreamArchivo);
				if (wb != null) {
					sheet = wb.getSheetAt(0);
					Iterator<Row> rowIterator = sheet.rowIterator();
					rowIteratorArchivo = sheet.rowIterator();
					numeroFilasExcelSubido = sheet.getLastRowNum();
					lstCatalogoValorDTO = listaCabeceras(tipoCabeceras);
					numeroColumnas = CollectionUtils.size(lstCatalogoValorDTO);
					numeroMaximoRegistros = obtenerParametro(articuloVOPlantillaValores.getCodigoCompania(), SICArticuloConstantes.getInstancia().PARAMETRO_MAXIMO_FILAS_CREACION_POR_ARCHIVO);
					if (NumberUtils.isNumber(numeroMaximoRegistros)) {
						numeroMaximoFilas = Integer.valueOf(numeroMaximoRegistros);
					} else {
						numeroMaximoFilas = 500;
					}
					numeroMaximoFilas = ((numeroMaximoFilas == null ? 500 : numeroMaximoFilas));

					if (numeroFilasExcelSubido > numeroMaximoFilas) {
						for (int i = numeroMaximoFilas + 1; i <= numeroFilasExcelSubido; i++) {
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.tamanio.maximo.mensaje.extra"), String.valueOf(i + 1), 0, "archivo excel ", numeroMaximoFilas + " art\u00EDculos");
							observaciones.add(observacion);
						}
						numeroFila = numeroMaximoFilas;
					} else {
						numeroMaximoFilas = numeroMaximoFilas + 2;
						// Iterar las filas
						while (rowIterator.hasNext() && numeroFila < numeroMaximoFilas) {
							Row rowExcel = rowIterator.next();
							// Se verifica que la cabecera del archivo excel
							// este correcta
							if (numeroFila == 1) {
								LOG_SICV2.info("SE INICIA LA VALIDACION DE LAS CABECERAS");
								observacion = validarCabeceraArchivo(rowExcel, lstCatalogoValorDTO);
								// Verificar la validacion de la cabecera
								if (StringUtils.isNotBlank(observacion)) {
									LOG_SICV2.error("Ha ocurrido un error al validar las cabeceras... " + MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.cabecera.error"), observacion));
									throw new SICException(MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.cabecera.error"), observacion));
								}
								LOG_SICV2.info("SE FINALIZA LA VALIDACION DE LAS CABECERAS");
							} else {
								if (numeroFila == 2) {
									LOG_SICV2.info("SE INICIA LA OBTENCION DE LAS FILAS INGRESADAS EN EL EXCEL");
								}
								List celdasTempList = new ArrayList();// Lista con las celdas validadas
								boolean estaLlena = Boolean.FALSE;
								/*
								 * SE RECORRE TODAS LAS CELDAS DE LA FILA PARA
								 * SABER SI POR LO MENOS UNA ESTA LLENA PARA QUE
								 * SEA UNA FILA CANDIDATA PARA LA VALIDACION
								 */
								for (Cell cell : rowExcel) {
									if (StringUtils.equals(StringUtils.trim(obtenerValorCeldaString(cell)), "")) {
										// SI POR LO MENOS UNA CELDA ESTA LLENA
										// ES OBTIENE EL VALOR DE TRUE Y NO SE
										// CAMBIA A FALSE
										if (!estaLlena) {
											estaLlena = Boolean.FALSE;
										}
									} else {
										estaLlena = Boolean.TRUE;
									}
								}
								// SI ESTA LLENA LA FILA SE PROCEDE A LA
								// VALIDACION
								if (estaLlena) {
									// SE RECORRE LA LIST
									for (CatalogoValorDTO dto : lstCatalogoValorDTO) {
										// SE OBTIENE LA CELDA DE ACUERDO AL
										// ORDEN DE LA CABECERA, SI ES NULL SE
										// CREA UNA CELDA EN BLANCO
										Cell celdaExcel = rowExcel.getCell(Integer.valueOf(dto.getOrden()), Row.CREATE_NULL_AS_BLANK);
										if (StringUtils.equals(StringUtils.trim(String.valueOf(celdaExcel)), "")) {
											// Valido que las columnas que no
											// son requeridas se ingresen
											if (!dto.getEsValorPorDefecto()) {
												celdaExcel.setCellValue(" ");
												celdasTempList.add(celdaExcel);
											} else {
												// Verifico que las columnas no esten vacias
												observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.vacia"), String.valueOf(numeroFila), Integer.valueOf(dto.getOrden()), dto.getNombreCatalogoValor());
												LOG_SICV2.error(StringUtils.substring(observacion, 4));
												observaciones.add(observacion);
												continue;
											}
										} else if ((dto.getValorNumerico() == null ? 0 : dto.getValorNumerico()) == 1 && (!StringUtils.equals(StringUtils.trim(String.valueOf(celdaExcel)), "")) && (!NumberUtils.isNumber(String.valueOf(celdaExcel)))) {
											// verifico las columnas numericas
											// SI LA COLUMNA ES DE TIPO NUMERICA
											// Y EL VALOR DE LA CELDA NO ES
											// NUMERICO SE AGREGA EL ERROR
											observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.tipo.numerico"), String.valueOf(numeroFila), Integer.valueOf(dto.getOrden()), dto.getNombreCatalogoValor());
											LOG_SICV2.error(StringUtils.substring(observacion, 4));
											observaciones.add(observacion);
											continue;
										} else {
											// Agrego las columnas que no tienen
											// restricciones
											celdasTempList.add(celdaExcel);
										}
										if (CollectionUtils.isNotEmpty(celdasTempList) && CollectionUtils.size(celdasTempList) == numeroColumnas) {
											// este metodo agrega el numero de
											// fila evaluada y despues agrega la
											// fila
											celdasTempList.add(numeroFila);// Se almacena el numero de la fila evaluada
											datosCeldaTmp.add(celdasTempList);// Se almacenan los datos de cada fila
											LOG_SICV2.info("FILA: {} : {}", numeroFila, celdasTempList.toString());
										}
									}
								}
							}
							numeroFila++;
							if (rowIterator.hasNext() == Boolean.FALSE) {
								LOG_SICV2.info("SE FINALIZA LA OBTENCION DE LAS FILAS INGRESADAS EN EL EXCEL");
							}
						}
					}
					// Se valida que el archivo se encuentra vacio
					if (numeroFila <= 2 && !StringUtils.isNotEmpty(StringUtils.trim(observacion))) {
						LOG_SICV2.error(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.vacio"));
						observacion = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.vacio");
						observaciones.add(observacion);
						this.generarExcelErrores(articuloVOPlantillaValores, observaciones, rowIteratorArchivo, numeroColumnas, lstCatalogoValorDTO);
						// throw new
						// SICException(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.vacio"));
					}

					// Se valida el formato del archivo
					if (datosCeldaTmp != null && CollectionUtils.isNotEmpty(datosCeldaTmp)) {
						datosValidosArchivo = validarFormatoArchivo(datosCeldaTmp, observaciones, articuloVOPlantillaValores, lstCatalogoValorDTO);
					}

					// Generacion de archivo excel cuando existen errores en las
					// observaciones
					if (CollectionUtils.isNotEmpty(observaciones) && numeroFila > 2) {
						LOG_SICV2.info("Se genera el archivo excel con las observaciones de errores respectivas");
						LOG_SICV2.info("OBSERVACIONES: {}", observaciones.toString());
						generarExcelErrores(articuloVOPlantillaValores, observaciones, rowIteratorArchivo, numeroColumnas, lstCatalogoValorDTO);
					}
				}
				LOG_SICV2.info("Fin de la validacion del archivo");
			}
		} catch (Exception e) {
			throw new SICException(e.getMessage());
		} finally {
			lstCatalogoValorDTO = null;
		}
		return datosValidosArchivo;
	}

	/**
	 * METODO QUE GENERA UN MAPA CON EL CODIGO DE CABECERA Y EL NOMBRE DE CADA
	 * CABECERA
	 * 
	 * @param lstCatalogoValorDTO
	 * @return
	 */
	private Map<String, String> obtenerMapaCabeceras(Collection<CatalogoValorDTO> lstCatalogoValorDTO) {
		LinkedHashMap<String, String> cabecerasMapa = null;
		try {
			cabecerasMapa = new LinkedHashMap<String, String>();
			for (CatalogoValorDTO catalogoValorDTO : lstCatalogoValorDTO) {
				// SE IDENTIFICA CUANDO LAS CABECERAS SON COMODINES PARA
				// INGRESAR INPUESTOS EN LA COMPRA Y EN LA VENTA
				if (StringUtils.equals(catalogoValorDTO.getId().getCodigoCatalogoValor(), SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_VENTA)) {
					cabecerasMapa.put(catalogoValorDTO.getNombreCatalogoValor(), catalogoValorDTO.getNombreCatalogoValor());
				} else if (StringUtils.equals(catalogoValorDTO.getId().getCodigoCatalogoValor(), SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_COMPRA)) {
					cabecerasMapa.put(catalogoValorDTO.getNombreCatalogoValor(), catalogoValorDTO.getNombreCatalogoValor());
				} else {
					cabecerasMapa.put(catalogoValorDTO.getId().getCodigoCatalogoValor(), catalogoValorDTO.getNombreCatalogoValor());
				}
			}
		} catch (Exception e) {
			throw new SICException("Error al cargar cabeceras en el mapa {}.", e.getMessage());
		}
		return cabecerasMapa;
	}

	/**
	 * METODO QUE VALIDA EL FORMATO DEL ARCHIVO
	 * 
	 * @param cellDataList
	 * @param observaciones
	 * @param articuloVOPlantillaValores
	 * @param lstCatalogoValorDTO
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	private Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> validarFormatoArchivo(List cellDataList, List<String> observaciones, ArticuloVO articuloVOPlantillaValores, Collection<CatalogoValorDTO> lstCatalogoValorDTO) throws SICException {
		// VARIABLE CON LOS OBJETOS VALIDADOS PARA SER ENVIADOS A LA CREACION
		Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidados = null;
		// VARIABLE EN LA CUAL SE SE AGRUPAN LOS DATOS PARA VALIDA
		MultiKeyMap datosParaValidar = null;
		// VARIABLE CON LOS DATOS VALIDADOS
		MultiKeyMap datosValidadosMapa = null;
		// VARIABLE EN LA CUAL SE AGREGAN LOS DATOS NECESARIOS PARA VALIDAR CADA
		// FILA
		LinkedHashMap<String, Integer> camposNecesarios = null;
		Collection<CatalogoValorDTO> lstCabecerasCatalogoValorDTO = null;
		// VARIABLE EN LA CUAL SE ALMACENA EL CODIGO DE COMPANIA
		Integer codigoCompania = null;
		// VARIABLE QUE ALMACENA EL NUMERO DE FILA QUE SE ESTA VALIDANDO
		Integer numeroFila = null;
		// VARIABLE QUE ALMACENA EL NUMERO DE COLUMNAS DEL EXCEL
		Integer numeroColumnas = null;
		// VARRIABLE QUE ALMACENA EL VALOR DE LA COLUMNA QUE SE ESTA VALIDANDO
		Integer ordenColumna = null;
		// VARIABLE QUE ALMACENA EL CODIGO DE CABECERA QUE SE ESTA VALIDANDO
		String codigoCabecera = StringUtils.EMPTY;
		// VARIABLE QUE ALMACENA EL CODIGO DE FUNCIONARIO
		String codigoFuncionario = StringUtils.EMPTY;
		// MAPA CON EL MAPA DE CODIGO DE CABECERAS Y NOMBRE CABECERAS
		Map<String, String> cabecerasMapa = null;
		try {
			LOG_SICV2.info("SE INGRESA A VALIDAR EL FORMATO DEL ARCHIVO");
			cabecerasMapa = new LinkedHashMap<String, String>();
			cabecerasMapa = obtenerMapaCabeceras(lstCatalogoValorDTO);
			if (CollectionUtils.isNotEmpty(cellDataList) && articuloVOPlantillaValores != null) {
				lstCabecerasCatalogoValorDTO = lstCatalogoValorDTO;
				if (CollectionUtils.isNotEmpty(lstCabecerasCatalogoValorDTO)) {
					// SE INICIA LAS VARIALBES PARA VALIDAR EL TODAS LAS FILAS
					// DEL DOCUMENTO
					datosValidados = new Duplex<Collection<CatalogoValorDTO>, MultiKeyMap>();
					datosParaValidar = new MultiKeyMap();
					datosValidadosMapa = new MultiKeyMap();
					camposNecesarios = new LinkedHashMap<String, Integer>();
					codigoCompania = articuloVOPlantillaValores.getCodigoCompania();
					codigoFuncionario = articuloVOPlantillaValores.getCodigofuncionario();
					numeroColumnas = CollectionUtils.size(lstCabecerasCatalogoValorDTO);
					datosValidados.setFirstObject(lstCabecerasCatalogoValorDTO);
					// Recorro la lista de filas
					for (int i = 0; i < cellDataList.size(); i++) {
						// OBTENGO LA FILA i PARA VALIDARLA
						List cellTempList = (List) cellDataList.get(i);
						// OBTENGO EL NUMERO DE LA FILA QUE SE ESTA VALIDANDO
						numeroFila = (Integer) cellTempList.get(numeroColumnas);
						// recorro las columnas
						for (CatalogoValorDTO dto : lstCabecerasCatalogoValorDTO) {
							// SE OBTIENE EL ORDEN DE LA COLUMNA QUE SE ESTA
							// VALIDANDO
							ordenColumna = Integer.valueOf(dto.getOrden());
							// SE VERIFICA SI LAS COLUMNAS SON DE TIPO IMPUESTOS
							if (StringUtils.equals(dto.getId().getCodigoCatalogoValor(), SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_VENTA)) {
								codigoCabecera = dto.getNombreCatalogoValor();
							} else if (StringUtils.equals(dto.getId().getCodigoCatalogoValor(), SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_COMPRA)) {
								codigoCabecera = dto.getNombreCatalogoValor();
							} else {
								codigoCabecera = dto.getId().getCodigoCatalogoValor();
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL PROVEEDOR
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DE LA
								// CLASIFICACION
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DE LA CLASE
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL CONTROL DE
								// PRECIOS
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL REGISTRO
								// SANITARIO
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DE LA FECHA
								// CADUCIDAD DEL REG.SAN
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL COSTO BRUTO
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL DES1
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL DES2
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL DES3
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL DES4
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL PRECIO
								// VENTA
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA DEL PRECIO
								// SUPERMAXI
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA VENTA PRECIO
								// AFILIAFO
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA PRESENTACION
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA FECHA INICIO
								// TEMPORADA
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA FECHA FIN
								// TEMPORADA
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA EMPAQUE
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA TIPO SECUENCIA
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
								// ORDEN Y EL CODIGO DE CABECERA CODIGO BARRAS
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE DATOS PARA VALIDAR TODAS
								// LAS CELDAS DE LA FILA
							//Se agrega el campo con la cabecera pa\u00EDs de fabricaci\u00F3n, para poderlo registrar el valor
							//para poderlo obtener despues para hacer validaciones, si otro campo lo requiere
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL
							//ORDEN EL CODIGO DE LA CABECERA PAIS ORIGEN
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_TAMANIO)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EL TAMANIO 
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CANTIDAD_MEDIDA)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EL CABECERA_CANTIDAD_MEDIDA
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA EL CABECERA_UNIDAD_MEDIDA
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_CONGELADO)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA VIDA UTIL CONGELADO
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_REFRIGERADO)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA VIDA UTIL REFRIGERADO
							if (StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_LOCAL)) {
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}// SE AGREGA VIDA UTIL 
							datosParaValidar.put(numeroFila, ordenColumna, codigoCabecera, limpiarEspacios(cellTempList,ordenColumna,codigoCabecera));
						}
					}// SE PROCEDE A VALIDAR LOS DATOS
					if (MapUtils.isNotEmpty(datosParaValidar) && MapUtils.isNotEmpty(camposNecesarios)) {
						datosValidadosMapa = validarDatosMapa(datosParaValidar, observaciones, lstCabecerasCatalogoValorDTO, camposNecesarios, codigoCompania, codigoFuncionario, cabecerasMapa);
					}// SE AGREGA AL DUPLEX LOS DATOS VALIDADOS
					datosValidados.setSecondObject(datosValidadosMapa);
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al validar el archivo excel. {}", e.getMessage());
			throw new SICException("Ha ocurrido un error al validar el archivo excel. {}", e.getMessage());
		} finally {
			datosParaValidar = null;
			datosValidadosMapa = null;
		}
		return datosValidados;
	}
	
	/**
	 * Limpia los espacios en blanco que se diguitaron por error, a los campos permitidos
	 * @bcueva
	 * @param cellTempList Lista con las celdas
	 * @param ordenColumna Numero de la columna que se encuentra evaluando
	 * @param codigoCabecera Nombre de la cabecera
	 * @return
	 */
	private Cell limpiarEspacios(List cellTempList, Integer ordenColumna, String codigoCabecera) {
		//Obteniendo la fila que se va ha validar
		Cell celdaExcel = (Cell) cellTempList.get(ordenColumna);
		//Si la celda no es de una de las siguientes cabeceras entonces se procede a limpiar los espacios en blanco
		if(!StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_TAMANIO)
				&& !StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_REFERENCIA)
				&& !StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_REFERENCIA_INTERNA)
				&& !StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO)
				&& !StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_MARCA)) {
			celdaExcel.setCellValue(StringUtils.trim(String.valueOf(celdaExcel)));
		}
		return celdaExcel; 
	}

	/**
	 * METODO QUE VALIDA LOS DATOS DE TODAS LAS FILAS INGRESADAS
	 * 
	 * @param datosParaValidar
	 * @param observaciones
	 * @param lstCabecerasCatalogoValorDTO
	 * @param camposNecesarios
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param cabecerasMapa
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	@SuppressWarnings("unchecked")
	private MultiKeyMap validarDatosMapa(MultiKeyMap datosParaValidar, List<String> observaciones, Collection<CatalogoValorDTO> lstCabecerasCatalogoValorDTO, LinkedHashMap<String, Integer> camposNecesarios, Integer codigoCompania, String codigoFuncionario, Map<String, String> cabecerasMapa) throws SICException {
		MultiKeyMap datosValidados = null;
		MultiKeyMap datosValidadosTmp = null;
		MultiKeyMap datosValidadosAgrupados = null;
		Integer numeroColumnas = null;
		Integer orden = null;
		Integer numeColumnaTmp = null;
		String campoTmp = StringUtils.EMPTY;
		String cabecera = StringUtils.EMPTY;
		String campo = StringUtils.EMPTY;
		String registroSanitario = StringUtils.EMPTY;
		String fechaCaducidadRegSan = StringUtils.EMPTY;
		String fechaInicioTemporada = StringUtils.EMPTY;
		String fechaFinalTemporada = StringUtils.EMPTY;
		String parametroIngresarDatos = StringUtils.EMPTY;
		Cell celdaTmp = null;
		Cell celda = null;
		String[] condicionesProveedor = null;
		String[] condicionesUnidadMedida = null;
		String[] condicionesClasificacion = null;
		Set objectList[] = null;
		LinkedHashMap objectListCarDin[] = null;
		boolean esFilaValida[] = null;
		LinkedList<String> objectProvedor = null;
		LinkedList<String> objectUnidadMedida = null;
		Set<Integer> indiceFila = null;
		Set<MultiKey> keys = null;
		LinkedHashMap<String, String> mapCamposReqValidacion = null;
		LinkedHashMap<String, String> mapValidacionCostos = null;
		LinkedHashMap<String, String> mapCamposImpuestos = null;
		Collection<CatalogoValorDTO> catalogosCabeceraImpuestos;
		try {
			LOG_SICV2.info("SE INGRESA A VALIDAR LOS DATOS DEL MAPA");
			if (MapUtils.isNotEmpty(datosParaValidar) && codigoCompania != null && CollectionUtils.isNotEmpty(lstCabecerasCatalogoValorDTO)) {
				datosValidadosAgrupados = new MultiKeyMap();

				indiceFila = new HashSet<Integer>();
				numeroColumnas = CollectionUtils.size(lstCabecerasCatalogoValorDTO);
				objectList = new Set[numeroColumnas];
				objectListCarDin = new LinkedHashMap[1];
				parametroIngresarDatos = obtenerParametro(codigoCompania, SICArticuloConstantes.getInstancia().PARAMETRO_INGRESO_VALORES_DE_CELDAS);
				keys = datosParaValidar.keySet();
				for (MultiKey key : keys) {
					indiceFila.add(Integer.valueOf(String.valueOf(key.getKey(0))));
				}
				// Recorro las filas ingresadas
				for (Integer numeroFila : indiceFila) {
					datosValidados = new MultiKeyMap();
					esFilaValida = new boolean[1];
					esFilaValida[0] = Boolean.TRUE;
					condicionesProveedor = new String[4];
					condicionesUnidadMedida = new String[2];
					condicionesClasificacion = new String[2];
					mapCamposReqValidacion = new LinkedHashMap<String, String>();
					mapValidacionCostos = new LinkedHashMap<String, String>();
					mapCamposImpuestos = new LinkedHashMap<String, String>();

					mapCamposReqValidacion.put("CODIGOCOMPANIA", String.valueOf(codigoCompania));
					mapCamposReqValidacion.put("FUNCIONARIOID", String.valueOf(codigoFuncionario));
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR, campoTmp);
						mapCamposReqValidacion.put("ORIGENPROVEEDOR", condicionesProveedor[2]);
						mapCamposReqValidacion.put("PROVEEDORIMPORTADOR", condicionesProveedor[3]);
					}
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS);
						campoTmp = validacionesParaCodigoBarras(celdaTmp, mapCamposReqValidacion, numeroFila, numeColumnaTmp, observaciones, objectList, esFilaValida);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS, campoTmp);
					}
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION, campoTmp);
					}
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE, campoTmp);
					}
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA, campoTmp);
					}
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS, campoTmp);
					}

					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION, campoTmp);
					}

					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_CONGELADO)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_CONGELADO);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_CONGELADO);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_CONGELADO, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_CONGELADO, campoTmp);
					}

					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA, campoTmp);
					}
					
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO);
						registroSanitario = obtenerValorCeldaString(celdaTmp);
					}
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN);
						fechaCaducidadRegSan = obtenerValorCeldaString(celdaTmp);
					}

					if (StringUtils.isNotEmpty(StringUtils.trim(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE))) && StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada"))) {

						if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA)) {
							numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA);
							celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA);
							validacionArticuloCampos.validacionesFechaInicioFinTemporada(celdaTmp, observaciones, numeroFila, numeColumnaTmp, Boolean.TRUE, esFilaValida, cabecerasMapa);
							fechaInicioTemporada = obtenerValorCeldaString(celdaTmp);
						}
						if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA)) {
							numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA);
							celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA);
							validacionArticuloCampos.validacionesFechaInicioFinTemporada(celdaTmp, observaciones, numeroFila, numeColumnaTmp, Boolean.FALSE, esFilaValida, cabecerasMapa);
							fechaFinalTemporada = obtenerValorCeldaString(celdaTmp);
						}
					}
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE);
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE, campoTmp);
					}
					
					//Registro el c\u00F3digo de pa\u00EDs para utilizarlo, en las validaciones
					if(camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN)) {
						//Obtengo el n\u00FAmero de la columna
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN);
						//Obtenemos la celda a validar
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN);
						//Validamos y obtenemos el valor del c\u00F3digo del pa\u00EDs
						campoTmp = validaciones(celdaTmp, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, numeColumnaTmp, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, null, null);
						//Registramos en el mapa el c\u00F3digo del pa\u00EDs, con el el nombre de la cabecera
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN, campoTmp);
					}
					
					/********************************************** LLENAR**COSTOS**INICIO *************************************************************************************************/
					// Costo bruto
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO);
						campoTmp = validacionesParaControlCostos(celdaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO), numeroFila, numeColumnaTmp, observaciones, esFilaValida, parametroIngresarDatos, objectListCarDin[0],
								mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION));
						mapValidacionCostos.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO, campoTmp);
					}
					// des1
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1);
						campoTmp = validacionesParaControlCostos(celdaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1), numeroFila, numeColumnaTmp, observaciones, esFilaValida, parametroIngresarDatos, objectListCarDin[0],
								mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION));
						mapValidacionCostos.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1, campoTmp);
					}
					// des2
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2);
						campoTmp = validacionesParaControlCostos(celdaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2), numeroFila, numeColumnaTmp, observaciones, esFilaValida, parametroIngresarDatos, objectListCarDin[0],
								mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION));
						mapValidacionCostos.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2, campoTmp);
					}
					// des3
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3);
						campoTmp = validacionesParaControlCostos(celdaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3), numeroFila, numeColumnaTmp, observaciones, esFilaValida, parametroIngresarDatos, objectListCarDin[0],
								mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION));
						mapValidacionCostos.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3, campoTmp);
					}
					// des4
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4);
						campoTmp = validacionesParaControlCostos(celdaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4), numeroFila, numeColumnaTmp, observaciones, esFilaValida, parametroIngresarDatos, objectListCarDin[0],
								mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION));
						mapValidacionCostos.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4, campoTmp);
					}
					// PVP
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA);
						campoTmp = validacionesParaControlCostos(celdaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA), numeroFila, numeColumnaTmp, observaciones, esFilaValida, parametroIngresarDatos, objectListCarDin[0],
								mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION));
						mapValidacionCostos.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA, campoTmp);
					}
					// PVP S
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI);
						campoTmp = validacionesParaControlCostos(celdaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI), numeroFila, numeColumnaTmp, observaciones, esFilaValida, parametroIngresarDatos, objectListCarDin[0],
								mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION));
						mapValidacionCostos.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI, campoTmp);
					}
					// Venta solo afiliado
					if (camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO)) {
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO);
						campoTmp = validacionesParaControlCostos(celdaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO), numeroFila, numeColumnaTmp, observaciones, esFilaValida, parametroIngresarDatos, objectListCarDin[0],
								mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION));
						mapValidacionCostos.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO, campoTmp);
						datosValidados.put(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO, campoTmp);
					}
					/********************************************** LLENAR**COSTOS**FIN ****************************************************************************************************/

					catalogosCabeceraImpuestos = new ArrayList<CatalogoValorDTO>();
					
					for (CatalogoValorDTO dto : lstCabecerasCatalogoValorDTO) {
						orden = Integer.valueOf(dto.getOrden());
						if (StringUtils.equals(dto.getId().getCodigoCatalogoValor(), SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_VENTA)) {
							cabecera = dto.getNombreCatalogoValor();
							catalogosCabeceraImpuestos.add(dto);
						} else if (StringUtils.equals(dto.getId().getCodigoCatalogoValor(), SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_COMPRA)) {
							cabecera = dto.getNombreCatalogoValor();
							catalogosCabeceraImpuestos.add(dto);
						} else {
							cabecera = dto.getId().getCodigoCatalogoValor();
						}
						celda = (Cell) datosParaValidar.get(numeroFila, orden, cabecera);
						if (StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR)) {
							campo = validaciones(celda, cabecerasMapa, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, orden, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, dto, catalogosCabeceraImpuestos);

							objectProvedor = new LinkedList<String>();
							for (String p : condicionesProveedor) {
								objectProvedor.add(p);
							}
							datosValidados.put(numeroFila, orden, cabecera, objectProvedor);
						} else if (StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA)) {
							String uni = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celda));
							if(uni.isEmpty() || uni.equals(" ")){
								campo = uni;
							}else{
								campo = validacionesUnidadMedida(celda, dto.getNombreCatalogoValor(), numeroFila, orden, observaciones, objectList, condicionesUnidadMedida, esFilaValida);
							}
							condicionesUnidadMedida[0] = campo;
							objectUnidadMedida = new LinkedList<String>();
							for (String um : condicionesUnidadMedida) {
								objectUnidadMedida.add(um);
							}
							datosValidados.put(numeroFila, orden, cabecera, objectUnidadMedida);
						} else if (StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN) || StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO)) {
							campo = validacionesRegistroSanitario(registroSanitario, fechaCaducidadRegSan, cabecera, cabecerasMapa, numeroFila, orden, observaciones, esFilaValida);
							datosValidados.put(numeroFila, orden, cabecera, campo);
						} else if (StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada"))
								&& (StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA) || StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA))) {
							if (StringUtils.isNotEmpty(StringUtils.trim(fechaInicioTemporada)) || StringUtils.isNotEmpty(StringUtils.trim(fechaFinalTemporada))) {
								campo = validacionesFechaInicioFin(fechaInicioTemporada, fechaFinalTemporada, cabecerasMapa, cabecera, numeroFila, orden, observaciones, esFilaValida);
								datosValidados.put(numeroFila, orden, cabecera, campo);
							}
						} else if (!StringUtils.equals(cabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO) && !StringUtils.equals(cabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO) && !StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1)
								&& !StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2) && !StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3) && !StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4)
								&& !StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA) && !StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI) && !StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS)) {
							campo = validaciones(celda, cabecerasMapa, cabecera, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, orden, observaciones, objectList, objectListCarDin, condicionesProveedor, esFilaValida, parametroIngresarDatos, condicionesClasificacion, dto, catalogosCabeceraImpuestos);
							datosValidados.put(numeroFila, orden, cabecera, campo);
						}
					}

					if (MapUtils.isNotEmpty(mapValidacionCostos) && MapUtils.isNotEmpty(camposNecesarios)) {
						validarCostosIngresados(codigoCompania, mapValidacionCostos, mapCamposReqValidacion, mapCamposImpuestos, numeroFila, camposNecesarios, observaciones, esFilaValida, objectListCarDin, condicionesClasificacion);
					}
					// SE PROCEDE A AGRUPAR LOS DATOS PARA ESCOGER SOLO LAS
					// FILAS VALIDAS
					datosValidadosTmp = agruparDatosMapa(datosValidados, numeroFila, esFilaValida[0], lstCabecerasCatalogoValorDTO);
					if (MapUtils.isNotEmpty(datosValidadosTmp)) {
						datosValidadosAgrupados.putAll(datosValidadosTmp);
					}
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("HA OCURRIDO UN ERROR AL VALIDAR LOS DATOS DEL MAPA. {}", e.getMessage());
		} finally {
			celdaTmp = null;
			celda = null;
			datosValidados = null;
			datosValidadosTmp = null;
			objectProvedor = null;
			mapCamposReqValidacion = null;
		}

		return datosValidadosAgrupados;
	}

	/**
	 * METODO PARA AGRUPAR LOS DATOS VALIDOS DEL MAPA DATOSVALIDADOSTMP
	 * 
	 * @param datosValidados
	 * @param numeroFila
	 * @param esFilaValida
	 * @param lstCabecerasCatalogoValorDTO
	 * @return
	 * @author eharo
	 */
	@SuppressWarnings("unchecked")
	private MultiKeyMap agruparDatosMapa(MultiKeyMap datosValidados, Integer numeroFila, boolean esFilaValida, Collection<CatalogoValorDTO> lstCabecerasCatalogoValorDTO) {
		MultiKeyMap datosValidadosAgrupados = null;
		Integer orden = null;
		String cabecera = StringUtils.EMPTY;
		String campo = StringUtils.EMPTY;
		LinkedList<String> condicionesProveedor = null;
		LinkedList<String> condicionesUnidadMedida = null;
		try {
			LOG_SICV2.info("SE AGRUPA LOS DATOS DEL MAPA");
			if (esFilaValida) {
				datosValidadosAgrupados = new MultiKeyMap();
				for (CatalogoValorDTO dto : lstCabecerasCatalogoValorDTO) {
					orden = Integer.valueOf(dto.getOrden());
					cabecera = dto.getId().getCodigoCatalogoValor();
					if (StringUtils.equals(dto.getId().getCodigoCatalogoValor(), SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_VENTA)) {
						cabecera = dto.getNombreCatalogoValor();
					} else if (StringUtils.equals(dto.getId().getCodigoCatalogoValor(), SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_COMPRA)) {
						cabecera = dto.getNombreCatalogoValor();
					} else {
						cabecera = dto.getId().getCodigoCatalogoValor();
					}// SE AGREGAN SOLO LOS DATOS QUE SON FILA VALIDA
					if (StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR)) {
						condicionesProveedor = (LinkedList<String>) datosValidados.get(numeroFila, orden, cabecera);
						datosValidadosAgrupados.put(numeroFila, cabecera, condicionesProveedor);
					} else if (StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA)) {
						condicionesUnidadMedida = (LinkedList<String>) datosValidados.get(numeroFila, orden, cabecera);
						datosValidadosAgrupados.put(numeroFila, cabecera, condicionesUnidadMedida);
					} else {
						campo = (String) datosValidados.get(numeroFila, orden, cabecera);
						datosValidadosAgrupados.put(numeroFila, cabecera, campo);
					}
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("HA OCURRIDO UN ERROR AL AGRUPAR LOS DATOS DEL MAPA. {}", e.getMessage());
		}
		return datosValidadosAgrupados;
	}

	/**
	 * METODO QUE VALIDA EL CONTROL DE COSTOS
	 * 
	 * @param celdaExcel
	 * @param nombreCatalogoValor
	 * @param numeroFila
	 * @param numeroColumna
	 * @param observaciones
	 * @param esFilaValida
	 * @param parametroIngresoDatos
	 * @return
	 * @author eharo
	 */
	@SuppressWarnings("incomplete-switch")
	private String validacionesParaControlCostos(Cell celdaExcel, String codigoCatalogoValor, String nombreCatalogoValor, Integer numeroFila, Integer numeroColumna, List<String> observaciones, boolean esFilaValida[], String parametroIngresoDatos, LinkedHashMap<String, Set<EnumCaracteristicaDinamica>> carDinMap, String codigoClasificacion) {

		String campo = StringUtils.EMPTY;
		Set<EnumCaracteristicaDinamica> caracteristicasDinamicasLista = null;
		EnumCreacionPorArchivoCabecera key = null;
		try {
			if (StringUtils.isNotEmpty(codigoCatalogoValor)) {
				key = EnumCreacionPorArchivoCabecera.valueOfNombre(codigoCatalogoValor);
				if (key != null) {
					switch (key) {
					case CABECERA_COSTO_BRUTO:
						campo = validacionArticuloCampos.validacionesCostoBruto(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 8, 4);
						break;
					case CABECERA_DES1:
						campo = validacionArticuloCampos.validacionesDescuentos(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 2, 2);
						break;
					case CABECERA_DES2:
						campo = validacionArticuloCampos.validacionesDescuentos(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 2, 2);
						break;
					case CABECERA_DES3:
						campo = validacionArticuloCampos.validacionesDescuentos(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 2, 2);
						break;
					case CABECERA_DES4:
						campo = validacionArticuloCampos.validacionesDescuentos(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 2, 2);
						break;
					case CABECERA_PRECIO_VENTA:
						caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
						if (caracteristicasDinamicasLista == null || (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && !caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_NOAPLICAPVP))) {
							if (validacionArticuloCampos.validarCaracteristicaDinamica(parsearValor(obtenerValorCeldaString(celdaExcel)), numeroFila, numeroColumna, nombreCatalogoValor, EnumCaracteristicaDinamica.CARACTERISTICA_NOAPLICAPVP, observaciones, esFilaValida)) {
								campo = validacionArticuloCampos.validacionesPrecios(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 8, 2);
							}
						}
						break;
					case CABECERA_PRECIO_SUPERMAXI:
						campo = validacionArticuloCampos.validacionesPrecios(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 8, 2);
						break;
					case CABECERA_VENTA_PRECIO_AFILIADO:
						campo = validacionArticuloCampos.validacionesVentaPrecioAfiliado(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, parametroIngresoDatos, esFilaValida);
						break;
					}
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en la validacion de los campos de costos. {}", e.getMessage());
		}
		return campo;
	}

	/**
	 * METODO PARA VALIDAR EL CODIGO DE BARRAS
	 * 
	 * @param celdaExcel
	 * @param mapCamposReqValidacion
	 * @param numeroFila
	 * @param numeroColumna
	 * @param observaciones
	 * @param objectList
	 * @param esFilaValida
	 * @return
	 * @author eharo
	 */
	private String validacionesParaCodigoBarras(Cell celdaExcel, LinkedHashMap<String, String> mapCamposReqValidacion, Integer numeroFila, Integer numeroColumna, List<String> observaciones, Set[] objectList, boolean esFilaValida[]) {
		String campo = StringUtils.EMPTY;
		try {
			campo = validacionesCodigoBarras(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, Integer.valueOf(String.valueOf(mapCamposReqValidacion.get("CODIGOCOMPANIA"))), esFilaValida);
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al validar el codigo de barras: {}", e.getMessage());
		}
		return campo;
	}

	/**
	 * @param celdaExcel
	 * @param nombreCatalogoValor
	 * @param mapCamposReqValidacion
	 * @param numeroFila
	 * @param numeroColumna
	 * @param observaciones
	 * @param objectList
	 * @param condicionesProveedor
	 * @param esFilaValida
	 * @param parametroIngresoDatos
	 * @return
	 * @author eharo
	 */
	@SuppressWarnings({ "unchecked", "incomplete-switch" })
	private String validaciones(Cell celdaExcel, Map<String, String> cabecerasMapa, String nombreCatalogoValor, LinkedHashMap<String, String> mapCamposReqValidacion, LinkedHashMap<String, String> mapCamposImpuestos, Integer numeroFila, Integer numeroColumna, List<String> observaciones, Set[] objectList, LinkedHashMap[] objectListCarDin, String[] condicionesProveedor, boolean esFilaValida[],
			String parametroIngresoDatos, String[] condicionesClasificacion, CatalogoValorDTO catalogoValor, Collection<CatalogoValorDTO> catalogosCabeceraImpuestos) {

		String campo = StringUtils.EMPTY;
		String codigoClasificacion = StringUtils.EMPTY;
		String codigoProveedor = StringUtils.EMPTY;
		String origenProveedor = StringUtils.EMPTY;
		String proveedorImportador = StringUtils.EMPTY;
		String controlPrecios = StringUtils.EMPTY;
		String empaque = StringUtils.EMPTY;
		String codigoFuncionario = StringUtils.EMPTY;
		Integer codigoCompania = null;
		String codigoCabecera = null;
		//C\u00F3digo del pa\u00EDs de fecbricaci\u00F3n
		String codigoDivGeoPol = null;
		LinkedList<String> codigosCabecera = null;
		Set<EnumCaracteristicaDinamica> caracteristicasDinamicasLista = null;
		LinkedHashMap<String, Set<EnumCaracteristicaDinamica>> carDinMap = null;

		EnumCreacionPorArchivoCabecera key = null;
		try {

			if (StringUtils.isNotEmpty(nombreCatalogoValor)) {
				codigoClasificacion = mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION);
				codigoProveedor = mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR);
				controlPrecios = mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS);
				codigoCompania = Integer.valueOf(mapCamposReqValidacion.get("CODIGOCOMPANIA"));
				origenProveedor = mapCamposReqValidacion.get("ORIGENPROVEEDOR");
				proveedorImportador = mapCamposReqValidacion.get("PROVEEDORIMPORTADOR");
				codigoFuncionario = mapCamposReqValidacion.get("FUNCIONARIOID");
				empaque = mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE);
				//Obteniendo el c\u00F3digo del pa\u00EDs de fabricaci\u00F3n
				codigoDivGeoPol = mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN);

				key = EnumCreacionPorArchivoCabecera.valueOfNombre(nombreCatalogoValor);
				if (key != null) {
					switch (key) {
					case CABECERA_CODIGO_PROVEEDOR:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR);
						campo = validacionesProveedor(celdaExcel, objectList, numeroColumna, numeroFila, codigoCompania, observaciones, condicionesProveedor, esFilaValida, codigoCabecera);
						break;
					case CABECERA_CODIGO_CLASIFICACION:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION);
						campo = validacionesClasificacion(celdaExcel, objectList, objectListCarDin, observaciones, numeroColumna, numeroFila, codigoCompania, esFilaValida, codigoFuncionario, codigoCabecera, condicionesClasificacion);
						break;
					case CABECERA_CODIGO_SUBCLASIFICACION:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_SUBCLASIFICACION);
						campo = validacionesSubClasificaion(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, codigoCompania, codigoClasificacion, esFilaValida, codigoCabecera);
						break;
					// case CABECERA_CODIGO_BARRAS :
					// campo = validacionesCodigoBarras(celdaExcel, objectList,
					// observaciones, numeroColumna, numeroFila, codigoCompania,
					// esFilaValida);
					// break;
					case CABECERA_DESCRIPCION:
						campo = validacionArticuloCampos.validacionesDescripcion(celdaExcel, observaciones, numeroFila, numeroColumna, esFilaValida);
						break;
					case CABECERA_CLASE:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE);
						campo = validacionesClase(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, codigoCompania, esFilaValida, codigoCabecera);
						break;
					case CABECERA_UNIDAD_MANEJO:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MANEJO);
						campo = validacionArticuloCampos.validacionesUnidadManejo(celdaExcel, observaciones, numeroFila, numeroColumna, esFilaValida, empaque, codigoCabecera);
						break;
					case CABECERA_EAN14:
						campo = validacionesEAN14(celdaExcel, objectList, observaciones, mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS), numeroColumna, numeroFila, codigoCompania, esFilaValida);
						break;
					case CABECERA_COSTO_MONEDA_ORIGEN:
						codigosCabecera = new LinkedList<String>();
						codigosCabecera.add(cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR));
						codigosCabecera.add(cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_MONEDA_ORIGEN));
						campo = validacionArticuloCampos.validacionesCostoMonedaOrigen(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, origenProveedor, proveedorImportador, esFilaValida, codigosCabecera);
						
						String moneda = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celdaExcel));
						if((moneda.equals(" ")||moneda.isEmpty())){
							if(!proveedorImportador.equals("1")){
								validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.TRUE);
								break;
							}
						}
						
						if(!proveedorImportador.equals("1")){
							String mensajeError = "El campo COSTO MODEDA ORIGEN no se registra porque este proveedor no es importador ";
							mensajeError = StringUtils.replace(mensajeError, ",", ".");
							String observacion = String.valueOf(numeroFila) + "," + numeroColumna + "," + mensajeError;
							observaciones.add(observacion);
							validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
							observaciones.add(observacion);
						}
						break;
					case CABECERA_TAMANIO:
						carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
						// caracteristicasDinamicasLista =
						// obtenerCaracteristicasDinamicas(codigoCompania,
						// codigoClasificacion);
						caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
						if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEPRESENTACIONES)) {
							codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_TAMANIO);
							campo = validacionArticuloCampos.validacionesTamanio(celdaExcel, observaciones, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
							
						}else{
							String tamanio = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celdaExcel));
							if(tamanio.isEmpty()||tamanio.equals(" ")) break;
								String mensajeError = "El campo TAMA\u00D1O no se registra porque la  clasificaci\u00F3n " + codigoClasificacion + " no tiene registrada la caracter\u00EDstica din\u00E1mica CARACTERISTICA_TIENEPRESENTACIONES ";
								mensajeError = StringUtils.replace(mensajeError, ",", ".");
								String observacion = String.valueOf(numeroFila) + "," + numeroColumna + "," + mensajeError;
								observaciones.add(observacion);
								validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
								observaciones.add(observacion);
						}
						break;
					case CABECERA_MARCA:
						codigosCabecera = new LinkedList<String>();
						codigosCabecera.add(cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_PROVEEDOR));
						codigosCabecera.add(cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_MARCA));
						campo = validacionesMarca(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, codigoCompania, codigoProveedor, esFilaValida, codigosCabecera);
						break;
					case CABECERA_MARCA_PARTICIPACION:
						campo = validacionArticuloCampos.validacionesMarcaParticipacion(celdaExcel, observaciones, numeroFila, numeroColumna, esFilaValida);
						break;
					case CABECERA_GARANTIA:
						carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
						caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
						// caracteristicasDinamicasLista =
						// obtenerCaracteristicasDinamicas(codigoCompania,
						// codigoClasificacion);
						if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEGARANTIA)) {
							codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_GARANTIA);
							campo = validacionArticuloCampos.validacionesGarantia(celdaExcel, observaciones, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
							
						} else {
							String garantia = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celdaExcel));
							if (garantia.isEmpty() || garantia.equals(" ")) break;
								String mensajeError = "El campo GARANTIA no se registra porque la clasificaci\u00F3n " + codigoClasificacion + " no tiene registrada la caracter\u00EDstica din\u00E1mica TIENE GARANTIA ";
								mensajeError = StringUtils.replace(mensajeError, ",", ".");
								String observacion = String.valueOf(numeroFila) + "," + numeroColumna + "," + mensajeError;
								observaciones.add(observacion);
								validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
								observaciones.add(observacion);
						}
						break;
					case CABECERA_REFERENCIA:
						campo = validacionArticuloCampos.validacionesReferencia(celdaExcel, observaciones, numeroFila, numeroColumna, esFilaValida);
						break;
					case CABECERA_REFERENCIA_INTERNA:
						campo = validacionArticuloCampos.validacionesReferenciaInterna(celdaExcel, observaciones, numeroFila, numeroColumna, esFilaValida);
						break;
					case CABECERA_ALCANCE_PROTOTIPO:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_ALCANCE_PROTOTIPO);
						//validaciones de la caracteristica dinamica
						carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
						caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
						boolean omisionValidacionAlcances = CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_VALIDACION_OMISION_ASIGNACION_ALCANCES);
						campo = validacionesAlcancePrototipo(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, codigoCompania, esFilaValida, codigoCabecera , omisionValidacionAlcances);
						break;
					case CABECERA_AGRUPADOR:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_AGRUPADOR);
						campo = validacionesAgrupador(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, esFilaValida, codigoCabecera);
						break;
					case CABECERA_CANTIDAD_MEDIDA:
						carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
						caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
						// caracteristicasDinamicasLista =
						// obtenerCaracteristicasDinamicas(codigoCompania,
						// codigoClasificacion);
						if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEPRESENTACIONES)) {
							codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CANTIDAD_MEDIDA);
							campo = validacionArticuloCampos.validacionesMedidas(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 8, 2, codigoCabecera);
						} else {
							String cmedida = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celdaExcel));
							if (cmedida.isEmpty() || cmedida.equals(" ")) break;
								String mensajeError = "El campo CANTIDAD DE MEDIDA no se registra porque la clasificaci\u00F3n " + codigoClasificacion + " no tiene registrada la caracter\u00EDstica din\u00E1mica TIENE PRESENTACIONES  ";
								mensajeError = StringUtils.replace(mensajeError, ",", ".");
								String observacion = String.valueOf(numeroFila) + "," + numeroColumna + "," + mensajeError;
								observaciones.add(observacion);
								validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
								observaciones.add(observacion);
							
						}
						break;
					case CABECERA_UNIDAD_MEDIDA:
						carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
						caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
						if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEPRESENTACIONES)) {
							codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_UNIDAD_MEDIDA);
							campo = validacionArticuloCampos.validacionesMedidas(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 8, 2, codigoCabecera);
						} else {
							String umedida = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celdaExcel));
							if (umedida.isEmpty() || umedida.equals(" ")) {
								validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.TRUE);
								break;
							}
								String mensajeError = "El campo UNIDAD DE MEDIDA no se registra porque la clasificaci\u00F3n " + codigoClasificacion + " no tiene registrada la caracter\u00EDstica din\u00E1mica TIENE PRESENTACIONES  ";
								mensajeError = StringUtils.replace(mensajeError, ",", ".");
								String observacion = String.valueOf(numeroFila) + "," + numeroColumna + "," + mensajeError;
								observaciones.add(observacion);
								validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
								observaciones.add(observacion);
						}
						break;
					case CABECERA_EMPAQUE:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_EMPAQUE);
						campo = validacionesEmpaque(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, esFilaValida, codigoCabecera);
						break;
					case CABECERA_IMPORTANCIA:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPORTANCIA);
						campo = validacionesImportancia(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, codigoCompania, esFilaValida, codigoCabecera);
						break;
					case CABECERA_PLAZO_PAGO:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PLAZO_PAGO);
						campo = validacionesPlazoPago(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, codigoCompania, esFilaValida, codigoCabecera);
						break;
					case CABECERA_CONTROL_PRECIOS:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS);
						campo = validacionesConstrolPrecios(celdaExcel, objectList, numeroColumna, numeroFila, observaciones, esFilaValida, mapCamposReqValidacion, codigoCabecera);
						break;
					case CABECERA_TIPO_SECUENCIA:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA);
						campo = validacionesTipoSecuencia(celdaExcel, objectList, numeroColumna, numeroFila, observaciones, esFilaValida, codigoCabecera);
						break;
					case CABECERA_DURACION_CONS_LOCAL:
						if (StringUtils.isNotEmpty(StringUtils.trim(obtenerValorCeldaString(celdaExcel)))) {
							carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
							caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
							// caracteristicasDinamicasLista =
							// obtenerCaracteristicasDinamicas(codigoCompania,
							// codigoClasificacion);
							if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_LOCAL)) {
								codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_LOCAL);
								if (validacionArticuloCampos.validarCaracteristicaDinamica(parsearValor(obtenerValorCeldaString(celdaExcel)), numeroFila, numeroColumna, codigoCabecera, EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_LOCAL, observaciones, esFilaValida)) {
									campo = validacionArticuloCampos.validacionesDuracionConservacion(celdaExcel, observaciones, numeroFila, numeroColumna, codigoCabecera, esFilaValida, 6, 0);
								}
							}else {
								String local = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celdaExcel));
								if (local.isEmpty() || local.equals(" ")) break;
									String mensajeError = "No se especifica : CARACTERISTICA_VIDA UTIL ";
									mensajeError = StringUtils.replace(mensajeError, ",", ".");
									String observacion = String.valueOf(numeroFila) + "," + numeroColumna + "," + mensajeError;
									observaciones.add(observacion);
									validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
									observaciones.add(observacion);
							}
						} else {
							campo = StringUtils.EMPTY;
						}
						break;
					case CABECERA_DURACION_CONS_REFRIGERADO:

						if (StringUtils.isNotEmpty(StringUtils.trim(obtenerValorCeldaString(celdaExcel)))) {
							carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
							caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
							// caracteristicasDinamicasLista =
							// obtenerCaracteristicasDinamicas(codigoCompania,
							// codigoClasificacion);
							if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_REFRIGERADO)) {
								codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_REFRIGERADO);
								if (validacionArticuloCampos.validarCaracteristicaDinamica(parsearValor(obtenerValorCeldaString(celdaExcel)), numeroFila, numeroColumna, codigoCabecera, EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_REFRIGERADO, observaciones, esFilaValida)) {
									campo = validacionArticuloCampos.validacionesDuracionConservacion(celdaExcel, observaciones, numeroFila, numeroColumna, codigoCabecera, esFilaValida, 6, 0);
								}
							}else{
								String refrigerado = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celdaExcel));
								if(refrigerado.isEmpty()||refrigerado.equals(" ")) break;
									String mensajeError = "El campo T.REFRIGERADO no se registra porque la clasificaci\u00F3n " + codigoClasificacion + " no tiene registrada la caracter\u00EDstica din\u00E1mica  CARACTERISTICA_TIENECONSERVACION_REFRIGERADO ";
									mensajeError = StringUtils.replace(mensajeError, ",", ".");
									String observacion = String.valueOf(numeroFila) + "," + numeroColumna + "," + mensajeError;
									observaciones.add(observacion);
									validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
									observaciones.add(observacion);
							}
						} else {
							campo = StringUtils.EMPTY;
						}
						break;
					case CABECERA_DURACION_CONS_CONGELADO:
						if (StringUtils.isNotEmpty(StringUtils.trim(obtenerValorCeldaString(celdaExcel)))) {
							carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
							caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
							// caracteristicasDinamicasLista =
							// obtenerCaracteristicasDinamicas(codigoCompania,
							// codigoClasificacion);
							if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_CONGELADO)) {
								codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DURACION_CONS_CONGELADO);
								if (validacionArticuloCampos.validarCaracteristicaDinamica(parsearValor(obtenerValorCeldaString(celdaExcel)), numeroFila, numeroColumna, codigoCabecera, EnumCaracteristicaDinamica.CARACTERISTICA_TIENECONSERVACION_CONGELADO, observaciones, esFilaValida)) {
									campo = validacionArticuloCampos.validacionesDuracionConservacion(celdaExcel, observaciones, numeroFila, numeroColumna, codigoCabecera, esFilaValida, 6, 0);
								}
							}else{
								String congelado = validacionArticuloCampos.parsearValor(validacionArticuloCampos.obtenerValorCeldaString(celdaExcel));
								if(congelado.isEmpty()||congelado.equals(" "))break;
									String mensajeError = "El campo T.CONGELADO no se registra porque la clasificaci\u00F3n " + codigoClasificacion + " no tiene registrada la caracter\u00EDstica din\u00E1mica CARACTERISTICA_TIENECONSERVACION_CONGELADO ";
									mensajeError = StringUtils.replace(mensajeError, ",", ".");
									String observacion = String.valueOf(numeroFila) + "," + numeroColumna + "," + mensajeError;
									observaciones.add(observacion);
									validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
									observaciones.add(observacion);
							}
						} else {
							campo = StringUtils.EMPTY;
						}
						break;
					//Validaci\u00F3n cuando el campo tiene una cabecera LUGAR COMPRA
					case CABECERA_LUGAR_COMPRA:
						//Obteniendo el c\u00F3digo de la cabecera
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_LUGAR_COMPRA);
						//Validando lugar de compra
						campo = validacionesLugarCompra(celdaExcel, objectList, codigoCompania, numeroColumna, numeroFila, observaciones, esFilaValida, codigoCabecera, codigoDivGeoPol);
						break;
					case CABECERA_PAIS_ORIGEN:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PAIS_ORIGEN);
						campo = validacionesPaisOrigen(celdaExcel, objectList, numeroColumna, numeroFila, observaciones, esFilaValida, codigoCabecera);
						break;
					case CABECERA_PESO_APROX_RECEPCION:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS);
						campo = validacionArticuloCampos.validacionesPesoAproximado(celdaExcel, observaciones, numeroFila, numeroColumna, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PESO_APROX_RECEPCION), esFilaValida, 8, 2, controlPrecios, codigoCabecera);
						break;
					case CABECERA_PESO_APROX_VENTA:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CONTROL_PRECIOS);
						campo = validacionArticuloCampos.validacionesPesoAproximado(celdaExcel, observaciones, numeroFila, numeroColumna, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PESO_APROX_VENTA), esFilaValida, 8, 2, controlPrecios, codigoCabecera);
						break;
					case CABECERA_PRESENTACION:
						carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
						caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
						if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEPRESENTACIONES)) {
							campo = validacionArticuloCampos.validacionesPresentacion(celdaExcel, observaciones, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida, 6, 0);
						}
						break;
					case CABECERA_TRANSGENICO:
						codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_TRANSGENICO);
						campo = validacionesTransgenico(celdaExcel, objectList, numeroColumna, numeroFila, observaciones, esFilaValida, codigoCabecera);
						break;
					case CABECERA_USOS:
						carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
						caracteristicasDinamicasLista = carDinMap.get(codigoClasificacion);
						if (CollectionUtils.isNotEmpty(caracteristicasDinamicasLista) && caracteristicasDinamicasLista.contains(EnumCaracteristicaDinamica.CARACTERISTICA_TIENEUSOS)) {
							codigoCabecera = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_USOS);
							campo = validacionesUsos(celdaExcel, objectList, numeroColumna, numeroFila, observaciones, esFilaValida, codigoCabecera);
						}
						break;
					}
				} else {
					campo = validarIngresoImpuestos(celdaExcel, mapCamposImpuestos, esFilaValida, parametroIngresoDatos, nombreCatalogoValor, numeroFila, numeroColumna, observaciones, catalogoValor, catalogosCabeceraImpuestos);
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("HA OCURRIDO UN ERROR AL ESCOGER EL CASO DE VALIDACION: {}. {}", key.getNombreFormato(), e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion : " +
			// key.getNombreFormato(), e.getMessage());
		} finally {
			key = null;
		}
		return campo;
	}

	/*******************************************************************************************************************************************************************/
	/****************************************************** VALIDACIONES CAMPOS INICIO ***********************************************************************************/
	/*******************************************************************************************************************************************************************/

	@SuppressWarnings("unchecked")
	private void validarCostosIngresados(Integer codigoCompania, LinkedHashMap<String, String> valoresCostos, LinkedHashMap<String, String> mapCamposReqValidacion, LinkedHashMap<String, String> mapCamposImpuestos, Integer numeroFila, LinkedHashMap<String, Integer> camposNecesarios, List<String> observaciones, boolean esFilaValida[], LinkedHashMap objectListCarDin[],
			String[] condicionesClasificacion) {

		String costoBruto = StringUtils.EMPTY;
		String des1 = StringUtils.EMPTY;
		String des2 = StringUtils.EMPTY;
		String des3 = StringUtils.EMPTY;
		String des4 = StringUtils.EMPTY;
		String precioVenta = StringUtils.EMPTY;
		String precioSupermaxi = StringUtils.EMPTY;
		String codigoClasificacion = StringUtils.EMPTY;
		String presentacion = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		Boolean ventaPrecioAfiliado = null;
		Double porcentajeNA = null;
		Collection<DescuentoProveedorArticuloDTO> lstDescuentos = null;
		Collection<ArticuloPrecioDTO> lstPrecios = null;
		Set<EnumCaracteristicaDinamica> caracteristicasDinamicas = null;
		Collection<ArticuloImpuestoDTO> lstImpuestos = null;
		LinkedHashMap<String, Set<EnumCaracteristicaDinamica>> carDinMap = null;
		try {
			if (MapUtils.isNotEmpty(valoresCostos) && MapUtils.isNotEmpty(mapCamposReqValidacion) && condicionesClasificacion != null) {

				costoBruto = valoresCostos.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_COSTO_BRUTO);
				des1 = valoresCostos.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES1);
				des2 = valoresCostos.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES2);
				des3 = valoresCostos.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES3);
				des4 = valoresCostos.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_DES4);
				precioVenta = valoresCostos.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_VENTA);
				precioSupermaxi = valoresCostos.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI);
				codigoClasificacion = mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_CLASIFICACION);
				if (condicionesClasificacion[1] != null) {
					porcentajeNA = Double.valueOf(condicionesClasificacion[1]);
				}
				ventaPrecioAfiliado = Boolean.valueOf(valoresCostos.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_VENTA_PRECIO_AFILIADO));
				presentacion = StringUtils.isNotEmpty(StringUtils.trim(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION))) ? mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRESENTACION) : "1";

				lstDescuentos = new ArrayList<DescuentoProveedorArticuloDTO>();
				llenarListaDescuentos(lstDescuentos, codigoCompania, des1, des2, des3, des4);
				lstPrecios = new ArrayList<ArticuloPrecioDTO>();
				llenarListaPrecios(lstPrecios, codigoCompania, precioVenta, precioSupermaxi);
				if (StringUtils.isNotEmpty(StringUtils.trim(codigoClasificacion))) {
					carDinMap = objectListCarDin[0] == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : objectListCarDin[0];
					caracteristicasDinamicas = carDinMap.get(codigoClasificacion);
				}
				lstImpuestos = new ArrayList<ArticuloImpuestoDTO>();
				if (MapUtils.isNotEmpty(mapCamposImpuestos)) {
					obtenerImpuestos(mapCamposImpuestos, lstImpuestos);
				}
				if (StringUtils.isEmpty(StringUtils.trim(precioVenta))) {
					validacionReglasComerciales.validarPreciosCostos(Integer.valueOf(presentacion), ventaPrecioAfiliado, porcentajeNA, Double.valueOf(costoBruto), Double.valueOf(precioSupermaxi), null, lstImpuestos, lstDescuentos, caracteristicasDinamicas);
				} else {
					validacionReglasComerciales.validarPreciosCostos(Integer.valueOf(presentacion), ventaPrecioAfiliado, porcentajeNA, Double.valueOf(costoBruto), Double.valueOf(precioSupermaxi), Double.valueOf(precioVenta), lstImpuestos, lstDescuentos, caracteristicasDinamicas);
				}
			}
		} catch (SICRuleException ex) {
			LOG_SICV2.error("Ha ocurrido un error en la validacion de costos. {} ", ex.getMessage());
			String mensajeError = ex.getMessage();
			mensajeError = StringUtils.replace(mensajeError, ",", ".");
			observacion = String.valueOf(numeroFila) + "," + camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI) + "," + mensajeError;
			observaciones.add(observacion);
			validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en la validacion de costos. {} ", e.getMessage());
			String mensajeError = e.getMessage();
			mensajeError = StringUtils.replace(mensajeError, ",", ".");
			observacion = String.valueOf(numeroFila) + "," + camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_PRECIO_SUPERMAXI) + "," + mensajeError;
			observaciones.add(observacion);
			validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
		}
	}

	private void obtenerImpuestos(LinkedHashMap<String, String> mapCamposImpuestos, Collection<ArticuloImpuestoDTO> lstImpuestos) {
		ArticuloImpuestoDTO articuloImpuestoDTO = null;
		TipoImpuestoDTO tipoImpuestoDTO = null;
		Collection<TipoImpuestoDTO> impuestoDTOs = null;
		StringBuilder codigoImpuestoCompra = null;
		StringBuilder codigoImpuestoVenta = null;

		String obtenerValorImpuestoCompra = StringUtils.EMPTY;
		String obtenerValorImpuestoVenta = StringUtils.EMPTY;

		Boolean seIngresaImpuestoCompraBoolean = Boolean.FALSE;
		Boolean seIngresaImpuestoVentaBoolean = Boolean.FALSE;
		try {
			tipoImpuestoDTO = new TipoImpuestoDTO();
			tipoImpuestoDTO.setEstadoTipoImpuesto(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			impuestoDTOs = dataGestor.findObjects(tipoImpuestoDTO);

			if (impuestoDTOs != null) {
				for (TipoImpuestoDTO impuesto : impuestoDTOs) {
					codigoImpuestoCompra = new StringBuilder(impuesto.getNombreTipoImpuesto());
					codigoImpuestoVenta = new StringBuilder(impuesto.getNombreTipoImpuesto());

					if (impuesto.getId().getCodigoTipoImpuesto() != null && impuesto.getId().getCodigoTipoImpuesto().compareTo(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVE) != 0) {

						codigoImpuestoCompra.append(impuesto.getPorcentajeImpuesto().intValue());
						codigoImpuestoVenta.append(impuesto.getPorcentajeImpuesto().intValue());
					}
					
					codigoImpuestoCompra.append(SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_COMPRA);
					codigoImpuestoVenta.append(SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_VENTA);

					obtenerValorImpuestoCompra = mapCamposImpuestos.get(String.valueOf(codigoImpuestoCompra));
					obtenerValorImpuestoVenta = mapCamposImpuestos.get(String.valueOf(codigoImpuestoVenta));

					if (obtenerValorImpuestoCompra != null && obtenerValorImpuestoVenta != null) {
						seIngresaImpuestoCompraBoolean = Boolean.valueOf(obtenerValorImpuestoCompra);
						seIngresaImpuestoVentaBoolean = Boolean.valueOf(obtenerValorImpuestoVenta);

						articuloImpuestoDTO = new ArticuloImpuestoDTO();
						articuloImpuestoDTO.getId().setCodigoTipoImpuesto(impuesto.getId().getCodigoTipoImpuesto());
						articuloImpuestoDTO.setEstadoArticuloImpuesto(SICConstantes.ESTADO_ACTIVO_NUMERICO);
						articuloImpuestoDTO.setEsParaCompra(seIngresaImpuestoCompraBoolean);
						articuloImpuestoDTO.setEsParaVenta(seIngresaImpuestoVentaBoolean);
						articuloImpuestoDTO.setTipoImpuestoArticulo(impuesto);

						lstImpuestos.add(articuloImpuestoDTO);
					}
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en obtener impuestos. {} ", e.getMessage());
			// throw new
			// SICException("Ha ocurrido un error en obtener impuestos. {} ",e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private Set<EnumCaracteristicaDinamica> obtenerCaracteristicasDinamicas(Integer codigoCompania, String codigoClasificacion) {
		Set<EnumCaracteristicaDinamica> caracteristicaDinamicaDTOs = null;
		CaracteristicaDinamicaDTO caracteristicaDinamicaDTO = null;
		try {
			caracteristicaDinamicaDTO = new CaracteristicaDinamicaDTO();

			List<Integer> codigosCaracteristicaDinamica = new ArrayList<Integer>();
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_VERIFICA_FECHACADUCIDAD);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_TIENEGARANTIA);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_TIENEUSOS);
			codigosCaracteristicaDinamica.add(SICArticuloConstantes.getInstancia().CODIGOCATALOGOTIPOCONSERVACION);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_CALCULO_PRECIO);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_TIENEPRESENTACIONES);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_NOAPLICAPVP);
			codigosCaracteristicaDinamica.add(TipoCatalogoArticulo.CARACTERISTICA_OMISION_ASIGNACION_ALCANCES);

			caracteristicaDinamicaDTO.addCriteriaSearchParameter("codigoTipoCaracteristica", ComparatorTypeEnum.IN_COMPARATOR, codigosCaracteristicaDinamica);
			caracteristicaDinamicaDTO.setCodigoClasificacion(codigoClasificacion);
			caracteristicaDinamicaDTO.setCodigoCompania(codigoCompania);
			caracteristicaDinamicaDTOs = CaracteristicaDinamicaUtil.transformarCaracteristicasDinamicas(this.dataGestor.findObjects(caracteristicaDinamicaDTO));
		} catch (Exception e) {
			LOG_SICV2.error("HA OCURRIDO UN ERROR AL CONSULTAR LAS CARACTERISTICAS DINAMICAS {}", e.getMessage());
			// throw new
			// SICException("Error al consultar ls carecteristicas dinamicas {}",
			// e.getMessage());
		} finally {
			caracteristicaDinamicaDTO = null;
		}
		return caracteristicaDinamicaDTOs;
	}

	private ArticuloPrecioDTO obtenerPrecio(Integer codigoCompania, String tipoPrecio, String precio) {
		ArticuloPrecioDTO articuloPrecio = null;
		try {
			if (codigoCompania != null && StringUtils.isNotEmpty(StringUtils.trim(tipoPrecio)) && StringUtils.isNotEmpty(StringUtils.trim(precio))) {
				articuloPrecio = new ArticuloPrecioDTO();
				articuloPrecio.getId().setCodigoCompania(codigoCompania);
				articuloPrecio.getId().setCodigoTipoPrecio(tipoPrecio);
				articuloPrecio.setValorActual(Double.valueOf(precio));
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en la asignacion de precio. {} ", e.getMessage());
			// throw new
			// SICException("Ha ocurrido un error en la asignacion de precio. {} ",e.getMessage());
		}
		return articuloPrecio;
	}

	private void llenarListaPrecios(Collection<ArticuloPrecioDTO> lstPrecios, Integer codigoCompania, String precioVenta, String precioSupermaxi) {
		ArticuloPrecioDTO articuloPrecioVenta = null;
		ArticuloPrecioDTO articuloPrecioSupermaxi = null;
		try {
			if (lstPrecios != null && codigoCompania != null) {
				if (StringUtils.isNotEmpty(StringUtils.trim(precioVenta))) {
					articuloPrecioVenta = obtenerPrecio(codigoCompania, SICArticuloConstantes.getInstancia().TIPO_PRECIO_PVP, precioVenta);
					lstPrecios.add(articuloPrecioVenta);
				}
				if (StringUtils.isNotEmpty(StringUtils.trim(precioSupermaxi))) {
					articuloPrecioSupermaxi = obtenerPrecio(codigoCompania, SICArticuloConstantes.getInstancia().TIPO_PRECIO_BASE, precioSupermaxi);
					lstPrecios.add(articuloPrecioSupermaxi);
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en la asignacion de precio. {} ", e.getMessage());
			// throw new
			// SICException("Ha ocurrido un error en la asignacion de precio. {} ",e.getMessage());
		}
	}

	private DescuentoProveedorArticuloDTO obtenerDescuentos(Integer codigoCompania, String tipoDescuento, String valorDescuento, Collection<AsignacionTipoDescuentoDTO> asignacionTipoDescuentoCol) {
		DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO = null;
		try {
			if (StringUtils.isNotEmpty(StringUtils.trim(tipoDescuento)) && StringUtils.isNotEmpty(StringUtils.trim(valorDescuento))) {
				descuentoProveedorArticuloDTO = new DescuentoProveedorArticuloDTO();
				descuentoProveedorArticuloDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
				descuentoProveedorArticuloDTO.setPorcentajeDescuento(Double.valueOf(valorDescuento));
				
				// <>TIPODESCUENTO
				if( CollectionUtils.isNotEmpty(asignacionTipoDescuentoCol) ){
					AsignacionTipoDescuentoDTO asigTipDes = (AsignacionTipoDescuentoDTO) CollectionUtils.find(asignacionTipoDescuentoCol, new BeanPredicate("codigoTipoDescuento", PredicateUtils.equalPredicate(tipoDescuento)));
					descuentoProveedorArticuloDTO.setSecuencialAsignacionTipoDescuento(asigTipDes.getId().getSecuencialAsignacionTipoDescuento());
					descuentoProveedorArticuloDTO.setAsignacionTipoDescuento(new AsignacionTipoDescuentoDTO());
					descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setCodigoTipoDescuento(asigTipDes.getCodigoTipoDescuento());
					descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setCodigoAplicacionTipoDescuento(asigTipDes.getCodigoAplicacionTipoDescuento());
					descuentoProveedorArticuloDTO.getAsignacionTipoDescuento().setValorAplicacionTipoDescuento(asigTipDes.getValorAplicacionTipoDescuento());
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en obtener descuentos. {} ", e.getMessage());
			// throw new
			// SICException("Ha ocurrido un error en obtener descuentos. {} ",e.getMessage());
		}
		return descuentoProveedorArticuloDTO;
	}
	
	/**
	 * Busca los tipos de descuentos del articulo (COMPRA, CONVENIO)
	 * @param codigoCompania
	 * @return
	 */
	private Collection<AsignacionTipoDescuentoDTO> buscarAsignacionTipoDescuentoCol(Integer codigoCompania)throws SICException{
		Collection<AsignacionTipoDescuentoDTO> asiTipoDes = null;
		try{			
			AsignacionTipoDescuentoDTO asignacionTipoDescuentoDTO = new AsignacionTipoDescuentoDTO();
			asignacionTipoDescuentoDTO.getId().setCodigoCompania(codigoCompania);
			asignacionTipoDescuentoDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			asignacionTipoDescuentoDTO.setCodigoAsignacionTipoDescuento(EnumTipoAsignacionDescuento.CODIGO_TIPO_ASIGNACION_DESCUENTO);
			asignacionTipoDescuentoDTO.setValorAsignacionTipoDescuento(EnumTipoAsignacionDescuento.ARTICULO.getValorTipoAsignacionDescuento());
			asignacionTipoDescuentoDTO.setCodigoAplicacionTipoDescuento(EnumTipoAplicacionDescuento.CODIGO_TIPO_APLICACION_DESCUENTO);
			asignacionTipoDescuentoDTO.addCriteriaSearchParameter(new CriteriaSearchParameter<String>("valorAplicacionTipoDescuento", ComparatorTypeEnum.IN_COMPARATOR, new String[] { EnumTipoAplicacionDescuento.COSTO_COMPRA.getValorTipoAplicacionDescuento(), EnumTipoAplicacionDescuento.COSTO_CONVENIO.getValorTipoAplicacionDescuento() }));
			asiTipoDes = SICFactory.getInstancia().administracion.getDataService().findObjects(asignacionTipoDescuentoDTO);
		}catch (SICException e) {
			Logeable.LOG_SICV2.error("Error al consultar los tipos de descuentos del art\u00EDculo.", e.getMessage());
			throw new SICException("Error al consultar los tipos de descuentos del art\u00EDculo.. {}",e.getMessage());
		}
		return asiTipoDes;
	}

	private void llenarListaDescuentos(Collection<DescuentoProveedorArticuloDTO> lstDescuentos, Integer codigoCompania, String des1, String des2, String des3, String des4) {
		DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO1 = null;
		DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO2 = null;
		DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO3 = null;
		DescuentoProveedorArticuloDTO descuentoProveedorArticuloDTO4 = null;
		try {
			if (lstDescuentos != null && codigoCompania != null) {
				Collection<AsignacionTipoDescuentoDTO> asignacionTipoDescuentoCol = buscarAsignacionTipoDescuentoCol(codigoCompania);
				if (StringUtils.isNotEmpty(StringUtils.trim(des1))) {
					descuentoProveedorArticuloDTO1 = obtenerDescuentos(codigoCompania, SICArticuloConstantes.getInstancia().TIPODESCUENTO1, des1, asignacionTipoDescuentoCol);
					lstDescuentos.add(descuentoProveedorArticuloDTO1);
				}
				if (StringUtils.isNotEmpty(StringUtils.trim(des2))) {
					descuentoProveedorArticuloDTO2 = obtenerDescuentos(codigoCompania, SICArticuloConstantes.getInstancia().TIPODESCUENTO2, des2 ,asignacionTipoDescuentoCol);
					lstDescuentos.add(descuentoProveedorArticuloDTO2);
				}
				if (StringUtils.isNotEmpty(StringUtils.trim(des3))) {
					descuentoProveedorArticuloDTO3 = obtenerDescuentos(codigoCompania, SICArticuloConstantes.getInstancia().TIPODESCUENTO3, des3, asignacionTipoDescuentoCol);
					lstDescuentos.add(descuentoProveedorArticuloDTO3);
				}
				if (StringUtils.isNotEmpty(StringUtils.trim(des4))) {
					descuentoProveedorArticuloDTO4 = obtenerDescuentos(codigoCompania, SICArticuloConstantes.getInstancia().TIPODESCUENTO4, des4, asignacionTipoDescuentoCol);
					lstDescuentos.add(descuentoProveedorArticuloDTO4);
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en obtener descuentos. {} ", e.getMessage());
			// throw new
			// SICException("Ha ocurrido un error en obtener descuentos. {} ",e.getMessage());
		} finally {
			descuentoProveedorArticuloDTO1 = null;
			descuentoProveedorArticuloDTO2 = null;
			descuentoProveedorArticuloDTO3 = null;
			descuentoProveedorArticuloDTO4 = null;
		}
	}

	@SuppressWarnings("unchecked")
	private String validacionesUnidadMedida(Cell celda, String cabecera, Integer numeroFila, Integer numeroColumna, List<String> observaciones, Set[] objectList, String[] condicionesUnidadMedida, boolean esFilaValida[]) throws SICException {
		String unidadMedida = StringUtils.EMPTY;
		Object object = null;
		List<HashMap<String, String>> listaUnidadMedida = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaUnidadMedida = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaUnidadMedida = new ArrayList<HashMap<String, String>>();
				listaUnidadMedida.addAll(listaSetTemp);
			}
			unidadMedida = validacionArticuloCampos.validacionesUnidadMedida(celda, observaciones, listaUnidadMedida, numeroFila, numeroColumna, cabecera, condicionesUnidadMedida, esFilaValida);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaUnidadMedida);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al obtener la unidad de medida. {}", e.getMessage());
			// throw new
			// SICException("Error al obtener la unidad de medida. {}",
			// e.getMessage());
		}
		return unidadMedida;
	}

	private String validacionesRegistroSanitario(String registroSanitario, String fechaCaducidad, String codigoCatalogoValor, Map<String, String> nombreCatalogoValor, Integer numeroFila, Integer numeroColumna, List<String> observaciones, boolean esFilaValida[]) {
		String campo = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try {
			if (StringUtils.isNotEmpty(StringUtils.trim(registroSanitario)) && StringUtils.isEmpty(StringUtils.trim(fechaCaducidad)) && StringUtils.equals(StringUtils.trim(codigoCatalogoValor), SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO)) {

				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.otro.campo.requerido"), String.valueOf(numeroFila), numeroColumna, nombreCatalogoValor.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN),
						nombreCatalogoValor.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO));
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);

			} else if (StringUtils.isEmpty(StringUtils.trim(registroSanitario)) && StringUtils.isNotEmpty(StringUtils.trim(fechaCaducidad)) && StringUtils.equals(StringUtils.trim(codigoCatalogoValor), SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN)) {

				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.otro.campo.requerido"), String.valueOf(numeroFila), numeroColumna, nombreCatalogoValor.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO),
						nombreCatalogoValor.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN));
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			} else {
				if (StringUtils.equals(codigoCatalogoValor, SICArticuloConstantes.getInstancia().VALOR_CABECERA_REGISTRO_SANITARIO)) {
					campo = registroSanitario;
				} else {
					if (StringUtils.isNotEmpty(StringUtils.trim(fechaCaducidad))) {
						validacionArticuloCampos.validacionesRegistroSanitario(fechaCaducidad, observaciones, numeroFila, numeroColumna, nombreCatalogoValor.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_CADUCIDAD_REG_SAN), esFilaValida);
					} else {
						validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}

					// }
					campo = fechaCaducidad;
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en la validacion de registro sanitario: {}.", e.getMessage());
			// throw new
			// SICException("Ha ocurrido un error en la validacion de registro sanitario. {}",
			// e.getMessage());
		}
		return campo;
	}

	private String validacionesFechaInicioFin(String fechaInicio, String fechaFinal, Map<String, String> cabecerasMapa, String nombreCatalogoValor, Integer numeroFila, Integer numeroColumna, List<String> observaciones, boolean esFilaValida[]) {
		String campo = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try {

			if (StringUtils.isEmpty(StringUtils.trim(fechaInicio)) && StringUtils.isEmpty(StringUtils.trim(fechaFinal))) {
				String nombreCampos = cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA).concat(", ").concat(cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA));

				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.otro.campo.requerido"), String.valueOf(numeroFila), numeroColumna, nombreCampos, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE));
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}

			if (StringUtils.isNotEmpty(StringUtils.trim(fechaInicio)) && StringUtils.isEmpty(StringUtils.trim(fechaFinal))) {

				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.rango.fechas.no.valido"), String.valueOf(numeroFila), numeroColumna);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);

			} else if (StringUtils.isEmpty(StringUtils.trim(fechaInicio)) && StringUtils.isNotEmpty(StringUtils.trim(fechaFinal))) {

				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.rango.fechas.no.valido"), String.valueOf(numeroFila), numeroColumna);
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			} else {
				if (StringUtils.equals(nombreCatalogoValor, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA)) {
					if (ManejoFechas.getDateFormated(DateUtils.setHours(DateUtils.setMinutes(DateUtils.setSeconds(Calendar.getInstance().getTime(), 0), 0), 0)).compareTo(ManejoFechas.convertStringDate(fechaInicio)) > 0) {
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.fecha.actual"), String.valueOf(numeroFila), numeroColumna, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA));
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
						validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					}
					campo = fechaInicio;

				} else {
					if (fechaInicio != null && fechaFinal != null) {
						if (ManejoFechas.getDateFormated(DateUtils.setHours(DateUtils.setMinutes(DateUtils.setSeconds(Calendar.getInstance().getTime(), 0), 0), 0)).compareTo(ManejoFechas.convertStringDate(fechaFinal)) > 0) {
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.fecha.actual"), String.valueOf(numeroFila), numeroColumna, cabecerasMapa.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA));
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						} else if (ManejoFechas.convertStringDate(fechaInicio).compareTo(ManejoFechas.convertStringDate(fechaFinal)) > 0) {
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.fecha.fin.temporada.menor"), String.valueOf(numeroFila), numeroColumna);
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						} else {
							validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.TRUE);
						}
					}
					campo = fechaFinal;
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error en la validacion de fechas temporada: {}.", e.getMessage());
			// throw new
			// SICException("Ha ocurrido un error en la validacion de fechas temporada. {}",
			// e.getMessage());
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesTipoSecuencia(Cell celdaExcel, Set[] objectList, Integer numeroColumna, Integer numeroFila, List<String> observaciones, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaTipoSecuencias = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaTipoSecuencias = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaTipoSecuencias = new ArrayList<HashMap<String, String>>();
				listaTipoSecuencias.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesTipoSecuncia(celdaExcel, observaciones, listaTipoSecuencias, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaTipoSecuencias);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de tipo secuencia: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de tipo secuencia: ",
			// e.getMessage());
		} finally {
			object = null;
			listaTipoSecuencias = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	/**
	 * Valida el lugar de compra
	 * @param celdaExcel Instancia de la celda de excel que se va ha validar
	 * @param objectList
	 * @param codigoCompania C\u00F3digo de la compan\u00EDa
	 * @param numeroColumna N\u00FAmero de la columna que se va ha validar
	 * @param numeroFila N\u00FAmero de la fila que se va ha validar
	 * @param observaciones Lista con las observaciones, con los errores del documento
	 * @param esFilaValida Bandera para verificar si el valor de la celda es v\u00E1lido
	 * @param codigoCabecera C\u00F3digo de la Cabecera
	 * @param codigoDivGeoPol C\u00F3digo del pa\u00EDs de fabricaci\u00F3n
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String validacionesLugarCompra(Cell celdaExcel, Set[] objectList, Integer codigoCompania, Integer numeroColumna, Integer numeroFila, List<String> observaciones, boolean esFilaValida[], String codigoCabecera, String codigoDivGeoPol) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaLugaresCompra = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaLugaresCompra = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaLugaresCompra = new ArrayList<HashMap<String, String>>();
				listaLugaresCompra.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesLugarCompra(celdaExcel, observaciones, listaLugaresCompra, codigoCompania, numeroFila, numeroColumna, esFilaValida, codigoCabecera, codigoDivGeoPol);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaLugaresCompra);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de lugar de compra: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de lugar de compra: ",
			// e.getMessage());
		} finally {
			object = null;
			listaLugaresCompra = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesPaisOrigen(Cell celdaExcel, Set[] objectList, Integer numeroColumna, Integer numeroFila, List<String> observaciones, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaPaisOrigen = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaPaisOrigen = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaPaisOrigen = new ArrayList<HashMap<String, String>>();
				listaPaisOrigen.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesPaisOrigen(celdaExcel, observaciones, listaPaisOrigen, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaPaisOrigen);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de pais de origen: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de pais de origen: ",
			// e.getMessage());
		} finally {
			object = null;
			listaPaisOrigen = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesConstrolPrecios(Cell celdaExcel, Set[] objectList, Integer numeroColumna, Integer numeroFila, List<String> observaciones, boolean esFilaValida[], LinkedHashMap<String, String> mapCamposReqValidacion, String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaControlPrecios = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		String tipoSecuencia = StringUtils.EMPTY;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaControlPrecios = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaControlPrecios = new ArrayList<HashMap<String, String>>();
				listaControlPrecios.addAll(listaSetTemp);
			}
			tipoSecuencia = mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_TIPO_SECUENCIA);

			campo = validacionArticuloCampos.validacionesControlPrecios(celdaExcel, observaciones, listaControlPrecios, numeroFila, numeroColumna, esFilaValida, tipoSecuencia, codigoCabecera);

			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaControlPrecios);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de control precios: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de control precios: ",
			// e.getMessage());
		} finally {
			object = null;
			listaControlPrecios = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesProveedor(Cell celdaExcel, Set[] objectList, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, List<String> observaciones, String[] condicionesProveedor, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		Set<HashMap<String, LinkedList<String>>> listaSetPro = null;
		Set<HashMap<String, LinkedList<String>>> listaSetProTemp = null;
		List<HashMap<String, LinkedList<String>>> listaProveedores = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaProveedores = new ArrayList<HashMap<String, LinkedList<String>>>();
			} else {
				listaSetProTemp = (Set<HashMap<String, LinkedList<String>>>) object;
				listaProveedores = new ArrayList<HashMap<String, LinkedList<String>>>();
				listaProveedores.addAll(listaSetProTemp);
			}
			campo = validacionArticuloCampos.validacionesProveedor(celdaExcel, observaciones, listaProveedores, numeroFila, numeroColumna, codigoCompania, condicionesProveedor, esFilaValida, codigoCabecera);
			listaSetPro = new HashSet<HashMap<String, LinkedList<String>>>();
			listaSetPro.addAll(listaProveedores);
			objectList[numeroColumna] = listaSetPro;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de proveedores: {}.", e.getMessage());
		} finally {
			object = null;
			listaSetPro = null;
			listaSetProTemp = null;
			listaProveedores = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesClasificacion(Cell celdaExcel, Set[] objectList, LinkedHashMap[] objectListCarDin, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, boolean esFilaValida[], String codigoFuncionario, String codigoCabecera, String[] condicionesClasificacion) {
		String campo = StringUtils.EMPTY;
		Set<HashMap<String, LinkedList<String>>> listaSetCla = null;
		Set<HashMap<String, LinkedList<String>>> listaSetClaTemp = null;
		List<HashMap<String, LinkedList<String>>> listaClasificacionesList = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaClasificacionesList = new ArrayList<HashMap<String, LinkedList<String>>>();
			} else {
				listaSetClaTemp = (Set<HashMap<String, LinkedList<String>>>) object;
				listaClasificacionesList = new ArrayList<HashMap<String, LinkedList<String>>>();
				listaClasificacionesList.addAll(listaSetClaTemp);
			}
			campo = validacionArticuloCampos.validacionesClasificacion(celdaExcel, observaciones, listaClasificacionesList, numeroFila, numeroColumna, codigoCompania, esFilaValida, codigoFuncionario, codigoCabecera, condicionesClasificacion);
			listaSetCla = new HashSet<HashMap<String, LinkedList<String>>>();
			listaSetCla.addAll(listaClasificacionesList);
			objectList[numeroColumna] = listaSetCla;
			consultarCaracteristicasDinamicas(codigoCompania, campo, objectListCarDin);
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de clasificaciones: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de clasificaciones: ",
			// e.getMessage());
		} finally {
			object = null;
			listaClasificacionesList = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private void consultarCaracteristicasDinamicas(Integer codigoCompania, String codigoClasificacion, LinkedHashMap[] objectListCarDin) {
		Set<EnumCaracteristicaDinamica> lstCarDina = null;
		LinkedHashMap<String, Set<EnumCaracteristicaDinamica>> carDinMap = null;
		Object object = null;
		try {
			object = objectListCarDin[0];
			carDinMap = (object == null ? new LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>() : (LinkedHashMap<String, Set<EnumCaracteristicaDinamica>>) object);
			if (!carDinMap.containsKey(codigoClasificacion)) {
				lstCarDina = obtenerCaracteristicasDinamicas(codigoCompania, codigoClasificacion);
				carDinMap.put(codigoClasificacion, lstCarDina);
				objectListCarDin[0] = carDinMap;
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al buscar las caracteristicas dinamicas por clasificacion. {}", e.getMessage());
		} finally {
			object = null;
			lstCarDina = null;
			carDinMap = null;
		}
	}

	@SuppressWarnings("unchecked")
	private String validacionesSubClasificaion(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, String codigoClasificacion, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<MultiKeyMap> listaSubClasificaciones = null;
		Set<MultiKeyMap> listaSubClasificacionesSet = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			listaSubClasificacionesSet = (object == null ? listaSubClasificacionesSet = new HashSet<MultiKeyMap>() : (Set<MultiKeyMap>) object);
			listaSubClasificaciones = new ArrayList<MultiKeyMap>();
			listaSubClasificaciones.addAll(listaSubClasificacionesSet);
			campo = validacionArticuloCampos.validacionesSubClasificacion(celdaExcel, observaciones, codigoClasificacion, numeroFila, numeroColumna, listaSubClasificaciones, codigoCompania, esFilaValida, codigoCabecera);
			listaSubClasificacionesSet = new HashSet<MultiKeyMap>();
			listaSubClasificacionesSet.addAll(listaSubClasificaciones);
			objectList[numeroColumna] = listaSubClasificacionesSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de sub clasificaciones: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de sub clasificaciones: ",
			// e.getMessage());
		} finally {
			object = null;
			listaSubClasificaciones = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesCodigoBarras(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, boolean esFilaValida[]) {
		String campo = StringUtils.EMPTY;
		Set<String> listaCodigosBarras = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			listaCodigosBarras = (object == null ? listaCodigosBarras = new HashSet<String>() : (Set<String>) object);
			campo = validacionArticuloCampos.validacionesCodigoBarras(celdaExcel, observaciones, numeroFila, numeroColumna, codigoCompania, listaCodigosBarras, esFilaValida);
			objectList[numeroColumna] = listaCodigosBarras;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de codigo de barras: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de codigo de barras: ",
			// e.getMessage());
		} finally {
			object = null;
			listaCodigosBarras = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesClase(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		Set<String> listaClaseArticulos = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			listaClaseArticulos = (object == null ? listaClaseArticulos = new HashSet<String>() : (Set<String>) object);
			campo = validacionArticuloCampos.validacionesClase(celdaExcel, observaciones, numeroFila, numeroColumna, listaClaseArticulos, codigoCompania, esFilaValida, codigoCabecera, Boolean.TRUE);
			objectList[numeroColumna] = listaClaseArticulos;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de clase articulos: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de clase articulos: ",
			// e.getMessage());
		} finally {
			object = null;
			listaClaseArticulos = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesEAN14(Cell celdaExcel, Set[] objectList, List<String> observaciones, String codigoBarras, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, boolean esFilaValida[]) {
		String campo = StringUtils.EMPTY;
		Set<String> listaEAN14 = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			listaEAN14 = (object == null ? listaEAN14 = new HashSet<String>() : (Set<String>) object);
			campo = validacionArticuloCampos.validacionesEAN14(celdaExcel, observaciones, codigoBarras, numeroFila, numeroColumna, codigoCompania, listaEAN14, esFilaValida);
			objectList[numeroColumna] = listaEAN14;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de EAN14: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de EAN14: ",
			// e.getMessage());
		} finally {
			object = null;
			listaEAN14 = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesMarca(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, String codigoProveedor, boolean esFilaValida[], LinkedList<String> codigosCabeceras) {
		String campo = StringUtils.EMPTY;
		List<MultiKeyMap> listaMarcas = null;
		Set<MultiKeyMap> listaSetMarca = null;
		Set<MultiKeyMap> listaSetMarcaTmp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaMarcas = new ArrayList<MultiKeyMap>();
			} else {
				listaSetMarcaTmp = (Set<MultiKeyMap>) object;
				listaMarcas = new ArrayList<MultiKeyMap>();
				listaMarcas.addAll(listaSetMarcaTmp);
			}
			campo = validacionArticuloCampos.validacionesMarca(celdaExcel, listaMarcas, observaciones, codigoCompania, numeroFila, numeroColumna, codigoProveedor, esFilaValida, codigosCabeceras);
			listaSetMarca = new HashSet<MultiKeyMap>();
			listaSetMarca.addAll(listaMarcas);
			objectList[numeroColumna] = listaSetMarca;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de Marca: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de Marca: ",
			// e.getMessage());
		} finally {
			object = null;
			listaMarcas = null;
			listaSetMarca = null;
			listaSetMarcaTmp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesAlcancePrototipo(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, boolean esFilaValida[], String codigoCabecera , boolean omisionValidacionAlcances) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaAlcancesPrototipos = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaAlcancesPrototipos = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaAlcancesPrototipos = new ArrayList<HashMap<String, String>>();
				listaAlcancesPrototipos.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesAlcancePrototipo(celdaExcel, observaciones, listaAlcancesPrototipos, numeroFila, numeroColumna, codigoCompania, esFilaValida, codigoCabecera , omisionValidacionAlcances);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaAlcancesPrototipos);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de Alcance prototipo: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de Alcance prototipo: ",
			// e.getMessage());
		} finally {
			object = null;
			listaAlcancesPrototipos = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesAgrupador(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaAgrupadores = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaAgrupadores = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaAgrupadores = new ArrayList<HashMap<String, String>>();
				listaAgrupadores.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesAgrupador(celdaExcel, observaciones, listaAgrupadores, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaAgrupadores);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de Alcance prototipo: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de Alcance prototipo: ",
			// e.getMessage());
		} finally {
			object = null;
			listaAgrupadores = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesEmpaque(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaEmpaques = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaEmpaques = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaEmpaques = new ArrayList<HashMap<String, String>>();
				listaEmpaques.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesEmpaque(celdaExcel, observaciones, listaEmpaques, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaEmpaques);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de Empaque: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de Empaque: ",
			// e.getMessage());
		} finally {
			object = null;
			listaEmpaques = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesImportancia(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaImportancias = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaImportancias = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaImportancias = new ArrayList<HashMap<String, String>>();
				listaImportancias.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesImportancia(celdaExcel, observaciones, listaImportancias, codigoCompania, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaImportancias);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de Importacia: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de Importacia: ",
			// e.getMessage());
		} finally {
			object = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesPlazoPago(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaPlazosPagos = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaPlazosPagos = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaPlazosPagos = new ArrayList<HashMap<String, String>>();
				listaPlazosPagos.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesPlazoPago(celdaExcel, observaciones, listaPlazosPagos, codigoCompania, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaPlazosPagos);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de Plazo pago: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de Plazo pago: ",
			// e.getMessage());
		} finally {
			object = null;
			listaPlazosPagos = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesTransgenico(Cell celdaExcel, Set[] objectList, Integer numeroColumna, Integer numeroFila, List<String> observaciones, boolean esFilaValida[], String codigoCabecera) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaTransgenicos = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaTransgenicos = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaTransgenicos = new ArrayList<HashMap<String, String>>();
				listaTransgenicos.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesTransgenico(celdaExcel, observaciones, listaTransgenicos, numeroFila, numeroColumna, esFilaValida, codigoCabecera);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaTransgenicos);
			objectList[numeroColumna] = listaSet;
		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de transgenico: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de transgenico: ",
			// e.getMessage());
		} finally {
			object = null;
			listaTransgenicos = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}

	@SuppressWarnings("unchecked")
	private String validacionesUsos(Cell celdaExcel, Set[] objectList, Integer numeroColumna, Integer numeroFila, List<String> observaciones, boolean esFilaValida[], String nombreCatalogoValor) {
		String campo = StringUtils.EMPTY;
		List<HashMap<String, String>> listaUsos = null;
		Set<HashMap<String, String>> listaSet = null;
		Set<HashMap<String, String>> listaSetTemp = null;
		Object object = null;
		try {
			object = objectList[numeroColumna];
			if (object == null) {
				listaUsos = new ArrayList<HashMap<String, String>>();
			} else {
				listaSetTemp = (Set<HashMap<String, String>>) object;
				listaUsos = new ArrayList<HashMap<String, String>>();
				listaUsos.addAll(listaSetTemp);
			}
			campo = validacionArticuloCampos.validacionesUsos(celdaExcel, observaciones, listaUsos, numeroFila, numeroColumna, nombreCatalogoValor, esFilaValida);
			listaSet = new HashSet<HashMap<String, String>>();
			listaSet.addAll(listaUsos);
			objectList[numeroColumna] = listaSet;

		} catch (Exception e) {
			LOG_SICV2.error("Error al escoger el caso de validacion de usos: {}.", e.getMessage());
			// throw new
			// SICException("Error al escoger el caso de validacion de usos: ",
			// e.getMessage());
		} finally {

		}
		return campo;
	}

	/*******************************************************************************************************************************************************************/
	/****************************************************** VALIDACIONES CAMPOS FIN ***********************************************************************************/
	/*******************************************************************************************************************************************************************/

	/**
	 * METODO QUE PERMITE SABER SI SE INGRESAN LOS IMPUESTOS
	 * 
	 * @param celdaExcel
	 * @param objectList
	 * @param esFilaValida
	 * @param parametroIngresoDatos
	 * @return
	 * @throws SICException
	 */
	private String validarIngresoImpuestos(Cell celdaExcel, LinkedHashMap<String, String> mapCamposImpuestos, boolean esFilaValida[], String parametroIngresoDatos, String nombreCatalogoValor, Integer numeroFila, Integer numeroColumna, List<String> observaciones, CatalogoValorDTO catalogoValor, Collection<CatalogoValorDTO> catalogosCabeceraImpuestos) throws SICException {
		String ingresarImpuesto = StringUtils.EMPTY;
		String valorCelda = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		try {
			valorCelda = parsearValor(obtenerValorCeldaString(celdaExcel));
			if (StringUtils.length(StringUtils.trim(valorCelda)) > 1) {
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.tamanio.maximo.mensaje.extra"), String.valueOf(numeroFila), numeroColumna, "Impuesto ".concat(nombreCatalogoValor), " 1 caracter");
				LOG_SICV2.error(observacion.substring(4));
				observaciones.add(observacion);
				validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			} else {
				valorCelda = StringUtils.upperCase(valorCelda);
				if(!StringUtils.equals(StringUtils.trim(valorCelda), "S") && !StringUtils.equals(StringUtils.trim(valorCelda), "N")) {
					validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.no.existe"), String.valueOf(numeroFila), numeroColumna, "Impuesto ".concat(nombreCatalogoValor));
					LOG_SICV2.error(observacion.substring(4));
					LOG_SICV2.info(parametroIngresoDatos);
					observaciones.add(observacion);
					
				} else if(this.validarCondicionesImpuestos(nombreCatalogoValor, valorCelda, mapCamposImpuestos, catalogoValor, observaciones, esFilaValida, numeroFila, numeroColumna, catalogosCabeceraImpuestos)) {
					
					if (StringUtils.equals(StringUtils.trim(valorCelda), "S")) {
						ingresarImpuesto = String.valueOf(Boolean.TRUE);
						mapCamposImpuestos.put(nombreCatalogoValor, ingresarImpuesto);
						validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					} else {
						ingresarImpuesto = String.valueOf(Boolean.FALSE);
						mapCamposImpuestos.put(nombreCatalogoValor, ingresarImpuesto);
						validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.TRUE);
					}
				} 
			}
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un erro al ingresar los impuestos en la fila " + numeroFila + ". {}", e.getMessage());
			// throw new
			// SICException("Ha ocurrido un erro al ingresar los impuestos. {}",
			// e.getMessage());
		}
		return ingresarImpuesto;
	}
	
	/**
	 * Permite realizar las validaciones de las condiciones que tengan los impuestos
	 * @author bcueva
	 * @param nombreCatalogoValor Nombre de la cabecera del Impuesto
	 * @param valorCelda Valor ingresado en la celda
	 * @param mapCamposImpuestos Mapa con los impuestos ingresados
	 * @param catalogoValor Catalogo valor del campo que se esta verificando
	 * @param observaciones Lista de observaciones de errores del el archivo
	 * @param esFilaValida Array para verificar si la celda es valida o no
	 * @param numeroFila Numero de la fila que se encuentra validando
	 * @param numeroColumna Numero de la columna que se encuentra validando
	 * @return
	 */
	private Boolean validarCondicionesImpuestos(String nombreCatalogoValor, String valorCelda, LinkedHashMap<String, String> mapCamposImpuestos, CatalogoValorDTO catalogoValor, List<String> observaciones, boolean esFilaValida[], Integer numeroFila, Integer numeroColumna, Collection<CatalogoValorDTO> catalogosCabeceraImpuestos) {
		String valorImpuesto = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		String nombreImpuesto = StringUtils.EMPTY;
		String verificaImpuesto = StringUtils.EMPTY;
		
		//Obtener el nombre del impuesto
		nombreImpuesto = StringUtils.replace(StringUtils.replace(nombreCatalogoValor, SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_VENTA, ""), SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_COMPRA, "");
		//Si se esta evaluando un impuesto tipo compra obtengo (V), y si es venta obtengo (C), ya que se debe evaluar al anterior ingresado con el actual
		verificaImpuesto = (nombreCatalogoValor.equals(nombreImpuesto + SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_VENTA))? SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_COMPRA : SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_VENTA;
		
		//Verificando si tiene las propiedades dinamicas necesarias para poder validar
		if(catalogoValor.hasDynamicProperty("codigoTipoImpuesto") && catalogoValor.hasDynamicProperty("codigoGrupoImpuesto")) {
			
			//Validar si el impuesto verde es el mismo tanto en Compra como en venta
			//Si es impuesto de tipo I.VERDE
			if(catalogoValor.getDynamicProperty("codigoTipoImpuesto", String.class).equals(SICArticuloConstantes.TIPOIMPUESTO_OMISION_IVE.toString())) {
				valorImpuesto = mapCamposImpuestos.get(nombreImpuesto + verificaImpuesto);
				
				if(!StringUtils.isEmpty(valorImpuesto)) {
					//Si el valor de I.Verde de Compra y Venta son diferentes
					if(!valorImpuesto.equals((valorCelda.equals("S"))? String.valueOf(Boolean.TRUE):String.valueOf(Boolean.FALSE))) {
						observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.impuesto.aplicar.compra.venta"), String.valueOf(numeroFila), numeroColumna, nombreImpuesto);
						LOG_SICV2.error(observacion.substring(4));
						observaciones.add(observacion);
						validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
						return Boolean.FALSE;
					}
				}
			}
			
			//Verificando que no se pueda agregar varios impuestos del mismo grupo de impuestos
			//Si el impuesto a validar es del grupo de impuestos de IVA
			if(catalogoValor.getDynamicProperty("codigoGrupoImpuesto", String.class).equals(SICArticuloConstantes.GRUPOIMPUESTO_IVA) && valorCelda.equals("S") && mapCamposImpuestos.size() > 0) {
				//Recorro los catalogos con las cabeceras de los impuestos para verificar si los impuestos fueron cargados
				for(CatalogoValorDTO catalogoImpuesto : catalogosCabeceraImpuestos) {
					//Solo obtengo los catalogos que sean del mismo grupo de impuestos IVA
					if(!catalogoImpuesto.getNombreCatalogoValor().equals(catalogoValor.getNombreCatalogoValor())  && catalogoImpuesto.getDynamicProperty("codigoGrupoImpuesto", String.class).equals(SICArticuloConstantes.GRUPOIMPUESTO_IVA)
							&& !catalogoImpuesto.getNombreCatalogoValor().equals(nombreImpuesto + verificaImpuesto)) {
						valorImpuesto = mapCamposImpuestos.get(catalogoImpuesto.getNombreCatalogoValor());
						if(valorImpuesto != null && valorImpuesto.equals(Boolean.TRUE.toString())) {
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.impuesto.aplicar.uno.mismotipo"), String.valueOf(numeroFila), numeroColumna, nombreCatalogoValor, catalogoImpuesto.getNombreCatalogoValor());
							LOG_SICV2.error(observacion.substring(4));
							observaciones.add(observacion);
							validacionArticuloCampos.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
							return Boolean.FALSE;
						}
					}
				}
			}
		}
		
		return Boolean.TRUE;
	}

	/**
	 * Se procede a validar la cabecera del archivo para verificar que las
	 * columnas ingresadas son correctas
	 * 
	 * @param rowExcel
	 * @param lstCatalogoValorDTO
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	private String validarCabeceraArchivo(Row rowExcel, Collection<CatalogoValorDTO> lstCatalogoValorDTO) throws SICException {
		String observacion = " ";
		Cell celdaCabecera = null;
		String valorCabecera = StringUtils.EMPTY;
		String columna = StringUtils.EMPTY;
		try {
			for (CatalogoValorDTO dto : lstCatalogoValorDTO) {
				Integer orden = Integer.valueOf(dto.getOrden());
				celdaCabecera = rowExcel.getCell(orden, Row.CREATE_NULL_AS_BLANK);
				valorCabecera = obtenerValorCeldaString(celdaCabecera);
				if (StringUtils.isBlank(valorCabecera) || !StringUtils.equals(valorCabecera, dto.getNombreCatalogoValor())) {
					columna = valorCabecera;
					if (StringUtils.equals(columna, "A")) {
						observacion = columna;
					} else {
						if (StringUtils.isNotEmpty(StringUtils.trim(columna))) {
							observacion = observacion.concat((StringUtils.isBlank(observacion)) ? columna : ", ".concat(columna));
						}
					}
				}
			}
		} catch (Exception e) {
			throw new SICException("Error al validar la cabecera del archivo. {}", e.getMessage());
		}
		return observacion;
	}

	/**
	 * Metodo que genera el excel con los detalles de las observaciones para la
	 * correccion del usuario
	 * 
	 * @param articuloVO
	 * @param observaciones
	 * @param rowIterator
	 * @param numeroColumnas
	 */
	@SuppressWarnings("unchecked")
	private void generarExcelErrores(ArticuloVO articuloVO, List<String> observaciones, Iterator<Row> rowIteratorArchivo, int numeroColumnas, Collection<CatalogoValorDTO> lstCatalogoValor) throws SICException {
		LOG_SICV2.info(observaciones.toString());
		XSSFWorkbook wb = null;
		XSSFSheet sheet = null;
		List<String> observacionesFilaActual = null;
		MultiKeyMap mapaObservaciones = this.crearMapObservaciones(observaciones);
		int k = 0;
		try {
			LOG_SICV2.info("SE GENERA EL EXCEL DE ERRORES");
			wb = new XSSFWorkbook();
			sheet = wb.createSheet(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.title.excel.arhivo"));

			// creamos la cabecera de la tabla de datos
			this.crearCeldaExcel(wb, sheet, (List<CatalogoValorDTO>) lstCatalogoValor, Boolean.TRUE);

			int i = 1;
			// Se Itera las filas
			while (rowIteratorArchivo.hasNext()) {
				Row xssfRow = rowIteratorArchivo.next();
				if (i > 1) {
					// Se crea la fila
					XSSFRow row = sheet.createRow((short) (i - 1));
					// Se Itera las columnas de la fila actual
					List cellTempList = new ArrayList();
					for (int j = 0; j < numeroColumnas; j++) {
						// Seteo el valor de cada columna de la fila
						Cell xssfCellData = xssfRow.getCell(j, Row.CREATE_NULL_AS_BLANK);
						cellTempList.add(xssfCellData);
					}
					// Validacion de errores
					observacionesFilaActual = new ArrayList<String>();
					// Se crean las columnas
					observacionesFilaActual = obtenerObservacionesErrores(cellTempList, mapaObservaciones, row, wb, i);
					// Columnas observaciones de errores
					k = numeroColumnas;
					if (!observacionesFilaActual.isEmpty()) {
						StringBuilder observacionesLista = new StringBuilder();
						for (String observacion : observacionesFilaActual) {
							observacionesLista.append(observacion + ".");
							// k++;
						}
						XSSFCell cellObservacion = row.createCell(k);
						cellObservacion.setCellValue(new XSSFRichTextString(observacionesLista.toString()));
						PoiExcelStyleUtil.getInstance().applyErrorObservationCellStyle(wb, cellObservacion);
					}
				}
				i++;
			}
			
			if(k > 0) {
				sheet.autoSizeColumn(k);
			}
			articuloVO.setContenidoExcelObservaciones(wb);
		} catch (Exception e) {
			LOG_SICV2.error("Error al generar el contenido del archivo excel de las observacines: {}", e.getMessage());
			throw new SICException("Error al generar el contenido del archivo excel de las observaciones: {}", e.getMessage());
		}
	}
	
	/**
	 * Pasa la lista de observaciones a una estructura accesible MultikeyMap
	 * @param observaciones
	 * @return
	 */
	private MultiKeyMap crearMapObservaciones(List<String> observaciones) {
		MultiKeyMap mapa = new MultiKeyMap();
		for (String observacion : observaciones) {
			String[] resultadoObservacion = observacion.split(",");
			mapa.put(resultadoObservacion[0], resultadoObservacion[1], resultadoObservacion[2]);
		}
		
		return mapa;
	}

	/**
	 * Metodo para cargar los valores de las celdas
	 * 
	 * @param cellTempList
	 * @param observaciones
	 * @param row
	 * @param estiloCeldaError
	 * @param estiloCeldaGeneral
	 * @param i
	 * @return
	 */
	private List<String> obtenerObservacionesErrores(List cellTempList, MultiKeyMap observaciones, XSSFRow row, XSSFWorkbook wb, int i) {
		List<String> observacionesFilaActual = null;
		try {
			observacionesFilaActual = new ArrayList<String>();
			for (int j = 0; j < cellTempList.size(); j++) {
				XSSFCell xssfCell = (XSSFCell) cellTempList.get(j);
				final XSSFCell cell = row.createCell(j);
				setearValorCelda(xssfCell, cell);
				if ((validarEstilo(i, j, observaciones, observacionesFilaActual))) {
					PoiExcelStyleUtil.getInstance().applyErrorCellStyle(wb, cell);
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al validar las observaciones de errores", e.getMessage());
			// throw new
			// SICException("Error al validar las observaciones de errores",
			// e.getMessage());
		}
		return observacionesFilaActual;
	}

	/**
	 * Metodo para formatear el valor de la celda
	 * 
	 * @param cell
	 * @param cellActual
	 */
	private void setearValorCelda(Cell cell, final Cell cellActual) {
		if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			cellActual.setCellValue(" ");
		} else {
			String valorCelda = obtenerValorCeldaString(cell);
			if (NumberUtils.isNumber(valorCelda)) {
				String lastChar = StringUtils.substring(valorCelda, -1);
				// SE VERIFICA QUE EL NUMERO TERMINE EN LAS LETRAS D,F,L PARA
				// QUE INGRESE EL MISMO VALOR Y NO REALICE NINGUN CAST
				if (StringUtils.equals(lastChar.toUpperCase(), "D") || StringUtils.equals(lastChar.toUpperCase(), "F") || StringUtils.equals(lastChar.toUpperCase(), "L")) {
					cellActual.setCellValue(valorCelda);
				} else {
					// validacion
					if (StringUtils.startsWith(valorCelda, "0")) {
						cellActual.setCellValue(valorCelda);
					} else {
						cellActual.setCellValue(Double.valueOf(valorCelda));
					}
				}
			} else {
				cellActual.setCellValue(valorCelda);
			}
		}
	}

	/**
	 * Metodo para poner el estilo en las observaciones
	 * 
	 * @param rowNum
	 * @param columnIndex
	 * @param observaciones
	 * @param observacionesFilaActual
	 * @return
	 */
	private boolean validarEstilo(int rowNum, int columnIndex, MultiKeyMap observaciones, List<String> observacionesFilaActual) {
		if(observaciones.containsKey(String.valueOf(rowNum), String.valueOf(columnIndex))) {
			observacionesFilaActual.add(observaciones.get(String.valueOf(rowNum), String.valueOf(columnIndex)).toString());
			return true;
		}
		return false;
	}

	/**
	 * Metodo que devuelve el indice alfabetico de las columnas
	 * 
	 * @param indiceColumna
	 * @return
	 */
	@SuppressWarnings("unused")
	private String indiceAlfabeticoColumna(Integer indiceColumna) {
		String indice = "";
		if (indiceColumna != null) {
			indice = validacionArticuloCampos.indiceAlfabeticoColumna(indiceColumna);
		}
		return indice;
	}

	/**
	 * Metodo que retorna un string con el valor de la celda
	 * 
	 * @param celda
	 * @return
	 * @author eharo
	 */
	private String obtenerValorCeldaString(Cell celda) {
		String valorCelda = StringUtils.EMPTY;
		if (celda != null) {
			valorCelda = validacionArticuloCampos.obtenerValorCeldaString(celda);
		}
		return valorCelda;
	}

	/**
	 * Metodo que elimina los valores de la celda despues del punto ya que los
	 * codigos que se ingresan solo son enteros
	 * 
	 * @param numericCellValue
	 * @return
	 */
	private String parsearValor(String numericCellValue) {
		String parseNumericCellValue = numericCellValue;
		if (StringUtils.isNotEmpty(numericCellValue)) {
			parseNumericCellValue = validacionArticuloCampos.parsearValor(numericCellValue);
		}

		return parseNumericCellValue;
	}

	@Override
	public void obtenerCabeceraArchivo(XSSFWorkbook wb, XSSFSheet sheet, Integer tipoCabecera) throws SICException {
		Collection<CatalogoValorDTO> lstCatalogoValorDTO = null;
		try {
			if (wb != null && sheet != null) {
				lstCatalogoValorDTO = new ArrayList<CatalogoValorDTO>();
				lstCatalogoValorDTO = listaCabeceras(tipoCabecera);
				if (CollectionUtils.isNotEmpty(lstCatalogoValorDTO)) {

					this.crearCeldaExcel(wb, sheet, (List<CatalogoValorDTO>) lstCatalogoValorDTO, Boolean.FALSE);
				}
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al crear la cabecera del archivo");
		}
	}

	/**
	 * Metodo que crea las celdas de la cabecera para la plantilla Excel
	 * 
	 * @param wb
	 * @param sheet
	 * @param listaCabeceras
	 * @throws SICException
	 * @author eharo
	 */
	private void crearCeldaExcel(XSSFWorkbook wb, XSSFSheet sheet, List<CatalogoValorDTO> listaCabeceras, Boolean esFormatoError) throws SICException {
		try {
			XSSFCell cellCabecera = null;
			XSSFRow rowCabecera = null;
			if (wb != null && sheet != null && CollectionUtils.isNotEmpty(listaCabeceras)) {

				// Create a new font and alter it.
				XSSFFont font = wb.createFont();
				font.setFontHeightInPoints((short) 10);
				font.setFontName("Arial");
				font.setBold(true);

				rowCabecera = sheet.createRow(0);
				for (int i = 0; i < listaCabeceras.size(); i++) {
					// Valores de la cabecera
					cellCabecera = rowCabecera.createCell(i);
					
					if(listaCabeceras.get(i).getEsValorPorDefecto()) {
						PoiExcelStyleUtil.getInstance().applyRequireCellHeaderStyle(wb, cellCabecera);
					} else {
						PoiExcelStyleUtil.getInstance().applyNormalCellHeaderStyle(wb, cellCabecera);
					}
					cellCabecera.setCellValue(new XSSFRichTextString(listaCabeceras.get(i).getNombreCatalogoValor()));

					sheet.autoSizeColumn(i);
				}
				if (esFormatoError) {
					cellCabecera = rowCabecera.createCell(listaCabeceras.size());
					
					PoiExcelStyleUtil.getInstance().applyNormalCellHeaderStyle(wb, cellCabecera);
					cellCabecera.setCellValue(new XSSFRichTextString("OBSERVACIONES"));
				}
				sheet.createFreezePane(0, 1, listaCabeceras.size(), 1);
			}
		} catch (Exception e) {
			LOG_SICV2.error("Error al generar las cabeceras del excel" + e.getMessage());
			throw new SICException("Error al generar las cabeceras del excel" + e.getMessage());
		}
	}

	/**
	 * Obtiene la lista de las cabeceras desde el catalogo
	 * 
	 * @param catalogoTipo
	 * @return
	 */
	private Collection<CatalogoValorDTO> listaCabeceras(Integer catalogoTipo) throws SICException {
		List<CatalogoValorDTO> lstCatalogoValorOrdered = null;
		CatalogoValorDTO catalogoValorDTO = null;
		Collection<CatalogoValorDTO> lstCatalogoValorDTO = null;
		TipoImpuestoDTO tipoImpuestoDTO = null;
		Collection<TipoImpuestoDTO> tipoImpuestoDTOCol = null;
		if (catalogoTipo != null) {
			catalogoValorDTO = new CatalogoValorDTO();
			catalogoValorDTO.getId().setCodigoCatalogoTipo(catalogoTipo);
			catalogoValorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			catalogoValorDTO.setOrderByField(OrderBy.orderAsc("orden"));
			lstCatalogoValorDTO = dataGestor.findObjects(catalogoValorDTO);
			tipoImpuestoDTO = new TipoImpuestoDTO();
			tipoImpuestoDTO.setEstadoTipoImpuesto(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			tipoImpuestoDTO.addCriteriaSearchParameter(new CriteriaSearchParameter<Integer>("id.codigoTipoImpuesto", ComparatorTypeEnum.NOT_IN_COMPARATOR, Boolean.FALSE, SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IDN, SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_SIN_IVA));
			tipoImpuestoDTO.setOrderByField(OrderBy.orderAsc("id.codigoTipoImpuesto"));
			tipoImpuestoDTOCol = dataGestor.findObjects(tipoImpuestoDTO);
			lstCatalogoValorOrdered = new ArrayList<CatalogoValorDTO>();
			for (CatalogoValorDTO columna : lstCatalogoValorDTO) {
				if (StringUtils.equals(SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_VENTA, columna.getId().getCodigoCatalogoValor())) {
					lstCatalogoValorOrdered.addAll(obtenerCatalogoImpuestos(tipoImpuestoDTOCol, Boolean.TRUE));
				} else if (StringUtils.equals(SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_COMPRA, columna.getId().getCodigoCatalogoValor())) {
					lstCatalogoValorOrdered.addAll(obtenerCatalogoImpuestos(tipoImpuestoDTOCol, Boolean.FALSE));
				} else {
					lstCatalogoValorOrdered.add(columna);
				}
			}
		}
		asignarOrden(lstCatalogoValorOrdered);
		return lstCatalogoValorOrdered;
	}

	@SuppressWarnings("unchecked")
	private Collection<CatalogoValorDTO> obtenerCatalogoImpuestos(Collection<TipoImpuestoDTO> tipoImpuestoDTOCol, final Boolean esVenta) {
		Collection<CatalogoValorDTO> catalogoValorDTOs = new ArrayList<CatalogoValorDTO>();
		if (CollectionUtils.isNotEmpty(tipoImpuestoDTOCol)) {
			catalogoValorDTOs = CollectionUtils.collect(tipoImpuestoDTOCol, new Transformer() {
				@Override
				public Object transform(Object input) {
					TipoImpuestoDTO tipoImpuestoDTO = (TipoImpuestoDTO) input;
					CatalogoValorDTO catalogoValorDTO = new CatalogoValorDTO();
					catalogoValorDTO.getId().setCodigoCatalogoTipo(SICArticuloConstantes.getInstancia().VALOR_CABECERAS_CATALOGO_TIPO_MERCANCIAS);
					catalogoValorDTO.getId().setCodigoCatalogoValor(esVenta ? SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_VENTA : SICArticuloConstantes.getInstancia().VALOR_CABECERA_IMPUESTO_COMPRA);
					catalogoValorDTO.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
					StringBuilder nombre = new StringBuilder(tipoImpuestoDTO.getNombreTipoImpuesto());
					if (tipoImpuestoDTO.getId().getCodigoTipoImpuesto() != null && tipoImpuestoDTO.getId().getCodigoTipoImpuesto().compareTo(SICArticuloConstantes.getInstancia().TIPOIMPUESTO_OMISION_IVE) != 0) {
						nombre.append(tipoImpuestoDTO.getPorcentajeImpuesto().intValue());
					}
					catalogoValorDTO.setNombreCatalogoValor(nombre.append(esVenta ? SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_VENTA : SICArticuloConstantes.getInstancia().CABECERA_IMPUESTOS_POSFIJO_COMPRA).toString());
					catalogoValorDTO.setValorNumerico(0L);
					catalogoValorDTO.setEsValorPorDefecto(Boolean.TRUE);
					//Se agrega la siguiente propiedad din\u00E1mica para retener la informci\u00F3n del c\u00F3digo del impuesto
					catalogoValorDTO.setDynamicProperties(new HashMap<String, Object>());
					catalogoValorDTO.getDynamicProperties().put("codigoTipoImpuesto", tipoImpuestoDTO.getId().getCodigoTipoImpuesto().toString());
					//Se agrega la siguiente propiedad din\u00E1mica para retener la informaci\u00F3n del c\u00F3digo del grupo de impuesto
					catalogoValorDTO.getDynamicProperties().put("codigoGrupoImpuesto", tipoImpuestoDTO.getCodigoGrupoImpuesto());
					return catalogoValorDTO;
				}
			});
		}
		return catalogoValorDTOs;
	}

	/**
	 * METODO QUE ASIGNA EL ORDEN A LAS COLUMNAS DESPUES DE AGREGAR LAS COLUMNAS
	 * DE IMPUESTOS
	 * 
	 * @param catalogoValorDTOs
	 */
	private void asignarOrden(Collection<CatalogoValorDTO> catalogoValorDTOs) {
		if (CollectionUtils.isNotEmpty(catalogoValorDTOs)) {
			Integer count = 0;
			for (CatalogoValorDTO catalogoValorDTO : catalogoValorDTOs) {
				catalogoValorDTO.setOrden(String.valueOf(count));
				count += 1;
			}
		}
	}

	/**
	 * METODO PARA OBTENER UN PARAMETRO
	 * 
	 * @param codigoCompania
	 * @param codigoParametro
	 * @return
	 */
	private String obtenerParametro(Integer codigoCompania, String codigoParametro) {
		String valorParametro = StringUtils.EMPTY;
		try {
			valorParametro = creacionPorArchivoDAO.obtenerParametroRequerido(codigoCompania, codigoParametro);
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al obtener el parametro maximo de filas. {}", e.getMessage());
		}
		return valorParametro;
	}

	@Override
	public void generarExcelConErrores(ArticuloVO articuloVO, List<String> observaciones, Iterator<Row> rowIteratorArchivo, int numeroColumnas, Collection<CatalogoValorDTO> lstCatalogoValor) throws SICException {
		try {
			this.generarExcelErrores(articuloVO, observaciones, rowIteratorArchivo, numeroColumnas, lstCatalogoValor);
		} catch (Exception e) {
			LOG_SICV2.error("Ha ocurrido un error al generar el excel con errores", e.getMessage());
		}
	}

	/**
	 * @param dataGestor
	 *            the dataGestor to set
	 */
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}

	/**
	 * @param creacionPorArchivoDAO
	 *            the creacionPorArchivoDAO to set
	 */
	public void setCreacionPorArchivoDAO(IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO) {
		this.creacionPorArchivoDAO = creacionPorArchivoDAO;
	}

	/**
	 * @param validacionArticuloCampos
	 *            the validacionArticuloCampos to set
	 */
	public void setValidacionArticuloCampos(IValidacionArticuloCamposCreacionPorArchivoGestor validacionArticuloCampos) {
		this.validacionArticuloCampos = validacionArticuloCampos;
	}

	/**
	 * @param validacionReglasComerciales
	 *            the validacionReglasComerciales to set
	 */
	public void setValidacionReglasComerciales(IValidacionArticuloReglasComercialesGestor validacionReglasComerciales) {
		this.validacionReglasComerciales = validacionReglasComerciales;
	}
}