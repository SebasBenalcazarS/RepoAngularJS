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
import ec.com.smx.corpv2.dto.FuncionarioDTO;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase
 * LineaEmpaqueFuncionarioDTO
 * 
 * @see ec.com.smx.corpv2.dto.LineaEmpaqueFuncionarioDTO
 * 
 * @author srodriguez
 */


@SuppressWarnings("serial")
@Entity
@Table(name = "SBLOGTLINEMPUSU")
public class LineaEmpaqueFuncionarioDTO extends SimpleAuditDTO {

	/**
	 * Clave primaria de la tabla LineaEmpaqueArticuloDTO
	 * 
	 */
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueFuncionarioID id = new ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueFuncionarioID();

	
	/**
	 * Especifica el numero de personas maximas
	 */
	@Column(name = "ESTADO")
	@ComparatorTypeField
	private java.lang.String estado;

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
	@Column(name = "FECHAREGISTRO")
	private java.util.Date fechaRegistro;

	/**
	 * Id del usuario que realizo la ultima actualizacion
	 * 
	 */
	@LastModifierUserIdField
	@Column(name = "IDUSUARIOMODIFICACION")
	private java.lang.String idUsuarioModificacion;

	/**
	 * Fecha en la que se realizo la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Column(name = "FECHAMODIFICACION")
	private java.util.Date fechaModificacion;
	
	
	/**
	 * Obtiene la relacion con el catalogo de la linea de empaque
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOLINEAEMPAQUE", insertable = false, updatable = false, referencedColumnName = "CODIGOLINEAEMPAQUE") })
	private LineaEmpaqueDTO lineaEmpaqueDTO;
	
	/**
	 * Obtiene la relacion con el catalogo de articulo
	 * 
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({ @JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false), @JoinColumn(name = "CODIGOFUNCIONARIO", insertable = false, updatable = false, referencedColumnName = "CODIGOFUNCIONARIO") })
	private FuncionarioDTO funcionarioDTO;

	/** HashCode de la la clase LineaEmpaqueFuncionarioDTO
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/** Equals de la la clase LineaEmpaqueFuncionarioDTO
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineaEmpaqueFuncionarioDTO other = (LineaEmpaqueFuncionarioDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/**
	 * Metodo Getter del campo id
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueFuncionarioID getId() {
		return id;
	}

	/**
	 * Metodo Setter the id
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.LineaEmpaqueFuncionarioID id) {
		this.id = id;
	}

	/**
	 * Metodo Getter del campo estado
	 * @return the estado
	 */
	public java.lang.String getEstado() {
		return estado;
	}

	/**
	 * Metodo Setter the estado
	 * @param estado the estado to set
	 */
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	/**
	 * Metodo Getter del campo idUsuarioRegistro
	 * @return the idUsuarioRegistro
	 */
	public java.lang.String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * Metodo Setter the idUsuarioRegistro
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(java.lang.String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * Metodo Getter del campo fechaRegistro
	 * @return the fechaRegistro
	 */
	public java.util.Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Metodo Setter the fechaRegistro
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Metodo Getter del campo idUsuarioModificacion
	 * @return the idUsuarioModificacion
	 */
	public java.lang.String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	/**
	 * Metodo Setter the idUsuarioModificacion
	 * @param idUsuarioModificacion the idUsuarioModificacion to set
	 */
	public void setIdUsuarioModificacion(java.lang.String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	/**
	 * Metodo Getter del campo fechaModificacion
	 * @return the fechaModificacion
	 */
	public java.util.Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Metodo Setter the fechaModificacion
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * Metodo Getter del campo lineaEmpaqueDTO
	 * @return the lineaEmpaqueDTO
	 */
	public LineaEmpaqueDTO getLineaEmpaqueDTO() {
		return lineaEmpaqueDTO;
	}

	/**
	 * Metodo Setter the lineaEmpaqueDTO
	 * @param lineaEmpaqueDTO the lineaEmpaqueDTO to set
	 */
	public void setLineaEmpaqueDTO(LineaEmpaqueDTO lineaEmpaqueDTO) {
		this.lineaEmpaqueDTO = lineaEmpaqueDTO;
	}

	/**
	 * Metodo Getter del campo funcionarioDTO
	 * @return the funcionarioDTO
	 */
	public FuncionarioDTO getFuncionarioDTO() {
		return funcionarioDTO;
	}

	/**
	 * Metodo Setter the funcionarioDTO
	 * @param funcionarioDTO the funcionarioDTO to set
	 */
	public void setFuncionarioDTO(FuncionarioDTO funcionarioDTO) {
		this.funcionarioDTO = funcionarioDTO;
	}
	
}
