package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;
import java.util.Date;

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
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBitacoraCodigoBarrasID;

/**
 * Entidad que almacena la bitàcora de cambios de los códigos de barras del artículo
 * 
 * @author fmunoz
 */
@Entity
@Table(name="SCSADTARTBITCODBAR")
@SuppressWarnings("serial")
public class ArticuloBitacoraCodigoBarrasDTO extends SimpleAuditDTO implements Cloneable{

	@EmbeddedId
	private ArticuloBitacoraCodigoBarrasID id = new ArticuloBitacoraCodigoBarrasID();
	
	/**
	 * El identificador del tipo de código de barras
	 */
	@ComparatorTypeField
	@Column(name="CODIGOTIPOCODIGOARTICULO")
	private String codigoTipoCodigoArticulo;
	
	/**
	 * Almacena el código de barras del artículo, este código almacena máximo un EAN12.
	 */
	@ComparatorTypeField
	private String codigoBarrasPOS;

	/**
	 * Almacena el estado del artículo en la bitacora, los valores permitidos son: [1] Activo [0] Inactivo
	 * 
	 */
	@ComparatorTypeField
	private String estadoArticuloBitacora;
	
	/**
	 * Código del tipo de peso en el catálogo
	 */
	@Column(name="CODIGOTIPOSECUENCIA")
	private Integer codigoTipoSecuencia ;
	/**
	 * Valor del tipo de peso en el catálogo
	 */
	@ComparatorTypeField
	@Column(name="VALORTIPOSECUENCIA")
	private String valorTipoSecuencia ;
	
	private Date fechaFinalActivo;
	/**
	 * Especifica el usuario que realiza el registro.
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
	 * Id del usuario que realizó la última actualización.
	 */
	@LastModifierUserIdField
	@Column(insertable=false)
	private String idUsuarioModificacion;
	/**
	 * Fecha en la que se realizó la última actualización.
	 */
	@LastModificationDateField
	@Column(insertable=false)
	private java.sql.Timestamp fechaModificacion;
	
