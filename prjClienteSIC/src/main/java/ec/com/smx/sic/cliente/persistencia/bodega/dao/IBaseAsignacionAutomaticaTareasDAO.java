package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.Map;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFuncionarioPerfilDTO;

public interface IBaseAsignacionAutomaticaTareasDAO {
	
	/**
	 * Retorna todos los funcionarios activos con perfil de recibidor validando: el referenceCode, si es perfil por defecto y al &aacute;rea de trabajo
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaSublugarTrabajo
	 */
	public Collection<VistaFuncionarioPerfilDTO> obtenerFuncionariosRecibidores(Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo) throws SICException;
	
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
	public Collection<FuncionarioDTO> obtenerFuncionariosOcupados(Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo, Long codigoTipoTareaPerfil) throws SICException;

	
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
	 * Obtiene el funcionario con el total de recepciones asignadas
	 * @param tipoTareaPerfilDTO
	 * @param codigosFuncionarios
	 * @throws SICException
	 */
	public Map<String, Integer> obtenerNumeroRecepcionesAsignadas(Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoAreaSublugarTrabajo, Long codigoTipoTareaPerfil) throws SICException;
}
