package ec.com.smx.sic.cliente.persistencia.bodega.recepcion.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoRecepcionDTO;

/**
 * Interface para consultar un articulo con las ordenes de compra enviadas y planificadas de un pallet de recepcion 
 * 
 * @author acaiza
 *
 */
public interface IArticulosRecibidosPalletDAO {
	
	/**
	 * Consulta una coleccion de vistas que contiene las ordenes de compra recibidas en el pallet
	 * @param codigoCompania
	 * @param codigoBarrasPalet
	 * @param codigoTarea
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaArticuloUnidadManejoRecepcionDTO> obtenerArticulosRecibidosPallet(Integer codigoCompania, Long codigoRecepcionProveedor, DatosTareaDTO datosTareaDTO, Long codigoTarea)throws SICException;
	
	/**
	 * 
	 * @param codigoBarrasPallet
	 * @return
	 * @throws SICException
	 */
	public DatosTareaDTO consultarDatosTareaPorCodigoBarrasPallet(String codigoBarrasPallet) throws SICException;
	
}
