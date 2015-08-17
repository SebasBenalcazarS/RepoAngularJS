package ec.com.smx.sic.cliente.common.articulo.solicitudImpresion.bean;

import java.util.Collection;
import java.util.Date;

/**
 * Estructura  utilizada para la busqueda y el ingreso de datos  de los articulos para la solicitud
 * @author aquingaluisa
 *
 */
public class EstructuraArticuloSolImpresion {
	private String codigoArticulo;
	private Integer codigoCompania;
	private String descripcionArticulo;
	private String referenciaMedida;
	
	private String lote;
	private Date fechaCaduccidad;
	private Date fechaElaboracion;
	private Integer numeroEtiquetas;
	private boolean tieneSemaforo;
	
	/**
	 * de este proveedor solo se va a traerc cargado los campos codigoArticulo, codigoReferenciaProveedor, proveedor.nombreProveedor
	 */
	private Collection<EstructuraArticuloProveedorSolImpresion> articuloProveedor;
	
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	public String getReferenciaMedida() {
		return referenciaMedida;
	}
	public void setReferenciaMedida(String referenciaMedida) {
		this.referenciaMedida = referenciaMedida;
	}
	public Collection<EstructuraArticuloProveedorSolImpresion> getArticuloProveedor() {
		return articuloProveedor;
	}
	public void setArticuloProveedor(Collection<EstructuraArticuloProveedorSolImpresion> articuloProveedor) {
		this.articuloProveedor = articuloProveedor;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Date getFechaCaduccidad() {
		return fechaCaduccidad;
	}
	public void setFechaCaduccidad(Date fechaCaduccidad) {
		this.fechaCaduccidad = fechaCaduccidad;
	}
	public Date getFechaElaboracion() {
		return fechaElaboracion;
	}
	public void setFechaElaboracion(Date fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}
	public Integer getNumeroEtiquetas() {
		return numeroEtiquetas;
	}
	public void setNumeroEtiquetas(Integer numeroEtiquetas) {
		this.numeroEtiquetas = numeroEtiquetas;
	}
	public boolean isTieneSemaforo() {
		return tieneSemaforo;
	}
	public void setTieneSemaforo(boolean tieneSemaforo) {
		this.tieneSemaforo = tieneSemaforo;
	}
	
}
