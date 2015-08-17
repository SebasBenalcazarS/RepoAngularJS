package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaPerchasArticulosID;

@Entity
@SuppressWarnings("serial")
public class VistaPerchasArticulosDTO extends SearchDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.VistaPerchasArticulosID id = new ec.com.smx.sic.cliente.mdl.dto.id.VistaPerchasArticulosID();
	
	//@Transient
	private Integer cantidad;
	
	@Transient
	private String userId;
	
	/**
	 * @return the id
	 */
	public VistaPerchasArticulosID getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(VistaPerchasArticulosID id) {
		this.id = id;
	}
	
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
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
	
}
