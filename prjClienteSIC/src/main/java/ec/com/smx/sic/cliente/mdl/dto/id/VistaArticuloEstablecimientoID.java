
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ClienteArticulo
 *
 * @author mrivera
 */
@Embeddable
@SuppressWarnings("serial")
public class VistaArticuloEstablecimientoID extends BaseID {

	/**
	 * Especifica el codigo de la compania.
	 */
	@Column(name="CODIGOCOMPANIA")
	private Integer codigoCompania ;
	/**
	 * Código del artículo
	 */
	@Column(name="CODIGOARTICULO")
	private String codigoArticulo;
	/**
	 * Código asignado al establecimiento
	 */
	@Column(name="CODIGOESTABLECIMIENTO")
	private Integer codigoEstablecimiento ;
	
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
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the codigoEstablecimiento
	 */
	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}
	/**
	 * @param codigoEstablecimiento the codigoEstablecimiento to set
	 */
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}	
}

