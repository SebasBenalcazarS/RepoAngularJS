package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author srodriguez
 * 2014-09-10
*/
@SuppressWarnings("serial")
@Embeddable
public class VistaEmpresaParticipantePromocionID implements Serializable{
	private Integer codigoCompania;
	
	private Long codigoParticipacion;

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
	 * @return the participacion
	 */
	public Long getCodigoParticipacion() {
		return codigoParticipacion;
	}

	/**
	 * @param participacion the participacion to set
	 */
	public void setCodigoParticipacion(Long participacion) {
		this.codigoParticipacion = participacion;
	}

	

}
