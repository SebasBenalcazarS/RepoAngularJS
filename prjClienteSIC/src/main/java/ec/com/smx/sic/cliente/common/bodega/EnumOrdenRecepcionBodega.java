
package ec.com.smx.sic.cliente.common.bodega;

/**
 * Contiene los valores para el orden de recepcion de bodega
 * 
 * @author acaiza
 *
 */
public enum EnumOrdenRecepcionBodega {

	//Valores para el orden de recepcion de bodega ASC, DESC
	ASC("ASC"),
	DESC("DESC"),
	;
	
	private String valor;
	
	private EnumOrdenRecepcionBodega(String valor){
		this.valor = valor;
	}

	/**
	 * @return the codigoCatalogoValor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param codigoCatalogoValor the codigoCatalogoValor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public static EnumOrdenRecepcionBodega getEnumOrdenRecepcionBodega(String valor) {
		for (EnumOrdenRecepcionBodega enumOrdenRecepcionBodega : EnumOrdenRecepcionBodega.values()) {
			if (enumOrdenRecepcionBodega.getValor().equals(valor))  {
				return enumOrdenRecepcionBodega;
			}
		}
		return null;
	}
}
