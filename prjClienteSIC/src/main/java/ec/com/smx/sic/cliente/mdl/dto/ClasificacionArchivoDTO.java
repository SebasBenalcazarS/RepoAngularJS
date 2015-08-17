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


/**
 * Entidad que almacena diferentes definiciones de archivos, pueden ser archivos de im�genes.
 *
 **/
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTCLAARC")
public class ClasificacionArchivoDTO extends SimpleAuditDTO{


	/**
	 * identificador
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.ArticuloClasificacionArchivoID id = new ec.com.smx.sic.cliente.mdl.dto.id.ArticuloClasificacionArchivoID();

	/**
	 * Nombre del archivo del art�culo
	 * 
	 */
	private String nombreArchivo;

	/**
	 * Descripc�n del archivo del art�culo
	 * 
	 */
	private String descripcionArchivo;

	@Column(name = "CODIGOCLASIFICACION")
	private String codigoClasificacion;
	

	/**
	 * Codigo del tipo de archivo.
	 *
	 */
	private Integer codigoTipoArchivo ;

	/**
	 * Valor del tipo de archivo.
	 * Los valores pueden ser los que esten disponibles en el catalogo valor
	 */
	@ComparatorTypeField
	private String valorTipoArchivo ;

	/**
	 * Tama�o del archivo
	 * 
	 */
	private Double tamanioArchivo;

	/**
	 * Tipo de contenido que tiene el archivo
	 * 
	 */
	private String tipoContenidoArchivo;

	/**
	 * Estado del archivo, los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoArchivo;

	/**
	 * orden del archivo en la defici�n
	 */
	private Integer orden;


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
		@JoinColumn(name="CODIGOARCHIVO", referencedColumnName="CODIGOARCHIVO", insertable=false, updatable=false)})
	private ClasificacionContenidoArchivoDTO clasificacionContenidoArchivoDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name="CODIGOCLASIFICACION", referencedColumnName="CODIGOCLASIFICACION", insertable=false, updatable=false)})
	private ClasificacionDTO clasificacionDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOTIPOARCHIVO", insertable=false, updatable=false, referencedColumnName="CODIGOCATALOGOTIPO"),
		@JoinColumn(name="VALORTIPOARCHIVO", referencedColumnName="CODIGOCATALOGOVALOR", insertable=false, updatable=false)})
	private ec.com.smx.corpv2.dto.CatalogoValorDTO tipoArchivo;
	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.ArticuloClasificacionArchivoID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.ArticuloClasificacionArchivoID id) {
		this.id = id;
	}

	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = (nombreArchivo != null && nombreArchivo.length() > 50) ? nombreArchivo.substring(0, 50): nombreArchivo;
	}
	/**
	 * @return the descripcionArchivo
	 */
	public String getDescripcionArchivo() {
		return descripcionArchivo;
	}
	/**
	 * @param descripcionArchivo the descripcionArchivo to set
	 */
	public void setDescripcionArchivo(String descripcionArchivo) {
		this.descripcionArchivo = (descripcionArchivo != null && descripcionArchivo.length() > 200)?descripcionArchivo.substring(0, 200):descripcionArchivo;
	}
	/**
	 * @return the codigoTipoArchivo
	 */
	public Integer getCodigoTipoArchivo() {
		return codigoTipoArchivo;
	}
	/**
	 * @param codigoTipoArchivo the codigoTipoArchivo to set
	 */
	public void setCodigoTipoArchivo(Integer codigoTipoArchivo) {
		this.codigoTipoArchivo = codigoTipoArchivo;
	}
	/**
	 * @return the valorTipoArchivo
	 */
	public String getValorTipoArchivo() {
		return valorTipoArchivo;
	}
	/**
	 * @param valorTipoArchivo the valorTipoArchivo to set
	 */
	public void setValorTipoArchivo(String valorTipoArchivo) {
		this.valorTipoArchivo = valorTipoArchivo;
	}
	/**
	 * @return the tamanioArchivo
	 */
	public Double getTamanioArchivo() {
		return tamanioArchivo;
	}
	/**
	 * @param tamanioArchivo the tamanioArchivo to set
	 */
	public void setTamanioArchivo(Double tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}
	/**
	 * @return the tipoContenidoArchivo
	 */
	public String getTipoContenidoArchivo() {
		return tipoContenidoArchivo;
	}
	/**
	 * @param tipoContenidoArchivo the tipoContenidoArchivo to set
	 */
	public void setTipoContenidoArchivo(String tipoContenidoArchivo) {
		this.tipoContenidoArchivo = (tipoContenidoArchivo != null && tipoContenidoArchivo.length() > 50)?tipoContenidoArchivo.substring(0, 50):tipoContenidoArchivo;
	}
	/**
	 * @return the estadoArchivo
	 */
	public String getEstadoArchivo() {
		return estadoArchivo;
	}
	/**
	 * @param estadoArchivo the estadoArchivo to set
	 */
	public void setEstadoArchivo(String estadoArchivo) {
		this.estadoArchivo = estadoArchivo;
	}
	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}
	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
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
		this.idUsuarioRegistro = (idUsuarioRegistro != null && idUsuarioRegistro.length() > 32) ?idUsuarioRegistro.substring(0, 32):idUsuarioRegistro;
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
		this.idUsuarioModificacion = (idUsuarioModificacion != null && idUsuarioModificacion.length() > 32)?idUsuarioModificacion.substring(0, 32):idUsuarioModificacion;
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
	 * 
	 * @return the clasificacionContenidoArchivoDTO
	 */
	public ClasificacionContenidoArchivoDTO getClasificacionContenidoArchivoDTO() {
		return clasificacionContenidoArchivoDTO;
	}
	/**
	 * 
	 * @param clasificacionContenidoArchivoDTO the clasificacionContenidoArchivoDTO to set
	 */
	public void setClasificacionContenidoArchivoDTO(ClasificacionContenidoArchivoDTO clasificacionContenidoArchivoDTO) {
		this.clasificacionContenidoArchivoDTO = clasificacionContenidoArchivoDTO;
	}
	/**
	 * @return the tipoArchivo
	 */
	public ec.com.smx.corpv2.dto.CatalogoValorDTO getTipoArchivo() {
		return tipoArchivo;
	}
	/**
	 * @param tipoArchivo the tipoArchivo to set
	 */
	public void setTipoArchivo(ec.com.smx.corpv2.dto.CatalogoValorDTO tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}
	/**
	 * @return the codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	/**
	 * @param codigoClasificacion the codigoClasificacion to set
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	/**
	 * @return the clasificacionDTO
	 */
	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}
	/**
	 * @param clasificacionDTO the clasificacionDTO to set
	 */
	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}


}
