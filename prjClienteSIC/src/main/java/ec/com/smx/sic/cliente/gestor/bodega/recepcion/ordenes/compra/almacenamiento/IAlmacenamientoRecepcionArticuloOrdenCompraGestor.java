package ec.com.smx.sic.cliente.gestor.bodega.recepcion.ordenes.compra.almacenamiento;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

public interface IAlmacenamientoRecepcionArticuloOrdenCompraGestor {
	
	/**
	 * Metodo para recibir un articulo que se encuentre en el proceso de recepcion
	 * 
	 * @param codigoRecepcion
	 * @param articuloUnidadManejoDTO
	 * @param cantidadRecibida
	 * @throws SICException Excepcion en casa de producirse un error
	 */
	public abstract Collection<OrdenCompraDetalleEstadoDTO> recibirArticulo(
			RecepcionProveedorDTO recepcionProveedorDTO, 
			ArticuloUnidadManejoDTO articuloUnidadManejoDTO, 
			Integer cantidadRecibida, 
			BigDecimal pesoRecibo, 
			String tipoControlCosto)  throws SICException;

	/**
	 * Este metodo elimina los datos registrados en el pallet que recibe como parametro, elimina los registros de detalleDatosTarea y tambien hace una reversa de todo lo recibido en
	 * el pallet, y luego vuelve a recibir la nueva cantidad que recibe como parametro, para recibir primero recibe de los ordenCompraDetalleEstado que antes habia recibido y si aun
	 * falta cantidad por recibir llamamos nuevamente al metodo que recibe normalmente con el algoritmo del metodo2
	 * 
	 * @param codigoTarea
	 * @param recepcionProveedor
	 * @param codigoBarrasPalet
	 * @param cantidadRecibir
	 * @param pesoRecibir
	 * @param tipoControlCosto
	 * @return
	 * @throws SICException
	 */
	public abstract Collection<OrdenCompraDetalleEstadoDTO> modificarPallet(Long codigoTarea, RecepcionProveedorDTO recepcionProveedor, String codigoBarrasPalet, Integer cantidadRecibir, BigDecimal pesoRecibir, String tipoControlCosto)  throws SICException;
	/**
	 * Restablece las cantidades en las ordenes de compra de los articulos que se han recibido en el pallet, hace una reversa de todo lo recibido en
	 * el palet
	 * @param codigoCompania
	 * @param codigoBarrasPalet
	 * @param codigoTarea
	 */
	public abstract void restablecerCantidadesOrdenCompraPallet(TareaDTO tareaRecolector, Long codigoRecepcionActual, String codigoBarrasPalet)throws SICException;
	
	/**
	 * Consulta un pallets con sus detalles de orden de compra
	 * @param codigoBarrasPallet
	 * @return
	 * @throws SICException
	 */
	public abstract DatosTareaDTO consultarDatosTareaPorCodigoBarrasPallet(String codigoBarrasPallet) throws SICException;
}
