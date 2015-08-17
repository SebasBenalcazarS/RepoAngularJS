package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

public interface IAlmacenamientoRecepcionProveedorGestorScanner {
	
	/**
	 * Cambia estado del proceso logistico y la tarea a terminado
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void terminarProveedor(TareaDTO tareaDTO) throws SICException;
	
	/**
	 * Cambia estado del proceso logistico y la tarea a registrada
	 * @param tareaDTO
	 * @param procesoLog
	 * @throws SICException
	 */
	void suspenderProveedor(TareaDTO tareaDTO) throws SICException;
	 /**
	 * Registrar el pallet incompleto cuando no finaliza de recebir el pallet(codigoBarras=-1)
	 * @param usuarioFuncionario
	 * @param tareaSeleccionada
	 * @return
	 * @throws SICException
	 */
	Long registrarPalletIncompleto(String usuarioFuncionario, TareaDTO tareaSeleccionada) throws SICException;
}