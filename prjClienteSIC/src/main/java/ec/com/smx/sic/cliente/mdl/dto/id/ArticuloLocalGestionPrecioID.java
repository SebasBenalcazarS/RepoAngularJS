package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author guvidia
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloLocalGestionPrecioID implements Serializable {

	/**
	 * Codigo de la compan&iacute;a
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencia &uacute;nica del registro
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCARTSECARTPREDIF")
	@Column(name = "SECUENCIALARTLOCGESPRE", nullable = false)
	private Long secuencialArtLocGesPre;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	public Long getSecuencialArtLocGesPre() {
		return secuencialArtLocGesPre;
	}

	public void setSecuencialArtLocGesPre(Long secuencialArtLocGesPre) {
		this.secuencialArtLocGesPre = secuencialArtLocGesPre;
	}


}
