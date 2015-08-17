package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.math.BigDecimal;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

@SuppressWarnings("serial")
public class RecepcionOrdenCompraDetalleEstadoAuditEST extends SimpleAuditDTO{
	
	private Integer codigoCompania;
	 
	private Long codigoOrdenCompraDetalleEstado;
	 
	private BigDecimal costoBruto;
	 
	private String codigoBarras;
	
	private String accesItemID;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}

	public BigDecimal getCostoBruto() {
		return costoBruto;
	}

	public void setCostoBruto(BigDecimal costoBruto) {
		this.costoBruto = costoBruto;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getAccesItemID() {
		return accesItemID;
	}

	public void setAccesItemID(String accesItemID) {
		this.accesItemID = accesItemID;
	} 
}
