package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDetalleSeccionDTO;

/**
 * 
 * @author cortiz
 *
 */

public interface IProveedorDetalleSeccionDAO {

	/**
	 * Metodo actualiza el estado de la relacion entre andenes y proveedores
	 * @param provDet
	 * @throws SICException
	 */
	public void actualizacionRelacionProveedorDetalle(ProveedorDetalleSeccionDTO provDet) throws SICException;
	
	/**
	 * Busqueda de proveedores relacionados a un detaleSeccion anden 
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Collection<ProveedorDetalleSeccionDTO> busquedaAndenProveedor(DetalleSeccionDTO anden)throws SICException;
	
	/**
	 * Devuelve true si el anden ingresado tiene hijos proveedores.
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	public Boolean existeProveedoresAsignados(DetalleSeccionDTO anden)throws SICException;
}
