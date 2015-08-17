package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.TransaccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorEstadoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.PlantillaRespaldoCountTrasient;

/**
 * 
 * @author cherrera
 *
 */
@SuppressWarnings("serial")
public class AdminContenedorVO  extends BaseVO<ContenedorEstadoDTO>{
	private String accessItemId;
	private String systemId;
	private String userId;
	private String codigoBarrasBusqueda;
	private FuncionarioDTO funcionario = null;
	//Variable de navegacion
	private String vista;
	private Map<String, Object> filtrosMap = null;
	private String sortBy;
	private Integer currentPage;
	private Integer currentDetPage;
	private String imageSort = "unsorted";
	//Si el valor de la consulta de orden de compra es diferente de nulo y mayor a cero, se vuelve a consultar.
	private Integer valorConsulta = null;
	private Boolean integracionActiva;
	private Collection<ArticuloDTO> tipoContenedorCol= null;
	private Collection<CatalogoValorDTO> tipoEstadoCol= null;
	//Creacion
	private String mensajeExitoCreacion;
	//Transaccion seleccionada
	private TransaccionDTO tipoTransaccionSeleccionada;
	private String transaccionSeleccionada;
	private Collection<TransaccionDTO> tipoTransaccionCol;
	private Collection<TransaccionDTO> tipoTransaccionSsaLiqCol;
	//Variables para la busqueda de notificaciones
	private String catalogoValor;
	private Integer catalogoTipo;
	private String tipoContenedor;
	//Total items
	private Integer totalItems;
	//Total pedido
	private Integer totalCantidad;
	//Codigo de cada proceso del submenu
	private Long codigoProceso;
	//Tipo de pallet
	private String tipoPallet;
	//Plantilla de respaldo para la edicion
	private PlantillaRespaldoCountTrasient plantillaRespaldo;
	
	/**
	 * @return the tipoPallet
	 */
	public String getTipoPallet() {
		return tipoPallet;
	}

	/**
	 * @param tipoPallet the tipoPallet to set
	 */
	public void setTipoPallet(String tipoPallet) {
		this.tipoPallet = tipoPallet;
	}

	/**
	 * @return the tipoContenedor
	 */
	public String getTipoContenedor() {
		return tipoContenedor;
	}

	/**
	 * @param tipoContenedor the tipoContenedor to set
	 */
	public void setTipoContenedor(String tipoContenedor) {
		this.tipoContenedor = tipoContenedor;
	}

