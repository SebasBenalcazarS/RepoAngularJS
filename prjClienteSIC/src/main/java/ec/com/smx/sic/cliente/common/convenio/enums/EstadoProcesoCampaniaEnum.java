package ec.com.smx.sic.cliente.common.convenio.enums;

import ec.com.smx.sic.cliente.resources.convenios.SICConvenioMessages;

public enum EstadoProcesoCampaniaEnum {

	PEN(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.pendiente")),
	CON(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.configurada")),
	COB(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.cobrada"));
	//SINCOB(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.proceso.campania.configurada"));
	
	private Integer codigoTipo;
	private String codigoValor;
	
	private EstadoProcesoCampaniaEnum(final String codigoValorCampo){
		this.codigoTipo = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.estado.proceso.promocion");; 
		this.codigoValor= codigoValorCampo;
	}
	
	public Integer getCodigoTipo() {
		return codigoTipo;
	}
	public String getCodigoValor() {
		return codigoValor;
	}

}
