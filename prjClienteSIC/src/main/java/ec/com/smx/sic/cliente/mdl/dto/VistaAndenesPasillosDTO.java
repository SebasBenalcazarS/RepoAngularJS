package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaAndenesPasillosID;

@Entity
@SuppressWarnings("serial")
public class VistaAndenesPasillosDTO extends SearchDTO{
	
	@EmbeddedId
	private VistaAndenesPasillosID id = new VistaAndenesPasillosID();
	
	/**
	 *
	 * Especifica el codigo de la seccion
	 */
	private java.lang.Long codigoSeccion ;

	/**
	 * Nombre de la secci�n
	 * 
	 */
	private String nombre ;
	
	/**
	 * Especifica el nombre del detalle de la seccion
	 *
	 */
	private String descripcion ;

	/**
	 * Especifica el orden del detalle de la seccion
	 *
	 */
	private Integer orden ;
	
	/**
	 * Indica el estado del registro:[1] activo [0] inactivo
	 *
	 */
	private String estado ;

	/**
	 * @return the id
	 */
	public VistaAndenesPasillosID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaAndenesPasillosID id) {
		this.id = id;
	}

	/**
	 * @return the codigoSeccion
	 */
	public java.lang.Long getCodigoSeccion() {
		return codigoSeccion;
	}

	/**
	 * @param codigoSeccion the codigoSeccion to set
	 */
	public void setCodigoSeccion(java.lang.Long codigoSeccion) {
		this.codigoSeccion = codigoSeccion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
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
}
