package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
@SuppressWarnings("serial")
@Embeddable
public class OrdenCompraID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable=false)
    private Integer codigoCompania;
   
    @Column(name = "CODIGOORDENCOMPRA", nullable=false)
    @SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCORCSECORDCOM")
    private Long codigoOrdenCompra;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}
    
    
}
