
package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.mdl.dto.interfaces.IBaseEntidadID;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;



/**
 * Clase que encapsula a las propiedades Identificadoras de la clase OficinaExterior
 * @see ec.com.smx.sic.cliente.mdl.dto.OficinaExterior
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class OficinaExteriorID implements IBaseEntidadID{




	/**
	 * Codigo de la compañía
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Codigo de la Oficina Exterior
	 *

	 */
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSOFIEXT")
	@Column(name = "CODIGOOFICINAEXTERIOR", nullable = false)
	private Integer codigoOficinaExterior ;
		
	

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
	 * Retorna valor de propiedad <code>codigoOficinaExterior</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoOficinaExterior</code>
	 */
	public Integer getCodigoOficinaExterior(){
		return this.codigoOficinaExterior;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoOficinaExterior</code>.
	 * @param codigoOficinaExterior1 
	 *		El valor a establecer para la propiedad <code>codigoOficinaExterior</code>.
	 */
	public void setCodigoOficinaExterior( Integer codigoOficinaExterior1 ){
		this.codigoOficinaExterior=codigoOficinaExterior1;
		
	}

		
}

