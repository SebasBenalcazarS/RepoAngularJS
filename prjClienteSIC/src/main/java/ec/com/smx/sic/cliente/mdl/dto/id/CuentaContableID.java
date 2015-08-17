package ec.com.smx.sic.cliente.mdl.dto.id;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Types;

/**
 * @author srodriguez
 * 2014-09-10
*/

@Embeddable
@SuppressWarnings("serial")
public class CuentaContableID implements Serializable{
	
	/**
	 * C&oacute;digo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el c&oacute;digo num&eacute;rico de una participacion
	 */
	@Column(name = "CODIGOCUENTACONTABLE", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SFCORSECCUECON", castTo = @Cast(sqlType = Types.NUMERIC, precision = 15, scale = 0))
	private Integer codigoCuentaContable;

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
				+ ((codigoCuentaContable == null) ? 0 : codigoCuentaContable
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
		CuentaContableID other = (CuentaContableID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null) {
				return false;
			}
		} else if (!codigoCompania.equals(other.codigoCompania)) {
			return false;
		}
		if (codigoCuentaContable == null) {
			if (other.codigoCuentaContable != null) {
				return false;
			}
		} else if (!codigoCuentaContable.equals(other.codigoCuentaContable)) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CuentaContableID [codigoCompania=" + codigoCompania
				+ ", codigoCuentaContable=" + codigoCuentaContable + "]";
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
	 * @return the codigoCuentaContable
	 */
	public Integer getCodigoCuentaContable() {
		return codigoCuentaContable;
	}

	/**
	 * @param codigoCuentaContable the codigoCuentaContable to set
	 */
	public void setCodigoCuentaContable(Integer codigoCuentaContable) {
		this.codigoCuentaContable = codigoCuentaContable;
	}
}
