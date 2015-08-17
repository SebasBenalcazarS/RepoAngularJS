package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

/**
 * @author lmantilla
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloProveedorArancelRegID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIALARTPROARAREG")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECARTPROARAREG")
	private Long secuencialArtProvAraReg;

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
	 * @return the secuencialArtProvAraReg
	 */
	public Long getSecuencialArtProvAraReg() {
		return secuencialArtProvAraReg;
	}

	/**
	 * @param secuencialArtProvAraReg the secuencialArtProvAraReg to set
	 */
	public void setSecuencialArtProvAraReg(Long secuencialArtProvAraReg) {
		this.secuencialArtProvAraReg = secuencialArtProvAraReg;
	}
}
