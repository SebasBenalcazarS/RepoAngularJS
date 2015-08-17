package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.math.BigDecimal;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

@SuppressWarnings("serial")
public class RecepcionModificarPalletAuditEST extends SimpleAuditDTO {

	private Integer codigoCompania;
	
	private Long codigoRecepcionProveedor;
	
	private String codigoBarrasPallet;
	
	private Integer cantidad;
	
	private BigDecimal peso;
	
	private String accesItemID;
	
	private String codigoSistema;

	public RecepcionModificarPalletAuditEST() {
		super();
	}

	public RecepcionModificarPalletAuditEST(Integer codigoCompania, Long codigoRecepcionProveedor, String codigoBarrasPallet, Integer cantidad, BigDecimal peso, String accesItemID, String userId, String codigoSistema) {
		super();
		this.setUserId(userId);
		this.codigoCompania = codigoCompania;
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
		this.codigoBarrasPallet = codigoBarrasPallet;
		this.cantidad = cantidad;
		this.peso = peso;
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
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
