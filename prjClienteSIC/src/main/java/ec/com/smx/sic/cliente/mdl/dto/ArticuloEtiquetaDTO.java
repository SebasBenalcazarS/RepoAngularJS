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
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.etiquetado.modelo.dto.TagDTO;

/**
 * Contiene informaci�n de la etiqueta del art�culo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTETI")
public class ArticuloEtiquetaDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEtiquetaID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEtiquetaID();
	
	private Double alto;
	
	private Double ancho;
	
	private String colorEtiqueta;
	
	@Column(name="VALORORIENTACIONETIQUETA",nullable=true,updatable=true,insertable=true)
	private String valorOrientacionEtiqueta;
	
	@Column(name="CODIGOORIENTACIONETIQUETA",updatable=true,insertable=true)
	private Integer codigoOrientacionEtiqueta;
	
	@Column(name="CODIGOREFERENCIA",nullable=true,updatable=true,insertable=true)
	private Integer codigoReferencia;
	
	@Column(name="VALORSECUENCIA",updatable=true,insertable=true)
	private Long valorSecuencia;
	
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
	 * Id del usuario que realiz� la �ltima actualizaci�n.
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
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="COMPANYID"),
		@JoinColumn(name="TAGCODE", insertable=false, updatable=false, referencedColumnName="TAGCODE")
	})
	private TagDTO tagDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORORIENTACIONETIQUETA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
				  @JoinColumn(name="CODIGOORIENTACIONETIQUETA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO orientacionEtiqueta;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEtiquetaID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEtiquetaID id1) {
		this.id = id1;
	}

	/**
	 * @return the alto
	 */
	public final Double getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public final void setAlto(Double alto) {
		this.alto = alto;
	}

	/**
	 * @return the ancho
	 */
	public final Double getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public final void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioRegistro</code>
	 */
	public String getIdUsuarioRegistro() {
		return this.idUsuarioRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioRegistro</code>.
	 * 
	 * @param idUsuarioRegistro1
	 *            El valor a establecer para la propiedad <code>idUsuarioRegistro</code>.
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro1) {
		this.idUsuarioRegistro = idUsuarioRegistro1;

		if (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) {
			idUsuarioRegistro = idUsuarioRegistro.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>idUsuarioModificacion</code>
	 */
	public String getIdUsuarioModificacion() {
		return this.idUsuarioModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>idUsuarioModificacion</code>.
	 * 
	 * @param idUsuarioModificacion1
	 *            El valor a establecer para la propiedad <code>idUsuarioModificacion</code>.
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion1) {
		this.idUsuarioModificacion = idUsuarioModificacion1;

		if (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32) {
			idUsuarioModificacion = idUsuarioModificacion.substring(0, 32);
		}

	}

	/**
	 * Retorna valor de propiedad <code>fechaRegistro</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaRegistro</code>
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaRegistro</code>.
	 * 
	 * @param fechaRegistro1
	 *            El valor a establecer para la propiedad <code>fechaRegistro</code>.
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro1) {
		this.fechaRegistro = fechaRegistro1;

	}

	/**
	 * Retorna valor de propiedad <code>fechaModificacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>fechaModificacion</code>
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return this.fechaModificacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>fechaModificacion</code>.
	 * 
	 * @param fechaModificacion1
	 *            El valor a establecer para la propiedad <code>fechaModificacion</code>.
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion1) {
		this.fechaModificacion = fechaModificacion1;

	}

	/**
	 * Retorna valor de propiedad <code>articulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>articulo</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO getArticulo() {
		return this.articulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>articulo</code>.
	 * 
	 * @param articulo1
	 *            El valor a establecer para la propiedad <code>articulo</code>.
	 */
	public void setArticulo(ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo1) {
		this.articulo = articulo1;
	}

	/**
	 * @return the tagDTO
	 */
	public final TagDTO getTagDTO() {
		return tagDTO;
	}

	/**
	 * @param tagDTO the tagDTO to set
	 */
	public final void setTagDTO(TagDTO tagDTO) {
		this.tagDTO = tagDTO;
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
	 * 
	 * @return
	 */
	public Boolean getTieneTagDTO() {
		return isLoaded(this.tagDTO);
	}

	public String getColorEtiqueta() {
		return colorEtiqueta;
	}

	public void setColorEtiqueta(String colorEtiqueta) {
		this.colorEtiqueta = colorEtiqueta;
	}

	/**
	 * @return the valorOrientacionEtiqueta
	 */
	public String getValorOrientacionEtiqueta() {
		return valorOrientacionEtiqueta;
	}

	/**
	 * @param valorOrientacionEtiqueta the valorOrientacionEtiqueta to set
	 */
	public void setValorOrientacionEtiqueta(String valorOrientacionEtiqueta) {
		this.valorOrientacionEtiqueta = valorOrientacionEtiqueta;
	}

	/**
	 * @return the codigoOrientacionEtiqueta
	 */
	public Integer getCodigoOrientacionEtiqueta() {
		return codigoOrientacionEtiqueta;
	}

	/**
	 * @param codigoOrientacionEtiqueta the codigoOrientacionEtiqueta to set
	 */
	public void setCodigoOrientacionEtiqueta(Integer codigoOrientacionEtiqueta) {
		this.codigoOrientacionEtiqueta = codigoOrientacionEtiqueta;
	}

	public Integer getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(Integer codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	public Long getValorSecuencia() {
		return valorSecuencia;
	}

	public void setValorSecuencia(Long valorSecuencia) {
		this.valorSecuencia = valorSecuencia;
	}

	/**
	 * @return the orientacionEtiqueta
	 */
	public CatalogoValorDTO getOrientacionEtiqueta() {
		return orientacionEtiqueta;
	}

	/**
	 * @param orientacionEtiqueta the orientacionEtiqueta to set
	 */
	public void setOrientacionEtiqueta(CatalogoValorDTO orientacionEtiqueta) {
		this.orientacionEtiqueta = orientacionEtiqueta;
	}
}
