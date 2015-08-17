
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;
/**
 * Clase que encapsula a las propiedades Identificadoras de la clase CaracteristicaDinamicaDTO
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloRelacion
 *
 * @author kruger
 */
@Embeddable
@SuppressWarnings("serial")
public class CaracteristicaDinamicaID implements Serializable {


	public CaracteristicaDinamicaID() {}
	
	/**
	 * Código de la característica dinámica
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSCARDIN")
	@Column(name = "SECUENCIALCARDIN", nullable = false)
	private java.lang.Long secuencialCaracteristicaDinamica;


	/**
	 * @return the secuencialCaracteristicaDinamica
	 */
	public java.lang.Long getSecuencialCaracteristicaDinamica() {
		return secuencialCaracteristicaDinamica;
	}

	/**
	 * @param secuencialCaracteristicaDinamica the secuencialCaracteristicaDinamica to set
	 */
	public void setSecuencialCaracteristicaDinamica(
			java.lang.Long secuencialCaracteristicaDinamica) {
		this.secuencialCaracteristicaDinamica = secuencialCaracteristicaDinamica;
	}
}

