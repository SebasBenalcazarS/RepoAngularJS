
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DetalleAsignacionProceso
 * @see ec.com.smx.sic.cliente.mdl.dto.DetalleAsignacionProceso
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class DetalleAsignacionProcesoID implements Serializable{




	/**
	 * Codigo de la compania
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Secuencial de la tabla DetalleAsignacionProceso
	 *

	 */
	@Column(name = "CODIGODETALLEASIGNACIONPROCESO", nullable = false)
	private Long codigoDetalleAsignacionProceso ;
		
	

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania(){
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 ){
		this.codigoCompania=codigoCompania1;
		
	}

		

	/**
	 * Retorna valor de propiedad <code>codigoDetalleAsignacionProceso</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoDetalleAsignacionProceso</code>
	 */
	public java.lang.Long getCodigoDetalleAsignacionProceso(){
		return this.codigoDetalleAsignacionProceso;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoDetalleAsignacionProceso</code>.
	 * @param codigoDetalleAsignacionProceso1 
	 *		El valor a establecer para la propiedad <code>codigoDetalleAsignacionProceso</code>.
	 */
	public void setCodigoDetalleAsignacionProceso( Long codigoDetalleAsignacionProceso1 ){
		this.codigoDetalleAsignacionProceso=codigoDetalleAsignacionProceso1;
		
	}


}

