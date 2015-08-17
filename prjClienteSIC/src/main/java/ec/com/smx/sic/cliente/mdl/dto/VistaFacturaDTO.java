package ec.com.smx.sic.cliente.mdl.dto;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

@SuppressWarnings("serial")
public class VistaFacturaDTO extends SearchDTO{
	private Integer codigoCompania;
	private Long codigoFactura;
	private String tipoDocumento;
	private String facturaEnSitio;
	private Integer codigoSubBodega;
	private String nombreSubBodega;
	private Long numeroRegistros;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getFacturaEnSitio() {
		return facturaEnSitio;
	}
	public void setFacturaEnSitio(String facturaEnSitio) {
		this.facturaEnSitio = facturaEnSitio;
	}
	public Integer getCodigoSubBodega() {
		return codigoSubBodega;
	}
	public void setCodigoSubBodega(Integer codigoSubBodega) {
		this.codigoSubBodega = codigoSubBodega;
	}
	public Long getNumeroRegistros() {
		return numeroRegistros;
	}
	public void setNumeroRegistros(Long numeroRegistros) {
		this.numeroRegistros = numeroRegistros;
	}
	public String getNombreSubBodega() {
		return nombreSubBodega;
	}
	public void setNombreSubBodega(String nombreSubBodega) {
		this.nombreSubBodega = nombreSubBodega;
	}
}