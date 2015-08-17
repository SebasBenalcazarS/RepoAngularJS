/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;

/**
 * @author finga
 *
 */
@SuppressWarnings("serial")
public class FacturaDigitalEST extends SimpleAuditDTO {

	private String codigoArticulo;
	private Date fechaCaducidad;
	private String tipoEntrega;
	private BigDecimal costoNeto;
	private Integer cantidadPedida;
	private BigDecimal pesoPedido;
	private BigDecimal pesoDetalleFactura;
	private BigDecimal costoProveedor;
	/**
	 * cantidad total de los detalles de la factura consolidado 
	 */
	private Integer cantidadDetalleFactura;
	
	private Long codigoUnidadManejo;
	private Long codigoFactura;
	private Integer diferenciaOrdenCompra;
	private BigDecimal diferenciaPesoVariadoOrdenCompra;
	private Integer cantidadDisponiblePlanificada;
	private String codigosOrdenCompra;
	private Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs;
	private ArticuloUnidadManejoDTO articuloUnidadManejoDTO;
	private OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO;
	private BodegaDTO subbodega;
	private AreaTrabajoDTO areaTrabajoDTO;
	private String numerosOrdenCompra;
	
	

	public Collection<OrdenCompraDetalleEstadoDTO> getOrdenCompraDetalleEstadoDTOs() {
		return ordenCompraDetalleEstadoDTOs;
	}

	public void setOrdenCompraDetalleEstadoDTOs(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) {
		this.ordenCompraDetalleEstadoDTOs = ordenCompraDetalleEstadoDTOs;
	}

	public OrdenCompraDetalleEstadoDTO getOrdenCompraDetalleEstadoDTO() {
		return ordenCompraDetalleEstadoDTO;
	}

	public void setOrdenCompraDetalleEstadoDTO(OrdenCompraDetalleEstadoDTO ordenCompraDetalleEstadoDTO) {
		this.ordenCompraDetalleEstadoDTO = ordenCompraDetalleEstadoDTO;
	}

	public Integer getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public ArticuloUnidadManejoDTO getArticuloUnidadManejoDTO() {
		return articuloUnidadManejoDTO;
	}

	public void setArticuloUnidadManejoDTO(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) {
		this.articuloUnidadManejoDTO = articuloUnidadManejoDTO;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Integer getDiferenciaOrdenCompra() {
		return diferenciaOrdenCompra;
	}

	public void setDiferenciaOrdenCompra(Integer diferenciaOrdenCompra) {
		this.diferenciaOrdenCompra = diferenciaOrdenCompra;
	}

	public String getCodigosOrdenCompra() {
		return codigosOrdenCompra;
	}

	public void setCodigosOrdenCompra(String codigosOrdenCompra) {
		this.codigosOrdenCompra = codigosOrdenCompra;
	}

	public String getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public BigDecimal getCostoNeto() {
		return costoNeto;
	}

	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}

	public BodegaDTO getSubbodega() {
		return subbodega;
	}

	public void setSubbodega(BodegaDTO subbodega) {
		this.subbodega = subbodega;
	}

	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}
	
	public Integer getCantidadDisponiblePlanificada() {
		return cantidadDisponiblePlanificada;
	}

	public void setCantidadDisponiblePlanificada(Integer cantidadDisponiblePlanificada) {
		this.cantidadDisponiblePlanificada = cantidadDisponiblePlanificada;
	}

	/**
	 * @return the codigoFactura
	 */
	public Long getCodigoFactura() {
		return codigoFactura;
	}

	/**
	 * @param codigoFactura the codigoFactura to set
	 */
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public Integer getCantidadDetalleFactura() {
		return cantidadDetalleFactura;
	}

	public void setCantidadDetalleFactura(Integer cantidadDetalleFactura) {
		this.cantidadDetalleFactura = cantidadDetalleFactura;
	}

	public AreaTrabajoDTO getAreaTrabajoDTO() {
		return areaTrabajoDTO;
	}

	public void setAreaTrabajoDTO(AreaTrabajoDTO areaTrabajoDTO) {
		this.areaTrabajoDTO = areaTrabajoDTO;
	}

	public String getNumerosOrdenCompra() {
		return numerosOrdenCompra;
	}

	public void setNumerosOrdenCompra(String numerosOrdenCompra) {
		this.numerosOrdenCompra = numerosOrdenCompra;
	}

	/**
	 * @return the pesoPedido
	 */
	public BigDecimal getPesoPedido() {
		return pesoPedido;
	}

	/**
	 * @param pesoPedido the pesoPedido to set
	 */
	public void setPesoPedido(BigDecimal pesoPedido) {
		this.pesoPedido = pesoPedido;
	}

	public BigDecimal getCostoProveedor() {
		return costoProveedor;
	}

	public void setCostoProveedor(BigDecimal costoProveedor) {
		this.costoProveedor = costoProveedor;
	}

	public BigDecimal getPesoDetalleFactura() {
		return pesoDetalleFactura;
	}

	public void setPesoDetalleFactura(BigDecimal pesoDetalleFactura) {
		this.pesoDetalleFactura = pesoDetalleFactura;
	}

	public BigDecimal getDiferenciaPesoVariadoOrdenCompra() {
		return diferenciaPesoVariadoOrdenCompra;
	}

	public void setDiferenciaPesoVariadoOrdenCompra(BigDecimal diferenciaPesoVariadoOrdenCompra) {
		this.diferenciaPesoVariadoOrdenCompra = diferenciaPesoVariadoOrdenCompra;
	}

	

}
