package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase EntregaDTO
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.EntregaDTO
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class EntregaID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial de la tabla Entrega
	 * 
	 */
	@Column(name = "CODIGOENTREGA", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECENTREGA", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private java.lang.Long codigoEntrega;

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
	 * Retorna valor de propiedad <code>codigoEntrega</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoEntrega</code>
	 */
	public java.lang.Long getCodigoEntrega() {
		return this.codigoEntrega;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoEntrega</code>.
	 * 
	 * @param codigoEntrega1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoEntrega</code>.
	 */
	public void setCodigoEntrega(java.lang.Long codigoEntrega1) {
		this.codigoEntrega = codigoEntrega1;

	}

}
