package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.Collection;

import ec.com.smx.corpv2.dto.CompaniaDTO;
import ec.com.smx.sic.cliente.mdl.dto.FacturaEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraDTO;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProcesoLogisticoDTO;
import ec.com.smx.sic.cliente.mdl.dto.VistaProveedorDTO;

@SuppressWarnings("serial")
public class FacturaInternaVO implements Serializable {
	
	private String recibidor;
	
	private CompaniaDTO companiaDTO;
	
	private VistaProveedorDTO vistaProveedorDTO;
	
	private FacturaEstadoDTO facturaInternaEstado;
	
	private FacturaInternaCostosVO costo = new FacturaInternaCostosVO();
	
	private Integer plazoPago;

	private Collection<OrdenCompraEstadoDTO> ordenesCompraEstadoDTO;
	
	private Collection<FacturaEstadoDTO> facturasEstadosDTO;
	
	private Collection<VistaProcesoLogisticoDTO> vistasProcesosLogisticosDTO;
	
	private Collection<RecepcionArticuloVO> recepcionArticuloVOs;
	
	private Collection<OrdenCompraDTO> ordenesCompra;
	
	public String getRecibidor() {
		return recibidor;
	}

	public void setRecibidor(String recibidor) {
		this.recibidor = recibidor;
	}

	public Collection<OrdenCompraEstadoDTO> getOrdenesCompraEstadoDTO() {
		return ordenesCompraEstadoDTO;
	}

	public void setOrdenesCompraEstadoDTO(Collection<OrdenCompraEstadoDTO> ordenesCompraEstadoDTO) {
		this.ordenesCompraEstadoDTO = ordenesCompraEstadoDTO;
	}

	public VistaProveedorDTO getVistaProveedorDTO() {
		return vistaProveedorDTO;
	}

	public void setVistaProveedorDTO(VistaProveedorDTO vistaProveedorDTO) {
		this.vistaProveedorDTO = vistaProveedorDTO;
	}

	public Collection<FacturaEstadoDTO> getFacturasEstadosDTO() {
		return facturasEstadosDTO;
	}

	public void setFacturasEstadosDTO(Collection<FacturaEstadoDTO> facturasEstadosDTO) {
		this.facturasEstadosDTO = facturasEstadosDTO;
	}

	public FacturaEstadoDTO getFacturaInternaEstado() {
		return facturaInternaEstado;
	}

	public void setFacturaInternaEstado(FacturaEstadoDTO facturaInternaEstado) {
		this.facturaInternaEstado = facturaInternaEstado;
	}

	public CompaniaDTO getCompaniaDTO() {
		return companiaDTO;
	}

	public void setCompaniaDTO(CompaniaDTO companiaDTO) {
		this.companiaDTO = companiaDTO;
	}

	public Collection<VistaProcesoLogisticoDTO> getVistasProcesosLogisticosDTO() {
		return vistasProcesosLogisticosDTO;
	}

	public void setVistasProcesosLogisticosDTO(Collection<VistaProcesoLogisticoDTO> vistasProcesosLogisticosDTO) {
		this.vistasProcesosLogisticosDTO = vistasProcesosLogisticosDTO;
	}

	public Collection<RecepcionArticuloVO> getRecepcionArticuloVOs() {
		return recepcionArticuloVOs;
	}

	public void setRecepcionArticuloVOs(Collection<RecepcionArticuloVO> recepcionArticuloVOs) {
		this.recepcionArticuloVOs = recepcionArticuloVOs;
	}

	public Collection<OrdenCompraDTO> getOrdenesCompra() {
		return ordenesCompra;
	}

	public void setOrdenesCompra(Collection<OrdenCompraDTO> ordenesCompra) {
		this.ordenesCompra = ordenesCompra;
	}

	public Integer getPlazoPago() {
		return plazoPago;
	}

	public void setPlazoPago(Integer plazoPago) {
		this.plazoPago = plazoPago;
	}

	public FacturaInternaCostosVO getCosto() {
		return costo;
	}

	public void setCosto(FacturaInternaCostosVO costo) {
		this.costo = costo;
	}

}
