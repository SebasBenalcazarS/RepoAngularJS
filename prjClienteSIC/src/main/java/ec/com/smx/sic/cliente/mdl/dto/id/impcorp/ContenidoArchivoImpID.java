package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class ContenidoArchivoImpID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIALARCHIVO")
	//@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMTCONARC")
	private Long secuencialArchivo;
	
	
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
	 * @return the secuencialArchivo
	 */
	public Long getSecuencialArchivo() {
		return secuencialArchivo;
	}

	/**
	 * @param secuencialArchivo the secuencialArchivo to set
	 */
	public void setSecuencialArchivo(Long secuencialArchivo) {
		this.secuencialArchivo = secuencialArchivo;
	}

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
				+ ((secuencialArchivo == null) ? 0 : secuencialArchivo
						.hashCode());
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
		ContenidoArchivoImpID other = (ContenidoArchivoImpID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (secuencialArchivo == null) {
			if (other.secuencialArchivo != null)
				return false;
		} else if (!secuencialArchivo.equals(other.secuencialArchivo))
			return false;
		return true;
	}
	
	
}
