package ec.com.smx.sic.articulo.servicio;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import ec.com.kruger.utilitario.dao.commons.annotations.NoTransaction;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;
import ec.com.smx.corpv2.dto.EstablecimientoDTO;
import ec.com.smx.corpv2.dto.GrupoAreaTrabajoDTO;
import ec.com.smx.corpv2.dto.GrupoTrabajoDTO;
import ec.com.smx.corpv2.vo.GrupoTrabajoVO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.annotation.HibernateTransaction;
import ec.com.smx.sic.cliente.common.articulo.filtros.IPlantillaFiltrosBusquedaArticulos;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.IArticuloAlcanceGestor;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.validacion.IValidacionAlcanceGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloAreaTrabajoBitacoraDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloAlcanceEST;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.PrototipoAlcanceVO;
import ec.com.smx.sic.cliente.servicio.articulo.IArticuloAlcanceServicio;


public class ArticuloAlcanceServicio implements IArticuloAlcanceServicio {

	private IArticuloAlcanceGestor  articuloAlcanceGestor;
	private IValidacionAlcanceGestor  validacionAlcanceGestor;

	/**
	 * Permite crear grupos de alcance
	 * @param grupoTrabajoDTO
	 * @param areaTrabajoCol
	 * @throws SICException
	 */
	public void crearGrupoAlcance(GrupoTrabajoDTO grupoTrabajoDTO, Collection<AreaTrabajoDTO> areaTrabajoCol) throws SICException {
		this.articuloAlcanceGestor.crearGrupoAlcance(grupoTrabajoDTO, areaTrabajoCol);
	}
	
	@Override	
	@HibernateTransaction
	public void asignacionLocalesPrototipos(PrototipoAlcanceVO prototipoAlcanceVO, UserDto userDto)throws SICException{
		this.articuloAlcanceGestor.asignacionLocalesPrototipos(prototipoAlcanceVO, userDto);
	}
	
	
	/**
	 * M�todo para validar los datos en la actualizaci�n del grupo de alcance
	 * @param grupoTrabajoDTO
	 * @param areasAsignar
	 * @param areasDesactivar
	 * @param areasActivar
	 * @throws SICException
	 */
	@Override
	@HibernateTransaction
	public void actualizarGrupoAlcance(String accessItemId,String systemId,GrupoTrabajoDTO grupoTrabajoDTO,Timestamp fechaAplicacion, ArrayList<GrupoAreaTrabajoDTO> areasAsignar, ArrayList<GrupoAreaTrabajoDTO> areasDesactivar, ArrayList<GrupoAreaTrabajoDTO> areasActivar, UserDto userDto,String codigoFuncionario) throws SICException{
		this.articuloAlcanceGestor.actualizarGrupoAlcance(accessItemId,systemId,grupoTrabajoDTO,fechaAplicacion, areasAsignar, areasDesactivar, areasActivar,userDto,codigoFuncionario);
	}
	
	/**
	 * Permite copiar los articulos de un local base a otro local
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	@Override
	@NoTransaction
	public void copiarLocal(ArticuloVO articuloVO, UserDto userDto) throws SICException{
		this.articuloAlcanceGestor.copiarLocal(articuloVO,userDto);
	}
	
	@HibernateTransaction
	public void copiarLocal(ArticuloVO articuloVO)throws SICException{
		this.articuloAlcanceGestor.copiarLocal(articuloVO);
	}
	
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
	@Override
	@NoTransaction
	public void asignacionMasivaArticulos(ArticuloVO articuloFiltro,UserDto userDto) throws SICException{
		this.articuloAlcanceGestor.asignacionMasivaArticulos(articuloFiltro,userDto);
	}
	
	/**
	 * Permite asignar masivamente art&iacute;culos a los locales por archivo
	 * @param articuloFiltro
	 * @param codigosBarras
	 * @param prototipoAlcanceVO
	 * @throws SICException
	 */
	@Override	
	@NoTransaction
	public void asignacionMasivaArticulosPorArchivo(ArticuloVO articuloFiltro, ArrayList<ArticuloDTO> articulos, UserDto userDto) throws SICException{
		  this.articuloAlcanceGestor.asignacionMasivaArticulosPorArchivo(articuloFiltro, articulos,userDto);
	}
	
	
	/**
	 * Permite obrtener los articulos de la lista de codigo de barra
	 * @param codigosBarras
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<ArticuloDTO> obtenerArticulosDeCodigosBarras(ArrayList<String>codigosBarras,ArticuloVO articuloVO)throws SICException{
		return this.articuloAlcanceGestor.obtenerArticulosDeCodigosBarras(codigosBarras, articuloVO);
	}
	
	/**
	 * Permite obtener los c&oacute;digos v&aacute;lidos del archivo
	 * @param prototipoAlcanceVO
	 * @param inputStreamArchAlcArticulos
	 * @return
	 * @throws SICException
	 */
	@Override
	@HibernateTransaction
	public Collection<ArticuloDTO> obtenerCodigosValidosPorArchivo(ArticuloVO articuloVO,Collection<String> codigosBarras)throws SICException{
		return this.articuloAlcanceGestor.obtenerCodigosValidosPorArchivo(articuloVO, codigosBarras);
	}
	
