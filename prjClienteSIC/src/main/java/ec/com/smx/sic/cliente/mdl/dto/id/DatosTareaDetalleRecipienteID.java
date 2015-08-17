/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class DatosTareaDetalleRecipienteID implements Serializable{
	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Especifica el codigo del pallet relacionado con el detalle del recipiente (secuencia de base)
	 */
	@Column(name="CODIGODATOSTAREADETALLEREC", nullable = false)
	private Long codigoDatosTareaDetalleRecipiente;
	
	public static final String NOMBRE_SECUENCIA = "SBLOGSECDATTARDETRCI";
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
	 * @return the codigoDatosTareaDetalleRecipiente
	 */
	public Long getCodigoDatosTareaDetalleRecipiente() {
		return codigoDatosTareaDetalleRecipiente;
	}

	/**
	 * @param codigoDatosTareaDetalleRecipiente the codigoDatosTareaDetalleRecipiente to set
	 */
	public void setCodigoDatosTareaDetalleRecipiente(Long codigoDatosTareaDetalleRecipiente) {
		this.codigoDatosTareaDetalleRecipiente = codigoDatosTareaDetalleRecipiente;
	}
	
	
}
