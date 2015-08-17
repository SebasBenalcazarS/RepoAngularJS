package ec.com.smx.sic.cliente.mdl.dto;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloCaracteristicasMercanciaID;

/**
 * Vista para obtener los campos de la etiqueta de mercancia  mediante codigo de barras
 * @author aquingaluisa
 *
 */
@Entity
@SuppressWarnings("serial")
public class VistaArticuloCaracteristicasMercanciaDTO extends SearchDTO {
	
	@EmbeddedId
	private VistaArticuloCaracteristicasMercanciaID id;
	/**
	 * articulo
	 */
	private String codigoArticulo;
	private Integer codigoCompania;
	/**
	 * BitacoraCodigoBarras
	 */
	private String codigoBarras;
	private String descripcionArticulo;
	/**
	 * articulo comercial
	 */
	private String comercialValorTipoCosto;
	private Double comercialPesoAproximadoVenta;
	private Double comercialPorcentajeNoAfiliado;
	private Boolean comercialTienePrecioFijo;
	private Boolean comercialVentaPrecioAfiliado;
	/**
	 * Garantia
	 */
	private String garantiaEstadoExtensionGarantia;
	/**
	 * Marca
	 */
	private String nombreMarca;
	/**
	 * articulo proveedor
	 */
	private String codigoProveedor;
	private String codigoReferenciaProveedor;
	/**
	 * caracteristicas
	 */
	
	private BigDecimal caracteristicaSecuancialCaracteristica;
	private Integer caracteristicaCodigoTipoCaracteristica;
	private String caracteristicaDescripcionCaracteristica;
	private Integer caracteristicaOrden;
	/**
	 * Clasificacion
	 */
	private String clasificacionCodigoClasificacion;
	/**
	 * articuloLocal
	 */
	private Integer localCodigoLocal;
	/**
	 * articulo precio
	 */
	private String precioCodigoTipoPrecio;
	
	private Long precioCodigoUnidadManejo;
	
	private Double precioValorActual;
	
