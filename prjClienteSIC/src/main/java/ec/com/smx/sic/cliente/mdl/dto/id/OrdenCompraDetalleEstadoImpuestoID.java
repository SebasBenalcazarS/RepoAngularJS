/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class OrdenCompraDetalleEstadoImpuestoID implements Serializable{
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania;
   
    @Column(name = "CODIGOORDCOMDETESTIMP", nullable = false)
    @SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECORDCOMDETESTIMP")
    private Long codigoOrdenCompraDetalleEstadoImpuesto;

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
	 * @return the codigoOrdenCompraDetalleEstadoImpuesto
	 */
	public Long getCodigoOrdenCompraDetalleEstadoImpuesto() {
		return codigoOrdenCompraDetalleEstadoImpuesto;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstadoImpuesto the codigoOrdenCompraDetalleEstadoImpuesto to set
	 */
	public void setCodigoOrdenCompraDetalleEstadoImpuesto(Long codigoOrdenCompraDetalleEstadoImpuesto) {
		this.codigoOrdenCompraDetalleEstadoImpuesto = codigoOrdenCompraDetalleEstadoImpuesto;
	}
    
}
