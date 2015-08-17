package ec.com.smx.sic.cliente.mdl.vo;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.SeccionDTO;

/**
 * @author dalmeida
 *
 */
@SuppressWarnings("serial")
public class SeccionVO extends BaseVO<SeccionDTO> {
	private Boolean contarSubDetalleSeccion = Boolean.FALSE;
	private Boolean contarPasillos = Boolean.FALSE;
	private Boolean contarAndenesPasillos = Boolean.FALSE;
	private Boolean nivelPadres = Boolean.FALSE;
	private Boolean mostrarJerarquia = Boolean.FALSE;
	private Boolean obtenerRelacionSeccion = Boolean.FALSE;
	private Long codigoDetalleSeccionPadre;
	private Boolean asignadoUbicacion = Boolean.FALSE;
	
	/**
	 * @return the contarSubDetalleSeccion
	 */
	public Boolean getContarSubDetalleSeccion() {
		return contarSubDetalleSeccion;
	}
	/**
	 * @param contarSubDetalleSeccion the contarSubDetalleSeccion to set
	 */
	public void setContarSubDetalleSeccion(Boolean contarSubDetalleSeccion) {
		this.contarSubDetalleSeccion = contarSubDetalleSeccion;
	}
	/**
	 * @return the nivelPadres
	 */
	public Boolean getNivelPadres() {
		return nivelPadres;
	}
	/**
	 * @param nivelPadres the nivelPadres to set
	 */
	public void setNivelPadres(Boolean nivelPadres) {
		this.nivelPadres = nivelPadres;
	}
	/**
	 * @return the mostrarJerarquia
	 */
	public Boolean getMostrarJerarquia() {
		return mostrarJerarquia;
	}
	/**
	 * @param mostrarJerarquia the mostrarJerarquia to set
	 */
	public void setMostrarJerarquia(Boolean mostrarJerarquia) {
		this.mostrarJerarquia = mostrarJerarquia;
	}
	/**
	 * @return the obtenerRelacionSeccion
	 */
	public Boolean getObtenerRelacionSeccion() {
		return obtenerRelacionSeccion;
	}
	/**
	 * @param obtenerRelacionSeccion the obtenerRelacionSeccion to set
	 */
	public void setObtenerRelacionSeccion(Boolean obtenerRelacionSeccion) {
		this.obtenerRelacionSeccion = obtenerRelacionSeccion;
	}
	/**
	 * @return the codigoDetalleSeccionPadre
	 */
	public Long getCodigoDetalleSeccionPadre() {
		return codigoDetalleSeccionPadre;
	}
	/**
	 * @param codigoDetalleSeccionPadre the codigoDetalleSeccionPadre to set
	 */
	public void setCodigoDetalleSeccionPadre(Long codigoDetalleSeccionPadre) {
		this.codigoDetalleSeccionPadre = codigoDetalleSeccionPadre;
	}
	/**
	 * @return the asignadoUbicacion
	 */
	public Boolean getAsignadoUbicacion() {
		return asignadoUbicacion;
	}
	/**
	 * @param asignadoUbicacion the asignadoUbicacion to set
	 */
	public void setAsignadoUbicacion(Boolean asignadoUbicacion) {
		this.asignadoUbicacion = asignadoUbicacion;
	}
	public Boolean getContarPasillos() {
		return contarPasillos;
	}
	public void setContarPasillos(Boolean contarPasillos) {
		this.contarPasillos = contarPasillos;
	}
	/**
	 * @return the contarAndenesPasillos
	 */
	public Boolean getContarAndenesPasillos() {
		return contarAndenesPasillos;
	}
	/**
	 * @param contarAndenesPasillos the contarAndenesPasillos to set
	 */
	public void setContarAndenesPasillos(Boolean contarAndenesPasillos) {
		this.contarAndenesPasillos = contarAndenesPasillos;
	}
	
}
