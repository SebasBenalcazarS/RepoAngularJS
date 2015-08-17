
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ProveedorDetalleSeccionDTO
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ProveedorDetalleSeccionDTO
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Embeddable
public class ProveedorDetalleSeccionID implements Serializable {

	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el codigo del detalle de la seccion
	 *
	 */
	@Column(name = "CODIGOPROVEEDORDETALLESECCION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECPRODETSEC")
	private java.lang.Long codigoProveedorDetalleSeccion ;

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
	 * @return the codigoProveedorDetalleSeccion
	 */
	public java.lang.Long getCodigoProveedorDetalleSeccion() {
		return codigoProveedorDetalleSeccion;
	}

	/**
	 * @param codigoProveedorDetalleSeccion the codigoProveedorDetalleSeccion to set
	 */
	public void setCodigoProveedorDetalleSeccion(java.lang.Long codigoProveedorDetalleSeccion) {
		this.codigoProveedorDetalleSeccion = codigoProveedorDetalleSeccion;
	}

}

