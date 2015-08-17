
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Temporada
 * @see ec.com.smx.sic.sispe.dto.Temporada
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Embeddable
public class TemporadaID extends BaseID implements Serializable {




	/**
	 * Código de companía
	 *

	 */
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania ;
		
	

	/**
	 * Código de la temporada, secuencial de base
	 *

	 */
	@SequenceDataBaseValue(name="SCSPESECTEMPORADA", descriptorClass= DescriptorSecuenciasSIC.class)
	@Column(name = "CODIGOTEMPORADA")
	private java.lang.Long codigoTemporada ;
		
	

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
	 * Retorna valor de propiedad <code>codigoTemporada</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTemporada</code>
	 */
	public java.lang.Long getCodigoTemporada(){
		return this.codigoTemporada;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTemporada</code>.
	 * @param codigoTemporada1 
	 *		El valor a establecer para la propiedad <code>codigoTemporada</code>.
	 */
	public void setCodigoTemporada( java.lang.Long codigoTemporada1 ){
		this.codigoTemporada=codigoTemporada1;
		
	}


}

