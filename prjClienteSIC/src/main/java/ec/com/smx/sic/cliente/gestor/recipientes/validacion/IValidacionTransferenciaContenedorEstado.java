package ec.com.smx.sic.cliente.gestor.recipientes.validacion;

import java.io.Serializable;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.AdminContenedorVO;

public interface IValidacionTransferenciaContenedorEstado extends Serializable{
	/**
	 * 
	 * @param adminContenedorVO
	 * @throws SICException
	 */
	
	public void validarDatosTransferenciaContenedorEstado(AdminContenedorVO adminContenedorVO) throws SICException;
}
