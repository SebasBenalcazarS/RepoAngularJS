package ec.com.smx.sic.cliente.mdl.nopersistente;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

@SuppressWarnings("serial")
public class RecepcionEscaneoManualAuditEST extends SimpleAuditDTO {

	private Integer codigoCompania;
	
	private Long codigoRecepcionProveedor;
	
	private Boolean activarEscaneoManual;
	
	private String codigoProveedor;
	
	private String accesItemID;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}

	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}

	public Boolean getActivarEscaneoManual() {
		return activarEscaneoManual;
	}

	public void setActivarEscaneoManual(Boolean activarEscaneoManual) {
		this.activarEscaneoManual = activarEscaneoManual;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getAccesItemID() {
		return accesItemID;
	}

	public void setAccesItemID(String accesItemID) {
		this.accesItemID = accesItemID;
	}
	
	
}
