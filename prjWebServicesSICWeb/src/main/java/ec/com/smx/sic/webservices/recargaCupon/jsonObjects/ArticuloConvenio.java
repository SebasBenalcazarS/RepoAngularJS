package ec.com.smx.sic.webservices.recargaCupon.jsonObjects;

import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloID;


public class ArticuloConvenio{
	
	private ArticuloID id;
	
	private String estado;


	public ArticuloID getId() {
		return id;
	}

	public void setId(ArticuloID id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}