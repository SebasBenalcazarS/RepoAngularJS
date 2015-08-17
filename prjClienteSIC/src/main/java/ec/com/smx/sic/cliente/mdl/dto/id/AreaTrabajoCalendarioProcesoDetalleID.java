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
public class AreaTrabajoCalendarioProcesoDetalleID implements Serializable{

	@Column(name = "CODIGOCOMPANIA")
    private Integer codigoCompania;
	
	@Column(name = "CODIGOARETRACALPRODET")
	@SequenceDataBaseValue(descriptorClass = DescriptorSecuenciasSIC.class, name = "SBPEASECARETRACALPRODET")
	private Long codigoAreaTrabajoCalendarioProcesoDetalle;
	
	
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
	 * @return the codigoAreaTrabajoCalendarioProcesoDetalle
	 */
	public Long getCodigoAreaTrabajoCalendarioProcesoDetalle() {
		return codigoAreaTrabajoCalendarioProcesoDetalle;
	}

	/**
	 * @param codigoAreaTrabajoCalendarioProcesoDetalle the codigoAreaTrabajoCalendarioProcesoDetalle to set
	 */
	public void setCodigoAreaTrabajoCalendarioProcesoDetalle(Long codigoAreaTrabajoCalendarioProcesoDetalle) {
		this.codigoAreaTrabajoCalendarioProcesoDetalle = codigoAreaTrabajoCalendarioProcesoDetalle;
	}
	
}
