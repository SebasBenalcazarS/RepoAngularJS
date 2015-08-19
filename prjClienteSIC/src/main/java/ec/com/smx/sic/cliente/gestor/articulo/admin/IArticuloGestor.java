package ec.com.smx.sic.cliente.gestor.articulo.admin;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.common.seguridades.autorizacion.IAuthorizationComponent;
import ec.com.smx.corpv2.etiquetado.modelo.dto.TagFormatDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.common.articulo.EnumSubProcesoGuardadoArticulo;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaBusquedaEdicionMasivaArticulos;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.common.articulo.filtros.PlantillaFiltrosBusquedaB2B;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAgrupadorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.DescuentoProveedorArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloCodBarrasEtiquetaMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaCampoMercanciaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.ContenedorArticulo;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloAsignacionLocalVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloGeneralVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;

public interface IArticuloGestor extends IArticuloRegistroGestor {
	
	public void registrarArticuloMasivo(Collection<ArticuloDTO> articuloDTOs, Set<EnumSubProcesoGuardadoArticulo> enumSubProcesoGuardadoArticulo) throws SICException;
		
	public ArticuloVO registrarArticuloPrecioMasivo(Collection<ArticuloDTO> articulos) throws SICException;
	
	public void registrarArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICException;

	public ArticuloDTO obtenerArticuloCodigoBarrasActivo(Integer codigoCompania, String codigoBarras) throws SICException;
	
	public Collection<ArticuloDTO> obtenerArticuloVenta(ArticuloDTO articuloDTO)throws SICException;

	public <x extends SearchDTO & ContenedorArticulo> Collection<x> obtenerArticuloVenta(ContenedorArticulo con, Class<x> clase)throws SICException;
	
	public Collection<ArticuloPrecioDTO> obtenerArticuloPrecio(ArticuloPrecioDTO ap)throws SICException;
	
	public Collection<ArticuloLocalPrecioDTO> obtenerArticuloLocalPrecio(ArticuloLocalPrecioDTO alp)throws SICException;

	public SearchResultDTO<ArticuloDTO> buscarArticulos(ArticuloVO articuloVO, IAuthorizationComponent authorizationComponent) throws SICException;
	
	public void cambiarEstadoArticulo(Collection<ArticuloDTO> articuloDTOCol,String estado,UserDto userDto) throws SICException;
	
	public void cambiarEstadoArticuloProveeedor(Collection<ArticuloProveedorDTO> articuloProveedorDTOCol,String estado,UserDto userDto) throws SICException;
	
	public ArticuloBitacoraCodigoBarrasDTO validarAsignacionCodigoBarras(ArticuloVO articuloVO)throws SICRuleException;
	
	void validarAsignacionCodigoBarras(Integer codigoCompania, String codigoArticulo, String codigoBarras)throws SICRuleException;
	
	public SearchResultDTO<ArticuloDTO> obtenerArticulo(ArticuloDTO articuloDTO) throws SICException;
	
	public SearchResultDTO<ArticuloDTO> obtenerArticulosSinPromocionPorLocal(ArticuloDTO articuloDTO) throws SICException;
	
	public void registrarClaseArticulo(ClaseArticuloDTO claseArticuloDTO) throws SICException;
	
	public void registrarArticuloArchivoCol(Collection<ArticuloDefinicionArchivoDTO> articuloDefinicionArchivoCol)throws SICException;
	
