package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Contiene información de la etiqueta del artículo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTBITEST")
public class ArticuloBitacoraEstadoDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBitacoraEstadoID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBitacoraEstadoID();
	
	/**
	 * Código del artículo
	 */
	@ComparatorTypeField
	private String codigoArticulo;
	@ComparatorTypeField
	private String codigoEstado;
	
	@ComparatorTypeField
	private Boolean esActual;
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOESTADO", referencedColumnName="CODIGOESTADO", insertable=false, updatable=false)})
	private EstadoCodificacionArticuloDTO estadoArticulo;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBitacoraEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBitacoraEstadoID id) {
		this.id = id;
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
	 * @return the codigoEstado
	 */
	public String getCodigoEstado() {
		return codigoEstado;
	}

	/**
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	/**
	 * @return the esActual
	 */
	public Boolean getEsActual() {
		return esActual;
	}

	/**
	 * @param esActual the esActual to set
	 */
	public void setEsActual(Boolean esActual) {
		this.esActual = esActual;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the articulo
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	/**
	 * @return the estadoArticulo
	 */
	public EstadoCodificacionArticuloDTO getEstadoArticulo() {
		return estadoArticulo;
	}

	/**
	 * @param estadoArticulo the estadoArticulo to set
	 */
	public void setEstadoArticulo(EstadoCodificacionArticuloDTO estadoArticulo) {
		this.estadoArticulo = estadoArticulo;
	}

}
