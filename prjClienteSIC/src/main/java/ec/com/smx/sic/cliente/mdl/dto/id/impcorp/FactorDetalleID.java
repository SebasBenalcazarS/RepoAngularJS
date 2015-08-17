package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

/**
 * 
 */


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
public class FactorDetalleID extends BaseID  {
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOFACTORDETALLE")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECFCTDET")
	private Long codigoFactorDetalle;

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
	 * @return devuelve el valor de la propiedad codigoFactorDetalle
	 */
	public Long getCodigoFactorDetalle() {
		return codigoFactorDetalle;
	}

	/**
	 * @param codigoFactorDetalle establece el valor a la propiedad codigoFactorDetalle
	 */
	public void setCodigoFactorDetalle(Long codigoFactorDetalle) {
		this.codigoFactorDetalle = codigoFactorDetalle;
	}
	
}
