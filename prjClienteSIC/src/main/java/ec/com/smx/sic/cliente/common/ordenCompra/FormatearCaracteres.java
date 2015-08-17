package ec.com.smx.sic.cliente.common.ordenCompra;

import org.apache.commons.lang3.StringUtils;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.Logeable;

public class FormatearCaracteres implements Logeable{

	private final static FormatearCaracteres INSTANCIA = new FormatearCaracteres();
	
	
	public String reemplazarCaracteres(StringBuilder contenidoXML) {
		String newContenido = contenidoXML.toString();
			newContenido.replaceAll("�","a").replaceAll("�", "e").replaceAll("�", "i").replaceAll("�", "o").replaceAll("�", "u").replaceAll("�", "n");
		
		return newContenido;
	}
	
	/**
	 * M&eacute;todo que devuelve una cadena formateada a partir de un <code>Double</code> ingresado, 
	 * parte entera y decimal ser&aacute;n llenadas con cero hasta alcanzar los valores indicados 
	 * de <code>cifrasEntero</code> y <code>cifrasDecimal</code> indicados como par&aacute;metros 
	 * 
	 * @param value valor <code>Double</code> a ser formateado
	 * @param cifrasEntero n&uacute;mero de cifras enteras
	 * @param cifrasDecimal n&uacute;mero de cifras decimales
	 * @return cadena formateada
	 */
	public String getCadenaFormato(Double doubleValue, int cifrasEntero, int cifrasDecimal) {

		StringBuilder stringFormatted = null;

		if (doubleValue != null) {

			String parteEntera = getParteEnteraDecimalDouble(doubleValue).getFirstObject();
			String parteDecimal = getParteEnteraDecimalDouble(doubleValue).getSecondObject();

			stringFormatted = new StringBuilder();
			stringFormatted.append(formatNumber(parteEntera, cifrasEntero, "entero"));
			stringFormatted.append(formatNumber(parteDecimal, cifrasDecimal, "decimal"));

		} else {
			stringFormatted = new StringBuilder();
			int numberZeros = cifrasEntero + cifrasDecimal;

			for (int i = 0; i < numberZeros; i++) {
				stringFormatted.append("0");
			}
		}

		return stringFormatted.toString();
	}
	
	/**
	 * @param number 
	 * @param cifras
	 * @param tipo
	 * @return <code>Duplex</code>
	 */
	private Duplex<String, String> getParteEnteraDecimalDouble(Double doubleValue){

		Duplex<String, String> valorEnteroDecimal = null;

		if (doubleValue != null) {

			char[] chars = doubleValue.toString().toCharArray();
			boolean isDecimal = false;

			StringBuilder parteEntera = new StringBuilder();
			StringBuilder parteDecimal = new StringBuilder();

			for (char caracter : chars) {

				if (caracter == '.') {
					isDecimal = true;
				}

				if (!isDecimal) {
					parteEntera.append(caracter);
				} else {
					if (caracter != '.') {
						parteDecimal.append(caracter);
					}
				}
			}

			if (parteDecimal.length() == 0) {
				parteDecimal.append("0");
			}

			valorEnteroDecimal = new Duplex<String, String>(parteEntera.toString(), parteDecimal.toString());
		}

		return valorEnteroDecimal;
	}
	
	
	/**
	 * Rellena de ceros (la parte entera y decimal) de un n&uacute;mero de acuerdo a las cifras indicadas
	 * como par&aacute;metro 
	 * 
	 * @param number cadena a ser formateada (parte entera o decimal)
	 * @param cifras n&uacute;mero de caract&eacute;res que debera tener el n&uacute;mero ingresado
	 * @param tipo (entero o decimal) rellena de ceros parte derecha o izquierda de acuerdo al tipo
	 * @return
	 */
	private String formatNumber(String number, Integer cifras, String tipo) { 
		
		// add zero to decimal
		StringBuilder numberFormatted = null;

		if (cifras.intValue() != 0) {

			if (number.length() < cifras) {
				numberFormatted = new StringBuilder();

				// relleno cero a la derecha
				if (tipo.equals("decimal")) {
					numberFormatted.append(number);
				}

				int numberZeros = cifras - number.length();
				for (int i = 0; i < numberZeros; i++) {
					numberFormatted.append("0");
				}

				// relleno cero a la izquierda
				if (tipo.equals("entero")) {
					numberFormatted.append(number);
				}

			} else {
				numberFormatted = new StringBuilder(number.substring(0, cifras));
			}
		
		}else{
			numberFormatted = new StringBuilder();
		}

		return numberFormatted.toString();
	}
	
	/**
	 * Obtiene una cadena, representaci&oacute;n del double ingresado con el numero de cifras tanto entera como decimal 
	 * indicados en los par&aacute;metros cifrasEntero y cifrasDecimal ademas de especificar el separador 
	 * @param doubleValue
	 * @param cifrasEntero
	 * @param cifrasDecimal
	 * @param pSeparador
	 * @return
	 */
	public String getCadenaEnteroDecimal(Double doubleValue, int cifrasEntero, int cifrasDecimal, String pSeparador) {

		String separador = "";
		if (pSeparador != null) {
			separador = pSeparador;
		}

		StringBuilder stringFormatted = null;

		String parteEnteraFormato = null;
		String parteDecimalFormato = null;

		if (doubleValue != null) {

			if(cifrasEntero > 0){
				String parteEntera = getParteEnteraDecimalDouble(doubleValue).getFirstObject();
				parteEnteraFormato = parteEntera;//revisar formato
			}

			if(cifrasDecimal > 0){
				String parteDecimal = getParteEnteraDecimalDouble(doubleValue).getSecondObject();
				parteDecimalFormato = formatNumber(parteDecimal, cifrasDecimal, "decimal");
			}

		} else {
			if (cifrasDecimal > 0) {
				StringBuilder parteDecimalSB = new StringBuilder();
				for (int i = 0; i < cifrasDecimal; i++) {
					parteDecimalSB.append("0");
				}
				parteDecimalFormato = parteDecimalSB.toString();
			}

			parteEnteraFormato = "0";
		}

		stringFormatted = new StringBuilder();
		stringFormatted.append(parteEnteraFormato);

		if (cifrasDecimal > 0) {
			stringFormatted.append(separador);
			stringFormatted.append(parteDecimalFormato);
		}

		return stringFormatted.toString();
	}

	public String rellenarCeros(String pValor, Integer longitudCadena){
		
		StringBuilder cadenaResultado =  new StringBuilder();;
		if(StringUtils.isNotEmpty(pValor)){
			
			if(pValor.length() < longitudCadena){
				int numeroCerosAdd = longitudCadena - pValor.length();
				for (int i = 0; i < numeroCerosAdd; i++) {
					cadenaResultado.append(0);
				}
			}
		}
		
		return cadenaResultado.append(pValor).toString();
	}
	

	
	/**
	 * @return the instancia
	 */
	public static FormatearCaracteres getInstancia() {
		return INSTANCIA;
	}
}
