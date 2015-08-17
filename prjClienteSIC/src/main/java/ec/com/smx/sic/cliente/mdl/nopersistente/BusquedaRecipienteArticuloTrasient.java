package ec.com.smx.sic.cliente.mdl.nopersistente;

import javax.persistence.Id;

/**
 * Busca los recipientes con los que puede ser recibido un articulo en la recepcion
 * @author amunoz
 *
 */
public class BusquedaRecipienteArticuloTrasient {
	@Id
	private String codigoArticuloRecipiente;
	private String descripcionArticuloRecipiente;
	private String codigoArticuloRecepcion;
	
	
	public String getCodigoArticuloRecipiente() {
		return codigoArticuloRecipiente;
	}
	public void setCodigoArticuloRecipiente(String codigoArticuloRecipiente) {
		this.codigoArticuloRecipiente = codigoArticuloRecipiente;
	}
	public String getDescripcionArticuloRecipiente() {
		return descripcionArticuloRecipiente;
	}
	public void setDescripcionArticuloRecipiente(String descripcionArticuloRecipiente) {
		this.descripcionArticuloRecipiente = descripcionArticuloRecipiente;
	}
	public String getCodigoArticuloRecepcion() {
		return codigoArticuloRecepcion;
	}
	public void setCodigoArticuloRecepcion(String codigoArticuloRecepcion) {
		this.codigoArticuloRecepcion = codigoArticuloRecepcion;
	}
	
	
	
}
