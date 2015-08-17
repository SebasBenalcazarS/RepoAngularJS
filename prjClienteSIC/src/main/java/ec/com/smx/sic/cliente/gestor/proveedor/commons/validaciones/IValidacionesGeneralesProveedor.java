package ec.com.smx.sic.cliente.gestor.proveedor.commons.validaciones;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidad;
import ec.com.smx.sic.cliente.mdl.vo.EntidadVO;

public interface IValidacionesGeneralesProveedor {

	/**
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	Boolean existeEntidadProveedor(EntidadVO<? extends IBaseEntidad> entidadVO) throws SICException;
	
	/**
	 * 
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	Boolean existePersonaProveedor(EntidadVO<? extends IBaseEntidad> entidadVO) throws SICException;
	
	/**
	 * @param proveedorVO
	 * @return
	 * @throws SICException
	 */
	Boolean existeLocalizacionProveedor(EntidadVO<? extends IBaseEntidad> entidadVO) throws SICException;
	
	
	/**
	 * 
	 * @param entidadVO
	 * @return
	 * @throws SICException
	 */
	Boolean existeEmpresaProveedor(EntidadVO<? extends IBaseEntidad> entidadVO) throws SICException;
	
	/**
	 * 
	 * @return
	 * @throws SICException
	 */
	Boolean esActivaContingenciaBaseFinanciera() throws SICException;
	
	/**
	 * @param proveedores
	 * @return Tipos de entidad con sus respectivos codigos
	 * @throws SICException
	 */
	Map<String, Set<Long>> obtenerCodigosEntidadesAgrupados(Collection<VistaProveedorDTO> proveedores) throws SICException;
	
	
}
