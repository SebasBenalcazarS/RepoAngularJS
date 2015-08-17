package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.CantidadCuponLocal;

public interface IArticuloLocalDAO {

	/**
	 * 
	 * @param articuloLocalDTO
	 * @throws SICException
	 */
	public abstract void actualizarEstadoPorArticulo(Integer codigoCompania, String codigoArticulo, String estado, String userId, Collection<Integer> codigosLocal) throws SICException;

	/**
	 * 
	 * @param locales
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return
	 * @throws SICException
	 */
	public Collection<CantidadCuponLocal> obtenerCantidadCuponesLocal(Collection<Integer> locales, Date fechaInicial, Date fechaFinal) throws SICException;
	
	/**
	 * 
	 * @param articuloLocalDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloLocalDTO> obtenerArticuloLocal(Integer codigoCompania, String codigoArticulo) throws SICException;
	
}