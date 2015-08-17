/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.regsan.validacion;


import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.regsan.validacion.IValidacionRegSanGestor;
import ec.com.smx.sic.cliente.mdl.dto.RelacionArticuloRegistroSanitarioDTO;

/**
 * @author fmunoz
 *
 */

public class ValidacionRegSanGestor implements IValidacionRegSanGestor {

	/**
	 * 
	 * @param ars
	 * @throws SICException
	 */
	@Override
	public void validarAsignacionesRegistroSanitario(RelacionArticuloRegistroSanitarioDTO ars)throws SICException{

		if(!ars.getTieneArticulo() || ars.getArticulo().getCodigoBarrasActivo() == null)
			throw new SICException("Para realizar el registro se necesita los datos del art\u00EDculo y del c\u00F3digo de barras");
		if(!ars.getTieneRegistroSanitario() || StringUtils.isEmpty(ars.getRegistroSanitario().getRegistroSanitario()))
			throw new SICException("Se necesita los datos del registro sanitario con su numeraci\u00F3n");
		
	}
}
