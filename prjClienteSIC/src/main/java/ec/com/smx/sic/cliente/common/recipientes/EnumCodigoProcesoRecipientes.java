package ec.com.smx.sic.cliente.common.recipientes;

import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;

public enum EnumCodigoProcesoRecipientes {
	
	
	CREACION_CAJAS (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoProceso.creacionCajas").longValue()),
	CREACION_PALLETS (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoProceso.creacionPallets").longValue()),
	CREACION_TRANSFERENCIA_RECIPIENTES (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoProceso.transferenciaRecipientes").longValue()),
	CREACION_DEVOLUCION_PROVEEDOR (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoProceso.devolucionProveedor").longValue()),
	CREACION_TRANSFERENCIA_MERCADERIA_GENERAL (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoProceso.transferenciaMercaderia").longValue());
	
	Long proceso;
	
	EnumCodigoProcesoRecipientes(Long proceso){
		this.proceso = proceso;
	}
	public Long getProceso() {
		return proceso;
	}
}
