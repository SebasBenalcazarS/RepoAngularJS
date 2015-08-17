
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase EntregaDetalleCalendarioBodegaProveedor
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Embeddable
public class EntregaHoraCalendarioProveedorID implements Serializable {

	/**
	 * codigo compania
	 *

	 */
	private Integer codigoCompania ;
		
	

	/**
	 * secuencial de la tabla EntregaDetalleCalendarioProveedor
	 *

	 */
	@Column(name = "CODIGOENTREGAHORACALENDARIOPROVEEDOR", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCFDISECENTHORCALPRO")
	private java.lang.Long codigoEntregaHoraCalendarioProveedor ;
		
	

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
	 * @return the codigoEntregaHoraCalendarioProveedor
	 */
	public java.lang.Long getCodigoEntregaHoraCalendarioProveedor() {
		return codigoEntregaHoraCalendarioProveedor;
	}

	/**
	 * @param codigoEntregaHoraCalendarioProveedor the codigoEntregaHoraCalendarioProveedor to set
	 */
	public void setCodigoEntregaHoraCalendarioProveedor(java.lang.Long codigoEntregaHoraCalendarioProveedor) {
		this.codigoEntregaHoraCalendarioProveedor = codigoEntregaHoraCalendarioProveedor;
	}

}

