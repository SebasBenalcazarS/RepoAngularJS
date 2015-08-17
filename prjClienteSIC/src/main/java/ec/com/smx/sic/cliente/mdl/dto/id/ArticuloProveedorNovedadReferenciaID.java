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
public class ArticuloProveedorNovedadReferenciaID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIALNOVEDAD", nullable = false)
	private Long secuencialNovedad;

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
	 * @return the secuencialNovedad
	 */
	public Long getSecuencialNovedad() {
		return secuencialNovedad;
	}

	/**
	 * @param secuencialNovedad the secuencialNovedad to set
	 */
	public void setSecuencialNovedad(Long secuencialNovedad) {
		this.secuencialNovedad = secuencialNovedad;
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
