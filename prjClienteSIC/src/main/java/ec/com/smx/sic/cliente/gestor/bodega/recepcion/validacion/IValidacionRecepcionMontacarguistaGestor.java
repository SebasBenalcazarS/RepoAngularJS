package ec.com.smx.sic.cliente.gestor.bodega.recepcion.validacion;

import ec.com.smx.corpv2.dto.FuncionarioProcesoPerfilAreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaArticuloUnidadManejoInformacionRecepcionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaUbicacionPalletMontacarguistaDTO;

public interface IValidacionRecepcionMontacarguistaGestor {
	
	/**
	 * Validacion de los campos obligatorios para asignar la tarea al montacarguista
	 * @param vistaUbicacionPalletMontacarguistaDTO
	 * @param funcionarioSublugarTrabajoRelacionadoDTO
	 * @throws SICException
	 */
	void asignarTareaMontacarguista(VistaUbicacionPalletMontacarguistaDTO vistaUbicacionPalletMontacarguistaDTO , FuncionarioProcesoPerfilAreaTrabajoDTO funcionarioProcesoPerfilAreaTrabajoDTO) throws SICException;

	/**
	 * Validacion de los campos obligatorios para finalizar la tarea del montacarguista
	 * @param vistaUbicacionPalletMontacarguistaDTO
	 * @param vistaInformacionArticulo
	 * @param detalleSeccionDTO
	 * @throws SICException
	 */
	void finalizarTareaMontacarguista(VistaUbicacionPalletMontacarguistaDTO vistaUbicacionPalletMontacarguistaDTO,VistaArticuloUnidadManejoInformacionRecepcionDTO vistaInformacionArticulo,
	DetalleSeccionDTO detalleSeccionDTO) throws SICException;
			
}