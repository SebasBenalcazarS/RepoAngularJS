package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

@SuppressWarnings("serial")
@Embeddable
public class FacturaGastoEmbarqueEstadoImpID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOFACTURAGASTO")
	private Long codigoFacturaGasto;
		
	@Column(name = "CODIGOFACTURAGASTOESTADO")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECFACGASEST")
	private Long codigoFacturaGastoEstado;

	/**
	 * @return devuelve el valor de la propiedad codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania establece el valor a la propiedad codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
	/**
	 * @return the codigoFacturaGasto
	 */
	public Long getCodigoFacturaGasto() {
		return codigoFacturaGasto;
	}

	/**
	 * @param codigoFacturaGasto the codigoFacturaGasto to set
	 */
	public void setCodigoFacturaGasto(Long codigoFacturaGasto) {
		this.codigoFacturaGasto = codigoFacturaGasto;
	}

	/**
	 * @return the codigoFacturaGastoEstado
	 */
	public Long getCodigoFacturaGastoEstado() {
		return codigoFacturaGastoEstado;
	}

	/**
	 * @param codigoFacturaGastoEstado the codigoFacturaGastoEstado to set
	 */
	public void setCodigoFacturaGastoEstado(Long codigoFacturaGastoEstado) {
		this.codigoFacturaGastoEstado = codigoFacturaGastoEstado;
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
				+ ((codigoFacturaGasto == null) ? 0 : codigoFacturaGasto
						.hashCode());
		result = prime
				* result
				+ ((codigoFacturaGastoEstado == null) ? 0
						: codigoFacturaGastoEstado.hashCode());
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
		FacturaGastoEmbarqueEstadoImpID other = (FacturaGastoEmbarqueEstadoImpID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoFacturaGasto == null) {
			if (other.codigoFacturaGasto != null)
				return false;
		} else if (!codigoFacturaGasto.equals(other.codigoFacturaGasto))
			return false;
		if (codigoFacturaGastoEstado == null) {
			if (other.codigoFacturaGastoEstado != null)
				return false;
		} else if (!codigoFacturaGastoEstado
				.equals(other.codigoFacturaGastoEstado))
			return false;
		return true;
	}
	
	
}