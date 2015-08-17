/*
 * Kruger 2015 
 */ 
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.notaingreso.calculo;

import java.util.Collection;
import java.util.List;

import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionCantidadesRecibidasDTO;
import ec.com.smx.sic.cliente.mdl.vo.FacturaInternaVO;
import ec.com.smx.sic.cliente.persistencia.bodega.recepcion.notaingreso.dao.IFacturaInternaDAO;

/** 
 * <b> Gestor que contiene todos los metodos necesarios para desplegar la factura interna. </b>
 *
 * @author mchiliquinga, Date: 4/2/2015
 *
 */
public interface ICalculoFacturaInternaGestor {

	/**
	 * <b> Obtiene los datos para desplegar la factura interna. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 4/2/2015]
	 * </p>
	 *
	 * @param vistasProcesoLogisticoDTO
	 *            proceso logisticos seleccionados
	 * @return factura interna que contiene los datos necesarios para desplegar
	 *         en pantalla
	 * @throws SICException
	 *             excepcion lanzada en caso de existir un error
	 */
	FacturaInternaVO cargarDatosFacturaInterna (Collection<VistaProcesoLogisticoDTO> vistasProcesoLogisticoDTO) throws SICException;
	
	/**
	 * Consulta los articulos recibidos en las recepciones del proveedor
	 * 
	 * @param vistaProcesoLogisticoDTOs
	 * @return Collection de VistaRecepcionCantidadesRecibidasDTO
	 * @throws SICException
	 */
	@Deprecated
	Collection<VistaRecepcionCantidadesRecibidasDTO> consultarArticulosRecibidosRecepcion
		(Collection<VistaProcesoLogisticoDTO> vistaProcesoLogisticoDTOs) throws SICException;
	
	/**
	 * <b> Obtiene una lista de tipos de impuestos en base a un estado y que pertenescan a un grupo o grupos definidos. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 18/09/2014]
	 * </p>
	 * 
	 * @param estado
	 *            estado del impuesto
	 * @param codigosGrupoImpuesto
	 *            grupo al que pertenece el impuesto (IVA, IVE...)
	 * @return
	 */
	List<TipoImpuestoDTO> obtenerImpuestosPorGrupo(String estado, String... codigosGrupoImpuesto) throws SICException; 
	
	/**
	 * <b> Obtiene los descuentos en base a un tipo de uso. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 18/09/2014]
	 * </p>
	 * 
	 * @param estado
	 *            estado del descuento
	 * @param valorTipoUso
	 *            tipo de uso por el cual se quiere filtrar la consulta
	 * @return
	 */ 
	List<TipoDescuentoDTO> obtenerDescuentosPorTipoUso(String estado, String valorTipoUso) throws SICException;
	
	/**
	 * <b> Obtiene una bodega filtrada por el codigo del area de trabajo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 26/09/2014]
	 * </p>
	 * 
	 * @param codigoAreaTrabajo
	 *            es el area de trabajo con la cual se busca la bodega
	 * @param codigoCompania
	 * @param estado
	 *            define el estado de la bodega para realizar la busqueda
	 * @return
	 */
	BodegaDTO obtenerBodegaPorAreaTrabajo(Integer codigoAreaTrabajo, Integer codigoCompania, String estado) throws SICException;
	
	/**
	 * <b> Obtiene la empresa con la localizacion de la matriz en base al codigo de compania del usuario logeado. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 07/10/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 *            codigo de la compania del usuario logeado
	 * @param tipoLocalizacion
	 *            localizacion de la empresa(matriz para este caso)
	 * @param estado
	 *            define que la empresa que busca se encuentra activo
	 * @return
	 */ 
	EmpresaDTO obtenerEmpresa(Integer codigoCompania, String tipoLocalizacion, String estado) throws SICException;
	
