package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase NotificacionProcesoProveedor
 * @see ec.com.smx.b2b.dto.NotificacionProcesoProveedor
 *
 * @author kruger
 */

@SuppressWarnings("serial")
@Embeddable
public class ConfiguracionNotificacionProcesoID implements Serializable {
	/**
	 * codigo de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;

	/**
	 * codigo asignado al pedido
	 */	
	@Column(name = "SECCONNOTPRO", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSEQCONNOTPRO")
	private java.lang.Long secuencialNotificacionProceso ;

	
	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * @param codigoCompania 
	 *		El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}


	/**
	 * Retorna valor de propiedad <code>secuencialNotificacionProceso</code>
	 * @return 
	 * 		Retorna valor de propiedad <code>secuencialNotificacionProceso</code>
	 */
	public java.lang.Long getSecuencialNotificacionProceso() {
		return secuencialNotificacionProceso;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>secuencialNotificacionProceso</code>.
	 * @param codigoPedido1 
	 *		El valor a establecer para la propiedad <code>secuencialNotificacionProceso</code>.
	 */
	public void setSecuencialNotificacionProceso(
			java.lang.Long secuencialNotificacionProceso) {
		this.secuencialNotificacionProceso = secuencialNotificacionProceso;
	}


	
}
