/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.procesamientoventas.administracion.almacenamiento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAlmacenamientoDatosProcesamientoVentasDocumentDAO extends Serializable {


	/**
	 * @param oDocument
	 * @throws SICException
	 */
	void registrarArticuloVentaDocument(ODocument oDocument) throws SICException;


	/**
	 * @param oDocument
	 * @param fechaProcesamiento
	 * @param codigoTransaccion
	 * @throws SICException
	 */
	void registrarArticuloLocalVentaDocument(ODocument oDocument, Date fechaProcesamiento, Integer codigoTransaccion) throws SICException;


	/**
	 * @param db
	 * @param articuloVentaDocument
	 * @throws SICException
	 */
	void registrarIndiceArticuloVenta(ODatabaseDocumentTx db, ODocument articuloVentaDocument) throws SICException;


	/**
	 * @param db
	 * @param articuloLocalVentaDocument
	 * @param fechaProcesamiento
	 * @param codigoTransaccion
	 * @throws SICException
	 */
	void registrarIndiceArticuloLocalVenta(ODatabaseDocumentTx db, ODocument articuloLocalVentaDocument, Date fechaProcesamiento, Integer codigoTransaccion) throws SICException;


	/**
	 * 
	 * @param db
	 * @param ridArticuloLocalVenta
	 * @param totalCantidadArticulo
	 * @param totalVentaAcumuladaArtLoc
	 * @param cobraIva
	 * @param porcentajeIva
	 * @throws SICException
	 */
	void actualizarArticuloLocalVenta(ODatabaseDocumentTx db, ORID ridArticuloLocalVenta, BigDecimal totalCantidadArticulo, BigDecimal totalVentaAcumuladaArtLoc, Integer cobraIva, Double porcentajeIva) throws SICException;


	/**
	 * @param db
	 * @param datosVentaArticuloDocument
	 * @throws SICException
	 */
	void actualizarTotalVentaArticulo(ODatabaseDocumentTx db, ODocument datosVentaArticuloDocument) throws SICException;


	/**
	 * @param db
	 * @param ridArticuloVentaResumen
	 * @param fechaProcesamientoVenta
	 * @param totalVentaAcumulada
	 * @throws SICException
	 */
	void actualizarTotalAcumuladoArticuloVentaResumen(ODatabaseDocumentTx db, ORID ridArticuloVentaResumen, Date fechaProcesamientoVenta, BigDecimal totalVentaAcumulada) throws SICException;


	/**
	 * @param articuloVentaResumenDocument
	 * @param fechaProcesamiento
	 * @param codigoTransaccion
	 * @throws SICException
	 */
	void registrarArticuloVentaResumenDocument(ODocument articuloVentaResumenDocument, Date fechaProcesamiento, Integer codigoTransaccion) throws SICException;
	
	/**
	 * @param db
	 * @param ridHistorial
	 * @param fechaProcesamientoVenta
	 * @param precioArticulo
	 * @throws SICException
	 */
	void actualizarHistorialArticuloPrecioVenta(ODatabaseDocumentTx db, ORID ridHistorial, Date fechaProcesamientoVenta, Double precioArticulo) throws SICException;
	
	/**
	 * @param historialArticuloPrecioDocument
	 * @param fechaProcesamiento
	 * @throws SICException
	 */
	void registrarHistorialArticuloPrecioDocument(ODocument historialArticuloPrecioDocument, Date fechaProcesamiento) throws SICException ;

}
