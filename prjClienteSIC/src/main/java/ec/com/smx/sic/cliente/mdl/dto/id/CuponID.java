package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase CuponDTO
 * 
 * @author fvallejo
 * 
 */
@Embeddable
public class CuponID extends BaseID {

	private static final long serialVersionUID = -7088176157494481450L;

	/**
	 * Especifica el código de la compania.
	 * 
	 */
	private Integer codigoCompania;

	/**
	 * Especifica el código del artículo.
	 * 
	 */
	private String codigoArticulo;

	/**
	 * 
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * 
	 * @param codigoCompania
	 *            the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * 
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * 
	 * @param codigoArticulo
	 *            the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

}
