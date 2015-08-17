package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
public class FuncionarioTipoMarcaID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

	@Column(name = "CODFUNTIPMAR", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECFUNTIPMAR")
    private Long codigoFuncionarioTipoMarca;

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
	 * @return the codigoFuncionarioTipoMarca
	 */
	public Long getCodigoFuncionarioTipoMarca() {
		return codigoFuncionarioTipoMarca;
	}

	/**
	 * @param codigoFuncionarioTipoMarca the codigoFuncionarioTipoMarca to set
	 */
	public void setCodigoFuncionarioTipoMarca(Long codigoFuncionarioTipoMarca) {
		this.codigoFuncionarioTipoMarca = codigoFuncionarioTipoMarca;
	}
}
