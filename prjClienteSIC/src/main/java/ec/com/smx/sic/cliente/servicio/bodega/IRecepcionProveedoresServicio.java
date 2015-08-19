/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.bodega;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioLogisticoDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.OperadorLogisticoDTO;
import ec.com.smx.corpv2.plantillas.dto.ConfiguracionPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.DetalleGrupoCampoPlantillaDTO;
import ec.com.smx.corpv2.plantillas.dto.ValorConfiguracionPlantillaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaRecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoAutorizacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecipienteTaraDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloTipoControlCostosDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoInformacionRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAsignacionArticuloUnidadManejoUbicacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAutorizacionFacturaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaFuncionarioPerfilDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaJabasPalletRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaListaProveedoresRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaOrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPalletsRecepcionPesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaResumenPalletsNavesSubnaves;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;

/**
 * @author acaiza
 *
 */

public interface IRecepcionProveedoresServicio {

	/**
	 * @param numeroAutorizacion
	 * @param codigoEmpresaProveedor
	 * @param codigoPersona
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<VistaAutorizacionFacturaProveedorDTO>  transObtenerNumeroAutorizacion(String numeroAutorizacion,Long codigoEmpresaProveedor, Long codigoPersona, Integer codigoCompania) throws SICException;
	
	/**
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param catalogoValorDTO
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	 CaracteristicaProcesoAreaTrabajoDTO obtenerCaracteristicaValidacionesRecepcion(Integer codigoCompania, Integer codigoAreaTrabajo, CatalogoValorDTO catalogoValorDTO, Long codigoProceso) throws SICException;
	
	/**
	 * Metodo para obtener Ubicaciones de surtidos para un articulo
	 * @param codigoAreaTrabajo
	 * @param verificarCantidadUbicada
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoCompania
	 * 
	 */
	Collection<VistaAsignacionArticuloUnidadManejoUbicacionDTO> transObtenerUbicacionesPorArticulo(Integer codigoAreaTrabajo, Boolean verificarCantidadUbicada, String codigoArticulo,
			Long codigoUnidadManejo, Integer codigoCompania) throws SICException;
	
	RecepcionProveedorDTO transRegistrarRecepcionJuguetes(RecepcionProveedorDTO recepcionProveedorDTO, EntregaDTO entrega) throws SICException;
	
	/**
	 * Este metodo obtiene entregas de la recepcion
	 * @param recepcionProveedorDTO
	 */
	Collection<EntregaRecepcionProveedorDTO> obtenerEntregasEnRecepcion(RecepcionProveedorDTO recepcionProveedorDTO)throws SICException;
	
	/**
	 * 
	 * @param tareaRecolector
	 * @param recepcionProveedor
	 * @param codigoBarrasPalet
	 * @param codigoAutorizacion
	 * @param codigoSistema
	 */
	void transRemoverPalet(TareaDTO tareaRecolector, RecepcionProveedorDTO recepcionProveedor, String codigoBarrasPalet, Long codigoAutorizacion, String codigoSistema)throws SICException;
	
	/**
	 * Este metodo obtiene las ordenes de compra detalle estado segun las unidades de manejo
	 * @param listaArtUniMan
	 * @param tareaRecepcion
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerDatosOrdenCompraDetalleEstado(Collection<ArticuloUnidadManejoDTO> listaArtUniMan, TareaDTO tareaRecepcion)throws SICException;
	
	/**
	 * Este metodo obtiene la informacion de un palet a editar
	 * @param datosTareaDTO
	 */
	DetalleDatosTareaDTO obtenerInformacionPaletEditar(DatosTareaDTO datosTareaDTO)throws SICException;
	
	
	/**
	 * @param tareaSeleccionada
	 * @param detalleTareaDTO
	 * @param datosTarea
	 * @param artUniManRecepcion
	 * @param controlRecipienteTaraDetallesCol
	 * @throws SICException
	 */
	void transRecibirArticulo(TareaDTO tareaSeleccionada, DetalleTareaDTO detalleTareaDTO,
			DatosTareaDTO datosTarea,
			ArticuloUnidadManejoDTO artUniManRecepcion, 
			Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol) throws SICException;
//	void transRecibirArticulo(RecepcionProveedorDTO recepcionEnProceso, DetalleTareaDTO detalleTareaDTO, DatosTareaDTO datosTarea,
//			ArticuloUnidadManejoDTO artUniManRecepcion, Integer cantidadPallet, BigDecimal pesoPallet, String tipoControlCosto,
//			Boolean actualizarUniMan, Integer valorMaximoAlmacenar, Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol, Long codigoProceso) throws SICException;
	/**
	 * Este m&eacute;todo modifica los datos recibidos del palet que recibe como parametro
	 * @param tareaDTO
	 * @param recepcion
	 * @param datosTarea
	 * @param cantidadRecibir
	 * @param codigoDatosTarea
	 * @param codigoAutorizacion
	 * @param codigoSistema
	 * @throws SICException
	 */
	void transModificarPalet(TareaDTO tareaDTO, RecepcionProveedorDTO recepcion, DatosTareaDTO datosTarea, Integer cantidadRecibir, BigDecimal pesoRecibir, String tipoControlCosto, Long codigoDatosTarea, Long codigoAutorizacion, String codigoSistema) throws SICException;
	 
