package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPedidoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IntegrableMQ;

@SuppressWarnings("serial")
public class ArticuloTransient extends SimpleAuditDTO implements IntegrableMQ{
	
    public static final String REUTILIZAR_CODIGOSEAN14 = "REUTILIZAR_CODIGOS_EAN14";
    public static final String CODIGOS_EAN_DUPLICADOS = "CODIGOS.EAN14.DUPLICADOS";
    public static final String PROCESO_CODIFICACIONARTICULO = "CODART";
    public static final String PROCESO_CODIFICACIONARTICULO_ARCHIVO = "CODARTARC";
    public static final String PROCESO_EDICIONARTICULO = "EDIART";
    public static final String ADMINISTRACIONCOMPLETA = "ADMCOM";
    public static final String ALERTA_IMPORTACION = "ALERTA_IMPORTACION";
    public static final String GENERAR_CODIGOINTERNO = "GENERAR.CODIGO.INTERNO";
    public static final String PROCESO_INTEGRACION_SIC = "PROINTSIC";
    public static final String PRECIO_ARTICULO_PROVEEDOR_IMPORTADO = "PREARTPROIMP";
    public static final String HABILITADO_ARTICULO_TEMPORADA = "HAT";
    public static final String PROCESO_CREACION_MASIVA_ARTICULO = "CREMASART";
    public static final String OMITIR_INTEGRACION_ARTICULO = "OIA";
     
	private String npCodigoEspecial;
	private Integer npCodigoLocal;
	private Double precioSugerido;
	private String npHabilitarPrecioCaja;
	private Collection npDetallesPedidos;
	private String npCodigoClasificacionAnterior;
	private Long npStockArticulo;
	private String npEstadoStockArticulo;
	private String npEstadoStockArticuloReceta;
	private String npEstadoExistencia;
	private String npAlcance;
	private String npAlcanceReceta;
	private String npEstadoArticuloSIC;
	private String npEstadoArticuloSICReceta;
	private ArticuloDTO npArticuloAnteriorDTO;
	private String npNuevoCodigoArticulo;
	private String npNuevaDescripcionArticulo;
	private String npDetalle;
	private String npCodigoArticuloPadre;
	private String npActivarInterfazSIC;
	private String npCodigoTipoArticulo;
	private Long npCantidadAProducir;
	private Long npCantidadAProducirFija;
	private Integer npCantidadTotalRegistros;
	private Boolean npObtenerCantidadTotalRegistros;
	private String npNuevoCodigoClasificacion;
	private String npEstadoEspecial;
	private String npConsultarArticulosCarnes;
	private Long npCodigoArticuloSIC;
	private String npHabilitarPrecioMayorista;
	private String npSecuencialEstadoPedido;
	private String npCodigoArticulo;
	private Collection<ArticuloDTO> npCodigoArticulos;
	private String npEstadoError;
	private String tipoCalculoPrecioFiltro;
	private String estadoPerecibleRecetaFiltro;
	private Boolean selected;
	//////////////////////////////////////////////////
	////		CAMPOS NP SISPE
	//////////////////////////////////////////////////
	private String npEstadoArticuloLocal;
	private String npOrderBy;	
	private Integer npFirstResult;
	private Integer npMaxResults;	
	private String npEstadoArticulo;
	private String npCodigoBarras;
	private Collection<ArticuloRelacionDTO> recetaArticulosRespaldo;
	private Collection<ArticuloRelacionDTO> recetaArticulosOriginal;
	private Collection<ArticuloRelacionDTO> recetaArticulosOriginalRespaldo;
	private Collection articulos;
	private String npEstadoAutorizacion;
	private Long npStockArticuloAutorizado;
	private Long npCantidadCanastosReservados; 
	protected Integer npUnidadManejoVenta;

	////////////////////////////////////////////////
	//////////	CAMPOS DE PARTICIPACION ARTICULO Y ARTICULOSIC
	/////////////////////////////////////////////////
	
