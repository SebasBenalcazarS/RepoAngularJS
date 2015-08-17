package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.kruger.utilitario.dao.commons.hibernate.CriteriaSearchParameter;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaArticulo;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaMarca;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaProveedor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaAreaTrabajoDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaAreaTrabajoDetalleDTO;

/**
 * 
 * @author bsandoval
 *
 */
@SuppressWarnings({ "serial", "deprecation" })
public class PedidoFijoVO  extends BaseVO<PedidoPlantillaAreaTrabajoDTO>{
	private Collection<PedidoPlantillaAreaTrabajoDTO> pedidosPlantillaCol;
	private Collection<PedidoPlantillaAreaTrabajoDetalleDTO> pedidosPlantillaDetallesCrear;
	private Collection<PedidoPlantillaAreaTrabajoDetalleDTO> pedidosPlantillaDetallesModificar;
	private HashSet<String> nombresSubbodegasEncontradas;
	private PlantillaBusquedaArticulo plantillaBusquedaArticulo;
	private PlantillaBusquedaMarca plantillaBusquedaMarca;
	private PlantillaBusquedaProveedor plantillaBusquedaProveedor;
	private CriteriaSearchParameter<Object> descripcionProveedor;
	private Integer  codigoDia;
	LinkedHashMap<String, Collection<PedidoPlantillaAreaTrabajoDTO>> subBodegaArticuloPedPlantilla;
	private Collection<AreaTrabajoDTO> bodegas;
	private AreaTrabajoDTO centroDistribucion;
	private Long countResults;
	private Long countResultsVisualizacion;
	private String codigoBarras;
	private Collection<ArticuloUnidadManejoDTO> articulos;
	private String codigoFuncionario;
	private Integer codigoBodega;
	private Integer codigoSubBodega;
	private Collection<PedidoPlantillaAreaTrabajoDetalleDTO> pedidosPlantilla;
	private Integer codigoEstablecimiento;
	private String codigoArticulo;
	Collection<Integer> codigosLocales;
	private Boolean actualizacionPlantilla;
	private Boolean actualizarBusqueda;
	private Boolean busquedaBarra;
	
	/**
	 * @return the pedidosPlantillaCol
	 */
	public Collection<PedidoPlantillaAreaTrabajoDTO> getPedidosPlantillaCol() {
		return pedidosPlantillaCol;
	}

	/**
	 * @param pedidosPlantillaCol the pedidosPlantillaCol to set
	 */
	public void setPedidosPlantillaCol(Collection<PedidoPlantillaAreaTrabajoDTO> pedidosPlantillaCol) {
		this.pedidosPlantillaCol = pedidosPlantillaCol;
	}

	/**
	 * @return the nombresSubbodegasEncontradas
	 */
	public HashSet<String> getNombresSubbodegasEncontradas() {
		return nombresSubbodegasEncontradas;
	}

	/**
	 * @param nombresSubbodegasEncontradas the nombresSubbodegasEncontradas to set
	 */
	public void setNombresSubbodegasEncontradas(HashSet<String> nombresSubbodegasEncontradas) {
		this.nombresSubbodegasEncontradas = nombresSubbodegasEncontradas;
	}

	/**
	 * @return the plantillaBusquedaArticulo
	 */
	public PlantillaBusquedaArticulo getPlantillaBusquedaArticulo() {
		return plantillaBusquedaArticulo;
	}

	/**
	 * @param plantillaBusquedaArticulo the plantillaBusquedaArticulo to set
	 */
	public void setPlantillaBusquedaArticulo(PlantillaBusquedaArticulo plantillaBusquedaArticulo) {
		this.plantillaBusquedaArticulo = plantillaBusquedaArticulo;
	}

	/**
	 * @return the codigoDia
	 */
	public Integer getCodigoDia() {
		return codigoDia;
	}

	/**
	 * @param codigoDia the codigoDia to set
	 */
	public void setCodigoDia(Integer codigoDia) {
		this.codigoDia = codigoDia;
	}

	/**
	 * @return the subBodegaArticuloPedPlantilla
	 */
	public LinkedHashMap<String, Collection<PedidoPlantillaAreaTrabajoDTO>> getSubBodegaArticuloPedPlantilla() {
		return subBodegaArticuloPedPlantilla;
	}

	/**
	 * @param subBodegaArticuloPedPlantilla the subBodegaArticuloPedPlantilla to set
	 */
	public void setSubBodegaArticuloPedPlantilla(LinkedHashMap<String, Collection<PedidoPlantillaAreaTrabajoDTO>> subBodegaArticuloPedPlantilla) {
		this.subBodegaArticuloPedPlantilla = subBodegaArticuloPedPlantilla;
	}

	/**
	 * @return the bodegas
	 */
	public Collection<AreaTrabajoDTO> getBodegas() {
		return bodegas;
	}

	/**
	 * @param bodegas the bodegas to set
	 */
	public void setBodegas(Collection<AreaTrabajoDTO> bodegas) {
		this.bodegas = bodegas;
	}

	/**
	 * @return the centroDistribucion
	 */
	public AreaTrabajoDTO getCentroDistribucion() {
		return centroDistribucion;
	}

	/**
	 * @param centroDistribucion the centroDistribucion to set
	 */
	public void setCentroDistribucion(AreaTrabajoDTO centroDistribucion) {
		this.centroDistribucion = centroDistribucion;
	}

	/**
	 * @return the countResults
	 */
	public Long getCountResults() {
		return countResults;
	}

