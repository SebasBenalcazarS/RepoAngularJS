
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.GuiaTransporteDocumentoID;

/**
 * Entidad GuiaTransporteDocumentoDTO para la tabla SBLOGTGUITRADOC
 * @author hgudino
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTGUITRADOC")
public class GuiaTransporteDocumentoDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla GuiaTransporteDestinoDTO
	 *
	 */
	@EmbeddedId
	private GuiaTransporteDocumentoID id = new GuiaTransporteDocumentoID();
	
	/**
	 * Codigo de documento packinglist
	 *
	 */
	@Column(name="CODIGODOCUMENTO")
	private java.lang.String codigoDocumento ;
	
	/**
	 * codigo de guia de transporte
	 *
	 */
	@Column(name="SECUENCIAGUIA")
	private java.lang.Long secuenciaGuia;
	
	/**
	 * Codigo de clientes 
	 *
	 */
	@Column(name="CANTIDAD")
	private java.lang.Integer cantidad ;
			
	/**
	 * Indica la descripcion del documento
	 *
	 */
	@Transient
//	@Column(name="DESCRIPCION")
	private java.lang.String descripcion ;
	
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private java.lang.String estado ;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiza la actualizacion del registro
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaActualizacion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String idUsuarioRegistro;

	
	/**
	 * Id del usuario que realiz� la �ltima actualizaci�n.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
	/**
	 * Relacion con la tabla guia transporte
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
	@JoinColumn(name="SECUENCIAGUIA", insertable=false, updatable=false, referencedColumnName="SECUENCIAGUIA")})
	private GuiaTransporteDTO guiaTransporteDTO;
		
	public GuiaTransporteDocumentoDTO() {
		
	}

	/**
	 * @return the id
	 */
	public GuiaTransporteDocumentoID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(GuiaTransporteDocumentoID id) {
		this.id = id;
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
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaActualizacion
	 */
	public java.util.Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	/**
	 * @param fechaActualizacion the fechaActualizacion to set
	 */
	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
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
	 * @return the idUsuarioActualizacion
	 */
	public String getIdUsuarioActualizacion() {
		return idUsuarioActualizacion;
	}

	/**
	 * @param idUsuarioActualizacion the idUsuarioActualizacion to set
	 */
	public void setIdUsuarioActualizacion(String idUsuarioActualizacion) {
		this.idUsuarioActualizacion = idUsuarioActualizacion;
	}

	/**
	 * @return the codigoDocumento
	 */
	public java.lang.String getCodigoDocumento() {
		return codigoDocumento;
	}

	/**
	 * @param codigoDocumento the codigoDocumento to set
	 */
	public void setCodigoDocumento(java.lang.String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	/**
	 * @return the secuenciaGuia
	 */
	public java.lang.Long getSecuenciaGuia() {
		return secuenciaGuia;
	}

	/**
	 * @param secuenciaGuia the secuenciaGuia to set
	 */
	public void setSecuenciaGuia(java.lang.Long secuenciaGuia) {
		this.secuenciaGuia = secuenciaGuia;
	}

	/**
	 * @return the cantidad
	 */
	public java.lang.Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(java.lang.Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the guiaTransporteDTO
	 */
	public GuiaTransporteDTO getGuiaTransporteDTO() {
		return guiaTransporteDTO;
	}

	/**
	 * @param guiaTransporteDTO the guiaTransporteDTO to set
	 */
	public void setGuiaTransporteDTO(GuiaTransporteDTO guiaTransporteDTO) {
		this.guiaTransporteDTO = guiaTransporteDTO;
	}

	/**
	 * @return the descripcion
	 */
	public java.lang.String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(java.lang.String descripcion) {
		this.descripcion = descripcion;
	}

}