package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;
import java.util.Date;

import org.hibernate.criterion.Criterion;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.articulo.EnumTipoRelacionArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClaseArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloEdicionMasivaVO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.BusquedaSimpleArticuloVO;

public interface IArticuloDAO {

	public abstract SearchResultDTO<ArticuloDTO> obtenerArticulosAgrupados(ArticuloVO articuloVO,Integer maximoArticulos) throws SICException;
	
	public abstract SearchResultDTO<ArticuloDTO> obtenerArticulosAgrupados(ArticuloVO articuloVO) throws SICException;

	public abstract int cambiarEstadoArticulo(Collection<ArticuloDTO> articuloDTOCol, String estado, UserDto userDto);

	public abstract int cambiarEstadoArticuloProveeedor(Collection<ArticuloProveedorDTO> articuloProveedorDTOCol, String estado, UserDto userDto);

	/**
	 * Obtiene la lista de artículos que no están en promoción
	 * @param articuloDTO		el/los par&aacute;metros de consulta
	 * @return					la informaci&oacute;n solicitada
	 * @throws SICException		en caso de error al ejecutar el m&eacute;todo
	 */
	public abstract SearchResultDTO<ArticuloDTO> obtenerArticulosSinPromocionPorLocal(ArticuloDTO articuloDTO) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param estado			- valor del campe estado
	 * @param campoEstado		- Nombre del campo que hace referencia al estado
	 * @param clase				- Clase de la entidad que se desea actualizar
	 */
	public abstract void actualizarEstadoRelacion(Integer codigoCompania, String codigoArticulo, String campoArticulo, String estado, String campoEstado, 
			Class<? extends SearchDTO> clase)throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 */
	public abstract int completarCodificacionArticulo(ArticuloDTO articuloDTO) throws SICException;

	public void actualizarEstadoArticuloRelacion(Integer codigoCompania, String codigoArticulo, String nuevoEstado, String codigoProveedor, String filtroEstado, String userId) throws SICException;
	
	public void actualizarDatosPrecioDescuentos(Integer codigoCompania, String codigoArticulo, String userId)  throws SICException;
	
	/**
	 * Permite obtener registros de art&iacute;culo local a partir de los filtros de b&uacute;squeda de art&iacute;culos
	 * @author dalmeida
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloAlcanceEST> obtenerArticulosLocalAlcance(ArticuloVO articuloVO) throws SICException;
	
	/**
	 * Actualiza el campo aplicaRegistroSanitario que pertenecen a un padre
	 * @param userId
	 * @param codigoClasificacion
	 * @throws SICException
	 */
	public void actualizarAplicaRegistroSanitario(String userId, String codigoClasificacion)throws SICException;
	
	/**
	 * Actualiza el campo aplicaRegistroSanitario que pertenecen a un padre
	 * @param userId
	 * @param codigoClasificacion
	 * @throws SICException
	 */
	public void actualizarAplicaRegistroSanitario(String userId, String codigoClasificacion, Integer codigoAplicaRegistroSanitario, String valorAplicaRegistroSanitario) throws SICException;
	
	/**
	 * Retorna un listado de los codigos de los articulos que tienen relacionado una clasificacion especifica
	 * @param clasificacion
	 * @return
	 * @throws SICException
	 */
	public Collection<String> obtenerCodigosArticulosClasificaciones(ClasificacionDTO clasificacion) throws SICException;
	/**
	 * Retorna un listado de los codigos de los articulos que tienen relacionado una subclasificacion especifica
	 * @param subClasificacion
	 * @return
	 * @throws SICException
	 */
	public Collection<String> obtenerCodigosArticulosSubClasificaciones(SubClasificacionDTO subClasificacion) throws SICException;
	
	public Long obtenerPrototipoAlcance(Integer codigoCompania , String codigoArticulo)throws SICException;
	
	public Collection<ArticuloDTO> buscarArticulosPersonalizado(ArticuloDTO articuloDTO) throws SICException;
	
	/**
	 * Retorna un listado de las estructuras WRT relacionadas con una estructura comercial
	 * @param estComercialDTO
	 * @return Coleccion clasificacionDTO
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> obtenerEstWRTRelacionada(ClasificacionDTO estComercialDTO)throws SICException;
	
	/**
	 * Metodo para devolver una estructura comercial por medio de una estructura WRT
	 * @param estWRT
	 * @return ClasificacionDTO
	 * @throws SICException
	 */
	public Collection<ClasificacionDTO> obtenerECdesdeWRT(ClasificacionDTO estWRT)throws SICException;
	/**
	 * Metodo para validar que existe almenos un articulo de la clasificacion dada que tenga alguno de los estados PEN, CON, AUT
	 * @param clasificacionDTO
	 * @return
	 * @throws SICException
	 */
	public Boolean existeArticuloUnificarCosto(ClasificacionDTO clasificacionDTO)throws SICException;
	
	public Collection<ArticuloEdicionMasivaVO> obtenerArticulosEdicion(ArticuloVO articuloVO , Criterion criterion)throws SICException;
	
	public Long obtenerCantidadArticulosEdicion(ArticuloVO articuloVO , Criterion criterion)throws SICException;
	
	public Integer buscarCantidadArticulosEdicionInterna(String sqlQuery)throws SICException;
	
