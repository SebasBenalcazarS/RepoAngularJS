package ec.com.smx.sic.cliente.gestor.procesamientoventas.administracion;

import java.io.Serializable;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Marcelo Hidalgo
 *
 */
public interface IAccionMigracionProcesamientoVentasArticulosGestor extends Serializable{

	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	void ejecutarActualizacionPreciosArticulosAcumuladoProcesamientoVentas(Integer codigoCompania) throws SICException;


	/**
	 * @param codigoCompania
	 * @param fechaCierre
	 * @throws SICException
	 */
	void ejecutarActualizacionPreciosArticulosAcumuladoProcesamientoVentas(Integer codigoCompania, Date fechaCierre) throws SICException;


	/**
	 * @param codigoCompania
	 * @throws SICException
	 */
	void ejecutarActualizacionPreciosArticulosDiariosProcesamientoVentas(Integer codigoCompania) throws SICException;


	/**
	 * @param codigoCompania
	 * @param fechaCierre
	 * @throws SICException
	 */
	void ejecutarActualizacionPreciosArticulosDiariosProcesamientoVentas(Integer codigoCompania, Date fechaCierre) throws SICException;

}
