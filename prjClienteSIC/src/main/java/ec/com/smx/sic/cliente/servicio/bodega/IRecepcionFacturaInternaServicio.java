package ec.com.smx.sic.cliente.servicio.bodega;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.bodega.factura.digital.almacenamiento.IAlmacenamientoFacturaInternaGestor;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionCantidadesRecibidasDTO;
import ec.com.smx.sic.cliente.mdl.vo.FacturaInternaVO;


/**
 * 
 * @author acaiza
 *
 */
public interface IRecepcionFacturaInternaServicio {
	
	/**
	 * 
	 * @param vistaProcesoLogisticoDTOs
	 * @return
	 * @throws SICException
	 */
	public Collection<VistaRecepcionCantidadesRecibidasDTO> consultarCantidadesRecibidasRecepcion(Collection<VistaProcesoLogisticoDTO> vistaProcesoLogisticoDTOs) throws SICException;
	
	/**
	 * Este metodo devuelve un objeto VO cargado con todos los datos de la factura interna
	 * @param vistasProcesoLogisticoDTO
	 * @return
	 */
	public FacturaInternaVO obtenerDatosFacturaInterna (Collection<VistaProcesoLogisticoDTO> vistasProcesoLogisticoDTO) throws SICException;
	
	/**
	* {@link ICalculoFacturaInternaGestor#obtenerImpuestosPorGrupo(String, String...)
	*/ 
	List<TipoImpuestoDTO> obtenerImpuestosPorGrupo(String estado, String... codigosGrupoImpuesto) throws SICException; 
	
	/**
	* {@link ICalculoFacturaInternaGestor#obtenerDescuentosPorTipoUso(String, String)
	*/ 
	List<TipoDescuentoDTO> obtenerDescuentosPorTipoUso(String estado, String valorTipoUso) throws SICException;
	
	/**
	* {@link ICalculoFacturaInternaGestor#obtenerBodegaPorAreaTrabajo(Integer, Integer, String)
	*/ 
	BodegaDTO obtenerBodegaPorAreaTrabajo(Integer codigoAreaTrabajo, Integer codigoCompania, String estado) throws SICException;
	
	/**
	* {@link ICalculoFacturaInternaGestor#obtenerEmpresa(Integer, String, String)
	*/ 
	EmpresaDTO obtenerEmpresa(Integer codigoCompania, String tipoLocalizacion, String estado) throws SICException;
	
	/**
	* {@link ICalculoFacturaInternaGestor#obtenerProcesoLogisticoPorId(Integer, Long, String)
	*/ 
	ProcesoLogisticoEstadoDTO obtenerProcesoLogisticoPorId(Integer codigoCompania, Long codigoProcesoLogistico, String estado) 
			throws SICException;
	
	/**
	* {@link IAlmacenamientoFacturaInternaGestor#registrarFacturaInterna(FacturaInternaVO, EmpresaDTO, String, String, String, String, String)}
	*/ 
	FacturaEstadoDTO transRegistrarFacturaInterna(FacturaInternaVO facturaInternaVO, EmpresaDTO empresa, String userId, String secNotaIngreso,
			String secNumeroFactura, String codigoSistema, String codigoOpcion) throws SICException;
	
	/**
	* {@link ICalculoFacturaInternaGestor#obtenerFacturaPorRecepcion(Long, Integer, String, String)
	*/ 
	FacturaDTO obtenerFacturaPorRecepcion(Long codigoRecepcionProveedor, Integer codigoCompania, String estado,
			String facturaInterna) throws SICException;
	
	/**
	* {@link ICalculoFacturaInternaGestor#obtenerDetallesFacturaInterna(Long, Integer, String)
	*/ 
	List<DetalleFacturaEstadoDTO> obtenerDetallesFacturaInterna(Long codigoFactura, Integer codigoCompania, String estado)
			throws SICException;
	
	/**
	* {@link ICalculoFacturaInternaGestor#obtenerCodigoBarrasPorArticulo(String, String, Integer)
	*/ 
	String obtenerCodigoBarrasPorArticulo(String estado, String codigoArticulo, Integer codigoCompania) throws SICException;
	
	/**
	 * {@link ICalculoFacturaInternaGestor#obtenerArticulosRecibidosRecepcion(String, String, Collection)
	 */
	List<VistaRecepcionCantidadesRecibidasDTO> obtenerArticulosRecibidosRecepcion(String estado, String estadoPalletAnulado,
			Collection<Long> codigosProcesoLogistico) throws SICException;
	
	/**
	 * {@link ICalculoFacturaInternaGestor#actualizarEstadoImpresion(boolean, Integer, List, String)
	 */
	void actualizarEstadoImpresion(boolean estadoImpreso, Integer codigoCompania, List<Long> codigosRecepcionProveedor, String userId)
			throws SICException;
	
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
	 * @param codigoAreaTrabajoBodega
	 *            bodega seleccionada para generar el reporte
	 * @param estado
	 *            filtra los datos por estado activo
	 * @return facturas internas registradas para un dia en particular
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error
	 */
	List<DetalleFacturaEstadoDTO> obtenerDatosReporte(Calendar fechaSeleccionada, Integer codigoCompania, String tipoFacturaInterna,
			Integer codigoAreaTrabajoCd, Integer codigoAreaTrabajoBodega, String estado) throws SICException;
	
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
