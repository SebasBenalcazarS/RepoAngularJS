package ec.com.smx.sic.cliente.common.bodega;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.exception.ValidadorEanException;
import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public final class ValidacionEanUtil {

	/**
	 * Constructor
	 */
	private ValidacionEanUtil() {

	}

	private static final ValidacionEanUtil INSTANCIA = new ValidacionEanUtil();

	/**
	 * @return the instancia
	 */
	public static ValidacionEanUtil getInstancia() {
		return INSTANCIA;
	}


	/***************************************************************************
	 * Metodo que verifica si el prefijo ingresao corresponde a un
	 * EAN(13-14-128) y devuelve el codigo de barras copletado con ceros.
	 * @param ean (Codigo Barras EAN(13-14-128)
	 * @param tipEan (13-14-128)
	 * @return Codigo Barras completado con ceros.
	 * @author cquilumba
	 ***************************************************************************/
	public static Map<String, String> verificarPrefijo(String ean, int tipEan) throws ValidadorEanException{
		Map<String, String> codigoBarras = new HashMap<String, String>();
		int limite = 0;
		String prefijo = "";
		String codigo = ean;
		Pattern p = Pattern.compile(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.ean.patron.identificador.codigo"));
		
		Matcher m = p.matcher(ean.toUpperCase());
		boolean resul = m.find();
		if (resul) {
			prefijo = ean.substring(m.start(), m.end()).trim().toUpperCase();
			codigo = ean.substring(m.end(), ean.length()).trim();
		}

		if (!StringUtils.isNumeric(codigo) && tipEan != EnumEan.EAN128.getTipo()) {
			throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
			
		} else if ((tipEan == EnumEan.EAN13.getTipo() 
				&& codigo.length() < EnumEan.EAN13.getMaxLength()) ||
				tipEan == EnumEan.EAN13.getTipo() && codigo.length() > EnumEan.EAN13.getMaxLength() || tipEan == EnumEan.EAN13.getTipo() 
				&& !prefijo.equals(EnumEan.EAN13.getIdentificadorCodigo())) {
			throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
			
		} else if (tipEan == EnumEan.EAN14.getTipo() && codigo.length() > EnumEan.EAN14.getMaxLength() || (tipEan == EnumEan.EAN14.getTipo() 
				&& ean.length() < EnumEan.EAN14.getMaxLength()) || tipEan == EnumEan.EAN14.getTipo() && !prefijo.equals(EnumEan.EAN14.getIdentificadorCodigo())) {
			throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
			
		} else if (tipEan == EnumEan.EAN128.getTipo() && ean.length() > EnumEan.EAN128.getMaxLength() || tipEan == EnumEan.EAN128.getTipo() 
				&& !prefijo.equals(EnumEan.EAN128.getIdentificadorCodigo())) {
			throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
		}
		
		if (tipEan == EnumEan.EAN13.getTipo()) {
			limite = EnumEan.EAN13.getMaxLength() - codigo.length();
			
		}

		if (tipEan == EnumEan.EAN13.getTipo()) {
			for (int i = 0; i < limite; i++) {
				codigo = "0".concat(codigo);
			}
		}
		
		codigoBarras.put(prefijo, codigo);
		
		return codigoBarras;
	}

	/*****************************************************************************
	 * Metodo que verifica si el codigo EAN128 es v\u00E1lido. Recibe como parametro
	 * el EAN128 incluido el prefijo y el tipo, devueve true o false.
	 * @param ean (Codigo de barras EAN128)
	 * @param tipEan (128)
	 * @return true - false.
	 * @author cquilumba
	 *******************************************************************************/
	public boolean validarEan128(String eanAux, int tipEan) throws ValidadorEanException {
		String ean = eanAux;
		String prefijo = null;
		String ia = null;
		Boolean resultado = Boolean.FALSE;
		Map<String, String> barCode = ValidacionEanUtil.verificarPrefijo(ean, tipEan);
		Map.Entry<String, String> entry = barCode.entrySet().iterator().next();
		prefijo = entry.getKey();
		ean = entry.getValue();
		
		if (prefijo.equals("")){
			throw new ValidadorEanException("errors.recepcion.formato.ean");
		}
//		this.validarEan128Identificadores(ean);
		int length = 0;
		String cadena = ean;
		for (int i = 0; i < cadena.length(); i++) {
			Pattern p = Pattern.compile(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.ean.patron.ia"));
			Matcher m = p.matcher(cadena);
			if (m.find()) {
				ia = m.group();
				if (ia.equals(EnumIdentificadorAplicacion.SSCC.getCodigoIdentificadorAplicacion()) 
						&& cadena.length() >= (m.end() + EnumIdentificadorAplicacion.SSCC.getLongitudIdentificadorAplicacion())) {
					length = m.end() + EnumIdentificadorAplicacion.SSCC.getLongitudIdentificadorAplicacion();
					if (cadena.length() == length || cadena.length() == ean.length() && StringUtils.isNumeric(cadena.substring(m.end(), length))) {
						resultado = validarEan(EnumEan.EAN128.getIdentificadorCodigo() + cadena.substring(m.end(), length), EnumEan.EAN128.getTipo());
						
					} else {
						throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
					}
				}
				if (ia.equals(EnumIdentificadorAplicacion.EAN14.getCodigoIdentificadorAplicacion())) {
					length = m.end() + EnumIdentificadorAplicacion.EAN14.getLongitudIdentificadorAplicacion();
					if (cadena.length() == length || cadena.length() == ean.length() && cadena.length() >= EnumEan.EAN14.getMaxLength() 
							&& StringUtils.isNumeric(cadena.substring(m.end(), length))) {
						resultado = validarEan(EnumEan.EAN14.getIdentificadorCodigo() + cadena.substring(m.end(), length), EnumEan.EAN14.getTipo());
						
					} else {
						throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
					}
				}
				if (ia.equals(EnumIdentificadorAplicacion.EAN13.getCodigoIdentificadorAplicacion())) {
					length = m.end() + EnumIdentificadorAplicacion.EAN13.getLongitudIdentificadorAplicacion();
					if (cadena.length() == length || cadena.length() == ean.length() && cadena.length() >= EnumEan.EAN14.getMaxLength() 
							&& StringUtils.isNumeric(cadena.substring(m.end(), length))) {
						resultado = validarEan(EnumEan.EAN13.getIdentificadorCodigo() + cadena.substring(m.end() + 1, length), EnumEan.EAN13.getTipo());
						
					} else {
						throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
					}
				}
				cadena = cadena.substring(length, m.regionEnd());
			}
		}
		if (resultado == false){
			throw new ValidadorEanException("errors.recepcion.formato.ean");
		}
		return resultado;
	}
	
	public Duplex<Boolean, Map<String, String>> validarEan128Identificadores(String ean128, int tipEan) throws ValidadorEanException{
		String ean = ean128;
		String prefijo = null;
		Map<String, String> barCode = ValidacionEanUtil.verificarPrefijo(ean, tipEan);
		Map.Entry<String, String> entry = barCode.entrySet().iterator().next();
		prefijo = entry.getKey();
		ean = entry.getValue();
		Map<String, String> mapIdentificadoresAplicacion = null;
		Duplex<Boolean, Map<String, String>> identificadoresValidos  = null;
		try {
			if (prefijo.equals("")){
				throw new ValidadorEanException("errors.recepcion.formato.ean");
			}
			mapIdentificadoresAplicacion = obtenerIdentificadoresEan128(ean);
			identificadoresValidos = new Duplex<Boolean, Map<String,String>>();
			if(MapUtils.isNotEmpty(mapIdentificadoresAplicacion) 
					&& mapIdentificadoresAplicacion.get(EnumIdentificadorAplicacion.EAN14.getCodigoIdentificadorAplicacion()) != null){
				String valorEan14 = mapIdentificadoresAplicacion.get(EnumIdentificadorAplicacion.EAN14.getCodigoIdentificadorAplicacion());
				
				identificadoresValidos.setFirstObject(Boolean.valueOf(obtenerDigitoVerificador(valorEan14) == 
						Integer.parseInt(valorEan14.substring(valorEan14.length() - 1, valorEan14.length()))));
				
				identificadoresValidos.setSecondObject(mapIdentificadoresAplicacion);
			}else{
				throw new ValidadorEanException("errors.recepcion.no.contiene.ean");
			}
		} catch (Exception e) {
			throw new ValidadorEanException("errors.recepcion.no.contiene.ean");
		}
		return identificadoresValidos;
	}
	
	/**
	 * Metodo que permite obtener los identificadores de aplicacion
	 * @param ean
	 * @return
	 */
	private Map<String, String> obtenerIdentificadoresEan128(String ean) {
		Map<String, String> mapValoresIdentificadores = new HashMap<String, String>();
		Integer contIdentificador = 2;
		String cadena = ean;
		String codigoIdentificadorAplicacion= null;
		Integer limiteIdentificador = null;
		Integer inicioIdentificadorRestante = null;
		EnumIdentificadorAplicacion enumIdentificadorAplicacion = null;
		for (int i = 0; i < cadena.length(); i++) {
			codigoIdentificadorAplicacion = cadena.substring(0, contIdentificador);
			enumIdentificadorAplicacion = EnumIdentificadorAplicacion.valueOfCodigoIdentificadorAplicacion(codigoIdentificadorAplicacion);
			if(enumIdentificadorAplicacion != null && enumIdentificadorAplicacion.getTipoIdentificadorAplicacion()
					== SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.fijo")){
				
				limiteIdentificador = contIdentificador+enumIdentificadorAplicacion.getLongitudIdentificadorAplicacion();
				mapValoresIdentificadores.put(codigoIdentificadorAplicacion, cadena.substring(contIdentificador, limiteIdentificador));
				inicioIdentificadorRestante = contIdentificador + enumIdentificadorAplicacion.getLongitudIdentificadorAplicacion();
				cadena = this.obtenerCadenaRestante(cadena, inicioIdentificadorRestante, limiteIdentificador );
				contIdentificador = 2;
			}else if (enumIdentificadorAplicacion != null && enumIdentificadorAplicacion.getTipoIdentificadorAplicacion()
					== SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.identificador.aplicacion.tipo.variable")){
				limiteIdentificador = obtenerPosicionIdentificadorVariable(cadena);
				mapValoresIdentificadores.put(codigoIdentificadorAplicacion, cadena.substring(contIdentificador, limiteIdentificador));
				contIdentificador--;
				inicioIdentificadorRestante = contIdentificador + obtenerPosicionIdentificadorVariable(cadena);
				cadena = this.obtenerCadenaRestante(cadena, inicioIdentificadorRestante, limiteIdentificador);
				contIdentificador = 2;
			}else{
				contIdentificador++;
				if(contIdentificador >4){
					break;
				}
			}
		}
		return mapValoresIdentificadores;
	}
	
	/**
	 * Metodo que obtiene la posicion del indentificador de aplicacion variable
	 * y si no tiene retorna la posicion final
	 * @param ean128Variable
	 * @return
	 */
	private  Integer obtenerPosicionIdentificadorVariable(final String ean128Variable){
		Integer posicion = 0;
		if(ean128Variable != null){
			for(int i = 2; i < ean128Variable.length(); i++){
				if(Character.isWhitespace(ean128Variable.charAt(i))){
					posicion = i;
					break;
				}
			}
			if (posicion == 0) {
				posicion = ean128Variable.length();
			}
		}
		return posicion;
	}
	
	/**
	 * Metodo que obtiene la cadena restante del ean128
	 * @param cadena
	 * @param inicioIdentificador
	 * @param limiteIdentificador
	 * @return
	 */
	private String obtenerCadenaRestante(String cadena, Integer inicioIdentificador, Integer limiteIdentificador){
		String cadenaRestante = cadena;
		if(cadena.length() == limiteIdentificador){
			cadenaRestante = StringUtils.EMPTY;
		}else{
			cadenaRestante = cadenaRestante.substring(inicioIdentificador, cadena.length());
		}
		return cadenaRestante;
	}
	
	/********************************************************************************
	 * Metodo que verifica si el codigo de barras EAN(13-14) ingresado
	 * es v\u00E1lido, recibe como par\u00E1metro el ean y el tipo y retorna true o false.
	 * @param ean (codigobarras ean(13-14)
	 * @param tipEan (13-14)
	 * @return true o false
	 * @throws NumberFormatException
	 * @author cquilumba
	 ********************************************************************************/
	public boolean validarEan(String eanAux, int tipEan) throws ValidadorEanException {
		String ean = eanAux;
		Boolean resultado = Boolean.FALSE;
		String prefijo = null;
		Map<String, String> barCode = ValidacionEanUtil.verificarPrefijo(ean, tipEan);
		Map.Entry<String, String> entry = barCode.entrySet().iterator().next();
		prefijo = entry.getKey();
		ean = entry.getValue();
		
		if (prefijo.equals("")){
			throw new ValidadorEanException("errors.recepcion.formato.ean");
		}
		if ((ean != null) && (StringUtils.isNumeric(ean) && prefijo != null)) {
			if (ean.length() == EnumEan.EAN13.getMaxLength() && prefijo.equals(EnumEan.EAN13.getIdentificadorCodigo()) 
					&& tipEan == EnumEan.EAN13.getTipo() || ean.length() == EnumEan.EAN13.getMaxLength() && prefijo.equals("")) {
				
				resultado = Boolean.valueOf(obtenerDigitoVerificador(ean) == Integer.parseInt(ean.substring(ean.length() - 1, ean.length())));
				
			} else if (ean.length() == EnumEan.EAN14.getMaxLength() && prefijo.equals(EnumEan.EAN14.getIdentificadorCodigo()) 
					&& tipEan == EnumEan.EAN14.getTipo() || prefijo.equals(EnumEan.EAN14.getIdentificadorCodigo()) && ean.length() > EnumEan.EAN14.getMaxLength()) {
				
				resultado = Boolean.valueOf(obtenerDigitoVerificador(ean) == Integer.parseInt(ean.substring(ean.length() - 1, ean.length())));
				
			} 
//			else if (prefijo.equals(EnumEan.EAN128.getIdentificadorCodigo()) && tipEan == EnumEan.EAN128.getTipo() 
//					|| tipEan == EnumEan.EAN128.getTipo() && prefijo.equals("")) {
//				
//				resultado = Boolean.valueOf(obtenerDigitoVerificador(ean) == Integer.parseInt(ean.substring(ean.length() - 1, ean.length())));
//				
//			}
			else {
				throw new ValidadorEanException("errors.recepcion.formato.ean");
			}
		}
		if (resultado == false){
			throw new ValidadorEanException("errors.recepcion.formato.ean");
		}
		return resultado;
	}

	/*******************************************************************************
	 * M\u00e9todo que calcula y devuelve el d\u00edgito verificador de un codigo EAN13
	 * EAN14 Y EAN128
	 * @param ean codigoBarras EAN(13,14,128) sin el identificador de codigo (A-F-K)
	 * @return Digito Verificador.
	 * @throws ValidadorEanException 
	 * @author cquilumba
	 *******************************************************************************/
	public int obtenerDigitoVerificador(String ean) throws ValidadorEanException {
		int checkSum = 0;
		String codBarras = "";
		if (!StringUtils.isNumeric(ean)) {
			throw new ValidadorEanException("errors.recepcion.formato.ean");
		}
		if (ean.length() <= EnumEan.EAN13.getMaxLength() - 1) {
			codBarras = new StringBuilder(ean.substring(0, ean.length())).reverse().toString();
		} else {
			codBarras = new StringBuilder(ean.substring(0, ean.length() - 1)).reverse().toString();
		}

		for (int i = 0; i < codBarras.length(); i++) {
			if ((i % 2) == 0) {
				checkSum += Character.getNumericValue(codBarras.charAt(i)) * 3;
			} else {
				checkSum += Character.getNumericValue(codBarras.charAt(i));
			}
		}
		return ((10 - (checkSum % 10)) == 10) ? 0 : (10 - (checkSum % 10));
	}
	
	/**
	 * @param ean
	 * @return
	 * @throws ValidadorEanException
	 */
	public boolean validarEanCompletado(String ean) throws ValidadorEanException{
		Boolean eanValido = Boolean.FALSE;
		eanValido = Boolean.valueOf(obtenerDigitoVerificadorGeneral(ean) == Integer.parseInt(ean.substring(ean.length() - 1, ean.length())));
		if (!eanValido){
			throw new ValidadorEanException("errors.recepcion.formato.ean");
		}
		return eanValido;
	}
	
	/**
	 * @param ean
	 * @return
	 */
	public static String verificarPrefijoEanCompletado(String ean){
		String eanAux = ean;
		String prefijo = StringUtils.EMPTY;
		Pattern patronInicio = Pattern.compile(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.ean.patron.identificador.inicio.cero"));
		Matcher comparacionInicio = patronInicio.matcher(ean);
		
		if(comparacionInicio.find()){
			Pattern patron = Pattern.compile(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.ean.patron.identificador.cantidad.ceros"));
			Matcher comparacion = patron.matcher(ean);
			if(comparacion.find()){
				prefijo = eanAux.substring(comparacion.start(), comparacion.end());
				eanAux = eanAux.substring(prefijo.length(),eanAux.length());
			}
		}
		return eanAux;
	}
	
	/**
	 * M\u00e9todo que calcula y devuelve el d\u00edgito verificador de cualquier codigo ean
	 * valido
	 * @param ean
	 * @param cantidadEanMenos
	 * @return
	 */
	public int obtenerDigitoVerificadorGeneral(String ean){
		int checkSum = 0;
		String codBarras = "";
		codBarras = new StringBuilder(ean.substring(0, ean.length() - 1)).reverse().toString();
		for (int i = 0; i < codBarras.length(); i++) {
			if ((i % 2) == 0) {
				checkSum += Character.getNumericValue(codBarras.charAt(i)) * 3;
			} else {
				checkSum += Character.getNumericValue(codBarras.charAt(i));
			}
		}
		return ((10 - (checkSum % 10)) == 10) ? 0 : (10 - (checkSum % 10));
	}

	/**************************************************************************************************************
	 * M\u00e9todo que obtiene el Ean14 desde un Ean128 ingresado.
	 * @param ean Codigo barras Ean128
	 * @return Ean14
	 * @throws ValidadorEanException
	 **************************************************************************************************************/
	public String obtenerEan14DesdeEan128(String ean) throws ValidadorEanException {
		String resultado = null;
		String cadena = "";
		int length = 0;
		String ia = null;

		Map<String, String> barCode = ValidacionEanUtil.verificarPrefijo(ean, EnumEan.EAN128.getTipo());
		Map.Entry<String, String> entry = barCode.entrySet().iterator().next();
		cadena = entry.getValue();
		
		for (int i = 0; i < cadena.length(); i++) {
			Pattern p = Pattern.compile(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.ean14.patron.ia"));
			Matcher m = p.matcher(cadena);
			if (m.find()) {
				ia = m.group();
				if (ia.equals(EnumIdentificadorAplicacion.EAN14.getCodigoIdentificadorAplicacion())) {
					length = m.end() + EnumIdentificadorAplicacion.EAN14.getLongitudIdentificadorAplicacion();
					if (cadena.length() >= length) {
						resultado = EnumEan.EAN14.getIdentificadorCodigo()+""+cadena.substring(m.end(), length);
						break;
					} else {
						throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
					}
				}

				cadena = cadena.substring(length, m.regionEnd());
			}
		}
		if (resultado == null) {
			throw new ValidadorEanException("mensajes.error.no.contiene.ean");
		}
		
		return resultado;
	}

	/*********************************************************************************************************************
	 * M\u00e9todo que obtiene el tipo de c\u00f3digo ingresado
	 * @param ean (codigo barras)
	 * @return tipo Ean (13, 14 o 128).
	 * @throws ValidadorEanException
	 ********************************************************************************************************************/
	public int obtenerTipoEan(String ean) throws ValidadorEanException {
		int resultado = 0;
		if (StringUtils.isEmpty(ean)) {
			throw new ValidadorEanException();
		}
		String aux = ean.substring(0, 1).toUpperCase();

		if (aux.equals(EnumEan.EAN13.getIdentificadorCodigo())) {
			resultado = EnumEan.EAN13.getTipo();
		} else if (aux.equals(EnumEan.EAN14.getIdentificadorCodigo())) {
			resultado = EnumEan.EAN14.getTipo();
		} else if (aux.equals(EnumEan.EAN128.getIdentificadorCodigo())) {
			resultado = EnumEan.EAN128.getTipo();
		} else {
			throw new ValidadorEanException("errors.recepcion.formato.ean");
		}
		return resultado;
	}
	
	/**************************************************************************
	 * M\u00e9todo que obtiene un EAN 13 apartir de un EAN 14
	 * @param ean (Codigo Baras Ean 14) sin el Identificador de codigo, n\u00famero
	 * de 14 digitos.
	 * @return Ean13(Identificador de codigo + codigo+digitoverificador)
	 * @author cquilumba
	 **************************************************************************/
	public String obtenerEan13DesdeEan14(String ean) throws ValidadorEanException {
		String result = null;
		if (ean.length() != EnumEan.EAN14.getMaxLength()) {
			throw new ValidadorEanException("errors.recepcion.codigo.EAN.parametro");
		}
		
//		Integer tamanioCodigo = EnumEan.EAN13.getMaxLength() - 1;
		Integer iniCodigo = 2;
//		tamanioCodigo = iniCodigo + tamanioCodigo;
		String codEanCalcular = ean.substring(iniCodigo, EnumEan.EAN14.getMaxLength());
		try {
			int digitoVerificador = this.obtenerDigitoVerificador(codEanCalcular);
			result = EnumEan.EAN13.getIdentificadorCodigo().concat(codEanCalcular.concat(String.valueOf(digitoVerificador)));
		} catch (Exception e) {
			result = e.getMessage();
		}
		return result;
	}
	
	/**************************************************************************************************************
	 * M\u00e9todo que  obtiene la fecha de caducidad desde un EAN 128
	 * @param ean Codigo barras Ean128
	 * @return fechaCaducidad formato AAMMDD
	 * @throws ValidadorEanException
	 **************************************************************************************************************/
	public String obtenerFechaCaducidadDesdeEan128(String ean) throws ValidadorEanException {
		String resultado = null;		
		int length = 6;
		int posInicio = ean.length()-length;		
		resultado = ean.substring(posInicio, ean.length());		
		return resultado;
	}
	
}