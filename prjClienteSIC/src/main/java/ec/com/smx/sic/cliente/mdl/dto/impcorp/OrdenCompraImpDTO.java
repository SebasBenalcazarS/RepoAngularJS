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
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.corpv2.dto.FormaPagoSistemaDTO;
import ec.com.smx.sic.cliente.mdl.dto.ProveedorOficinaExteriorDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.OrdenCompraImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTORDCOM")
public class OrdenCompraImpDTO extends AuditoriaBaseDTO<OrdenCompraImpID>{
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "FECHAORDENCOMPRA")
	private Date fechaOrdenCompra;
	
	@Column(name = "AREA")
	private String area;
	
	@Column(name = "CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	@Column(name = "CODIGOOFICINAEXTERIOR")
	private Integer codigoOficinaExterior;
	
	@Column(name = "CODIGOCLIENTEIMPORTACION")
	private Long codigoClienteImportacion;
	
	@Column(name = "CODIGOCOMPRADOR")
	private String codigoComprador;
	
	@Column(name = "CODIGOFORMAPAGO")
	private Long codigoFormaPago;
	
	@Column(name = "CODIGOSISTEMAFP")
	private String codigoSistemaFP;
	
	@Column(name = "CODIGOMODTRACATTIP")
	private Long codigoModTraCatTip;
	
	@Column(name = "CODIGOMODTRACATVAL")
	private Long codigoModTraCatVal;
	
	@Column(name = "CODIGOPUERTOEMBARQUE")
	private String codigoPuertoEmbarque;
	
	@Column(name = "CODIGOPUERTODESCARGA")
	private String codigoPuertoDescarga;
	
	@Column(name = "CODIGOSEGUROCATTIP")
	private Long codigoSeguroCatTip;
	
	@Column(name = "CODIGOSEGUROCATVAL")
	private Long codigoSeguroCatVal;
	
	@Column(name = "CODIGOMERCADERIACATTIP")
	private Long codigoMercaderiaCatTip;
	
	@Column(name = "CODIGOMERCADERIACATVAL")
	private Long codigoMercaderiaCatVal;
	
	@Column(name = "CODIGOTIPOCATTIP")
	private Long codigoTipoCatTip;
	
	@Column(name = "CODIGOTIPOCATVAL")
	private Long codigoTipoCatVal;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "CODIGOREFERENCIAEXTERNA")
	private String codigoReferenciaExterna;
	
	@Column(name = "NUMEROCASO")
	private String numeroCaso;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", updatable = false, insertable = false),
		@JoinColumn(name = "CODIGOCLIENTEIMPORTACION", referencedColumnName = "CODIGOCLIENTEIMPORTACION", updatable = false, insertable = false),
		@JoinColumn(name = "CODIGOCOMPRADOR", referencedColumnName = "CODIGOCOMPRADOR", updatable = false, insertable = false)
	})
	private ClienteImportacionCompradorDTO clienteImportacioComprador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", updatable = false, insertable = false),
		@JoinColumn(name = "CODIGOFORMAPAGO", referencedColumnName = "CODIGOFORMAPAGO", updatable = false, insertable = false),
		@JoinColumn(name = "CODIGOSISTEMAFP", referencedColumnName = "CODIGOSISTEMA", updatable = false, insertable = false)
	})
	private FormaPagoSistemaDTO formaPagoSistema;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOOFICINAEXTERIOR", referencedColumnName = "CODIGOOFICINAEXTERIOR", insertable = false, updatable = false)
	})
	private ProveedorOficinaExteriorDTO proveedorOficinaExterior;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private VistaProveedorDTO vistaProveedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMODTRACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMODTRACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO modoTransporte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOPUERTOEMBARQUE", referencedColumnName = "CODIGODIVGEOPOL", insertable = false, updatable = false)
	})
	private DivisionGeoPoliticaDTO puertoEmbarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOPUERTODESCARGA", referencedColumnName = "CODIGODIVGEOPOL", insertable = false, updatable = false)
	})
	private DivisionGeoPoliticaDTO puertoDescarga;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOSEGUROCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOSEGUROCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipoSeguro;
	
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
		@JoinColumn(name = "CODIGOTIPOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tipo;
	
	
	
	
	@OneToMany(mappedBy = "ordenCompra")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<OrdenCompraFacturaImpDTO> ordenCompraFacturas;
	
	@OneToMany(mappedBy = "ordenCompra")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<OrdenCompraDetalleImpDTO> ordenCompraDetalles;
	
	@OneToMany(mappedBy = "ordenCompra")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<OrdenCompraEstadoImpDTO> ordenCompraEstado;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false)
		
	})
	private VistaEmbarqueAsistenteWorkFlowDTO reporteEmbarque;
	
	
	
	public Collection<OrdenCompraDetalleImpDTO> getOrdenCompraDetalles() {
		return ordenCompraDetalles;
	}

	public void setOrdenCompraDetalles(Collection<OrdenCompraDetalleImpDTO> ordenCompraDetalles) {
		this.ordenCompraDetalles = ordenCompraDetalles;
	}

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
	 * @return devuelve el valor de la propiedad fechaOrdenCompra
	 */
	public Date getFechaOrdenCompra() {
		return fechaOrdenCompra;
	}

	/**
	 * @param fechaOrdenCompra establece el valor a la propiedad fechaOrdenCompra
	 */
	public void setFechaOrdenCompra(Date fechaOrdenCompra) {
		this.fechaOrdenCompra = fechaOrdenCompra;
	}

	/**
	 * @return devuelve el valor de la propiedad area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area establece el valor a la propiedad area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoComprador
	 */
	public String getCodigoComprador() {
		return codigoComprador;
	}

	/**
	 * @param codigoComprador establece el valor a la propiedad codigoComprador
	 */
	public void setCodigoComprador(String codigoComprador) {
		this.codigoComprador = codigoComprador;
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
	 * @return devuelve el valor de la propiedad codigoPuertoEmbarque
	 */
	public String getCodigoPuertoEmbarque() {
		return codigoPuertoEmbarque;
	}

	/**
	 * @param codigoPuertoEmbarque establece el valor a la propiedad codigoPuertoEmbarque
	 */
	public void setCodigoPuertoEmbarque(String codigoPuertoEmbarque) {
		this.codigoPuertoEmbarque = codigoPuertoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoPuertoDescarga
	 */
	public String getCodigoPuertoDescarga() {
		return codigoPuertoDescarga;
	}

	/**
	 * @param codigoPuertoDescarga establece el valor a la propiedad codigoPuertoDescarga
	 */
	public void setCodigoPuertoDescarga(String codigoPuertoDescarga) {
		this.codigoPuertoDescarga = codigoPuertoDescarga;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoSeguroCatTip
	 */
	public Long getCodigoSeguroCatTip() {
		return codigoSeguroCatTip;
	}

	/**
	 * @param codigoSeguroCatTip establece el valor a la propiedad codigoSeguroCatTip
	 */
	public void setCodigoSeguroCatTip(Long codigoSeguroCatTip) {
		this.codigoSeguroCatTip = codigoSeguroCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoSeguroCatVal
	 */
	public Long getCodigoSeguroCatVal() {
		return codigoSeguroCatVal;
	}

	/**
	 * @param codigoSeguroCatVal establece el valor a la propiedad codigoSeguroCatVal
	 */
	public void setCodigoSeguroCatVal(Long codigoSeguroCatVal) {
		this.codigoSeguroCatVal = codigoSeguroCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad puertoEmbarque
	 */
	public DivisionGeoPoliticaDTO getPuertoEmbarque() {
		return puertoEmbarque;
	}

	/**
	 * @param puertoEmbarque establece el valor a la propiedad puertoEmbarque
	 */
	public void setPuertoEmbarque(DivisionGeoPoliticaDTO puertoEmbarque) {
		this.puertoEmbarque = puertoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad puertoDescarga
	 */
	public DivisionGeoPoliticaDTO getPuertoDescarga() {
		return puertoDescarga;
	}

	/**
	 * @param puertoDescarga establece el valor a la propiedad puertoDescarga
	 */
	public void setPuertoDescarga(DivisionGeoPoliticaDTO puertoDescarga) {
		this.puertoDescarga = puertoDescarga;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor establece el valor a la propiedad codigoProveedor
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoOficinaExterior
	 */
	public Integer getCodigoOficinaExterior() {
		return codigoOficinaExterior;
	}

	/**
	 * @param codigoOficinaExterior establece el valor a la propiedad codigoOficinaExterior
	 */
	public void setCodigoOficinaExterior(Integer codigoOficinaExterior) {
		this.codigoOficinaExterior = codigoOficinaExterior;
	}

	/**
	 * @return devuelve el valor de la propiedad proveedorOficinaExterior
	 */
	public ProveedorOficinaExteriorDTO getProveedorOficinaExterior() {
		return proveedorOficinaExterior;
	}

	/**
	 * @param proveedorOficinaExterior establece el valor a la propiedad proveedorOficinaExterior
	 */
	public void setProveedorOficinaExterior(
			ProveedorOficinaExteriorDTO proveedorOficinaExterior) {
		this.proveedorOficinaExterior = proveedorOficinaExterior;
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
	 * @return devuelve el valor de la propiedad codigoSistemaFP
	 */
	public String getCodigoSistemaFP() {
		return codigoSistemaFP;
	}

	/**
	 * @param codigoSistemaFP establece el valor a la propiedad codigoSistemaFP
	 */
	public void setCodigoSistemaFP(String codigoSistemaFP) {
		this.codigoSistemaFP = codigoSistemaFP;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoModTraCatTip
	 */
	public Long getCodigoModTraCatTip() {
		return codigoModTraCatTip;
	}

	/**
	 * @param codigoModTraCatTip establece el valor a la propiedad codigoModTraCatTip
	 */
	public void setCodigoModTraCatTip(Long codigoModTraCatTip) {
		this.codigoModTraCatTip = codigoModTraCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoModTraCatVal
	 */
	public Long getCodigoModTraCatVal() {
		return codigoModTraCatVal;
	}

	/**
	 * @param codigoModTraCatVal establece el valor a la propiedad codigoModTraCatVal
	 */
	public void setCodigoModTraCatVal(Long codigoModTraCatVal) {
		this.codigoModTraCatVal = codigoModTraCatVal;
	}

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
	 * @return devuelve el valor de la propiedad modoTransporte
	 */
	public CatalogoValorImpDTO getModoTransporte() {
		return modoTransporte;
	}

	/**
	 * @param modoTransporte establece el valor a la propiedad modoTransporte
	 */
	public void setModoTransporte(CatalogoValorImpDTO modoTransporte) {
		this.modoTransporte = modoTransporte;
	}

	/**
	 * @return devuelve el valor de la propiedad tipoSeguro
	 */
	public CatalogoValorImpDTO getTipoSeguro() {
		return tipoSeguro;
	}

	/**
	 * @param tipoSeguro establece el valor a la propiedad tipoSeguro
	 */
	public void setTipoSeguro(CatalogoValorImpDTO tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
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
	 * @return devuelve el valor de la propiedad codigoTipoCatTip
	 */
	public Long getCodigoTipoCatTip() {
		return codigoTipoCatTip;
	}

	/**
	 * @param codigoTipoCatTip establece el valor a la propiedad codigoTipoCatTip
	 */
	public void setCodigoTipoCatTip(Long codigoTipoCatTip) {
		this.codigoTipoCatTip = codigoTipoCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoTipoCatVal
	 */
	public Long getCodigoTipoCatVal() {
		return codigoTipoCatVal;
	}

	/**
	 * @param codigoTipoCatVal establece el valor a la propiedad codigoTipoCatVal
	 */
	public void setCodigoTipoCatVal(Long codigoTipoCatVal) {
		this.codigoTipoCatVal = codigoTipoCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad tipo
	 */
	public CatalogoValorImpDTO getTipo() {
		return tipo;
	}

	/**
	 * @param tipo establece el valor a la propiedad tipo
	 */
	public void setTipo(CatalogoValorImpDTO tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return devuelve el valor de la propiedad vistaProveedor
	 */
	public VistaProveedorDTO getVistaProveedor() {
		return vistaProveedor;
	}

	/**
	 * @param vistaProveedor establece el valor a la propiedad vistaProveedor
	 */
	public void setVistaProveedor(VistaProveedorDTO vistaProveedor) {
		this.vistaProveedor = vistaProveedor;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoClienteImportacion
	 */
	public Long getCodigoClienteImportacion() {
		return codigoClienteImportacion;
	}

	/**
	 * @param codigoClienteImportacion establece el valor a la propiedad codigoClienteImportacion
	 */
	public void setCodigoClienteImportacion(Long codigoClienteImportacion) {
		this.codigoClienteImportacion = codigoClienteImportacion;
	}

	/**
	 * @return devuelve el valor de la propiedad clienteImportacioComprador
	 */
	public ClienteImportacionCompradorDTO getClienteImportacioComprador() {
		return clienteImportacioComprador;
	}

	/**
	 * @param clienteImportacioComprador establece el valor a la propiedad clienteImportacioComprador
	 */
	public void setClienteImportacioComprador(
			ClienteImportacionCompradorDTO clienteImportacioComprador) {
		this.clienteImportacioComprador = clienteImportacioComprador;
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

	public String getCodigoReferenciaExterna() {
		return codigoReferenciaExterna;
	}

	public void setCodigoReferenciaExterna(String codigoReferenciaExterna) {
		this.codigoReferenciaExterna = codigoReferenciaExterna;
	}

	public String getNumeroCaso() {
		return numeroCaso;
	}

	public void setNumeroCaso(String numeroCaso) {
		this.numeroCaso = numeroCaso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * @return the reporteEmbarque
	 */
	public VistaEmbarqueAsistenteWorkFlowDTO getReporteEmbarque() {
		return reporteEmbarque;
	}

	/**
	 * @param reporteEmbarque the reporteEmbarque to set
	 */
	public void setReporteEmbarque(VistaEmbarqueAsistenteWorkFlowDTO reporteEmbarque) {
		this.reporteEmbarque = reporteEmbarque;
	}

	/**
	 * @return the ordenCompraEstado
	 */
	public Collection<OrdenCompraEstadoImpDTO> getOrdenCompraEstado() {
		return ordenCompraEstado;
	}

	/**
	 * @param ordenCompraEstado the ordenCompraEstado to set
	 */
	public void setOrdenCompraEstado(Collection<OrdenCompraEstadoImpDTO> ordenCompraEstado) {
		this.ordenCompraEstado = ordenCompraEstado;
	}

	
}
