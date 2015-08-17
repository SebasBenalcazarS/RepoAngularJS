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
public class FechaOfertaProveedorID implements Serializable{

	/**
	 * Codigo de compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Secuencial del codigo fecha oferta
	 */
	@Column(name = "CODIGOFECHAOFERTA", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCFRUSECFECOFEPRO", castTo=@Cast(sqlType=Types.BIGINT))
	private Long codigoFechaOferta;

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
	 * @return the codigoFechaOferta
	 */
	public Long getCodigoFechaOferta() {
		return codigoFechaOferta;
	}

	/**
	 * @param codigoFechaOferta the codigoFechaOferta to set
	 */
	public void setCodigoFechaOferta(Long codigoFechaOferta) {
		this.codigoFechaOferta = codigoFechaOferta;
	}
}
