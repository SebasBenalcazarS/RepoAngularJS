
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase FurgonAreaTrabajoDTO
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.FurgonAreaTrabajoDTO
 * 
 * @author egudino
 */
@SuppressWarnings("serial")
@Embeddable
public class ChoferID implements Serializable {

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
	@Column(name = "CODIGOCHOFER", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECCHOFERSEC")
	private Long codigoChofer;

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
	 * @return the codigoChofer
	 */
	public Long getCodigoChofer() {
		return codigoChofer;
	}

	/**
	 * @param codigoChofer the codigoChofer to set
	 */
	public void setCodigoChofer(Long codigoChofer) {
		this.codigoChofer = codigoChofer;
	}

			
}

