
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoFurgonID;

/**
 * Especifica las caractegorias del detalle de la seccion tipo anden
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SBLOGTTIPOFURGON")
public class TipoFurgonDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla CategoriaDTO
	 *
	 */
	@EmbeddedId
	private TipoFurgonID id = new TipoFurgonID();
	
	/**
	 * Especifica el nombre del tipo de furgon
	 *
	 */
	@Column(name="NOMBRE")
	private String nombre ;
	
	/**
	 * Especifica la cantidad de bultos que soporta un furgon
	 *
	 */
	@Column(name="CANTIDADBULTOS")
	private Integer cantidadBultos ;
	
	/**
	 * Especifica la cantidad exedente de bultos que soporta un furgon
	 *
	 */
	@Column(name="CANTIDADEXEDENTEBULTOS")
	private Integer cantidadExedenteBultos ;

			
	/**
	 * Indica el estado del registro:[ACT] activo [INA] inactivo
	 *
	 */
	@Column(name="ESTADO")
	private String estado ;
	
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
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String idUsuarioActualizacion;
	
		
	public TipoFurgonDTO() {
		
	}

	/**
	 * @return the id
	 */
	public TipoFurgonID getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(TipoFurgonID id) {
		this.id = id;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the cantidadBultos
	 */
	public Integer getCantidadBultos() {
		return cantidadBultos;
	}

	/**
	 * @param cantidadBultos the cantidadBultos to set
	 */
	public void setCantidadBultos(Integer cantidadBultos) {
		this.cantidadBultos = cantidadBultos;
	}

	/**
	 * @return the cantidadExedenteBultos
	 */
	public Integer getCantidadExedenteBultos() {
		return cantidadExedenteBultos;
	}

	/**
	 * @param cantidadExedenteBultos the cantidadExedenteBultos to set
	 */
	public void setCantidadExedenteBultos(Integer cantidadExedenteBultos) {
		this.cantidadExedenteBultos = cantidadExedenteBultos;
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
	
}