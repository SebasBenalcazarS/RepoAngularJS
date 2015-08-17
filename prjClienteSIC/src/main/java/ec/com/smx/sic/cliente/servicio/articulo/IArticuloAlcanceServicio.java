package ec.com.smx.sic.cliente.servicio.articulo;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.vo.GrupoTrabajoVO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.PrototipoAlcanceVO;

/**
 * @author dalmeida
 *
 */
public interface IArticuloAlcanceServicio {
	/**
	 * Permite crear grupos de alcance
	 * @param grupoTrabajoDTO
	 * @param areaTrabajoCol
	 * @throws SICException
	 */
	public void crearGrupoAlcance(GrupoTrabajoDTO grupoTrabajoDTO, Collection<AreaTrabajoDTO> areaTrabajoCol)throws SICException;

	/**
	 * Permite la asignacion de locales a prototipos
	 * @param areaTrabajoDTOs
	 * @param grupoTrabajoDTOs
	 * @param asignacion
	 * @throws SICException
	 */
	public void asignacionLocalesPrototipos(PrototipoAlcanceVO prototipoAlcanceVO, UserDto userDto)throws SICException;
	
	
	/**
	 * M�todo para validar los datos en la actualizaci�n del grupo de alcance
	 * @param grupoTrabajoDTO
	 * @param fechaAplicacion
	 * @param areasAsignar
	 * @param areasDesactivar
	 * @param areasActivar
	 * @throws SICException
	 */
	public void actualizarGrupoAlcance(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO,Timestamp fechaAplicacion, ArrayList<GrupoAreaTrabajoDTO> areasAsignar, ArrayList<GrupoAreaTrabajoDTO> areasDesactivar, ArrayList<GrupoAreaTrabajoDTO> areasActivar, UserDto userDto,String codigoFuncionario) throws SICException;
	
	/**
	 * Permite copiar los articulos de un local base a otro local, y generar el archivo de articulos de los locales afectados
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	public void copiarLocal(ArticuloVO articuloVO, UserDto userDto) throws SICException;
	
	/**
	 * permite hacer una copia de alcances
	 * @param articuloVO
	 * @throws SICException
	 */
	public void copiarLocal(ArticuloVO articuloVO)throws SICException;
	
	/**
	 * Permite asignar, quitar masivamente articulos de la tabla SCSADTARTLOC,
	 * Obtiene el archivo de SCSADTARTLOC afectados en una misma fecha (FECHAALCANCE)
	 * Actualiza los prototipos de SCSPETARTICULO que han sido afectados en SCSADTARTLOC
	 * Obtiene el archivo de SCSPETARTICULO afectados en una misma fecha (FECHAMODIFICACION)
	 * 
	 * @param articuloFiltro	
	 * @param plantillaFiltrosBusqueda
	 * @throws SICException
	 */
	public void asignacionMasivaArticulos(ArticuloVO articuloFiltro,UserDto userDto) throws SICException;
	
	/**
	 * Permite asignar masivamente art&iacute;culos a los locales por archivo
	 * @param articuloFiltro
	 * @param codigosBarras
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	public void asignacionMasivaArticulosPorArchivo(ArticuloVO articuloFiltro, ArrayList<ArticuloDTO> articulos, UserDto userDto) throws SICException;
	
	/**
	 * Permite obrtener los articulos de la lista de codigo de barra
	 * @param codigosBarras
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticulosDeCodigosBarras(ArrayList<String>codigosBarras,ArticuloVO articuloVO)throws SICException;
	
	/**
	 * Permite obtener los c&oacute;digos v&aacute;lidos del archivo
	 * @param prototipoAlcanceVO
	 * @param inputStreamArchAlcArticulos
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerCodigosValidosPorArchivo(ArticuloVO articuloVO,Collection<String> codigosBarras)throws SICException;
	
	/**
	 * Permite obtener los articulos local que se afectaron sus alcances
	 * @param fechaAplicacion
	 */
	public void obtenerArticuloLocalSIC(ArticuloVO articuloVO)throws SICException;
	
	
	
	/**
	 * Permite obtener registros de art&iacute;culo local a partir de los filtros de b&uacute;squeda de art&iacute;culos
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloAlcanceEST> obtenerArticulosLocalAlcance(ArticuloVO articuloVO) throws SICException;
	
	/**
	 * 
	 * @param searchDTO
	 * @throws SICException
	 */
	public void addCriterioRestriccionFechaAlcanceFinal(SearchDTO searchDTO)throws SICException;
	/**
	 * Permite registrar alcances temporales
	 * @param articuloVO
	 * @throws SICException
	 */
	public void registrarAlcanceTemporal(ArticuloVO articuloVO)throws SICException;
	
	/**
	 * Permite remplazar los alcances de un local, bodega, oficina
	 * @param articuloVO
	 * @throws SICException
	 */
	public void remplazarArticulosAreasTrabajoMasivo(ArticuloVO articuloVO,UserDto userDto)throws SICException;
	/**
	 * Permite registrar alcance a las bodegas padres de una subbodega especifica
	 * @param articuloVO
	 * @throws SICException
	 */
	public void registrarAlcanceBodegasSubbodega(ArticuloVO articuloVO) throws SICException;
	
	/**
	 * Permite obtener los alcances de las diferentes tablas de alcances para generar el archivo de excel
	 * @param articuloVO
	 * @param plantillaFiltrosBusquedaMAX
	 * @throws SICException
	 */
	public Collection<ArticuloAlcanceEST> obtenerAlcances(ArticuloVO articuloVO, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX)throws SICException;
	
