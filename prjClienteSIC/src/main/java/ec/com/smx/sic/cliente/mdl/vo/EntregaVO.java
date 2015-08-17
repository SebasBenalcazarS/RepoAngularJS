package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.autorizaciones.dto.AutorizacionDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.RangeValue;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.CalendarioBodegaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDetalleCalendarioProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioEntregaBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCalendarioPlanificacionBodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;

@SuppressWarnings("serial")
public class EntregaVO extends BaseVO<EntregaDTO>{

	//private EntregaDTO entregaDTO;
	private String codigoBodega;
	private String codigoProveedor;
	private Integer codigoAreaTrabajoBodega;
	private BodegaDTO bodegaDTO;
	private ProveedorDTO proveedorDTO;
	private VistaProveedorDTO  vistaProveedorDTO;	
	private Collection<EntregaDTO> entregaDTOs;
	private Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs;
	private Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs;
	private Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOSeleccionados;
	private CatalogoValorDTO tipoPedidoCatVal;
	private FacturaDTO facturaDTO;
	private FacturaEstadoDTO facturaEstadoDTO;
	private Collection<FacturaDTO> facturaDTOs;
	private Collection<FacturaEstadoDTO> facturaEstadoDTOs;
	private Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOs;
	private EntregaEstadoDTO entregaEstadoDTO;
	private Collection<EntregaOrdenCompraEstadoDTO> entregaOrdenCompraEstadoDTOs;
	private Collection<CalendarioBodegaProveedorDTO> calendarioBodegaProveedorDTOs;
	private RangeValue<Date> rangeFechaEntrega;
	private RangeValue<Date> rangeHoraEntrega;
	private AutorizacionDTO autorizacionDTO;
	private VistaCalendarioEntregaBodegaDTO vistaCalendarioEntregaBodegaDTO;
	private Collection<VistaCalendarioEntregaBodegaDTO> vistaCalendarioEntregaBodegaDTOs;
	private Collection<VistaCalendarioEntregaBodegaDTO> fechasAutorizacionAndenes;
	private Collection<VistaCalendarioPlanificacionBodegaDTO> vistaCalendarioPlanificacionBodegaDTOs;
	private Collection<FacturaEstadoImpuestoDTO> facturaEstadoImpuestoDTOs;
	private Collection<FacturaDigitalEST> facturaDigitalESTs;
	private Collection<FacturaDigitalEST> facturaDigitalESTSeleccionados; 
	private Collection<EntregaDetalleCalendarioProveedorDTO> entregaDetalleCalendarioProveedorDTOs;
	private Date fechaAutorizacionEntrega;
	private Long codigoOrdenCompra;
	private String numeroOrdenCompra;
	private Map<FacturaEstadoDTO, Collection<OrdenCompraDetalleEstadoDTO>> facturasEntrega;
	
