
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase GrupoMovimiento
 * @see ec.com.smx.sic.sispe.dto.GrupoMovimiento
 * @author osaransig
 * 21/06/2012
 */
@SuppressWarnings("serial")
@Embeddable
public class GrupoMovimientoID extends BaseID implements Serializable {




	/**
	 * secuencia de base 
	 *

	 */
	@SequenceDataBaseValue(name="SCSPESECGRUMOV", descriptorClass= DescriptorSecuenciasSIC.class)
	@Column(name = "CODIGOGRUPOMOVIMIENTO")
	private java.lang.Long codigoGrupoMovimiento ;
		
	

	/**
	 * Retorna valor de propiedad <code>codigoGrupoMovimiento</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoGrupoMovimiento</code>
	 */
	public java.lang.Long getCodigoGrupoMovimiento(){
		return this.codigoGrupoMovimiento;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoGrupoMovimiento</code>.
	 * @param codigoGrupoMovimiento1 
	 *		El valor a establecer para la propiedad <code>codigoGrupoMovimiento</code>.
	 */
	public void setCodigoGrupoMovimiento( java.lang.Long codigoGrupoMovimiento1 ){
		this.codigoGrupoMovimiento=codigoGrupoMovimiento1;
		
	}


}

