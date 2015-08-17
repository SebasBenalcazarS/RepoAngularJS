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
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.ArancelRequisitoID;


/**
 * @author rhidalgo
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTARAREQ")
public class ArancelRequisitoDTO extends AuditoriaBaseDTO<ArancelRequisitoID> {

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "APLICAVALIDACION")
	private Boolean aplicaValidacion;

	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;

	@Column(name = "CODIGOTIPOCATTIP")
	private Long codigoTipoRequisitoCatTip;

	@Column(name = "CODIGOTIPOCATVAL")
	private Long codigoTipoRequisitoCatVal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOTIPOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)})
	private CatalogoValorImpDTO tipoRequisito;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOARANCEL", referencedColumnName = "CODIGOARANCEL", insertable = false, updatable = false) })
	private ArancelDTO arancel;

	@OneToMany(mappedBy = "arancelRequisitoDTO")
	@CollectionTypeInfo(name = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<OrdenCompraDetalleArancelReqDTO> ordenCompraDetalleArancelReqCol;

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the aplicaValidacion
	 */
	public Boolean getAplicaValidacion() {
		return aplicaValidacion;
	}

	/**
	 * @param aplicaValidacion
	 *            the aplicaValidacion to set
	 */
	public void setAplicaValidacion(Boolean aplicaValidacion) {
		this.aplicaValidacion = aplicaValidacion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the codigoTipoRequisitoCatTip
	 */
	public Long getCodigoTipoRequisitoCatTip() {
		return codigoTipoRequisitoCatTip;
	}

	/**
	 * @param codigoTipoRequisitoCatTip
	 *            the codigoTipoRequisitoCatTip to set
	 */
	public void setCodigoTipoRequisitoCatTip(Long codigoTipoRequisitoCatTip) {
		this.codigoTipoRequisitoCatTip = codigoTipoRequisitoCatTip;
	}

	/**
	 * @return the codigoTipoRequisitoCatVal
	 */
	public Long getCodigoTipoRequisitoCatVal() {
		return codigoTipoRequisitoCatVal;
	}

	/**
	 * @param codigoTipoRequisitoCatVal
	 *            the codigoTipoRequisitoCatVal to set
	 */
	public void setCodigoTipoRequisitoCatVal(Long codigoTipoRequisitoCatVal) {
		this.codigoTipoRequisitoCatVal = codigoTipoRequisitoCatVal;
	}

	/**
	 * @return the tipoRequisito
	 */
	public CatalogoValorImpDTO getTipoRequisito() {
		return tipoRequisito;
	}

	/**
	 * @param tipoRequisito
	 *            the tipoRequisito to set
	 */
	public void setTipoRequisito(CatalogoValorImpDTO tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
	}

	/**
	 * @return the arancel
	 */
	public ArancelDTO getArancel() {
		return arancel;
	}

	/**
	 * @param arancel
	 *            the arancel to set
	 */
	public void setArancel(ArancelDTO arancel) {
		this.arancel = arancel;
	}

	public Collection<OrdenCompraDetalleArancelReqDTO> getOrdenCompraDetalleArancelReqCol() {
		return ordenCompraDetalleArancelReqCol;
	}

	public void setOrdenCompraDetalleArancelReqCol(
			Collection<OrdenCompraDetalleArancelReqDTO> ordenCompraDetalleArancelReqCol) {
		this.ordenCompraDetalleArancelReqCol = ordenCompraDetalleArancelReqCol;
	}

}
