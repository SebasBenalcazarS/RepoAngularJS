/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.procesamientoventas.enums;

import ec.com.smx.sic.cliente.common.procesamientoventas.constantes.TipoClusterProcesamientoVenta;

/**
 * @author vjaramillo
 *
 */
public enum EnumArticuloAreaTrabajoVentaDTO {

	CLASS_NAME_TABLE("ArticuloAreaTrabajoVentaDTO"),
	COBRA_IVA_ARTICULO_AREA_TRABAJO("cobIva"),
	CODIGO_AREA_TRABAJO("codAreTra"),
	LINK_ARTICULO_VENTA_DTO("linkArtVen"),
	PORCENTAJE_IVA_ARTICULO_AREA_TRABAJO("porIva"),
	TOTAL_CANTIDAD_ARTICULO_AREA_TRABAJO("totCanArtAreTra"),	
	TOTAL_VENTA_ACUMULADA_ARTICULO_AREA_TRABAJO("totVenAcuArtAreTra"),
	INDEX_ARTICULO_AREA_TRABAJO_VENTA("indexArtAreTraVen");
	
	private String nameProperty;
	
	public static final TipoClusterProcesamientoVenta TIPO_CLUSTER_PROCESAMIENTO_VENTA = TipoClusterProcesamientoVenta.YEAR_MONTH_TRANSACTION;

	private EnumArticuloAreaTrabajoVentaDTO(String nameProperty){
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
