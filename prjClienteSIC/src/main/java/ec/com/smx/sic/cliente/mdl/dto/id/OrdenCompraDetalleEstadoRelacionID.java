package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author acaiza
 *
 */

@SuppressWarnings("serial")
@Embeddable
public class OrdenCompraDetalleEstadoRelacionID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable=false)
    private Integer codigoCompania;
   
    @Column(name = "CODIGOORDENCOMPRADETALLEESTADORELACION", nullable=false)
    @SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECORDCOMDETESTREL")
    private Long codigoOrdenCompraDetalleEstadoRelacion;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoOrdenCompraDetalleEstadoRelacion() {
		return codigoOrdenCompraDetalleEstadoRelacion;
	}

	public void setCodigoOrdenCompraDetalleEstadoRelacion(Long codigoOrdenCompraDetalleEstadoRelacion) {
		this.codigoOrdenCompraDetalleEstadoRelacion = codigoOrdenCompraDetalleEstadoRelacion;
	}

}
