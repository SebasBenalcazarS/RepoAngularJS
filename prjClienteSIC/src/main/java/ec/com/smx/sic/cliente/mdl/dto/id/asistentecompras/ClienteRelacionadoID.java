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
public class ClienteRelacionadoID implements Serializable{

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	
	/**
	 * Código del cliente lista relacionada
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSACSCLIREL")
	@Column(name = "CODIGOCLIENTERELACIONADO", nullable = false)
	private Long codigoClienteRelacionado;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoClienteRelacionado() {
		return codigoClienteRelacionado;
	}

	public void setCodigoClienteRelacionado(Long codigoClienteRelacionado) {
		this.codigoClienteRelacionado = codigoClienteRelacionado;
	}

}
