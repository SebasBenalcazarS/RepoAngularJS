/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
public class ConfiguracionNivelPagoReporteCaracteristicaID implements Serializable {

	private Integer codigoCompania;
	
	@Column(name = "SECCONNIVPAG")
	private String secuencialConfiguracionNivelPago;
	private String codigoCaracteristica;
	private Integer codigoCaracteristicaTipo;
	
	
	
	
	
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
	 * @return the secuencialConfiguracionNivelPago
	 */
	public String getSecuencialConfiguracionNivelPago() {
		return secuencialConfiguracionNivelPago;
	}
	/**
	 * @param secuencialConfiguracionNivelPago the secuencialConfiguracionNivelPago to set
	 */
	public void setSecuencialConfiguracionNivelPago(
			String secuencialConfiguracionNivelPago) {
		this.secuencialConfiguracionNivelPago = secuencialConfiguracionNivelPago;
	}
	/**
	 * @return the codigoCaracteristica
	 */
	public String getCodigoCaracteristica() {
		return codigoCaracteristica;
	}
	/**
	 * @param codigoCaracteristica the codigoCaracteristica to set
	 */
	public void setCodigoCaracteristica(String codigoCaracteristica) {
		this.codigoCaracteristica = codigoCaracteristica;
	}
	/**
	 * @return the codigoCaracteristicaTipo
	 */
	public Integer getCodigoCaracteristicaTipo() {
		return codigoCaracteristicaTipo;
	}
	/**
	 * @param codigoCaracteristicaTipo the codigoCaracteristicaTipo to set
	 */
	public void setCodigoCaracteristicaTipo(Integer codigoCaracteristicaTipo) {
		this.codigoCaracteristicaTipo = codigoCaracteristicaTipo;
	}

}
