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
public class FacturaDetalleImpID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOFACTURA")
	private Long codigoFactura;
	
	@Column(name = "CODIGOFACTURADETALLE")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECFACDET")
	private Long codigoFacturaDetalle;

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
	 * @return devuelve el valor de la propiedad codigoFactura
	 */
	public Long getCodigoFactura() {
		return codigoFactura;
	}

	/**
	 * @param codigoFactura establece el valor a la propiedad codigoFactura
	 */
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFacturaDetalle
	 */
	public Long getCodigoFacturaDetalle() {
		return codigoFacturaDetalle;
	}

	/**
	 * @param codigoFacturaDetalle establece el valor a la propiedad codigoFacturaDetalle
	 */
	public void setCodigoFacturaDetalle(Long codigoFacturaDetalle) {
		this.codigoFacturaDetalle = codigoFacturaDetalle;
	}
	
}
