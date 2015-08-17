/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;
import ec.com.smx.sic.cliente.mdl.dto.HistorialPrecioDiferenciadoArticuloDTO;

/**
 * @author dgutierrez
 *
 */
@SuppressWarnings("serial")
public class DatosHistorialCambioPrecio extends SearchDTO {

	// id
	private Long codigoHistorialPrecio;
	
	// articulo
	private String codigoArticulo;	
	private String codigoBarras;
	private String descripcionArticulo;
	
	// proveedor
	private String codigoProveedor;
	private String nombreProveedor;
	private String rucProveedor;

	// clasificacion
	private String codigoClasificacion;
	private String descripcionClasificacion;

	private Boolean tienePreciosDiferenciados;
	private Integer tamano;
	private String estado;
	
	private Date fechaVigenciaCostos;
	private Date fechaVigenciaRetornoCostos;
	private Date fechaVigenciaPrecios;
	private Date fechaVigenciaRetornoPrecios;
	
	private Double inflacionCosto;
	private Double inflacionVenta;

	private Double costoBrutoAnterior;
	private Double costoNetoNcAnterior;
	private Double costoNetoAnterior;
	private Double precioPVPAnterior;	
	private Double precioSMXAnterior;		
	private Double precioSMXnaAnterior;	
	private Double psmxOfertaLocalAnterior;

	private Double costoBrutoNuevo;
	private Double costoNetoNcNuevo;
	private Double costoNetoNuevo;
	private Double precioPVPNuevo;	
	private Double precioSMXNuevo;		
	private Double precioSMXnaNuevo;
	private Double psmxOfertaLocalNuevo;
	
	private Double variacionCostoBruto;
	private Double variacionVenta;

	private Collection<HistorialPrecioDiferenciadoArticuloDTO> historialPreciosDiferenciados;

	public DatosHistorialCambioPrecio() {
		this.setEstado(EstadoGestionPrecio.AUTORIZADO.getLabelEstadoGestionPrecio());
	}
	
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Long getCodigoHistorialPrecio() {
		return codigoHistorialPrecio;
	}

	public void setCodigoHistorialPrecio(Long codigoHistorialPrecio) {
		this.codigoHistorialPrecio = codigoHistorialPrecio;
	}

	public String getRucProveedor() {
		return rucProveedor;
	}

