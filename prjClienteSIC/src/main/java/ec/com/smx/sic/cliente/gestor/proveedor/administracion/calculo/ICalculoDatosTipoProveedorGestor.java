/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.proveedor.administracion.calculo;

import ec.com.smx.sic.cliente.common.IConfiguracionBean;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoDatoProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author Mario Braganza
 *
 */
public interface ICalculoDatosTipoProveedorGestor extends IConfiguracionBean {
	
	/**
	 * 
	 * @param codigoCompania
	 * @param resultadoValidacionProveedor
	 * @param tipoDatoProveedorPrincipal
	 * @param tiposDatosProveedorSecundarios
	 * @return
	 * @throws SICException
	 */
	public ProveedorVO obtenerDatosProveedor(Integer codigoCompania,
			ResultadoValidacionProveedor resultadoValidacionProveedor,
			TipoDatoProveedor tipoDatoProveedorPrincipal,
			TipoDatoProveedor... tiposDatosProveedorSecundarios) throws SICException;
	
	
	
	/**
	 * 
	 * @param proveedorVO
	 * @param resultadoValidacionProveedor
	 * @throws SICException
	 */
	public void completarDatosProveedor(ProveedorVO proveedorVO,
			ResultadoValidacionProveedor resultadoValidacionProveedor,
			TipoDatoProveedor... tiposDatosProveedor) throws SICException;

}
