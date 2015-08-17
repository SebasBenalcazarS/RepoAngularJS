package ec.com.smx.sic.cliente.mdl.nopersistente;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

@SuppressWarnings("serial")
public class RecepcionIngresoCajaAuditEST extends SimpleAuditDTO {

	private Integer codigoCompania;
	
	private Long codigoRecepcionProveedor;
	
	private Boolean activarIngresoCaja;
	
	private String codigoProveedor;
	
	private String accesItemID;

	public RecepcionIngresoCajaAuditEST() {
		super();
	}

	public RecepcionIngresoCajaAuditEST(Integer codigoCompania, Boolean activarIngresoCaja, Long codigoRecepcionProveedor, String codigoProveedor, String userId, String accesItemID) {
		super();
		this.setUserId(userId);
		this.codigoCompania = codigoCompania;
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
		this.activarIngresoCaja = activarIngresoCaja;
		this.codigoProveedor = codigoProveedor;
		this.accesItemID = accesItemID;
	}

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

	public Boolean getActivarIngresoCaja() {
		return activarIngresoCaja;
	}

	public void setActivarIngresoCaja(Boolean activarIngresoCaja) {
		this.activarIngresoCaja = activarIngresoCaja;
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
