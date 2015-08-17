package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author srodriguez
 * 2014-09-10
*/
@Embeddable
@SuppressWarnings("serial")
public class ConvenioParticipanteID implements Serializable {
	
	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el c�digo num�rico de una participacion
	 */
	@Column(name = "CODIGOPARTICIPACION", nullable = false)
	private Long codigoParticipacion;

	public static final String NOMBRE_SECUENCIA = "SCCEMSECCONPAR";
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime
				* result
				+ ((codigoParticipacion == null) ? 0 : codigoParticipacion
						.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ConvenioParticipanteID other = (ConvenioParticipanteID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null) {
				return false;
			}
		} else if (!codigoCompania.equals(other.codigoCompania)) {
			return false;
		}
		if (codigoParticipacion == null) {
			if (other.codigoParticipacion != null) {
				return false;
			}
		} else if (!codigoParticipacion.equals(other.codigoParticipacion)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConvenioParticipanteID [codigoCompania=" + codigoCompania
				+ ", codigoParticipacion=" + codigoParticipacion + "]";
	}

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoParticipacion
	 */
	public Long getCodigoParticipacion() {
		return codigoParticipacion;
	}

	/**
	 * @param codigoParticipacion the codigoParticipacion to set
	 */
	public void setCodigoParticipacion(Long codigoParticipacion) {
		this.codigoParticipacion = codigoParticipacion;
	}

}
