package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorRelacionadoDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;


/**
 * 
 * @author acaiza
 *
 */
public interface IAlmacenamientoRecepcionTareasGestor {
	
	/**
	 * Crea una tarea tipo montacarguista 
	 * 
	 * @param datosTareaDTO Datos de la tarea
	 * @param funcionarioSubTraRel
	 * @return Excepcion en caso de producirse un error
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void crearTareaMontacarguista(DatosTareaDTO datosTareaRecolectorDTO, FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 * Crea una tarea tipo recolector 
	 * 
	 * @param datosTareaDTO
	 * @param detalleTareaDTO
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO crearTareaRecolector(DatosTareaDTO datosTareaDTO, DetalleTareaDTO detalleTareaDTO, Long codigoProceso) throws SICException;

	/**
	 * Crea una tarea tipo recibidor 
	 * 
	 * @param andenes
	 * @param recepcionProveedor
	 * @return Excepcion en caso de producirse un error
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	TareaDTO crearTareaRecibidor(Collection<DetalleSeccionDTO> andenes, RecepcionProveedorDTO recepcionProveedor) throws SICException;
	
	/**
	 * Registra andenes a la tarea de recepci&oacute;n
	 * @param andenes
	 * @param recepcionProveedor
	 * @param tareaDTO
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleTareaDTO> registrarAndenesTareaRecepcion(Collection<DetalleSeccionDTO> andenes, RecepcionProveedorDTO recepcionProveedor, TareaDTO tareaDTO) throws SICException;
	/**
	 * Crear tarea de recepcion
	 * @param tareaDTO
	 * @return
	 * @throws SICException
	 */
	TareaDTO crearTarea(TareaDTO tareaDTO, CatalogoValorRelacionadoDTO catalogoValorRelacionadoDTO)throws SICException;

	/**
	 * Crea el detalle del pallet con las cantidades que se afectaron en el detalle de las ordenes de compra 
	 * @param ordenCompraDetalleEstadoDTOs
	 * @param datosTarea
	 * @return Excepcion en caso de producirse un error
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void crearDetallePallet(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs, DatosTareaDTO datosTarea) throws SICException;

	/**
	 * Envia a finalizar y preasignar las tareas del recolector.
	 * @param tareaRecolector 
	 * @param codigoDatosTarea
	 * @param valorTipoMarca
	 * @param artUniManRecepcion
	 * @param codigoAreaTrabajoBodega
	 * @param codigoDetalleSeccionOrigen
	 * @return Excepcion en caso de producirse un error
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	DetalleTareaDTO procesarTareasRecepcion(TareaDTO tareaRecolector, Long codigoDatosTarea, String valorTipoMarca, ArticuloUnidadManejoDTO artUniManRecepcion, Integer codigoAreaTrabajoBodega, Long codigoDetalleSeccionOrigen);
	
	/**
	 * Crear relacion del pallet con la tarea del recibidor
	 * @param codigoCompania
	 * @param codigoTarea
	 * @param codigoDatosTarea
	 * @param idUsuarioRegistro
	 */
	void crearTareaDatosTareaRecibidor(DatosTareaDTO datosTareaDTO, Long codigoTarea);
	
}
