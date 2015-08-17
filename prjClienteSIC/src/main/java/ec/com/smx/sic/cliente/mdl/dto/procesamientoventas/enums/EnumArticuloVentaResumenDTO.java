package ec.com.smx.sic.cliente.mdl.dto.procesamientoventas.enums;

import ec.com.smx.sic.cliente.common.procesamientoventas.constantes.TipoClusterProcesamientoVenta;

/**
 * @author Luis Yacchirema
 *
 */
public enum EnumArticuloVentaResumenDTO {

	CLASS_NAME_TABLE("ArticuloVentaResumenDTO"),
	ANIO_VENTA_ARTICULO("anioVenArt"),
	CODIGO_ARTICULO("codArt"),
	CODIGO_COMPANIA("codCom"), 	
	CODIGO_TRANSACCION("codTra"), 
	MAPA_ANUAL_TOTAL_VENTA_ACUMULADA_ARTICULO("mapTotVenAcuArt");
	
	private String nameProperty;
	
	public static final TipoClusterProcesamientoVenta TIPO_CLUSTER_PROCESAMIENTO_VENTA = TipoClusterProcesamientoVenta.YEAR_TRANSACTION;

	private EnumArticuloVentaResumenDTO(String nameProperty) {
		this.nameProperty = nameProperty;
	}

	public String getNameProperty() {
		return nameProperty;
	}
	
}
