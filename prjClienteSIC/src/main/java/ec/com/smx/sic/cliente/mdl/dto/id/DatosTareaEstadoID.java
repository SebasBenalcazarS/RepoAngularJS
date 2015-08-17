
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
 * Clase que encapsula a las propiedades Identificadoras de la clase DatosTareaEstado
 * @see ec.com.smx.sic.cliente.mdl.dto.DatosTareaEstadoDTO
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class DatosTareaEstadoID implements Serializable {

	/**
	 * Representa del codigo de la compa�ia.
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Representa la clave primaria de la tabla (Secuencial de la tabla)
	 *
	 */
	@Column(name = "CODIGODATOSTAREAESTADO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, 
						   name = "SBLOGSECDATTAREST" , 
								   sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
						   castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoDatosTareaEstado ;
		
	

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
	 * @return the codigoDatosTareaEstado
	 */
	public Long getCodigoDatosTareaEstado() {
		return codigoDatosTareaEstado;
	}

	/**
	 * @param codigoDatosTareaEstado the codigoDatosTareaEstado to set
	 */
	public void setCodigoDatosTareaEstado(Long codigoDatosTareaEstado) {
		this.codigoDatosTareaEstado = codigoDatosTareaEstado;
	}

}

