package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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

/**
 * Tabla que representa al mantenimeinto de una linea de empaque o produccion
 * 
 * @author srodriguez
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "SBLOGTLINEMP")
public class BitacoraMantenimientoLineaEmpaqueDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla Bitacora Administracion Linea Empaque
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.BitacoraMantenimientoLineaEmpaqueID id = new ec.com.smx.sic.cliente.mdl.dto.id.BitacoraMantenimientoLineaEmpaqueID();

	/**
	 * Especifica la descripción de la causa que obliga a la linea a tener
	 * mantenimiento
	 */
	@Column(name = "DESCRIPCIONCAUSA")
	@ComparatorTypeField
	private java.lang.String descripcionCausa;

	/**
	 * Especifica la fecha del mantenimiento de la linea de produccion
	 */
	@Column(name = "FECHAMANTENIMIENTO")
	@ComparatorTypeField
	private java.util.Date fechaMantenimiento;

	/**
	 * Especifica la descripción de la solución del mantenimiento
	 */
	@Column(name = "DESCRIPCIONSOLUCION")
	@ComparatorTypeField
	private java.lang.String descripcionSolucion;

	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(name = "IDUSUARIOREGISTRO")
	private java.lang.String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizó la última actualización.
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizó la última actualización.
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;

	/**
	 * Obtiene la relacion con el catálogo de líneas de empaque
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOLINEAEMPAQUE", insertable = false, updatable = false, referencedColumnName = "CODIGOLINEAEMPAQUE") })
	private LineaEmpaqueDTO lineaEmpaqueDTO;

	/**
	 * Método Getter del campo id
	 * 
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.BitacoraMantenimientoLineaEmpaqueID getId() {
		return id;
	}

	/**
	 * Método Setter the id
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.BitacoraMantenimientoLineaEmpaqueID id) {
		this.id = id;
	}

	/**
	 * Método Getter del campo descripcionCausa
	 * 
	 * @return the descripcionCausa
	 */
	public java.lang.String getDescripcionCausa() {
		return descripcionCausa;
	}

	/**
	 * Método Setter the descripcionCausa
	 * 
	 * @param descripcionCausa
	 *            the descripcionCausa to set
	 */
	public void setDescripcionCausa(java.lang.String descripcionCausa) {
		this.descripcionCausa = descripcionCausa;
	}

	/**
	 * Método Getter del campo fechaMantenimiento
	 * 
	 * @return the fechaMantenimiento
	 */
	public java.util.Date getFechaMantenimiento() {
		return fechaMantenimiento;
	}

	/**
	 * Método Setter the fechaMantenimiento
	 * 
	 * @param fechaMantenimiento
	 *            the fechaMantenimiento to set
	 */
	public void setFechaMantenimiento(java.util.Date fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}

	/**
	 * Método Getter del campo descripcionSolucion
	 * 
	 * @return the descripcionSolucion
	 */
	public java.lang.String getDescripcionSolucion() {
		return descripcionSolucion;
	}

	/**
	 * Método Setter the descripcionSolucion
	 * 
	 * @param descripcionSolucion
	 *            the descripcionSolucion to set
	 */
	public void setDescripcionSolucion(java.lang.String descripcionSolucion) {
		this.descripcionSolucion = descripcionSolucion;
	}

	/**
	 * Método Getter del campo idUsuarioRegistro
	 * 
	 * @return the idUsuarioRegistro
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * Método Setter the idUsuarioRegistro
	 * 
	 * @param idUsuarioRegistro
	 *            the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * Método Getter del campo fechaRegistro
	 * 
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Método Setter the fechaRegistro
	 * 
	 * @param fechaRegistro
	 *            the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Método Getter del campo idUsuarioModificacion
	 * 
	 * @return the idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * Método Setter the idUsuarioModificacion
	 * 
	 * @param idUsuarioModificacion
	 *            the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * Método Getter del campo fechaModificacion
	 * 
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Método Setter the fechaModificacion
	 * 
	 * @param fechaModificacion
	 *            the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Método Getter del campo lineaEmpaqueDTO
	 * 
	 * @return the lineaEmpaqueDTO
	 */
	public LineaEmpaqueDTO getLineaEmpaqueDTO() {
		return lineaEmpaqueDTO;
	}

	/**
	 * Método Setter the lineaEmpaqueDTO
	 * 
	 * @param lineaEmpaqueDTO
	 *            the lineaEmpaqueDTO to set
	 */
	public void setLineaEmpaqueDTO(LineaEmpaqueDTO lineaEmpaqueDTO) {
		this.lineaEmpaqueDTO = lineaEmpaqueDTO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BitacoraMantenimientoLineaEmpaqueDTO [id=" + id + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BitacoraMantenimientoLineaEmpaqueDTO other = (BitacoraMantenimientoLineaEmpaqueDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
