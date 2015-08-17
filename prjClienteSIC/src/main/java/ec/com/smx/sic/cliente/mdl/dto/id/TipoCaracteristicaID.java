package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoCaracteristica
 * 
 * @see ec.com.smx.sic.adm.dto.TipoCaracteristica
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoCaracteristicaID implements Serializable {

	/**
	 * Codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Codigo del tipo de caracteristica
	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSTIPCAR")
	@Column(name = "CODIGOTIPOCARACTERSTICA", nullable = false)
	private Integer codigoTipoCaracterstica;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoCaracterstica</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoCaracterstica</code>
	 */
	public Integer getCodigoTipoCaracterstica() {
		return this.codigoTipoCaracterstica;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoCaracterstica</code>.
	 * 
	 * @param codigoTipoCaracterstica1
	 *            El valor a establecer para la propiedad <code>codigoTipoCaracterstica</code>.
	 */
	public void setCodigoTipoCaracterstica(Integer codigoTipoCaracterstica1) {
		this.codigoTipoCaracterstica = codigoTipoCaracterstica1;

	}

}
