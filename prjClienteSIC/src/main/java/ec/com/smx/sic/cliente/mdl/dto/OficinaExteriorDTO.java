
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.corpv2.dto.LocalizacionDTO;
import ec.com.smx.frameworkv2.auditoria.common.annotation.Etiqueta;



/**
 * Entidad que almacena los datos de las Oficinas en Exterior que se van a 
 * encargar de manejar a los proveedores que pueden ser personas o localizacines
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTOFIEXT")
public class OficinaExteriorDTO extends AuditoriaOficinaExteriorDTO{
	
	
	
	private Long codigoLocalizacion;
	
	@ComparatorTypeField
	private String estadoOficinaExterior;
	
	
	/**
	 * Nombre de la Oficina Exterior
	 *

	 */
	private String nombreOficinaExterior ;
	
	/*
	 * Abreviatura del nombre de la oficina en el exterior
	 */
	@Column(name = "ABRNOMOFIEXT")
	private String abreviaturaNombreOficinaExterior;

	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOLOCALIZACION", referencedColumnName = "CODIGOLOCALIZACION", insertable = false, updatable = false)
	})
	private LocalizacionDTO localizacion;


	/**
	 * 
	 *
	 */
	/*@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false)
	private ec.com.smx.corpv2.dto.CompaniaDTO compania;*/
	
	
	@Transient
	private Long secuencialContacto;
	@Transient
	private String codigoCiudadDireccionPrincipal;
	@Transient
	private String codigoProvinciaDireccionPrincipal;
	@Transient
	private String direccionPrincipal;
	@Transient
	private String numeroTelefonicoPrincipal;
	@Transient
	private String emailPrincipal;
	@Transient
	private String urlPaginaWeb;
	
	
	

	/**
	 * Retorna valor de propiedad <code>nombreOficinaExterior</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>nombreOficinaExterior</code>
	 */
	@Etiqueta
	public String getNombreOficinaExterior(){
		return this.nombreOficinaExterior;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>nombreOficinaExterior</code>.
	 * @param nombreOficinaExterior1 
	 *		El valor a establecer para la propiedad <code>nombreOficinaExterior</code>.
	 */
	public void setNombreOficinaExterior( String nombreOficinaExterior1 ){
		this.nombreOficinaExterior=nombreOficinaExterior1;
	}


	/**
	 * @return the abreviaturaNombreOficinaExterior
	 */
	public String getAbreviaturaNombreOficinaExterior() {
		return abreviaturaNombreOficinaExterior;
	}

	/**
	 * @param abreviaturaNombreOficinaExterior the abreviaturaNombreOficinaExterior to set
	 */
	public void setAbreviaturaNombreOficinaExterior(
			String abreviaturaNombreOficinaExterior) {
		this.abreviaturaNombreOficinaExterior = abreviaturaNombreOficinaExterior;
	}
	
	

	

	/**
	 * @return the estadoOficinaExterior
	 */
	public String getEstadoOficinaExterior() {
		return estadoOficinaExterior;
	}

	/**
	 * @param estadoOficinaExterior the estadoOficinaExterior to set
	 */
	public void setEstadoOficinaExterior(String estadoOficinaExterior) {
		this.estadoOficinaExterior = estadoOficinaExterior;
	}

	/**
	 * @return the codigoLocalizacion
	 */
	public Long getCodigoLocalizacion() {
		return codigoLocalizacion;
	}

	/**
	 * @param codigoLocalizacion the codigoLocalizacion to set
	 */
	public void setCodigoLocalizacion(Long codigoLocalizacion) {
		this.codigoLocalizacion = codigoLocalizacion;
	}
	
	
	/**
	 * @deprecated hasta cambiar el nombre de la columna codigoLocalizacionProveedor
	 * de la tabla proveedor
	 */
	@Deprecated
	public Long getCodigoLocalizacionProveedor() {
		return this.getCodigoLocalizacion();
	}

	/**
	 * @deprecated hasta cambiar el nombre de la columna codigoLocalizacionProveedor
	 * de la tabla proveedor
	 */
	@Deprecated
	public void setCodigoLocalizacionProveedor(Long codigoLocalizacion) {
		this.setCodigoLocalizacion(codigoLocalizacion);
	}

	/**
	 * @return the localizacion
	 */
	public LocalizacionDTO getLocalizacion() {
		return localizacion;
	}

	/**
	 * @param localizacion the localizacion to set
	 */
	public void setLocalizacion(LocalizacionDTO localizacion) {
		this.localizacion = localizacion;
	}

	public Long getSecuencialContacto() {
		return secuencialContacto;
	}

	public void setSecuencialContacto(Long secuencialContacto) {
		this.secuencialContacto = secuencialContacto;
	}

	public String getCodigoCiudadDireccionPrincipal() {
		return codigoCiudadDireccionPrincipal;
	}

	public void setCodigoCiudadDireccionPrincipal(String codigoCiudadDireccionPrincipal) {
		this.codigoCiudadDireccionPrincipal = codigoCiudadDireccionPrincipal;
	}

	public String getCodigoProvinciaDireccionPrincipal() {
		return codigoProvinciaDireccionPrincipal;
	}

	public void setCodigoProvinciaDireccionPrincipal(String codigoProvinciaDireccionPrincipal) {
		this.codigoProvinciaDireccionPrincipal = codigoProvinciaDireccionPrincipal;
	}

	public String getDireccionPrincipal() {
		return direccionPrincipal;
	}

	public void setDireccionPrincipal(String direccionPrincipal) {
		this.direccionPrincipal = direccionPrincipal;
	}

	public String getNumeroTelefonicoPrincipal() {
		return numeroTelefonicoPrincipal;
	}

	public void setNumeroTelefonicoPrincipal(String numeroTelefonicoPrincipal) {
		this.numeroTelefonicoPrincipal = numeroTelefonicoPrincipal;
	}

	public String getEmailPrincipal() {
		return emailPrincipal;
	}

	public void setEmailPrincipal(String emailPrincipal) {
		this.emailPrincipal = emailPrincipal;
	}

	public String getUrlPaginaWeb() {
		return urlPaginaWeb;
	}

	public void setUrlPaginaWeb(String urlPaginaWeb) {
		this.urlPaginaWeb = urlPaginaWeb;
	}
}

