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
public class DefinicionConfiguracionID implements Serializable{
	
	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el codigo numerico la configuracion de los procesos de datos
	 */
	@Column(name = "CODIGODEFINICIONCONFIGURACION", nullable = false)
	private Long codigoDefinicionConfiguracion;

	public static final String NOMBRE_SECUENCIA = "SCCEMSECDEFCON";

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoDefinicionConfiguracion == null) ? 0 : codigoDefinicionConfiguracion.hashCode());
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
		DefinicionConfiguracionID other = (DefinicionConfiguracionID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoDefinicionConfiguracion == null) {
			if (other.codigoDefinicionConfiguracion != null)
				return false;
		} else if (!codigoDefinicionConfiguracion.equals(other.codigoDefinicionConfiguracion))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefinicionConfiguracionID [codigoCompania=" + codigoCompania + ", codigoSecuencial=" + codigoDefinicionConfiguracion + "]";
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

	public Long getCodigoDefinicionConfiguracion() {
		return codigoDefinicionConfiguracion;
	}

	public void setCodigoDefinicionConfiguracion(Long codigoDefinicionConfiguracion) {
		this.codigoDefinicionConfiguracion = codigoDefinicionConfiguracion;
	}

	

}
