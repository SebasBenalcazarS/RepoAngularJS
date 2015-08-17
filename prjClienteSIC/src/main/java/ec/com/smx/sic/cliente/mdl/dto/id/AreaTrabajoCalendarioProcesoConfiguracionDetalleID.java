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
public class AreaTrabajoCalendarioProcesoConfiguracionDetalleID implements Serializable{
	
	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	@Column(name = "CODIGOARETRACALPROCONDET")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECARETRACALPROCONDET")
	private Long codigoAreaTrabajoCalendarioProcesoConfiguracionDetalle;

	
	
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
	 * @return the codigoAreaTrabajoCalendarioProcesoConfiguracionDetalle
	 */
	public Long getCodigoAreaTrabajoCalendarioProcesoConfiguracionDetalle() {
		return codigoAreaTrabajoCalendarioProcesoConfiguracionDetalle;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProcesoConfiguracionDetalle the codigoAreaTrabajoCalendarioProcesoConfiguracionDetalle to set
	 */
	public void setCodigoAreaTrabajoCalendarioProcesoConfiguracionDetalle(Long codigoAreaTrabajoCalendarioProcesoConfiguracionDetalle) {
		this.codigoAreaTrabajoCalendarioProcesoConfiguracionDetalle = codigoAreaTrabajoCalendarioProcesoConfiguracionDetalle;
	}
	
}
