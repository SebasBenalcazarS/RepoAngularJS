package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.BodegaID;

@Entity
@Table(name="SCSPETBODEGA")
@SuppressWarnings("serial")
public class BodegaDTO extends SimpleAuditDTO{

	@EmbeddedId
	private BodegaID id;
	
	private String descripcionBodega;
	
	@ComparatorTypeField
	private String estadoBodega;
	
	@LastModifierUserIdField
	@ComparatorTypeField
	private String usuarioActualizacion;
	
	@LastModificationDateField
	private Timestamp fechaUltimaActualizacion;
	
	@RegisterUserIdField
	@ComparatorTypeField
	private String usuarioCreacion;
	
	@RegisterDateField
	private Timestamp fechaCreacion;
	
	@ComparatorTypeField
	private String tipoBodega;
	
	@ComparatorTypeField
	private String codigoReferencia;
	
	@Column(name="CODIGOAREATRABAJO")
	private Integer codigoAreaTrabajo;
	
	@Transient
	private Boolean seleccionado=Boolean.FALSE;
	@Transient
	private Integer countSubbodegas=0;
	@Transient
	private SeccionDTO naveSeccionDTO;
	@Transient
	private SeccionDTO ubicacionSeccionDTO;
	@Transient
	private SeccionDTO andenSeccionDTO;
	@Transient
	private Boolean plegar=Boolean.FALSE;
	@Transient
	private BodegaDTO bodegaPadre;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOAREATRABAJO", insertable=false, updatable=false, referencedColumnName="CODIGOAREATRABAJO")})
	private ec.com.smx.corpv2.dto.AreaTrabajoDTO areaTrabajo;
	
	public BodegaDTO() {
		id = new BodegaID();
	}
	public BodegaDTO(Boolean initID) {
		id = new BodegaID(initID);
	}
	/**
	 * @return the id
	 */
	public BodegaID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(BodegaID id) {
		this.id = id;
	}
	
	/**
	 * @return the descripcionBodega
	 */
	public String getDescripcionBodega() {
		return descripcionBodega;
	}
	/**
	 * @param descripcionBodega the descripcionBodega to set
	 */
	public void setDescripcionBodega(String descripcionBodega) {
		this.descripcionBodega = descripcionBodega != null ? descripcionBodega.toUpperCase() : null;
	}
	/**
	 * @return the estadoBodega
	 */
	public String getEstadoBodega() {
		return estadoBodega;
	}
	/**
	 * @param estadoBodega the estadoBodega to set
	 */
	public void setEstadoBodega(String estadoBodega) {
		this.estadoBodega = estadoBodega;
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
	 * @return Obtiene el codigo del SIC
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}
	/**
	 * @param codigoReferencia Establece el codigo del SIC
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}
	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
	/**
	 * @return the areaTrabajo
	 */
	public ec.com.smx.corpv2.dto.AreaTrabajoDTO getAreaTrabajo() {
		return areaTrabajo;
	}
	/**
	 * @param areaTrabajo the areaTrabajo to set
	 */
	public void setAreaTrabajo(ec.com.smx.corpv2.dto.AreaTrabajoDTO areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}
	
	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}
	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	/**
	 * @return the countSubbodegas
	 */
	public Integer getCountSubbodegas() {
		return countSubbodegas;
	}
	/**
	 * @param countSubbodegas the countSubbodegas to set
	 */
	public void setCountSubbodegas(Integer countSubbodegas) {
		this.countSubbodegas = countSubbodegas;
	}
	/**
	 * @return the naveSeccionDTO
	 */
	public SeccionDTO getNaveSeccionDTO() {
		return naveSeccionDTO;
	}
	/**
	 * @param naveSeccionDTO the naveSeccionDTO to set
	 */
	public void setNaveSeccionDTO(SeccionDTO naveSeccionDTO) {
		this.naveSeccionDTO = naveSeccionDTO;
	}
	/**
	 * @return the ubicacionSeccionDTO
	 */
	public SeccionDTO getUbicacionSeccionDTO() {
		return ubicacionSeccionDTO;
	}
	/**
	 * @param ubicacionSeccionDTO the ubicacionSeccionDTO to set
	 */
	public void setUbicacionSeccionDTO(SeccionDTO ubicacionSeccionDTO) {
		this.ubicacionSeccionDTO = ubicacionSeccionDTO;
	}
	/**
	 * @return the andenSeccionDTO
	 */
	public SeccionDTO getAndenSeccionDTO() {
		return andenSeccionDTO;
	}
	/**
	 * @param andenSeccionDTO the andenSeccionDTO to set
	 */
	public void setAndenSeccionDTO(SeccionDTO andenSeccionDTO) {
		this.andenSeccionDTO = andenSeccionDTO;
	}
	/**
	 * @return the plegar
	 */
	public Boolean getPlegar() {
		return plegar;
	}
	/**
	 * @param plegar the plegar to set
	 */
	public void setPlegar(Boolean plegar) {
		this.plegar = plegar;
	}

	/**
	 * @return the tipoBodega
	 */
	public String getTipoBodega() {
		return tipoBodega;
	}
	/**
	 * @param tipoBodega the tipoBodega to set
	 */
	public void setTipoBodega(String tipoBodega) {
		this.tipoBodega = tipoBodega;
	}
	public BodegaDTO getBodegaPadre() {
		return bodegaPadre;
	}
	public void setBodegaPadre(BodegaDTO bodegaPadre) {
		this.bodegaPadre = bodegaPadre;
	}
}
