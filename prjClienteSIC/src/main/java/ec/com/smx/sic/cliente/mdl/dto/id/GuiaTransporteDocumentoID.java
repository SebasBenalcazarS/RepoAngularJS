
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase GuiaTransporteDocumento
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.GuiaTransporteDocumentoDTO
 * 
 * @author egudino
 */
@SuppressWarnings("serial")
@Embeddable
public class GuiaTransporteDocumentoID implements Serializable {

	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private java.lang.Integer codigoCompania;
		
	/**
	 * Especifica el codigo del detalle de la seccion
	 *
	 */
	@Column(name = "SECUENCIAGUIATRADOC", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECGUITRADOC")
	private java.lang.Long secuenciaGuiaDocumento;

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
	 * @return the secuenciaGuiaDocumento
	 */
	public java.lang.Long getSecuenciaGuiaDocumento() {
		return secuenciaGuiaDocumento;
	}

	/**
	 * @param secuenciaGuiaDocumento the secuenciaGuiaDocumento to set
	 */
	public void setSecuenciaGuiaDocumento(java.lang.Long secuenciaGuiaDocumento) {
		this.secuenciaGuiaDocumento = secuenciaGuiaDocumento;
	}

}

