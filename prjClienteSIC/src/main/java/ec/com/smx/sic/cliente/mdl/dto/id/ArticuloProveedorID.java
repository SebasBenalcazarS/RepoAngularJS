package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloProveedor
 * @see ec.com.smx.sic.adm.dto.ArticuloProveedor
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloProveedorID implements Serializable, Cloneable{

	/**
	 * Codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Codigo de articulo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	/**
	 * Codigo del proveedor
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor;

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
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

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
	 *            El valor a establecer para la propiedad <code>codigoArticulo</code>.
	 */
	public void setCodigoArticulo(String codigoArticulo1) {
		this.codigoArticulo = codigoArticulo1;

		if (codigoArticulo != null && codigoArticulo.length() > 20) {
			codigoArticulo = codigoArticulo.substring(0, 20);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoProveedor</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoProveedor</code>
	 */
	public String getCodigoProveedor() {
		return this.codigoProveedor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoProveedor</code>.
	 * 
	 * @param codigoProveedor1
	 *            El valor a establecer para la propiedad <code>codigoProveedor</code>.
	 */
	public void setCodigoProveedor(String codigoProveedor1) {
		this.codigoProveedor = codigoProveedor1;

		if (codigoProveedor != null && codigoProveedor.length() > 10) {
			codigoProveedor = codigoProveedor.substring(0, 10);
		}

	}

	public ArticuloProveedorID clone() throws CloneNotSupportedException{
		return (ArticuloProveedorID)super.clone();
	}
}
