/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.asistentecompras;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras.InscripcionNotificacionID;

/**
 * @author dvillafuerte
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSACTINSNOT")
public class InscripcionNotificacionDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private InscripcionNotificacionID id = new InscripcionNotificacionID();
	
	private Long codigoClientePedido;
	private String codigoClasificacion;
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

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({
//		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
//		@JoinColumn(name = "CODIGOCLIENTEPEDIDO", referencedColumnName = "CODIGOCLIENTEPEDIDO", insertable = false, updatable = false) })
//	private ClienteDTO clienteDto;
//	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({
//		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
//		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false) })
//	private ClasificacionDTO clasificacionDto;
	
	//METODOS GET Y SET
	public InscripcionNotificacionID getId() {
		return id;
	}

	public void setId(InscripcionNotificacionID id) {
		this.id = id;
	}

	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}

	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
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

//	public ClienteDTO getClienteDto() {
//		return clienteDto;
//	}
//
//	public void setClienteDto(ClienteDTO clienteDto) {
//		this.clienteDto = clienteDto;
//	}
//
//	public ClasificacionDTO getClasificacionDto() {
//		return clasificacionDto;
//	}
//
//	public void setClasificacionDto(ClasificacionDTO clasificacionDto) {
//		this.clasificacionDto = clasificacionDto;
//	}
	
}
