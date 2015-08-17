package ec.com.smx.sic.articulo.servicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.annotations.NoTransaction;
import ec.com.kruger.utilitario.dao.commons.annotations.ReadOnlyTransaction;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.common.seguridades.autorizacion.IAuthorizationComponent;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.etiquetado.modelo.dto.TagFormatDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.annotation.HibernateTransaction;
import ec.com.smx.sic.cliente.common.articulo.EnumSubProcesoGuardadoArticulo;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.common.articulo.etiquetado.ArticuloInformacionEtiquetado;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaBusquedaEdicionMasivaArticulos;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.common.articulo.filtros.PlantillaFiltrosBusquedaB2B;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloEdicionMasivaGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.admin.calculo.ICalculoBusquedaArticuloGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloBitacora.IArticuloBitacoraGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloPrecioDiferenciado.IArticuloPrecioDiferenciadoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.articuloagrupador.IArticuloAgrupadorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.clase.IArticuloClaseGestor;
import ec.com.smx.sic.cliente.gestor.articulo.etiquetado.IArticuloControlEtiquetadoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.ley.podermercado.IArticuloLeyMercadoGestor;
import ec.com.smx.sic.cliente.gestor.articulo.proveedor.IArticuloProveedorGestor;
import ec.com.smx.sic.cliente.gestor.articulo.tareaprogramada.IArticuloTareaProgramadaGestor;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.IArticuloUnidadManejoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDiferenciadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloCodBarrasEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCampoMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.clase.ArticuloBitacoraClaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloBitacoraLeyMercadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.ley.podermercado.ArticuloLeyMercadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.ContenedorArticulo;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloAsignacionLocalVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloGeneralVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio;

public class ArticuloServicio implements IArticuloServicio {

	private IArticuloGestor articuloGestor;
	private IArticuloProveedorGestor articuloProveedorGestor;
	private IArticuloAgrupadorGestor articuloAgrupadorGestor;
	private IArticuloUnidadManejoGestor unidadManejoGestor;
	private IArticuloEdicionMasivaGestor articuloEdicionMasivaGestor;
	private IArticuloControlEtiquetadoGestor articuloControlEtiquetadoGestor;
	private IArticuloPrecioDiferenciadoGestor articuloPrecioDiferenciadoGestor;
	private IArticuloClaseGestor articuloClaseGestor;
	private IArticuloLeyMercadoGestor articuloLeyMercadoGestor;
	private IArticuloBitacoraGestor articuloBitacoraGestor;
	private IArticuloTareaProgramadaGestor articuloTareaProgramadaGestor;
	private ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor;
		
	
	public ArticuloDTO obtenerArticuloCodigoBarrasActivo(Integer codigoCompania, String codigoBarras) throws SICException {
		return this.articuloGestor.obtenerArticuloCodigoBarrasActivo(codigoCompania, codigoBarras);
	}

	public Collection<ArticuloLocalPrecioDTO> obtenerArticuloLocalPrecio(ArticuloLocalPrecioDTO alp) throws SICException {
		return this.articuloGestor.obtenerArticuloLocalPrecio(alp);
	}

	public Collection<ArticuloPrecioDTO> obtenerArticuloPrecio(ArticuloPrecioDTO ap) throws SICException {
		return this.articuloGestor.obtenerArticuloPrecio(ap);
	}

	public Collection<ArticuloDTO> obtenerArticuloVenta(ArticuloDTO articuloDTO) throws SICException {
		return this.articuloGestor.obtenerArticuloVenta(articuloDTO);
	}

	public <x extends SearchDTO & ContenedorArticulo> Collection<x> obtenerArticuloVenta(ContenedorArticulo contenedorArticulo, Class<x> clase)throws SICException {
		return this.articuloGestor.obtenerArticuloVenta(contenedorArticulo, clase);
	}
	
	public ArticuloVO registrarArticulo(ArticuloVO articuloVO) throws SICException {
		return this.articuloGestor.registrarArticulo(articuloVO);
	}
	
	public synchronized void registrarArticuloMasivo(Collection<ArticuloDTO> articuloDTOs, Set<EnumSubProcesoGuardadoArticulo> enumSubProcesoGuardadoArticulo) throws SICException{
		this.articuloGestor.registrarArticuloMasivo(articuloDTOs, enumSubProcesoGuardadoArticulo);
	}
	
