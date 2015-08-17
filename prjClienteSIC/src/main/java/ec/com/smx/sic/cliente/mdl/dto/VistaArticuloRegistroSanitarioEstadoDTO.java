/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloRegistroSanitarioEstadoID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADVARTREGEST")
public class VistaArticuloRegistroSanitarioEstadoDTO extends SimpleAuditDTO {
	@EmbeddedId
	private VistaArticuloRegistroSanitarioEstadoID id = new VistaArticuloRegistroSanitarioEstadoID();

	@Column(name = "ESTADOPROCESO", nullable = false)
	private String estadoProceso;
	
	/**
	 * @return the id
	 */
	public VistaArticuloRegistroSanitarioEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaArticuloRegistroSanitarioEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the estadoProceso
	 */
	public String getEstadoProceso() {
		return estadoProceso;
	}

	/**
	 * @param estadoProceso the estadoProceso to set
	 */
	public void setEstadoProceso(String estadoProceso) {
		this.estadoProceso = estadoProceso;
	}
	
}
