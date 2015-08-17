package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.common.articulo.SICArticuloCalculo;
import ec.com.smx.sic.cliente.common.factory.SICFactory;
import ec.com.smx.sic.cliente.mdl.dto.id.ArticuloProveedorGestionPrecioID;
import ec.com.smx.sic.cliente.mdl.nopersistente.ArticuloProveedorGestionPrecioTransient;

/**
 * @author Luis Yacchirema
 *
 */
@Entity
@Table(name="SCPRETARTPROGESPRE")
@SuppressWarnings("serial")
public class ArticuloProveedorGestionPrecioDTO extends ArticuloProveedorGestionPrecioTransient {

	@EmbeddedId
	private ArticuloProveedorGestionPrecioID id = new ArticuloProveedorGestionPrecioID();
	
	@Transient
	private BigDecimal costoMonedaOrigen;
	
	@Transient
	public BigDecimal costoDerechoImportacion;

	@Column(name = "COSTOBRUTO" , nullable = false)
	private Double costoBruto;

	@Column(name = "CODIGOVALORCOSTOGESTION" , nullable = false)
	private Long codigoValorCostoGestion;

	@Column(name = "ESPROVEEDORBASE" , nullable = false)
	private Boolean esProveedorBase;

	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name = "CODIGOGESTIONPRECIO" , referencedColumnName="CODIGOGESTIONPRECIO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO" , referencedColumnName="CODIGOARTICULO", insertable = false, updatable = false)})
	private ArticuloGestionPrecioDTO articuloGestionPrecio;

	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ArticuloProveedorDTO articuloProveedor;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "CODIGOCOMPANIA", insertable = false, updatable = false, referencedColumnName="CODIGOCOMPANIA"),
		@JoinColumn(name = "CODIGOVALORCOSTOGESTION", insertable = false, updatable = false, referencedColumnName = "CODIGOVALORCOSTOGESTION")})
	private ValorCostoGestionDTO valorCostoGestion;

	/**
	 * @return the id
	 */
	public ArticuloProveedorGestionPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ArticuloProveedorGestionPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the costoBruto
	 */
	public Double getCostoBruto() {
		return costoBruto;
	}

	/**
	 * @param costoBruto the costoBruto to set
	 */
	public void setCostoBruto(Double costoBruto) {
		this.costoBruto = costoBruto;
	}

	/**
	 * @return the costoNeto
	 */
	public Double getCostoNeto() {

		// Calcular costo neto anterior
		if (super.costoNeto == null && this.costoBruto != null && SearchDTO.isLoaded(this.articuloProveedor)) {
			super.costoNeto = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNeto(this.costoBruto,
					this.articuloProveedor.getDescuentoProveedorArticuloCol(), this.articuloProveedor.getUnidadesManejo());
		}

		return super.costoNeto;
	}

	/**
	 * @param costoNeto the costoNeto to set
	 */
	public void setCostoNeto(Double costoNeto) {
		this.costoNeto = costoNeto;
	}

	/**
	 * @return the margenPVP
	 */
	public Double getMargenPVP() {

		// Calcular margen PVP anterior
		if (super.margenPVP == null && this.getCostoNeto() != null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.margenPVP = SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.articuloGestionPrecio.getPrecioPVPAnterior(), this.getCostoNeto());
		}

		return super.margenPVP;
	}

	/**
	 * @param margenPVP the margenPVP to set
	 */
	public void setMargenPVP(Double margenPVP) {
		this.margenPVP = margenPVP;
	}

	/**
	 * @return the margenSMX
	 */
	public Double getMargenSMX() {

		// Calcular margen SMX anterior
		if (super.margenSMX == null && this.getCostoNeto() != null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.margenSMX = SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.articuloGestionPrecio.getPrecioSMXAnterior(), this.getCostoNeto());
		}

		return super.margenSMX;
	}

	/**
	 * @param margenSMX the margenSMX to set
	 */
	public void setMargenSMX(Double margenSMX) {
		this.margenSMX = margenSMX;
	}

	/**
	 * @return the costoNetoNuevo
	 */
	public Double getCostoNetoNuevo() {

		// Calcular costo neto nuevo
		if (super.costoNetoNuevo == null && SearchDTO.isLoaded(this.articuloProveedor)
				&& SearchDTO.isLoaded(this.valorCostoGestion) && this.valorCostoGestion.getCostoBruto() != null) {
			super.costoNetoNuevo = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNeto(this.valorCostoGestion.getCostoBruto(),
					this.articuloProveedor.getDescuentoProveedorArticuloCol(), this.articuloProveedor.getUnidadesManejo());
		}

		return super.costoNetoNuevo;
	}

	/**
	 * @param costoNetoNuevo the costoNetoNuevo to set
	 */
	public void setCostoNetoNuevo(Double costoNetoNuevo) {
		this.costoNetoNuevo = costoNetoNuevo;
	}

	/**
	 * @return the margenPVPNuevo
	 */
	public Double getMargenPVPNuevo() {

		// Calcular margen PVP nuevo
		if (super.margenPVPNuevo == null && this.getCostoNetoNuevo() != null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.margenPVPNuevo = SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.articuloGestionPrecio.getPrecioPVPNuevo(), this.getCostoNetoNuevo());
		}

		return super.margenPVPNuevo;
	}

	/**
	 * @param margenPVPNuevo the margenPVPNuevo to set
	 */
	public void setMargenPVPNuevo(Double margenPVPNuevo) {
		this.margenPVPNuevo = margenPVPNuevo;
	}

	/**
	 * @return the margenSMXNuevo
	 */
	public Double getMargenSMXNuevo() {

		// Calcular margen SMX nuevo
		if (super.margenSMXNuevo == null && this.getCostoNetoNuevo() != null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.margenSMXNuevo = SICArticuloCalculo.getInstancia().calcularMargenPrecio(this.articuloGestionPrecio.getPrecioSMXNuevo(), this.getCostoNetoNuevo());
		}

		return super.margenSMXNuevo;
	}

	/**
	 * @param margenSMXNuevo the margenSMXNuevo to set
	 */
	public void setMargenSMXNuevo(Double margenSMXNuevo) {
		this.margenSMXNuevo = margenSMXNuevo;
	}

	/**
	 * @return the codigoValorCostoGestion
	 */
	public Long getCodigoValorCostoGestion() {
		return codigoValorCostoGestion;
	}

	/**
	 * @param codigoValorCostoGestion the codigoValorCostoGestion to set
	 */
	public void setCodigoValorCostoGestion(Long codigoValorCostoGestion) {
		this.codigoValorCostoGestion = codigoValorCostoGestion;
	}

	/**
	 * @return the esProveedorBase
	 */
	public Boolean getEsProveedorBase() {
		return esProveedorBase;
	}

	/**
	 * @param esProveedorBase the esProveedorBase to set
	 */
	public void setEsProveedorBase(Boolean esProveedorBase) {
		this.esProveedorBase = esProveedorBase;
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
	 * @return the articuloGestionPrecio
	 */
	public ArticuloGestionPrecioDTO getArticuloGestionPrecio() {
		return articuloGestionPrecio;
	}

	/**
	 * @param articuloGestionPrecio the articuloGestionPrecio to set
	 */
	public void setArticuloGestionPrecio(ArticuloGestionPrecioDTO articuloGestionPrecio) {
		this.articuloGestionPrecio = articuloGestionPrecio;
	}

	/**
	 * @return the articuloProveedor
	 */
	public ArticuloProveedorDTO getArticuloProveedor() {
		return articuloProveedor;
	}

	/**
	 * @param articuloProveedor the articuloProveedor to set
	 */
	public void setArticuloProveedor(ArticuloProveedorDTO articuloProveedor) {
		this.articuloProveedor = articuloProveedor;
	}

	/**
	 * @return the valorCostoGestion
	 */
	public ValorCostoGestionDTO getValorCostoGestion() {
		return valorCostoGestion;
	}

	/**
	 * @param valorCostoGestion the valorCostoGestion to set
	 */
	public void setValorCostoGestion(ValorCostoGestionDTO valorCostoGestion) {
		this.valorCostoGestion = valorCostoGestion;
	}

	/**
	 * @return the costoMonedaOrigen
	 */
	public BigDecimal getCostoMonedaOrigen() {
		
		if (this.costoMonedaOrigen == null && SearchDTO.isLoaded(this.getArticuloProveedor()) && SearchDTO.isLoaded(this.articuloProveedor.getArticuloImportacion())) {
			this.costoMonedaOrigen = this.getArticuloProveedor().getArticuloImportacion().getCostoMonedaOrigen(); 
		}
		
		return this.costoMonedaOrigen;
	}

	/**
	 * @param costoMonedaOrigen the costoMonedaOrigen to set
	 */
	public void setCostoMonedaOrigen(BigDecimal costoMonedaOrigen) {
		this.costoMonedaOrigen = costoMonedaOrigen;
	}

	/**
	 * @return the costoDerechoImportacion
	 */
	public BigDecimal getCostoDerechoImportacion() {
		
		if (this.costoDerechoImportacion == null && SearchDTO.isLoaded(this.getArticuloProveedor()) && SearchDTO.isLoaded(this.articuloProveedor.getArticuloImportacion())) {
			this.costoDerechoImportacion = this.getArticuloProveedor().getArticuloImportacion().getCostoDerechoImportacion(); 
		}
		
		return this.costoDerechoImportacion;
	}

	/**
	 * @param costoDerechoImportacion the costoDerechoImportacion to set
	 */
	public void setCostoDerechoImportacion(BigDecimal costoDerechoImportacion) {
		this.costoDerechoImportacion = costoDerechoImportacion;
	}
	
	public Double getCostoNetoNCAnterior() {
		if (super.costoNetoNCAnterior == null && SearchDTO.isLoaded(this.articuloProveedor)) {
			super.costoNetoNCAnterior = this.articuloProveedor.getCostoNetoNC();
		}
		return super.costoNetoNCAnterior;
	}
	
	public void setCostoNetoNCAnterior(Double costoNetoNCAnterior) {
		super.costoNetoNCAnterior = costoNetoNCAnterior;
	}

	public Double getCostoNetoNCNuevo() {
		if (super.costoNetoNCNuevo == null && SearchDTO.isLoaded(this.articuloProveedor)) {
			super.costoNetoNCNuevo = SICFactory.getInstancia().articulo.getArticuloCalculoService().calcularCostoNetoNotaCredito(this.articuloProveedor.getDescuentoProveedorArticuloCol(), 
				this.getCostoNetoNuevo());
		}
		return super.costoNetoNCNuevo;
	}

	public void setCostoNetoNCNuevo(Double costoNetoNCNuevo) {
		super.costoNetoNCNuevo = costoNetoNCNuevo;
	}
	
	public Double getCostoNetoNotaCreditoVsPvpAnterior() {
		if (super.costoNetoNotaCreditoVsPvpAnterior == null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.costoNetoNotaCreditoVsPvpAnterior = SICArticuloCalculo.getInstancia().calcularCostoNetoNotaCreditoVsPvp(getCostoNetoNCAnterior(), this.articuloGestionPrecio.getPrecioPVPAnterior());
		}
		return super.costoNetoNotaCreditoVsPvpAnterior;
	}
	
	public void setCostoNetoNotaCreditoVsPvpAnterior(Double costoNetoNotaCreditoVsPvpAnterior) {
		super.costoNetoNotaCreditoVsPvpAnterior = costoNetoNotaCreditoVsPvpAnterior;
	}

	public Double getCostoNetoNotaCreditoVsPvpNuevo() {
		if (super.costoNetoNotaCreditoVsPvpNuevo == null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.costoNetoNotaCreditoVsPvpNuevo = SICArticuloCalculo.getInstancia().calcularCostoNetoNotaCreditoVsPvp(getCostoNetoNCNuevo(), this.articuloGestionPrecio.getPrecioPVPNuevo());
		}
		return super.costoNetoNotaCreditoVsPvpNuevo;
	}

	public void setCostoNetoNotaCreditoVsPvpNuevo(Double costoNetoNotaCreditoVsPvpNuevo) {
		super.costoNetoNotaCreditoVsPvpNuevo = costoNetoNotaCreditoVsPvpNuevo;
	}
	
	public Double getPvpVsCostoNetoNotaCreditoAnterior() {
		if (super.pvpVsCostoNetoNotaCreditoAnterior == null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.pvpVsCostoNetoNotaCreditoAnterior = SICArticuloCalculo.getInstancia().calcularPvpVsCostoNetoNotaCredito(this.articuloGestionPrecio.getPrecioPVPAnterior(), getCostoNetoNCAnterior());
		}
		return super.pvpVsCostoNetoNotaCreditoAnterior;
	}
	
	public void setPvpVsCostoNetoNotaCreditoAnterior(Double pvpVsCostoNetoNotaCreditoAnterior) {
		super.pvpVsCostoNetoNotaCreditoAnterior = pvpVsCostoNetoNotaCreditoAnterior;
	}

	public Double getPvpVsCostoNetoNotaCreditoNuevo() {
		if (super.pvpVsCostoNetoNotaCreditoNuevo == null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.pvpVsCostoNetoNotaCreditoNuevo = SICArticuloCalculo.getInstancia().calcularPvpVsCostoNetoNotaCredito(this.articuloGestionPrecio.getPrecioPVPNuevo(), getCostoNetoNCNuevo());
		}
		return super.pvpVsCostoNetoNotaCreditoNuevo;
	}

	public void setPvpVsCostoNetoNotaCreditoNuevo(Double pvpVsCostoNetoNotaCreditoNuevo) {
		super.pvpVsCostoNetoNotaCreditoNuevo = pvpVsCostoNetoNotaCreditoNuevo;
	}

	public Double getVentaCostoNetoNCAnterior() {
		if (super.ventaCostoNetoNCAnterior == null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.ventaCostoNetoNCAnterior = SICArticuloCalculo.getInstancia().calcularVentaCostoNetoNotaCredito(this.articuloGestionPrecio.getPrecioPVPAnterior(), getCostoNetoNCAnterior());
		}
		return super.ventaCostoNetoNCAnterior;
	}
	
	public void setVentaCostoNetoNCAnterior(Double ventaCostoNetoNCAnterior) {
		super.ventaCostoNetoNCAnterior = ventaCostoNetoNCAnterior;
	}

	public Double getVentaCostoNetoNCNuevo() {
		if (super.ventaCostoNetoNCNuevo == null && SearchDTO.isLoaded(this.articuloGestionPrecio)) {
			super.ventaCostoNetoNCNuevo = SICArticuloCalculo.getInstancia().calcularVentaCostoNetoNotaCredito(this.articuloGestionPrecio.getPrecioPVPNuevo(), getCostoNetoNCNuevo());
		}
		return super.ventaCostoNetoNCNuevo;
	}

	public void setVentaCostoNetoNCNuevo(Double ventaCostoNetoNCNuevo) {
		super.ventaCostoNetoNCNuevo = ventaCostoNetoNCNuevo;
	}

	public Double getVariacionCostoBruto() {
		if (super.variacionCostoBruto == null && SearchDTO.isLoaded(this.valorCostoGestion)) {
			super.variacionCostoBruto = SICArticuloCalculo.getInstancia().calcularVariacionCostoBruto(this.valorCostoGestion.getCostoBruto(), this.getCostoBruto());
		}
		return super.variacionCostoBruto;
	}

	public void setVariacionCostoBruto(Double variacionCostoBruto) {
		super.variacionCostoBruto = variacionCostoBruto;
	}

	public Double getPorcentajeVariacionCostoBruto() {
		if (super.porcentajeVariacionCostoBruto == null) {
			super.porcentajeVariacionCostoBruto = SICArticuloCalculo.getInstancia().calcularPorcentajeVariacionCostoBruto(this.getVariacionCostoBruto(), this.getCostoBruto());
		}
		return super.porcentajeVariacionCostoBruto;
	}

	public void setPorcentajeVariacionCostoBruto(Double porcentajeVariacionCostoBruto) {
		this.porcentajeVariacionCostoBruto = porcentajeVariacionCostoBruto;
	}
}
