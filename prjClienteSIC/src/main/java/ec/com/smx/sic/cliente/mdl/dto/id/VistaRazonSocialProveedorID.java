package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Claves compuestas para VistaRazonSocialProveedorDTO
 * @author dbravo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class VistaRazonSocialProveedorID implements Serializable {

	private String codigoArticulo;
	private Integer rowId;
	private Integer codigoCompania;
	
	
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Integer getRowId() {
		return rowId;
	}
	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	
	
	
	
}
