/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.mercancias;

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
import ec.com.smx.sic.cliente.mdl.vo.EtiquetaMercanciaVO;

/**
 * @author eharo
 *
 */
public interface IArticuloMercanciaGestor {

	/**
	 * METODO QUE PERMITE OBTENER LA LISTA DE LOS TIPOS DE CARACTERISTICAS DISPONIBLES
	 * @param codigoCompania
	 * @return
	 * @throws SICException
	 */
	public List<TipoCaracteristicaDTO> obtenerListaTipoCaracteristicas(Integer codigoCompania) throws SICException;
	
	/**
	 * METODO QUE PERMITE OBTENER LA LISTA DE LAS CARACTERISTICAS DISPONIBLES
	 * @param codigoCompania
	 * @param tipoCaracteristicaId
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public List<CaracteristicaDTO> obtenerListaCaracteristicas(Integer codigoCompania, Collection<Integer> tipoCaracteristicaId, String codigoArticulo) throws SICException;
	
	
	/**
	 * METODO PARA ELIMINAR UNA LISTA DE CARACTERISTICAS
	 * @param usuario
	 * @param caracteristicasEliminar
	 * @throws SICException
	 */
	public void transEliminarCaracteristica(String usuario, Set<CaracteristicaDTO> caracteristicasEliminar) throws SICException;
	
	/**
	 * METODO PARA GUARDAR UNA LISTA DE CARACTERISTICAS
	 * @param usuario
	 * @param lstCaracteristicas
	 * @throws SICException
	 */
	public void transGuardarCaracteristicas(String usuario, Collection<CaracteristicaDTO> lstCaracteristicas) throws SICException;
	
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
	 * 
	 * @param first - pagina inicial
	 * @param pageSize - rango paginacion
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoClasificacion
	 * @param promocion
	 * @return
	 * @throws SICException
	 */
	public Collection<EtiquetaMercanciaVO> obtenerEtiquetaMercanciaMasivaPaginada(Integer first, Integer pageSize, Integer codigoCompania,Integer areaTrabajo, String codigoClasificacion, String promocion) throws SICException;
	
	/**
	 * 
	 * @param codigoCompania
	 * @param areaTrabajo
	 * @param codigoClasificacion
	 * @param promocion
	 * @return
	 * @throws SICException
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
	 * @throws MercanciasException
	 */
	public InfoRecepcionEST obtenerEstructuraDesdeArchivo(String usuario, String codigoFormato, InputStream archivoImportacion, File archivoImportacionF, String codigoCompania) throws SICException;
	
	
	/**
	 * Metodo para obtener las clasificacion de un funcionario
	 * @param funcionario
	 * @return
	 * @throws SICException
	 */
	public Collection<String> obtenerCodigosClasificacionFuncionario(FuncionarioDTO funcionario,Boolean tieneLineaComercial) throws SICException;
}
