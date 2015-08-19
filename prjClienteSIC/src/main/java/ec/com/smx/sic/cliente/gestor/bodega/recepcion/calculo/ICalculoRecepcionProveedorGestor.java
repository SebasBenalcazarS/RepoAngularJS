package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.smx.corpv2.dto.CaracteristicaProcesoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaRecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.HoraCalendarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecipienteTaraDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoInformacionRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAsignacionArticuloUnidadManejoUbicacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaAutorizacionFacturaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaJabasPalletRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaListaProveedoresRecepcionEntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaPalletsRecepcionPesoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaResumenPalletsNavesSubnaves;
import ec.com.smx.sic.cliente.mdl.dto.VistaTareaDatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionProveedorVO;

/**
 * 
 * @author acaiza
 *
 */
public interface ICalculoRecepcionProveedorGestor {
	/**
	 * @param codigoBarrasUnidadManejo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> verificarAsignacionUnidadManejoArticulo(String codigoBarrasUnidadManejo, Integer codigoCompania) throws SICException;
	
	/**
	 * @param numeroAutorizacion
	 * @param codigoEmpresaProveedor
	 * @param codigoPersona
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<VistaAutorizacionFacturaProveedorDTO>  obtenerNumeroAutorizacion(String numeroAutorizacion,Long codigoEmpresaProveedor, Long codigoPersona, Integer codigoCompania)  throws SICException;
	
	 /**
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param catalogoValorDTO
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	CaracteristicaProcesoAreaTrabajoDTO obtenerCaracteristicaValidacionesRecepcion(Integer codigoCompania, Integer codigoAreaTrabajo, CatalogoValorDTO catalogoValorDTO, Long codigoProceso)  throws SICException;
	
	/**
	 * 
	 * @param codigoAreaTrabajo
	 * @param verificarCantidadUbicada
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Collection<VistaAsignacionArticuloUnidadManejoUbicacionDTO> obtenerUbicacionesPorArticulo(Integer codigoAreaTrabajo, Boolean verificarCantidadUbicada, String codigoArticulo,
			Long codigoUnidadManejo, Integer codigoCompania)  throws SICException;
	
	/**
	 * 
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaRecepcionProveedorDTO> obtenerEntregasEnRecepcion(RecepcionProveedorDTO recepcionProveedorDTO)  throws SICException;
	
	/**
	 * Obtiene las ordenes de compra detalle estado segun las unidades de manejo
	 * @param listaArtUniMan
	 * @param tareaRecepcion
	 * @return
	 * @throws CDException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> obtenerDatosOrdenCompraDetalleEstado(Collection<ArticuloUnidadManejoDTO> listaArtUniMan, TareaDTO tareaRecepcion) throws SICException;
	
	/**
	 * Obtiene el palet que se va ha modificar
	 * @param datosTareaDTO
	 * @return
	 * @throws CDException
	 */
	DetalleDatosTareaDTO armarObjetoInformacionPalet(DatosTareaDTO datosTareaDTO) throws SICException;
	
	/**
	 * Obtiene las cantidades que se han recibido en un palet
	 * @param datosTareaDTO
	 * @return
	 * @throws CDException
	 */
	DetalleDatosTareaDTO obtenerCantidadRecibidaEnPalet(DatosTareaDTO datosTareaDTO) throws SICException;
	
	/**
	 * Obtiene el valor de un parametro para la recepcion
	 * @param parametroDTO
	 * @return
	 * @throws CDException
	 */
	String obtenerParametroRecepcion(ParametroDTO parametroDTO) throws SICException;
	
	/**
	 * 	
	 * @param recepcionProveedorDTO
	 * @return
	 * @throws SICException
	 */
	Collection<BodegaDTO> obtenerDatosCDBodegaDesdeRecepcion(RecepcionProveedorDTO recepcionProveedorDTO) throws SICException;
	
	/**
	 * 	
	 * @param codigosEntrega
	 * @return
	 * @throws SICException
	 */
	Object[] obtenerBultosItemsOrdenCompra(Collection<Long> codigosEntrega) throws SICException;
	
