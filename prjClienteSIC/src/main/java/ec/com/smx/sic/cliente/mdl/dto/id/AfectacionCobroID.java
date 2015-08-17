package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author srodriguez
 * 2014-09-10
*/
@Deprecated
@Embeddable
@SuppressWarnings("serial")
public class AfectacionCobroID implements Serializable {
	/**
	 * Código de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el código numérico de una afectacion cobro
	 */
	@Column(name = "CODIGOAFECTACION", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCCEMSECAFECOB", castTo = @Cast(sqlType = Types.NUMERIC, precision = 15, scale = 0))
	private Integer codigoAfectacion;

	

	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codigoAfectacion == null) ? 0 : codigoAfectacion.hashCode());
		result = prime * result
				+ ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
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
		AfectacionCobroID other = (AfectacionCobroID) obj;
		if (codigoAfectacion == null) {
			if (other.codigoAfectacion != null) {
				return false;
			}
		} else if (!codigoAfectacion.equals(other.codigoAfectacion)) {
			return false;
		}
		if (codigoCompania == null) {
			if (other.codigoCompania != null) {
				return false;
			}
		} else if (!codigoCompania.equals(other.codigoCompania)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AfectacionCobroID [codigoCompania=" + codigoCompania
				+ ", codigoAfectacion=" + codigoAfectacion + "]";
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
	 * @return the codigoAfectacion
	 */
	public Integer getCodigoAfectacion() {
		return codigoAfectacion;
	}

	/**
	 * @param codigoAfectacion the codigoAfectacion to set
	 */
	public void setCodigoAfectacion(Integer codigoAfectacion) {
		this.codigoAfectacion = codigoAfectacion;
	}
	
	
	
}
