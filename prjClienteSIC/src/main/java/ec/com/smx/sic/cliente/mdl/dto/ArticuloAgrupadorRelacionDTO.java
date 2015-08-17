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
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloAgrupadorRelacionID;

/**
 * Almacena las relaciones entre los agrupadores del art&iacute;culo
 * 
 * @author fmunoz
 */
@Entity
@Table(name = "SCARTTARTAGRREL")
@SuppressWarnings("serial")
public class ArticuloAgrupadorRelacionDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ArticuloAgrupadorRelacionID id = new ArticuloAgrupadorRelacionID();
	/**
	 * C&oacute;digo del art&iacute;culo
	 */
	@ComparatorTypeField
	private String codigoArticulo;
	/**
	 * Codigo del Tipo de agrupador del Articulo
	 *
	 */
	@Column(name = "CODTIPAGRPRI", nullable = false)
	private Integer codigoTipoAgrupador ;		

	/**
	 * Valor del Tipo de agrupador del Articulo
	 *
	 */
	@ComparatorTypeField
	@Column(name = "VALTIPAGRPRI", nullable = false)
	private String valorTipoAgrupador ;
	/**
	 * Codigo del Tipo de agrupador del Articulo
	 *
	 */
	@Column(name = "CODTIPAGRREL", nullable = false)
	private Integer codigoTipoAgrupadorRelacionado ;		

	/**
	 * Valor del Tipo de agrupador del Articulo
	 *
	 */
	@ComparatorTypeField
	@Column(name = "VALTIPAGRREL", nullable = false)
	private String valorTipoAgrupadorRelacionado ;
	
	/**
	 * Estado del registro (1/0)
	 */
	@ComparatorTypeField
	private String estado ;

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
	 * Id del usuario que realiza la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="VALTIPAGRPRI", referencedColumnName="VALORTIPOAGRUPADOR", insertable=false, updatable=false),
		@JoinColumn(name="CODTIPAGRPRI", referencedColumnName="CODIGOTIPOAGRUPADOR", insertable=false, updatable=false)})
	private ArticuloAgrupadorDTO articuloAgrupadorPrincipal;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false),
		@JoinColumn(name="VALTIPAGRREL", referencedColumnName="VALORTIPOAGRUPADOR", insertable=false, updatable=false),
		@JoinColumn(name="CODTIPAGRREL", referencedColumnName="CODIGOTIPOAGRUPADOR", insertable=false, updatable=false)})
	private ArticuloAgrupadorDTO articuloAgrupadorRelacionado;
	
	
	/**
	 * @return the id
	 */
	public ArticuloAgrupadorRelacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloAgrupadorRelacionID id) {
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
	 * @return the codigoTipoAgrupador
	 */
	public Integer getCodigoTipoAgrupador() {
		return codigoTipoAgrupador;
	}

	/**
	 * @param codigoTipoAgrupador the codigoTipoAgrupador to set
	 */
	public void setCodigoTipoAgrupador(Integer codigoTipoAgrupador) {
		this.codigoTipoAgrupador = codigoTipoAgrupador;
	}

	/**
	 * @return the valorTipoAgrupador
	 */
	public String getValorTipoAgrupador() {
		return valorTipoAgrupador;
	}

	/**
	 * @param valorTipoAgrupador the valorTipoAgrupador to set
	 */
	public void setValorTipoAgrupador(String valorTipoAgrupador) {
		this.valorTipoAgrupador = valorTipoAgrupador;
	}

	/**
	 * @return the codigoTipoAgrupadorRelacionado
	 */
	public Integer getCodigoTipoAgrupadorRelacionado() {
		return codigoTipoAgrupadorRelacionado;
	}

	/**
	 * @param codigoTipoAgrupadorRelacionado the codigoTipoAgrupadorRelacionado to set
	 */
	public void setCodigoTipoAgrupadorRelacionado(Integer codigoTipoAgrupadorRelacionado) {
		this.codigoTipoAgrupadorRelacionado = codigoTipoAgrupadorRelacionado;
	}

	/**
	 * @return the valorTipoAgrupadorRelacionado
	 */
	public String getValorTipoAgrupadorRelacionado() {
		return valorTipoAgrupadorRelacionado;
	}

	/**
	 * @param valorTipoAgrupadorRelacionado the valorTipoAgrupadorRelacionado to set
	 */
	public void setValorTipoAgrupadorRelacionado(String valorTipoAgrupadorRelacionado) {
		this.valorTipoAgrupadorRelacionado = valorTipoAgrupadorRelacionado;
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
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the articuloAgrupadorPrincipal
	 */
	public ArticuloAgrupadorDTO getArticuloAgrupadorPrincipal() {
		return articuloAgrupadorPrincipal;
	}

	/**
	 * @param articuloAgrupadorPrincipal the articuloAgrupadorPrincipal to set
	 */
	public void setArticuloAgrupadorPrincipal(ArticuloAgrupadorDTO articuloAgrupadorPrincipal) {
		this.articuloAgrupadorPrincipal = articuloAgrupadorPrincipal;
	}

	/**
	 * @return the articuloAgrupadorRelacionado
	 */
	public ArticuloAgrupadorDTO getArticuloAgrupadorRelacionado() {
		return articuloAgrupadorRelacionado;
	}

	/**
	 * @param articuloAgrupadorRelacionado the articuloAgrupadorRelacionado to set
	 */
	public void setArticuloAgrupadorRelacionado(ArticuloAgrupadorDTO articuloAgrupadorRelacionado) {
		this.articuloAgrupadorRelacionado = articuloAgrupadorRelacionado;
	}

}
