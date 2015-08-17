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
public class OrdenCompraDetalleImpID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOORDENCOMPRA")
	private Long codigoOrdenCompra;
	
	@Column(name = "CODIGOORDENCOMPRADETALLE")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECORDCOMDET")
	private Long codigoOrdenCompraDetalle;
	
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
	 * @return devuelve el valor de la propiedad codigoOrdenCompra
	 */
	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	/**
	 * @param codigoOrdenCompra establece el valor a la propiedad codigoOrdenCompra
	 */
	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoOrdenCompraDetalle
	 */
	public Long getCodigoOrdenCompraDetalle() {
		return codigoOrdenCompraDetalle;
	}

	/**
	 * @param codigoOrdenCompraDetalle establece el valor a la propiedad codigoOrdenCompraDetalle
	 */
	public void setCodigoOrdenCompraDetalle(Long codigoOrdenCompraDetalle) {
		this.codigoOrdenCompraDetalle = codigoOrdenCompraDetalle;
	}
	
}
