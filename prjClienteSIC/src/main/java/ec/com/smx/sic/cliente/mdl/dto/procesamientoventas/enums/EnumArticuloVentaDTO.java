/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.procesamientoventas.enums;

import ec.com.smx.sic.cliente.common.procesamientoventas.constantes.TipoClusterProcesamientoVenta;


/**
 * @author vjaramillo
 *
 */
public enum EnumArticuloVentaDTO {

	CLASS_NAME_TABLE("ArticuloVentaDTO"),
	CODIGO_ARTICULO("codArt"),
	CODIGO_COMPANIA("codCom"),	
	CODIGO_TRANSACCION("codTra"),
	FECHA_VENTA_ARTICULO("fecVenArt"),
	TOTAL_VENTA_ARTICULO("totVenArt"),
	INDEX_ARTICULO_VENTA("indexArtVen");
	
	private String nameProperty;
	
	public static final TipoClusterProcesamientoVenta TIPO_CLUSTER_PROCESAMIENTO_VENTA = TipoClusterProcesamientoVenta.YEAR_MONTH_TRANSACTION;
	
	private EnumArticuloVentaDTO(String nameProperty){
		this.nameProperty = nameProperty;
	}

	/**
	 * @return the nameProperty
	 */
	public String getNameProperty() {
		return nameProperty;
	}

	/**
	 * @param nameProperty the nameProperty to set
	 */
	public void setNameProperty(String nameProperty) {
		this.nameProperty = nameProperty;
	}
}
