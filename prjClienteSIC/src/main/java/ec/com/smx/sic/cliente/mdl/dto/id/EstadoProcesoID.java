
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase EstadoProceso
 * @see ec.com.smx.sic.cliente.mdl.dto.EstadoProceso
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class EstadoProcesoID implements Serializable {

	/**
	 * Representa del codigo de la compañia.
	 *

	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	

	/**
	 * Representa la clave primaria de la tabla (Secuencial de la tabla)
	 *

	 */
	@Column(name = "CODIGOPROCESOLOGISTICOESTADO", nullable = false)
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBLOGSECPROLOGEST" , castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoProcesoLogisticoEstado ;
		
	

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
	 * @return the codigoProcesoLogisticoEstado
	 */
	public Long getCodigoProcesoLogisticoEstado() {
		return codigoProcesoLogisticoEstado;
	}

	/**
	 * @param codigoProcesoLogisticoEstado the codigoProcesoLogisticoEstado to set
	 */
	public void setCodigoProcesoLogisticoEstado(Long codigoProcesoLogisticoEstado) {
		this.codigoProcesoLogisticoEstado = codigoProcesoLogisticoEstado;
	}


}

