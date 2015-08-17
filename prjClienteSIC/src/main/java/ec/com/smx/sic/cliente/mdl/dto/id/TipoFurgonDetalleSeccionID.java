
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
public class TipoFurgonDetalleSeccionID implements Serializable {

	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
		
	/**
	 * Especifica el codigo del detalle de la seccion
	 *
	 */
	@Column(name = "CODIGOTIPOFURGONDETALLESECCION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECTIPFURDETSEC")
	private java.lang.Long codigoTipoFurgonDetalleSeccion;

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
	 * @return the codigoTipoFurgonDetalleSeccion
	 */
	public java.lang.Long getCodigoTipoFurgonDetalleSeccion() {
		return codigoTipoFurgonDetalleSeccion;
	}

	/**
	 * @param codigoTipoFurgonDetalleSeccion the codigoTipoFurgonDetalleSeccion to set
	 */
	public void setCodigoTipoFurgonDetalleSeccion(java.lang.Long codigoTipoFurgonDetalleSeccion) {
		this.codigoTipoFurgonDetalleSeccion = codigoTipoFurgonDetalleSeccion;
	}

}

