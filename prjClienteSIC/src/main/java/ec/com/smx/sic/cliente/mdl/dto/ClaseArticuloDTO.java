/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.ClaseArticuloID;
import ec.com.smx.sic.cliente.resources.ordenCompra.SICOrdenCompraMessages;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTCLASEARTICULO")
public class ClaseArticuloDTO extends SimpleAuditDTO{

	@EmbeddedId
	private ClaseArticuloID id;
	@Column(name="NOMBRE")
	private String name;
	@Column(name="DESCRIPCION")
	private String description;
	@Column(name="ESTADO")
	@ComparatorTypeField
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
	@Transient
	private Integer diasMenor;
	
	@Transient
	private boolean selected;
	
	//variable usada para Historial de cambios
	@Transient
	private String varClaseArticulo;
	
	public ClaseArticuloDTO() {
		id = new ClaseArticuloID();
	}
	/**
	 * @return the id
	 */
	public ClaseArticuloID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ClaseArticuloID id) {
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
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String getVarClaseArticulo() {
		this.varClaseArticulo =  this.getId().getCodigoClaseArticulo().concat(" - ").concat(this.getName());
		return varClaseArticulo;
	}
	
	public void setVarClaseArticulo(String varClaseArticulo) {
		this.varClaseArticulo = this.getId().getCodigoClaseArticulo().concat(" - ").concat(this.getName());
	}
	
	public Integer getDiasMenor() {
		if(getId().getCodigoClaseArticulo().equals("B")){
			diasMenor = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.diasMenor.claseB"));
		}else if(getId().getCodigoClaseArticulo().equals(SICArticuloConstantes.CODIGO_CLASE_ARTICULO_R)){
			diasMenor = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.diasMenor.claseR"));
		}else{
			diasMenor = Integer.valueOf(SICOrdenCompraMessages.getInstancia().getString("ec.com.smx.sic.ordenCompra.diasMenor.claseGeneral"));
		}
		return diasMenor;
	}
	public void setDiasMenor(Integer diasMenor) {
		this.diasMenor = diasMenor;
	}
}
