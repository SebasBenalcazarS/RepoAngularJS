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
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.ListaClientePedidoID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;

/**
 * @author dvillafuerte
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSACTLISCLIPED")
public class ListaClientePedidoDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private ListaClientePedidoID id = new ListaClientePedidoID();
	
	private Long codigoLista;
	private Long codigoClientePedido;
	@ComparatorTypeField
	private String estado;
	private Long codigoClienteRelacionado;
	private String mantenerColaboracion;

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
	
	//relaciones
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLISTA", referencedColumnName = "CODIGOLISTA", insertable = false, updatable = false)		   
		 })
	private ListaDTO listaDto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLIENTEPEDIDO", referencedColumnName = "CODIGOCLIENTEPEDIDO", insertable = false, updatable = false)  })
	private ClienteDTO clienteDto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLIENTERELACIONADO", referencedColumnName = "CODIGOCLIENTERELACIONADO", insertable = false, updatable = false)
	})
	private ClienteRelacionadoDTO clienteRelacionadoDto;

	//METODOS GET Y SET
	public ListaClientePedidoID getId() {
		return id;
	}

	public void setId(ListaClientePedidoID id) {
		this.id = id;
	}

	public Long getCodigoLista() {
		return codigoLista;
	}

	public void setCodigoLista(Long codigoLista) {
		this.codigoLista = codigoLista;
	}

	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getCodigoClienteRelacionado() {
		return codigoClienteRelacionado;
	}

	public void setCodigoClienteRelacionado(Long codigoClienteRelacionado) {
		this.codigoClienteRelacionado = codigoClienteRelacionado;
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

	public ClienteDTO getClienteDto() {
		return clienteDto;
	}

	public void setClienteDto(ClienteDTO clienteDto) {
		this.clienteDto = clienteDto;
	}

	public ClienteRelacionadoDTO getClienteRelacionadoDto() {
		return clienteRelacionadoDto;
	}

	public void setClienteRelacionadoDto(ClienteRelacionadoDTO clienteRelacionadoDto) {
		this.clienteRelacionadoDto = clienteRelacionadoDto;
	}

	public String getMantenerColaboracion() {
		return mantenerColaboracion;
	}

	public void setMantenerColaboracion(String mantenerColaboracion) {
		this.mantenerColaboracion = mantenerColaboracion;
	}
	
}
