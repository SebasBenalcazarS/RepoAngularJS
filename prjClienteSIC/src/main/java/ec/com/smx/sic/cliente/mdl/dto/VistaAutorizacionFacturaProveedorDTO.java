package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaAutorizacionFacturaProveedorID;

@Entity
public class VistaAutorizacionFacturaProveedorDTO {
	@EmbeddedId
	VistaAutorizacionFacturaProveedorID id = new VistaAutorizacionFacturaProveedorID();

	private String numeroAutorizacion;
	private Date fechaCaducidad;
	private String estado;
	private Integer estadoTipo;
	private Long codigoProceso;
	
	
	/**
	 * @return the numeroAutorizacion
	 */
	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}
	/**
	 * @param numeroAutorizacion the numeroAutorizacion to set
	 */
	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
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
	 * @return the estadoTipo
	 */
	public Integer getEstadoTipo() {
		return estadoTipo;
	}
	/**
	 * @param estadoTipo the estadoTipo to set
	 */
	public void setEstadoTipo(Integer estadoTipo) {
		this.estadoTipo = estadoTipo;
	}
	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}
	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}
	/**
	 * @return the id
	 */
	public VistaAutorizacionFacturaProveedorID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaAutorizacionFacturaProveedorID id) {
		this.id = id;
	}
	/**
	 * @return the fechaCaducidad
	 */
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
	/**
	 * @param fechaCaducidad the fechaCaducidad to set
	 */
	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
		
}

