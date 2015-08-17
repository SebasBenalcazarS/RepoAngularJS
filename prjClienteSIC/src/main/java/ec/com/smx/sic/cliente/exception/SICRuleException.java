/*
 * Creado el 20079-04-20
 */
package ec.com.smx.sic.cliente.exception;

/**
 * @author fmunoz
 * 
 */
@SuppressWarnings("serial")
public class SICRuleException extends SICException{

	public SICRuleException() {
		super();
	}

	public SICRuleException(String codigoError, String mensaje,
			String descripcionError) {
		super(codigoError, mensaje, descripcionError);
	}

	public SICRuleException(String codigoError, String descripcionError) {
		super(codigoError, descripcionError);
	}

	public SICRuleException(String message, Throwable cause) {
		super(message, cause);
	}

	public SICRuleException(String message) {
		super(message);
	}

	public SICRuleException(Throwable cause) {
		super(cause);
	}
	
}

