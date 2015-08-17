package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoCodigoBarras
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.TipoCodigoBarras
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoCodigoBarrasID implements Serializable {

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * El identificador del registro de tipos de código de barras
	 */
	@Column(name = "CODIGOTIPO", nullable = false)
	private String codigoTipo;

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

	/**
	 * Retorna valor de propiedad <code>codigoTipo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipo</code>
	 */
	public String getCodigoTipo() {
		return this.codigoTipo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipo</code>.
	 * 
	 * @param codigoTipo1
	 *            El valor a establecer para la propiedad <code>codigoTipo</code>.
	 */
	public void setCodigoTipo(String codigoTipo1) {
		this.codigoTipo = codigoTipo1;

		if (codigoTipo != null && codigoTipo.length() > 32) {
			codigoTipo = codigoTipo.substring(0, 32);
		}

	}

}
