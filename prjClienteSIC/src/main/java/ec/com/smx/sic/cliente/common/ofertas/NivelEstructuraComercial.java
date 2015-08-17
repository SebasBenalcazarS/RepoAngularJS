/**
 * 
 */
package ec.com.smx.sic.cliente.common.ofertas;

import java.util.Arrays;
import java.util.List;

import ec.com.smx.sic.cliente.common.gestionprecios.constantes.GestionPrecioConstantes;

/**
 * @author gnolivos
 *
 */
public enum NivelEstructuraComercial {
	
	CLASIFICACION(GestionPrecioConstantes.getInstancia().CODIGO_CLASIFICACION ,GestionPrecioConstantes.getInstancia().DESCRIPCION_CLASIFICACION),
	DEPARTAMENTO(GestionPrecioConstantes.getInstancia().CODIGO_DEPARTAMENTO, GestionPrecioConstantes.getInstancia().DESCRIPCION_DEPARTAMENTO),
	DIVISION(GestionPrecioConstantes.getInstancia().CODIGO_DIVISION, GestionPrecioConstantes.getInstancia().DESCRIPCION_DIVISION);
	
	private final String value;
	private final String label;
	
	/**
	 * Cosntructor.
	 * @param value
	 * @param label
	 */
	private NivelEstructuraComercial(String value, String label) {
		this.label = label;
		this.value = value;
	}
	
	/**
	 * Lista con valores.
	 * @return
	 */
	public static List<NivelEstructuraComercial> getNivelesEstructuraComercial(){
		return Arrays.asList(NivelEstructuraComercial.values());
	}
	
	public static List<NivelEstructuraComercial> getListaDesdeDepartamento(){
		return Arrays.asList(NivelEstructuraComercial.CLASIFICACION, NivelEstructuraComercial.DEPARTAMENTO);
	}

	public static NivelEstructuraComercial valueOfEstructuraComercial(String codigoEstructuraComercial) {
		
		NivelEstructuraComercial opcionEstructuraCom = null;

		if (DIVISION.getValue().equals(codigoEstructuraComercial)) {
			opcionEstructuraCom = NivelEstructuraComercial.DIVISION;
		} 
		else if (DEPARTAMENTO.getValue().equals(codigoEstructuraComercial)) {
			opcionEstructuraCom = NivelEstructuraComercial.DEPARTAMENTO;			
		}
		else if (CLASIFICACION.getValue().equals(codigoEstructuraComercial)) {
			opcionEstructuraCom = NivelEstructuraComercial.CLASIFICACION;			
		}
		
		return opcionEstructuraCom;
		
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
}
