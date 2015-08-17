package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.CuentaContableDTO;

/**
 * @author srodriguez
 * 2014-09-10
 */
public interface ICuentaContableDAO {
	/**
	 * @author khidalgo
	 * Collection<CuentaContableDTO>
	 * @return
	 */
	Collection<CuentaContableDTO> findCuentasContablesNegociacion();
}
