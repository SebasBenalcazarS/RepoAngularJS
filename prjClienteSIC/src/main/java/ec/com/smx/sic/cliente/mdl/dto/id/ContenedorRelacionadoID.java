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
public class ContenedorRelacionadoID implements Serializable {
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla Contenedor Padre
	 * 
	 */
	@Column(name = "CODIGOCONTENEDORPADRE", nullable = false)
    private Long codigoContenedorPadre;
	
	/**
	 * Secuencial de la tabla Contenedor Relacionado
	 * 
	 */
	@Column(name = "CODIGOCONTENEDORRELACIONADO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECCONREL")
    private Long codigoContenedorRelacionado;
	
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
	 * @return the codigoContenedorPadre
	 */
	public Long getCodigoContenedorPadre() {
		return codigoContenedorPadre;
	}

	/**
	 * @param codigoContenedorPadre the codigoContenedorPadre to set
	 */
	public void setCodigoContenedorPadre(Long codigoContenedorPadre) {
		this.codigoContenedorPadre = codigoContenedorPadre;
	}

	/**
	 * @return the codigoContenedorRelacionado
	 */
	public Long getCodigoContenedorRelacionado() {
		return codigoContenedorRelacionado;
	}

	/**
	 * @param codigoContenedorRelacionado the codigoContenedorRelacionado to set
	 */
	public void setCodigoContenedorRelacionado(Long codigoContenedorRelacionado) {
		this.codigoContenedorRelacionado = codigoContenedorRelacionado;
	}

}
