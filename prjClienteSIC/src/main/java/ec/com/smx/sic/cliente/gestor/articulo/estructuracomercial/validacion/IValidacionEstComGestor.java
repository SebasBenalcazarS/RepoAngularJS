package ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.validacion;

import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.mdl.dto.id.ConceptoClasificacionID;

public interface IValidacionEstComGestor {

	/**
	 * 
	 * @param conceptoClasificacionID
	 * @return
	 * @throws SICRuleException
	 */
	public abstract Boolean esActivoConceptoClasificacion(ConceptoClasificacionID conceptoClasificacionID) throws SICRuleException;

}