	public void setRucProveedor(String rucProveedor) {
		this.rucProveedor = rucProveedor;
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

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public Boolean getTienePreciosDiferenciados() {
		return tienePreciosDiferenciados;
	}

	public void setTienePreciosDiferenciados(Boolean tienePreciosDiferenciados) {
		this.tienePreciosDiferenciados = tienePreciosDiferenciados;
	}

	public Integer getTamano() {
		return tamano;
	}

	public void setTamano(Integer tamano) {
		this.tamano = tamano;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public String getDescripcionClasificacion() {
		return descripcionClasificacion;
	}

	public void setDescripcionClasificacion(String descripcionClasificacion) {
		this.descripcionClasificacion = descripcionClasificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaVigenciaCostos() {
		return fechaVigenciaCostos;
	}

	public void setFechaVigenciaCostos(Date fechaVigenciaCostos) {
		this.fechaVigenciaCostos = fechaVigenciaCostos;
	}

	public Date getFechaVigenciaRetornoCostos() {
		return fechaVigenciaRetornoCostos;
	}

	public void setFechaVigenciaRetornoCostos(Date fechaVigenciaRetornoCostos) {
		this.fechaVigenciaRetornoCostos = fechaVigenciaRetornoCostos;
	}

	public Date getFechaVigenciaPrecios() {
		return fechaVigenciaPrecios;
	}

	public void setFechaVigenciaPrecios(Date fechaVigenciaPrecios) {
		this.fechaVigenciaPrecios = fechaVigenciaPrecios;
	}

	public Date getFechaVigenciaRetornoPrecios() {
		return fechaVigenciaRetornoPrecios;
	}

	public void setFechaVigenciaRetornoPrecios(Date fechaVigenciaRetornoPrecios) {
		this.fechaVigenciaRetornoPrecios = fechaVigenciaRetornoPrecios;
	}

	public Double getInflacionCosto() {
		return inflacionCosto;
	}

	public void setInflacionCosto(Double inflacionCosto) {
		this.inflacionCosto = inflacionCosto;
	}

	public Double getInflacionVenta() {
		return inflacionVenta;
	}

	public void setInflacionVenta(Double inflacionVenta) {
		this.inflacionVenta = inflacionVenta;
	}

	public Double getCostoBrutoAnterior() {
		return costoBrutoAnterior;
	}

	public void setCostoBrutoAnterior(Double costoBrutoAnterior) {
		this.costoBrutoAnterior = costoBrutoAnterior;
	}

	public Double getCostoNetoNcAnterior() {
		return costoNetoNcAnterior;
	}

	public void setCostoNetoNcAnterior(Double costoNetoNcAnterior) {
		this.costoNetoNcAnterior = costoNetoNcAnterior;
	}

	public Double getCostoNetoAnterior() {
		return costoNetoAnterior;
	}

	public void setCostoNetoAnterior(Double costoNetoAnterior) {
		this.costoNetoAnterior = costoNetoAnterior;
	}

	public Double getPrecioPVPAnterior() {
		return precioPVPAnterior;
	}

	public void setPrecioPVPAnterior(Double precioPVPAnterior) {
		this.precioPVPAnterior = precioPVPAnterior;
	}

	public Double getPrecioSMXAnterior() {
		return precioSMXAnterior;
	}

	public void setPrecioSMXAnterior(Double precioSMXAnterior) {
		this.precioSMXAnterior = precioSMXAnterior;
	}

	public Double getPrecioSMXnaAnterior() {
		return precioSMXnaAnterior;
	}

	public void setPrecioSMXnaAnterior(Double precioSMXnaAnterior) {
		this.precioSMXnaAnterior = precioSMXnaAnterior;
	}

	public Double getPsmxOfertaLocalAnterior() {
		 return psmxOfertaLocalAnterior;
	}

	public Double getCostoBrutoNuevo() {
		return costoBrutoNuevo;
	}

	public void setCostoBrutoNuevo(Double costoBrutoNuevo) {
		this.costoBrutoNuevo = costoBrutoNuevo;
	}

	public Double getCostoNetoNcNuevo() {
		return costoNetoNcNuevo;
	}

	public void setCostoNetoNcNuevo(Double costoNetoNcNuevo) {
		this.costoNetoNcNuevo = costoNetoNcNuevo;
	}

	public Double getCostoNetoNuevo() {
		return costoNetoNuevo;
	}

	public void setCostoNetoNuevo(Double costoNetoNuevo) {
		this.costoNetoNuevo = costoNetoNuevo;
	}

	public Double getPrecioPVPNuevo() {
		return precioPVPNuevo;
	}

	public void setPrecioPVPNuevo(Double precioPVPNuevo) {
		this.precioPVPNuevo = precioPVPNuevo;
	}

	public Double getPrecioSMXNuevo() {
		return precioSMXNuevo;
	}

	public void setPrecioSMXNuevo(Double precioSMXNuevo) {
		this.precioSMXNuevo = precioSMXNuevo;
	}

	public Double getPrecioSMXnaNuevo() {
		return precioSMXnaNuevo;
	}

	public void setPrecioSMXnaNuevo(Double precioSMXnaNuevo) {
		this.precioSMXnaNuevo = precioSMXnaNuevo;
	}

	public Double getPsmxOfertaLocalNuevo() {
		return psmxOfertaLocalNuevo;
	}

	public Collection<HistorialPrecioDiferenciadoArticuloDTO> getHistorialPreciosDiferenciados() {
		return historialPreciosDiferenciados;
	}

	public void setHistorialPreciosDiferenciados(Collection<HistorialPrecioDiferenciadoArticuloDTO> historialPreciosDiferenciados) {
		this.historialPreciosDiferenciados = historialPreciosDiferenciados;
	}

	public void setPsmxOfertaLocalAnterior(Double psmxOfertaLocalAnterior) {
		this.psmxOfertaLocalAnterior = psmxOfertaLocalAnterior;
	}

	public void setPsmxOfertaLocalNuevo(Double psmxOfertaLocalNuevo) {
		this.psmxOfertaLocalNuevo = psmxOfertaLocalNuevo;
	}

	public Double getVariacionCostoBruto() {
		if (variacionCostoBruto == null) {
			variacionCostoBruto = SICArticuloCalculo.getInstancia().calcularVariacionCostoBruto(this.getCostoBrutoNuevo(), this.getCostoBrutoAnterior()); 
		}
		return variacionCostoBruto;
	}
	
	public Double getVariacionVenta() {
		if (variacionVenta == null) {
			variacionVenta = SICArticuloCalculo.getInstancia().calcularVariacionVenta(this.getPrecioPVPNuevo(), this.getPrecioPVPAnterior());
		}
		return variacionVenta;
	}
	
	public Double getVentaCostoNetoNotaCreditoAnterior() {
		return SICArticuloCalculo.getInstancia().calcularVentaCostoNetoNotaCredito(this.getPrecioPVPAnterior(), this.getCostoNetoNcAnterior());
	}

	public Double getMargenPVPAnterior() {
		return SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.getPrecioPVPAnterior(), this.getCostoNetoAnterior());
	}

	public Double getMargenSMXAnterior() {
		return SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.getPrecioSMXAnterior(), this.getCostoNetoAnterior());
	}

	public Double getCostoNetoNotaCreditoVsPvpAnterior() {
		return SICArticuloCalculo.getInstancia().calcularCostoNetoNotaCreditoVsPvp(this.getCostoNetoNcAnterior(), this.getPrecioPVPAnterior());
	}

	public Double getPvpVsPsmxAnterior() {
		return SICArticuloCalculo.getInstancia().calcularPvpVsPsmx(this.getPrecioPVPAnterior(), this.getPrecioSMXAnterior());
	}

	public Double getPvpVsCostoNetoNotaCreditoAnterior() {
		return SICArticuloCalculo.getInstancia().calcularPvpVsCostoNetoNotaCredito(this.getPrecioPVPAnterior(), this.getCostoNetoNcAnterior());
	}
	
	public Double getVentaCostoNetoNotaCreditoNuevo() {
		return SICArticuloCalculo.getInstancia().calcularVentaCostoNetoNotaCredito(this.getPrecioPVPNuevo(), this.getCostoNetoNcNuevo());
	}

	public Double getMargenPVPNuevo() {
		return SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.getPrecioPVPNuevo(), this.getCostoNetoNuevo());
	}

