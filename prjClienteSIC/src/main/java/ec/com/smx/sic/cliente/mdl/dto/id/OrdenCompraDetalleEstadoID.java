package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
@SuppressWarnings("serial")
@Embeddable
public class OrdenCompraDetalleEstadoID implements Serializable {
	@Column(name = "CODIGOCOMPANIA", nullable=false)
    private Integer codigoCompania;
   
    @Column(name = "CODIGOORDENCOMPRADETALLEESTADO", nullable=false)
    @SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECORDCOMDETEST")
    private Long codigoOrdenCompraDetalleEstado;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	public void setCodigoOrdenCompraDetalleEstado(
			Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}
}
