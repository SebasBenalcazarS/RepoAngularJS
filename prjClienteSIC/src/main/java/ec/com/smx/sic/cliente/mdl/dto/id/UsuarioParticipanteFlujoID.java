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
 * @author jpucha
 *
 */

@SuppressWarnings("serial")
@Embeddable
public class UsuarioParticipanteFlujoID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	@Column(name = "CODIGOUSRPARFLU", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFDISECUSRPARFLU")
	private Integer codigoUsuarioParticipanteFlujo;

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
	 * @return the codigoUsuarioParticipanteFlujo
	 */
	public Integer getCodigoUsuarioParticipanteFlujo() {
		return codigoUsuarioParticipanteFlujo;
	}

	/**
	 * @param codigoUsuarioParticipanteFlujo the codigoUsuarioParticipanteFlujo to set
	 */
	public void setCodigoUsuarioParticipanteFlujo(Integer codigoUsuarioParticipanteFlujo) {
		this.codigoUsuarioParticipanteFlujo = codigoUsuarioParticipanteFlujo;
	}

}
