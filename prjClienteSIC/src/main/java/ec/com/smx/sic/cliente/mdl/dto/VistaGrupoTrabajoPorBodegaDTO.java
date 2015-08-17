package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;

/**
 * 
 * @author cortiz
 * @author jdvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
public class VistaGrupoTrabajoPorBodegaDTO extends SearchDTO{


	@Id
	private java.lang.Long codigoGrupoTrabajo;
	private String nombreGrupoTrabajo;
	private String descripcionGrupoTrabajo;
	private String estadoGrupoTrabajo;
	private String tieneAreas;
	@Transient
	private Boolean plegado = Boolean.TRUE;
	@Transient
	private Boolean edicion = Boolean.FALSE;
	
	@Transient
	private Collection<AreaTrabajoDTO> areasTrabajoRelCol;

	/**
	 * @return the codigoGrupoTrabajo
	 */
	public java.lang.Long getCodigoGrupoTrabajo() {
		return codigoGrupoTrabajo;
	}

	/**
	 * @param codigoGrupoTrabajo the codigoGrupoTrabajo to set
	 */
	public void setCodigoGrupoTrabajo(java.lang.Long codigoGrupoTrabajo) {
		this.codigoGrupoTrabajo = codigoGrupoTrabajo;
	}

	/**
	 * @return the nombreGrupoTrabajo
	 */
	public String getNombreGrupoTrabajo() {
		return nombreGrupoTrabajo;
	}

	/**
	 * @param nombreGrupoTrabajo the nombreGrupoTrabajo to set
	 */
	public void setNombreGrupoTrabajo(String nombreGrupoTrabajo) {
		this.nombreGrupoTrabajo = nombreGrupoTrabajo;
	}

	/**
	 * @return the descripcionGrupoTrabajo
	 */
	public String getDescripcionGrupoTrabajo() {
		return descripcionGrupoTrabajo;
	}

	/**
	 * @param descripcionGrupoTrabajo the descripcionGrupoTrabajo to set
	 */
	public void setDescripcionGrupoTrabajo(String descripcionGrupoTrabajo) {
		this.descripcionGrupoTrabajo = descripcionGrupoTrabajo;
	}

	/**
	 * @return the estadoGrupoTrabajo
	 */
	public String getEstadoGrupoTrabajo() {
		return estadoGrupoTrabajo;
	}

	/**
	 * @param estadoGrupoTrabajo the estadoGrupoTrabajo to set
	 */
	public void setEstadoGrupoTrabajo(String estadoGrupoTrabajo) {
		this.estadoGrupoTrabajo = estadoGrupoTrabajo;
	}

	/**
	 * @return the tieneAreas
	 */
	public String getTieneAreas() {
		return tieneAreas;
	}

	/**
	 * @param tieneAreas the tieneAreas to set
	 */
	public void setTieneAreas(String tieneAreas) {
		this.tieneAreas = tieneAreas;
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
	 * @return the areasTrabajoRelCol
	 */
	public Collection<AreaTrabajoDTO> getAreasTrabajoRelCol() {
		return areasTrabajoRelCol;
	}

	/**
	 * @param areasTrabajoRelCol the areasTrabajoRelCol to set
	 */
	public void setAreasTrabajoRelCol(Collection<AreaTrabajoDTO> areasTrabajoRelCol) {
		this.areasTrabajoRelCol = areasTrabajoRelCol;
	}

	/**
	 * @return the edicion
	 */
	public Boolean getEdicion() {
		return edicion;
	}

	/**
	 * @param edicion the edicion to set
	 */
	public void setEdicion(Boolean edicion) {
		this.edicion = edicion;
	}
	
	

}
