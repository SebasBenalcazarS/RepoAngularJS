package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;


/**
 * @author Luis Yacchirema
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class BitacoraPrecioID implements Serializable {

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;

	@Column(name = "CODIGOBITACORAPRECIO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCPRESECBITPRE")
	private Long codigoBitacoraPrecio;

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
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the codigoBitacoraPrecio
	 */
	public Long getCodigoBitacoraPrecio() {
		return codigoBitacoraPrecio;
	}

	/**
	 * @param codigoBitacoraPrecio the codigoBitacoraPrecio to set
	 */
	public void setCodigoBitacoraPrecio(Long codigoBitacoraPrecio) {
		this.codigoBitacoraPrecio = codigoBitacoraPrecio;
	}

}
