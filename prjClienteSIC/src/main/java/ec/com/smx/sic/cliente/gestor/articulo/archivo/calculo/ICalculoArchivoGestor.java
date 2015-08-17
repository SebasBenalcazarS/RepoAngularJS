package ec.com.smx.sic.cliente.gestor.articulo.archivo.calculo;

import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDefinicionArchivoDTO;

public interface ICalculoArchivoGestor {

	/**
	 * 
	 * @param articuloDefinicionArchivoDTO
	 * @throws SICRuleException
	 */
	public abstract void asignarCamposArticuloArchivo(ArticuloDefinicionArchivoDTO articuloDefinicionArchivoDTO) throws SICRuleException;

}