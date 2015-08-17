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

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.dto.SearchResultDTO;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.TramiteEmbarqueImpID;

/**
 * 
 * @author acastillo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTTRAEMB")
public class TramiteEmbarqueImpDTO extends AuditoriaBaseDTO<TramiteEmbarqueImpID>{
	
	@Column(name="CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name="CODIGOORDENCOMPRA")
	private Long codigoOrdenCompra;
	
	@Column(name="MERCADERIA")
	private String mercaderia;
	
	@Column(name="CODTIPTRACATTIP")
	private Long codigoTipoTramite;
	
	@Column(name="CODTIPTRACATVAL")
	private Long codigoValorTramite;
	
	@Column(name="NUMOFICIOEXCEPCION")
	private String numeroOficioExcepcion;
	
	@Column(name="FECHAOFICIOEXCEPCION")
	private Date fechaOficioExcepcion;
	
	@Column(name="FECHARECEPCIONTESTREPORT")
	private Date fechaRecepcionTestReport;
	
	@Column(name="FECHADECLARACIONJURAMENTADA")
	private Date fechaDeclaracionJuramentada;
	
	@Column(name="NUMSOLICITUDINEN")
	private String numeroSolicitudINEN;
	
	@Column(name="FECHAINGRESOSOLICITUDINEN")
	private Date fechaIngSolINEN;
	
	@Column(name="FECHAPAGOAUTORIZADO")
	private Date fechaPagoAutorizado;
	
	@Column(name="FECHAPAGOCONFIRMADOINEN")
	private Date fechaPagoConfirmadoINEN;
	
	@Column(name="CODESTCATVAL")
	private Long codigoEstadoTipo;
	
	@Column(name="CODESTCATTIP")
	private Long codigoEstadoValor;
	
	@Column(name="ROP")
	private String rop;
	
	@Column(name="OBSERVACIONGENERAL")
	private String observacionGeneral;
	
	@Column(name="FECHADECLARACION")
	private Date fechaDeclaracion;
	
	@Transient
	private SearchResultDTO<TramiteEmbarqueImpDTO> searchResultDTO;
	
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
    private OrdenCompraImpDTO ordenCompraImpDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODTIPTRACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODTIPTRACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO tramite;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODESTCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODESTCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO estadoTramite;
	
	@OneToMany(mappedBy="tramiteEmbarque")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<BitacoraTramiteEmbarqueImpDTO> bitacoraTramiteEmbarques;
	
	@OneToMany(mappedBy="tramiteEmbarque")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<TramiteArchivoImpDTO> tramiteArchivos;

	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	public Long getCodigoOrdenCompra() {
		return codigoOrdenCompra;
	}

	public void setCodigoOrdenCompra(Long codigoOrdenCompra) {
		this.codigoOrdenCompra = codigoOrdenCompra;
	}

	public String getMercaderia() {
		return mercaderia;
	}

	public void setMercaderia(String mercaderia) {
		this.mercaderia = mercaderia;
	}

	public Long getCodigoTipoTramite() {
		return codigoTipoTramite;
	}

	public void setCodigoTipoTramite(Long codigoTipoTramite) {
		this.codigoTipoTramite = codigoTipoTramite;
	}

	public Long getCodigoValorTramite() {
		return codigoValorTramite;
	}

	public void setCodigoValorTramite(Long codigoValorTramite) {
		this.codigoValorTramite = codigoValorTramite;
	}

	public String getNumeroOficioExcepcion() {
		return numeroOficioExcepcion;
	}

	public void setNumeroOficioExcepcion(String numeroOficioExcepcion) {
		this.numeroOficioExcepcion = numeroOficioExcepcion;
	}

	public Date getFechaOficioExcepcion() {
		return fechaOficioExcepcion;
	}

	public void setFechaOficioExcepcion(Date fechaOficioExcepcion) {
		this.fechaOficioExcepcion = fechaOficioExcepcion;
	}

	public Date getFechaRecepcionTestReport() {
		return fechaRecepcionTestReport;
	}

	public void setFechaRecepcionTestReport(Date fechaRecepcionTestReport) {
		this.fechaRecepcionTestReport = fechaRecepcionTestReport;
	}

	public Date getFechaDeclaracionJuramentada() {
		return fechaDeclaracionJuramentada;
	}

	public void setFechaDeclaracionJuramentada(Date fechaDeclaracionJuramentada) {
		this.fechaDeclaracionJuramentada = fechaDeclaracionJuramentada;
	}

	public String getNumeroSolicitudINEN() {
		return numeroSolicitudINEN;
	}

	public void setNumeroSolicitudINEN(String numeroSolicitudINEN) {
		this.numeroSolicitudINEN = numeroSolicitudINEN;
	}

	public Date getFechaIngSolINEN() {
		return fechaIngSolINEN;
	}

	public void setFechaIngSolINEN(Date fechaIngSolINEN) {
		this.fechaIngSolINEN = fechaIngSolINEN;
	}

	public Date getFechaPagoAutorizado() {
		return fechaPagoAutorizado;
	}

	public void setFechaPagoAutorizado(Date fechaPagoAutorizado) {
		this.fechaPagoAutorizado = fechaPagoAutorizado;
	}

	public Date getFechaPagoConfirmadoINEN() {
		return fechaPagoConfirmadoINEN;
	}

	public void setFechaPagoConfirmadoINEN(Date fechaPagoConfirmadoINEN) {
		this.fechaPagoConfirmadoINEN = fechaPagoConfirmadoINEN;
	}

	public Long getCodigoEstadoTipo() {
		return codigoEstadoTipo;
	}

	public void setCodigoEstadoTipo(Long codigoEstadoTipo) {
		this.codigoEstadoTipo = codigoEstadoTipo;
	}

	public Long getCodigoEstadoValor() {
		return codigoEstadoValor;
	}

	public void setCodigoEstadoValor(Long codigoEstadoValor) {
		this.codigoEstadoValor = codigoEstadoValor;
	}

	public String getRop() {
		return rop;
	}

	public void setRop(String rop) {
		this.rop = rop;
	}

	public EmbarqueImpDTO getEmbarque() {
		return embarque;
	}

	public void setEmbarque(EmbarqueImpDTO embarque) {
		this.embarque = embarque;
	}

	public OrdenCompraImpDTO getOrdenCompraImpDTO() {
		return ordenCompraImpDTO;
	}

	public void setOrdenCompraImpDTO(OrdenCompraImpDTO ordenCompraImpDTO) {
		this.ordenCompraImpDTO = ordenCompraImpDTO;
	}

	public CatalogoValorImpDTO getTramite() {
		return tramite;
	}

	public void setTramite(CatalogoValorImpDTO tramite) {
		this.tramite = tramite;
	}

	public CatalogoValorImpDTO getEstadoTramite() {
		return estadoTramite;
	}

	public void setEstadoTramite(CatalogoValorImpDTO estadoTramite) {
		this.estadoTramite = estadoTramite;
	}

	public Collection<BitacoraTramiteEmbarqueImpDTO> getBitacoraTramiteEmbarques() {
		return bitacoraTramiteEmbarques;
	}

	public void setBitacoraTramiteEmbarques(Collection<BitacoraTramiteEmbarqueImpDTO> bitacoraTramiteEmbarques) {
		this.bitacoraTramiteEmbarques = bitacoraTramiteEmbarques;
	}

	public Collection<TramiteArchivoImpDTO> getTramiteArchivos() {
		return tramiteArchivos;
	}

	public void setTramiteArchivos(Collection<TramiteArchivoImpDTO> tramiteArchivos) {
		this.tramiteArchivos = tramiteArchivos;
	}

	public String getObservacionGeneral() {
		return observacionGeneral;
	}

	public void setObservacionGeneral(String observacionGeneral) {
		this.observacionGeneral = observacionGeneral;
	}

	public Date getFechaDeclaracion() {
		return fechaDeclaracion;
	}

	public void setFechaDeclaracion(Date fechaDeclaracion) {
		this.fechaDeclaracion = fechaDeclaracion;
	}

	public SearchResultDTO<TramiteEmbarqueImpDTO> getSearchResultDTO() {
		return searchResultDTO;
	}

	public void setSearchResultDTO(SearchResultDTO<TramiteEmbarqueImpDTO> searchResultDTO) {
		this.searchResultDTO = searchResultDTO;
	}
	
	
		
}
