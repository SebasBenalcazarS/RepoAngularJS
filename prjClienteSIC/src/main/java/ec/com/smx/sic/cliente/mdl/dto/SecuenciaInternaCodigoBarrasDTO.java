/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.SecuenciaInternaCodigoBarrasID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTSECINTCODBAR")
public class SecuenciaInternaCodigoBarrasDTO extends SimpleAuditDTO{

	@EmbeddedId
	private SecuenciaInternaCodigoBarrasID id = new SecuenciaInternaCodigoBarrasID();
	private String valorTipoSecuencia;
	private Integer codigoTipoSecuencia;
	private String estado;
	/**
	 * Especifica el usuario que realiza el registro.
	 * 
	 */
	@RegisterUserIdField
	@Column(updatable=false)
	private String idUsuarioRegistro;

	/**
	 * Fecha en la que se realiza el registro
	 * 
	 */
	@RegisterDateField
	@Column(updatable=false)
	private java.sql.Timestamp fechaRegistro;

	/**
	 * Id del usuario que realiza la ultima actualizacion.
	 * 
	 */
	@LastModifierUserIdField
	@Column(insertable=false)
	private String idUsuarioModificacion;

	/**
	 * Fecha en la que se realiza la ultima actualizacion.
	 * 
	 */
	@LastModificationDateField
	@Column(insertable=false)
	private java.sql.Timestamp fechaModificacion;
	
	/**
	 * @return the valorTipoSecuencia
	 */
	public String getValorTipoSecuencia() {
		return valorTipoSecuencia;
	}
	/**
	 * @param valorTipoSecuencia the valorTipoSecuencia to set
	 */
	public void setValorTipoSecuencia(String valorTipoSecuencia) {
		this.valorTipoSecuencia = valorTipoSecuencia;
	}
	/**
	 * @return the codigoTipoSecuencia
	 */
	public Integer getCodigoTipoSecuencia() {
		return codigoTipoSecuencia;
	}
	/**
	 * @param codigoTipoSecuencia the codigoTipoSecuencia to set
	 */
	public void setCodigoTipoSecuencia(Integer codigoTipoSecuencia) {
		this.codigoTipoSecuencia = codigoTipoSecuencia;
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
	 * @return the id
	 */
	public SecuenciaInternaCodigoBarrasID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(SecuenciaInternaCodigoBarrasID id) {
		this.id = id;
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
	
}
