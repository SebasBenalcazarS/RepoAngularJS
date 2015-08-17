/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import ec.com.smx.sic.cliente.common.oficinaexterior.ResultadoValidacionOficinaExterior;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class DatosRegistroOficinaExteriorVO extends DatosRegistroEntidadVO<ResultadoValidacionOficinaExterior, OficinaExteriorVO> {
	
	
	/**
	 * 
	 * @param oficinaExteriorVO
	 * @param resultadoValidacionOficinaExterior
	 */
	public DatosRegistroOficinaExteriorVO(OficinaExteriorVO oficinaExteriorVO, 
			ResultadoValidacionOficinaExterior resultadoValidacionOficinaExterior){
		
		super(oficinaExteriorVO, resultadoValidacionOficinaExterior);
	}

}
