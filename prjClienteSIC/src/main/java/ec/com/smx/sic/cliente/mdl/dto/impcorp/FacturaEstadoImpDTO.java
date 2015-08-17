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

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.corpv2.dto.MonedaSistemaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FacturaEstadoImpID;

/**
 * @author jvillacis
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACEST")
public class FacturaEstadoImpDTO extends AuditoriaBaseDTO<FacturaEstadoImpID> {
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;

	@Column(name = "CODIGOEMBARQUEESTADO")
	private Long codigoEmbarqueEstado;

	@Column(name = "CODIGOESTADOCATTIP")
	private Long codigoEstadoCatTip;

	@Column(name = "CODIGOESTADOCATVAL")
	private Long codigoEstadoCatVal;

	@Column(name = "FECHAINICIO")
	private Timestamp fechaInicio;

	@Column(name = "FECHAFIN")
	private Timestamp fechaFin;

	@Column(name = "VALORTOTAL")
	private Double valorTotal;

	@Column(name = "VALORTOTALFINAL")
	private Double valorTotalFinal;

	@Column(name = "VALORFLETE")
	private Double valorFlete;

	@Column(name = "VALORSEGURO")
	private Double valorSeguro;

	@Column(name = "VALORSEGURONACIONAL")
	private Double valorSeguroNacional;

	@Column(name = "VALORINLAND")
	private Double valorInland;

	@Column(name = "VALORENVASEEMBALAJE")
	private Double valorEnvaseEmbalaje;

	@Column(name = "VALORESTIBA")
	private Double valorEstiba;

	@Column(name = "PORCENTAJEDESCUENTO")
	private Double porcentajeDescuento;

	@Column(name = "VALORDESCUENTO")
	private Double valorDescuento;

	@Column(name = "PESONETOTOTAL")
	private Double pesoNetoTotal;

	@Column(name = "PESOBRUTOTOTAL")
	private Double pesoBrutoTotal;

	@Column(name = "CANTIDADCAJAS")
	private Integer cantidadCajas;

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

	@Column(name = "PESONETOTOTALPL")
	private Double pesoNetoTotalPL;

	@Column(name = "PESOBRUTOTOTALPL")
	private Double pesoBrutoTotalPL;

	@Column(name = "CANTIDADCAJASPL")
	private Integer cantidadCajasPL;

	@Column(name = "NUMEROFP")
	private String numeroFP;

	@Column(name = "PORCENTAJEINCREMENTO")
	private Double porcentajeIncremento;

	@Column(name = "VALORTOTALFP")
	private Double valorTotalFP;

	@Column(name = "PESONETOTOTALFP")
	private Double pesoNetoTotalFP;

	@Column(name = "PESOBRUTOTOTALFP")
	private Double pesoBrutoTotalFP;

	@Column(name = "CANTIDADCAJASFP")
	private Integer cantidadCajasFP;

	@Column(name = "CODIGOMONEDAFOB")
	private Long codigoMonedaFob;

	@Column(name = "VALORCAMBIOMONEDAFOB")
	private Double valorCambioMonedaFob;

	@Column(name = "CODIGOMONEDAFLT")
	private Long codigoMonedaFlt;

	@Column(name = "VALORCAMBIOMONEDAFLT")
	private Double valorCambioMonedaFlt;

	@Column(name = "CODIGOMONEDAFCTTL")
	private Long codigoMonedaFctTl;

	@Column(name = "VALORCAMBIOMONEDAFCTTL")
	private Double valorCambioMonedaFctTl;

	@Column(name = "CODIGOMONEDAINLD")
	private Long codigoMonedaInld;

	@Column(name = "VALORCAMBIOMONEDAINLD")
	private Double valorCambioMonedaInld;

	@Column(name = "CODIGOMONEDAENV")
	private Long codigoMonedaEnv;

	@Column(name = "VALORCAMBIOMONEDAENV")
	private Double valorCambioMonedaEnv;

	@Column(name = "CODIGOMONEDAETB")
	private Long codigoMonedaEtb;

	@Column(name = "VALORCAMBIOMONEDAETB")
	private Double valorCambioMonedaEtb;

	@Column(name = "CODIGOMONEDASEGINT")
	private Long codigoMonedaSegInt;

	@Column(name = "VALORCAMBIOMONEDASEGINT")
	private Double valorCambioMonedaSegInt;

	@Column(name = "CODIGOMONEDAVALDSC")
	private Long codigoMonedaValDsc;

	@Column(name = "VALORCAMBIOMONEDAVALDSC")
	private Double valorCambioMonedaValDsc;

	@Column(name = "CODIGOMONEDAVALTP")
	private Long codigoMonedaValTp;

	@Column(name = "VALORCAMBIOMONEDAVALTP")
	private Double valorCambioMonedaValTp;

	@Column(name = "TOTALCANTIDADES")
	private Double totalCantidades;
	
	// COLUMNA MAPEADA PESOPALETS
	@Column(name = "PESOPALETS")
	private Double pesoPalets;
	
	//VALOR COMISION MAPEADO
	@Column(name="VALORCOMISION")
	private Double valorComision;
	
	@Column(name="CODIGOMONEDACOMISION")
	private Long codigoMonedaComision;
	
	@Column(name="VALORCAMBIOMONEDACOMISION")
	private Double valorCambioMonedaComision;

	@Transient
	private String area;
	
	@Transient
	private String clienteImportancionSiglas;
	
	@Transient
	private String codigoProveedor;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOEMBARQUEESTADO", referencedColumnName = "CODIGOEMBARQUEESTADO", insertable = false, updatable = false) })
	private EmbarqueEstadoImpDTO embarqueEstado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOESTADOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOESTADOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false) })
	private CatalogoValorImpDTO estadoFactura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false) })
	private FacturaImpDTO factura;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDA", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistema;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDAFOB", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaFob;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDAFLT", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaFlt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDAFCTTL", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaFctTl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDAINLD", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaInld;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDAENV", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaEnv;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDAETB", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaEtb;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDASEGINT", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaSegInt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDAVALDSC", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaValDsc;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDAVALTP", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaValTp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CODIGOMONEDACOMISION", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
			@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false) })
	private MonedaSistemaDTO monedaSistemaComision;

	@OneToMany(mappedBy = "facturaEstado")
	@CollectionTypeInfo(name = "ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FacturaDetalleEstadoImpDTO> facturaDetallesEstado;

	@Transient
	private FactorDTO factor;
	
	/**
	 * @return the factor
	 */
	public FactorDTO getFactor() {
		return factor;
	}

	/**
	 * @param factor the factor to set
	 */
	public void setFactor(FactorDTO factor) {
		this.factor = factor;
	}

	/**
	 * @return devuelve el valor de la propiedad valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal
	 *            establece el valor a la propiedad valorTotal
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
	 * @param valorDescuento
	 *            establece el valor a la propiedad valorDescuento
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
	 * @param valorFlete
	 *            establece el valor a la propiedad valorFlete
	 */
	public void setValorFlete(Double valorFlete) {
		this.valorFlete = valorFlete;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoMoneda
	 */
	public Long getCodigoMoneda() {
		return codigoMoneda;
	}

	/**
	 * @param codigoMoneda
	 *            establece el valor a la propiedad codigoMoneda
	 */
	public void setCodigoMoneda(Long codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}

	/**
	 * @return devuelve el valor de la propiedad volumenTotal
	 */
	public Double getVolumenTotal() {
		return volumenTotal;
	}

	/**
	 * @param volumenTotal
	 *            establece el valor a la propiedad volumenTotal
	 */
	public void setVolumenTotal(Double volumenTotal) {
		this.volumenTotal = volumenTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoNetoTotal
	 */
	public Double getPesoNetoTotal() {
		return pesoNetoTotal;
	}

	/**
	 * @param pesoNetoTotal
	 *            establece el valor a la propiedad pesoNetoTotal
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
	 * @param pesoBrutoTotal
	 *            establece el valor a la propiedad pesoBrutoTotal
	 */
	public void setPesoBrutoTotal(Double pesoBrutoTotal) {
		this.pesoBrutoTotal = pesoBrutoTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoNetoTotalPL
	 */
	public Double getPesoNetoTotalPL() {
		return pesoNetoTotalPL;
	}

	/**
	 * @param pesoNetoTotalPL
	 *            establece el valor a la propiedad pesoNetoTotalPL
	 */
	public void setPesoNetoTotalPL(Double pesoNetoTotalPL) {
		this.pesoNetoTotalPL = pesoNetoTotalPL;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoBrutoTotalPL
	 */
	public Double getPesoBrutoTotalPL() {
		return pesoBrutoTotalPL;
	}

	/**
	 * @param pesoBrutoTotalPL
	 *            establece el valor a la propiedad pesoBrutoTotalPL
	 */
	public void setPesoBrutoTotalPL(Double pesoBrutoTotalPL) {
		this.pesoBrutoTotalPL = pesoBrutoTotalPL;
	}

	/**
	 * @return devuelve el valor de la propiedad fechaInicio
	 */
	public Timestamp getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            establece el valor a la propiedad fechaInicio
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
	 * @param fechaFin
	 *            establece el valor a la propiedad fechaFin
	 */
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return devuelve el valor de la propiedad factura
	 */
	public FacturaImpDTO getFactura() {
		return factura;
	}

	/**
	 * @param factura
	 *            establece el valor a la propiedad factura
	 */
	public void setFactura(FacturaImpDTO factura) {
		this.factura = factura;
	}

	/**
	 * @return devuelve el valor de la propiedad facturaDetallesEstado
	 */
	public Collection<FacturaDetalleEstadoImpDTO> getFacturaDetallesEstado() {
		return facturaDetallesEstado;
	}

	/**
	 * @param facturaDetallesEstado
	 *            establece el valor a la propiedad facturaDetallesEstado
	 */
	public void setFacturaDetallesEstado(
			Collection<FacturaDetalleEstadoImpDTO> facturaDetallesEstado) {
		this.facturaDetallesEstado = facturaDetallesEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad porcentajeIncremento
	 */
	public Double getPorcentajeIncremento() {
		return porcentajeIncremento;
	}

	/**
	 * @param porcentajeIncremento
	 *            establece el valor a la propiedad porcentajeIncremento
	 */
	public void setPorcentajeIncremento(Double porcentajeIncremento) {
		this.porcentajeIncremento = porcentajeIncremento;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEstadoCatTip
	 */
	public Long getCodigoEstadoCatTip() {
		return codigoEstadoCatTip;
	}

	/**
	 * @param codigoEstadoCatTip
	 *            establece el valor a la propiedad codigoEstadoCatTip
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
	 * @param codigoEstadoCatVal
	 *            establece el valor a la propiedad codigoEstadoCatVal
	 */
	public void setCodigoEstadoCatVal(Long codigoEstadoCatVal) {
		this.codigoEstadoCatVal = codigoEstadoCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad estadoFactura
	 */
	public CatalogoValorImpDTO getEstadoFactura() {
		return estadoFactura;
	}

	/**
	 * @param estadoFactura
	 *            establece el valor a la propiedad estadoFactura
	 */
	public void setEstadoFactura(CatalogoValorImpDTO estadoFactura) {
		this.estadoFactura = estadoFactura;
	}

	/**
	 * @return devuelve el valor de la propiedad valorSeguro
	 */
	public Double getValorSeguro() {
		return valorSeguro;
	}

	/**
	 * @param valorSeguro
	 *            establece el valor a la propiedad valorSeguro
	 */
	public void setValorSeguro(Double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}

	/**
	 * @return devuelve el valor de la propiedad valorTotalFinal
	 */
	public Double getValorTotalFinal() {
		return valorTotalFinal;
	}

	/**
	 * @param valorTotalFinal
	 *            establece el valor a la propiedad valorTotalFinal
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
	 * @param porcentajeDescuento
	 *            establece el valor a la propiedad porcentajeDescuento
	 */
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	/**
	 * @return devuelve el valor de la propiedad cantidadCajas
	 */
	public Integer getCantidadCajas() {
		return cantidadCajas;
	}

	/**
	 * @param cantidadCajas
	 *            establece el valor a la propiedad cantidadCajas
	 */
	public void setCantidadCajas(Integer cantidadCajas) {
		this.cantidadCajas = cantidadCajas;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}

	/**
	 * @param codigoSistema
	 *            establece el valor a la propiedad codigoSistema
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	/**
	 * @return devuelve el valor de la propiedad valorCambioMoneda
	 */
	public Double getValorCambioMoneda() {
		return valorCambioMoneda;
	}

	/**
	 * @param valorCambioMoneda
	 *            establece el valor a la propiedad valorCambioMoneda
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
	 * @param fechaCambioMoneda
	 *            establece el valor a la propiedad fechaCambioMoneda
	 */
	public void setFechaCambioMoneda(Date fechaCambioMoneda) {
		this.fechaCambioMoneda = fechaCambioMoneda;
	}

	/**
	 * @return devuelve el valor de la propiedad cantidadCajasPL
	 */
	public Integer getCantidadCajasPL() {
		return cantidadCajasPL;
	}

	/**
	 * @param cantidadCajasPL
	 *            establece el valor a la propiedad cantidadCajasPL
	 */
	public void setCantidadCajasPL(Integer cantidadCajasPL) {
		this.cantidadCajasPL = cantidadCajasPL;
	}

	/**
	 * @return devuelve el valor de la propiedad numeroFP
	 */
	public String getNumeroFP() {
		return numeroFP;
	}

	/**
	 * @param numeroFP
	 *            establece el valor a la propiedad numeroFP
	 */
	public void setNumeroFP(String numeroFP) {
		this.numeroFP = numeroFP;
	}

	/**
	 * @return devuelve el valor de la propiedad valorTotalFP
	 */
	public Double getValorTotalFP() {
		return valorTotalFP;
	}

	/**
	 * @param valorTotalFP
	 *            establece el valor a la propiedad valorTotalFP
	 */
	public void setValorTotalFP(Double valorTotalFP) {
		this.valorTotalFP = valorTotalFP;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoNetoTotalFP
	 */
	public Double getPesoNetoTotalFP() {
		return pesoNetoTotalFP;
	}

	/**
	 * @param pesoNetoTotalFP
	 *            establece el valor a la propiedad pesoNetoTotalFP
	 */
	public void setPesoNetoTotalFP(Double pesoNetoTotalFP) {
		this.pesoNetoTotalFP = pesoNetoTotalFP;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoBrutoTotalFP
	 */
	public Double getPesoBrutoTotalFP() {
		return pesoBrutoTotalFP;
	}

	/**
	 * @param pesoBrutoTotalFP
	 *            establece el valor a la propiedad pesoBrutoTotalFP
	 */
	public void setPesoBrutoTotalFP(Double pesoBrutoTotalFP) {
		this.pesoBrutoTotalFP = pesoBrutoTotalFP;
	}

	/**
	 * @return devuelve el valor de la propiedad cantidadCajasFP
	 */
	public Integer getCantidadCajasFP() {
		return cantidadCajasFP;
	}

	/**
	 * @param cantidadCajasFP
	 *            establece el valor a la propiedad cantidadCajasFP
	 */
	public void setCantidadCajasFP(Integer cantidadCajasFP) {
		this.cantidadCajasFP = cantidadCajasFP;
	}

	/**
	 * @return devuelve el valor de la propiedad monedaSistema
	 */
	public MonedaSistemaDTO getMonedaSistema() {
		return monedaSistema;
	}

	/**
	 * @param monedaSistema
	 *            establece el valor a la propiedad monedaSistema
	 */
	public void setMonedaSistema(MonedaSistemaDTO monedaSistema) {
		this.monedaSistema = monedaSistema;
	}

	/**
	 * @return devuelve el valor de la propiedad valorSeguroNacional
	 */
	public Double getValorSeguroNacional() {
		return valorSeguroNacional;
	}

	/**
	 * @param valorSeguroNacional
	 *            establece el valor a la propiedad valorSeguroNacional
	 */
	public void setValorSeguroNacional(Double valorSeguroNacional) {
		this.valorSeguroNacional = valorSeguroNacional;
	}

	/**
	 * @return devuelve el valor de la propiedad valorInland
	 */
	public Double getValorInland() {
		return valorInland;
	}

	/**
	 * @param valorInland
	 *            establece el valor a la propiedad valorInland
	 */
	public void setValorInland(Double valorInland) {
		this.valorInland = valorInland;
	}

	/**
	 * @return devuelve el valor de la propiedad valorEnvaseEmbalaje
	 */
	public Double getValorEnvaseEmbalaje() {
		return valorEnvaseEmbalaje;
	}

	/**
	 * @param valorEnvaseEmbalaje
	 *            establece el valor a la propiedad valorEnvaseEmbalaje
	 */
	public void setValorEnvaseEmbalaje(Double valorEnvaseEmbalaje) {
		this.valorEnvaseEmbalaje = valorEnvaseEmbalaje;
	}

	/**
	 * @return devuelve el valor de la propiedad valorEstiba
	 */
	public Double getValorEstiba() {
		return valorEstiba;
	}

	/**
	 * @param valorEstiba
	 *            establece el valor a la propiedad valorEstiba
	 */
	public void setValorEstiba(Double valorEstiba) {
		this.valorEstiba = valorEstiba;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarqueEstado
	 */
	public Long getCodigoEmbarqueEstado() {
		return codigoEmbarqueEstado;
	}

	/**
	 * @param codigoEmbarqueEstado
	 *            establece el valor a la propiedad codigoEmbarqueEstado
	 */
	public void setCodigoEmbarqueEstado(Long codigoEmbarqueEstado) {
		this.codigoEmbarqueEstado = codigoEmbarqueEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarque
	 */
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque
	 *            establece el valor a la propiedad codigoEmbarque
	 */
	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad embarqueEstado
	 */
	public EmbarqueEstadoImpDTO getEmbarqueEstado() {
		return embarqueEstado;
	}

	/**
	 * @param embarqueEstado
	 *            establece el valor a la propiedad embarqueEstado
	 */
	public void setEmbarqueEstado(EmbarqueEstadoImpDTO embarqueEstado) {
		this.embarqueEstado = embarqueEstado;
	}

	
	/**
	 * @return the codigoMonedaFob
	 */
	public Long getCodigoMonedaFob() {
		return codigoMonedaFob;
	}

	/**
	 * @param codigoMonedaFob
	 *            the codigoMonedaFob to set
	 */
	public void setCodigoMonedaFob(Long codigoMonedaFob) {
		this.codigoMonedaFob = codigoMonedaFob;
	}

	/**
	 * @return the valorCambioMonedaFob
	 */
	public Double getValorCambioMonedaFob() {
		return valorCambioMonedaFob;
	}

	/**
	 * @param valorCambioMonedaFob
	 *            the valorCambioMonedaFob to set
	 */
	public void setValorCambioMonedaFob(Double valorCambioMonedaFob) {
		this.valorCambioMonedaFob = valorCambioMonedaFob;
	}

	/**
	 * @return the monedaSistemaFob
	 */
	public MonedaSistemaDTO getMonedaSistemaFob() {
		return monedaSistemaFob;
	}

	/**
	 * @param monedaSistemaFob
	 *            the monedaSistemaFob to set
	 */
	public void setMonedaSistemaFob(MonedaSistemaDTO monedaSistemaFob) {
		this.monedaSistemaFob = monedaSistemaFob;
	}

	/**
	 * @return the codigoMonedaFlt
	 */
	public Long getCodigoMonedaFlt() {
		return codigoMonedaFlt;
	}

	/**
	 * @param codigoMonedaFlt
	 *            the codigoMonedaFlt to set
	 */
	public void setCodigoMonedaFlt(Long codigoMonedaFlt) {
		this.codigoMonedaFlt = codigoMonedaFlt;
	}

	/**
	 * @return the valorCambioMonedaFlt
	 */
	public Double getValorCambioMonedaFlt() {
		return valorCambioMonedaFlt;
	}

	/**
	 * @param valorCambioMonedaFlt
	 *            the valorCambioMonedaFlt to set
	 */
	public void setValorCambioMonedaFlt(Double valorCambioMonedaFlt) {
		this.valorCambioMonedaFlt = valorCambioMonedaFlt;
	}

	/**
	 * @return the monedaSistemaFlt
	 */
	public MonedaSistemaDTO getMonedaSistemaFlt() {
		return monedaSistemaFlt;
	}

	/**
	 * @param monedaSistemaFlt
	 *            the monedaSistemaFlt to set
	 */
	public void setMonedaSistemaFlt(MonedaSistemaDTO monedaSistemaFlt) {
		this.monedaSistemaFlt = monedaSistemaFlt;
	}

	/**
	 * @return the codigoMonedaFctTl
	 */
	public Long getCodigoMonedaFctTl() {
		return codigoMonedaFctTl;
	}

	/**
	 * @param codigoMonedaFctTl
	 *            the codigoMonedaFctTl to set
	 */
	public void setCodigoMonedaFctTl(Long codigoMonedaFctTl) {
		this.codigoMonedaFctTl = codigoMonedaFctTl;
	}

	/**
	 * @return the valorCambioMonedaFctTl
	 */
	public Double getValorCambioMonedaFctTl() {
		return valorCambioMonedaFctTl;
	}

	/**
	 * @param valorCambioMonedaFctTl
	 *            the valorCambioMonedaFctTl to set
	 */
	public void setValorCambioMonedaFctTl(Double valorCambioMonedaFctTl) {
		this.valorCambioMonedaFctTl = valorCambioMonedaFctTl;
	}

	/**
	 * @return the monedaSistemaFctTl
	 */
	public MonedaSistemaDTO getMonedaSistemaFctTl() {
		return monedaSistemaFctTl;
	}

	/**
	 * @param monedaSistemaFctTl
	 *            the monedaSistemaFctTl to set
	 */
	public void setMonedaSistemaFctTl(MonedaSistemaDTO monedaSistemaFctTl) {
		this.monedaSistemaFctTl = monedaSistemaFctTl;
	}

	/**
	 * @return the codigoMonedaInld
	 */
	public Long getCodigoMonedaInld() {
		return codigoMonedaInld;
	}

	/**
	 * @param codigoMonedaInld
	 *            the codigoMonedaInld to set
	 */
	public void setCodigoMonedaInld(Long codigoMonedaInld) {
		this.codigoMonedaInld = codigoMonedaInld;
	}

	/**
	 * @return the valorCambioMonedaInld
	 */
	public Double getValorCambioMonedaInld() {
		return valorCambioMonedaInld;
	}

	/**
	 * @param valorCambioMonedaInld
	 *            the valorCambioMonedaInld to set
	 */
	public void setValorCambioMonedaInld(Double valorCambioMonedaInld) {
		this.valorCambioMonedaInld = valorCambioMonedaInld;
	}

	/**
	 * @return the monedaSistemaInld
	 */
	public MonedaSistemaDTO getMonedaSistemaInld() {
		return monedaSistemaInld;
	}

	/**
	 * @param monedaSistemaInld
	 *            the monedaSistemaInld to set
	 */
	public void setMonedaSistemaInld(MonedaSistemaDTO monedaSistemaInld) {
		this.monedaSistemaInld = monedaSistemaInld;
	}

	/**
	 * @return the codigoMonedaEnv
	 */
	public Long getCodigoMonedaEnv() {
		return codigoMonedaEnv;
	}

	/**
	 * @param codigoMonedaEnv
	 *            the codigoMonedaEnv to set
	 */
	public void setCodigoMonedaEnv(Long codigoMonedaEnv) {
		this.codigoMonedaEnv = codigoMonedaEnv;
	}

	/**
	 * @return the valorCambioMonedaEnv
	 */
	public Double getValorCambioMonedaEnv() {
		return valorCambioMonedaEnv;
	}

	/**
	 * @param valorCambioMonedaEnv
	 *            the valorCambioMonedaEnv to set
	 */
	public void setValorCambioMonedaEnv(Double valorCambioMonedaEnv) {
		this.valorCambioMonedaEnv = valorCambioMonedaEnv;
	}

	/**
	 * @return the monedaSistemaEnv
	 */
	public MonedaSistemaDTO getMonedaSistemaEnv() {
		return monedaSistemaEnv;
	}

	/**
	 * @param monedaSistemaEnv
	 *            the monedaSistemaEnv to set
	 */
	public void setMonedaSistemaEnv(MonedaSistemaDTO monedaSistemaEnv) {
		this.monedaSistemaEnv = monedaSistemaEnv;
	}

	/**
	 * @return the codigoMonedaEtb
	 */
	public Long getCodigoMonedaEtb() {
		return codigoMonedaEtb;
	}

	/**
	 * @param codigoMonedaEtb
	 *            the codigoMonedaEtb to set
	 */
	public void setCodigoMonedaEtb(Long codigoMonedaEtb) {
		this.codigoMonedaEtb = codigoMonedaEtb;
	}

	/**
	 * @return the valorCambioMonedaEtb
	 */
	public Double getValorCambioMonedaEtb() {
		return valorCambioMonedaEtb;
	}

	/**
	 * @param valorCambioMonedaEtb
	 *            the valorCambioMonedaEtb to set
	 */
	public void setValorCambioMonedaEtb(Double valorCambioMonedaEtb) {
		this.valorCambioMonedaEtb = valorCambioMonedaEtb;
	}

	/**
	 * @return the monedaSistemaEtb
	 */
	public MonedaSistemaDTO getMonedaSistemaEtb() {
		return monedaSistemaEtb;
	}

	/**
	 * @param monedaSistemaEtb
	 *            the monedaSistemaEtb to set
	 */
	public void setMonedaSistemaEtb(MonedaSistemaDTO monedaSistemaEtb) {
		this.monedaSistemaEtb = monedaSistemaEtb;
	}

	/**
	 * @return the codigoMonedaSegInt
	 */
	public Long getCodigoMonedaSegInt() {
		return codigoMonedaSegInt;
	}

	/**
	 * @param codigoMonedaSegInt
	 *            the codigoMonedaSegInt to set
	 */
	public void setCodigoMonedaSegInt(Long codigoMonedaSegInt) {
		this.codigoMonedaSegInt = codigoMonedaSegInt;
	}

	/**
	 * @return the valorCambioMonedaSegInt
	 */
	public Double getValorCambioMonedaSegInt() {
		return valorCambioMonedaSegInt;
	}

	/**
	 * @param valorCambioMonedaSegInt
	 *            the valorCambioMonedaSegInt to set
	 */
	public void setValorCambioMonedaSegInt(Double valorCambioMonedaSegInt) {
		this.valorCambioMonedaSegInt = valorCambioMonedaSegInt;
	}

	/**
	 * @return the monedaSistemaSegInt
	 */
	public MonedaSistemaDTO getMonedaSistemaSegInt() {
		return monedaSistemaSegInt;
	}

	/**
	 * @param monedaSistemaSegInt
	 *            the monedaSistemaSegInt to set
	 */
	public void setMonedaSistemaSegInt(MonedaSistemaDTO monedaSistemaSegInt) {
		this.monedaSistemaSegInt = monedaSistemaSegInt;
	}

	/**
	 * @return the codigoMonedaValDsc
	 */
	public Long getCodigoMonedaValDsc() {
		return codigoMonedaValDsc;
	}

	/**
	 * @param codigoMonedaValDsc
	 *            the codigoMonedaValDsc to set
	 */
	public void setCodigoMonedaValDsc(Long codigoMonedaValDsc) {
		this.codigoMonedaValDsc = codigoMonedaValDsc;
	}

	/**
	 * @return the valorCambioMonedaValDsc
	 */
	public Double getValorCambioMonedaValDsc() {
		return valorCambioMonedaValDsc;
	}

	/**
	 * @param valorCambioMonedaValDsc
	 *            the valorCambioMonedaValDsc to set
	 */
	public void setValorCambioMonedaValDsc(Double valorCambioMonedaValDsc) {
		this.valorCambioMonedaValDsc = valorCambioMonedaValDsc;
	}

	/**
	 * @return the monedaSistemaValDsc
	 */
	public MonedaSistemaDTO getMonedaSistemaValDsc() {
		return monedaSistemaValDsc;
	}

	/**
	 * @param monedaSistemaValDsc
	 *            the monedaSistemaValDsc to set
	 */
	public void setMonedaSistemaValDsc(MonedaSistemaDTO monedaSistemaValDsc) {
		this.monedaSistemaValDsc = monedaSistemaValDsc;
	}

	/**
	 * @return the codigoMonedaValTp
	 */
	public Long getCodigoMonedaValTp() {
		return codigoMonedaValTp;
	}

	/**
	 * @param codigoMonedaValTp
	 *            the codigoMonedaValTp to set
	 */
	public void setCodigoMonedaValTp(Long codigoMonedaValTp) {
		this.codigoMonedaValTp = codigoMonedaValTp;
	}

	/**
	 * @return the valorCambioMonedaValTp
	 */
	public Double getValorCambioMonedaValTp() {
		return valorCambioMonedaValTp;
	}

	/**
	 * @param valorCambioMonedaValTp
	 *            the valorCambioMonedaValTp to set
	 */
	public void setValorCambioMonedaValTp(Double valorCambioMonedaValTp) {
		this.valorCambioMonedaValTp = valorCambioMonedaValTp;
	}

	/**
	 * @return the monedaSistemaValTp
	 */
	public MonedaSistemaDTO getMonedaSistemaValTp() {
		return monedaSistemaValTp;
	}

	/**
	 * @param monedaSistemaValTp
	 *            the monedaSistemaValTp to set
	 */
	public void setMonedaSistemaValTp(MonedaSistemaDTO monedaSistemaValTp) {
		this.monedaSistemaValTp = monedaSistemaValTp;
	}

	/**
	 * @return the totalCantidades
	 */
	public Double getTotalCantidades() {
		return totalCantidades;
	}

	/**
	 * @param totalCantidades
	 *            the totalCantidades to set
	 */
	public void setTotalCantidades(Double totalCantidades) {
		this.totalCantidades = totalCantidades;
	}

	/**
	 * @return the pesoPalets
	 */

	public Double getPesoPalets() {
		return pesoPalets;
	}

	/**
	 * @param pesoPalets
	 *            the pesoPalets to set
	 */

	public void setPesoPalets(Double pesoPalets) {
		this.pesoPalets = pesoPalets;
	}
	/**
	 * @return the valorComision
	 */

	public Double getValorComision() {
		return valorComision;
	}
	
	/**
	 * @param valorComision
	 *            the valorComision to set
	 */

	public void setValorComision(Double valorComision) {
		this.valorComision=valorComision;
	}
	
	/**
	 * @return the monedaSistemaComision
	 */
	public MonedaSistemaDTO getMonedaSistemaComision() {
		return monedaSistemaComision;
	}

	/**
	 * @param monedaSistemaComision
	 *            the monedaSistemaComision to set
	 */
	public void setMonedaSistemaComision(MonedaSistemaDTO monedaSistemaComision) {
		this.monedaSistemaComision = monedaSistemaComision;
	}
	/**
	 * @return the codigoMonedaComision
	 */
	public Long getCodigoMonedaComision() {
		return codigoMonedaComision;
	}
	
	/**
	 * @param codigoMonedaComision
	 *            the codigoMonedaComision to set
	 */
	public void setCodigoMonedaComision(Long codigoMonedaComision) {
		this.codigoMonedaComision = codigoMonedaComision;
	}
	
	
	/**
	 * @return the valorCambioMonedaComision
	 */
	public Double getValorCambioMonedaComision() {
		return valorCambioMonedaComision;
	}
	
	/**
	 * @param valorCambioMonedaComision
	 *            the valorCambioMonedaComision to set
	 */
	public void setValorCambioMonedaComision(Double valorCambioMonedaComision) {
		this.valorCambioMonedaComision = valorCambioMonedaComision;
	}
	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the clienteImportancionSiglas
	 */
	public String getClienteImportancionSiglas() {
		return clienteImportancionSiglas;
	}

	/**
	 * @param clienteImportancionSiglas the clienteImportancionSiglas to set
	 */
	public void setClienteImportancionSiglas(String clienteImportancionSiglas) {
		this.clienteImportancionSiglas = clienteImportancionSiglas;
	}

	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}


}
