/**
 * 
 */
package ec.com.smx.sic.cliente.persistencia.articulos.dao;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoArticuloDTO;

/**
 * @author eharo
 *
 */
public interface IArticuloControlEtiquetadoDAO {

	
	/**
	 * METODO QUE DEVUELVE EL {@link ArticuloDTO} CON LA INFORMACION:
	 * <code>CODIGO COMPANIA</code>
	 * <code>CODIGO ARTICULO</code>
	 * <code>APLICA TRANSGENICO</code>
	 * <code>APLICA REGISTRO SANITARIO</code>
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public ArticuloDTO obtenerInformacionTraRegSanSem(Integer codigoCompania, String codigoArticulo) throws SICException;
	
	
	public ArticuloEtiquetaDTO obtenerArticuloPoseeEtiquetaSemaforo(Integer codigoCompania, String codigoArticulo) throws SICException;

	/**
	 * PERMITE OBTENER UNA LISTA DE ARTICULOS QUE POSEEN ETIQUETAS DE ACUERDO A UN TIPO
	 * @param codigoCompania
	 * @param codigoEtiqueta
	 * @param codigoTipoArticulo
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloEtiquetaDTO> obtenerArticuloEtiquetaPorTipo(Integer codigoCompania, Long codigoEtiqueta, String codigoTipoArticulo) throws SICException;

	/**
	 * PERMITE OBTENER UNA LISTA DE ARTICULOS RECIPIENTES
	 * @param codigoCompania
	 * @param codigoArticuloTipoPadre
	 * @return
	 * @throws SICException
	 */
	public Collection<TipoArticuloDTO> obtenerArticuloRecipientes(Integer codigoCompania, String codigoArticuloTipoPadre)throws SICException;
	
	/**
	 * PERMITE OBTNER EL SECUENCIAL DE LOS ARTICULOETIQUETAS
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param codigoEtiqueta
	 * @return
	 * @throws SICException
	 */
	public Integer obtenerSecuencialArticuloEtiqueta(Integer codigoCompania, String codigoArticulo, Long codigoEtiqueta)throws SICException;
	
	/**
	 * PERMITE ACTUALIZAR EL SECUENCIAL DEL ARTICULO ETIQUETA CON LA NUEVA SECUENCIA
	 * @param articuloEtiquetaDTO
	 * @throws SICException
	 */
	public void  actualizarArticuloEtiquetaDTO(ArticuloEtiquetaDTO articuloEtiquetaDTO)throws SICException;

}
