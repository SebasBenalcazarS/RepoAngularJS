package ec.com.smx.sic.cliente.gestor.procesamientoventas.administracion.almacenamiento;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloPrecioDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.procesamientoventas.DatoTransaccionProcesamientoVenta;

/**
 * @author Luis Yacchirema
 *
 */
public interface IAlmacenamientoDatosProcesamientoVentasDocumentGestor extends Serializable {


	/**
	 * @param codigoCompania
	 * @param codigoTransaccion
	 * @param fechaProcesamientoVenta
	 * @param codigosArticulosProcesamientoVenta
	 * @throws SICException
	 */
	void registrarDatosArticulosProcesamientoVentas(Integer codigoCompania, Integer codigoTransaccion, Date fechaProcesamientoVenta,
			Set<String> codigosArticulosProcesamientoVenta) throws SICException;
	
	
	/**
	 * @param codigoCompania
	 * @param codigoTransaccion
	 * @param fechaProcesamientoVenta
	 * @param codigosArticulosProcesamientoVenta
	 * @throws SICException
	 */
	void registrarDatosArticulosLocalesProcesamientoVentas(Integer codigoCompania, Integer codigoTransaccion, Date fechaProcesamientoVenta,
			List<DatoTransaccionProcesamientoVenta> datosArticulosProcesamientoVenta) throws SICException;


	/**
	 * @param datosTotalesVentasArticulos
	 * @throws SICException
	 */
	void actualizarTotalesVentaArticulos(List<ODocument> datosTotalesVentasArticulos) throws SICException;


	/**
	 * @param codigoCompania
	 * @param fechaProcesamientoVenta
	 * @param datosTotalesVentaArticulos
	 * @throws SICException
	 */
	void actualizarTotalesAcumuladosArticuloVenta(Integer codigoCompania, Date fechaProcesamientoVenta, List<DatoTransaccionProcesamientoVenta> datosTotalesVentaArticulos) throws SICException;
	
	/**
	 * @param db
	 * @param codigoCompania
	 * @param fechaProcesamientoVenta
	 * @param articulosPrecios
	 * @throws SICException
	 */
	void registrarDatosHistorialArticulosPreciosProcesamientoVentas(ODatabaseDocumentTx db, Integer codigoCompania, Date fechaProcesamientoVenta, Collection<ArticuloPrecioDTO> articulosPrecios) throws SICException;

}
