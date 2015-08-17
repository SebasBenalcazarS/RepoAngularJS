package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Collection;

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

/**
 * Entidad que almacena los tipos de impuestos que puede tener un art�culo. Por ejemplo: [IVA] Impuesto al valor agregado [ICE] Impuesto a los
 * consumos especiales
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTTIPIMP")
public class TipoImpuestoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.TipoImpuestoID id = new ec.com.smx.sic.cliente.mdl.dto.id.TipoImpuestoID();

	/**
	 * C�digo del grupo de impuesto
	 *
	 */
	@ComparatorTypeField
	private String codigoGrupoImpuesto ;
	
	private String codigoReferencia;
	
	/**
	 * Indica una descripci�n corta del registro
	 *
	 */
	private String nombreTipoImpuesto ;
	
	/**
	 * Descripci�n del tipo de impuesto
	 * 
	 */
	private String descripcionTipoImpuesto;

	/**
	 * Porcentaje del tipo de impuesto
	 * 
	 */
	private Double porcentajeImpuesto;

	/**
	 * Estado que indica si un tipo de impuesto est� activo o no. Los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoTipoImpuesto;
	
	private Boolean esPredeterminado;
	
	private Double valorImpuesto;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	@OneToMany(mappedBy="tipoImpuestoArticulo")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ArticuloImpuestoDTO> articuloImpuestoCol;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOGRUPOIMPUESTO", referencedColumnName="CODIGOGRUPOIMPUESTO", insertable=false, updatable=false)})
	private GrupoImpuestoDTO grupoImpuesto;
	
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.TipoImpuestoID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.TipoImpuestoID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>descripcionTipoImpuesto</code>
	 * 
	 * @return Retorna valor de propiedad <code>descripcionTipoImpuesto</code>
	 */
	public String getDescripcionTipoImpuesto() {
		return this.descripcionTipoImpuesto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>descripcionTipoImpuesto</code>.
	 * 
	 * @param descripcionTipoImpuesto1
	 *            El valor a establecer para la propiedad <code>descripcionTipoImpuesto</code>.
	 */
	public void setDescripcionTipoImpuesto(String descripcionTipoImpuesto1) {
		this.descripcionTipoImpuesto = descripcionTipoImpuesto1 != null ? descripcionTipoImpuesto1.toUpperCase() : null;

		if (descripcionTipoImpuesto != null && descripcionTipoImpuesto.length() > 100) {
			descripcionTipoImpuesto = descripcionTipoImpuesto.substring(0, 100);
		}

	}

	/**
	 * Retorna valor de propiedad <code>porcentajeImpuesto</code>
	 * 
	 * @return Retorna valor de propiedad <code>porcentajeImpuesto</code>
	 */
	public Double getPorcentajeImpuesto() {
		return this.porcentajeImpuesto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>porcentajeImpuesto</code>.
	 * 
	 * @param porcentajeImpuesto1
	 *            El valor a establecer para la propiedad <code>porcentajeImpuesto</code>.
	 */
	public void setPorcentajeImpuesto(Double porcentajeImpuesto1) {
		this.porcentajeImpuesto = porcentajeImpuesto1;

	}

	/**
	 * Retorna valor de propiedad <code>estadoTipoImpuesto</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoTipoImpuesto</code>
	 */
	public String getEstadoTipoImpuesto() {
		return this.estadoTipoImpuesto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoTipoImpuesto</code>.
	 * 
	 * @param estadoTipoImpuesto1
	 *            El valor a establecer para la propiedad <code>estadoTipoImpuesto</code>.
	 */
	public void setEstadoTipoImpuesto(String estadoTipoImpuesto1) {
		this.estadoTipoImpuesto = estadoTipoImpuesto1;

		if (estadoTipoImpuesto != null && estadoTipoImpuesto.length() > 1) {
			estadoTipoImpuesto = estadoTipoImpuesto.substring(0, 1);
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
	 * @return the codigoGrupoImpuesto
	 */
	public String getCodigoGrupoImpuesto() {
		return codigoGrupoImpuesto;
	}

	/**
	 * @param codigoGrupoImpuesto the codigoGrupoImpuesto to set
	 */
	public void setCodigoGrupoImpuesto(String codigoGrupoImpuesto1) {
		this.codigoGrupoImpuesto=codigoGrupoImpuesto1;
		
		if(codigoGrupoImpuesto!=null && codigoGrupoImpuesto.length()>4){
			codigoGrupoImpuesto = codigoGrupoImpuesto.substring(0,4);
		}
	}

	/**
	 * @return the nombreTipoImpuesto
	 */
	public String getNombreTipoImpuesto() {
		return nombreTipoImpuesto;
	}

	/**
	 * @param nombreTipoImpuesto the nombreTipoImpuesto to set
	 */
	public void setNombreTipoImpuesto(String nombreTipoImpuesto1) {
		this.nombreTipoImpuesto=nombreTipoImpuesto1 != null ? nombreTipoImpuesto1.toUpperCase() : null;
		
		if(nombreTipoImpuesto!=null && nombreTipoImpuesto.length()>10){
			nombreTipoImpuesto = nombreTipoImpuesto.substring(0,10);
		}
	}

	/**
	 * @return the grupoImpuesto
	 */
	public GrupoImpuestoDTO getGrupoImpuesto() {
		return grupoImpuesto;
	}

	/**
	 * @param grupoImpuesto the grupoImpuesto to set
	 */
	public void setGrupoImpuesto(GrupoImpuestoDTO grupoImpuesto) {
		this.grupoImpuesto = grupoImpuesto;
	}

	public Collection<ArticuloImpuestoDTO> getArticuloImpuestoCol() {
		return articuloImpuestoCol;
	}

	public void setArticuloImpuestoCol(
			Collection<ArticuloImpuestoDTO> articuloImpuestoCol) {
		this.articuloImpuestoCol = articuloImpuestoCol;
	}

	/**
	 * @return the esPredeterminado
	 */
	public Boolean getEsPredeterminado() {
		return esPredeterminado;
	}

	/**
	 * @param esPredeterminado the esPredeterminado to set
	 */
	public void setEsPredeterminado(Boolean esPredeterminado) {
		this.esPredeterminado = esPredeterminado;
	}

	/**
	 * @return the valorImpuesto
	 */
	public Double getValorImpuesto() {
		return valorImpuesto;
	}

	/**
	 * @param valorImpuesto the valorImpuesto to set
	 */
	public void setValorImpuesto(Double valorImpuesto) {
		this.valorImpuesto = valorImpuesto;
	}

	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
}
