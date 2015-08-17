/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author dvillafuerte
 *
 */
@SuppressWarnings("serial")
public class DetalleListaRecetaID implements Serializable {
	
	/**
	 * Codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSACSDETLISREC")
	@Column(name = "CODIGODETALLELISTARECETA")
	private Long codigoDetalleListaReceta;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoDetalleListaReceta() {
		return codigoDetalleListaReceta;
	}

	public void setCodigoDetalleListaReceta(Long codigoDetalleListaReceta) {
		this.codigoDetalleListaReceta = codigoDetalleListaReceta;
	}
}
