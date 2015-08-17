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
import javax.persistence.Transient;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.corpv2.dto.FormaPagoSistemaDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraFacturaImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FacturaImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACTURA")
public class FacturaImpDTO extends AuditoriaBaseDTO<FacturaImpID>{
	
	
	
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "FECHAFACTURA")
	private Date fechaFactura;
	
	@Column(name = "FECHALIMITEPAGO")
	private Date fechaLimitePago;
	
	@Column(name = "NUMERODR")
	private String numeroDR;

	@Column(name = "CODIGOTIPFACCATTIP")
	private Long codigoTipFacCatTip;
	
	@Column(name = "CODIGOTIPFACCATVAL")
	private Long codigoTipFacCatVal;
	
	@Column(name = "CODIGOFORMAPAGO")
	private Long codigoFormaPago;
	
	@Column(name = "CODIGOSISTEMA")
	private String codigoSistema;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "NUMEROCONTRATO")
	private String numeroContrato;
	
	@Column(name = "FECHACONTRATO")
	private Date fechaContrato;
	
	@Column(name = "ORDEN")
	private Integer orden;
	
	@Transient
	private Double valorTotal;
	
	
	
	@Column(name = "CODIGOESTMERCATTIP")
	private Long codigoEstMerCatTip;
	
	@Column(name = "CODIGOESTMERCATVAL")
	private Long codigoEstMerCatVal;
	
	
	@Column(name = "CODIGOESTTIPTRACATTIP")
	private Long codigoEstTipTraCatTip;
	
	@Column(name = "CODIGOESTTIPTRACATVAL")
	private Long codigoEstTipTraCatVal;
	
	
	@Column(name = "CODIGOUBIGEOCATTIP")
	private Long codigoUbicacionGeopoliticaCatTip;
	
	@Column(name = "CODIGOUBIGEOCATVAL")
	private Long codigoUbicacionGeopoliticaCatVal;
	
	
	@Column(name = "CODIGOBIECAPCATTIP")
	private Long codigoBienCapitalCatTip;
	
	@Column(name = "CODIGOBIECAPCATVAL")
	private Long codigoBienCapitalCatVal;
	
	
	
	@Column(name = "CODIGOFORENVCATTIP")
	private Long codigoFormaEnvioCatTip;
	
	@Column(name = "CODIGOFORENVCATVAL")
	private Long codigoFormaEnvioCatVal;
	
	
	
	@Column(name = "CODIGOMEDPAGCATTIP")
	private Long codigoMedioPagoCatTip;
	
	@Column(name = "CODIGOMEDPAGCATVAL")
	private Long codigoMedioPagoCatVal;
	
	
	@Column(name = "CODIGONATURALEZACATTIP")
	private Long codigoNaturalezaCatTip;
	
	@Column(name = "CODIGONATURALEZACATVAL")
	private Long codigoNaturalezaCatVal;
	
	
	@Column(name = "CODIGOMETVALCATTIP")
	private Long codigoMetValCatTip;
	
	@Column(name = "CODIGOMETVALCATVAL")
	private Long codigoMetValCatVal;
	
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTMERCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTMERCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO estadoMercancia; 
	
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTTIPTRACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTTIPTRACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoTratamiento; 
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOUBIGEOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOUBIGEOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO ubicacionGeopolitica; 
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBIECAPCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBIECAPCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO bienCapital; 
		

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFORENVCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFORENVCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO formaEnvio; 
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMEDPAGCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMEDPAGCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO medioPago;
	
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGONATURALEZACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGONATURALEZACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO naturaleza;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMETVALCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMETVALCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO metodoValor;
	
			
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false)
	})
	private EmbarqueImpDTO embarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
	})
	@Deprecated
	private OrdenCompraImpDTO ordenCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFORMAPAGO", referencedColumnName = "CODIGOFORMAPAGO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false)
	})
	private FormaPagoSistemaDTO formaPagoSistema;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPFACCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPFACCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoFactura; 
	
	@OneToMany(mappedBy = "factura")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FacturaDetalleImpDTO> facturaDetalles;
	
	@OneToMany(mappedBy="factura")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<OrdenCompraFacturaImpDTO> ordenCompraFacturas;
	
	@OneToMany(mappedBy="facturaImportacion")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<OrdenCompraFacturaImportacionDTO> ordenCompraFacturaImportacionDTOs;
	
	@Transient
	private OrdenCompraImpDTO npOrdenCompra;
	
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
	 * @return devuelve el valor de la propiedad codigoEmbarque
	 */
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque establece el valor a la propiedad codigoEmbarque
	 */
	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaFactura
	 */
	public Date getFechaFactura() {
		return fechaFactura;
	}

	/**
	 * @param fechaFactura establece el valor a la propiedad fechaFactura
	 */
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
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
	 * @return devuelve el valor de la propiedad ordenCompra
	 */
	@Deprecated
	public OrdenCompraImpDTO getOrdenCompra() {
		return ordenCompra;
	}

	/**
	 * @param ordenCompra establece el valor a la propiedad ordenCompra
	 */
	@Deprecated
	public void setOrdenCompra(OrdenCompraImpDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	/**
	 * @return devuelve el valor de la propiedad facturaDetalles
	 */
	public Collection<FacturaDetalleImpDTO> getFacturaDetalles() {
		return facturaDetalles;
	}

	/**
	 * @param facturaDetalles establece el valor a la propiedad facturaDetalles
	 */
	public void setFacturaDetalles(Collection<FacturaDetalleImpDTO> facturaDetalles) {
		this.facturaDetalles = facturaDetalles;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaLimitePago
	 */
	public Date getFechaLimitePago() {
		return fechaLimitePago;
	}

	/**
	 * @param fechaLimitePago establece el valor a la propiedad fechaLimitePago
	 */
	public void setFechaLimitePago(Date fechaLimitePago) {
		this.fechaLimitePago = fechaLimitePago;
	}

	/**
	 * @return devuelve el valor de la propiedad numeroDR
	 */
	public String getNumeroDR() {
		return numeroDR;
	}

	/**
	 * @param numeroDR establece el valor a la propiedad numeroDR
	 */
	public void setNumeroDR(String numeroDR) {
		this.numeroDR = numeroDR;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipFacCatTip
	 */
	public Long getCodigoTipFacCatTip() {
		return codigoTipFacCatTip;
	}

	/**
	 * @param codigoTipFacCatTip establece el valor a la propiedad codigoTipFacCatTip
	 */
	public void setCodigoTipFacCatTip(Long codigoTipFacCatTip) {
		this.codigoTipFacCatTip = codigoTipFacCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipFacCatVal
	 */
	public Long getCodigoTipFacCatVal() {
		return codigoTipFacCatVal;
	}

	/**
	 * @param codigoTipFacCatVal establece el valor a la propiedad codigoTipFacCatVal
	 */
	public void setCodigoTipFacCatVal(Long codigoTipFacCatVal) {
		this.codigoTipFacCatVal = codigoTipFacCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFormaPago
	 */
	public Long getCodigoFormaPago() {
		return codigoFormaPago;
	}

	/**
	 * @param codigoFormaPago establece el valor a la propiedad codigoFormaPago
	 */
	public void setCodigoFormaPago(Long codigoFormaPago) {
		this.codigoFormaPago = codigoFormaPago;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}

	/**
	 * @param codigoSistema establece el valor a la propiedad codigoSistema
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	/**
	 * @return devuelve el valor de la propiedad formaPagoSistema
	 */
	public FormaPagoSistemaDTO getFormaPagoSistema() {
		return formaPagoSistema;
	}

	/**
	 * @param formaPagoSistema establece el valor a la propiedad formaPagoSistema
	 */
	public void setFormaPagoSistema(FormaPagoSistemaDTO formaPagoSistema) {
		this.formaPagoSistema = formaPagoSistema;
	}

	/**
	 * @return devuelve el valor de la propiedad tipoFactura
	 */
	public CatalogoValorImpDTO getTipoFactura() {
		return tipoFactura;
	}

	/**
	 * @param tipoFactura establece el valor a la propiedad tipoFactura
	 */
	public void setTipoFactura(CatalogoValorImpDTO tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return the numeroContrato
	 */
	public String getNumeroContrato() {
		return numeroContrato;
	}

	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	/**
	 * @return the fechaContrato
	 */
	public Date getFechaContrato() {
		return fechaContrato;
	}

	/**
	 * @param fechaContrato the fechaContrato to set
	 */
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	/**
	 * @return the codigoEstMerCatTip
	 */
	public Long getCodigoEstMerCatTip() {
		return codigoEstMerCatTip;
	}

	/**
	 * @param codigoEstMerCatTip the codigoEstMerCatTip to set
	 */
	public void setCodigoEstMerCatTip(Long codigoEstMerCatTip) {
		this.codigoEstMerCatTip = codigoEstMerCatTip;
	}

	/**
	 * @return the codigoEstMerCatVal
	 */
	public Long getCodigoEstMerCatVal() {
		return codigoEstMerCatVal;
	}

	/**
	 * @param codigoEstMerCatVal the codigoEstMerCatVal to set
	 */
	public void setCodigoEstMerCatVal(Long codigoEstMerCatVal) {
		this.codigoEstMerCatVal = codigoEstMerCatVal;
	}

	/**
	 * @return the codigoEstTipTraCatTip
	 */
	public Long getCodigoEstTipTraCatTip() {
		return codigoEstTipTraCatTip;
	}

	/**
	 * @param codigoEstTipTraCatTip the codigoEstTipTraCatTip to set
	 */
	public void setCodigoEstTipTraCatTip(Long codigoEstTipTraCatTip) {
		this.codigoEstTipTraCatTip = codigoEstTipTraCatTip;
	}

	/**
	 * @return the codigoEstTipTraCatVal
	 */
	public Long getCodigoEstTipTraCatVal() {
		return codigoEstTipTraCatVal;
	}

	/**
	 * @param codigoEstTipTraCatVal the codigoEstTipTraCatVal to set
	 */
	public void setCodigoEstTipTraCatVal(Long codigoEstTipTraCatVal) {
		this.codigoEstTipTraCatVal = codigoEstTipTraCatVal;
	}

	/**
	 * @return the codigoUbicacionGeopoliticaCatTip
	 */
	public Long getCodigoUbicacionGeopoliticaCatTip() {
		return codigoUbicacionGeopoliticaCatTip;
	}

	/**
	 * @param codigoUbicacionGeopoliticaCatTip the codigoUbicacionGeopoliticaCatTip to set
	 */
	public void setCodigoUbicacionGeopoliticaCatTip(
			Long codigoUbicacionGeopoliticaCatTip) {
		this.codigoUbicacionGeopoliticaCatTip = codigoUbicacionGeopoliticaCatTip;
	}

	/**
	 * @return the codigoUbicacionGeopoliticaCatVal
	 */
	public Long getCodigoUbicacionGeopoliticaCatVal() {
		return codigoUbicacionGeopoliticaCatVal;
	}

	/**
	 * @param codigoUbicacionGeopoliticaCatVal the codigoUbicacionGeopoliticaCatVal to set
	 */
	public void setCodigoUbicacionGeopoliticaCatVal(
			Long codigoUbicacionGeopoliticaCatVal) {
		this.codigoUbicacionGeopoliticaCatVal = codigoUbicacionGeopoliticaCatVal;
	}

	/**
	 * @return the codigoBienCapitalCatTip
	 */
	public Long getCodigoBienCapitalCatTip() {
		return codigoBienCapitalCatTip;
	}

	/**
	 * @param codigoBienCapitalCatTip the codigoBienCapitalCatTip to set
	 */
	public void setCodigoBienCapitalCatTip(Long codigoBienCapitalCatTip) {
		this.codigoBienCapitalCatTip = codigoBienCapitalCatTip;
	}

	/**
	 * @return the codigoBienCapitalCatVal
	 */
	public Long getCodigoBienCapitalCatVal() {
		return codigoBienCapitalCatVal;
	}

	/**
	 * @param codigoBienCapitalCatVal the codigoBienCapitalCatVal to set
	 */
	public void setCodigoBienCapitalCatVal(Long codigoBienCapitalCatVal) {
		this.codigoBienCapitalCatVal = codigoBienCapitalCatVal;
	}

	/**
	 * @return the codigoFormaEnvioCatTip
	 */
	public Long getCodigoFormaEnvioCatTip() {
		return codigoFormaEnvioCatTip;
	}

	/**
	 * @param codigoFormaEnvioCatTip the codigoFormaEnvioCatTip to set
	 */
	public void setCodigoFormaEnvioCatTip(Long codigoFormaEnvioCatTip) {
		this.codigoFormaEnvioCatTip = codigoFormaEnvioCatTip;
	}

	/**
	 * @return the codigoFormaEnvioCatVal
	 */
	public Long getCodigoFormaEnvioCatVal() {
		return codigoFormaEnvioCatVal;
	}

	/**
	 * @param codigoFormaEnvioCatVal the codigoFormaEnvioCatVal to set
	 */
	public void setCodigoFormaEnvioCatVal(Long codigoFormaEnvioCatVal) {
		this.codigoFormaEnvioCatVal = codigoFormaEnvioCatVal;
	}

	/**
	 * @return the codigoMedioPagoCatTip
	 */
	public Long getCodigoMedioPagoCatTip() {
		return codigoMedioPagoCatTip;
	}

	/**
	 * @param codigoMedioPagoCatTip the codigoMedioPagoCatTip to set
	 */
	public void setCodigoMedioPagoCatTip(Long codigoMedioPagoCatTip) {
		this.codigoMedioPagoCatTip = codigoMedioPagoCatTip;
	}

	/**
	 * @return the codigoMedioPagoCatVal
	 */
	public Long getCodigoMedioPagoCatVal() {
		return codigoMedioPagoCatVal;
	}

	/**
	 * @param codigoMedioPagoCatVal the codigoMedioPagoCatVal to set
	 */
	public void setCodigoMedioPagoCatVal(Long codigoMedioPagoCatVal) {
		this.codigoMedioPagoCatVal = codigoMedioPagoCatVal;
	}

	/**
	 * @return the codigoNaturalezaCatTip
	 */
	public Long getCodigoNaturalezaCatTip() {
		return codigoNaturalezaCatTip;
	}

	/**
	 * @param codigoNaturalezaCatTip the codigoNaturalezaCatTip to set
	 */
	public void setCodigoNaturalezaCatTip(Long codigoNaturalezaCatTip) {
		this.codigoNaturalezaCatTip = codigoNaturalezaCatTip;
	}

	/**
	 * @return the codigoNaturalezaCatVal
	 */
	public Long getCodigoNaturalezaCatVal() {
		return codigoNaturalezaCatVal;
	}

	/**
	 * @param codigoNaturalezaCatVal the codigoNaturalezaCatVal to set
	 */
	public void setCodigoNaturalezaCatVal(Long codigoNaturalezaCatVal) {
		this.codigoNaturalezaCatVal = codigoNaturalezaCatVal;
	}

	/**
	 * @return the estadoMercancia
	 */
	public CatalogoValorImpDTO getEstadoMercancia() {
		return estadoMercancia;
	}

	/**
	 * @param estadoMercancia the estadoMercancia to set
	 */
	public void setEstadoMercancia(CatalogoValorImpDTO estadoMercancia) {
		this.estadoMercancia = estadoMercancia;
	}

	/**
	 * @return the estadoTipoTratamiento
	 */
	public CatalogoValorImpDTO getTipoTratamiento() {
		return tipoTratamiento;
	}

	/**
	 * @param estadoTipoTratamiento the estadoTipoTratamiento to set
	 */
	public void setTipoTratamiento(CatalogoValorImpDTO tipoTratamiento) {
		this.tipoTratamiento = tipoTratamiento;
	}
	
	
	/**
	 * @param estadoTipoTratamiento the estadoTipoTratamiento to set
	 */
	public void setEstadoTipoTratamiento(CatalogoValorImpDTO tipoTratamiento) {
		this.tipoTratamiento = tipoTratamiento;
	}

	/**
	 * @return the ubicacionGeopolitica
	 */
	public CatalogoValorImpDTO getUbicacionGeopolitica() {
		return ubicacionGeopolitica;
	}

	/**
	 * @param ubicacionGeopolitica the ubicacionGeopolitica to set
	 */
	public void setUbicacionGeopolitica(CatalogoValorImpDTO ubicacionGeopolitica) {
		this.ubicacionGeopolitica = ubicacionGeopolitica;
	}

	/**
	 * @return the bienCapital
	 */
	public CatalogoValorImpDTO getBienCapital() {
		return bienCapital;
	}

	/**
	 * @param bienCapital the bienCapital to set
	 */
	public void setBienCapital(CatalogoValorImpDTO bienCapital) {
		this.bienCapital = bienCapital;
	}

	/**
	 * @return the formaEnvio
	 */
	public CatalogoValorImpDTO getFormaEnvio() {
		return formaEnvio;
	}

	/**
	 * @param formaEnvio the formaEnvio to set
	 */
	public void setFormaEnvio(CatalogoValorImpDTO formaEnvio) {
		this.formaEnvio = formaEnvio;
	}

	/**
	 * @return the medioPago
	 */
	public CatalogoValorImpDTO getMedioPago() {
		return medioPago;
	}

	/**
	 * @param medioPago the medioPago to set
	 */
	public void setMedioPago(CatalogoValorImpDTO medioPago) {
		this.medioPago = medioPago;
	}

	/**
	 * @return the naturaleza
	 */
	public CatalogoValorImpDTO getNaturaleza() {
		return naturaleza;
	}

	/**
	 * @param naturaleza the naturaleza to set
	 */
	public void setNaturaleza(CatalogoValorImpDTO naturaleza) {
		this.naturaleza = naturaleza;
	}

	/**
	 * @return the codigoMetValCatTip
	 */
	public Long getCodigoMetValCatTip() {
		return codigoMetValCatTip;
	}

	/**
	 * @param codigoMetValCatTip the codigoMetValCatTip to set
	 */
	public void setCodigoMetValCatTip(Long codigoMetValCatTip) {
		this.codigoMetValCatTip = codigoMetValCatTip;
	}

	/**
	 * @return the codigoMetValCatVal
	 */
	public Long getCodigoMetValCatVal() {
		return codigoMetValCatVal;
	}

	/**
	 * @param codigoMetValCatVal the codigoMetValCatVal to set
	 */
	public void setCodigoMetValCatVal(Long codigoMetValCatVal) {
		this.codigoMetValCatVal = codigoMetValCatVal;
	}

	/**
	 * @return the metodoValor
	 */
	public CatalogoValorImpDTO getMetodoValor() {
		return metodoValor;
	}

	/**
	 * @param metodoValor the metodoValor to set
	 */
	public void setMetodoValor(CatalogoValorImpDTO metodoValor) {
		this.metodoValor = metodoValor;
	}

	/**
	 * @return the ordenCompraFacturas
	 */
	public Collection<OrdenCompraFacturaImpDTO> getOrdenCompraFacturas() {
		return ordenCompraFacturas;
	}

	/**
	 * @param ordenCompraFacturas the ordenCompraFacturas to set
	 */
	public void setOrdenCompraFacturas(
			Collection<OrdenCompraFacturaImpDTO> ordenCompraFacturas) {
		this.ordenCompraFacturas = ordenCompraFacturas;
	}

	public OrdenCompraImpDTO getNpOrdenCompra() {
		if(npOrdenCompra == null && CollectionUtils.isNotEmpty(ordenCompraFacturas))
			npOrdenCompra = ordenCompraFacturas.iterator().next().getOrdenCompra();
		return npOrdenCompra;
	}

	public void setNpOrdenCompra(OrdenCompraImpDTO npOrdenCompra) {
		this.npOrdenCompra = npOrdenCompra;
	}

	/**
	 * @return the ordenCompraFacturaImportacionDTOs
	 */
	public Collection<OrdenCompraFacturaImportacionDTO> getOrdenCompraFacturaImportacionDTOs() {
		return ordenCompraFacturaImportacionDTOs;
	}

	/**
	 * @param ordenCompraFacturaImportacionDTOs the ordenCompraFacturaImportacionDTOs to set
	 */
	public void setOrdenCompraFacturaImportacionDTOs(Collection<OrdenCompraFacturaImportacionDTO> ordenCompraFacturaImportacionDTOs) {
		this.ordenCompraFacturaImportacionDTOs = ordenCompraFacturaImportacionDTOs;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}


	
}
