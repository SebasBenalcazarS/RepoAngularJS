package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author amunoz
 * @author cherrera
 * 
 */

@SuppressWarnings("serial")
@Embeddable
public class ContenedorID implements Serializable{
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla Contenedor
	 * 
	 */
	@Column(name = "CODIGOCONTENEDOR", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECCONTENEDOR")
    private Long codigoContenedor;
	
	/**
	 * @return the codigoContenedor
	 */
	public Long getCodigoContenedor() {
		return codigoContenedor;
	}

	/**
	 * @param codigoContenedor the codigoContenedor to set
	 */
	public void setCodigoContenedor(Long codigoContenedor) {
		this.codigoContenedor = codigoContenedor;
	}

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
	
}
