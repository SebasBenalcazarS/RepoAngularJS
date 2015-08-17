package ec.com.smx.sic.cliente.servicio.convenio.ventas;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosAcumuladosDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.RegistroCobroDTO;
import ec.com.smx.sic.cliente.mdl.dto.RegistroCobroDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.RegistroCobroDetalleDiarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.RegistroCobroDiarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDatosAcumuladosArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaDescuentosDiariosArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesamientoVentasDTO;


/**
 * @author egudino
 */
public interface IProcesamientoVentasServicio {
	
	/**
	 * 
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param registroInicial
	 * @param registroFinal
	 * @return
	 */
	Collection<VistaProcesamientoVentasDTO> findFechasCobroParticipantes(Date fechaCobro);
	
	/**
	 * 
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param registroInicial
	 * @param registroFinal
	 * @return
	 */
	Collection<VistaProcesamientoVentasDTO> findParticipantesCobroProyectadoDiario(Date fechaCobro);
	
	/**
	 * True o false si existe algun lote sin procesar de una determinada fecha para atras
	 * @param codigoCompania
	 * @param fecha
	 * @return
	 */
	Boolean findProcesosDatosNoProcesados(Integer codigoCompania, Date fecha);
	
	/**
	 * Registra el dato de cobro por participacion
	 * @param registroConbroDTO
	 */
	void transRegistrarConbroParticipacion(RegistroCobroDTO registroConbroDTO, Integer codigoCompania, String userId);
	
	/**
	 * Registra el dato de cobro por participacion
	 * @param registroConbroDTO
	 */
	void transRegistrarConbroParticipacion(Collection<RegistroCobroDTO> registroConbroDTOCols, VistaProcesamientoVentasDTO vistaProcesamientoDTO, Integer codigoCompania, String userId);
	
	
	/**
	 * Devuelve el utimo registro de conbro para poder sumar el valor acumulado
	 * @param codigoCompania
	 * @param codigoDetalleNegociacion
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 * @return
	 */
	RegistroCobroDTO obtenerUltimoRegistroCobro(Integer codigoCompania, Long codigoDetalleNegociacionGestionPrecioConvenioParticipante);
	
	
	/**
	 * Devuelve el utimo registro de conbro para poder sumar el valor acumulado
	 * @param codigoCompania
	 * @param codigoDetalleNegociacion
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 * @return
	 */
	RegistroCobroDTO findUltimoRegistroCobroImpuesto(Integer codigoCompania, Long codigoDetalleNegociacionGestionPrecioConvenioParticipante, Integer codigoTipoImpuesto);
	
	/**
	 * Metodo para actualizar la plnificacion a estado cobrado
	 * @param codigoPlanificacion
	 * @param codigoCompania
	 * @param userId
	 */
	void transActualizarPlanificacionFechaCobro(Long codigoPlanificacion, Integer codigoCompania, String userId);
	
	
	/**
	 * Actualiza la campania a cobrada
	 * @param vistaProcesamientoDTO
	 * @param codigoCompania
	 * @param userId
	 */
	void transActualizarDatosGeneracionCobros(VistaProcesamientoVentasDTO vistaProcesamientoDTO, Integer codigoCompania, String userId);
	
	/**
	 * Metodo para obtener todos los articulos de un proveedor
	 * @param codigoReferencia
	 * @return
	 */
	Collection<ArticuloProveedorDTO> findArticulosProveedor(String codigoProveedor);
	
	/**
	 * Metodo para obtener el valor acumulado
	 * de articulos de un proveedor
	 * @param codigoCampania
	 * @return
	 */
	Collection<DatosAcumuladosDTO> findDatosAcumuladosCampaniaProveedor(Long codigoCampania, String codigoProveedor);
	
	/**
	 * Vista dinamica para cosultar datos
	 * acumulados por articulo, local e impuesto
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @param codigoProveedor
	 * @return
	 */
	Collection<VistaDatosAcumuladosArticuloLocalDTO> findDatosAcumuladosCampaniaProveedorImpuesto(Integer codigoCompania, Long codigoPromocion, String codigoProveedor);
	
	/**
	 * Vista dinamica para cosultar datos
	 * acumulados por articulo, local e impuesto
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @param codigoProveedor
	 * @return
	 */
	Collection<VistaDatosAcumuladosArticuloLocalDTO> findDatosAcumuladosCampaniaProveedorByImpuesto(Integer codigoCompania, Long codigoPromocion, String codigoProveedor, Integer codigoTipoImpuesto);
	
	/**
	 * Vista dinamica para cosultar datos
	 * acumulados por articulo, local e impuesto
	 * que no pertenescan a los proveedores de la promocion
	 * como el caso de diners
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @param codigoProveedor
	 * @return
	 */
	
	Collection<VistaDatosAcumuladosArticuloLocalDTO> findDatosAcumuladosCampaniaNoProveedorImpuesto(Integer codigoCompania, Long codigoPromocion);
	
	/**
	 * Vista dinamica para cosultar datos
	 * acumulados por articulo, local e impuesto
	 * que no pertenescan a los proveedores de la promocion
	 * como el caso de diners
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @param codigoProveedor
	 * @return
	 */
	Collection<VistaDatosAcumuladosArticuloLocalDTO> findDatosAcumuladosCampaniaNoProveedorByImpuesto(Integer codigoCompania, Long codigoPromocion, Integer codigoTipoImpuesto);
	
	/**
	 * Metodo para obtener el valor acumulado de un promocion
	 * de articulos de un proveedor
	 * @param codigoCampania
	 * @return
	 */
	BigDecimal findTotalDatosAcumuladosPromocionCampania(Integer codigoCompania, Long codigoPromocion);
	
