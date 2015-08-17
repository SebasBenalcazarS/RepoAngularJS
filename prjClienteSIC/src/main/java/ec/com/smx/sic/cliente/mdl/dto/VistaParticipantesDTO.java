package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author egudino 
 */
@Entity
@SuppressWarnings("serial")
public class VistaParticipantesDTO implements Serializable{
	@Id
	private java.lang.Integer secuenciaParticipante; 
	private java.lang.Long codigoPersona;
	private java.lang.String codigoProveedor;
	private java.lang.Long codigoLocalizacion;
	private java.lang.String participante;
	private java.lang.String codigoJDE;
	
	/**
	 * @return the secuenciaParticipante
	 */
	public java.lang.Integer getSecuenciaParticipante() {
		return secuenciaParticipante;
	}
	/**
	 * @param secuenciaParticipante the secuenciaParticipante to set
	 */
	public void setSecuenciaParticipante(java.lang.Integer secuenciaParticipante) {
		this.secuenciaParticipante = secuenciaParticipante;
	}
	/**
	 * @return the codigoPersona
	 */
	public java.lang.Long getCodigoPersona() {
		return codigoPersona;
	}
	/**
	 * @param codigoPersona the codigoPersona to set
	 */
	public void setCodigoPersona(java.lang.Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	/**
	 * @return the codigoProveedor
	 */
	public java.lang.String getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(java.lang.String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	/**
	 * @return the codigoLocalizacion
	 */
	public java.lang.Long getCodigoLocalizacion() {
		return codigoLocalizacion;
	}
	/**
	 * @param codigoLocalizacion the codigoLocalizacion to set
	 */
	public void setCodigoLocalizacion(java.lang.Long codigoLocalizacion) {
		this.codigoLocalizacion = codigoLocalizacion;
	}
	/**
	 * @return the participante
	 */
	public java.lang.String getParticipante() {
		return participante;
	}
	/**
	 * @param participante the participante to set
	 */
	public void setParticipante(java.lang.String participante) {
		this.participante = participante;
	}
	public java.lang.String getCodigoJDE() {
		return codigoJDE;
	}
	public void setCodigoJDE(java.lang.String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}
}
