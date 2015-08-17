/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.sql.Timestamp;
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
import ec.com.smx.corpv2.dto.MonedaSistemaDTO;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.OrdenCompraEstadoImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTORDCOMEST")
public class OrdenCompraEstadoImpDTO extends AuditoriaBaseDTO<OrdenCompraEstadoImpID>{
	@Column(name = "CODIGOESTADOCATTIP")
	private Long codigoEstadoCatTip;
	
	@Column(name = "CODIGOESTADOCATVAL")
	private Long codigoEstadoCatVal;
	
	@Column(name = "FECHAINICIO")
	private Timestamp fechaInicio;
	
	@Column(name = "FECHAFIN")
	private Timestamp fechaFin;
	
	@Column(name = "PROFORMA")
	private Boolean proforma;
	
	@Column(name = "APROBADA")
	private Boolean aprobada;
	
	@Column(name = "VALORTOTAL")
	private Double valorTotal;
	
	@Column(name = "VALORTOTALFINAL")
	private Double valorTotalFinal;
	
	@Column(name = "VALORDESCUENTO")
	private Double valorDescuento;
	
	@Column(name = "PORCENTAJEDESCUENTO")
	private Double porcentajeDescuento;
	
	@Column(name = "VALORFLETE")
	private Double valorFlete;
	
	@Column(name = "VALORSEGURO")
	private Double valorSeguro;
	
	@Column(name = "PESONETOTOTAL")
	private Double pesoNetoTotal;
	
	@Column(name = "PESOBRUTOTOTAL")
	private Double pesoBrutoTotal;
	
	@Column(name = "CANTIDADCAJASTOTAL")
	private Integer cantidadCajasTotal;
	
	@Column(name = "VOLUMENTOTAL")
	private Double volumenTotal;
	
	@Column(name = "CODIGOMONEDA")
	private Long codigoMoneda;
	
	@Column(name = "CODIGOSISTEMA")
	private String codigoSistema;
	
	@Column(name = "VALORCAMBIOMONEDA")
	private Double valorCambioMoneda;
	
	@Column(name = "FECHACAMBIOMONEDA")
	private Date fechaCambioMoneda;
	
	@Column(name="USUARIORESPONSABLE")
	private String usuarioResponsable;
	
	@Column(name="RESPONSABLECOMPRAS")
	private String usuarioCompras;
	
	@Column(name="RESPONSABLEOFIEXT")
	private String usuarioOfExt;
	
	@Column(name="CLIENTEDESTINO")
	private String clienteDestino;
	
	@Column(name = "FECHAESTIMADA")
	private Date fechaEstimadaLlegadaBodega;
	
	@Column(name = "APROBACIONPACKLIST")
	private String aprobacionPackList;
	
	@Column(name = "FECHAAPROBACIONEMBARQUE")
	private Timestamp fechaAprobacionEmbarque;
	
