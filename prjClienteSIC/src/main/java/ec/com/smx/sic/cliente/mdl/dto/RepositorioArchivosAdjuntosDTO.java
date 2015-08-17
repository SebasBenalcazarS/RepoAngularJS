package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.RepositorioArchivosAdjuntosID;
import static javax.persistence.FetchType.LAZY;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCFDITARCHIVOS")
public class RepositorioArchivosAdjuntosDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	ec.com.smx.sic.cliente.mdl.dto.id.RepositorioArchivosAdjuntosID id = new RepositorioArchivosAdjuntosID();
	
	@Column
	private Long codigoFactura;
	
	@Column
	private Integer codigoCompania;

	@Column
	private String nombreArchivo;

	@Column
	private String tipoArchivo;

	@Column
	private Integer tamaArchivo;
	
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
	
	@OneToMany(mappedBy = "archivosAdjuntosDTO")
	@CollectionTypeInfo(name= SICConstantes.USERTYPE_COLLECTION)
	private Collection<RepositorioDatosArchivoAdjuntoDTO> datosArchivoAdjuntoDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false)
	})
	private FacturaDTO facturaDTO;

	public ec.com.smx.sic.cliente.mdl.dto.id.RepositorioArchivosAdjuntosID getId() {
		return id;
	}

	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.RepositorioArchivosAdjuntosID id) {
		this.id = id;
	}

	public Long getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getTipoArchivo() {
		return tipoArchivo;
	}

	public void setTipoArchivo(String tipoArchivo) {
		this.tipoArchivo = tipoArchivo;
	}

	public Integer getTamaArchivo() {
		return tamaArchivo;
	}

	public void setTamaArchivo(Integer tamaArchivo) {
		this.tamaArchivo = tamaArchivo;
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

	public Collection<RepositorioDatosArchivoAdjuntoDTO> getDatosArchivoAdjuntoDTO() {
		return datosArchivoAdjuntoDTO;
	}

	public void setDatosArchivoAdjuntoDTO(Collection<RepositorioDatosArchivoAdjuntoDTO> datosArchivoAdjuntoDTO) {
		this.datosArchivoAdjuntoDTO = datosArchivoAdjuntoDTO;
	}

	public FacturaDTO getFacturaDTO() {
		return facturaDTO;
	}

	public void setFacturaDTO(FacturaDTO facturaDTO) {
		this.facturaDTO = facturaDTO;
	}
	
	
}
