/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.ObservacionImpID;

/**
 * @author jcruz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTOBSERVACION")
public class ObservacionImpDTO extends AuditoriaBaseDTO<ObservacionImpID> {

	@Column(name="OBSERVACION")
	private String observacion;
	
	@Column(name="CODIGOTIPOOBSERVACIONCATTIP")
	private Long codigoTipoObservacionCatTip;
	
	@Column(name="CODIGOTIPOOBSERVACIONCATVAL")
	private Long codigoTipoObservacionCatVal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false)
	})
	private EmbarqueImpDTO embarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOTIPOOBSERVACIONCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOTIPOOBSERVACIONCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoObservacion;
	
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	/**
	 * @return the codigoTipoObservacionCatTip
	 */
	public Long getCodigoTipoObservacionCatTip() {
		return codigoTipoObservacionCatTip;
	}

	/**
	 * @param codigoTipoObservacionCatTip the codigoTipoObservacionCatTip to set
	 */
	public void setCodigoTipoObservacionCatTip(Long codigoTipoObservacionCatTip) {
		this.codigoTipoObservacionCatTip = codigoTipoObservacionCatTip;
	}

	/**
	 * @return the codigoTipoObservacionCatVal
	 */
	public Long getCodigoTipoObservacionCatVal() {
		return codigoTipoObservacionCatVal;
	}

	/**
	 * @param codigoTipoObservacionCatVal the codigoTipoObservacionCatVal to set
	 */
	public void setCodigoTipoObservacionCatVal(Long codigoTipoObservacionCatVal) {
		this.codigoTipoObservacionCatVal = codigoTipoObservacionCatVal;
	}

	/**
	 * @return the tipoObservacion
	 */
	public CatalogoValorImpDTO getTipoObservacion() {
		return tipoObservacion;
	}

	/**
	 * @param tipoObservacion the tipoObservacion to set
	 */
	public void setTipoObservacion(CatalogoValorImpDTO tipoObservacion) {
		this.tipoObservacion = tipoObservacion;
	}

}
