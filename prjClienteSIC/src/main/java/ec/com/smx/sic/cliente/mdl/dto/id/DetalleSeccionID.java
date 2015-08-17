
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
public class DetalleSeccionID implements Serializable {

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
	@Column(name = "CODIGODETALLESECCION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECDETSEC")
	private java.lang.Long codigoDetalleSeccion ;
		
	

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
	 * Retorna valor de propiedad <code>codigoDetalleSeccion</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoDetalleSeccion</code>
	 */
	public java.lang.Long getCodigoDetalleSeccion(){
		return this.codigoDetalleSeccion;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoDetalleSeccion</code>.
	 * @param codigoDetalleSeccion1 
	 *		El valor a establecer para la propiedad <code>codigoDetalleSeccion</code>.
	 */
	public void setCodigoDetalleSeccion( java.lang.Long codigoDetalleSeccion1 ){
		this.codigoDetalleSeccion=codigoDetalleSeccion1;
		
	}
}

