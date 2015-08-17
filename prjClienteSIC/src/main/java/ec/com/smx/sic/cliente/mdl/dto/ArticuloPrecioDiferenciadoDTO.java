package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloPrecioDiferenciadoID;

/**
 * Almacena los valores y margenes de los precios de diferenciados de un art&iacute;culo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTPREDIF")
public class ArticuloPrecioDiferenciadoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ArticuloPrecioDiferenciadoID id = new ArticuloPrecioDiferenciadoID();

	/**
	 * Identificador &uacute;nico del art&iacute;culo
	 */
	@ComparatorTypeField
	private String codigoArticulo;
	
	/**
	 * C&oacute;digo del tipo de precio
	 */
	@ComparatorTypeField
	private String codigoTipoPrecio;
	
	
	/**
	 * Estado que indica si un precio diferenciado est&aacute; activo o no. Los valores permitidos son: [0] Inactivo [1] Activo
	 */
	@ComparatorTypeField
	private String estado;
	
	/**
	 * Valor actual del precio
	 * 
	 */
	private Double valor;
	/**
	 * Porcentaje de margen del precio
	 * 
	 */
	private Double porcentajeMargen;
	
	/**
	 * Valor anterior del precio
	 * 
	 */
	private Double valorAnterior;
	
	/**
	 * Porcentaje anterior de margen del precio
	 * 
	 */
	private Double porcentajeMargenAnterior;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiz&oacute; la &uacute;ltima actualizaci&oacute;n.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz&oacute; la uacute;ltima actualizaci&oacute;n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@OneToMany(mappedBy = "articuloPrecioDif")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ArticuloLocalGestionPrecioDTO> articuloLocalGestionPrecioCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOPRECIO", referencedColumnName="CODIGOTIPOPRECIO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO articuloPrecio;
	
	public ArticuloPrecioDiferenciadoID getId() {
		return id;
	}

	public void setId(ArticuloPrecioDiferenciadoID id) {
		this.id = id;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoTipoPrecio() {
		return codigoTipoPrecio;
	}

	public void setCodigoTipoPrecio(String codigoTipoPrecio) {
		this.codigoTipoPrecio = codigoTipoPrecio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getPorcentajeMargen() {
		return porcentajeMargen;
	}

	public void setPorcentajeMargen(Double porcentajeMargen) {
		this.porcentajeMargen = porcentajeMargen;
	}
	
	public Double getValorAnterior() {
		return valorAnterior;
	}

	public void setValorAnterior(Double valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	public Double getPorcentajeMargenAnterior() {
		return porcentajeMargenAnterior;
	}

	public void setPorcentajeMargenAnterior(Double porcentajeMargenAnterior) {
		this.porcentajeMargenAnterior = porcentajeMargenAnterior;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO getArticuloPrecio() {
		return articuloPrecio;
	}

	public void setArticuloPrecio(ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO articuloPrecio) {
		this.articuloPrecio = articuloPrecio;
	}

	public Collection<ArticuloLocalGestionPrecioDTO> getArticuloLocalGestionPrecioCol() {
		return articuloLocalGestionPrecioCol;
	}

	public void setArticuloLocalGestionPrecioCol(Collection<ArticuloLocalGestionPrecioDTO> articuloLocalGestionPrecioCol) {
		this.articuloLocalGestionPrecioCol = articuloLocalGestionPrecioCol;
	}
	

}
