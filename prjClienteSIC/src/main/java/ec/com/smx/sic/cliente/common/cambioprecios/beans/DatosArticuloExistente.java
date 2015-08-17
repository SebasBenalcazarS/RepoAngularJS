/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class DatosArticuloExistente  implements Serializable{
	
	private String codigoArticulo;
	private String codigoProveedor;
	private String valorTipoEstado;
	private Long codigoGestionPrecio;
	private Long codigoValorCostoGestion;
	private Double precioPVPNuevo;
	private Double precioSMXNuevo;
	private Date fechaVigenciaVenta;
	
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
	 * @return the codigoGestionPrecio
	 */
	public Long getCodigoGestionPrecio() {
		return codigoGestionPrecio;
	}
	/**
	 * @param codigoGestionPrecio the codigoGestionPrecio to set
	 */
	public void setCodigoGestionPrecio(Long codigoGestionPrecio) {
		this.codigoGestionPrecio = codigoGestionPrecio;
	}
	/**
	 * @return the codigoValorCostoGestion
	 */
	public Long getCodigoValorCostoGestion() {
		return codigoValorCostoGestion;
	}
	/**
	 * @param codigoValorCostoGestion the codigoValorCostoGestion to set
	 */
	public void setCodigoValorCostoGestion(Long codigoValorCostoGestion) {
		this.codigoValorCostoGestion = codigoValorCostoGestion;
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
	
	public Double getPrecioPVPNuevo() {
		return precioPVPNuevo;
	}
	
	public void setPrecioPVPNuevo(Double precioPVPNuevo) {
		this.precioPVPNuevo = precioPVPNuevo;
	}
	
	public Double getPrecioSMXNuevo() {
		return precioSMXNuevo;
	}
	
	public void setPrecioSMXNuevo(Double precioSMXNuevo) {
		this.precioSMXNuevo = precioSMXNuevo;
	}
	
	public String getValorTipoEstado() {
		return valorTipoEstado;
	}
	
	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}
	
	public Date getFechaVigenciaVenta() {
		return fechaVigenciaVenta;
	}
	
	public void setFechaVigenciaVenta(Date fechaVigenciaVenta) {
		this.fechaVigenciaVenta = fechaVigenciaVenta;
	}
}
