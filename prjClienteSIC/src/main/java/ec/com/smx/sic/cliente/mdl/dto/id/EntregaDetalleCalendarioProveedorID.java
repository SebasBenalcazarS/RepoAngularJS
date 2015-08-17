
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
public class EntregaDetalleCalendarioProveedorID implements Serializable {

	/**
	 * codigo compania
	 *

	 */
	private Integer codigoCompania ;
		
	

	/**
	 * secuencial de la tabla EntregaDetalleCalendarioProveedor
	 *

	 */
	@Column(name = "CODIGOENTREGADETALLECALENDARIOPROVEEDOR")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SCFDISECENTDETCALPRO")
	private java.lang.Long codigoDetEntHorCalPro ;
		
	

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
	 * @return the codigoDetEntHorCalPro
	 */
	public java.lang.Long getCodigoDetEntHorCalPro() {
		return codigoDetEntHorCalPro;
	}

	/**
	 * @param codigoDetEntHorCalPro the codigoDetEntHorCalPro to set
	 */
	public void setCodigoDetEntHorCalPro(java.lang.Long codigoDetEntHorCalPro) {
		this.codigoDetEntHorCalPro = codigoDetEntHorCalPro;
	}

}

