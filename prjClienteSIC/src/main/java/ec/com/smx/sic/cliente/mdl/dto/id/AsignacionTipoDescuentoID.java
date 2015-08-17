package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;


/**
 * @author Luis Yacchirema
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class AsignacionTipoDescuentoID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	@Column(name = "SECUENCIALASITIPDES", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = NOMBRE_SECUENCIA)
	private Integer secuencialAsignacionTipoDescuento;
	
	public static final String NOMBRE_SECUENCIA = "SCADMSECASITIPDES";

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
	 * @return the secuencialAsignacionTipoDescuento
	 */
	public Integer getSecuencialAsignacionTipoDescuento() {
		return secuencialAsignacionTipoDescuento;
	}

	/**
	 * @param secuencialAsignacionTipoDescuento the secuencialAsignacionTipoDescuento to set
	 */
	public void setSecuencialAsignacionTipoDescuento(Integer secuencialAsignacionTipoDescuento) {
		this.secuencialAsignacionTipoDescuento = secuencialAsignacionTipoDescuento;
	}

}
