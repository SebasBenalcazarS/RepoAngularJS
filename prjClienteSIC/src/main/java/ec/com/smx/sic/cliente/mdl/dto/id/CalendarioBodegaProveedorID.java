package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author kruger
 *
 */

@SuppressWarnings("serial")
@Embeddable

public class CalendarioBodegaProveedorID implements Serializable {

	/**
	 * secuencial de base
	 * 
	 */
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSPESECCALBODPRO")
	private java.lang.Long codigoCalBodPro;

	/**
	 * codigo compania
	 * 
	 */
	private Integer codigoCompania;

	/**
	 * Retorna valor de propiedad <code>codigoCalBodPro</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCalBodPro</code>
	 */
	public java.lang.Long getCodigoCalBodPro() {
		return this.codigoCalBodPro;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCalBodPro</code>.
	 * 
	 * @param codigoCalBodPro1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoCalBodPro</code>.
	 */
	public void setCodigoCalBodPro(java.lang.Long codigoCalBodPro1) {
		this.codigoCalBodPro = codigoCalBodPro1;

	}

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
	 *            El valor a establecer para la propiedad
	 *            <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

}
