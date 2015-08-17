package ec.com.smx.sic.cliente.gestor.articulo.regsan.calculo;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloRegistroSanitarioDTO;

public interface ICalculoRegSanGestor {

	/**
	 * 
	 * @param ars
	 */
	public abstract void asignarCamposRegistroSanitario(ArticuloRegistroSanitarioDTO ars);

}