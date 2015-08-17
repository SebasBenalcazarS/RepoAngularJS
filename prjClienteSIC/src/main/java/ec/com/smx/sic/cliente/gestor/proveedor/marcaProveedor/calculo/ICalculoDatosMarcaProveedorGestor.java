package ec.com.smx.sic.cliente.gestor.proveedor.marcaProveedor.calculo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.MarcaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorMarcaDTO;

public interface ICalculoDatosMarcaProveedorGestor extends Serializable {
	
	/**
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return Collection<ProveedorMarcaDTO>
	 * @throws SICException
	 */
	public Collection<ProveedorMarcaDTO> obtenerTotalDatosProveedorMarca(Integer codigoCompania, String codigoProveedor) throws SICException;
	/**
	 * Este método devuelve las marcas del proveedor ingresado pero en base a las marcas que tiene asignado el funcinario logueado
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorMarcaDTO> obtenerProveedorMarcaFuncionario(Integer codigoCompania, String userId, Set<String> codigoProveedor) throws SICException;

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
}
