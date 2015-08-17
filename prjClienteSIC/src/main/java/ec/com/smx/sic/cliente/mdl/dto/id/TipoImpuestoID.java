package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoImpuestoArticulo
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.TipoImpuestoArticulo
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoImpuestoID implements Serializable {

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial para el tipo de impuesto
	 */
	@Column(name = "CODIGOTIPOIMPUESTO", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSTIPIMP")
	private Integer codigoTipoImpuesto;

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
	 * @return the codigoTipoImpuesto
	 */
	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}

	/**
	 * @param codigoTipoImpuesto the codigoTipoImpuesto to set
	 */
	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}


}