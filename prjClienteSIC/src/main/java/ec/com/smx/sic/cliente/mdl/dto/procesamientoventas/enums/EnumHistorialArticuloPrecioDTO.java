package ec.com.smx.sic.cliente.mdl.dto.procesamientoventas.enums;

import ec.com.smx.sic.cliente.common.procesamientoventas.constantes.TipoClusterProcesamientoVenta;

/**
 * @author Marcelo Hidalgo
 *
 */
public enum EnumHistorialArticuloPrecioDTO {

	CLASS_NAME_TABLE("HistorialArticuloPrecioDTO"),
	ANIO_VENTA_ARTICULO("anio"),
	CODIGO_ARTICULO("codArt"),
	CODIGO_COMPANIA("codCom"), 	
	CODIGO_TIPO_PRECIO("codTipPre"), 
	MAPA_ANUAL_VALOR_TIPO_PRECIO("mapValTipPre");
	
	private String nameProperty;
	
	public static final TipoClusterProcesamientoVenta TIPO_CLUSTER_PROCESAMIENTO_VENTA = TipoClusterProcesamientoVenta.YEAR;

	private EnumHistorialArticuloPrecioDTO(String nameProperty) {
		this.nameProperty = nameProperty;
	}

	public String getNameProperty() {
		return nameProperty;
	}
}
