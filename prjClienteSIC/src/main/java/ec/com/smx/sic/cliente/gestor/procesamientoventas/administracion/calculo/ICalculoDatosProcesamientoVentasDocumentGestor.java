/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.procesamientoventas.administracion.calculo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.procesamientoventas.beans.DatoPrecioMargenReal;
import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosProcesamientoVentasDocumentGestor extends Serializable {

	/**
	 * 
	 * @param db
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param fechaProcesamientoVenta
	 * @param codigoTransaccion
	 * @param nameclusterFechaTransaccionAnteriores
	 * @return
	 * @throws SICException
	 */
	Duplex<ORID, BigDecimal> obtenerRidYTotalVentaAcumuladaAnteriorArticuloVentaResumen(ODatabaseDocumentTx db, Integer codigoCompania,
			String codigoArticulo, Date fechaProcesamientoVenta, Integer codigoTransaccion, Map<String, String> nameclusterFechaTransaccionAnteriores) throws SICException;

	/**
	 * Metodo para obtener todos los articulosVenta que fueron procesados en la fecha recibidad
	 * @param db
	 * @param codigoCompania
	 * @param fechaProcesamientoVenta
	 * @param codigosTransaccion
	 * @return
	 * @throws SICException
	 */
	Collection<ODocument> obtenerArticuloVentaProcesados(ODatabaseDocumentTx db, Integer codigoCompania, Date fechaProcesamientoVenta, Set<Integer> codigosTransaccion) throws SICException;

	/**
	 * Metodo para obtener los totales por fecha recibida de cada articuloVenta
	 * @param db
	 * @param fechaProcesamientoVenta
	 * @param codigosTransaccion
	 * @return
	 * @throws SICException
	 */
	Collection<ODocument> obtenerTotalesArticuloVentaPorFecha(ODatabaseDocumentTx db, Date fechaProcesamientoVenta, Set<Integer> codigosTransaccion) throws SICException;

	/**
	 * 
	 * @param codigoArticulo 
	 * @param codigoCompania 
	 * @param fechaInicial 
	 * @param fechaFinal
	 */
	Collection<DatoPrecioMargenReal> obtenerListadoPreciosMargenReal(String codigoArticulo, Integer codigoCompania, Date fechaInicial, Date fechaFinal);
}
