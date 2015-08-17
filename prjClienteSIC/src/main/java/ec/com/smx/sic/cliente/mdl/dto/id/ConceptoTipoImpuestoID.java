package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author aquingaluisa
 * 2015-05-08
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ConceptoTipoImpuestoID implements Serializable{
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	@Column(name="CODIGOCONTIPIMP")
	private Long codigoConceptoTipoImpuesto;
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoConceptoTipoImpuesto() {
		return codigoConceptoTipoImpuesto;
	}
	public void setCodigoConceptoTipoImpuesto(Long codigoConceptoTipoImpuesto) {
		this.codigoConceptoTipoImpuesto = codigoConceptoTipoImpuesto;
	}
}
