package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
@SuppressWarnings("serial")
@Embeddable
public class OrdenCompraDetalleEstadoDescuentoID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable=false)
    private Integer codigoCompania;
   
    @Column(name = "CODIGOORDCOMDETESTDES", nullable=false)
    @SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECORDCOMDETESTDES")
    private Long codigoOrdenCompraDetalleEstadoDescuento;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoOrdenCompraDetalleEstadoDescuento
	 */
	public Long getCodigoOrdenCompraDetalleEstadoDescuento() {
		return codigoOrdenCompraDetalleEstadoDescuento;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstadoDescuento the codigoOrdenCompraDetalleEstadoDescuento to set
	 */
	public void setCodigoOrdenCompraDetalleEstadoDescuento(Long codigoOrdenCompraDetalleEstadoDescuento) {
		this.codigoOrdenCompraDetalleEstadoDescuento = codigoOrdenCompraDetalleEstadoDescuento;
	}
	   
}
