package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.sql.Timestamp;
import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

/**
 * 
 * @author cortiz
 *
 */
public interface IUbicacionDAO {

	/**
	 * Permite la busqueda de la ubicacion de los articulos en las areas de trabajo
	 * @param artUMDTO
	 * @param areaSublugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	Collection<DetalleSeccionDTO> buscaUbicacion(ArticuloUnidadManejoDTO artUMDTO, AreaSublugarTrabajoDTO areaSublugarTrabajoDTO)throws SICException;

	/**
	 * Permite la busqueda de ubicacions disponibles
	 * @param articuloUnidadManejoDTO
	 * @param areaDTO
	 * @return
	 * @throws SICException
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> buscarDisponibilidadUbicacion(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Integer codigoAreaTrabajo,Integer codigoAreaSubbodega)throws SICException;
	
	/**
	 * Permite obtener el paller de un articulo
	 * @param artUnMan
	 * @return
	 * @throws SICException
	 */
	public ArticuloUnidadManejoDTO buscarPaletArticulo(ArticuloUnidadManejoDTO artUnMan)throws SICException;
	
	/**
	 * permite consultar si existe la ubicacion articulo
	 * @param articuloUnidadManejoDTO
	 * @param detalleSeccionDTO
	 * @return
	 * @throws SICException
	 */
	public AsignacionArticuloUnidadManejoDTO buscarUbicacionArticulo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO,DetalleSeccionDTO detalleSeccionDTO)throws SICException;
	
	/**
	 * Permite actualizar la cantidad de articulo ubicacion
	 * @param asignacionArticuloUnidadManejoDTO
	 * @param cantidad
	 * @param fechaCaducidad
	 * @param lote
	 * @param fechaElaboracion
	 * @throws SICException
	 */
	public void actualizarUbicacionArticulo(AsignacionArticuloUnidadManejoDTO asignacionArticuloUnidadManejoDTO,Integer cantidad,Timestamp fechaCaducidad, String lote, Timestamp fechaElaboracion)throws SICException;

	/**
	 * Devuelve una ubicacion de la bodega si se encuentra registrada con el identificador especificado
	 * @param codigoAreaTrabajo
	 * @param identificador
	 * @param codigoCompania
	 * @throws SICException
	 */
	public DetalleSeccionDTO buscarUbicacionExistente(Integer codigoAreaTrabajo, String identificador, Integer codigoCompania,Integer codigoAreaTrabajoSubbodega) throws SICException;

	/**
	 * Devuelve una lista de ubicaciones que se encuentran ocupados
	 * @param asignacionArticuloUnidadManejoDTO
	 * @param tipoAlmacenamiento
	 * @throws SICException
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> obtenerUbicacionesOcupadas(AsignacionArticuloUnidadManejoDTO asignacionArticuloUnidadManejoDTO, CatalogoValorDTO tipoAlmacenamiento);

	/**
	 * Devuelve una lista de ubicaciones para balanza
	 * @param codigoAreaTrabajo
	 * @param codigoCompania
	 * @param codigoBarrasBalanza
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> buscarUbicacionBalanza(Integer codigoAreaTrabajo, Integer codigoCompania, String codigoBarrasBalanza) throws SICException;
	/**
	 * Devuelve una ubicacion filtrada por tipo de almacenamiento e identificador 
	 * @param identificador
	 * @param catalogoValorDTO
	 * @param areaSublugatTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	AsignacionArticuloUnidadManejoDTO obtenerUbicacionDisponiblePorIdentificador(String identificador, CatalogoValorDTO catalogoValorDTO,
			AreaSublugarTrabajoDTO areaSublugatTrabajoDTO) throws SICException;
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param valorTipoAlmacenamiento
	 * @param codigoTipoAlmacenamiento
	 * @return
	 * @throws SICException
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> obtenerUbicacionesDisponibles(Integer codigoCompania, Integer codigoAreaTrabajo, String valorTipoAlmacenamiento, Integer codigoTipoAlmacenamiento, Boolean validarFechacaducidad) throws SICException;

	/**
	 * Retorna el pallet de la ubicacion 
	 * @param codigoCompania
	 * @param codigoUnidadManejoPadre
	 * @return
	 * @throws SICException
	 */
	public ArticuloUnidadManejoDTO obtenerPalletUnidadManejo(Integer codigoCompania, Long codigoUnidadManejoPadre) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public DatosTareaDTO obtenerPalletPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;

	/**
	 * 
	 * @param asignacionArticuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void actualizarUbicacionArticulo(AsignacionArticuloUnidadManejoDTO asignacionArticuloUnidadManejoDTO) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param codigoUnidadManejo
	 * @param codigoAreaTrabajo
	 * @param codigoBarrasArticulo
	 * @param valorTipoUbicacion
	 * @param valorTipoAlmacenamiento
	 * @param validarCantidad
	 * @return
	 * @throws SICException
	 */
	public 	Collection<AsignacionArticuloUnidadManejoDTO> obtenerUbicacionesArticulo(Integer codigoCompania, Long codigoUnidadManejo, Integer codigoAreaTrabajo, String codigoBarrasArticulo, String valorTipoUbicacion, String valorTipoAlmacenamiento, Boolean validarCantidad) throws SICException;

	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigoDetalleSeccion
	 * @throws SICException
	 */
	public void desactivarAsignacionUbicacionesArticulos(Integer codigoCompania, String userId, Long codigoDetalleSeccion) throws SICException;

	/**
	 * 
	 * @param asignacionArticuloUnidadManejoDTO
	 * @throws SICException
	 */
	public void registrarAsignacionArticuloUnidadManejo(AsignacionArticuloUnidadManejoDTO asignacionArticuloUnidadManejoDTO) throws SICException;

	
	
}
