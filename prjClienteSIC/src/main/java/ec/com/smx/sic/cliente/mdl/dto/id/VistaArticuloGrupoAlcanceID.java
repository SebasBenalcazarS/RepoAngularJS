package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
 /**
  * 
  * @author jmontenegro
  *
  */


@SuppressWarnings("serial")
@Embeddable
public class VistaArticuloGrupoAlcanceID implements Serializable{

	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	
	
	@Column(name = "CODIGOARTICULO", nullable = false)	
	private String codigoArticulo;



	public Integer getCodigoCompania() {
		return codigoCompania;
	}



	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}



	public String getCodigoArticulo() {
		return codigoArticulo;
	}



	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	
	
	
	
}