	/**
	 * @return the codigoBodega
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}
	/**
	 * @param codigoBodega the codigoBodega to set
	 */
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
	/**
	 * @return the bodegaDTO
	 */
	public BodegaDTO getBodegaDTO() {
		return bodegaDTO;
	}
	/**
	 * @param bodegaDTO the bodegaDTO to set
	 */
	public void setBodegaDTO(BodegaDTO bodegaDTO) {
		this.bodegaDTO = bodegaDTO;
	}
	/**
	 * @return the entregaDTOs
	 */
	public Collection<EntregaDTO> getEntregaDTOs() {
		return entregaDTOs;
	}
	/**
	 * @param entregaDTOs the entregaDTOs to set
	 */
	public void setEntregaDTOs(Collection<EntregaDTO> entregaDTOs) {
		this.entregaDTOs = entregaDTOs;
	}
	/**
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}
	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}
	/**
	 * @return the ordenCompraDetalleEstadoDTOs
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> getOrdenCompraDetalleEstadoDTOs() {
		return ordenCompraDetalleEstadoDTOs;
	}
	/**
	 * @param ordenCompraDetalleEstadoDTOs the ordenCompraDetalleEstadoDTOs to set
	 */
	public void setOrdenCompraDetalleEstadoDTOs(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) {
		this.ordenCompraDetalleEstadoDTOs = ordenCompraDetalleEstadoDTOs;
	}
	/**
	 * @return the tipoPedidoCatVal
	 */
	public CatalogoValorDTO getTipoPedidoCatVal() {
		return tipoPedidoCatVal;
	}
	/**
	 * @param tipoPedidoCatVal the tipoPedidoCatVal to set
	 */
	public void setTipoPedidoCatVal(CatalogoValorDTO tipoPedidoCatVal) {
		this.tipoPedidoCatVal = tipoPedidoCatVal;
	}
	/**
	 * @return the ordenCompraEstadoDTOs
	 */
	public Collection<OrdenCompraEstadoDTO> getOrdenCompraEstadoDTOs() {
		return ordenCompraEstadoDTOs;
	}
	/**
	 * @param ordenCompraEstadoDTOs the ordenCompraEstadoDTOs to set
	 */
	public void setOrdenCompraEstadoDTOs(
			Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs) {
		this.ordenCompraEstadoDTOs = ordenCompraEstadoDTOs;
	}
	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	/**
	 * @return the proveedorDTO
	 */
	public ProveedorDTO getProveedorDTO() {
		return proveedorDTO;
	}
	/**
	 * @param proveedorDTO the proveedorDTO to set
	 */
	public void setProveedorDTO(ProveedorDTO proveedorDTO) {
		this.proveedorDTO = proveedorDTO;
	}
	/**
	 * @return the vistaProveedorDTO
	 */
	public VistaProveedorDTO getVistaProveedorDTO() {
		return vistaProveedorDTO;
	}
	/**
	 * @param vistaProveedorDTO the vistaProveedorDTO to set
	 */
	public void setVistaProveedorDTO(VistaProveedorDTO vistaProveedorDTO) {
		this.vistaProveedorDTO = vistaProveedorDTO;
	}
	/**
	 * @return the facturaDTO
	 */
	public FacturaDTO getFacturaDTO() {
		return facturaDTO;
	}
	/**
	 * @param facturaDTO the facturaDTO to set
	 */
	public void setFacturaDTO(FacturaDTO facturaDTO) {
		this.facturaDTO = facturaDTO;
	}
	/**
	 * @return the facturaDTOs
	 */
	public Collection<FacturaDTO> getFacturaDTOs() {
		return facturaDTOs;
	}
	/**
	 * @param facturaDTOs the facturaDTOs to set
	 */
	public void setFacturaDTOs(Collection<FacturaDTO> facturaDTOs) {
		this.facturaDTOs = facturaDTOs;
	}
	/**
	 * @return the ordenCompraDetalleEstadoDTOSeleccionados
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> getOrdenCompraDetalleEstadoDTOSeleccionados() {
		return ordenCompraDetalleEstadoDTOSeleccionados;
	}
	/**
	 * @param ordenCompraDetalleEstadoDTOSeleccionados the ordenCompraDetalleEstadoDTOSeleccionados to set
	 */
	public void setOrdenCompraDetalleEstadoDTOSeleccionados(
			Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOSeleccionados) {
		this.ordenCompraDetalleEstadoDTOSeleccionados = ordenCompraDetalleEstadoDTOSeleccionados;
	}
	/**
	 * @return the facturaEstadoDTOs
	 */
	public Collection<FacturaEstadoDTO> getFacturaEstadoDTOs() {
		return facturaEstadoDTOs;
	}
	/**
	 * @param facturaEstadoDTOs the facturaEstadoDTOs to set
	 */
	public void setFacturaEstadoDTOs(Collection<FacturaEstadoDTO> facturaEstadoDTOs) {
		this.facturaEstadoDTOs = facturaEstadoDTOs;
	}
	/**
	 * @return the entregaEstadoDTO
	 */
	public EntregaEstadoDTO getEntregaEstadoDTO() {
		return entregaEstadoDTO;
	}
	/**
	 * @param entregaEstadoDTO the entregaEstadoDTO to set
	 */
	public void setEntregaEstadoDTO(EntregaEstadoDTO entregaEstadoDTO) {
		this.entregaEstadoDTO = entregaEstadoDTO;
	}
	/**
	 * @return the entregaOrdenCompraEstadoDTOs
	 */
	public Collection<EntregaOrdenCompraEstadoDTO> getEntregaOrdenCompraEstadoDTOs() {
		return entregaOrdenCompraEstadoDTOs;
	}
	/**
	 * @param entregaOrdenCompraEstadoDTOs the entregaOrdenCompraEstadoDTOs to set
	 */
	public void setEntregaOrdenCompraEstadoDTOs(
			Collection<EntregaOrdenCompraEstadoDTO> entregaOrdenCompraEstadoDTOs) {
		this.entregaOrdenCompraEstadoDTOs = entregaOrdenCompraEstadoDTOs;
	}
	/**
	 * @return the facturaEstadoDTO
	 */
	public FacturaEstadoDTO getFacturaEstadoDTO() {
		return facturaEstadoDTO;
	}
	/**
	 * @param facturaEstadoDTO the facturaEstadoDTO to set
	 */
	public void setFacturaEstadoDTO(FacturaEstadoDTO facturaEstadoDTO) {
		this.facturaEstadoDTO = facturaEstadoDTO;
	}
	/**
	 * @param detalleFacturaEstadoDTOs the detalleFacturaEstadoDTOs to set
	 */
	public void setDetalleFacturaEstadoDTOs(
			Collection<DetalleFacturaEstadoDTO> detalleFacturaEstadoDTOs) {
		this.detalleFacturaEstadoDTOs = detalleFacturaEstadoDTOs;
	}
	/**
	 * @return the detalleFacturaEstadoDTOs
	 */
	public Collection<DetalleFacturaEstadoDTO> getDetalleFacturaEstadoDTOs() {
		return detalleFacturaEstadoDTOs;
	}
	/**
	 * @return the calendarioBodegaProveedorDTOs
	 */
	public Collection<CalendarioBodegaProveedorDTO> getCalendarioBodegaProveedorDTOs() {
		return calendarioBodegaProveedorDTOs;
	}
	/**
	 * @param calendarioBodegaProveedorDTOs the calendarioBodegaProveedorDTOs to set
	 */
	public void setCalendarioBodegaProveedorDTOs(Collection<CalendarioBodegaProveedorDTO> calendarioBodegaProveedorDTOs) {
		this.calendarioBodegaProveedorDTOs = calendarioBodegaProveedorDTOs;
	}
	/**
	 * @return the rangeFechaEntrega
	 */
	public RangeValue<Date> getRangeFechaEntrega() {
		return rangeFechaEntrega;
	}
	/**
	 * @param rangeFechaEntrega the rangeFechaEntrega to set
	 */
	public void setRangeFechaEntrega(RangeValue<Date> rangeFechaEntrega) {
		this.rangeFechaEntrega = rangeFechaEntrega;
	}
	/**
	 * @return the rangeHoraEntrega
	 */
	public RangeValue<Date> getRangeHoraEntrega() {
		return rangeHoraEntrega;
	}
	/**
	 * @param rangeHoraEntrega the rangeHoraEntrega to set
	 */
	public void setRangeHoraEntrega(RangeValue<Date> rangeHoraEntrega) {
		this.rangeHoraEntrega = rangeHoraEntrega;
	}
	/**
	 * @return the autorizacionDTO
	 */
	public AutorizacionDTO getAutorizacionDTO() {
		return autorizacionDTO;
	}
	/**
	 * @param autorizacionDTO the autorizacionDTO to set
	 */
	public void setAutorizacionDTO(AutorizacionDTO autorizacionDTO) {
		this.autorizacionDTO = autorizacionDTO;
	}
	/**
	 * @return the vistaCalendarioEntregaBodegaDTO
	 */
	public VistaCalendarioEntregaBodegaDTO getVistaCalendarioEntregaBodegaDTO() {
		return vistaCalendarioEntregaBodegaDTO;
	}
	/**
	 * @param vistaCalendarioEntregaBodegaDTO the vistaCalendarioEntregaBodegaDTO to set
	 */
	public void setVistaCalendarioEntregaBodegaDTO(VistaCalendarioEntregaBodegaDTO vistaCalendarioEntregaBodegaDTO) {
		this.vistaCalendarioEntregaBodegaDTO = vistaCalendarioEntregaBodegaDTO;
	}
	/**
	 * @return the vistaCalendarioEntregaBodegaDTOs
	 */
	public Collection<VistaCalendarioEntregaBodegaDTO> getVistaCalendarioEntregaBodegaDTOs() {
		return vistaCalendarioEntregaBodegaDTOs;
	}
	/**
	 * @param vistaCalendarioEntregaBodegaDTOs the vistaCalendarioEntregaBodegaDTOs to set
	 */
	public void setVistaCalendarioEntregaBodegaDTOs(Collection<VistaCalendarioEntregaBodegaDTO> vistaCalendarioEntregaBodegaDTOs) {
		this.vistaCalendarioEntregaBodegaDTOs = vistaCalendarioEntregaBodegaDTOs;
	}
	/**
	 * @return the vistaCalendarioPlanificacionBodegaDTOs
	 */
	public Collection<VistaCalendarioPlanificacionBodegaDTO> getVistaCalendarioPlanificacionBodegaDTOs() {
		return vistaCalendarioPlanificacionBodegaDTOs;
	}
	/**
	 * @param vistaCalendarioPlanificacionBodegaDTOs the vistaCalendarioPlanificacionBodegaDTOs to set
	 */
	public void setVistaCalendarioPlanificacionBodegaDTOs(Collection<VistaCalendarioPlanificacionBodegaDTO> vistaCalendarioPlanificacionBodegaDTOs) {
		this.vistaCalendarioPlanificacionBodegaDTOs = vistaCalendarioPlanificacionBodegaDTOs;
	}
	
