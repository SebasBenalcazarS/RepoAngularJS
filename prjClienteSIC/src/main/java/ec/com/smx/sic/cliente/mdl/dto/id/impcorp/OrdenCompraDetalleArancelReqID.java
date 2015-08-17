/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * @author mchiliquinga
 *
 */
@Embeddable
public class OrdenCompraDetalleArancelReqID extends BaseID {

	private static final long serialVersionUID = -2187671458993032959L;
	
	@Column(name ="CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name ="CODIGOARANCELREQUISITO")
	private Long codigoArancelRequisito;
	
	@Column(name ="CODIGOORDENCOMPRADETALLE")
	private Long codigoOrdenCompraDetalle;
	
	@Column(name ="CODIGOORDENCOMPRA")
	private Long codigoOrdenCompra;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoArancelRequisito() {
		return codigoArancelRequisito;
	}

	public void setCodigoArancelRequisito(Long codigoArancelRequisito) {
		this.codigoArancelRequisito = codigoArancelRequisito;
	}

	public Long getCodigoOrdenCompraDetalle() {
		return codigoOrdenCompraDetalle;
	}

	public void setCodigoOrdenCompraDetalle(Long codigoOrdenCompraDetalle) {
		this.codigoOrdenCompraDetalle = codigoOrdenCompraDetalle;
	}

	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}
	
}
