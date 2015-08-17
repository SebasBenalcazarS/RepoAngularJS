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
public class AreaTrabajoCalendarioProcesoID implements Serializable {

	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	@Column(name = "CODIGOARETRACALPRO")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECARETRACALPRO")
	private Long codigoAreaTrabajoCalendarioProceso;

	
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
	 * @return the codigoAreaTrabajoCalendarioProceso
	 */
	public Long getCodigoAreaTrabajoCalendarioProceso() {
		return codigoAreaTrabajoCalendarioProceso;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProceso the codigoAreaTrabajoCalendarioProceso to set
	 */
	public void setCodigoAreaTrabajoCalendarioProceso(Long codigoAreaTrabajoCalendarioProceso) {
		this.codigoAreaTrabajoCalendarioProceso = codigoAreaTrabajoCalendarioProceso;
	}

}
