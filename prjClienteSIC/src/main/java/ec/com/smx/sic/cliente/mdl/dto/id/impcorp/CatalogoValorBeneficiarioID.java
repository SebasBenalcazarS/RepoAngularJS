package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * @author aguato
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class CatalogoValorBeneficiarioID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOCATALOGOVALOR")
	private Long codigoCatalogoValor;
	
	@Column(name = "CODIGOCATALOGOTIPO")
	private Long codigoCatalogoTipo;
	
	@Column(name = "CODIGOCATALOGOTIPOREL")
	private Long codigoCatalogoTipoRel;

	/**
	 * @return the codigoCatalogoValor
	 */
	public Long getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}

	/**
	 * @param codigoCatalogoValor the codigoCatalogoValor to set
	 */
	public void setCodigoCatalogoValor(Long codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}

	/**
	 * @return the codigoCatalogoTipo
	 */
	public Long getCodigoCatalogoTipo() {
		return codigoCatalogoTipo;
	}

	/**
	 * @param codigoCatalogoTipo the codigoCatalogoTipo to set
	 */
	public void setCodigoCatalogoTipo(Long codigoCatalogoTipo) {
		this.codigoCatalogoTipo = codigoCatalogoTipo;
	}

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
	 * @return the codigoCatalogoTipoRel
	 */
	public Long getCodigoCatalogoTipoRel() {
		return codigoCatalogoTipoRel;
	}

	/**
	 * @param codigoCatalogoTipoRel the codigoCatalogoTipoRel to set
	 */
	public void setCodigoCatalogoTipoRel(Long codigoCatalogoTipoRel) {
		this.codigoCatalogoTipoRel = codigoCatalogoTipoRel;
	}
}