	public void incluirRestriccionesBusquedaArticulo(ArticuloVO articuloFiltro,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException;
	
	public Collection<ArticuloDTO> buscarTodoArticulos(ArticuloVO articuloVO,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX, IAuthorizationComponent authorizationComponent) throws SICException ;
	
	public Collection<ArticuloDTO> buscarTodoArticulosCupon(ArticuloVO articuloVO,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX) throws SICException ;
	
	public Long buscarCantidadArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException;
	
	public Collection<ArticuloEdicionMasivaVO> buscarArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException;
	
	public void cargarCadenaDescuentos(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	public void asignarRelacionesArticuloCosto(ArticuloDTO articuloDTO) throws SICException;
	/**
	 * 
	 * @param locales
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return
	 * @throws SICException
	 */
	public void validarCantidadCuponesActivosLocal(ArticuloVO articuloVO) throws SICException;
	public SearchResultDTO<ArticuloDTO> buscarArticulosSimple(ArticuloVO articuloVO,Set<EnumTipoRelacionArticulo> relacionArticulos,Integer maximoArticulos) throws SICException;
	
	public void cargarRelacion(ArticuloDTO articuloDTO,  EnumTipoRelacionArticulo... tiposRelacion) throws SICException;
	
	public void registrarArticulos(Collection<ArticuloDTO> articuloDTOs) throws SICException;
	
	public SearchResultDTO<ArticuloAlcanceEST> obtenerArticulosLocalAlcance(ArticuloVO articuloVO) throws SICException;
	
	
	/**
	 * Metodo que genera y envia por ftp  un archivo generado con la informacion de etiquetas
	 * @param articuloEtiquetaMercanciaDTO
	 * @param UserDto usuario que usa la aplicacion
	 * @param remoteHost host del cliente
	 * @throws SICException
	 */
	void generarArchivoImpresionEtiquetaMercancias(Collection<ArticuloEtiquetaMercanciaDTO> articuloEtiquetaMercanciaDTOCol,TagFormatDTO formatoEtiqueta,UserDto userDto,String remoteHost,String nombreBatParametro,String nombreTxtParametro)  throws SICException;
	
	public String obtenerCodigoBarrasActivoPorArticulo(String codigoArticulo,Integer codigoCompania) throws SICException;
	
	public Collection<String> obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> artUniMnjCol) throws SICException;
	
	public Collection<ArticuloDTO> obtenerArticuloPorUnidadesManejoCodBarras(Integer compania, String codigoBarras) throws SICException;
	
	/**
	 * Verifica que una caracteristica dinamica exista en una clasificacion
	 * 
	 * @param codigoClasificacion
	 * @param codigoTipoCaracteristica
	 * @param codigoValorCaracteristica
	 * @param codigoCompania
	 * @return
	 */
	Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, String codigoValorCaracteristica, Integer codigoCompania);
	
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, Integer codigoCompania) throws SICException;
	
	public void registrarArticuloEtiquetaMercancia(ArticuloVO articuloVO,Boolean esCreacion)throws SICException;
	
	/*
	 * Obtiene los campos necesarios para la etiqueta de mercancia 
	 */
	public VistaCampoMercanciaDTO obtenerCamposEtiquetaMercancia(String codigoArticulo, Integer codigoCompania) throws SICException;
	
	public Boolean esArticuloImportado(String codigoArticulo, Integer codigoCompania)throws SICException;
	
	public Collection<ArticuloAsignacionLocalVO> obtenerArticuloLocal(ArticuloID articuloId , Integer tipoAreaTrabajoTic , String tipoAreaTrabajoValor , Boolean consultarCamposAsignacion)throws SICException;
	
	/**
	 * Metodo para la integracion de la fecha de sic para  etiquetado mercancia
	 * @author aquingaluisa	
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws Exception
	 */
	public String integrarDatosRecepcionArticuloSIC(Integer codigoCompania, String codigoBarras) throws Exception;
	
	public VistaArticuloCodBarrasEtiquetaMercanciaDTO obtenerMercanciaporCodigoBarras(String codigoBarras, Integer codigoCompania)throws SICException;

	void registrarArticuloClase(ArticuloVO articuloVO) throws SICException;

	EnumTipoPrecio obtenerTipoPrecioLocal(ArticuloDTO articuloDTO) throws SICException;

	void registrarArticuloProveedor(ArticuloVO articuloVO, Boolean esCreacion);

	void registrarArticuloMaterial(ArticuloVO articuloVO, Boolean esCreacion) throws SICException;

	SearchResultDTO<ArticuloDTO> buscarArticulosB2B(ArticuloVO articuloVO) throws SICException;

	void incluirRestriccionesBusquedaArticuloB2B(ArticuloVO articuloFiltro, PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException;

	Collection<ArticuloDTO> buscarTodoArticulosB2B(ArticuloVO articuloVO, PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException;

	void validarPreciosCostos(Integer presentacion, Boolean ventaPrecioAfiliado, Double porcentajeNA, Double costoBruto, Double precioBase, Double pvp, Collection<ArticuloImpuestoDTO> articuloImpuestos, Collection<DescuentoProveedorArticuloDTO> descuentosProveedor, Set<EnumCaracteristicaDinamica> caracteristicasDinamicas) throws SICRuleException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoTipoAgrupador
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloAgrupadorDTO> obtenerArticuloAgrupadorPorCodigoTipoAgrupador(Integer codigoCompania, String codigoArticulo, Integer codigoTipoAgrupador) throws SICException;

	
	public <T> void enviarArchivoFtp(Collection<T> objectToGenererateFile,
			TagFormatDTO formatoEtiqueta, String usuario, String remoteHost,
			Integer puertoFtp, String nombreBatParametro,
			String nombreTxtParametro, String directorioRemotoBat,
			String usuarioFtp, String passwordFtp,
			String directorioRemotoFtp) throws SICException;
	
	public ArticuloGeneralVO obtenerArticuloEtiqueta(Integer codigoCompania , String codigoBarras , String codigoFuncionario , String ... clasificaciones) throws SICException;
	
	public SearchResultDTO<ArticuloDTO> buscarArticuloBasico(Criterion criterioBusqueda , Integer firstResult ,Integer maxResults , Boolean findNum , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;
	
	/**
	 * Permite validar un conjunto de reglas para indicar si el articulo aplica precio de mayoreo o no
	 * @param articuloDTO Articulo a validar
	 * @return True si valida las reglas, False en caso contrario
	 * @throws SICException
	 */
	public Boolean validarAplicaMayoreo(ArticuloDTO articuloDTO) throws SICException;
	
	/**
	 * Permite obtener informacion de articulos
	 * @param codigosArticulo Codigos de los articulos que se obtiene la informacion
	 * @return Lista de articulos
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticulos(Collection<String> codigosArticulo) throws SICException;
	
	/**
	 * Permite obtener el articuloDTO con informacion general como: codigo barra, costos etc.
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @param codigoProveedores
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerInformacionGeneral(Integer codigoCompania, String[] codigoArticulos, String[] codigoProveedores)throws SICException;
	
	Collection<ArticuloDTO> obtenerInformacionArticulo(Integer codigoCompania, String[] codigoArticulos, String[] codigoBarras, String[] codigoClasificacion, String[] codigoProveedores, EnumTipoRelacionArticulo... tiposRelacion);
	
	/**
	 * Permite encontrar costos por artículo
	 * @param
	 * @return 
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerCostosArticulos(String[] codigoArticulos) throws SICException;
	
	/**
	 * Permite encontrar costos netos por artículo
	 * @param
	 * @return 
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerCostosNetosArticulos(String[] codigoArticulos, String[] codigoProveedor) throws SICException;

	

	/**
	 * Permite obtener precios de uno o varios articulos dados sus codigos
	 * @param codigocompania
	 * @param codigos
	 * @return 
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerPreciosPorCodigo(Integer codigoCompania, String[] codigoArticulos) throws SICException;
	
	/**
	 * Permite obtener los articulos que comparten codigos de barra en bitacora
	 * @param codigocompania
	 * @param codigoBarra
	 * @return 
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticulosCodigoBarras(Integer codigoCompania, String codbar, String codart) throws SICException;


	/**
	 * Permite obtener una lista de articulos para validar su relacion
	 * @param articuloVO
	 * @param codigoArticulo
	 * @param codigoReferncia
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> validarArticuloRelacion(ArticuloVO articuloVO)throws SICException;

	void inactivarCupones(Integer codigoCompania, String codigoArticulo, String userId);
	
	public String registrarArticuloEAN(String codigoBarras , Integer codigoCompania , String idUsuario , Boolean validarEan)throws SICException;
	
	/**
	 * Almacena o actualiza el articulo precio enviado
	 * @param articulosPrecio
	 * @throws SICException
	 */
	public void registrarPrecioArticuloPorTipoPrecio(Collection<ArticuloPrecioDTO> articulosPrecio) throws SICException;
	

	/**
	 * @param codigoCompania
	 * @param codigosArticulo
	 * @param tiposPrecios
	 * @return
	 * @throws SICException
	 */
	List<ArticuloPrecioDTO> obtenerDatosArticulosPreciosPorTiposPrecios(Integer codigoCompania, Set<String> codigosArticulo, Set<EnumTipoPrecio> tiposPrecios) throws SICException;

	
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
	Collection<ArticuloDTO> obtenerArticulosSinPaginar (ArticuloVO articuloVO, Integer codigoCompania, Boolean obtenerRelaciones, Collection <String> colClasificacionLeyMercado)throws SICException;
	
	/**
	 * devuelve un articulo en base al codigoCompania y codigoArticulo
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO buscarArticuloId(Integer codigoCompania, String codigoArticulo)throws SICException;
}
