package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author amunoz
 * @author cherrera
 * @author hgudino
 * 
 */

@SuppressWarnings("serial")
@Embeddable
public class RutaParticipanteRegistroNovedadID implements Serializable{
	
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA")
	private java.lang.Integer codigoCompania;
	
	/**
	 * Secuencial de la tabla bitacora
	 * 
	 */
	@Column(name = "SECUENCIAPARTICIPANTEREGISTRO", nullable = false)
	private java.lang.Long secuenciaParticipanteRegistro;
	
	/**
	 * Secuencial de la tabla Contenedor
	 * 
	 */
	@Column(name = "VALORTIPONOVEDAD", nullable = false)
	private java.lang.String valorTipoNovedad;
	
	/**
	 * @return the codigoCompania
	 */
	public java.lang.Integer getCodigoCompania() {
		return codigoCompania;
	}
	
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(java.lang.Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}	
		
	/**
	 * @return the secuenciaParticipanteRegistro
	 */
	public java.lang.Long getSecuenciaParticipanteRegistro() {
		return secuenciaParticipanteRegistro;
	}

	/**
	 * @param secuenciaParticipanteRegistro the secuenciaParticipanteRegistro to set
	 */
	public void setSecuenciaParticipanteRegistro(java.lang.Long secuenciaParticipanteRegistro) {
		this.secuenciaParticipanteRegistro = secuenciaParticipanteRegistro;
	}

	/**
	 * @return the valorTipoNovedad
	 */
	public java.lang.String getValorTipoNovedad() {
		return valorTipoNovedad;
	}
	
	/**
	 * @param valorTipoNovedad the valorTipoNovedad to set
	 */
	public void setValorTipoNovedad(java.lang.String valorTipoNovedad) {
		this.valorTipoNovedad = valorTipoNovedad;
	}
}
