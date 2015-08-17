/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.articulo.articuloBitacora;

import java.util.Collection;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloBitacoraCodigoBarrasDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author gaortiz
 *
 */
public interface IArticuloBitacoraGestor {
	
	/**
	 * 
	 * @param articuloVO
	 * @throws SICException
	 */
	void registrar( ArticuloVO articuloVO )throws SICException;
	
	
	/**
	 * 
	 * @param articuloBitacoraCodigoBarrasDTO
	 * @throws SICException
	 */
	void registrar( ArticuloBitacoraCodigoBarrasDTO articuloBitacoraCodigoBarrasDTO ) throws SICException;

	
	public String obtenerCodigoBarrasActivoPorArticulo(String codigoArticulo,Integer codigoCompania) throws SICException;

	public Collection<String> obtenerUnidadesManejoEnOtrosArticulosPorCodBarras(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> artUniMnjCol) throws SICException;
	
	public Collection<ArticuloDTO> obtenerArticuloPorUnidadesManejoCodBarras(Integer compania, String codigoBarras) throws SICException;
	
	public String transformarCodigoBarras(String codigoBarras); 
	
	/**
	 * Retorna los articulos asociados a un codigo de barras.
	 * @param compania
	 * @param codigoBarras
	 * @return
	 * @throws SICException
	 */
	public Collection<ArticuloDTO> obtenerArticuloPorCodBarras(Integer compania, String codbar, String codart) throws SICException;
}
