/**
 * 
 */
package ec.com.smx.sic.cliente.common.articulo.decorator;

import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloRegistroGestor;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author gaortiz
 *
 */
public abstract class ArticuloGestorDecorator implements IArticuloRegistroGestor {
	
	protected final IArticuloRegistroGestor articuloGestor;

	public ArticuloGestorDecorator(IArticuloRegistroGestor articuloGestor) {
		this.articuloGestor = articuloGestor;
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloRegistroGestor#registrarArticulo(ec.com.smx.sic.cliente.mdl.vo.ArticuloVO)
	 */
	@Override
	public ArticuloVO registrarArticulo(ArticuloVO articuloVO) throws SICException {
		return articuloGestor.registrarArticulo(articuloVO);
	}
	
	/**
	 * Metodo que inactiva las unidades de manejo por una prioridad especifica y puede omitir una unidad de manejo especifica.
	 * @author jgranda
	 * @param codigoCompania
	 * @param codigoArticulo
	 * @param prioridad
	 * @param codigoUnidadManejo codigo de unidad de manejo que se omite puede anularse este parametro
	 * @param userId
	 * @return
	 * @throws SICException
	 */
	@Override
	public Integer inactivarUnidadManejoPorPrioridad(Integer codigoCompania, String codigoArticulo, Integer prioridad, String userId, Long... codigoUnidadManejo) throws SICException{
		return articuloGestor.inactivarUnidadManejoPorPrioridad(codigoCompania, codigoArticulo, prioridad, userId, codigoUnidadManejo);
	}

}
