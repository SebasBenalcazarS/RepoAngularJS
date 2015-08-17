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
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.EmbarqueDocumentoImpID;

/**
 * 
 * @author jcruz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTEMBDOC")
public class EmbarqueDocumentoImpDTO extends
		AuditoriaBaseDTO<EmbarqueDocumentoImpID> {

	@Column(name = "TIPODOCUMENTOTIPO")
	private Long codigoTipoDocCatTip;
	
	@Column(name = "TIPODOCUMENTOVALOR")
	private Long codigoTipoDocCatVal;
	
	@Column(name = "DATO")
	private String dato;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "TIPODOCUMENTOTIPO", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
			@JoinColumn(name = "TIPODOCUMENTOVALOR", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoDocumento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false)
	})
	private EmbarqueImpDTO embarque;

	/**
	 * @return the codigoTipoDocCatTip
	 */
	public Long getCodigoTipoDocCatTip() {
		return codigoTipoDocCatTip;
	}

	/**
	 * @param codigoTipoDocCatTip the codigoTipoDocCatTip to set
	 */
	public void setCodigoTipoDocCatTip(Long codigoTipoDocCatTip) {
		this.codigoTipoDocCatTip = codigoTipoDocCatTip;
	}

	/**
	 * @return the codigoTipoDocCatVal
	 */
	public Long getCodigoTipoDocCatVal() {
		return codigoTipoDocCatVal;
	}

	/**
	 * @param codigoTipoDocCatVal the codigoTipoDocCatVal to set
	 */
	public void setCodigoTipoDocCatVal(Long codigoTipoDocCatVal) {
		this.codigoTipoDocCatVal = codigoTipoDocCatVal;
	}

	/**
	 * @return the dato
	 */
	public String getDato() {
		return dato;
	}

	/**
	 * @param dato the dato to set
	 */
	public void setDato(String dato) {
		this.dato = dato;
	}

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

	/**
	 * @return the embarque
	 */
	public EmbarqueImpDTO getEmbarque() {
		return embarque;
	}

	/**
	 * @param embarque the embarque to set
	 */
	public void setEmbarque(EmbarqueImpDTO embarque) {
		this.embarque = embarque;
	}
	
}