	/**
	 * 	
	 * @param proveedorDTO
	 * @param bodegaDTO
	 * @return
	 * @throws SICException
	 */
	Collection<CalendarioDTO> obtenerHorariosProveedorRecepcion(ProveedorDTO proveedorDTO, BodegaDTO bodegaDTO) throws SICException;
	
	/**
	 * 	
	 * @param codigoCatalogoTipo
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerCategoriasDetalleSeccion(Integer codigoCatalogoTipo) throws SICException;
	
//	/**
//	 * Obtiene la lista de proveedores para recepcion
//	 * @param fechaEntrega Fecha de la entrega
//	 * @return Un Collection de VistaProveedorDTO
//	 * @throws SICException Excepcion en caso de producirse un error
//	 */
//	Collection<VistaProveedorDTO> obtenerListaProveedoresRecepcion(Date fecha, Time hora, String codigoNombreProveedor, Integer codigoCD, Collection<Integer> codigosBodega) throws SICException;
	
	/**
	 * Busca los proveedores que tienen entregas en una determinada fecha. Busca los proveedores en las entregas de factura digital, en la planificacion del calendario de la bodega
	 * 
	 * @param fecha Fecha de la entrega
	 * @param hora Hora de la entrega
	 * @param codigoNombreProveedor Codigo o nombre del proveedor
	 * @param codigoATCD Codigo del area de trabajo CD
	 * @param codigosATBodega Codigo del area de trabajo Bodega
	 * @return Un Collection de VistaListaProveedoresRecepcionEntregaDTO con los datos de los proveedores que tienen recepcion en esa fecha
	 * 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<VistaListaProveedoresRecepcionEntregaDTO> obtenerListaProveedoresRecepcion2(Integer codigoCompania, Date fecha, Time hora, String codigoNombreProveedor, Integer codigoATCD, Integer codigoATBodega) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @return
	 * @throws SICException
	 */
	Collection<HoraCalendarioDTO> obtenerHorasRecepcion(Date fecha) throws SICException;
	
