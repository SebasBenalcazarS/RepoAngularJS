/**
 * 
 */
package ec.com.smx.sic.cliente.servicio.articulo;

import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.common.articulo.EnumCaracteristicaDinamica;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO;

/**
 * @author eharo
 *
 */
public interface IArticuloMasivoServicio {

	/**
	 * METODO QUE CREA UN MAPA CON LA CLASIFICACION Y LAS CARACTERISTICAS DINAMICAS DE ESTA
	 * @param codigoCompania
	 * @param listaClasificaciones
	 * @param codigosCaracteristicasDinamicas
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Map<String, Set<EnumCaracteristicaDinamica>> obtenerMapaClasificacionCarDin(Integer codigoCompania, Set<String> listaClasificaciones, Collection<Integer> codigosCaracteristicasDinamicas) throws SICException;
	
	/**
	 * METODO QUE OBTIENE EL NUMERO DE FILAS INGRESADO EN UN ARCHIVO EXCEL
	 * @param inputStreamArchivo
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Integer obtenerTamanioFilasArchivoExcel(final InputStream inputStreamArchivo) throws SICException;
	
	/*
	 * CREACION ARTICULO POR ARCHIVO INICIO
	 */
	
	/**
	 * Metodo que procesa el archivo excel para la creacion de articulos por archivo
	 * @param articuloVO
	 * @param inputStreamArchivoArticulo
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoArticulo(ArticuloVO articuloVOPlantillaValores, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException;

	
	/**
	 * Metodo que sirve para crear un articulo desde un archivo
	 * @param datosValidos
	 * @throws SICException
	 * @author eharo
	 */
	public void realizarCreacionArticuloPorArchivo(ArticuloVO articuloVOPlantillaValores,Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos, String nombreArchivo)throws SICException;
	
	/**
	 * Metodo para crear articulo por archivo excel 
	 * @param articuloVO
	 * @throws SICException
	 */
	public void crearArticuloPorArchivo(ArticuloVO articuloVO) throws SICException;
	
	/**
	 * Metodo para crear la plantilla, a partir de la cabecera del archivo excel
	 * @param wb
	 * @param sheet
	 * @throws SICException
	 */
	public void obtenerCabeceraArchivoArticulo(XSSFWorkbook wb , XSSFSheet sheet, Integer tipoCabeceras) throws SICException;
	@SuppressWarnings("rawtypes")
	public ArticuloVO obtenerDatosArticuloVO(ArticuloVO articuloVOPlantillaValores,Integer key, MultiKeyMap datosValidos,LinkedHashMap objectListCarDin []) throws SICException;
	/**
	 * Metodo que permite enviar el mail para confirmar la creacion de articulo por archivo excel
	 */
	public void envioMailCreacionArticuloPorArchivo(Integer codigoCompania, String userId, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo)throws SICException;
	
	/*
	 * CREACION ARTICULO POR ARCHIVO FIN
	 */
	
	
	/*
	 * EDICION ARCHIVO GESTOR INICIO
	 */
	
	
	/**
	 * METODO QUE PROCESA LOS DATOS INGRESADOS
	 * @param articuloEdicionMasivaArchivoVO
	 * @param inputStreamArchivo
	 * @param tipoCabeceras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoEdicionArticulo(ArticuloVO articuloVO, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException;
	
	/**
	 * METODO QUE REALIZAR LA EDICION DE LOS ARTICULOS INGRESADOS
	 * @param articuloVOPlantillaValores
	 * @param datosValidos
	 * @param nombreArchivo
	 * @throws SICException
	 * @author eharo
	 */
	public void realizarEdicionArticuloPorArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos, String nombreArchivo)throws SICException;
	
	
	/**
	 * @param articuloEdicionMasivaArchivoVO
	 * @throws SICException
	 * @author eharo
	 */
	public Integer editarArticuloArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException;
	
	/**
	 * @param articuloEdicionMasivaArchivoVO
	 * @param key
	 * @param datosListaValidos
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public ArticuloEdicionMasivaArchivoVO obtnerArticuloEdicionMasivaVO (ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Integer key, MultiKeyMap datosListaValidos) throws SICException;
	
	/**
	 * Metodo que permite enviar un mensaje con los detalles de la edicion de articulos por excel
	 * @param codigoCompania
	 * @param userId
	 * @param articulosNoRegistrados
	 * @param totalArticulosRegistrados
	 * @param fechaCreacion
	 * @param nombreArchivo
	 * @throws SICException
	 */
	public void envioMailEdicionArticuloPorArchivo(Integer codigoCompania, String userId, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo)throws SICException;
	
	/*
	 * EDICION ARCHIVO GESTOR FIN
	 */
}
