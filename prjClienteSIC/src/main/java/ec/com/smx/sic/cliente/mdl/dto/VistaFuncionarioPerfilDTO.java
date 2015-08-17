package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaFuncionarioPerfilID;

@SuppressWarnings("serial")
public class VistaFuncionarioPerfilDTO extends SearchDTO {
	@EmbeddedId
	VistaFuncionarioPerfilID id = new VistaFuncionarioPerfilID();
	/*Campo desde Funcionario*/
	private String usuarioFuncionario;
	/*Campos desde Usuario*/
	private String userName;
	private String userCompleteName;
	/*Campos desde FuncionarioSublugarTrabajoRelacion*/
	private Integer codigoAreaTrabajo;	
	private Integer codigoAreaSublugarTrabajo;
	private Boolean esPorDefecto;
	
	@Transient
	//Identificador para saber si esta ocupado el funcionario
	private Boolean estaOcupado = Boolean.FALSE;
	
	@Transient
	//Numero de recepciones asignadas al funcionario
	private Integer numeroRecepcionesAsignadas;
	
	public VistaFuncionarioPerfilID getId() {
		return id;
	}
	public void setId(VistaFuncionarioPerfilID id) {
		this.id = id;
	}
	/**
	 * @return the usuarioFuncionario
	 */
	public String getUsuarioFuncionario() {
		return usuarioFuncionario;
	}
	/**
	 * @param usuarioFuncionario the usuarioFuncionario to set
	 */
	public void setUsuarioFuncionario(String usuarioFuncionario) {
		this.usuarioFuncionario = usuarioFuncionario;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userCompleteName
	 */
	public String getUserCompleteName() {
		return userCompleteName;
	}
	/**
	 * @param userCompleteName the userCompleteName to set
	 */
	public void setUserCompleteName(String userCompleteName) {
		this.userCompleteName = userCompleteName;
	}
	/**
	 * @return the esPorDefecto
	 */
	public Boolean getEsPorDefecto() {
		return esPorDefecto;
	}
	/**
	 * @param esPorDefecto the esPorDefecto to set
	 */
	public void setEsPorDefecto(Boolean esPorDefecto) {
		this.esPorDefecto = esPorDefecto;
	}
	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}
	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
	/**
	 * @return the estaOcupado
	 */
	public Boolean getEstaOcupado() {
		return estaOcupado;
	}
	/**
	 * @param estaOcupado the estaOcupado to set
	 */
	public void setEstaOcupado(Boolean estaOcupado) {
		this.estaOcupado = estaOcupado;
	}
	/**
	 * @return the numeroRecepcionesAsignadas
	 */
	public Integer getNumeroRecepcionesAsignadas() {
		return numeroRecepcionesAsignadas;
	}
	/**
	 * @param numeroRecepcionesAsignadas the numeroRecepcionesAsignadas to set
	 */
	public void setNumeroRecepcionesAsignadas(Integer numeroRecepcionesAsignadas) {
		this.numeroRecepcionesAsignadas = numeroRecepcionesAsignadas;
	}
	/**
	 * @return the codigoAreaSublugarTrabajo
	 */
	public Integer getCodigoAreaSublugarTrabajo() {
		return codigoAreaSublugarTrabajo;
	}
	/**
	 * @param codigoAreaSublugarTrabajo the codigoAreaSublugarTrabajo to set
	 */
	public void setCodigoAreaSublugarTrabajo(Integer codigoAreaSublugarTrabajo) {
		this.codigoAreaSublugarTrabajo = codigoAreaSublugarTrabajo;
	}	
	
}

