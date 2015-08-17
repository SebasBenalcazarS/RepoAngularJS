package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.RecetaClientePedidoID;
import ec.com.smx.sic.cliente.mdl.dto.sispe.ClienteDTO;

/**
 * 
 * @author cgalarza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSACTRECCLIPED")
public class RecetaClientePedidoDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private RecetaClientePedidoID id = new RecetaClientePedidoID();
	
	private Long codigoListaReceta;
	private Long codigoClientePedido;
	private String estado;
	
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name="USUARIOREGISTRO",updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion.
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
	 * Fecha en la que se realizo la ultima actualizacion.
	 */
	@LastModificationDateField
	private java.sql.Timestamp fechaModificacion;
	
	
	//RELACIONES
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLISTARECETA", referencedColumnName = "CODIGOLISTARECETA", insertable = false, updatable = false)		   
		 })
	private ListaRecetaDTO listaRecetaDto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCLIENTEPEDIDO", referencedColumnName = "CODIGOCLIENTEPEDIDO", insertable = false, updatable = false)  })
	private ClienteDTO clienteDto;
	
	
	//METODOS GET Y SET

	/**
	 * @return the id
	 */
	public RecetaClientePedidoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(RecetaClientePedidoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoReceta
	 */
	public Long getCodigoListaReceta() {
		return codigoListaReceta;
	}

	/**
	 * @param codigoReceta the codigoReceta to set
	 */
	public void setCodigoListaReceta(Long codigoListaReceta) {
		this.codigoListaReceta = codigoListaReceta;
	}

	/**
	 * @return the codigoClientePedido
	 */
	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	/**
	 * @param codigoClientePedido the codigoClientePedido to set
	 */
	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the idUsuarioModificacion
	 */
	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * @return the fechaRegistro
	 */
	public java.sql.Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.sql.Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaModificacion
	 */
	public java.sql.Timestamp getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.sql.Timestamp fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the listaRecetaDto
	 */
	public ListaRecetaDTO getListaRecetaDto() {
		return listaRecetaDto;
	}

	/**
	 * @param listaRecetaDto the listaRecetaDto to set
	 */
	public void setListaRecetaDto(ListaRecetaDTO listaRecetaDto) {
		this.listaRecetaDto = listaRecetaDto;
	}

	/**
	 * @return the clienteDto
	 */
	public ClienteDTO getClienteDto() {
		return clienteDto;
	}

	/**
	 * @param clienteDto the clienteDto to set
	 */
	public void setClienteDto(ClienteDTO clienteDto) {
		this.clienteDto = clienteDto;
	}
	
}