	/**
	 * <b> Obtiene todos los procesos logisticos agrupados al momento de realizar la factura interna. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 26/11/2014]
	 * </p>
	 * 
	 * @param codigoRecepcionProveedor
	 *            es el codigo de la recepcion asociado al proceso logistico(seleccioando desde pantalla)
	 * @param codigoCompania
	 *            identificador de la compania
	 * @param estado
	 *            es el estado de la recepcion(solo activos)
	 * @param facturaInterna
	 *            define el estado del proceso lofistico(FIN)
	 * @return
	 */
	List<RecepcionProveedorDTO> obtenerRecepcionPorFactura(Long codigoRecepcionProveedor, Integer codigoCompania, String estado,
			String facturaInterna) throws SICException;
	
	/**
	 * <b> Obtiene un proceso logistico estado filtrada por el codigo del proceso logisto correspondiente. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/1/2015]
	 * </p>
	 *
	 * @param codigoCompania
	 *            es el codigo de la compania
	 * @param codigoProcesoLogistico
	 *            proseco losgistico seleccionado
	 * @param estado
	 *            filtra la budqueda por el estado
	 * @return lista de estados procesos logisticos
	 */
	ProcesoLogisticoEstadoDTO obtenerProcesoLogisticoPorId(Integer codigoCompania, Long codigoProcesoLogistico, String estado) 
			throws SICException;
	
	/**
	 * {@link IFacturaInternaDAO#obtenerFacturaPorRecepcion(Long, Integer, String, String)}
	 */ 
	FacturaDTO obtenerFacturaPorRecepcion(Long codigoRecepcionProveedor, Integer codigoCompania, String estado,
			String facturaInterna) throws SICException;
	
	/**
	 * {@link IFacturaInternaDAO#obtenerDetallesFacturaInterna(Long, Integer, String)}
	 */ 
	List<DetalleFacturaEstadoDTO> obtenerDetallesFacturaInterna(Long codigoFactura, Integer codigoCompania, String estado)
			throws SICException;
	
	/**
	 * {@link IFacturaInternaDAO#obtenerCodigoBarrasPorArticulo(String, String, Integer)}
	 */
	String obtenerCodigoBarrasPorArticulo(String estado, String codigoArticulo, Integer codigoCompania) throws SICException;
	
	/**
	 * {@link IFacturaInternaDAO#obtenerArticulosRecibidosRecepcion(String, String, Collection)
	 */
	List<VistaRecepcionCantidadesRecibidasDTO> obtenerArticulosRecibidosRecepcion(String estado, String estadoPalletAnulado,
			Collection<Long> codigosProcesoLogistico) throws SICException;
	
	/**
	 * {@link IFacturaInternaDAO#obtenerRecibidoresPorUserName(List)
	 */
	List<String> obtenerRecibidoresPorUserName(List<String> userNames) throws SICException;
	
	/**
	 * {@link IFacturaInternaDAO#actualizarEstadoImpresion(boolean, Integer, List, String)
	 */
	void actualizarEstadoImpresion(boolean estadoImpreso, Integer codigoCompania, List<Long> codigosRecepcionProveedor, String userId)
		throws SICException;
	
	/**
	 * <b> Obtiene los mismos datos del metodo 'obtenerDetallesFacturaInterna', con la diferencia que los datos obtenidos son 
	 * unicamnete los necesarios, para ello se hace uso de Projections. </b>
	 * <p>
	 * <p>
	 * [Author: mchiliquinga, Date: 8/6/2015]
	 * </p>
	 * </p>
	 *
	 * @param codigoFactura
	 *            codigo de la FIN generada
	 * @param codigoCompania
	 *            compania del usuario logeado
	 * @param estado
	 *            filtra la consulta por un estado especifico
	 * @return detalles de la factura interna
	 */ 
	List<DetalleFacturaEstadoDTO> obtenerDatosDetalleFacturaInterna(Long codigoFactura, Integer codigoCompania, String estado)
			throws SICException;
	
}
