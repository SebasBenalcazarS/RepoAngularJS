package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author wcaiza
 *
 */
public interface IValidacionTareasRecesoFuncionarioGestor {
	
	/**
	 * Validar que se tengan todos los par&aacute;metros obligarios para realizar la consulta
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param codigoPerfil
	 * @param colCatalogoValorEstadoTarea
	 * @throws SICException Se lanza si falta alg&uacute;n par&aacute;metro
	 */
	void validarObtenerTareasPorFuncionarioYEstadoTarea(Integer codigoCompania, String codigoFuncionario, String codigoPerfil, Collection<String> colCatalogoValorEstadoTarea) throws SICException;
	
	/**
	 * Validar que se tengan todos los par&aacute;metros obligarios para poder finalizar la tarea del funcionario
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param userId
	 * @param codigoPerfil
	 * @throws SICException
	 */
	void validarFinalizarTareaFuncionario(Integer codigoCompania, String codigoFuncionario, String userId, String codigoPerfil) throws SICException;
	
}