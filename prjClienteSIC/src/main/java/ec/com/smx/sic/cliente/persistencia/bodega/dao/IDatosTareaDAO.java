package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioSublugarTrabajoRelacionadoDTO;
import ec.com.smx.sic.cliente.common.bodega.EnumTotalesPallets;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaResumenPalletsNavesSubnaves;

public interface IDatosTareaDAO {

	
	/**
	 * Finaliza el estado de un tarea estado
	 * 
	 * @param tareaEstadoDTO
	 * @param usuario
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void finalizarEstadoDatosTareaEstado(DatosTareaEstadoDTO datosTareaEstadoDTO, String usuario) throws SICException;
	
	/**
	 * Actualiza el estado del datos tarea con su ultimo estado de datos tarea estado
	 * 
	 * @param secuencialDatosTarea
	 * @param estado
	 * @throws SICException
	 */
	void actualizarEstadoActualDatosTarea(Long secuencialDatosTarea, CatalogoValorDTO estado) throws SICException;
	
	/**
	 * 
	 * @param datosTarea
	 * @param estadosExcluir
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerDatosTareaCol(DatosTareaDTO datosTarea, Collection<String> estadosExcluir) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obteberPalletsRecepcion(Integer codigoCompania, Long codigoProcesoLogistico) throws SICException;

	/**
	 * 
	 * @param palletActualizar
	 * @return
	 * @throws SICException
	 */
	void actualizarDatosPallet(DatosTareaDTO palletActualizar) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO obtenerPalletPorId(Integer codigoCompania, Long codigoDatosTarea) throws SICException;
	
	/**
	 * Metodo para obtener el estado actual del pallet
	 * @param codigoCompania
	 * @param codigoBarrasPallets
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerEstadoActualPallet(Integer codigoCompania, Collection<String> codigoBarrasPallets) throws SICException;
	
	/**
	 * Obtener {@link DatosTareaDTO} por el codigo de tarea 
	 * @param codigoCompania
	 * @param codigoTarea
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO obtenerDatosTareaPorCodigoTarea(Integer codigoCompania, Long codigoTarea, String codigoBarras) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @param funcionarioAreaTrabajoDTO
	 * @param funSubTraRel
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerPalletsRecolectar(Integer codigoCompania, String codigoBarras, String codigoFuncionario,Collection<DetalleSeccionDTO> andenesAsignados) throws SICException;
	
	/**
	 * Obtener la lista de pallets asignados a un recolector
	 * @param funcionarioSubTraRel
	 * @param codigoTipoTareaPerfilDTO
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerPalletsAsignadosRecolector(FuncionarioSublugarTrabajoRelacionadoDTO funcionarioSubTraRel, Long codigoTipoTareaPerfilDTO) throws SICException; 
	
	/**
	 * <b>  Obtener la lista de tareas para el recolector<b>
	 * <p>
	 * [Author: lguaman, Date: 19/11/2014]
	 * @param funSubTarRel
	 * @param codigoTipoTareaPerfil
	 * @param codigoBarrasPallet
	 * @return
	 */
//	Collection<VistaTareaDatosTareaDTO> obtenerDatosTareaRecolector(FuncionarioSublugarTrabajoRelacionadoDTO funSubTarRel, Long codigoTipoTareaPerfil, Collection<String> codigoBarrasPallet);
	
	
	/**
	 * Obtener los pallet que esten en una lista de andenes
	 * @param codigoCompania
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> palletInAnden(Integer codigoCompania, Collection<DetalleSeccionDTO> anden);
	
	/**
	 * Obtener los pallet que esten en una lista de andenes
	 * @param codigoCompania
	 * @param anden
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> palletInAndenPorCodigoAnden(Integer codigoCompania, Collection<Long> anden);
	
	/**
	 * Obtener datos tarea, donde hay pallets, de acuerdo a la compania y los andenes a los que esta asignado, limitado por maxResults.
	 * @param codigoCompania
	 * @param anden
	 * @param maxResults si es diferente de null y mayor a cero limita los resultados caso contrario no.
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> palletRangoAndenes(Integer codigoCompania, Collection<DetalleSeccionDTO> anden,Integer maxResults) throws SICException;
	
	/**
	 * Obtiene el registro de datosTareaDTO de acuerdo a la compania, los andenes a los que esta asignado y el
	 * pallet. Retorna null si el pallet no esta en los andenes asignados.
	 * @param codigoCompania
	 * @param anden
	 * @param codigoBarrasPallet
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO palletPerteneceRangoAndenes(Integer codigoCompania, Collection<DetalleSeccionDTO> anden,String codigoBarrasPallet) throws SICException;
	
	/**
	 * Sirve para obtener el resumen de pallets pendientes para las naves y/o subnaves de las areas de trabajo enviadas como parametros
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaTrabajoBodega
	 * @param codigoAreaTrabajoSubbodega
	 * @param codigoReferenciaTipoTarea
	 * @param incluyeSubnaves sirve para hacer la consulta agrupada por naves y subnaves si es true, si es false agrupada solo por naves
	 * @return
	 * @throws SICException
	 */
	Collection<VistaResumenPalletsNavesSubnaves> resumenPalletsPendientesNaveSubnave(Integer codigoCompania,Integer codigoAreaTrabajo,Integer codigoAreaTrabajoBodega,Integer codigoAreaTrabajoSubbodega,String codigoReferenciaTipoTarea,boolean incluyeSubnaves) throws SICException;
	
	/**
	 * Sirve para sacar el total de pallets de acuerdo a EnumTotalesPallets en el día actual
	 * TOTAL_TOTAL el total de pallets recibidos
	 * TOTAL_ANDEN el total de pallets que se encuentran en anden
	 * TOTAL_EN_PROCESO el total de pallets que se encuentran en proceso
     * TOTAL_TERMINADO el totoal de pallets que estan terminados
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaTrabajoBodega
	 * @param codigoAreaTrabajoSubbodega
	 * @param total
	 * @return
	 * @throws SICException
	 */
	Long obtenerTotalPalletsCriterios(Integer codigoCompania,Integer codigoAreaTrabajo,Integer codigoAreaTrabajoBodega,Integer codigoAreaTrabajoSubbodega,EnumTotalesPallets total) throws SICException;
}