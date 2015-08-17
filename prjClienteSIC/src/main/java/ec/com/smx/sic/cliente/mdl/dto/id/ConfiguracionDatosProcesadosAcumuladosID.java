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
public class ConfiguracionDatosProcesadosAcumuladosID implements Serializable{
	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el codigo numerico la configuracion de los procesos de datos
	 */
	@Column(name = "CODIGOCONFIGURACIONDATOPROCESADOACUMULADO", nullable = false)
	private Long codigoConfiguracionDatoProcesadoAcumulado;

	public static final String NOMBRE_SECUENCIA = "SCCEMSECCONDATPROACU";

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ConfiguracionDatosProcesadosAcumuladosID [codigoCompania=" + codigoCompania + ", codigoSecuencial=" + codigoConfiguracionDatoProcesadoAcumulado + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoConfiguracionDatoProcesadoAcumulado == null) ? 0 : codigoConfiguracionDatoProcesadoAcumulado.hashCode());
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
		ConfiguracionDatosProcesadosAcumuladosID other = (ConfiguracionDatosProcesadosAcumuladosID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoConfiguracionDatoProcesadoAcumulado == null) {
			if (other.codigoConfiguracionDatoProcesadoAcumulado != null)
				return false;
		} else if (!codigoConfiguracionDatoProcesadoAcumulado.equals(other.codigoConfiguracionDatoProcesadoAcumulado))
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

	public Long getCodigoConfiguracionDatoProcesadoAcumulado() {
		return codigoConfiguracionDatoProcesadoAcumulado;
	}

	public void setCodigoConfiguracionDatoProcesadoAcumulado(Long codigoConfiguracionDatoProcesadoAcumulado) {
		this.codigoConfiguracionDatoProcesadoAcumulado = codigoConfiguracionDatoProcesadoAcumulado;
	}

	

}
