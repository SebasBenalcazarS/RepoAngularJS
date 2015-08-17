
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceValueAddition;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionPositionEnum;
import ec.com.kruger.utilitario.dao.commons.hibernate.sequence.enumeration.SequenceValueAdditionSizeEnum;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase EstadoTarea
 * 
 * @see ec.com.smx.corpv2.dto.TareaEstadoDTO
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Embeddable
public class TareaEstadoID implements Serializable{

	/**
	 * C�digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el codigo del estado de la tarea
	 *
	 */
	@Column(name = "CODIGOTAREAESTADO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , 
							name = "SBTARSECTAREST", 
							sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
							castTo=@Cast(sqlType=Types.NUMERIC,precision=9,scale=0))
	private Long codigoTareaEstado ;

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
	 * Retorna valor de propiedad <code>codigoTareaEstado</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTareaEstado</code>
	 */
	public Long getCodigoTareaEstado(){
		return this.codigoTareaEstado;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTareaEstado</code>.
	 * @param codigoTareaEstado 
	 *		El valor a establecer para la propiedad <code>codigoTareaEstado</code>.
	 */
	public void setCodigoTareaEstado(Long codigoTareaEstado ){
		this.codigoTareaEstado=codigoTareaEstado;
		
	}
}

