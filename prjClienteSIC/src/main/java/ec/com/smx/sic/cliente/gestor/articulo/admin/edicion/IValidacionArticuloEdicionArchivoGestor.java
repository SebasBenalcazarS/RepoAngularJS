/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.admin.edicion;

import java.io.InputStream;
import java.util.Collection;

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
public interface IValidacionArticuloEdicionArchivoGestor {

	public void imprimirAcceso(String nombre) throws SICException;
	
	public Duplex<Collection<CatalogoValorDTO>, MultiKeyMap> procesarArchivoEdicionArticulo(ArticuloVO articuloVO, ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO, InputStream inputStreamArchivo, Integer tipoCabeceras) throws SICException;
	
	public String obtenerCodigoArticuloDesdeCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	
	public Integer editarArticuloArchivo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException;
	
}
