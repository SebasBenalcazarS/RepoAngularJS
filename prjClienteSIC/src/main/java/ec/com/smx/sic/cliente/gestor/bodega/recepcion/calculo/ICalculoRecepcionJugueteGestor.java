/*
 * Kruger 2014 
 */
package ec.com.smx.sic.cliente.gestor.bodega.recepcion.calculo;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.CompaniaDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDinamicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.EntregaDTO;
import ec.com.smx.sic.cliente.mdl.dto.IndicadorPropietarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaRecepcionJugueteDTO;
import ec.com.smx.sic.cliente.mdl.vo.RecepcionJugueteVO;
import ec.com.smx.sic.cliente.mdl.vo.SlickGridVO;

/**
 * <b> Gestor que obtiene la informacion necesaria para la recepcion de juguetes.
 * </b>
 * 
 * @author mchiliquinga, Date: 20/03/2014
 * 
 */
public interface ICalculoRecepcionJugueteGestor {

	/**
	 * <b> Obtiene una lista mediante un sql nativo, la cual contiene todos los
	 * datos necesarios para realizar una recepcion de juguetes. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 20/03/2014]
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
			String nombreProveedor, String codigoJDEProveedor, Integer codigoCD, Integer codigoBodega, String codigoSubBodega, boolean ubicacion, List<Long> codigosEmbarque) throws SICException;

	/**
	 * <b> Crea la estructura necesaria para mostrar datos usando SlickGrid.
	 * </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 24/03/2014]
	 * </p>
	 * 
	 * @param recepcionJugueteDTOs
	 *            lista que contiene los datos de la recepcion de juguetes
	 * @return objeto de tipo SlickGridVO que contiene las cabeceras y el
	 *         contenido que se mostrara en el SlickGrid
	 * @throws SICException
	 */
	SlickGridVO createDataFromDTOtoJson(List<VistaRecepcionJugueteDTO> recepcionJugueteDTOs) throws SICException;
	
	/**
	 * <b> Obtiene los datos de un proveedor filtrado por el codigo de compania y proveedor. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 01/04/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoProveedor
	 * @return
	 * @throws SICException
	 */
	VistaProveedorDTO obtenerProveedorPorID(Integer codigoCompania, String codigoProveedor) throws SICException;
	
	/**
	 * <b> Obtiene un objeto de tipo compania con su respectiva provincia. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 01/04/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	CompaniaDTO obtenerCompaniaConProvincia(Integer codigoCompania) throws SICException;
	
	/**
	 * <b> Crea una lista con los datos que fueron cambiados en pantalla, para
	 * lo cual recibe una cadena un formato JSON. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/04/2014]
	 * </p>
	 * 
	 * @param origenDatosJSON
	 *            cadena en formato JSON con los datos que fueron modificados en
	 *            pantalla
	 * @return lista de tipo VistaRecepcionJugueteDTO
	 * @throws SICException
	 */ 
	List<VistaRecepcionJugueteDTO> obtenerDatosDesdeJSON(String origenDatosJSON) throws SICException;
	
	/**
	 * <b> Crea un objeto de tipo EntregaDTO con todos los datos necesarios para registrar la recepcion
	 * </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 14/04/2014]
	 * </p>
	 * 
	 * @param vistaRecepcionJugueteDTOs
	 *            lista que contiene los datos de la recepcion
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	EntregaDTO obtenerEntegarParaCrearRecepcion(List<VistaRecepcionJugueteDTO> vistaRecepcionJugueteDTOs, Integer codigoCompania) throws SICException;
	
	/**
	 * <b> Agrupa los datos por proveedor, cada elemento de la lista contiene:
	 * EntregaDTO, RecepcionProveedorDTO, VistaProveedorDTO, List<<VistaRecepcionJugueteDTO>>. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 21/04/2014]
	 * </p>
	 * 
	 * @param recepcionJuguetes
	 *            datos de la recepcion
	 * @param codigoCompania
	 *            codigo de la compania
	 * @param userId
	 *            identificador del usuario logeado
	 * @param codigoCD
	 *            codigo del centro de distribucion
	 * @param codigoATBodega
	 *            codigo area trabajo bodega
	 * @param codigoATSubBodega
	 *            codigo area trabajo subbodega
	 * @param paraRecepcion
	 * 			  define la los datos que se necesitan son para crear la recepcion o para generar el reporte
	 * @return lista de tipo RecepcionJugueteVO
	 * @throws SICException
	 */ 
	List<RecepcionJugueteVO> crearAgruparDatosParaRecepcion(List<VistaRecepcionJugueteDTO> recepcionJuguetes, Integer codigoCompania,
			String userId, Integer codigoCD, Integer codigoATBodega, Integer codigoATSubBodega, boolean paraRecepcion) throws SICException;
	