	/**
	 * Permite obtener los articulos local que se afectaron sus alcances
	 * @param fechaAplicacion
	 */
	@Override
	@HibernateTransaction
	public void obtenerArticuloLocalSIC(ArticuloVO articuloVO)throws SICException{
		this.articuloAlcanceGestor.obtenerArticuloLocalSIC(articuloVO);
	}
	
	
	
	/**
	 * Permite obtener registros de art&iacute;culo local a partir de los filtros de b&uacute;squeda de art&iacute;culos
	 * @param articuloVO
	 * @return
	 * @throws SICException
	 */
	public SearchResultDTO<ArticuloAlcanceEST> obtenerArticulosLocalAlcance(ArticuloVO articuloVO) throws SICException{
		return articuloAlcanceGestor.obtenerArticulosLocalAlcance(articuloVO);
	}
	
	public void addCriterioRestriccionFechaAlcanceFinal(SearchDTO searchDTO)throws SICException{
		articuloAlcanceGestor.addCriterioRestriccionFechaAlcanceFinal(searchDTO);
	}
	
	/**
	 * Permite remplazar los alcances de un local, bodega, oficina
	 * @param articuloVO
	 * @throws SICException
	 */
	@Override
	@HibernateTransaction
	public void remplazarArticulosAreasTrabajoMasivo(ArticuloVO articuloVO,UserDto userDto)throws SICException{
		this.articuloAlcanceGestor.remplazarArticulosAreasTrabajoMasivo(articuloVO,userDto);
	}
	
	@Override
	public void registrarAlcanceTemporal(ArticuloVO articuloVO)throws SICException{
		this.articuloAlcanceGestor.registrarAlcanceTemporal(articuloVO);
	}
	
	@Override
	public void registrarAlcanceBodegasSubbodega(ArticuloVO articuloVO) throws SICException{
		this.articuloAlcanceGestor.registrarAlcanceBodegasSubbodega(articuloVO);
	}
	
	
	
	/**
	 * Permite obtener los alcances de las diferentes tablas de alcances para generar el archivo de excel
	 * @param articuloVO
	 * @param plantillaFiltrosBusquedaMAX
	 * @throws SICException
	 */
	@Override
	@HibernateTransaction
	public Collection<ArticuloAlcanceEST> obtenerAlcances(ArticuloVO articuloVO, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusquedaMAX)throws SICException{
		return this.articuloAlcanceGestor.obtenerAlcances(articuloVO, plantillaFiltrosBusquedaMAX);
	}
	
	/**
	 * Permite la lectura del archivo
	 * @param inputStreamArchAlcArticulos
	 * @return
	 * @throws SICException
	 */
	@Override
	public Collection<String> procesarArchivo(InputStream inputStreamArchAlcArticulos) throws SICException{
		return this.articuloAlcanceGestor.procesarArchivo(inputStreamArchAlcArticulos);
	}
	
	/**
	 * Permite descargar archivo plantilla para la asignacion masiva
	 * @param wb
	 * @params sheet
	 * @return 
	 * @throws SICException
	 */
	@Override
	public void obtenerCabeceraArchivoAsignacionMasiva(HSSFWorkbook wb, HSSFSheet sheet) throws SICException {
		this.articuloAlcanceGestor.obtenerCabeceraArchivoAsignacionMasiva(wb, sheet);
		
	}
	/**
	 * Permite registrar alcance a los locales de un prototipo
	 * @param articuloVO
	 */
	public void insertarAlcancePorPrototipo(ArticuloVO articuloVO)throws SICException{
		this.articuloAlcanceGestor.insertarAlcancePorPrototipo(articuloVO);
	}
	
	/**
	 * Permite generar el archivo excel con errores de validacion para la asignacion masiva de alcances
	 * @param observacionCodigoBarras
	 * @throws SICException
	 */
	public HSSFWorkbook generarExcelErroresAsignacionAlcances(HashMap<String, String> observacionCodigoBarras)throws SICException{
		return this.articuloAlcanceGestor.generarExcelErroresAsignacionAlcances(observacionCodigoBarras);
	}
	
	/**
	 * administracion de prototipos
	 * Permite validar si uno de los prototipos se queda sin locales asignados
	 */
	public Collection<String> validarPrototiposLocales(Collection<String> refProt,Collection<Integer> codLoc)throws SICException{
		return this.articuloAlcanceGestor.validarPrototiposLocales(refProt, codLoc);
	}
		
