/**
 * 
 */
package ec.com.smx.sic.cliente.common.bodega;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Clase con los m&eacute;todos para realizar las validaciones necesarias para la recepcion de perecibles
 * @author wcaiza
 *
 */
public final class ValidacionRecepcionPereciblesUtil {
	
	/**
	 * Validar si el peso ingresado no excede el peso pendiente de recibir, en caso de exceder 
	 * el peso se verifica que no se exceda el peso m&aacute;s el porcentaje de exceso al recibir.
	 * @param mensajesError
	 * @param pesoNeto
	 * @param pesoPendienteRecibir
	 * @param porcentajeExesoRecepcion
	 */
	public static void validarExcedePesoRecepcion (Collection<String> mensajesError, BigDecimal pesoNeto, BigDecimal pesoPendienteRecibir, Double porcentajeExesoRecepcion) {
		
		if (pesoNeto.compareTo(pesoPendienteRecibir)>0) {
			
			if (porcentajeExesoRecepcion.doubleValue() > 0) {
				
				BigDecimal pesoNetoConExeso = pesoNeto.add(pesoNeto.multiply(new BigDecimal(porcentajeExesoRecepcion/100)));
				
				if (pesoNetoConExeso.compareTo(pesoPendienteRecibir)>0) {
					mensajesError.add("No se puede recibir m\u00e1s de lo autorizado");
				}
				
			} else {
				mensajesError.add("No se puede recibir m\u00e1s de lo autorizado");
			}
			
		} 
		
	}
	
	/**
	 * Validar si el peso del pallet mecanico excede el peso bruto ingresado
	 * @param mensajesError
	 * @param pesoBruto
	 * @param pesoPalletJack
	 */
	public static void validarPesoBrutoExcedePesoPallets(Collection<String> mensajesError, BigDecimal pesoBruto, BigDecimal pesoPalletJack) {
		
		if (pesoBruto.compareTo(pesoPalletJack)<0) {
			mensajesError.add("Peso de jabas y pallets excede Peso Bruto");
		}
		
	}
	
	/**
	 * Validar si el peso neto acumulado excede el peso planificado
	 * @param mensajesError
	 * @param pesoNetoAcumulado
	 * @param pesoPlanificado
	 */
	public static void validarPesoNetoAcumuladoExcedePesoPlanificado (Collection<String> mensajesError, BigDecimal pesoNetoAcumulado, BigDecimal pesoEnviadoAgrupado) {
		
		if (pesoNetoAcumulado.compareTo(pesoEnviadoAgrupado)>0) {
			mensajesError.add("Peso Neto Acumulado excede Peso Planificado");
		}
		
	}

}
