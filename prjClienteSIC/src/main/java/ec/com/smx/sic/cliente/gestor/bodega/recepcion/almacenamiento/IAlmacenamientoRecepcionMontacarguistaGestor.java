package ec.com.smx.sic.cliente.gestor.bodega.recepcion.almacenamiento;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoInformacionRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionPalletMontacarguistaDTO;

public interface IAlmacenamientoRecepcionMontacarguistaGestor {

	/**
	 * Asigna la tarea del montacarguista a un funcionario y cambia el estado de REG a ASI, EPR
	 * 
	 * @param vistaUbicacionPalletMontacarguistaDTO
	 * @param funcionarioSublugarTrabajoRelacionadoDTO funcionario al q se le asigna la tarea
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void asignarTareaMontacarguista(VistaUbicacionPalletMontacarguistaDTO vistaUbicacionPalletMontacarguistaDTO , FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;

	/**
	 * Finaliza la tarea del montacarguista, finaliza el estado del pallet y actualiza los valores de la ubicacion
	 * 
	 * @param vistaUbicacionPalletMontacarguistaDTO
	 * @param vistaInformacionArticulo
	 * @param detalleSeccionDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void finalizarTareaMontacarguista(VistaUbicacionPalletMontacarguistaDTO vistaUbicacionPalletMontacarguistaDTO,VistaArticuloUnidadManejoInformacionRecepcionDTO vistaInformacionArticulo,
			DetalleSeccionDTO detalleSeccionDTO) throws SICException;	
	
}