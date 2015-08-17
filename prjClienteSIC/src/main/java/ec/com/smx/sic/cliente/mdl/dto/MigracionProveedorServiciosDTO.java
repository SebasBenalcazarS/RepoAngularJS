package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ivasquez
 *
 */

@Entity
@Table(name = "SCPROTMIGPROSER")
public class MigracionProveedorServiciosDTO {

	@Id
	@Column(name = "CODIGOMIPROSER")
	private Long codigoMigProSer;
	
	@Column(name = "CODIGOJDE")
	private String codigoJDE;
	
	@Column(name = "NUMERODOCUMENTOPROVEEDOR")
	private String numeroDocumentoProveedor;
	
	@Column(name = "NOMBRECOMERCIAL")
	private String nombreComercial;
	
	@Column(name = "PLAZAPAGOS")
	private String plazaPagos;
	
	@Column(name = "RAZONSOCIALPROVEEDOR")
	private String razonSocialProveedor;
	
	@Column(name = "CIUDAD")
	private String ciudad;
	
	@Column(name = "CALLEPRINCIPAL")
	private String callePrincipal;
	
	@Column(name = "NUMEROCALLE")
	private String numeroCalle; 
	
	@Column(name = "CALLETRANSVERSAL")
	private String calleTransversal; 
	
	@Column(name = "CODIGOAREATRABAJO")
	private String codigoAreaTrabajo;
	
	@Column(name = "EMAILCONTACTOB2B")
	private String emailContactoB2B;
	
	@Column(name = "CEDULACONTACTOB2B")
	private String cedulaContactoB2B;
	
	@Column(name = "PRIMERAPELLIDOCONTACTOB2B")
	private String primerApellidoContactoB2B;
	
	@Column(name = "PRIMERNOMBRECONTACTOB2B")
	private String primerNombreContactoB2B;
	
	@Column(name = "SEGUNDOAPELLIDOCONTACTOB2B")
	private String segundoApellidoContactoB2B; 
	
	@Column(name = "SEGUNDONOMBRECONTACTOB2B")
	private String segundoNombreContactoB2B; 
	
	@Column(name = "CIUDADCONTACTOB2B")
	private String ciudadContactoB2B;
	
	@Column(name = "CALLEPRINCIPALCONTACTOB2B")
	private String callePrincipalContactoB2B;
	
	@Column(name = "NUMEROCALLECONTACTOB2B")
	private String numeroCalleContactoB2B;
	
	@Column(name = "CALLETRANSVERSALCONTACTOB2B")
	private String calleTransversalContactoB2B; 
	
	@Column(name = "PRIMERAPELLIDO")
	private String primerApellido;
	
	@Column(name = "PRIMERNOMBRE")
	private String primerNombre; 
	
	@Column(name = "SEGUNDOAPELLIDO")
	private String segundoApellido; 
	
	@Column(name = "SEGUNDONOMBRE")
	private String segundoNombre; 
	
	@Column(name = "ESTADOPROCESADO")
	private String estadoProcesado;
	
	@Column(name = "VALORTIPOENTIDADPROVEEDOR")
	private String valorTipoEntidadProveedor;
	
	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Column(name = "FECHAEJECUCION")
	private Date fechaEjecucion;

	
	/*
	 * GETTERS AND SETTERS
	 */
	
	public String getCodigoJDE() {
		return codigoJDE;
	}

	public void setCodigoJDE(String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}

	public String getNumeroDocumentoProveedor() {
		return numeroDocumentoProveedor;
	}

	public void setNumeroDocumentoProveedor(String numeroDocumentoProveedor) {
		this.numeroDocumentoProveedor = numeroDocumentoProveedor;
	}

