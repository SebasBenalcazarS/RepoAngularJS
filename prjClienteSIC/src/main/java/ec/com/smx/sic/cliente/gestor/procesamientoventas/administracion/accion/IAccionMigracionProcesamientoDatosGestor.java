package ec.com.smx.sic.cliente.gestor.procesamientoventas.administracion.accion;

import java.io.Serializable;
import java.util.Date;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 * 
 * @author vjaramillo
 *
 */
public interface IAccionMigracionProcesamientoDatosGestor extends Serializable {


	/**
	 * @param codigoCompania
	 * @param fechaProcesamientoVenta
	 * @param codigosTransaccion
	 * @throws SICException
	 */
	void sumarTotalesAcumuladosArticulos(Integer codigoCompania, Date fechaProcesamientoVenta, String codigosTransaccion) throws SICException;

}