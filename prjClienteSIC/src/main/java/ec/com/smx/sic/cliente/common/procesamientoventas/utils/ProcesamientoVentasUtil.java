/**
 * 
 */
package ec.com.smx.sic.cliente.common.procesamientoventas.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.PredicateUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.framework.common.util.ColeccionesUtil;
import ec.com.smx.framework.common.util.transformer.GetInvokerTransformer;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.common.inventario.EnumTransaccionInventario;
import ec.com.smx.sic.cliente.common.procesamientoventas.constantes.ProcesamientoVentasConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.procesamientoventas.MigrarDatosProcesoVentaDTO;

/**
 * @author vjaramillo
 *
 */
public final class ProcesamientoVentasUtil {

	private static Collection<TransaccionDTO> transaccionesMAX;

	private static final ProcesamientoVentasUtil INSTANCE = new ProcesamientoVentasUtil();

	private ProcesamientoVentasUtil(){}

	public static ProcesamientoVentasUtil getInstance(){
		return INSTANCE;
	}
	
	
	/**
	 * Nos ayuda a crear un directorio si lo requiere y un archivo que nosotros deseemos, insertando
	 * una linea al final de dicho archivo
	 * @param nameFile
	 * @param pathDirArchivo
	 * @param textLine
	 * @throws SICException
	 * @throws IOException 
	 */
	public void crearActualizarArchivoFTP(String nameFile, String pathDirArchivo, String textLine)  throws SICException, IOException{
		File fileArchivo;
		BufferedWriter bw = null;
		try {
			fileArchivo = new File(pathDirArchivo);
			fileArchivo.mkdirs();
			
			fileArchivo = new File(pathDirArchivo.concat(nameFile));
			
			if ( !fileArchivo.exists() ){
				fileArchivo.createNewFile();
			}
			bw = new BufferedWriter(new FileWriter(fileArchivo, Boolean.TRUE));
			bw.write(textLine);
			bw.newLine();
			bw.close();
			
		} catch (Exception e) {
			Logeable.LOG_SICV2.error("No se pudo crear el archivo " + nameFile + "en la ruta: " + pathDirArchivo);
		}finally{
			if( bw  != null )
				bw.close();
		}
		
	}
	
	/**
	 * Metodo para obtener la linea de mi archivo tal cual se nos envio anets de un batch, si deseamos l agregamos un mensaje
	 * que deseemos agregar al final de la linea
	 * @param articuloMigracion
	 * @param mensaje
	 * @return
	 * @throws SICException
	 */
	public String generarTextoNovedadLineaArchivoArticulo(MigrarDatosProcesoVentaDTO articuloMigracion, String mensaje) throws SICException{
		String articuloSICArchivo = "" ;
		String mensajeInformativo = StringUtils.isNotEmpty(mensaje) ? " - ".concat(mensaje) : StringUtils.EMPTY;
		articuloSICArchivo = articuloSICArchivo.concat(articuloMigracion.getTipoRegistro())
				.concat(completarCerosIzquierda(articuloMigracion.getTransaccion().toString(),3))
				.concat(completarCerosIzquierda(articuloMigracion.getCodigoBarras(), 13))
				.concat(completarCerosIzquierda(articuloMigracion.getCantidad().toString(), 8))
				.concat(completarCerosIzquierda(articuloMigracion.getValorTotal().toString(), 11))
				.concat(articuloMigracion.getCobraIva().toString())
				.concat(completarCerosIzquierda(articuloMigracion.getPorcentajeIva().toString(), 4));
		return articuloSICArchivo.concat(mensajeInformativo);
	}
	
	/**
	 * Nos ayuda a agregar ceros a la 
	 * @param valorIncompleto
	 * @param maxCadena
	 * @return
	 * @throws SICException
	 */
	public String completarCerosIzquierda( String valorIncompleto, Integer maxCadena ) throws SICException{
		Boolean agregar = true;
		String cadena = valorIncompleto.replace(".", "").replace(",", "");
		while ( agregar ){
			if(cadena.length() == maxCadena)
				agregar = false;
			else{
				cadena = "0".concat(cadena);
			}
		}
		return cadena;
	}
	
	/**
	 * Obtenemos el codigo local por el nombre de archivo recibido
	 * @param nameFile
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerCodigoLocal(String nameFile) throws SICException {
		return  Integer.valueOf(nameFile != null ? (nameFile.substring(1, nameFile.length() - 12)) : "0");
	}
	
	/**
	 * Obtenemos la fecha de venta en la cual el articulo fue vendido.
	 * @param nameFile
	 * @param pattern
	 * @return
	 * @throws SICException
	 * @throws ParseException
	 */
	public Date obtenerFechaVentaArticulos(String nameFile, String pattern)
			throws SICException, ParseException {
		
		String fechaString = nameFile != null ? (nameFile.substring(
				nameFile.length() - 12, nameFile.length() - 4)) : null;

		fechaString = fechaString.substring(0, 4).concat("-")
				.concat(fechaString.substring(4, 6)).concat("-")
				.concat(fechaString.substring(6, 8));
		
		return obtenerFechaDesdeString(fechaString, pattern);
	}
	

