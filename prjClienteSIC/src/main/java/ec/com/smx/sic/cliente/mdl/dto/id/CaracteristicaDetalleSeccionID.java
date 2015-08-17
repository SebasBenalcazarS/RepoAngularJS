
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase DetalleSeccion
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.DetalleSeccionDTO
 * 
 * @author fcollaguazo
 */
@SuppressWarnings("serial")
@Embeddable
public class CaracteristicaDetalleSeccionID implements Serializable {

	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el codigo del detalle de la seccion
	 *

	 */
	@Column(name = "CODIGODETALLESECCION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECCARDETSEC")
	private java.lang.Long codigoCaracteristicaDetalleSeccion ;
		
	

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
	 * @return the codigoCaracteristicaDetalleSeccion
	 */
	public java.lang.Long getCodigoCaracteristicaDetalleSeccion() {
		return codigoCaracteristicaDetalleSeccion;
	}

	/**
	 * @param codigoCaracteristicaDetalleSeccion the codigoCaracteristicaDetalleSeccion to set
	 */
	public void setCodigoCaracteristicaDetalleSeccion(java.lang.Long codigoCaracteristicaDetalleSeccion) {
		this.codigoCaracteristicaDetalleSeccion = codigoCaracteristicaDetalleSeccion;
	}

	
}

