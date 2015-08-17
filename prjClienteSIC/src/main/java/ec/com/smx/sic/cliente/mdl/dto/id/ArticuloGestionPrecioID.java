/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Victor Jaramillo
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloGestionPrecioID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOGESTIONPRECIO", nullable = false)
	private Long codigoGestionPrecio;
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

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
	 * @return the codigoGestionPrecio
	 */
	public Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}

	/**
	 * @param codigoGestionPrecio the codigoGestionPrecio to set
	 */
	public void setCodigoGestionPrecio(Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
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
}
