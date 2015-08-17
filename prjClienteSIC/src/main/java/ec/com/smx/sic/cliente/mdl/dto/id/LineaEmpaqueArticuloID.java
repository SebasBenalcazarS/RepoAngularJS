package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class LineaEmpaqueArticuloID implements Serializable {

	/**
	 * Codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Especifica el codigo numerico de la linea de empaque
	 * */
	@Column(name = "CODIGOLINEAEMPAQUE", nullable = false)
	private Integer codigoLineaEmpaque;

	/**
	 * Especifica el codigo numerico del articulo
	 * */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	/**
	 * Metodo Getter del campo codigoCompania
	 * 
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * Metodo Setter the codigoCompania
	 * 
	 * @param codigoCompania
	 *            the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * Metodo Getter del campo codigoLineaEmpaque
	 * 
	 * @return the codigoLineaEmpaque
	 */
	public Integer getCodigoLineaEmpaque() {
		return codigoLineaEmpaque;
	}

	/**
	 * Metodo Setter the codigoLineaEmpaque
	 * 
	 * @param codigoLineaEmpaque
	 *            the codigoLineaEmpaque to set
	 */
	public void setCodigoLineaEmpaque(Integer codigoLineaEmpaque) {
		this.codigoLineaEmpaque = codigoLineaEmpaque;
	}

	/**
	 * Metodo Getter del campo codigoArticulo
	 * 
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * Metodo Setter the codigoArticulo
	 * 
	 * @param codigoArticulo
	 *            the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
}
