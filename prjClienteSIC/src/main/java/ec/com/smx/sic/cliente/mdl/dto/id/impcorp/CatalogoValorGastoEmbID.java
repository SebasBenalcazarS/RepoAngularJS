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
public class CatalogoValorGastoEmbID extends BaseID{

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGODOCCATVAL")
	private Long codigoDocumentoCatalogoValor;
	
	@Column(name = "CODIGODOCCATTIP")
	private Long codigoDocumentoCatalogoTipo;
	
	@Column(name = "CODIGOGASTOEMBARQUE")
	private Long codigoGastoEmbarque;

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
	 * @return the codigoDocumentoCatalogoValor
	 */
	public Long getCodigoDocumentoCatalogoValor() {
		return codigoDocumentoCatalogoValor;
	}

	/**
	 * @param codigoDocumentoCatalogoValor the codigoDocumentoCatalogoValor to set
	 */
	public void setCodigoDocumentoCatalogoValor(Long codigoDocumentoCatalogoValor) {
		this.codigoDocumentoCatalogoValor = codigoDocumentoCatalogoValor;
	}

	/**
	 * @return the codigoDocumentoCatalogoTipo
	 */
	public Long getCodigoDocumentoCatalogoTipo() {
		return codigoDocumentoCatalogoTipo;
	}

	/**
	 * @param codigoDocumentoCatalogoTipo the codigoDocumentoCatalogoTipo to set
	 */
	public void setCodigoDocumentoCatalogoTipo(Long codigoDocumentoCatalogoTipo) {
		this.codigoDocumentoCatalogoTipo = codigoDocumentoCatalogoTipo;
	}

	/**
	 * @return the codigoGastoEmbarque
	 */
	public Long getCodigoGastoEmbarque() {
		return codigoGastoEmbarque;
	}

	/**
	 * @param codigoGastoEmbarque the codigoGastoEmbarque to set
	 */
	public void setCodigoGastoEmbarque(Long codigoGastoEmbarque) {
		this.codigoGastoEmbarque = codigoGastoEmbarque;
	}
}
