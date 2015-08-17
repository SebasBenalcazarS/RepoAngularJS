/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.procesamientoventas.administracion.calculo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.nopersistente.procesamientoventas.DatoTransaccionProcesamientoVenta;

/**
 * @author Luis Yacchirema
 *
 */
public interface ICalculoDatosProcesamientoVentasDocumentDAO extends Serializable {


	/**
	 * Metodo para buscar un articulo por su indice
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoTransaccion
	 * @param fechaVentaArticulo
	 * @return
	 * @throws SICException
	 */
	ODocument obtenerArticuloVentaPorIndice(Integer codigoCompania, String codigoArticulo, Integer codigoTransaccion, Date fechaVentaArticulo) throws SICException;


	/**
	 * @param ridArticuloVenta
	 * @param codigoLocal
	 * @param fechaProcesamiento
	 * @param codigoTransaccion
	 * @return
	 * @throws SICException
	 */
	ORID obtenerRidArticuloLocalVentaPorIndice(ORID ridArticuloVenta, Integer codigoLocal, Date fechaProcesamiento, Integer codigoTransaccion) throws SICException;


	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoTransaccion
	 * @param fechaVentaArticulo
	 * @param codigoLocal
	 * @return
	 * @throws SICException
	 */
	ORID obtenerRidArticuloLocalPorIndiceArticulo(Integer codigoCompania, String codigoArticulo, Integer codigoTransaccion, Date fechaVentaArticulo, Integer codigoLocal) throws SICException;


	/**
	 * @param db
	 * @param codigoCompania
	 * @param fechaVentaArticulo
	 * @param codigosArticulos
	 * @param codigosTransaccion
	 * @return
	 * @throws SICException
	 */
	List<ODocument> obtenerArticulosVentasPorCodigosArticuloTransaccion(ODatabaseDocumentTx db, Integer codigoCompania, Date fechaVentaArticulo,
			Set<String> codigosArticulos, Set<Integer> codigosTransaccion) throws SICException;



	/**
	 * @param db
	 * @param codigoCompania
	 * @param fechaVentaArticulo
	 * @param codigosTransaccion
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	List<ODocument> obtenerDatosArticulosLocalesPorDatosArticulos(ODatabaseDocumentTx db, Integer codigoCompania, Date fechaVentaArticulo,
			Set<Integer> codigosTransaccion, Set<String> codigosArticulos) throws SICException;


	/**
	 * @param db
	 * @param codigoCompania
	 * @param fecha
	 * @param codigosTransaccion
	 * @return
	 * @throws SICException
	 */
	List<DatoTransaccionProcesamientoVenta> obtenerArticulosProcesamientoVentaAcumulados(ODatabaseDocumentTx db, Integer codigoCompania, Date fecha,  Set<Integer> codigosTransaccion) throws SICException;


	/**
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param fechaProcesamientoVenta
	 * @param codigoTransaccion
	 * @return
	 * @throws SICException
	 */
	ODocument obtenerDatosAcumuladosArticuloVentaResumen(Integer codigoCompania, String codigoArticulo, Date fechaProcesamientoVenta, Integer codigoTransaccion) throws SICException;
	
	/**
	 * @param db
	 * @param codigoCompania
	 * @param fecha
	 * @param codigosTransaccion
	 * @return
	 * @throws SICException
	 */
	List<DatoTransaccionProcesamientoVenta> obtenerArticulosProcesamientoVentaDiarios(ODatabaseDocumentTx db, Integer codigoCompania, Date fecha,  Set<Integer> codigosTransaccion) throws SICException;
	
	/**
	 * @param db
	 * @param codigoCompania
	 * @param fechaProcesamiento
	 * @param codigosArticulos
	 * @return
	 * @throws SICException
	 */
	List<ODocument> obtenerHistorialPrecioArticulos(ODatabaseDocumentTx db, Integer codigoCompania, Date fechaProcesamiento,  Set<String> codigosArticulos) throws SICException;
	
	/**
	 * 
	 * @param db
	 * @param codigoArticulo
	 * @param codigoCompania
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return
	 */
	List<ODocument> obtenerListadoPreciosMargenReal(ODatabaseDocumentTx db, String codigoArticulo, Integer codigoCompania, Date fechaInicial, Date fechaFinal);
}