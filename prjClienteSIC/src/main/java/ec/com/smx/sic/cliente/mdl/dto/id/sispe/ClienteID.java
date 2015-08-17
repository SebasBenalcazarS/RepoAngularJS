/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author osaransig
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class ClienteID extends BaseID {
	
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	
	@SequenceDataBaseValue(name="SCSPESECCLIPED",descriptorClass=DescriptorSecuenciasSIC.class)
	@Column(name = "CODIGOCLIENTEPEDIDO")
	private Long codigoClientePedido;
	
	/**
	 * @return el codigoCliente
	 */
	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}
	/**
	 * @param codigoCliente el codigoCliente a establecer
	 */
	public void setCodigoClientePedido(Long codigoCliente) {
		this.codigoClientePedido = codigoCliente;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	
}
