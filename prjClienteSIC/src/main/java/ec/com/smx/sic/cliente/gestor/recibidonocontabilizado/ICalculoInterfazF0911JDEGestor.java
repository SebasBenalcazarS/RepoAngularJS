package ec.com.smx.sic.cliente.gestor.recibidonocontabilizado;

import java.util.Collection;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.interfaz.jde.mdl.vo.InterfazBase;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecibidoNoFacturadoDTO;


/**
 * Permite generar el archivo F0911 usado en la contabilidad para JDE
 * @author fcollaguazo
 *
 */
public interface ICalculoInterfazF0911JDEGestor {

	public Collection<InterfazBase> obtenerInformacionF0911(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO, Boolean estadoRechazado)throws SICException;
	
	/**
	 * Permite obtener la estructura F0911 solo con ajustes
	 */
	public Duplex<Collection<InterfazBase>, Collection<VistaRecibidoNoFacturadoDTO>> obtenerInformacionF0911Ajustes(VistaRecibidoNoFacturadoDTO recibidoNoFacturadoDTO)throws SICException;
}
