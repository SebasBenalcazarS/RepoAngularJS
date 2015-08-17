package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * Entidad que almacena los tipos de impuestos que puede tener un art�culo. Por ejemplo: [IVA] Impuesto al valor agregado [ICE] Impuesto a los
 * consumos especiales
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTARTIMP")
public class ArticuloImpuestoDTO extends SimpleAuditDTO {

	/**
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloImpuestoID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloImpuestoID();

	/**
	 * Estado que indica si un art�culo tiene o no activo un impuesto Los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoArticuloImpuesto;

	/**
	 * Indica si el impuesto es para venta (true)
	 */
	private Boolean esParaVenta;
	
	/**
	 * Indica si el impuesto es para compra (true)
	 */
	private Boolean esParaCompra;
	
	/**
	 * Indica el valor de impuesto verde
	 */
	@Transient
	private Double valorImpuesto;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

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
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOTIPOIMPUESTO", referencedColumnName="CODIGOTIPOIMPUESTO", insertable=false, updatable=false)})
	private ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO tipoImpuestoArticulo;

	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloImpuestoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloImpuestoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>estadoArticuloImpuesto</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoArticuloImpuesto</code>
	 */
	public String getEstadoArticuloImpuesto() {
		return this.estadoArticuloImpuesto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoArticuloImpuesto</code>.
	 * 
	 * @param estadoArticuloImpuesto1
	 *            El valor a establecer para la propiedad <code>estadoArticuloImpuesto</code>.
	 */
	public void setEstadoArticuloImpuesto(String estadoArticuloImpuesto1) {
		this.estadoArticuloImpuesto = estadoArticuloImpuesto1;

		if (estadoArticuloImpuesto != null && estadoArticuloImpuesto.length() > 1) {
			estadoArticuloImpuesto = estadoArticuloImpuesto.substring(0, 1);
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
	 * Retorna valor de propiedad <code>tipoImpuestoArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>tipoImpuestoArticulo</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO getTipoImpuestoArticulo() {
		return this.tipoImpuestoArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>tipoImpuestoArticulo</code>.
	 * 
	 * @param tipoImpuestoArticulo1
	 *            El valor a establecer para la propiedad <code>tipoImpuestoArticulo</code>.
	 */
	public void setTipoImpuestoArticulo(ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO tipoImpuestoArticulo1) {
		this.tipoImpuestoArticulo = tipoImpuestoArticulo1;
	}

	public Boolean getTieneTipoImpuesto(){
		return isLoaded(tipoImpuestoArticulo) && tipoImpuestoArticulo != null;
	}

	/**
	 * @return the esParaVenta
	 */
	public Boolean getEsParaVenta() {
		return esParaVenta;
	}

	/**
	 * @param esParaVenta the esParaVenta to set
	 */
	public void setEsParaVenta(Boolean esParaVenta) {
		this.esParaVenta = esParaVenta;
	}

	/**
	 * @return the esParaCompra
	 */
	public Boolean getEsParaCompra() {
		return esParaCompra;
	}

	/**
	 * @param esParaCompra the esParaCompra to set
	 */
	public void setEsParaCompra(Boolean esParaCompra) {
		this.esParaCompra = esParaCompra;
	}

	public Double getValorImpuesto() {
		return valorImpuesto;
	}

	public void setValorImpuesto(Double valorImpuesto) {
		this.valorImpuesto = valorImpuesto;
	}	
}
