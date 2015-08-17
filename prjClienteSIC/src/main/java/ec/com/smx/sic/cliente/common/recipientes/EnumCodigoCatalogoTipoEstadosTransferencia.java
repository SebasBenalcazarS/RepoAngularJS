package ec.com.smx.sic.cliente.common.recipientes;

import ec.com.smx.sic.cliente.resources.recipientes.SICRecipientesMessages;


public enum EnumCodigoCatalogoTipoEstadosTransferencia {
	//CODIGOS CATALOGO TIPO 
	CODIGO_CATALOGO_TIPO (SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.estados.codigoCatalogoTipo")),
	CODIGO_CATALOGO_TRANSACCIONES_TIPO(SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.transferencia.tipos.codigoCatalogoTipo")),
	CODIGO_CATALOGO_TIPO_CONTROLCOSTO_RECIPIENTE(SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.transferencia.tipos.controlCostoRecipiente")),
	CODIGO_CATALOGO_TIPO_AJUSTES(SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.canjeRecipientes.codigoCatalogoTipo")),
	CODIGO_CATALOGO_ESTADOS_ENTREGA_RECIPIENTES(SICRecipientesMessages.getInstancia().getInteger("ec.com.smx.sic.recipientes.entregaRecipientes.codigoCatalogoTipo"));
	Integer codigoCatalogoTipo;
	EnumCodigoCatalogoTipoEstadosTransferencia(Integer codigoCatalogoTipo){
		this.codigoCatalogoTipo = codigoCatalogoTipo;
	}
	public Integer getCodigoCatalogoTipo() {
		return codigoCatalogoTipo;
	}
	
}
