package ec.com.smx.sic.cliente.servicio.marcaProveedor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.common.proveedor.ResultadoValidacionProveedor;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;
import ec.com.smx.sic.cliente.mdl.vo.ProveedorVO;


public interface IMarcaProveedorServicio extends Serializable {

	/**
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return Collection<ProveedorMarcaDTO>
	 * @throws SICException
	 */
	public Collection<ProveedorMarcaDTO> obtenerTotalDatosProveedorMarca(Integer codigoCompania, String codigoProveedor) throws SICException;
	
	/**
	 * Metodo que permite obtener las marcas de un proveedor
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param userId
	 * @return Collection<ProveedorMarcaDTO>
	 * @throws SICException
	 */
	public Collection<ProveedorMarcaDTO> obtenerProveedorMarcaFuncionario(Integer codigoCompania, Set<String>  codigoProveedor, String userId) throws SICException;
	
	/**
	 * @param marcaActivaSeleccionada
	 * @param proveedorVO
	 * @return Collection<MarcaArticuloDTO>
	 * @throws SICException
	 */
	public Collection<MarcaArticuloDTO> obtenerMarcasConArticulos(Collection<ProveedorMarcaDTO> marcaActivaSeleccionada, String codigoProveedor) throws SICException;
	
	/**
	 * @param marcasNuevas
	 * @param codigoProveedor
	 * @param user
	 * @return ProveedorMarcaDTO
	 * @throws SICException
	 */
	public ProveedorMarcaDTO obtenerProveedorMarcaNueva(MarcaArticuloDTO marcasNuevas, String codigoProveedor, String userId) throws SICException;
	
	/**
	 * Guardar los datos de las marcas de proveedor modificadas
	 * @param proveedorVO
	 * @param proveedorMarcaTotal
	 * @param proveedorMarcaRegistrar
	 * @throws SICException
	 */
	public void guardarDatosProveedorMarca(ProveedorVO proveedorVO, ResultadoValidacionProveedor resultadoValidacionProveedor,
			Collection<ProveedorMarcaDTO> proveedorMarcaTotal, Collection<ProveedorMarcaDTO> proveedorMarcaRegistrar) throws Exception;
}
