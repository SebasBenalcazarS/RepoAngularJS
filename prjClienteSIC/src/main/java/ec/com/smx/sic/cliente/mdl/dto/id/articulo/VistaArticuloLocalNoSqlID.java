/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.articulo;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author wcaiza
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class VistaArticuloLocalNoSqlID implements Serializable {
	
	private Integer codigoCompania;
	private String codigoArticulo;
	private Integer codigoLocal;
	
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
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}
	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

}
