
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Seccion
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.SeccionDTO
 * 
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Embeddable
public class SeccionID implements Serializable {

	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el codigo de la seccion
	 *
	 */
	@Column(name = "CODIGOSECCION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECSECCION")
	private Long codigoSeccion ;
		
	

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
	 * Retorna valor de propiedad <code>codigoSeccion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoSeccion</code>
	 */
	public Long getCodigoSeccion(){
		return this.codigoSeccion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoSeccion</code>.
	 * @param codigoSeccion1 
	 *		El valor a establecer para la propiedad <code>codigoSeccion</code>.
	 */
	public void setCodigoSeccion(Long codigoSeccion1 ){
		this.codigoSeccion=codigoSeccion1;
		
	}
}

