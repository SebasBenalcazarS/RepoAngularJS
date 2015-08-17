package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.JustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.NovedadArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.NovedadArticuloJustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorArticuloJustificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoDTO;

public interface IRecepcionJustificacionesDAO {

	/**
	 * Obtener datos de articulo unidad de manejo
	 * @param recepcionProveedorDTO
	 * @param codigoBarrasArticulo
	 * @param codigoBarrasCaja
	 * @return
	 * @throws SICException
	 */
	Collection<VistaArticuloUnidadManejoDTO> obtenerDatosArticuloUnidadManejo(RecepcionProveedorDTO recepcionProveedorDTO, String codigoBarrasArticulo, String codigoBarrasCaja)  throws SICException;

	/**
	 * Obtener la justificacion del articulo en la recepcion
	 * @param recepcionProveedorDTO
	 * @param articuloUnidadManejoDTO
	 * @param codigoJustificacion
	 * @return
	 * @throws SICException
	 */
	NovedadArticuloJustificacionDTO obtenerNovedadArticuloJustificacionEnRecepcion(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO, Long codigoJustificacion) throws SICException;

	/**
	 * Actualiza la cantidad de la justificacion ya ingresada
	 * @param novedadArticuloJustificacionDTO
	 * @param cantidad
	 * @return
	 * @throws SICException
	 */
	void actualizarCantidadNovedadJustificacionRecepcion(NovedadArticuloJustificacionDTO novedadArticuloJustificacionDTO, Integer cantidad) throws SICException;

	/**
	 * Obtener la causa de los rechazos del articulo por jabas
	 * @param codigoCompania
	 * @param codigoNovedadArticuloJustificacion
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	ControlRecipienteTaraDetalleDTO obtenerRechazosJabas(Integer codigoCompania, Long codigoNovedadArticuloJustificacion, String codigoArticulo)throws SICException;
	
	/**
	 * Actualizar la cantidad de las jabas recibidas,
	 * sumando el anterior valor con el ingresado
	 * @param controlRecipienteTaraDetalleDTO
	 * @param cantidad
	 * @throws SICException
	 */
	void actualizarCantidadJabas(ControlRecipienteTaraDetalleDTO controlRecipienteTaraDetalleDTO, Integer cantidad)throws SICException;
	
	/**
	 * Obtener la novedad de articulo
	 * @param recepcionProveedorDTO
	 * @param articuloUnidadManejoDTO
	 * @return
	 * @throws SICException
	 */
	NovedadArticuloDTO obtenerNovedadArticulo(RecepcionProveedorDTO recepcionProveedorDTO, ArticuloUnidadManejoDTO articuloUnidadManejoDTO)throws SICException;
	
	/**
	 * Obtener las justificaciones para las validaciones de etiquetado
	 * @param codigoCompania
	 * @param justificacionesEtiquetadoRecepcion
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerJustificacionesEtiquetadoRecepcion(Integer codigoCompania, Collection<String> justificacionesEtiquetadoRecepcion) throws SICException;
	
	/**
	 * <b> Obtiene la configuracion de etiquetado de, registro sanitario
	 * transgénico y semaforo, para activar y desactivar las validaciones</b>
	 * <p>
	 * [Author: aecaiza, Date: 27/02/2015]
	 * </p>
	 * @param codigoCompania
	 * @param codigoRecepcionProveedorArticulo
	 * @param validacionesEtiquetado
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerConfiguracionesValidacionesEtiquetado(Integer codigoCompania, Long codigoRecepcionProveedorArticulo, Collection<String> validacionesEtiquetado)throws SICException;
	
	/**
	 * <b> Obtiene el codigo de de recepcion proveedor articulo</b>
	 * <p>
	 * [Author: aecaiza, Date: 02/03/2015]
	 * </p>
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoRecepcionProveedor
	 * @return
	 * @throws SICException
	 */
	Long obtenerCodigoRecepcionProveedorArticulo(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Long codigoRecepcionProveedor)throws SICException;

	/**
	 * Registrar las justificaciones para las validaciones del etiquetado en la recepcion
	 * @param recepcionProveedorArticuloJustificacionCol
	 * @throws SICException
	 */
	void registrarJustificacionesEtiquetadoRecepcion(RecepcionProveedorArticuloJustificacionDTO recepcionProveedorArticuloJustificacionCol, Long codigoRecepcionProveedorArticulo)throws SICException;
	
	/**
	 * Consulta las configuraciones registradas para validar etiquetado en el articulo
	 * @param codigoCompania
	 * @param validacionesEtiquetado
	 * @param codigoTipoConfiguracionEtiquetado
	 * @param valorTipoConfiguracionEtiquetado
	 * @param codigoRecepcionProveedorArticulo
	 * @return
	 * @throws SICException
	 */
	Collection<RecepcionProveedorArticuloJustificacionDTO> consultarConfiguracionesEtiquetado(Integer codigoCompania, Collection<String> validacionesEtiquetado, Integer codigoTipoConfiguracionEtiquetado, String valorTipoConfiguracionEtiquetado, Long codigoRecepcionProveedorArticulo) throws SICException;
	
	/**
	 * Inactivar las justificaciones de etiquetado anteriores
	 * @param recepcionProveedorArticuloJustificacionDTOs
	 * @throws SICException
	 */
	void actualizarJustificacionesEtiquetadoRecepcion(RecepcionProveedorArticuloJustificacionDTO reDto) throws SICException;
	
	/**
	 *<b> Obtiene las cantidades de justificaciones por articulo y unidad de manejo</b>
	 * <p>
	 * [Author: aecaiza, Date: 04/03/2015]
	 * </p>
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @return
	 * @throws SICException
	 */
	Collection<JustificacionDTO> obtenerCantidadJustificaciones(Integer codigoCompania, String codigoArticulo, Long codigoUnidadManejo, Long codigoProcesoLogistico) throws SICException;
	
	/**
	 *<b> Actualiza las cantidades de justificaciones por articulo y unidad de manejo</b>
	 * <p>
	 * [Author: aecaiza, Date: 05/03/2015]
	 * </p>
	 * @param listaJustificacionesActualizadas
	 * @param codigoCompania
	 * @param usuarioModificacion
	 * @throws SICException
	 */
	void actualizarCantidadJustificaciones(Collection<JustificacionDTO> listaJustificacionesActualizadas, Integer codigoCompania, String usuarioModificacion) throws SICException;

	/**
	 * @param codigoCompania
	 * @param codigoAreaTrabajoSubBodega
	 * @param codigoPerfil
	 * @return
	 */
	Collection<JustificacionDTO> obtenerJustificacionesRecepcion(Integer codigoCompania, Integer codigoAreaTrabajoSubBodega, String codigoPerfil) throws SICException;

}