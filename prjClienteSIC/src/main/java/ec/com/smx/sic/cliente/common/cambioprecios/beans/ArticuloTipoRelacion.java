/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;

/**
 * @author Victor Jaramillo
 *
 */
@SuppressWarnings("serial")
public class ArticuloTipoRelacion implements Serializable{
	
	private String codigoArticulo;
	private String codigoArticuloRelacionado;
	private String tipoRelacion;
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
	 * @return the codigoArticuloRelacionado
	 */
	public String getCodigoArticuloRelacionado() {
		return codigoArticuloRelacionado;
	}
	/**
	 * @param codigoArticuloRelacionado the codigoArticuloRelacionado to set
	 */
	public void setCodigoArticuloRelacionado(String codigoArticuloRelacionado) {
		this.codigoArticuloRelacionado = codigoArticuloRelacionado;
	}
	/**
	 * @return the tipoRelacion
	 */
	public String getTipoRelacion() {
		return tipoRelacion;
	}
	/**
	 * @param tipoRelacion the tipoRelacion to set
	 */
	public void setTipoRelacion(String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}
}