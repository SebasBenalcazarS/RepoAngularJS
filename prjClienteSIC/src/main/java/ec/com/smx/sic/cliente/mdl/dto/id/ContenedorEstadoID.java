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
 */

@SuppressWarnings("serial")
@Embeddable
public class ContenedorEstadoID implements Serializable{
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla Contenedor Estado
	 * 
	 */
	@Column(name = "CODIGOCONTENEDORESTADO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECCONEST")
    private Long codigoContenedorEstado;

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
	 * @return the codigoContenedorEstado
	 */
	public Long getCodigoContenedorEstado() {
		return codigoContenedorEstado;
	}

	/**
	 * @param codigoContenedorEstado the codigoContenedorEstado to set
	 */
	public void setCodigoContenedorEstado(Long codigoContenedorEstado) {
		this.codigoContenedorEstado = codigoContenedorEstado;
	}

}
