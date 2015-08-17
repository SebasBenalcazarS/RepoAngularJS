/*
 * Creado el 20079-04-20
 */
package ec.com.smx.sic.cliente.exception;

import java.util.Collection;



/**
 * @author 
 * 
 */
@SuppressWarnings("serial")
public class ValidadorEanException extends Exception{
	
	private String codigoError;
	private String descripcionError;
	private Boolean showErrorMessage;
	private Collection<String> descripcionesErrores;

	
	/**
	 * Constructor por defecto. 
	 */
	public ValidadorEanException(){
		super();
	}
	
	public ValidadorEanException(String message){
		super(message);
	}

	/**
	 * @param message Mensaje de error.
	 */
	public ValidadorEanException(String message, Boolean showErrorMessage){
		this(message);
		this.descripcionError = message;
		this.showErrorMessage = showErrorMessage;
	}
	
	public ValidadorEanException(Collection<String> descripcionesErrores, Boolean showErrorMessage){
		super();
		this.descripcionesErrores = descripcionesErrores;
		this.showErrorMessage = showErrorMessage;
	}

	/**
	 * @param message Mensaje de error.
	 * @param cause Causa del error.
	 */
	public ValidadorEanException(String message, Throwable cause){
		super(message, cause);
	}

	/**
	 * @param cause Causa del Error.
	 */
	public ValidadorEanException(Throwable cause){
		super(cause);
	}
	/**
	 * @param codigoError  					codigo del error
	 * @param descripcionError 			descripcion del error
	 */
	public ValidadorEanException(String codigoError, String descripcionError){
		this.setCodigoError(codigoError);
		this.setDescripcionError(descripcionError);
	}
	/**
	 * @param codigoError  					codigo del error
	 * @param descripcionError 			descripcion del error
	 */
	public ValidadorEanException(String codigoError, String mensaje, String descripcionError){
		super(mensaje);
		this.setCodigoError(codigoError);			
		this.setDescripcionError(descripcionError);
	}

	/**
	 * @return the codigoError
	 */
	public String getCodigoError() {
		return codigoError;
	}

	/**
	 * @param codigoError the codigoError to set
	 */
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	/**
	 * @return the descripcionError
	 */
	public String getDescripcionError() {
		return descripcionError;
	}

	/**
	 * @param descripcionError the descripcionError to set
	 */
	public void setDescripcionError(String descripcionError) {
		this.descripcionError = descripcionError;
	}

	/**
	 * @return the showErrorMessage
	 */
	public Boolean getShowErrorMessage() {
		return showErrorMessage;
	}

	/**
	 * @param showErrorMessage the showErrorMessage to set
	 */
	public void setShowErrorMessage(Boolean showErrorMessage) {
		this.showErrorMessage = showErrorMessage;
	}

	/**
	 * @return the descripcionesErrores
	 */
	public Collection<String> getDescripcionesErrores() {
		return descripcionesErrores;
	}

	/**
	 * @param descripcionesErrores the descripcionesErrores to set
	 */
	public void setDescripcionesErrores(Collection<String> descripcionesErrores) {
		this.descripcionesErrores = descripcionesErrores;
	}
}

