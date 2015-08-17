package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;

/**
 * Entidad que almacena datos comerciales de un artículo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
//@Entity
//@Table(name="SCARTTARTENV")
public class ArticuloEnvaseDTO extends SimpleAuditDTO {

	/**
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEnvaseID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEnvaseID();
	
	private String codigoArticulo;
	@ComparatorTypeField
	private String estado;
	@ComparatorTypeField
	private String valorMaterialEnvase;
	private Integer codigoMaterialEnvase;
	@ComparatorTypeField
	private String valorTipoEnvase;
	private Integer codigoTipoEnvase;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String usuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String usuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORMATERIALENVASE", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOMATERIALENVASE", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO materialEnvase;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOENVASE", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOENVASE", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoEnvase;
	
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEnvaseID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloEnvaseID id) {
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

	public String getValorMaterialEnvase() {
		return valorMaterialEnvase;
	}

	public void setValorMaterialEnvase(String valorMaterialEnvase) {
		this.valorMaterialEnvase = valorMaterialEnvase;
	}

	public Integer getCodigoMaterialEnvase() {
		return codigoMaterialEnvase;
	}

	public void setCodigoMaterialEnvase(Integer codigoMaterialEnvase) {
		this.codigoMaterialEnvase = codigoMaterialEnvase;
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

	public CatalogoValorDTO getMaterialEnvase() {
		return materialEnvase;
	}

	public void setMaterialEnvase(CatalogoValorDTO materialEnvase) {
		this.materialEnvase = materialEnvase;
	}

	public String getValorTipoEnvase() {
		return valorTipoEnvase;
	}

	public void setValorTipoEnvase(String valorTipoEnvase) {
		this.valorTipoEnvase = valorTipoEnvase;
	}

	public Integer getCodigoTipoEnvase() {
		return codigoTipoEnvase;
	}

	public void setCodigoTipoEnvase(Integer codigoTipoEnvase) {
		this.codigoTipoEnvase = codigoTipoEnvase;
	}

	public CatalogoValorDTO getTipoEnvase() {
		return tipoEnvase;
	}

	public void setTipoEnvase(CatalogoValorDTO tipoEnvase) {
		this.tipoEnvase = tipoEnvase;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	
}
