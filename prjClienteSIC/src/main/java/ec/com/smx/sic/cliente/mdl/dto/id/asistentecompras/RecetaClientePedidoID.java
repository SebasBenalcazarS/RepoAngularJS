package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import java.io.Serializable;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author cgalarza
 *
 */
@SuppressWarnings("serial")
public class RecetaClientePedidoID implements Serializable{
	/**
	 * Codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSACSRECCLIPED")
	@Column(name = "CODIGORECETACLIENTEPEDIDO", nullable = false)
	private Integer codigoRecetaClientePedido;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoRecetaClientePedido
	 */
	public Integer getCodigoRecetaClientePedido() {
		return codigoRecetaClientePedido;
	}

	/**
	 * @param codigoRecetaClientePedido the codigoRecetaClientePedido to set
	 */
	public void setCodigoRecetaClientePedido(Integer codigoRecetaClientePedido) {
		this.codigoRecetaClientePedido = codigoRecetaClientePedido;
	}
	
}
