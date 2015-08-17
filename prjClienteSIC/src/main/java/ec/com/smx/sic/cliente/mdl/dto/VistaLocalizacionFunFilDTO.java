package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaLocalizacionFunFilID;

/**
 * Permite gestionar la informaci&oacute;n de localizaciones por tipo
 * de selecci&oacute;n.
 *
 * @author kruger
 * @author egudino
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGVFUNDACIONFILIAL")
public class VistaLocalizacionFunFilDTO extends BaseDto<VistaLocalizacionFunFilID> {
	
	/**
	 * Campo codigo JDE
	 */
	private java.lang.Integer codigoJDE;

	/**
	 * Campo descripcion localizacion
	 */
	private java.lang.String descripcionLocalizacion;


	/**
	 * numero del ruc de la persona o empresa
	 * 
	 */
	private java.lang.String numeroRuc;

	
	/**
	 * Nombre ciudad direccion principal
	 */
	private java.lang.String ciudad;
	
	/**
	 * codigo ciudad direccion principal
	 */
	private java.lang.String codigoCiudad;
	
	/**
	 * codigo ciudad direccion principal
	 */
	private java.lang.String direccion;
	
	/**
	 * razon social persona o empresa
	 */
	private java.lang.String razonSocial;
	
	/**
	 * codigo calificacion empresa
	 */
	private java.lang.Integer codCalEmpCal;
	
	/**
	 * Codigo valor calificacion empresa
	 */
	private java.lang.String codCalEmpCalVal;
	
	/**
	 * Nombre calificacion
	 */
	private java.lang.Integer codCal;
	
	/**
	 * Codigo valor calificacion
	 */
	private java.lang.String codCalVal;

	
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

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * @return the descripcionLocalizacion
	 */
	public java.lang.String getDescripcionLocalizacion() {
		return descripcionLocalizacion;
	}

	/**
	 * @param descripcionLocalizacion the descripcionLocalizacion to set
	 */
	public void setDescripcionLocalizacion(java.lang.String descripcionLocalizacion) {
		this.descripcionLocalizacion = descripcionLocalizacion;
	}

	/**
	 * @return the codCalEmpCal
	 */
	public java.lang.Integer getCodCalEmpCal() {
		return codCalEmpCal;
	}

	/**
	 * @param codCalEmpCal the codCalEmpCal to set
	 */
	public void setCodCalEmpCal(java.lang.Integer codCalEmpCal) {
		this.codCalEmpCal = codCalEmpCal;
	}

	/**
	 * @return the codCalEmpCalVal
	 */
	public java.lang.String getCodCalEmpCalVal() {
		return codCalEmpCalVal;
	}

	/**
	 * @param codCalEmpCalVal the codCalEmpCalVal to set
	 */
	public void setCodCalEmpCalVal(java.lang.String codCalEmpCalVal) {
		this.codCalEmpCalVal = codCalEmpCalVal;
	}

	/**
	 * @return the codCal
	 */
	public java.lang.Integer getCodCal() {
		return codCal;
	}

	/**
	 * @param codCal the codCal to set
	 */
	public void setCodCal(java.lang.Integer codCal) {
		this.codCal = codCal;
	}

	/**
	 * @return the codCalVal
	 */
	public java.lang.String getCodCalVal() {
		return codCalVal;
	}

	/**
	 * @param codCalVal the codCalVal to set
	 */
	public void setCodCalVal(java.lang.String codCalVal) {
		this.codCalVal = codCalVal;
	}

	/**
	 * @return the codigoCiudad
	 */
	public java.lang.String getCodigoCiudad() {
		return codigoCiudad;
	}

	/**
	 * @param codigoCiudad the codigoCiudad to set
	 */
	public void setCodigoCiudad(java.lang.String codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
	}

	/**
	 * @return the direccion
	 */
	public java.lang.String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
	}
}

