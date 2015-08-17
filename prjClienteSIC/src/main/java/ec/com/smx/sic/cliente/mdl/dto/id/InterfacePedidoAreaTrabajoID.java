/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class InterfacePedidoAreaTrabajoID implements Serializable {
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	public static final String NOMBRE_SECUENCIA = "SBPEASECINTPEDARETRA";

	@Column(name = "CODIGOINTPEDARETRA")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECINTPEDARETRA")
	private Long codigoInterfacePedidoAreaTrabajo;

	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return the codigoInterfacePedidoAreaTrabajo
	 */
	public Long getCodigoInterfacePedidoAreaTrabajo() {
		return codigoInterfacePedidoAreaTrabajo;
	}

	/**
	 * @param codigoInterfacePedidoAreaTrabajo the codigoInterfacePedidoAreaTrabajo to set
	 */
	public void setCodigoInterfacePedidoAreaTrabajo(Long codigoInterfacePedidoAreaTrabajo) {
		this.codigoInterfacePedidoAreaTrabajo = codigoInterfacePedidoAreaTrabajo;
	}

}
