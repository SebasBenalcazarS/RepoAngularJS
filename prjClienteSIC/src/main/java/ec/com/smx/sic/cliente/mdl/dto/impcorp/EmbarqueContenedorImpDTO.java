/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;
import java.util.Date;

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
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.EmbarqueContenedorImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTEMBCON")
public class EmbarqueContenedorImpDTO extends AuditoriaBaseDTO<EmbarqueContenedorImpID>{
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "SELLO")
	private String sello;
	
	@Column(name = "SELLOMANIFESTADO")
	private String selloManifestado;
	
	@Column(name = "CODIGOTIPCONCATTIP")
	private Long codigoTipConCatTip;
	
	@Column(name = "CODIGOTIPCONCATVAL")
	private Long codigoTipConCatVal;
	
	@Column(name = "CODIGOTAMCONCATTIP")
	private Long codigoTamConCatTip;
	
	@Column(name = "CODIGOTAMCONCATVAL")
	private Long codigoTamConCatVal;
	
	@Column(name = "TARA")
	private Double tara;
	
	@Column(name = "CANTIDADCAJAS")
	private Integer cantidadCajas;
	
	@Column(name = "PESOTOTAL")
	private Double pesoTotal;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "FECHALLEGADABODEGA")
	private Date fechaLlegadaBodega;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false)
	})
	private EmbarqueImpDTO embarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPCONCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPCONCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoContenedor;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTAMCONCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTAMCONCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tamanioContenedor;
	
	
	@OneToMany(mappedBy = "embarqueContenedor")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FacturaGastoEmbarqueContenedorImpDTO> facturaGastoEmbarqueContenedores;

	/**
	 * @return devuelve el valor de la propiedad codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia establece el valor a la propiedad codigoReferencia
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoTotal
	 */
	public Double getPesoTotal() {
		return pesoTotal;
	}

	/**
	 * @param pesoTotal establece el valor a la propiedad pesoTotal
	 */
	public void setPesoTotal(Double pesoTotal) {
		this.pesoTotal = pesoTotal;
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
	 * @return devuelve el valor de la propiedad embarque
	 */
	public EmbarqueImpDTO getEmbarque() {
		return embarque;
	}

	/**
	 * @param embarque establece el valor a la propiedad embarque
	 */
	public void setEmbarque(EmbarqueImpDTO embarque) {
		this.embarque = embarque;
	}

	/**
	 * @return devuelve el valor de la propiedad sello
	 */
	public String getSello() {
		return sello;
	}

	/**
	 * @param sello establece el valor a la propiedad sello
	 */
	public void setSello(String sello) {
		this.sello = sello;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipConCatTip
	 */
	public Long getCodigoTipConCatTip() {
		return codigoTipConCatTip;
	}

	/**
	 * @param codigoTipConCatTip establece el valor a la propiedad codigoTipConCatTip
	 */
	public void setCodigoTipConCatTip(Long codigoTipConCatTip) {
		this.codigoTipConCatTip = codigoTipConCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipConCatVal
	 */
	public Long getCodigoTipConCatVal() {
		return codigoTipConCatVal;
	}

	/**
	 * @param codigoTipConCatVal establece el valor a la propiedad codigoTipConCatVal
	 */
	public void setCodigoTipConCatVal(Long codigoTipConCatVal) {
		this.codigoTipConCatVal = codigoTipConCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTamConCatTip
	 */
	public Long getCodigoTamConCatTip() {
		return codigoTamConCatTip;
	}

	/**
	 * @param codigoTamConCatTip establece el valor a la propiedad codigoTamConCatTip
	 */
	public void setCodigoTamConCatTip(Long codigoTamConCatTip) {
		this.codigoTamConCatTip = codigoTamConCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTamConCatVal
	 */
	public Long getCodigoTamConCatVal() {
		return codigoTamConCatVal;
	}

	/**
	 * @param codigoTamConCatVal establece el valor a la propiedad codigoTamConCatVal
	 */
	public void setCodigoTamConCatVal(Long codigoTamConCatVal) {
		this.codigoTamConCatVal = codigoTamConCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad tara
	 */
	public Double getTara() {
		return tara;
	}

	/**
	 * @param tara establece el valor a la propiedad tara
	 */
	public void setTara(Double tara) {
		this.tara = tara;
	}

	/**
	 * @return devuelve el valor de la propiedad cantidadCajas
	 */
	public Integer getCantidadCajas() {
		return cantidadCajas;
	}

	/**
	 * @param cantidadCajas establece el valor a la propiedad cantidadCajas
	 */
	public void setCantidadCajas(Integer cantidadCajas) {
		this.cantidadCajas = cantidadCajas;
	}

	/**
	 * @return devuelve el valor de la propiedad tipoContenedor
	 */
	public CatalogoValorImpDTO getTipoContenedor() {
		return tipoContenedor;
	}

	/**
	 * @param tipoContenedor establece el valor a la propiedad tipoContenedor
	 */
	public void setTipoContenedor(CatalogoValorImpDTO tipoContenedor) {
		this.tipoContenedor = tipoContenedor;
	}

	/**
	 * @return devuelve el valor de la propiedad tamanioContenedor
	 */
	public CatalogoValorImpDTO getTamanioContenedor() {
		return tamanioContenedor;
	}

	/**
	 * @param tamanioContenedor establece el valor a la propiedad tamanioContenedor
	 */
	public void setTamanioContenedor(CatalogoValorImpDTO tamanioContenedor) {
		this.tamanioContenedor = tamanioContenedor;
	}

	/**
	 * @return devuelve el valor de la propiedad selloManifestado
	 */
	public String getSelloManifestado() {
		return selloManifestado;
	}

	/**
	 * @param selloManifestado establece el valor a la propiedad selloManifestado
	 */
	public void setSelloManifestado(String selloManifestado) {
		this.selloManifestado = selloManifestado;
	}

	/**
	 * @return the facturaGastoEmbarqueContenedores
	 */
	public Collection<FacturaGastoEmbarqueContenedorImpDTO> getFacturaGastoEmbarqueContenedores() {
		return facturaGastoEmbarqueContenedores;
	}

	/**
	 * @param facturaGastoEmbarqueContenedores the facturaGastoEmbarqueContenedores to set
	 */
	public void setFacturaGastoEmbarqueContenedores(
			Collection<FacturaGastoEmbarqueContenedorImpDTO> facturaGastoEmbarqueContenedores) {
		this.facturaGastoEmbarqueContenedores = facturaGastoEmbarqueContenedores;
	}

	/**
	 * @return the fechaLlegadaBodega
	 */
	public Date getFechaLlegadaBodega() {
		return fechaLlegadaBodega;
	}

	/**
	 * @param fechaLlegadaBodega the fechaLlegadaBodega to set
	 */
	public void setFechaLlegadaBodega(Date fechaLlegadaBodega) {
		this.fechaLlegadaBodega = fechaLlegadaBodega;
	}
	
}
