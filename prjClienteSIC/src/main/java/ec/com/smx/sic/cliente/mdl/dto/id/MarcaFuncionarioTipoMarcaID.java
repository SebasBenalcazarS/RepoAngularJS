package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

@SuppressWarnings("serial")
@Embeddable
public class MarcaFuncionarioTipoMarcaID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

	@Column(name = "CODMARFUNTIPMAR", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCADMSECMARFUNTIPMAR")
    private Long codigoMarcaFuncionarioTipoMarca;

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
	 * @return the codigoMarcaFuncionarioTipoMarca
	 */
	public Long getCodigoMarcaFuncionarioTipoMarca() {
		return codigoMarcaFuncionarioTipoMarca;
	}

	/**
	 * @param codigoMarcaFuncionarioTipoMarca the codigoMarcaFuncionarioTipoMarca to set
	 */
	public void setCodigoMarcaFuncionarioTipoMarca(Long codigoMarcaFuncionarioTipoMarca) {
		this.codigoMarcaFuncionarioTipoMarca = codigoMarcaFuncionarioTipoMarca;
	}
}
