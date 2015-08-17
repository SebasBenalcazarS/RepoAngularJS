package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
/**
 * 
 * @author cortiz
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class UbicacionPendienteIntegracionID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * 
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name =  "SBLOGSECUBIPENINT")
	@Column(name = "CODIGOUBIPENINT", nullable = false)
	private Long codigoUbiPenInt;
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
	 * @return the codigoUbiPenInt
	 */
	public Long getCodigoUbiPenInt() {
		return codigoUbiPenInt;
	}
	/**
	 * @param codigoUbiPenInt the codigoUbiPenInt to set
	 */
	public void setCodigoUbiPenInt(Long codigoUbiPenInt) {
		this.codigoUbiPenInt = codigoUbiPenInt;
	}
	
	
}
