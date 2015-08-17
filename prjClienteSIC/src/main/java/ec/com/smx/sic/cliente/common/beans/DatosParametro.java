/**
 * 
 */
package ec.com.smx.sic.cliente.common.beans;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.ParametroDTO;

/**
 * @author Mario Braganza
 *
 */
@SuppressWarnings("serial")
public class DatosParametro<T> implements Serializable {

	private ParametroDTO parametro;
	private Collection<T> listaValoresParametro;
	/**
	 * @return the parametro
	 */
	public ParametroDTO getParametro() {
		return parametro;
	}
	/**
	 * @param parametro the parametro to set
	 */
	public void setParametro(ParametroDTO parametro) {
		this.parametro = parametro;
	}
	/**
	 * @return the listaValoresParametro
	 */
	public Collection<T> getListaValoresParametro() {
		return listaValoresParametro;
	}
	/**
	 * @param listaValoresParametro the listaValoresParametro to set
	 */
	public void setListaValoresParametro(Collection<T> listaValoresParametro) {
		this.listaValoresParametro = listaValoresParametro;
	}
	
	
	
}
