package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaCatalogoTareaRecepcionID;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings("serial")
public class VistaCatalogoTareaRecepcionDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaCatalogoTareaRecepcionID id = new VistaCatalogoTareaRecepcionID();
	
	//campos de la tabla CatalogoValorDTO - SSPCOTCATALOGOVALOR
	private Integer codigoCatalogoTipo;
	private String codigoCatalogoValor;
	private String nombreCatalogoValor;
	
	//campos de la tabla BaseProfileDto - KSSEGTPROFILE
	private String referenceCode;
	
	@Transient
	private Boolean esCatalogoPersistente = Boolean.TRUE;
	
	
	/**
	 * @return the id
	 */
	public VistaCatalogoTareaRecepcionID getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(VistaCatalogoTareaRecepcionID id) {
		this.id = id;
	}
	
	/**
	 * @return the codigoCatalogoTipo
	 */
	public Integer getCodigoCatalogoTipo() {
		return codigoCatalogoTipo;
	}
	
	/**
	 * @param codigoCatalogoTipo the codigoCatalogoTipo to set
	 */
	public void setCodigoCatalogoTipo(Integer codigoCatalogoTipo) {
		this.codigoCatalogoTipo = codigoCatalogoTipo;
	}
	
	/**
	 * @return the codigoCatalogoValor
	 */
	public String getCodigoCatalogoValor() {
		return codigoCatalogoValor;
	}
	
	/**
	 * @param codigoCatalogoValor the codigoCatalogoValor to set
	 */
	public void setCodigoCatalogoValor(String codigoCatalogoValor) {
		this.codigoCatalogoValor = codigoCatalogoValor;
	}
	
	/**
	 * @return the nombreCatalogoValor
	 */
	public String getNombreCatalogoValor() {
		return nombreCatalogoValor;
	}
	
	/**
	 * @param nombreCatalogoValor the nombreCatalogoValor to set
	 */
	public void setNombreCatalogoValor(String nombreCatalogoValor) {
		this.nombreCatalogoValor = nombreCatalogoValor;
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
	 * @return the esCatalogoPersistente
	 */
	public Boolean getEsCatalogoPersistente() {
		return esCatalogoPersistente;
	}

	/**
	 * @param esCatalogoPersistente the esCatalogoPersistente to set
	 */
	public void setEsCatalogoPersistente(Boolean esCatalogoPersistente) {
		this.esCatalogoPersistente = esCatalogoPersistente;
	}
	
}
