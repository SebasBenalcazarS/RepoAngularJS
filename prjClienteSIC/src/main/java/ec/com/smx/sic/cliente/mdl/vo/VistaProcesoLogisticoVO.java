package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.common.search.bean.ISearchTemplate;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;

@SuppressWarnings({ "serial", "deprecation" })
public class VistaProcesoLogisticoVO extends BaseVO<VistaProcesoLogisticoDTO> {
	
	private Collection<VistaProcesoLogisticoDTO> vistasProcesosLogisticos;
	private Long cantidadPaletsRecibidos;
	private Long cantidadPaletsUbicados;
	private Long cantidadPaletsEnAndenes;
	private Long cantidadPaletsTransitoPasillo;
	private Long cantidadPaletsCancelados;
	private Long cantidadPaletsEnProceso;
	private Long cantidadTotalProveedores;
	private Long cantidadTotalPedida;
	private Long cantidadTotalPlanificada;
	private Long cantidadTotalRecibida;
	
	//Campos para las busquedas se utilizan en la paginacion de resultados
	private Integer codigoCompania;
	private String codigoJdeProveedor; 
	private String nombreProveedor;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubBodega;
	private Date fechaSeleccionada;
	private String tipoRecepcion;
	private String estadoProcesoLogistico;
	// buscar las recepciones del dia o de anteriores dias y pendientes del dia  
	private Boolean traerRecepcionesAnteriores;
	
	// Paginacion de resultados
	private Integer totalRegistros;
	
	// Plantilla de busqueda para usar criteria en la consulta
	private Collection<ISearchTemplate> plantillasBusqueda;
	
	public Collection<VistaProcesoLogisticoDTO> getVistasProcesosLogisticos() {
		return vistasProcesosLogisticos;
	}
	
	public void setVistasProcesosLogisticos(Collection<VistaProcesoLogisticoDTO> vistasProcesosLogisticos) {
		this.vistasProcesosLogisticos = vistasProcesosLogisticos;
	}
	
	public Long getCantidadPaletsRecibidos() {
		return cantidadPaletsRecibidos;
	}
	
	public void setCantidadPaletsRecibidos(Long cantidadPaletsRecibidos) {
		this.cantidadPaletsRecibidos = cantidadPaletsRecibidos;
	}
	
	public Long getCantidadPaletsUbicados() {
		return cantidadPaletsUbicados;
	}
	
	public void setCantidadPaletsUbicados(Long cantidadPaletsUbicados) {
		this.cantidadPaletsUbicados = cantidadPaletsUbicados;
	}
	
	public Long getCantidadPaletsEnAndenes() {
		return cantidadPaletsEnAndenes;
	}
	
	public void setCantidadPaletsEnAndenes(Long cantidadPaletsEnAndenes) {
		this.cantidadPaletsEnAndenes = cantidadPaletsEnAndenes;
	}

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
	 * @return the codigoJdeProveedor
	 */
	public String getCodigoJdeProveedor() {
		return codigoJdeProveedor;
	}

	/**
	 * @param codigoJdeProveedor the codigoJdeProveedor to set
	 */
	public void setCodigoJdeProveedor(String codigoJdeProveedor) {
		this.codigoJdeProveedor = codigoJdeProveedor;
	}

	/**
	 * @return the nombreProveedor
	 */
	public String getNombreProveedor() {
		return nombreProveedor;
	}

	/**
	 * @param nombreProveedor the nombreProveedor to set
	 */
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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
	 * @return the fechaSeleccionada
	 */
	public Date getFechaSeleccionada() {
		return fechaSeleccionada;
	}

	/**
	 * @param fechaSeleccionada the fechaSeleccionada to set
	 */
	public void setFechaSeleccionada(Date fechaSeleccionada) {
		this.fechaSeleccionada = fechaSeleccionada;
	}

	/**
	 * @return the tipoRecepcion
	 */
	public String getTipoRecepcion() {
		return tipoRecepcion;
	}

