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
public class AreaTrabajoCalendarioProcesoConfiguracionID implements Serializable{

	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	@Column(name = "CODIGOARETRACALPROCON")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECARETRACALPROCON")
	private Long codigoAreaTrabajoCalendarioProcesoConfiguracion;

	
	
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
	 * @return the codigoAreaTrabajoCalendarioProcesoConfiguracion
	 */
	public Long getCodigoAreaTrabajoCalendarioProcesoConfiguracion() {
		return codigoAreaTrabajoCalendarioProcesoConfiguracion;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProcesoConfiguracion the codigoAreaTrabajoCalendarioProcesoConfiguracion to set
	 */
	public void setCodigoAreaTrabajoCalendarioProcesoConfiguracion(Long codigoAreaTrabajoCalendarioProcesoConfiguracion) {
		this.codigoAreaTrabajoCalendarioProcesoConfiguracion = codigoAreaTrabajoCalendarioProcesoConfiguracion;
	}

}
