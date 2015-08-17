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
public class ClaseArticuloID implements Serializable{

    /**
     * Codigo de la compañía
     */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

    /**
     * Codigo que califica a la clase del articulo
     */
	@Column(name = "CODIGOCLASEARTICULO", nullable = false)
    private String codigoClaseArticulo ;

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
	 * @return the codigoClaseArticulo
	 */
	public String getCodigoClaseArticulo() {
		return codigoClaseArticulo;
	}

	/**
	 * @param codigoClaseArticulo the codigoClaseArticulo to set
	 */
	public void setCodigoClaseArticulo(String codigoClaseArticulo) {
		this.codigoClaseArticulo = codigoClaseArticulo != null ? codigoClaseArticulo.toUpperCase() : null;
	}
}
