package ec.com.smx.sic.cliente.mdl.dto.id.b2b;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase
 * DetalleOrdenCompra
 * 
 * @see ec.com.smx.b2b.dto.DetalleOrdenCompra
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
@Deprecated
public class DetalleOrdenCompraID implements Serializable {
	/**
	 * codigo que identifica la compania.
	 * 
	 */
	private Integer codigoCompania;
	/**
	 * codigo del pedido
	 * 
	 */
	@Column(name = "CODIGOPEDIDO")
	private Long codigoPedido;
	/**
	 * numero de la orden de compra.
	 * 
	 */
	@Column(name = "CODIGOORDENCOMPRA")
	private String codigoOrdenCompra;
	/**
	 * identificacion del articulo
	 * 
	 */
	private String codigoArticulo;
	
	@Column(name = "SECDETORDCOM", nullable=false)
    private Long secuencialDetalleOrdenCompra;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoPedido</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoPedido</code>
	 */
	public java.lang.Long getCodigoPedido() {
		return this.codigoPedido;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoPedido</code>.
	 * 
	 * @param codigoPedido1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoPedido</code>.
	 */
	public void setCodigoPedido(java.lang.Long codigoPedido1) {
		this.codigoPedido = codigoPedido1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoOrdenCompra</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoOrdenCompra</code>
	 */
	public String getCodigoOrdenCompra() {
		return this.codigoOrdenCompra;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoOrdenCompra</code>
	 * .
	 * 
	 * @param codigoOrdenCompra1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoOrdenCompra</code>.
	 */
	public void setCodigoOrdenCompra(String codigoOrdenCompra1) {
		this.codigoOrdenCompra = codigoOrdenCompra1;

		if (codigoOrdenCompra != null && codigoOrdenCompra.length() > 12) {
			codigoOrdenCompra = codigoOrdenCompra.substring(0, 12);
		}
	}

	/**
	 * Retorna valor de propiedad <code>codigoArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoArticulo</code>
	 */
	public String getCodigoArticulo() {
		return this.codigoArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
	 * 
	 * @param codigoArticulo1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoArticulo</code>.
	 */
	public void setCodigoArticulo(String codigoArticulo1) {
		this.codigoArticulo = codigoArticulo1;

		if (codigoArticulo != null && codigoArticulo.length() > 20) {
			codigoArticulo = codigoArticulo.substring(0, 20);
		}

	}

	/**
	 * @return the secuencialDetalleOrdenCompra
	 */
	public Long getSecuencialDetalleOrdenCompra() {
		return secuencialDetalleOrdenCompra;
	}

	/**
	 * @param secuencialDetalleOrdenCompra the secuencialDetalleOrdenCompra to set
	 */
	public void setSecuencialDetalleOrdenCompra(Long secuencialDetalleOrdenCompra) {
		this.secuencialDetalleOrdenCompra = secuencialDetalleOrdenCompra;
	}
}
