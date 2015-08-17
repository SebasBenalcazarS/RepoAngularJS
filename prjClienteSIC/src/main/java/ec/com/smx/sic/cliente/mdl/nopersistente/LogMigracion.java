/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
public class LogMigracion implements Serializable{

	@Id
	private Long secuencial;
	private String codigoBarras;
	private String codigoProveedor;
	private Integer codigoLocal;
	private String mensaje;
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Long getSecuencial() {
		return secuencial;
	}
	public void setSecuencial(Long secuencial) {
		this.secuencial = secuencial;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public Integer getCodigoLocal() {
		return codigoLocal;
	}
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}
	
}