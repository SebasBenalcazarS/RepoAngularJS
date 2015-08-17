package ec.com.smx.sic.cliente.gestor.recipientes.almacenamiento;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ContenedorEstadoDTO;
import ec.com.smx.sic.cliente.mdl.vo.AdminContenedorVO;

/**
 * 
 * @author amunoz
 *
 */
public interface ITransferenciasContenedorEstadoGestor extends Serializable {
	/**
	 * 
	 * @param adminContenedorVO
	 * @param accion
	 * @return
	 */
	public ContenedorEstadoDTO generarNuevoContenedorEstado(AdminContenedorVO adminContenedorVO, String accion) throws SICException;
	/**
	 * 
	 * @param adminContenedorVO
	 * @throws SICException
	 */
	
	public void almacenarEstadoInicialTransferenciaContenedor(AdminContenedorVO adminContenedorVO) throws SICException;
	
}
