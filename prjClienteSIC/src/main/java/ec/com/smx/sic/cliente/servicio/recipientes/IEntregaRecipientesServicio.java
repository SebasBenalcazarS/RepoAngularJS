package ec.com.smx.sic.cliente.servicio.recipientes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenSalidaControlRecipienteDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenSalidaRecipienteDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecipienteCabeceraEntregaTrasient;
import ec.com.smx.sic.cliente.mdl.nopersistente.TareaEntregaRecipientesTrasient;
/**
 * Servicios de entrega de recipientes a proveedor
 * @author cherrera
 *
 */
public interface IEntregaRecipientesServicio extends Serializable {

	/**
	 * M\u00E9todo que b\u00FAsca las cabeceras de la entrega de acuerdo a los filtros
	 * @param componentesMap
	 * @return
	 */
	public Collection<RecipienteCabeceraEntregaTrasient> obtenerCabeceraEntregaRecipiente(Map<String, Object> componentesMap);
	
	/**
	 * M\u00E9todo que b\u00FAsca los recipientes a entregar por proveedor
	 * @param codigoControlRecipiente
	 * @return
	 */
	public Collection<ControlRecipienteDetalleDTO> findEntregaRecipienteDetalle(Collection<Long> idsConRecCol);
	
	/**
	 * Se asigna una tarea a un funcionario para la entrega de recipientes
	 * @param userId
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @param codigoRecepcionProveedor
	 * @param codigoFuncionario
	 * @param codigoPerfil
	 * @return
	 */
	public TareaDTO creacionMotorTareaEntregaRecipientes (String userId, 
														  Integer codigoCompania, 
														  String codigoProveedor,
														  Long codigoRecepcionProveedor,
														  String codigoFuncionario,
														  String codigoPerfil,
														  Collection<RecipienteCabeceraEntregaTrasient> recipientesCol,
														  Integer codigoAreaTrabajo);
	
	/**
	 * Crea la orden de salida de recipientes con sus detalles
	 * @param userId
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param recipientesCol
	 * @param codigoAreaTrabajo
	 */
	public OrdenSalidaRecipienteDTO creacionOrdenSalida(String userId, 
									  Integer codigoCompania, 
									  Long  codigoProcesoLogistico,
									  Collection<RecipienteCabeceraEntregaTrasient> recipientesCol,
									  Integer codigoAreaTrabajo);
									
	/**
	 * 
	 * @param userId
	 * @param codigoCompania
	 * @return
	 */
	public ProcesoLogisticoDTO creacionProcesoLogisticoEntregaRecipientes(String userId, 
																		  Integer codigoCompania);
	
	/**
	 * Busca todas las tareas estado creadas para mostrarse en el monitor de tareas
	 * @return
	 */
	public Collection<TareaEntregaRecipientesTrasient> buscarTareasEstadoRecipientes();
	
	/**
     * Busca los funcionarios que tengan el perfil de despachador
     * @param codigoCompania
     * @param profileId
     * @return
     * @throws SICException
     */
    public Collection<FuncionarioDTO> obtenerFuncionariosTarea(Integer codigoCompania,  Integer referenceCode, String usuario, String nombreUsuario) throws SICException;
   
    /**
    *  
    * @param ordenSalida
    * @param recipientesCol
    * @return
    */
    public Collection<OrdenSalidaControlRecipienteDetalleDTO> creacionOrdSalConRecDetCol(OrdenSalidaRecipienteDTO ordenSalida,
			  																	 Collection<RecipienteCabeceraEntregaTrasient> recipientesCol);
    
}
