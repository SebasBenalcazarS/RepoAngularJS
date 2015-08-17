
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
 * @author dalmeida
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class RecepcionProveedorDetalleSeccionID implements Serializable {

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	@Column(name = "CODIGORECPRODETSEC", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , 
							name = "SBLOGSECRECPRODETSEC", 
						    sequenceValueAddition = @SequenceValueAddition(valueAddition = SequenceValueAdditionEnum.JULIAN_DAY, valueAdditionPosition = SequenceValueAdditionPositionEnum.BEFORE, valueAdditionSize=SequenceValueAdditionSizeEnum.LARGE),
							castTo=@Cast(sqlType=Types.NUMERIC,precision=9,scale=0))
	private Long codigoRecepcionProveedorDetalleSeccion;

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
	 * @return the codigoRecepcionProveedorDetalleSeccion
	 */
	public Long getCodigoRecepcionProveedorDetalleSeccion() {
		return codigoRecepcionProveedorDetalleSeccion;
	}

	/**
	 * @param codigoRecepcionProveedorDetalleSeccion the codigoRecepcionProveedorDetalleSeccion to set
	 */
	public void setCodigoRecepcionProveedorDetalleSeccion(Long codigoRecepcionProveedorDetalleSeccion) {
		this.codigoRecepcionProveedorDetalleSeccion = codigoRecepcionProveedorDetalleSeccion;
	}
		
}

