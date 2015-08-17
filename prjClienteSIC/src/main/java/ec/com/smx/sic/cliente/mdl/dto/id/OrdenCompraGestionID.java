package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@Embeddable
public class OrdenCompraGestionID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	@Column(name = "CODIGOORDENCOMPRAGESTION", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCPRESECORDCOMGES")
	private Long codigoOrdenCompraGestion;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoOrdenCompraGestion() {
		return codigoOrdenCompraGestion;
	}

	public void setCodigoOrdenCompraGestion(Long codigoOrdenCompraGestion) {
		this.codigoOrdenCompraGestion = codigoOrdenCompraGestion;
	}

}
