/**
 * 
 */
package ec.com.smx.sic.cliente.common.beans;

import java.io.Serializable;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class InformacionCaracteristicas implements Serializable {
	
	private final Integer codigoCaracteristica;
	private final String nombreCampoCodigoCaracteristica;
	private final String nombreCampoValorCaracteristica;
	private final String nombreCampoCaracteristica;
	private final String nombreObjetoBase;
	private final String rutaAccesoCampoCaracteristica;
	private final String rutaAccesoCampoCodigoCaracteristica;
	private final String rutaAccesoCampoValorCaracteristica;
	
	private final String PUNTO = ".";
	
	
	
	
	public InformacionCaracteristicas(Integer codigoCaracteristica,
			String nombreCampoCodigoCaracteristica,
			String nombreCampoValorCaracteristica,
			String nombreCampoCaracteristica, String nombreObjetoBase) {
		super();
		this.codigoCaracteristica = codigoCaracteristica;
		this.nombreCampoCodigoCaracteristica = nombreCampoCodigoCaracteristica;
		this.nombreCampoValorCaracteristica = nombreCampoValorCaracteristica;
		this.nombreCampoCaracteristica = nombreCampoCaracteristica;
		this.nombreObjetoBase = nombreObjetoBase;
		this.rutaAccesoCampoCaracteristica = this.nombreObjetoBase + this.PUNTO + this.nombreCampoCaracteristica;
		this.rutaAccesoCampoCodigoCaracteristica = this.nombreObjetoBase + this.PUNTO + this.nombreCampoCodigoCaracteristica;
		this.rutaAccesoCampoValorCaracteristica = this.nombreObjetoBase + this.PUNTO + this.nombreCampoValorCaracteristica;
		
	}
	/**
	 * @return the codigoCaracteristica
	 */
	public Integer getCodigoCaracteristica() {
		return codigoCaracteristica;
	}
	
	/**
	 * @return the nombreCampoCodigoCaracteristica
	 */
	public String getNombreCampoCodigoCaracteristica() {
		return nombreCampoCodigoCaracteristica;
	}
	
	/**
	 * @return the nombreCampoValorCaracteristica
	 */
	public String getNombreCampoValorCaracteristica() {
		return nombreCampoValorCaracteristica;
	}
	
	/**
	 * @return the nombreCampoCaracteristica
	 */
	public String getNombreCampoCaracteristica() {
		return nombreCampoCaracteristica;
	}
	
	/**
	 * @return the nombreObjetoBase
	 */
	public String getNombreObjetoBase() {
		return nombreObjetoBase;
	}
	
	/**
	 * @return the rutaAccesoCampoCaracteristica
	 */
	public String getRutaAccesoCampoCaracteristica() {
		return rutaAccesoCampoCaracteristica;
	}
	/**
	 * @return the rutaAccesoCampoCodigoCaracteristica
	 */
	public String getRutaAccesoCampoCodigoCaracteristica() {
		return rutaAccesoCampoCodigoCaracteristica;
	}
	/**
	 * @return the rutaAccesoCampoValorCaracteristica
	 */
	public String getRutaAccesoCampoValorCaracteristica() {
		return rutaAccesoCampoValorCaracteristica;
	}
	
	
	

}
