
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ProcesoLogisticoGrupoNovedadArticuloDTO
 * @see ec.com.smx.sic.cliente.mdl.dto.ProcesoLogisticoGrupoNovedadArticuloDTO
 *
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ProcesoLogisticoGrupoNovedadArticuloID implements Serializable{

	/**
	 * Codigo de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Secuencial de la tabla ProcesoLogisticoGrupoNovedadArticuloDTO
	 *
	 */
	@Column(name = "CODIGOPROCESOLOGISTICOGRUPONOVEDADARTICULO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SBLOGSECPROLOGGRUNOVART", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoProcesoLogisticoNovedadArticulo;
		
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
	 * @return the codigoProcesoLogisticoNovedadArticulo
	 */
	public Long getCodigoProcesoLogisticoNovedadArticulo() {
		return codigoProcesoLogisticoNovedadArticulo;
	}

	/**
	 * @param codigoProcesoLogisticoNovedadArticulo the codigoProcesoLogisticoNovedadArticulo to set
	 */
	public void setCodigoProcesoLogisticoNovedadArticulo(Long codigoProcesoLogisticoNovedadArticulo) {
		this.codigoProcesoLogisticoNovedadArticulo = codigoProcesoLogisticoNovedadArticulo;
	}

}

