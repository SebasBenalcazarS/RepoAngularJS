
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;


/**
 * Clase que encapsula a las propiedades Identificadoras de la clase TipoStock
 * @see ec.com.smx.sic.sispe.dto.TipoStock
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoStockID extends BaseID implements Serializable {




	/**
	 * codigoCompania
	 *

	 */
	@Column (name = "CODIGOCOMPANIA")
	private Integer codigoCompania ;
		
	

	/**
	 * secuencial de base
	 *

	 */
	@SequenceDataBaseValue(name="SCSPESECTIPSTO", descriptorClass=DescriptorSecuenciasSIC.class)
	@Column (name = "CODIGOTIPOSTOCK")
	private java.lang.Long codigoTipoStock ;
		
	

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
	 * Retorna valor de propiedad <code>codigoTipoStock</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoTipoStock</code>
	 */
	public java.lang.Long getCodigoTipoStock(){
		return this.codigoTipoStock;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoStock</code>.
	 * @param codigoTipoStock1 
	 *		El valor a establecer para la propiedad <code>codigoTipoStock</code>.
	 */
	public void setCodigoTipoStock( java.lang.Long codigoTipoStock1 ){
		this.codigoTipoStock=codigoTipoStock1;
		
	}

}

