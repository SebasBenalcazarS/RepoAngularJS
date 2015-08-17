package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.ControlRecipienteDTO;

@SuppressWarnings("serial")
public class ControlRecipienteVO extends ControlRecipienteDTO{
	
	//Campos de VO 
	private ControlRecipienteDTO controlRecipienteAnterior;
	
	private String evento;
	
	private Collection<String> mensajesError;
	
	private Collection<String> mensajesInfo;
	
	private Collection<ArticuloDTO> articuloCol;
	//Campos de la pantalla
	
	//Mensaje de confirmacion de popup botones de navegacion
	private String mensajeConf;
	private String accessItemId;
	private String systemId;
	private String userId;
	
	
	public ControlRecipienteDTO getControlRecipienteAnterior() {
		return controlRecipienteAnterior;
	}

	public void setControlRecipienteAnterior(ControlRecipienteDTO controlRecipienteAnterior) {
		this.controlRecipienteAnterior = controlRecipienteAnterior;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Collection<String> getMensajesError() {
		return mensajesError;
	}

	public void setMensajesError(Collection<String> mensajesError) {
		this.mensajesError = mensajesError;
	}

	public Collection<String> getMensajesInfo() {
		return mensajesInfo;
	}

	public void setMensajesInfo(Collection<String> mensajesInfo) {
		this.mensajesInfo = mensajesInfo;
	}

	public String getMensajeConf() {
		return mensajeConf;
	}

	public void setMensajeConf(String mensajeConf) {
		this.mensajeConf = mensajeConf;
	}

	public String getAccessItemId() {
		return accessItemId;
	}

	public void setAccessItemId(String accessItemId) {
		this.accessItemId = accessItemId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public Collection<ArticuloDTO> getArticuloCol() {
		return articuloCol;
	}

	public void setArticuloCol(Collection<ArticuloDTO> articuloCol) {
		this.articuloCol = articuloCol;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
