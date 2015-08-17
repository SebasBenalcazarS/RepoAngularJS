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
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class TransporteID implements Serializable{

	/**
	 * Código de la compania
	 * 
	 */
	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * Código del grupo alcance
	 */
	@Column(name = "CODIGOTRANSPORTE", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSTRA")
	private Integer codigoTransporte;
	
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
	 * @return the codigoTransporte
	 */
	public Integer getCodigoTransporte() {
		return codigoTransporte;
	}
	/**
	 * @param codigoTransporte the codigoTransporte to set
	 */
	public void setCodigoTransporte(Integer codigoTransporte) {
		this.codigoTransporte = codigoTransporte;
	}
}
