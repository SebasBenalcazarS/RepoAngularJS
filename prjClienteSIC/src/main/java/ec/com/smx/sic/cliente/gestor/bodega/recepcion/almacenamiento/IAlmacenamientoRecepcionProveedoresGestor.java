package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.plantillas.dto.GrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.frameworkv2.multicompany.dto.UserCompanySystemDto;
import ec.com.smx.sic.cliente.common.bodega.EnumTipoRecepcion;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoAutorizacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFuncionarioPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaOrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;


/**
 * 
 * @author acaiza
 *
 */
public interface IAlmacenamientoRecepcionProveedoresGestor {
	
	RecepcionProveedorDTO registrarRecepcionJuguetes(RecepcionProveedorDTO recepcionProveedorDTO, EntregaDTO entrega) throws SICException;
	
	void removerPalet(TareaDTO tareaRecolector, RecepcionProveedorDTO recepcionProveedorDTO, String codigoBarrasPalet, Long codigoAutorizacion, String codigoSistema) throws SICException;
	
	/**
	 * @param recepcionEnProceso
	 * @param detalleTareaDTO
	 * @param datosTarea
	 * @param artUniManRecepcion
	 * @param cantidadPallet
	 * @param actualizarUniMan
	 * @param valorMaximoAlmacenar
	 * @throws SICException
	 */
	void recibirArticulo(TareaDTO tareaSeleccionada, DetalleTareaDTO detalleTareaDTO, DatosTareaDTO datosTarea,
			ArticuloUnidadManejoDTO artUniManRecepcion,	Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol) throws SICException;
//	void recibirArticulo(RecepcionProveedorDTO recepcionEnProceso, DetalleTareaDTO detalleTareaDTO, DatosTareaDTO datosTarea,
//			ArticuloUnidadManejoDTO artUniManRecepcion, Integer cantidadPallet, BigDecimal pesoPallet, String tipoControlCosto,
//			Boolean actualizarUniMan, Integer valorMaximoAlmacenar, Collection<ControlRecipienteTaraDetalleDTO> 
//			controlRecipienteTaraDetallesCol, Long codigoProceso) throws SICException;
//	
	/**
	 * 
	 * @param tareaDTO
	 * @param recepcion
	 * @param datosTarea
	 * @param cantidadRecibir
	 * @param codigoDatosTarea
	 * @param codigoAutorizacion
	 * @param codigoSistema
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void modificarPallet(TareaDTO tareaDTO, RecepcionProveedorDTO recepcion, DatosTareaDTO datosTarea, Integer cantidadRecibir, BigDecimal pesoRecibir, String tipoControlCosto, Long codigoDatosTarea, Long codigoAutorizacion, String codigoSistema)throws SICException;

	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @param andenes
	 * @param listaEntregas
	 * @param listaFacturaEstadoTemporal
	 * @param funcionarioPerfil
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<RecepcionProveedorDTO> iniciarRecepcionProveedor(RecepcionProveedorDTO recepcionProveedorDTO, Collection<DetalleSeccionDTO> andenes, Collection<EntregaDTO> listaEntregas, Collection<FacturaEstadoDTO> listaFacturaEstadoTemporal, VistaFuncionarioPerfilDTO funcionarioPerfil) throws SICException;
	
	/**
	 * Registrar las tablas cabecera para la recepci&oacute;n del proveedor
	 * @param listaEntregas
	 * @param plantillaRecepcion
	 * @return
	 * @throws SICException
	 */
	RecepcionProveedorDTO registrarProveedorRecepcionEntrega(Collection<EntregaDTO> listaEntregas, RecepcionProveedorDTO plantillaRecepcion) throws SICException;
	
	/**
	 * M&eacute;todo que crea la transacion de un proceso logistico tipo recepci&oacute;n
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param codigoTipoTransaccion
	 * @param catalogoTipoRecepcion
	 * @param userID
	 * @throws SICException
	 */
	void crearProcesoLogisticoTransaccion(Integer codigoCompania, Long codigoProcesoLogistico, Integer codigoTipoTransaccion, CatalogoValorDTO catalogoTipoRecepcion,  String userID) throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorVO 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	//public DetalleRecepcionEntregaDTO registrarDetalleRecepcionEntrega(RecepcionProveedorVO recepcionProveedorVO) throws SICException;
	DetalleRecepcionEntregaDTO 
		registrarDetalleRecepcionEntrega(Collection<EntregaDTO> entregaDTOs, ValorConfiguracionPlantillaDTO valorConfiguracionPlantillaDTO,  
				String placa, Time hora, EnumTipoRecepcion tipoRecepcion, DetalleSeccionDTO anden, Collection<GrupoCampoPlantillaDTO> preguntasAutorizar, UserCompanySystemDto informacionUsuario) 
						throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorVO 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	abstract void registrarFurgonProveedorRecepcion(RecepcionProveedorVO recepcionProveedorVO) throws SICException;
	
