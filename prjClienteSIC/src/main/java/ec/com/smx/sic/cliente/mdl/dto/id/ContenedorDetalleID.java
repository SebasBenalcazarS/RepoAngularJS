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
public class ContenedorDetalleID implements Serializable{
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla Contenedor Detalle
	 * 
	 */
	@Column(name = "CODIGOCONTENEDORDETALLE", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECCONDET")
    private Long codigoContenedorDetalle;

	/**
	 * @return the codigoContenedorDetalle
	 */
	public Long getCodigoContenedorDetalle() {
		return codigoContenedorDetalle;
	}

	/**
	 * @param codigoContenedorDetalle the codigoContenedorDetalle to set
	 */
	public void setCodigoContenedorDetalle(Long codigoContenedorDetalle) {
		this.codigoContenedorDetalle = codigoContenedorDetalle;
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
