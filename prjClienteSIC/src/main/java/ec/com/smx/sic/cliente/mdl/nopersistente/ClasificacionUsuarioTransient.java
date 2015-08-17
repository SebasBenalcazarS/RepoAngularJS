package ec.com.smx.sic.cliente.mdl.nopersistente;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

@SuppressWarnings("serial")
public class ClasificacionUsuarioTransient extends SimpleAuditDTO {

	private Integer npIndiceClasificacionUsuario;
	private String npEstadoClasificacionAgregada;
	public Integer getNpIndiceClasificacionUsuario() {
		return npIndiceClasificacionUsuario;
	}
	public void setNpIndiceClasificacionUsuario(Integer npIndiceClasificacionUsuario) {
		this.npIndiceClasificacionUsuario = npIndiceClasificacionUsuario;
	}
	public String getNpEstadoClasificacionAgregada() {
		return npEstadoClasificacionAgregada;
	}
	public void setNpEstadoClasificacionAgregada(
			String npEstadoClasificacionAgregada) {
		this.npEstadoClasificacionAgregada = npEstadoClasificacionAgregada;
	}
}
