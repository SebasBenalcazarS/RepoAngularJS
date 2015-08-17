package ec.com.smx.sic.cliente.mdl.dto;

import static javax.persistence.FetchType.LAZY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.sic.cliente.mdl.dto.id.HistorialArticuloProveedorPrecioID;

@Entity
@Table(name="SCPRETHISARTPROPRE")
@SuppressWarnings("serial")
public class HistorialArticuloProveedorPrecioDTO extends AuditoriaBaseDTO {

	@EmbeddedId
	private HistorialArticuloProveedorPrecioID id = new HistorialArticuloProveedorPrecioID();

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAINICIO", nullable = false)	
	private Date fechaVigenciaInicio ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAVIGENCIAFIN")	
	private Date fechaVigenciaFin ;
	
	@Column(name = "COSTOBRUTOANTERIOR" , nullable = false)
	private Double costoBrutoAnterior;

	@Column(name = "COSTOBRUTONUEVO" , nullable = false)
	private Double costoBrutoNuevo;
	
	@Column(name = "COSTONETOANTERIOR" , nullable = false)
	private Double costoNetoAnterior;
	
	@Column(name = "COSTONETONUEVO" , nullable = false)
	private Double costoNetoNuevo;

	@Column(name = "COSTONETONOTACREDITOANTERIOR" , nullable = false)
	private Double costoNetoNotaCreditoAnterior;
	
	@Column(name = "COSTONETONOTACREDITONUEVO" , nullable = false)
	private Double costoNetoNotaCreditoNuevo;

	@ComparatorTypeField
	@Column(name = "ESTADO", nullable = false)
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName="CODIGOCOMPANIA", insertable=false, updatable=false),
		@JoinColumn(name = "CODIGOHISTORIALPRECIO" , referencedColumnName="CODIGOHISTORIALPRECIO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO" , referencedColumnName="CODIGOARTICULO", insertable = false, updatable = false)})
	private HistorialArticuloPrecioDTO historialArticuloPrecio;
	
	@ManyToOne(fetch = LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTICULO", referencedColumnName = "CODIGOARTICULO", insertable = false, updatable = false), 
		@JoinColumn(name = "CODIGOPROVEEDOR", referencedColumnName = "CODIGOPROVEEDOR", insertable = false, updatable = false)
	})
	private ArticuloProveedorDTO articuloProveedor;
	
	
	/**
	 * @return the id
	 */
	public HistorialArticuloProveedorPrecioID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(HistorialArticuloProveedorPrecioID id) {
		this.id = id;
	}

	/**
	 * @return the costoBrutoAnterior
	 */
	public Double getCostoBrutoAnterior() {
		return costoBrutoAnterior;
	}

	/**
	 * @param costoBrutoAnterior the costoBrutoAnterior to set
	 */
	public void setCostoBrutoAnterior(Double costoBrutoAnterior) {
		this.costoBrutoAnterior = costoBrutoAnterior;
	}

	/**
	 * @return the costoBrutoNuevo
	 */
	public Double getCostoBrutoNuevo() {
		return costoBrutoNuevo;
	}

	/**
	 * @param costoBrutoNuevo the costoBrutoNuevo to set
	 */
	public void setCostoBrutoNuevo(Double costoBrutoNuevo) {
		this.costoBrutoNuevo = costoBrutoNuevo;
	}

	/**
	 * @return the costoNetoAnterior
	 */
	public Double getCostoNetoAnterior() {
		return costoNetoAnterior;
	}

	/**
	 * @param costoNetoAnterior the costoNetoAnterior to set
	 */
	public void setCostoNetoAnterior(Double costoNetoAnterior) {
		this.costoNetoAnterior = costoNetoAnterior;
	}

	/**
	 * @return the costoNetoNuevo
	 */
	public Double getCostoNetoNuevo() {
		return costoNetoNuevo;
	}

	/**
	 * @param costoNetoNuevo the costoNetoNuevo to set
	 */
	public void setCostoNetoNuevo(Double costoNetoNuevo) {
		this.costoNetoNuevo = costoNetoNuevo;
	}

	/**
	 * @return the costoNetoNotaCreditoAnterior
	 */
	public Double getCostoNetoNotaCreditoAnterior() {
		return costoNetoNotaCreditoAnterior;
	}

	/**
	 * @param costoNetoNotaCreditoAnterior the costoNetoNotaCreditoAnterior to set
	 */
	public void setCostoNetoNotaCreditoAnterior(Double costoNetoNotaCreditoAnterior) {
		this.costoNetoNotaCreditoAnterior = costoNetoNotaCreditoAnterior;
	}

	/**
	 * @return the costoNetoNotaCreditoNuevo
	 */
	public Double getCostoNetoNotaCreditoNuevo() {
		return costoNetoNotaCreditoNuevo;
	}

	/**
	 * @param costoNetoNotaCreditoNuevo the costoNetoNotaCreditoNuevo to set
	 */
	public void setCostoNetoNotaCreditoNuevo(Double costoNetoNotaCreditoNuevo) {
		this.costoNetoNotaCreditoNuevo = costoNetoNotaCreditoNuevo;
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
	 * @return the historialArticuloPrecio
	 */
	public HistorialArticuloPrecioDTO getHistorialArticuloPrecio() {
		return historialArticuloPrecio;
	}

	/**
	 * @param historialArticuloPrecio the historialArticuloPrecio to set
	 */
	public void setHistorialArticuloPrecio(HistorialArticuloPrecioDTO historialArticuloPrecio) {
		this.historialArticuloPrecio = historialArticuloPrecio;
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
	 * @return the fechaVigenciaInicio
	 */
	public Date getFechaVigenciaInicio() {
		return fechaVigenciaInicio;
	}

	/**
	 * @param fechaVigenciaInicio the fechaVigenciaInicio to set
	 */
	public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
		this.fechaVigenciaInicio = fechaVigenciaInicio;
	}

	/**
	 * @return the fechaVigenciaFin
	 */
	public Date getFechaVigenciaFin() {
		return fechaVigenciaFin;
	}

	/**
	 * @param fechaVigenciaFin the fechaVigenciaFin to set
	 */
	public void setFechaVigenciaFin(Date fechaVigenciaFin) {
		this.fechaVigenciaFin = fechaVigenciaFin;
	}
}
