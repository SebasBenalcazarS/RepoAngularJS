package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.CodigoArchivoID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSACTCONDEFARC")
public class ContenidoDefinicionArchivoDTO extends SimpleAuditDTO {

	@EmbeddedId
	private CodigoArchivoID id;

	private Long secuencialContenido;
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

	private String valorTipoArchivo;
	private Integer codigoTipoArchivo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOTIPOARCHIVO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), @JoinColumn(name = "VALORTIPOARCHIVO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO catalogoValor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECUENCIALCONTENIDO", referencedColumnName = "SECUENCIALCONTENIDO", insertable = false, updatable = false)
	private ContenidoDTO contenidoDTO;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contenidoDefinicionArchivoDTO", cascade = CascadeType.ALL)
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenidoArchivoDto> contenidoArchivoDtos;

	public CodigoArchivoID getId() {
		return id;
	}

	public void setId(CodigoArchivoID id) {
		this.id = id;
	}

	public Long getSecuencialContenido() {
		return secuencialContenido;
	}

	public void setSecuencialContenido(Long secuencialContenido) {
		this.secuencialContenido = secuencialContenido;
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

	public String getValorTipoArchivo() {
		return valorTipoArchivo;
	}

	public void setValorTipoArchivo(String valorTipoArchivo) {
		this.valorTipoArchivo = valorTipoArchivo;
	}

	public Integer getCodigoTipoArchivo() {
		return codigoTipoArchivo;
	}

	public void setCodigoTipoArchivo(Integer codigoTipoArchivo) {
		this.codigoTipoArchivo = codigoTipoArchivo;
	}

	public CatalogoValorDTO getCatalogoValor() {
		return catalogoValor;
	}

	public void setCatalogoValor(CatalogoValorDTO catalogoValor) {
		this.catalogoValor = catalogoValor;
	}

	public ContenidoDTO getContenidoDTO() {
		return contenidoDTO;
	}

	public void setContenidoDTO(ContenidoDTO contenidoDTO) {
		this.contenidoDTO = contenidoDTO;
	}

	public Collection<ContenidoArchivoDto> getContenidoArchivoDtos() {
		return contenidoArchivoDtos;
	}

	public void setContenidoArchivoDtos(Collection<ContenidoArchivoDto> contenidoArchivoDtos) {
		this.contenidoArchivoDtos = contenidoArchivoDtos;
	}

}
