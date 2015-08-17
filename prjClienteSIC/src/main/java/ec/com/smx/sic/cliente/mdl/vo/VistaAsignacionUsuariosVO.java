package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.mdl.dto.VistaAsignacionUsuariosBodegaDTO;

@SuppressWarnings({"serial","deprecation"})
public class VistaAsignacionUsuariosVO extends BaseVO<VistaAsignacionUsuariosBodegaDTO>{
	
	private Collection<VistaAsignacionUsuariosBodegaDTO> colAsignacionUsuarios;

	//Filtros area trabajo
	private Integer codigoCompania;
	private Integer codigoAreaTrabajo;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubBodega;
	//Filtros proceso
	private Long codigoProceso;
	private String codigoPerfil;
	private String estadoUsuario;
	private String estadoActualUsuario;
	//Filtros usuarios
	private String usuario;
	private String nombreUsuario;
	// Paginacion de resultados
	private Integer totalRegistros;
	
	DynamicCriteriaRestriction plantillaBusqueda;

	/**
	 * @return the totalRegistros
	 */
	public Integer getTotalRegistros() {
		return totalRegistros;
	}

	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
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

	/**
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}

	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}

	/**
	 * @return the codigoAreaTrabajoSubBodega
	 */
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}

	/**
	 * @param codigoAreaTrabajoSubBodega the codigoAreaTrabajoSubBodega to set
	 */
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nombreUsuario 
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the colAsignacionUsuarios
	 */
	public Collection<VistaAsignacionUsuariosBodegaDTO> getColAsignacionUsuarios() {
		return colAsignacionUsuarios;
	}

	/**
	 * @param colAsignacionUsuarios the colAsignacionUsuarios to set
	 */
	public void setColAsignacionUsuarios(Collection<VistaAsignacionUsuariosBodegaDTO> colAsignacionUsuarios) {
		this.colAsignacionUsuarios = colAsignacionUsuarios;
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
	 * @return the estadoUsuario
	 */
	public String getEstadoUsuario() {
		return estadoUsuario;
	}

	/**
	 * @param estadoUsuario the estadoUsuario to set
	 */
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	/**
	 * @return the estadoActualUsuario
	 */
	public String getEstadoActualUsuario() {
		return estadoActualUsuario;
	}

	/**
	 * @param estadoActualUsuario the estadoActualUsuario to set
	 */
	public void setEstadoActualUsuario(String estadoActualUsuario) {
		this.estadoActualUsuario = estadoActualUsuario;
	}

	/**
	 * @return the codigoPerfil
	 */
	public String getCodigoPerfil() {
		return codigoPerfil;
	}

	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(String codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	/**
	 * @return the plantillaBusqueda
	 */
	public DynamicCriteriaRestriction getPlantillaBusqueda() {
		return plantillaBusqueda;
	}

	/**
	 * @param plantillaBusqueda the plantillaBusqueda to set
	 */
	public void setPlantillaBusqueda(DynamicCriteriaRestriction plantillaBusqueda) {
		this.plantillaBusqueda = plantillaBusqueda;
	}

	
}
