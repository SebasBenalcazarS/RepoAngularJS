/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.admin.edicion;

import java.io.InputStream;
import java.util.Collection;
import java.util.Set;

import org.apache.commons.collections.map.MultiKeyMap;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.framework.common.util.dto.Duplex;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO;

/**
 * @author eharo
 *
 */
public interface IArticuloEdicionArchivoGestor {

	
	/**
	 * METODO QUE PERMITE PROCESAR EL ARCHIVO EXCEL PARA OBTENER LOS DATOS VALIDOS PARA LA ACTUALIZACION
	 * @param articuloVO
	 * @param articuloEdicionMasivaArchivoVO
	 * @param inputStreamArchivo
	 * @param tipoCabeceras
	 * @return
	 * @throws SICException
	 */
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoEdicionArticulo(ArticuloVO articuloVO, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException;
	
	/**
	 * MEETODO QUE REALIZA LA EDICION DE TODOS LOS DATOS VALIDOS OBTENIDOS
	 * @param articuloEdicionMasivaArchivoVO
	 * @param datosValidos
	 * @param nombreArchivo
	 * @throws SICException
	 */
	public void realizarEdicionArticuloPorArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> datosValidos, String nombreArchivo) throws SICException;
	
	/**
	 * METODO QUE ACTUALIZA CADA ARTICULO VALIDO OBTENIDO
	 * @param articuloEdicionMasivaArchivoVO
	 * @return
	 * @throws SICException
	 */
	public Integer editarArticuloArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException;
	
	/**
	 * METODO QUE CONTRUYE EL VO CON LOS DATOS PARA LA ACTUALIZACION
	 * @param articuloEdicionMasivaArchivoVO
	 * @param key
	 * @param datosListaValidos
	 * @return
	 * @throws SICException
	 */
	public ArticuloEdicionMasivaArchivoVO obtnerArticuloEdicionMasivaVO (ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, Integer key, MultiKeyMap datosListaValidos) throws SICException;
	
	/**
	 * METODO QUE PERMITE ENVIAR UN EMAIL AL USUARIO LOGUEADO AL FINAL DE LA ACTUALIZACION
	 * @param codigoCompania
	 * @param userId
	 * @param articulosNoRegistrados
	 * @param totalArticulosRegistrados
	 * @param fechaCreacion
	 * @param nombreArchivo
	 * @throws SICException
	 */
	public void envioMailEdicionArticuloPorArchivo(Integer codigoCompania, String userId, Set<Integer> articulosNoRegistrados, Integer totalArticulosRegistrados, String fechaCreacion, String nombreArchivo)throws SICException;
	
}
