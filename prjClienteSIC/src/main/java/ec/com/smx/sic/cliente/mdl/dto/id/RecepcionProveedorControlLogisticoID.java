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
public class RecepcionProveedorControlLogisticoID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	@Column(name = "CODIGORECEPCIONPROVEEDORCONTROLLOGISTICO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECRECPROCONLOG" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoRecepcionProveedorControlLogistico;

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
	 * @return the codigoRecepcionProveedorControlLogistico
	 */
	public Long getCodigoRecepcionProveedorControlLogistico() {
		return codigoRecepcionProveedorControlLogistico;
	}

	/**
	 * @param codigoRecepcionProveedorControlLogistico the codigoRecepcionProveedorControlLogistico to set
	 */
	public void setCodigoRecepcionProveedorControlLogistico(Long codigoRecepcionProveedorControlLogistico) {
		this.codigoRecepcionProveedorControlLogistico = codigoRecepcionProveedorControlLogistico;
	}
	
}