	private Double precioValorAnterior;
	/**
	 * Precio local
	 */
	private Integer precioLocalCodigoLocal;
	private String precioLocalcodigoTipoPrecio;
	private Double precioLocalValorActual;
	private Double precioLocalValorAnterior;
	/**
	 * UnidadManejo
	 */
	private Long unidadManejoCodigoUnidadManejo;
	private Integer unidadManejoValorUnidadManejo;
	/**
	 * UnidadManejoUso
	 */
	private String unidadManejoUsoValorTipoUso;
	private Long unidadManejoUsoCodigoUnidadManejo;
	private Integer unidadManejoUsoCodigoTipoUso;
	/**
	 * Descuento en Venta
	 */
	private String descuentoVentaCodigoTipoDescuento;
	private Double descuentoVentaPorcentajeDescuento;
	private Double valorDescuentoValorDestuento;
	/**
	 * Impuestos 
	 */
	private Integer impuestoCodigoTipoImpuesto;
	private Boolean impuestoEsParaVenta;
	/**
	 * TipoImpuesto
	 */
	private String tipoImpuestoGrupoImpuesto;
	private Double tipoImpuestoPorcentajeImpuesto;
	public VistaArticuloCaracteristicasMercanciaID getId() {
		return id;
	}
	public void setId(VistaArticuloCaracteristicasMercanciaID id) {
		this.id = id;
	}
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	public String getComercialValorTipoCosto() {
		return comercialValorTipoCosto;
	}
	public void setComercialValorTipoCosto(String comercialValorTipoCosto) {
		this.comercialValorTipoCosto = comercialValorTipoCosto;
	}
	public Double getComercialPesoAproximadoVenta() {
		return comercialPesoAproximadoVenta;
	}
	public void setComercialPesoAproximadoVenta(Double comercialPesoAproximadoVenta) {
		this.comercialPesoAproximadoVenta = comercialPesoAproximadoVenta;
	}
	public Double getComercialPorcentajeNoAfiliado() {
		return comercialPorcentajeNoAfiliado;
	}
	public void setComercialPorcentajeNoAfiliado(Double comercialPorcentajeNoAfiliado) {
		this.comercialPorcentajeNoAfiliado = comercialPorcentajeNoAfiliado;
	}
	public Boolean getComercialTienePrecioFijo() {
		return comercialTienePrecioFijo;
	}
	public void setComercialTienePrecioFijo(Boolean comercialTienePrecioFijo) {
		this.comercialTienePrecioFijo = comercialTienePrecioFijo;
	}
	public Boolean getComercialVentaPrecioAfiliado() {
		return comercialVentaPrecioAfiliado;
	}
	public void setComercialVentaPrecioAfiliado(Boolean comercialVentaPrecioAfiliado) {
		this.comercialVentaPrecioAfiliado = comercialVentaPrecioAfiliado;
	}
	public String getGarantiaEstadoExtensionGarantia() {
		return garantiaEstadoExtensionGarantia;
	}
	public void setGarantiaEstadoExtensionGarantia(String garantiaEstadoExtensionGarantia) {
		this.garantiaEstadoExtensionGarantia = garantiaEstadoExtensionGarantia;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String nombreMarca) {
		this.nombreMarca = nombreMarca;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public String getCodigoReferenciaProveedor() {
		return codigoReferenciaProveedor;
	}
	public void setCodigoReferenciaProveedor(String codigoReferenciaProveedor) {
		this.codigoReferenciaProveedor = codigoReferenciaProveedor;
	}
	public BigDecimal getCaracteristicaSecuancialCaracteristica() {
		return caracteristicaSecuancialCaracteristica;
	}
	public void setCaracteristicaSecuancialCaracteristica(BigDecimal caracteristicaSecuancialCaracteristica) {
		this.caracteristicaSecuancialCaracteristica = caracteristicaSecuancialCaracteristica;
	}
	public Integer getCaracteristicaCodigoTipoCaracteristica() {
		return caracteristicaCodigoTipoCaracteristica;
	}
	public void setCaracteristicaCodigoTipoCaracteristica(Integer caracteristicaCodigoTipoCaracteristica) {
		this.caracteristicaCodigoTipoCaracteristica = caracteristicaCodigoTipoCaracteristica;
	}
	public String getCaracteristicaDescripcionCaracteristica() {
		return caracteristicaDescripcionCaracteristica;
	}
	public void setCaracteristicaDescripcionCaracteristica(String caracteristicaDescripcionCaracteristica) {
		this.caracteristicaDescripcionCaracteristica = caracteristicaDescripcionCaracteristica;
	}
	public Integer getCaracteristicaOrden() {
		return caracteristicaOrden;
	}
	public void setCaracteristicaOrden(Integer caracteristicaOrden) {
		this.caracteristicaOrden = caracteristicaOrden;
	}
	public String getClasificacionCodigoClasificacion() {
		return clasificacionCodigoClasificacion;
	}
	public void setClasificacionCodigoClasificacion(String clasificacionCodigoClasificacion) {
		this.clasificacionCodigoClasificacion = clasificacionCodigoClasificacion;
	}
	public Integer getLocalCodigoLocal() {
		return localCodigoLocal;
	}
	public void setLocalCodigoLocal(Integer localCodigoLocal) {
		this.localCodigoLocal = localCodigoLocal;
	}
	public String getPrecioCodigoTipoPrecio() {
		return precioCodigoTipoPrecio;
	}
	public void setPrecioCodigoTipoPrecio(String precioCodigoTipoPrecio) {
		this.precioCodigoTipoPrecio = precioCodigoTipoPrecio;
	}
	public Long getPrecioCodigoUnidadManejo() {
		return precioCodigoUnidadManejo;
	}
	public void setPrecioCodigoUnidadManejo(Long precioCodigoUnidadManejo) {
		this.precioCodigoUnidadManejo = precioCodigoUnidadManejo;
	}
	public Double getPrecioValorActual() {
		return precioValorActual;
	}
	public void setPrecioValorActual(Double precioValorActual) {
		this.precioValorActual = precioValorActual;
	}
	public Double getPrecioValorAnterior() {
		return precioValorAnterior;
	}
	public void setPrecioValorAnterior(Double precioValorAnterior) {
		this.precioValorAnterior = precioValorAnterior;
	}
	public Integer getPrecioLocalCodigoLocal() {
		return precioLocalCodigoLocal;
	}
	public void setPrecioLocalCodigoLocal(Integer precioLocalCodigoLocal) {
		this.precioLocalCodigoLocal = precioLocalCodigoLocal;
	}
	public String getPrecioLocalcodigoTipoPrecio() {
		return precioLocalcodigoTipoPrecio;
	}
	public Double getPrecioLocalValorActual() {
		return precioLocalValorActual;
	}
	public void setPrecioLocalValorActual(Double precioLocalValorActual) {
		this.precioLocalValorActual = precioLocalValorActual;
	}
	public Double getPrecioLocalValorAnterior() {
		return precioLocalValorAnterior;
	}
	public void setPrecioLocalValorAnterior(Double precioLocalValorAnterior) {
		this.precioLocalValorAnterior = precioLocalValorAnterior;
	}
	public void setPrecioLocalcodigoTipoPrecio(String precioLocalcodigoTipoPrecio) {
		this.precioLocalcodigoTipoPrecio = precioLocalcodigoTipoPrecio;
	}
	public Long getUnidadManejoCodigoUnidadManejo() {
		return unidadManejoCodigoUnidadManejo;
	}
	public void setUnidadManejoCodigoUnidadManejo(Long unidadManejoCodigoUnidadManejo) {
		this.unidadManejoCodigoUnidadManejo = unidadManejoCodigoUnidadManejo;
	}
	public Integer getUnidadManejoValorUnidadManejo() {
		return unidadManejoValorUnidadManejo;
	}
	public void setUnidadManejoValorUnidadManejo(Integer unidadManejoValorUnidadManejo) {
		this.unidadManejoValorUnidadManejo = unidadManejoValorUnidadManejo;
	}
	public String getUnidadManejoUsoValorTipoUso() {
		return unidadManejoUsoValorTipoUso;
	}
	public void setUnidadManejoUsoValorTipoUso(String unidadManejoUsoValorTipoUso) {
		this.unidadManejoUsoValorTipoUso = unidadManejoUsoValorTipoUso;
	}
	public Long getUnidadManejoUsoCodigoUnidadManejo() {
		return unidadManejoUsoCodigoUnidadManejo;
	}
	public void setUnidadManejoUsoCodigoUnidadManejo(Long unidadManejoUsoCodigoUnidadManejo) {
		this.unidadManejoUsoCodigoUnidadManejo = unidadManejoUsoCodigoUnidadManejo;
	}
	public Integer getUnidadManejoUsoCodigoTipoUso() {
		return unidadManejoUsoCodigoTipoUso;
	}
	public void setUnidadManejoUsoCodigoTipoUso(Integer unidadManejoUsoCodigoTipoUso) {
		this.unidadManejoUsoCodigoTipoUso = unidadManejoUsoCodigoTipoUso;
	}
	public String getDescuentoVentaCodigoTipoDescuento() {
		return descuentoVentaCodigoTipoDescuento;
	}
	public void setDescuentoVentaCodigoTipoDescuento(String descuentoVentaCodigoTipoDescuento) {
		this.descuentoVentaCodigoTipoDescuento = descuentoVentaCodigoTipoDescuento;
	}
	public Double getDescuentoVentaPorcentajeDescuento() {
		return descuentoVentaPorcentajeDescuento;
	}
	public void setDescuentoVentaPorcentajeDescuento(Double descuentoVentaPorcentajeDescuento) {
		this.descuentoVentaPorcentajeDescuento = descuentoVentaPorcentajeDescuento;
	}
	public Double getValorDescuentoValorDestuento() {
		return valorDescuentoValorDestuento;
	}
	public void setValorDescuentoValorDestuento(Double valorDescuentoValorDestuento) {
		this.valorDescuentoValorDestuento = valorDescuentoValorDestuento;
	}
	public Integer getImpuestoCodigoTipoImpuesto() {
		return impuestoCodigoTipoImpuesto;
	}
	public void setImpuestoCodigoTipoImpuesto(Integer impuestoCodigoTipoImpuesto) {
		this.impuestoCodigoTipoImpuesto = impuestoCodigoTipoImpuesto;
	}
	public Boolean getImpuestoEsParaVenta() {
		return impuestoEsParaVenta;
	}
	public void setImpuestoEsParaVenta(Boolean impuestoEsParaVenta) {
		this.impuestoEsParaVenta = impuestoEsParaVenta;
	}
	public String getTipoImpuestoGrupoImpuesto() {
		return tipoImpuestoGrupoImpuesto;
	}
	public void setTipoImpuestoGrupoImpuesto(String tipoImpuestoGrupoImpuesto) {
		this.tipoImpuestoGrupoImpuesto = tipoImpuestoGrupoImpuesto;
	}
	public Double getTipoImpuestoPorcentajeImpuesto() {
		return tipoImpuestoPorcentajeImpuesto;
	}
	public void setTipoImpuestoPorcentajeImpuesto(Double tipoImpuestoPorcentajeImpuesto) {
		this.tipoImpuestoPorcentajeImpuesto = tipoImpuestoPorcentajeImpuesto;
	}
}
