package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

@SuppressWarnings("serial")
public class ProcesoLogisticoVO extends BaseVO<ProcesoLogisticoDTO>{

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
	public void setOrdenCompraDetalleEstadoDTOs(
			Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) {
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
	
}
