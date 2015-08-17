package ec.com.smx.sic.cliente.mdl.dto.id.articulo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ArticuloObservacionID implements Serializable{

	private String usuarioModificacion;
	
	private Long fechaModificacion;

	public String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public Long getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Long fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
}
