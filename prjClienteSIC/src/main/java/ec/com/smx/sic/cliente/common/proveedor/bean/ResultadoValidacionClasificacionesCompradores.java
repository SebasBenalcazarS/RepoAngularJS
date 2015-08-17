/**
 * 
 */
package ec.com.smx.sic.cliente.common.proveedor.bean;

import java.io.Serializable;

import ec.com.smx.sic.cliente.common.proveedor.TipoAsignacionUsuario;

/**
 * @author gaortiz
 *
 */
@SuppressWarnings("serial")
public class ResultadoValidacionClasificacionesCompradores implements Serializable{
	private TipoAsignacionUsuario tiposUsuario;
	
	
	public ResultadoValidacionClasificacionesCompradores(TipoAsignacionUsuario tiposUsuario){
		this.tiposUsuario = tiposUsuario;
	}
	/**
	 * 
	 * @return
	 */
	public TipoAsignacionUsuario getTiposUsuario(){
		return this.tiposUsuario;
	}

}
