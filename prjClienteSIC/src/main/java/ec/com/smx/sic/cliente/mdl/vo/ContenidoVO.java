package ec.com.smx.sic.cliente.mdl.vo;

import ec.com.smx.sic.cliente.mdl.dto.asistentecompras.ContenidoDTO;

public class ContenidoVO {

	private ContenidoDTO contenidoDTO;
	private String userID;
	private Long secuencialContenido;
	
	//private Long codigoPersona;

	public ContenidoDTO getContenidoDTO() {
		return contenidoDTO;
	}

	public void setContenidoDTO(ContenidoDTO contenidoDTO) {
		this.contenidoDTO = contenidoDTO;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Long getSecuencialContenido() {
		return secuencialContenido;
	}

	public void setSecuencialContenido(Long secuencialContenido) {
		this.secuencialContenido = secuencialContenido;
	}

	

}
