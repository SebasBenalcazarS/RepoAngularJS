package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en los procesos de bodega
 * 
 * @author acaiza
 *
 */
public enum EnumTipoPedido {

	//VALORES TIPO DE RECEPCION
	NORMAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoOrde.normal")),
	BONIFICACION(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoOrde.bonificacion")),
	ESPECIAL(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.ordenCompra.codigo.catalogoValor.tipoOrde.especial")),
	;
	
	/**
	 * The tipoRecepcion
	 */
	private String tipoRecepcion;
	
	private EnumTipoPedido(String tipoRecepcion) {
		this.tipoRecepcion = tipoRecepcion;
	}
	
	/**
	 * Realiza la busqueda de un EnumTipoRecepcion en base al valor de un tipo de recepcion
	 * 
	 * @param tipoRecepcion
	 * @return Un EnumTipoRecepcion
	 */
	public static EnumTipoPedido getEnumTipoRecepcion(String tipoRecepcion) {
		for (EnumTipoPedido enumTipoRecepcion : EnumTipoPedido.values()) {
			if (enumTipoRecepcion.getTipoRecepcion().equals(tipoRecepcion))  {
				return enumTipoRecepcion;
			}
		}
		return null;
	}
	
	/**
	 * @return the tipoRecepcion
	 */
	public final String getTipoRecepcion() {
		return tipoRecepcion;
	}
	/**
	 * @param tipoRecepcion the tipoRecepcion to set
	 */
	public final void setTipoRecepcion(String tipoRecepcion) {
		this.tipoRecepcion = tipoRecepcion;
	}
}