	/**
	 * @param fechaString
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public Date obtenerFechaDesdeString(String fechaString, String pattern) throws ParseException{
		
		Date fechaVenta = null;
		
		if (StringUtils.isNotEmpty(fechaString)) {
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat(pattern, ProcesamientoVentasConstantes.LOCALE_ES);
			fechaVenta = formatoDelTexto.parse(fechaString);;
		}

		return fechaVenta;
	}


	/**
	 * @param fecha
	 * @param pattern
	 * @return
	 */
	public String devolverFormatoFechaPorPatronString(Date fecha, String pattern){
		SimpleDateFormat formatoDelTexto;
		if ( fecha != null ){
			formatoDelTexto = new SimpleDateFormat(
					pattern != null ? pattern : "yyyy-MM-dd");
			
			return formatoDelTexto.format(fecha);
		} else
			throw new SICException("Debe enviar la fecha y el patron");
		
	}


	/**
	 * Metodo para validar el nombre del archivo y crearlo
	 * @param codigoLocal
	 * @param fechaEjecucion
	 * @param pathDirProcesadosFtpSic
	 * @param mensajeGrabarArchivoArticuloProcesado
	 * @param migrarDatosProcesoVentaDTO
	 * @throws IOException 
	 */
	public void crearActualizarArchivo(String nameFileOriginal, Integer codigoLocal,
			Date fechaEjecucion, String pathDirProcesadosFtpSic,
			String mensajeGrabarArchivoArticuloProcesado,
			MigrarDatosProcesoVentaDTO migrarDatosProcesoVentaDTO)  throws SICException, IOException {
		
		Format formatoFecha;
		String nameFile, pathDirArchivo;
		// Obtenemos el nombre de nuestro archivo de acuerdo a la fecha q vamos a recibir con el formato de fecha yyyyMMddHHmmss
		formatoFecha = new SimpleDateFormat("yyyyMMddHHmmss");
		nameFile = nameFileOriginal.substring(0, nameFileOriginal.length() - 4).concat("_")
				.concat(formatoFecha.format(fechaEjecucion))
				.concat(".txt");
		// Obtenemos el path del archivo donde lo vamos a crear, tomando en cuenta la carpeta con el nombre de la fecha yyyy-MM-dd
		formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		pathDirArchivo = MessageFormat.format(pathDirProcesadosFtpSic, formatoFecha.format(fechaEjecucion));
		
		// Enviamos a crear o actualizar el archivo.
		crearActualizarArchivoFTP(
				nameFile, 
				pathDirArchivo, 
				generarTextoNovedadLineaArchivoArticulo(migrarDatosProcesoVentaDTO, mensajeGrabarArchivoArticuloProcesado));
		
	}
	
	/**
	 * 
	 * @param listaArticulosMigracionSIC
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public Set<String> obtenerCodigosBarras(List<? extends MigrarDatosProcesoVentaDTO> listaArticulosMigracionSIC) throws SICException{
		Set<String> codigosBarras = new HashSet<String>(CollectionUtils.collect(listaArticulosMigracionSIC, new GetInvokerTransformer("codigoBarras")));;
		Set<String> codigosBarrasTransofrmados = new HashSet<String>();
		for (String string : codigosBarras) {
			codigosBarrasTransofrmados.add(Long.valueOf(string).toString());
		}
		return codigosBarrasTransofrmados;
		
	}

	/**
	 * el @param numDiasSumarRestar nos indica cuantos dias queremos sumar o restar ( en este caso deben enviar numeros menores a cero )
	 * @param fechaActual
	 * @param numDiasSumarRestar .- este valor puede ser positivo (agregar) o negativo (disminuir)
	 * @param tipoCambio .- Este valor nos ayuda a restar dependiendo del parametro q puede ser: 
	 * 		- Calendar.DAY_OF_YEAR(dias), 
	 *		- Calendar.MONTH(meses) y 
	 *		- Calendar.YEAR(Año)
	 * @return
	 */
	public Date sumarRestarFechaPorParametro(Date fechaActual, int numDiasSumarRestar, int tipoCambio) {
		Calendar calendar = Calendar.getInstance(ProcesamientoVentasConstantes.LOCALE_ES);
		calendar.setTime(fechaActual);
		calendar.add(tipoCambio, numDiasSumarRestar);
		return calendar.getTime();
	}

