package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BalanzaDetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

/**
 * 
 * @author cortiz
 *
 */

public interface IBalanzaDetalleSeccionDAO {


	/**
	 * Metodo para actualizar el detalle balanza
	 * @param detalleSeccionBalanzaDTO
	 * @throws SICException
	 */
	public void actualizarDetalleBalanza(DetalleSeccionDTO detalleSeccionBalanzaDTO) throws SICException;

	/**
	 * Devuelve true si encuentra una balanza que este activa y tenga la direccion ip de la plantilla
	 * @param balDetSecDTO
	 * @return
	 */
	public Boolean existeDetalleBalanza(BalanzaDetalleSeccionDTO balDetSecDTO)throws SICException;
	
	/**
	 * devuelve un detalle del detalle seccion de la balanza si el id conincide con la plantilla
	 * @param balDetSecDTO
	 * @return
	 */
	public BalanzaDetalleSeccionDTO obtenerDetalleBalanza(BalanzaDetalleSeccionDTO balDetSecDTO)throws SICException;
	
	
}
