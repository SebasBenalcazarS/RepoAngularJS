
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase VehiculoFurgonDTO
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.VehiculoFurgonDTO
 * 
 * @author egudino
 */
@SuppressWarnings("serial")
@Embeddable
public class VehiculoChoferID implements Serializable {

	/**
	 * C�digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
		
	/**
	 * Especifica el codigo secuencia para la tabla
	 *
	 */
	@Column(name = "SECUENCIALVEHCHOF", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECVEHICULOCHOFERSEC")
	private Long secuencialVehiculoChofer;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania(){
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 ){
		this.codigoCompania=codigoCompania1;
		
	}

	/**
	 * @return the secuencialVehiculoChofer
	 */
	public Long getSecuencialVehiculoChofer() {
		return secuencialVehiculoChofer;
	}

	/**
	 * @param secuencialVehiculoChofer the secuencialVehiculoChofer to set
	 */
	public void setSecuencialVehiculoChofer(Long secuencialVehiculoChofer) {
		this.secuencialVehiculoChofer = secuencialVehiculoChofer;
	}

		
}

