package ec.com.smx.sic.cliente.mdl.dto.articulo.observacion;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.articulo.ArticuloObservacionID;

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTTARTOBSTMP")
public class ArticuloObservacionDTO implements Serializable{

	@EmbeddedId
	ArticuloObservacionID id = new ArticuloObservacionID();
	
	private String codigoBarras;
	
	private String observacion;

	public ArticuloObservacionID getId() {
		return id;
	}

	public void setId(ArticuloObservacionID id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	
}