	/**
	 * <b> Actualiza los datos del articulo (codigo barras, unidad manejo, cantidad unidad manejo), el pedido (codigo migracion) y la
	 * OrdenCompraDetalleEstado (cantidad entregada); seguidamente crea los datos de la recepcion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 24/04/2014]
	 * </p>
	 * 
	 * @param recepcionJuguetes
	 *            datos de la rececpion, lista para realizar las actualizaciones
	 * @param codigoCompania
	 * @param datosRecepcion
	 *            datos de la recepcion agrupado por proveedor, lista para crear la recepcion
	 * @throws SICException
	 */ 
	void actualizarCrearDatosRecepcion(List<VistaRecepcionJugueteDTO> recepcionJuguetes, Integer codigoCompania,
			String userId, Integer codigoCD, Integer codigoATBodega, Integer codigoATSubBodega,String accesItemID, String systemId) throws SICException;
	
	/**
	 * <b> Obtiene un string con la cabecera de las columnas para mostrar en el SlickGrid. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 24/03/2014]
	 * </p>
	 * 
	 * @param isRecepcion define si tiene la funcionalidad de recepcion o solamente es un usuario de codificacion
	 * @return columnas para mostrar en el slickGrid
	 * @throws SICException
	 */
	String crearColumnasSlickGrid(boolean isRecepcion) throws SICException;
	
	/**
	 * <b> Obtiene una cadena en formato JSON con las datos que necesarios para mostrar en la table del SlickGrid. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 24/03/2014]
	 * </p>
	 * 
	 * @param recepcionJugueteDTOs
	 *            lista que contiene los datos de la recepcion de juguetes
	 * @return cadena en formato JSON
	 * @throws SICException
	 */
	String crearDatosSlickGrid(List<VistaRecepcionJugueteDTO> recepcionJugueteDTOs) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoArticulo
	 * @param codigoUnidadManejo
	 * @param codigoProveedor
	 * @param userId
	 * @throws SICException
	 */
	@Deprecated
	Collection<VistaRecepcionJugueteDTO> cambiarArticuloOrdenCompraDetalleEstado(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado, String codigoArticulo, Long codigoUnidadManejoNuevo, Integer valorUnidadManejoNuevo, String codigoProveedorNuevo, String userId, Long codigoEmbarque) throws SICException;
	
	/**
	 * <b> Actualiza los datos cuando se remplaza un articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 10/07/2015]
	 * </p>
	 * 
	 * @param recepcionJuguete
	 *            representa datos de la recepcion
	 * @param systemId
	 *            identificador del sistema(MAX)
	 * @param accessItemId
	 *            identificador de la opcion dentro del sistema(131-recepcion
	 *            juguetes)
	 * @param userId
	 *            identificador del usuario logeado
	 * @return coleccion con los datos actualizados para remplazar en la parte
	 *         visual
	 * @throws SICException
	 *             escepcion lanzada en caso de existir un error
	 */
	Collection<VistaRecepcionJugueteDTO> cambiarArticuloOrdenCompraDetalleEstado(VistaRecepcionJugueteDTO recepcionJuguete,
			String systemId, String accessItemId, String userId) throws SICException;
	
