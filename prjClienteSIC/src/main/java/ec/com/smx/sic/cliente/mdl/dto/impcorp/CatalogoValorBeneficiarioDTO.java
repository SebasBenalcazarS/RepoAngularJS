package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.CatalogoValorBeneficiarioID;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTCATVALREL")
public class CatalogoValorBeneficiarioDTO extends AuditoriaBaseDTO<CatalogoValorBeneficiarioID>{
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCATALOGOTIPOREL", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoTipoImpDTO beneficiario; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCATALOGOTIPO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCATALOGOVALOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoDocumento;
	
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the beneficiario
	 */
	public CatalogoTipoImpDTO getBeneficiario() {
		return beneficiario;
	}

	/**
	 * @param beneficiario the beneficiario to set
	 */
	public void setBeneficiario(CatalogoTipoImpDTO beneficiario) {
		this.beneficiario = beneficiario;
	}

	/**
	 * @return the tipoDocumento
	 */
	public CatalogoValorImpDTO getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(CatalogoValorImpDTO tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
}
