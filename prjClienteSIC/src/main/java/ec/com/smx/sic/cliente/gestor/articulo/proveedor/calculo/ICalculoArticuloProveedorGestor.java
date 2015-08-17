package ec.com.smx.sic.cliente.gestor.articulo.proveedor.calculo;

import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloProveedorDTO;

public interface ICalculoArticuloProveedorGestor {

	/**
	 * @param articuloProveedorDTO
	 * @throws SICRuleException
	 */
	public abstract void asignarCondicionComercial(ArticuloProveedorDTO articuloProveedorDTO) throws SICRuleException;

	/**
	 * 
	 * @param articuloProveedorDTO
	 * @throws SICRuleException
	 */
	public abstract void asignarCamposArticuloProveedor(ArticuloProveedorDTO articuloProveedorDTO) throws SICRuleException;

}