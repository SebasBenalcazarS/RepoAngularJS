package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaBodegaCDAreaTrabajoID;

@Entity
@SuppressWarnings("serial")
public class VistaBodegaCDAreaTrabajoDTO extends SearchDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.VistaBodegaCDAreaTrabajoID id = new ec.com.smx.sic.cliente.mdl.dto.id.VistaBodegaCDAreaTrabajoID();
	
	private String nombreAreaTrabajo;
	
	private String estadoAreaTrabajo;
	
	@Transient
	private String userId;
	
	/**
	 * @return the id
	 */
	public VistaBodegaCDAreaTrabajoID getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(VistaBodegaCDAreaTrabajoID id) {
		this.id = id;
	}
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the nombreAreaTrabajo
	 */
	public String getNombreAreaTrabajo() {
		return nombreAreaTrabajo;
	}

	/**
	 * @param nombreAreaTrabajo the nombreAreaTrabajo to set
	 */
	public void setNombreAreaTrabajo(String nombreAreaTrabajo) {
		this.nombreAreaTrabajo = nombreAreaTrabajo;
	}

	/**
	 * @return the estadoAreaTrabajo
	 */
	public String getEstadoAreaTrabajo() {
		return estadoAreaTrabajo;
	}

	/**
	 * @param estadoAreaTrabajo the estadoAreaTrabajo to set
	 */
	public void setEstadoAreaTrabajo(String estadoAreaTrabajo) {
		this.estadoAreaTrabajo = estadoAreaTrabajo;
	}
	
}
