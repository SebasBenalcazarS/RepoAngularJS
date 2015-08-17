package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author cgalarza
 *
 */
@SuppressWarnings("serial")
@Entity
public class RecetasPopularesDTO implements Serializable{
	
	@Id 
	private Long codigoReceta;
	private Long cantidad;
	private String idApp;
	/**
	 * @return the codigoReceta
	 */
	public Long getCodigoReceta() {
		return codigoReceta;
	}
	/**
	 * @param codigoReceta the codigoReceta to set
	 */
	public void setCodigoReceta(Long codigoReceta) {
		this.codigoReceta = codigoReceta;
	}
	/**
	 * @return the cantidad
	 */
	public Long getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the idApp
	 */
	public String getIdApp() {
		return idApp;
	}
	/**
	 * @param idApp the idApp to set
	 */
	public void setIdApp(String idApp) {
		this.idApp = idApp;
	}
}