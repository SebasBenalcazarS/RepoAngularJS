package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaRecepcionCantidadesRecibidasID;

@Entity
@SuppressWarnings("serial")
public class VistaRecepcionCantidadesRecibidasDTO implements Serializable {
	
	@EmbeddedId
	private VistaRecepcionCantidadesRecibidasID id = new VistaRecepcionCantidadesRecibidasID();
	
	private String codigoArticulo;
	
	private Long codigoUnidadManejo;
	
	private Integer valorUnidadManejo;
	
	private String valorTipoUnidadEmpaque;
	
	private String descripcionArticulo;
	
	private String codigoBarras;
	
	private Integer cantidadRecibida;
	
	private String codigoClasificacionPadre;
	
	private String referenciaMedida;
	
    private BigDecimal costoNeto;
   
    private BigDecimal costoBruto;
    
    private Double pesoAproximadoRecepcion;
    
    private String codigoReferenciaInterna;
    
    private Long codigoPedido;
    
    private Integer plazoPago;
    
	private BigDecimal peso;
	
	private String valorTipoControlCosto;
    
    @Transient
    private Collection<OrdenCompraDetalleEstadoDescuentoDTO> descuentosDetalle;
 
    @Transient
    private BigDecimal valorTotal;
    
    /**
     * Trasinent utilizados por Entrega B2B
     */
    @Transient
    private BigDecimal numeroFactura;
    
    @Transient
    private Long codigoFactura;
	
	/**
	 * @return the id
	 */
	public VistaRecepcionCantidadesRecibidasID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaRecepcionCantidadesRecibidasID id) {
		this.id = id;
	}

	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the valorUnidadManejo
	 */
	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	/**
	 * @param valorUnidadManejo the valorUnidadManejo to set
	 */
	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}

	/**
	 * @return the valorTipoUnidadEmpaque
	 */
	public String getValorTipoUnidadEmpaque() {
		return valorTipoUnidadEmpaque;
	}

	/**
	 * @param valorTipoUnidadEmpaque the valorTipoUnidadEmpaque to set
	 */
	public void setValorTipoUnidadEmpaque(String valorTipoUnidadEmpaque) {
		this.valorTipoUnidadEmpaque = valorTipoUnidadEmpaque;
	}

	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * @return the cantidadRecibida
	 */
	public Integer getCantidadRecibida() {
		return cantidadRecibida;
	}

	/**
	 * @param cantidadRecibida the cantidadRecibida to set
	 */
	public void setCantidadRecibida(Integer cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	/**
	 * @return the costoNeto
	 */
	public BigDecimal getCostoNeto() {
		return costoNeto;
	}

	/**
	 * @param costoNeto the costoNeto to set
	 */
	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}

	/**
	 * @return the codigoClasificacionPadre
	 */
	public String getCodigoClasificacionPadre() {
		return codigoClasificacionPadre;
	}

	/**
	 * @param codigoClasificacionPadre the codigoClasificacionPadre to set
	 */
	public void setCodigoClasificacionPadre(String codigoClasificacionPadre) {
		this.codigoClasificacionPadre = codigoClasificacionPadre;
	}

	/**
	 * @return the referenciaMedida
	 */
	public String getReferenciaMedida() {
		return referenciaMedida;
	}

	/**
	 * @param referenciaMedida the referenciaMedida to set
	 */
	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}

	/**
	 * @return the costoBruto
	 */
	public BigDecimal getCostoBruto() {
		return costoBruto;
	}

	/**
	 * @param costoBruto the costoBruto to set
	 */
	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}

	/**
	 * @return the valorTotal
	 */
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal the valorTotal to set
	 */
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
		if (plazoPago == null) {
			this.plazoPago = 0;
		} else {
			this.plazoPago = plazoPago;
		}
	}

	public Collection<OrdenCompraDetalleEstadoDescuentoDTO> getDescuentosDetalle() {
		return descuentosDetalle;
	}

	public void setDescuentosDetalle(Collection<OrdenCompraDetalleEstadoDescuentoDTO> descuentosDetalle) {
		this.descuentosDetalle = descuentosDetalle;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}

	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}

	/**
	 * @return the numeroFactura
	 */
	public BigDecimal getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * @param numeroFactura the numeroFactura to set
	 */
	public void setNumeroFactura(BigDecimal numeroFactura) {
		this.numeroFactura = numeroFactura;
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

	
}
