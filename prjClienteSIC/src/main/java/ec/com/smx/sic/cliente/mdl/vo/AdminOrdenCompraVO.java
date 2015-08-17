package ec.com.smx.sic.cliente.mdl.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioLineaComercial;
import ec.com.smx.corpv2.common.beans.InformacionFuncionarioTipoMarca;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaArticulo;
import ec.com.smx.sic.cliente.common.ordenCompra.TiposSelectItemsOrdenCompra;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.GrupoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.NegociacionArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.OficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.FacturaImpDTO;

/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
public class AdminOrdenCompraVO extends BaseVO<OrdenCompraEstadoDTO>{
	
	private String userId;
	private String codigoProveedorCargado;
	//Relaciones 
	private Collection<OrdenCompraEstadoDTO> ordenCompraEstadoCol;
	private Collection<FacturaDTO> facturaDTOCol;
	private Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOCol;
	//Creacion
	private String modoCreacion;
	private String codigoTipoCatVal;
	private OrdenCompraEstadoDTO ordeCompraEstadoPlantilla;
	private OrdenCompraEstadoDTO ordenCompraSelect;
	private Boolean esProveedorImportado;
	private Collection<ProveedorOficinaExteriorDTO> provOfiCol;
	//Colleciones utilizadas para inicializar el componente de Busqueda OrdenCompra
	private Collection<Long> codigosLineasComercialesCol ;
	private Collection<BodegaDTO> bodegasCol;
	private Collection<OficinaExteriorDTO> oficinaExteriorCol;
	private Collection<CatalogoValorDTO> estadosCol;
	private Collection<CatalogoValorDTO> tipoPedidoCol;
	private Collection<CatalogoValorDTO> modoCreacionCol;
	private Collection<CatalogoValorDTO> frecuenciaRotacionCol;
	private Collection<CatalogoValorDTO> destinosNotaPedidoCol;
	private FuncionarioDTO funcionario ;
	private Integer currentPage;
	private Integer currentDetPage;
	private String vista;
	private String imageSort = "unsorted";
	private String sortBy;
	//Si el valor de la consulta de orden de compra es diferente de nulo y mayor a cero, se vuelve a consultar.
	private Integer valorConsulta ;
	//Se almacena el valor de la consulta del count para no volver a consultar
	private Long valorCountBusqueda;
	private Map<String, Object> filtrosMap ;
	//Rotacion - Costo origen
	public String rotacion;
	public Boolean costoOri;
	//Creacion por Articulo
	private String codigoBarras;
	private String referenciaExterna;
	private PlantillaBusquedaArticulo plantillaBusquedaArticulo;
	//Mensaje de exito Creacion;
	private String mensajeExitoCreacion;
	
	//Valores para la Rotacion de Articulos
	private Integer codigoAreaTrabajoRotacion;
	private String codigoTipoFrecuencia;
	//Bandera de activacion de la integracion de datos del articulo desde el SIC.
	private Boolean integracionActiva;
	private Collection<String> articulosOcultar; 
	
	//bytes para generar el archivo de excel con observaciones..
	private HSSFWorkbook contenidoExcelObservaciones;
	
	//url para la generacion del reporte
	private String urlReporte;
	
	//Patern para ordenar busqueda de articulos
	private String orderBy;
	private Boolean ordenarPorClasificacion = Boolean.TRUE;
	private Boolean ordenarPorSubClasificacion;
	
	//Colecci�n de codCatVal relaci�n por art�culo
	private Collection<String> codCatValRelCol;
	//Colecci�n de c�digos de barra art�culos relaciondos
	private Collection<String> codBarArtRelCol;
	//Colecci�n de c�digos de barra art�culos relaciondos ya agregados
	private Collection<String> codBarArtRelAgrCol;	
	//Tipos de marcas por usuario
	private Collection<InformacionFuncionarioTipoMarca> funcionarioTipoMarcaCol;
	//Lineas comerciales del funcionario
	private Collection<InformacionFuncionarioLineaComercial> funcionarioLineaComercialCol;
	//Coleccion de lineas comerciales seleccionadas
	private Collection<LineaComercialClienteImportacionDTO> lineasComercialesSeleccionadas;
	
	//codigos de unidad de manejo
	private Long[] codigosUnidadManejo;
	
