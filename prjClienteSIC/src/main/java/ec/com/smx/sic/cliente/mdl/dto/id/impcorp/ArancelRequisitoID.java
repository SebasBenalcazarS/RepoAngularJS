/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

/**
 * @author rhidalgo
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class ArancelRequisitoID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOARANCEL")
	private Long codigoArancel;
	
	@Column(name = "CODIGOARANCELREQUISITO")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECARANREQ")
	private Long codigoArancelRequisito;

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
	 * @return the codigoArancel
	 */
	public Long getCodigoArancel() {
		return codigoArancel;
	}

	/**
	 * @param codigoArancel the codigoArancel to set
	 */
	public void setCodigoArancel(Long codigoArancel) {
		this.codigoArancel = codigoArancel;
	}

	/**
	 * @return the codigoArancelRequisito
	 */
	public Long getCodigoArancelRequisito() {
		return codigoArancelRequisito;
	}

	/**
	 * @param codigoArancelRequisito the codigoArancelRequisito to set
	 */
	public void setCodigoArancelRequisito(Long codigoArancelRequisito) {
		this.codigoArancelRequisito = codigoArancelRequisito;
	}

	
	
}
