/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.despacho.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioPerfilDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.FuncionarioPerfilDetalleSeccionDTO;

/**
 * @author jdvasquez
 *
 */
public interface IAlmacenamientoConfiguracionSeccionesTrabajoGestor {
	/**
	 * Guarda la relacion de funcionario con seccion
	 * @param codigoCompania
	 * @param userId
	 * @param codigoDetalleSeccion
	 * @param listaFuncionarioPerfilDTO
	 * @throws SICException
	 */
	public void guardarRelacionFuncionarioSeccion(Integer codigoCompania, String userId, Long codigoDetalleSeccion, Collection<FuncionarioPerfilDTO> listaFuncionarioPerfilDTO) throws SICException;
	/**
	 * Desactiva la relacion de funcionario con seccion
	 * @param listaFuncionarioSeccionDTO
	 * @throws SICException
	 */
	public void desactivarRelacionFuncionarioSeccion(Integer codigoCompania, Collection<FuncionarioPerfilDetalleSeccionDTO> listaFuncionarioSeccionDTO) throws SICException;
	/**
	 *  Guarda la relacion de funcionario con area trabajo
	 * @param codigoCompania
	 * @param userId
	 * @param codigoAreaTrabajo
	 * @param listaFuncionarioPerfilDTO
	 * @throws SICException
	 */
	public void guardarRelacionFuncionarioAreaTrabajo(Integer codigoCompania, String userId, Integer codigoAreaTrabajo, Collection<FuncionarioPerfilDTO> listaFuncionarioPerfilDTO) throws SICException;
	/**
	 * Desactiva la relacion de funcionario con area trabajo
	 * @param codigoCompania
	 * @param userId
	 * @param codigoAreaTrabajo
	 * @param codigoFuncionario
	 * @throws SICException
	 */
	public void desactivarRelacionFuncionarioAreaTrabajo(Integer codigoCompania, String userId, Integer codigoAreaTrabajo, String codigoFuncionario) throws SICException;

}
