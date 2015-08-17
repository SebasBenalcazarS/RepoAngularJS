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
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ClienteRelacionadoID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;

/**
 * @author dvillafuerte
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSACTCLIREL")
public class ClienteRelacionadoDTO  extends SimpleAuditDTO {
	
	@EmbeddedId
	private ClienteRelacionadoID id = new ClienteRelacionadoID();
	
	private Long codigoClientePedido;
	private Long codigoClientePedidoInvitado;
	private String nombreInvitado;
	
	@ComparatorTypeField
	private String email;
	@ComparatorTypeField
	private String estado;
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO",updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name="USUARIOMODIFICACION")
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Fecha en la que se realizó la última actualización.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	/**
	 * Relacion con la tabla SCSPETCLIPED
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLIENTEPEDIDO", referencedColumnName = "CODIGOCLIENTEPEDIDO", insertable = false, updatable = false)
	})
	private ClienteDTO clienteDto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLIENTEPEDIDOINVITADO", referencedColumnName = "CODIGOCLIENTEPEDIDO", insertable = false, updatable = false)
	})
	private ClienteDTO clienteInvitadoDto;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="clienteRelacionadoDto")	
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<ListaClientePedidoDTO> listaClientePedidoDtoCol;
	
	//METODOS GET Y SET
	public ClienteRelacionadoID getId() {
		return id;
	}

	public void setId(ClienteRelacionadoID id) {
		this.id = id;
	}

	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

	public Long getCodigoClientePedidoInvitado() {
		return codigoClientePedidoInvitado;
	}

	public void setCodigoClientePedidoInvitado(Long codigoClientePedidoInvitado) {
		this.codigoClientePedidoInvitado = codigoClientePedidoInvitado;
	}

	public String getNombreInvitado() {
		return nombreInvitado;
	}

	public void setNombreInvitado(String nombreInvitado) {
		this.nombreInvitado = nombreInvitado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public ClienteDTO getClienteDto() {
		return clienteDto;
	}

	public void setClienteDto(ClienteDTO clienteDto) {
		this.clienteDto = clienteDto;
	}

	public ClienteDTO getClienteInvitadoDto() {
		return clienteInvitadoDto;
	}

	public void setClienteInvitadoDto(ClienteDTO clienteInvitadoDto) {
		this.clienteInvitadoDto = clienteInvitadoDto;
	}

	public Collection<ListaClientePedidoDTO> getListaClientePedidoDtoCol() {
		return listaClientePedidoDtoCol;
	}

	public void setListaClientePedidoDtoCol(Collection<ListaClientePedidoDTO> listaClientePedidoDtoCol) {
		this.listaClientePedidoDtoCol = listaClientePedidoDtoCol;
	}
	
}
