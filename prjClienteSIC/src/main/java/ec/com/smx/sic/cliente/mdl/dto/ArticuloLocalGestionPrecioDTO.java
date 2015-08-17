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
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloLocalGestionPrecioID;

/**
 * 
 * @author guvidia
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTLOCGESPRE")
public class ArticuloLocalGestionPrecioDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private ArticuloLocalGestionPrecioID id = new ArticuloLocalGestionPrecioID();

	/**
	 * Identificador &uacute;nico del art&iacute;culo
	 */
	@ComparatorTypeField
	private String codigoArticulo;
	
	/**
	 * C&oacute;digo del area de trabajo
	 */
	@ComparatorTypeField
	@Column( name = "CODIGOAREATRABAJO")
	private Integer codigoLocal;
	
	/**
	 * Secuencial del precio diferenciado 
	 */
	@ComparatorTypeField
	@Column( name = "SECUENCIALPREDIF")
	private Long secuencialPreDif;
		
	/**
	 * Estado que indica si un precio diferenciado est&aacute; activo o no. Los valores permitidos son: [0] Inactivo [1] Activo
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Fecha inicio de la planificacion 
	 */
	private java.sql.Timestamp fechaInicio;
	
	/**
	 * Fecha fin de la planificacion 
	 */
	private java.sql.Timestamp fechaFin;
	
	@ComparatorTypeField
	@Column (name = "VALORESTADOEJECUCION", nullable = false)
	private String valorEstadoEjecucion;

	@Column (name = "CODIGOVALORESTADOEJECUCION", nullable = false)
	private Integer codigoEstadoEjecucion;

	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="SECUENCIALPREDIF", referencedColumnName="SECUENCIAL", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO articuloPrecioDif;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOAREATRABAJO", referencedColumnName="CODIGOAREATRABAJO", insertable=false, updatable=false)})
	private AreaTrabajoDTO local;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORESTADOEJECUCION", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOVALORESTADOEJECUCION", referencedColumnName="CODIGOCATALOGOTIPO", insertable=false, updatable=false)})
	private CatalogoValorDTO tipoEstadoEjecucion;

	public ArticuloLocalGestionPrecioID getId() {
		return id;
	}

	public void setId(ArticuloLocalGestionPrecioID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	public Long getSecuencialPreDif() {
		return secuencialPreDif;
	}

	public void setSecuencialPreDif(Long secuencialPreDif) {
		this.secuencialPreDif = secuencialPreDif;
	}

	public java.sql.Timestamp getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(java.sql.Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public java.sql.Timestamp getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(java.sql.Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return articulo;
	}

	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo) {
		this.articulo = articulo;
	}

	public AreaTrabajoDTO getLocal() {
		return local;
	}

	public void setLocal(AreaTrabajoDTO local) {
		this.local = local;
	}

	public ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO getArticuloPrecioDif() {
		return articuloPrecioDif;
	}

	public void setArticuloPrecioDif(ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO articuloPrecioDif) {
		this.articuloPrecioDif = articuloPrecioDif;
	}

	public String getValorEstadoEjecucion() {
		return valorEstadoEjecucion;
	}

	public void setValorEstadoEjecucion(String valorEstadoEjecucion) {
		this.valorEstadoEjecucion = valorEstadoEjecucion;
	}

	public Integer getCodigoEstadoEjecucion() {
		return codigoEstadoEjecucion;
	}

	public void setCodigoEstadoEjecucion(Integer codigoEstadoEjecucion) {
		this.codigoEstadoEjecucion = codigoEstadoEjecucion;
	}

	public CatalogoValorDTO getTipoEstadoEjecucion() {
		return tipoEstadoEjecucion;
	}

	public void setTipoEstadoEjecucion(CatalogoValorDTO tipoEstadoEjecucion) {
		this.tipoEstadoEjecucion = tipoEstadoEjecucion;
	}

}
