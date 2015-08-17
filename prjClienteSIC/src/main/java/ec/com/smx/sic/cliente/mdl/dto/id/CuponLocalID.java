
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase CuponDTO
 *
 * @author mrivera
 */
@Embeddable
public class CuponLocalID extends BaseID {
	
	private static final long serialVersionUID = 3732630366636440359L;

	/**
	 * Especifica el codigo de la compania.
	 *
	 */
	private Integer codigoCompania ;
	
	/**
	 * Especifica el código del artículo.
	 *
	 */
	private String codigoArticulo ;
	/**
	 * Código del local donde se asignó el cupón
	 *
	 */
	private Integer codigoAreaTrabajo ;
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
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
}

