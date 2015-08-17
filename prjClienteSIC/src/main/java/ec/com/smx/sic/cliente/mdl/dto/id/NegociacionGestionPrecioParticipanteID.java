package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class NegociacionGestionPrecioParticipanteID implements Serializable {
	
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name="CODIGONEGOCIACIONGESTIONPRECIOCONVENIOPARTICIPANTE")
	private Long codigoNegociacionGestionPrecioConvenioParticipante;
	
	public static final String NOMBRE_SECUENCIA = "SCCEMSECNEGGESPRECONPAR";

	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoNegociacionGestionPrecioConvenioParticipante() {
		return codigoNegociacionGestionPrecioConvenioParticipante;
	}
	public void setCodigoNegociacionGestionPrecioConvenioParticipante(Long codigoNegociacionGestionPrecioConvenioParticipante) {
		this.codigoNegociacionGestionPrecioConvenioParticipante = codigoNegociacionGestionPrecioConvenioParticipante;
	}
	
	
	
}