	/**
	 * @param tipoRecepcion the tipoRecepcion to set
	 */
	public void setTipoRecepcion(String tipoRecepcion) {
		this.tipoRecepcion = tipoRecepcion;
	}

	/**
	 * @return the estadoProcesoLogistico
	 */
	public String getEstadoProcesoLogistico() {
		return estadoProcesoLogistico;
	}

	/**
	 * @param estadoProcesoLogistico the estadoProcesoLogistico to set
	 */
	public void setEstadoProcesoLogistico(String estadoProcesoLogistico) {
		this.estadoProcesoLogistico = estadoProcesoLogistico;
	}

	/**
	 * @return the traerRecepcionesAnteriores
	 */
	public Boolean getTraerRecepcionesAnteriores() {
		return traerRecepcionesAnteriores;
	}

	/**
	 * @param traerRecepcionesAnteriores the traerRecepcionesAnteriores to set
	 */
	public void setTraerRecepcionesAnteriores(Boolean traerRecepcionesAnteriores) {
		this.traerRecepcionesAnteriores = traerRecepcionesAnteriores;
	}

	/**
	 * @return the cantidadPaletsTransitoPasillo
	 */
	public Long getCantidadPaletsTransitoPasillo() {
		return cantidadPaletsTransitoPasillo;
	}

	/**
	 * @param cantidadPaletsTransitoPasillo the cantidadPaletsTransitoPasillo to set
	 */
	public void setCantidadPaletsTransitoPasillo(Long cantidadPaletsTransitoPasillo) {
		this.cantidadPaletsTransitoPasillo = cantidadPaletsTransitoPasillo;
	}

	/**
	 * @return the cantidadPaletsEnProceso
	 */
	public Long getCantidadPaletsEnProceso() {
		return cantidadPaletsEnProceso;
	}

	/**
	 * @param cantidadPaletsEnProceso the cantidadPaletsEnProceso to set
	 */
	public void setCantidadPaletsEnProceso(Long cantidadPaletsEnProceso) {
		this.cantidadPaletsEnProceso = cantidadPaletsEnProceso;
	}

	/**
	 * @return the cantidadPaletsCancelados
	 */
	public Long getCantidadPaletsCancelados() {
		return cantidadPaletsCancelados;
	}

	/**
	 * @param cantidadPaletsCancelados the cantidadPaletsCancelados to set
	 */
	public void setCantidadPaletsCancelados(Long cantidadPaletsCancelados) {
		this.cantidadPaletsCancelados = cantidadPaletsCancelados;
	}

	/**
	 * @return the cantidadTotalProveedores
	 */
	public Long getCantidadTotalProveedores() {
		return cantidadTotalProveedores;
	}

	/**
	 * @param cantidadTotalProveedores the cantidadTotalProveedores to set
	 */
	public void setCantidadTotalProveedores(Long cantidadTotalProveedores) {
		this.cantidadTotalProveedores = cantidadTotalProveedores;
	}

	public Long getCantidadTotalPedida() {
		return cantidadTotalPedida;
	}

	public void setCantidadTotalPedida(Long cantidadTotalPedida) {
		this.cantidadTotalPedida = cantidadTotalPedida;
	}

	public Long getCantidadTotalPlanificada() {
		return cantidadTotalPlanificada;
	}

	public void setCantidadTotalPlanificada(Long cantidadTotalPlanificada) {
		this.cantidadTotalPlanificada = cantidadTotalPlanificada;
	}

	public Long getCantidadTotalRecibida() {
		return cantidadTotalRecibida;
	}

	public void setCantidadTotalRecibida(Long cantidadTotalRecibida) {
		this.cantidadTotalRecibida = cantidadTotalRecibida;
	}

	/**
	 * @return the plantillasBusqueda
	 */
	public Collection<ISearchTemplate> getPlantillasBusqueda() {
		return plantillasBusqueda;
	}

	/**
	 * @param plantillasBusqueda the plantillasBusqueda to set
	 */
	public void setPlantillasBusqueda(Collection<ISearchTemplate> plantillasBusqueda) {
		this.plantillasBusqueda = plantillasBusqueda;
	}
	
	
}
