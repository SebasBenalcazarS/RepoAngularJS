package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Claves compuestas para VistaArticuloCaracteristicasMercanciaDTO 
 * @author aquingaluisa
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class VistaArticuloCaracteristicasMercanciaID implements Serializable {
	private Integer rowId;

	public Integer getRowId() {
		return rowId;
	}

	public void setRowId(Integer rowId) {
		this.rowId = rowId;
	}
	
	
}
