package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.nopersistente.FacturaDigitalEST;

@Entity
@SuppressWarnings("serial")
public class VistaEntregaFacturaDigitalDTO extends SearchDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.VistaEntregaFacturaDigitalID id = new ec.com.smx.sic.cliente.mdl.dto.id.VistaEntregaFacturaDigitalID();
	
	private Date fechaEntrega;
	
	private String codigoProveedor;
	
	private String valorTipoSeccion ;
	
	private Integer cantidadAndenes;
	
	private Integer cantidadFacturas;
	
	private String estadoEntrega;
	
	private String estadoAutorizacion;
	
	private Long codigoAutorizacion;
	
	private String numeroAutorizacion;
	
	private String observacionEntrega;
	
	private Date fechaAutorizacion;
	
	private String processCode;
	
	private String nombreAreaTrabajo;
	
	/**
	 * codigo asignado a un area de trabajo.
	 * 
	 */
	private Integer codigoAreaTrabajoEntrega;
	
	/**
	 * Variable que contiene datos para la creacion de una factura
	 */
	@Transient
	private FacturaEstadoDTO facturaEstadoDTO; 
	
	/**
	 * Articulos de la entrega de las ordenes de compra
	 */
	@Transient
	private Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs;
	
	/**
	 * 
	 */
	@Transient
	private Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs;
	
	/**
	 * Estructura para agrupar los articulos iguales de una entrega
	 */
	@Transient
	private Collection<FacturaDigitalEST> facturaDigitalESTs;
	
	/**
	 * Facturas de las entrega
	 */
	@Transient
	private Collection<FacturaEstadoDTO> facturaEstadoDTOs;

	/**
	 * Estructura que contiene los articulos para creacion de una factura
	 */
	@Transient
	private Collection<FacturaDigitalEST> facturaDigitalESTSeleccionados;
	
	/**
	 * Estructura que contiene los impuestos de una factura.
	 */
	@Transient
	private Collection<FacturaEstadoImpuestoDTO> facturaEstadoImpuestoDTOs; 
	
	/**
	 * Variable para controlar si se despliegan los articulos de la entrega
	 */
	@Transient
	private Boolean desplegar;
	
	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.VistaEntregaFacturaDigitalID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.VistaEntregaFacturaDigitalID id) {
		this.id = id;
	}

	/**
	 * @return the fechaEntrega
	 */
	public java.util.Date getFechaEntrega() {
		return fechaEntrega;
	}

	/**
	 * @param fechaEntrega the fechaEntrega to set
	 */
	public void setFechaEntrega(java.util.Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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

	/**
	 * @return the valorTipoSeccion
	 */
	public String getValorTipoSeccion() {
		return valorTipoSeccion;
	}

	/**
	 * @param valorTipoSeccion the valorTipoSeccion to set
	 */
	public void setValorTipoSeccion(String valorTipoSeccion) {
		this.valorTipoSeccion = valorTipoSeccion;
	}

	/**
	 * @return the cantidadAndenes
	 */
	public Integer getCantidadAndenes() {
		return cantidadAndenes;
	}

	/**
	 * @param cantidadAndenes the cantidadAndenes to set
	 */
	public void setCantidadAndenes(Integer cantidadAndenes) {
		this.cantidadAndenes = cantidadAndenes;
	}

	/**
	 * @return the cantidadFacturas
	 */
	public Integer getCantidadFacturas() {
		return cantidadFacturas;
	}

	/**
	 * @param cantidadFacturas the cantidadFacturas to set
	 */
	public void setCantidadFacturas(Integer cantidadFacturas) {
		this.cantidadFacturas = cantidadFacturas;
	}

	/**
	 * @return the estadoEntrega
	 */
	public String getEstadoEntrega() {
		return estadoEntrega;
	}

	/**
	 * @param estadoEntrega the estadoEntrega to set
	 */
	public void setEstadoEntrega(String estadoEntrega) {
		this.estadoEntrega = estadoEntrega;
	}

	/**
	 * @return the estadoAutorizacion
	 */
	public String getEstadoAutorizacion() {
		return estadoAutorizacion;
	}

	/**
	 * @param estadoAutorizacion the estadoAutorizacion to set
	 */
	public void setEstadoAutorizacion(String estadoAutorizacion) {
		this.estadoAutorizacion = estadoAutorizacion;
	}

	/**
	 * @return the codigoAutorizacion
	 */
	public Long getCodigoAutorizacion() {
		return codigoAutorizacion;
	}

	/**
	 * @param codigoAutorizacion the codigoAutorizacion to set
	 */
	public void setCodigoAutorizacion(Long codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	/**
	 * @return the numeroAutorizacion
	 */
	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	/**
	 * @param numeroAutorizacion the numeroAutorizacion to set
	 */
	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	/**
	 * @return the fechaAutorizacion
	 */
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	/**
	 * @param fechaAutorizacion the fechaAutorizacion to set
	 */
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	/**
	 * @return the processCode
	 */
	public String getProcessCode() {
		return processCode;
	}

	/**
	 * @param processCode the processCode to set
	 */
	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	/**
	 * @return the nombreAreaTrabajo
	 */
	public String getNombreAreaTrabajo() {
		return nombreAreaTrabajo;
	}

	/**
	 * @param nombreAreaTrabajo the nombreAreaTrabajo to set
	 */
	public void setNombreAreaTrabajo(String nombreAreaTrabajo) {
		this.nombreAreaTrabajo = nombreAreaTrabajo;
	}

	/**
	 * @return the observacionEntrega
	 */
	public String getObservacionEntrega() {
		return observacionEntrega;
	}

	/**
	 * @param observacionEntrega the observacionEntrega to set
	 */
	public void setObservacionEntrega(String observacionEntrega) {
		this.observacionEntrega = observacionEntrega;
	}

	/**
	 * @return the ordenCompraDetalleEstadoDTOs
	 */
	public Collection<OrdenCompraDetalleEstadoDTO> getOrdenCompraDetalleEstadoDTOs() {
		return ordenCompraDetalleEstadoDTOs;
	}

	/**
	 * @param ordenCompraDetalleEstadoDTOs the ordenCompraDetalleEstadoDTOs to set
	 */
	public void setOrdenCompraDetalleEstadoDTOs(Collection<OrdenCompraDetalleEstadoDTO> ordenCompraDetalleEstadoDTOs) {
		this.ordenCompraDetalleEstadoDTOs = ordenCompraDetalleEstadoDTOs;
	}

	/**
	 * @return the desplegar
	 */
	public Boolean getDesplegar() {
		return desplegar;
	}

	/**
	 * @param desplegar the desplegar to set
	 */
	public void setDesplegar(Boolean desplegar) {
		this.desplegar = desplegar;
	}

	/**
	 * @return the facturaDigitalESTs
	 */
	public Collection<FacturaDigitalEST> getFacturaDigitalESTs() {
		return facturaDigitalESTs;
	}

	/**
	 * @param facturaDigitalESTs the facturaDigitalESTs to set
	 */
	public void setFacturaDigitalESTs(Collection<FacturaDigitalEST> facturaDigitalESTs) {
		this.facturaDigitalESTs = facturaDigitalESTs;
	}

	/**
	 * @return the facturaEstadoDTOs
	 */
	public Collection<FacturaEstadoDTO> getFacturaEstadoDTOs() {
		return facturaEstadoDTOs;
	}

	/**
	 * @param facturaEstadoDTOs the facturaEstadoDTOs to set
	 */
	public void setFacturaEstadoDTOs(Collection<FacturaEstadoDTO> facturaEstadoDTOs) {
		this.facturaEstadoDTOs = facturaEstadoDTOs;
	}

	public FacturaEstadoDTO getFacturaEstadoDTO() {
		return facturaEstadoDTO;
	}

	public void setFacturaEstadoDTO(FacturaEstadoDTO facturaEstadoDTO) {
		this.facturaEstadoDTO = facturaEstadoDTO;
	}

	public Collection<FacturaDigitalEST> getFacturaDigitalESTSeleccionados() {
		return facturaDigitalESTSeleccionados;
	}

	public void setFacturaDigitalESTSeleccionados(Collection<FacturaDigitalEST> facturaDigitalESTSeleccionados) {
		this.facturaDigitalESTSeleccionados = facturaDigitalESTSeleccionados;
	}

	public Collection<OrdenCompraEstadoDTO> getOrdenCompraEstadoDTOs() {
		return ordenCompraEstadoDTOs;
	}

	public void setOrdenCompraEstadoDTOs(Collection<OrdenCompraEstadoDTO> ordenCompraEstadoDTOs) {
		this.ordenCompraEstadoDTOs = ordenCompraEstadoDTOs;
	}

	public Integer getCodigoAreaTrabajoEntrega() {
		return codigoAreaTrabajoEntrega;
	}

	public void setCodigoAreaTrabajoEntrega(Integer codigoAreaTrabajoEntrega) {
		this.codigoAreaTrabajoEntrega = codigoAreaTrabajoEntrega;
	}

	public Collection<FacturaEstadoImpuestoDTO> getFacturaEstadoImpuestoDTOs() {
		return facturaEstadoImpuestoDTOs;
	}

	public void setFacturaEstadoImpuestoDTOs(Collection<FacturaEstadoImpuestoDTO> facturaEstadoImpuestoDTOs) {
		this.facturaEstadoImpuestoDTOs = facturaEstadoImpuestoDTOs;
	}
	
}
