
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase CalendarioBodegaEntregaProveedor
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class EntregaCalendarioBodegaProveedorID implements Serializable {




	/**
	 * codigo compania
	 *

	 */
	private Integer codigoCompania ;
		
	

	/**
	 * secuencial de la diferencia de precios.
	 *

	 */
	@Column(name = "CODIGOENTCALBODPRO")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCSPESECCALBODENTPRO")
	private java.lang.Long codigoEntregaCalendarioBodegaProveedor ;
		
	

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
	 * @return the codigoEntregaCalendarioBodegaProveedor
	 */
	public java.lang.Long getCodigoEntregaCalendarioBodegaProveedor() {
		return codigoEntregaCalendarioBodegaProveedor;
	}

	/**
	 * @param codigoEntregaCalendarioBodegaProveedor the codigoEntregaCalendarioBodegaProveedor to set
	 */
	public void setCodigoEntregaCalendarioBodegaProveedor(
			java.lang.Long codigoEntregaCalendarioBodegaProveedor) {
		this.codigoEntregaCalendarioBodegaProveedor = codigoEntregaCalendarioBodegaProveedor;
	}
		
}

