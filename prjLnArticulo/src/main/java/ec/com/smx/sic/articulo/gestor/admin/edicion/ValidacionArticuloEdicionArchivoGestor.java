/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.admin.edicion;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.keyvalue.MultiKey;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloCamposEdicionArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloEdicionArchivoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.validacion.IValidacionArticuloCreacionPorArchivoGestor;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloCreacionPorArchivoDAO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion.IArticuloEdicionArchivoDAO;
import ec.com.smx.sic.cliente.resources.articulo.SICArticuloMessages;

/**
 * @author eharo
 *
 */
public class ValidacionArticuloEdicionArchivoGestor implements IValidacionArticuloEdicionArchivoGestor, Logeable{

	IArticuloEdicionArchivoDAO articuloEdicionArchivoDAO;
	//Variable de acceso al DAO de la creacion por archivo
	IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO;
	//Variable de acceso a la validacion de la creacion
	IValidacionArticuloCreacionPorArchivoGestor validacionArticuloCreacionPorArchivoGestor;
	//Variable de acceso a la validacion de campos en la edicion
	IValidacionArticuloCamposEdicionArchivoGestor validacionArticuloCamposEdicionArchivoGestor;

	
	/**
	 * @param articuloEdicionArchivoDAO the articuloEdicionArchivoDAO to set
	 */
	public void setArticuloEdicionArchivoDAO(IArticuloEdicionArchivoDAO articuloEdicionArchivoDAO) {
		this.articuloEdicionArchivoDAO = articuloEdicionArchivoDAO;
	}
	
	/**
	 * @param validacionArticuloCamposEdicionArchivoGestor the validacionArticuloCamposEdicionArchivoGestor to set
	 */
	public void setValidacionArticuloCamposEdicionArchivoGestor(IValidacionArticuloCamposEdicionArchivoGestor validacionArticuloCamposEdicionArchivoGestor) {
		this.validacionArticuloCamposEdicionArchivoGestor = validacionArticuloCamposEdicionArchivoGestor;
	}

	/**
	 * @param creacionPorArchivoDAO the creacionPorArchivoDAO to set
	 */
	public void setCreacionPorArchivoDAO(IArticuloCreacionPorArchivoDAO creacionPorArchivoDAO) {
		this.creacionPorArchivoDAO = creacionPorArchivoDAO;
	}
	
