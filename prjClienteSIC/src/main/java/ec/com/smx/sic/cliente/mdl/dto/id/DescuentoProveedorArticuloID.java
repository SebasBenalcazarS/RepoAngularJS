package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DescuentoProveedorArticulo
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticulo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class DescuentoProveedorArticuloID implements Serializable {

	/**
	 * Codigo de la compan�a
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Codigo de la secuencia
	 */
	@Column(name = "SECDESCARTPRO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSADSECDESARTPRO")
	private String secuencialDescuentoArticuloProveedor;

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

//	/**
//	 * Retorna valor de propiedad <code>codigoProveedor</code>
//	 * 
//	 * @return Retorna valor de propiedad <code>codigoProveedor</code>
//	 */
//	public String getCodigoProveedor() {
//		return this.codigoProveedor;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>codigoProveedor</code>.
//	 * 
//	 * @param codigoProveedor1
//	 *            El valor a establecer para la propiedad <code>codigoProveedor</code>.
//	 */
//	public void setCodigoProveedor(String codigoProveedor1) {
//		this.codigoProveedor = codigoProveedor1;
//
//		if (codigoProveedor != null && codigoProveedor.length() > 10) {
//			codigoProveedor = codigoProveedor.substring(0, 10);
//		}
//
//	}
//
//	/**
//	 * Retorna valor de propiedad <code>codigoArticulo</code>
//	 * 
//	 * @return Retorna valor de propiedad <code>codigoArticulo</code>
//	 */
//	public String getCodigoArticulo() {
//		return this.codigoArticulo;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
//	 * 
//	 * @param codigoArticulo1
//	 *            El valor a establecer para la propiedad <code>codigoArticulo</code>.
//	 */
//	public void setCodigoArticulo(String codigoArticulo1) {
//		this.codigoArticulo = codigoArticulo1;
//
//		if (codigoArticulo != null && codigoArticulo.length() > 20) {
//			codigoArticulo = codigoArticulo.substring(0, 20);
//		}
//
//	}
//
//	/**
//	 * Retorna valor de propiedad <code>codigoTipoDescuento</code>
//	 * 
//	 * @return Retorna valor de propiedad <code>codigoTipoDescuento</code>
//	 */
//	public String getCodigoTipoDescuento() {
//		return this.codigoTipoDescuento;
//	}
//
//	/**
//	 * Establece un nuevo valor para la propiedad <code>codigoTipoDescuento</code>.
//	 * 
//	 * @param codigoTipoDescuento1
//	 *            El valor a establecer para la propiedad <code>codigoTipoDescuento</code>.
//	 */
//	public void setCodigoTipoDescuento(String codigoTipoDescuento1) {
//		this.codigoTipoDescuento = codigoTipoDescuento1;
//
//		if (codigoTipoDescuento != null && codigoTipoDescuento.length() > 5) {
//			codigoTipoDescuento = codigoTipoDescuento.substring(0, 5);
//		}
//
//	}

	/**
	 * @return the secuencialDescuentoArticuloProveedor
	 */
	public String getSecuencialDescuentoArticuloProveedor() {
		return secuencialDescuentoArticuloProveedor;
	}

	/**
	 * @param secuencialDescuentoArticuloProveedor the secuencialDescuentoArticuloProveedor to set
	 */
	public void setSecuencialDescuentoArticuloProveedor(String secuencialDescuentoArticuloProveedor) {
		this.secuencialDescuentoArticuloProveedor = secuencialDescuentoArticuloProveedor;
	}
	
	

}
