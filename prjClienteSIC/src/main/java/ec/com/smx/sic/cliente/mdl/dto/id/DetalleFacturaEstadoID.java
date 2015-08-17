
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Tarea
 * 
 * @see ec.com.smx.corpv2.dto.TipoTareaPerfilDTO
 * 
 * @author acaiza
 */
@SuppressWarnings("serial")
@Embeddable
public class DetalleFacturaEstadoID implements Serializable {

	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Especifica el codigo de la tarea
	 *
	 */
	@Column(name = "CODIGODETALLEFACTURAESTADO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFDISECDETALLEFACTURAESTADO", castTo=@Cast(sqlType=Types.NUMERIC,precision=15,scale=0))
	private Long codigoDetalleFacturaEstado ;
		
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
	 * @return the codigoDetalleFacturaEstado
	 */
	public Long getCodigoDetalleFacturaEstado() {
		return codigoDetalleFacturaEstado;
	}

	/**
	 * @param codigoDetalleFacturaEstado the codigoDetalleFacturaEstado to set
	 */
	public void setCodigoDetalleFacturaEstado(Long codigoDetalleFacturaEstado) {
		this.codigoDetalleFacturaEstado = codigoDetalleFacturaEstado;
	}
	
}

