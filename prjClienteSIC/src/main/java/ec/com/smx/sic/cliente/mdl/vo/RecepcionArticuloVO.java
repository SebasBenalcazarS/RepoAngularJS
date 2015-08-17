package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoImpuestoDTO;

@SuppressWarnings("serial")
public class RecepcionArticuloVO implements Serializable {
	
	private Integer codigoCompania;
	
	private String codigoArticulo;
	
	private Long codigoUnidadManejo;
	
	private Long codigoOrdenCompraDetalleEstado;
	
	private Integer valorUnidadManejo;
	
	private String valorTipoUnidadEmpaque;
	
	private String descripcionArticulo;
	
	private String codigoBarras;
	
	private Integer cantidadRecibida;
	
	private String codigoClasificacionPadre;
	
	private String referenciaMedida;
	
    private BigDecimal costoNeto;
   
    private BigDecimal costoBruto;
 
    private BigDecimal valorTotal;
    
    private Double pesoAproximadoRecepcion;
    
    private String codigoReferenciaInterna;
    
    private Long codigoPedido;
    
    private Integer plazoPago;
    
    private String valorTipoControlCosto;
    
    private BigDecimal pesoJaba;
    
    private Map<Integer, OrdenCompraDetalleEstadoImpuestoDTO> detalleImpuestos = new HashMap<Integer, OrdenCompraDetalleEstadoImpuestoDTO>();
    
    private Map<String, BigDecimal> mapDescuentos = new HashMap<String, BigDecimal>();
    
	public OrdenCompraDetalleEstadoImpuestoDTO getImpuestoPorIdMap(Integer idMapImpuesto) {
		return (OrdenCompraDetalleEstadoImpuestoDTO) detalleImpuestos.get(idMapImpuesto);
	}
    
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}

	public String getValorTipoUnidadEmpaque() {
		return valorTipoUnidadEmpaque;
	}

	public void setValorTipoUnidadEmpaque(String valorTipoUnidadEmpaque) {
		this.valorTipoUnidadEmpaque = valorTipoUnidadEmpaque;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidadRecibida() {
		return cantidadRecibida;
	}

	public void setCantidadRecibida(Integer cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	public String getCodigoClasificacionPadre() {
		return codigoClasificacionPadre;
	}

	public void setCodigoClasificacionPadre(String codigoClasificacionPadre) {
		this.codigoClasificacionPadre = codigoClasificacionPadre;
	}

	public String getReferenciaMedida() {
		return referenciaMedida;
	}

	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}

	public BigDecimal getCostoNeto() {
		return costoNeto;
	}

	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}

	public BigDecimal getCostoBruto() {
		return costoBruto;
	}

	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getPesoAproximadoRecepcion() {
		return pesoAproximadoRecepcion;
	}

	public void setPesoAproximadoRecepcion(Double pesoAproximadoRecepcion) {
		this.pesoAproximadoRecepcion = pesoAproximadoRecepcion;
	}

	public String getCodigoReferenciaInterna() {
		return codigoReferenciaInterna;
	}

	public void setCodigoReferenciaInterna(String codigoReferenciaInterna) {
		this.codigoReferenciaInterna = codigoReferenciaInterna;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Integer getPlazoPago() {
		return plazoPago;
	}

	public void setPlazoPago(Integer plazoPago) {
		this.plazoPago = plazoPago;
	}

	public Map<String, BigDecimal> getMapDescuentos() {
		return mapDescuentos;
	}

	public void setMapDescuentos(Map<String, BigDecimal> mapDescuentos) {
		this.mapDescuentos = mapDescuentos;
	}

	public BigDecimal getPesoJaba() {
		return pesoJaba;
	}

	public void setPesoJaba(BigDecimal pesoJaba) {
		this.pesoJaba = pesoJaba;
	}

	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}

	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}

	public Map<Integer, OrdenCompraDetalleEstadoImpuestoDTO> getDetalleImpuestos() {
		return detalleImpuestos;
	}

	public void setDetalleImpuestos(Map<Integer, OrdenCompraDetalleEstadoImpuestoDTO> detalleImpuestos) {
		this.detalleImpuestos = detalleImpuestos;
	}

	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}

}
