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
public class PedidoAreaTrabajoEstadoID implements Serializable {

	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	@Column(name = "CODIGOPEDARETRAEST")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECPEDARETRAEST")
	private Long codigoPedidoAreaTrabajoEstado;

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
	 * @return the codigoPedidoAreaTrabajoEstado
	 */
	public Long getCodigoPedidoAreaTrabajoEstado() {
		return codigoPedidoAreaTrabajoEstado;
	}

	/**
	 * @param codigoPedidoAreaTrabajoEstado the codigoPedidoAreaTrabajoEstado to set
	 */
	public void setCodigoPedidoAreaTrabajoEstado(Long codigoPedidoAreaTrabajoEstado) {
		this.codigoPedidoAreaTrabajoEstado = codigoPedidoAreaTrabajoEstado;
	}

}
