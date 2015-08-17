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
 * @author dalmeida
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ControlLogisticoID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	@Column(name = "CODIGOCONTROLLOGISTICO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECCONLOG" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoControlLogistico;

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
	 * @return the codigoControlLogistico
	 */
	public Long getCodigoControlLogistico() {
		return codigoControlLogistico;
	}

	/**
	 * @param codigoControlLogistico the codigoControlLogistico to set
	 */
	public void setCodigoControlLogistico(Long codigoControlLogistico) {
		this.codigoControlLogistico = codigoControlLogistico;
	}
	
}
