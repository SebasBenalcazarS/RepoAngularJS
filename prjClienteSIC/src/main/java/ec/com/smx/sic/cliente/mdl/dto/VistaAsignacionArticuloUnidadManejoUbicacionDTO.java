package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaAsignacionArticuloUnidadManejoUbicacionID;

@Entity
public class VistaAsignacionArticuloUnidadManejoUbicacionDTO {
	@EmbeddedId
	VistaAsignacionArticuloUnidadManejoUbicacionID id = new VistaAsignacionArticuloUnidadManejoUbicacionID();
	//Campos AsignacionArtUniMan
	private Long cantidad;
	private String lote;
	private Long costoNeto;
	//Campos DetalleSeccion
	private Long codigoSeccion;
	private String nombre;
	private String descripcion;
	private String valorTipoAlmacenamiento;
	private Integer codigoTipoAlmacenamiento;
	private String identificador;
	//Campos Seccion
	private Integer codigoAreaTrabajo;
	//Campos Unidad Manejo
	private Long codigoUnidadManejoPadre;
	
	/**
	 * @return the cantidad
	 */
	public Long getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the lote
	 */
	public String getLote() {
		return lote;
	}
	/**
	 * @param lote the lote to set
	 */
	public void setLote(String lote) {
		this.lote = lote;
	}
	/**
	 * @return the costoNeto
	 */
	public Long getCostoNeto() {
		return costoNeto;
	}
	/**
	 * @param costoNeto the costoNeto to set
	 */
	public void setCostoNeto(Long costoNeto) {
		this.costoNeto = costoNeto;
	}
	/**
	 * @return the codigoSeccion
	 */
	public Long getCodigoSeccion() {
		return codigoSeccion;
	}
	/**
	 * @param codigoSeccion the codigoSeccion to set
	 */
	public void setCodigoSeccion(Long codigoSeccion) {
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
	 * @return the valorTipoAlmacenamiento
	 */
	public String getValorTipoAlmacenamiento() {
		return valorTipoAlmacenamiento;
	}
	/**
	 * @param valorTipoAlmacenamiento the valorTipoAlmacenamiento to set
	 */
	public void setValorTipoAlmacenamiento(String valorTipoAlmacenamiento) {
		this.valorTipoAlmacenamiento = valorTipoAlmacenamiento;
	}
	/**
	 * @return the codigoTipoAlmacenamiento
	 */
	public Integer getCodigoTipoAlmacenamiento() {
		return codigoTipoAlmacenamiento;
	}
	/**
	 * @param codigoTipoAlmacenamiento the codigoTipoAlmacenamiento to set
	 */
	public void setCodigoTipoAlmacenamiento(Integer codigoTipoAlmacenamiento) {
		this.codigoTipoAlmacenamiento = codigoTipoAlmacenamiento;
	}
	/**
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}
	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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
	public VistaAsignacionArticuloUnidadManejoUbicacionID getId() {
		return id;
	}
	public void setId(VistaAsignacionArticuloUnidadManejoUbicacionID id) {
		this.id = id;
	}
	/**
	 * @return the codigoUnidadManejoPadre
	 */
	public Long getCodigoUnidadManejoPadre() {
		return codigoUnidadManejoPadre;
	}
	/**
	 * @param codigoUnidadManejoPadre the codigoUnidadManejoPadre to set
	 */
	public void setCodigoUnidadManejoPadre(Long codigoUnidadManejoPadre) {
		this.codigoUnidadManejoPadre = codigoUnidadManejoPadre;
	}
		
}

