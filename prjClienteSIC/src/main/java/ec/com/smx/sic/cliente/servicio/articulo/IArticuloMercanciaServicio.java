/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.articulo;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.generadorexportacion.estructura.InfoRecepcionEST;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.CaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoCaracteristicaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.ArticuloRangoExtensionGarantiaDTO;
import ec.com.smx.sic.cliente.mdl.dto.articulo.garantia.GarantiaArticuloDTO;
import ec.com.smx.sic.cliente.mdl.vo.EtiquetaMercanciaVO;

/**
 * Interfaz que sirve como servicio para integracion de articulos con mercancias
 * @author eharo
 *
 */
public interface IArticuloMercanciaServicio {

	
	/**
	 * SERVICIO QUE PERMITE OBTENER LA LISTA DE TIPO CARACTERISTICAS
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public List<TipoCaracteristicaDTO> obtenerListaTipoCaracteristicas(Integer codigoCompania) throws SICException;
	
	/**
	 * SERVICIO QUE PERMITE OBTENER LA LISTA DE CARACTERISTICAS DE UN ARTICULO DE ACUERDO A TODOS LOS 
	 * TIPOS DE CARACTERISTICAS
	 * @param codigoCompania
	 * @param tipoCaracteristicaId
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public List<CaracteristicaDTO> obtenerListaCaracteristicas(Integer codigoCompania, Collection<Integer> tipoCaracteristicaId, String codigoArticulo) throws SICException;
	
	/**
	 * SERVICIO QUE QUE PERMITE GUARDAR UNA LISTA DE CARACTERISTICAS
	 * @param usuario
	 * @param tipoCarSeleccionadaId
	 * @param lstCaracteristicas
	 * @throws SICException
	 */
	public void transGuardarCaracteristicas(String usuario, List<CaracteristicaDTO> lstCaracteristicas) throws SICException;
	
	/**
	 * @param usuario
	 * @param caracteristicasEliminar
	 * @throws SICException
	 */
	public void transEliminarCaracteristica(String usuario, Set<CaracteristicaDTO> caracteristicasEliminar) throws SICException;

	/***********************GARANTIA***************************************************************************************************************************/
	
	/**
	 * @param rangoExtensionGarantiaDTO
	 * @param precioBaseImp
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloRangoExtensionGarantiaDTO> obtenerRangosGE(ArticuloRangoExtensionGarantiaDTO rangoExtensionGarantiaDTO, Double precioBaseImp) throws SICException;
	
	
	/**
	 * @param rangosGE
	 * @param precioBaseImp
	 * @return
	 * @throws SICException
	 */
	public Collection<GarantiaArticuloDTO> buscarPrecioExtension(Collection<ArticuloRangoExtensionGarantiaDTO> rangosGE, Double precioBaseImp) throws SICException;
	
	/**
	 *  Obtener  las etiquetas mercancia segun los datos del articulo
	 * @param codigoCompania
	 * @param codigoArtBarCol
	 * @param esCodigoBarra
	 * @param areaTrabajoFuncionario
	 * @param codigoClasificacion
	 * @return
	 * @throws SICException
	 */
	public Collection<EtiquetaMercanciaVO> obtenerEtiquetaCaracteristicaMasivaCol(Integer codigoCompania,Collection<String> codigoArtBarCol, Boolean esCodigoBarra, Integer areaTrabajoFuncionario,String codigoClasificacion) throws SICException;
	
	/**
	 * Obtiene etiquetaMercancia con paginacion
	 * @param first
	 * @param pageSize
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoClasificacion
	 * @param promocion
	 * @return
	 * @throws SICException
	 */
	public Collection<EtiquetaMercanciaVO> obtenerEtiquetaMercanciaMasivaPaginada(Integer first, Integer pageSize, Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException;
	
	/**
	 * Obtiene el total de articulos dependiendo si tiene o no promocion
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoClasificacion
	 * @param promocion
	 * @return
	 */
	public Integer totalRegistrosEtiquetaMercanciaMasiva(Integer codigoCompania, Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException;
	
	/**
	 * @author aquingaluisa
	 * Copia y modificacion del metodo original en el proyecto de mercancias
	 * Metodo que procesa un archivo inputstream con generación exportación al objeto deseado dado el codigo del formato
	 * @param usuario
	 * @param codigoFormato
	 * @param archivoImportacion
	 * @param archivoImportacionF
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public InfoRecepcionEST obtenerEstructuraDesdeArchivo(String usuario, String codigoFormato, InputStream archivoImportacion, File archivoImportacionF, String codigoCompania) throws SICException;
	
	/**
	 * Metodo para obtner las clasificacion de un funcionario
	 * @param funcionario
	 * @return
	 * @throws SICException
	 */
	public Collection<String> obtenerCodigosClasificacionFuncionario(FuncionarioDTO funcionario,Boolean tieneLineaComercial) throws SICException;
}
