package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * @author srodriguez
 * 2014-11-20
*/
@Embeddable
@SuppressWarnings("serial")
public class ConfiguracionDatosProcesadosID implements Serializable{

	
	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el codigo numerico la configuracion de los procesos de datos
	 */
	@Column(name = "CODIGOCONFIGURACION", nullable = false)
	private Long codigoConfiguracion;

	public static final String NOMBRE_SECUENCIA = "SCCEMSECCONDATPRO";

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConfiguracionDatosProcesadosID [codigoCompania=" + codigoCompania + ", codigoConfiguracion=" + codigoConfiguracion + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoConfiguracion == null) ? 0 : codigoConfiguracion.hashCode());
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
		ConfiguracionDatosProcesadosID other = (ConfiguracionDatosProcesadosID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoConfiguracion == null) {
			if (other.codigoConfiguracion != null)
				return false;
		} else if (!codigoConfiguracion.equals(other.codigoConfiguracion))
			return false;
		return true;
	}

	/* Metodo que retorna codigoCompania del objeto
	 * @author srodriguez
	 * 20/11/2014
	 * @return Integer codigoCompania 
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/* Metodo que asigna el codigoCompania del objeto
	 * @author srodriguez
	 * 20/11/2014
	 * @param codigoCompania parametro de tipo Integer
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/* Metodo que retorna codigoConfiguracion del objeto
	 * @author srodriguez
	 * 20/11/2014
	 * @return Long codigoConfiguracion 
	 */
	public Long getCodigoConfiguracion() {
		return codigoConfiguracion;
	}

	/* Metodo que asigna el codigoConfiguracion del objeto
	 * @author srodriguez
	 * 20/11/2014
	 * @param codigoConfiguracion parametro de tipo Long
	 */
	public void setCodigoConfiguracion(Long codigoConfiguracion) {
		this.codigoConfiguracion = codigoConfiguracion;
	}

}
