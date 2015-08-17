/*
 * Kruger 2015 
 */ 
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.reporte.tesoreria;

import java.util.Calendar;
import java.util.List;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;

/**
 * <b> Genera los datos del reporte en bytes y como documento. </b>
 *
 * @author mchiliquinga, Date: 16/3/2015
 *
 */
public interface IReporteTesoreriaImpresionGestor {
	
	/**
	 * <b> En base a la lista de objetos que contiene los datos del reporte los agrupa por tipo de proveedor(N/I) con lo cual genera una
	 *  cadena XML y un Documento fo este ultimo sera enviado para ser impreso en una impresora previamente configurada. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 16/3/2015]
	 * </p>
	 *
	 * @param fechaReporte
	 *            fehca seleccionada para el reporte
	 * @param areaTrabajoSeleccionada
	 *            representa el cd y la subbodega seleccionada
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @param codigoAreaTrabajo
	 *            area de trabajo del usuario logeado
	 * @param datosReporte
	 *            lista que contiene los datos para generar el reporte
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error
	 */  
	void generarReporteTesoreriaImpresion(Calendar fechaReporte, AreaTrabajoDTO areaTrabajoSeleccionada, Integer codigoCompania,
			Integer codigoAreaTrabajo, List<DetalleFacturaEstadoDTO> datosReporte) throws SICException;

	/**
	 * <b> Genera los datos del reporte en bytes para desplagar el reprote en formato PDF. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 17/3/2015]
	 * </p>
	 *
	 * @param fechaSeleccionada
	 *            fehca seleccionada para el reporte
	 * @param areaTrabajoSeleccionada
	 *            representa el cd y la subbodega seleccionada
	 * @param datosReporte
	 *            lista que contiene los datos para generar el reporte
	 * @return bytes con los datos del reporte
	 * @throws SICException
	 *             excepcion propagada en caso de existir un error
	 */
	byte[] generarBytesReporteTesoreria(Calendar fechaSeleccionada, AreaTrabajoDTO areaTrabajoSeleccionada,
			List<DetalleFacturaEstadoDTO> datosReporte) throws SICException;

}
