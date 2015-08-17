package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDescuentoDTO;

/**
 * @author Marcelo Hidalgo
 *
 */
@SuppressWarnings("serial")
public class DatosArticuloOrdenCompra implements Serializable{

	private String codigoArticulo;
	private String codigoBarras;
	private String descripcionArticulo;
	private String codigoProveedor;
	private BigDecimal costoBruto;
	private BigDecimal costoNeto;
	private Boolean existeConflictoCambioPrecio;
	private Boolean existeArticuloEnCambioPrecio;
	private Double costoBrutoCambioPrecio;
	private Double costoNetoCambioPrecio;
	private Long codigoOrdenCompra;
	private Long codigoOrdenCompraGestion;
	
	//variables para conflictos con condiciones comerciales
	private String codigoClasificacion;
	private Collection<OrdenCompraDetalleEstadoDescuentoDTO> descuentosArticuloOrdenCompra;

	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public BigDecimal getCostoBruto() {
		return costoBruto;
	}

	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}

	public Boolean getExisteConflictoCambioPrecio() {
		return existeConflictoCambioPrecio;
	}

	public void setExisteConflictoCambioPrecio(Boolean existeConflictoCambioPrecio) {
		this.existeConflictoCambioPrecio = existeConflictoCambioPrecio;
	}

	public Double getCostoBrutoCambioPrecio() {
		return costoBrutoCambioPrecio;
	}

	public void setCostoBrutoCambioPrecio(Double costoBrutoCambioPrecio) {
		this.costoBrutoCambioPrecio = costoBrutoCambioPrecio;
	}

	public Boolean getExisteArticuloEnCambioPrecio() {
		return existeArticuloEnCambioPrecio;
	}

	public void setExisteArticuloEnCambioPrecio(Boolean existeArticuloEnCambioPrecio) {
		this.existeArticuloEnCambioPrecio = existeArticuloEnCambioPrecio;
	}

	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	public Long getCodigoOrdenCompraGestion() {
		return codigoOrdenCompraGestion;
	}

	public void setCodigoOrdenCompraGestion(Long codigoOrdenCompraGestion) {
		this.codigoOrdenCompraGestion = codigoOrdenCompraGestion;
	}

	public BigDecimal getCostoNeto() {
		return costoNeto;
	}

	public void setCostoNeto(BigDecimal costoNeto) {
		this.costoNeto = costoNeto;
	}

	public Double getCostoNetoCambioPrecio() {
		return costoNetoCambioPrecio;
	}

	public void setCostoNetoCambioPrecio(Double costoNetoCambioPrecio) {
		this.costoNetoCambioPrecio = costoNetoCambioPrecio;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public Collection<OrdenCompraDetalleEstadoDescuentoDTO> getDescuentosArticuloOrdenCompra() {
		return descuentosArticuloOrdenCompra;
	}

	public void setDescuentosArticuloOrdenCompra(Collection<OrdenCompraDetalleEstadoDescuentoDTO> descuentosArticuloOrdenCompra) {
		this.descuentosArticuloOrdenCompra = descuentosArticuloOrdenCompra;
	}

}
