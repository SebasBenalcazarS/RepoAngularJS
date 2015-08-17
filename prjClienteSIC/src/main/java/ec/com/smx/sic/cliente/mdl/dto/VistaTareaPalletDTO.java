package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaTareaPalletID;

/**
 * <b> Estructura para el manejo de Tarea y Pallet. </b>
 * 
 * @author acaiza
 * 
 */
@SuppressWarnings("serial")
@Entity
public class VistaTareaPalletDTO implements Serializable{

	@EmbeddedId
	VistaTareaPalletID id = new VistaTareaPalletID();
	
	@Column(name = "CODIGOPROCESOLOGISTICO")
	private Long codigoProcesoLogistico;
	
	@Column(name = "CODIGORECEPCIONPROVEEDOR")
	private Long codigoRecepcionProveedor ;
	
	@Column(name = "CODIGOPERFIL")
	private Long codigoPerfil;
	
	@Column(name = "ESTADOTAREA")
	private String estadoTarea;
	
	@Column(name = "ESTADOPALLET")
	private String estadoPallet;
	
	@Column(name = "CODIGODATOSTAREA")
	private Long codigoDatosTarea;

	@Column(name = "CODIGOTIPOTAREAPERFIL")
	private Long codigoTipoTareaPerfil;
	
	@Column(name = "CODIGOBARRASPALLET")
	private String codigoBarrasPallet;
	
	@Column(name = "PROFILENAME")
	private String profileName;
	
	@Column(name = "PROFILEREFERENCECODE")
	private String profileReferenceCode;

	/**
	 * @return the id
	 */
	public VistaTareaPalletID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaTareaPalletID id) {
		this.id = id;
	}

	/**
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the codigoPerfil
	 */
	public Long getCodigoPerfil() {
		return codigoPerfil;
	}

	/**
	 * @param codigoPerfil the codigoPerfil to set
	 */
	public void setCodigoPerfil(Long codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}

	/**
	 * @return the estadoTarea
	 */
	public String getEstadoTarea() {
		return estadoTarea;
	}

	/**
	 * @param estadoTarea the estadoTarea to set
	 */
	public void setEstadoTarea(String estadoTarea) {
		this.estadoTarea = estadoTarea;
	}

	/**
	 * @return the estadoPallet
	 */
	public String getEstadoPallet() {
		return estadoPallet;
	}

	/**
	 * @param estadoPallet the estadoPallet to set
	 */
	public void setEstadoPallet(String estadoPallet) {
		this.estadoPallet = estadoPallet;
	}

	/**
	 * @return the codigoDatosTarea
	 */
	public Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}

	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
	}

	/**
	 * @return the codigoTipoTareaPerfil
	 */
	public Long getCodigoTipoTareaPerfil() {
		return codigoTipoTareaPerfil;
	}

	/**
	 * @param codigoTipoTareaPerfil the codigoTipoTareaPerfil to set
	 */
	public void setCodigoTipoTareaPerfil(Long codigoTipoTareaPerfil) {
		this.codigoTipoTareaPerfil = codigoTipoTareaPerfil;
	}

	/**
	 * @return the codigoBarrasPallet
	 */
	public String getCodigoBarrasPallet() {
		return codigoBarrasPallet;
	}

	/**
	 * @param codigoBarrasPallet the codigoBarrasPallet to set
	 */
	public void setCodigoBarrasPallet(String codigoBarrasPallet) {
		this.codigoBarrasPallet = codigoBarrasPallet;
	}

	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * @param profileName the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	/**
	 * @return the profileReferenceCode
	 */
	public String getProfileReferenceCode() {
		return profileReferenceCode;
	}

	/**
	 * @param profileReferenceCode the profileReferenceCode to set
	 */
	public void setProfileReferenceCode(String profileReferenceCode) {
		this.profileReferenceCode = profileReferenceCode;
	}

	/**
	 * @return the codigoRecepcionProveedor
	 */
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}

	/**
	 * @param codigoRecepcionProveedor the codigoRecepcionProveedor to set
	 */
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}
	
}
