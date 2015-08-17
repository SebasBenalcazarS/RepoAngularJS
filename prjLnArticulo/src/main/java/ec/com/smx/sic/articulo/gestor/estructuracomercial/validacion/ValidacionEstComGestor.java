/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.estructuracomercial.validacion;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.gestor.DataGestor;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.exception.SICRuleException;
import ec.com.smx.sic.cliente.gestor.articulo.estructuracomercial.validacion.IValidacionEstComGestor;
import ec.com.smx.sic.cliente.mdl.dto.ConceptoClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ConceptoClasificacionID;

/**
 * @author fmunoz
 *
 */
public class ValidacionEstComGestor implements IValidacionEstComGestor {

	private DataGestor dataGestor;
	/**
	 * 
	 * @param conceptoClasificacionID
	 * @return
	 * @throws SICRuleException
	 */
	@Override
	public Boolean esActivoConceptoClasificacion(ConceptoClasificacionID conceptoClasificacionID)throws SICRuleException{
		ConceptoClasificacionDTO ccl;
		try{
			//se verifica si existe el codigo de clasifiacion en la lista del concepto
			ccl = new ConceptoClasificacionDTO();
			ccl.setId(conceptoClasificacionID);
			ccl.setEstado(SICConstantes.ESTADO_ACTIVO_NUMERICO);
			Collection<ConceptoClasificacionDTO> col = dataGestor.findObjects(ccl);
			if(!col.isEmpty()){
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}catch (Exception e) {
			throw new SICRuleException(e);
		}finally{
			ccl = null;
		}
	}
	
	public void setDataGestor(DataGestor dataGestor) {
		this.dataGestor = dataGestor;
	}
}
