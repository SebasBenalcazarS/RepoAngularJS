package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.io.Serializable;

import ec.com.smx.sic.cliente.mdl.dto.ContenedorEstadoDTO;

@SuppressWarnings("serial")
public class PlantillaRespaldoCountTrasient implements Serializable{
	
	private ContenedorEstadoDTO contenedorEstadoResp;

	/**
	 * @return the contenedorEstadoResp
	 */
	public ContenedorEstadoDTO getContenedorEstadoResp() {
		return contenedorEstadoResp;
	}

	/**
	 * @param contenedorEstadoResp the contenedorEstadoResp to set
	 */
	public void setContenedorEstadoResp(ContenedorEstadoDTO contenedorEstadoResp) {
		this.contenedorEstadoResp = contenedorEstadoResp;
	}

	
}
