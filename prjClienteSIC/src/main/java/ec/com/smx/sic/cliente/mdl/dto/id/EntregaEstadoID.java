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
public class EntregaEstadoID implements Serializable {

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
	@Column(name = "CODIGOENTREGAESTADO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCFDISECENTEST", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private java.lang.Long codigoEntregaEstado;

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
	 * @return the codigoEntregaEstado
	 */
	public java.lang.Long getCodigoEntregaEstado() {
		return codigoEntregaEstado;
	}

	/**
	 * @param codigoEntregaEstado the codigoEntregaEstado to set
	 */
	public void setCodigoEntregaEstado(java.lang.Long codigoEntregaEstado) {
		this.codigoEntregaEstado = codigoEntregaEstado;
	}

}
