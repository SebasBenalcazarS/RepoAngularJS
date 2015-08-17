package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.GregorianCalendar;

import ec.com.kruger.cliente.sri.comprobantes.electronicos.jaxb.factura.version110.Factura;
import ec.com.kruger.cliente.sri.comprobantes.electronicos.jaxb.notacredito.version110.NotaCredito;
import ec.com.kruger.cliente.sri.respuesta.ws.jaxb.Autorizacion;

/**
 * Estructura de los documentos electronicos del SRI
 * @author fcollaguazo
 *
 */
public class DocumentoElectronicoSRI {

	private Factura factura;
	
	private NotaCredito notaCredito;
	
	private Autorizacion autorizacion;
	
	private String comprobanteXml;
	
	private GregorianCalendar fechaAutorizacion;
	
	private String numeroComprobantes;

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Autorizacion getAutorizacion() {
		return autorizacion;
	}

	public void setAutorizacion(Autorizacion autorizacion) {
		this.autorizacion = autorizacion;
	}

	public String getComprobanteXml() {
		return comprobanteXml;
	}

	public void setComprobanteXml(String comprobanteXml) {
		this.comprobanteXml = comprobanteXml;
	}

	/**
	 * @return the notaCredito
	 */
	public NotaCredito getNotaCredito() {
		return notaCredito;
	}

	/**
	 * @param notaCredito the notaCredito to set
	 */
	public void setNotaCredito(NotaCredito notaCredito) {
		this.notaCredito = notaCredito;
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