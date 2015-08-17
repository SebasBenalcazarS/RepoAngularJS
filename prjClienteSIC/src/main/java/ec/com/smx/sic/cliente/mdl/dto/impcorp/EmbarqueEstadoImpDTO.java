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
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.EmbarqueEstadoImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTEMBEST")
public class EmbarqueEstadoImpDTO extends AuditoriaBaseDTO<EmbarqueEstadoImpID>{
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
	
	@Column(name = "VALORFLETE")
	private Double valorFlete;
	
	@Column(name = "VALORFLETETOTAL")
	private Double valorFleteTotal;
	
	@Column(name = "VALORSEGURONAC")
	private Double valorSeguroNac;
	
	@Column(name = "VALORSEGUROINT")
	private Double valorSeguroInt;
	
	@Column(name = "PESOBRUTOTOTAL")
	private Double pesoBrutoTotal;
	
	@Column(name = "PESONETOTOTAL")
	private Double pesoNetoTotal;
	
	@Column(name = "PESORECIBIDO")
	private Double pesoRecibido;
	
	@Column(name = "CANTIDADCAJAS")
	private Integer cantidadCajas;
	
	@Column(name = "CANTIDADUNIDADES")
	private Double cantidadUnidades;

	@Column(name = "OBSERVACION")
	private String observacion;
	
	@Column(name = "CODIGOSISTEMA")
	private String codigoSistema;
	
	@Column(name = "CODIGOMONEDAFOB")
	private Long codigoMonedaFob;
	
	@Column(name = "VALORCAMBIOMONEDAFOB")
	private Double valorCambioMonedaFob;
	
	@Column(name = "CODIGOMONEDAFLMFT")
	private Long codigoMonedaFlmft;
	
	@Column(name = "VALORCAMBIOMONEDAFLMFT")
	private Double valorCambioMonedaFlmft;
	
	@Column(name = "CODIGOMONEDAFLT")
	private Long codigoMonedaFlt;
	
	@Column(name = "VALORCAMBIOMONEDAFLT")
	private Double valorCambioMonedaFlt;
	
	@Column(name = "PORCENTAJEMERCADERIA")
	private Double porcentajeSeguroTipoMercaderia;
	
	@Column(name = "USUARIORESPONSABLE")
	private String usuarioResponsable;	
	
	@Column(name = "FECHADECLARACION")
	private Timestamp fechaDeclaracion;
	
	@Column(name = "FECHARECEPCIONDOCS")
	private Date fechaRecepcionDocs;
	
