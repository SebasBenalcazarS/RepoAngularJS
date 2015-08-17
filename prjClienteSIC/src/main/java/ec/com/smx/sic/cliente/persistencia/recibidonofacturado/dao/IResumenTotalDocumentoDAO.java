package ec.com.smx.sic.cliente.persistencia.recibidonofacturado.dao;

import java.math.BigDecimal;
import java.util.Collection;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.recibidonocontabilizado.EnumTipoDocumentoResumen;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.TotalesFacturasNotaIngresoEST;

public interface IResumenTotalDocumentoDAO {

	/**
	 * Permite obtener los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @return
	 * @throws SICException
	 */
	Collection<TotalesFacturasNotaIngresoEST> obtenerTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso)throws SICException;
	
	/**
	 * Permite obtener los totales de las notas de credito y debito del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param enumTipoDocumentoResumen
	 * @return
	 * @throws SICException
	 */
	Collection<TotalesFacturasNotaIngresoEST> obtenerTotalesNotasCreditoDebitoNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, EnumTipoDocumentoResumen enumTipoDocumentoResumen)throws SICException;
	
	/**
	 * Permite consultar y registrar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param codigoUsuario
	 * @param valoresAjusteAutomatico
	 * @throws SICException
	 */
	void registrarTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, Duplex<Boolean, BigDecimal> valoresAjusteAutomatico, String codigoUsuario)throws SICException;
	
	/**
	 * Permite registrar los totales de los ajustes automaticos de la nota de ingreso 
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param valoresAjusteAutomatico
	 * @param codigoUsuario
	 */
	public void registrarTotalesAjusteAutomaticoNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, Duplex<Boolean, BigDecimal> valoresAjusteAutomatico, String codigoUsuario)throws SICException;
	
	/**
	 * Permite eliminar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoNotaIngreso
	 * @param enumTipoDocumentoResumen
	 * @throws SICException
	 */
	void eliminarTotalesFacturasNotasIngreso(Long codigoNotaIngreso, EnumTipoDocumentoResumen enumTipoDocumentoResumen)throws SICException;
	
	/**
	 * Permite eliminar, consultar y registrar los totales de las facturas del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param valoresAjusteAutomatico
	 * @param codigoUsuario
	 * @throws SICException
	 */
	void eliminarCrearTotalesFacturasNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, Duplex<Boolean, BigDecimal> valoresAjusteAutomatico, String codigoUsuario)throws SICException;

	
	/**
	 * Permite consultar y registrar los totales de las notas de credito y debito del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param codigoUsuario
	 * @param enumTipoDocumentoResumen
	 * @throws SICException
	 */
	void registrarTotalesNotasCreditoDebitoNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, String codigoUsuario, EnumTipoDocumentoResumen enumTipoDocumentoResumen)throws SICException;
	
	/**
	 * Permite eliminar, consultar y registrar los totales de las notas de credito y debito del proveedor de la nota de ingreso
	 * @param codigoCompania
	 * @param codigoNotaIngreso
	 * @param codigoUsuario
	 * @param enumTipoDocumentoResumen
	 * @throws SICException
	 */
	void eliminarCrearTotalesNotasCreditoDebitoNotaIngreso(Integer codigoCompania, Long codigoNotaIngreso, String codigoUsuario, EnumTipoDocumentoResumen enumTipoDocumentoResumen)throws SICException;
}
