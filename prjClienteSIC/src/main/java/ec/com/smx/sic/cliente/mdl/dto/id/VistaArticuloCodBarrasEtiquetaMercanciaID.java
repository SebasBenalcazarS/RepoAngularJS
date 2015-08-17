package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Claves compuestas para VistaArticuloCodBarrasEtiquetaMercanciaDTO 
 * @author aquingaluisa
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class VistaArticuloCodBarrasEtiquetaMercanciaID implements Serializable {
	
	private Integer codCompania;
	private String  codArticulo;
	public Integer getCodCompania() {
		return codCompania;
	}
	public void setCodCompania(Integer codCompania) {
		this.codCompania = codCompania;
	}
	public String getCodArticulo() {
		return codArticulo;
	}
	public void setCodArticulo(String codArticulo) {
		this.codArticulo = codArticulo;
	}
}
