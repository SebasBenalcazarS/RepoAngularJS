/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.OficinaExteriorID;

/**
 * @author vjaramillo
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADVOFIEXT")
public class VistaOficinaExteriorDTO extends SearchDTO {

	@EmbeddedId
	private OficinaExteriorID id = new OficinaExteriorID();

	private String abreviaturaOficinaExterior;
	private String nombreOficinaExterior;
	private String nombreComercial;
	private String razonSocial;
	private Long codigoPersona;
	private Long codigoLocalizacion;
	private Long codigoEmpresa;
	private Long codigoEntidad;
	private String valorTipoEntidad;
	private Integer codigoTipoEntidad;
	private String numeroDocumento;
	private String tipoDocumento;
	private String estadoOficinaExterior;
	private String usuarioCreacion;
	private Timestamp fechaCreacion;
	private String usuarioActualizacion;
	private Timestamp fechaUltimaActualizacion;
	/**
	 * @return the id
	 */
	public OficinaExteriorID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(OficinaExteriorID id) {
		this.id = id;
	}
	/**
	 * @return the abreviaturaOficinaExterior
	 */
	public String getAbreviaturaOficinaExterior() {
		return abreviaturaOficinaExterior;
	}
	/**
	 * @param abreviaturaOficinaExterior the abreviaturaOficinaExterior to set
	 */
	public void setAbreviaturaOficinaExterior(String abreviaturaOficinaExterior) {
		this.abreviaturaOficinaExterior = abreviaturaOficinaExterior;
	}
	/**
	 * @return the nombreOficinaExterior
	 */
	public String getNombreOficinaExterior() {
		return nombreOficinaExterior;
	}
	/**
	 * @param nombreOficinaExterior the nombreOficinaExterior to set
	 */
	public void setNombreOficinaExterior(String nombreOficinaExterior) {
		this.nombreOficinaExterior = nombreOficinaExterior;
	}
	/**
	 * @return the nombreComercial
	 */
	public String getNombreComercial() {
		return nombreComercial;
	}
	/**
	 * @param nombreComercial the nombreComercial to set
	 */
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}
	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	/**
	 * @return the codigoPersona
	 */
	public Long getCodigoPersona() {
		return codigoPersona;
	}
	/**
	 * @param codigoPersona the codigoPersona to set
	 */
	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
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
	 * @return the codigoEmpresa
	 */
	public Long getCodigoEmpresa() {
		return codigoEmpresa;
	}
	/**
	 * @param codigoEmpresa the codigoEmpresa to set
	 */
	public void setCodigoEmpresa(Long codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	/**
	 * @return the codigoEntidad
	 */
	public Long getCodigoEntidad() {
		return codigoEntidad;
	}
	/**
	 * @param codigoEntidad the codigoEntidad to set
	 */
	public void setCodigoEntidad(Long codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}
	/**
	 * @return the valorTipoEntidad
	 */
	public String getValorTipoEntidad() {
		return valorTipoEntidad;
	}
	/**
	 * @param valorTipoEntidad the valorTipoEntidad to set
	 */
	public void setValorTipoEntidad(String valorTipoEntidad) {
		this.valorTipoEntidad = valorTipoEntidad;
	}
	/**
	 * @return the codigoTipoEntidad
	 */
	public Integer getCodigoTipoEntidad() {
		return codigoTipoEntidad;
	}
	/**
	 * @param codigoTipoEntidad the codigoTipoEntidad to set
	 */
	public void setCodigoTipoEntidad(Integer codigoTipoEntidad) {
		this.codigoTipoEntidad = codigoTipoEntidad;
	}
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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
	 * @return the usuarioCreacion
	 */
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	/**
	 * @param usuarioCreacion the usuarioCreacion to set
	 */
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the usuarioActualizacion
	 */
	public String getUsuarioActualizacion() {
		return usuarioActualizacion;
	}
	/**
	 * @param usuarioActualizacion the usuarioActualizacion to set
	 */
	public void setUsuarioActualizacion(String usuarioActualizacion) {
		this.usuarioActualizacion = usuarioActualizacion;
	}
	/**
	 * @return the fechaUltimaActualizacion
	 */
	public Timestamp getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}
	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}	
}
