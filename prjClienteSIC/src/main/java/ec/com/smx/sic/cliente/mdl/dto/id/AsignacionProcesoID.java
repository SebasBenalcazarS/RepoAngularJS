
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase AsignacionProceso
 * @see ec.com.smx.sic.cliente.mdl.dto.AsignacionProceso
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class AsignacionProcesoID implements Serializable{




	/**
	 * Codigo de la compania
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Secuencial de la tabla AsignacionProceso
	 *

	 */
	@Column(name = "CODIGOASIGNACIONPROCESO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECASIPRO")
	private Long codigoAsignacionProceso ;
		
	

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
	 * @return the codigoAsignacionProceso
	 */
	public Long getCodigoAsignacionProceso() {
		return codigoAsignacionProceso;
	}

	/**
	 * @param codigoAsignacionProceso the codigoAsignacionProceso to set
	 */
	public void setCodigoAsignacionProceso(Long codigoAsignacionProceso) {
		this.codigoAsignacionProceso = codigoAsignacionProceso;
	}

}