	public String getNombreComercial() {
		return nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getRazonSocialProveedor() {
		return razonSocialProveedor;
	}

	public void setRazonSocialProveedor(String razonSocialProveedor) {
		this.razonSocialProveedor = razonSocialProveedor;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCallePrincipal() {
		return callePrincipal;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}

	public String getNumeroCalle() {
		return numeroCalle;
	}

	public void setNumeroCalle(String numeroCalle) {
		this.numeroCalle = numeroCalle;
	}

	public String getCalleTransversal() {
		return calleTransversal;
	}

	public void setCalleTransversal(String calleTransversal) {
		this.calleTransversal = calleTransversal;
	}

	public String getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	public void setCodigoAreaTrabajo(String codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	public String getEmailContactoB2B() {
		return emailContactoB2B;
	}

	public void setEmailContactoB2B(String emailContactoB2B) {
		this.emailContactoB2B = emailContactoB2B;
	}

	public String getCedulaContactoB2B() {
		return cedulaContactoB2B;
	}

	public void setCedulaContactoB2B(String cedulaContactoB2B) {
		this.cedulaContactoB2B = cedulaContactoB2B;
	}

	public String getPrimerApellidoContactoB2B() {
		return primerApellidoContactoB2B;
	}

	public void setPrimerApellidoContactoB2B(String primerApellidoContactoB2B) {
		this.primerApellidoContactoB2B = primerApellidoContactoB2B;
	}

	public String getPrimerNombreContactoB2B() {
		return primerNombreContactoB2B;
	}

	public void setPrimerNombreContactoB2B(String primerNombreContactoB2B) {
		this.primerNombreContactoB2B = primerNombreContactoB2B;
	}

	public String getSegundoApellidoContactoB2B() {
		return segundoApellidoContactoB2B;
	}

	public void setSegundoApellidoContactoB2B(String segundoApellidoContactoB2B) {
		this.segundoApellidoContactoB2B = segundoApellidoContactoB2B;
	}

	public String getSegundoNombreContactoB2B() {
		return segundoNombreContactoB2B;
	}

	public void setSegundoNombreContactoB2B(String segundoNombreContactoB2B) {
		this.segundoNombreContactoB2B = segundoNombreContactoB2B;
	}

	public String getCiudadContactoB2B() {
		return ciudadContactoB2B;
	}

	public void setCiudadContactoB2B(String ciudadContactoB2B) {
		this.ciudadContactoB2B = ciudadContactoB2B;
	}

	public String getCallePrincipalContactoB2B() {
		return callePrincipalContactoB2B;
	}

	public void setCallePrincipalContactoB2B(String callePrincipalContactoB2B) {
		this.callePrincipalContactoB2B = callePrincipalContactoB2B;
	}

	public String getNumeroCalleContactoB2B() {
		return numeroCalleContactoB2B;
	}

	public void setNumeroCalleContactoB2B(String numeroCalleContactoB2B) {
		this.numeroCalleContactoB2B = numeroCalleContactoB2B;
	}

	public String getCalleTransversalContactoB2B() {
		return calleTransversalContactoB2B;
	}

	public void setCalleTransversalContactoB2B(String calleTransversalContactoB2B) {
		this.calleTransversalContactoB2B = calleTransversalContactoB2B;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getEstadoProcesado() {
		return estadoProcesado;
	}

	public void setEstadoProcesado(String estadoProcesado) {
		this.estadoProcesado = estadoProcesado;
	}

	public String getValorTipoEntidadProveedor() {
		return valorTipoEntidadProveedor;
	}

	public void setValorTipoEntidadProveedor(String valorTipoEntidadProveedor) {
		this.valorTipoEntidadProveedor = valorTipoEntidadProveedor;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaEjecucion() {
		return fechaEjecucion;
	}

	public void setFechaEjecucion(Date fechaEjecucion) {
		this.fechaEjecucion = fechaEjecucion;
	}

	public String getPlazaPagos() {
		return plazaPagos;
	}

	public void setPlazaPagos(String plazaPagos) {
		this.plazaPagos = plazaPagos;
	}
	
	public Long getCodigoMigProSer() {
		return codigoMigProSer;
	}

	public void setCodigoMigProSer(Long codigoMigProSer) {
		this.codigoMigProSer = codigoMigProSer;
	}
}