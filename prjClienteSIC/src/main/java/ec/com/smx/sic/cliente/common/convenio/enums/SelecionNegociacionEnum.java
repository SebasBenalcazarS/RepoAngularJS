package ec.com.smx.sic.cliente.common.convenio.enums;

import ec.com.smx.sic.cliente.resources.convenios.SICConvenioMessages;

/**
 * Identifica si la seleccio para la negociacion  
 * @author aquingaluisa
 *
 */
public enum SelecionNegociacionEnum {
	
	CAMPANIA(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.catalogo.campania")),
	PROMOCION(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.catalogo.promocion")), 
	PARTICIPANTE(SICConvenioMessages.getInstancia().getString("smx.cobro.proveedores.comercial.catalogo.participante"));
	
	private String selecionNegociacionOrdinal;
	
	/**
	 * @author aquingaluisa
	 * @param codigoUnico
	 */
	private SelecionNegociacionEnum(String codigoUnico) {
		selecionNegociacionOrdinal = codigoUnico;
	}


	/**
	 * @author aquingaluisa
	 * @return String
	 */
	public String getSelecionNegociacionOrdinal() {
		return selecionNegociacionOrdinal;
	}


	/**
	 * @author aquingaluisa
	 * @param selecionNegociacionOrdinal
	 */
	public void setSelecionNegociacionOrdinal(String selecionNegociacionOrdinal) {
		this.selecionNegociacionOrdinal = selecionNegociacionOrdinal;
	}
	
}