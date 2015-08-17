package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaPerfilMonitorRecolectorID;

@SuppressWarnings("serial")
public class VistaPerfilMonitorRecolectorDTO extends SimpleAuditDTO {

	@EmbeddedId
	private VistaPerfilMonitorRecolectorID id = new VistaPerfilMonitorRecolectorID();

	private String profileName;
	private String referenceCode;

	public VistaPerfilMonitorRecolectorDTO() {
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public VistaPerfilMonitorRecolectorID getId() {
		return id;
	}

	public void setId(VistaPerfilMonitorRecolectorID id) {
		this.id = id;
	}

}
