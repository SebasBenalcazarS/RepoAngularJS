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
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.UsuarioClasificacionProcesoID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author cortiz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTUSUCLA")
public class UsuarioClasificacionProcesoDTO extends AuditoriaBaseDTO{

	/**
	 * id de usuario articulo
	 */
	@EmbeddedId
	private UsuarioClasificacionProcesoID id = new UsuarioClasificacionProcesoID();
	
	/**
	 * codigo usuario clasificacion secuencial
	 */
	@Column
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSECUSUCLA")
	private java.lang.Long codigoUsuarioClasificacion;
	
	/**
	 * codigo del proceso
	 */
	@Column
	private java.lang.Long codigoProceso;
	
	/**
	 * estado 
	 */
	@Column
	@ComparatorTypeField
	private String estado;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName = "CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOCLASIFICACION", referencedColumnName = "CODIGOCLASIFICACION", insertable = false, updatable = false)})
	private ClasificacionDTO clasificacionDTO;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "CODIGOUSUARIO", referencedColumnName = "USERID", insertable = false, updatable = false)
	private UserDto  userDTO;
	
	public UsuarioClasificacionProcesoID getId() {
		return id;
	}

	public void setId(UsuarioClasificacionProcesoID id) {
		this.id = id;
	}

	public java.lang.Long getCodigoUsuarioClasificacion() {
		return codigoUsuarioClasificacion;
	}

	public void setCodigoUsuarioClasificacion(java.lang.Long codigoUsuarioClasificacion) {
		this.codigoUsuarioClasificacion = codigoUsuarioClasificacion;
	}

	public java.lang.Long getCodigoProceso() {
		return codigoProceso;
	}

	public void setCodigoProceso(java.lang.Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ClasificacionDTO getClasificacionDTO() {
		return clasificacionDTO;
	}

	public void setClasificacionDTO(ClasificacionDTO clasificacionDTO) {
		this.clasificacionDTO = clasificacionDTO;
	}

	public UserDto getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDto userDTO) {
		this.userDTO = userDTO;
	}
	
	
}
