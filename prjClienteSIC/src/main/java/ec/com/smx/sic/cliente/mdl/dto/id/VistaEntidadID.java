package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class VistaEntidadID implements Serializable{
	private String tipoEntidad;
	private Long codigoEntidad;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEntidad == null) ? 0 : codigoEntidad.hashCode());
		result = prime * result + ((tipoEntidad == null) ? 0 : tipoEntidad.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VistaEntidadID other = (VistaEntidadID) obj;
		if (codigoEntidad == null) {
			if (other.codigoEntidad != null)
				return false;
		} else if (!codigoEntidad.equals(other.codigoEntidad))
			return false;
		if (tipoEntidad == null) {
			if (other.tipoEntidad != null)
				return false;
		} else if (!tipoEntidad.equals(other.tipoEntidad))
			return false;
		return true;
	}
	
	public String getTipoEntidad() {
		return tipoEntidad;
	}
	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}
	public Long getCodigoEntidad() {
		return codigoEntidad;
	}
	public void setCodigoEntidad(Long codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}
	
}