	/**
	 * Verifica que una caracteristica dinamica exista en una clasificaci�n
	 * 
	 * @param codigoClasificacion
	 * @param codigoTipoCaracteristica
	 * @param codigoValorCaracteristica
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, String codigoValorCaracteristica, Integer codigoCompania) throws SICException;
	
	/**
	 * Metodo que permite saber si existe la caracteristica dinamica para la clasificacion
	 * @param codigoClasificacion
	 * @param codigoTipoCaracteristica
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Boolean obtenerExistenciaCaracteristicaDinamica(String codigoClasificacion, Integer codigoTipoCaracteristica, Integer codigoCompania) throws SICException;
	/**
	 * Valida si existe una clasificacion que tiene igual descripcion
	 * @param clasificacion
	 * @return
	 * @throws SICException
	 */
	public Boolean validarDescripcionClasificacion(ClasificacionDTO clasificacion)throws SICException;
	/**
	 * Valida si tiene subclasificaciones con la misma descripcion
	 * @param subcla
	 * @return
	 * @throws SICException
	 */
	public Collection<SubClasificacionDTO> validarDescripcionSubclasificacion( SubClasificacionDTO subcla)throws SICException;

	/**
	 * M\u00E9todo que permite actualizar el c\u00F3digo de cliente asociado al art\u00EDculo
	 * @author mgranda
	 * @param codigoCompania
	 * @param userId
	 * @param codigoClienteImportacion
	 * @param codigosArticulo
	 * @return Retorna el total de art\u00EDculos actualizados.
	 * @throws SICException
	 */
	Integer actualizarClienteImportacionArticulo(Integer codigoCompania, String userId, Long codigoClienteImportacion, String... codigosArticulo) throws SICException;
	
	/**
	 * devuelve un articulo en base a una plantilla
	 * @return unidad de manejo dto
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> buscarArticulos(ArticuloDTO articuloDTO)throws SICException;

	Date obtenerFechaCreacionArticulo(Integer codigoCompania, String codigoArticulo);
	
	public SearchResultDTO<ArticuloDTO> buscarArticuloBasico(Criterion criterioBusqueda , Integer firstResult ,Integer maxResults , Boolean findNum , BusquedaSimpleArticuloVO busquedaSimpleArticuloVO)throws SICException;

	/**
	 * Metodo que permite obtener la información general de artículos, costos
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @param codigoProveedores
	 * @return
	 */
	Collection<ArticuloDTO> obtenerInformacionGeneral(Integer codigoCompania, String[] codigoArticulos, String[] codigoProveedores);
	
	
	public Collection<ArticuloDTO> obtenerPreciosPorCodigo(Integer codigoCompania,String[] codigoArticulos);

	
	/**
	 * Permite obtener informacion de articulos
	 * @param codigosArticulo Codigos de los articulos que se obtiene la informacion
	 * @return Lista de articulos
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticulos(Collection<String> codigosArticulo) throws SICException;
	
	/**
	 * Metodo que permite obtener costos de los artículos
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @param codigoProveedores
	 * @return
	 */
	public Collection<ArticuloDTO> obtenerCostosArticulos(String[] codigoArticulos)throws SICException;

	Collection<ArticuloDTO> obtenerInformacionArticulo(Integer codigoCompania, String[] codigoArticulos, String[] codigoBarras, String[] codigoClasificacion, String[] codigoProveedores, EnumTipoRelacionArticulo... tiposRelacion);

	/**
	 * Metodo que permite obtener costos de los artículos
	 * @param codigoCompania
	 * @param codigoArticulos
	 * @param codigoProveedores
	 * @return
	 */
	public Collection<ArticuloDTO> obtenerCostosNetosArticulos(String[] codigoArticulos,String[] codigoProveedor)throws SICException;
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoEstado
	 * @param habilitaFechaCreacion
	 * @param codigoLineaComercial
	 * @throws SICException
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
	 * Metodo para buscar un articulo con su unidad de mandejo 
	 * @param valorUniMan
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> buscarArticulo(Integer valorUniMan, String codigoBarras)throws SICException;

	/**
	 * Metodo que permite obtener el estado de un articulo
	 * @author mgranda
	 * @param codigoCompania
	 * @param codigoArticulo	 
	 * @return
	 */
	String obtenerEstadoArticulo(Integer codigoCompania, String codigoArticulo);

	void inactivarArticulo(Integer codigoCompania, String codigoArticulo, String userId) throws SICException;
	
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
	 * Obtiene la coleccion de clases de articulo
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public Collection<ClaseArticuloDTO> consultarClaseArticulos(Integer codigoCompania)throws SICException;
	/**
	 * Obtiene el articulo por id
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO buscarArticuloId(Integer codigoCompania, String codigoArticulo)throws SICException;
	
	//public Collection<ArticuloLocalPrecioDTO> obtenerPreciosPorLocal(Integer codigoCompania , String codigoArticulo) throws SICException;
	
//	/**
//	 * metodo que retorna las areas de trabajo por prototipo
//	 */
//	public Collection<GrupoAreaTrabajoDTO> cargarLocalesPrototipoAlcance(Integer codigoCompania, Long codigoGrupoTrabajo,Boolean asignacionMasivaArticulos);
}