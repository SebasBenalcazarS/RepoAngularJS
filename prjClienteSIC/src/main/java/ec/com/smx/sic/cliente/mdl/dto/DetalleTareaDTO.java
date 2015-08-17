
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

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.DetalleTareaID;



/**
 * Almacena los detalles de las tareas de la estructura logistica
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBTARTDETTAR")
public class DetalleTareaDTO extends SimpleAuditDTO{

	
	/**
	 * Clave primaria de la tabla DetalleTareaDTO
	 * 
	 */
	@EmbeddedId
	private DetalleTareaID id = new DetalleTareaID();
	
	/**
	 * Especifica el codigo de la tarea
	 *
	 */
	@Column
	private java.lang.Long codigoTarea ;
	
	/**
	 * Especifica el codigo del detalle seccion origen
	 *
	 */
	@Column
	private java.lang.Long codigoDetalleSeccionOrigen ;
	
	/**
	 * Especifica el codigo del detalle seccion destino
	 *
	 */
	@Column	
	private java.lang.Long codigoDetalleSeccionDestino ;

	/**
	 * Indica el estado del registro: [1] activo [0] inactivo
	 *
	 */
	@Column
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Id del usuario que realiz\u00f3 la \u00faltima actualizaci\u00f3n.
	 *

	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioModificacion ;
	
	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaRegistro;
	
	/**
	 * Fecha en la que se realiz\u00f3 la \u00faltima actualizaci\u00f3n.
	 * 
	 */
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date fechaModificacion;
	
	/**
	 * Especifica la relacion con la tarea
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOTAREA", referencedColumnName = "CODIGOTAREA", insertable = false, updatable = false)})
	
	private TareaDTO tareaDTO;
	/**
	 * Especifica la relacion con la seccion de origen
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODETALLESECCIONORIGEN", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)})
	private DetalleSeccionDTO detalleSeccionOrigen;
	
	/**
	 * Especifica la relacion con la seccion de destino
	 *
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGODETALLESECCIONDESTINO", referencedColumnName = "CODIGODETALLESECCION", insertable = false, updatable = false)})
	private DetalleSeccionDTO detalleSeccionDestino;

	/**
	 * @return the id
	 */
	public DetalleTareaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(DetalleTareaID id) {
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
	 * @return the tareaDTO
	 */
	public TareaDTO getTareaDTO() {
		return tareaDTO;
	}

	/**
	 * @param tareaDTO the tareaDTO to set
	 */
	public void setTareaDTO(TareaDTO tareaDTO) {
		this.tareaDTO = tareaDTO;
	}
	
	/**
	 * @return the detalleSeccionOrigen
	 */
	public DetalleSeccionDTO getDetalleSeccionOrigen() {
		return detalleSeccionOrigen;
	}

	/**
	 * @param detalleSeccionOrigen the detalleSeccionOrigen to set
	 */
	public void setDetalleSeccionOrigen(DetalleSeccionDTO detalleSeccionOrigen) {
		this.detalleSeccionOrigen = detalleSeccionOrigen;
	}
	
	/**
	 * @return the detalleSeccionDestino
	 */
	public DetalleSeccionDTO getDetalleSeccionDestino() {
		return detalleSeccionDestino;
	}

	/**
	 * @param detalleSeccionDestino the detalleSeccionDestino to set
	 */
	public void setDetalleSeccionDestino(DetalleSeccionDTO detalleSeccionDestino) {
		this.detalleSeccionDestino = detalleSeccionDestino;
	}

	/**
	 * @return the codigoDetalleSeccionOrigen
	 */
	public java.lang.Long getCodigoDetalleSeccionOrigen() {
		return codigoDetalleSeccionOrigen;
	}

	/**
	 * @param codigoDetalleSeccionOrigen the codigoDetalleSeccionOrigen to set
	 */
	public void setCodigoDetalleSeccionOrigen(java.lang.Long codigoDetalleSeccionOrigen) {
		this.codigoDetalleSeccionOrigen = codigoDetalleSeccionOrigen;
	}

	/**
	 * @return the codigoDetalleSeccionDestino
	 */
	public java.lang.Long getCodigoDetalleSeccionDestino() {
		return codigoDetalleSeccionDestino;
	}

	/**
	 * @param codigoDetalleSeccionDestino the codigoDetalleSeccionDestino to set
	 */
	public void setCodigoDetalleSeccionDestino(java.lang.Long codigoDetalleSeccionDestino) {
		this.codigoDetalleSeccionDestino = codigoDetalleSeccionDestino;
	}

	/**
	 * @return the codigoTarea
	 */
	public java.lang.Long getCodigoTarea() {
		return codigoTarea;
	}

	/**
	 * @param codigoTarea the codigoTarea to set
	 */
	public void setCodigoTarea(java.lang.Long codigoTarea) {
		this.codigoTarea = codigoTarea;
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
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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
	
}