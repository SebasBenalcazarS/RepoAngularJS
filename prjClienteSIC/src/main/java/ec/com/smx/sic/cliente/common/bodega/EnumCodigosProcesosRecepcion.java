/**
 * 
 */
package ec.com.smx.sic.cliente.common.bodega;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;

/**
 * @author jdvasquez
 *
 */
public enum EnumCodigosProcesosRecepcion {
	
	EDICION_DATOS_EXTRA(new Long(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.codigo.proceso.edicion.datos.extra")));
	
	Long codigoProceso;

	private EnumCodigosProcesosRecepcion(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}
	
}
