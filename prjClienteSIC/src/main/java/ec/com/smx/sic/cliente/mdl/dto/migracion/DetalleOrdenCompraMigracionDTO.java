package ec.com.smx.sic.cliente.mdl.dto.migracion;

import java.util.Date;

import javax.persistence.Column;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.generadorexportacion.anotaciones.Format;

/**
 * Objeto con la estructura del detalle de la migracion de ordenes de compra
 * desde el B2B al SIC
 * @author osaransig
 * Jun 7, 2013
 */
@SuppressWarnings("serial")
public class DetalleOrdenCompraMigracionDTO extends SearchDTO {

	/**
	 * tipo registro, valor 2
	 */
	@Column(length = 1)
	@Format
	private Integer tipoRegistro;
	
	@Column(length = 3)
	@Format
	private Integer unidadOperativa;
	
	@Column(length = 2)
	@Format
	private String subBodega;
	
	@Column(length = 12)
	@Format
	private String numeroOrdenCompra;
	
	@Column(length = 1)
	@Format
	private Integer tipoOrdenCompra;

	@Column(length = 17)
	@Format
	private String numeroFacturaProveedor;
	
	@Column(length = 20)
	@Format
	private String numeroAutorizacionSRI;
	
	@Column(length = 8)
	@Format
	private Date fechaCaducidadAutorizacion;
	
	@Column(length = 1)
	@Format
	private Integer entregaFactura;
	
	@Column(length = 15)
	@Format
	private String documentoOrigen;
	
	@Column(length = 12)
	@Format(numberDecimals = 4)
	public Double totalBruto;
	
	@Column(length = 11)
	@Format(numberDecimals = 4)
	public Double descuentos;
	
	@Column(length = 11)
	@Format(numberDecimals = 4)
	public Double ivaFactura;
	
	@Column(length = 9)
	@Format
	public Double impuestoVerde;
	
	@Column(length = 11)
	@Format
	public Double totalNeto;

	
	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getUnidadOperativa() {
		return unidadOperativa;
	}

	public void setUnidadOperativa(Integer unidadOperativa) {
		this.unidadOperativa = unidadOperativa;
	}

	public String getSubBodega() {
		return subBodega;
	}

	public void setSubBodega(String subBodega) {
		this.subBodega = subBodega;
	}

	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public Integer getTipoOrdenCompra() {
		return tipoOrdenCompra;
	}

	public void setTipoOrdenCompra(Integer tipoOrdenCompra) {
		this.tipoOrdenCompra = tipoOrdenCompra;
	}

	public String getNumeroFacturaProveedor() {
		return numeroFacturaProveedor;
	}

	public void setNumeroFacturaProveedor(String numeroFacturaProveedor) {
		this.numeroFacturaProveedor = numeroFacturaProveedor;
	}

	public String getNumeroAutorizacionSRI() {
		return numeroAutorizacionSRI;
	}

	public void setNumeroAutorizacionSRI(String numeroAutorizacionSRI) {
		this.numeroAutorizacionSRI = numeroAutorizacionSRI;
	}

	public Date getFechaCaducidadAutorizacion() {
		return fechaCaducidadAutorizacion;
	}

	public void setFechaCaducidadAutorizacion(Date fechaCaducidadAutorizacion) {
		this.fechaCaducidadAutorizacion = fechaCaducidadAutorizacion;
	}

	public Integer getEntregaFactura() {
		return entregaFactura;
	}

	public void setEntregaFactura(Integer entregaFactura) {
		this.entregaFactura = entregaFactura;
	}

	public Double getTotalBruto() {
		return totalBruto;
	}

	public void setTotalBruto(Double totalBruto) {
		this.totalBruto = totalBruto;
	}

	public Double getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(Double descuentos) {
		this.descuentos = descuentos;
	}

	public Double getIvaFactura() {
		return ivaFactura;
	}

	public void setIvaFactura(Double ivaFactura) {
		this.ivaFactura = ivaFactura;
	}

	public Double getImpuestoVerde() {
		return impuestoVerde;
	}

	public void setImpuestoVerde(Double impuestoVerde) {
		this.impuestoVerde = impuestoVerde;
	}

	public Double getTotalNeto() {
		return totalNeto;
	}

	public void setTotalNeto(Double totalNeto) {
		this.totalNeto = totalNeto;
	}

	public String getDocumentoOrigen() {
		return documentoOrigen;
	}

	public void setDocumentoOrigen(String documentoOrigen) {
		this.documentoOrigen = documentoOrigen;
	}
}
