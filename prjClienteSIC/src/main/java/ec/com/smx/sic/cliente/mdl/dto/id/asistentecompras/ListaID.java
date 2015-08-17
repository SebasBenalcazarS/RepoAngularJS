/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.asistentecompras;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author dvillafuerte
 * 
 */
@Embeddable
@SuppressWarnings("serial")
public class ListaID extends BaseID {

	/**
	 * C�digo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSACSLISTA")
	@Column(name = "CODIGOLISTA")
	private Long codigoLista;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoLista() {
		return codigoLista;
	}

	public void setCodigoLista(Long codigoLista) {
		this.codigoLista = codigoLista;
	}

}
