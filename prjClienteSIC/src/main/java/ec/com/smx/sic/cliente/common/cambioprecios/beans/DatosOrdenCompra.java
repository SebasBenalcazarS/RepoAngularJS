/**
 * 
 */
package ec.com.smx.sic.cliente.common.cambioprecios.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author Victor Jaramillo
 *
 */
@SuppressWarnings("serial")
public class DatosOrdenCompra implements Serializable {

	private String codigoProveedor;
	private String nombreProveedor;
	private String numeroOrdenCompra;
	private String valorAccionAnular;
	private String valorAccionCrear;
	private String valorEstado;
	private String estadoOrdenCompra;
	private Date fechaInicio;
	private Date fechaCaducidad;
	private Boolean plegar;
	private Boolean anularOrdenCompraPorDefecto;
	private Boolean selected = Boolean.FALSE;
	private Long codigoOrdenCompra;
	private Long codigoOrdenCompraGestion;
	private Collection<DatosArticuloOrdenCompra> articulosOrdenCompra;
	
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
	
	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}
	
	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Boolean getPlegar() {
		return plegar;
	}

	public void setPlegar(Boolean plegar) {
		this.plegar = plegar;
	}

	public Collection<DatosArticuloOrdenCompra> getArticulosOrdenCompra() {
		return articulosOrdenCompra;
	}

	public void setArticulosOrdenCompra(Collection<DatosArticuloOrdenCompra> articulosOrdenCompra) {
		this.articulosOrdenCompra = articulosOrdenCompra;
	}

	public Boolean getAnularOrdenCompraPorDefecto() {
		return anularOrdenCompraPorDefecto;
	}

	public void setAnularOrdenCompraPorDefecto(Boolean anularOrdenCompraPorDefecto) {
		this.anularOrdenCompraPorDefecto = anularOrdenCompraPorDefecto;
	}

	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	public String getValorAccionAnular() {
		return valorAccionAnular;
	}

	public void setValorAccionAnular(String valorAccionAnular) {
		this.valorAccionAnular = valorAccionAnular;
	}

	public String getValorAccionCrear() {
		return valorAccionCrear;
	}

	public void setValorAccionCrear(String valorAccionCrear) {
		this.valorAccionCrear = valorAccionCrear;
	}

	public String getValorEstado() {
		return valorEstado;
	}

	public void setValorEstado(String valorEstado) {
		this.valorEstado = valorEstado;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	
	public String getEstadoOrdenCompra() {
		return estadoOrdenCompra;
	}

	public void setEstadoOrdenCompra(String estadoOrdenCompra) {
		this.estadoOrdenCompra = estadoOrdenCompra;
	}
	
	public Long getCodigoOrdenCompraGestion() {
		return codigoOrdenCompraGestion;
	}

	public void setCodigoOrdenCompraGestion(Long codigoOrdenCompraGestion) {
		this.codigoOrdenCompraGestion = codigoOrdenCompraGestion;
	}

}
