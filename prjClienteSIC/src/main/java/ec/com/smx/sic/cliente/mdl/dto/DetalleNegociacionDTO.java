package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.math.BigDecimal;
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

import ec.com.kruger.utilitario.dao.commons.constants.CollectionType;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.DetalleNegociacionID;

/**
 * Clase DTO que extiende de SimpleAuditDTO, representa la tabla SCCEMTNEGOCIACION
 * del Schema DSMXSIC
 * 
 * @author khidalgo
 * 2015-10-01
*/


@Entity
@Table(name = "SCCEMTDETNEG")
public class DetalleNegociacionDTO extends SearchDTO implements Serializable{
	/**
	 * Clave primaria de la tabla Convenio participante
	 */
	private static final long serialVersionUID = 7863262235394607247L;
	
	@EmbeddedId
	private DetalleNegociacionID id = new DetalleNegociacionID();
	
	@Column(name="CODIGONEGOCIACION")
	private Long codigoNegociacion;
	
	/**
	 * CATALOGO PERIODICIDADCOBRO
	 * 
	 */
	@Column(name = "CODIGOVALORPERIODICIDADCORTE")
	private String codigoValorPeriodicidadCorte;
	
	@Column(name = "CODIGOTIPOPERIODICIDADCORTE")
	private Integer codigoTipoPeriodicidadCorte;

	/**
	 * CATALOGO PLAZO COBRO
	 */
	
	@Column(name = "CODIGOVALORPLAZOCOBRO")
	private String codigoValorPlazoCobro;
	
	@Column(name = "CODIGOTIPOPLAZOCOBRO")
	private Integer codigoTipoPlazoCobro;
	
	/**
	 * VALOR TIPO CONDICION COBRO
	 */
	@Column (name = "CODIGOVALORTIPOCONDICIONCOBRO")
	private String codigoValorCondicionCobro;
	
	@Column(name = "CODIGOTIPOCONDICIONCOBRO")
	private Integer codigoTipoCondicionCobro;
	
	/**
	 * VALOR TIPO COBRO COSTO
	 */
	@Column (name = "CODIGOVALORCOBROCOSTO")
	private String codigoValorCobroCosto;
	
	@Column(name = "CODIGOTIPOCOBROCOSTO")
	private Integer codigoTipoCobroCosto;
	
	/**
	 * CATALOGO INICIO COBRO
	 */
	@Column(name = "CODIGOVALORINICIOCOBRO")
	private String codigoValorInicioCobro;
	
	@Column(name = "CODIGOTIPOINICIOCOBRO")
	private Integer codigoTipoInicioCobro;
	
	
	/**
	 * catalogo tipo forma venta
	 */
	@Column(name = "CODIGOVALORTIPOFORMAVENTA")
	private String codigoValorTipoFormaVenta;
	
	@Column(name = "CODIGOTIPOFORMAVENTA")
	private Integer codigoTipoFormaVenta;
	
