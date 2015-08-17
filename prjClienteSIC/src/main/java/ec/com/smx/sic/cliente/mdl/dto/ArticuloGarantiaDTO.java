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
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloGarantiaID;

/**
 * Entidad que almacena datos relacionados a la garantia  de un articulo.
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTGAR")
public class ArticuloGarantiaDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ArticuloGarantiaID id = new ArticuloGarantiaID();

	/**
	 * Indica el estado de garantia  del articulo. Los posibles valores son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoGarantia;

	/**
	 * Indica el estado de la extensiin de garantia  del articulo. Los posibles valores son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoExtensionGarantia;

	/**
	 * Tiempo normal que se puede cubrir una garantia para un articulo.
	 * 
	 */
	private Integer tieMaxGarNor;

	/**
	 * Tiempo miximo que se puede cubrir una garantia para un articulo.
	 * 
	 */
	private Integer tieMaxExtGar;

	/**
	 * Tiempo maximo para vender una extensiin de garantia  apartir de la fecha de compra
	 * 
	 */
	private Integer tieMaxVenExtGar;

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
	 * Id del usuario que realizi la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizi la ultima actualizacion.
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
	public ArticuloGarantiaID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ArticuloGarantiaID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>estadoGarantia</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoGarantia</code>
	 */
	public String getEstadoGarantia() {
		return this.estadoGarantia;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoGarantia</code>.
	 * 
	 * @param estadoGarantia1
	 *            El valor a establecer para la propiedad <code>estadoGarantia</code>.
	 */
	public void setEstadoGarantia(String estadoGarantia1) {
		this.estadoGarantia = estadoGarantia1;

		if (estadoGarantia != null && estadoGarantia.length() > 1) {
			estadoGarantia = estadoGarantia.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estadoExtensionGarantia</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoExtensionGarantia</code>
	 */
	public String getEstadoExtensionGarantia() {
		return this.estadoExtensionGarantia;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoExtensionGarantia</code>.
	 * 
	 * @param estadoExtensionGarantia1
	 *            El valor a establecer para la propiedad <code>estadoExtensionGarantia</code>.
	 */
	public void setEstadoExtensionGarantia(String estadoExtensionGarantia1) {
		this.estadoExtensionGarantia = estadoExtensionGarantia1;

		if (estadoExtensionGarantia != null && estadoExtensionGarantia.length() > 1) {
			estadoExtensionGarantia = estadoExtensionGarantia.substring(0, 1);
		}

	}

	/**
	 * Retorna valor de propiedad <code>tieMaxGarNor</code>
	 * 
	 * @return Retorna valor de propiedad <code>tieMaxGarNor</code>
	 */
	public Integer getTieMaxGarNor() {
		return this.tieMaxGarNor;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tieMaxGarNor</code>.
	 * 
	 * @param tieMaxGarNor1
	 *            El valor a establecer para la propiedad <code>tieMaxGarNor</code>.
	 */
	public void setTieMaxGarNor(Integer tieMaxGarNor1) {
		this.tieMaxGarNor = tieMaxGarNor1;

	}

	/**
	 * Retorna valor de propiedad <code>tieMaxExtGar</code>
	 * 
	 * @return Retorna valor de propiedad <code>tieMaxExtGar</code>
	 */
	public Integer getTieMaxExtGar() {
		return this.tieMaxExtGar;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tieMaxExtGar</code>.
	 * 
	 * @param tieMaxExtGar1
	 *            El valor a establecer para la propiedad <code>tieMaxExtGar</code>.
	 */
	public void setTieMaxExtGar(Integer tieMaxExtGar1) {
		this.tieMaxExtGar = tieMaxExtGar1;

	}

	/**
	 * Retorna valor de propiedad <code>tieMaxVenExtGar</code>
	 * 
	 * @return Retorna valor de propiedad <code>tieMaxVenExtGar</code>
	 */
	public Integer getTieMaxVenExtGar() {
		return this.tieMaxVenExtGar;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tieMaxVenExtGar</code>.
	 * 
	 * @param tieMaxVenExtGar1
	 *            El valor a establecer para la propiedad <code>tieMaxVenExtGar</code>.
	 */
	public void setTieMaxVenExtGar(Integer tieMaxVenExtGar1) {
		this.tieMaxVenExtGar = tieMaxVenExtGar1;

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


}