	/**
	 * <b> Deshace el cambio de un articulo. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 30/05/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigoOrdenCompraDetalleEstado
	 * @param codigoArticulo
	 * @param codigoUnidadManejoActual
	 * @param codigoProveedorActual
	 * @param userId
	 * @param codigoEmbarque
	 * @return
	 * @throws SICException
	 */ 
	Collection<VistaRecepcionJugueteDTO> reversaArticuloOrdenCompraDetalleEstado(Integer codigoCompania, Long codigoOrdenCompraDetalleEstado,
			String codigoArticulo, Long codigoUnidadManejoActual, String codigoProveedorActual, String userId, Long codigoEmbarque)
			throws SICException;
	
	/**
	 * <b> Obtiene los grupos de trabajo(Prototipo) para mostralo en el popUp del SlickGrid; obtine los que se encuentran en estado activo y el tipo
	 * se ALC. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 04/06/2014]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @return
	 */
	Collection<GrupoTrabajoDTO> obtenerPrototipos(Integer codigoCompania) throws SICException;
	
	/**
	 * <b>Actualiza los datos de la rececpion en caso de que el perfil del usuario no sea de recepcion. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 10/06/2014]
	 * </p>
	 *
	 * @param recepcionJuguetes
	 * @param codigoCompania
	 * @param userId
	 * @param accesItemID
	 * @param systemId
	 * @throws SICException
	 */ 
	void actualizarCrearDatosCodificacion(List<VistaRecepcionJugueteDTO> recepcionJuguetes, Integer codigoCompania, String userId,
			String accesItemID, String systemId) throws SICException;
	
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
	Collection<VistaProveedorDTO> buscarProveedorPorCodigoNombre(String codigoProveedor, String nombreProveedor, Integer codigoCompania)
			throws SICException;
	
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
	List<Integer> obtenerIdsLocalesPorArticulo(Integer codigoCompania, String codigoArticulo, String estadoArticuloLocal) throws SICException;
	
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
	List<ArticuloLocalDTO> obtenerLocalesPorArticulo(Integer codigoCompania, String codigoArticulo, String estadoArticuloLocal)
			throws SICException;
	
	/**
	 * <b> Obtiene las caracteristicas dinamicas en base a la clasificacion del articulo, estas caracteristicas definen si se puedo o no 
	 * editar el idicador propietario. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 06/01/2015]
	 * </p>
	 * 
	 * @param codigoCompania
	 * @param codigosClasificacion
	 *            clasificacion asociado al articulo
	 * @param codigoTipoCatalogo
	 *            define el catalogo por el cual se quiere realizar la busqueda
	 * @return coleccion con las propiedades dinamicas que tiene el articulo
	 */
	Collection<CaracteristicaDinamicaDTO> obtenerCaratecristicasDinamicas(Integer codigoCompania, Set<String> codigosClasificacion, Integer codigoTipoCatalogo);
	
	/**
	 * <b> Obtiene los los datos de los diferentes tipos de indicador propietario. </b>
	 * <p>
	 * [Author: mchiliquinga, Date: 07/01/2015]
	 * </p>
	 * 
	 * @param estado filtra la busqueda por un estado especifico
	 * @return lista de Indicador propietario
	 * @throws SICException
	 */ 
	List<IndicadorPropietarioDTO> obtenerDatosIndicadorPropietario(String estado) throws SICException;
	
	/**
	 * <b> Valida que el codigo de clasificacion pertenezca a la subbodega de juguetes. </b>
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
	 */ 
	void validarClasificacionBodegaJuguetes(String codigoClasificacion, String subBodegaJuguetes, String estado) throws SICException;
	
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
	 * @throws SICException excepcion lanzada en caso de existir un error
	 */
	AreaTrabajoDTO obtenerAreaTrabajoPorId(Integer codigoCompania, Integer codigoAreaTrabajo, String estado) throws SICException;
	
}
