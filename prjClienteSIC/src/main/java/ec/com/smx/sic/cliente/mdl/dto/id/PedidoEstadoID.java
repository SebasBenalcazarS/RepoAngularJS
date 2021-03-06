package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class PedidoEstadoID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
	
	@Column(name = "CODIGOPEDIDOESTADO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECPEDEST")
	private Long codigoPedidoEstado;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoPedidoEstado() {
		return codigoPedidoEstado;
	}

	public void setCodigoPedidoEstado(Long codigoPedidoEstado) {
		this.codigoPedidoEstado = codigoPedidoEstado;
	}
	
}
