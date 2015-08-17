/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.proveedor;

import java.util.Collection;

import ec.com.smx.corpv2.dto.DatoContactoPersonaLocalizacionDTO;
import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoEstadoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoProveedor;
import ec.com.smx.sic.cliente.common.proveedor.TipoValidacionProveedor;
import ec.com.smx.sic.cliente.common.proveedor.ValidacionOrigenProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IProveedor;
import ec.com.smx.sic.cliente.mdl.vo.IIdentificadorProveedorVO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;

/**
 * @author Mario Braganza
 *
 */
public interface IValidacionProveedorServicio {

	/**
	 * 
	 * @param identificadorProveedor
	 * @return
	 * @throws SICException
	 */
	ResultadoValidacionProveedor validarProveedor(IIdentificadorProveedorVO identificadorProveedor) throws SICException;

	/**
	 * 
	 * @param proveedorVO
	 * @param tipoValidacionProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarProveedorImportado(ProveedorVO proveedorVO, TipoValidacionProveedor tipoValidacionProveedor) throws SICException;


	/**
	 * 
	 * @param proveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarExistenciaOficinasExteriorPorProveedor(IProveedor proveedor) throws SICException;

	/**
	 * 
	 * @param proveedor
	 * @param valorCaracteristicaTipoProveedor
	 * @param tipoEstadoProveedor
	 * @throws SICException
	 */
	Boolean validarEstadoProveedorPorTipo(IProveedor proveedor, 
			TipoProveedor tipoProveedor, 
			TipoEstadoProveedor tipoEstadoProveedor) throws SICException;


	/**
	 * 
	 * @param proveedorVO
	 * @param valorOrigenProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarOrigenProveedor(ProveedorVO proveedorVO, String valorOrigenProveedor) throws SICException;


	/**
	 * 
	 * @param proveedorVO
	 * @param contactosRelacionados
	 * @return
	 * @throws SICException
	 */
	ValidacionOrigenProveedor validarOrigenNacionalImportado(ProveedorVO proveedorVO, Collection<DatoContactoPersonaLocalizacionDTO> contactosRelacionados) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Boolean validarCaracteristicaEsInterproveedor(Integer codigoCompania, String codigoProveedor) throws SICException;
}
