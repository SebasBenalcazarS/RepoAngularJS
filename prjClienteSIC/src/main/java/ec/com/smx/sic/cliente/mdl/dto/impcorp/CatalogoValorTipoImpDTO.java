package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.CatalogoValorTipoImpID;


@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTCATVALTIP")
public class CatalogoValorTipoImpDTO extends AuditoriaBaseDTO<CatalogoValorTipoImpID>{

	@Column(name="VALOR")
	private Double valor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCATALOGOVALOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCATALOGOTIPO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO catalogoValorImp;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOCONCEPTO", referencedColumnName = "CODIGOCONCEPTO", insertable = false, updatable = false)
	})
	private ConceptoCatalogoValorImpDTO conceptoCatalogoValorImp;

	
	/**
	 * @return the valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return the catalogoValorImp
	 */
	public CatalogoValorImpDTO getCatalogoValorImp() {
		return catalogoValorImp;
	}

	/**
	 * @param catalogoValorImp the catalogoValorImp to set
	 */
	public void setCatalogoValorImp(CatalogoValorImpDTO catalogoValorImp) {
		this.catalogoValorImp = catalogoValorImp;
	}
	/**
	 * 
	 * @return
	 */
	public ConceptoCatalogoValorImpDTO getConceptoCatalogoValorImp() {
		return conceptoCatalogoValorImp;
	}
	/**
	 * 
	 * @param conceptoCatalogoValorImp
	 */
	public void setConceptoCatalogoValorImp(ConceptoCatalogoValorImpDTO conceptoCatalogoValorImp) {
		this.conceptoCatalogoValorImp = conceptoCatalogoValorImp;
	}

	
}
