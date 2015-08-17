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
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;

/**
 * Entidad que almacena los datos de la medida de un artículo
 * 
 * @author fmunoz
 */
@Entity
@Table(name="SCSADTARTMED")
@SuppressWarnings("serial")
public class ArticuloMedidaDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ArticuloID id = new ArticuloID();

	/**
	 * Descripción de la medida del artículo
	 * 
	 */
	private String referenciaMedida;

	/**
	 * Valor de la medida
	 * 
	 */
	private Double cantidadMedida;

	/**
	 * Código del tipo de medida
	 * 
	 */
	@Column(name="CODIGOTIPOMEDIDA")
	private Integer codigoTipoMedida;

	/**
	 * Valor del tipo de medida
	 * 
	 */
	@ComparatorTypeField
	@Column(name="VALORTIPOMEDIDA")
	private String valorTipoMedida;

	private Integer presentacion;
	
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
	@Column(insertable=false)
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	@Column(insertable=false)
	private java.sql.Timestamp fechaModificacion;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO articulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOMEDIDA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOMEDIDA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoMedida;
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ArticuloID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ArticuloID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>referenciaMedida</code>
	 * 
	 * @return Retorna valor de propiedad <code>referenciaMedida</code>
	 */
	public String getReferenciaMedida() {
		return this.referenciaMedida;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>referenciaMedida</code>.
	 * 
	 * @param referenciaMedida1
	 *            El valor a establecer para la propiedad <code>referenciaMedida</code>.
	 */
	public void setReferenciaMedida(String referenciaMedida1) {
		this.referenciaMedida = referenciaMedida1;

		if (referenciaMedida != null && referenciaMedida.length() > 50) {
			referenciaMedida = referenciaMedida.substring(0, 50);
		}

	}

	/**
	 * Retorna valor de propiedad <code>cantidadMedida</code>
	 * 
	 * @return Retorna valor de propiedad <code>cantidadMedida</code>
	 */
	public Double getCantidadMedida() {
		return this.cantidadMedida;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>cantidadMedida</code>.
	 * 
	 * @param cantidadMedida1
	 *            El valor a establecer para la propiedad <code>cantidadMedida</code>.
	 */
	public void setCantidadMedida(Double cantidadMedida1) {
		this.cantidadMedida = cantidadMedida1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoMedida</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoMedida</code>
	 */
	public Integer getCodigoTipoMedida() {
		return this.codigoTipoMedida;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoMedida</code>.
	 * 
	 * @param codigoTipoMedida1
	 *            El valor a establecer para la propiedad <code>codigoTipoMedida</code>.
	 */
	public void setCodigoTipoMedida(Integer codigoTipoMedida1) {
		this.codigoTipoMedida = codigoTipoMedida1;

	}

	/**
	 * Retorna valor de propiedad <code>valorTipoMedida</code>
	 * 
	 * @return Retorna valor de propiedad <code>valorTipoMedida</code>
	 */
	public String getValorTipoMedida() {
		return this.valorTipoMedida;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>valorTipoMedida</code>.
	 * 
	 * @param valorTipoMedida1
	 *            El valor a establecer para la propiedad <code>valorTipoMedida</code>.
	 */
	public void setValorTipoMedida(String valorTipoMedida1) {
		this.valorTipoMedida = valorTipoMedida1;

		if (valorTipoMedida != null && valorTipoMedida.length() > 3) {
			valorTipoMedida = valorTipoMedida.substring(0, 3);
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
	 * @return the tipoMedida
	 */
	public CatalogoValorDTO getTipoMedida() {
		return tipoMedida;
	}

	/**
	 * @param tipoMedida the tipoMedida to set
	 */
	public void setTipoMedida(CatalogoValorDTO tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	/**
	 * @return the presentacion
	 */
	public Integer getPresentacion() {
		return presentacion;
	}

	/**
	 * @param presentacion the presentacion to set
	 */
	public void setPresentacion(Integer presentacion) {
		this.presentacion = presentacion;
	}

}
