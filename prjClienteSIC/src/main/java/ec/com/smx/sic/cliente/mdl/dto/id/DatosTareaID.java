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
 * Clase que encapsula a las propiedades Identificadoras de la clase DatosTarea
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DatosTareaDTO
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class DatosTareaID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial de la tabla DatosTarea
	 * 
	 */
	@Column(name = "CODIGODATOSTAREA", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, 
						   name = "SBLOGSECDATTAR", 
						   sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
						   castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private java.lang.Long codigoDatosTarea;

	public static final String NOMBRE_SECUENCIA = "SBLOGSECDATTAR";
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
	 * Retorna valor de propiedad <code>codigoDatosTarea</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoDatosTarea</code>
	 */
	public java.lang.Long getCodigoDatosTarea() {
		return this.codigoDatosTarea;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoDatosTarea</code>.
	 * 
	 * @param codigoDatosTarea1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoDatosTarea</code>.
	 */
	public void setCodigoDatosTarea(java.lang.Long codigoDatosTarea1) {
		this.codigoDatosTarea = codigoDatosTarea1;

	}

}