	/**
	 * Metodo para obtener el valor acumulado por articulo local
	 * de articulos de un proveedor
	 * @param codigoCampania
	 * @param codigoArticulo
	 * @return
	 */
	Collection<DatosAcumuladosDTO> findDatosAcumuladosArticulos(Long codigoCampania, String codigoArticulo);
	
	
	/**
	 * Obtiene el valor del iva cobrado
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 */
	TipoImpuestoDTO findIvaCobradoArticulo(Integer codigoCompania, String codigoArticulo);
	
	/**
	 * Obtiene los detalle de negociacion por costo articulo
	 * @param codigoDetalleNegociacion
	 * @return
	 */
	Collection<NegociacionArticuloDTO> findDatosNegociacionArticulos(Long codigoDetalleNegociacion);
	
	/**
	 * Devuelve el utimo registro de cobro detalle
	 * @param codigoCompania
	 * @param codigoRegistroCobro
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @return
	 */
	RegistroCobroDetalleDTO findUltimoRegistroCobroDetalle(Integer codigoCompania, Long codigoRegistroCobro, String codigoLocal, String codigoArticulo, Integer codigoTipoImpuesto);
	
	/**
	 * Total de cuotas
	 * @param codigoCompania
	 * @param codigoDetalleNegociacion
	 * @param codigoNegociacionGestionPrecioConvenioParticipante
	 * @return
	 * @throws SICException
	 */
	Long findTotalCuotasPagar(Integer codigoCompania, Long codigoDetalleNegociacionGestionPrecioConvenioParticipante) throws SICException;
	
	/**
	 * Retorna los tipos de impuestos
	 * @param codigoCompania
	 * @return
	 */
	Collection<TipoImpuestoDTO> findTiposImpuestoIVA(Integer codigoCompania);
	
	/**
	 * Metodo para obtener el valor acumulado 
	 * por articulo el caso costo
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @param codigoArticulo
	 * @return
	 */
	Collection<VistaDatosAcumuladosArticuloLocalDTO> findDatosAcumuladosArticulosCosto(Integer codigoCompania, Long codigoPromocion, String codigoArticulo);
	
	/**
	 * Metodo para obtener el valor acumulado 
	 * por articulo el caso costo
	 * @param codigoCompania
	 * @param codigoPromocion
	 * @param codigoArticulo
	 * @return
	 */
	Collection<VistaDatosAcumuladosArticuloLocalDTO> findDatosAcumuladosArticulosCostoDiario(Integer codigoCompania, Long codigoPromocionLoyalty, String codigoArticulo, Date fecha);
	
	/**
	 * Cantidad de dias que va a estar vigente una promocion
	 * @param codigoCompania
	 * @param codigoReferencia
	 * @return
	 * @throws SICException
	 */
	Long findTotalCuotasCobroDario(Integer codigoCompania, Long codigoReferencia) throws SICException;
	
	/**
	 * Devuelve el ultimo registro de cobro diario para la negociacion 
	 * @param codigoCompania
	 * @param codigoDetalleNegociacionGestionPrecioConvenioParticipante
	 * @param codigoTipoImpuesto
	 * @return
	 */
	RegistroCobroDiarioDTO findUltimoRegistroCobroImpuestoDiario(Integer codigoCompania, Long codigoDetalleNegociacionGestionPrecioConvenioParticipante, Integer codigoTipoImpuesto) throws SICException;
	
	/**
	 * Devuelve el utimo registro de cobro detalle
	 * @param codigoCompania
	 * @param codigoRegistroCobro
	 * @param codigoLocal
	 * @param codigoArticulo
	 * @return
	 */
	RegistroCobroDetalleDiarioDTO findUltimoRegistroCobroDetalleDiario(Integer codigoCompania, Long codigoRegistroCobro, String codigoLocal, String codigoArticulo, Integer codigoTipoImpuesto);
	
	/**
	 * Registra cobros diario proyectados
	 * @param registroConbroDTOCols
	 * @param vistaProcesamientoDTO
	 * @param codigoCompania
	 * @param userId
	 */
	void transRegistrarCobroDiarioProyectado(Collection<RegistroCobroDiarioDTO> registroConbroDTOCols ,VistaProcesamientoVentasDTO vistaProcesamientoDTO, Integer codigoCompania, String userId);
	
	/**
	 * True o false si existe registros diarios para la
	 * fecha y codigo enviado
	 * @param codigoCompania
	 * @param fecha
	 * @return
	 */
	Boolean findCobroDiarioPryectadoByCodigoyFecha(Integer codigoCompania, Long codigoDetalleNegociacionGestionPrecioConvenioParticipante, Date fecha);
	
	/**
	 * Metodo para obtnere los descuentos diarios por promocion 
	 * cuando el participante no es proveedor
	 * @param codigoCompania
	 * @param codigoPromocionLoyalty
	 * @param fechaDescuento
	 * @return
	 */
	Collection<VistaDescuentosDiariosArticuloLocalDTO> findDescuentosDiariosParticipanteCuandoNoesProveedorPorImpuesto(Integer codigoCompania, Long codigoPromocionLoyalty, Date fechaDescuento, Integer codigoTipoImpuesto) throws SICException;
	
	/**
	 * Metodo para obtnere los descuentos diarios por promocion 
	 * cuando el participante es proveedor
	 * @param codigoCompania
	 * @param codigoPromocionLoyalty
	 * @param codigoProveedor
	 * @param codigoTipoImpuesto
	 * @param fecha
	 * @return
	 */
	Collection<VistaDescuentosDiariosArticuloLocalDTO> findDescuentosDiariosParticipanteCuandoEsProveedorPorImpuesto(Integer codigoCompania, Long codigoPromocionLoyalty, String codigoProveedor, Integer codigoTipoImpuesto, Date fecha) throws SICException;
}
