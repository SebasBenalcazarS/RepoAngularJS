package ec.com.smx.sic.cliente.gestor.bodega.factura.digital.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFuncionarioPerfilDTO;

/**
 * @author dalmeida
 *
 */
public interface IAsignacionAutomaticaTareasGestor {
	
	/**
	 * Tareas que tienen un proceso log&iacute;stico registrado con fechaFin = null y codigoCatalogoValorRelacionado = 'REG'
	 * y que tiene en la TareaEstado fechaFin = null y codigoCatalogoValorRelacionado = 'REG'. Filtradas por &aacute;rea de trabajo y de perfil
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoPerfil
	 * @return
	 * @throws SICException
	 */
	public Collection<TareaDTO> obtenerTareasParaAsignar(Integer codigoCompania, Integer codigoAreaTrabajo, Long codigoPerfil) throws SICException;
	
	
	/**
	 * Retorna todos los funcionarios activos con perfil de recibidor validando: el referenceCode, si es perfil por defecto y al &aacute;rea de trabajo
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaSublugarTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaFuncionarioPerfilDTO> obtenerFuncionariosRecibidores(Integer codigoCompania,Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo)throws SICException;
	
	/**
	 * Retorna los funcionarios ocupados del &aacute;rea de trabajo enviado que tienen proceso log&iacute;stico estado 
	 * con fechaFin = null y cuyo codigoCatalogoValorRelacionado no est&aacute; en: 'REG','TER','FAC'. 
	 * Y que tienen en su tarea estado relacionada, fechaFin = null y su codigoCatalogoValorRelacionado no es igual a 'REG'
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaSublugarTrabajo
	 * @param codigoTipoTareaPerfil
	 * @return
	 * @throws SICException
	 */
	public Collection<FuncionarioDTO> obtenerFuncionariosOcupados(Integer codigoCompania,Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo, Long codigoTipoTareaPerfil) throws SICException;
	
	/**
	 * Resultado de remover los funcionarios ocupados de los funcionarios con perfil de recibidor
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaSublugarTrabajo 
	 * @return
	 * @throws SICException
	 */
	public  Collection<VistaFuncionarioPerfilDTO> obtenerFuncionariosRecepcionDisponibles(Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo)throws SICException;
	
	/**
	 * Permite la asignaci&oacute;n de funcionarios con perfil de recibidor disponibles a tareas en estado: 'REG'
	 * @param codigoCompania
	 * @param codigoCd
	 * @param codigoBodega
	 * @param codigoSubBodega
	 * @param codigoPerfil
	 * @throws SICException
	 */
	public abstract void asignarTareasFuncionario(Integer codigoCompania, Integer codigoCd, Integer codigoBodega, Integer codigoSubBodega, Long codigoPerfil) throws SICException;
	
	/**
	 * Retorna una lista con todos los funcionarios recibidores, tambi&eacute;n identifica cuales est&aacute;n ocupados
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaSublugarTrabajo
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaFuncionarioPerfilDTO> obtenerFuncionariosRecibidorRecepcion(Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo) throws SICException;
	
}
