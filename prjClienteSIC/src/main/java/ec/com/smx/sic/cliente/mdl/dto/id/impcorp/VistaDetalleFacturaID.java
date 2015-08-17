package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * 
 * @author rhidalgo
 *
 */

@SuppressWarnings("serial")
@Embeddable
public class VistaDetalleFacturaID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOFACTURA")	
	private Long codigoFactura;
	
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;

	@Column(name = "CODIGOEMBARQUEESTADO")
	private Long codigoEmbarqueEstado;
	
	@Column(name = "CODIGOFACTURAESTADO")	
	private Long codigoFacturaEstado;
	
	@Column(name = "CODIGOFACTURADETALLEEST")	
	private Long codigoFacturaDetalleEstado;
	
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
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

	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	public Long getCodigoFacturaDetalleEstado() {
		return codigoFacturaDetalleEstado;
	}

	public void setCodigoFacturaDetalleEstado(Long codigoFacturaDetalleEstado) {
		this.codigoFacturaDetalleEstado = codigoFacturaDetalleEstado;
	}






	



	
	
	
	
}