	private String[] npClasesArticulo;
	private Collection<String> npCodigosInicialesSubclasificacionesAExcluir;
	private Collection<String> npCodigosProveedores;
	private Collection<String> npCodigosClasificaciones;	
	private Double npPrecioExtGar;
	private String npcodigoProveedor;
	private String npPedidoPavos;
	//campo de control para evitar el envio de datos al SIC
	private Boolean transferirDatosSIC = Boolean.TRUE;
	
	
	//////////////////////////////////////////////////////////
	////		CAMPOS PARA DEVOLUCIONES
	//////////////////////////////////////////////////////////
	
	private Date npFechaFactura;
	
	private String[] npCodigoBarrasCol;
	
	//////////////////////////////////////////////////////////
	///			CAMPOS PARA EXPORTACION DE TABLAS
	/////////////////////////////////////////////////////////
	
	private HashMap<Integer, String> impVen;
	private HashMap<Integer, String> impCom; 
	
	//////////////////////////////////////////////////////////
	///			CAMPOS PARA CAMBIO DE PRECIOS
	/////////////////////////////////////////////////////////
	private Boolean articuloAgregado;
	private Boolean plegar;
	private Collection<ArticuloProveedorDTO> proveedoresRelacionados;

	// PEDIDO ASISTIDO
	private ArticuloLocalDTO npArticuloLocal;
	private ArticuloLocalPedidoDTO npArticuloLocalPedido;
	
	//Campo para determinar si un articulo aplica precio Mayoreo o Caja segun el local del npCodigoLocal
	private EnumTipoPrecio enumTipoPrecio;
	
	//////////////////////////////////////////////////////////
	///			CAMPOS PARA BUSQUEDA SIMPLE
	//////////////////////////////////////////////////////////
	private String nombreMarca;
	