	/**
	 * Referencia CatalogoValorDTO forma venta
	 */
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOVALORTIPOFORMAVENTA", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOTIPOFORMAVENTA", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false)
	})
	private CatalogoValorDTO formaVentaCatalogoValorDTO;
	
	/**
	 * CATAKLOGO VALOR APLICACION DESCUENTO USADO PARA ORDEN COMPRA
	 *
	 */
	@Column(name = "CODIGOVALORAPLICACIONDESCUENTO")
	private String codigoValorAplicacionDescuento;

	@Column(name = "CODIGOTIPOAPLICACIONDESCUENTO")
	private Integer codigoTipoAplicacionDescuento;
	
	/**
	 * Catalogos para  los centros de costos
	 * 
	 */
	@Column(name = "CODIGOVALORCENTROCOSTO")
	private String codigoValorCentroCosto;

	@Column(name = "CODIGOTIPOCENTROCOSTO")
	private Integer codigoTipoCentroCosto;

	
	@Column(name = "FECHAINICIOCOBRO")
	private Date fechaInicioCobro;
	
	@Column(name = "FECHAFINCOBRO")
	private Date fechaFinCobro;
	
	
	@Column(name = "VALORMONETARIOCOBRO")
	private BigDecimal valorMonetarioCobro;
	
	@Column(name = "VALORPORCENTAJECOBRO")
	private BigDecimal valorPorcentajeCobro;
	
	@Column (name = "ESTADOPARTICIPACION")
	private Boolean estadoParticipacion ;
	
	@Column (name = "ESTADOVENTACOSTO")
	private Boolean estadoVentaCosto;	

	@Column (name = "CUOTAS")
	private Integer cuota;


	@Column(name = "ESTADO")
	private Boolean estado;
	
	@Column(name = "IDUSUARIOREGISTRO")
	private String idUsuarioRegistro;
	
	@Column(name = "FECHAREGISTRO")
	private Date fechaRegistro;
	
	@Column(name = "IDUSUARIOMODIFICACION")
	private String idUsuarioModificacion;
	
	@Column(name = "FECHAMODIFICACION")
	private Date fechaModificacion;
	
	@Column(name = "DIASCOBRO")
	private String diasCobro;
	
	
	@Column (name = "ISFINPROMOCION")
	private Boolean isFinPromocion;	
	
	@Transient
	boolean activarCuota;
	/**
	 * Relacion a negociacion articulos
	 */
	@OneToMany(mappedBy="detalleNegociacionDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<NegociacionArticuloDTO> negociacionArticulos;
	
	/**
	 * Relacion a NegociacionCuentas contables
	 */
	@OneToMany(mappedBy="detalleNegociacionDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<NegociacionCuentaContableDTO> negociacionCuentaContables;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name="CODIGOCOMPANIA",referencedColumnName="CODIGOCOMPANIA",insertable=false,updatable=false),
		@JoinColumn(name="CODIGONEGOCIACION",referencedColumnName="CODIGONEGOCIACION",insertable=false,updatable=false)})
	private NegociacionDTO negociacionDTO;
	
	@OneToMany(mappedBy="detalleNegociacionDTO")
	@CollectionTypeInfo(name=CollectionType.LIST_COLLECTION_TYPE)
	private Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> detalleNegociacionGestionPrecioCovenioParticipanteDTOCol;

	public DetalleNegociacionID getId() {
		return id;
	}

	public void setId(DetalleNegociacionID id) {
		this.id = id;
	}

	public String getCodigoValorPeriodicidadCorte() {
		return codigoValorPeriodicidadCorte;
	}

	public void setCodigoValorPeriodicidadCorte(String codigoValorPeriodicidadCorte) {
		this.codigoValorPeriodicidadCorte = codigoValorPeriodicidadCorte;
	}

	public Integer getCodigoTipoPeriodicidadCorte() {
		return codigoTipoPeriodicidadCorte;
	}

	public void setCodigoTipoPeriodicidadCorte(Integer codigoTipoPeriodicidadCorte) {
		this.codigoTipoPeriodicidadCorte = codigoTipoPeriodicidadCorte;
	}

	public String getCodigoValorPlazoCobro() {
		return codigoValorPlazoCobro;
	}

	public void setCodigoValorPlazoCobro(String codigoValorPlazoCobro) {
		this.codigoValorPlazoCobro = codigoValorPlazoCobro;
	}

	public Integer getCodigoTipoPlazoCobro() {
		return codigoTipoPlazoCobro;
	}

	public void setCodigoTipoPlazoCobro(Integer codigoTipoPlazoCobro) {
		this.codigoTipoPlazoCobro = codigoTipoPlazoCobro;
	}

	public String getCodigoValorCondicionCobro() {
		return codigoValorCondicionCobro;
	}

	public void setCodigoValorCondicionCobro(String codigoValorCondicionCobro) {
		this.codigoValorCondicionCobro = codigoValorCondicionCobro;
	}

	public Integer getCodigoTipoCondicionCobro() {
		return codigoTipoCondicionCobro;
	}

	public void setCodigoTipoCondicionCobro(Integer codigoTipoCondicionCobro) {
		this.codigoTipoCondicionCobro = codigoTipoCondicionCobro;
	}

	public String getCodigoValorInicioCobro() {
		return codigoValorInicioCobro;
	}

	public void setCodigoValorInicioCobro(String codigoValorInicioCobro) {
		this.codigoValorInicioCobro = codigoValorInicioCobro;
	}

	public Integer getCodigoTipoInicioCobro() {
		return codigoTipoInicioCobro;
	}

	public void setCodigoTipoInicioCobro(Integer codigoTipoInicioCobro) {
		this.codigoTipoInicioCobro = codigoTipoInicioCobro;
	}

	public String getCodigoValorTipoFormaVenta() {
		return codigoValorTipoFormaVenta;
	}

	public void setCodigoValorTipoFormaVenta(String codigoValorTipoFormaVenta) {
		this.codigoValorTipoFormaVenta = codigoValorTipoFormaVenta;
	}

	public Integer getCodigoTipoFormaVenta() {
		return codigoTipoFormaVenta;
	}

	public void setCodigoTipoFormaVenta(Integer codigoTipoFormaVenta) {
		this.codigoTipoFormaVenta = codigoTipoFormaVenta;
	}

	public String getCodigoValorAplicacionDescuento() {
		return codigoValorAplicacionDescuento;
	}

	public void setCodigoValorAplicacionDescuento(String codigoValorAplicacionDescuento) {
		this.codigoValorAplicacionDescuento = codigoValorAplicacionDescuento;
	}

	public Integer getCodigoTipoAplicacionDescuento() {
		return codigoTipoAplicacionDescuento;
	}

	public void setCodigoTipoAplicacionDescuento(Integer codigoTipoAplicacionDescuento) {
		this.codigoTipoAplicacionDescuento = codigoTipoAplicacionDescuento;
	}

	public Date getFechaInicioCobro() {
		return fechaInicioCobro;
	}

	public void setFechaInicioCobro(Date fechaInicioCobro) {
		this.fechaInicioCobro = fechaInicioCobro;
	}

	public Date getFechaFinCobro() {
		return fechaFinCobro;
	}

	public void setFechaFinCobro(Date fechaFinCobro) {
		this.fechaFinCobro = fechaFinCobro;
	}

	public BigDecimal getValorMonetarioCobro() {
		return valorMonetarioCobro;
	}

	public void setValorMonetarioCobro(BigDecimal valorMonetarioCobro) {
		this.valorMonetarioCobro = valorMonetarioCobro;
	}

	public BigDecimal getValorPorcentajeCobro() {
		return valorPorcentajeCobro==null?(new BigDecimal("100")):valorPorcentajeCobro;
	}

	public void setValorPorcentajeCobro(BigDecimal valorPorcentajeCobro) {
		this.valorPorcentajeCobro = valorPorcentajeCobro;
	}

	public Boolean getEstadoParticipacion() {
		return estadoParticipacion;
	}

	public void setEstadoParticipacion(Boolean estadoParticipacion) {
		this.estadoParticipacion = estadoParticipacion;
	}

	public Boolean getEstadoVentaCosto() {
		return estadoVentaCosto;
	}

	public void setEstadoVentaCosto(Boolean estadoVentaCosto) {
		this.estadoVentaCosto = estadoVentaCosto;
	}

	public Integer getCuota() {
		return cuota;
	}

	public void setCuota(Integer cuota) {
		this.cuota = cuota;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getIdUsuarioModificacion() {
		return idUsuarioModificacion;
	}

	public void setIdUsuarioModificacion(String idUsuarioModificacion) {
		this.idUsuarioModificacion = idUsuarioModificacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Collection<NegociacionArticuloDTO> getNegociacionArticulos() {
		return negociacionArticulos;
	}

	public void setNegociacionArticulos(Collection<NegociacionArticuloDTO> negociacionArticulos) {
		this.negociacionArticulos = negociacionArticulos;
	}

	public Collection<NegociacionCuentaContableDTO> getNegociacionCuentaContables() {
		return negociacionCuentaContables;
	}

	public void setNegociacionCuentaContables(Collection<NegociacionCuentaContableDTO> negociacionCuentaContables) {
		this.negociacionCuentaContables = negociacionCuentaContables;
	}

	public Long getCodigoNegociacion() {
		return codigoNegociacion;
	}

	public void setCodigoNegociacion(Long codigoNegociacion) {
		this.codigoNegociacion = codigoNegociacion;
	}

	public String getDiasCobro() {
		return diasCobro;
	}

	public void setDiasCobro(String diasCobro) {
		this.diasCobro = diasCobro;
	}

	/** Metodo que retorna isFinPromocion del objeto
	 * @author srodriguez
	 * 26/3/2015
	 * @return Boolean isFinPromocion 
	 */
	public Boolean getIsFinPromocion() {
		return isFinPromocion;
	}

	/** Metodo que asigna el valor isFinPromocion en isFinPromocion del objeto
	 * @author srodriguez
	 * 26/3/2015
	 * @param isFinPromocion
	 */
	
	public void setIsFinPromocion(Boolean isFinPromocion) {
		this.isFinPromocion = isFinPromocion;
	}

	/** Metodo que retorna negociacionDTO del objeto
	 * @author srodriguez
	 * 26/3/2015
	 * @return NegociacionDTO negociacionDTO 
	 */
	public NegociacionDTO getNegociacionDTO() {
		return negociacionDTO;
	}

	/** Metodo que asigna el valor negociacionDTO en negociacionDTO del objeto
	 * @author srodriguez
	 * 26/3/2015
	 * @param negociacionDTO
	 */
	
	public void setNegociacionDTO(NegociacionDTO negociacionDTO) {
		this.negociacionDTO = negociacionDTO;
	}

	/**
	 * @return the activarCuota
	 */
	public boolean getActivarCuota() {
		return activarCuota;
	}

	/**
	 * @param activarCuota the activarCuota to set
	 */
	public void setActivarCuota(boolean activarCuota) {
		this.activarCuota = activarCuota;
	}

	public String getCodigoValorCentroCosto() {
		return codigoValorCentroCosto;
	}

	public void setCodigoValorCentroCosto(String codigoValorCentroCosto) {
		this.codigoValorCentroCosto = codigoValorCentroCosto;
	}

	public Integer getCodigoTipoCentroCosto() {
		return codigoTipoCentroCosto;
	}

	public void setCodigoTipoCentroCosto(Integer codigoTipoCentroCosto) {
		this.codigoTipoCentroCosto = codigoTipoCentroCosto;
	}

	public CatalogoValorDTO getFormaVentaCatalogoValorDTO() {
		return formaVentaCatalogoValorDTO;
	}

	public void setFormaVentaCatalogoValorDTO(CatalogoValorDTO formaVentaCatalogoValorDTO) {
		this.formaVentaCatalogoValorDTO = formaVentaCatalogoValorDTO;
	}

	public Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> getDetalleNegociacionGestionPrecioCovenioParticipanteDTOCol() {
		return detalleNegociacionGestionPrecioCovenioParticipanteDTOCol;
	}

	public void setDetalleNegociacionGestionPrecioCovenioParticipanteDTOCol(Collection<DetalleNegociacionGestionPrecioCovenioParticipanteDTO> detalleNegociacionGestionPrecioCovenioParticipanteDTOCol) {
		this.detalleNegociacionGestionPrecioCovenioParticipanteDTOCol = detalleNegociacionGestionPrecioCovenioParticipanteDTOCol;
	}

	public String getCodigoValorCobroCosto() {
		return codigoValorCobroCosto;
	}

	public void setCodigoValorCobroCosto(String codigoValorCobroCosto) {
		this.codigoValorCobroCosto = codigoValorCobroCosto;
	}

	public Integer getCodigoTipoCobroCosto() {
		return codigoTipoCobroCosto;
	}

	public void setCodigoTipoCobroCosto(Integer codigoTipoCobroCosto) {
		this.codigoTipoCobroCosto = codigoTipoCobroCosto;
	}
}
