package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * 
 * @author fcollaguazo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class ClasificacionRelacionadaID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "SECUENCIACLASIFICACIONRELACION", nullable = false)
	@SequenceDataBaseValue (descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSPESECCLAREL")
	private Long secuenciaClasificacionRelacion;
	
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
	 * @return the secuenciaClasificacionRelacion
	 */
	public Long getSecuenciaClasificacionRelacion() {
		return secuenciaClasificacionRelacion;
	}

	/**
	 * @param secuenciaClasificacionRelacion the secuenciaClasificacionRelacion to set
	 */
	public void setSecuenciaClasificacionRelacion(Long secuenciaClasificacionRelacion) {
		this.secuenciaClasificacionRelacion = secuenciaClasificacionRelacion;
	}
}
