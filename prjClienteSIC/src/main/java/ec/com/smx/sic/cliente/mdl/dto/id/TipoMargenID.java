package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoMargen
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.TipoMargen
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoMargenID implements Serializable {

	/**
	 * Código de la compania
	 * 
	 */
	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial del tipo de margen
	 * 
	 */
	@Column(name = "CODIGOTIPOMARGEN", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSTIPMAR")
	private Integer codigoTipoMargen;

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
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoMargen</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoMargen</code>
	 */
	public Integer getCodigoTipoMargen() {
		return this.codigoTipoMargen;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoMargen</code>.
	 * 
	 * @param codigoTipoMargen1
	 *            El valor a establecer para la propiedad <code>codigoTipoMargen</code>.
	 */
	public void setCodigoTipoMargen(Integer codigoTipoMargen1) {
		this.codigoTipoMargen = codigoTipoMargen1;

	}

}
