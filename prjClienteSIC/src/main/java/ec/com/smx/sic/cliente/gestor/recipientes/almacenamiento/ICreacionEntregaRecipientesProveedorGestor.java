package ec.com.smx.sic.cliente.gestor.recipientes.almacenamiento;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.OrdenSalidaControlRecipienteDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenSalidaRecipienteDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.RecipienteCabeceraEntregaTrasient;

/**
 * 
 * @author amunoz
 *
 */
public interface ICreacionEntregaRecipientesProveedorGestor  extends Serializable {
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
    *  
    * @param ordenSalida
    * @param recipientesCol
    * @return
    */
    public Collection<OrdenSalidaControlRecipienteDetalleDTO> creacionOrdSalConRecDetCol(OrdenSalidaRecipienteDTO ordenSalida,
			  																	 Collection<RecipienteCabeceraEntregaTrasient> recipientesCol);
 
}
