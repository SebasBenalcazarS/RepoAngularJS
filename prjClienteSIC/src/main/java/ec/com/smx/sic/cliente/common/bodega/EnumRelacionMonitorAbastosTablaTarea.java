/**
 * 
 */
package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * @author wcaiza
 *
 */
public enum EnumRelacionMonitorAbastosTablaTarea {
	
	DEFAULT(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.relacion.tabla.tarea.monitor.abastos.valor.default")),
	INNER_JOIN(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.relacion.tabla.tarea.monitor.abastos.valor.inner")),
	LEFT_JOIN(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.relacion.tabla.tarea.monitor.abastos.valor.left"))
	;
	
	private String valorRelacion;
	
	private EnumRelacionMonitorAbastosTablaTarea (String valorRelacion) {
		this.valorRelacion = valorRelacion;
	}
	
	/**
	 * @return the valorRelacion
	 */
	public String getValorRelacion() {
		return valorRelacion;
	}
	
}
