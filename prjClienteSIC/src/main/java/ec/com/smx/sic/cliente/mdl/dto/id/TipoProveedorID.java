/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author mbraganza
 *
 */

@Embeddable
public class TipoProveedorID implements Serializable {

	private Integer codigoCompania;
	private String codigoProveedor;
	private Integer codigoTipoProveedor;
	private String valorTipoProveedor;
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
	/**
	 * @return the codigoTipoProveedor
	 */
	public Integer getCodigoTipoProveedor() {
		return codigoTipoProveedor;
	}
	/**
	 * @param codigoTipoProveedor the codigoTipoProveedor to set
	 */
	public void setCodigoTipoProveedor(Integer codigoTipoProveedor) {
		this.codigoTipoProveedor = codigoTipoProveedor;
	}
	/**
	 * @return the valorTipoProveedor
	 */
	public String getValorTipoProveedor() {
		return valorTipoProveedor;
	}
	/**
	 * @param valorTipoProveedor the valorTipoProveedor to set
	 */
	public void setValorTipoProveedor(String valorTipoProveedor) {
		this.valorTipoProveedor = valorTipoProveedor;
	}
	
	
	
}