	/**
	 * Permite activar, desactivar, insertar alcances cuando se ha realizado un cambio de prototipo
	 * @param articuloVO
	 * @throws SICException
	 */
	public void insertarAlcancesCambioPrototipo(ArticuloVO articuloVO) throws SICException{
		this.articuloAlcanceGestor.insertarAlcancesCambioPrototipo(articuloVO);
	}
	
	/**
	 * Metodo que permite consultar las oficinas para la asignacion de articulos
	 * 
	 */
	public Collection<AreaTrabajoDTO> consultarOficinas(String tipoAreaTrabajo , Integer codigoCompania){
		return articuloAlcanceGestor.consultarOficinas(tipoAreaTrabajo, codigoCompania);
	} 
	
	/**
	 * Metodo que permite consultar las oficinas para la asignacion de articulos
	 * 
	 */
	public Collection<AreaTrabajoDTO> consultarBodegas(String tipoAreaTrabajo , Integer codigoCompania){
		return articuloAlcanceGestor.consultarBodegas(tipoAreaTrabajo, codigoCompania);
	} 
	
	/**
	 * Metodo que permite consultar las oficinas a las que tiene alcance un articulo
	 * @throws SICException
	 */
	public Collection<ArticuloLocalDTO> consultarAreasTrabajoAsignadas(ArticuloDTO articuloDto, String tipoAreaTrabajo, Boolean validarEstado)throws SICException{
		return articuloAlcanceGestor.consultarAreasTrabajoAsignadas(articuloDto,tipoAreaTrabajo,validarEstado);
	}
	
	public Collection<AreaTrabajoDTO> obtenerAreasTrabajo()throws SICException{
		return articuloAlcanceGestor.obtenerAreasTrabajo();
	}
	
	/**
	 * Permite obtener datos de Bodega
	 * @param codigoCompania Codigo de compania
	 * @param codigoBodega Codigo de bodega
	 * @return Lista de bodegas
	 * @throws SICException
	 */
	public Collection<BodegaDTO> obtenerBodegasPorCodigoBodega(Integer codigoCompania, String codigoBodega) throws SICException{
		return this.articuloAlcanceGestor.obtenerBodegasPorCodigoBodega(codigoCompania, codigoBodega);
	}
	@Override
	public void asignarAlcancesAreaTrabajo(List<? extends ArticuloDTO> articuloCol,ArticuloVO articuloVO)throws SICException{
		 this.articuloAlcanceGestor.asignarAlcancesAreaTrabajo(articuloCol, articuloVO);
	}
	@Override
	public Collection<AreaSublugarTrabajoDTO> obtenerBodegaPorCodigoSubBodega(Integer codigoCompania, Integer codigoSubBod) throws SICException{
		return articuloAlcanceGestor.obtenerBodegaPorCodigoSubBodega(codigoCompania, codigoSubBod);
	}
	@Override
	public void asignacionMasivaArticulos(ArticuloVO articuloFiltro, IPlantillaFiltrosBusquedaArticulos plantillaFiltrosBusqueda) throws SICException{
		this.validacionAlcanceGestor.asignacionMasivaArticulos(articuloFiltro,plantillaFiltrosBusqueda);
	}

	@Override
	public Collection<EstablecimientoDTO> obtenerEstablecimientos(Integer codigoCompania) throws SICException {
		return articuloAlcanceGestor.obtenerEstablecimientos(codigoCompania);
	}
	@Override
	public Collection<GrupoTrabajoDTO> obtenerGruposTrabajo(GrupoTrabajoVO grupoTrabajoVO) throws SICException{
		return articuloAlcanceGestor.obtenerGruposTrabajo(grupoTrabajoVO);
	}
	
	public Collection<ArticuloAreaTrabajoBitacoraDTO> obtenerArticuloAreaTrabajoBitacoraError(ArticuloVO articuloVO, String sufijoAreaTrabajo) throws SICException{
		return articuloAlcanceGestor.obtenerArticuloAreaTrabajoBitacoraError(articuloVO, sufijoAreaTrabajo);
	}
	
	public void insertarBitacoraArticuloAreaTrabajoError(ArticuloVO articuloVO, String codigoArticulo, String errorMsg) throws SICException{
		this.articuloAlcanceGestor.insertarBitacoraArticuloAreaTrabajoError(articuloVO, codigoArticulo, errorMsg);
	}

	/**
	 * Setters
	 */
	public void setArticuloAlcanceGestor(IArticuloAlcanceGestor articuloAlcanceGestor) {
		this.articuloAlcanceGestor = articuloAlcanceGestor;
	}

	/**
	 * @param validacionAlcanceGestor the validacionAlcanceGestor to set
	 */
	public void setValidacionAlcanceGestor(IValidacionAlcanceGestor validacionAlcanceGestor) {
		this.validacionAlcanceGestor = validacionAlcanceGestor;
	}
	
}
