
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase RecepcionProveedor
 * @see ec.com.smx.sic.cliente.mdl.dto.AsignacionProceso
 *
 * @author acaiza
 */
@SuppressWarnings("serial")
@Embeddable
public class RecepcionProveedorArticuloID implements Serializable{


	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;

	/**
	 * Secuencial de la tabla AsignacionProceso
	 *
	 */
	@Column(name = "CODIGORECEPCIONPROVEEDORARTICULO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECRECPROART" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoRecepcionProveedorArticulo ;
		
	

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
	 * @return the codigoRecepcionProveedorArticulo
	 */
	public Long getCodigoRecepcionProveedorArticulo() {
		return codigoRecepcionProveedorArticulo;
	}

	/**
	 * @param codigoRecepcionProveedorArticulo the codigoRecepcionProveedorArticulo to set
	 */
	public void setCodigoRecepcionProveedorArticulo(Long codigoRecepcionProveedorArticulo) {
		this.codigoRecepcionProveedorArticulo = codigoRecepcionProveedorArticulo;
	}

}

