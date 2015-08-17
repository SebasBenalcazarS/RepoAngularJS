package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author srodriguez
 * 2014-09-10
*/

@Entity
@SuppressWarnings("serial")
public class VistaEmpresaParticipanteDTO implements Serializable {

	@Id
	private String codigo;
	
	private String documento;
	
//	@Transient
	private String tipoDocumento;
	
	private String nombre;
	
	private String codigoJDE;
	
//	@Transient
	private String tipo;
	
	@Transient
	private boolean oficinaExterior;
	
	//Variables para Participantes tipo persona
	@Transient
	private String codigoJDEPersona;
	
	@Transient
	private String nombreComercialPersona;
	
	//Variables para Participantes tipo empresa
	@Transient
	private String codigoJDELocalizacion;
	
	@Transient
	private String descripcionLocalizacion;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the codigoJDE
	 */
	public String getCodigoJDE() {
		return codigoJDE;
	}

	/**
	 * @param codigoJDE the codigoJDE to set
	 */
	public void setCodigoJDE(String codigoJDE) {
		this.codigoJDE = codigoJDE;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the oficinaExterior
	 */
	public boolean getOficinaExterior() {
		return oficinaExterior;
	}

	/**
	 * @param oficinaExterior the oficinaExterior to set
	 */
	public void setOficinaExterior(boolean oficinaExterior) {
		this.oficinaExterior = oficinaExterior;
	}

	/**
	 * @return the codigoJDEPersona
	 */
	public String getCodigoJDEPersona() {
		return codigoJDEPersona;
	}

	/**
	 * @param codigoJDEPersona the codigoJDEPersona to set
	 */
	public void setCodigoJDEPersona(String codigoJDEPersona) {
		this.codigoJDEPersona = codigoJDEPersona;
	}

	/**
	 * @return the nombreComercialPersona
	 */
	public String getNombreComercialPersona() {
		return nombreComercialPersona;
	}

	/**
	 * @param nombreComercialPersona the nombreComercialPersona to set
	 */
	public void setNombreComercialPersona(String nombreComercialPersona) {
		this.nombreComercialPersona = nombreComercialPersona;
	}

	/**
	 * @return the codigoJDELocalizacion
	 */
	public String getCodigoJDELocalizacion() {
		return codigoJDELocalizacion;
	}

	/**
	 * @param codigoJDELocalizacion the codigoJDELocalizacion to set
	 */
	public void setCodigoJDELocalizacion(String codigoJDELocalizacion) {
		this.codigoJDELocalizacion = codigoJDELocalizacion;
	}

	/**
	 * @return the descripcionLocalizacion
	 */
	public String getDescripcionLocalizacion() {
		return descripcionLocalizacion;
	}

	/**
	 * @param descripcionLocalizacion the descripcionLocalizacion to set
	 */
	public void setDescripcionLocalizacion(String descripcionLocalizacion) {
		this.descripcionLocalizacion = descripcionLocalizacion;
	}
	
}
