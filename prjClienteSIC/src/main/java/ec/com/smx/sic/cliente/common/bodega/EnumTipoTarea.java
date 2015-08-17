package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * Contiene los valores de los catalogos que intervienen en el proceso logistico
 * 
 * @author acaiza
 *
 */
public enum EnumTipoTarea {
	
	RECIBIR_PROVEEDOR( SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.recibir.proveedor")),
	INGRESAR_PALLET( SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.ingresar.pallet")),
	INGRESAR_PALLET_PESADO( SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.ingresar.pallet.pesado")),
	SUBIR_PALET( SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.subir.palet")),
	CONTROL_CALIDAD(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.control.calidad")),
	PESAR_PALLET(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.pesar.pallet")),
	DESPACHAR_RECIPIENTES(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.despachar.recipientes")),
	RECESO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.funcionario.receso")),
	ALMUERZO(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.tipo.tarea.funcionario.almuerzo"));
	
	private String codigoReferencia;
	
	private EnumTipoTarea(String codigoReferencia){
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	
	/**
	 * Realiza la busqueda de un EnumTipoTarea en base al valor de un codigo de referencia configurados en el enum
	 * 
	 * @param codigoReferencia
	 * @return Un EnumTipoTarea
	 */
	public static EnumTipoTarea getEnumTipoTarea(String codigoReferencia) {
		for (EnumTipoTarea enun : EnumTipoTarea.values()) {
			if (enun.getCodigoReferencia().equals(codigoReferencia))  {
				return enun;
			}
		}
		return null;
	}
}
