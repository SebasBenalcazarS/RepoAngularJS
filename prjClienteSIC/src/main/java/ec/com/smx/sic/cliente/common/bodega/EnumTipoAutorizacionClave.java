/**
 * 
 */
package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * @author jdvasquez
 *
 */
public enum EnumTipoAutorizacionClave {
	TIPO_ENCERAR_PALLET_MAX(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.autorizaciones.clave.encerar.pallet.max")),
	TIPO_CANCELAR_PALLET_MAX(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.autorizaciones.clave.cancelar.pallet.max")),
	TIPO_CAMBIAR_PRECIOS_RECEPCION_MAX(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.autorizaciones.clave.cambiar.precios.recepcion.max")),
	TIPO_ACTIVAR_INGRESO_MANUAL_MAX(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.autorizaciones.clave.activar.ingreso.manual.max")),
	TIPO_DESACTIVAR_INGRESO_MANUAL_MAX(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.autorizaciones.clave.desactivar.ingreso.manual.max")),
	TIPO_ACTIVAR_INGRESO_CAJA_MAX(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.autorizaciones.clave.activar.ingreso.caja.max")),
	TIPO_DESACTIVAR_INGRESO_CAJA_MAX(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.autorizaciones.clave.desactivar.ingreso.caja.max")),
	TIPO_CONFIGURAR_VALIDACIONES_ETIQUETADO_MAX(SICBodegaMessajes.getInstancia().getInteger("ec.com.smx.sic.bodega.autorizaciones.clave.configurar.validaciones.etiquetado.max"));
	
	private Integer tipoAutorizacion;
	
	private  EnumTipoAutorizacionClave(Integer tipoAutorizacion){
		this.tipoAutorizacion = tipoAutorizacion;
	}

	/**
	 * @return the tipoAutorizacion
	 */
	public Integer getTipoAutorizacion() {
		return tipoAutorizacion;
	}

	/**
	 * @param tipoAutorizacion the tipoAutorizacion to set
	 */
	public void setTipoAutorizacion(Integer tipoAutorizacion) {
		this.tipoAutorizacion = tipoAutorizacion;
	}
	
	
}
