package ec.com.smx.sic.cliente.gestor.bodega.administracion.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;

/**
 * @author dalmeida
 *
 */
public interface IAlmacenamientoBodegaGestor {
	
	/**
	 * Permite registrar una seccion
	 * @param seccionDTO
	 * @throws SICException
	 */
	public void registrarSeccion(SeccionDTO seccionDTO) throws SICException;
	
	/**
	 * Permite crear una bodega
	 * @param bodegaDTO
	 * @throws SICException
	 */
	public void registrarBodega(BodegaDTO bodegaDTO) throws SICException;
	
	/**
	 * Permite registrar ubicacion
	 * @param seccionDTO
	 * @throws SICException
	 */
	
	public void registrarUbicacion(SeccionDTO seccionDTO) throws SICException;
	
}
