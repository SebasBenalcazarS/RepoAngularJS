package ec.com.smx.sic.cliente.servicio.articulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.common.seguridades.autorizacion.IAuthorizationComponent;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.corpv2.etiquetado.modelo.dto.TagFormatDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.articulo.EnumSubProcesoGuardadoArticulo;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoPrecio;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.common.articulo.etiquetado.ArticuloInformacionEtiquetado;
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

/**
 * Interface para la administraci\u00F3n de art\u00EDculos con las procesos que se puede realizar desde la capa de usuario de forma remota
 * 
 * @author fmunoz
 * @since J2SDK5.0
 */
public interface IArticuloServicio {
	/**
	 * Registra un art\u00EDculo en la base de datos 
	 * @param articuloVO
	 */
	public ArticuloVO registrarArticulo(ArticuloVO articuloVO) throws SICException;
	
	public void registrarArticuloMasivo(Collection<ArticuloDTO> articuloDTOs, Set<EnumSubProcesoGuardadoArticulo> enumSubProcesoGuardadoArticulo) throws SICException;

	public ArticuloVO registrarArticuloPrecioMasivo(Collection<ArticuloDTO> articulos) throws SICException;
	/**
	 * 
	 * @param articuloUnidadManejoDTO
	 * @throws SICRuleException
	 */
	public void registrarArticuloUnidadManejo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO)throws SICRuleException;
	/**
	 * 
	 * @param articuloDefinicionArchivoDTO
	 * @throws SICRuleException
	 */
	public void registrarArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO)throws SICRuleException;
	
	/**
	 * Realiza el registro de una condicion comercial para un art\u00EDculo (ARTICULO-PROVEEDOR-CLASIFICACION)
	 * @param articuloVO
	 */
	public void registrarArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	public void registrarArticuloRegistroSanitario(Collection<ArticuloRegistroSanitarioDTO> artRegSans,Collection<ArticuloProveedorDTO> artPros,Collection<ArticuloDTO> articuloDTOs) throws SICException;
	
	/**
	 * 
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticuloVenta(ArticuloDTO articuloDTO)throws SICException;
	
	public <x extends SearchDTO & ContenedorArticulo> Collection<x> obtenerArticuloVenta(ContenedorArticulo contenedorArticulo, Class<x> clase)throws SICException;
	
	/**
	 * 
	 * @param articuloDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloPrecioDTO> obtenerArticuloPrecio(ArticuloPrecioDTO ap)throws SICException;
	/**
	 * 
	 * @param articuloPrecioDTO
	 * @param cargarRelacionArticuloPrecio
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloLocalPrecioDTO> obtenerArticuloLocalPrecio(ArticuloLocalPrecioDTO alp)throws SICException;

	/**
	 * Obtiene el art\u00EDculo activo en base al c\u00F3digo de barras, si no encuentra uno activo devuelve nulo
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO obtenerArticuloCodigoBarrasActivo(Integer codigoCompania, String codigoBarras) throws SICException;
	
	public SearchResultDTO<ArticuloDTO> buscarArticulos(ArticuloVO articuloVO, IAuthorizationComponent authorizationComponent) throws SICException;
	
	public void cambiarEstadoArticulo(Collection<ArticuloDTO> articuloDTOCol,String estado,UserDto userDto) throws SICException;
	
	public void cambiarEstadoArticuloProveeedor(Collection<ArticuloProveedorDTO> articuloProveedorDTOCol,String estado,UserDto userDto) throws SICException;
	
	public ArticuloBitacoraCodigoBarrasDTO validarAsignacionCodigoBarras(ArticuloVO articuloVO)throws SICRuleException;
	
	void validarAsignacionCodigoBarras(Integer codigoCompania, String codigoArticulo, String codigoBarras)throws SICRuleException;
	
	public Collection<ArticuloUnidadManejoProveedorDTO> obtenerDescuentosUnidadManejo(Collection<String> codArticuloProveedorCol,Integer codigoCompania) throws SICException;

	public Collection<DescuentoProveedorArticuloDTO> obtenerDescuentosArticuloProv(Collection<String> codArticuloProveedorCol,Integer codigoCompania) throws SICException;

	public SearchResultDTO<ArticuloDTO> obtenerArticulo(ArticuloDTO articuloDTO) throws SICException;
	
	public SearchResultDTO<ArticuloDTO> obtenerArticulosSinPromocionPorLocal(ArticuloDTO articuloDTO) throws SICException;
	
	public void registrarClaseArticulo(ClaseArticuloDTO claseArticuloDTO) throws SICException;
	
	public void registrarArticuloArchivoCol(Collection<ArticuloDefinicionArchivoDTO> articuloDefinicionArchivoCol)throws SICException;

	public void incluirRestriccionesBusquedaArticulo(ArticuloVO articuloFiltro,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX) throws SICException;

	public void incluirRestriccionesBusquedaArticuloB2B(ArticuloVO articuloFiltro,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException;

	public Collection<ArticuloDTO> buscarTodoArticulos(ArticuloVO articuloVO,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX, IAuthorizationComponent authorizationComponent) throws SICException;
	
	public Collection<ArticuloDTO> buscarTodoArticulosCupon(ArticuloVO articuloVO,IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX) throws SICException;
	
	public Long buscarCantidadArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException;;
	
	public Collection<ArticuloEdicionMasivaVO> buscarArticulosEdicionMasiva(IPlantillaBusquedaEdicionMasivaArticulos plantillaFiltrosBusquedaMAX) throws SICException;
	
	public void cargarCadenaDescuentos(ArticuloProveedorDTO articuloProveedorDTO) throws SICException;
	
	public void asignarRelacionesArticuloCosto(ArticuloDTO articuloDTO) throws SICException;
	
	public void validarCantidadCuponesActivosLocal(ArticuloVO articuloVO) throws SICException;
	
	public SearchResultDTO<ArticuloDTO> buscarArticulosSimple(ArticuloVO articuloVO,Set<EnumTipoRelacionArticulo> relacionArticulos,Integer maximoArticulos) throws SICException;
	
	public void cargarRelacion(ArticuloDTO articuloDTO,  EnumTipoRelacionArticulo... tiposRelacion) throws SICException;
	
	Collection<ArticuloUnidadManejoDTO> obtenerUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException;
	
	Integer obtenerNumeroUnidadesManejoActivasPorArticulo(ArticuloDTO articuloDTO) throws SICException;
	
	public Collection<CatalogoValorDTO> obtenerAgrupadoresPadres(Integer... codigoCatalogoTipo) throws SICException;
	
	public Collection<CatalogoValorDTO> obtenerAgrupadoresHijos(CatalogoValorDTO catalogoValorDTO) throws SICException;
	
	public SearchResultDTO<ArticuloDTO> buscarArticulosB2B(ArticuloVO articuloVO) throws SICException;
	
	public Collection<ArticuloDTO> buscarTodoArticulosB2B(ArticuloVO articuloVO,PlantillaFiltrosBusquedaB2B plantillaFiltrosBusqueda) throws SICException;
	
	
	/**
	 * Metodo que genera y envia por ftp  un archivo generado con la informaci?n de etiquetas
	 * @param articuloEtiquetaMercanciaDTO
	 * @param UserDto usuario que usa la aplicacion
	 * @param remoteHost host del cliente
	 * @throws SICException
	 */
	void generarArchivoImpresionEtiquetaMercancias(ArticuloEtiquetaMercanciaDTO articuloEtiquetaMercanciaDTO,TagFormatDTO formatoEtiqueta,UserDto userDto,String remoteHost,String nombreBatParametro,String nombreTxtParametro)  throws SICException;
	void generarArchivoImpresionEtiquetaMercancias(Collection<ArticuloEtiquetaMercanciaDTO> articuloEtiquetaMercanciaDTOCol,TagFormatDTO formatoEtiqueta,UserDto userDto,String remoteHost,String nombreBatParametro,String nombreTxtParametro)  throws SICException;
	
	public String obtenerCodigoBarrasActivoPorArticulo(String codigoArticulo,Integer codigoCompania) throws SICException;
	
	public String registrarArticuloMasivamente(ArrayList<ArticuloEdicionMasivaVO> articuloCol, Boolean envioMail)throws SICException;
	
	/**
	 * M\u00E9todo que obtiene la informaci\u00F3n del Art\u00EDculo ley de mercado
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	ArticuloLeyMercadoDTO obtenerArticuloLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * M\u00E9todo que obtiene la informaci\u00F3n del Hist\u00F3rico art\u00EDculo ley de mercado
	 * @param first
	 * @param pageSize
	 * @param sortField
	 * @param sortOrder
	 * @param filters
	 * @return
	 * @throws SICException
	 */
	List<ArticuloBitacoraLeyMercadoDTO> obtenerHistoricoLeyMercado(int first, int pageSize, String sortField, Map<String, String> filters) throws SICException;
	
	/**
	 * M\u00E9todo que obtiene el total de registro del Hist\u00F3rico art\u00EDculo ley de mercado
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	Long obtenerTotalHistoricoLeyMercado(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	public void registrarArticuloEdicionMasiva(ArticuloEdicionMasivaVO edicionMasivaVO)throws SICException;
	
	public void registroArticulosMasivoInterno(String sqlQuery , ArticuloEdicionMasivaVO plantillaRegistro , String usuarioModificacion , Integer numArticulos , String fechaModificacion , Integer codigoCompania)throws SICException;
	
	public Integer consultarNumeroArticulosRegistrados(String sqlQuery) throws SICException;
	
	public void registrarArticuloInternamente(Collection<ArticuloEdicionMasivaVO> articuloCol , Integer totalArticulos , Long fechaModificacion)throws SICException;
	
	public void registrarArticuloIntegracion(ArticuloEdicionMasivaVO edicionMasivaVO)throws SICException;
	
	Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, String codigoValorCaracteristica, Integer codigoCompania) throws SICException;
	
	
	/**
	 * Metodo que permite saber si existe la caracteristica dinamica
	 * @param codigoClasificacion
	 * @param codigoTipoCaracteristica
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, Integer codigoCompania) throws SICException;
	/**
	 * Metodo  para guardar los datos de mercancias
	 * @param articuloVO
	 * @param esCreacion
	 * @throws SICException
	 */
	void registrarArticuloEtiquetaMercancia(ArticuloVO articuloVO,Boolean esCreacion)throws SICException;

	public Collection<String> obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> artUniMnjCol) throws SICException;
	
	public Collection<ArticuloDTO> obtenerArticuloPorUnidadesManejoCodBarras(Integer compania, String codigoBarras) throws SICException;
	
	/**
	 * Envia un mail luego de procesarlos articulos que hayan sido modificados sus prototipos
	 * @param codigoCompania
	 * @param userId
	 * @param articulosNoRegistrados
	 * @param datosRegistrados
	 * @throws SICException
	 */
	void envioMailEdicionMasivaArticulo(Integer codigoCompania, String userId, Collection<ArticuloEdicionMasivaVO> articulosNoRegistrados , Boolean datosRegistrados)throws SICException;
	
	void envioMailEdicionInternaArticulo(Integer codigoCompania, String userId, Integer datosRegistrados , Long fechaModificacion)throws SICException;
	
	/**
	 * Consulta los precios diferenciados por articulo
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param estado
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloPrecioDiferenciadoDTO> obtenerArticulosPrecioDiferenciado(Integer codigoCompania, String codigoArticulo, String estado) throws SICException;
	
	/**
	 * Metodo para guardar el precio diferenciado desde la edicion de articulos
	 * @param articuloPrecioDiferenciadoDTO
	 * @throws SICException
	 */
