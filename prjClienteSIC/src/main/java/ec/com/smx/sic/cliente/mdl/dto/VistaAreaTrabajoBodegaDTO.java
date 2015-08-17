package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * 
 * @author cortiz
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
public class VistaAreaTrabajoBodegaDTO extends SearchDTO{

	@Id
	private Integer codigoAreaTrabajo;
	private String nombreAreaTrabajo;
	private String estadoAreaTrabajo;
	private String tieneGrupos;
	@Transient
	private Boolean plegado = Boolean.TRUE;
	
	@Transient
	private Collection<VistaGrupoTrabajoPorBodegaDTO> gruposTrabajoRelCol;
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
	/**
	 * @return the tienegrupos
	 */
	public String getTieneGrupos() {
		return tieneGrupos;
	}
	/**
	 * @param tienegrupos the tienegrupos to set
	 */
	public void setTieneGrupos(String tieneGrupos) {
		this.tieneGrupos = tieneGrupos;
	}
	/**
	 * @return the plegado
	 */
	public Boolean getPlegado() {
		return plegado;
	}
	/**
	 * @param plegado the plegado to set
	 */
	public void setPlegado(Boolean plegado) {
		this.plegado = plegado;
	}
	/**
	 * @return the gruposTrabajoRelCol
	 */
	public Collection<VistaGrupoTrabajoPorBodegaDTO> getGruposTrabajoRelCol() {
		return gruposTrabajoRelCol;
	}
	/**
	 * @param gruposTrabajoRelCol the gruposTrabajoRelCol to set
	 */
	public void setGruposTrabajoRelCol(Collection<VistaGrupoTrabajoPorBodegaDTO> gruposTrabajoRelCol) {
		this.gruposTrabajoRelCol = gruposTrabajoRelCol;
	}
	
}
