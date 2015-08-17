package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLeyendaID;

/**
 * Alamacena leyendas del art&iacute;culo para usarlo en publicaciones
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTLEY")
public class ArticuloLeyendaDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ArticuloLeyendaID id = new ArticuloLeyendaID();
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	@ComparatorTypeField
	private String codigoArticulo;
	
	private String codigoBarras;
	private String descripcionArticulo;
	/**
	 * Almacena el precio normal de afiliado
	 */
	private Double precionormal;
	/**
	 * Almacena el precio final del artículo si tuviera algún descuento
	 */
	private Double preciofinal;
	/**
	 * Almacena el porcentaje de descuento total
	 */
	private Double porcentajeDescuento;
	/**
	 * Almacena el valor de descuento total
	 */
	private Double valorDescuento;
	private String leyendaPrecioNormal;
	private String leyendaPrecioFinal;
	private String leyendaDescuento;
	private String terminosCondiciones;
	private String leyendaVigencia;
	private Date fechaInicioVigencia;
	private Date fechaFinVigencia;
	
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Fecha en la que se realizó la última actualización.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	public ArticuloLeyendaID getId() {
		return id;
	}

	public void setId(ArticuloLeyendaID id) {
		this.id = id;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public Double getPrecionormal() {
		return precionormal;
	}

	public void setPrecionormal(Double precionormal) {
		this.precionormal = precionormal;
	}

	public Double getPreciofinal() {
		return preciofinal;
	}

	public void setPreciofinal(Double preciofinal) {
		this.preciofinal = preciofinal;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Double getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	public String getLeyendaPrecioNormal() {
		return leyendaPrecioNormal;
	}

	public void setLeyendaPrecioNormal(String leyendaPrecioNormal) {
		this.leyendaPrecioNormal = leyendaPrecioNormal;
	}

	public String getLeyendaPrecioFinal() {
		return leyendaPrecioFinal;
	}

	public void setLeyendaPrecioFinal(String leyendaPrecioFinal) {
		this.leyendaPrecioFinal = leyendaPrecioFinal;
	}

	public String getLeyendaDescuento() {
		return leyendaDescuento;
	}

	public void setLeyendaDescuento(String leyendaDescuento) {
		this.leyendaDescuento = leyendaDescuento;
	}

	public String getTerminosCondiciones() {
		return terminosCondiciones;
	}

	public void setTerminosCondiciones(String terminosCondiciones) {
		this.terminosCondiciones = terminosCondiciones;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public String getLeyendaVigencia() {
		return leyendaVigencia;
	}

	public void setLeyendaVigencia(String leyendaVigencia) {
		this.leyendaVigencia = leyendaVigencia;
	}	
}