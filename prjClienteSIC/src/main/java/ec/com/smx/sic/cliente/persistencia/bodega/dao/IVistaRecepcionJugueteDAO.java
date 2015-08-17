/*
 * Kruger 2014 
 */
package ec.com.smx.sic.cliente.persistencia.bodega.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.IndicadorPropietarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDetalleEstadoRelacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.SubClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionJugueteDTO;

/**
 * <b> Dao asociado a la recepcion de juguetes. </b>
 * 
 * @author mchiliquinga, Date: 19/03/2014
 * 
 */
public interface IVistaRecepcionJugueteDAO {

	/**
	 * <b> Obtiene una lista mediante un sql nativo, la cual contiene todos los
	 * datos necesarios para realizar una recepcion de juguetes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 19/03/2014]
	 * </p>
	 * 
	 * @param fechaRegistroDesde
	 *            filtro de fecha limite inferior (fecha de registro del pedido)
	 * @param fechaRegistroHasta
	 *            filtro de fecha limite superior (fecha de registro del pedido)
	 * @param codigoProveedor
	 *            codigo del proveedor
	 * @param nombreProveedor
	 *            nombre del proveedor
	 * @param codigoBodega
	 *            codigo de la bodega de juguetes
	 * @param codigoSubBodega
	 * 			  codigo de la subbodega de juguetes 
	 * @param ubicacion
	 *            define si se realiza o no la relacion con las tablas para obtener la ubicacion
	 * @param codigosEmbarque
	 * 			  filtra la recepcion por el codigo de embarque(s)
	 * @return lista con los datos que cumplan la condicion
	 */ 
	List<VistaRecepcionJugueteDTO> obtenerRecepcionJuguetes(Date fechaRegistroDesde, Date fechaRegistroHasta, String codigoProveedor,
			String nombreProveedor, String codigoJDEProveedor, Integer codigoCD, Integer codigoBodega, String codigoSubBodega, boolean ubicacion, List<Long> codigosEmbarque,
			String codigoArticulo, List<Long> codigosOrdenCompraDetalleEstado, Long codigoEmbarque);
	
	/**
	 * Permite desactivar los OrdenCompraDetalleEstadoRelacionDTO de una coleccion
	 * 
	 * @param ordenCompraDetalleEstadoRelacionDTOs Un Collection
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void desactivarOrdenCompraDetalleEstadoRelacion(Integer codigoCompania, Collection<OrdenCompraDetalleEstadoRelacionDTO> ordenCompraDetalleEstadoRelacionDTOs) throws SICException;
	
	/**
	 * <b> Actualiza el codigo de migracion de la orden compra estado; esto debido
	 * a que cuando realice la recepcion por segunda vez tambien se debe
	 * migrar los datos de la orden de compra </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 05/05/2014]
	 * </p>
	 * 
	 * @param idOrdenCompraEstados codigos de  orden compra estado
	 * @param codigoCompania
	 */ 
	void actualizarCodigoMigracion(Collection<Long> idOrdenCompraEstados, Integer codigoCompania);
	
	/**
	 * Busca los articulos de las ordenes de compra de un embarque por proveedor y unidad de manejo
	 * 
	 * @param codigoCompania Codigo de la compania
	 * @param codigoOrdenCompraDetalleEstado  Codigo del detalle de la orden de compra estado
	 * @param codigoUnidadManejo Codigo de la unidad de manejo
	 * @param codigoProveedor Codigo del proveedor
	 * 
	 * @throws SICException Excepcion en caso de producirse un error
	 */
	void cambiarArticuloOrdenCompraDetalleEstado(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, Long codigoUnidadManejo, String codigoProveedor, Long codigoEmbarque) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoUnidadManejo
	 * @param codigoProveedor
	 * @param codigoEmbarque
	 * @throws SICException
	 */
	Collection<OrdenCompraDetalleEstadoDTO> buscarOrdenCompraDetalleEstadoPorArticuloUnidadManejoProveedorEmbarque(Integer codigoCompania, Long codigoUnidadManejo, String codigoProveedor, Long codigoEmbarque) throws SICException;
	
	/**
	 * <b> Actualiza el costo de la moneda de origen(costo bruto) dentro de la orden compra detalle estado; este dato es actualizado desde pantalla
	 * cuando marca el check del costo disney. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 29/05/2014]
	 * </p>
	 * 
	 * @param recepcionJuguete dato que ha sido modificado el costo disney
	 */
	void actualizarCostoMonedaOrigen(VistaRecepcionJugueteDTO recepcionJuguete);
	
	/**
	 * <b> Retorna una coleccion de proveedor que cumplan las condiciones de igualdad en codigo y nombre usando el operador LIKE. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 26/06/2014]
	 * </p>
	 * 
	 * @param codigoProveedor
	 * @param nombreProveedor
	 * @param codigoCompania
	 * @return
	 */
	Collection<VistaProveedorDTO> buscarProveedorPorCodigoNombre(String codigoProveedor, String nombreProveedor, Integer codigoCompania);
	
