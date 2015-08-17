/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.regsan.calculo;


import org.apache.commons.lang3.StringUtils;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.gestor.articulo.regsan.calculo.ICalculoRegSanGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;

/**
 * @author fmunoz
 *
 */

public class CalculoRegSanGestor implements ICalculoRegSanGestor {

	/**
	 * 
	 * @param ars
	 */
	@Override
	public void asignarCamposRegistroSanitario(ArticuloRegistroSanitarioDTO ars){
		if(StringUtils.isEmpty(ars.getEstadoRegistroSanitario()))
			ars.setEstadoRegistroSanitario(SICConstantes.ESTADO_ACTIVO_NUMERICO);
		if(StringUtils.isEmpty(ars.getDescripcionArticulo()))
			ars.setDescripcionArticulo(SICConstantes.VALOR_NOASIGNADO);
	}
}
