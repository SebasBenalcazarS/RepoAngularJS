package ec.com.smx.sic.cliente.mdl.dto.id;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;


@SuppressWarnings("serial")
public class VistaPerfilMonitorRecolectorID extends BaseID {
	
	private String profileId ;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	
}