	/**
	 * <b> Actualiza varios datos de detalle de la orden de compra (estado, catidad pedida, cantidad entrega recepcion), estos datos son actualizados
	 * siempre y cuando los valores de los parametros sean diferente de null. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 08/09/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 *            identificador del detalle que se actualizara
	 * @param nuevoEstado
	 *            nuevo estado del detalle (ACT/INC)
	 * @param cantidadPedida
	 *            dato para actualizar la cantidad pedida
	 * @param cantidadEntregadaRecepcion
	 *            dato para actualizar la cantidad entregada al realizar la recepcion
	 * @param userId
	 *            usuario que esta realizando la actualizacion
	 */ 
	void actualizarOrdenCompraDetalleEstado(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, String nuevoEstado,
			Integer cantidadPedida, Integer cantidadEntregadaRecepcion, String userId);
	
	/**
	 * <b> Obtiene una lista con los codigos de locales en el cual tiene alcances el articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 07/11/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 *            articulo para buscar los alcances
	 * @param estadoArticuloLocal
	 *            estado para filtrar la busqueda
	 * @return
	 */
	List<Integer> obtenerIdsLocalesPorArticulo(Integer codigoCompania, String codigoArticulo, String estadoArticuloLocal);
	
	/**
	 * <b> Obtiene una lista de tipo 'ArticuloLocalDTO' la cual representa los locales en el cual tienen alcances el articulo(codigo) que se pasa como
	 * parametro. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 07/11/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoArticulo
	 *            articulo para buscar los alcances
	 * @param estadoArticuloLocal
	 *            estado para filtrar la busqueda
	 * @return
	 */
	List<ArticuloLocalDTO> obtenerLocalesPorArticulo(Integer codigoCompania, String codigoArticulo, String estadoArticuloLocal);
	
	/**
	 * <b> Obtiene subclasificaciones en base a un conjunto de codigos de clasificacion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/11/2014]
	 * </p>
	 * 
	 * @param codigosClasificacion
	 *            codigos de las clasificaciones
	 * @param codigoCompania
	 *            codigo de la compania para filtrar la busqueda
	 * @param estado
	 *            activo
	 * @return
	 */
	List<SubClasificacionDTO> obtenerSubclaficaciones(Collection<Long> codigosClasificacion, Integer codigoCompania, String estado);
	
	/**
	 * <b> Obtiene los los datos de los diferentes tipos de indicador propietario. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param estado filtra la busqueda por un estado especifico
	 * @return lista de Indicador propietario
	 */ 
	List<IndicadorPropietarioDTO> obtenerDatosIndicadorPropietario(String estado);
	
	/**
	 * <b> Actualiza el indicador peopietario modificado desde pantalla. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 08/01/2015]
	 * </p>
	 * 
	 * @param datoIndicadorPropietario
	 *            contiene los datos para la actializacion
	 * @param userId
	 *            identificador del usuario que realiza la accion
	 */
	void actualizarIndicadorPropietario(VistaRecepcionJugueteDTO datoIndicadorPropietario, String userId);
	
	/**
	 * <b> Valida que el codigo de clasificacion pertenezca a la subbodega de
	 * juguetes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 12/01/2015]
	 * </p>
	 * 
	 * @param codigoClasificacion
	 *            clasificacion del articulo
	 * @param subBodegaJuguetes
	 *            codigo de la subbodega de juguetes
	 * @param estado
	 *            filtra la consulta por el estado (ACT/INC)
	 * @return lista con las clasificaciones que posea
	 */ 
	List<ClasificacionDTO> buscarClasificacionBodegaJuguetes(String codigoClasificacion, String subBodegaJuguetes, String estado);
	
	/**
	 * <b> Obtiene un area de trabajo en base a su identificador. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 21/04/2015]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoAreaTrabajo
	 *            identificador del area de trabajo
	 * @param estado
	 *            filtra el estado del area de trabjo
	 * @return area de trabajo
	 */
	AreaTrabajoDTO obtenerAreaTrabajoPorId(Integer codigoCompania, Integer codigoAreaTrabajo, String estado);
	
	/**
	 * <b> Obtiene el estado del articulo (precodificado/codificado) en base al identificadorn de la tabla. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 29/6/2015]
	 * </p>
	 *
	 * @param codigoCompania
	 *            condigo de la compania
	 * @param codigoArticulo
	 *            identificador del articulo
	 * @param estado
	 *            estado del articulo (activo)
	 * @return tipo del articulo (PCO/COD)
	 */ 
	String obtenerEstadoArticuloPorId(Integer codigoCompania, String codigoArticulo, String estado);
	
	/**
	 * <b> Obtiene un articulo en base a su identificador. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 30/06/2015]
	 * </p>
	 * 
	 * @param codigoCompania
	 *            codigo de la compania
	 * @param codigoArticulo
	 *            identificador de la tabla
	 * @param estado
	 *            filtra por el estado del articulo (0/1)
	 * @return articulo en funcion de su identificador
	 */
	ArticuloDTO obtenerArticuloPorId(Integer codigoCompania, String codigoArticulo, String estado);
	
	List<ArticuloDTO> obtenerArticulosPorIds(Integer codigoCompania, String estado, List<String> codigosArticulo);
	
}
