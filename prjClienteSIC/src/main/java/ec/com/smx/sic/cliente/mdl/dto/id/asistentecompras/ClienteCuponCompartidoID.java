package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;


@Embeddable
@SuppressWarnings("serial")
public class ClienteCuponCompartidoID extends BaseID{


	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSACSCLICUPCOM")
	@Column(name = "CODIGOCLICUPCOM", nullable = false)
	private Long codigoClienteCupomComp;


	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * @return the codigoClienteCupomComp
	 */
	public Long getCodigoClienteCupomComp() {
		return codigoClienteCupomComp;
	}

	/**
	 * @param codigoClienteCupomComp the codigoClienteCupomComp to set
	 */
	public void setCodigoClienteCupomComp(Long codigoClienteCupomComp) {
		this.codigoClienteCupomComp = codigoClienteCupomComp;
	}

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
}