	 @ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="USUARIORESPONSABLE", referencedColumnName="USERID", insertable=false, updatable=false)
	  private UserDto usuarioResponsableDTO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTADOCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOESTADOCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO estadoEmbarque;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false)
	})
	private EmbarqueImpDTO embarque;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOMONEDAFOB", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false)
	})
	private MonedaSistemaDTO monedaSistemaFob;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOMONEDAFLMFT", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false)
	})
	private MonedaSistemaDTO monedaSistemaFlmft;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOMONEDAFLT", referencedColumnName = "CODIGOMONEDA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOSISTEMA", referencedColumnName = "CODIGOSISTEMA", insertable = false, updatable = false)
	})
	private MonedaSistemaDTO monedaSistemaFlt;
	
	@OneToMany(mappedBy = "embarqueEstado")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FacturaEstadoImpDTO> facturasEstado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOEMBARQUEESTADO", referencedColumnName = "CODIGOEMBARQUEESTADO", insertable = false, updatable = false)
	})
	private EmbarqueLiquidacionImpDTO embarqueLiquidacion;
	
	@Transient
	private FactorDTO factor;
	
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
	 * @return devuelve el valor de la propiedad estadoEmbarque
	 */
	public CatalogoValorImpDTO getEstadoEmbarque() {
		return estadoEmbarque;
	}
	/**
	 * @param estadoEmbarque establece el valor a la propiedad estadoEmbarque
	 */
	public void setEstadoEmbarque(CatalogoValorImpDTO estadoEmbarque) {
		this.estadoEmbarque = estadoEmbarque;
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
	 * @return devuelve el valor de la propiedad valorSeguroNac
	 */
	public Double getValorSeguroNac() {
		return valorSeguroNac;
	}
	/**
	 * @param valorSeguroNac establece el valor a la propiedad valorSeguroNac
	 */
	public void setValorSeguroNac(Double valorSeguroNac) {
		this.valorSeguroNac = valorSeguroNac;
	}
	/**
	 * @return devuelve el valor de la propiedad valorSeguroInt
	 */
	public Double getValorSeguroInt() {
		return valorSeguroInt;
	}
	/**
	 * @param valorSeguroInt establece el valor a la propiedad valorSeguroInt
	 */
	public void setValorSeguroInt(Double valorSeguroInt) {
		this.valorSeguroInt = valorSeguroInt;
	}
	/**
	 * @return devuelve el valor de la propiedad valorFleteTotal
	 */
	public Double getValorFleteTotal() {
		return valorFleteTotal;
	}
	/**
	 * @param valorFleteTotal establece el valor a la propiedad valorFleteTotal
	 */
	public void setValorFleteTotal(Double valorFleteTotal) {
		this.valorFleteTotal = valorFleteTotal;
	}
	/**
	 * @return devuelve el valor de la propiedad pesoBrutoTota
	 */
	public Double getPesoBrutoTotal() {
		return pesoBrutoTotal;
	}
	/**
	 * @param pesoBrutoTota establece el valor a la propiedad pesoBrutoTota
	 */
	public void setPesoBrutoTotal(Double pesoBrutoTota) {
		this.pesoBrutoTotal = pesoBrutoTota;
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
	 * @return devuelve el valor de la propiedad pesoRecibido
	 */
	public Double getPesoRecibido() {
		return pesoRecibido;
	}
	/**
	 * @param pesoRecibido establece el valor a la propiedad pesoRecibido
	 */
	public void setPesoRecibido(Double pesoRecibido) {
		this.pesoRecibido = pesoRecibido;
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
	 * @return devuelve el valor de la propiedad cantidadUnidades
	 */
	public Double getCantidadUnidades() {
		return cantidadUnidades;
	}
	/**
	 * @param cantidadUnidades establece el valor a la propiedad cantidadUnidades
	 */
	public void setCantidadUnidades(Double cantidadUnidades) {
		this.cantidadUnidades = cantidadUnidades;
	}
	/**
	 * @return devuelve el valor de la propiedad facturasEstado
	 */
	public Collection<FacturaEstadoImpDTO> getFacturasEstado() {
		return facturasEstado;
	}
	/**
	 * @param facturasEstado establece el valor a la propiedad facturasEstado
	 */
	public void setFacturasEstado(Collection<FacturaEstadoImpDTO> facturasEstado) {
		this.facturasEstado = facturasEstado;
	}
	
	/**
	 * @return devuelve el valor de la propiedad observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion establece el valor a la propiedad observacion
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * @return the codigoSistema
	 */
	public String getCodigoSistema() {
		return codigoSistema;
	}
	/**
	 * @param codigoSistema the codigoSistema to set
	 */
	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	/**
	 * @return the codigoMonedaFob
	 */
	public Long getCodigoMonedaFob() {
		return codigoMonedaFob;
	}
	/**
	 * @param codigoMonedaFob the codigoMonedaFob to set
	 */
	public void setCodigoMonedaFob(Long codigoMonedaFob) {
		this.codigoMonedaFob = codigoMonedaFob;
	}
	/**
	 * @return the monedaSistemaFob
	 */
	public MonedaSistemaDTO getMonedaSistemaFob() {
		return monedaSistemaFob;
	}
	/**
	 * @param monedaSistemaFob the monedaSistemaFob to set
	 */
	public void setMonedaSistemaFob(MonedaSistemaDTO monedaSistemaFob) {
		this.monedaSistemaFob = monedaSistemaFob;
	}
	/**
	 * @return the valorCambioMonedaFob
	 */
	public Double getValorCambioMonedaFob() {
		return valorCambioMonedaFob;
	}
	/**
	 * @param valorCambioMonedaFob the valorCambioMonedaFob to set
	 */
	public void setValorCambioMonedaFob(Double valorCambioMonedaFob) {
		this.valorCambioMonedaFob = valorCambioMonedaFob;
	}
	/**
	 * @return the codigoMonedaFlmft
	 */
	public Long getCodigoMonedaFlmft() {
		return codigoMonedaFlmft;
	}
	/**
	 * @param codigoMonedaFlmft the codigoMonedaFlmft to set
	 */
	public void setCodigoMonedaFlmft(Long codigoMonedaFlmft) {
		this.codigoMonedaFlmft = codigoMonedaFlmft;
	}
	/**
	 * @return the valorCambioMonedaFlmft
	 */
	public Double getValorCambioMonedaFlmft() {
		return valorCambioMonedaFlmft;
	}
	/**
	 * @param valorCambioMonedaFlmft the valorCambioMonedaFlmft to set
	 */
	public void setValorCambioMonedaFlmft(Double valorCambioMonedaFlmft) {
		this.valorCambioMonedaFlmft = valorCambioMonedaFlmft;
	}
	/**
	 * @return the monedaSistemaFlmft
	 */
	public MonedaSistemaDTO getMonedaSistemaFlmft() {
		return monedaSistemaFlmft;
	}
	/**
	 * @param monedaSistemaFlmft the monedaSistemaFlmft to set
	 */
	public void setMonedaSistemaFlmft(MonedaSistemaDTO monedaSistemaFlmft) {
		this.monedaSistemaFlmft = monedaSistemaFlmft;
	}
	/**
	 * @return the codigoMonedaFlt
	 */
	public Long getCodigoMonedaFlt() {
		return codigoMonedaFlt;
	}
	/**
	 * @param codigoMonedaFlt the codigoMonedaFlt to set
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
	 * @param valorCambioMonedaFlt the valorCambioMonedaFlt to set
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
	 * @param monedaSistemaFlt the monedaSistemaFlt to set
	 */
	public void setMonedaSistemaFlt(MonedaSistemaDTO monedaSistemaFlt) {
		this.monedaSistemaFlt = monedaSistemaFlt;
	}
	/**
	 * @return the porcentajeSeguroTipoMercaderia
	 */
	public Double getPorcentajeSeguroTipoMercaderia() {
		return porcentajeSeguroTipoMercaderia;
	}
	/**
	 * @param porcentajeSeguroTipoMercaderia the porcentajeSeguroTipoMercaderia to set
	 */
	public void setPorcentajeSeguroTipoMercaderia(
			Double porcentajeSeguroTipoMercaderia) {
		this.porcentajeSeguroTipoMercaderia = porcentajeSeguroTipoMercaderia;
	}
	/**
	 * @return the usuarioResponsable
	 */
	public String getUsuarioResponsable() {
		return usuarioResponsable;
	}
	/**
	 * @param usuarioResponsable the usuarioResponsable to set
	 */
	public void setUsuarioResponsable(String usuarioResponsable) {
		this.usuarioResponsable = usuarioResponsable;
	}
	/**
	 * @return the embarqueLiquidacion
	 */
	public EmbarqueLiquidacionImpDTO getEmbarqueLiquidacion() {
		return embarqueLiquidacion;
	}
	/**
	 * @param embarqueLiquidacion the embarqueLiquidacion to set
	 */
	public void setEmbarqueLiquidacion(EmbarqueLiquidacionImpDTO embarqueLiquidacion) {
		this.embarqueLiquidacion = embarqueLiquidacion;
	}
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
	public UserDto getUsuarioResponsableDTO() {
		return usuarioResponsableDTO;
	}
	public void setUsuarioResponsableDTO(UserDto usuarioResponsableDTO) {
		this.usuarioResponsableDTO = usuarioResponsableDTO;
	}
	public Timestamp getFechaDeclaracion() {
		return fechaDeclaracion;
	}
	public void setFechaDeclaracion(Timestamp fechaDeclaracion) {
		this.fechaDeclaracion = fechaDeclaracion;
	}
	public Date getFechaRecepcionDocs() {
		return fechaRecepcionDocs;
	}
	public void setFechaRecepcionDocs(Date fechaRecepcionDocs) {
		this.fechaRecepcionDocs = fechaRecepcionDocs;
	}
	
	
	
}
