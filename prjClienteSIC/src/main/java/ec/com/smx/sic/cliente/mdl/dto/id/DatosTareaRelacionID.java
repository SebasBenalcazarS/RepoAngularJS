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
 * Clase que encapsula a las propiedades Identificadoras de la clase DatosTareaRelacion
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DatosTareaRelacionDTO
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class DatosTareaRelacionID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	
	/**
	 * Codigo datos tarea relacionado
	 * 
	 */
	@Column(name = "CODIGODATOSTAREARELACION", nullable = false)	
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, 
						   name = "SBLOGSECDATTARREL", 
						   sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
						   castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private java.lang.Long codigoDatosTareaRelacion;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	/**
	 * @return the codigoDatosTareaRelacion
	 */
	public java.lang.Long getCodigoDatosTareaRelacion() {
		return codigoDatosTareaRelacion;
	}

	/**
	 * @param codigoDatosTareaRelacion the codigoDatosTareaRelacion to set
	 */
	public void setCodigoDatosTareaRelacion(java.lang.Long codigoDatosTareaRelacion) {
		this.codigoDatosTareaRelacion = codigoDatosTareaRelacion;
	}

}