	public Collection<TransaccionDTO> obtenerTransacciones(Integer codigoCompania) {
		
		if ( CollectionUtils.isEmpty(transaccionesMAX)){
			transaccionesMAX = SICFactory.getInstancia().procesamientoVentas.getIProcesamientoVentasServicio().obtenerCodigoTransaccionRelacionadoSIC(
					codigoCompania, 
					new HashSet<Integer>(Arrays.asList(
							EnumTransaccionInventario.VENTAS.getCodigoInterno(),
							EnumTransaccionInventario.DEVOLUCION_VENTAS.getCodigoInterno(),
							EnumTransaccionInventario.DESCUENTOS_PROMOCION.getCodigoInterno(),
							EnumTransaccionInventario.RECUPERACIONES_DESCUENTOS_PROMOCION.getCodigoInterno(),
							EnumTransaccionInventario.RECUPERACIONES_DIARIAS_DESCUENTOS_PROMOCION.getCodigoInterno())));
			
		}
		return transaccionesMAX;
	}
	
	public Set<Integer> obtenerCodigosTransaccion ( String codigosTransaccionString) {
		List<String> codigos;
		Set<Integer> codigosTransaccion;
		if ( StringUtils.isNotEmpty(codigosTransaccionString) ){
			codigos = new ArrayList<String>(Arrays.asList(codigosTransaccionString.split(",")));
			if ( CollectionUtils.isNotEmpty(codigos) ){
				codigosTransaccion = new HashSet<Integer>();
				for (String codTraString : codigos) {
					codigosTransaccion.add(Integer.parseInt(codTraString));
				}
				return codigosTransaccion;
			}
		}
		return new HashSet<Integer>();
	}
	/**	
	 * 
	 * @param codigoCompania
	 * @param codigoInternoTransaccionSIC
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerCodigoTransaccionMAX(Integer codigoCompania, Integer codigoInternoTransaccionSIC) throws SICException{
		Collection<TransaccionDTO> transaccionesMAX = obtenerTransacciones(codigoCompania);
		if ( CollectionUtils.isNotEmpty(transaccionesMAX) 
				&& codigoInternoTransaccionSIC != null )
			return ((TransaccionDTO)CollectionUtils.find(transaccionesMAX, PredicateUtils.transformedPredicate(new GetInvokerTransformer("codigoInterno"), PredicateUtils.equalPredicate(codigoInternoTransaccionSIC)))).getId().getCodigoTipoTransaccion();
		else
			throw new SICException("No existen codigos de transaccion correspondientes en el MAX o no no puede ser null el codigoTransaccionSIC");

	}
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigosInternosTransaccionSIC
	 * @return
	 * @throws SICException
	 */
	@SuppressWarnings("unchecked")
	public Set<Integer> obtenerCodigosTransaccionMAX(Integer codigoCompania, Set<Integer> codigosInternosTransaccionSIC) throws SICException {
		Collection<TransaccionDTO> transacciones =  obtenerTransacciones(codigoCompania);
		
		transacciones = ColeccionesUtil.getInstance().selectWithIn(transacciones, "codigoInterno", codigosInternosTransaccionSIC);
		return new HashSet<Integer>(CollectionUtils.collect(transacciones, new GetInvokerTransformer("id.codigoTipoTransaccion")));
	}

	/**
	 * Devuelve el maximo valor anterior al dia recibido
	 * @param valorAcumuladosMap
	 * @param valorDiaActual
	 * @return
	 * @throws SICException
	 */
	public BigDecimal obtenerValorAcumuladoAnterior (Map<String, Object> valorAcumuladosMap, Integer valorDiaActual, Boolean considerarDiaActual) throws SICException {
		if(valorDiaActual == null){
			valorDiaActual = 366;
		}
		
		BigDecimal valorAcumuladoAnterior = BigDecimal.ZERO;
		Set<String> keysMapSet;
		TreeSet<String> keysOrderMap = new TreeSet<String>(Collections.reverseOrder());
		
		if (MapUtils.isNotEmpty(valorAcumuladosMap)){
			// Obtenemos todas las claves de nuestro map
			keysMapSet = valorAcumuladosMap.keySet();
			// Los agregamos a nuestro treeMap para que se ordenen en forma descendente
			keysOrderMap.addAll(keysMapSet);
			
			for (String diaMapRecibido : keysOrderMap) {
				// Recorremos nuestros keys ordenados  y validamos cual es menor al dia recibido.
				if (considerarDiaActual ? Integer.valueOf(diaMapRecibido) <= valorDiaActual : Integer.valueOf(diaMapRecibido) < valorDiaActual)
					return new BigDecimal(valorAcumuladosMap.get(diaMapRecibido).toString());
			}
		}
		return valorAcumuladoAnterior;
	}
}
