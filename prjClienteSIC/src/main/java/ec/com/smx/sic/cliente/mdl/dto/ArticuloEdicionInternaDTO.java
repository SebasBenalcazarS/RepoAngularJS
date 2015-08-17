package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

@SuppressWarnings("serial")
@Entity
public class ArticuloEdicionInternaDTO extends SearchDTO implements Serializable {
	
	@Id
	private String codigoArticulo;
	
	private String codigoBarras;

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

}
