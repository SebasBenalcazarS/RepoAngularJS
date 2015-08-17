
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DefinicionEstructuraLogistica
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DefinicionEstructuraLogisticaDTO
 * 
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Embeddable
public class DefinicionEstructuraLogisticaID implements Serializable {

	/**
	 * Código de la compania
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el codigo de la definicion de la estructura logistica
	 *

	 */
	@Column(name = "CODIGODEFINICIONESTLOG", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECDEFESTLOG")
	private java.lang.Long codigoDefinicionEstLog ;
		
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
	 * @return the codigoDefinicionEstLog
	 */
	public java.lang.Long getCodigoDefinicionEstLog() {
		return codigoDefinicionEstLog;
	}

	/**
	 * @param codigoDefinicionEstLog the codigoDefinicionEstLog to set
	 */
	public void setCodigoDefinicionEstLog(java.lang.Long codigoDefinicionEstLog) {
		this.codigoDefinicionEstLog = codigoDefinicionEstLog;
	}

	
}

