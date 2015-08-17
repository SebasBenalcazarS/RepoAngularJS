package ec.com.smx.sic.cliente.gestor.bodega.administracion.almacenamiento;

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
public interface IAlmacenamientoUbicacionGestor {

	/**
	 * Permite la busqueda de la ubicacion de los articulos en las areas de trabajo
	 * @param artUMDTO
	 * @param areaSublugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	DetalleSeccionDTO buscaUbicacion(ArticuloUnidadManejoDTO artUMDTO, AreaSublugarTrabajoDTO areaSublugarTrabajoDTO)throws SICException;
		
	/**
	 * @param articuloUnidadManejoDTO
	 * @param codigoAreaTrabajo
	 * @param Identificador
	 * @return
	 * @throws SICException
	 */
	public DetalleSeccionDTO buscarUbicacionDisponible(ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Integer codigoAreaTrabajo,Integer codigoAreaSubbodega,String identificador)throws SICException;
	
	/**
	 *Permite actualizar los datos de ubicacion de articulo  
	 * @param articuloUnidadManejoDTO
	 * @param detalleSeccionDTO
	 * @param fechaCaducidad
	 * @param cantidad
	 * @param userID
	 * @param codigoBarras
	 * @param lote
	 * @param fechaElaboracion
	 * @throws SICException
	 */
	public void actualizarDatosUbicacionArticulo(ArticuloUnidadManejoDTO articuloUnidadManejoDTO,DetalleSeccionDTO detalleSeccionDTO,Timestamp fechaCaducidad,Integer cantidad,
			String userID,String codigoBarras, String lote,Timestamp fechaElaboracion)throws SICException;

	/**
	 * Devuelve una ubicacion de la bodega si se encuentra registrada con el identificador especificado
	 * @param codigoAreaTrabajo
	 * @param identificador
	 * @param codigoCompania
	 * @throws SICException
	 */
	public DetalleSeccionDTO buscarUbicacionExistenteParaArticulo(Integer codigoAreaTrabajo, String codigoBarrasUbicacion, Integer codigoCompania,Integer codigoAreaTrabajoSubbodega) throws SICException;

	/**
	 * Devuelve una lista de ubicaciones que se encuentran ocupados
	 * @param asignacionArticuloUnidadManejoDTO
	 * @param tipoAlmacenamiento
	 * @throws SICException
	 */
	public Collection<AsignacionArticuloUnidadManejoDTO> obtenerUbicacionesOcupadas(AsignacionArticuloUnidadManejoDTO asignacionArticuloUnidadManejoDTO, CatalogoValorDTO tipoAlmacenamiento) throws SICException;

	/**
	 * Devuelve una lista de ubicaciones para la balanza a nivel de area de trabajo
	 * @param tipoControlCostos
	 * @param artUMDTO
	 * @param areaSublugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	DetalleSeccionDTO buscarUbicacionPorTipoControlCostos(String tipoControlCostos, ArticuloUnidadManejoDTO artUMDTO, AreaSublugarTrabajoDTO areaSublugarTrabajoDTO) throws SICException;

	/**
	 * Devuelve una ubicacion filtrada por identificador y tipo de almacenamiento
	 * @param codigoCompania
	 * @param identificador
	 * @param codigoAreaTrabajo
	 * @param valorTipoAlmacenamiento
	 * @param codigoTipoAlmacenamiento
	 * @return
	 * @throws SICException
	 */
	public AsignacionArticuloUnidadManejoDTO obtenerUbicacionDisponiblePorIdentificador(Integer codigoCompania, String identificador, Integer codigoAreaTrabajo, String valorTipoAlmacenamiento, Integer codigoTipoAlmacenamiento) throws SICException;
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
	 * 
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
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param codigoBarrasBalanza
	 * @return
	 * @throws SICException
	 */
	public Collection<DetalleSeccionDTO> buscarUbicacionBalanza(Integer codigoCompania, Integer codigoAreaTrabajo, String codigoBarrasBalanza) throws SICException;
	
	/**
	 * 
	 * @param ubicacionReserva
	 * @param ubicacionSurtido
	 * @throws SICException
	 */
	public void alimentarUbicacionSurtido(AsignacionArticuloUnidadManejoDTO ubicacionReserva, AsignacionArticuloUnidadManejoDTO ubicacionSurtido) throws SICException;
	
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
	public	Collection<AsignacionArticuloUnidadManejoDTO> obtenerUbicacionesArticulo(Integer codigoCompania, Long codigoUnidadManejo, Integer codigoAreaTrabajo, String codigoBarrasArticulo, String valorTipoUbicacion, String valorTipoAlmacenamiento, Boolean validarCantidad) throws SICException;

	/**
	 * 
	 * @param ubicacionDesde
	 * @param ubicacionHasta
	 * @param userId
	 * @param desactivarUbicacionDesde
	 * @throws SICException
	 */
	public 	void reemplazarUbicacionArticulo(AsignacionArticuloUnidadManejoDTO ubicacionDesde, AsignacionArticuloUnidadManejoDTO ubicacionHasta, String userId, Boolean desactivarUbicacionDesde) throws SICException;

	/**
	 * 
	 * @param ubicacionDesde
	 * @param ubicacionHasta
	 * @param userId
	 * @throws SICException
	 */
	public void reemplazarUbicacionArticuloSaneamiento(AsignacionArticuloUnidadManejoDTO ubicacionDesde, AsignacionArticuloUnidadManejoDTO ubicacionHasta, String userId) throws SICException;

	

}
