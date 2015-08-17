package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class HistorialArticuloProveedorPrecioID implements Serializable {

	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOHISTORIALPRECIO", nullable = false)
	private Long codigoHistorialPrecio;
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;

	
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
	 * @return the codigoHistorialPrecio
	 */
	public Long getCodigoHistorialPrecio() {
		return codigoHistorialPrecio;
	}

	/**
	 * @param codigoHistorialPrecio the codigoHistorialPrecio to set
	 */
	public void setCodigoHistorialPrecio(Long codigoHistorialPrecio) {
		this.codigoHistorialPrecio = codigoHistorialPrecio;
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
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
}
