package ec.com.smx.sic.cliente.mdl.nopersistente;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

@SuppressWarnings("serial")
public class RecepcionCancelarPalletAuditEST extends SimpleAuditDTO {

	private Integer codigoCompania;
	
	private Long codigoRecepcionProveedor;
	
	private String codigoBarrasPallet;
	
	private String estado;
	
	private String accesItemID;
	
	private String codigoSistema;

	public RecepcionCancelarPalletAuditEST() {
		super();
	}

	public RecepcionCancelarPalletAuditEST(Integer codigoCompania, Long codigoRecepcionProveedor, String codigoBarrasPallet, String estado, String accesItemID, String userId, String codigoSistema) {
		super();
		this.setUserId(userId);
		this.codigoCompania = codigoCompania;
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
		this.codigoBarrasPallet = codigoBarrasPallet;
		this.estado = estado;
		this.accesItemID = accesItemID;
		this.codigoSistema = codigoSistema;
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

	public String getCodigoBarrasPallet() {
		return codigoBarrasPallet;
	}

	public void setCodigoBarrasPallet(String codigoBarrasPallet) {
		this.codigoBarrasPallet = codigoBarrasPallet;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAccesItemID() {
		return accesItemID;
	}

	public void setAccesItemID(String accesItemID) {
		this.accesItemID = accesItemID;
	}

	public String getCodigoSistema() {
		return codigoSistema;
	}

	public void setCodigoSistema(String codigoSistema) {
		this.codigoSistema = codigoSistema;
	}
	
}
