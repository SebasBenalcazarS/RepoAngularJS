/**
 * 
 */
package ec.com.smx.sic.cliente.gestor.bodega.tareas.validacion;

import ec.com.smx.corpv2.dto.id.CatalogoValorID;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.mdl.dto.TareaDTO;

/**
 * @author wcaiza
 *
 */
public interface IValidacionAlmacenamientoTareasGestor {
	
	void cambiarEstadoTarea(TareaDTO tareaDTO, CatalogoValorID catalogoIDEstadoTarea) throws SICException;

}
