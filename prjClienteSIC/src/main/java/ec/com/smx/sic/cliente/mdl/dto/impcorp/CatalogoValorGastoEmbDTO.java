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
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.CatalogoValorGastoEmbID;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTCATVALGASEMB")
public class CatalogoValorGastoEmbDTO extends AuditoriaBaseDTO<CatalogoValorGastoEmbID>{

	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODOCCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGODOCCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO catalogoValor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOGASTOEMBARQUE", referencedColumnName = "CODIGOGASTOEMBARQUE", insertable = false, updatable = false)
	})
	private GastoEmbarqueDTO gasto;

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
	 * @return the catalogoValor
	 */
	public CatalogoValorImpDTO getCatalogoValor() {
		return catalogoValor;
	}

	/**
	 * @param catalogoValor the catalogoValor to set
	 */
	public void setCatalogoValor(CatalogoValorImpDTO catalogoValor) {
		this.catalogoValor = catalogoValor;
	}

	/**
	 * @return the gasto
	 */
	public GastoEmbarqueDTO getGasto() {
		return gasto;
	}

	/**
	 * @param gasto the gasto to set
	 */
	public void setGasto(GastoEmbarqueDTO gasto) {
		this.gasto = gasto;
	}
}
