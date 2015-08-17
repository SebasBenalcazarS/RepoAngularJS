package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
@Embeddable
@SuppressWarnings("serial")
public class VistaFacturaRelacionadaID extends BaseID{
		
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOFACTURA")
	private Long codigoFactura;
	
	@Column(name = "CODIGOFACTURARELACIONADA")
	private Long codigoFacturaRelacionada;

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

	public Long getCodigoFacturaRelacionada() {
		return codigoFacturaRelacionada;
	}

	public void setCodigoFacturaRelacionada(Long codigoFacturaRelacionada) {
		this.codigoFacturaRelacionada = codigoFacturaRelacionada;
	}
}
