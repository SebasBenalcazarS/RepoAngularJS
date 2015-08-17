package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Permite configurar el tipo de contenedor en base al catalogo de tipo articulo o cualquier catalogo valor
 * 
 * @author acaiza
 * @author guvidia
 */
@SuppressWarnings("serial")
@Table(name = "SBLOGTTIPCON")
public class TipoContenedorDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla TipoContenedor
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TipoContenedorID id = new ec.com.smx.sic.cliente.mdl.dto.id.TipoContenedorID();
	
	/**
     * Codigo que califica a la clase tipo articulo
     */
	@ComparatorTypeField
	@Column(name = "CODIGOTIPOARTICULO")
    private String codigoTipoArticulo ;
	
	/**
	 * Un CT para tipo de contenedor
	 * 
	 */	
	@ComparatorTypeField
	@Column(name="TIPOCONTENEDORCODIGO")
	private Integer tipoContenedorCodigo;

	/**
	 * Un CV para tipo de contenedor
	 * 
	 */
	@Column(name="TIPOCONTENEDORVALOR")
	private String tipoContenedorValor;
	
	/**
     * Codigo con el identificador del tipo del articulo o el tipo de contenedor del catalogo valor
     */
	@ComparatorTypeField
	@Column(name = "CODIGORELACION", nullable = false)
    private String codigoRelacion ;
	
	/**
	 * Especifica la relacion con CatalogoValor
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "TIPOCONTENEDORVALOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "TIPOCONTENEDORCODIGO", insertable = false, updatable = false, referencedColumnName = "CODIGOCATALOGOTIPO") })
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoContenedor;
	
	/**
	 * Especifica la relacion con Tipo Articulo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOARTICULO", insertable = false, updatable = false, referencedColumnName = "CODIGOTIPOARTICULO") })
	private TipoArticuloDTO tipoArticuloDTO;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@ComparatorTypeField
	@Column(name = "USUARIOREGISTRO")
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAREGISTRO")
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOREGISTRO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.frameworkv2.security.dto.UserDto usuarioCreacion;

	/**
	 * Referencia con la tabla User
	 * 
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIOMODIFICACION", referencedColumnName = "USERID", insertable = false, updatable = false)
	private ec.com.smx.framework.security.dto.UserDto usuarioModificacion;

}
