/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class CatalogoValorImpID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOCATALOGOVALOR")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SIADMSECCATVAL")
	private Long codigoCatalogoValor;
	
	@Column(name = "CODIGOCATALOGOTIPO")
	private Long codigoCatalogoTipo;

	/**
	 * @return devuelve el valor de la propiedad codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania establece el valor a la propiedad codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoCatalogoValor
	 */
	public Long getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}

	/**
	 * @param codigoCatalogoValor establece el valor a la propiedad codigoCatalogoValor
	 */
	public void setCodigoCatalogoValor(Long codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoCatalogoTipo
	 */
	public Long getCodigoCatalogoTipo() {
		return codigoCatalogoTipo;
	}

	/**
	 * @param codigoCatalogoTipo establece el valor a la propiedad codigoCatalogoTipo
	 */
	public void setCodigoCatalogoTipo(Long codigoCatalogoTipo) {
		this.codigoCatalogoTipo = codigoCatalogoTipo;
	}
	
}
