package ec.com.smx.sic.cliente.persistencia.recipientes.dao;

import java.util.Collection;
import java.util.LinkedHashMap;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.TransaccionCausalProcesoRelacionTrasient;

public interface ITransaccionCausalesDAO {
	/**
	 * @param parametrosConsulta
	 * @return
	 */
	public  Collection<TransaccionCausalProcesoRelacionTrasient> obtenerTransaccionCausalesRelacion(LinkedHashMap<String, Object> parametrosConsulta) throws SICException;
	
	
}
