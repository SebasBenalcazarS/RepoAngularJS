package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;

/**
 * 
 * @author lguaman
 */

public interface IValidacionRecepcionTipoControlCostosGestor {

	/**
	 * Validar los campos requeridos para registrar un articulo recibido por tipo control costos
	 * @param tipoControlCostos
	 * @param listaJabasRecibidas
	 * @throws SICException
	 */
	public void recibirArticuloPorTipoControlCostos(String tipoControlCostos, Collection<ControlRecipienteTaraDetalleDTO> listaJabasRecibidas) throws SICException;

	/**
	 * Validar los campos requeridos para recibir articulo por peso o cantidad
	 * @param recepcionEnProceso
	 * @param listaPalletsBalanza
	 * @param codigoDetalleSeccionOrigen
	 * @param userId
	 * @throws SICException
	 */
	void recibirArticuloPorCantidadOPeso(RecepcionProveedorDTO recepcionEnProceso, Collection<DatosTareaDTO> listaPalletsBalanza, Long codigoDetalleSeccionOrigen, String userId) throws SICException;

	/**
	 * Validar la informacion para procesar le pallet en la recepcion
	 * @param palletEnBalanza
	 * @throws SICException
	 */
	void validarInformacionProcesarPallet(DatosTareaDTO palletEnBalanza);

}