	/**
	 * Registra los furgones de cada uno de los proveedores para la recepcion 
	 * 
	 * @param recepcionProveedorVOs Lista de recepciones  con varios proveedores
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	abstract void registrarFurgonProveedorRecepcion(RecepcionProveedorVO recepcionProveedorVO, Collection<VistaProveedorDTO> vistaProveedorDTOs) throws SICException;
	
	/**
	 * Permite asignar el valor del anden a un furg&oacute;n cuya solicitud de autorizaci&oacute;n ha sido aprobada
	 * 
	 * @param detalleSeccionDTO Un RecepcionProveedorVO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	abstract void registrarAndenDetalleRecepcionEntrega(RecepcionProveedorVO recepcionProveedorVO) throws SICException;
	
	/**
	 * Eliminar de la BD, recepci&oacute;n proveedor
	 * @param colProcesoLogistico
	 * @throws SICException
	 */
	void eliminarRecepcionProveedor(Collection<VistaProcesoLogisticoDTO> colProcesoLogistico) throws SICException; 

	/**
	 * Guarda los valores que se han editado en la recepcion
	 * 
	 * @param recepcionActual
	 * @param entregaRegistrada
	 * @param entregaTemporal
	 * @param entregasAdicionalesFDI
	 * @param listaFactTemp
	 * @param listaFactRegO
	 * @param listaAndenesRegistrados
	 * @param listaAndenesTemporales
	 * @param funcionarioPerfil
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	RecepcionProveedorDTO guardarEdicionRecepcion(RecepcionProveedorDTO recepcionActual,EntregaDTO entregaRegistrada, EntregaDTO entregaTemporal, Collection<EntregaDTO> entregasAdicionalesFDI, Collection<FacturaEstadoDTO> listaFactTemp, Collection<FacturaEstadoDTO> listaFactReg,
			Collection<DetalleTareaDTO> listaAndenesRegistrados, Collection<DetalleSeccionDTO> listaAndenesTemporales, VistaFuncionarioPerfilDTO funcionarioPerfil) throws SICException;	

	
	/**
	 * Cambia estado del proceso logistico y la tareas, pallet a terminado a cancelado
	 * 
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void cancelarRecepcionProveedor(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;


	/**
	 * Elimina una factura que puede estar en la recepcion o en la entrega
	 * 
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	void removerFacturaRecepcion(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	/**
	 * Activa o desactiva el escaneo manual
	 * @param codigoCompania
	 * @param activarEscaneoManual
	 * @param secuencialRecepcionProveedor
	 * @throws SICException
	 */
	void administrarIngresoManual(Boolean estadoIngresoManualAnterior, Boolean estadoIngresoManualNuevo, String accessItemID, String userId, VistaProcesoLogisticoDTO vistaProcesoLogisticoSeleccionada, Long codigoAutorizacion , ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO) throws SICException;
	
	/**
	 * Activa o desactiva el Ingreso Caja
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param estadoIngresoCajaAnterior
	 * @param estadoIngresoCajaNuevo
	 * @param accessItemID 
	 * @param userId
	 * @param codigoAutorizacion
	 * @param vistaProcesoLogisticoDTO
	 * @param vistaOrdenCompraDetalleEstadoDTO
	 * @param procesoLogisticoAutorizacionDTO
	 * @throws SICException
	 */
	void administrarIngresoCaja(Integer codigoCompania, Boolean estadoIngresoCajaAnterior, Boolean estadoIngresoCajaNuevo, String accessItemID, String userId, Long codigoAutorizacion, VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, VistaOrdenCompraDetalleEstadoDTO vistaOrdenCompraDetalleEstadoDTO, ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO) throws SICException;
	
	/**
	 * Consulta el estado del ingreso manual en la recepcion
	 * @param recepcion
	 * @return
	 * @throws SICException
	 */
	Boolean consultarEstadoIngresoManual(Integer codigoCompania, Long secuencialRecepcionProveedor) throws SICException;
	
	/**
	 * Conocer el estado de Ingreso Caja
	 * @author Yuniesky Armentero Moreno
	 * @param codigoCompania
	 * @param vistaProcesoLogisticoDTO
	 * @param vistaOrdenCompraDetalleEstadoDTO
	 * @return Boolean
	 * @throws SICException
	 */
	Boolean consultarEstadoIngresoCaja(Integer codigoCompania, VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO, VistaOrdenCompraDetalleEstadoDTO vistaOrdenCompraDetalleEstadoDTO) throws SICException;
	
	/**
	 * Consulta el nombre del tipo de recepcion a partir del codigo
	 * @param codigoCatalogoValorTipoRecepcion
	 * @return
	 * @throws SICException
	 */
	String consultarNombreTipoRecepcionPorCodigoTipo(String codigoCatalogoValorTipoRecepcion) throws SICException;
	
	/**
	 * Metodo que actualiza la tabla resumen, registra las cantidades y pesos de los articulos recibidos desde la Entrega B2B. 
	 * @param recepcionProveedorDTO
	 * @param artUniManRecepcion
	 * @param cantidadRecibir
	 * @param pesoRecibir
	 * @param userId
	 * @param tipoControlCosto
	 * @throws SICException
	 */
	void recibirArticuloB2B(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO artUniManRecepcion, Integer cantidadRecibir, BigDecimal pesoRecibir, String userId,
			String tipoControlCosto) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param listaAnden
	 * @param estado
	 * @throws SICException
	 */
	void cambiarEstadoAnden(Integer codigoCompania, Collection<DetalleSeccionDTO> listaAnden, String estado) throws SICException;

	/**
	 * @author yarmentero
	 * @param recepcionProveedor
	 */
	void reactivarRecepcionProveedorDetalleSeccion(RecepcionProveedorDTO recepcionProveedor);

}
