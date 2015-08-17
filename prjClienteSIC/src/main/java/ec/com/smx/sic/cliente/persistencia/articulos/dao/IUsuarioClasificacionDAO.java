package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;

public interface IUsuarioClasificacionDAO {

	/**
	 * Funcion para desactivar las clasificaciones de un grupo de usuarios
	 * @param funcionarios
	 * @param clasificaciones
	 * @throws SICException
	 */
	public abstract void desactivarEstadoPorClasificacionUsuario(Collection<String> usuarios, Collection<String> clasificaciones, int compania) throws SICException;

}