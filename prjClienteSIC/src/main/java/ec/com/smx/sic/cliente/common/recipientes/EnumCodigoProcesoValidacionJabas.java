/**
 * 
 */
package ec.com.smx.sic.cliente.common.recipientes;

import ec.com.smx.sic.cliente.resources.bodega.SICBodegaMessajes;
import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;

/**
 * @author jdvasquez
 *
 */
public enum EnumCodigoProcesoValidacionJabas {
	
	
	PROCESO_VALIDACION_JABA_PESO_FIJO(new Long(SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.proceso.validacion.jaba.peso.fijo"))),
	PROCESO_VALIDACION_JABA_PESO_VARIABLE(new Long(SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.proceso.validacion.jaba.peso.variable"))),
	PROCESO_VALIDACION_JABA_RECHAZO(new Long(SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.proceso.validacion.jaba.rechazo"))),
	PROCESO_RESUMEN_JABAS(new Long(SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.proceso.jabas.resumen"))),
	PROCESO_VALIDACION_JABAS_EDICION_DATOS_LOGISTICOS(new Long(SICBodegaMessajes.getInstancia().getString("ec.com.smx.sic.bodega.recepcion.codigo.proceso.validacion.jabas.edicion.datos.logisticos")));
	
	private Long codigo;
	/**
	 * @param codigo
	 */
	private EnumCodigoProcesoValidacionJabas(Long codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the codigo
	 */
	public Long getCodigo() {
		return codigo;
	}
}