	public synchronized ArticuloVO registrarArticuloPrecioMasivo(Collection<ArticuloDTO> articulos) throws SICRuleException{
		return this.articuloGestor.registrarArticuloPrecioMasivo(articulos);
	}
	public void registrarArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO) throws SICRuleException {
		this.articuloGestor.registrarArticuloArchivo(articuloDefinicionArchivoDTO);
	}

	public synchronized void registrarArticuloRegistroSanitario(Collection<ArticuloRegistroSanitarioDTO> artRegSans,Collection<ArticuloProveedorDTO> artPros, Collection<ArticuloDTO> articuloDTOs) throws SICException{
		this.articuloGestor.registrarArticulos(articuloDTOs);
	}
	
	public synchronized void registrarArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO) throws SICException {
		this.articuloProveedorGestor.registrarArticuloProveedor(articuloProveedorDTO);
	}

	public void registrarArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO) throws SICRuleException {
		this.unidadManejoGestor.registrarArticuloUnidadManejo(articuloUnidadManejoDTO);
	}
	
	public SearchResultDTO<ArticuloDTO> buscarArticulos(ArticuloVO articuloVO, IAuthorizationComponent authorizationComponent) throws SICException{
		
		return this.articuloGestor.buscarArticulos(articuloVO, authorizationComponent);
	}
	
	public void cambiarEstadoArticulo(Collection<ArticuloDTO> articuloDTOCol,String estado,UserDto userDto) throws SICException{
		this.articuloGestor.cambiarEstadoArticulo(articuloDTOCol, estado, userDto);
	}
	
	public void cambiarEstadoArticuloProveeedor(Collection<ArticuloProveedorDTO> articuloProveedorDTOCol,String estado,UserDto userDto) throws SICException{
		this.articuloGestor.cambiarEstadoArticuloProveeedor(articuloProveedorDTOCol, estado, userDto);
	}
	
	public ArticuloBitacoraCodigoBarrasDTO validarAsignacionCodigoBarras(ArticuloVO articuloVO)throws SICRuleException{
		return this.articuloGestor.validarAsignacionCodigoBarras(articuloVO);
	}
	
	@Override
	public void validarAsignacionCodigoBarras(Integer codigoCompania, String codigoArticulo, String codigoBarras) throws SICRuleException {
		this.articuloGestor.validarAsignacionCodigoBarras(codigoCompania, codigoArticulo, codigoBarras);
	}

	public Collection<ArticuloUnidadManejoProveedorDTO> obtenerDescuentosUnidadManejo(Collection<String> codArticuloProveedorCol,Integer codigoCompania) throws SICException{
		return articuloProveedorGestor.obtenerDescuentosUnidadManejo(codArticuloProveedorCol,codigoCompania);
		
	}
	
	public Collection<DescuentoProveedorArticuloDTO> obtenerDescuentosArticuloProv(Collection<String> codArticuloProveedorCol,Integer codigoCompania) throws SICException{
		return articuloProveedorGestor.obtenerDescuentosArticuloProv(codArticuloProveedorCol,codigoCompania);
	}
	
	public SearchResultDTO<ArticuloDTO> obtenerArticulo(ArticuloDTO articuloDTO) throws SICException{
		return articuloGestor.obtenerArticulo(articuloDTO);
	}

	public SearchResultDTO<ArticuloDTO> obtenerArticulosSinPromocionPorLocal(ArticuloDTO articuloDTO) throws SICException{
		return articuloGestor.obtenerArticulosSinPromocionPorLocal(articuloDTO);
	}
	
	public void registrarClaseArticulo(ClaseArticuloDTO claseArticuloDTO) throws SICException{
		articuloGestor.registrarClaseArticulo(claseArticuloDTO);
	}
	
	public void registrarArticuloArchivoCol(Collection<ArticuloDefinicionArchivoDTO> articuloDefinicionArchivoCol)throws SICException{
		articuloGestor.registrarArticuloArchivoCol(articuloDefinicionArchivoCol);
	}
	
	@NoTransaction
	public String registrarArticuloMasivamente(ArrayList<ArticuloEdicionMasivaVO> articuloCol, Boolean envioMail)throws SICException{
		return articuloEdicionMasivaGestor.registrarArticulo(articuloCol, envioMail);
	}
	
	public ArticuloLeyMercadoDTO obtenerArticuloLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException {
		 return articuloLeyMercadoGestor.obtenerArticuloLeyMercado(codigoCompania, codigoArticulo);
	}
	
	@Override
	public List<ArticuloBitacoraLeyMercadoDTO> obtenerHistoricoLeyMercado(int first, int pageSize, String sortField, Map<String, String> filters) throws SICException {
		return articuloLeyMercadoGestor.obtenerHistoricoLeyMercado(first, pageSize, sortField, filters) ;
	}
	
	@Override
	public Long obtenerTotalHistoricoLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException {
		return articuloLeyMercadoGestor.obtenerTotalHistoricoLeyMercado(codigoCompania, codigoArticulo) ;
	}
	
	/**
	 * servicio que registra los articulos en la edicion masiva
	 */
	public void registrarArticuloEdicionMasiva(ArticuloEdicionMasivaVO edicionMasivaVO)throws SICException{
		articuloEdicionMasivaGestor.registrarArticuloMasivamente(edicionMasivaVO);
	}
	
	@NoTransaction
	public void registroArticulosMasivoInterno(String sqlQuery , ArticuloEdicionMasivaVO plantillaRegistro , String usuarioModificacion , Integer numArticulos , String fechaModificacion , Integer codigoCompania)throws SICException{
		articuloEdicionMasivaGestor.registroArticulosMasivoInterno(sqlQuery , plantillaRegistro , usuarioModificacion , numArticulos , fechaModificacion , codigoCompania);
	}
	
	public Integer consultarNumeroArticulosRegistrados(String sqlQuery) throws SICException{
		return articuloEdicionMasivaGestor.consultarNumeroArticulosRegistrados(sqlQuery);
	}
	
	@NoTransaction
	public void registrarArticuloInternamente(Collection<ArticuloEdicionMasivaVO> articuloCol , Integer totalArticulos , Long fechaModificacion)throws SICException{
		articuloEdicionMasivaGestor.registrarArticuloInternamente(articuloCol , totalArticulos , fechaModificacion);
	}
	
	public void registrarArticuloIntegracion(ArticuloEdicionMasivaVO edicionMasivaVO)throws SICException{
		articuloEdicionMasivaGestor.registrarArticuloIntegracion(edicionMasivaVO);
	}
	
	@Override
	public Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException {
		return this.unidadManejoGestor.obtenerUnidadesManejoActivasPorArticulo(articuloDTO);
	}
	
	@NoTransaction
	public void asignarRelacionesArticuloCosto(ArticuloDTO articuloDTO) throws SICException{
		articuloGestor.asignarRelacionesArticuloCosto(articuloDTO);
	}
	
	@NoTransaction
	public void cargarRelacion(ArticuloDTO articuloDTO,  EnumTipoRelacionArticulo... tiposRelacion) throws SICException{
		articuloGestor.cargarRelacion(articuloDTO, tiposRelacion);
	}

	/**
	 * @param articuloGestor the articuloGestor to set
	 */
	public void setArticuloGestor(IArticuloGestor articuloGestor) {
		this.articuloGestor = articuloGestor;
	}
	
	@NoTransaction
	public void incluirRestriccionesBusquedaArticulo(ArticuloVO articuloFiltro,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException{
		this.articuloGestor.incluirRestriccionesBusquedaArticulo(articuloFiltro, plantillaFiltrosBusqueda);
	}
	
	@NoTransaction
	public void incluirRestriccionesBusquedaArticuloB2B(ArticuloVO articuloFiltro,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException{
		this.articuloGestor.incluirRestriccionesBusquedaArticuloB2B(articuloFiltro, plantillaFiltrosBusqueda);
	}
	
	public SearchResultDTO<ArticuloDTO> buscarArticulosB2B(ArticuloVO articuloVO) throws SICException {
		return this.articuloGestor.buscarArticulosB2B(articuloVO);
	}
	
	public Collection<ArticuloDTO> buscarTodoArticulosB2B(ArticuloVO articuloVO,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException {
		return this.articuloGestor.buscarTodoArticulosB2B(articuloVO,plantillaFiltrosBusqueda);
	}
	
	public Collection<ArticuloDTO> buscarTodoArticulos(ArticuloVO articuloVO,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX, IAuthorizationComponent authorizationComponent) throws SICException {
		return this.articuloGestor.buscarTodoArticulos(articuloVO,plantillaFiltrosBusquedaMAX, authorizationComponent);
	}
	
	public Collection<ArticuloDTO> buscarTodoArticulosCupon(ArticuloVO articuloVO,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX) throws SICException {
		return this.articuloGestor.buscarTodoArticulosCupon(articuloVO,plantillaFiltrosBusquedaMAX);
	}
	
	/**
	 * servicio que busca la cantidad de articulos en la edicion masiva
	 */
	public Long buscarCantidadArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException{
		return this.articuloGestor.buscarCantidadArticulosEdicionMasiva(plantillaFiltrosBusquedaMAX);
	}
	
	/**
	 * servicio que busca los articulos en la edicion masiva
	 */
	public Collection<ArticuloEdicionMasivaVO> buscarArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException{
		return this.articuloGestor.buscarArticulosEdicionMasiva(plantillaFiltrosBusquedaMAX);
	}

	public void cargarCadenaDescuentos(ArticuloProveedorDTO articuloProveedorDTO) throws SICException{
		this.articuloGestor.cargarCadenaDescuentos(articuloProveedorDTO);
	}
	
	public SearchResultDTO<ArticuloDTO> buscarArticulosSimple(ArticuloVO articuloVO,Set<EnumTipoRelacionArticulo> relacionArticulos,Integer maximoArticulos) throws SICException {
		return this.articuloGestor.buscarArticulosSimple(articuloVO, relacionArticulos,maximoArticulos);
	}
	
	/**
	 * 
	 * @param locales
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return
	 * @throws SICException
	 */
	@Override
	public void validarCantidadCuponesActivosLocal(ArticuloVO articuloVO) throws SICException{
		this.articuloGestor.validarCantidadCuponesActivosLocal(articuloVO);
	}
	
	@Override
	public Integer obtenerNumeroUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException {
		return this.unidadManejoGestor.obtenerNumeroUnidadesManejoActivasPorArticulo(articuloDTO);
	}
	
	public Collection<CatalogoValorDTO> obtenerAgrupadoresPadres(Integer... codigoCatalogoTipo){
		return this.articuloAgrupadorGestor.obtenerAgrupadoresPadres(codigoCatalogoTipo);
	}
	
	public Collection<CatalogoValorDTO> obtenerAgrupadoresHijos(CatalogoValorDTO catalogoValorDTO){ 
		return this.articuloAgrupadorGestor.obtenerAgrupadoresHijos(catalogoValorDTO);
	}

	
	@Override
	public void registrarArticuloEtiquetaMercancia(ArticuloVO articuloVO,Boolean esCreacion)throws SICException{
		this.articuloGestor.registrarArticuloEtiquetaMercancia(articuloVO, esCreacion);
	}
	
	/**
	 * @return the articuloProveedorGestor
	 */
	public IArticuloProveedorGestor getArticuloProveedorGestor() {
		return articuloProveedorGestor;
	}

	/**
	 * @param articuloProveedorGestor the articuloProveedorGestor to set
	 */
	public void setArticuloProveedorGestor(IArticuloProveedorGestor articuloProveedorGestor) {
		this.articuloProveedorGestor = articuloProveedorGestor;
	}
	
	public void setArticuloAgrupadorGestor(IArticuloAgrupadorGestor articuloAgrupadorGestor) {
		this.articuloAgrupadorGestor = articuloAgrupadorGestor;
	}

	/**
	 * @param unidadManejoGestor the unidadManejoGestor to set
	 */
	public void setUnidadManejoGestor(IArticuloUnidadManejoGestor unidadManejoGestor) {
		this.unidadManejoGestor = unidadManejoGestor;
	}

	@Override
	@HibernateTransaction
	public void generarArchivoImpresionEtiquetaMercancias(ArticuloEtiquetaMercanciaDTO articuloEtiquetaMercanciaDTO,TagFormatDTO formatoEtiqueta,UserDto userDto,String remoteHost,String nombreBatParametro,String nombreTxtParametro)  throws SICException{
		Collection<ArticuloEtiquetaMercanciaDTO> articuloEtiquetaMercanciaDTOCol = new ArrayList<ArticuloEtiquetaMercanciaDTO>();
		articuloEtiquetaMercanciaDTOCol.add(articuloEtiquetaMercanciaDTO);
		this.articuloGestor.generarArchivoImpresionEtiquetaMercancias(articuloEtiquetaMercanciaDTOCol,formatoEtiqueta,userDto, remoteHost,nombreBatParametro,nombreTxtParametro);
	}
	
	@Override
	@HibernateTransaction
	public void generarArchivoImpresionEtiquetaMercancias(Collection<ArticuloEtiquetaMercanciaDTO> articuloEtiquetaMercanciaDTOCol,TagFormatDTO formatoEtiqueta,UserDto userDto,String remoteHost,String nombreBatParametro,String nombreTxtParametro)  throws SICException{
		this.articuloGestor.generarArchivoImpresionEtiquetaMercancias(articuloEtiquetaMercanciaDTOCol,formatoEtiqueta,userDto, remoteHost,nombreBatParametro,nombreTxtParametro);
	}
	public Collection<String> obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> artUniMnjCol) throws SICException{
		return this.articuloGestor.obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(articuloVO, artUniMnjCol);
	}
	
	public Collection<ArticuloDTO> obtenerArticuloPorUnidadesManejoCodBarras(Integer compania, String codigoBarras) throws SICException{
		return this.articuloGestor.obtenerArticuloPorUnidadesManejoCodBarras(compania, codigoBarras);
	}

	public String obtenerCodigoBarrasActivoPorArticulo(String codigoArticulo,Integer codigoCompania) throws SICException{
		return this.articuloGestor.obtenerCodigoBarrasActivoPorArticulo(codigoArticulo, codigoCompania);
	}
	
	@Override
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, String codigoValorCaracteristica, Integer codigoCompania)  throws SICException {
		return this.articuloGestor.obtenerExistenciaCaracteristicaDinamica(codigoClasificacion, codigoTipoCaracteristica, codigoValorCaracteristica, codigoCompania);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#obtenerExistenciaCaracteristicaDinamica(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, Integer codigoCompania) throws SICException {
		return this.articuloGestor.obtenerExistenciaCaracteristicaDinamica(codigoClasificacion, codigoTipoCaracteristica, codigoCompania);
	}

	/**
	 * @param articuloEdicionMasivaGestor the articuloEdicionMasivaGestor to set
	 */
	public void setArticuloEdicionMasivaGestor(IArticuloEdicionMasivaGestor articuloEdicionMasivaGestor) {
		this.articuloEdicionMasivaGestor = articuloEdicionMasivaGestor;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#envioMailEdicionMasivaArticulo(java.lang.Integer, java.lang.String, java.util.Collection, java.lang.Boolean)
	 */
	public void envioMailEdicionMasivaArticulo(Integer codigoCompania, String userId, Collection<ArticuloEdicionMasivaVO> articulosNoRegistrados , Boolean datosRegistrados)throws SICException{
		this.articuloEdicionMasivaGestor.envioMailEdicionMasivaArticulo(codigoCompania, userId, articulosNoRegistrados, datosRegistrados);
	}
	
	public void envioMailEdicionInternaArticulo(Integer codigoCompania, String userId, Integer datosRegistrados , Long fechaModificacion)throws SICException{
		this.articuloEdicionMasivaGestor.envioMailEdicionInternaArticulo(codigoCompania, userId, datosRegistrados, fechaModificacion);
	}
	
	@Override
	public VistaCampoMercanciaDTO obtenerCamposEtiquetaMercancia(String codigoArticulo, Integer codigoCompania) throws SICException {
		return this.articuloGestor.obtenerCamposEtiquetaMercancia(codigoArticulo, codigoCompania);
	}
	
	@Override
	public VistaArticuloCodBarrasEtiquetaMercanciaDTO obtenerMercanciaporCodigoBarras(String codigoBarras, Integer codigoCompania)throws SICException{
		return this.articuloGestor.obtenerMercanciaporCodigoBarras(codigoBarras, codigoCompania);
	}
	public Boolean esArticuloImportado(String codigoArticulo, Integer codigoCompania) throws SICException{
		return this.articuloGestor.esArticuloImportado(codigoArticulo, codigoCompania);
	}
	
	public String integrarDatosRecepcionArticuloSIC(Integer codigoCompania, String codigoBarras) throws Exception{
		return this.articuloGestor.integrarDatosRecepcionArticuloSIC(codigoCompania, codigoBarras);
	}
	
	public Collection<ArticuloAsignacionLocalVO> obtenerArticuloLocal(ArticuloID articuloId , Integer tipoAreaTrabajoTic , String tipoAreaTrabajoValor , Boolean consultarCamposAsignacion)throws SICException{
		return this.articuloGestor.obtenerArticuloLocal(articuloId , tipoAreaTrabajoTic , tipoAreaTrabajoValor , consultarCamposAsignacion);
	}
	
	
	@Override
	public EnumTipoPrecio obtenerTipoPrecioLocal(ArticuloDTO articuloDTO) throws SICException{
		return this.articuloGestor.obtenerTipoPrecioLocal(articuloDTO);
	}
	
	/**ARTICULO CLASE**/
	
	public Long obtenerTotalHistoricoClase(Integer codigoCompania, String codigoArticulo) throws SICException{
		return articuloClaseGestor.obtenerTotalHistoricoClase(codigoCompania, codigoArticulo);
	}
	
	public List<ArticuloBitacoraClaseDTO> obtenerHistoricoClase(int first, int pageSize, String sortField, Map<String, String> filters) throws SICException{
		return this.articuloClaseGestor.obtenerHistoricoClase(first, pageSize, sortField, filters);
	}
	
	public Collection<ArticuloAgrupadorDTO> obtenerArticuloAgrupadorPorCodigoTipoAgrupador(Integer codigoCompania, String codigoArticulo, Integer codigoTipoAgrupador) throws SICException {
		return this.articuloGestor.obtenerArticuloAgrupadorPorCodigoTipoAgrupador(codigoCompania, codigoArticulo, codigoTipoAgrupador);
	}
	
	public void setArticuloClaseGestor(IArticuloClaseGestor articuloClaseGestor) {
		this.articuloClaseGestor = articuloClaseGestor;
	}

	public void setArticuloLeyMercadoGestor(IArticuloLeyMercadoGestor articuloLeyMercadoGestor) {
		this.articuloLeyMercadoGestor = articuloLeyMercadoGestor;
	}
	
	public ArticuloImportacionDTO obtenerArticuloImportacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException{
		return this.articuloProveedorGestor.obtenerArticuloImportacion(codigoCompania, codigoArticulo, codigoProveedor);
	}
	
	public Boolean tieneImpuestoDisney(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException {
		return this.articuloProveedorGestor.tieneImpuestoDisney(codigoCompania, codigoArticulo, codigoProveedor);
	}

	/**
	 *CONTROL ETIQUETADO INICIO 
	 */
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#obtenerInformacionTraRegSanSem(java.lang.Integer, java.lang.String)
	 */
	@Override
	@ReadOnlyTransaction
	public ArticuloInformacionEtiquetado obtenerInformacionTraRegSanSem(Integer codigoCompania, String codigoArticulo) throws SICException {
		return this.articuloControlEtiquetadoGestor.obtenerInformacionTraRegSanSem(codigoCompania, codigoArticulo);
	}
	
	/**
	 * @param articuloControlEtiquetadoGestor the articuloControlEtiquetadoGestor to set
	 */
	public void setArticuloControlEtiquetadoGestor(IArticuloControlEtiquetadoGestor articuloControlEtiquetadoGestor) {
		this.articuloControlEtiquetadoGestor = articuloControlEtiquetadoGestor;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#enviarArchivoFtp(java.util.Collection, ec.com.smx.corpv2.etiquetado.modelo.dto.TagFormatDTO, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	@NoTransaction
	public <T> void enviarArchivoFtp(Collection<T> objectToGenererateFile, TagFormatDTO formatoEtiqueta, String usuario, String remoteHost, Integer puertoFtp, String nombreBatParametro, String nombreTxtParametro, String directorioRemotoBat, String usuarioFtp, String passwordFtp, String directorioRemotoFtp) throws SICException {
		this.articuloGestor.enviarArchivoFtp(objectToGenererateFile, formatoEtiqueta, usuario, remoteHost, puertoFtp, nombreBatParametro, nombreTxtParametro, directorioRemotoBat, usuarioFtp, passwordFtp, directorioRemotoFtp);
		
	}
	
	/**
	 * CONTROL ETIQUETADO FIN
	 */

	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#obtenerArticuloPrecioDiferenciado(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@Override
	public Collection<ArticuloPrecioDiferenciadoDTO> obtenerArticulosPrecioDiferenciado(Integer codigoCompania, String codigoArticulo, String estado) throws SICException {
		return this.articuloPrecioDiferenciadoGestor.obtenerArticulosPrecioDiferenciado(codigoCompania, codigoArticulo, estado);
	}
	
	public void setArticuloPrecioDiferenciadoGestor(IArticuloPrecioDiferenciadoGestor articuloPrecioDiferenciadoGestor) {
		this.articuloPrecioDiferenciadoGestor = articuloPrecioDiferenciadoGestor;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.servicio.articulo.IArticuloServicio#guardarCollArticuloPrecioDiferenciado(java.util.Collection)
	 */
//	@Override
//	public void registrarCollArticuloPrecioDiferenciado(Collection<ArticuloPrecioDiferenciadoDTO> articuloPrecioDiferenciadoDTOCol, ArticuloGestionPrecioDTO articuloGestionPrecioConflictos) throws SICException {
//		this.articuloPrecioDiferenciadoGestor.registrarCollArticuloPrecioDiferenciado(articuloPrecioDiferenciadoDTOCol, articuloGestionPrecioConflictos);
//	}
	
	public SearchResultDTO<ArticuloDTO> buscarArticuloBasico(Criterion criterioBusqueda , Integer firstResult ,Integer maxResults , Boolean findNum , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException{
		return articuloGestor.buscarArticuloBasico(criterioBusqueda , firstResult , maxResults , findNum , busquedaSimpleArticuloVO);
	}
	
//	@Override
//	public List<String> buscarCodigosArticulos(ArticuloVO articuloVO, IPlantillaBusquedaArticuloPrecioDiferenciado plantillaBusquedaArticulos){
//		return this.articuloPrecioDiferenciadoGestor.buscarCodigosArticulos(articuloVO, plantillaBusquedaArticulos);
//	}

//	public void setAccionArticuloPrecioDiferenciadoGestor(IAccionArticuloPrecioDiferenciadoGestor accionArticuloPrecioDiferenciadoGestor) {
//		this.accionArticuloPrecioDiferenciadoGestor = accionArticuloPrecioDiferenciadoGestor;
//	}
	
//	@Override
//	public void procesarPrecioDiferenciado(Integer codigoCompania)throws SICException{
//		this.accionArticuloPrecioDiferenciadoGestor.procesarPrecioDiferenciado(codigoCompania);
//	}
	
	public Boolean validarAplicaMayoreo(ArticuloDTO articuloDTO) throws SICException{
		return this.articuloGestor.validarAplicaMayoreo(articuloDTO);
	}
	
	public Collection<ArticuloDTO> obtenerArticulos(Collection<String> codigosArticulo) throws SICException{
		return this.articuloGestor.obtenerArticulos(codigosArticulo);
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerInformacionGeneral(Integer codigoCompania, String[] codigoArticulos, String[] codigoProveedores) throws SICException {
		return this.articuloGestor.obtenerInformacionGeneral(codigoCompania, codigoArticulos, codigoProveedores);
	}
	
	/**
	 * metodo que obtiene la informacion de costos articulo
	 */
	public Collection<ArticuloDTO> obtenerCostosArticulos(String[] codigoArticulos) throws SICException{
		return articuloGestor.obtenerCostosArticulos(codigoArticulos);
	}
	
	/**
	 * metodo que obtiene la informacion de costos netos articulo
	 */
	public Collection<ArticuloDTO> obtenerCostosNetosArticulos(String[] codigoArticulos, String[] codigoProveedor) throws SICException{
		return articuloGestor.obtenerCostosNetosArticulos(codigoArticulos, codigoProveedor);
	}
	
	/**
	 * metodo que cambia de estado articulos no validados
	 */
	@Override
	public void invalidarArticulosFecha(Integer codigoCompania,String codigoEstado,Integer habilitaFechaCreacion,String codigoLineaComercial) throws SICException{
		 articuloTareaProgramadaGestor.invalidarArticulosFecha(codigoCompania,codigoEstado,habilitaFechaCreacion,codigoLineaComercial);
	}
	
	public void setArticuloTareaProgramadaGestor(IArticuloTareaProgramadaGestor articuloTareaProgramadaGestor) {
		this.articuloTareaProgramadaGestor = articuloTareaProgramadaGestor;
	}
	

	@Override
	public Collection<ArticuloDTO> obtenerPreciosPorCodigo(Integer codigoCompania, String[] codigoArticulos) {
		return this.articuloGestor.obtenerPreciosPorCodigo(codigoCompania, codigoArticulos);
	}
	
	/**
	 * 
	 */
	@Override
	public Collection<ArticuloDTO> validarArticuloRelacion(ArticuloVO articuloVO)throws SICException{
		return this.articuloGestor.validarArticuloRelacion(articuloVO);
	}

	@Override
	@HibernateTransaction
	public void registrarPrecioArticuloPorTipoPrecio(Collection<ArticuloPrecioDTO> articulosPrecio) throws SICException {
		this.articuloGestor.registrarPrecioArticuloPorTipoPrecio(articulosPrecio);		
	}


	@Override
	public List<ArticuloPrecioDTO> obtenerDatosArticulosPreciosPorTiposPrecios(Integer codigoCompania, Set<String> codigosArticulo, Set<EnumTipoPrecio> tiposPrecios) throws SICException {
		return this.articuloGestor.obtenerDatosArticulosPreciosPorTiposPrecios(codigoCompania, codigosArticulo, tiposPrecios);
	}
	

	
	public IArticuloBitacoraGestor getArticuloBitacoraGestor() {
		return articuloBitacoraGestor;
	}
	
	public void setArticuloBitacoraGestor(IArticuloBitacoraGestor articuloBitacoraGestor) {
		this.articuloBitacoraGestor = articuloBitacoraGestor;
	}

	/**
	 * @author rali
	 * servicio que realiza la busqueda de artículos historicamente relacionados por su codigo de barras.
	 */
	@Override
	public Collection<ArticuloDTO> obtenerArticuloPorCodBarras(Integer compania, String codbar, String codart) throws SICException {
		return this.articuloGestor.obtenerArticulosCodigoBarras(compania, codbar, codart);
	}

	@Override
	public ArticuloGeneralVO obtenerArticuloEtiqueta(Integer codigoCompania, String codigoBarras, String codigoFuncionario, String... clasificaciones) throws SICException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Collection<ArticuloDTO> obtenerInformacionArticulo(Integer codigoCompania, String[] codigoArticulos, String[] codigoBarras, String[] codigoProveedores, String codigoFuncionario, String[] clasificaciones, EnumTipoRelacionArticulo... tiposRelacion) throws SICException {
		// TODO Auto-generated method stub
		return this.articuloGestor.obtenerInformacionArticulo(codigoCompania, codigoArticulos, codigoBarras, clasificaciones, codigoProveedores, tiposRelacion);
	}
	
	
	/**
	 * Metodo que permite obtener las clasificaciones de un proveedor en las que se debe visualizar los precios en B2B
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<String> obtenerClasificacionesConPreciosB2B(Integer codigoCompania, String codigoProveedor)  throws SICException {
		return this.articuloProveedorGestor.obtenerClasificacionesConPreciosB2B(codigoCompania, codigoProveedor);
	}
	/**
	 * Obtiene la coleccion de articulos en base del articuloVO
	 * @param articuloVO
	 * @param codigoCompania
	 * @param obtenerRelaciones valor booleano que trae las relaciones de ArticuloDTO
	 * @param colClasificacionLeyMercado clasificaciones a las aplica la ley de mercado
	 * @return
	 * @throws SICException
	 * @author derazo
	 */
	@Override
	public Collection<ArticuloDTO> obtenerArticulosSinPaginar (ArticuloVO articuloVO, Integer codigoCompania, Boolean obtenerRelaciones, Collection <String> colClasificacionLeyMercado)throws SICException{
		return this.articuloGestor.obtenerArticulosSinPaginar(articuloVO, codigoCompania, obtenerRelaciones, colClasificacionLeyMercado);
	}
			
	public void setCalculoBusquedaArticuloGestor(ICalculoBusquedaArticuloGestor calculoBusquedaArticuloGestor) {
		this.calculoBusquedaArticuloGestor = calculoBusquedaArticuloGestor;
	}
	
	@Override
	public ArticuloDTO busquedaArticuloSimple(String codigoBarras, Integer codigoCompania) throws SICException {
		return calculoBusquedaArticuloGestor.busquedaArticuloSimple(codigoBarras, codigoCompania);
	}
}