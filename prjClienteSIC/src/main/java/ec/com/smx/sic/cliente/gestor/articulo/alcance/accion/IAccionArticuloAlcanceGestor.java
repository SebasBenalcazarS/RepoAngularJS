package ec.com.smx.sic.cliente.gestor.articulo.alcance.accion;

import java.util.HashSet;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.integracion.IConsultarAlcanceArticuloIDTO;

public interface IAccionArticuloAlcanceGestor {

	/**
	 * Metodo que consulta a que locales
	 * tiene alcance los articulos enviados 
	 * @param codigoBarrasArticulos
	 * @return Collection<ConsultarAlcanceArticuloIDTO>
	 * @throws SICException
	 */
	public abstract IConsultarAlcanceArticuloIDTO consultarArticulosAlcance(HashSet<String> codigoBarrasArticulos) throws SICException;
}