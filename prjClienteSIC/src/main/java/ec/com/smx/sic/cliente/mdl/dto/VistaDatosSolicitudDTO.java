package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaDatosSolicitudID;

@SuppressWarnings("serial")
@Entity
public class VistaDatosSolicitudDTO extends SearchDTO{
	@EmbeddedId
	private VistaDatosSolicitudID id = new VistaDatosSolicitudID();
//	@Transient
	private String fechaCaducidadPedido;
	public VistaDatosSolicitudID getId() {
		return id;
	}

	public void setId(VistaDatosSolicitudID id) {
		this.id = id;
	}

	public String getFechaCaducidadPedido() {
		return fechaCaducidadPedido;
	}

	public void setFechaCaducidadPedido(String fechaCaducidadPedido) {
		this.fechaCaducidadPedido = fechaCaducidadPedido;
	}
}
