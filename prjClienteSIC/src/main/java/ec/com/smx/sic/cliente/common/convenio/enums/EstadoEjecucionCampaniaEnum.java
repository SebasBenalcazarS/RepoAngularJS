package ec.com.smx.sic.cliente.common.convenio.enums;

import ec.com.smx.sic.cliente.resources.convenios.SICConvenioMessages;

public enum EstadoEjecucionCampaniaEnum {

	PEN(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.ejecucion.campania.pendiente")),
	PRO(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.mercadeo.valor.estado.ejecucion.campania.proceso"));
	
	private Integer codigoTipo;
	private String codigoValor;
	
	private EstadoEjecucionCampaniaEnum(final String codigoValor){
		this.codigoTipo = SICConvenioMessages.getInstancia().getInteger("smx.cobro.proveedores.catalogo.tipo.estado.ejecucion.promocion");; 
		this.codigoValor = codigoValor;
	}
	
	public Integer getCodigoTipo() {
		return codigoTipo;
	}
	public String getCodigoValor() {
		return codigoValor;
	}
}