	/**
	 * @param validacionArticuloCreacionPorArchivoGestor the validacionArticuloCreacionPorArchivoGestor to set
	 */
	public void setValidacionArticuloCreacionPorArchivoGestor(IValidacionArticuloCreacionPorArchivoGestor validacionArticuloCreacionPorArchivoGestor) {
		this.validacionArticuloCreacionPorArchivoGestor = validacionArticuloCreacionPorArchivoGestor;
	}


	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloEdicionArchivoGestor#imprimirAcceso(java.lang.String)
	 */
	@Override
	public void imprimirAcceso(String nombre) throws SICException {
		Logeable.LOG_SICV2.info("LLEGO AL GESTOR: " + ValidacionArticuloEdicionArchivoGestor.class.getName());
		this.articuloEdicionArchivoDAO.imprimirAcceso(nombre);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloEdicionArchivoGestor#procesarArchivoEdicionArticulo(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO, java.io.InputStream, java.lang.Integer)
	 */
	@Override
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoEdicionArticulo(ArticuloVO articuloVO, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException {
		LOG_SICV2.info(">>>>>>>>>>>>>>>>>>>>>>INICIA EL METODO DE PROCESAR EL ARCHIVO PARA LA EDICION<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos = null;
		try{
			
			datosValidos = this.validarArchivoArticulo(articuloVO, articuloEdicionMasivaArchivoVO, inputStreamArchivo, tipoCabeceras);
			
		}catch(Exception e){
			throw new SICException(e.getMessage());
		}
		return datosValidos;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> validarArchivoArticulo(ArticuloVO articuloVO, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, InputStream inputStreamArchivo, Integer tipoCabeceras) {
		Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidosArchivo = null;
		List<CatalogoValorDTO> lstCatalogoValorCabeceras = null;
		//LISTA EN LA CUAL SE ALMACENAN TODAS LAS OBSERVACIONES QUE GENERA LA VALIDACION
		List<String> observaciones = null;
		//LISTA  CON LOS DATOS DEL EXCEL POR CADA FILA
		List datosCeldaTmp = new ArrayList();
		//VARIABLE PARA ASIGNAR LA OBSERVACION DE CADA VALIDACION
		String observacion = " ";
		//VARIABLE DE LA HOJA QUE SE GENERAR CON REPORTES DE ERRORES O LA PLANTILLA DEL ARCHIVO EXCEL
		Sheet sheet = null;
		//ITERADOR DE LAS FILAS DEL ARCHIVO EXCEL
		Iterator<Row> rowIteratorArchivo = null;
		//VARIABLE QUE IDENTIFICA EL VALOR DE LA FILA PROCESADA
		Integer numeroFila = 1;
		//VARIABLE QUE IDENTIFICA EL NUMERO DE COLUMNAS DEL ARHIVO EXCEL
		Integer numeroColumnas = 0;
		//VARIABLE QUE IDENTIFICA EL NUMERO MAXIMO DE FILAS DE ACUERDO AL PARAMETRO PARA DATOS EN EL EXCEL
		Integer numeroMaximoFilas = 0;
		//NUMERO DE FILAS QUE ESTA EN EL EXCEL QUE SE SUBIO
		Integer numeroFilasExcelSubido = 0;
		//PARAMETRO CON EL NUMERO MAXIMO DE REGISTROS
		String numeroMaximoRegistros = StringUtils.EMPTY;
		try{
			if(inputStreamArchivo != null && tipoCabeceras != null){
				LOG_SICV2.info(">>>>>>>>>>>SE INICIA LA VALIDACION DEL ARCHIVO<<<<<<<<<<<<<");
				
				observaciones = new ArrayList<String>();
				datosValidosArchivo = new Duplex<Collection<CatalogoValorDTO>, MultiKeyMap>();
				Workbook wb = archivoArticulosCargado(inputStreamArchivo);
				if(wb != null){
					sheet = wb.getSheetAt(0);
					Iterator<Row> rowIterator = sheet.rowIterator();
					rowIteratorArchivo = sheet.rowIterator();
					numeroFilasExcelSubido = sheet.getLastRowNum();
					lstCatalogoValorCabeceras = obtenerListaCabeceras(tipoCabeceras);
					numeroColumnas = CollectionUtils.size(lstCatalogoValorCabeceras);
					numeroMaximoRegistros = obtenerParametro(articuloEdicionMasivaArchivoVO.getCodigoCompania(), SICArticuloConstantes.getInstancia().EDICION_ARTICULO_EXCE_PARAMETRO_MAX_FILAS);
					if(NumberUtils.isNumber(numeroMaximoRegistros)){
						numeroMaximoFilas = Integer.valueOf(numeroMaximoRegistros);
					}else{
						numeroMaximoFilas = 2000;
					}
					numeroMaximoFilas = ((numeroMaximoFilas == null ? 2000 : numeroMaximoFilas));
					
					if(numeroFilasExcelSubido > numeroMaximoFilas){
						for(int i = numeroMaximoFilas + 1; i <= numeroFilasExcelSubido; i++){
							observacion = MessageFormat.format(SICArticuloMessages.getInstancia().
								      getString("ec.com.smx.sic.articulo.validacion.archivo.columna.generica.tamanio.maximo.mensaje.extra"), String.valueOf(i+1), 0, "archivo excel ", numeroMaximoFilas + " art\u00EDculos");
							observaciones.add(observacion);
						}
						numeroFila = numeroMaximoFilas;
					}else{
						numeroMaximoFilas = numeroMaximoFilas + 2;
						//Recorrer las filas
						while(rowIterator.hasNext() && numeroFila < numeroMaximoFilas){
							Row rowExcel = rowIterator.next();
							//Se verifica que las cabeceras esten correctas
							if(numeroFila == 1){
								LOG_SICV2.info("SE INICIA LA VALIDACION DE LAS CABECERAS");
								observacion = validarCabeceraArchivo(rowExcel, lstCatalogoValorCabeceras);
								//Verificar la validacion de la cabecera
								if(StringUtils.isNotBlank(observacion)){
									LOG_SICV2.error("Ha ocurrido un error al validar las cabeceras... " + MessageFormat.format(SICArticuloMessages.
											getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.cabecera.error"), observacion));
									throw new SICException(MessageFormat.format(SICArticuloMessages.
											getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.cabecera.error"), observacion));
								}
								LOG_SICV2.info("SE FINALIZA LA VALIDACION DE LAS CABECERAS");
							}else{
								if(numeroFila == 2){
									LOG_SICV2.info("SE INICIA LA OBTENCION DE LAS FILAS INGRESADAS EN EL EXCEL");
								}
								List celdasTempList = new ArrayList();//Lista con las celdas validadas
								boolean estaLlena = Boolean.FALSE;
								/*SE RECORRE TODAS LAS CELDAS DE LA FILA PARA SABER SI POR LO MENOS UNA ESTA LLENA PARA QUE SEA UNA FILA
								CANDIDATA PARA LA VALIDACION*/
								for(Cell cell : rowExcel){
									if(StringUtils.equals(StringUtils.trim(obtenerValorCeldaString(cell)), "")){
										//SI POR LO MENOS UNA CELDA ESTA LLENA ES OBTIENE EL VALOR DE TRUE Y NO SE CAMBIA A FALSE
										if(!estaLlena){
											estaLlena = Boolean.FALSE;
										}
									}else{
										estaLlena = Boolean.TRUE;
									}
								}
								//SI ESTA LLENA LA FILA SE PROCEDE A LA VALIDACION
								if(estaLlena){
									//SE RECORRE LA LIST
									for(CatalogoValorDTO dto : lstCatalogoValorCabeceras){
										//SE OBTIENE LA CELDA DE ACUERDO AL ORDEN DE LA CABECERA, SI ES NULL SE CREA UNA CELDA EN BLANCO
										Cell celdaExcel = rowExcel.getCell(Integer.valueOf(dto.getOrden()), Row.CREATE_NULL_AS_BLANK);
										if(StringUtils.equals(StringUtils.trim(String.valueOf(celdaExcel)), "")){
											//Valido que las columnas que no son requeridas se ingresen
											if(!dto.getEsValorPorDefecto()){
												celdaExcel.setCellValue(" ");
												celdasTempList.add(celdaExcel);
											}else{
												//Verifico que las columnas no esten vacias
												observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.vacia"), numeroFila,Integer.valueOf(dto.getOrden()),dto.getNombreCatalogoValor());
												LOG_SICV2.error(StringUtils.substring(observacion, 4));
												observaciones.add(observacion);
												continue;
											}
										}else if((dto.getValorNumerico() == null ? 0 : dto.getValorNumerico()) == 1
												&& (!StringUtils.equals(StringUtils.trim(String.valueOf(celdaExcel)), ""))
												&& (!NumberUtils.isNumber(String.valueOf(celdaExcel)))){
											//verifico las columnas numericas
											//SI LA COLUMNA ES DE TIPO NUMERICA Y EL VALOR DE LA CELDA NO ES NUMERICO SE AGREGA EL ERROR
											observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.tipo.numerico"), String.valueOf(numeroFila),Integer.valueOf(dto.getOrden()),dto.getNombreCatalogoValor());
											LOG_SICV2.error(StringUtils.substring(observacion, 4));
											observaciones.add(observacion);
											continue;
										}else{
											//Agrego las columnas que no tienen restricciones
											celdasTempList.add(celdaExcel);
										}
										if(CollectionUtils.isNotEmpty(celdasTempList)
												&& CollectionUtils.size(celdasTempList) == numeroColumnas){
											//este metodo agrega el numero de fila evaluada y despues agrega la fila
											celdasTempList.add(numeroFila);//Se almacena el numero de la fila evaluada
											datosCeldaTmp.add(celdasTempList);//Se almacenan los datos de cada fila
											LOG_SICV2.info("FILA: {} : {}", String.valueOf(numeroFila), celdasTempList.toString());
										}
									}
								}
							}
							numeroFila++;
							if(rowIterator.hasNext() == Boolean.FALSE){
								LOG_SICV2.info("SE FINALIZA LA OBTENCION DE LAS FILAS INGRESADAS EN EL EXCEL");
							}
						}
					}
					
					//Se valida que el archivo se encuentra vacio
					if(numeroFila <= 2 && !StringUtils.isNotEmpty(StringUtils.trim(observacion))){
						LOG_SICV2.error(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.vacio"));
						observacion = SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.vacio");
						observaciones.add(observacion);
						this.validacionArticuloCreacionPorArchivoGestor.generarExcelConErrores(articuloVO, observaciones, rowIteratorArchivo, numeroColumnas, lstCatalogoValorCabeceras);
					}
					
					//Se valida el formato del archivo
					if(datosCeldaTmp != null && CollectionUtils.isNotEmpty(datosCeldaTmp)){
						datosValidosArchivo = validarFormatoArchivo(datosCeldaTmp, observaciones, articuloEdicionMasivaArchivoVO, lstCatalogoValorCabeceras, articuloVO.getCodigofuncionario());
					}
					
					//Generacion de archivo excel cuando existen errores en las observaciones
					if(CollectionUtils.isNotEmpty(observaciones) && numeroFila > 2){
						LOG_SICV2.info("Se genera el archivo excel con las observaciones de errores respectivas");
						LOG_SICV2.info("OBSERVACIONES: {}", observaciones.toString());
						this.validacionArticuloCreacionPorArchivoGestor.generarExcelConErrores(articuloVO, observaciones, rowIteratorArchivo, numeroColumnas, lstCatalogoValorCabeceras);
					}
				}
				LOG_SICV2.info("Fin de la validacion del archivo");
			}
		}catch(Exception e){
			throw new SICException(e.getMessage());
		}
		return datosValidosArchivo;
	}
	
	
	@SuppressWarnings("rawtypes")
	private Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> validarFormatoArchivo(List cellDataList, List<String> observaciones, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Collection<CatalogoValorDTO> lstCatalogoValorDTO, String codigoFuncionario) throws SICException {
		//VARIABLE CON LOS OBJETOS VALIDADOS PARA SER ENVIADOS A LA CREACION
				Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidados = null;
				//VARIABLE EN LA CUAL SE SE AGRUPAN LOS DATOS PARA VALIDA
				MultiKeyMap datosParaValidar = null;
				//VARIABLE CON LOS DATOS VALIDADOS
				MultiKeyMap datosValidadosMapa = null;
				//VARIABLE EN LA CUAL SE AGREGAN LOS DATOS NECESARIOS PARA VALIDAR CADA FILA
				LinkedHashMap<String, Integer> camposNecesarios = null;
				Collection<CatalogoValorDTO> lstCabecerasCatalogoValorDTO = null;
				//VARIABLE EN LA CUAL SE ALMACENA EL CODIGO DE COMPANIA
				Integer codigoCompania = null;
				//VARIABLE QUE ALMACENA EL NUMERO DE FILA QUE SE ESTA VALIDANDO
				Integer numeroFila = null;
				//VARIABLE QUE ALMACENA EL NUMERO DE COLUMNAS DEL EXCEL
				Integer numeroColumnas = null;
				//VARRIABLE QUE ALMACENA EL VALOR DE LA COLUMNA QUE SE ESTA VALIDANDO
				Integer ordenColumna = null;
				//VARIABLE QUE ALMACENA EL CODIGO DE CABECERA QUE SE ESTA VALIDANDO
				String codigoCabecera = StringUtils.EMPTY;
				//VARIABLE QUE ALMACENA EL CODIGO DE USUARIO MODIFICACION
				String codigoUsuarioModificacion = StringUtils.EMPTY;
				//MAPA CON EL MAPA DE CODIGO DE CABECERAS Y NOMBRE CABECERAS
				Map<String, String> cabecerasMapa = null;
		try{
			LOG_SICV2.info("SE INGRESA A VALIDAR EL FORMATO DEL ARCHIVO");
			cabecerasMapa = new LinkedHashMap<String, String>();
			cabecerasMapa = obtenerMapaCabeceras(lstCatalogoValorDTO);
			if(CollectionUtils.isNotEmpty(cellDataList) && articuloEdicionMasivaArchivoVO != null && CollectionUtils.isNotEmpty(lstCatalogoValorDTO)){
				lstCabecerasCatalogoValorDTO = lstCatalogoValorDTO;
				if(CollectionUtils.isNotEmpty(lstCabecerasCatalogoValorDTO)){
					//SE INICIA LAS VARIALBES PARA VALIDAR EL TODAS LAS FILAS DEL DOCUMENTO
					datosValidados = new Duplex<Collection<CatalogoValorDTO>, MultiKeyMap>();
					datosParaValidar = new MultiKeyMap();
					datosValidadosMapa = new MultiKeyMap();
					camposNecesarios = new LinkedHashMap<String, Integer>();
					codigoCompania = articuloEdicionMasivaArchivoVO.getCodigoCompania();
					codigoUsuarioModificacion = articuloEdicionMasivaArchivoVO.getUsuarioModificacion();
					numeroColumnas = CollectionUtils.size(lstCabecerasCatalogoValorDTO);
					datosValidados.setFirstObject(lstCabecerasCatalogoValorDTO);
					//Recorro la lista de filas
					for(int i=0; i<cellDataList.size(); i++){
						//OBTENGO LA FILA i PARA VALIDARLA
						List cellTempList = (List) cellDataList.get(i);
						//OBTENGO EL NUMERO DE LA FILA QUE SE ESTA VALIDANDO
						numeroFila = (Integer) cellTempList.get(numeroColumnas);
						//recorro las columnas
						for(CatalogoValorDTO dto : lstCabecerasCatalogoValorDTO){
							//SE OBTIENE EL ORDEN DE LA COLUMNA QUE SE ESTA VALIDANDO
							ordenColumna = Integer.valueOf(dto.getOrden());
							//SE OBTIENE EL ORDEN DE LA COLUMNA QUE SE ESTA VALIDANDO
							codigoCabecera = dto.getId().getCodigoCatalogoValor();
							//SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL ORDEN Y EL CODIGO DE BARRAS
							if(StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS)){
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}//SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL ORDEN Y LA CLASE
							if(StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE)){
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}//SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL ORDEN Y LA FECHA FIN TEMPORADA
							if(StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA)){
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}//SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL ORDEN Y LA FECHA INICIO TEMPORADA
							if(StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA)){
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}//SE AGREGA EN EL MAPA DE CAMPOS NECESARIOS EL ORDEN Y EL CASUSAL
							if(StringUtils.equals(codigoCabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CAUSAL)){
								camposNecesarios.put(codigoCabecera, Integer.valueOf(dto.getOrden()));
							}
							datosParaValidar.put(numeroFila, ordenColumna, codigoCabecera, (Cell) cellTempList.get(ordenColumna));
						}
					}//SE PROCEDE A VALIDAR LOS DATOS
					if(MapUtils.isNotEmpty(datosParaValidar) && MapUtils.isNotEmpty(camposNecesarios)){
						datosValidadosMapa = validarDatosMapa(datosParaValidar, observaciones, lstCabecerasCatalogoValorDTO, camposNecesarios, codigoCompania, codigoFuncionario, codigoUsuarioModificacion, cabecerasMapa);
					}//SE AGREGA AL DUPLEX LOS DATOS VALIDADOS
					datosValidados.setSecondObject(datosValidadosMapa);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al validar el archivo excel. {}",e.getMessage());
			throw new SICException("Ha ocurrido un error al validar el archivo excel. {}",e.getMessage());
		}finally{
			datosParaValidar = null;
			datosValidadosMapa = null;
		}
		return datosValidados;
	}
	
	/**
	 * METODO QUE VALIDA LOS DATOS DE TODAS LAS FILAS INGRESADAS
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private MultiKeyMap validarDatosMapa(MultiKeyMap datosParaValidar, List<String> observaciones, Collection<CatalogoValorDTO> lstCabecerasCatalogoValorDTO, LinkedHashMap<String, Integer> camposNecesarios, Integer codigoCompania, String codigoFuncionario, String usuarioModificacion, Map<String, String> cabecerasMapa) throws SICException {
		MultiKeyMap datosValidados = null;
		MultiKeyMap datosValidadosTmp = null;
		MultiKeyMap datosValidadosAgrupados = null;
		Integer numeroColumnas = null;
		Integer orden = null;
		Integer numeColumnaTmp = null;
		String campoTmp = StringUtils.EMPTY;
		String cabecera = StringUtils.EMPTY;
		String campo = StringUtils.EMPTY;
		String fechaInicioTemporada = StringUtils.EMPTY;
		String fechaFinalTemporada = StringUtils.EMPTY;
		Cell celdaTmp = null;
		Cell celda = null;
		Set objectList [] = null;
		boolean esFilaValida [] = null;
		Set<Integer> indiceFila = null;
		Set<MultiKey> keys = null;
		LinkedHashMap<String, String> mapCamposReqValidacion = null;
		try{
			LOG_SICV2.info(">>>>>>>>>>>>>>>>>>>>>>>SE INGRESA A VALIDAR LOS DATOS DEL MAPA<<<<<<<<<<<<<<<<<<<");
			if(MapUtils.isNotEmpty(datosParaValidar) && codigoCompania != null && CollectionUtils.isNotEmpty(lstCabecerasCatalogoValorDTO)){
				datosValidadosAgrupados = new MultiKeyMap();
				indiceFila = new LinkedHashSet<Integer>();
				numeroColumnas = CollectionUtils.size(lstCabecerasCatalogoValorDTO);
				objectList = new Set[numeroColumnas];
				keys = datosParaValidar.keySet();
				obtenerIndiceFilas(keys, indiceFila);
				//Recorro las filas ingresadas
				for(Integer numeroFila : indiceFila){
					datosValidados = new MultiKeyMap();
					esFilaValida = new boolean[1];
					esFilaValida[0] = Boolean.TRUE;
					mapCamposReqValidacion = new LinkedHashMap<String, String>();
					mapCamposReqValidacion.put("CODIGOCOMPANIA", String.valueOf(codigoCompania));
					mapCamposReqValidacion.put("USUARIOMODIFICACION", usuarioModificacion);
					//Validaciones para el codigo de barras
					if(camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS)){
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS);
										
						Integer numColClase = camposNecesarios.get(SICArticuloConstantes.VALOR_CABECERA_CLASE);
						Cell celdaClase = (Cell) datosParaValidar.get(numeroFila, numColClase, SICArticuloConstantes.VALOR_CABECERA_CLASE);;
						String campoClase = this.validacionArticuloCamposEdicionArchivoGestor.obtenerValorCeldaString(celdaClase);
						
						campoTmp = validacionesCodigoBarras(celdaTmp, objectList, observaciones, numeColumnaTmp, numeroFila, codigoCompania, codigoFuncionario, esFilaValida, cabecerasMapa, campoClase);
						datosValidados.put(numeroFila, numeColumnaTmp,SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS, campoTmp);
					}
					//Validaciones para la clase
					if(camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE)){
						numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE);
						celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE);
						campoTmp = validacionesClase(celdaTmp, objectList, observaciones, numeColumnaTmp, numeroFila, codigoCompania, esFilaValida, cabecerasMapa);
						datosValidados.put(numeroFila, numeColumnaTmp,SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE, campoTmp);
						mapCamposReqValidacion.put(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE, campoTmp);
					}
					//Fecha inicio y fin
					if(StringUtils.isNotEmpty(StringUtils.trim(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE))) 
							&& StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada"))){

						if(camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA)){
							numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA);
							celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA);
							validacionArticuloCamposEdicionArchivoGestor.validacionesFechaInicioFinTemporada(celdaTmp, observaciones, numeroFila, numeColumnaTmp, Boolean.TRUE, esFilaValida, cabecerasMapa);
							fechaInicioTemporada = obtenerValorCeldaString(celdaTmp);
						}
						if(camposNecesarios.containsKey(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA)){
							numeColumnaTmp = camposNecesarios.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA);
							celdaTmp = (Cell) datosParaValidar.get(numeroFila, numeColumnaTmp, SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA);
							validacionArticuloCamposEdicionArchivoGestor.validacionesFechaInicioFinTemporada(celdaTmp, observaciones, numeroFila, numeColumnaTmp, Boolean.FALSE, esFilaValida, cabecerasMapa);
							fechaFinalTemporada = obtenerValorCeldaString(celdaTmp);
						}
					}
					
					//recorro las columnas
					for(CatalogoValorDTO dto : lstCabecerasCatalogoValorDTO){
						orden = Integer.valueOf(dto.getOrden());
						cabecera = dto.getId().getCodigoCatalogoValor();
						celda = (Cell) datosParaValidar.get(numeroFila, orden, cabecera);
						LOG_SICV2.info(dto.getOrden() + celda.toString());
						//Compara que las cabecera no sea una ya validada anteriormente
						if(!StringUtils.equals(cabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CODIGO_BARRAS)
								&& !StringUtils.equals(cabecera, SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE)){
							//verifico que la clase sea tipo T para validar fecha inicio y fecha fin
							if(StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.claseArticulo.temporada"))
									&& (StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_INICIO_TEMPORADA)
									|| StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_FECHA_FIN_TEMPORADA))){
								if(StringUtils.isNotEmpty(StringUtils.trim(fechaInicioTemporada)) || StringUtils.isNotEmpty(StringUtils.trim(fechaFinalTemporada))){
									campo = validacionArticuloCreacionPorArchivoGestor.validacionesFechaInicioFinTemporada(fechaInicioTemporada, fechaFinalTemporada, cabecerasMapa, cabecera, numeroFila, orden, observaciones, esFilaValida);
									datosValidados.put(numeroFila, orden, cabecera, campo);
								}else{
									validacionArticuloCamposEdicionArchivoGestor.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
								}
							}else if((StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_O)
									|| StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_I)
									|| StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_E))
									&& StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_CAUSAL)){
								campo = validacionesExisteCausal(celda, objectList, observaciones, orden, numeroFila, codigoCompania, mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), esFilaValida, cabecerasMapa);
								datosValidados.put(numeroFila, orden, cabecera, campo);
							}else if((!StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_O)
									|| !StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_I)
									|| !StringUtils.equals(mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), SICArticuloConstantes.getInstancia().CODIGO_CLASE_ARTICULO_E))
									&& StringUtils.equals(StringUtils.trim(cabecera), SICArticuloConstantes.getInstancia().VALOR_CABECERA_CAUSAL)){
								this.validarCausalNoNecesario(celda, observaciones, orden, numeroFila, mapCamposReqValidacion.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE), esFilaValida);
							}
						}
					}
					//SE PROCEDE A AGRUPAR LOS DATOS PARA ESCOGER SOLO LAS FILAS VALIDAS
					datosValidadosTmp = validacionArticuloCreacionPorArchivoGestor.agruparDatosMapaValidados(datosValidados, numeroFila, esFilaValida[0], lstCabecerasCatalogoValorDTO);
					if(MapUtils.isNotEmpty(datosValidadosTmp)){
						datosValidadosAgrupados.putAll(datosValidadosTmp);
					}
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("HA OCURRIDO UN ERROR AL VALIDAR LOS DATOS DEL MAPA. {}",e.getMessage());
		}finally{
			celdaTmp = null;
			celda = null;
			datosValidados = null;
			datosValidadosTmp = null;
			mapCamposReqValidacion = null;
		}
		return datosValidadosAgrupados;
	}
	
	/**
	 * METODO QUE PERMITE VALIDAR SI SE INGRESA UN CAUSAL EN UNA CLASE QUE NO REQUIERE CAUSAL
	 * @param celdaExcel
	 * @param observaciones
	 * @param numeroColumna
	 * @param numeroFila
	 * @param clase
	 * @param esFilaValida
	 */
	private void validarCausalNoNecesario(Cell celdaExcel, List<String> observaciones, Integer numeroColumna, Integer numeroFila, String clase, boolean esFilaValida []){
		String observacion = StringUtils.EMPTY;
		String causal = StringUtils.EMPTY;
		try{
			if(celdaExcel != null){
				causal = obtenerValorCeldaString(celdaExcel);
				if(StringUtils.isNotEmpty(StringUtils.trim(causal))){
					observacion = MessageFormat.format("{0},{1}, La clase {2} no posee ningun causal; revise por favor", String.valueOf(numeroFila), numeroColumna, clase);
					validacionArticuloCamposEdicionArchivoGestor.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
					observaciones.add(observacion);
				}
			}
		}catch(Exception e){
			LOG_SICV2.error("{}", e.getMessage());
		}
	}
	
	/**
	 * METODO PARA VALIDAR SI EXISTE EL CASUAL INGRESADO
	 * @param celdaExcel
	 * @param objectList
	 * @param observaciones
	 * @param numeroColumna
	 * @param numeroFila
	 * @param codigoCompania
	 * @param clase
	 * @param esFilaValida
	 * @param codigosCabeceras
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String validacionesExisteCausal(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, String clase, boolean esFilaValida [], Map<String, String> codigosCabeceras){
		String campo = StringUtils.EMPTY;
		String observacion = StringUtils.EMPTY;
		if(celdaExcel != null){
			campo = obtenerValorCeldaString(celdaExcel);
			if(StringUtils.isEmpty(StringUtils.trim(campo))){
				observacion = MessageFormat.format(SICArticuloMessages.getInstancia().getString("ec.com.smx.sic.articulo.validacion.archivo.columna.otro.campo.requerido"), String.valueOf(numeroFila), numeroColumna, codigosCabeceras.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CAUSAL), codigosCabeceras.get(SICArticuloConstantes.getInstancia().VALOR_CABECERA_CLASE));
				observaciones.add(observacion);
				validacionArticuloCamposEdicionArchivoGestor.agregarEsFilaValida(esFilaValida, Boolean.FALSE);
			}else{
				campo = validacionesCausal(celdaExcel, objectList, observaciones, numeroColumna, numeroFila, codigoCompania, clase, esFilaValida, codigosCabeceras);
			}
		}
		return campo;
	}
	
	/**
	 * METODO PARA VALIDAR EL CAUSAL INGRESADO
	 * @param celdaExcel
	 * @param objectList
	 * @param observaciones
	 * @param numeroColumna
	 * @param numeroFila
	 * @param codigoCompania
	 * @param clase
	 * @param esFilaValida
	 * @param codigosCabeceras
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String validacionesCausal(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, String clase, boolean esFilaValida [], Map<String, String> codigosCabeceras){
		String campo = StringUtils.EMPTY;
		List<MultiKeyMap> listaCausales = null;
		Set<MultiKeyMap> listaSet = null;
		Set<MultiKeyMap> listaSetTemp = null;
		Object object = null;
		try{
			object = objectList[numeroColumna];
			if(object == null){
				listaCausales = new ArrayList<MultiKeyMap>();
			}else{
				listaSetTemp = (Set<MultiKeyMap>) object;
				listaCausales = new ArrayList<MultiKeyMap>();
				listaCausales.addAll(listaSetTemp);
			}
			campo = validacionArticuloCamposEdicionArchivoGestor.validacionesCausal(celdaExcel, observaciones, numeroFila, numeroColumna, codigoCompania, clase, esFilaValida, listaCausales, codigosCabeceras);
			listaSet = new HashSet<MultiKeyMap>();
			listaSet.addAll(listaCausales);
			objectList[numeroColumna] = listaSet;
		}catch(Exception e){
			LOG_SICV2.error("Error al escoger el caso de validacion del causal: {}.",e.getMessage());
//			throw new SICException("Error al escoger el caso de validacion de codigo de barras: ", e.getMessage());
		}finally{
			object = null;
			listaCausales = null;
			listaSet = null;
			listaSetTemp = null;
		}
		return campo;
	}
	
	/**
	 * @param celdaExcel
	 * @param objectList
	 * @param observaciones
	 * @param numeroColumna
	 * @param numeroFila
	 * @param codigoCompania
	 * @param esFilaValida
	 * @return
	 * @author eharo
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private String validacionesCodigoBarras(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, String codigoFuncionario, boolean esFilaValida [], Map<String, String> codigosCabeceras, String claseArticulo){
		String campo = StringUtils.EMPTY;
		Set<String> listaCodigosBarras = null;
		Object object = null;
		try{
			object = objectList[numeroColumna];
			listaCodigosBarras = (object == null ? listaCodigosBarras = new HashSet<String>() : (Set<String>) object);
			campo = validacionArticuloCamposEdicionArchivoGestor.validacionesCodigoBarras(celdaExcel, observaciones, numeroFila, numeroColumna, codigoCompania, codigoFuncionario, listaCodigosBarras, esFilaValida, codigosCabeceras, claseArticulo);
			objectList[numeroColumna] = listaCodigosBarras;
		}catch(Exception e){
			LOG_SICV2.error("Error al escoger el caso de validacion de codigo de barras: {}.",e.getMessage());
//			throw new SICException("Error al escoger el caso de validacion de codigo de barras: ", e.getMessage());
		}finally{
			object = null;
			listaCodigosBarras = null;
		}
		return campo;
	}
	
	/**
	 * @param celdaExcel
	 * @param objectList
	 * @param observaciones
	 * @param numeroColumna
	 * @param numeroFila
	 * @param codigoCompania
	 * @param esFilaValida
	 * @param codigosCabeceras
	 * @return
	 * @author eharo
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private String validacionesClase(Cell celdaExcel, Set[] objectList, List<String> observaciones, Integer numeroColumna, Integer numeroFila, Integer codigoCompania, boolean esFilaValida [], Map<String, String> codigosCabeceras){
		String campo = StringUtils.EMPTY;
		Set<String> listaClaseArticulos = null;
		Object object = null;
		try{
			object = objectList[numeroColumna];
			listaClaseArticulos = (object == null ? listaClaseArticulos = new HashSet<String>() : (Set<String>) object);
			campo = validacionArticuloCamposEdicionArchivoGestor.validacionesClase(celdaExcel, observaciones, numeroFila, numeroColumna, codigoCompania, listaClaseArticulos, esFilaValida, codigosCabeceras);
			objectList[numeroColumna] = listaClaseArticulos;
		}catch(Exception e){
			LOG_SICV2.error("Error al escoger el caso de validacion de clase articulos: {}.",e.getMessage());
		}finally{
			object = null;
			listaClaseArticulos = null;
		}
		return campo;
	}
	
	/**
	 * @param keys
	 * @param indiceFila
	 * @author eharo
	 */
	private void obtenerIndiceFilas(Set<MultiKey> keys, Set<Integer> indiceFila){
		LinkedList<Integer> listaOrdenada = null;
		try{
			listaOrdenada = new LinkedList<Integer>();
			for(MultiKey key :keys){
				listaOrdenada.add(Integer.valueOf(String.valueOf(key.getKey(0))));
			}
			Collections.sort(listaOrdenada);
			for(Integer i : listaOrdenada){
				indiceFila.add(i);
			}
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener el indice de filas. {}", e.getMessage());
		}finally{
			listaOrdenada = null;
		}
	}
	
	/**
	 * METODO QUE GENERA UN MAPA CON EL CODIGO DE CABECERA Y EL NOMBRE DE CADA CABECERA
	 * @param lstCatalogoValorDTO
	 * @return
	 */
	private Map<String, String> obtenerMapaCabeceras(Collection<CatalogoValorDTO> lstCatalogoValorDTO){
		LinkedHashMap<String, String> cabecerasMapa = null;
		try {
			if(CollectionUtils.isNotEmpty(lstCatalogoValorDTO)){
				cabecerasMapa = new LinkedHashMap<String, String>();
				for(CatalogoValorDTO catalogoValorDTO: lstCatalogoValorDTO){
					cabecerasMapa.put(catalogoValorDTO.getId().getCodigoCatalogoValor(), catalogoValorDTO.getNombreCatalogoValor());
				}
			}
		} catch (Exception e) {
			throw new SICException("Error al cargar cabeceras en el mapa {}.", e.getMessage());
		}
		return cabecerasMapa;
	}
	
	/**
	 * Se procede a validar la cabecera del archivo
	 * para verificar que las columnas ingresadas son correctas
	 * @param rowExcel
	 * @param lstCatalogoValorDTO
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	private String validarCabeceraArchivo(Row rowExcel, Collection<CatalogoValorDTO> lstCatalogoValorDTO) throws SICException{
		String observacion = " ";
		Cell celdaCabecera = null;
		String valorCabecera = StringUtils.EMPTY;
		String columna = StringUtils.EMPTY;
		try{
			for(CatalogoValorDTO dto : lstCatalogoValorDTO){
				Integer orden = Integer.valueOf(dto.getOrden());
				celdaCabecera = rowExcel.getCell(orden, Row.CREATE_NULL_AS_BLANK);
				valorCabecera = obtenerValorCeldaString(celdaCabecera);
				if(StringUtils.isBlank(valorCabecera) 
						|| !StringUtils.equals(valorCabecera, dto.getNombreCatalogoValor())){
					columna = valorCabecera;
					if(StringUtils.equals(columna, "A")){
						observacion = columna;
					}else{
						if(StringUtils.isNotEmpty(StringUtils.trim(columna))){
							observacion = observacion.concat((StringUtils.isBlank(observacion)) ? columna : ", ".concat(columna));
						}
					}
				}
			}
		}catch(Exception e){
			throw new SICException("Error al validar la cabecera del archivo. {}",e.getMessage());
		}
		return observacion;
	}
	
	/**
	 * Metodo que retorna un string con el valor de la celda
	 * @param celda
	 * @return
	 * @author eharo
	 */
	private String obtenerValorCeldaString(Cell celda){
		String valorCelda = StringUtils.EMPTY;
		if(celda != null){
			valorCelda = validacionArticuloCamposEdicionArchivoGestor.obtenerValorCeldaString(celda);
		}
		return valorCelda;
	}
	
	/**
	 * METODO QUE PERMITE GENERAR UN OBJETO Workbook CON EL INPUTSTREAM 
	 * DEL ARCHIVO EXCEL
	 * @param inputStreamArchivo
	 * @return
	 * @author eharo
	 */
	private Workbook archivoArticulosCargado(InputStream inputStreamArchivo){
		Workbook workbook = null;
		try{
			if(inputStreamArchivo != null){
				
				workbook = WorkbookFactory.create(inputStreamArchivo);
				
			}
		}catch (Exception e) {
			LOG_SICV2.error("Error al cargar el archivo. {}",e.getMessage());
			throw new SICException("Error al cargar el archivo. {}",e.getMessage());
		}
		return workbook;
	}
	
	private List<CatalogoValorDTO> obtenerListaCabeceras (Integer tipoCabeceras){
		List<CatalogoValorDTO> listaCabeceras = null;
		try{
			
			listaCabeceras = this.articuloEdicionArchivoDAO.listaCabecerasEdicion(tipoCabeceras); 
					
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al intentar obtener la lista de cabeceras. {}", e.getMessage());
		}
		return listaCabeceras;
	}
	
	/**
	 * METODO PARA OBTENER UN PARAMETRO
	 * @param codigoCompania
	 * @param codigoParametro
	 * @return
	 */
	private String obtenerParametro(Integer codigoCompania, String codigoParametro){
		String valorParametro = StringUtils.EMPTY;
		try{
			valorParametro = creacionPorArchivoDAO.obtenerParametroRequerido(codigoCompania, codigoParametro);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error al obtener el parametro maximo de filas. {}", e.getMessage());
		}
		return valorParametro;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloEdicionArchivoGestor#obtenerCodigoArticuloDesdeCodigoBarras(java.lang.Integer, java.lang.String)
	 */
	@Override
	public String obtenerCodigoArticuloDesdeCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException {
		String codigoArticulo = StringUtils.EMPTY;
		try{
			codigoArticulo = this.articuloEdicionArchivoDAO.obtenerCodigoArticuloDesdeCodigoBarras(codigoCompania, codigoBarras);
		}catch(Exception e){
			LOG_SICV2.error("Ha ocurrido un error en obtener el codigo de articulo. {}", e.getMessage());
		}
		return codigoArticulo;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.edicion.IValidacionArticuloEdicionArchivoGestor#editarArticuloArchivo(ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO)
	 */
	@Override
	public Integer editarArticuloArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException {
		return this.articuloEdicionArchivoDAO.editarClaseArticulo(articuloEdicionMasivaArchivoVO);
	}
	
}