	/**
	 * @return the fechasAutorizacionAndenes
	 */
	public Collection<VistaCalendarioEntregaBodegaDTO> getFechasAutorizacionAndenes() {
		return fechasAutorizacionAndenes;
	}
	/**
	 * @param fechasAutorizacionAndenes the fechasAutorizacionAndenes to set
	 */
	public void setFechasAutorizacionAndenes(Collection<VistaCalendarioEntregaBodegaDTO> fechasAutorizacionAndenes) {
		this.fechasAutorizacionAndenes = fechasAutorizacionAndenes;
	}
	/**
	 * @return the facturaEstadoImpuestoDTOs
	 */
	public Collection<FacturaEstadoImpuestoDTO> getFacturaEstadoImpuestoDTOs() {
		return facturaEstadoImpuestoDTOs;
	}
	/**
	 * @param facturaEstadoImpuestoDTOs the facturaEstadoImpuestoDTOs to set
	 */
	public void setFacturaEstadoImpuestoDTOs(Collection<FacturaEstadoImpuestoDTO> facturaEstadoImpuestoDTOs) {
		this.facturaEstadoImpuestoDTOs = facturaEstadoImpuestoDTOs;
	}
	/**
	 * @return the facturaDigitalESTs
	 */
	public Collection<FacturaDigitalEST> getFacturaDigitalESTs() {
		return facturaDigitalESTs;
	}
	/**
	 * @param facturaDigitalESTs the facturaDigitalESTs to set
	 */
	public void setFacturaDigitalESTs(Collection<FacturaDigitalEST> facturaDigitalESTs) {
		this.facturaDigitalESTs = facturaDigitalESTs;
	}
	
