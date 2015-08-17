package ec.com.smx.sic.cliente.mdl.vo;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioLineaComercial;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioTipoMarca;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.corpv2.dto.MonedaDTO;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaArticulo;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaDTO;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class PlantillaOrdenCompraVO extends BaseVO<PedidoPlantillaDTO>{
	
	//Relaciones 
	private Collection<PedidoPlantillaDetalleDTO> pedidoPlantillaDetalleCol;
	private Collection<Long> codigosLineasComercialesCol = null;
	private LinkedHashMap<String, Collection<PedidoPlantillaDetalleDTO>> proveedorArticuloPedPlantilla;

	//Mensajes
	private String mensajeExitoCreacion;
	private String vista;
	private Integer currentPage;
	private Integer currentDetPage;
	
	//Collecciones de Objetos
	private Collection<BodegaDTO> bodegasCol = null;
	private List<List<String>> dias = null;
	private Map<String, Object> filtrosMap = null;
	private Collection<VistaProveedorDTO> vistaProveedorDTOCol = null;
	
	//Objetos
	private FuncionarioDTO funcionario = null;
	private PlantillaBusquedaArticulo plantillaBusquedaArticulo;
	private Boolean esProveedorImportado;
	private Integer valorConsulta = null;
	private PedidoPlantillaDTO pedidoPltlPlantilla;
	private String sortBy;
	
	//Items
	private String codigoProveedor;
	private String codigoBarras;
	
	//Totales
	private Integer cantidadTotalPedida;
	private BigDecimal pesoTotalPedido;
	private Integer cantidadItems;
	
	//Campos creación orden compra
	private String observacion;
	private Date fechaEntrega;
	private Date fechaCaducidad;
	private Date fechaPublicacion;
	private Date fechaSugerido;
	private String urlReporte;
	private Integer codigoOrigenCatTip;
	private String codigoOrigenCatVal;
	
	//Bandera de activación de la integración de datos del artículo desde el SIC.
	private Boolean integracionActiva;
	
	//Cambio de moneda
	private Long codigoMoneda;
	private Double valorCambioMoneda;
	private MonedaDTO monedaDTO;
	
	//Area de trabajo orden de compra
	private AreaTrabajoDTO areaTrabajoDestino;
	
	//Id session
	private String identificadorArchivoSesion;
		
	//Tipos de marcas por usuario
	private Collection<InformacionFuncionarioTipoMarca> funcionarioTipoMarcaCol;
	
	//Lineas comerciales del funcionario
	private Collection<InformacionFuncionarioLineaComercial> funcionarioLineaComercialCol;
	
	//No B2B
	private Boolean noB2B;
	
	//paginacion
		private int currentPageArticulo;
		
		
	/*GETTERS AND SETTERS*/
	/**
	 * @return the pedidoPlantillaDetalleCol
	 */
	public Collection<PedidoPlantillaDetalleDTO> getPedidoPlantillaDetalleCol() {
		return pedidoPlantillaDetalleCol;
	}

	/**
	 * @param pedidoPlantillaDetalleCol the pedidoPlantillaDetalleCol to set
	 */
	public void setPedidoPlantillaDetalleCol(Collection<PedidoPlantillaDetalleDTO> pedidoPlantillaDetalleCol) {
		this.pedidoPlantillaDetalleCol = pedidoPlantillaDetalleCol;
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
	 * @return the vista
	 */
	public String getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(String vista) {
		this.vista = vista;
	}

	/**
	 * @return the codigosLineasComercialesCol
	 */
	public Collection<Long> getCodigosLineasComercialesCol() {
		return codigosLineasComercialesCol;
	}

	/**
	 * @param codigosLineasComercialesCol the codigosLineasComercialesCol to set
	 */
	public void setCodigosLineasComercialesCol(Collection<Long> codigosLineasComercialesCol) {
		this.codigosLineasComercialesCol = codigosLineasComercialesCol;
	}

	public Collection<BodegaDTO> getBodegasCol() {
		return bodegasCol;
	}

	public void setBodegasCol(Collection<BodegaDTO> bodegasCol) {
		this.bodegasCol = bodegasCol;
	}

	public List<List<String>> getDias() {
		return dias;
	}

	public void setDias(List<List<String>> dias) {
		this.dias = dias;
	}

	/**
	 * @return the funcionario
	 */
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	/**
	 * @return the proveedorArticuloPedPlantilla
	 */
	public LinkedHashMap<String, Collection<PedidoPlantillaDetalleDTO>> getProveedorArticuloPedPlantilla() {
		return proveedorArticuloPedPlantilla;
	}

	/**
	 * @param proveedorArticuloPedPlantilla the proveedorArticuloPedPlantilla to set
	 */
	public void setProveedorArticuloPedPlantilla(LinkedHashMap<String, Collection<PedidoPlantillaDetalleDTO>> proveedorArticuloPedPlantilla) {
		this.proveedorArticuloPedPlantilla = proveedorArticuloPedPlantilla;
	}

	/**
	 * @return the cantidadTotalPedida
	 */
	public Integer getCantidadTotalPedida() {
		return cantidadTotalPedida;
	}

	/**
	 * @param cantidadTotalPedida the cantidadTotalPedida to set
	 */
	public void setCantidadTotalPedida(Integer cantidadTotalPedida) {
		this.cantidadTotalPedida = cantidadTotalPedida;
	}

	/**
	 * @return the pesoTotalPedido
	 */
	public BigDecimal getPesoTotalPedido() {
		return pesoTotalPedido;
	}

	/**
	 * @param pesoTotalPedido the pesoTotalPedido to set
	 */
	public void setPesoTotalPedido(BigDecimal pesoTotalPedido) {
		this.pesoTotalPedido = pesoTotalPedido;
	}

	/**
	 * @return the cantidadItems
	 */
	public Integer getCantidadItems() {
		return cantidadItems;
	}

	/**
	 * @param cantidadItems the cantidadItems to set
	 */
	public void setCantidadItems(Integer cantidadItems) {
		this.cantidadItems = cantidadItems;
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
	 * @return the esProveedorImportado
	 */
	public Boolean getEsProveedorImportado() {
		return esProveedorImportado;
	}

	/**
	 * @param esProveedorImportado the esProveedorImportado to set
	 */
	public void setEsProveedorImportado(Boolean esProveedorImportado) {
		this.esProveedorImportado = esProveedorImportado;
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
	 * @return the pedidoPltlPlantilla
	 */
	public PedidoPlantillaDTO getPedidoPltlPlantilla() {
		return pedidoPltlPlantilla;
	}

	/**
	 * @param pedidoPltlPlantilla the pedidoPltlPlantilla to set
	 */
	public void setPedidoPltlPlantilla(PedidoPlantillaDTO pedidoPltlPlantilla) {
		this.pedidoPltlPlantilla = pedidoPltlPlantilla;
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
	 * @return the vistaProveedorDTOCol
	 */
	public Collection<VistaProveedorDTO> getVistaProveedorDTOCol() {
		return vistaProveedorDTOCol;
	}

	/**
	 * @param vistaProveedorDTOCol the vistaProveedorDTOCol to set
	 */
	public void setVistaProveedorDTOCol(Collection<VistaProveedorDTO> vistaProveedorDTOCol) {
		this.vistaProveedorDTOCol = vistaProveedorDTOCol;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the fechaEntrega
	 */
	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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

	/**
	 * @return the fechaPublicacion
	 */
	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	/**
	 * @param fechaPublicacion the fechaPublicacion to set
	 */
	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	/**
	 * @return the urlReporte
	 */
	public String getUrlReporte() {
		return urlReporte;
	}

	/**
	 * @param urlReporte the urlReporte to set
	 */
	public void setUrlReporte(String urlReporte) {
		this.urlReporte = urlReporte;
	}

	/**
	 * @return the codigoOrigenCatTip
	 */
	public Integer getCodigoOrigenCatTip() {
		return codigoOrigenCatTip;
	}

	/**
	 * @param codigoOrigenCatTip the codigoOrigenCatTip to set
	 */
	public void setCodigoOrigenCatTip(Integer codigoOrigenCatTip) {
		this.codigoOrigenCatTip = codigoOrigenCatTip;
	}

	/**
	 * @return the codigoOrigenCatVal
	 */
	public String getCodigoOrigenCatVal() {
		return codigoOrigenCatVal;
	}

	/**
	 * @param codigoOrigenCatVal the codigoOrigenCatVal to set
	 */
	public void setCodigoOrigenCatVal(String codigoOrigenCatVal) {
		this.codigoOrigenCatVal = codigoOrigenCatVal;
	}

	public Boolean getIntegracionActiva() {
		return integracionActiva;
	}

	public void setIntegracionActiva(Boolean integracionActiva) {
		this.integracionActiva = integracionActiva;
	}

	/**
	 * @return the codigoMoneda
	 */
	public Long getCodigoMoneda() {
		return codigoMoneda;
	}

	/**
	 * @param codigoMoneda the codigoMoneda to set
	 */
	public void setCodigoMoneda(Long codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	/**
	 * @return the valorCambioMoneda
	 */
	public Double getValorCambioMoneda() {
		return valorCambioMoneda;
	}

	/**
	 * @param valorCambioMoneda the valorCambioMoneda to set
	 */
	public void setValorCambioMoneda(Double valorCambioMoneda) {
		this.valorCambioMoneda = valorCambioMoneda;
	}

	/**
	 * @return the areaTrabajoDestino
	 */
	public AreaTrabajoDTO getAreaTrabajoDestino() {
		return areaTrabajoDestino;
	}

	/**
	 * @param areaTrabajoDestino the areaTrabajoDestino to set
	 */
	public void setAreaTrabajoDestino(AreaTrabajoDTO areaTrabajoDestino) {
		this.areaTrabajoDestino = areaTrabajoDestino;
	}

	/**
	 * @return the monedaDTO
	 */
	public MonedaDTO getMonedaDTO() {
		return monedaDTO;
	}

	/**
	 * @param monedaDTO the monedaDTO to set
	 */
	public void setMonedaDTO(MonedaDTO monedaDTO) {
		this.monedaDTO = monedaDTO;
	}

	/**
	 * @return the funcionarioTipoMarcaCol
	 */
	public Collection<InformacionFuncionarioTipoMarca> getFuncionarioTipoMarcaCol() {
		return funcionarioTipoMarcaCol;
	}

	/**
	 * @param funcionarioTipoMarcaCol the funcionarioTipoMarcaCol to set
	 */
	public void setFuncionarioTipoMarcaCol(Collection<InformacionFuncionarioTipoMarca> funcionarioTipoMarcaCol) {
		this.funcionarioTipoMarcaCol = funcionarioTipoMarcaCol;
	}

	/**
	 * @return the identificadorArchivoSesion
	 */
	public String getIdentificadorArchivoSesion() {
		return identificadorArchivoSesion;
	}

	/**
	 * @param identificadorArchivoSesion the identificadorArchivoSesion to set
	 */
	public void setIdentificadorArchivoSesion(String identificadorArchivoSesion) {
		this.identificadorArchivoSesion = identificadorArchivoSesion;
	}

	/**
	 * @return the funcionarioLineaComercialCol
	 */
	public Collection<InformacionFuncionarioLineaComercial> getFuncionarioLineaComercialCol() {
		return funcionarioLineaComercialCol;
	}

	/**
	 * @param funcionarioLineaComercialCol the funcionarioLineaComercialCol to set
	 */
	public void setFuncionarioLineaComercialCol(Collection<InformacionFuncionarioLineaComercial> funcionarioLineaComercialCol) {
		this.funcionarioLineaComercialCol = funcionarioLineaComercialCol;
	}

	/**
	 * @return the fechaSugerido
	 */
	public Date getFechaSugerido() {
		return fechaSugerido;
	}

	/**
	 * @param fechaSugerido the fechaSugerido to set
	 */
	public void setFechaSugerido(Date fechaSugerido) {
		this.fechaSugerido = fechaSugerido;
	}
	
	/**
	 * @return the noB2B
	 */
	public Boolean getNoB2B() {
		return noB2B;
	}

	/**
	 * @param noB2B the noB2B to set
	 */
	public void setNoB2B(Boolean noB2B) {
		this.noB2B = noB2B;
	}

	/**
	 * @return the currentPageArticulo
	 */
	public int getCurrentPageArticulo() {
		return currentPageArticulo;
	}

	/**
	 * @param currentPageArticulo the currentPageArticulo to set
	 */
	public void setCurrentPageArticulo(int currentPageArticulo) {
		this.currentPageArticulo = currentPageArticulo;
	}
}
