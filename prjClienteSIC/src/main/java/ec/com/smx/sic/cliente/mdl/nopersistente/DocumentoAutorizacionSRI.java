package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.GregorianCalendar;

import ec.com.kruger.cliente.sri.respuesta.ws.jaxb.Autorizacion;

/**
 * Obtiene la autorizacion de los documentos electronicos del SRI
 * 
 * @author fcollaguazo
 *
 */
public class DocumentoAutorizacionSRI {

	private String contenidoXML;
	
	private Autorizacion autorizacion;
	
	private GregorianCalendar fechaAutorizacion;
	
	private String numeroComprobantes;

	/**
	 * @return the contenidoXML
	 */
	public String getContenidoXML() {
		return contenidoXML;
	}

	/**
	 * @param contenidoXML the contenidoXML to set
	 */
	public void setContenidoXML(String contenidoXML) {
		this.contenidoXML = contenidoXML;
	}

	/**
	 * @return the autorizacion
	 */
	public Autorizacion getAutorizacion() {
		return autorizacion;
	}

	/**
	 * @param autorizacion the autorizacion to set
	 */
	public void setAutorizacion(Autorizacion autorizacion) {
		this.autorizacion = autorizacion;
	}

	/**
	 * @return the fechaAutorizacion
	 */
	public GregorianCalendar getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	/**
	 * @param fechaAutorizacion the fechaAutorizacion to set
	 */
	public void setFechaAutorizacion(GregorianCalendar fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	/**
	 * @return the numeroComprobantes
	 */
	public String getNumeroComprobantes() {
		return numeroComprobantes;
	}

	/**
	 * @param numeroComprobantes the numeroComprobantes to set
	 */
	public void setNumeroComprobantes(String numeroComprobantes) {
		this.numeroComprobantes = numeroComprobantes;
	}
}
