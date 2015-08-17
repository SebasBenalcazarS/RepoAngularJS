/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean.controlrutas;

import java.io.Serializable;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;

/**
 * @author Esteban Gudino
 * 
 * 
 */
public interface IPlantillaBusquedaTransporte extends Serializable {

	public abstract SearchTemplateDTO<String> getPlacaTransporte();
	public abstract SearchTemplateDTO<Long> getCodigoTransporte();
	public abstract SearchTemplateDTO<String> getTipoTransporte();
	public abstract SearchTemplateDTO<String> getMarcaTransporte();
	public abstract SearchTemplateDTO<String> getColorTransporte();
}
