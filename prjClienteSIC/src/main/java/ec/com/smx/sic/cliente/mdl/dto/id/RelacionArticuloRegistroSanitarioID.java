package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class RelacionArticuloRegistroSanitarioID implements Serializable {
	
	/**
	 * codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * codigo del articulo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	
	/**
	 * Código del registro sanitario de articulo
	 *
	 */
	@Column(name="CODIGOREGISTROSANITARIO", nullable = false)
	private String codigoRegistroSanitario;

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
	 * @return the codigoRegistroSanitario
	 */
	public String getCodigoRegistroSanitario() {
		return codigoRegistroSanitario;
	}

	/**
	 * @param codigoRegistroSanitario the codigoRegistroSanitario to set
	 */
	public void setCodigoRegistroSanitario(String codigoRegistroSanitario) {
		this.codigoRegistroSanitario = codigoRegistroSanitario;
	}
	
	
}
