package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@SuppressWarnings("serial")
public class VistaUltimasFechasCobradasDTO implements Serializable{
	@Id
	private Long codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	private Date fechaCobro;
	
	public Long getCodigoDetalleNegociacionGestionPrecioConvenioParticipante() {
		return codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}
	public void setCodigoDetalleNegociacionGestionPrecioConvenioParticipante(Long codigoDetalleNegociacionGestionPrecioConvenioParticipante) {
		this.codigoDetalleNegociacionGestionPrecioConvenioParticipante = codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}
	public Date getFechaCobro() {
		return fechaCobro;
	}
	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}
}
