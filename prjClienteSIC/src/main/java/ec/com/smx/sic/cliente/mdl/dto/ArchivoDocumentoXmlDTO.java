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
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArchivoDocumentoXmlID;

/**
 * Entidad que almacena el archivo xml de la factura
 * 
 * @author fcollaguazo
 */
@Entity
@Table(name="SCFDITARCDOCXML")
@SuppressWarnings("serial")
public class ArchivoDocumentoXmlDTO extends SearchDTO {

	/**
	 */
	@EmbeddedId
	private ArchivoDocumentoXmlID id = new ArchivoDocumentoXmlID();

	
	/**
	 * Contenido digital del archivo
	 * 
	 */
	private String contenidoXml;
	
	/**
	 * Codigo de la tabla factura
	 */
	private Long codigoDocumento;

	
	/**
	 * Estado del archivo, los valores permitidos son: [0] Inactivo [1] Activo
	 * 
	 */
	@ComparatorTypeField
	private String estadoArchivo;
	
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Column(name="FECHAMODIFICACION")
	private java.util.Date fechaModificacion;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODOCUMENTO", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURA") })
	private FacturaDTO facturaDTO;


	public ArchivoDocumentoXmlID getId() {
		return id;
	}


	public void setId(ArchivoDocumentoXmlID id) {
		this.id = id;
	}


	public String getContenidoXml() {
		return contenidoXml;
	}


	public void setContenidoXml(String contenidoXml) {
		this.contenidoXml = contenidoXml;
	}


	public Long getCodigoDocumento() {
		return codigoDocumento;
	}


	public void setCodigoDocumento(Long codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}


	public String getEstadoArchivo() {
		return estadoArchivo;
	}


	public void setEstadoArchivo(String estadoArchivo) {
		this.estadoArchivo = estadoArchivo;
	}

	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}


	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}


	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}


	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}


	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public FacturaDTO getFacturaDTO() {
		return facturaDTO;
	}


	public void setFacturaDTO(FacturaDTO facturaDTO) {
		this.facturaDTO = facturaDTO;
	}
}
