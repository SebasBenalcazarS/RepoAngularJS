
package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.LastModificationDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.LastModifierUserIdField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterDateField;
import ec.com.kruger.utilitario.dao.commons.annotations.RegisterUserIdField;
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.Logeable;
import ec.com.smx.sic.cliente.mdl.dto.id.CaracteristicaID;


/**
 * Almacena especificaciones del Articulo
 *
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCSADTCARACTERISTICA")
public class CaracteristicaDTO extends SimpleAuditDTO implements Cloneable{

	@EmbeddedId
	private CaracteristicaID id;	
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
	private Integer orden;
	
	/**
	 * C�digo del tipo de caracter�stica
	 */
	private Integer codigoTipoCaracterstica ;

	/**
	 * Trae el tipo de caracteristica
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOTIPOCARACTERSTICA", referencedColumnName="CODIGOTIPOCARACTERSTICA", insertable=false, updatable=false)})
	private TipoCaracteristicaDTO tipoCaracteristica;
	/**
	 * El articulo a la que pertenece esta caracteristica
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA", insertable=false, updatable=false, referencedColumnName="CODIGOCOMPANIA"),@JoinColumn(name="CODIGOARTICULO", referencedColumnName="CODIGOARTICULO", insertable=false, updatable=false)})
	private ArticuloDTO articulo;

	public CaracteristicaDTO(){
		this.id = new CaracteristicaID();
	}
	/**
	 * Cloneable
	 */
	public CaracteristicaDTO clone(){
		CaracteristicaDTO clon = null;
		try{
			clon = (CaracteristicaDTO)super.clone();
			clon.setId(this.id.clone());
		}catch(CloneNotSupportedException ex){
			Logeable.LOG_SICV2.error(ex.getMessage());
		}
		return clon;
	}

	/**
	 * @return the id
	 */
	public CaracteristicaID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(CaracteristicaID id) {
		this.id = id;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * @return the codigoTipoCaracterstica
	 */
	public Integer getCodigoTipoCaracterstica() {
		return codigoTipoCaracterstica;
	}

	/**
	 * @param codigoTipoCaracterstica the codigoTipoCaracterstica to set
	 */
	public void setCodigoTipoCaracterstica(Integer codigoTipoCaracterstica) {
		this.codigoTipoCaracterstica = codigoTipoCaracterstica;
	}

	/**
	 * @return the tipoCaracteristica
	 */
	public TipoCaracteristicaDTO getTipoCaracteristica() {
		return tipoCaracteristica;
	}

	/**
	 * @param tipoCaracteristica the tipoCaracteristica to set
	 */
	public void setTipoCaracteristica(TipoCaracteristicaDTO tipoCaracteristica) {
		this.tipoCaracteristica = tipoCaracteristica;
	}

	/**
	 * @return the articulo
	 */
	public ArticuloDTO getArticulo() {
		return articulo;
	}

	/**
	 * @param articulo the articulo to set
	 */
	public void setArticulo(ArticuloDTO articulo) {
		this.articulo = articulo;
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

