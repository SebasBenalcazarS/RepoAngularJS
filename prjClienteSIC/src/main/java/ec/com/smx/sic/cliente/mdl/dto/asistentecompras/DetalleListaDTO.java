/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.DetalleListaID;

/**
 * @author dvillafuerte
 * 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.asistentecompras.DetalleListaDTO")
@Table(name = "SCSACTDETLIS")
public class DetalleListaDTO extends SimpleAuditDTO {

	@EmbeddedId
	private DetalleListaID id = new DetalleListaID();

	private Long codigoLista;
	private Integer codigoTipoDetalle;
	private String valorTipoDetalle;
	@Column(updatable = false)
	private String codigoClasificacion;
	@Column(updatable = false)
	private String codigoArticulo;
	@Column(updatable = false)
	private String descripcion;
	private String notas;
	private Double cantidad;
	private String unidadesPeso;
	private java.sql.Timestamp fechaDispositivo;
	private Integer codigoTipoUnidadMedida;

	@ComparatorTypeField
	private String estado;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name = "USUARIOREGISTRO", updatable = false)
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable = false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Fecha en la que se realizó la última actualización.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;

	private String comprado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOLISTA", referencedColumnName = "CODIGOLISTA", insertable = false, updatable = false) })
	private ListaDTO listaDto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
	private ClasificacionDTO clasificacionDto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private ArticuloDTO articuloDto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOTIPODETALLE", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false), @JoinColumn(name = "VALORTIPODETALLE", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorDTO catalogoValorDto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOTIPOUNIDADMEDIDA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "UNIDADESPESO", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)})
	private CatalogoValorDTO catalogoValorDto1;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false) })
	private VistaDetalleListaProductoDTO vistaDetalleListaProductoDTO;

	// METODOS GET Y SEET
	public DetalleListaID getId() {
		return id;
	}

	public void setId(DetalleListaID id) {
		this.id = id;
	}
	
	

	public Long getCodigoLista() {
		return codigoLista;
	}

	public void setCodigoLista(Long codigoLista) {
		this.codigoLista = codigoLista;
	}

	public Integer getCodigoTipoDetalle() {
		return codigoTipoDetalle;
	}

	public void setCodigoTipoDetalle(Integer codigoTipoDetalle) {
		this.codigoTipoDetalle = codigoTipoDetalle;
	}

	public String getValorTipoDetalle() {
		return valorTipoDetalle;
	}

	public void setValorTipoDetalle(String valorTipoDetalle) {
		this.valorTipoDetalle = valorTipoDetalle;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidadesPeso() {
		return unidadesPeso;
	}

	public void setUnidadesPeso(String unidadesPeso) {
		this.unidadesPeso = unidadesPeso;
	}

	public java.sql.Timestamp getFechaDispositivo() {
		return fechaDispositivo;
	}

	public void setFechaDispositivo(java.sql.Timestamp fechaDispositivo) {
		this.fechaDispositivo = fechaDispositivo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public ListaDTO getListaDto() {
		return listaDto;
	}

	public void setListaDto(ListaDTO listaDto) {
		this.listaDto = listaDto;
	}

	public ClasificacionDTO getClasificacionDto() {
		return clasificacionDto;
	}

	public void setClasificacionDto(ClasificacionDTO clasificacionDto) {
		this.clasificacionDto = clasificacionDto;
	}

	public ArticuloDTO getArticuloDto() {
		return articuloDto;
	}

	public void setArticuloDto(ArticuloDTO articuloDto) {
		this.articuloDto = articuloDto;
	}

	public CatalogoValorDTO getCatalogoValorDto() {
		return catalogoValorDto;
	}

	public void setCatalogoValorDto(CatalogoValorDTO catalogoValorDto) {
		this.catalogoValorDto = catalogoValorDto;
	}

	public String getComprado() {
		return comprado;
	}

	public void setComprado(String comprado) {
		this.comprado = comprado;
	}

	public VistaDetalleListaProductoDTO getVistaDetalleListaProductoDTO() {
		return vistaDetalleListaProductoDTO;
	}

	public void setVistaDetalleListaProductoDTO(VistaDetalleListaProductoDTO vistaDetalleListaProductoDTO) {
		this.vistaDetalleListaProductoDTO = vistaDetalleListaProductoDTO;
	}

	public Integer getCodigoTipoUnidadMedida() {
		return codigoTipoUnidadMedida;
	}

	public void setCodigoTipoUnidadMedida(Integer codigoTipoUnidadMedida) {
		this.codigoTipoUnidadMedida = codigoTipoUnidadMedida;
	}

	public CatalogoValorDTO getCatalogoValorDto1() {
		return catalogoValorDto1;
	}

	public void setCatalogoValorDto1(CatalogoValorDTO catalogoValorDto1) {
		this.catalogoValorDto1 = catalogoValorDto1;
	}

}
