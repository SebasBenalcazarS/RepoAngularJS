package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteTaraDetalleDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;



/**
 * 
 * @author lguaman
 *
 */
public interface IAlmacenamientoRecepcionDatosTareaGestor {

	/**
	 * <b> Cambia el estado de un pallet<b>
	 * <p>
	 * [Author: lguaman, Date: 13/12/2014]
	 * @param pallets
	 * @param valorAccionPallet
	 * @return
	 */
	Collection<DatosTareaDTO> cambiarEstadoPallet(Collection<DatosTareaDTO> pallets, String valorAccionPallet) throws SICException;

	/**
	 * <b> Crea el detalle de un pallet segun lo recibido en la orden de compra<b>
	 * <p>
	 * [Author: lguaman, Date: 13/12/2014]
	 * @param ordenCompraDetalleEstadoDTOs
	 * @param datosTarea
	 * @param userId
	 * @return
	 */
	void crearDetallePallet(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs, DatosTareaDTO datosTarea, String userId) throws SICException;
	/**
	 * 
	 * @param controlRecipienteTaraDetallesCol
	 * @param usuarioRegistro
	 * @param codigoDatosTarea
	 * @return 
	 * @throws SICException
	 */
	Collection<ControlRecipienteTaraDetalleDTO> crearRelacionDatosTareaDetalleRecipiente(Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol, String usuarioRegistro, Long codigoDatosTarea) throws SICException;

	/**
	 * 
	 * @param controlRecipienteTaraDetallesCol
	 * @param usuarioRegistro
	 * @return
	 * @throws SICException
	 */
	Collection<ControlRecipienteTaraDetalleDTO> crearControlDetalleRecipienteTara(Collection<ControlRecipienteTaraDetalleDTO> controlRecipienteTaraDetallesCol, String usuarioRegistro) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param userId
	 * @param codigoDatosTarea
	 * @param cantidadModificar
	 * @throws SICException
	 */
	void modificarCantidadRecibidaPalletJabas(Integer codigoCompania, String userId, Long codigoDatosTarea, Integer cantidadModificar) throws SICException;
}
