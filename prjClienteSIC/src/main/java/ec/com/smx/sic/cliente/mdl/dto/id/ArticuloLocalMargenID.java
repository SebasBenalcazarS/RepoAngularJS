package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloLocalMargen
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloLocalMargen
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloLocalMargenID implements Serializable {

	/**
	 * Código de la compania
	 */
	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial del articulo local margen
	 */
	@Column(name="CODIGOARTICULOLOCALMARGEN", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSARTLOCMAR")
	private java.lang.Long codigoArticuloLocalMargen;

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
	 * Retorna valor de propiedad <code>codigoArticuloLocalMargen</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoArticuloLocalMargen</code>
	 */
	public java.lang.Long getCodigoArticuloLocalMargen() {
		return this.codigoArticuloLocalMargen;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticuloLocalMargen</code>.
	 * 
	 * @param codigoArticuloLocalMargen1
	 *            El valor a establecer para la propiedad <code>codigoArticuloLocalMargen</code>.
	 */
	public void setCodigoArticuloLocalMargen(java.lang.Long codigoArticuloLocalMargen1) {
		this.codigoArticuloLocalMargen = codigoArticuloLocalMargen1;

	}

}
