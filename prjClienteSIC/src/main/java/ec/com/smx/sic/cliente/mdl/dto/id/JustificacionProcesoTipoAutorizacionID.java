/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jvasquez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class JustificacionProcesoTipoAutorizacionID implements Serializable{
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial de la tabla Justificacion
	 * 
	 */
	@Column(name = "CODIGOJUSTIFICACION", nullable = false)
	private java.lang.Long codigoJustificacion;
	
	/**
	 * Especifica el codigo del proceso (secuencia de base)
	 */
	@Column(name="CODIGOPROCESO", nullable = false)
	private Long codigoProceso;
	
	/**
	 * Este campo representa el codigo del tipo de autorizacion
	 *

	 */
	@Column(name="CODIGOTIPOAUTORIZACION")
	private Long codigoTipoAutorizacion ;
		
	/**
	 * Este campo representa el codigo del sistema que tiene la autorizacion
	 *

	 */
	@Column(name="CODIGOSISTEMA")
	private String codigoSistema ;

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
	 * @return the codigoJustificacion
	 */
	public java.lang.Long getCodigoJustificacion() {
		return codigoJustificacion;
	}

	/**
	 * @param codigoJustificacion the codigoJustificacion to set
	 */
	public void setCodigoJustificacion(java.lang.Long codigoJustificacion) {
		this.codigoJustificacion = codigoJustificacion;
	}

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	/**
	 * @return the codigoTipoAutorizacion
	 */
	public Long getCodigoTipoAutorizacion() {
		return codigoTipoAutorizacion;
	}

	/**
	 * @param codigoTipoAutorizacion the codigoTipoAutorizacion to set
	 */
	public void setCodigoTipoAutorizacion(Long codigoTipoAutorizacion) {
		this.codigoTipoAutorizacion = codigoTipoAutorizacion;
	}

	/**
	 * @return the codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}

	/**
	 * @param codigoSistema the codigoSistema to set
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	
}