	///////////////////////////////////////////////////////////////
	///			CAMPO PARA MIGRACION DE ESTRUCTURA LOGISTICA
	//////////////////////////////////////////////////////////////
	private Long codigoUnidadManejo;
	
	
	public Collection<String> getNpCodigosClasificaciones() {
		return npCodigosClasificaciones;
	}
	public void setNpCodigosClasificaciones(
			Collection<String> npCodigosClasificaciones) {
		this.npCodigosClasificaciones = npCodigosClasificaciones;
	}
	public String getNpCodigoEspecial() {
		return npCodigoEspecial;
	}
	public void setNpCodigoEspecial(String npCodigoEspecial) {
		this.npCodigoEspecial = npCodigoEspecial;
	}
	public Double getPrecioSugerido() {
		return precioSugerido;
	}
	public void setPrecioSugerido(Double precioSugerido) {
		this.precioSugerido = precioSugerido;
	}
	public String getNpHabilitarPrecioCaja() {
		return npHabilitarPrecioCaja;
	}
	public void setNpHabilitarPrecioCaja(String npHabilitarPrecioCaja) {
		this.npHabilitarPrecioCaja = npHabilitarPrecioCaja;
	}
	public Collection getNpDetallesPedidos() {
		return npDetallesPedidos;
	}
	public void setNpDetallesPedidos(Collection npDetallesPedidos) {
		this.npDetallesPedidos = npDetallesPedidos;
	}
	public String getNpCodigoClasificacionAnterior() {
		return npCodigoClasificacionAnterior;
	}
	public void setNpCodigoClasificacionAnterior(
			String npCodigoClasificacionAnterior) {
		this.npCodigoClasificacionAnterior = npCodigoClasificacionAnterior;
	}
	public Long getNpStockArticulo() {
		return npStockArticulo;
	}
	public void setNpStockArticulo(Long npStockArticulo) {
		this.npStockArticulo = npStockArticulo;
	}
	public String getNpEstadoStockArticulo() {
		return npEstadoStockArticulo;
	}
	public void setNpEstadoStockArticulo(String npEstadoStockArticulo) {
		this.npEstadoStockArticulo = npEstadoStockArticulo;
	}
	public String getNpEstadoStockArticuloReceta() {
		return npEstadoStockArticuloReceta;
	}
	public void setNpEstadoStockArticuloReceta(String npEstadoStockArticuloReceta) {
		this.npEstadoStockArticuloReceta = npEstadoStockArticuloReceta;
	}
	public String getNpEstadoExistencia() {
		return npEstadoExistencia;
	}
	public void setNpEstadoExistencia(String npEstadoExistencia) {
		this.npEstadoExistencia = npEstadoExistencia;
	}
	public String getNpAlcance() {
		return npAlcance;
	}
	public void setNpAlcance(String npAlcance) {
		this.npAlcance = npAlcance;
	}
	public String getNpAlcanceReceta() {
		return npAlcanceReceta;
	}
	public void setNpAlcanceReceta(String npAlcanceReceta) {
		this.npAlcanceReceta = npAlcanceReceta;
	}
	public String getNpEstadoArticuloSIC() {
		return npEstadoArticuloSIC;
	}
	public void setNpEstadoArticuloSIC(String npEstadoArticuloSIC) {
		this.npEstadoArticuloSIC = npEstadoArticuloSIC;
	}
	public String getNpEstadoArticuloSICReceta() {
		return npEstadoArticuloSICReceta;
	}
	public void setNpEstadoArticuloSICReceta(String npEstadoArticuloSICReceta) {
		this.npEstadoArticuloSICReceta = npEstadoArticuloSICReceta;
	}
	public ArticuloDTO getNpArticuloAnteriorDTO() {
		return npArticuloAnteriorDTO;
	}
	public void setNpArticuloAnteriorDTO(ArticuloDTO npArticuloAnteriorDTO) {
		this.npArticuloAnteriorDTO = npArticuloAnteriorDTO;
	}
	public String getNpNuevoCodigoArticulo() {
		return npNuevoCodigoArticulo;
	}
	public void setNpNuevoCodigoArticulo(String npNuevoCodigoArticulo) {
		this.npNuevoCodigoArticulo = npNuevoCodigoArticulo;
	}
	public String getNpNuevaDescripcionArticulo() {
		return npNuevaDescripcionArticulo;
	}
	public void setNpNuevaDescripcionArticulo(String npNuevaDescripcionArticulo) {
		this.npNuevaDescripcionArticulo = npNuevaDescripcionArticulo;
	}
	public String getNpDetalle() {
		return npDetalle;
	}
	public void setNpDetalle(String npDetalle) {
		this.npDetalle = npDetalle;
	}
	public String getNpCodigoArticuloPadre() {
		return npCodigoArticuloPadre;
	}
	public void setNpCodigoArticuloPadre(String npCodigoArticuloPadre) {
		this.npCodigoArticuloPadre = npCodigoArticuloPadre;
	}
	public String getNpActivarInterfazSIC() {
		return npActivarInterfazSIC;
	}
	public void setNpActivarInterfazSIC(String npActivarInterfazSIC) {
		this.npActivarInterfazSIC = npActivarInterfazSIC;
	}
	public String getNpCodigoTipoArticulo() {
		return npCodigoTipoArticulo;
	}
	public void setNpCodigoTipoArticulo(String npCodigoTipoArticulo) {
		this.npCodigoTipoArticulo = npCodigoTipoArticulo;
	}
	public Long getNpCantidadAProducir() {
		return npCantidadAProducir;
	}
	public void setNpCantidadAProducir(Long npCantidadAProducir) {
		this.npCantidadAProducir = npCantidadAProducir;
	}
	public Long getNpCantidadAProducirFija() {
		return npCantidadAProducirFija;
	}
	public void setNpCantidadAProducirFija(Long npCantidadAProducirFija) {
		this.npCantidadAProducirFija = npCantidadAProducirFija;
	}
	public Integer getNpCantidadTotalRegistros() {
		return npCantidadTotalRegistros;
	}
	public void setNpCantidadTotalRegistros(Integer npCantidadTotalRegistros) {
		this.npCantidadTotalRegistros = npCantidadTotalRegistros;
	}
	public Boolean getNpObtenerCantidadTotalRegistros() {
		return npObtenerCantidadTotalRegistros;
	}
	public void setNpObtenerCantidadTotalRegistros(
			Boolean npObtenerCantidadTotalRegistros) {
		this.npObtenerCantidadTotalRegistros = npObtenerCantidadTotalRegistros;
	}
	public String getNpNuevoCodigoClasificacion() {
		return npNuevoCodigoClasificacion;
	}
	public void setNpNuevoCodigoClasificacion(String npNuevoCodigoClasificacion) {
		this.npNuevoCodigoClasificacion = npNuevoCodigoClasificacion;
	}
	public String getNpEstadoEspecial() {
		return npEstadoEspecial;
	}
	public void setNpEstadoEspecial(String npEstadoEspecial) {
		this.npEstadoEspecial = npEstadoEspecial;
	}
	public String getNpConsultarArticulosCarnes() {
		return npConsultarArticulosCarnes;
	}
	public void setNpConsultarArticulosCarnes(String npConsultarArticulosCarnes) {
		this.npConsultarArticulosCarnes = npConsultarArticulosCarnes;
	}
	public Long getNpCodigoArticuloSIC() {
		return npCodigoArticuloSIC;
	}
	public void setNpCodigoArticuloSIC(Long npCodigoArticuloSIC) {
		this.npCodigoArticuloSIC = npCodigoArticuloSIC;
	}
	public String getNpHabilitarPrecioMayorista() {
		return npHabilitarPrecioMayorista;
	}
	public void setNpHabilitarPrecioMayorista(String npHabilitarPrecioMayorista) {
		this.npHabilitarPrecioMayorista = npHabilitarPrecioMayorista;
	}
	public String getNpSecuencialEstadoPedido() {
		return npSecuencialEstadoPedido;
	}
	public void setNpSecuencialEstadoPedido(String npSecuencialEstadoPedido) {
		this.npSecuencialEstadoPedido = npSecuencialEstadoPedido;
	}
	public String getNpCodigoArticulo() {
		return npCodigoArticulo;
	}
	public void setNpCodigoArticulo(String npCodigoArticulo) {
		this.npCodigoArticulo = npCodigoArticulo;
	}
	public String getNpEstadoError() {
		return npEstadoError;
	}
	public void setNpEstadoError(String npEstadoError) {
		this.npEstadoError = npEstadoError;
	}
	public String getTipoCalculoPrecioFiltro() {
		return tipoCalculoPrecioFiltro;
	}
	public void setTipoCalculoPrecioFiltro(String tipoCalculoPrecioFiltro) {
		this.tipoCalculoPrecioFiltro = tipoCalculoPrecioFiltro;
	}
	public String getEstadoPerecibleRecetaFiltro() {
		return estadoPerecibleRecetaFiltro;
	}
	public void setEstadoPerecibleRecetaFiltro(String estadoPerecibleRecetaFiltro) {
		this.estadoPerecibleRecetaFiltro = estadoPerecibleRecetaFiltro;
	}	
	public String[] getNpClasesArticulo() {
		return npClasesArticulo;
	}
	public void setNpClasesArticulo(String[] npClasesArticulo) {
		this.npClasesArticulo = npClasesArticulo;
	}
	public Collection<String> getNpCodigosInicialesSubclasificacionesAExcluir() {
		return npCodigosInicialesSubclasificacionesAExcluir;
	}
	public void setNpCodigosInicialesSubclasificacionesAExcluir(
			Collection<String> npCodigosInicialesSubclasificacionesAExcluir) {
		this.npCodigosInicialesSubclasificacionesAExcluir = npCodigosInicialesSubclasificacionesAExcluir;
	}
	public Collection<String> getNpCodigosProveedores() {
		return npCodigosProveedores;
	}
	public void setNpCodigosProveedores(Collection<String> npCodigosProveedores) {
		this.npCodigosProveedores = npCodigosProveedores;
	}
	public Double getNpPrecioExtGar() {
		return npPrecioExtGar;
	}
	public void setNpPrecioExtGar(Double npPrecioExtGar) {
		this.npPrecioExtGar = npPrecioExtGar;
	}
	public String getNpcodigoProveedor() {
		return npcodigoProveedor;
	}
	public void setNpcodigoProveedor(String npcodigoProveedor) {
		this.npcodigoProveedor = npcodigoProveedor;
	}
	public Integer getNpCodigoLocal() {
		return npCodigoLocal;
	}
	public void setNpCodigoLocal(Integer npCodigoLocal) {
		this.npCodigoLocal = npCodigoLocal;
	}
	/**
	 * @return the npCodigoArticulos
	 */
	public Collection<ArticuloDTO> getNpCodigoArticulos() {
		return npCodigoArticulos;
	}
	/**
	 * @param npCodigoArticulos the npCodigoArticulos to set
	 */
	public void setNpCodigoArticulos(Collection<ArticuloDTO> npCodigoArticulos) {
		this.npCodigoArticulos = npCodigoArticulos;
	}
	public String getNpEstadoArticuloLocal() {
		return npEstadoArticuloLocal;
	}
	public void setNpEstadoArticuloLocal(String npEstadoArticuloLocal) {
		this.npEstadoArticuloLocal = npEstadoArticuloLocal;
	}
	public String getNpOrderBy() {
		return npOrderBy;
	}
	public void setNpOrderBy(String npOrderBy) {
		this.npOrderBy = npOrderBy;
	}
	public Integer getNpFirstResult() {
		return npFirstResult;
	}
	public void setNpFirstResult(Integer npFirstResult) {
		this.npFirstResult = npFirstResult;
	}
	public Integer getNpMaxResults() {
		return npMaxResults;
	}
	public void setNpMaxResults(Integer npMaxResults) {
		this.npMaxResults = npMaxResults;
	}
	public String getNpEstadoArticulo() {
		return npEstadoArticulo;
	}
	public void setNpEstadoArticulo(String npEstadoArticulo) {
		this.npEstadoArticulo = npEstadoArticulo;
	}
	public String getNpCodigoBarras() {
		return npCodigoBarras;
	}
	public void setNpCodigoBarras(String npCodigoBarras) {
		this.npCodigoBarras = npCodigoBarras;
	}
	public Collection<ArticuloRelacionDTO> getRecetaArticulosRespaldo() {
		return recetaArticulosRespaldo;
	}
	public void setRecetaArticulosRespaldo(
			Collection<ArticuloRelacionDTO> recetaArticulosRespaldo) {
		this.recetaArticulosRespaldo = recetaArticulosRespaldo;
	}
	public Collection<ArticuloRelacionDTO> getRecetaArticulosOriginal() {
		return recetaArticulosOriginal;
	}
	public void setRecetaArticulosOriginal(
			Collection<ArticuloRelacionDTO> recetaArticulosOriginal) {
		this.recetaArticulosOriginal = recetaArticulosOriginal;
	}
	public Collection<ArticuloRelacionDTO> getRecetaArticulosOriginalRespaldo() {
		return recetaArticulosOriginalRespaldo;
	}
	public void setRecetaArticulosOriginalRespaldo(
			Collection<ArticuloRelacionDTO> recetaArticulosOriginalRespaldo) {
		this.recetaArticulosOriginalRespaldo = recetaArticulosOriginalRespaldo;
	}
	public Collection getArticulos() {
		return articulos;
	}
	public void setArticulos(Collection articulos) {
		this.articulos = articulos;
	}
	@Override
	public Boolean getTransferirDatosSIC() {
		return transferirDatosSIC;
	}
	@Override
	public void setTransferirDatosSIC(Boolean transferirDatosSIC) {
		this.transferirDatosSIC = transferirDatosSIC;
	}
	public Date getNpFechaFactura() {
		return npFechaFactura;
	}
	public void setNpFechaFactura(Date npFechaFactura) {
		this.npFechaFactura = npFechaFactura;
	}
	public String[] getNpCodigoBarrasCol() {
		return npCodigoBarrasCol;
	}
	public void setNpCodigoBarrasCol(String[] npCodigoBarrasCol) {
		this.npCodigoBarrasCol = npCodigoBarrasCol;
	}
	public String getNpPedidoPavos() {
		return npPedidoPavos;
	}
	public void setNpPedidoPavos(String npPedidoPavos) {
		this.npPedidoPavos = npPedidoPavos;
	}
	public HashMap<Integer, String> getImpVen() {
		return impVen;
	}
	public void setImpVen(HashMap<Integer, String> impVen) {
		this.impVen = impVen;
	}	
	public void addImpVen(Integer key,String value){
		if(impVen == null){
			impVen = new HashMap<Integer, String>();
		}
		this.impVen.put(key, value);
	}
	public String getImpuestoVenta(Integer codigoImpuestoVenta){
		if(impVen != null){
			return impVen.get(codigoImpuestoVenta);
		}
		return null;
	}
	public HashMap<Integer, String> getImpCom() {
		return impCom;
	}
	public void setImpCom(HashMap<Integer, String> impCom) {
		this.impCom = impCom;
	}	
	public String getImpuestoCompra(Integer codigoImpuestoCompra){
		if(impCom != null){
			return impCom.get(codigoImpuestoCompra);
		}
		return null;
	}
	public void addImpCom(Integer key,String value){
		if(impCom == null){
			impCom = new HashMap<Integer, String>();
		}
		this.impCom.put(key, value);
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public String getNpEstadoAutorizacion() {
		return npEstadoAutorizacion;
	}
	public void setNpEstadoAutorizacion(String npEstadoAutorizacion) {
		this.npEstadoAutorizacion = npEstadoAutorizacion;
	}
	public Long getNpStockArticuloAutorizado() {
		return npStockArticuloAutorizado;
	}
	public void setNpStockArticuloAutorizado(Long npStockArticuloAutorizado) {
		this.npStockArticuloAutorizado = npStockArticuloAutorizado;
	}
	public Long getNpCantidadCanastosReservados() {
		return npCantidadCanastosReservados != null ? npCantidadCanastosReservados : 0;
	}
	public void setNpCantidadCanastosReservados(Long npCantidadCanastosReservados) {
		this.npCantidadCanastosReservados = npCantidadCanastosReservados;
	}
	public Boolean getArticuloAgregado() {
		return articuloAgregado;
	}
	public void setArticuloAgregado(Boolean articuloAgregado) {
		this.articuloAgregado = articuloAgregado;
	}
	/**
	 * @return the plegar
	 */
	public Boolean getPlegar() {
		return plegar;
	}
	/**
	 * @param plegar the plegar to set
	 */
	public void setPlegar(Boolean plegar) {
		this.plegar = plegar;
	}
	/**
	 * @return the proveedoresRelacionados
	 */
	public Collection<ArticuloProveedorDTO> getProveedoresRelacionados() {
		return proveedoresRelacionados;
	}
	/**
	 * @param proveedoresRelacionados the proveedoresRelacionados to set
	 */
	public void setProveedoresRelacionados(Collection<ArticuloProveedorDTO> proveedoresRelacionados) {
		this.proveedoresRelacionados = proveedoresRelacionados;
	}
	
	/**
	 * @return the npArticuloLocal
	 */
	public ArticuloLocalDTO getNpArticuloLocal() {
		return npArticuloLocal;
	}
	
	/**
	 * @param npArticuloLocal the npArticuloLocal to set
	 */
	public void setNpArticuloLocal(ArticuloLocalDTO npArticuloLocal) {
		this.npArticuloLocal = npArticuloLocal;
	}
	public ArticuloLocalPedidoDTO getNpArticuloLocalPedido() {
		return npArticuloLocalPedido;
	}
	public void setNpArticuloLocalPedido(ArticuloLocalPedidoDTO npArticuloLocalPedido) {
		this.npArticuloLocalPedido = npArticuloLocalPedido;
	}
	public EnumTipoPrecio getEnumTipoPrecio() {
		return enumTipoPrecio;
	}
	public void setEnumTipoPrecio(EnumTipoPrecio enumTipoPrecio) {
		this.enumTipoPrecio = enumTipoPrecio;
	}
	/**
	 * @return the nombreMarca
	 */
	public String getNombreMarca() {
		return nombreMarca;
	}
	/**
	 * @param nombreMarca the nombreMarca to set
	 */
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}
	
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}
	
}