	/**
	 * Permite la lectura del archivo
	 * @param inputStreamArchAlcArticulos
	 * @return
	 * @throws SICException
	 */
	public Collection<String> procesarArchivo(InputStream inputStreamArchAlcArticulos) throws SICException;
	
	/**
	 *  Permite descargar archivo plantilla para la asignacion masiva
	 * @param wb
	 * @param sheet
	 * @throws SICException
	 */
	
	public void obtenerCabeceraArchivoAsignacionMasiva(HSSFWorkbook wb, HSSFSheet sheet)throws SICException;
	/**
	 * Permite registrar alcance a los locales de un prototipo
	 * @param articuloVO
	 */
	
	public void insertarAlcancePorPrototipo(ArticuloVO articuloVO)throws SICException;
	
	/**
	 * 
	 * @param observacionCodigoBarras
	 * @return 
	 * @throws SICException
	 */
	public HSSFWorkbook generarExcelErroresAsignacionAlcances(HashMap<String, String> observacionCodigoBarras)throws SICException;
	
	/**
	 * * administracion de prototipos
	 * Permite validar si uno de los prototipos se queda sin locales asignados
	 * @param refProt
	 * @param codLoc
	 * @return
	 * @throws SICException
	 */
	public Collection<String> validarPrototiposLocales(Collection<String> refProt,Collection<Integer> codLoc)throws SICException;
	
	/**
	 * Permite activar, desactivar, insertar alcances cuando se ha realizado un cambio de prototipo
	 * @param articuloVO
	 * @throws SICException
	 */
	public void insertarAlcancesCambioPrototipo(ArticuloVO articuloVO) throws SICException;
	
	/**
	 * Permite consultar las oficinas para la asignacion de articulos
	 * @param tipoAreaTrabajo
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> consultarOficinas(String tipoAreaTrabajo, Integer codigoCompania) throws SICException;
	
	/**
	 * Permite consultar los CD y bodegas para la asignacion de articulos
	 * @param tipoAreaTrabajo
	 * @param codigoCompania
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> consultarBodegas(String tipoAreaTrabajo, Integer codigoCompania) throws SICException;
	
	/**
	 * Permite obtener datos de bodega
	 * @param codigoCompania Codigo de la compania
	 * @param codigoBodega Codigo de bodega
	 * @return Lista de bodegas
	 * @throws SICException
	 */
	public Collection<BodegaDTO> obtenerBodegasPorCodigoBodega(Integer codigoCompania, String codigoBodega) throws SICException;
	
	/**
	 * Permite consultar las areas de trabajo en las que el articulo tiene alcance
	 * @param articuloVO
	 * @param tipoAreaTrabajo
	 * @return Lista de areas de trabajo a las que el articulo tiene alcance
	 * @throws SICException
	 */
	public Collection<ArticuloLocalDTO> consultarAreasTrabajoAsignadas(ArticuloDTO articuloDto, String tipoAreaTrabajo, Boolean validarEstado)throws SICException;
	
	/**
	 * Permite obtener la lista de areas de trabajo
	 * @return Lista de areas de trabajo 
	 * @throws SICException
	 */
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajo()throws SICException;
	
	/**
	 * Permite asignar Alcance a areas de trabajo (bodegas-oficinas) a partir del articulo
	 * @param articuloCol
	 * @param articuloVO
	 * @throws SICException
	 */
	public void asignarAlcancesAreaTrabajo(List<? extends ArticuloDTO> articuloCol,ArticuloVO articuloVO)throws SICException;
	
	/**
	 * Permite obtener los codigos de bodega padre dependiendo del codigo de subbodega 
	 * @param codigoCompania
	 * @param codigoSubBod
	 * @return Lista de codigos de bodegas padre dependiendo del codigo de subbodega
	 * @throws SICException
	 */
	public Collection<AreaSublugarTrabajoDTO> obtenerBodegaPorCodigoSubBodega(Integer codigoCompania, Integer codigoSubBod) throws SICException;
	/**
	 * 
	 * @param articuloFiltro
	 * @param plantillaFiltrosBusqueda
	 * @throws SICException
	 */
	public void asignacionMasivaArticulos(ArticuloVO articuloFiltro, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @return lista de establecimientos
	 * @throws SICException
	 */
	
	public Collection<EstablecimientoDTO> obtenerEstablecimientos(Integer codigoCompania) throws SICException;
	
	
	/**
	 * Obtener los grupos de trabajo dados por los filtros en GrupoTrabajoVO
	 * @param grupoTrabajoVO
	 * @return Lista de Grupos de Trabajo
	 * @throws SICException
	 */
	public Collection<GrupoTrabajoDTO> obtenerGruposTrabajo(GrupoTrabajoVO grupoTrabajoVO) throws SICException;
	
	/**
	 * Permite obtener los registros ArticuloAreaTrabajoBitacoraDTO que se generaron por error de asignacion de alcances
	 * @param articuloVO
	 * @param sufijoAreaTrabajo
	 * @return Lista de registros ArticuloAreaTrabajoBitacoraDTO
	 * @throws SICException
	 */
	public Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerArticuloAreaTrabajoBitacoraError(ArticuloVO articuloVO, String sufijoAreaTrabajo) throws SICException;
	
	/**
	 * Permite insertar la bitacora de alcances correspondientes a aquellos donde se presento error en la asignacion
	 * @param articuloVO
	 * @param codigoArticulo
	 * @param errorMsg
	 * @throws SICException
	 */
	public void insertarBitacoraArticuloAreaTrabajoError(ArticuloVO articuloVO, String codigoArticulo, String errorMsg) throws SICException;
}
