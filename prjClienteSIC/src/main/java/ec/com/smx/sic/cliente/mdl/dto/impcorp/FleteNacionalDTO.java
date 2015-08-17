/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FleteNacionalID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SIADMTFLENAC")
public class FleteNacionalDTO extends AuditoriaBaseDTO<FleteNacionalID>{
	@Column(name = "CODIGOMERCADERIACATTIP")
	private Long codigoMercaderiaCatTip;
	
	@Column(name = "CODIGOMERCADERIACATVAL")
	private Long codigoMercaderiaCatVal;
	
	@Column(name = "CODIGOTIPCARCATTIP")
	private Long codigoTipCarCatTip;
	
	@Column(name = "CODIGOTIPCARCATVAL")
	private Long codigoTipCarCatVal;
	
	@Column(name = "CODIGOTAMCONCATTIP")
	private Long codigoTamConCatTip;
	
	@Column(name = "CODIGOTAMCONCATVAL")
	private Long codigoTamConCatVal;
	
	@Column(name = "CODIGOPUERTO")
	private String codigoPuerto;
	
	@Column(name = "VALOR")
	private Double valor;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMERCADERIACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMERCADERIACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoMercaderia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPCARCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPCARCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoCarga;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTAMCONCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTAMCONCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tamanioContenedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOPUERTO", referencedColumnName = "CODIGODIVGEOPOL", insertable = false, updatable = false)
	})
	private DivisionGeoPoliticaDTO puerto;
	
	/**
	 * @return devuelve el valor de la propiedad codigoMercaderiaCatTip
	 */
	public Long getCodigoMercaderiaCatTip() {
		return codigoMercaderiaCatTip;
	}

	/**
	 * @param codigoMercaderiaCatTip establece el valor a la propiedad codigoMercaderiaCatTip
	 */
	public void setCodigoMercaderiaCatTip(Long codigoMercaderiaCatTip) {
		this.codigoMercaderiaCatTip = codigoMercaderiaCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoMercaderiaCatVal
	 */
	public Long getCodigoMercaderiaCatVal() {
		return codigoMercaderiaCatVal;
	}

	/**
	 * @param codigoMercaderiaCatVal establece el valor a la propiedad codigoMercaderiaCatVal
	 */
	public void setCodigoMercaderiaCatVal(Long codigoMercaderiaCatVal) {
		this.codigoMercaderiaCatVal = codigoMercaderiaCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipCarCatTip
	 */
	public Long getCodigoTipCarCatTip() {
		return codigoTipCarCatTip;
	}

	/**
	 * @param codigoTipCarCatTip establece el valor a la propiedad codigoTipCarCatTip
	 */
	public void setCodigoTipCarCatTip(Long codigoTipCarCatTip) {
		this.codigoTipCarCatTip = codigoTipCarCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipCarCatVal
	 */
	public Long getCodigoTipCarCatVal() {
		return codigoTipCarCatVal;
	}

	/**
	 * @param codigoTipCarCatVal establece el valor a la propiedad codigoTipCarCatVal
	 */
	public void setCodigoTipCarCatVal(Long codigoTipCarCatVal) {
		this.codigoTipCarCatVal = codigoTipCarCatVal;
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
	 * @return devuelve el valor de la propiedad codigoPuerto
	 */
	public String getCodigoPuerto() {
		return codigoPuerto;
	}

	/**
	 * @param codigoPuerto establece el valor a la propiedad codigoPuerto
	 */
	public void setCodigoPuerto(String codigoPuerto) {
		this.codigoPuerto = codigoPuerto;
	}

	/**
	 * @return devuelve el valor de la propiedad valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor establece el valor a la propiedad valor
	 */
	public void setValor(Double valor) {
		this.valor = valor;
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
	 * @return devuelve el valor de la propiedad tipoMercaderia
	 */
	public CatalogoValorImpDTO getTipoMercaderia() {
		return tipoMercaderia;
	}

	/**
	 * @param tipoMercaderia establece el valor a la propiedad tipoMercaderia
	 */
	public void setTipoMercaderia(CatalogoValorImpDTO tipoMercaderia) {
		this.tipoMercaderia = tipoMercaderia;
	}

	/**
	 * @return devuelve el valor de la propiedad tipoCarga
	 */
	public CatalogoValorImpDTO getTipoCarga() {
		return tipoCarga;
	}

	/**
	 * @param tipoCarga establece el valor a la propiedad tipoCarga
	 */
	public void setTipoCarga(CatalogoValorImpDTO tipoCarga) {
		this.tipoCarga = tipoCarga;
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
	 * @return devuelve el valor de la propiedad puerto
	 */
	public DivisionGeoPoliticaDTO getPuerto() {
		return puerto;
	}

	/**
	 * @param puerto establece el valor a la propiedad puerto
	 */
	public void setPuerto(DivisionGeoPoliticaDTO puerto) {
		this.puerto = puerto;
	}
	
}
