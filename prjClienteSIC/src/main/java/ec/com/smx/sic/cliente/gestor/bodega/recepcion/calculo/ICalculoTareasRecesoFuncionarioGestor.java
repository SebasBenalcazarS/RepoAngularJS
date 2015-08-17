/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Date;

import ec.com.smx.corpv2.dto.FuncionarioLogisticoDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

/**
 * @author wcaiza
 *
 */
public interface ICalculoTareasRecesoFuncionarioGestor extends Logeable {
	
	/**
	 * Obtener {@link FuncionarioLogisticoDTO}, por el catalogo que califica al tipo tarea o por el codigo del funcionario
	 * @param codigoCompania
	 * @param catalogoTipoEstadoUsuario
	 * @param catalogoValorEstadoUsuario
	 * @param colCodigoFuncionario
	 * @return
	 * @throws SICException
	 */
	Collection<FuncionarioLogisticoDTO> obtenerFuncionarioLogisticoPorCodFuncionario (Integer codigoCompania, Integer catalogoTipoEstadoUsuario, String catalogoValorEstadoUsuario, String ... colCodigoFuncionario) throws SICException;
	
	
	/**
	 * Obtener la tarea de receso de un funcionario si esta sin finalizar.
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareaRecesoPorFuncionarioEnProceso(Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda) throws SICException;
	
	/**
	 * Contar las tareas en estado activo que un funcionario tiene asociadas por el catalogovalor del estado de la tarea
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @param codigoPerfil
	 * @param catalogoTipoEstadoTarea
	 * @param colCatalogoValorEstadoTarea
	 * @return
	 * @throws SICException
	 */
	Collection<TareaDTO> obtenerTareasPorFuncionarioYEstadoTarea(Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda, String codigoPerfil, Integer catalogoTipoEstadoTarea, Collection<String> colCatalogoValorEstadoTarea) throws SICException;
	
}
