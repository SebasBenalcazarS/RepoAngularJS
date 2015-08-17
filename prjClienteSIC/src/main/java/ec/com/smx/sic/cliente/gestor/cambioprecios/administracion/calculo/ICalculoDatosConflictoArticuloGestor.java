package ec.com.smx.sic.cliente.gestor.cambioprecios.administracion.calculo;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.gestionprecios.constantes.TipoConflictoArticulo;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloGestionPrecioDTO;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosConflictoArticuloGestor extends Serializable {

	
	/**
	 * @param articuloGestionPrecio
	 * @param tipoConflictoArticulo
	 * @throws SICException
	 */
	void calcularConflictosArticuloPorTipo(ArticuloGestionPrecioDTO articuloGestionPrecio, TipoConflictoArticulo tipoConflictoArticulo) throws SICException;

}