	private Boolean pendienteCodigoBarras;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOTIPOCODIGOARTICULO", referencedColumnName="CODIGOTIPO", insertable=false, updatable=false)})
	private TipoCodigoArticuloDTO tipoCodigoArticulo;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="VALORTIPOSECUENCIA", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false),
		@JoinColumn(name="CODIGOTIPOSECUENCIA", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO")})
	private CatalogoValorDTO tipoSecuenciaArticulo;
	
	
	/**
	 * Retorna valor de propiedad <code>id</code>
	 * 
	 * @return Retorna valor de propiedad <code>id</code>
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBitacoraCodigoBarrasID getId() {
		return this.id;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>id</code>.
	 * 
	 * @param id1
	 *            El valor a establecer para la propiedad <code>id</code>.
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloBitacoraCodigoBarrasID id1) {
		this.id = id1;
	}

	/**
	 * Retorna valor de propiedad <code>codigoBarrasPOS</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoBarrasPOS</code>
	 */
	public String getCodigoBarrasPOS() {
		return this.codigoBarrasPOS;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoBarrasPOS</code>.
	 * 
	 * @param codigoBarrasPOS1
	 *            El valor a establecer para la propiedad <code>codigoBarrasPOS</code>.
	 */
	public void setCodigoBarrasPOS(String codigoBarrasPOS1) {
		this.codigoBarrasPOS = codigoBarrasPOS1;

		if (codigoBarrasPOS != null && codigoBarrasPOS.length() > 20) {
			codigoBarrasPOS = codigoBarrasPOS.substring(0, 20);
		}

	}

	/**
	 * Retorna valor de propiedad <code>estadoArticuloBitacora</code>
	 * 
	 * @return Retorna valor de propiedad <code>estadoArticuloBitacora</code>
	 */
	public String getEstadoArticuloBitacora() {
		return this.estadoArticuloBitacora;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>estadoArticuloBitacora</code>.
	 * 
	 * @param estadoArticuloBitacora1
	 *            El valor a establecer para la propiedad <code>estadoArticuloBitacora</code>.
	 */
	public void setEstadoArticuloBitacora(String estadoArticuloBitacora1) {
		this.estadoArticuloBitacora = estadoArticuloBitacora1;

		if (estadoArticuloBitacora != null && estadoArticuloBitacora.length() > 1) {
			estadoArticuloBitacora = estadoArticuloBitacora.substring(0, 1);
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
	 * @param fechaFinalActivo the fechaFinalActivo to set
	 */
	public void setFechaFinalActivo(Timestamp fechaFinalActivo) {
		this.fechaFinalActivo = fechaFinalActivo;
	}


	/**
	 * @return the fechaFinalActivo
	 */
	public Date getFechaFinalActivo() {
		return fechaFinalActivo;
	}

	/**
	 * @param fechaFinalActivo the fechaFinalActivo to set
	 */
	public void setFechaFinalActivo(Date fechaFinalActivo) {
		this.fechaFinalActivo = fechaFinalActivo;
	}

	public Boolean getTieneArticulo(){
		return isLoaded(articulo) && articulo != null;
	}

	/**
	 * @return the tipoCodigoArticulo
	 */
	public TipoCodigoArticuloDTO getTipoCodigoArticulo() {
		return tipoCodigoArticulo;
	}

	/**
	 * @param tipoCodigoArticulo the tipoCodigoArticulo to set
	 */
	public void setTipoCodigoArticulo(TipoCodigoArticuloDTO tipoCodigoArticulo) {
		this.tipoCodigoArticulo = tipoCodigoArticulo;
	}

	/**
	 * @return the codigoTipoCodigoArticulo
	 */
	public String getCodigoTipoCodigoArticulo() {
		return codigoTipoCodigoArticulo;
	}

	/**
	 * @param codigoTipoCodigoArticulo the codigoTipoCodigoArticulo to set
	 */
	public void setCodigoTipoCodigoArticulo(String codigoTipoCodigoArticulo) {
		this.codigoTipoCodigoArticulo = codigoTipoCodigoArticulo;
	}

	/**
	 * @return the codigoTipoSecuencia
	 */
	public Integer getCodigoTipoSecuencia() {
		return codigoTipoSecuencia;
	}

	/**
	 * @param codigoTipoSecuencia the codigoTipoSecuencia to set
	 */
	public void setCodigoTipoSecuencia(Integer codigoTipoSecuencia) {
		this.codigoTipoSecuencia = codigoTipoSecuencia;
	}

	/**
	 * @return the valorTipoSecuencia
	 */
	public String getValorTipoSecuencia() {
		return valorTipoSecuencia;
	}

	/**
	 * @param valorTipoSecuencia the valorTipoSecuencia to set
	 */
	public void setValorTipoSecuencia(String valorTipoSecuencia) {
		this.valorTipoSecuencia = valorTipoSecuencia;
	}

	/**
	 * @return the tipoSecuenciaArticulo
	 */
	public CatalogoValorDTO getTipoSecuenciaArticulo() {
		return tipoSecuenciaArticulo;
	}

	/**
	 * @param tipoSecuenciaArticulo the tipoSecuenciaArticulo to set
	 */
	public void setTipoSecuenciaArticulo(CatalogoValorDTO tipoSecuenciaArticulo) {
		this.tipoSecuenciaArticulo = tipoSecuenciaArticulo;
	}

	/**
	 * @return the pendienteCodigoBarras
	 */
	public Boolean getPendienteCodigoBarras() {
		return pendienteCodigoBarras;
	}

	/**
	 * @param pendienteCodigoBarras the pendienteCodigoBarras to set
	 */
	public void setPendienteCodigoBarras(Boolean pendienteCodigoBarras) {
		this.pendienteCodigoBarras = pendienteCodigoBarras;
	}
	

	public ArticuloBitacoraCodigoBarrasDTO clone() throws CloneNotSupportedException{
		ArticuloBitacoraCodigoBarrasDTO abcbClone = (ArticuloBitacoraCodigoBarrasDTO)super.clone();
		abcbClone.setId(id.clone());
		return abcbClone;
	}
}