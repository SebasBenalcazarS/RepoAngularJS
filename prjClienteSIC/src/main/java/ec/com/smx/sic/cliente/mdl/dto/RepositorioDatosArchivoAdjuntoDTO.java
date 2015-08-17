package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.RepositorioDatosArchivoAdjuntoID;
import static javax.persistence.FetchType.LAZY;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITDATARCHIVO")
public class RepositorioDatosArchivoAdjuntoDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	ec.com.smx.sic.cliente.mdl.dto.id.RepositorioDatosArchivoAdjuntoID id = new RepositorioDatosArchivoAdjuntoID();
	
	@Column(name = "CODIGOFACARCHIVO")
	private Long codigoFacturaArchivo;
	
	@Column
	private byte[] archivo;
	
	@RegisterUserIdField
	@Column(name = "IDUSUARIIOREGISTRO")
	private java.lang.String idUsuarioRegistro;
	
	@RegisterDateField
	@Column(name = "FECHAREGISTRO")
	private java.util.Date fechaRegistro;
	

	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiz� la �ltima actualizaci�n.
	 * 
	 */
	@LastModificationDateField
	@Column(name="FECHAMODIFICACION")
	private java.util.Date fechaModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns(@JoinColumn(name = "CODIGOFACARCHIVO", referencedColumnName = "CODIGOFACARCHIVO", insertable = false, updatable = false))
	private RepositorioArchivosAdjuntosDTO archivosAdjuntosDTO;
	
	public ec.com.smx.sic.cliente.mdl.dto.id.RepositorioDatosArchivoAdjuntoID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.RepositorioDatosArchivoAdjuntoID id) {
		this.id = id;
	}

	public Long getCodigoFacturaArchivo() {
		return codigoFacturaArchivo;
	}

	public void setCodigoFacturaArchivo(Long codigoFacturaArchivo) {
		this.codigoFacturaArchivo = codigoFacturaArchivo;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
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

	public RepositorioArchivosAdjuntosDTO getArchivosAdjuntosDTO() {
		return archivosAdjuntosDTO;
	}

	public void setArchivosAdjuntosDTO(RepositorioArchivosAdjuntosDTO archivosAdjuntosDTO) {
		this.archivosAdjuntosDTO = archivosAdjuntosDTO;
	}
	
	
}