	public Double getMargenSMXNuevo() {
		return SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.getPrecioSMXNuevo(), this.getCostoNetoNuevo());
	}

	public Double getCostoNetoNotaCreditoVsPvpNuevo() {
		return SICArticuloCalculo.getInstancia().calcularCostoNetoNotaCreditoVsPvp(this.getCostoNetoNcNuevo(), this.getPrecioPVPNuevo());
	}

	public Double getPvpVsPsmxNuevo() {
		return SICArticuloCalculo.getInstancia().calcularPvpVsPsmx(this.getPrecioPVPNuevo(), this.getPrecioSMXNuevo());
	}

	public Double getPvpVsCostoNetoNotaCreditoNuevo() {
		return SICArticuloCalculo.getInstancia().calcularPvpVsCostoNetoNotaCredito(this.getPrecioPVPNuevo(), this.getCostoNetoNcNuevo());
	}
	
	public Double getPorcentajeVariacionCostoBruto() {
		return SICArticuloCalculo.getInstancia().calcularPorcentajeVariacionCostoBruto(this.getVariacionCostoBruto(), this.getCostoBrutoAnterior());
	}
	
	public Double getPorcentajeVariacionVenta() {
		return SICArticuloCalculo.getInstancia().calcularPorcentajeVariacionVenta(this.getVariacionVenta(), this.getPrecioSMXAnterior());
	}
}
