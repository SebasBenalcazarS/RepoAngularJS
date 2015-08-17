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
public class OrdenCompraEstadoImpuestoID implements Serializable{
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania;
   
    @Column(name = "CODIGOORDCOMESTIMP", nullable = false)
    @SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECORDCOMESTIMP")
    private Long codigoOrdenCompraEstadoImpuesto;

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
	 * @return the codigoOrdenCompraEstadoImpuesto
	 */
	public Long getCodigoOrdenCompraEstadoImpuesto() {
		return codigoOrdenCompraEstadoImpuesto;
	}

	/**
	 * @param codigoOrdenCompraEstadoImpuesto the codigoOrdenCompraEstadoImpuesto to set
	 */
	public void setCodigoOrdenCompraEstadoImpuesto(Long codigoOrdenCompraEstadoImpuesto) {
		this.codigoOrdenCompraEstadoImpuesto = codigoOrdenCompraEstadoImpuesto;
	}
    
}
