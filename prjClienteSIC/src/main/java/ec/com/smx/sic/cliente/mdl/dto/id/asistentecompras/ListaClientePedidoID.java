/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author dvillafuerte
 *
 */
@SuppressWarnings("serial")
public class ListaClientePedidoID implements Serializable{
	
	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSACSLISCLIPED")
	@Column(name = "CODIGOLISTACLIENTEPEDIDO", nullable = false)
	private Long codigoListaClientePedido;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoListaClientePedido() {
		return codigoListaClientePedido;
	}

	public void setCodigoListaClientePedido(Long codigoListaClientePedido) {
		this.codigoListaClientePedido = codigoListaClientePedido;
	}
}
