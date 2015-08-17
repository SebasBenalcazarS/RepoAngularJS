package ec.com.smx.sic.cliente.persistencia.convenio.dao;

import ec.com.smx.sic.cliente.mdl.dto.NegociacionCuentaContableDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.NegociacionCuentaContableID;

/**
 * @author srodriguez
 * 2014-11-29
 */
public interface INegociacionCuentaContableDAO {
	
	/**
	 * @author srodriguez
	 * @param negociacionCuentaContableDTO
	 */
	void crearNegociacionCuentaContable(NegociacionCuentaContableDTO negociacionCuentaContableDTO,Integer codigoCompania, String idUsuarioAuditoria);
	
	/**
	 * @author srodriguez
	 * @param negociacionCuentaContableDTO
	 */
	void actualizarNegociacionCuentaContable(NegociacionCuentaContableDTO negociacionCuentaContableDTO, String idUsuarioAuditoria);
	
	/**
	 * @author srodriguez
	 * @param negociacionCuentaContableID
	 * @return Boolean
	 */
	Boolean findExistsNegociacionCuentaContable(NegociacionCuentaContableID negociacionCuentaContableID);
	
	
	/**
	 * Metodo de INegociacionCuentaContableDAO.java, utilizado para eliminar los registros de negociacion de cuentas contables
	 * srodriguez
	 * 30/1/2015
	 * @param negociacionCuentaContableDTO
	 * void
	 */
	void eliminarNegociacionCuentaContableFisico(NegociacionCuentaContableDTO negociacionCuentaContableDTO);
	
}