	/**
	 * @return the facturaDigitalESTSeleccionados
	 */
	public Collection<FacturaDigitalEST> getFacturaDigitalESTSeleccionados() {
		return facturaDigitalESTSeleccionados;
	}
	
	/**
	 * @param facturaDigitalESTSeleccionados the facturaDigitalESTSeleccionados to set
	 */
	public void setFacturaDigitalESTSeleccionados(Collection<FacturaDigitalEST> facturaDigitalESTSeleccionados) {
		this.facturaDigitalESTSeleccionados = facturaDigitalESTSeleccionados;
	}
	public Collection<EntregaDetalleCalendarioProveedorDTO> getEntregaDetalleCalendarioProveedorDTOs() {
		return entregaDetalleCalendarioProveedorDTOs;
	}
	public void setEntregaDetalleCalendarioProveedorDTOs(Collection<EntregaDetalleCalendarioProveedorDTO> entregaDetalleCalendarioProveedorDTOs) {
		this.entregaDetalleCalendarioProveedorDTOs = entregaDetalleCalendarioProveedorDTOs;
	}
	public Date getFechaAutorizacionEntrega() {
		return fechaAutorizacionEntrega;
	}
	public void setFechaAutorizacionEntrega(Date fechaAutorizacionEntrega) {
		this.fechaAutorizacionEntrega = fechaAutorizacionEntrega;
	}
	/**
	 * getCodigoOrdenCompra
	 * @return
	 */
	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}
	/**
	 * setCodigoOrdenCompra
	 * @param codigoOrdenCompra
	 */
	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}
	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}
	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}
	public Map<FacturaEstadoDTO, Collection<OrdenCompraDetalleEstadoDTO>> getFacturasEntrega() {
		return facturasEntrega;
	}
	public void setFacturasEntrega(Map<FacturaEstadoDTO, Collection<OrdenCompraDetalleEstadoDTO>> facturasEntrega) {
		this.facturasEntrega = facturasEntrega;
	}

}
