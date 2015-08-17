package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
public class LineaComercialFuncionarioTipoMarcaID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

	@Column(name = "CODLINCOMFUNTIPMAR", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECLINCOMFUNTIPMAR")
	private Long codigoLineaComercialFuncionarioTipoMargen;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoLineaComercialFuncionarioTipoMargen
	 */
	public Long getCodigoLineaComercialFuncionarioTipoMargen() {
		return codigoLineaComercialFuncionarioTipoMargen;
	}

	/**
	 * @param codigoLineaComercialFuncionarioTipoMargen the codigoLineaComercialFuncionarioTipoMargen to set
	 */
	public void setCodigoLineaComercialFuncionarioTipoMargen(Long codigoLineaComercialFuncionarioTipoMargen) {
		this.codigoLineaComercialFuncionarioTipoMargen = codigoLineaComercialFuncionarioTipoMargen;
	}
}
