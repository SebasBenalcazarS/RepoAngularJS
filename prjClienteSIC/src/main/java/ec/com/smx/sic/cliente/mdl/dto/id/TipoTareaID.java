/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoTareaID implements Serializable {
	
	/**
	 * C&oacute;digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el c&oacute;digo del tipo tarea
	 *
	 */
	@Column(name = "CODIGOTIPOTAREA", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBTARSECTIPTAR", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoTipoTarea ;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoTipoTarea
	 */
	public Long getCodigoTipoTarea() {
		return codigoTipoTarea;
	}

	/**
	 * @param codigoTipoTarea the codigoTipoTarea to set
	 */
	public void setCodigoTipoTarea(Long codigoTipoTarea) {
		this.codigoTipoTarea = codigoTipoTarea;
	}
	
}
