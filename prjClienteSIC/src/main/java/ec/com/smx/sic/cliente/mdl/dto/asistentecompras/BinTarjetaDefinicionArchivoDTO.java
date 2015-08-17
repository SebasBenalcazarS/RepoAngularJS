package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.CodigoArchivoBinID;

/**
 * @author ediaz
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSACTBINTARDEFARC")
public class BinTarjetaDefinicionArchivoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private CodigoArchivoBinID id;

	private Long codigoBinTarjeta;
	private String nombreArchivo;
	private String estado;
	private String tipoContenidoArchivo;
	private Long tamanioArchivo;

	@RegisterUserIdField
	@Column(updatable = false)
	private String usuarioRegistro;

	@RegisterUserIdField
	@Column(updatable = false)
	private Date fechaRegistro;

	@LastModifierUserIdField
	@Column(updatable = false)
	private String usuarioModificacion;

	@LastModifierUserIdField
	@Column(updatable = false)
	private Date fechaModificacion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOBINTARJETA", referencedColumnName = "CODIGOBINTARJETA", insertable = false, updatable = false)
	private BinTarjetaDTO binTarjetaDTO;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "binTarjetaDefinicionArchivoDTO", cascade = CascadeType.ALL)
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<BinTarjetaArchivoDTO> binTarjetaArchivoDTOs;

	public CodigoArchivoBinID getId() {
		return id;
	}

	public void setId(CodigoArchivoBinID id) {
		this.id = id;
	}

	public Long getCodigoBinTarjeta() {
		return codigoBinTarjeta;
	}

	public void setCodigoBinTarjeta(Long codigoBinTarjeta) {
		this.codigoBinTarjeta = codigoBinTarjeta;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipoContenidoArchivo() {
		return tipoContenidoArchivo;
	}

	public void setTipoContenidoArchivo(String tipoContenidoArchivo) {
		this.tipoContenidoArchivo = tipoContenidoArchivo;
	}

	public Long getTamanioArchivo() {
		return tamanioArchivo;
	}

	public void setTamanioArchivo(Long tamanioArchivo) {
		this.tamanioArchivo = tamanioArchivo;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public BinTarjetaDTO getBinTarjetaDTO() {
		return binTarjetaDTO;
	}

	public void setBinTarjetaDTO(BinTarjetaDTO binTarjetaDTO) {
		this.binTarjetaDTO = binTarjetaDTO;
	}

	public Collection<BinTarjetaArchivoDTO> getBinTarjetaArchivoDTOs() {
		return binTarjetaArchivoDTOs;
	}

	public void setBinTarjetaArchivoDTOs(Collection<BinTarjetaArchivoDTO> binTarjetaArchivoDTOs) {
		this.binTarjetaArchivoDTOs = binTarjetaArchivoDTOs;
	}

	
	
	
	
}
