
package ec.com.smx.sic.cliente.common.bodega;

/**
 * Contiene los valores para el orden de recepcion de bodega
 * 
 * @author acaiza
 *
 */
public enum EnumMetodoRecepcionBodega {

	//Valores para los metodos de recepcion de bodega MR1, MR2
	MR1("MR1"),
	MR2("MR2"),
	;
	
	private String valor;
	
	private EnumMetodoRecepcionBodega(String valor){
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
	
	public static EnumMetodoRecepcionBodega getEnumOrdenRecepcionBodega(String valor) {
		for (EnumMetodoRecepcionBodega enumMetodoRecepcionBodega : EnumMetodoRecepcionBodega.values()) {
			if (enumMetodoRecepcionBodega.getValor().equals(valor))  {
				return enumMetodoRecepcionBodega;
			}
		}
		return null;
	}
}
