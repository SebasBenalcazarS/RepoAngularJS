package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@SuppressWarnings("serial")
@Embeddable
public class OrdenCompraRelacionadoID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable=false)
    private Integer codigoCompania;
   
    @Column(name = "CODIGOORDENCOMPRA", nullable=false)
    private Long codigoOrdenCompra;
   
    @Column(name = "CODIGOORDENCOMPRARELACIONADA")
    private Long codigoOrdenCompraRelacionada;

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

	public Long getCodigoOrdenCompraRelacionada() {
		return codigoOrdenCompraRelacionada;
	}

	public void setCodigoOrdenCompraRelacionada(Long codigoOrdenCompraRelacionada) {
		this.codigoOrdenCompraRelacionada = codigoOrdenCompraRelacionada;
	}
    
    
}
