package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Claves compuestas para CampoMercanciasDTO 
 * @author dbravo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class VistaCampoMercanciaID implements Serializable {
	
	private Integer codCompania;
	private String  codArticulo;
	private Integer rowId;
	
	
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
	public Integer getRowId() {
		return rowId;
	}
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}

	
	
	
	
	

}
