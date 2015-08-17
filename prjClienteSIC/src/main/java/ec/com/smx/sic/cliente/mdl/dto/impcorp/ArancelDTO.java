/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.ArancelID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTARANCEL")
public class ArancelDTO extends AuditoriaBaseDTO<ArancelID>{
	@Column(name = "NUMEROPARTIDA")
	private String numeroPartida;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "DESCRIPCIONCORTA")
	private String descripcionCorta;
	
	@Column(name = "PORCENTAJE")
	private Double porcentaje;
	
	@Column(name = "TASAESPECIAL")
	private Double tasaEspecial;
	
	@Column(name = "SALVAGUARDA")
	private Double salvaguarda;
	
	@Column(name = "APLICAMIXTA")
	private String aplicaMixta;
	
	@Column(name = "CAMPOAPLICACION")
	private String campoAplicacion;
	
	@Column(name = "CODIGOTIPOUNICOMADUCATTIP")
	private Long codigoTipoUnidadComercialAduCatTip;
	
	@Column(name = "CODIGOTIPOUNICOMADUCATVAL")
	private Long codigoTipoUnidadComercialAduCatVal;
	
	@Column(name = "CODIGOCAMPOAPLICACIONCATTIP")
	private Long codigoCampoAplicacionCatTip;
	
	@Column(name = "CODIGOCAMPOAPLICACIONCATVAL")
	private Long codigoCampoAplicacionCatVal;
	
	@Column(name = "SOBRETASAARANCELARIA")
	private Double sobreTasaArancel;
	

	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOUNICOMADUCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOUNICOMADUCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoUnidadComercialAdu;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCAMPOAPLICACIONCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOCAMPOAPLICACIONCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoCalculoPartida;
	
	
	@OneToMany(mappedBy="arancel")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<ArancelRequisitoDTO> arancelRequisitosImpDTO;
	
//	@OneToMany(mappedBy="arancelReg")
//	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	
	
	
	/**
	 * @return devuelve el valor de la propiedad numeroPartida
	 */
	public String getNumeroPartida() {
		return numeroPartida;
	}

	/**
	 * @param numeroPartida establece el valor a la propiedad numeroPartida
	 */
	public void setNumeroPartida(String numeroPartida) {
		this.numeroPartida = numeroPartida;
	}

	/**
	 * @return devuelve el valor de la propiedad descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion establece el valor a la propiedad descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return devuelve el valor de la propiedad descripcionCorta
	 */
	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	/**
	 * @param descripcionCorta establece el valor a la propiedad descripcionCorta
	 */
	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	/**
	 * @return devuelve el valor de la propiedad estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado establece el valor a la propiedad estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return devuelve el valor de la propiedad porcentaje
	 */
	public Double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje establece el valor a la propiedad porcentaje
	 */
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * @return the tasaEspecial
	 */
	public Double getTasaEspecial() {
		return tasaEspecial;
	}

	/**
	 * @param tasaEspecial the tasaEspecial to set
	 */
	public void setTasaEspecial(Double tasaEspecial) {
		this.tasaEspecial = tasaEspecial;
	}

	/**
	 * @return the salvaguarda
	 */
	public Double getSalvaguarda() {
		return salvaguarda;
	}

	/**
	 * @param salvaguarda the salvaguarda to set
	 */
	public void setSalvaguarda(Double salvaguarda) {
		this.salvaguarda = salvaguarda;
	}

	/**
	 * @return the aplicaMixta
	 */
	public String getAplicaMixta() {
		return aplicaMixta;
	}

	/**
	 * @param aplicaMixta the aplicaMixta to set
	 */
	public void setAplicaMixta(String aplicaMixta) {
		this.aplicaMixta = aplicaMixta;
	}

	/**
	 * @return the campoAplicacion
	 */
	public String getCampoAplicacion() {
		return campoAplicacion;
	}

	/**
	 * @param campoAplicacion the campoAplicacion to set
	 */
	public void setCampoAplicacion(String campoAplicacion) {
		this.campoAplicacion = campoAplicacion;
	}

	/**
	 * @return the codigoTipoUnidadComercialAduCatTip
	 */
	public Long getCodigoTipoUnidadComercialAduCatTip() {
		return codigoTipoUnidadComercialAduCatTip;
	}

	/**
	 * @param codigoTipoUnidadComercialAduCatTip the codigoTipoUnidadComercialAduCatTip to set
	 */
	public void setCodigoTipoUnidadComercialAduCatTip(
			Long codigoTipoUnidadComercialAduCatTip) {
		this.codigoTipoUnidadComercialAduCatTip = codigoTipoUnidadComercialAduCatTip;
	}

	/**
	 * @return the codigoTipoUnidadComercialAduCatVal
	 */
	public Long getCodigoTipoUnidadComercialAduCatVal() {
		return codigoTipoUnidadComercialAduCatVal;
	}

	/**
	 * @param codigoTipoUnidadComercialAduCatVal the codigoTipoUnidadComercialAduCatVal to set
	 */
	public void setCodigoTipoUnidadComercialAduCatVal(
			Long codigoTipoUnidadComercialAduCatVal) {
		this.codigoTipoUnidadComercialAduCatVal = codigoTipoUnidadComercialAduCatVal;
	}

	/**
	 * @return the tipoUnidadComercialAdu
	 */
	public CatalogoValorImpDTO getTipoUnidadComercialAdu() {
		return tipoUnidadComercialAdu;
	}

	/**
	 * @param tipoUnidadComercialAdu the tipoUnidadComercialAdu to set
	 */
	public void setTipoUnidadComercialAdu(CatalogoValorImpDTO tipoUnidadComercialAdu) {
		this.tipoUnidadComercialAdu = tipoUnidadComercialAdu;
	}

	public Long getCodigoCampoAplicacionCatTip() {
		return codigoCampoAplicacionCatTip;
	}

	public void setCodigoCampoAplicacionCatTip(Long codigoCampoAplicacionCatTip) {
		this.codigoCampoAplicacionCatTip = codigoCampoAplicacionCatTip;
	}

	public Long getCodigoCampoAplicacionCatVal() {
		return codigoCampoAplicacionCatVal;
	}

	public void setCodigoCampoAplicacionCatVal(Long codigoCampoAplicacionCatVal) {
		this.codigoCampoAplicacionCatVal = codigoCampoAplicacionCatVal;
	}

	public CatalogoValorImpDTO getTipoCalculoPartida() {
		return tipoCalculoPartida;
	}

	public void setTipoCalculoPartida(CatalogoValorImpDTO tipoCalculoPartida) {
		this.tipoCalculoPartida = tipoCalculoPartida;
	}

	/**
	 * @return the arancelRequisitosImpDTO
	 */
	public Collection<ArancelRequisitoDTO> getArancelRequisitosImpDTO() {
		return arancelRequisitosImpDTO;
	}

	/**
	 * @param arancelRequisitosImpDTO the arancelRequisitosImpDTO to set
	 */
	public void setArancelRequisitosImpDTO(
			Collection<ArancelRequisitoDTO> arancelRequisitosImpDTO) {
		this.arancelRequisitosImpDTO = arancelRequisitosImpDTO;
	}

	/**
	 * @return the sobreTasaArancel
	 */
	public Double getSobreTasaArancel() {
		return sobreTasaArancel;
	}

	/**
	 * @param sobreTasaArancel the sobreTasaArancel to set
	 */
	public void setSobreTasaArancel(Double sobreTasaArancel) {
		this.sobreTasaArancel = sobreTasaArancel;
	}

		
	
	
	
}
