package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * 
 * @author dcruz
 *
 */

@SuppressWarnings("serial")
@Embeddable
public class VistaReporteEmbarqueID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOEMBARQUE")	
	private Long codigoEmbarque;
	
	@Column(name = "CODIGOEMBARQUEESTADO")	
	private Long codigoEmbarqueEstado;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	public Long getCodigoEmbarqueEstado() {
		return codigoEmbarqueEstado;
	}

	public void setCodigoEmbarqueEstado(Long codigoEmbarqueEstado) {
		this.codigoEmbarqueEstado = codigoEmbarqueEstado;
	}


	
	
	
	
}
