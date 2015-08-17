/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.framework.multicompany.dto.UserCompanySystemDto;
import ec.com.smx.framework.security.dto.UserRoleDto;
import ec.com.smx.sic.cliente.mdl.dto.id.UsuarioEntidadProveedorID;

/**
 * @author mbraganza
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SSB2BVUSUENTPRO")
public class UsuarioEntidadProveedorDTO extends SearchDTO {
	
	@EmbeddedId
	private UsuarioEntidadProveedorID id;
	
	private Integer codigoCompania;
	private Long codigoEntidad;
	private String valorTipoEntidad;
	private Integer codigoTipoEntidad;
	private String codigoUnicoEmpresa;
	private String estadoUsuarioEmpresa;
	private Boolean esInactivoPermanente;
	private String cuentaUsuario;
	private String nombreUsuario;
	private String emailUsuario;
	private String contraseniaUsuario;
	private String contraseniaEncriptada;
	private String estadoUsuario;
	private String tipoUsuario;
	private String esSuperUsuario;
	
	@Transient
	private Collection<UserRoleDto> rolesUsuario;
	
	@Transient
	private Set<UserCompanySystemDto> sistemasUsuario;
	

	/**
	 * @return el id
	 */
	public UsuarioEntidadProveedorID getId() {
		return id;
	}

	/**
	 * @param id el id a establecer
	 */
	public void setId(UsuarioEntidadProveedorID id) {
		this.id = id;
	}
	
	

	/**
	 * @return el codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania el codigoCompania a establecer
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return el codigoEntidad
	 */
	public Long getCodigoEntidad() {
		return codigoEntidad;
	}

	/**
	 * @param codigoEntidad el codigoEntidad a establecer
	 */
	public void setCodigoEntidad(Long codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}

	/**
	 * @return el codigoTipoEntidad
	 */
	public Integer getCodigoTipoEntidad() {
		return codigoTipoEntidad;
	}

	/**
	 * @param codigoTipoEntidad el codigoTipoEntidad a establecer
	 */
	public void setCodigoTipoEntidad(Integer codigoTipoEntidad) {
		this.codigoTipoEntidad = codigoTipoEntidad;
	}

	/**
	 * @return el codigoUnicoEmpresa
	 */
	public String getCodigoUnicoEmpresa() {
		return codigoUnicoEmpresa;
	}

	/**
	 * @param codigoUnicoEmpresa el codigoUnicoEmpresa a establecer
	 */
	public void setCodigoUnicoEmpresa(String codigoUnicoEmpresa) {
		this.codigoUnicoEmpresa = codigoUnicoEmpresa;
	}

	/**
	 * @return el cuentaUsuario
	 */
	public String getCuentaUsuario() {
		return cuentaUsuario;
	}

	/**
	 * @param cuentaUsuario el cuentaUsuario a establecer
	 */
	public void setCuentaUsuario(String cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}

	/**
	 * @return el emailUsuario
	 */
	public String getEmailUsuario() {
		return emailUsuario;
	}

	/**
	 * @param emailUsuario el emailUsuario a establecer
	 */
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	/**
	 * @return el esInactivoPermanente
	 */
	public Boolean getEsInactivoPermanente() {
		return esInactivoPermanente;
	}

	/**
	 * @param esInactivoPermanente el esInactivoPermanente a establecer
	 */
	public void setEsInactivoPermanente(Boolean esInactivoPermanente) {
		this.esInactivoPermanente = esInactivoPermanente;
	}

	/**
	 * @return el esSuperUsuario
	 */
	public String getEsSuperUsuario() {
		return esSuperUsuario;
	}

	/**
	 * @param esSuperUsuario el esSuperUsuario a establecer
	 */
	public void setEsSuperUsuario(String esSuperUsuario) {
		this.esSuperUsuario = esSuperUsuario;
	}

	/**
	 * @return el estadoUsuario
	 */
	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	/**
	 * @param estadoUsuario el estadoUsuario a establecer
	 */
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	/**
	 * @return el estadoUsuarioEmpresa
	 */
	public String getEstadoUsuarioEmpresa() {
		return estadoUsuarioEmpresa;
	}

	/**
	 * @param estadoUsuarioEmpresa el estadoUsuarioEmpresa a establecer
	 */
	public void setEstadoUsuarioEmpresa(String estadoUsuarioEmpresa) {
		this.estadoUsuarioEmpresa = estadoUsuarioEmpresa;
	}

	/**
	 * @return el nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario el nombreUsuario a establecer
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return el tipoUsuario
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario el tipoUsuario a establecer
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	/**
	 * @return el valorTipoEntidad
	 */
	public String getValorTipoEntidad() {
		return valorTipoEntidad;
	}

	/**
	 * @param valorTipoEntidad el valorTipoEntidad a establecer
	 */
	public void setValorTipoEntidad(String valorTipoEntidad) {
		this.valorTipoEntidad = valorTipoEntidad;
	}

	/**
	 * @return el rolesUsuario
	 */
	public Collection<UserRoleDto> getRolesUsuario() {
		return rolesUsuario;
	}

	/**
	 * @param rolesUsuario el rolesUsuario a establecer
	 */
	public void setRolesUsuario(Collection<UserRoleDto> rolesUsuario) {
		this.rolesUsuario = rolesUsuario;
	}

	/**
	 * @return el sistemasUsuario
	 */
	public Set<UserCompanySystemDto> getSistemasUsuario() {
		return sistemasUsuario;
	}

	/**
	 * @param sistemasUsuario el sistemasUsuario a establecer
	 */
	public void setSistemasUsuario(Set<UserCompanySystemDto> sistemasUsuario) {
		this.sistemasUsuario = sistemasUsuario;
	}

	/**
	 * @return el contraseniaUsuario
	 */
	public String getContraseniaUsuario() {
		return contraseniaUsuario;
	}

	/**
	 * @param contraseniaUsuario el contraseniaUsuario a establecer
	 */
	public void setContraseniaUsuario(String contraseniaUsuario) {
		this.contraseniaUsuario = contraseniaUsuario;
	}

	/**
	 * @return el contraseniaEncriptada
	 */
	public String getContraseniaEncriptada() {
		return contraseniaEncriptada;
	}

	/**
	 * @param contraseniaEncriptada el contraseniaEncriptada a establecer
	 */
	public void setContraseniaEncriptada(String contraseniaEncriptada) {
		this.contraseniaEncriptada = contraseniaEncriptada;
	}

}
