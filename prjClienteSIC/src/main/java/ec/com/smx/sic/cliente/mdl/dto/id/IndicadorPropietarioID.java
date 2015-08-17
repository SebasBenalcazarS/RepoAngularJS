/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class IndicadorPropietarioID implements Serializable{
	/**
	 * C&oacute;digo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * C&oacute;digo del indicador
	 * 
	 */
	@Column(name = "CODIGOINDICADORPROPIETARIO", nullable = false)
	private Integer codigoIndicadorPropietario;

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
	 * @return the codigoIndicadorPropietario
	 */
	public Integer getCodigoIndicadorPropietario() {
		return codigoIndicadorPropietario;
	}

	/**
	 * @param codigoIndicadorPropietario the codigoIndicadorPropietario to set
	 */
	public void setCodigoIndicadorPropietario(Integer codigoIndicadorPropietario) {
		this.codigoIndicadorPropietario = codigoIndicadorPropietario;
	}
	
}
