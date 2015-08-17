/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor;

import ec.com.smx.corpv2.common.util.TiposCatalogoConstantes;
import ec.com.smx.sic.cliente.resources.proveedor.SICProveedorMessages;

/**
 * @author Mario Braganza
 *
 */
public class TipoAsignacionProveedorOficinaExterior {
	
	private final String valorTipoAsignacionProveedorOficinaExterior;
	public final static Integer CODIGO_TIPO_ASIGNACION_PROVEEDOR_OFICINA_EXTERIOR = TiposCatalogoConstantes.TIPO_ASIGNACIONES_PROVEEDOR_OFICINA_EXTERIOR;
	
	public TipoAsignacionProveedorOficinaExterior(String valorTipoAsignacionProveedorOficinaExterior){
		this.valorTipoAsignacionProveedorOficinaExterior = valorTipoAsignacionProveedorOficinaExterior;
	}
	

	/**
	 * @return the valorTipoAsignacionProveedorOficinaExterior
	 */
	public String getValorTipoAsignacionProveedorOficinaExterior() {
		return valorTipoAsignacionProveedorOficinaExterior;
	}


	public final static TipoAsignacionProveedorOficinaExterior PREDETERMINADA = new TipoAsignacionProveedorOficinaExterior(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipoAsignacionProveedorOficinaExterior.predeterminada.codigo")) {};
	public final static TipoAsignacionProveedorOficinaExterior NO_PREDETERMINADA = new TipoAsignacionProveedorOficinaExterior(SICProveedorMessages.getInstancia().getString("ec.com.smx.max.tipoAsignacionProveedorOficinaExterior.noPredeterminada.codigo")) {};

}
