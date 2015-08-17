package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaCampoMercanciaID;

/**
 * Campos para la etiqueta de mercancia
 * @author dbravo
 *
 */
@Entity
@SuppressWarnings("serial")
public class VistaCampoMercanciaDTO extends SearchDTO {
	
	@EmbeddedId
	private VistaCampoMercanciaID id;
	
	private String descripcionArticulo;
	private String nombreMarca;
	private String codigoReferenciaProveedor;
	private String codigoProveedor;
	private String paisOrigen;
	private Float  cantidadMedida;
	private String tamanioArticulo;
	private Integer diasVidaUtil;
	
	/*
	 * Campos faltantes de la mercancia que se obtienen de VistaRazonSocialProveedorDAO y VistaFechaLoteDAO
	 */
	@Transient
	private String direccionPrincipal;
	
	@Transient
	private String razonSocialProveedor;
	
	@Transient
	private String origenProveedor;
	
	@Transient
	private Date fechaMaxUso; 
	
	@Transient
	private Date fechaLote;
	
	@Transient
	private Boolean razonSocialImportador;
	
	public VistaCampoMercanciaID getId() {
		return id;
	}
	public void setId(VistaCampoMercanciaID id) {
		this.id = id;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	public String getCodigoReferenciaProveedor() {
		return codigoReferenciaProveedor;
	}
	public void setCodigoReferenciaProveedor(String codigoReferenciaProveedor) {
		this.codigoReferenciaProveedor = codigoReferenciaProveedor;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public String getPaisOrigen() {
		return paisOrigen;
	}
	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
	public Float getCantidadMedida() {
		return cantidadMedida;
	}
	public void setCantidadMedida(Float cantidadMedida) {
		this.cantidadMedida = cantidadMedida;
	}
	public String getTamanioArticulo() {
		return tamanioArticulo;
	}
	public void setTamanioArticulo(String tamanioArticulo) {
		this.tamanioArticulo = tamanioArticulo;
	}
	public Integer getDiasVidaUtil() {
		return diasVidaUtil;
	}
	public void setDiasVidaUtil(Integer diasVidaUtil) {
		this.diasVidaUtil = diasVidaUtil;
	}
	
	/*
	 * Metodos get/set Campos faltantes de la mercancia
	 */
	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}
	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}
	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}
	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}
	public String getOrigenProveedor() {
		return origenProveedor;
	}
	public void setOrigenProveedor(String origenProveedor) {
		this.origenProveedor = origenProveedor;
	}
	
	/*
	 * diasVidaUtil + fechaLote = FechaMaximoUso
	 */
	public Date getFechaMaxUso() {
		return fechaMaxUso;
	}
	public void setFechaMaxUso(Date fechaMaxUso) {
		this.fechaMaxUso = fechaMaxUso;
	}
	public Date getFechaLote() {
		return fechaLote;
	}
	public void setFechaLote(Date fechaLote) {
		this.fechaLote = fechaLote;
	}
	
	/*
	 * almacena el resultado de la condicion de origen proveedor != I
	 */
	public Boolean getRazonSocialImportador() {
		return razonSocialImportador;
	}
	public void setRazonSocialImportador(Boolean razonSocialImportador) {
		this.razonSocialImportador = razonSocialImportador;
	}
	/*
	 * Metodos concatena cantidadMedida y el tamanioArticulo para representar el contenidoNeto 
	 */
	public String getContenidoNeto(){
		String  cantidadTmp = cantidadMedida==null?"":cantidadMedida.toString();
		String tamanioTmp = tamanioArticulo==null?"":tamanioArticulo;
		return (cantidadTmp+""+tamanioTmp).toString();
	}
	
}