	@Transient
	private SearchResultDTO<OrdenCompraEstadoImpDTO> viResultDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USUARIORESPONSABLE", referencedColumnName="USERID", insertable=false, updatable=false)
	private UserDto usuarioResponsableDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RESPONSABLECOMPRAS", referencedColumnName="USERID", insertable=false, updatable=false)
	private UserDto usuarioComprasDTO;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RESPONSABLEOFIEXT", referencedColumnName="USERID", insertable=false, updatable=false)
	private UserDto usuarioOfExtDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTADOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTADOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO estadoOrdenCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", updatable = false, insertable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", updatable = false, insertable = false)
	})
	private OrdenCompraImpDTO ordenCompra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOMONEDA", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false)
	})
	private MonedaSistemaDTO monedaSistema;
	
	@OneToMany(mappedBy = "ordenCompraEstado")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<OrdenCompraDetalleEstadoImpDTO> ordenCompraDetallesEstado;
	

	/**
	 * @return devuelve el valor de la propiedad valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal establece el valor a la propiedad valorTotal
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad valorDescuento
	 */
	public Double getValorDescuento() {
		return valorDescuento;
	}

	/**
	 * @param valorDescuento establece el valor a la propiedad valorDescuento
	 */
	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	/**
	 * @return devuelve el valor de la propiedad valorFlete
	 */
	public Double getValorFlete() {
		return valorFlete;
	}

	/**
	 * @param valorFlete establece el valor a la propiedad valorFlete
	 */
	public void setValorFlete(Double valorFlete) {
		this.valorFlete = valorFlete;
	}

	/**
	 * @return devuelve el valor de la propiedad volumenTotal
	 */
	public Double getVolumenTotal() {
		return volumenTotal;
	}

	/**
	 * @param volumenTotal establece el valor a la propiedad volumenTotal
	 */
	public void setVolumenTotal(Double volumenTotal) {
		this.volumenTotal = volumenTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEstadoCatTip
	 */
	public Long getCodigoEstadoCatTip() {
		return codigoEstadoCatTip;
	}

	/**
	 * @param codigoEstadoCatTip establece el valor a la propiedad codigoEstadoCatTip
	 */
	public void setCodigoEstadoCatTip(Long codigoEstadoCatTip) {
		this.codigoEstadoCatTip = codigoEstadoCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEstadoCatVal
	 */
	public Long getCodigoEstadoCatVal() {
		return codigoEstadoCatVal;
	}

	/**
	 * @param codigoEstadoCatVal establece el valor a la propiedad codigoEstadoCatVal
	 */
	public void setCodigoEstadoCatVal(Long codigoEstadoCatVal) {
		this.codigoEstadoCatVal = codigoEstadoCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad proforma
	 */
	public Boolean getProforma() {
		return proforma;
	}

	/**
	 * @param proforma establece el valor a la propiedad proforma
	 */
	public void setProforma(Boolean proforma) {
		this.proforma = proforma;
	}

	/**
	 * @return devuelve el valor de la propiedad aprobada
	 */
	public Boolean getAprobada() {
		return aprobada;
	}

	/**
	 * @param aprobada establece el valor a la propiedad aprobada
	 */
	public void setAprobada(Boolean aprobada) {
		this.aprobada = aprobada;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio establece el valor a la propiedad fechaInicio
	 */
	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaFin
	 */
	public Timestamp getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin establece el valor a la propiedad fechaFin
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return devuelve el valor de la propiedad estadoOrdenCompra
	 */
	public CatalogoValorImpDTO getEstadoOrdenCompra() {
		return estadoOrdenCompra;
	}

	/**
	 * @param estadoOrdenCompra establece el valor a la propiedad estadoOrdenCompra
	 */
	public void setEstadoOrdenCompra(CatalogoValorImpDTO estadoOrdenCompra) {
		this.estadoOrdenCompra = estadoOrdenCompra;
	}

	/**
	 * @return devuelve el valor de la propiedad ordenCompra
	 */
	public OrdenCompraImpDTO getOrdenCompra() {
		return ordenCompra;
	}

	/**
	 * @param ordenCompra establece el valor a la propiedad ordenCompra
	 */
	public void setOrdenCompra(OrdenCompraImpDTO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	/**
	 * @return devuelve el valor de la propiedad ordenCompraDetallesEstado
	 */
	public Collection<OrdenCompraDetalleEstadoImpDTO> getOrdenCompraDetallesEstado() {
		return ordenCompraDetallesEstado;
	}

	/**
	 * @param ordenCompraDetallesEstado establece el valor a la propiedad ordenCompraDetallesEstado
	 */
	public void setOrdenCompraDetallesEstado(
			Collection<OrdenCompraDetalleEstadoImpDTO> ordenCompraDetallesEstado) {
		this.ordenCompraDetallesEstado = ordenCompraDetallesEstado;
	}
	
	/**
	 * @return devuelve el valor de la propiedad codigoMoneda
	 */
	public Long getCodigoMoneda() {
		return codigoMoneda;
	}

	/**
	 * @param codigoMoneda establece el valor a la propiedad codigoMoneda
	 */
	public void setCodigoMoneda(Long codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}
	
	/**
	 * @return devuelve el valor de la propiedad valorTotalFinal
	 */
	public Double getValorTotalFinal() {
		return valorTotalFinal;
	}

	/**
	 * @param valorTotalFinal establece el valor a la propiedad valorTotalFinal
	 */
	public void setValorTotalFinal(Double valorTotalFinal) {
		this.valorTotalFinal = valorTotalFinal;
	}

	/**
	 * @return devuelve el valor de la propiedad porcentajeDescuento
	 */
	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * @param porcentajeDescuento establece el valor a la propiedad porcentajeDescuento
	 */
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	/**
	 * @return devuelve el valor de la propiedad valorSeguro
	 */
	public Double getValorSeguro() {
		return valorSeguro;
	}

	/**
	 * @param valorSeguro establece el valor a la propiedad valorSeguro
	 */
	public void setValorSeguro(Double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoNetoTotal
	 */
	public Double getPesoNetoTotal() {
		return pesoNetoTotal;
	}

	/**
	 * @param pesoNetoTotal establece el valor a la propiedad pesoNetoTotal
	 */
	public void setPesoNetoTotal(Double pesoNetoTotal) {
		this.pesoNetoTotal = pesoNetoTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoBrutoTotal
	 */
	public Double getPesoBrutoTotal() {
		return pesoBrutoTotal;
	}

	/**
	 * @param pesoBrutoTotal establece el valor a la propiedad pesoBrutoTotal
	 */
	public void setPesoBrutoTotal(Double pesoBrutoTotal) {
		this.pesoBrutoTotal = pesoBrutoTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad cantidadCajasTotal
	 */
	public Integer getCantidadCajasTotal() {
		return cantidadCajasTotal;
	}

	/**
	 * @param cantidadCajasTotal establece el valor a la propiedad cantidadCajasTotal
	 */
	public void setCantidadCajasTotal(Integer cantidadCajasTotal) {
		this.cantidadCajasTotal = cantidadCajasTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad valorCambioMoneda
	 */
	public Double getValorCambioMoneda() {
		return valorCambioMoneda;
	}

	/**
	 * @param valorCambioMoneda establece el valor a la propiedad valorCambioMoneda
	 */
	public void setValorCambioMoneda(Double valorCambioMoneda) {
		this.valorCambioMoneda = valorCambioMoneda;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaCambioMoneda
	 */
	public Date getFechaCambioMoneda() {
		return fechaCambioMoneda;
	}

	/**
	 * @param fechaCambioMoneda establece el valor a la propiedad fechaCambioMoneda
	 */
	public void setFechaCambioMoneda(Date fechaCambioMoneda) {
		this.fechaCambioMoneda = fechaCambioMoneda;
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
	 * @return devuelve el valor de la propiedad monedaSistema
	 */
	public MonedaSistemaDTO getMonedaSistema() {
		return monedaSistema;
	}

	/**
	 * @param monedaSistema establece el valor a la propiedad monedaSistema
	 */
	public void setMonedaSistema(MonedaSistemaDTO monedaSistema) {
		this.monedaSistema = monedaSistema;
	}

	public String getUsuarioResponsable() {
		return usuarioResponsable;
	}

	public void setUsuarioResponsable(String usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}

	public UserDto getUsuarioResponsableDTO() {
		return usuarioResponsableDTO;
	}

	public void setUsuarioResponsableDTO(UserDto usuarioResponsableDTO) {
		this.usuarioResponsableDTO = usuarioResponsableDTO;
	}

	public String getUsuarioCompras() {
		return usuarioCompras;
	}

	public void setUsuarioCompras(String usuarioCompras) {
		this.usuarioCompras = usuarioCompras;
	}

	public String getUsuarioOfExt() {
		return usuarioOfExt;
	}

	public void setUsuarioOfExt(String usuarioOfExt) {
		this.usuarioOfExt = usuarioOfExt;
	}

	public String getClienteDestino() {
		return clienteDestino;
	}

	public void setClienteDestino(String clienteDestino) {
		this.clienteDestino = clienteDestino;
	}

	

	public Date getFechaEstimadaLlegadaBodega() {
		return fechaEstimadaLlegadaBodega;
	}

	public void setFechaEstimadaLlegadaBodega(Date fechaEstimadaLlegadaBodega) {
		this.fechaEstimadaLlegadaBodega = fechaEstimadaLlegadaBodega;
	}

	public UserDto getUsuarioComprasDTO() {
		return usuarioComprasDTO;
	}

	public void setUsuarioComprasDTO(UserDto usuarioComprasDTO) {
		this.usuarioComprasDTO = usuarioComprasDTO;
	}

	public UserDto getUsuarioOfExtDTO() {
		return usuarioOfExtDTO;
	}

	public void setUsuarioOfExtDTO(UserDto usuarioOfExtDTO) {
		this.usuarioOfExtDTO = usuarioOfExtDTO;
	}

	public String getAprobacionPackList() {
		return aprobacionPackList;
	}

	public void setAprobacionPackList(String aprobacionPackList) {
		this.aprobacionPackList = aprobacionPackList;
	}

	/**
	 * @return the viResultDTO
	 */
	public SearchResultDTO<OrdenCompraEstadoImpDTO> getViResultDTO() {
		return viResultDTO;
	}

	/**
	 * @param viResultDTO the viResultDTO to set
	 */
	public void setViResultDTO(SearchResultDTO<OrdenCompraEstadoImpDTO> viResultDTO) {
		this.viResultDTO = viResultDTO;
	}

	public Timestamp getFechaAprobacionEmbarque() {
		return fechaAprobacionEmbarque;
	}

	public void setFechaAprobacionEmbarque(Timestamp fechaAprobacionEmbarque) {
		this.fechaAprobacionEmbarque = fechaAprobacionEmbarque;
	}

	
	
	
}
