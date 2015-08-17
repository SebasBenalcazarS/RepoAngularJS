package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaEntidadID;

@SuppressWarnings("serial")
@Entity
@Table(name="SSPCOVENTIDAD")
public class VistaEntidadDTO implements Serializable{
	@EmbeddedId
	private VistaEntidadID id;
	
	private String tipoDocumento;
	
	private String numeroDocumento;
	
	private String razonSocial;
	
	private String nombreComercial;
	
	private String codigoJDE;

	public VistaEntidadID getId() {
		return id;
	}

	public void setId(VistaEntidadID id) {
		this.id = id;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getCodigoJDE() {
		return codigoJDE;
	}

	public void setCodigoJDE(String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}
	
	
}
