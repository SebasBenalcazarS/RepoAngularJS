package ec.com.smx.sic.cliente.common.recipientes;

import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;


public enum EnumCodigoInternoTipoTransaccionRecipeintes {
	//CODIGOS DE TRANSACCION
	TIPO_TRANSACCION_SSA (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoInterno.superSaldos")),
	TIPO_TRANSACCION_LIQ (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoInterno.liquidaciones")),
	TIPO_TRANSACCION_DPR (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoInterno.devolucionProveedores")),
	TIPO_TRANSACCION_DJA (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoInterno.devolucionJabas")),
	TIPO_TRANSACCION_RME (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoInterno.reservaMercanciaTiendas")),
	TIPO_TRANSACCION_TTT (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoInterno.testTipoTransaccion1")),
	TIPO_TRANSACCION_MEE (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.codigoInterno.movimiento.envases.egreso"))
	;
	
	Integer codigoInterno;
	EnumCodigoInternoTipoTransaccionRecipeintes(Integer codigoInterno){
		this.codigoInterno = codigoInterno;
	}
	public Integer getCodigoInterno() {
		return codigoInterno;
	}
	
}
