//extends SimpleAuditDTO
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.VistaReporteEmbarqueID;

/**
 * 
 * @author dcruz
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMVEMBARQUE")
public class VistaEmbarqueDTO extends SimpleAuditDTO implements Serializable{
	
	@EmbeddedId
	private VistaReporteEmbarqueID id = new VistaReporteEmbarqueID();
		
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "INCOTERM")
	private String incoterm;
	
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
		
	@Column(name = "FECHAEMBARQUE")
	private Date fechaEmbarque;
	
	@Column(name = "FECHAARRIBO")
	private Date fechaArribo;
	
	@Column(name = "CODIGOAGENTEADUANERO")
	private String codigoAgenteAduanero;
	
	@Column(name = "CODIGOLINTRACATTIP")
	private Long codigoLinTraCatTip;
	
	@Column(name = "CODIGOLINTRACATVAL")
	private Long codigoLinTraCatVal;
		
	@Column(name = "ANIO")
	private String anio;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	
	@Column(name = "NUMEROCONTENEDORES")
	private Integer numeroContenedores;
	
	
	@Column(name = "CODIGOESTADOEMBARQUECATTIP")
	private Long codigoEstadoCatTip;
	
	@Column(name = "CODIGOESTADOEMBARQUECATVAL")
	private Long codigoEstadoCatVal;
	
	@Column(name = "ESTADOEMBARQUE")
	private String estadoEmbarque;
	
	@Column(name="TIPODOCUMENTO")
	private String tipoDocumento;
	
	@Column(name="NUMERODOCUMENTO")
	private String numeroDocumento;
	
	@Column(name="VALORFACTOR")
	private Double valorFactor;
	
	@Column(name="ESTADO")
	private String estado;

	@Column(name="FECHAAGENTEADUANERO")
	private Date fechaAgenteAduanero;
	
	@Column(name="ADUANACATALOGOTIPO")
	private Long aduanaCatTip;
	
	@Column(name="ADUANACATALOGOVALOR")
	private Long aduanaCatVal;
	
	@Column(name="ADUANA")
	private String aduana;
	
	@Column(name="NAVIERACATALOGOTIPO")
	private Long navieraCatTip;
	
	@Column(name="NAVIERACATALOGOVALOR")
	private Long navieraCatVal;
	
	@Column(name="NAVIERA")
	private String naviera;
	
	@Column(name="FECHALLEGADACD")
	private Date fechaLLegadaCD;
	
	@Column(name="VALORFLETE")
	private Double valorFlete;
	
	@Column(name="PUERTOEMBARQUE")
	private String puertoEmbarque;
	
	@Column(name="PUERTODESCARGA")
	private String puertoDescarga;
	
	@Transient
	private SearchResultDTO<VistaEmbarqueDTO> viResultDTO;
	
	@Transient
	private Collection<EmbarqueContenedorImpDTO> contenedores;
	
	@OneToMany(mappedBy = "reporteEmbarque")
	@CollectionTypeInfo(name = SICConstantes.USERTYPE_COLLECTION)
	private Collection<VistaEmbarqueFacturasDTO> facturas;
	
	
	@OneToMany(mappedBy = "reporteEmbarque")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<GastosEmbarqueFactorDTO> gastosEmbarque;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOAGENTEADUANERO", referencedColumnName = "CODIGOAGENTEADUANERO", insertable = false, updatable = false)})	
	private AgenteAduaneroDTO agenteAduanero;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLINTRACATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOLINTRACATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO lineaTransporte;
	
	
	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the numeroContenedores
	 */
	public Integer getNumeroContenedores() {
		return numeroContenedores;
	}

	/**
	 * @param numeroContenedores the numeroContenedores to set
	 */
	public void setNumeroContenedores(Integer numeroContenedores) {
		this.numeroContenedores = numeroContenedores;
	}

	/**
	 * @return the codigoEstadoCatTip
	 */
	public Long getCodigoEstadoCatTip() {
		return codigoEstadoCatTip;
	}

	/**
	 * @param codigoEstadoCatTip the codigoEstadoCatTip to set
	 */
	public void setCodigoEstadoCatTip(Long codigoEstadoCatTip) {
		this.codigoEstadoCatTip = codigoEstadoCatTip;
	}

	/**
	 * @return the codigoEstadoCatVal
	 */
	public Long getCodigoEstadoCatVal() {
		return codigoEstadoCatVal;
	}

	/**
	 * @param codigoEstadoCatVal the codigoEstadoCatVal to set
	 */
	public void setCodigoEstadoCatVal(Long codigoEstadoCatVal) {
		this.codigoEstadoCatVal = codigoEstadoCatVal;
	}

	/**
	 * @return the estadoEmbarque
	 */
	public String getEstadoEmbarque() {
		return estadoEmbarque;
	}

	/**
	 * @param estadoEmbarque the estadoEmbarque to set
	 */
	public void setEstadoEmbarque(String estadoEmbarque) {
		this.estadoEmbarque = estadoEmbarque;
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	
	
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * @return the valorFactor
	 */
	public Double getValorFactor() {
		return valorFactor;
	}

	/**
	 * @param valorFactor the valorFactor to set
	 */
	public void setValorFactor(Double valorFactor) {
		this.valorFactor = valorFactor;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the gastosEmbarque
	 */
	public Collection<GastosEmbarqueFactorDTO> getGastosEmbarque() {
		return gastosEmbarque;
	}

	/**
	 * @param gastosEmbarque the gastosEmbarque to set
	 */
	public void setGastosEmbarque(Collection<GastosEmbarqueFactorDTO> gastosEmbarque) {
		this.gastosEmbarque = gastosEmbarque;
	}

	/**
	 * @return the facturas
	 */
	public Collection<VistaEmbarqueFacturasDTO> getFacturas() {
		return facturas;
	}

	/**
	 * @param facturas the facturas to set
	 */
	public void setFacturas(Collection<VistaEmbarqueFacturasDTO> facturas) {
		this.facturas = facturas;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the id
	 */
	public VistaReporteEmbarqueID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaReporteEmbarqueID id) {
		this.id = id;
	}

	/**
	 * @return the fechaEmbarque
	 */
	public Date getFechaEmbarque() {
		return fechaEmbarque;
	}

	/**
	 * @param fechaEmbarque the fechaEmbarque to set
	 */
	public void setFechaEmbarque(Date fechaEmbarque) {
		this.fechaEmbarque = fechaEmbarque;
	}

	/**
	 * @return the fechaArribo
	 */
	public Date getFechaArribo() {
		return fechaArribo;
	}

	/**
	 * @param fechaArribo the fechaArribo to set
	 */
	public void setFechaArribo(Date fechaArribo) {
		this.fechaArribo = fechaArribo;
	}

	

	public String getIncoterm() {
		return incoterm;
	}

	public void setIncoterm(String incoterm) {
		this.incoterm = incoterm;
	}

	public String getCodigoAgenteAduanero() {
		return codigoAgenteAduanero;
	}

	public void setCodigoAgenteAduanero(String codigoAgenteAduanero) {
		this.codigoAgenteAduanero = codigoAgenteAduanero;
	}

	public Long getCodigoLinTraCatTip() {
		return codigoLinTraCatTip;
	}

	public void setCodigoLinTraCatTip(Long codigoLinTraCatTip) {
		this.codigoLinTraCatTip = codigoLinTraCatTip;
	}

	public Long getCodigoLinTraCatVal() {
		return codigoLinTraCatVal;
	}

	public void setCodigoLinTraCatVal(Long codigoLinTraCatVal) {
		this.codigoLinTraCatVal = codigoLinTraCatVal;
	}

	public AgenteAduaneroDTO getAgenteAduanero() {
		return agenteAduanero;
	}

	public void setAgenteAduanero(AgenteAduaneroDTO agenteAduanero) {
		this.agenteAduanero = agenteAduanero;
	}

	public CatalogoValorImpDTO getLineaTransporte() {
		return lineaTransporte;
	}

	public void setLineaTransporte(CatalogoValorImpDTO lineaTransporte) {
		this.lineaTransporte = lineaTransporte;
	}

	/**
	 * Fecha de envio al agente aduanero
	 */
	public Date getFechaAgenteAduanero() {
		return fechaAgenteAduanero;
	}

	public void setFechaAgenteAduanero(Date fechaAgenteAduanero) {
		this.fechaAgenteAduanero = fechaAgenteAduanero;
	}

	public Long getAduanaCatTip() {
		return aduanaCatTip;
	}

	public void setAduanaCatTip(Long aduanaCatTip) {
		this.aduanaCatTip = aduanaCatTip;
	}

	public Long getAduanaCatVal() {
		return aduanaCatVal;
	}

	public void setAduanaCatVal(Long aduanaCatVal) {
		this.aduanaCatVal = aduanaCatVal;
	}

	public String getAduana() {
		return aduana;
	}

	public void setAduana(String aduana) {
		this.aduana = aduana;
	}

	public Long getNavieraCatTip() {
		return navieraCatTip;
	}

	public void setNavieraCatTip(Long navieraCatTip) {
		this.navieraCatTip = navieraCatTip;
	}

	public Long getNavieraCatVal() {
		return navieraCatVal;
	}

	public void setNavieraCatVal(Long navieraCatVal) {
		this.navieraCatVal = navieraCatVal;
	}

	public Date getFechaLLegadaCD() {
		return fechaLLegadaCD;
	}

	public void setFechaLLegadaCD(Date fechaLLegadaCD) {
		this.fechaLLegadaCD = fechaLLegadaCD;
	}

	public Double getValorFlete() {
		return valorFlete;
	}

	public void setValorFlete(Double valorFlete) {
		this.valorFlete = valorFlete;
	}

	public SearchResultDTO<VistaEmbarqueDTO> getViResultDTO() {
		return viResultDTO;
	}

	public void setViResultDTO(SearchResultDTO<VistaEmbarqueDTO> viResultDTO) {
		this.viResultDTO = viResultDTO;
	}

	public Collection<EmbarqueContenedorImpDTO> getContenedores() {
		return contenedores;
	}

	public void setContenedores(Collection<EmbarqueContenedorImpDTO> contenedores) {
		this.contenedores = contenedores;
	}

	public String getNaviera() {
		return naviera;
	}

	public void setNaviera(String naviera) {
		this.naviera = naviera;
	}

	public String getPuertoEmbarque() {
		return puertoEmbarque;
	}

	public void setPuertoEmbarque(String puertoEmbarque) {
		this.puertoEmbarque = puertoEmbarque;
	}

	public String getPuertoDescarga() {
		return puertoDescarga;
	}

	public void setPuertoDescarga(String puertoDescarga) {
		this.puertoDescarga = puertoDescarga;
	}
	
	
}
