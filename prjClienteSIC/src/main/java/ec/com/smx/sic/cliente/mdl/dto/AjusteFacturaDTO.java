package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.AjusteFacturaID;

/**
 * 
 * @author fcollaguazo
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SCSADTAJUFAC")
public class AjusteFacturaDTO extends SimpleAuditDTO{
	/**
	 * Clave primaria de la tabla AjusteFacturaDTO
	 * 
	 */
	@EmbeddedId
	private AjusteFacturaID id = new AjusteFacturaID();
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@Column
	@RegisterDateField
	private Date fechaRegistro;
	
	@Column(name="IDUSUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;
	
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
	
	@Column(name="IDUSUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOAJUSTEFACTURAESTADO", insertable = false, updatable = false, referencedColumnName = "CODIGOAJUSTEFACTURAESTADO") })
    private AjusteFacturaEstadoDTO ajusteFacturaEstadoDTO;
	
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURAESTADO", insertable = false, updatable = false, referencedColumnName = "CODIGOFACTURAESTADO") })
	private FacturaEstadoDTO facturaEstadoDTO;


	public AjusteFacturaID getId() {
		return id;
	}


	public void setId(AjusteFacturaID id) {
		this.id = id;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}


	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}


	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}


	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}


	public AjusteFacturaEstadoDTO getAjusteFacturaEstadoDTO() {
		return ajusteFacturaEstadoDTO;
	}


	public void setAjusteFacturaEstadoDTO(AjusteFacturaEstadoDTO ajusteFacturaEstadoDTO) {
		this.ajusteFacturaEstadoDTO = ajusteFacturaEstadoDTO;
	}


	public FacturaEstadoDTO getFacturaEstadoDTO() {
		return facturaEstadoDTO;
	}


	public void setFacturaEstadoDTO(FacturaEstadoDTO facturaEstadoDTO) {
		this.facturaEstadoDTO = facturaEstadoDTO;
	}
}
