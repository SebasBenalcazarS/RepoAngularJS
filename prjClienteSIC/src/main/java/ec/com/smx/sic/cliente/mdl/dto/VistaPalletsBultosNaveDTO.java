/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaPalletsBultosNaveID;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings("serial")
public class VistaPalletsBultosNaveDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaPalletsBultosNaveID id = new VistaPalletsBultosNaveID();
	
	private Integer totalBultos;
	private Integer totalPallets;
	
	//campos de la tabla DetalleSeccionDTO - SBLOGTDETSEC
	private String nombreSeccionNave;
	
	//campos de la tabla BaseProfileDto - KSSEGTPROFILE
	private String profileName;
	private String referenceCode;
	
	//campos de la tabla CatalogoValorDTO - SSPCOTCATALOGOVALOR para el estado del pallet
	private String nomCatValEstPalletRel;
	
	//campos de la tabla DatosTareaDTO - SBLOGTDATTAR
	private Integer codigoAreaTrabajo;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubBodega;
	
	public VistaPalletsBultosNaveDTO () {}

	/**
	 * @return the id
	 */
	public VistaPalletsBultosNaveID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaPalletsBultosNaveID id) {
		this.id = id;
	}

	/**
	 * @return the totalBultos
	 */
	public Integer getTotalBultos() {
		return totalBultos;
	}

	/**
	 * @param totalBultos the totalBultos to set
	 */
	public void setTotalBultos(Integer totalBultos) {
		this.totalBultos = totalBultos;
	}

	/**
	 * @return the totalPallets
	 */
	public Integer getTotalPallets() {
		return totalPallets;
	}

	/**
	 * @param totalPallets the totalPallets to set
	 */
	public void setTotalPallets(Integer totalPallets) {
		this.totalPallets = totalPallets;
	}

	/**
	 * @return the nombreSeccionNave
	 */
	public String getNombreSeccionNave() {
		return nombreSeccionNave;
	}

	/**
	 * @param nombreSeccionNave the nombreSeccionNave to set
	 */
	public void setNombreSeccionNave(String nombreSeccionNave) {
		this.nombreSeccionNave = nombreSeccionNave;
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
	 * @return the referenceCode
	 */
	public String getReferenceCode() {
		return referenceCode;
	}

	/**
	 * @param referenceCode the referenceCode to set
	 */
	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	/**
	 * @return the nomCatValEstPalletRel
	 */
	public String getNomCatValEstPalletRel() {
		return nomCatValEstPalletRel;
	}

	/**
	 * @param nomCatValEstPalletRel the nomCatValEstPalletRel to set
	 */
	public void setNomCatValEstPalletRel(String nomCatValEstPalletRel) {
		this.nomCatValEstPalletRel = nomCatValEstPalletRel;
	}

	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}

	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}

	/**
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}

	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}

	/**
	 * @return the codigoAreaTrabajoSubBodega
	 */
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}

	/**
	 * @param codigoAreaTrabajoSubBodega the codigoAreaTrabajoSubBodega to set
	 */
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}

}
