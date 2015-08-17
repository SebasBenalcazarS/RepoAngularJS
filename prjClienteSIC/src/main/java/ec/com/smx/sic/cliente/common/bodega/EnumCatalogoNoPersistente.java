package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

public enum EnumCatalogoNoPersistente {

	TODOS(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.monitor.montacarga.estado.todos.id"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.monitor.montacarga.estado.todos.label")), 
	PENDIENTE(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.monitor.montacarga.estado.pendiente.id"), 
			SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.catalogo.monitor.montacarga.estado.pendiente.label"));

	private String id;
	private String label;

	EnumCatalogoNoPersistente(String id, String label) {
		this.id = id;
		this.label = label;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

}
