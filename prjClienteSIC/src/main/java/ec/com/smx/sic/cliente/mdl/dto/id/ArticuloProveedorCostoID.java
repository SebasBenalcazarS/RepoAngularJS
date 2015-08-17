package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;



/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloProveedorCosto
 * 
 * @author adgonzalez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloProveedorCostoID implements Serializable, Cloneable{

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

	@ComparatorTypeField
	@Column(name="VALORTIPOCOSTO", nullable = false)	
	private String valorTipoCosto;
	
	@Column(name="CODIGOTIPOCOSTO", nullable = false)
	private Integer codigoTipoCosto;
	
	/**
	 * Retorna el valor de la propiedad codigoCompania
	 * @return
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * Establece el valor de la propiedad codigoCompania
	 * @return
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;
	}
	/**
	 * Retorna el valor de la propiedad codigoArticulo
	 * @return
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * Establece el valor de la propiedad codigoArticulo
	 * @return
	 */
	public void setCodigoArticulo(String codigoArticulo1) {
		this.codigoArticulo = codigoArticulo1;
		
		if (codigoArticulo != null && codigoArticulo.length() > 20) {
			codigoArticulo = codigoArticulo.substring(0, 20);
		}
	}
	/**
	 * Retorna el valor de la propiedad codigoProveedor
	 * @return
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * Establece el valor de la propiedad codigoProveedor
	 * @param codigoProveedor
	 */
	public void setCodigoProveedor(String codigoProveedor1) {
		this.codigoProveedor = codigoProveedor1;
		
		if (codigoProveedor != null && codigoProveedor.length() > 10) {
			codigoProveedor = codigoProveedor.substring(0, 10);
		}
	}
	
	public ArticuloProveedorCostoID clone() throws CloneNotSupportedException{
		return (ArticuloProveedorCostoID)super.clone();
	}
	
	public String getValorTipoCosto() {
		return valorTipoCosto;
	}

	public void setValorTipoCosto(String valorTipoCosto) {
		this.valorTipoCosto = valorTipoCosto;
	}

	public Integer getCodigoTipoCosto() {
		return codigoTipoCosto;
	}

	public void setCodigoTipoCosto(Integer codigoTipoCosto) {
		this.codigoTipoCosto = codigoTipoCosto;
	}
}
