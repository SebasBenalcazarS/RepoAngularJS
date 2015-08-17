/** ec.com.smx.sic.cliente.persistencia.convenio.dao
 * IRegistroCobroDAO.java
 * @author srodriguez
 * 23/2/2015
 */
package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ConceptoTipoImpuestoDTO;

/**
 * @author aquingaluisa
 *
 */
public interface IConceptoTipoImpuestoDAO {
	
	/**
	 * Metodo para obtener los registros de la tabla  conceptoTipoIMpuestos
	 * @return
	 * @throws SICException
	 */
	Collection<ConceptoTipoImpuestoDTO> obtenerConceptoTipoImpuesto(Integer codigoCompania) throws SICException;
}
