/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.etiquetado;

import java.util.Collection;

import ec.com.smx.sic.cliente.common.articulo.etiquetado.ArticuloInformacionEtiquetado;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaDTO;
import ec.com.smx.sic.cliente.mdl.dto.TipoArticuloDTO;

/**
 * @author eharo
 *
 */
public interface IArticuloControlEtiquetadoGestor {

	/**
	 * METODO QUE DEVUELVE UNA ESTRUCTURA CON LA INFORMACION DEL ARTICULO:
	 * APLICA TRANSGENICO
	 * APLICA REGISTRO SANITARIO
	 * POSEE SEMAFORO
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @return
	 * @throws SICException
	 */
	public ArticuloInformacionEtiquetado obtenerInformacionTraRegSanSem(Integer codigoCompania, String codigoArticulo) throws SICException;

	public Collection<ArticuloEtiquetaDTO> obtenerArticuloEtiquetaPorTipo(Integer codigoCompania, Long codigoEtiqueta, String codigoTipoArticulo)throws SICException;
	
	public Collection<TipoArticuloDTO> obtenerArticuloRecipientes(Integer codigoCompania, String codigoArticuloTipoPadre)throws SICException;
	
	public Integer obtenerSecuencialArticuloEtiqueta(Integer codigoCompania, String codigoArticulo, Long codigoEtiqueta)throws SICException;
	
	public void  actualizarArticuloEtiquetaDTO(ArticuloEtiquetaDTO articuloEtiquetaDTO)throws SICException;
}
