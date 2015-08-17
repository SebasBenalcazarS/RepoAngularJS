package ec.com.smx.sic.cliente.gestor.articulo.admin.calculo;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;

public interface ICalculoArticuloLocalGestor {

	/**
	 * 
	 * @param registros
	 * @param registrosActuales
	 * @throws SICException
	 */
	public abstract void registrarArticuloLocalCupon(ArticuloDTO articuloDTO, Collection<ArticuloLocalDTO> registrosRecibidos, Collection<ArticuloLocalDTO> registrosActuales) throws SICException;

	/**
	 * 
	 * @param articuloLocalDTO
	 * @throws SICRuleException
	 */
	public void asignarCamposArticuloLocal(ArticuloLocalDTO articuloLocalDTO)throws SICRuleException;
}