/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.ArchivoContenidoID;


/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCORCTARCCON")
public class ArchivoContenidoDTO extends SimpleAuditDTO{
	
	@EmbeddedId
	private ArchivoContenidoID id = new ArchivoContenidoID();
	
	
	@Column(name = "CONTENIDO", nullable = false)
	private byte[] contenido;

	
	/**
	 * @return the id
	 */
	public ArchivoContenidoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArchivoContenidoID id) {
		this.id = id;
	}

	/**
	 * @return the contenido
	 */
	public byte[] getContenido() {
		return contenido;
	}

	/**
	 * @param contenido the contenido to set
	 */
	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}
	
}
