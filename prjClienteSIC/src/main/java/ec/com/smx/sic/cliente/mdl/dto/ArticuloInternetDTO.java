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
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloInternetID;

/**
 * Entidad que almacena datos relacionados de artículos con el internet
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTINT")
public class ArticuloInternetDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ArticuloInternetID id = new ArticuloInternetID();

	/**
	 * Dias de entrega al cliente que tiene un artículo cuando se lo vende por internet
	 * 
	 */
	private Integer diasEntregaAlCliente;

	/**
	 * Indica si un artículo se lo puede publicar en Internet o no. Los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoPublicacion;

	/**
	 * Descripción para la publicación en internet
	 */
	private String descripcionPublicacionInternet;
	
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
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ArticuloInternetID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ArticuloInternetID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>diasEntregaAlCliente</code>
	 * 
	 * @return Retorna valor de propiedad <code>diasEntregaAlCliente</code>
	 */
	public Integer getDiasEntregaAlCliente() {
		return this.diasEntregaAlCliente;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>diasEntregaAlCliente</code>.
	 * 
	 * @param diasEntregaAlCliente1
	 *            El valor a establecer para la propiedad <code>diasEntregaAlCliente</code>.
	 */
	public void setDiasEntregaAlCliente(Integer diasEntregaAlCliente1) {
		this.diasEntregaAlCliente = diasEntregaAlCliente1;

	}

	/**
	 * Retorna valor de propiedad <code>estadoPublicacion</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoPublicacion</code>
	 */
	public String getEstadoPublicacion() {
		return this.estadoPublicacion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoPublicacion</code>.
	 * 
	 * @param estadoPublicacion1
	 *            El valor a establecer para la propiedad <code>estadoPublicacion</code>.
	 */
	public void setEstadoPublicacion(String estadoPublicacion1) {
		this.estadoPublicacion = estadoPublicacion1;

		if (estadoPublicacion != null && estadoPublicacion.length() > 1) {
			estadoPublicacion = estadoPublicacion.substring(0, 1);
		}

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
	 * @return the descripcionPublicacionInternet
	 */
	public String getDescripcionPublicacionInternet() {
		return descripcionPublicacionInternet;
	}

	/**
	 * @param descripcionPublicacionInternet the descripcionPublicacionInternet to set
	 */
	public void setDescripcionPublicacionInternet(String descripcionPublicacionInternet) {
		this.descripcionPublicacionInternet = descripcionPublicacionInternet;
	}

}
