/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo;

/**
 * @author fmunoz
 *
 */
public enum EnumConcentracionNutricional {

	ALTO(1),
	MEDIO(2),
	BAJO(3);
	
	private Integer valor;
	
	private EnumConcentracionNutricional(Integer valor) {
		this.valor = valor;
	}
	public Integer getValor() {
		return valor;
	}
	
}
