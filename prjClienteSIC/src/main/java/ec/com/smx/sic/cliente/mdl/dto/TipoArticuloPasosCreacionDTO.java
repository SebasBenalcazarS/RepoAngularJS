package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoArticuloPasosCreacionID;

/**
 * Almacena los pasos de la creaci&oacute;n de un art&iacute;culo por su tipo
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTTIPARTPASCRE")
public class TipoArticuloPasosCreacionDTO extends SimpleAuditDTO {

	@EmbeddedId
	private TipoArticuloPasosCreacionID id = new TipoArticuloPasosCreacionID();
	
	@ComparatorTypeField
	private String estado;
	private Integer orden;
	/**
	 * Especifica el usuario que realiza el registro.
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;
	
	/**
	 * Fecha en la que se realiza el registro
	 */
	@RegisterDateField
	@Column(updatable=false)
	private Timestamp fechaRegistro;

	/**
	 * @return the id
	 */
	public TipoArticuloPasosCreacionID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TipoArticuloPasosCreacionID id) {
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
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
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
	 * @return the fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
