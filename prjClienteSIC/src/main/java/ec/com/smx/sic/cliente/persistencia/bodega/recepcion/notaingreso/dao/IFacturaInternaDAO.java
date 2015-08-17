/*
 * Kruger 2015 
 */ 
package ec.com.smx.sic.cliente.persistencia.bodega.recepcion.notaingreso.dao;

import java.util.Collection;
import java.util.List;

import ec.com.smx.corpv2.dto.EmpresaDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.dto.DetalleFacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.RecepcionProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoDescuentoDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionCantidadesRecibidasDTO;

/**
 * <b> Interface que define los metodos para obterner informacion de la factura
 * interna. </b>
 *
 * @author mchiliquinga, Date: 14/1/2015
 *
 */
public interface IFacturaInternaDAO {
	
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
	List<TipoImpuestoDTO> obtenerImpuestosPorGrupo(String estado, String... codigosGrupoImpuesto);
	
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
	List<TipoDescuentoDTO> obtenerDescuentosPorTipoUso(String estado, String valorTipoUso);
	
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
	EmpresaDTO obtenerEmpresa(Integer codigoCompania, String tipoLocalizacion, String estado);
	
	/**
	 * <b> Obtiene el tipo del plazo de pago para un proveedor especifico. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 24/10/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 *            es el codigo del proveedor del cual se obtendra el plazo de pago
	 * @return
	 */ 
	String obtenerTipoPlazoPorProveedor(Integer codigoCompania, String codigoProveedor);
	
	/**
	 * <b> Una vez realizada la facturacion(generacion de factura interna) y en el caso que en dicho proceso hubiera existo agrupacion de procesos
	 * logisticos; cuando nuevamente ingrese a la parte de la factura interna los detalles que se presenten deben ser del total de la agrupacion y no
	 * solo del proceso logistico seleccionado; este metodo en base al proceso logistico seleccionado(una vez realizada la factura ya no se muestran
	 * los checks, por tanto solo se puede seleccionar uno mediante el menu contextual) retorna el o los procesos logisticos que tengan la misma
	 * factura interna, con lo cual se obtendran todos los procesos logisticos involucrados en la generacion de la factura interna. </b>
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
			String facturaInterna);
	
	/**
	 * <b> Obtiene una lista de procesos logisticos estados filtrada por el codigo del proceso logisto correspondiente. </b>
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
	List<ProcesoLogisticoEstadoDTO> obtenerProcesoLogisticoPorId(Integer codigoCompania, Long codigoProcesoLogistico, String estado);
	
	/**
	 * Consulta los articulo que fueron recibidos en las recepciones del proveedor
	 * 
	 * @param vistaProcesoLogisticoDTOs
	 * @return Un Collection de VistaRecepcionCantidadesRecibidasDTO
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	@Deprecated
	Collection<VistaRecepcionCantidadesRecibidasDTO> consultarCantidadRecibidasRecepcion(Collection<Long> codigosProcesoLogistico);
	
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
	BodegaDTO obtenerBodegaPorAreaTrabajo(Integer codigoAreaTrabajo, Integer codigoCompania, String estado);
	
	/**
	 * <b> Obtien la factura asociada al proceso logisto; esta factura es creada desde la pantalla de la factura interna. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 22/1/2015]
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
	 * @return factura interna creada para el o los procesos logisticos
	 */ 
	FacturaDTO obtenerFacturaPorRecepcion(Long codigoRecepcionProveedor, Integer codigoCompania, String estado,
			String facturaInterna);
	
	/**
	 * <b> Obtiene todos los detalles de la FIN conjuntamente con el resto de datos necesarios para armar la estructura que se muestra en 
	 * pantalla. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 28/1/2015]
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
	List<DetalleFacturaEstadoDTO> obtenerDetallesFacturaInterna(Long codigoFactura, Integer codigoCompania, String estado);
	
	/**
	 * <b> Obtiene el codigo de barras de un articulo especifico. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 23/1/2015]
	 * </p>
	 *
	 * @param estado
	 *            estado activo del CB
	 * @param codigoArticulo
	 *            es el codigo del articulo del cual se busca el codigo de
	 *            barras
	 * @param codigoCompania
	 * @return codigo de barras
	 */ 
	String obtenerCodigoBarrasPorArticulo(String estado, String codigoArticulo, Integer codigoCompania);
	
	/**
	 * <b> Obtiene todos los articulos recibidos en la recepcion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 2/2/2015]
	 * </p>
	 *
	 * @param estado
	 *            filtra el codigo de barras por el estado activo
	 * @param estadoPalletAnulado
	 *            filtra la consulta por un pallet que sea diferente a anulado
	 * @param codigosProcesoLogistico
	 *            procesos logisticos seleccionados
	 * @return todos los articulo que se han recibido
	 */
	List<VistaRecepcionCantidadesRecibidasDTO> obtenerArticulosRecibidosRecepcion(String estado, String estadoPalletAnulado, 
			Collection<Long> codigosProcesoLogistico);
	
	/**
	 * <b> Obtiene los nombres completos en base a los nombres de usuarios. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 6/2/2015]
	 * </p>
	 *
	 * @param userNames 
	 * @return nombres completos de usuarios
	 */ 
	List<String> obtenerRecibidoresPorUserName(List<String> userNames);
	
	/**
	 * <b> Una vez impresa la facutra interna hay que cambier el valor del esto impresion a true para no permitir impresiones posteriores.
	 * </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 10/2/2015]
	 * </p>
	 *
	 * @param estadoImpreso
	 *            verdadero define que la factura interna ya fue impresa
	 * @param codigoCompania
	 *            codigo de la compania
	 * @param codigosRecepcionProveedor
	 *            son los codigos relacionados con los procesos logisticos
	 * @param userId
	 *            identificador del usuario logeado
	 */
	void actualizarEstadoImpresion(boolean estadoImpreso, Integer codigoCompania, List<Long> codigosRecepcionProveedor, String userId);
	
	/**
	 * <b> Obtiene los Ids de las entregas en base a las ordenes de compra y los procesos logisticos. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 16/12/2014]
	 * </p>
	 *
	 * @param codigoCompania
	 * @param estado
	 *            filtra la consulta por los estados activos
	 * @param codigosProcesosLogisticos
	 *            son los procesos logisticos selecconados en pantalla
	 * @return ids entrgas orden compra estado
	 */
	List<EntregaOrdenCompraEstadoDTO> obtenerEntregaPorOrdenCompra(Integer codigoCompania, String estado,
			Collection<Long> codigosProcesosLogisticos);
	
	/**
	 * <b> Obtiene los mismos datos del metodo 'obtenerDetallesFacturaInterna', con la diferencia que los datos obtenidos son 
	 * unicamnete los necesarios, para ello se hace uso de Projections. </b>
	 * <p>
	 * <p>
	 * [Author: mchiliquinga, Date: 5/6/2015]
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
	List<DetalleFacturaEstadoDTO> obtenerDatosDetalleFacturaInterna(Long codigoFactura, Integer codigoCompania, String estado);

}