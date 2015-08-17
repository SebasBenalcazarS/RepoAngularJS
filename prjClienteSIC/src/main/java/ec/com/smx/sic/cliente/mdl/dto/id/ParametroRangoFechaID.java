/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;
import java.sql.Types;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.annotations.Cast;
import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class ParametroRangoFechaID implements Serializable{
	
	/**
	 * Codigo de compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial del codigo articulo oferta
	 */
	@Column(name = "CODIGOPARAMETRORANGOFECHA", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFRUSECPARRANFEC", castTo=@Cast(sqlType=Types.BIGINT))
	private Long codigoParametroRangoFecha;

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
	 * @return the codigoParametroRangoFecha
	 */
	public Long getCodigoParametroRangoFecha() {
		return codigoParametroRangoFecha;
	}

	/**
	 * @param codigoParametroRangoFecha the codigoParametroRangoFecha to set
	 */
	public void setCodigoParametroRangoFecha(Long codigoParametroRangoFecha) {
		this.codigoParametroRangoFecha = codigoParametroRangoFecha;
	}

}
