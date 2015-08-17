
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase NovedadArticuloJustificacionDTO
 * @see ec.com.smx.sic.cliente.mdl.dto.NovedadArticuloJustificacionDTO
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class NovedadArticuloJustificacionID implements Serializable{

	/**
	 * Codigo de la compania
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Secuencial de la tabla NovedadArticuloJustificacionDTO
	 *

	 */
	@Column(name = "CODIGONOVEDADARTICULOJUSTIFICACION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECNOVARTJUS", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoNovedadArticuloJustificacion;
		
	

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
	 * @return the codigoNovedadArticuloJustificacion
	 */
	public Long getCodigoNovedadArticuloJustificacion() {
		return codigoNovedadArticuloJustificacion;
	}

	/**
	 * @param codigoNovedadArticuloJustificacion the codigoNovedadArticuloJustificacion to set
	 */
	public void setCodigoNovedadArticuloJustificacion(Long codigoNovedadArticuloJustificacion) {
		this.codigoNovedadArticuloJustificacion = codigoNovedadArticuloJustificacion;
	}

}

