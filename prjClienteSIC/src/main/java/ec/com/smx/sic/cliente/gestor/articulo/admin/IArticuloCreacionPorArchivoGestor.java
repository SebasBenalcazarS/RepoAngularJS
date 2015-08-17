/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.admin;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author eharo
 *
 */
public interface IArticuloCreacionPorArchivoGestor {

	/**
	 * METODO QUE PERMITE REALIZAR LA CREACION DE ARTICULO POR ARCHIVO
	 * @param articuloVOPlantillaValores
	 * @param datosValidos
	 * @param nombreArchivo
	 * @throws SICException
	 */
	public void realizarCreacionArticuloPorArchivo(ArticuloVO articuloVOPlantillaValores,Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos, String nombreArchivo)throws SICException;
	
	/**
	 * METODO QUE CREA UN NUEVO ARTICULO
	 * @param articuloVO
	 * @throws SICException
	 */
	public void crearArticulo(ArticuloVO articuloVO)throws SICException;
	
	
	/**
	 * METODO QUE PERMITE ARMAR EL VO CON LOS DATOS PARA LA CREACION
	 * @param articuloVOPlantillaValores
	 * @param key
	 * @param datosValidos
	 * @param objectListCarDin
	 * @return
	 * @throws SICException
	 * @author aecaiza
	 */
	@SuppressWarnings("rawtypes")
	public ArticuloVO obtenerDatosArticuloVO(ArticuloVO articuloVOPlantillaValores,Integer key, MultiKeyMap datosValidos,LinkedHashMap objectListCarDin []) throws SICException;
	
	/**
	 * METODO QUE PERMITE ENVIAR UN MAIL AL USUARIO LOGUEADO AL FINAL DEL PROCESO DE CREACION
	 * @param codigoCompania
	 * @param userId
	 * @param articulosNoRegistrados
	 * @param totalArticulosRegistrados
	 * @param fechaCreacion
	 * @param nombreArchivo
	 * @throws SICException
	 */
	public void envioMailCreacionArticuloPorArchivo(Integer codigoCompania, String userId, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo)throws SICException;
}
