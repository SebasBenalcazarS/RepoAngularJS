package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DetalleRecepcionEntrega
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DetalleRecepcionEntregaDTO
 * 
 * @author lguaman
 */
@SuppressWarnings("serial")
@Embeddable
public class DetalleRecepcionEntregaID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Secuencial de la tabla DetalleRecepcionEntrega
	 * 
	 */
	@Column(name = "CODIGODETALLERECEPCIONENTREGA", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECDETRECENT")
	private java.lang.Long codigoDetalleRecepcionEntrega;

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

	/**
	 * @return the codigoDetalleRecepcionEntrega
	 */
	public java.lang.Long getCodigoDetalleRecepcionEntrega() {
		return codigoDetalleRecepcionEntrega;
	}

	/**
	 * @param codigoRecepcionFurgon the codigoDetalleRecepcionEntrega to set
	 */
	public void setCodigoDetalleRecepcionEntrega(java.lang.Long codigoDetalleRecepcionEntrega) {
		this.codigoDetalleRecepcionEntrega = codigoDetalleRecepcionEntrega;
	}

}
