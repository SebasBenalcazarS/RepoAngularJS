package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaProveedorPlanificacionBodegaID;

@Entity
@SuppressWarnings("serial")
public class VistaProveedorPlanificacionBodegaDTO extends SearchDTO{
	
	@EmbeddedId
	private VistaProveedorPlanificacionBodegaID id = new VistaProveedorPlanificacionBodegaID();
	
	@Transient
	private Integer codigoAreaTrabajoPadre;
	@Transient
	private Integer codigoAreaTrabajoSeleccion;
	/**
	 * @return the id
	 */
	public VistaProveedorPlanificacionBodegaID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaProveedorPlanificacionBodegaID id) {
		this.id = id;
	}
	/**
	 * @return the codigoAreaTrabajoPadre
	 */
	public Integer getCodigoAreaTrabajoPadre() {
		return codigoAreaTrabajoPadre;
	}
	/**
	 * @param codigoAreaTrabajoPadre the codigoAreaTrabajoPadre to set
	 */
	public void setCodigoAreaTrabajoPadre(Integer codigoAreaTrabajoPadre) {
		this.codigoAreaTrabajoPadre = codigoAreaTrabajoPadre;
	}
	/**
	 * @return the codigoAreaTrabajoSeleccion
	 */
	public Integer getCodigoAreaTrabajoSeleccion() {
		return codigoAreaTrabajoSeleccion;
	}
	/**
	 * @param codigoAreaTrabajoSeleccion the codigoAreaTrabajoSeleccion to set
	 */
	public void setCodigoAreaTrabajoSeleccion(Integer codigoAreaTrabajoSeleccion) {
		this.codigoAreaTrabajoSeleccion = codigoAreaTrabajoSeleccion;
	}
	
}
