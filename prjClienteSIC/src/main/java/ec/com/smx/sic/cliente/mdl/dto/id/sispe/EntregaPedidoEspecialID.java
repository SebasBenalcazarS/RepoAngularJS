
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author esanchez
 */

@Embeddable
@SuppressWarnings("serial")
public class EntregaPedidoEspecialID extends BaseID {

	@SequenceDataBaseValue(name="SCSPESECENTPED",descriptorClass=DescriptorSecuenciasSIC.class)
	@Column(name = "CODIGOENTREGAPEDIDO")
	private java.lang.Long codigoEntregaPedido ;
		

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania ;


	public java.lang.Long getCodigoEntregaPedido() {
		return codigoEntregaPedido;
	}


	public void setCodigoEntregaPedido(java.lang.Long codigoEntregaPedido) {
		this.codigoEntregaPedido = codigoEntregaPedido;
	}


	public Integer getCodigoCompania() {
		return codigoCompania;
	}


	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
		
	
}

