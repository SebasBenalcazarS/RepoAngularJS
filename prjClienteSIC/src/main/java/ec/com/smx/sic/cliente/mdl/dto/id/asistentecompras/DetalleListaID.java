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
public class DetalleListaID implements Serializable {

	/**
	 * C�digo de la compania 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Cidigo detalle lista
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSACSDETLIS")
	@Column(name = "CODIGODETALLELISTA", nullable = false)
	private Long codigoDetalleLista;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoDetalleLista() {
		return codigoDetalleLista;
	}

	public void setCodigoDetalleLista(Long codigoDetalleLista) {
		this.codigoDetalleLista = codigoDetalleLista;
	}
	
}
