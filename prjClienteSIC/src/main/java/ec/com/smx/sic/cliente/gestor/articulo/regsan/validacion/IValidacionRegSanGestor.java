package ec.com.smx.sic.cliente.gestor.articulo.regsan.validacion;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;

public interface IValidacionRegSanGestor {

	/**
	 * 
	 * @param ars
	 * @throws SICException
	 */
	public abstract void validarAsignacionesRegistroSanitario(RelacionArticuloRegistroSanitarioDTO ars) throws SICException;

}