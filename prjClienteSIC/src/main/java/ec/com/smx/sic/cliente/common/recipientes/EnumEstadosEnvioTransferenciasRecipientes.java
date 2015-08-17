package ec.com.smx.sic.cliente.common.recipientes;

import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;

public enum EnumEstadosEnvioTransferenciasRecipientes {
	
	
	INICIAL (SICRecipientesMessages.getInstancia().getString("etiqueta.recipientes.estado.inciada")),
	CERRADA	(SICRecipientesMessages.getInstancia().getString("etiqueta.recipientes.estado.cerrada")),
	TRANSITO (SICRecipientesMessages.getInstancia().getString("etiqueta.recipientes.estado.enTransito")),
	ABIERTA (SICRecipientesMessages.getInstancia().getString("etiqueta.recipientes.estado.abierta")),
	AGRUPADA (SICRecipientesMessages.getInstancia().getString("etiqueta.recipientes.estado.agrupada")),
	ANULADA (SICRecipientesMessages.getInstancia().getString("etiqueta.recipientes.estado.anulada")),
	ENRUTADA (SICRecipientesMessages.getInstancia().getString("etiqueta.recipientes.estado.enrutada"));
	
	String estado;
	
	EnumEstadosEnvioTransferenciasRecipientes(String estado){
		this.estado = estado;
	}
	public String getEstado() {
		return estado;
	}
}
