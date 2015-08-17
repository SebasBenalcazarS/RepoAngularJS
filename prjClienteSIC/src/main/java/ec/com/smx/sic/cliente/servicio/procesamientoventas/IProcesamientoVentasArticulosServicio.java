package ec.com.smx.sic.cliente.servicio.procesamientoventas;

import java.io.Serializable;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Marcelo Hidalgo
 *
 */
public interface IProcesamientoVentasArticulosServicio extends Serializable {
	
	/**
	 * Permite almacenar los precios con descuento y de recuperacion de los articulos
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public void ejecutarActualizacionPreciosArticulosAcumuladoProcesamientoVentas(Integer codigoCompania) throws SICException;
	
	/**
	 * Permite almacenar los precios con descuento y de recuperacion de los articulos
	 * @param codigoCompania
	 * @param fechaCierre
	 * @return
	 * @throws SICException
	 */
	public void ejecutarActualizacionPreciosArticulosAcumuladoProcesamientoVentas(Integer codigoCompania, Date fechaCierre) throws SICException;
	
	/**
	 * Permite almacenar los precios con descuento y de recuperacion DIARIOS de los articulos
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public void ejecutarActualizacionPreciosArticulosDiariosProcesamientoVentas(Integer codigoCompania) throws SICException;
	
	/**
	 * Permite almacenar los precios con descuento y de recuperacion DIARIOS de los articulos
	 * @param codigoCompania
	 * @param fechaCierre
	 * @return
	 * @throws SICException
	 */
	public void ejecutarActualizacionPreciosArticulosDiariosProcesamientoVentas(Integer codigoCompania, Date fechaCierre) throws SICException;

}
