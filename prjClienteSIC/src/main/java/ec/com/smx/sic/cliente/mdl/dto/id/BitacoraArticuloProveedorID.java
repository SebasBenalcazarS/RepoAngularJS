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
 * @author Luis Yacchirema
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class BitacoraArticuloProveedorID implements Serializable {

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	@Column(name = "CODIGOBITARTPRO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCPRESECBITARTPRO")
	private Long codigoBitacoraArticuloProveedor;

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
	 * @return the codigoBitacoraArticuloProveedor
	 */
	public Long getCodigoBitacoraArticuloProveedor() {
		return codigoBitacoraArticuloProveedor;
	}

	/**
	 * @param codigoBitacoraArticuloProveedor the codigoBitacoraArticuloProveedor to set
	 */
	public void setCodigoBitacoraArticuloProveedor(Long codigoBitacoraArticuloProveedor) {
		this.codigoBitacoraArticuloProveedor = codigoBitacoraArticuloProveedor;
	}

}