	/**
	 * @param countResults the countResults to set
	 */
	public void setCountResults(Long countResults) {
		this.countResults = countResults;
	}

	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}

	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * @return the articulos
	 */
	public Collection<ArticuloUnidadManejoDTO> getArticulos() {
		return articulos;
	}

	/**
	 * @param articulos the articulos to set
	 */
	public void setArticulos(Collection<ArticuloUnidadManejoDTO> articulos) {
		this.articulos = articulos;
	}

	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	/**
	 * @return the codigoSubbodega
	 */
	public Integer getCodigoBodega() {
		return codigoBodega;
	}

	/**
	 * @param codigoSubbodega the codigoSubbodega to set
	 */
	public void setCodigoBodega(Integer codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	

	/**
	 * @return the plantillaBusquedaMarca
	 */
	public PlantillaBusquedaMarca getPlantillaBusquedaMarca() {
		return plantillaBusquedaMarca;
	}

	/**
	 * @param plantillaBusquedaMarca the plantillaBusquedaMarca to set
	 */
	public void setPlantillaBusquedaMarca(PlantillaBusquedaMarca plantillaBusquedaMarca) {
		this.plantillaBusquedaMarca = plantillaBusquedaMarca;
	}

	/**
	 * @return the plantillaBusquedaProveedor
	 */
	public PlantillaBusquedaProveedor getPlantillaBusquedaProveedor() {
		return plantillaBusquedaProveedor;
	}

	/**
	 * @param plantillaBusquedaProveedor the plantillaBusquedaProveedor to set
	 */
	public void setPlantillaBusquedaProveedor(PlantillaBusquedaProveedor plantillaBusquedaProveedor) {
		this.plantillaBusquedaProveedor = plantillaBusquedaProveedor;
	}

	/**
	 * @return the descripcionProveedor
	 */
	public CriteriaSearchParameter<Object> getDescripcionProveedor() {
		return descripcionProveedor;
	}

	/**
	 * @param descripcionProveedor the descripcionProveedor to set
	 */
	public void setDescripcionProveedor(CriteriaSearchParameter<Object> descripcionProveedor) {
		this.descripcionProveedor = descripcionProveedor;
	}

	/**
	 * @return the pedidosPlantilla
	 */
	public Collection<PedidoPlantillaAreaTrabajoDetalleDTO> getPedidosPlantilla() {
		return pedidosPlantilla;
	}

	/**
	 * @param pedidosPlantilla the pedidosPlantilla to set
	 */
	public void setPedidosPlantilla(Collection<PedidoPlantillaAreaTrabajoDetalleDTO> pedidosPlantilla) {
		this.pedidosPlantilla = pedidosPlantilla;
	}

	/**
	 * @return the codigoEstablecimiento
	 */
	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}

	/**
	 * @param codigoEstablecimiento the codigoEstablecimiento to set
	 */
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
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
	 * @return the codigosLocales
	 */
	public Collection<Integer> getCodigosLocales() {
		return codigosLocales;
	}

	/**
	 * @param codigosLocales the codigosLocales to set
	 */
	public void setCodigosLocales(Collection<Integer> codigosLocales) {
		this.codigosLocales = codigosLocales;
	}

	/**
	 * @return the pedidosPlantillaDetallesCrear
	 */
	public Collection<PedidoPlantillaAreaTrabajoDetalleDTO> getPedidosPlantillaDetallesCrear() {
		return pedidosPlantillaDetallesCrear;
	}

	/**
	 * @param pedidosPlantillaDetallesCrear the pedidosPlantillaDetallesCrear to set
	 */
	public void setPedidosPlantillaDetallesCrear(Collection<PedidoPlantillaAreaTrabajoDetalleDTO> pedidosPlantillaDetallesCrear) {
		this.pedidosPlantillaDetallesCrear = pedidosPlantillaDetallesCrear;
	}

	/**
	 * @return the pedidosPlantillaDetallesModificar
	 */
	public Collection<PedidoPlantillaAreaTrabajoDetalleDTO> getPedidosPlantillaDetallesModificar() {
		return pedidosPlantillaDetallesModificar;
	}

	/**
	 * @param pedidosPlantillaDetallesModificar the pedidosPlantillaDetallesModificar to set
	 */
	public void setPedidosPlantillaDetallesModificar(Collection<PedidoPlantillaAreaTrabajoDetalleDTO> pedidosPlantillaDetallesModificar) {
		this.pedidosPlantillaDetallesModificar = pedidosPlantillaDetallesModificar;
	}

	/**
	 * @return the codigoSubBodega
	 */
	public Integer getCodigoSubBodega() {
		return codigoSubBodega;
	}

	/**
	 * @param codigoSubBodega the codigoSubBodega to set
	 */
	public void setCodigoSubBodega(Integer codigoSubBodega) {
		this.codigoSubBodega = codigoSubBodega;
	}

	public Boolean getActualizacionPlantilla() {
		return actualizacionPlantilla;
	}

	public void setActualizacionPlantilla(Boolean actualizacionPlantilla) {
		this.actualizacionPlantilla = actualizacionPlantilla;
	}

	public Boolean getActualizarBusqueda() {
		return actualizarBusqueda;
	}

	public void setActualizarBusqueda(Boolean actualizarBusqueda) {
		this.actualizarBusqueda = actualizarBusqueda;
	}

	public Long getCountResultsVisualizacion() {
		return countResultsVisualizacion;
	}

	public void setCountResultsVisualizacion(Long countResultsVisualizacion) {
		this.countResultsVisualizacion = countResultsVisualizacion;
	}

	public Boolean getBusquedaBarra() {
		return busquedaBarra;
	}

	public void setBusquedaBarra(Boolean busquedaBarra) {
		this.busquedaBarra = busquedaBarra;
	}
	
	
}
