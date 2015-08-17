package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.sql.Timestamp;
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
import ec.com.smx.frameworkv2.multicompany.dto.SystemDto;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ContenidoID;

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSACTCONTENIDO")
public class ContenidoDTO extends SimpleAuditDTO {
	@EmbeddedId
	private ContenidoID id;

	private String detalle;
	private Integer orden;
	private String estado;
	private String descripcion;
	private Date fechaInicioTemporada;
	private Date fechaFinTemporada;
	private Integer codigoCompania;
	private String codigoArticulo;
	
	@RegisterUserIdField
	@Column(updatable = false)
	private String usuarioRegistro;

	@RegisterUserIdField
	@Column(updatable = false)
	private Timestamp fechaRegistro;

	@LastModifierUserIdField
	@Column(updatable = false)
	private String usuarioModificacion;

	@LastModifierUserIdField
	@Column(updatable = false)
	private Timestamp fechaModificacion;

	private String valorTipoContenido;
	private Integer codigoTipoContenido;
	private String sysId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOTIPOCONTENIDO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), @JoinColumn(name = "VALORTIPOCONTENIDO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO catalogoValor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SYSID", referencedColumnName = "SYSID", insertable = false, updatable = false)
	private SystemDto systemDto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false), @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false) })
	private ArticuloDTO articuloDTO;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contenidoDTO", cascade = CascadeType.ALL)
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ContenidoDefinicionArchivoDTO> contenidoDefinicionArchivoDTOs;

	public ContenidoID getId() {
		return id;
	}

	public void setId(ContenidoID id) {
		this.id = id;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicioTemporada() {
		return fechaInicioTemporada;
	}

	public void setFechaInicioTemporada(Date fechaInicioTemporada) {
		this.fechaInicioTemporada = fechaInicioTemporada;
	}

	public Date getFechaFinTemporada() {
		return fechaFinTemporada;
	}

	public void setFechaFinTemporada(Date fechaFinTemporada) {
		this.fechaFinTemporada = fechaFinTemporada;
	}

	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public String getValorTipoContenido() {
		return valorTipoContenido;
	}

	public void setValorTipoContenido(String valorTipoContenido) {
		this.valorTipoContenido = valorTipoContenido;
	}

	public Integer getCodigoTipoContenido() {
		return codigoTipoContenido;
	}

	public void setCodigoTipoContenido(Integer codigoTipoContenido) {
		this.codigoTipoContenido = codigoTipoContenido;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public CatalogoValorDTO getCatalogoValor() {
		return catalogoValor;
	}

	public void setCatalogoValor(CatalogoValorDTO catalogoValor) {
		this.catalogoValor = catalogoValor;
	}

	public SystemDto getSystemDto() {
		return systemDto;
	}

	public void setSystemDto(SystemDto systemDto) {
		this.systemDto = systemDto;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Collection<ContenidoDefinicionArchivoDTO> getContenidoDefinicionArchivoDTOs() {
		return contenidoDefinicionArchivoDTOs;
	}

	public void setContenidoDefinicionArchivoDTOs(Collection<ContenidoDefinicionArchivoDTO> contenidoDefinicionArchivoDTOs) {
		this.contenidoDefinicionArchivoDTOs = contenidoDefinicionArchivoDTOs;
	}

	public ArticuloDTO getArticuloDTO() {
		return articuloDTO;
	}

	public void setArticuloDTO(ArticuloDTO articuloDTO) {
		this.articuloDTO = articuloDTO;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

}
