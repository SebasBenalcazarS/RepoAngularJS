/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoEjecucionGestionPrecio;
import ec.com.smx.sic.cliente.common.gestionprecios.constantes.EstadoGestionPrecio;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class DatosGeneralesCambioPrecio extends SearchDTO {

	//id
	private String codigoArticulo;	
	
	//variables para mostrar en latabla
	private String codigoBarras;
	private String descripcionArticulo;
	private String codigoProveedor;
	private String nombreProveedor;
	private String valorTipoEntidadProveedor;
	private String valorTipoEstado;
	
	private Date fechaVigenciaCostos;
	private Date fechaVigenciaRetornoCostos;
	private Date fechaVigenciaPrecios;
	private Date fechaVigenciaRetornoPrecios;
	private String valorEstadoEjecucionCosto;
	private String valorEstadoEjecucionVenta;
	private double costoNetoAnterior;
	private double costoBrutoAnterior;
	private double margenPVPAnterior;
	private double margenSMXAnterior;
	private double costoNetoNuevo;
	private double costoBrutoNuevo;
	private double margenPVPNuevo;
	private double margenSMXNuevo;
	
	private double precioPVPAnterior;	
	private double precioSMXAnterior;		
	private double precioSMXnaAnterior;	
	private double precioPVPNuevo;	
	private double precioSMXNuevo;		
	private double precioSMXnaNuevo;
	private boolean tienePreciosDiferenciados;
	
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
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}	
		
	public boolean getTienePreciosDiferenciados() {
		return tienePreciosDiferenciados;
	}
	public void setTienePreciosDiferenciados(boolean tienePreciosRelacionados) {
		this.tienePreciosDiferenciados = tienePreciosRelacionados;
	}
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	public Date getFechaVigenciaCostos() {
		return fechaVigenciaCostos;
	}
	public void setFechaVigenciaCostos(Date fechaVigenciaCostos) {
		this.fechaVigenciaCostos = fechaVigenciaCostos;
	}
	
	public double getCostoBrutoAnterior() {
		return costoBrutoAnterior;
	}
	public void setCostoBrutoAnterior(double costoBrutoAnterior) {
		this.costoBrutoAnterior = costoBrutoAnterior;
	}
	public double getPrecioPVPAnterior() {
		return precioPVPAnterior;
	}
	public void setPrecioPVPAnterior(double precioPVPAnterior) {
		this.precioPVPAnterior = precioPVPAnterior;
	}
	public double getMargenPVPAnterior() {
		return margenPVPAnterior;
	}
	public void setMargenPVPAnterior(double margenPVPAnterior) {
		this.margenPVPAnterior = margenPVPAnterior;
	}
	public double getPrecioSMXAnterior() {
		return precioSMXAnterior;
	}
	public void setPrecioSMXAnterior(double precioSMXAnterior) {
		this.precioSMXAnterior = precioSMXAnterior;
	}
	public double getMargenSMXAnterior() {
		return margenSMXAnterior;
	}
	public void setMargenSMXAnterior(double margenSMXAnterior) {
		this.margenSMXAnterior = margenSMXAnterior;
	}
	public double getPrecioSMXnaAnterior() {
		return precioSMXnaAnterior;
	}
	public void setPrecioSMXnaAnterior(double precioSMXnaAnterior) {
		this.precioSMXnaAnterior = precioSMXnaAnterior;
	}
	
	public double getCostoBrutoNuevo() {
		return costoBrutoNuevo;
	}
	public void setCostoBrutoNuevo(double costoBrutoNuevo) {
		this.costoBrutoNuevo = costoBrutoNuevo;
	}
	public double getPrecioPVPNuevo() {
		return precioPVPNuevo;
	}
	public void setPrecioPVPNuevo(double precioPVPNuevo) {
		this.precioPVPNuevo = precioPVPNuevo;
	}
	public double getMargenPVPNuevo() {
		return margenPVPNuevo;
	}
	public void setMargenPVPNuevo(double margenPVPNuevo) {
		this.margenPVPNuevo = margenPVPNuevo;
	}
	public double getPrecioSMXNuevo() {
		return precioSMXNuevo;
	}
	public void setPrecioSMXNuevo(double precioSMXNuevo) {
		this.precioSMXNuevo = precioSMXNuevo;
	}
	public double getMargenSMXNuevo() {
		return margenSMXNuevo;
	}
	public void setMargenSMXNuevo(double margenSMXNuevo) {
		this.margenSMXNuevo = margenSMXNuevo;
	}
	public double getPrecioSMXnaNuevo() {
		return precioSMXnaNuevo;
	}
	public void setPrecioSMXnaNuevo(double precioSMXnaNuevo) {
		this.precioSMXnaNuevo = precioSMXnaNuevo;
	}
	public double getCostoNetoAnterior() {
		return costoNetoAnterior;
	}
	public void setCostoNetoAnterior(double costoNetoAnterior) {
		this.costoNetoAnterior = costoNetoAnterior;
	}
	public double getCostoNetoNuevo() {
		return costoNetoNuevo;
	}
	public void setCostoNetoNuevo(double costoNetoNuevo) {
		this.costoNetoNuevo = costoNetoNuevo;
	}
	public Date getFechaVigenciaPrecios() {
		return fechaVigenciaPrecios;
	}
	public void setFechaVigenciaPrecios(Date fechaVigenciaPrecios) {
		this.fechaVigenciaPrecios = fechaVigenciaPrecios;
	}
	public String getValorTipoEstado() {
		if(EstadoGestionPrecio.PENDIENTE.getValorEstadoGestionPrecio().equals(valorTipoEstado)){
			valorTipoEstado = EstadoGestionPrecio.PENDIENTE.getLabelEstadoGestionPrecio(); 
		}else if (EstadoGestionPrecio.CONFIRMADO.getValorEstadoGestionPrecio().equals(valorTipoEstado)) {
			valorTipoEstado = EstadoGestionPrecio.CONFIRMADO.getLabelEstadoGestionPrecio();;
		}else if (EstadoGestionPrecio.AUTORIZADO.getValorEstadoGestionPrecio().equals(valorTipoEstado)) {
			valorTipoEstado = EstadoGestionPrecio.AUTORIZADO.getLabelEstadoGestionPrecio();;
		}else if (EstadoGestionPrecio.DESAUTORIZADO.getValorEstadoGestionPrecio().equals(valorTipoEstado)) {
			valorTipoEstado = EstadoGestionPrecio.DESAUTORIZADO.getLabelEstadoGestionPrecio();;
		}
		return valorTipoEstado;
	}
	public void setValorTipoEstado(String valorTipoEstado) {
		this.valorTipoEstado = valorTipoEstado;
	}
	/**
	 * @return the fechaVigenciaRetornoCostos
	 */
	public Date getFechaVigenciaRetornoCostos() {
		return fechaVigenciaRetornoCostos;
	}
	/**
	 * @param fechaVigenciaRetornoCostos the fechaVigenciaRetornoCostos to set
	 */
	public void setFechaVigenciaRetornoCostos(Date fechaVigenciaRetornoCostos) {
		this.fechaVigenciaRetornoCostos = fechaVigenciaRetornoCostos;
	}
	/**
	 * @return the fechaVigenciaRetornoPrecios
	 */
	public Date getFechaVigenciaRetornoPrecios() {
		return fechaVigenciaRetornoPrecios;
	}
	/**
	 * @param fechaVigenciaRetornoPrecios the fechaVigenciaRetornoPrecios to set
	 */
	public void setFechaVigenciaRetornoPrecios(Date fechaVigenciaRetornoPrecios) {
		this.fechaVigenciaRetornoPrecios = fechaVigenciaRetornoPrecios;
	}
	/**
	 * @return the valorTipoEntidadProveedor
	 */
	public String getValorTipoEntidadProveedor() {
		return valorTipoEntidadProveedor;
	}
	/**
	 * @param valorTipoEntidadProveedor the valorTipoEntidadProveedor to set
	 */
	public void setValorTipoEntidadProveedor(String valorTipoEntidadProveedor) {
		this.valorTipoEntidadProveedor = valorTipoEntidadProveedor;
	}
	/**
	 * @return the valorEstadoEjecucionCosto
	 */
	public String getValorEstadoEjecucionCosto() {
		if(EstadoEjecucionGestionPrecio.PENDIENTE.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucionCosto)){
			valorEstadoEjecucionCosto = EstadoEjecucionGestionPrecio.PENDIENTE.getLabelEstadoEjecucionGestionPrecio(); 
		}else if (EstadoEjecucionGestionPrecio.PROCESADO.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucionCosto)) {
			valorEstadoEjecucionCosto = EstadoEjecucionGestionPrecio.PROCESADO.getLabelEstadoEjecucionGestionPrecio();
		}else if (EstadoEjecucionGestionPrecio.FINALIZADO.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucionCosto)) {
			valorEstadoEjecucionCosto = EstadoEjecucionGestionPrecio.FINALIZADO.getLabelEstadoEjecucionGestionPrecio();
		}
		
		return valorEstadoEjecucionCosto;
	}
	/**
	 * @param valorEstadoEjecucionCosto the valorEstadoEjecucionCosto to set
	 */
	public void setValorEstadoEjecucionCosto(String valorEstadoEjecucionCosto) {
		this.valorEstadoEjecucionCosto = valorEstadoEjecucionCosto;
	}
	/**
	 * @return the valorEstadoEjecucionVenta
	 */
	public String getValorEstadoEjecucionVenta() {
		if(EstadoEjecucionGestionPrecio.PENDIENTE.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucionVenta)){
			valorEstadoEjecucionVenta = EstadoEjecucionGestionPrecio.PENDIENTE.getLabelEstadoEjecucionGestionPrecio(); 
		}else if (EstadoEjecucionGestionPrecio.PROCESADO.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucionVenta)) {
			valorEstadoEjecucionVenta = EstadoEjecucionGestionPrecio.PROCESADO.getLabelEstadoEjecucionGestionPrecio();
		}else if (EstadoEjecucionGestionPrecio.FINALIZADO.getValorEstadoEjecucionGestionPrecio().equals(valorEstadoEjecucionVenta)) {
			valorEstadoEjecucionVenta = EstadoEjecucionGestionPrecio.FINALIZADO.getLabelEstadoEjecucionGestionPrecio();
		}
		return valorEstadoEjecucionVenta;
	}
	/**
	 * @param valorEstadoEjecucionVenta the valorEstadoEjecucionVenta to set
	 */
	public void setValorEstadoEjecucionVenta(String valorEstadoEjecucionVenta) {
		this.valorEstadoEjecucionVenta = valorEstadoEjecucionVenta;
	}
}
