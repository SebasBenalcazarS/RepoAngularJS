package ec.com.smx.sic.cliente.gestor.procesamientoventas.administracion.validacion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.sic.cliente.exception.SICException;

/**
 * @author Luis Yacchirema
 *
 */
public interface IValidacionDatosProcesamientoVentasDocumentGestor extends Serializable {

	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoTransaccion
	 * @return
	 * @throws SICException
	 */
	ODocument generarArticuloVentaTransaccionDocument(Integer codigoCompania, String codigoArticulo, Integer codigoTransaccion, Date fechaVentaArticulo) throws SICException;


	/**
	 * 
	 * @param ridArticuloVenta
	 * @param codigoLocal
	 * @param totalCantidadArticulo
	 * @param totalVentaAcumuladaArtLoc
	 * @param cobraIva
	 * @param porcentajeIva
	 * @return
	 * @throws SICException
	 */
	ODocument generarArticuloLocalVentaTransaccionDocument(ORID ridArticuloVenta, Integer codigoLocal, BigDecimal totalCantidadArticulo, BigDecimal totalVentaAcumuladaArtLoc, Integer cobraIva, Double porcentajeIva) throws SICException;
	
	
	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param fechaProcesamientoVenta
	 * @param codigoTransaccion
	 * @param totalVentaArticulo
	 * @return
	 * @throws SICException
	 */
	ODocument generarArticuloVentaResumenDocument(Integer codigoCompania,
			String codigoArticulo, Date fechaProcesamientoVenta, Integer codigoTransaccion, BigDecimal totalVentaArticulo) throws SICException;


	/**
	 * @param articulosVentaDocumentRegistradoPorFechas
	 * @param codigoArticuloValidar
	 * @param codigoTransaccionValidar
	 * @return
	 * @throws SICException
	 */
	Boolean existeArticuloVentaDocumentRegistrado(List<ODocument> articulosVentaDocumentRegistradoPorFechas, String codigoArticuloValidar, Integer codigoTransaccionValidar) throws SICException;


	/**
	 * @param articulosVentaDocumentRegistrados
	 * @param codigoArticuloValidar
	 * @param codigoTransaccionValidar
	 * @return
	 * @throws SICException
	 */
	ORID obtenerRidArticuloVentaRegistrado(List<ODocument> articulosVentaDocumentRegistrados, String codigoArticuloValidar, Integer codigoTransaccionValidar) throws SICException;


	/**
	 * @param articulosLocalesVentaDocumentRegistrados
	 * @param codigoOridArticuloVentaValidar
	 * @param codigoLocalValidar
	 * @return
	 * @throws SICException
	 */
	ORID obtenerRidArticuloLocalVentaRegistrado(List<ODocument> articulosLocalesVentaDocumentRegistrados, ORID codigoOridArticuloVentaValidar, Integer codigoLocalValidar)  throws SICException;
	
	/**
	 * @param articulosDocumentRegistrados
	 * @param codigoArticuloValidar
	 * @param codigoTipoPrecio
	 * @return
	 * @throws SICException
	 */
	ORID obtenerRidHistorialArticuloVentaRegistrado(List<ODocument> articulosDocumentRegistrados, String codigoArticuloValidar, String codigoTipoPrecio);
	
	/**
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoTipoPrecio
	 * @param precioArticulo
	 * @param fechaProcesamientoVenta
	 * @return
	 * @throws SICException
	 */
	ODocument generarHistorialArticuloPrecioDocument(Integer codigoCompania, String codigoArticulo, String codigoTipoPrecio, Double precioArticulo, Date fechaProcesamientoVenta) throws SICException;
}
