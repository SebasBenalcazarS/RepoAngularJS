package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class AjusteFacturaID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania; 
	
	@Column(name = "CODIGOFACTURAESTADO", nullable = false)
	private Long codigoFacturaEstado ;
	
	@Column(name = "CODIGOAJUSTEFACTURAESTADO", nullable = false)
	private Long codigoAjusteFacturaEstado;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	public Long getCodigoAjusteFacturaEstado() {
		return codigoAjusteFacturaEstado;
	}

	public void setCodigoAjusteFacturaEstado(Long codigoAjusteFacturaEstado) {
		this.codigoAjusteFacturaEstado = codigoAjusteFacturaEstado;
	}
}
