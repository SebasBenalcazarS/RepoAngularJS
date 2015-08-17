
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase GuiaTransporte
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.GuiaTransporteDTO
 * 
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Embeddable
public class GuiaTransporteID implements Serializable {

	/**
	 * C�digo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private java.lang.Integer codigoCompania;
		
	/**
	 * Especifica el codigo del detalle de la seccion
	 *
	 */
	@Column(name = "SECUENCIAGUIA", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECGUITRA")
	private java.lang.Long secuenciaGuia;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania(){
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania1 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania( Integer codigoCompania1 ){
		this.codigoCompania=codigoCompania1;
		
	}

	/**
	 * @return the secuenciaGuia
	 */
	public java.lang.Long getSecuenciaGuia() {
		return secuenciaGuia;
	}

	/**
	 * @param secuenciaGuia the secuenciaGuia to set
	 */
	public void setSecuenciaGuia(java.lang.Long secuenciaGuia) {
		this.secuenciaGuia = secuenciaGuia;
	}
}

