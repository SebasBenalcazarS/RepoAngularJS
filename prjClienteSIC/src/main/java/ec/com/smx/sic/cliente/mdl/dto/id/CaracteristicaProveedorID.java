/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author Victor Jaramillo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class CaracteristicaProveedorID implements Serializable {

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOCARPRO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCPROSECCARPRO")
	private Long codigoCaracteristicaProveedor;

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
	 * @return the codigoCaracteristicaProveedor
	 */
	public Long getCodigoCaracteristicaProveedor() {
		return codigoCaracteristicaProveedor;
	}

	/**
	 * @param codigoCaracteristicaProveedor the codigoCaracteristicaProveedor to set
	 */
	public void setCodigoCaracteristicaProveedor(Long codigoCaracteristicaProveedor) {
		this.codigoCaracteristicaProveedor = codigoCaracteristicaProveedor;
	}
	
}
