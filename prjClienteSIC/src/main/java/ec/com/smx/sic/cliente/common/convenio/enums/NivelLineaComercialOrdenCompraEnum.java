/** ec.com.smx.sic.cliente.common.convenio.enums
 * NivelLineaComercialOrdenCompraEnum.java
 * @author srodriguez
 * 11/3/2015
 */
package ec.com.smx.sic.cliente.common.convenio.enums;

/**
 * @author srodriguez
 *
 */
public enum NivelLineaComercialOrdenCompraEnum {
	
	/** Variable del tipo NivelLineaComercialOrdenCompraEnum NivelLineaComercialOrdenCompraEnum.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	SUBBODEGA(1),
	/** Variable del tipo NivelLineaComercialOrdenCompraEnum NivelLineaComercialOrdenCompraEnum.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	DEPARTAMENTO(2),
	/** Variable del tipo NivelLineaComercialOrdenCompraEnum NivelLineaComercialOrdenCompraEnum.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	CLASIFICACION(3),
	/** Variable del tipo NivelLineaComercialOrdenCompraEnum NivelLineaComercialOrdenCompraEnum.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	SUBCLASIFICACION(4),
	/** Variable del tipo NivelLineaComercialOrdenCompraEnum NivelLineaComercialOrdenCompraEnum.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	ARTICULO(6),
	/**
	 * Variable del tipo NivelLineaComercialOrdenCompraEnum marca comercial
	 * @author dbravo
	 */
	MARCA_COMERCIAL(5);

	private Integer prioridad;
	
	private NivelLineaComercialOrdenCompraEnum(Integer prioridad) {
		this.prioridad = prioridad;
	}

	
	public Integer getPrioridad() {
		return prioridad;
	}
}
