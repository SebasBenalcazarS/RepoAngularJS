package ec.com.smx.sic.cliente.common.procesamientoventas.beans;

import ec.com.smx.sic.cliente.resources.procesamientoventas.SICProcesamientoVentasMessages;

public enum DatosHistorialPreciosArticulo {
	COLUMNA_PRECIO_DESCUENTO(
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.preciodescuento.id"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.preciodescuento.name"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.preciodescuento.field"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.preciodescuento.toolTip")),
	COLUMNA_PRECIO_DESCUENTO_CON_CARGO(
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.preciodescuentocobro.id"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.preciodescuentocobro.name"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.preciodescuentocobro.field"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.preciodescuentocobro.toolTip")),
	COLUMNA_FECHA(
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.fecha.id"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.fecha.name"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.fecha.field"),
			SICProcesamientoVentasMessages.getInstancia().getString("ec.com.smx.sic.procesamiento.ventas.reporte.columna.fecha.toolTip"))
	;
	
	private final String id;
	private final String name;
	private final String field;
	private final String toolTip;

	private DatosHistorialPreciosArticulo(String id, String name, String field, String toolTip) {
		this.id = id;
		this.name = name;
		this.field = field;
		this.toolTip = toolTip;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getField() {
		return field;
	}

	public String getToolTip() {
		return toolTip;
	}
}