	/**
	 * 
	 * @param datosTareaDTO
	 * @throws SICException
	 */
	DetalleDatosTareaDTO obtenerCantidadRecibidaEnPalet(DatosTareaDTO datosTareaDTO) throws SICException;
	
	/**
	 * 
	 * @param parametroDTO
	 * @throws SICException
	 */
	String transObtenerParametroRecepcion(ParametroDTO parametroDTO) throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @param andenes
	 * @param listaEntregas
	 * @param listaFacturaEstadoTemporal
	 * @param funcionarioPerfil
	 * @throws SICException
	 */
	Collection<RecepcionProveedorDTO> transIniciarRecepcionProveedor(RecepcionProveedorDTO recepcionProveedorDTO, Collection<DetalleSeccionDTO> andenes, Collection<EntregaDTO> listaEntregas, Collection<FacturaEstadoDTO> listaFacturaEstadoTemporal, VistaFuncionarioPerfilDTO funcionarioPerfil) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraDTO
	 * @param listaEntregas
	 * @throws SICException
	 */
	void transRemoverOrdenCompraRecepcionDia(OrdenCompraDTO ordenCompraDTO,Collection<EntregaDTO> listaEntregas) throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
	Collection<BodegaDTO> transObtenerDatosCDBodegaDesdeRecepcion(RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param entregasDTO
	 * @throws SICException
	 */
	Collection<OrdenCompraDTO> transObtenerOrdenesCompraRecepcion(Collection<EntregaDTO> entregasDTO) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraEstadoDTOs
	 * @param articuloUnidadManejoDTO
	 * @throws SICException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> transOrdenarOrdenesCompraPorPrioridades(Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * 
	 * @param ordenCompraDTO
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
	void transRemoverOrdenCompraRecepcion(OrdenCompraDTO ordenCompraDTO,RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * 
	 * @param codigosEntrega
	 * @throws SICException
	 */
	Object[] transObtenerBultosItemsOrdenCompra(Collection<Long> codigosEntrega) throws SICException;
	
	/**
	 * 
	 * @param entregaDTOs
	 * @param ordenCompraEstadoDTOs
	 * @param horaCalendarioDTO
	 * @param recepcionProveedorDTO
	 * @throws SICException
	 */
	void transModificarOrdenesCompraEntregas(Collection<EntregaDTO> listaEntregas,Collection<OrdenCompraEstadoDTO> listaOrdenCEGuardar, HoraCalendarioDTO horaCalendarioPLA, RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
 	 * 
 	 * @param areaTrabajoDTOs
 	 * @param horaCalendarioDTO
 	 * @param ordenCompraEstadoDTOs
 	 * @param recepcionProveedorDTO
 	 * @return
 	 * @throws SICException
 	 */
	Collection<EntregaDTO> transCrearEntregasOrdenCompraPlanificacion(Collection<AreaTrabajoDTO> listaAreaTrabajo, HoraCalendarioDTO horaCalendarioDTO, Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * @param Collection<OrdenCompraEstadoDTO>
	 * @param EntregaDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void transCrearOdenCompraParaEntrega(Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs, EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * 
	 * @param OrdenCompraDetalleEstadoDTOs
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> transObtenerArticulosOrdenCompraDetalleEstado(Collection<OrdenCompraDetalleEstadoDTO> listOrdenCompraDetalleEstadoDTO) throws SICException;
	
	/**
	 * 
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	FacturaEstadoDTO transModificarFacturaFisica(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	/**
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	FacturaEstadoDTO transModificarFactura(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	/**
	 * 
	 * @param facturaEstadoDTOs
	 * @param entregaDTO
	 * @throws SICException
	 */
	FacturaEstadoDTO transRegistroFacturasFisicas(Collection<FacturaEstadoDTO> facturaEstadoDTOs, EntregaDTO entregaDTO) throws SICException;
	
	/**
	 * 
	 * @param configuracionPlantillaDTO
	 * @return
	 * @throws SICException
	 */
	abstract ValorConfiguracionPlantillaDTO transActualizarValoresParaEdicion(ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;
	
	/**
	 * 
	 * @param configuracionPlantillaDTO
	 * @return
	 * @throws SICException
	 */
	abstract ValorConfiguracionPlantillaDTO transGuardarValorConfiguracionPlantilla(ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;	
	
	/**
	 * 
	 * @param ConfiguracionPlantillaDTO
	 * @throws SICException
	 */
	ValorConfiguracionPlantillaDTO transGuardarValoresPlantilla(ConfiguracionPlantillaDTO configuracionPlantillaDTO) throws SICException;
	
	/**
	 * 
	 * @param valor
	 * @param dgcp
	 * @param vcp
	 * @throws SICException
	 */
	abstract void transGuardarValoresGrupoPlantilla(String valor, DetalleGrupoCampoPlantillaDTO dgcp, ValorConfiguracionPlantillaDTO vcp) throws SICException;
	
//	/**
//	 * 
//	 * @param fecha
//	 * @param hora
//	 * @param codigoNombreProveedor
//	 * @return
//	 * @throws SICException
//	 */
//	abstract Collection<VistaProveedorDTO> transObtenerListaProveedoresRecepcion(Date fecha, Time hora, String codigoNombreProveedor, Integer codigoCD, Collection<Integer> codigosBodega) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigoCD
	 * @param codigosBodega
	 * @return
	 * @throws SICException
	 */
	Collection<VistaListaProveedoresRecepcionEntregaDTO> transObtenerListaProveedoresRecepcion2(Integer codigoCompania, Date fecha, Time hora, String codigoNombreProveedor, Integer codigoATCD, Integer codigoATBodega) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @return
	 * @throws SICException
	 */
	abstract Collection<HoraCalendarioDTO> transObtenerHorasRecepcion(Date fecha) throws SICException;
	
	/**
	 * 
	 * @param vistaProveedorDTO
	 * @param fechaEntrega
	 * @param hora
	 * @return
	 */
	abstract RecepcionProveedorVO transObtenerInformacionRegistroProveedor(VistaProveedorDTO vistaProveedorDTO, Date fechaEntrega, Time hora, Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * Guarda los datos de un furgon para la recepcion de un proveedor
	 * 
	 * @param recepcionProveedorDTO Un RecepcionProveedorDTO
	 */
	abstract void transRegistrarFurgonProveedorRecepcion(RecepcionProveedorVO recepcionProveedorVO) throws SICException;
	
//	/**
//	 * 
//	 * @param fecha
//	 * @param hora
//	 * @param codigoNombreProveedor
//	 * @return
//	 * @throws SICException
//	 */
//	Collection<VistaProveedorDTO> transObtenerRecepcionProveedoresPorEntrega(Date fecha, final Time hora, final String codigoNombreProveedor, Collection<Integer> codigosBodega) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigosProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProveedorDTO> transObtenerRecepcionProveedoresPorPlanificacion(Date fecha, Time hora, String codigoNombreProveedor, Collection<String> codigosProveedor, Collection<Integer> codigosBodega) throws SICException;
	
	/**
	 * 
	 * @param entregaDTO
	 * @param andenesNoDisponibles
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> transObtenerAndenesRecepcion(EntregaDTO entregaDTO, Collection<DetalleSeccionDTO> andenesNoDisponibles) throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorVO
	 * @return
	 * @throws SICException
	 */
	DetalleSeccionDTO transObtenerAndenRecepcion(RecepcionProveedorVO recepcionProveedorVO, Collection<DetalleSeccionDTO> andenesNoDisponibles) throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorVO
	 * @param andenReferencia
	 * @param andenesNoDisponibles
	 * @param cantidadAndenesSolicitados
	 * @param clasificacionesProductosProveedor
	 * @param listaDetGrupoCampoPla
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> transObtenerAndenesRecepcion(RecepcionProveedorVO recepcionProveedorVO, DetalleSeccionDTO andenReferencia, Collection<DetalleSeccionDTO> andenesNoDisponibles, Integer cantidadAndenesSolicitados, Collection<String> clasificacionesProductosProveedor, Collection<DetalleGrupoCampoPlantillaDTO> listaDetGrupoCampoPla, Integer codigoAreaTrabajoPadre) throws SICException;
	
	/**
	 * Cuenta los furgones registrados de un proveedor de una recepcion
	 * 
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @param fecha
	 * @param hora
	 * @param codigoBodegaAT
	 * @return
	 * @throws SICException
	 */
	Integer transContarFurgonesRegistrados(Long codigoRecepcionProveedor, String codigoProveedor, Date fecha, Time hora, Integer codigoBodegaAT) throws SICException;
	
	/**
	 * Permite asignar el valor del anden a un furg&oacute;n cuya solicitud de autorizaci&oacute;n ha sido aprobada
	 * @param recepcionProveedorVO
	 * @throws SICException
	 */
	void transRegistrarAndenDetalleRecepcionEntrega(RecepcionProveedorVO recepcionProveedorVO) throws SICException;
	
	/**
	 * Obtiene las clasificaciones de los art&iacute;culos que contiene la entrega
	 * @param recepcionProveedorVO
	 * @return
	 * @throws SICException
	 */
	Collection<ClasificacionDTO> transObtenerClasificacionesProveedor(RecepcionProveedorVO recepcionProveedorVO)throws SICException;
	
	/**
	 * Permite obtener los datos del operador log&iacute;stico a partir del c&oacute;digo de la persona
	 * @param operadorLogisticoDTO
	 * @return
	 * @throws SICException
	 */
	OperadorLogisticoDTO transObtenerInformacionOperadorLogistico(OperadorLogisticoDTO operadorLogisticoDTO) throws SICException;
	
	/**
	 * Permite obtener los proveedores del operador log&iacute;sticos que est&aacute;n registrados en el DetalleRecepcionEntrega
	 * @param operadorLogisticoDTO
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleRecepcionEntregaDTO> transObtenerProveedoresOperadorLogistico(OperadorLogisticoDTO operadorLogisticoDTO)throws SICException;
	
	/**
	 * Permite validar a partir del co&oacute;digo del proveedor si este tiene alg&uacute;n registro como FacturaDigital o como PlanificacionBodega
	 * @param codigoProveedor
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleRecepcionEntregaDTO> transValidarProveedorOperadorLogistico(String codigoProveedor, Integer codigoCompania)throws SICException;
	
	/**
	 * Consultar los andenes disponibles en la bodega y clasificarlos en disponibles y ocupados
	 * @param codigoAreaTrabajo
	 * @param fechaRecepcion
	 * @param andenesNoDisponibles andenes no disponibles desde una variable de aplicaci&oacute;n
	 * @param numeroAnden restriccion para la busqueda de andenes por numero
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerAndenesLibresYOcupados(Integer codigoCompania, Integer codigoAreaTrabajo, Date fechaRecepcion, Collection<DetalleSeccionDTO> andenesNoDisponibles, String numeroAnden, Integer codigoAreaTrabajoPadre) throws SICException; 
	
	/**
	 * Valida si el proveedor seleccionado tiene operador logistico asignado
	 * @param recepcionProveedorVO
	 * @return
	 * @throws SICException
	 */
	Boolean transTieneOperadorLogistico(RecepcionProveedorVO recepcionProveedorVO)throws SICException;
	
	/**
	 * 
	 * @param codigoRecepcionProveedor
	 * @param articuloUnidadManejoDTO
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaOrdenCompraEstadoDTO> transObtenerEntregaOrdenCompraEstadoPorRecepcion(Long codigoRecepcionProveedor, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * Obtener los tipo de pedido del proveedor
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param fechaEntrega
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> transObtenerTipoPedidoProveedor (Integer codigoCompania, String codigoProveedor, Date fechaEntrega) throws SICException;
	
	/**
	 * Eliminar de la BD, recepci&oacute;n proveedor
	 * Si el estado de la recepcion esta en estado REGISTRADO se puede eliminar todo el registro de la recepcion 
	 * (Recepcion, EntregaRecepcionProveedor, ProcesoLogistico, Tarea, EstadoTarea, DetalleTarea, y las entregas de TIPO PLANIFICACION (PLA))
	 * @param vistaProcesoLogisticoDTO
	 * @throws SICException
	 */
	void transEliminarRecepcionProveedor (Collection<VistaProcesoLogisticoDTO> colVistaProcesoLogisticoDTO) throws SICException;
	
	/**
	 * Obtener los andenes asignados a un proveedor para editar la recepci&oacute;n
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleTareaDTO> transObtenerAndenesAsignadosProveedor(RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * Metodo para verificar si la UniMan existente esta asignada o relacionada con el articulo que esta en el parametro.
	 * @param codigoBarrasUnidadManejo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> verificarAsignacionUnidadManejoArticulo(String codigoBarrasUnidadManejo, Integer codigoCompania) throws SICException;

	/**
	 * Retorna la vista con la informacion del articulo q se encuentra en el pallet para ser ubicado
	 * @param codigoDatosTarea
	 * @param codigoCompania
	 * @return 
	 * @throws SICException
	 */
	VistaArticuloUnidadManejoInformacionRecepcionDTO transObtenerInformacionArticuloParaUbicacion(Long codigoDatosTarea, Integer codigoCompania) throws SICException;

	/**
	 * Retorna un pallet existente con su respectivo estado.
	 * @param codigoBarrasPallet
	 * @param codigoCompania
	 * @return 
	 * @throws SICException
	 */
	Collection<DatosTareaEstadoDTO> obtenerEstadoPaletExistente(Integer codigoCompania, Collection<String> codigoBarrasPallets) throws SICException;

	/**
	 * Actualiza los valores de la unidad de manejo, y la cantidad maxima de articulos que se puede almacenar en un PALLET
	 * @param artUniManRecepcion
	 * @param actualizarMedidas
	 * @param valorMaximoAlmacenar
	 * @param actualizarUbicacionDespacho
	 * @throws 
	 */
	ArticuloUnidadManejoDTO transActualizarValoresUnidadManejoArticulo(ArticuloUnidadManejoDTO artUniManRecepcion, Boolean actualizarMedidas, Integer valorMaximoAlmacenar, Boolean actualizarUbicacionDespacho) throws SICException;
	
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @param codigoBarrasUnidadManejo
	 * @return
	 * @throws SICException
	 */
	public void transActualizarCodigoBarrasArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, String codigoBarrasUnidadManejo) throws SICException;
	
	/**
	 * Guarda los valores que se han editado en la recepcion
	 * 
	 * @param recepcionActual
	 * @param entregaRegistrada
	 * @param entregaTemporal
	 * @param entregasAdicionalesFDI
	 * @param listaFactTemp
	 * @param listaFactReg
	 * @param listaAndenesRegistrados
	 * @param listaAndenesTemporales
	 * @param funcionarioPerfil
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	RecepcionProveedorDTO transGuardarEdicionRecepcion(RecepcionProveedorDTO recepcionActual, EntregaDTO entregaRegistrada, EntregaDTO entregaTemporal, Collection<EntregaDTO> entregasAdicionalesFDI, Collection<FacturaEstadoDTO> listaFactTemp, Collection<FacturaEstadoDTO> listaFactReg,
			Collection<DetalleTareaDTO> listaAndenesRegistrados, Collection<DetalleSeccionDTO> listaAndenesTemporales, VistaFuncionarioPerfilDTO funcionarioPerfil) throws SICException;

	/**
	 * obtiene el numero de pallets en el que se encuentra registrado los articulos de una orden de compra
	 * 
	 * @param recepcion
	 * @param codigosOrdenCompraDetalleEstados
	 */
	Integer obtenerNumeroPalletsArtRegistrados(RecepcionProveedorDTO recepcion, Collection<Long> codigosOrdenCompraDetalleEstados) throws SICException;
	
	/**
	 * Cancela los datos de una recepcion del proveedor
	 * 
	 * @param vistaProcesoLogisticoDTO Un VistaProcesoLogisticoDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void transCancelarRecepcionProveedor(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;

	/**
	 * Obtiene la ubicacion para despacho de un articulo en la recepcion
	 * @param articuloDTO
	 */
	ArticuloProcesoLogisticoDTO obtenerUbicacionArticuloDespacho(ArticuloDTO articuloDTO) throws SICException;

	/**
	 * obtiene el articulo que es de tipo pallet para la recepcion
	 * @param codigoBarrasArticuloPallet
	 * @param codigoCompania
	 */
	ArticuloDTO buscarArticuloPalletRecepcion(String codigoBarrasArticuloPallet, Integer codigoCompania) throws SICException;

	/**
	 * Cuenta el numero de facturas de una recepcion de un proveedor
	 * 
	 * @param vistaProcesoLogisticoDTO Una recepcion de un proveedor
	 * @return cantidad de facturas de la recepcion
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void contarFacturasRecepcionProveedor(VistaProcesoLogisticoDTO vistaProcesoLogisticoDTO) throws SICException;
	
	
	/**
	 * Obtiene la informacion del articulo unidad de manejo que esta en la recepcion	
	 * @param recepcionProveedorDTO
	 * @param codigoBarrasArticulo
	 * @param codigoBarrasCaja
	 * @return 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<VistaArticuloUnidadManejoDTO> obtenerDatosArticuloUnidadManejoRecepcion(RecepcionProveedorDTO recepcionProveedorDTO, String codigoBarrasArticulo, String codigoBarrasCaja) throws SICException;
	
	/**
	 * Busca bodegas o subbodegas por area de trabajo para la recepcion
	 * 
	 * @param codigoCompania
	 * @param codigosAreaTrabajo
	 * @param areaTrabajoValor
	 * @return 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<BodegaDTO> transObtenerBodegaSubbodegaPorAreaTrabajo(Integer codigoCompania, Collection<Integer> codigosAreaTrabajo, CatalogoValorDTO areaTrabajoValor) throws SICException;
	
	/**
	 * Busca la informacion del detalle de los articulos en la recepcion
	 * 
	 * @param ordenCompraDetalleEstadoCol
	 * @return 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<VistaArticuloUnidadManejoDTO> obtenerDatosDetalleArticuloRecepcion(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol) throws SICException;
	
	/**
	 * Obtiene la cantidad total de pallets que se necesit en una recepcion
	 * 
	 * @param ordenCompraDetalleEstadoCol
	 * @return 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Integer obtenerCantidadTotalPalletsRecepcion(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol) throws SICException;
	
//	/**
//	 * Obtiene la cantidad maxima de cajas que entran en un pallet de una articulo
//	 * @param ordenCompraDetalleEstadoCol
//	 * @return
//	 * @throws SICException
//	 */
//	Integer obtenerCantidaMaximaPalletPorArticulo(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol) throws SICException;
	
	/**
	 * Obtiene las clasificaciones de articulos en la recepcion
	 * 
	 * @param ordenCompraDetalleEstadoCol
	 * @return 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<ClasificacionDTO> transBuscarClasificacionesArticulosRecepcion(Collection<OrdenCompraDetalleEstadoDTO> listaDetalleOrdenCompra) throws SICException;
	
	/**
	 * Elimina una factura que puede estar en la recepcion o en la entrega
	 * 
	 * @param facturaEstadoDTO
	 * @throws SICException
	 */
	void transremoverFacturaRecepcion(FacturaEstadoDTO facturaEstadoDTO) throws SICException;
	
	/**
	 * Obtiene el pallet que se encuentra registrado en una recepcion
	 * 
	 * @param codigoBarrasPallet
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> buscarPalletRecepcion(String codigoBarrasPallet) throws SICException;
	
	/**
	 * Obtener el tipo de control de costos para los articulos
	 * 
	 * @param codigosOrdenCompraDetalleEstados
	 * @param codigoCompania
	 * @throws SICException
	 */
	Collection<VistaArticuloTipoControlCostosDTO> obtenerTipoControlCostosArticulo(Collection<Long> codigosOrdenCompraDetalleEstados, Integer codigoCompania) throws SICException;
	
	/**
	 * comprobar si la orden de compra tiene articulos pendientes por recibir.
	 * 
	 * @param ordenCompraEstadoENV
	 * @param listaTipoControlCosto
	 * @throws SICException
	 */
	Boolean comprobarOrdenCompraEntregada(OrdenCompraEstadoDTO ordenCompraEstadoENV, Collection<VistaArticuloTipoControlCostosDTO> listaTipoControlCosto) throws SICException;

	/**
	 * <b> Obtiene el tipo de control de costos<b>
	 * <p>
	 * [Author: aecaiza, Date: 27/10/2014]
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 */
	String obtenerTipoControlCostos(Integer codigoCompania, String codigoArticulo) throws SICException;	
	
	/**
	 * @param tipoControlCostos
	 * @param detalleTareaDTO
	 * @param recepcionEnProceso
	 * @param artUniManRecepcion
	 * @param datosTarea
	 * @param cantidadPallet
	 * @param listaJabasRecibidas
	 */
	void transRecibirArticuloPorTipoControlCostos(String tipoControlCostos, DetalleTareaDTO detalleTareaDTO, RecepcionProveedorDTO recepcionEnProceso,
			ArticuloUnidadManejoDTO artUniManRecepcion, DatosTareaDTO datosTarea, Integer cantidadPallet, BigDecimal pesoPallet, 
			Collection<ControlRecipienteTaraDetalleDTO> listaJabasRecibidas, Long codigoProceso) throws SICException;
	
	/**
	 * Obtiene el valor del porcentaje adicional de un articulo para la recepcion
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoProveeedor
	 * @return
	 * @throws SICException
	 */
	Double obtenerValorPorcentajeAdicional(Integer codigoCompania, String codigoArticulo, String codigoProveeedor) throws SICException;
	
	/**
	 * Obtiene el valor del estado actual del pallet
	 * @param codigoCompania
	 * @param codigoBarrasPallets
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerEstadoActualPallet(Integer codigoCompania, Collection<String> codigoBarrasPallets) throws SICException;
	
	/**
	 * Obtener la lista de pallets asignados a un recolector
	 * @param funcionarioSubTraRel
	 * @return
	 * @throws SICException
	 */
	Collection<DatosTareaDTO> obtenerPalletsAsignadosRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;
	
	/**
	 *  Obtener los datos para las tareas del recolector
	 * @param funSubTarRel
	 * @param codigoBarrasPallet
	 * @return
	 * @throws SICException
	 */
	Collection<VistaTareaDatosTareaDTO> obtenerDatosTareaRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Collection<String> codigoBarrasPallet) throws SICException;
	
	/* ************************************************
	 * INICIO SERVICIOS PARA LA RECEPCION DE PERECIBLES
	 * ***********************************************/
	/**
	 * Servicio para registrar las recepciones para los proveedores con entregas planificadas desde el B2B y ordenes 
	 * de compra en estado enviadas para la fecha actual para la bodega de perecibles.
	 * @param recepcionProveedorDTO
	 * @param colCodigoProveedor
	 * @param incluirOrdenesSinFDI
	 * @throws SICException
	 */
	void transRegistrarRecepcionPerecibles (RecepcionProveedorDTO recepcionProveedorDTO, Collection<String> colCodigoProveedor, Boolean incluirOrdenesSinFDI) throws SICException;
	
	/**
	 * Servicio para ejecutar el proceso batch que registra las recepciones de los proveedores
	 * @param recepcionProveedorDTO
	 * @param incluirOrdenesSinFDI
	 * @throws SICException
	 */
	void transRegistrarDatosRecepcionPereciblesBatch (RecepcionProveedorDTO recepcionProveedorDTO, Boolean incluirOrdenesSinFDI) throws SICException;
	
	/**
	 * Servicio para registrar las recepciones para los proveedores con entregas planificadas desde el B2B y 
	 * ordenes de compra en estado enviadas para la fecha actual para la bodega de perecibles.
	 * @param recepcionProveedorDTO
	 * @param colCodigoProveedor
	 * @param incluirOrdenesSinFDI
	 * @throws SICException
	 */
	void transRegistrarRecepcionPereciblesBatch (RecepcionProveedorDTO recepcionProveedorDTO, Collection<String> colCodigoProveedor, Boolean incluirOrdenesSinFDI) throws SICException;
	/* ************************************************
	 * FIN SERVICIOS PARA LA RECEPCION DE PERECIBLES
	 * ***********************************************/		

	/**
	 * Obtener la lista de caracteristicas area valor
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param caracteristicaCatalogoTipo
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	Map<String, String> obtenerCaracteristicaValidacionesRecepcionCol(Integer codigoCompania, Integer codigoAreaTrabajo, Integer caracteristicaCatalogoTipo, Long codigoProceso) throws SICException;

	/**
	 * Obtiene una lista pallets de recepcion relacionados a un aritulo en especifico
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	Collection<VistaPalletsRecepcionPesoDTO> obtenerPalletsRecepcionArticulo(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Long codigoProcesoLogistico, String valorTipoControlCosto) throws SICException;

	/**
	 * Obtiene un recipiente filtrado por codigo de barras
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	RecipienteTaraDTO obtenerRecipienteCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	
	/**
	 * Obtener el peso de referencia de un pallet filtrado por subbodega y codigo de proceso
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param catalogoValorDTO
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	BigDecimal obtenerPesoReferenciaPallet (Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoCatalogoTipo, String codigoCatalogoValor, Long codigoProceso) throws SICException;

	/**
	 * Obteiene una coleccion de jabas relacionadas a pallets de recepcion 
	 * @param codigoCompania
	 * @param codigosPallets
	 * @return
	 * @throws SICException
	 */
	Collection<VistaJabasPalletRecepcionDTO> obtenerJabasRecepcionPallets(Integer codigoCompania, Collection<Long> codigosPallets) throws SICException;

	/**
	 * Obtener los datos configurados en una plantilla
	 * 
	 * @param cargarDatos
	 * @param codConfPlantilla
	 * @param codValorPlantilla
	 * @throws SICException
	 */
	Collection<ConfiguracionPlantillaDTO> obtenerConfiguracionPlantilla(Boolean cargarDatos, Integer codConfPlantilla, Integer codValorPlantilla) throws SICException;

	/**
	 * @author lguaman
	 * Recibe un articulo en peso o en cantidad (Recepcion en Oficina)
	 * @param recepcionEnProceso
	 * @param palletsEnBalanza
	 * @param codigoDetalleSeccionOrigen
	 * @param userId
	 */
	void transRecibirArticuloPorCantidadOPeso(RecepcionProveedorDTO recepcionEnProceso, Collection<DatosTareaDTO> palletsEnBalanza, Long codigoDetalleSeccionOrigen, String userId) throws SICException;

	/**
	 * @author lguaman
	 * Termina la recepcion dependiendo del tipo de control de costos que se recibio, esto desde el recibidor
	 * @param tareaRecibidor
	 * @param procesoLogRecepcion
	 * @param userId
	 */
	void transTerminarRecepcionRecibidor(TareaDTO tareaRecibidor, ProcesoLogisticoDTO procesoLogRecepcion, String userId) throws SICException;

	
	/**
	 * @author lguaman
	 * Metodo que envia a finalizar la recepcion desde la oficina
	 * @param procesoLogRecepcion
	 * @param userId
	 */
	void transTerminarRecepcionOficina(ProcesoLogisticoDTO procesoLogRecepcion, String userId) throws SICException;

	/**
	 * Obtiene el resumen de jabas de la recepcion
	 * @param codigoCompania
	 * @param codigoProceso
	 * @param codigosProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	Collection<ControlRecipienteTaraDetalleDTO> obtenerResumenJabasRecepcion(Integer codigoCompania, Long codigoProceso, Collection<Long> codigosProcesoLogistico) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoProcesoLogistico
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloDTO> obtenerRecepcionProveedorArticuloRegistrar (Integer codigoCompania, Long codigoProcesoLogistico, Long codigoRecepcionProveedor, String codigoProveedor) throws SICException;

	/**
	 * Obtiene las recepciones configuradas del proveedor
	 * @param recepcion
	 * @param valoresExcluirEstadoRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorDTO> buscarRecepcionesConfiguradasProveedor(RecepcionProveedorDTO recepcion, Collection<String> valoresExcluirEstadoRecepcion) throws SICException;

	/**
	 * Verifica si la orden de compra igresada se encuentra en otras recepciones pendientes
	 * @param recepcion
	 * @param codigosOrdenCompraEstado
	 * @return
	 * @throws SICException
	 */
	Boolean verificarOrdenCompraEnRecepcionesPendientes(RecepcionProveedorDTO recepcion, Collection<Long> codigosOrdenCompraEstado) throws SICException;
	
//	/**
//	 * Permite registrar un pallet incompleto para la recepcion
//	 * @param funcionarioAreaTrabajo
//	 * @param tareaSeleccionada
//	 * @param articuloPallet
//	 * @return
//	 * @throws SICException
//	 */
//	Long registrarPalletIncompleto(FuncionarioAreaTrabajoDTO funcionarioAreaTrabajo, TareaDTO tareaSeleccionada) throws SICException;
	
	/**
	 * Activa o desactiva el escaneo manual
	 * @param codigoCompania
	 * @param activarEscaneoManual
	 * @param secuencialRecepcionProveedor
	 * @throws SICException
	 */
	void administrarIngresoManual(Boolean estadoIngresoManualAnterior, Boolean estadoIngresoManualNuevo, String accessItemID, String userId, VistaProcesoLogisticoDTO vistaProcesoLogisticoSeleccionada, Long codigoAutorizacion, ProcesoLogisticoAutorizacionDTO procesoLogisticoAutorizacionDTO) throws SICException;
	
	/**
	 * Activa o desactiva el ingreso a caja
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
	
	/*
	 * Inicio metodos para el proceso de tareas de receso
	 * */
	
	/**
	 * 
	 * @param tareaPlantilla
	 * @param codigoReferenciaTipoTarea
	 * @throws SICException
	 */
	void transIniciarTareaRecesoFuncionario (TareaDTO tareaPlantilla, String referenceCode, String codigoReferenciaTipoTarea) throws SICException;
	
	/**
	 * Registrar o actualizar {@link FuncionarioLogisticoDTO} que esten en estado OCUPADO a estado LIBRE
	 * @param codigoCompania
	 * @param userId
	 * @param colCodigoFuncionario
	 * @throws SICException
	 */
	void transRegistrarFuncionariosEstadoLibre (Integer codigoCompania, String userId, String ... colCodigoFuncionario) throws SICException;
	
	/**
	 * Finalizar la tarea de receso del usuario si esta en proceso
	 * @param codigoCompania
	 * @param codigoFuncionario
	 * @param fechaBusqueda
	 * @param userId
	 * @param codigoPerfil
	 * @throws SICException
	 */
	void transFinalizarTareaReceso (Integer codigoCompania, String codigoFuncionario, Date fechaBusqueda, String userId, String codigoPerfil) throws SICException;
	/*
	 * Fin metodos para el proceso de tareas de receso
	 * */
	
	/**
	 * Retorna una coleccion de repicientes tipo jaba relacionados a un articulo
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */

	Collection<ControlRecipienteTaraDetalleDTO> obtenerJabasArticuloCol(Integer codigoCompania, Collection<String> codigosBarrasArticulo) throws SICException;

	void cambiarEstadoAnden(Integer codigoCompania, Collection<DetalleSeccionDTO> listaAnden, String estado) throws SICException;

	/**
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerUbicacionArticulo() throws SICException;
	
	/**
	 * Sirve para consultar las naves de acuerdo al area de trabajo, la compania y de tiposeccion NAV.
	 * @param codigoCompania
	 * @param areasTrabajo
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerNavesPorAreaTrabajoValorTipoSeccion(Integer codigoCompania,Collection<Integer> areasTrabajo) throws SICException;
	
	/**
	 * Sirve para consultar las subnaves de acuerdo al area de trabajo, la compania y de tiposeccion SNA y que sean hijos
	 * de un detalleseccion enviado como parametro.
	 * @param codigoCompania
	 * @param detalleSeccionPadre
	 * @param areasTrabajo
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerSubnavesRelacionadoPorAreaTrabajoValorTipoSeccion(Integer codigoCompania,Long detalleSeccionPadre,Collection<Integer> areasTrabajo) throws SICException;
	
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
	Collection<VistaResumenPalletsNavesSubnaves> obtenerResumenPalletsPendientesNaveSubnave(Integer codigoCompania,Integer codigoAreaTrabajo,Integer codigoAreaTrabajoBodega,Integer codigoAreaTrabajoSubbodega,String codigoReferenciaTipoTarea,boolean incluyeSubnaves) throws SICException;
	
	/**
	 * Devuelve el total de pallets recibidos, total de pallets en anden, total de pallets en pasillo y el total de pallets terminados
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoAreaTrabajoBodega
	 * @param codigoAreaTrabajoSubbodega
	 * @return
	 */
	Collection<VistaResumenPalletsNavesSubnaves> obtenerTotalesPallets(Integer codigoCompania,Integer codigoAreaTrabajo,Integer codigoAreaTrabajoBodega,Integer codigoAreaTrabajoSubbodega) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param numeroOrdenCompra
	 * @return
	 * @throws SICException
	 */
	OrdenCompraEstadoDTO obtenerOrdenCompraEstadoPorNumero(Integer codigoCompania, String numeroOrdenCompra) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraEstado
	 * @return
	 * @throws SICException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerDetallesOrdenCompraEstado(Integer codigoCompania, Long codigoOrdenCompraEstado) throws SICException;
	/**
	 * <b>Obtiene un pallet filtrado por codigo de pallet y codigo de compania</b>
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO obtenerPalletPorId(Integer codigoCompania, Long codigoDatosTarea) throws SICException;
}
