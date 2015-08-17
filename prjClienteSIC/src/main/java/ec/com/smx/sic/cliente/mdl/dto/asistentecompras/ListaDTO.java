/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import java.util.Collection;

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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ListaID;

/**
 * @author dvillafuerte
 * 
 */
@SuppressWarnings("serial")
@Entity(name = "ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ListaDTO")
@Table(name = "SCSACTLISTA")
public class ListaDTO extends SimpleAuditDTO {

	@EmbeddedId
	private ListaID id = new ListaID();
	private Long codigoListaReceta;
	@ComparatorTypeField
	private String idApp;
	@ComparatorTypeField
	private String descripcionLista;
	private Integer numeroPorciones;
	private String favorita;

	private java.sql.Timestamp fechaDispositivo;

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOLISTARECETA", referencedColumnName = "CODIGOLISTARECETA", insertable = false, updatable = false) })
	private ListaRecetaDTO listaRecetaDto;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listaDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<DetalleListaDTO> detalleListaDtoCol;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listaDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ListaClientePedidoDTO> listaClientePedidoDtoCol;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "listaDto")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<VistaColaboracionDTO> colaboracionDTOCol;

	public ListaID getId() {
		return id;
	}

	public void setId(ListaID id) {
		this.id = id;
	}

	public Long getCodigoListaReceta() {
		return codigoListaReceta;
	}

	public void setCodigoListaReceta(Long codigoListaReceta) {
		this.codigoListaReceta = codigoListaReceta;
	}

	public String getDescripcionLista() {
		return descripcionLista;
	}

	public void setDescripcionLista(String descripcionLista) {
		this.descripcionLista = descripcionLista;
	}

	public Integer getNumeroPorciones() {
		return numeroPorciones;
	}

	public void setNumeroPorciones(Integer numeroPorciones) {
		this.numeroPorciones = numeroPorciones;
	}

	public String getFavorita() {
		return favorita;
	}

	public void setFavorita(String favorita) {
		this.favorita = favorita;
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

	public ListaRecetaDTO getListaRecetaDto() {
		return listaRecetaDto;
	}

	public void setListaRecetaDto(ListaRecetaDTO listaRecetaDto) {
		this.listaRecetaDto = listaRecetaDto;
	}

	public Collection<DetalleListaDTO> getDetalleListaDtoCol() {
		return detalleListaDtoCol;
	}

	public void setDetalleListaDtoCol(Collection<DetalleListaDTO> detalleListaDtoCol) {
		this.detalleListaDtoCol = detalleListaDtoCol;
	}

	public Collection<ListaClientePedidoDTO> getListaClientePedidoDtoCol() {
		return listaClientePedidoDtoCol;
	}

	public void setListaClientePedidoDtoCol(Collection<ListaClientePedidoDTO> listaClientePedidoDtoCol) {
		this.listaClientePedidoDtoCol = listaClientePedidoDtoCol;
	}

	public String getIdApp() {
		return idApp;
	}

	public void setIdApp(String idApp) {
		this.idApp = idApp;
	}

	public Collection<VistaColaboracionDTO> getColaboracionDTOCol() {
		return colaboracionDTOCol;
	}

	public void setColaboracionDTOCol(Collection<VistaColaboracionDTO> colaboracionDTOCol) {
		this.colaboracionDTOCol = colaboracionDTOCol;
	}
}
