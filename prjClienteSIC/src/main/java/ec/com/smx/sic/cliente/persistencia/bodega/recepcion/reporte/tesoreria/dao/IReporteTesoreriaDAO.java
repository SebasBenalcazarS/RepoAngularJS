/*
 * Kruger 2015 
 */ 
package ec.com.smx.sic.cliente.persistencia.bodega.recepcion.reporte.tesoreria.dao;

import java.util.Calendar;
import java.util.List;

import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;

/**
 * <b> Define los metodos necesarios para obtener los datos para el reporte de
 * tesoreria. </b>
 *
 * @author mchiliquinga, Date: 20/2/2015
 *
 */
public interface IReporteTesoreriaDAO {

	/**
	 * <b> Cuenta el numero de recepciones que aun no han sido facturadas. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/2/2015]
	 * </p>
	 *
	 * @param fechaInicio
	 * 			  filtra las recepciones de un dia especifico
	 * @param estado
	 *            filtra la consulta por los estados activos
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @param estadosProcesosLogisticos
	 *            filtra la consulta por estados FAC y ANU
	 * @return numero de recepciones que no esten en estado facturado o anulado
	 */
	Long obtenerRecepcionesNoFacturadas(Calendar fechaInicio, String estado, Integer codigoCompania, Integer codigoAreaTrabajoCd, Integer codigoAreaTrabajoSubBodega, String... estadosProcesosLogisticos);
	
	/**
	 * <b> Obtiene los codigos de las factura interna que fueron generadas en un dia especifico. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/2/2015]
	 * </p>
	 *
	 * @param fechaSeleccionada
	 *            fecha inicial para filtrar el reporte
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @param estado
	 *            estado activo de la factura interna
	 * @param tipoFacturaInterna
	 *            catalago que define a la factura como interna
	 * @param codigoAreaTrabajoCd
	 *            cd para filtrar la consulta
	 * @param codigoAreaTrabajoSubBodega
	 *            subBodega para filtrar la consulta
	 * @return todas las facturas interna generadas para la fecha seleccionada
	 */
	List<Long> obtenerCodigosFacturaInterna(Calendar fechaSeleccionada, Integer codigoCompania, String estado,
			String tipoFacturaInterna, Integer codigoAreaTrabajoCd, Integer codigoAreaTrabajoSubBodega);
	
	/**
	 * <b> Obtiene todas las facturas internas generadas en un dia especifico. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/2/2015]
	 * </p>
	 *
	 * @param codigosFactura
	 *            codigos de facturas internas generadas en un dia especifico
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @return facturas internas
	 */
	List<DetalleFacturaEstadoDTO> obtenerDatosFacturaInterna(List<Long> codigosFactura, Integer codigoCompania);
	
}
