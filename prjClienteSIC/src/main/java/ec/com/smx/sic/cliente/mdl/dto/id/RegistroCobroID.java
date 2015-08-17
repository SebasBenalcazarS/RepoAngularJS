package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author srodriguez
 * 2014-11-21
*/
@Embeddable
@SuppressWarnings("serial")
public class RegistroCobroID implements Serializable{
	
	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el codigo numerico del registro de cobro+
	 */
	@Column(name = "CODIGOREGISTROCOBRO", nullable = false)
	private Long codigoRegistroCobro;
	

	public static final String NOMBRE_SECUENCIA = "SCCEMSECREGCOB";


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RegistroCobroID [codigoCompania=" + codigoCompania + ", codigoRegistroCobro=" + codigoRegistroCobro + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoRegistroCobro == null) ? 0 : codigoRegistroCobro.hashCode());
		return result;
	}


	/* (non-Javadoc)
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
		RegistroCobroID other = (RegistroCobroID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoRegistroCobro == null) {
			if (other.codigoRegistroCobro != null)
				return false;
		} else if (!codigoRegistroCobro.equals(other.codigoRegistroCobro))
			return false;
		return true;
	}


	/* Metodo que retorna codigoCompania del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Integer codigoCompania 
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}


	/* Metodo que asigna el codigoCompania del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoCompania parametro de tipo Integer
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}


	/* Metodo que retorna codigoRegistroCobro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @return Long codigoRegistroCobro 
	 */
	public Long getCodigoRegistroCobro() {
		return codigoRegistroCobro;
	}


	/* Metodo que asigna el codigoRegistroCobro del objeto
	 * @author srodriguez
	 * 21/11/2014
	 * @param codigoRegistroCobro parametro de tipo Long
	 */
	public void setCodigoRegistroCobro(Long codigoRegistroCobro) {
		this.codigoRegistroCobro = codigoRegistroCobro;
	}

}
