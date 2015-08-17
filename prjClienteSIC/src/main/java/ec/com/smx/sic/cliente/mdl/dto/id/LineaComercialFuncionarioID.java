/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jvillacis
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class LineaComercialFuncionarioID implements Serializable {
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

	@Column(name = "CODIGOFUNCIONARIO", nullable = false)
	private String codigoFuncionario;
	
	@Column(name = "CODLINCOMFUN", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECLINCOMFUN")
	private Long codigoLineaComercialFuncionario;

	
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
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	/**
	 * @return the codigoLineaComercialFuncionario
	 */
	public Long getCodigoLineaComercialFuncionario() {
		return codigoLineaComercialFuncionario;
	}

	/**
	 * @param codigoLineaComercialFuncionario the codigoLineaComercialFuncionario to set
	 */
	public void setCodigoLineaComercialFuncionario(
			Long codigoLineaComercialFuncionario) {
		this.codigoLineaComercialFuncionario = codigoLineaComercialFuncionario;
	}
	
}
