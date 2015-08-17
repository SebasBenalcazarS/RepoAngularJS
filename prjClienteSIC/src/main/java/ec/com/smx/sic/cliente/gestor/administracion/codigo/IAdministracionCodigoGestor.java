/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.administracion.codigo;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author jvillacis
 *
 */
public interface IAdministracionCodigoGestor<T> extends Serializable {
	
	/**
	 * 
	 * @param idCodigo
	 * @return
	 */
	public T generarCodigo(Object... parametros) throws SICException;
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean validarCodigo(T codigo) throws SICException;
}
