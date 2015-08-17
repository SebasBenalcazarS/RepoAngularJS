/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.ShardDiscriminator;
import ec.com.kruger.utilitario.dao.commons.annotations.ShardDiscriminatorColumn;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ShardDiscriminatorType;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.frameworkv2.security.dto.AccessItemDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloAreaTrabajoBitacoraID;


@Entity
@Table(name="SCSADTARTARETRABIT")
@ShardDiscriminator(type=ShardDiscriminatorType.TABLE_SUFFIX,concatenator="",discriminatorColumn=@ShardDiscriminatorColumn(fieldDiscriminator="tipoAreaTrabajo"))
@SuppressWarnings("serial")
public class ArticuloAreaTrabajoBitacoraDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ArticuloAreaTrabajoBitacoraID id = new ArticuloAreaTrabajoBitacoraID();
	
	@Transient
	private String tipoAreaTrabajo=SICConstantes.getInstancia().SUFIJO_TIPO_AREA_TRABAJO_LOCAL;

	/**
	 * 
	 */
	@Column(name = "CODIGOAREATRABAJO")
	private Integer codigoAreaTrabajo;
	
	/**
	 * 
	 */
	@Column(name = "CODIGOARTICULO")
	@ComparatorTypeField
	private String codigoArticulo;
	
	/**
	 * es el codigo del sistema
	 */
	@Column(name = "CODIGOSISTEMA")
	@ComparatorTypeField
	private String codigoSistema;
	
	/**
	 * es el codigo de la aplicacion que activa o inactiva un alcance
	 */
	@Column(name = "CODIGOOPCION")
	@ComparatorTypeField
	private String codigoOpcion;

	/**
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOSISTEMA", insertable=false, updatable=false, referencedColumnName="SYSID"),
		@JoinColumn(name="CODIGOOPCION", referencedColumnName="ACCITEID", insertable=false, updatable=false)})
	private AccessItemDto opcion;
	
	/**
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOAREATRABAJO", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
	private AreaTrabajoDTO areaTrabajo;
	
	
	/**
	 * es el estado del alcance
	 */
	@Column(name = "ESTADOALCANCE")
	@ComparatorTypeField
	private String estadoAlcance;
	
	/**
	 * 
	 */
	@Column(name = "USUARIOALCANCE")
	@ComparatorTypeField
	private String usuarioAlcance;
	
	/**
	 * Referencia al usuario alcance
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOALCANCE", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioAlcanceDto;
	
	/**
	 * 
	 */
	@Column(name = "FECHAALCANCE")
	private Date fechaAlcance;
	
	/**
	 * 
	 */
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
	/**
	 * 
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private String estado;

	/**
	 * Fecha inicial de validez del alcance
	 */
	@Column(name = "FECHAINICIALALCANCE")
	private Date fechaInicialAlcance;
	/**
	 * Fecha final de validez del alcance
	 */
	@Column(name = "FECHAFINALALCANCE")
	private Date fechaFinalAlcance;
	
	/**
	 * tipo asignacion, opcion de la que se da el alcance
	 */
	@Column(name = "TIPOASIGNACIONVALOR")
	private String tipoAsignacionValor;
	
	/**
	 * tipo asignacion, opcion de la que se da el alcance
	 */
	@Column(name = "CODIGOTIPOASIGNACION")
	private Integer codigoTipoAsignacion;
	
	/**
	 * tipo bitacora si es regitro normal o error
	 */
	@Column(name = "TIPOBITACORAVALOR")
	private String tipoBitacoraValor;
	
	/**
	 * tipo bitacora si es regitro normal o error
	 */
	@Column(name = "CODIGOTIPOBITACORA")
	private Integer codigoTipoBitacora;
	
	
	/**
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOAREATRABAJO", referencedColumnName="CODIGOLOCAL", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloLocalDTO articuloAreaTrabajo;


	/**
	 * @return the id
	 */
	public ArticuloAreaTrabajoBitacoraID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloAreaTrabajoBitacoraID id) {
		this.id = id;
	}


	/**
	 * @return the tipoAreaTrabajo
	 */
	public String getTipoAreaTrabajo() {
		return tipoAreaTrabajo;
	}


	/**
	 * @param tipoAreaTrabajo the tipoAreaTrabajo to set
	 */
	public void setTipoAreaTrabajo(String tipoAreaTrabajo) {
		this.tipoAreaTrabajo = tipoAreaTrabajo;
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
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}


	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}


	/**
	 * @return the codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}


	/**
	 * @param codigoSistema the codigoSistema to set
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}


	/**
	 * @return the codigoOpcion
	 */
	public String getCodigoOpcion() {
		return codigoOpcion;
	}


	/**
	 * @param codigoOpcion the codigoOpcion to set
	 */
	public void setCodigoOpcion(String codigoOpcion) {
		this.codigoOpcion = codigoOpcion;
	}


	/**
	 * @return the opcion
	 */
	public AccessItemDto getOpcion() {
		return opcion;
	}


	/**
	 * @param opcion the opcion to set
	 */
	public void setOpcion(AccessItemDto opcion) {
		this.opcion = opcion;
	}


	/**
	 * @return the areaTrabajo
	 */
	public AreaTrabajoDTO getAreaTrabajo() {
		return areaTrabajo;
	}


	/**
	 * @param areaTrabajo the areaTrabajo to set
	 */
	public void setAreaTrabajo(AreaTrabajoDTO areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}


	/**
	 * @return the estadoAlcance
	 */
	public String getEstadoAlcance() {
		return estadoAlcance;
	}


	/**
	 * @param estadoAlcance the estadoAlcance to set
	 */
	public void setEstadoAlcance(String estadoAlcance) {
		this.estadoAlcance = estadoAlcance;
	}


	/**
	 * @return the usuarioAlcance
	 */
	public String getUsuarioAlcance() {
		return usuarioAlcance;
	}


	/**
	 * @param usuarioAlcance the usuarioAlcance to set
	 */
	public void setUsuarioAlcance(String usuarioAlcance) {
		this.usuarioAlcance = usuarioAlcance;
	}


	/**
	 * @return the usuarioAlcanceDto
	 */
	public ec.com.smx.frameworkv2.security.dto.UserDto getUsuarioAlcanceDto() {
		return usuarioAlcanceDto;
	}


	/**
	 * @param usuarioAlcanceDto the usuarioAlcanceDto to set
	 */
	public void setUsuarioAlcanceDto(ec.com.smx.frameworkv2.security.dto.UserDto usuarioAlcanceDto) {
		this.usuarioAlcanceDto = usuarioAlcanceDto;
	}


	/**
	 * @return the fechaAlcance
	 */
	public Date getFechaAlcance() {
		return fechaAlcance;
	}


	/**
	 * @param fechaAlcance the fechaAlcance to set
	 */
	public void setFechaAlcance(Date fechaAlcance) {
		this.fechaAlcance = fechaAlcance;
	}


	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}


	/**
	 * @return the articuloAreaTrabajo
	 */
	public ArticuloLocalDTO getArticuloAreaTrabajo() {
		return articuloAreaTrabajo;
	}


	/**
	 * @param articuloAreaTrabajo the articuloAreaTrabajo to set
	 */
	public void setArticuloAreaTrabajo(ArticuloLocalDTO articuloAreaTrabajo) {
		this.articuloAreaTrabajo = articuloAreaTrabajo;
	}


	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	

	public Date getFechaInicialAlcance() {
		return fechaInicialAlcance;
	}


	public void setFechaInicialAlcance(Date fechaInicialAlcance) {
		this.fechaInicialAlcance = fechaInicialAlcance;
	}


	public Date getFechaFinalAlcance() {
		return fechaFinalAlcance;
	}


	public void setFechaFinalAlcance(Date fechaFinalAlcance) {
		this.fechaFinalAlcance = fechaFinalAlcance;
	}


	public String getTipoAsignacionValor() {
		return tipoAsignacionValor;
	}


	public void setTipoAsignacionValor(String tipoAsignacionValor) {
		this.tipoAsignacionValor = tipoAsignacionValor;
	}


	public Integer getCodigoTipoAsignacion() {
		return codigoTipoAsignacion;
	}


	public void setCodigoTipoAsignacion(Integer codigoTipoAsignacion) {
		this.codigoTipoAsignacion = codigoTipoAsignacion;
	}


	public String getTipoBitacoraValor() {
		return tipoBitacoraValor;
	}


	public void setTipoBitacoraValor(String tipoBitacoraValor) {
		this.tipoBitacoraValor = tipoBitacoraValor;
	}


	public Integer getCodigoTipoBitacora() {
		return codigoTipoBitacora;
	}


	public void setCodigoTipoBitacora(Integer codigoTipoBitacora) {
		this.codigoTipoBitacora = codigoTipoBitacora;
	}
	
}
