/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.sic.cliente.mdl.dto.id.SecuenciaID;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSPETSECUENCIA")
public class SecuenciaDTO implements Serializable{

	@EmbeddedId
	private SecuenciaID id = new SecuenciaID();
	/**
	 * 
	 */
	private String descripcionSecuencia;
	/**
	 * 
	 */
	private Long valorSecuencia;
	
	/**
	 * @return the descripcionSecuencia
	 */
	public String getDescripcionSecuencia() {
		return descripcionSecuencia;
	}
	/**
	 * @param descripcionSecuencia the descripcionSecuencia to set
	 */
	public void setDescripcionSecuencia(String descripcionSecuencia) {
		this.descripcionSecuencia = descripcionSecuencia;
	}
	/**
	 * @return the valorSecuencia
	 */
	public Long getValorSecuencia() {
		return valorSecuencia;
	}
	/**
	 * @param valorSecuencia the valorSecuencia to set
	 */
	public void setValorSecuencia(Long valorSecuencia) {
		this.valorSecuencia = valorSecuencia;
	}
	/**
	 * @return the id
	 */
	public SecuenciaID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(SecuenciaID id) {
		this.id = id;
	}
}
