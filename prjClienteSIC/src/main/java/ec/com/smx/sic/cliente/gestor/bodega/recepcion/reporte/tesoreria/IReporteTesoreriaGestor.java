/*
 * Kruger 2015 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.reporte.tesoreria;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;

/**
 * <b> Expone los metodos necesarios para obtener los datos que se desplegaran
 * en el reporte de tesoreria. </b>
 *
 * @author mchiliquinga, Date: 20/2/2015
 *
 */
public interface IReporteTesoreriaGestor {
	
	/**
	 * <b> Obtiene los datos necesarios para generar el reporte de tesoreria. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/2/2015]
	 * </p>
	 *
	 * @param fechaSeleccionada
	 *            fecha seleccionada para generar el reporte
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @param tipoFacturaInterna
	 *            optiene los datos solo de las factura que sean de tipo interna
	 * @param codigoAreaTrabajoCd
	 *            centro de distribucion seleccionado para generar el reporte
	 * @param codigoAreaTrabajoSubBodega
	 *            subBodega seleccionada para generar el reporte
	 * @param estado
	 *            filtra los datos por estado activo
	 * @return facturas internas registradas para un dia en particular
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error
	 */
	List<DetalleFacturaEstadoDTO> obtenerDatosReporte(Calendar fechaSeleccionada, Integer codigoCompania, String tipoFacturaInterna,
			Integer codigoAreaTrabajoCd, Integer codigoAreaTrabajoSubBodega, String estado) throws SICException;
	
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
	Long obtenerRecepcionesNoFacturadas(Calendar fechaInicio, String estado, Integer codigoCompania, Integer codigoAreaTrabajoCd, Integer codigoAreaTrabajoSubBodega, String... estadosProcesosLogisticos)
			throws SICException;
	
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
	 * @throws SICException excepcion lanzada en caso de existir un error
	 */ 
	List<Long> obtenerCodigosFacturaInterna(Calendar fechaSeleccionada, Integer codigoCompania, String estado,
			String tipoFacturaInterna, Integer codigoAreaTrabajoCd, Integer codigoAreaTrabajoSubBodega) throws SICException;
	
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
	List<DetalleFacturaEstadoDTO> obtenerDatosFacturaInterna(List<Long> codigosFactura, Integer codigoCompania) 
			throws SICException;
	
	/**
	 * <b> Valida que todas las recepciones de un dia especifico se encuentren en estado facturado, de no ser asi lanza un excepcion para
	 * termianr el proceso del reporte. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/2/2015]
	 * </p>
	 *
	 * @param fechaInicio
	 *            fecha seleccionada para generar el reporte de un dia especifico
	 * @param estado
	 *            estado activo de las recepciones
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @param estadosProcesosLogisticos
	 *            estdos cancelado y facturado para filtra la consulta
	 * @throws SICException
	 *             excepcion alnzada en caso de existir un error
	 */
	void validarRecepcionesFacturadas(Calendar fechaInicio, String estado, Integer codigoCompania, Integer codigoAreaTrabajoCd,
			Integer codigoAreaTrabajoSubBodega, String... estadosProcesosLogisticos) throws SICException;
	
	/**
	 * <b> Valida que existan facturas para los parametros seleccionados. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 13/3/2015]
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
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error o cuando no existan datos para el reporte
	 */ 
	void validarExistenFacturasInternas(Calendar fechaSeleccionada, Integer codigoCompania, String estado,
			String tipoFacturaInterna, Integer codigoAreaTrabajoCd, Integer codigoAreaTrabajoSubBodega) throws SICException;
	
	/**
	 * <b> Obtiene una lista de objetos con los datos para el reporte y los procesa para realizar la impresion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 17/3/2015]
	 * </p>
	 *
	 * @param fechaSeleccionada
	 *            fecha seleccionada para generar el reporte
	 * @param areaTrabajoSeleccionada
	 *            representa el cd y la subBodega seleccionadas para el reporte
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @param codigoAreaTrabajo
	 *            area de trabajo del usuario logeado
	 * @throws SICException
	 *             excepcion propagada en caso de existir un errro
	 */
	void generarReporteTesoreriaImpresion(Date fechaSeleccionada, AreaTrabajoDTO areaTrabajoSeleccionada, Integer codigoCompania,
			Integer codigoAreaTrabajo) throws SICException;
	
	/**
	 * <b> Obtiene una lista con los datos del reporte y la transforma en un arreglo de bytes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 17/3/2015]
	 * </p>
	 *
	 * @param fechaSeleccionada
	 *            fecha seleccionada para generar el reporte
	 * @param areaTrabajoSeleccionada
	 *            representa el cd y la subBodega seleccionadas para el reporte
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @return datos del reporte en bytes
	 * @throws SICException
	 *             excepcion propagada en caso de existir un error
	 */
	byte[] generarBytesReporteTesoreria(Date fechaSeleccionada, AreaTrabajoDTO areaTrabajoSeleccionada, Integer codigoCompania)
			throws SICException;

}
