package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionCantidadOrdenCompraDetalleEstadoDTO;

public interface IVistaRecepcionCantidadOrdenCompraDetalleEstadoDAO {
	
	/**
	 * Retorna una coleccion con las cantidades recibidas cada orden de compra
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaRecepcionCantidadOrdenCompraDetalleEstadoDTO> obtenerCantidadesRecibidas(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;
	
	/**
	 * Resta las cantidades recibidas de la OCDE ENV
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param cantidadRecibida
	 * @throws SICException
	 */
	public void actualizarCantidadesOrdenCompraDetalleEstadoENV(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, Integer cantidadRecibida) throws SICException;
	
	/**
	 * Resta las cantidades recibidas de la OCDE PEN
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param cantidadRecibida
	 * @param codigoProcesoLogistico
	 * @throws SICException
	 */
	public void actualizarCantidadesOrdenCompraDetalleEstadoPEN(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, Integer cantidadRecibida, Long codigoProcesoLogistico) throws SICException; 

}
