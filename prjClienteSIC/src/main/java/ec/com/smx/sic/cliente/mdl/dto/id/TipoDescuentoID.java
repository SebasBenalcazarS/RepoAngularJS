package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoDescuento
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.TipoDescuento
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoDescuentoID implements Serializable{

	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del tipo de descuento
	 * 
	 */
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSTIPDES")
	@Column(name = "CODIGOTIPODESCUENTO", nullable = false)
	private String codigoTipoDescuento;

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
	 * Retorna valor de propiedad <code>codigoTipoDescuento</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoDescuento</code>
	 */
	public String getCodigoTipoDescuento() {
		return this.codigoTipoDescuento;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoDescuento</code>.
	 * 
	 * @param codigoTipoDescuento1
	 *            El valor a establecer para la propiedad <code>codigoTipoDescuento</code>.
	 */
	public void setCodigoTipoDescuento(String codigoTipoDescuento1) {
		this.codigoTipoDescuento = codigoTipoDescuento1;

		if (codigoTipoDescuento != null && codigoTipoDescuento.length() > 5) {
			codigoTipoDescuento = codigoTipoDescuento.substring(0, 5);
		}

	}


}
