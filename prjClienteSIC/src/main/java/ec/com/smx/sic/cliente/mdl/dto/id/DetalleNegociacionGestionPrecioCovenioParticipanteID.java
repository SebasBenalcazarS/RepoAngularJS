/** ec.com.smx.sic.cliente.mdl.dto.id
 * DetalleNegociacionGestionPrecioCovenioParticipanteID.java
 * @author srodriguez
 * 23/3/2015
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author srodriguez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class DetalleNegociacionGestionPrecioCovenioParticipanteID implements Serializable{
	

	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	
	@Column(name="CODIGODETNEGGESPRECONPAR")
	private Long codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	
	public static final String NOMBRE_SECUENCIA = "SCCEMSECDETNEGGESPRECONPAR";

	/* Metodo de implementacion de hashCode de DetalleNegociacionGestionPrecioCovenioParticipanteID.java
	 * @author srodriguez
	 * 23/3/2015
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		return result;
	}

	/* Metodo de implementacion de equals de DetalleNegociacionGestionPrecioCovenioParticipanteID.java
	 * @author srodriguez
	 * 23/3/2015
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
		DetalleNegociacionGestionPrecioCovenioParticipanteID other = (DetalleNegociacionGestionPrecioCovenioParticipanteID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		return true;
	}

	/* Metodo de implementacion de toString de DetalleNegociacionGestionPrecioCovenioParticipanteID.java
	 * @author srodriguez
	 * 23/3/2015
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DetalleNegociacionGestionPrecioCovenioParticipanteID [codigoCompania=" + codigoCompania + "]";
	}

	/** Metodo que retorna codigoCompania del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @return Integer codigoCompania 
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/** Metodo que asigna el valor codigoCompania en codigoCompania del objeto
	 * @author srodriguez
	 * 23/3/2015
	 * @param codigoCompania
	 */
	
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoDetalleNegociacionGestionPrecioConvenioParticipante() {
		return codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}

	public void setCodigoDetalleNegociacionGestionPrecioConvenioParticipante(Long codigoDetalleNegociacionGestionPrecioConvenioParticipante) {
		this.codigoDetalleNegociacionGestionPrecioConvenioParticipante = codigoDetalleNegociacionGestionPrecioConvenioParticipante;
	}
	
	
}
