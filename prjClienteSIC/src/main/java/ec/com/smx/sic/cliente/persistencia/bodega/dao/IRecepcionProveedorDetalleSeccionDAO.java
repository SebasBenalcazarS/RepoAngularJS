package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDetalleSeccionDTO;

public interface IRecepcionProveedorDetalleSeccionDAO {
	
	Collection<RecepcionProveedorDetalleSeccionDTO> andenConTiempoDeRecepcion(Integer codigoCompania, Collection<DetalleSeccionDTO> anden);
	
	/**
	 * Liberar Anden.
	 * @author Yuniesky Armentero Moreno
	 * @param listarpds
	 */
	void liberarAnden(Collection<Long> listarpds);
	
	public Collection<Long> obtenerSecuencialRecepcionProveedorDetalleSeccion(Integer codigoCompania, Long codigoRecepcionProveedor, Collection<Long> colCodigoDetalleSeccion) throws SICException;

	/**
	 * Cambiar el estado de los RecepcionProveedorDetalleSeccionDTO.
	 * 
	 * @author Yuniesky Armentero Moreno
	 * @param listarpds
	 * @param estado
	 */
	public void cambiarEstado(Collection<Long> listarpds, String estado) throws SICException;
	
	/**
	 * Cambiar el estado de los RecepcionProveedorDetalleSeccionDTO por la RecepcionProveedor.
	 * 
	 * @author Yuniesky Armentero Moreno
	 * @param recepcionProveedor
	 * @param estado
	 */
	public void cambiarEstado(RecepcionProveedorDTO recepcionProveedor, String estado) throws SICException;
}
