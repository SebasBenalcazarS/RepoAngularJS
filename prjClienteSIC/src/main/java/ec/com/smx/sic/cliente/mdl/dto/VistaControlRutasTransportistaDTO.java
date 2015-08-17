package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaControlRutasTransportistaID;

/**
 * Permite gestionar la informaci&oacute;n del Aspirante durante el proceso 
 * de selecci&oacute;n.
 *
 * @author kruger
 * @author egudino
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGVTRANSPORTISTA")
public class VistaControlRutasTransportistaDTO extends BaseDto<VistaControlRutasTransportistaID> {

	/**
	 * Campo codigo persona
	 */
	private java.lang.Long codigoPersona;

	/**
	 * Campo codigo localizacion
	 */
	private java.lang.Long codigoLocalizacion;


	/**
	 * numero del ruc de la persona o empresa
	 * 
	 */
	private String numeroRuc;

	/**
	 * codigo JDE de la persona o empresa
	 */
	private Integer codigoJDE;
	
	/**
	 * nombre de la persona o localizacion
	 */
	private String nombreTransportista;
	
	/**
	 * razon social persona o empresa
	 */
	private String razonSocial;
	
	/**
	 * Tipo persona o empresa
	 */
	private String tipoTransportista;
	
	/**
	 * Codigo pais direccion principal
	 */
	private String codigoPais;
	
	/**
	 * Nombre pais direccion principal
	 */
	private String pais;
	
	/**
	 * Codigo ciudad direccion principal
	 */
	private String codigoCiudad;
	
	/**
	 * Nombre pais direccion principal
	 */
	private String ciudad;
	
	/**
	 * Direccion principal
	 */
	private String direccion;
	
	/**
	 * Telefono principal
	 */
	private String telefonoPrincipal;
	
	/**
	 * Email principal
	 */
	private String email;
	
	/**
	 * Estado registro
	 */
	private String estado;

	public java.lang.Long getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(java.lang.Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public java.lang.Long getCodigoLocalizacion() {
		return codigoLocalizacion;
	}

	public void setCodigoLocalizacion(java.lang.Long codigoLocalizacion) {
		this.codigoLocalizacion = codigoLocalizacion;
	}

	public String getNumeroRuc() {
		return numeroRuc;
	}

	public void setNumeroRuc(String numeroRuc) {
		this.numeroRuc = numeroRuc;
	}

	public Integer getCodigoJDE() {
		return codigoJDE;
	}

	public void setCodigoJDE(Integer codigoJDE) {
		this.codigoJDE = codigoJDE;
	}

	public String getNombreTransportista() {
		return nombreTransportista;
	}

	public void setNombreTransportista(String nombreTransportista) {
		this.nombreTransportista = nombreTransportista;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTipoTransportista() {
		return tipoTransportista;
	}

	public void setTipoTransportista(String tipoTransportista) {
		this.tipoTransportista = tipoTransportista;
	}

	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefonoPrincipal() {
		return telefonoPrincipal;
	}

	public void setTelefonoPrincipal(String telefonoPrincipal) {
		this.telefonoPrincipal = telefonoPrincipal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}

