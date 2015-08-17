/**
 * 
 */
package ec.com.smx.sic.articulo.gestor.articulo.alcance.nosql.validacion;

import java.util.ArrayList;
import java.util.Collection;

import ec.com.smx.sic.cliente.common.bodega.CentroDistribucionUtil;
import ec.com.smx.sic.cliente.exception.SICException;
import ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.validacion.IValidacionArticuloAlcanceNoSqlGestor;
import ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.VistaArticuloLocalNoSqlDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.articulo.VistaArticuloLocalNoSqlID;

/**
 * @author wcaiza
 *
 */
public class ValidacionArticuloAlcanceNoSqlGestor implements IValidacionArticuloAlcanceNoSqlGestor {

	/* (non-Javadoc)
	 * @see ec.com.smx.sic.cliente.gestor.articulo.alcance.nosql.validacion.IValidacionArticuloAlcanceNoSqlGestor#validarArticuloLocalRegistrar(ec.com.smx.sic.cliente.mdl.dto.articulo.nosql.VistaMigrarArticuloLocalDTO)
	 */
	@Override
	public void validarArticuloLocalRegistrar(VistaArticuloLocalNoSqlDTO vistaArticuloLocalDTO) throws SICException {
		
		Boolean lanzarExcepcion = Boolean.FALSE;
		Collection<String> mensajes = new ArrayList<String>();
		mensajes.add("Existen valores vacios en: ");
		
		lanzarExcepcion = this.validarIdVistaMigrarArticuloLocalDTO(vistaArticuloLocalDTO.getId(), lanzarExcepcion, mensajes);
		
		if (lanzarExcepcion) {
			StringBuilder errorMessage = CentroDistribucionUtil.getInstancia().appendObject(mensajes.toArray(new Object[mensajes.size()]));
			throw new SICException(errorMessage.toString());
		}

	}
	
	private Boolean validarIdVistaMigrarArticuloLocalDTO (
			VistaArticuloLocalNoSqlID vistaMigrarArticuloLocalID, Boolean pLanzarExcepcion, Collection<String> mensajes) throws SICException {
		
		Boolean lanzarExcepcion = pLanzarExcepcion;
		
		if(vistaMigrarArticuloLocalID == null) {
			lanzarExcepcion = Boolean.TRUE;
			mensajes.add(", id");
		}
		
		if(vistaMigrarArticuloLocalID.getCodigoCompania() == null) {
			lanzarExcepcion = Boolean.TRUE;
			mensajes.add(", codigoCompania");
		}
		
		if(vistaMigrarArticuloLocalID.getCodigoArticulo() == null) {
			lanzarExcepcion = Boolean.TRUE;
			mensajes.add(", codigoArticulo");
		}
		
		if(vistaMigrarArticuloLocalID.getCodigoLocal() == null) {
			lanzarExcepcion = Boolean.TRUE;
			mensajes.add(", codigoLocal");
		}
		
		return lanzarExcepcion;
		
	}

}
