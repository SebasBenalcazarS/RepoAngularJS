package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;


/**
 * 
 * @author lguaman
 *
 */
public interface IAlmacenamientoRecepcionTipoControlCostosGestor {		
	/**
	 * Almacena la recepcion por tipo de control de costos
	 * 
	 * @param tipoControlCostos
	 * @param detalleTareaDTO
	 * @param recepcionEnProceso
	 * @param artUniManRecepcion
	 * @param datosTarea
	 * @param cantidadPallet
	 * @param listaJabasRecibidas
	 * @throws SICException
	 */
	public void recibirArticuloPorTipoControlCostos(String tipoControlCostos, DetalleTareaDTO detalleTareaDTO, RecepcionProveedorDTO recepcionEnProceso, 
			ArticuloUnidadManejoDTO artUniManRecepcion, DatosTareaDTO datosTarea, Integer cantidadPallet, BigDecimal pesoPallet,
			Collection<ControlRecipienteTaraDetalleDTO> listaJabasRecibidas, Long codigoProceso) throws SICException;

	/**
	 * @author lguaman
	 * <b>Recibe un articulo en peso o en cantidad (Recepcion en Oficina)</b>
	 * @param recepcionEnProceso
	 * @param palletsEnBalanza
	 * @param codigoDetalleSeccionOrigen
	 * @param userId
	 */
	void recibirArticuloPorCantidadOPeso(RecepcionProveedorDTO recepcionEnProceso, Collection<DatosTareaDTO> palletsEnBalanza, Long codigoDetalleSeccionOrigen, String userId) throws SICException;

	/**
	 * <b>Actualiza los datos de la recepcion cantidades y pesos recibidos</b>
	 * @param recepcionEnProceso
	 * @param cantidadActualizar
	 * @param cantidadAnterior
	 * @param idUsuarioModificacion
	 * @param pesoActualizar
	 */
	void actualizarDatosRecepcion(RecepcionProveedorDTO recepcionEnProceso, Integer cantidadActualizar, Integer cantidadAnterior, String idUsuarioModificacion, BigDecimal pesoActualizar) throws SICException;

	/**
	 * Obtiene el valor de la cantidad a actualizar y la operacion que se debe realizar (Sumar o Restar)
	 * @param codigoCompania
	 * @param codigoDatosTarea
	 * @param cantidadActual
	 * @param informacionActualpallet
	 */
	Duplex<Boolean, Integer> obtenerOperacionActualizacionResumen(Integer codigoCompania, Long codigoDatosTarea, Integer cantidadActual, DatosTareaDTO informacionActualpallet);	
			
}
