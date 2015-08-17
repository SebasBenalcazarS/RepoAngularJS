package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@SuppressWarnings("serial")
@Embeddable
public class VistaControlRutasTransportistaID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	@Column(name = "CODIGOTRANSPORTISTA")
	private java.lang.Long codigoTransportista;
	
	

	public java.lang.Long getCodigoTransportista() {
		return codigoTransportista;
	}

	public void setCodigoTransportista(java.lang.Long codigoTransportista) {
		this.codigoTransportista = codigoTransportista;
	}

	/**
	 * 
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * 
	 * @param codigoCompania
	 *            the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

}
