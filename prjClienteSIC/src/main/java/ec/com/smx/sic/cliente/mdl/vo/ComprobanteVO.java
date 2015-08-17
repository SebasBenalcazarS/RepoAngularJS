package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.ValidacionDocumentoDTO;

@SuppressWarnings("serial")
public class ComprobanteVO extends SearchDTO implements Serializable {

	private String numeroFacturaDocRel;
	private String establecimientoDocRel;
	private String puntoEmisionDocRel;
	private String secuencialDocRel;
	private Integer codigoCompania;
	private String codigoUsuario;
	private Integer valor;
	private String etiquetaTipoDocumentoElec;
	private String estadoDocumentoElec;
	private String codigoCliente;
	private Long codigoFactura;
	private Long codigoFacturaPadre;
	private Boolean facturaEnSitio;
	private String claveAcceso;
	private Date fechaCaducidadAutorizacion;
	private Double baseTarifaIveDocElec;
	private String etiquetaValorTipoDocumento;
	
	private Date fechaDocumento;
	private Date fechaDocumentoDocElec;	
	private String razonSocial;
	private String razonSocialDocElec;
	private String numeroAutorizacion;
	private String numeroAutorizacionDocElec;
	private String numeroFactura;
	private String numeroFacturaDocElec;
	private String ruc;
	private String rucDocElec;
	private String telefono;
	private String telefonoDocElec;
	private String establecimiento;
	private String establecimientoDocElec;
	private String puntoEmision;
	private String puntoEmisionDocElec;
	private String secuencial;
	private String secuencialDocElec;
	private String observaciones;
	private String observacionesDocElec;
	private Double baseTarifaCero;
	private Double baseTarifaCeroDocElec;
	private Double baseTarifaDoce;
	private Double baseTarifaDoceDocElec;
	private Double iva;
	private Double ivaDocElec;
	private Double ive;
	private Double iveDocElec;
	private Double valorTotal;
	private Double valorTotalDocElec;
	private Double valorTotalConImpuestos;
	private Double valorTotalConImpuestosDocElec;
	private Boolean retener;
	private Boolean retenerDocElec;
	private Double descuento;
	private Double descuentoDocElec;
	private String valorTipoDocumento;
	private String valorTipoDocumentoDocElec;
	
	//Descuentos de las tarifas
	private Double descuentoTarifaCeroDocEle;
	private Double descuentoTarifaDoceDocEle;
	
	//Comprobante XML
	private String comprobanteXml;
	
	/*Esta variable indica si el numero de documento ha sido validado o no, para esto verificamos si existe el registro en la tabla ValidacionDocumento y si es de tipo # documento*/
	private ValidacionDocumentoDTO validacionDocumentoDTO;
	private Integer validarNumeroDocumento;
	private Boolean nuevo = Boolean.TRUE;
	private Map<String, Object> estructuraValidacion;
	