	public Long getCodigoProceso() {
		return codigoProceso;
	}

	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}

	/**
	 * @return the transaccionSeleccionada
	 */
	public String getTransaccionSeleccionada() {
		return transaccionSeleccionada;
	}

	/**
	 * @param transaccionSeleccionada the transaccionSeleccionada to set
	 */
	public void setTransaccionSeleccionada(String transaccionSeleccionada) {
		this.transaccionSeleccionada = transaccionSeleccionada;
	}

	/**
	 * @return the catalogoValor
	 */
	public String getCatalogoValor() {
		return catalogoValor;
	}

	/**
	 * @param catalogoValor the catalogoValor to set
	 */
	public void setCatalogoValor(String catalogoValor) {
		this.catalogoValor = catalogoValor;
	}

	/**
	 * @return the catalogoTipo
	 */
	public Integer getCatalogoTipo() {
		return catalogoTipo;
	}

	/**
	 * @param catalogoTipo the catalogoTipo to set
	 */
	public void setCatalogoTipo(Integer catalogoTipo) {
		this.catalogoTipo = catalogoTipo;
	}

	/**
	 * @return the mensajeExitoCreacion
	 */
	public String getMensajeExitoCreacion() {
		return mensajeExitoCreacion;
	}

	/**
	 * @param mensajeExitoCreacion the mensajeExitoCreacion to set
	 */
	public void setMensajeExitoCreacion(String mensajeExitoCreacion) {
		this.mensajeExitoCreacion = mensajeExitoCreacion;
	}

	/**
	 * @return the tipoEstadoCol
	 */
	public Collection<CatalogoValorDTO> getTipoEstadoCol() {
		return tipoEstadoCol;
	}

	/**
	 * @param tipoEstadoCol the tipoEstadoCol to set
	 */
	public void setTipoEstadoCol(Collection<CatalogoValorDTO> tipoEstadoCol) {
		this.tipoEstadoCol = tipoEstadoCol;
	}

	private String codigoProveedorCargado;
	
	/**
	 * @return the codigoProveedorCargado
	 */
	public String getCodigoProveedorCargado() {
		return codigoProveedorCargado;
	}

	/**
	 * @param codigoProveedorCargado the codigoProveedorCargado to set
	 */
	public void setCodigoProveedorCargado(String codigoProveedorCargado) {
		this.codigoProveedorCargado = codigoProveedorCargado;
	}

	/**
	 * @return the tipoContenedorCol
	 */
	public Collection<ArticuloDTO> getTipoContenedorCol() {
		return tipoContenedorCol;
	}

	/**
	 * @param tipoContenedorCol the tipoContenedorCol to set
	 */
	public void setTipoContenedorCol(Collection<ArticuloDTO> tipoContenedorCol) {
		this.tipoContenedorCol = tipoContenedorCol;
	}

	/**
	 * @return the integracionActiva
	 */
	public Boolean getIntegracionActiva() {
		return integracionActiva;
	}

	/**
	 * @param integracionActiva the integracionActiva to set
	 */
	public void setIntegracionActiva(Boolean integracionActiva) {
		this.integracionActiva = integracionActiva;
	}

	/**
	 * @return the valorConsulta
	 */
	public Integer getValorConsulta() {
		return valorConsulta;
	}

	/**
	 * @param valorConsulta the valorConsulta to set
	 */
	public void setValorConsulta(Integer valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	/**
	 * @return the imageSort
	 */
	public String getImageSort() {
		return imageSort;
	}

	/**
	 * @param imageSort the imageSort to set
	 */
	public void setImageSort(String imageSort) {
		this.imageSort = imageSort;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	/**
	 * @return the filtrosMap
	 */
	public Map<String, Object> getFiltrosMap() {
		return filtrosMap;
	}

	/**
	 * @param filtrosMap the filtrosMap to set
	 */
	public void setFiltrosMap(Map<String, Object> filtrosMap) {
		this.filtrosMap = filtrosMap;
	}

	public String getVista() {
		return vista;
	}

	public void setVista(String vista) {
		this.vista = vista;
	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccessItemId() {
		return accessItemId;
	}
	
	public void setAccessItemId(String accessItemId) {
		this.accessItemId = accessItemId;
	}
	
	public String getSystemId() {
		return systemId;
	}
	
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	

	public TransaccionDTO getTipoTransaccionSeleccionada() {
		return tipoTransaccionSeleccionada;
	}

	public void setTipoTransaccionSeleccionada(TransaccionDTO tipoTransaccionSeleccionada) {
		this.tipoTransaccionSeleccionada = tipoTransaccionSeleccionada;
	}

	public String getCodigoBarrasBusqueda() {
		return codigoBarrasBusqueda;
	}

	public void setCodigoBarrasBusqueda(String codigoBarrasBusqueda) {
		this.codigoBarrasBusqueda = codigoBarrasBusqueda;
	}
	
	/**
	 * @return the currentDetPage
	 */
	public Integer getCurrentDetPage() {
		return currentDetPage;
	}

	/**
	 * @param currentDetPage the currentDetPage to set
	 */
	public void setCurrentDetPage(Integer currentDetPage) {
		this.currentDetPage = currentDetPage;
	}
	
	/**
	 * @return the tipoTransaccionCol
	 */
	public Collection<TransaccionDTO> getTipoTransaccionCol() {
		return tipoTransaccionCol;
	}

	/**
	 * @param tipoTransaccionCol the tipoTransaccionCol to set
	 */
	public void setTipoTransaccionCol(Collection<TransaccionDTO> tipoTransaccionCol) {
		this.tipoTransaccionCol = tipoTransaccionCol;
	}

	public Collection<TransaccionDTO> getTipoTransaccionSsaLiqCol() {
		return tipoTransaccionSsaLiqCol;
	}

	public void setTipoTransaccionSsaLiqCol(Collection<TransaccionDTO> tipoTransaccionSsaLiqCol) {
		this.tipoTransaccionSsaLiqCol = tipoTransaccionSsaLiqCol;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public Integer getTotalCantidad() {
		return totalCantidad;
	}

	public void setTotalCantidad(Integer totalCantidad) {
		this.totalCantidad = totalCantidad;
	}
	
	public PlantillaRespaldoCountTrasient getPlantillaRespaldo() {
		return plantillaRespaldo;
	}

	public void setPlantillaRespaldo(PlantillaRespaldoCountTrasient plantillaRespaldo) {
		this.plantillaRespaldo = plantillaRespaldo;
	}

	
}
