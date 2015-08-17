package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloEstablecimiento
 * @author corbe
 *
 */
@SuppressWarnings("serial")
public class ArticuloEstablecimientoID implements Serializable{
	
	/**
	 * codigo de compania
	 *
	 */
	private Integer codigoCompania ;

	/**
	 * codigo del articulo
	 * 
	 */
	private String codigoArticulo;
	
	/**
	 * codigo asignado al establecimiento
	 *
	 */
	private Integer codigoEstablecimiento ;
	

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}

	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
}