	/**
	 * @return the valor
	 */
	public Integer getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}
	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	/**
	 * @return the claveAcceso
	 */
	public String getClaveAcceso() {
		return claveAcceso;
	}
	/**
	 * @param claveAcceso the claveAcceso to set
	 */
	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}
	/**
	 * @return the ruc
	 */
	public String getRuc() {
		return ruc;
	}
	/**
	 * @param ruc the ruc to set
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the establecimiento
	 */
	public String getEstablecimiento() {
		if(establecimiento != null){
			establecimiento = addCeros(establecimiento, 3);
		}
		return establecimiento;
	}
	/**
	 * @param establecimiento the establecimiento to set
	 */
	public void setEstablecimiento(String establecimiento) {
		this.establecimiento = establecimiento;
	}
	/**
	 * @return the puntoEmision
	 */
	public String getPuntoEmision() {
		if(puntoEmision != null){
			puntoEmision = addCeros(puntoEmision, 3);
		}
		return puntoEmision;
	}
	/**
	 * @param puntoEmision the puntoEmision to set
	 */
	public void setPuntoEmision(String puntoEmision) {
		this.puntoEmision = puntoEmision;
	}
	/**
	 * @return the secuencial
	 */
	public String getSecuencial() {
		if(secuencial != null){
			secuencial = addCeros(secuencial, 9);
		}
		return secuencial;
	}
	/**
	 * @param secuencial the secuencial to set
	 */
	public void setSecuencial(String secuencial) {
		this.secuencial = secuencial;
	}
	/**
	 * @return the establecimientoDocRel
	 */
	public String getEstablecimientoDocRel() {
		if(establecimientoDocRel != null){
			establecimientoDocRel = addCeros(establecimientoDocRel, 3);
		}
		return establecimientoDocRel;
	}
	/**
	 * @param establecimientoDocRel the establecimientoDocRel to set
	 */
	public void setEstablecimientoDocRel(String establecimientoDocRel) {
		this.establecimientoDocRel = establecimientoDocRel;
	}
	/**
	 * @return the puntoEmisionDocRel
	 */
	public String getPuntoEmisionDocRel() {
		if(puntoEmisionDocRel != null){
			puntoEmisionDocRel = addCeros(puntoEmisionDocRel, 3);
		}
		return puntoEmisionDocRel;
	}
	/**
	 * @param puntoEmisionDocRel the puntoEmisionDocRel to set
	 */
	public void setPuntoEmisionDocRel(String puntoEmisionDocRel) {
		this.puntoEmisionDocRel = puntoEmisionDocRel;
	}
	/**
	 * @return the secuencialDocRel
	 */
	public String getSecuencialDocRel() {
		if(secuencialDocRel != null){
			secuencialDocRel = addCeros(secuencialDocRel, 9);
		}
		return secuencialDocRel;
	}
	/**
	 * @param secuencialDocRel the secuencialDocRel to set
	 */
	public void setSecuencialDocRel(String secuencialDocRel) {
		this.secuencialDocRel = secuencialDocRel;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the descuento
	 */
	public Double getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return the baseTarifaCero
	 */
	public Double getBaseTarifaCero() {
		return baseTarifaCero;
	}
	/**
	 * @param baseTarifaCero the baseTarifaCero to set
	 */
	public void setBaseTarifaCero(Double baseTarifaCero) {
		this.baseTarifaCero = baseTarifaCero;
	}
	/**
	 * @return the baseTarifaDoce
	 */
	public Double getBaseTarifaDoce() {
		return baseTarifaDoce;
	}
	/**
	 * @param baseTarifaDoce the baseTarifaDoce to set
	 */
	public void setBaseTarifaDoce(Double baseTarifaDoce) {
		this.baseTarifaDoce = baseTarifaDoce;
	}
	/**
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}
	/**
	 * @param iva the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}
	/**
	 * @return the valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}
	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	/**
	 * @return the numeroAutorizacionDocElec
	 */
	public String getNumeroAutorizacionDocElec() {
		return numeroAutorizacionDocElec;
	}
	/**
	 * @param numeroAutorizacionDocElec the numeroAutorizacionDocElec to set
	 */
	public void setNumeroAutorizacionDocElec(String numeroAutorizacionDocElec) {
		this.numeroAutorizacionDocElec = numeroAutorizacionDocElec;
	}
	/**
	 * @return the numeroFacturaDocElec
	 */
	public String getNumeroFacturaDocElec() {
		return numeroFacturaDocElec;
	}
	/**
	 * @param numeroFacturaDocElec the numeroFacturaDocElec to set
	 */
	public void setNumeroFacturaDocElec(String numeroFacturaDocElec) {
		this.numeroFacturaDocElec = numeroFacturaDocElec;
	}
	/**
	 * @return the rucDocElec
	 */
	public String getRucDocElec() {
		return rucDocElec;
	}
	/**
	 * @param rucDocElec the rucDocElec to set
	 */
	public void setRucDocElec(String rucDocElec) {
		this.rucDocElec = rucDocElec;
	}
	/**
	 * @return the telefonoDocElec
	 */
	public String getTelefonoDocElec() {
		return telefonoDocElec;
	}
	/**
	 * @param telefonoDocElec the telefonoDocElec to set
	 */
	public void setTelefonoDocElec(String telefonoDocElec) {
		this.telefonoDocElec = telefonoDocElec;
	}
	/**
	 * @return the establecimientoDocElec
	 */
	public String getEstablecimientoDocElec() {
		if(establecimientoDocElec != null){
			establecimientoDocElec = addCeros(establecimientoDocElec, 3);
		}
		return establecimientoDocElec;
	}
	/**
	 * @param establecimientoDocElec the establecimientoDocElec to set
	 */
	public void setEstablecimientoDocElec(String establecimientoDocElec) {
		this.establecimientoDocElec = establecimientoDocElec;
	}
	/**
	 * @return the puntoEmisionDocElec
	 */
	public String getPuntoEmisionDocElec() {
		if(puntoEmisionDocElec != null){
			puntoEmisionDocElec = addCeros(puntoEmisionDocElec, 3);
		}
		return puntoEmisionDocElec;
	}
	/**
	 * @param puntoEmisionDocElec the puntoEmisionDocElec to set
	 */
	public void setPuntoEmisionDocElec(String puntoEmisionDocElec) {
		this.puntoEmisionDocElec = puntoEmisionDocElec;
	}
	/**
	 * @return the secuencialDocElec
	 */
	public String getSecuencialDocElec() {
		if(secuencialDocElec != null){
			secuencialDocElec = addCeros(secuencialDocElec, 9);
		}
		return secuencialDocElec;
	}
	/**
	 * @param secuencialDocElec the secuencialDocElec to set
	 */
	public void setSecuencialDocElec(String secuencialDocElec) {
		this.secuencialDocElec = secuencialDocElec;
	}
	/**
	 * @return the observacionesDocElec
	 */
	public String getObservacionesDocElec() {
		return observacionesDocElec;
	}
	/**
	 * @param observacionesDocElec the observacionesDocElec to set
	 */
	public void setObservacionesDocElec(String observacionesDocElec) {
		this.observacionesDocElec = observacionesDocElec;
	}
	/**
	 * @return the descuentoDocElec
	 */
	public Double getDescuentoDocElec() {
		return descuentoDocElec;
	}
	/**
	 * @param descuentoDocElec the descuentoDocElec to set
	 */
	public void setDescuentoDocElec(Double descuentoDocElec) {
		this.descuentoDocElec = descuentoDocElec;
	}
	/**
	 * @return the baseTarifaCeroDocElec
	 */
	public Double getBaseTarifaCeroDocElec() {
		return baseTarifaCeroDocElec;
	}
	/**
	 * @param baseTarifaCeroDocElec the baseTarifaCeroDocElec to set
	 */
	public void setBaseTarifaCeroDocElec(Double baseTarifaCeroDocElec) {
		this.baseTarifaCeroDocElec = baseTarifaCeroDocElec;
	}
	/**
	 * @return the baseTarifaDoceDocElec
	 */
	public Double getBaseTarifaDoceDocElec() {
		return baseTarifaDoceDocElec;
	}
	/**
	 * @param baseTarifaDoceDocElec the baseTarifaDoceDocElec to set
	 */
	public void setBaseTarifaDoceDocElec(Double baseTarifaDoceDocElec) {
		this.baseTarifaDoceDocElec = baseTarifaDoceDocElec;
	}
	/**
	 * @return the ivaDocElec
	 */
	public Double getIvaDocElec() {
		return ivaDocElec;
	}
	/**
	 * @param ivaDocElec the ivaDocElec to set
	 */
	public void setIvaDocElec(Double ivaDocElec) {
		this.ivaDocElec = ivaDocElec;
	}
	/**
	 * @return the valorTotalDocElec
	 */
	public Double getValorTotalDocElec() {
		return valorTotalDocElec;
	}
	/**
	 * @param valorTotalDocElec the valorTotalDocElec to set
	 */
	public void setValorTotalDocElec(Double valorTotalDocElec) {
		this.valorTotalDocElec = valorTotalDocElec;
	}
	/**
	 * @return the razonSocialDocElec
	 */
	public String getRazonSocialDocElec() {
		return razonSocialDocElec;
	}
	/**
	 * @param razonSocialDocElec the razonSocialDocElec to set
	 */
	public void setRazonSocialDocElec(String razonSocialDocElec) {
		this.razonSocialDocElec = razonSocialDocElec;
	}
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public String getValorTipoDocumento() {
		return valorTipoDocumento;
	}
	public void setValorTipoDocumento(String valorTipoDocumento) {
		this.valorTipoDocumento = valorTipoDocumento;
	}
	public Boolean getRetener() {
		return retener;
	}
	public void setRetener(Boolean retener) {
		this.retener = retener;
	}
	/**
	 * @return the codigoCliente
	 */
	public String getCodigoCliente() {
		return codigoCliente;
	}
	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public Boolean getRetenerDocElec() {
		return retenerDocElec;
	}
	public void setRetenerDocElec(Boolean retenerDocElec) {
		this.retenerDocElec = retenerDocElec;
	}	
	public String getValorTipoDocumentoDocElec() {
		return valorTipoDocumentoDocElec;
	}
	public void setValorTipoDocumentoDocElec(String valorTipoDocumentoDocElec) {
		this.valorTipoDocumentoDocElec = valorTipoDocumentoDocElec;
	}
	public String getEtiquetaTipoDocumentoElec() {
		return etiquetaTipoDocumentoElec;
	}
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	public void setEtiquetaTipoDocumentoElec(String etiquetaTipoDocumentoElec) {
		this.etiquetaTipoDocumentoElec = etiquetaTipoDocumentoElec;
	}
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public Boolean getFacturaEnSitio() {
		return facturaEnSitio;
	}
	public void setFacturaEnSitio(Boolean facturaEnSitio) {
		this.facturaEnSitio = facturaEnSitio;
	}
	public ValidacionDocumentoDTO getValidacionDocumentoDTO() {
		return validacionDocumentoDTO;
	}
	public void setValidacionDocumentoDTO(ValidacionDocumentoDTO validacionDocumentoDTO) {
		this.validacionDocumentoDTO = validacionDocumentoDTO;
	}
	public Integer getValidarNumeroDocumento() {
		return validarNumeroDocumento;
	}
	public void setValidarNumeroDocumento(Integer validarNumeroDocumento) {
		this.validarNumeroDocumento = validarNumeroDocumento;
	}
	public String getNumeroFacturaDocRel() {
		return numeroFacturaDocRel;
	}
	public void setNumeroFacturaDocRel(String numeroFacturaDocRel) {
		this.numeroFacturaDocRel = numeroFacturaDocRel;
	}
	
	/**
	 * Permite concatenar ceros a la izquierda
	 */
	public String addCeros(String numero, Integer tamanio) {
		String valor="";
		Integer pendientes = tamanio - numero.length();
		for (int i=0; i<pendientes; i++){
			valor = valor+"0";
		}
		return valor+numero;
	}
	/**
	 * @return the valorTotalConImpuestos
	 */
	public Double getValorTotalConImpuestos() {
		return valorTotalConImpuestos;
	}
	/**
	 * @param valorTotalConImpuestos the valorTotalConImpuestos to set
	 */
	public void setValorTotalConImpuestos(Double valorTotalConImpuestos) {
		this.valorTotalConImpuestos = valorTotalConImpuestos;
	}
	/**
	 * @return the valorTotalConImpuestosDocElec
	 */
	public Double getValorTotalConImpuestosDocElec() {
		return valorTotalConImpuestosDocElec;
	}
	/**
	 * @param valorTotalConImpuestosDocElec the valorTotalConImpuestosDocElec to set
	 */
	public void setValorTotalConImpuestosDocElec(Double valorTotalConImpuestosDocElec) {
		this.valorTotalConImpuestosDocElec = valorTotalConImpuestosDocElec;
	}
	/**
	 * @return the nuevo
	 */
	public Boolean getNuevo() {
		return nuevo;
	}
	/**
	 * @param nuevo the nuevo to set
	 */
	public void setNuevo(Boolean nuevo) {
		this.nuevo = nuevo;
	}
	/**
	 * @return the estructuraValidacion
	 */
	public Map<String, Object> getEstructuraValidacion() {
		return estructuraValidacion;
	}
	/**
	 * @param estructuraValidacion the estructuraValidacion to set
	 */
	public void setEstructuraValidacion(Map<String, Object> estructuraValidacion) {
		this.estructuraValidacion = estructuraValidacion;
	}
	/**
	 * @return the estadoDocumentoElec
	 */
	public String getEstadoDocumentoElec() {
		return estadoDocumentoElec;
	}
	/**
	 * @param estadoDocumentoElec the estadoDocumentoElec to set
	 */
	public void setEstadoDocumentoElec(String estadoDocumentoElec) {
		this.estadoDocumentoElec = estadoDocumentoElec;
	}
	/**
	 * @return the codigoFacturaPadre
	 */
	public Long getCodigoFacturaPadre() {
		return codigoFacturaPadre;
	}
	/**
	 * @param codigoFacturaPadre the codigoFacturaPadre to set
	 */
	public void setCodigoFacturaPadre(Long codigoFacturaPadre) {
		this.codigoFacturaPadre = codigoFacturaPadre;
	}
	/**
	 * @return the baseTarifaIveDocElec
	 */
	public Double getBaseTarifaIveDocElec() {
		return baseTarifaIveDocElec;
	}
	/**
	 * @param baseTarifaIveDocElec the baseTarifaIveDocElec to set
	 */
	public void setBaseTarifaIveDocElec(Double baseTarifaIveDocElec) {
		this.baseTarifaIveDocElec = baseTarifaIveDocElec;
	}
	/**
	 * @return the iveDocElec
	 */
	public Double getIveDocElec() {
		return iveDocElec;
	}
	/**
	 * @param iveDocElec the iveDocElec to set
	 */
	public void setIveDocElec(Double iveDocElec) {
		this.iveDocElec = iveDocElec;
	}
	/**
	 * @return the etiquetaValorTipoDocumento
	 */
	public String getEtiquetaValorTipoDocumento() {
		return etiquetaValorTipoDocumento;
	}
	/**
	 * @param etiquetaValorTipoDocumento the etiquetaValorTipoDocumento to set
	 */
	public void setEtiquetaValorTipoDocumento(String etiquetaValorTipoDocumento) {
		this.etiquetaValorTipoDocumento = etiquetaValorTipoDocumento;
	}
	public Double getIve() {
		return ive;
	}
	public void setIve(Double ive) {
		this.ive = ive;
	}
	public Double getDescuentoTarifaCeroDocEle() {
		return descuentoTarifaCeroDocEle;
	}
	public void setDescuentoTarifaCeroDocEle(Double descuentoTarifaCeroDocEle) {
		this.descuentoTarifaCeroDocEle = descuentoTarifaCeroDocEle;
	}
	public Double getDescuentoTarifaDoceDocEle() {
		return descuentoTarifaDoceDocEle;
	}
	public void setDescuentoTarifaDoceDocEle(Double descuentoTarifaDoceDocEle) {
		this.descuentoTarifaDoceDocEle = descuentoTarifaDoceDocEle;
	}
	/**
	 * @return the comprobanteXml
	 */
	public String getComprobanteXml() {
		return comprobanteXml;
	}
	/**
	 * @param comprobanteXml the comprobanteXml to set
	 */
	public void setComprobanteXml(String comprobanteXml) {
		this.comprobanteXml = comprobanteXml;
	}
	/**
	 * @return the fechaDocumento
	 */
	public Date getFechaDocumento() {
		return fechaDocumento;
	}
	/**
	 * @param fechaDocumento the fechaDocumento to set
	 */
	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}
	/**
	 * @return the fechaDocumentoDocElec
	 */
	public Date getFechaDocumentoDocElec() {
		return fechaDocumentoDocElec;
	}
	/**
	 * @param fechaDocumentoDocElec the fechaDocumentoDocElec to set
	 */
	public void setFechaDocumentoDocElec(Date fechaDocumentoDocElec) {
		this.fechaDocumentoDocElec = fechaDocumentoDocElec;
	}
	/**
	 * @return the fechaCaducidadAutorizacion
	 */
	public Date getFechaCaducidadAutorizacion() {
		return fechaCaducidadAutorizacion;
	}
	/**
	 * @param fechaCaducidadAutorizacion the fechaCaducidadAutorizacion to set
	 */
	public void setFechaCaducidadAutorizacion(Date fechaCaducidadAutorizacion) {
		this.fechaCaducidadAutorizacion = fechaCaducidadAutorizacion;
	}
}