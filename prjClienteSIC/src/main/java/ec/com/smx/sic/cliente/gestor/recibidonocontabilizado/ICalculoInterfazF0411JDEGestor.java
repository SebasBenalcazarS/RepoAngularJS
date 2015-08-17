package ec.com.smx.sic.cliente.gestor.recibidonocontabilizado;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.InterfacesEstructurasJDE;

public interface ICalculoInterfazF0411JDEGestor {

	public InterfacesEstructurasJDE obtenerInformacionF0411(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO)throws SICException;
}
