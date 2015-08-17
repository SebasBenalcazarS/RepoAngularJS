/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.decorator;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;

import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.common.articulo.decorator.ArticuloGestorDecorator;
import ec.com.smx.sic.cliente.common.articulo.decorator.IArticuloRecepcionGestorDecorator;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.admin.IArticuloRegistroGestor;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;

/**
 * @author gaortiz
 *
 */
public class ArticuloRecepcionGestorDecorator extends ArticuloGestorDecorator implements IArticuloRecepcionGestorDecorator {

	public ArticuloRecepcionGestorDecorator(IArticuloRegistroGestor articuloGestor) {
		super(articuloGestor);
	}

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.common.articulo.decorator.IArticuloRecepcionGestorDecorator#registrarArticulos(java.util.Collection)
	 */
	@Override
	public void registrarArticulos(Collection<ArticuloVO> articuloVOs) throws SICException {
		
		if( CollectionUtils.isNotEmpty(articuloVOs) ){
			
			Logeable.LOG_SICV2.info("------------------------------------------------------------------------");
			Logeable.LOG_SICV2.info("----------------------- INICIO REGISTRO ARTICULO -----------------------");
			Logeable.LOG_SICV2.info("------------------------------------------------------------------------");
			
			for( final ArticuloVO articuloVO : articuloVOs ){
				this.registrarArticulo(articuloVO);
			}
			
			Logeable.LOG_SICV2.info("------------------------------------------------------------------------");
			Logeable.LOG_SICV2.info("----------------------- FIN REGISTRO ARTICULO -----------------------");
			Logeable.LOG_SICV2.info("------------------------------------------------------------------------");
			
		}
		
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
		return super.inactivarUnidadManejoPorPrioridad(codigoCompania, codigoArticulo, prioridad, userId, codigoUnidadManejo);
	}

}