	//nota de pedido
	private Boolean esNotaPedido;
	//pre orden
	private Boolean esPreorden;
	//orden de compra manual para la recepcion
	private Boolean esOrdenCompraRecepcion;
	
	//detalles no validos en orden de compra para la recepcion
	private Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraObservacionSic;

	//Contingencia orden de compra
	private Boolean visualizacionPlanContingencia = Boolean.FALSE;
	
	//Opcion y sistema en el que se encuentra el usuario
	private String accessItemId;
	private String systemId;
	
	//IMPUESTOS Y DESCUENTOS PRE DETERMINADOS -- CREACION NUEVO DETALLE ARTICULO
	private Collection<GrupoImpuestoDTO> grupoImpuestoDefaultCol;
	private TipoImpuestoDTO tipoImpuestoIvaDefaultDTO;
	private TipoImpuestoDTO tipoImpuestoIbrpDefaultDTO;
	private Collection<TipoDescuentoDTO> tipoDescuentosDefaultCol;
	//Codigos de linea comercial / Codigos de clasificacion
	private LinkedHashMap<Long, ArrayList<String>> codigosLineaComercialClasificacionMap;
	private LinkedHashMap<String, Long> codigosClasificacionLineaComercialMap;
	//Clases seleccionadas para filtrar en CREACION ASISTIDA
	private List<String> clasesSeleccionadasList;
	//lineas comerciales seleccionadas para filtrar en CREACION ASISTIDA
	private List<String> lineaComercialSeleccionadasList;

	
	//creacion por archivo
	private Collection<ArticuloImportadoVO> articuloImportadoCollection;
	private Collection<ArticuloImportadoVO> articuloImportadoCollectionAreaTrabajo;
	private List datosValidados;
	private Collection<TiposSelectItemsOrdenCompra> tiposGeneracionOrdenCompra;
	
	//Mapa que almacena codigos de moneda y tasas de cambio con respecto a la moneda del pedido
	private LinkedHashMap<Long, Double> codigosTasasLinkedHashMap;
	
	//Valor parametro calculo costo neto valor impuesto importacion
	private String valorParametroCostoNetoComision;
	
	//Id session
	private String identificadorArchivoSesion;
	private FacturaImpDTO facturaImportacionesRelacionada;
	
	//Boolean para manejar NoB2B
	private Boolean noB2B;
	
	//Lista de Plazo Pago
	private Collection<CatalogoValorDTO> plazoPagoDiasItems;
	
	//Tipos de ordenamiento para articulos
	private Collection<TiposSelectItemsOrdenCompra> tiposOrdenamientoArticulos;
	
	//Lista de codigos de clasificacion
	private Collection<StringBuffer> codigosClasificacion;
	
	//Listado de ordenes de compra seleccionadas
	private Map<Integer, List<OrdenCompraEstadoDTO>> ordenCompraListSelect = new HashMap<Integer, List<OrdenCompraEstadoDTO>>();

	
	//Coleccion de negociacion articulo (Convenio a proveedores)
	private Collection<NegociacionArticuloDTO> negociacionArticuloCol;
	
	//Parametro para determinar a que descuento se aplica el porcentaje de negociacion a proveedores de convenios
	private Integer parametroDescuentoConvenios;
	private String consultaDescuentoConvenioProveedor;
	
	private Integer currentPageArticulo;	
	private String busquedaArticuloPopUp = null;
		
	private String identificadorArchivo;
	private String nombreCarpeta = null;
	private Collection<String> emailsDestinatarios;
	//Edicion masiva
	private Date fechaEntregaMasiva = null;
	private Date fechaCaducidadMasiva = null;
	//Colecci�n de articulos con problemas en el SIC
	private Collection<String> articulosProblemasSIC;

	//Consulta items - clasificacion
	private Collection<String> codigosClasificacionItems;
	private Collection<String> codigosDepartamentoItems ;
	
