/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * @author jvasquez
 *
 */
@SuppressWarnings("serial")
@Entity
public class VistaNovedadArticuloRecepcionDTO extends SearchDTO{
	
	@Id
	private Long codigoNovedadArticulo;
	
	private String codigoBarrasArticulo;
	private String codigoArticulo;
	private String descripcionArticulo;
	private String novedad;
	private String codigosUnidadesManejo;
	@Transient
	private Collection<NovedadArticuloJustificacionUnidadManejoDTO> unidadesManejoCol;
	private String codigosProveedores;
	@Transient
	private Collection<NovedadArticuloJustificacionProveedorDTO> proveedoresCol;
	private Date fechaRegistro;
	private String idUsuarioRegistro;
	private String areaTrabajo;
	@Transient
	private Boolean mostrarIconoAgregar = Boolean.FALSE;
	
	/*****************************************************************************************************************
	 * SETTERS & GETTERS 
	 *****************************************************************************************************************/
	
	/**
	 * @return the codigoNovedadArticulo
	 */
	public Long getCodigoNovedadArticulo() {
		return codigoNovedadArticulo;
	}
	/**
	 * @param codigoNovedadArticulo the codigoNovedadArticulo to set
	 */
	public void setCodigoNovedadArticulo(Long codigoNovedadArticulo) {
		this.codigoNovedadArticulo = codigoNovedadArticulo;
	}
	/**
	 * @return the codigoBarrasArticulo
	 */
	public String getCodigoBarrasArticulo() {
		return codigoBarrasArticulo;
	}
	/**
	 * @param codigoBarrasArticulo the codigoBarrasArticulo to set
	 */
	public void setCodigoBarrasArticulo(String codigoBarrasArticulo) {
		this.codigoBarrasArticulo = codigoBarrasArticulo;
	}
	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	/**
	 * @return the novedad
	 */
	public String getNovedad() {
		return novedad;
	}
	/**
	 * @param novedad the novedad to set
	 */
	public void setNovedad(String novedad) {
		this.novedad = novedad;
	}
	/**
	 * @return the codigosUnidadesManejo
	 */
	public String getCodigosUnidadesManejo() {
		return codigosUnidadesManejo;
	}
	/**
	 * @param codigosUnidadesManejo the codigosUnidadesManejo to set
	 */
	public void setCodigosUnidadesManejo(String codigosUnidadesManejo) {
		this.codigosUnidadesManejo = codigosUnidadesManejo;
	}
	/**
	 * @return the unidadesManejoCol
	 */
	public Collection<NovedadArticuloJustificacionUnidadManejoDTO> getUnidadesManejoCol() {
		return unidadesManejoCol;
	}
	/**
	 * @param unidadesManejoCol the unidadesManejoCol to set
	 */
	public void setUnidadesManejoCol(Collection<NovedadArticuloJustificacionUnidadManejoDTO> unidadesManejoCol) {
		this.unidadesManejoCol = unidadesManejoCol;
	}
	/**
	 * @return the codigosProveedores
	 */
	public String getCodigosProveedores() {
		return codigosProveedores;
	}
	/**
	 * @param codigosProveedores the codigosProveedores to set
	 */
	public void setCodigosProveedores(String codigosProveedores) {
		this.codigosProveedores = codigosProveedores;
	}
	
	/**
	 * @return the proveedoresCol
	 */
	public Collection<NovedadArticuloJustificacionProveedorDTO> getProveedoresCol() {
		return proveedoresCol;
	}
	/**
	 * @param proveedoresCol the proveedoresCol to set
	 */
	public void setProveedoresCol(Collection<NovedadArticuloJustificacionProveedorDTO> proveedoresCol) {
		this.proveedoresCol = proveedoresCol;
	}
	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}
	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}
	/**
	 * @return the areaTrabajo
	 */
	public String getAreaTrabajo() {
		return areaTrabajo;
	}
	/**
	 * @param areaTrabajo the areaTrabajo to set
	 */
	public void setAreaTrabajo(String areaTrabajo) {
		this.areaTrabajo = areaTrabajo;
	}
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the mostrarIconoAgregar
	 */
	public Boolean getMostrarIconoAgregar() {
		return mostrarIconoAgregar;
	}
	/**
	 * @param mostrarIconoAgregar the mostrarIconoAgregar to set
	 */
	public void setMostrarIconoAgregar(Boolean mostrarIconoAgregar) {
		this.mostrarIconoAgregar = mostrarIconoAgregar;
	}
	
	
}
