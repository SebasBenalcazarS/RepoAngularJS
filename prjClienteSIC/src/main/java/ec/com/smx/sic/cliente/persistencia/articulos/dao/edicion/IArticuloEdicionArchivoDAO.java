/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao.edicion;

import java.util.List;

import org.hibernate.criterion.Criterion;

import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.vo.articulos.edicion.ArticuloEdicionMasivaArchivoVO;
import ec.com.smx.sic.cliente.mdl.vo.articulos.informacion.ArticuloInfoVO;

/**
 * @author eharo
 *
 */
public interface IArticuloEdicionArchivoDAO {

	
	public void imprimirAcceso(String nombre) throws SICException;
	
	/**
	 * Obtiene la lista de cabeceras para la edicion
	 * @param tipoCabeceras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public List<CatalogoValorDTO> listaCabecerasEdicion(Integer tipoCabeceras) throws SICException;
	
	/**
	 * Metodo que obtiene el codigo de un articulo desde el codigo de barras
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public String obtenerCodigoArticuloDesdeCodigoBarras(Integer codigoCompania, String codigoBarras) throws SICException;
	
	
	/**
	 * @param articuloEdicionMasivaArchivoVO
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public Integer editarClaseArticulo(ArticuloEdicionMasivaArchivoVO articuloEdicionMasivaArchivoVO) throws SICException;
	
	/**
	 * Obtener el usuario
	 * @param usuarioId
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public UserDto obtenerUsuario(String usuarioId) throws SICException;
	
	/**
	 * Metodo que permite obtener el tipo del articulo, la clase actual y el id
	 * @param codigoCompania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public ArticuloInfoVO obtenerArticuloEdicionArchivo(Integer codigoCompania, String codigoBarras) throws SICException;
	
	
	/**
	 * Metodo que valida el codigo de barras y que el usuario funcionario pertenesca a la linea comercial
	 * @param codigoCompania
	 * @param codigoBarras
	 * @param usuarioLineaComercial
	 * @return
	 * @throws SICException
	 */
	public Boolean validarExisteCodigoBarras(Integer codigoCompania, String codigoBarras, Criterion usuarioLineaComercial) throws SICException;
	
	
	/**
	 * METODO QUE PERMITE OBTENER LA CLASE ANTERIOR DEL ARTICULO
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 * @author eharo
	 */
	public String obtenerClaseAnteriorArticulo(Integer codigoCompania, String codigoArticulo) throws SICException;
}