//	void registrarCollArticuloPrecioDiferenciado(Collection<ArticuloPrecioDiferenciadoDTO> articuloPrecioDiferenciadoDTOCol, ArticuloGestionPrecioDTO articuloGestionPrecioConflictos) throws SICException;
	
	public VistaCampoMercanciaDTO obtenerCamposEtiquetaMercancia(String codigoArticulo, Integer codigoCompania) throws SICException;
	/**
	 * Metodo que valida si  el articulo es imporatado o nacional dependiendo de la clasificacion
	 * @param codigoArticulo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
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
	
	
	EnumTipoPrecio obtenerTipoPrecioLocal(ArticuloDTO articuloDTO) throws SICException;
	
//	List<String> buscarCodigosArticulos(ArticuloVO articuloVO, IPlantillaBusquedaArticuloPrecioDiferenciado plantillaBusquedaArticulos);

//	void procesarPrecioDiferenciado(Integer codigoCompania) throws SICException;

	
	/**
	 * METODO QUE DEVUELVE UNA ESTRUCTURA CON LA INFORMACION DEL ARTICULO:
	 * APLICA TRANSGENICO
	 * APLICA REGISTRO SANITARIO
	 * POSEE SEMAFORO
	 * @param codigoCompaniaO
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public ArticuloInformacionEtiquetado obtenerInformacionTraRegSanSem(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	
	/**Articulo Clase*/
	
	/**
	 * Permite obtener el total de registros en Historico de clase para el articulo
	 * @param codigoCompania Codigo de la compania
	 * @param codigoArticulo Codigo del articulo
	 * @return Total de registros encontrados
	 * @throws SICException
	 */
	public Long obtenerTotalHistoricoClase(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	/**
	 * Permite obtener el listado de Historico de Clase
	 * @param firts pagina
	 * @param pageSize Valores por pagina
	 * @param sortField Campo por el que se ordena
	 * @param sortOrder Tipo de orden
	 * @param filters Filtros a usar
	 * @return Lista de valores con historico de clase
	 * @throws SICException
	 */
	public List<ArticuloBitacoraClaseDTO> obtenerHistoricoClase(int firts, int pageSize, String sortField, Map<String, String> filters) throws SICException;
	
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
	
	/**
	 * Permite obtener el ArticuloImportacion de un determinado Art\u00EDculo y Proveedor
	 * @author bcueva
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param codigoArticulo C\u00F3digo del Art\u00EDculo
	 * @param codigoProveedor C\u00F3digo del Proveedor
	 * @return
	 * @throws SICException
	 */
	ArticuloImportacionDTO obtenerArticuloImportacion(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException;
	
	/**
	 * Permite verifiacar si un art\u00EDculo contiene c\u00F3digo disney
	 * @author bcueva
	 * @param codigoCompania C\u00F3digo de la Compan\u00EDa
	 * @param codigoArticulo C\u00F3digo del Art\u00EDculo
	 * @param codigoProveedor C\u00F3digo del Proveedor
	 * @return
	 * @throws SICException
	 */
	Boolean tieneImpuestoDisney(Integer codigoCompania, String codigoArticulo, String codigoProveedor) throws SICException;
	public ArticuloGeneralVO obtenerArticuloEtiqueta(Integer codigoCompania , String codigoBarras , String codigoFuncionario , String ... clasificaciones) throws SICException;
	
	public SearchResultDTO<ArticuloDTO> buscarArticuloBasico(Criterion criterioBusqueda , Integer firstResult ,Integer maxResults , Boolean findNum , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO) throws SICException;
	
	/**
	 * Permite validar un conjunto de reglas para indicar si el articulo aplica o no precio de mayoreo
	 * @param articuloDTO Articulo a validar
	 * @return True si valida las reglas, False en caso contrario
	 * @throws SICException
	 */
	public Boolean validarAplicaMayoreo(ArticuloDTO articuloDTO) throws SICException;
	
	public Collection<ArticuloDTO> obtenerPreciosPorCodigo(Integer codigoCompania,String[] codigoArticulos);
	

	/**
	 * Permite obtener informacion de articulos
	 * @param codigosArticulo Codigos de los articulos que se obtiene la informacion
	 * @return Lista de articulos
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticulos(Collection<String> codigosArticulo) throws SICException;
	
	/**
	 * Obtiene colleccion de articuloDTO con informacion general como codigoBarra, costos etc
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @param codigoProveedores
	 * @return
	 */
	public Collection<ArticuloDTO> obtenerInformacionGeneral(Integer codigoCompania, String[] codigoArticulos, String[] codigoProveedores) throws SICException;

	/**
	 * Obtiene costos por articulo
	 * @param codigoArticulos
	 * @return
	 */
	public Collection<ArticuloDTO> obtenerCostosArticulos(String[] codigoArticulos)throws SICException;
	
	/**
	 * Obtiene costos netos por articulo
	 * @param codigoArticulos
	 * @return
	 */
	public Collection<ArticuloDTO> obtenerCostosNetosArticulos(String[] codigoArticulos, String[] codigoProveedor)throws SICException;
	/**
	 * Cambia de estado los artículos no validados
	 * @param codigoCompania
	 * @param codigoEstado
	 * @param habilitaFechaCreacion
	 * @param codigoLineaComercial
	 */
	public void invalidarArticulosFecha(Integer codigoCompania,String codigoEstado,Integer habilitaFechaCreacion,String codigoLineaComercial);
	
	/**
	 * 
	 * @param articuloVO
	 * @param codigoArticulo
	 * @param codigoReferncia
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> validarArticuloRelacion(ArticuloVO articuloVO)throws SICException;
	
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
	 * Obtiene los articulos relacionados con un mismo codigo de barras
	 * @param codigoArticulos
	 * @return
	 */
	public Collection<ArticuloDTO> obtenerArticuloPorCodBarras(Integer compania, String codbar, String codart) throws SICException;
	
	/**
	 * Metodo que permite obtener la informacion del articulo
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @param codigoBarras
	 * @param codigoProveedores
	 * @param codigoFuncionario
	 * @param clasificaciones
	 * @param tiposRelacion
	 * @return
	 * @throws SICException
	 * @author eharo
	 * @author mgranda
	 */
	public Collection<ArticuloDTO> obtenerInformacionArticulo(Integer codigoCompania, String[] codigoArticulos, String[] codigoBarras, String[] codigoProveedores, String codigoFuncionario , String [] clasificaciones, EnumTipoRelacionArticulo... tiposRelacion) throws SICException;
	
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
	 * Metodo que permite obtener las clasificaciones de un proveedor en las que se debe visualizar los precios en B2B
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	Collection<String> obtenerClasificacionesConPreciosB2B(Integer codigoCompania, String codigoProveedor) throws SICException;
	
	/**
	 * Se obtiene un  objeto  articulo  simple
	 * @param codigoBarras
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO busquedaArticuloSimple(String codigoBarras , Integer codigoCompania)throws SICException;
	
}
