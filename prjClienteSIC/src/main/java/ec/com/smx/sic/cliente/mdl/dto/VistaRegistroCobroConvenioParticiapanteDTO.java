package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Vista para cargar los datos para la integracion con el SIF
 * @author aquingaluisa 
 */
@Entity
@SuppressWarnings("serial")
public class VistaRegistroCobroConvenioParticiapanteDTO implements Serializable{
	@Id
	private Integer id;
	private Integer codigoCompania;
	private Integer codigoCampania;
	private String refenciaCampania;
	private String nombreCampania;
	private Integer codigoPromocion;
	private String referenciaPromocion;
	private String nombrePromocion;
	private Date fechaCobro;
	private Long codigoPlanFechaRegistroCobro;
	private Long codigoNegociacion;
	private Long codigoDetalleNegociacion;
	private Long codigoNegGesPreCoPar;
	private String codigoProveedor;
	private Long codigoPersona;
	private Long codigoLocalizacion;
	private String codigoValorFormaVenta;
	private Integer codigoTipoFormaVenta;
	private String codigoValorCentroCosto;
	private Integer codigoTipoCentroCosto;
	private Long centroCosto;
	private Double valorACobrar;
	private Integer codigoTipoImpuesto;
	private Double porcentajeIva;
	private Long codigoRegistroCobro;
	//Bandera que  servira para discriniar si el registro cobro esta integerado con SIF
	private String valorError;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Integer getCodigoCampania() {
		return codigoCampania;
	}
	public void setCodigoCampania(Integer codigoCampania) {
		this.codigoCampania = codigoCampania;
	}
	public String getRefenciaCampania() {
		return refenciaCampania;
	}
	public void setRefenciaCampania(String refenciaCampania) {
		this.refenciaCampania = refenciaCampania;
	}
	public String getNombreCampania() {
		return nombreCampania;
	}
	public void setNombreCampania(String nombreCampania) {
		this.nombreCampania = nombreCampania;
	}
	public Integer getCodigoPromocion() {
		return codigoPromocion;
	}
	public void setCodigoPromocion(Integer codigoPromocion) {
		this.codigoPromocion = codigoPromocion;
	}
	public String getReferenciaPromocion() {
		return referenciaPromocion;
	}
	public void setReferenciaPromocion(String referenciaPromocion) {
		this.referenciaPromocion = referenciaPromocion;
	}
	public String getNombrePromocion() {
		return nombrePromocion;
	}
	public void setNombrePromocion(String nombrePromocion) {
		this.nombrePromocion = nombrePromocion;
	}
	public Date getFechaCobro() {
		return fechaCobro;
	}
	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}
	public Long getCodigoPlanFechaRegistroCobro() {
		return codigoPlanFechaRegistroCobro;
	}
	public void setCodigoPlanFechaRegistroCobro(Long codigoPlanFechaRegistroCobro) {
		this.codigoPlanFechaRegistroCobro = codigoPlanFechaRegistroCobro;
	}
	public Long getCodigoNegociacion() {
		return codigoNegociacion;
	}
	public void setCodigoNegociacion(Long codigoNegociacion) {
		this.codigoNegociacion = codigoNegociacion;
	}
	public Long getCodigoDetalleNegociacion() {
		return codigoDetalleNegociacion;
	}
	public void setCodigoDetalleNegociacion(Long codigoDetalleNegociacion) {
		this.codigoDetalleNegociacion = codigoDetalleNegociacion;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public Long getCodigoPersona() {
		return codigoPersona;
	}
	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	public Long getCodigoLocalizacion() {
		return codigoLocalizacion;
	}
	public void setCodigoLocalizacion(Long codigoLocalizacion) {
		this.codigoLocalizacion = codigoLocalizacion;
	}
	public String getCodigoValorFormaVenta() {
		return codigoValorFormaVenta;
	}
	public void setCodigoValorFormaVenta(String codigoValorFormaVenta) {
		this.codigoValorFormaVenta = codigoValorFormaVenta;
	}
	public Integer getCodigoTipoFormaVenta() {
		return codigoTipoFormaVenta;
	}
	public void setCodigoTipoFormaVenta(Integer codigoTipoFormaVenta) {
		this.codigoTipoFormaVenta = codigoTipoFormaVenta;
	}
	public String getCodigoValorCentroCosto() {
		return codigoValorCentroCosto;
	}
	public void setCodigoValorCentroCosto(String codigoValorCentroCosto) {
		this.codigoValorCentroCosto = codigoValorCentroCosto;
	}
	public Integer getCodigoTipoCentroCosto() {
		return codigoTipoCentroCosto;
	}
	public void setCodigoTipoCentroCosto(Integer codigoTipoCentroCosto) {
		this.codigoTipoCentroCosto = codigoTipoCentroCosto;
	}
	public Double getValorACobrar() {
		return valorACobrar;
	}
	public void setValorACobrar(Double valorACobrar) {
		this.valorACobrar = valorACobrar;
	}
	public Integer getCodigoTipoImpuesto() {
		return codigoTipoImpuesto;
	}
	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto) {
		this.codigoTipoImpuesto = codigoTipoImpuesto;
	}
	public Double getPorcentajeIva() {
		return porcentajeIva;
	}
	public void setPorcentajeIva(Double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}
	public Long getCodigoRegistroCobro() {
		return codigoRegistroCobro;
	}
	public void setCodigoRegistroCobro(Long codigoRegistroCobro) {
		this.codigoRegistroCobro = codigoRegistroCobro;
	}
	public String getValorError() {
		return valorError;
	}
	public void setValorError(String valorError) {
		this.valorError = valorError;
	}
	public Long getCodigoNegGesPreCoPar() {
		return codigoNegGesPreCoPar;
	}
	public void setCodigoNegGesPreCoPar(Long codigoNegGesPreCoPar) {
		this.codigoNegGesPreCoPar = codigoNegGesPreCoPar;
	}
	public Long getCentroCosto() {
		return centroCosto;
	}
	public void setCentroCosto(Long centroCosto) {
		this.centroCosto = centroCosto;
	}
	
}
