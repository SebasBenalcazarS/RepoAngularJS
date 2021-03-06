/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoUsoDTO;
import ec.com.smx.sic.cliente.mdl.dto.AsignacionArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;

/**
 * @author jdvasquez
 *
 */
public interface IProgramasMontacarguistaServicio {
	/**
	 * Obtiene una ubicacion disponible filtrada por identificador y tipo de almacenamiento 
	 * @param identificador
	 * @param catalogoValorDTO
	 * @param areaSublugarTrabajoDTO
	 * @return
	 * @throws SICException
	 */
	AsignacionArticuloUnidadManejoDTO obtenerUbicacionDisponiblePorIdentificador(String identificador,
			CatalogoValorDTO catalogoValorDTO, AreaSublugarTrabajoDTO areaSublugarTrabajoDTO) throws SICException;

	/**
	 * 
	 * Obtiene una coleccion de ubicaciones disponibles filtradas por area de trabajo y tipo de almacenamiento
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param valorTipoAlmacenamiento
	 * @param codigoTipoAlmacenamiento
	 * @param validarFechacaducidad
	 * @return
	 * @throws SICException
	 */
	Collection<AsignacionArticuloUnidadManejoDTO> obtenerUbicacionesDisponibles(Integer codigoCompania, Integer codigoAreaTrabajo, String valorTipoAlmacenamiento, Integer codigoTipoAlmacenamiento, Boolean validarFechacaducidad) throws SICException;

	/**
	 * Obtiene el pallet contenedor de una unidad de manejo especifica 
	 * @param codigoCompania
	 * @param codigoUnidadManejoPadre
	 * @return
	 * @throws SICException
	 */
	ArticuloUnidadManejoDTO obtenerPalletUnidadManejo(Integer codigoCompania, Long codigoUnidadManejoPadre) throws SICException;
	/**
	 * Obtiene el pallet filtrado por el codigo de barras
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	DatosTareaDTO obtenerPalletPorCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;

	/**
	 * Obtiene las ubicaciones de un articulo filtrado por el codigo de barras del mismo
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
	Collection<AsignacionArticuloUnidadManejoDTO> obtenerUbicacionesArticulo(Integer codigoCompania, Long codigoUnidadManejo, Integer codigoAreaTrabajo, String codigoBarrasArticulo, String valorTipoUbicacion, String valorTipoAlmacenamiento, Boolean validarCantidad) throws SICException;

	/**
	 * Obtiene el articulo unidad de manejo por el codigo de EAN
	 * @param codigoCompania
	 * @param codigoEAN
	 * @return
	 * @throws SICException
	 */
	ArticuloUnidadManejoDTO obtenerUnidadManejoPorEAN(Integer codigoCompania, String codigoEAN) throws SICException;

	/**
	 *  Obtiene el articulo unidad de manejo por el codigo de barras del articulo
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoDTO> obtenerArticuloUnidadManejoCodigoBarrasArticulo(Integer codigoCompania, String codigoBarras) throws SICException;

	/**
	 * Reemplaza la ubicacion del articulo desde por la ubicacion hasta
	 * @param ubicacionDesde
	 * @param ubicacionHasta
	 * @param userId
	 * @param desactivarUbicacionDesde
	 * @throws SICException
	 */
	void reemplazarUbicacionArticulo(AsignacionArticuloUnidadManejoDTO ubicacionDesde, AsignacionArticuloUnidadManejoDTO ubicacionHasta, String userId, Boolean desactivarUbicacionDesde) throws SICException;

	/**
	 * Obtiene una coleccion de usos de una unidad de manejo ingresada como parametro
	 * @param codigoCompania
	 * @param codigoArticuloUnidadManejo
	 * @return
	 * @throws SICException
	 */
	Collection<ArticuloUnidadManejoUsoDTO> obtenerArticuloUnidadManejoUso(Integer codigoCompania, Long codigoArticuloUnidadManejo) throws SICException;

	/***
	 * Reemplaza los datos de una ubicacion con los datos introducidos en pantalla
	 * @param ubicacionDesde
	 * @param ubicacionHasta
	 * @param userId
	 * @throws SICException
	 */
	void reemplazarUbicacionArticuloSaneamiento(AsignacionArticuloUnidadManejoDTO ubicacionDesde, AsignacionArticuloUnidadManejoDTO ubicacionHasta, String userId) throws SICException;

	/**
	 * Obtiene el detalle seccion filtrado por identificador y codigo area trabajo
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 * @param identificador
	 * @param valorTipoSeccion
	 * @return
	 * @throws SICException
	 */
	DetalleSeccionDTO obtenerDetalleSeccionPorIdentificador(Integer codigoCompania, Integer codigoAreaTrabajo, String identificador, String valorTipoSeccion) throws SICException;

}