	/*GETTERS AND SETTERS*/
	public Collection<OrdenCompraEstadoDTO> getOrdenCompraEstadoCol() {
		return ordenCompraEstadoCol;
	}
	public void setOrdenCompraEstadoCol(
			Collection<OrdenCompraEstadoDTO> ordenCompraEstadoCol) {
		this.ordenCompraEstadoCol = ordenCompraEstadoCol;
	}
	public OrdenCompraEstadoDTO getOrdeCompraEstadoPlantilla() {
		return ordeCompraEstadoPlantilla;
	}
	public void setOrdeCompraEstadoPlantilla(
			OrdenCompraEstadoDTO ordeCompraEstadoPlantilla) {
		this.ordeCompraEstadoPlantilla = ordeCompraEstadoPlantilla;
	}
	public OrdenCompraEstadoDTO getOrdenCompraSelect() {
		return ordenCompraSelect;
	}
	public void setOrdenCompraSelect(OrdenCompraEstadoDTO ordenCompraSelect) {
		this.ordenCompraSelect = ordenCompraSelect;
	}
	public Collection<BodegaDTO> getBodegasCol() {
		return bodegasCol;
	}
	public void setBodegasCol(Collection<BodegaDTO> bodegasCol) {
		this.bodegasCol = bodegasCol;
	}
	public Collection<CatalogoValorDTO> getEstadosCol() {
		return estadosCol;
	}
	public void setEstadosCol(Collection<CatalogoValorDTO> estadosCol) {
		this.estadosCol = estadosCol;
	}
	public Collection<CatalogoValorDTO> getTipoPedidoCol() {
		return tipoPedidoCol;
	}
	public void setTipoPedidoCol(Collection<CatalogoValorDTO> tipoPedidoCol) {
		this.tipoPedidoCol = tipoPedidoCol;
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
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentDetPage() {
		return currentDetPage;
	}
	public void setCurrentDetPage(Integer currentDetPage) {
		this.currentDetPage = currentDetPage;
	}
	public String getVista() {
		return vista;
	}
	public void setVista(String vista) {
		this.vista = vista;
	}
	public String getImageSort() {
		return imageSort;
	}
	public void setImageSort(String imageSort) {
		this.imageSort = imageSort;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public Map<String, Object> getFiltrosMap() {
		return filtrosMap;
	}
	public void setFiltrosMap(Map<String, Object> filtrosMap) {
		this.filtrosMap = filtrosMap;
	}
	public Collection<CatalogoValorDTO> getModoCreacionCol() {
		return modoCreacionCol;
	}
	public void setModoCreacionCol(Collection<CatalogoValorDTO> modoCreacionCol) {
		this.modoCreacionCol = modoCreacionCol;
	}
	public String getModoCreacion() {
		return modoCreacion;
	}
	public void setModoCreacion(String modoCreacion) {
		this.modoCreacion = modoCreacion;
	}
	public String getCodigoTipoCatVal() {
		return codigoTipoCatVal;
	}
	public void setCodigoTipoCatVal(String codigoTipoCatVal) {
		this.codigoTipoCatVal = codigoTipoCatVal;
	}
	public Collection<OficinaExteriorDTO> getOficinaExteriorCol() {
		return oficinaExteriorCol;
	}
	public void setOficinaExteriorCol(
			Collection<OficinaExteriorDTO> oficinaExteriorCol) {
		this.oficinaExteriorCol = oficinaExteriorCol;
	}
	public Collection<ProveedorOficinaExteriorDTO> getProvOfiCol() {
		return provOfiCol;
	}
	public void setProvOfiCol(Collection<ProveedorOficinaExteriorDTO> provOfiCol) {
		this.provOfiCol = provOfiCol;
	}
	public Integer getValorConsulta() {
		return valorConsulta;
	}
	public void setValorConsulta(Integer valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRotacion() {
		return rotacion;
	}
	public void setRotacion(String rotacion) {
		this.rotacion = rotacion;
	}
	public Boolean getCostoOri() {
		return costoOri;
	}
	public void setCostoOri(Boolean costoOri) {
		this.costoOri = costoOri;
	}
	public Boolean getEsProveedorImportado() {
		return esProveedorImportado;
	}
	public void setEsProveedorImportado(Boolean esProveedorImportado) {
		this.esProveedorImportado = esProveedorImportado;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getReferenciaExterna() {
		return referenciaExterna;
	}
	public void setReferenciaExterna(String referenciaExterna) {
		this.referenciaExterna = referenciaExterna;
	}
	public PlantillaBusquedaArticulo getPlantillaBusquedaArticulo() {
		return plantillaBusquedaArticulo;
	}
	public void setPlantillaBusquedaArticulo(
			PlantillaBusquedaArticulo plantillaBusquedaArticulo) {
		this.plantillaBusquedaArticulo = plantillaBusquedaArticulo;
	}
	public String getMensajeExitoCreacion() {
		return mensajeExitoCreacion;
	}
	public void setMensajeExitoCreacion(String mensajeExitoCreacion) {
		this.mensajeExitoCreacion = mensajeExitoCreacion;
	}
	public Collection<FacturaDTO> getFacturaDTOCol() {
		return facturaDTOCol;
	}
	public void setFacturaDTOCol(Collection<FacturaDTO> facturaDTOCol) {
		this.facturaDTOCol = facturaDTOCol;
	}
	public Collection<OrdenCompraDetalleEstadoDTO> getOrdenCompraDetalleEstadoDTOCol() {
		return ordenCompraDetalleEstadoDTOCol;
	}
	public void setOrdenCompraDetalleEstadoDTOCol(
			Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOCol) {
		this.ordenCompraDetalleEstadoDTOCol = ordenCompraDetalleEstadoDTOCol;
	}
	public Integer getCodigoAreaTrabajoRotacion() {
		return codigoAreaTrabajoRotacion;
	}
	public void setCodigoAreaTrabajoRotacion(Integer codigoAreaTrabajoRotacion) {
		this.codigoAreaTrabajoRotacion = codigoAreaTrabajoRotacion;
	}
	
	public String getCodigoTipoFrecuencia() {
		return codigoTipoFrecuencia;
	}
	public void setCodigoTipoFrecuencia(String codigoTipoFrecuencia) {
		this.codigoTipoFrecuencia = codigoTipoFrecuencia;
	}

	public Boolean getIntegracionActiva() {
		return integracionActiva;
	}
	
	public void setIntegracionActiva(Boolean integracionActiva) {
		this.integracionActiva = integracionActiva;
	}
	
	public Collection<CatalogoValorDTO> getFrecuenciaRotacionCol() {
		return frecuenciaRotacionCol;
	}
	public void setFrecuenciaRotacionCol(Collection<CatalogoValorDTO> frecuenciaRotacionCol) {
		this.frecuenciaRotacionCol = frecuenciaRotacionCol;
	}
	public Collection<String> getArticulosOcultar() {
		return articulosOcultar;
	}
	public void setArticulosOcultar(Collection<String> articulosOcultar) {
		this.articulosOcultar = articulosOcultar;
	}
	public HSSFWorkbook getContenidoExcelObservaciones() {
		return contenidoExcelObservaciones;
	}
	public void setContenidoExcelObservaciones(HSSFWorkbook contenidoExcelObservaciones) {
		this.contenidoExcelObservaciones = contenidoExcelObservaciones;
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
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/**
	 * @return the codigosUnidadManejo
	 */
	public Long[] getCodigosUnidadManejo() {
		return codigosUnidadManejo;
	}
	/**
	 * @param codigosUnidadManejo the codigosUnidadManejo to set
	 */
	public void setCodigosUnidadManejo(Long[] codigosUnidadManejo) {
		this.codigosUnidadManejo = codigosUnidadManejo;
	}
	/**
	 * @return the visualizacionPlanContingencia
	 */
	public Boolean getVisualizacionPlanContingencia() {
		return visualizacionPlanContingencia;
	}
	/**
	 * @param visualizacionPlanContingencia the visualizacionPlanContingencia to set
	 */
	public void setVisualizacionPlanContingencia(Boolean visualizacionPlanContingencia) {
		this.visualizacionPlanContingencia = visualizacionPlanContingencia;
	}
	public Collection<String> getCodCatValRelCol() {
		return codCatValRelCol;
	}
	public void setCodCatValRelCol(Collection<String> codCatValRelCol) {
		this.codCatValRelCol = codCatValRelCol;
	}
	public Collection<String> getCodBarArtRelCol() {
		return codBarArtRelCol;
	}
	public void setCodBarArtRelCol(Collection<String> codBarArtRelCol) {
		this.codBarArtRelCol = codBarArtRelCol;
	}
	public Collection<String> getCodBarArtRelAgrCol() {
		return codBarArtRelAgrCol;
	}
	public void setCodBarArtRelAgrCol(Collection<String> codBarArtRelAgrCol) {
		this.codBarArtRelAgrCol = codBarArtRelAgrCol;
	}
	public Collection<InformacionFuncionarioTipoMarca> getFuncionarioTipoMarcaCol() {
		return funcionarioTipoMarcaCol;
	}
	public void setFuncionarioTipoMarcaCol(Collection<InformacionFuncionarioTipoMarca> funcionarioTipoMarcaCol) {
		this.funcionarioTipoMarcaCol = funcionarioTipoMarcaCol;
	}
	public Boolean getEsNotaPedido() {
		return esNotaPedido;
	}
	public void setEsNotaPedido(Boolean esNotaPedido) {
		this.esNotaPedido = esNotaPedido;
	}
	public Collection<GrupoImpuestoDTO> getGrupoImpuestoDefaultCol() {
		return grupoImpuestoDefaultCol;
	}
	public void setGrupoImpuestoDefaultCol(Collection<GrupoImpuestoDTO> grupoImpuestoDefaultCol) {
		this.grupoImpuestoDefaultCol = grupoImpuestoDefaultCol;
	}
	public TipoImpuestoDTO getTipoImpuestoIvaDefaultDTO() {
		return tipoImpuestoIvaDefaultDTO;
	}
	public void setTipoImpuestoIvaDefaultDTO(TipoImpuestoDTO tipoImpuestoIvaDefaultDTO) {
		this.tipoImpuestoIvaDefaultDTO = tipoImpuestoIvaDefaultDTO;
	}
	public TipoImpuestoDTO getTipoImpuestoIbrpDefaultDTO() {
		return tipoImpuestoIbrpDefaultDTO;
	}
	public void setTipoImpuestoIbrpDefaultDTO(TipoImpuestoDTO tipoImpuestoIbrpDefaultDTO) {
		this.tipoImpuestoIbrpDefaultDTO = tipoImpuestoIbrpDefaultDTO;
	}
	public Collection<TipoDescuentoDTO> getTipoDescuentosDefaultCol() {
		return tipoDescuentosDefaultCol;
	}
	public void setTipoDescuentosDefaultCol(Collection<TipoDescuentoDTO> tipoDescuentosDefaultCol) {
		this.tipoDescuentosDefaultCol = tipoDescuentosDefaultCol;
	}
	public LinkedHashMap<Long, ArrayList<String>> getCodigosLineaComercialClasificacionMap() {
		return codigosLineaComercialClasificacionMap;
	}
	public void setCodigosLineaComercialClasificacionMap(LinkedHashMap<Long, ArrayList<String>> codigosLineaComercialClasificacionMap) {
		this.codigosLineaComercialClasificacionMap = codigosLineaComercialClasificacionMap;
	}
	public LinkedHashMap<String, Long> getCodigosClasificacionLineaComercialMap() {
		return codigosClasificacionLineaComercialMap;
	}
	public void setCodigosClasificacionLineaComercialMap(LinkedHashMap<String, Long> codigosClasificacionLineaComercialMap) {
		this.codigosClasificacionLineaComercialMap = codigosClasificacionLineaComercialMap;
	}
	public Collection<ArticuloImportadoVO> getArticuloImportadoCollection() {
		return articuloImportadoCollection;
	}
	public void setArticuloImportadoCollection(Collection<ArticuloImportadoVO> articuloImportadoCollection) {
		this.articuloImportadoCollection = articuloImportadoCollection;
	}
	public Collection<ArticuloImportadoVO> getArticuloImportadoCollectionAreaTrabajo() {
		return articuloImportadoCollectionAreaTrabajo;
	}
	public void setArticuloImportadoCollectionAreaTrabajo(Collection<ArticuloImportadoVO> articuloImportadoCollectionAreaTrabajo) {
		this.articuloImportadoCollectionAreaTrabajo = articuloImportadoCollectionAreaTrabajo;
	}
	public List getDatosValidados() {
		return datosValidados;
	}
	public void setDatosValidados(List datosValidados) {
		this.datosValidados = datosValidados;
	}
	public Boolean getEsPreorden() {
		return esPreorden;
	}
	public void setEsPreorden(Boolean esPreorden) {
		this.esPreorden = esPreorden;
	}
	public List<String> getClasesSeleccionadasList() {
		return clasesSeleccionadasList;
	}
	public void setClasesSeleccionadasList(List<String> clasesSeleccionadasList) {
		this.clasesSeleccionadasList = clasesSeleccionadasList;
	}
	public LinkedHashMap<Long, Double> getCodigosTasasLinkedHashMap() {
		return codigosTasasLinkedHashMap;
	}
	public void setCodigosTasasLinkedHashMap(LinkedHashMap<Long, Double> codigosTasasLinkedHashMap) {
		this.codigosTasasLinkedHashMap = codigosTasasLinkedHashMap;
	}
	public Collection<TiposSelectItemsOrdenCompra> getTiposGeneracionOrdenCompra() {
		return tiposGeneracionOrdenCompra;
	}
	public void setTiposGeneracionOrdenCompra(Collection<TiposSelectItemsOrdenCompra> tiposGeneracionOrdenCompra) {
		this.tiposGeneracionOrdenCompra = tiposGeneracionOrdenCompra;
	}
	/**
	 * @return the accessItemId
	 */
	public String getAccessItemId() {
		return accessItemId;
	}
	/**
	 * @param accessItemId the accessItemId to set
	 */
	public void setAccessItemId(String accessItemId) {
		this.accessItemId = accessItemId;
	}
	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}
	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
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
	 * @return the esOrdenCompraRecepcion
	 */
	public Boolean getEsOrdenCompraRecepcion() {
		return esOrdenCompraRecepcion;
	}
	/**
	 * @param esOrdenCompraRecepcion the esOrdenCompraRecepcion to set
	 */
	public void setEsOrdenCompraRecepcion(Boolean esOrdenCompraRecepcion) {
		this.esOrdenCompraRecepcion = esOrdenCompraRecepcion;
	}
	public String getCodigoProveedorCargado() {
		return codigoProveedorCargado;
	}
	public void setCodigoProveedorCargado(String codigoProveedorCargado) {
		this.codigoProveedorCargado = codigoProveedorCargado;
	}
	public Collection<CatalogoValorDTO> getDestinosNotaPedidoCol() {
		return destinosNotaPedidoCol;
	}
	public void setDestinosNotaPedidoCol(Collection<CatalogoValorDTO> destinosNotaPedidoCol) {
		this.destinosNotaPedidoCol = destinosNotaPedidoCol;
	}
	public String getValorParametroCostoNetoComision() {
		return valorParametroCostoNetoComision;
	}
	public void setValorParametroCostoNetoComision(String valorParametroCostoNetoComision) {
		this.valorParametroCostoNetoComision = valorParametroCostoNetoComision;
	}
	public String getIdentificadorArchivoSesion() {
		return identificadorArchivoSesion;
	}
	public void setIdentificadorArchivoSesion(String identificadorArchivoSesion) {
		this.identificadorArchivoSesion = identificadorArchivoSesion;
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
	/**
	 * @return the facturaImportacionesRelacionada
	 */
	public FacturaImpDTO getFacturaImportacionesRelacionada() {
		return facturaImportacionesRelacionada;
	}
	/**
	 * @param facturaImportacionesRelacionada the facturaImportacionesRelacionada to set
	 */
	public void setFacturaImportacionesRelacionada(FacturaImpDTO facturaImportacionesRelacionada) {
		this.facturaImportacionesRelacionada = facturaImportacionesRelacionada;
	}
	public Collection<LineaComercialClienteImportacionDTO> getLineasComercialesSeleccionadas() {
		return lineasComercialesSeleccionadas;
	}
	public void setLineasComercialesSeleccionadas(Collection<LineaComercialClienteImportacionDTO> lineasComercialesSeleccionadas) {
		this.lineasComercialesSeleccionadas = lineasComercialesSeleccionadas;
	}
	public List<String> getLineaComercialSeleccionadasList() {
		return lineaComercialSeleccionadasList;
	}
	@SuppressWarnings("unchecked")
	public void setLineaComercialSeleccionadasList(List<String> lineaComercialSeleccionadasList) {
		this.lineaComercialSeleccionadasList = lineaComercialSeleccionadasList;
	}
	/**
	 * @return the ordenarPorClasificacion
	 */
	public Boolean getOrdenarPorClasificacion() {
		return ordenarPorClasificacion;
	}
	/**
	 * @param ordenarPorClasificacion the ordenarPorClasificacion to set
	 */
	public void setOrdenarPorClasificacion(Boolean ordenarPorClasificacion) {
		this.ordenarPorClasificacion = ordenarPorClasificacion;
	}
	/**
	 * @return the ordenarPorSubClasificacion
	 */
	public Boolean getOrdenarPorSubClasificacion() {
		return ordenarPorSubClasificacion;
	}
	/**
	 * @param ordenarPorSubClasificacion the ordenarPorSubClasificacion to set
	 */
	public void setOrdenarPorSubClasificacion(Boolean ordenarPorSubClasificacion) {
		this.ordenarPorSubClasificacion = ordenarPorSubClasificacion;
	}
	/**
	 * @return the detalleOrdenCompraObservacionSic
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> getDetalleOrdenCompraObservacionSic() {
		return detalleOrdenCompraObservacionSic;
	}
	/**
	 * @param detalleOrdenCompraObservacionSic the detalleOrdenCompraObservacionSic to set
	 */
	public void setDetalleOrdenCompraObservacionSic(Collection<OrdenCompraDetalleEstadoDTO> detalleOrdenCompraObservacionSic) {
		this.detalleOrdenCompraObservacionSic = detalleOrdenCompraObservacionSic;
	}
	
	public Boolean getNoB2B() {
		return noB2B;
	}
	public void setNoB2B(Boolean noB2B) {
		this.noB2B = noB2B;
	}
	/**
	 * @return the plazoPagoDiasItems
	 */
	public Collection<CatalogoValorDTO> getPlazoPagoDiasItems() {
		return plazoPagoDiasItems;
	}
	/**
	 * @param plazoPagoDiasItems the plazoPagoDiasItems to set
	 */
	public void setPlazoPagoDiasItems(Collection<CatalogoValorDTO> plazoPagoDiasItems) {
		this.plazoPagoDiasItems = plazoPagoDiasItems;
	}
	/**
	 * @return the tiposOrdenamientoArticulos
	 */
	public Collection<TiposSelectItemsOrdenCompra> getTiposOrdenamientoArticulos() {
		return tiposOrdenamientoArticulos;
	}
	/**
	 * @param tiposOrdenamientoArticulos the tiposOrdenamientoArticulos to set
	 */
	public void setTiposOrdenamientoArticulos(Collection<TiposSelectItemsOrdenCompra> tiposOrdenamientoArticulos) {
		this.tiposOrdenamientoArticulos = tiposOrdenamientoArticulos;
	}
	/**
	 * @return the ordenCompraListSelect
	 */
	public Map<Integer, List<OrdenCompraEstadoDTO>> getOrdenCompraListSelect() {
		return ordenCompraListSelect;
	}
	/**
	 * @param ordenCompraListSelect the ordenCompraListSelect to set
	 */
	public void setOrdenCompraListSelect(Map<Integer, List<OrdenCompraEstadoDTO>> ordenCompraListSelect) {
		this.ordenCompraListSelect = ordenCompraListSelect;
	}
	public Collection<StringBuffer> getCodigosClasificacion() {
		return codigosClasificacion;
	}
	
	public void setCodigosClasificacion(Collection<StringBuffer> codigosClasificacion) {
		this.codigosClasificacion = codigosClasificacion;
	}
	
	public Collection<NegociacionArticuloDTO> getNegociacionArticuloCol() {
		return negociacionArticuloCol;
	}
	public void setNegociacionArticuloCol(Collection<NegociacionArticuloDTO> negociacionArticuloCol) {
		this.negociacionArticuloCol = negociacionArticuloCol;
	}
	public Integer getParametroDescuentoConvenios() {
		return parametroDescuentoConvenios;
	}
	public void setParametroDescuentoConvenios(Integer parametroDescuentoConvenios) {
		this.parametroDescuentoConvenios = parametroDescuentoConvenios;
	}
	public String getConsultaDescuentoConvenioProveedor() {
		return consultaDescuentoConvenioProveedor;
	}
	public void setConsultaDescuentoConvenioProveedor(String consultaDescuentoConvenioProveedor) {
		this.consultaDescuentoConvenioProveedor = consultaDescuentoConvenioProveedor;
	}
	/**
	 * @return the currentPageArticulo
	 */
	public Integer getCurrentPageArticulo() {
		return currentPageArticulo;
	}
	/**
	 * @param currentPageArticulo the currentPageArticulo to set
	 */
	public void setCurrentPageArticulo(Integer currentPageArticulo) {
		this.currentPageArticulo = currentPageArticulo;
	}

	/**
	 * @return the busquedaArticuloPopUp
	 */
	public String getBusquedaArticuloPopUp() {
		return busquedaArticuloPopUp;
	}
	/**
	 * @param busquedaArticuloPopUp the busquedaArticuloPopUp to set
	 */
	public void setBusquedaArticuloPopUp(String busquedaArticuloPopUp) {
		this.busquedaArticuloPopUp = busquedaArticuloPopUp;
	}
	
	/**
	 * @return the identificadorArchivo
	 */
	public String getIdentificadorArchivo() {
		return identificadorArchivo;
	}
	/**
	 * @param identificadorArchivo the identificadorArchivo to set
	 */
	public void setIdentificadorArchivo(String identificadorArchivo) {
		this.identificadorArchivo = identificadorArchivo;
	}
	/**
	 * @return the nombreCarpeta
	 */
	public String getNombreCarpeta() {
		return nombreCarpeta;
	}
	/**
	 * @param nombreCarpeta the nombreCarpeta to set
	 */
	public void setNombreCarpeta(String nombreCarpeta) {
		this.nombreCarpeta = nombreCarpeta;
	}
	/**
	 * @return the emailsDestinatarios
	 */
	public Collection<String> getEmailsDestinatarios() {
		return emailsDestinatarios;
	}
	/**
	 * @param emailsDestinatarios the emailsDestinatarios to set
	 */
	public void setEmailsDestinatarios(Collection<String> emailsDestinatarios) {
		this.emailsDestinatarios = emailsDestinatarios;
	}
	/**
	 * @return the fechaEntregaMasiva
	 */
	public Date getFechaEntregaMasiva() {
		return fechaEntregaMasiva;
	}
	/**
	 * @param fechaEntregaMasiva the fechaEntregaMasiva to set
	 */
	public void setFechaEntregaMasiva(Date fechaEntregaMasiva) {
		this.fechaEntregaMasiva = fechaEntregaMasiva;
	}
	/**
	 * @return the fechaCaducidadMasiva
	 */
	public Date getFechaCaducidadMasiva() {
		return fechaCaducidadMasiva;
	}
	/**
	 * @param fechaCaducidadMasiva the fechaCaducidadMasiva to set
	 */
	public void setFechaCaducidadMasiva(Date fechaCaducidadMasiva) {
		this.fechaCaducidadMasiva = fechaCaducidadMasiva;
	}
	public Collection<String> getArticulosProblemasSIC() {
		return articulosProblemasSIC;
	}
	public void setArticulosProblemasSIC(Collection<String> articulosProblemasSIC) {
		this.articulosProblemasSIC = articulosProblemasSIC;
	}
	/**
	 * @return the codigosClasificacionItems
	 */
	public Collection<String> getCodigosClasificacionItems() {
		return codigosClasificacionItems;
	}
	/**
	 * @param codigosClasificacionItems the codigosClasificacionItems to set
	 */
	public void setCodigosClasificacionItems(Collection<String> codigosClasificacionItems) {
		this.codigosClasificacionItems = codigosClasificacionItems;
	}
	/**
	 * @return the codigosDepartamentoItems
	 */
	public Collection<String> getCodigosDepartamentoItems() {
		return codigosDepartamentoItems;
	}
	/**
	 * @param codigosDepartamentoItems the codigosDepartamentoItems to set
	 */
	public void setCodigosDepartamentoItems(Collection<String> codigosDepartamentoItems) {
		this.codigosDepartamentoItems = codigosDepartamentoItems;
	}
	public Long getValorCountBusqueda() {
		return valorCountBusqueda;
	}
	public void setValorCountBusqueda(Long valorCountBusqueda) {
		this.valorCountBusqueda = valorCountBusqueda;
	}
}
