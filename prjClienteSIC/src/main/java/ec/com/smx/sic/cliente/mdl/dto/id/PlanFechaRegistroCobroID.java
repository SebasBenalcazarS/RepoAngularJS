/** ec.com.smx.sic.cliente.mdl.dto.id
 * PlanFechaRegistroCobroID.java
 * @author srodriguez
 * 20/3/2015
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author srodriguez
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class PlanFechaRegistroCobroID implements Serializable{

	public static final String NOMBRE_SECUENCIA = "SCCEMSECPLAFECREGCOB";
	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el codigo numerico del registro de cobro+
	 */
	@Column(name = "CODIGOPLANFECHAREGISTROCOBRO", nullable = false)
	private Long codigoPlanFechaRegistroCobro;

	/* Metodo de implementacion de hashCode de PlanFechaRegistroCobroID.java
	 * @author srodriguez
	 * 20/3/2015
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoPlanFechaRegistroCobro == null) ? 0 : codigoPlanFechaRegistroCobro.hashCode());
		return result;
	}

	/* Metodo de implementacion de equals de PlanFechaRegistroCobroID.java
	 * @author srodriguez
	 * 20/3/2015
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanFechaRegistroCobroID other = (PlanFechaRegistroCobroID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoPlanFechaRegistroCobro == null) {
			if (other.codigoPlanFechaRegistroCobro != null)
				return false;
		} else if (!codigoPlanFechaRegistroCobro.equals(other.codigoPlanFechaRegistroCobro))
			return false;
		return true;
	}

	/* Metodo de implementacion de toString de PlanFechaRegistroCobroID.java
	 * @author srodriguez
	 * 20/3/2015
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlanFechaRegistroCobroID [codigoCompania=" + codigoCompania + ", codigoPlanFechaRegistroCobro=" + codigoPlanFechaRegistroCobro + "]";
	}

	/** Metodo que retorna codigoCompania del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return Integer codigoCompania 
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/** Metodo que asigna el valor codigoCompania en codigoCompania del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param codigoCompania
	 */
	
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/** Metodo que retorna codigoPlanFechaRegistroCobro del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @return Long codigoPlanFechaRegistroCobro 
	 */
	public Long getCodigoPlanFechaRegistroCobro() {
		return codigoPlanFechaRegistroCobro;
	}

	/** Metodo que asigna el valor codigoPlanFechaRegistroCobro en codigoPlanFechaRegistroCobro del objeto
	 * @author srodriguez
	 * 20/3/2015
	 * @param codigoPlanFechaRegistroCobro
	 */
	
	public void setCodigoPlanFechaRegistroCobro(Long codigoPlanFechaRegistroCobro) {
		this.codigoPlanFechaRegistroCobro = codigoPlanFechaRegistroCobro;
	}
	
	
	
	
}
