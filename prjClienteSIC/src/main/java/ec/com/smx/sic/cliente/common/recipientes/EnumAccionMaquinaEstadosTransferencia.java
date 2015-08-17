package ec.com.smx.sic.cliente.common.recipientes;

import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;

public enum EnumAccionMaquinaEstadosTransferencia {
			
	CREAR_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.crearTransferencia")),
	MODIFICAR_TRANSFERENCIA	(SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.modificarTransferencia")),
	ANULAR_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.anularTransferencia")),
	RELACIONAR_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.relacionarTransferencia")),
	MODIFICAR_RELACION_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.modificarRelacionTransferencia")),
	ASIGNAR_RUTA_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.asignarRutaTransferencia")),
	MODIFICAR_RUTA_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.modificarRutaTransferencia")),
	RECIBIR_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.recibirTransferencia")),
	QUITAR_RUTA_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.quitarRutaTransferencia")),
	BUSCAR_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.buscarTransferencia")),
	CERRAR_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.cerrarTransferencia")),
	ELIMINAR_TRANSFERENCIA (SICRecipientesMessages.getInstancia().getString("ec.com.smx.sic.recipientes.transferencia.codigoValorAccion.eliminarTransferencia"));
			
	
	String accion;
	
	EnumAccionMaquinaEstadosTransferencia(String accion){
		this.accion = accion;
	}
	public String getAccion() {
		return accion;
	}
}
