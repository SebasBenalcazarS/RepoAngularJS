/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.unidadmanejo.validacion;

import java.util.Collection;
import java.util.List;

import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.unidadmanejo.validacion.IValidacionUnidadManejoGestor;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloUnidadManejoDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloTransient;
import ec.com.smx.sic.cliente.mdl.vo.ArticuloVO;
import ec.com.smx.sic.cliente.persistencia.articulos.dao.IArticuloUnidadManejoDAO;


/**
 * Implementaci&oacute;n de la l&oacute;gica del negocio para el registro de unidades de manejo
 * @author fmunoz
 *
 */
public class ValidacionUnidadManejoGestor implements IValidacionUnidadManejoGestor{

	private IArticuloUnidadManejoDAO articuloUnidadManejoDAO;
	
	/* (non-Javadoc)
	 * @see ec.com.smx.sic.articulo.gestor.unidadmanejo.validacion.IValidacionUnidadManejoGestor#validarUnicidadEAN14(ec.com.smx.sic.cliente.mdl.vo.ArticuloVO, java.util.Collection)
	 */
	@Override
	public Collection<ArticuloUnidadManejoDTO> validarUnicidadEAN14(ArticuloVO articuloVO, Collection<ArticuloUnidadManejoDTO> unidadesManejo)throws SICException{
		Collection<ArticuloUnidadManejoDTO> eanDuplicados = articuloUnidadManejoDAO.obtenerUnidadesManejoEnOtrosArticulosPorEAN(articuloVO.getBaseDTO(), unidadesManejo);
		articuloVO.getBaseDTO().addDynamicProperty(ArticuloTransient.CODIGOS_EAN_DUPLICADOS, eanDuplicados);
		return eanDuplicados;
	}
	
 
	/**
	* @see IValidacionUnidadManejoGestor#validarCondigoEANunico(String, Integer)
	*/ 
	@Override
	public void validarCondigoEANunico(String codigoEAN, Integer codigoCompania) throws SICException {
		try {
			List<ArticuloUnidadManejoDTO> unidadesManejo = articuloUnidadManejoDAO.obtenerUMporCodigoEAN(codigoEAN, codigoCompania, 
					SICConstantes.ESTADO_ACTIVO_NUMERICO);
			if (unidadesManejo != null) {
				throw new SICException("El c\u00f3digo de barras ingresado ".concat(codigoEAN).concat(" pertenece a una unidad de manejo"));
			}
		} catch (SICException e) {
			throw e;
		} catch (RuntimeException e) {
			throw new SICException("Error al tratar de validar el c\u00f3digo EAN en las unidades de manejo");
		}
	}
	
	/**
	 * @param articuloUnidadManejoDAO the articuloUnidadManejoDAO to set
	 */
	public void setArticuloUnidadManejoDAO(IArticuloUnidadManejoDAO articuloUnidadManejoDAO) {
		this.articuloUnidadManejoDAO = articuloUnidadManejoDAO;
	}
}