	/**
	 * Consulta informacion de recepcion de un proveedor en una fecha y hora determinada
	 * 
	 * @param vistaProveedorDTO Un VistaProveedorDTO
	 * @param fechaEntrega Un Date
	 * @param hora Un Time
	 * @return Un RecepcionProveedorVO
	 */
	RecepcionProveedorVO obtenerInformacionRecepcionProveedor(VistaProveedorDTO vistaProveedorDTO, Date fechaEntrega, Time hora, Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * Busca si el proveedor tiene una's recepcion abierta en proceso que todavia este sin generar factura interna
	 * 
	 * @param vistaProveedorDTO
	 * @param fechaEntrega
	 * @param tiposPedido
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorDTO> obtenerRecepcionesAbiertas(VistaProveedorDTO vistaProveedorDTO, Date fechaEntrega, Collection<CatalogoValorDTO> tiposPedido, Integer codigoBodegaAT, Time hora) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigosProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<VistaProveedorDTO> obtenerRecepcionProveedoresPorPlanificacion(Date fecha, Time hora, String codigoNombreProveedor, Collection<String> codigosProveedorExcluir, Collection<Integer> codigosATBodega) throws SICException;
	
//	/**
//	 * 
//	 * @param fecha
//	 * @param hora
//	 * @param codigoNombreProveedor
//	 * @return
//	 * @throws SICException
//	 */
//	Collection<VistaProveedorDTO> obtenerRecepcionProveedoresPorEntrega(Date fecha, Time hora, String codigoNombreProveedor, Collection<Integer> codigosATBodega) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigoATBodega
	 * @param codigosATBodega
	 * @return
	 * @throws SICException
	 */
	Collection<VistaListaProveedoresRecepcionEntregaDTO> obtenerListaRecepcionProveedoresPorEntrega(Date fecha, Time hora, String codigoNombreProveedor, Integer codigoATCD, Integer codigosATBodega) throws SICException;
	
	/**
	 * 
	 * @param fecha
	 * @param hora
	 * @param codigoNombreProveedor
	 * @param codigoATBodega
	 * @param codigosATBodega
	 * @return
	 * @throws SICException
	 */
	Collection<VistaListaProveedoresRecepcionEntregaDTO> obtenerListaRecepcionProveedoresPorPlanificacion(Date fecha, Time hora, String codigoNombreProveedor, Collection<String> codigosProveedor, Integer codigoATCD, Integer codigosATBodega) throws SICException;
	
	/**
	 * 
	 * @param codigoRecepcionProveedor
	 * @param codigoProveedor
	 * @param fecha
	 * @param hora
	 * @param codigoBodegaAT
	 * @return
	 * @throws SICException
	 */
	Integer contarFurgonesRegistrados(Long codigoRecepcionProveedor, String codigoProveedor, Date fecha, Time hora, Integer codigoBodegaAT) throws SICException;
	
	/**
	 * Obtiene las clasificaciones de los art&iacute;culos que contiene la entrega
	 * @param recepcionProveedorVO
	 * @return
	 * @throws SICException
	 */
	Collection<ClasificacionDTO> obtenerClasificacionesProveedor(RecepcionProveedorVO recepcionProveedorVO)throws SICException;
	
	/**
	 * Consulta las entregas de un proveedor en una fecha y hora indicada para obtener las entregas en la factua digital
	 * 
	 * @param vistaProveedorDTO Un proveedor
	 * @param fechaEntrega Fecha de las entregas
	 * @param hora Hora de la recepcion
	 * @return Una coleccion de entregas
	 */
	Collection<EntregaDTO> buscarEntregasPorFacturaDigital(VistaProveedorDTO vistaProveedorDTO, Date fechaEntrega, Time hora) throws SICException;
	
	/**
	 * 
	 * @param codigoRecepcionProveedor
	 * @param articuloUnidadManejoDTO
	 * @return
	 * @throws SICException
	 */
	Collection<EntregaOrdenCompraEstadoDTO> obtenerEntregaOrdenCompraEstadoPorRecepcion(Long codigoRecepcionProveedor, ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICException;
	
	/**
	 * Obtener los tipo de pedido del proveedor
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoProveedor
	 * @param fechaEntrega
	 * @return
	 * @throws SICException
	 */
	Collection<CatalogoValorDTO> obtenerTipoPedidoProveedor (Integer codigoCompania, String codigoProveedor, Date fechaEntrega) throws SICException;
	
	/**
	 * Retorna la vista con la informacion del articulo q se encuentra en el pallet para ser ubicado
	 * @param codigoDatosTarea
	 * @param codigoCompania
	 * @return 
	 * @throws SICException
	 */
	VistaArticuloUnidadManejoInformacionRecepcionDTO obtenerInformacionArticuloParaUbicacion(Long codigoDatosTarea, Integer codigoCompania) throws SICException;

	/**
	 * Retorna un pallet existente con su respectivo estado.
	 * @param codigoBarrasPallet
	 * @param codigoCompania
	 * @return 
	 * @throws SICException
	 */
	Collection<DatosTareaEstadoDTO> obtenerPaletExistenteEstado(Integer codigoCompania ,Collection<String> codigoBarrasPallets) throws SICException;

	/**
	 * Retorna la recepcion de un proveedor con sus tarea
	 * @param recepcion
	 * @return 
	 * @throws SICException
	 */
	RecepcionProveedorDTO buscarRecepcionProveedor(RecepcionProveedorDTO recepcion) throws SICException;
	
	/**
	 * obtiene el numero de pallets en el que se encuentra registrado los articulos de una orden de compra
	 * 
	 * @param recepcion
	 * @param codigosOrdenCompraDetalleEstados
	 */
	Integer obtenerNumeroPalletsArtRegistrados(RecepcionProveedorDTO recepcion, Collection<Long> codigosOrdenCompraDetalleEstados) throws SICException;

//	/**
//	 * 
//	 * @param codigoCompania
//	 * @param codigoTipoEstadoTarea
//	 * @param referenceCode
//	 */
//	@Deprecated
//	TipoTareaPerfilDTO obtenerTipoTarePerfil(Integer codigoCompania, Integer codigoTipoEstadoTarea, String referenceCode) throws SICException;
	
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
	 * 
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
	Collection<BodegaDTO> obtenerBodegaSubbodegaPorAreaTrabajo(Integer codigoCompania, Collection<Integer> codigosAreaTrabajo, CatalogoValorDTO areaTrabajoValor) throws SICException;

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
	Integer obtenerCantidadTotalPalletsRecepcion(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol)throws SICException;

	/**
	 * Obtiene las clasificaciones de articulos en la recepcion
	 * 
	 * @param ordenCompraDetalleEstadoCol
	 * @return 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<ClasificacionDTO> buscarClasificacionesArticulosRecepcion(Collection<OrdenCompraDetalleEstadoDTO> listaDetalleOrdenCompra) throws SICException;

	/**
	 * Obtiene el pallet que se encuentra registrado en una recepcion
	 *
	 * @param codigoBarrasPallet
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	Collection<DatosTareaDTO> buscarPalletRecepcion(String codigoBarrasPallet) throws SICException;
	
	/**
	 * <b> Obtiene el tipo de control de costos<b>
	 * <p>
	 * [Author: aecaiza, Date: 27/10/2014]
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 */
	String obtenerTipoControlCostos(Integer codigoCompania, String codigoArticulo) throws SICException;
	
//	/**
//	 * Obtiene la cantidad maxima de un articulo 
//	 * @param ordenCompraDetalleEstadoCol
//	 * @return
//	 * @throws SICException
//	 */
//	Integer obtenerCantidaMaximaPalletPorArticulo(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoCol) throws SICException;

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
	 * Obtener los datos para las tareas del recolector
	 * @param funSubTarRel
	 * @param codigoBarrasPallet
	 * @return
	 * @throws SICException
	 */
	Collection<VistaTareaDatosTareaDTO> obtenerDatosTareaRecolector(FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO, Collection<String> codigoBarrasPallet) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoProcesoLogistico
	 * @return
	 * @throws SICException
	 */
	Collection<VistaPalletsRecepcionPesoDTO> obtenerPalletsRecepcionArticulo(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Long codigoProcesoLogistico, String valorTipoControlCosto) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	RecipienteTaraDTO obtenerRecipienteCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param catalogoValorDTO
	 * @param codigoProceso
	 * @return
	 * @throws SICException
	 */
	BigDecimal obtenerPesoReferenciaPallet (Integer codigoCompania, Integer codigoAreaTrabajo, Integer codigoCatalogoTipo, String codigoCatalogoValor, Long codigoProceso) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigosPallets
	 * @return
	 * @throws SICException
	 */
	Collection<VistaJabasPalletRecepcionDTO> obtenerJabasRecepcionPallets(Integer codigoCompania, Collection<Long> codigosPallets) throws SICException;

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
	 * Retorna una lista de jabas relacionadas al articulo
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */

	Collection<ControlRecipienteTaraDetalleDTO> obtenerJabasArticuloCol(Integer codigoCompania, Collection<String> codigosBarrasArticulo) throws SICException;

	/**
	 * Obtiene la ubicaci&oacute;n de un art&iacute;culo
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
	 * devuelve el identificador de los codigosDetalleSeccion enviados y que pertenecan a la compania enviada y con estado 1
	 * @param codigoCompania
	 * @param codigosDetalleSeccion
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> obtenerIdentificadorCodigosDetalleSeccion(Integer codigoCompania,Collection<Long> codigosDetalleSeccion) throws SICException;
	
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
	 * Obtiene un pallet filtrado por codigo de pallet
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO obtenerPalletPorId(Integer codigoCompania, Long codigoDatosTarea) throws SICException;
}
