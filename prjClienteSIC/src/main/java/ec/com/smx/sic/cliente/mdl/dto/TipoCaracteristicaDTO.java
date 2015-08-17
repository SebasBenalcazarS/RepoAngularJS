
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.TipoCaracteristicaID;

/**
 * Especifica el tipo de caracteristica dependiendo del tipo de articulo
 *
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTIPCAR")
public class TipoCaracteristicaDTO extends SimpleAuditDTO{

	@EmbeddedId
    private TipoCaracteristicaID id;
	@Column(name="NOMBRE")
	private String name;
	@Column(name="DESCRIPCION")
	private String description;
	@Column(name="ESTADO")
	private String status;
	@Column(name="USUARIOREGISTRO")
	@RegisterUserIdField
	private String registerUserId;
	@Column(name="USUARIOMODIFICACION")
	@LastModifierUserIdField
	private String lastModifierUserId;
	@Column(name="FECHAREGISTRO")
	@RegisterDateField
	private Timestamp registerDate;
	@Column(name="FECHAMODIFICACION")
	@LastModificationDateField
	private Timestamp lastModificationDate;
	
    public TipoCaracteristicaDTO(){
    	this.id = new TipoCaracteristicaID();
    }

	/**
	 * @return the id
	 */
	public TipoCaracteristicaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(TipoCaracteristicaID id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name != null ? name.toUpperCase() : null;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description != null ? description.toUpperCase() : null;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the registerUserId
	 */
	public String getRegisterUserId() {
		return registerUserId;
	}

	/**
	 * @param registerUserId the registerUserId to set
	 */
	public void setRegisterUserId(String registerUserId) {
		this.registerUserId = registerUserId;
	}

	/**
	 * @return the lastModifierUserId
	 */
	public String getLastModifierUserId() {
		return lastModifierUserId;
	}

	/**
	 * @param lastModifierUserId the lastModifierUserId to set
	 */
	public void setLastModifierUserId(String lastModifierUserId) {
		this.lastModifierUserId = lastModifierUserId;
	}

	/**
	 * @return the registerDate
	 */
	public Timestamp getRegisterDate() {
		return registerDate;
	}

	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * @return the lastModificationDate
	 */
	public Timestamp getLastModificationDate() {
		return lastModificationDate;
	}

	/**
	 * @param lastModificationDate the lastModificationDate to set
	 */
	public void setLastModificationDate(Timestamp lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}


}

