/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FacturaDetalleEstadoAdicionalID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACDETESTADI")
public class FacturaDetalleEstadoAdicionalDTO extends AuditoriaBaseDTO<FacturaDetalleEstadoAdicionalID>{
	@Column(name = "CODIGOFACTURA")
	private Long codigoFactura;
	
	@Column(name = "CODIGOFACTURAESTADO")
	private Long codigoFacturaEstado;
	
	@Column(name = "CODIGOFACTURADETALLEEST")
	private Long codigoFacturaDetalleEst;
	
	@Column(name = "NUMEROLINEA")
	private Integer numeroLinea;
	
	@Column(name = "CODIGOREFERENCIA")
	private String codigoReferencia;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "MATERIAL")
	private String material;
	
	@Column(name = "CANTIDAD")
	private Double cantidad;
	
	@Column(name = "PRECIO")
	private Double precio;
	
	@Column(name = "VALORTOTAL")
	private Double valorTotal;
	
	@Column(name = "PESONETOTOTAL")
	private Double pesoNetoTotal;
	
	@Column(name = "PESOBRUTOTOTAL")
	private Double pesoBrutoTotal;
	
	@Column(name = "CODIGOUNIDADCATVAL")
	private Long codigoUnidadCatVal;
	
	@Column(name = "CODIGOUNIDADCATTIP")
	private Long codigoUnidadCatTip;
	
	@ComparatorTypeField(comparatorType = ComparatorTypeEnum.EQUAL_COMPARATOR)
	@Column(name = "ESTADO")
	private String estado;
	
	@Column(name = "CODIGOBIECAPCATTIP")
	private Long codigoBienCapitalCatTip;
	
	@Column(name = "CODIGOBIECAPCATVAL")
	private Long codigoBienCapitalCatVal;
	
	@Column(name="VALORUNIDADMANEJO")
	private Integer valorUnidadManejo;
	
	@Column(name="COSTOMONEDAORIGEN")
	private Double costoMonedaOrigen;
	
	@Column(name="COSTOCOMISION")
	private Double costoComision;
	
	@Column(name="COSTOECUADOR")
	private Double costoEcuador;
	

	@Column(name="H37PRECIONETO")
	private Double h37PrecioNeto;
	
	@Column(name="H27PAGOSINDIRECTOS")
	private Double h27PagosIndirectos ;
	
	@Column(name="H28DESCUENTOSRETROACTIVOS")
	private Double h28DescuentosRetroactivos ;
	
	@Column(name="H29SEGURONACIONAL")
	private Double h29SeguroNacional ;
		
	@Column(name="H29DIFERENCIAFLETES")
	private Double h29DiferenciaFletes ;
	
	@Column(name="H29OTROSPAGOS")
	private Double h29OtrosPagos ;
	
	
	@Column(name="H24FLETEINTERNACIONAL")
	private Double h24FleteInternacional ;
		
	@Column(name="H24SEGUROINTERNACIONAL")
	private Double h24SeguroInternacional ;
	
	@Column(name="H24ADICIONESDEDUCCIONES")
	private Double h24AdicionesDeducciones ;
	
	@Column(name="H26FOBCANTIDAD")
	private Double h26fobCantidad ;
	
	@Column(name="H25FOBITEM")
	private Double h25FobItem ;
	
	@Column(name="H23GASTOSTRANSPORTEITEM")
	private Double h23GastosTransporteItem ;
	
	@Column(name="H30GASTOSSEGUROITEM")
	private Double h30GastosSeguroItem ;
	
	@Column(name="H31BASEIMPONIBLEITEM")
	private Double h31BaseImponibleItem ;
	
	@Column(name="H38PAGOTOTALOPORPAGAR")
	private Double h38PagoTotaloPorPagar ;
	
	@Transient
	private FactorDTO factor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAESTADO", referencedColumnName = "CODIGOFACTURAESTADO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURADETALLEEST", referencedColumnName = "CODIGOFACTURADETALLEEST", insertable = false, updatable = false)
	})
	private FacturaDetalleEstadoImpDTO facturaDetalleEstado;
	
	/**
	 * @return the factor
	 */
	public FactorDTO getFactor() {
		return factor;
	}

	/**
	 * @param factor the factor to set
	 */
	public void setFactor(FactorDTO factor) {
		this.factor = factor;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFactura
	 */
	public Long getCodigoFactura() {
		return codigoFactura;
	}

	/**
	 * @param codigoFactura establece el valor a la propiedad codigoFactura
	 */
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFacturaEstado
	 */
	public Long getCodigoFacturaEstado() {
		return codigoFacturaEstado;
	}

	/**
	 * @param codigoFacturaEstado establece el valor a la propiedad codigoFacturaEstado
	 */
	public void setCodigoFacturaEstado(Long codigoFacturaEstado) {
		this.codigoFacturaEstado = codigoFacturaEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoFacturaDetalleEst
	 */
	public Long getCodigoFacturaDetalleEst() {
		return codigoFacturaDetalleEst;
	}

	/**
	 * @param codigoFacturaDetalleEst establece el valor a la propiedad codigoFacturaDetalleEst
	 */
	public void setCodigoFacturaDetalleEst(Long codigoFacturaDetalleEst) {
		this.codigoFacturaDetalleEst = codigoFacturaDetalleEst;
	}

	/**
	 * @return devuelve el valor de la propiedad numeroLinea
	 */
	public Integer getNumeroLinea() {
		return numeroLinea;
	}

	/**
	 * @param numeroLinea establece el valor a la propiedad numeroLinea
	 */
	public void setNumeroLinea(Integer numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}

	/**
	 * @param codigoReferencia establece el valor a la propiedad codigoReferencia
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}

	/**
	 * @return devuelve el valor de la propiedad descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion establece el valor a la propiedad descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return devuelve el valor de la propiedad material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @param material establece el valor a la propiedad material
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * @return devuelve el valor de la propiedad cantidad
	 */
	public Double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad establece el valor a la propiedad cantidad
	 */
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return devuelve el valor de la propiedad precio
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio establece el valor a la propiedad precio
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * @return devuelve el valor de la propiedad valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal establece el valor a la propiedad valorTotal
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoNetoTotal
	 */
	public Double getPesoNetoTotal() {
		return pesoNetoTotal;
	}

	/**
	 * @param pesoNetoTotal establece el valor a la propiedad pesoNetoTotal
	 */
	public void setPesoNetoTotal(Double pesoNetoTotal) {
		this.pesoNetoTotal = pesoNetoTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad pesoBrutoTotal
	 */
	public Double getPesoBrutoTotal() {
		return pesoBrutoTotal;
	}

	/**
	 * @param pesoBrutoTotal establece el valor a la propiedad pesoBrutoTotal
	 */
	public void setPesoBrutoTotal(Double pesoBrutoTotal) {
		this.pesoBrutoTotal = pesoBrutoTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoUnidadCatVal
	 */
	public Long getCodigoUnidadCatVal() {
		return codigoUnidadCatVal;
	}

	/**
	 * @param codigoUnidadCatVal establece el valor a la propiedad codigoUnidadCatVal
	 */
	public void setCodigoUnidadCatVal(Long codigoUnidadCatVal) {
		this.codigoUnidadCatVal = codigoUnidadCatVal;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoUnidadCatTip
	 */
	public Long getCodigoUnidadCatTip() {
		return codigoUnidadCatTip;
	}

	/**
	 * @param codigoUnidadCatTip establece el valor a la propiedad codigoUnidadCatTip
	 */
	public void setCodigoUnidadCatTip(Long codigoUnidadCatTip) {
		this.codigoUnidadCatTip = codigoUnidadCatTip;
	}

	/**
	 * @return devuelve el valor de la propiedad estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado establece el valor a la propiedad estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return devuelve el valor de la propiedad facturaDetalleEstado
	 */
	public FacturaDetalleEstadoImpDTO getFacturaDetalleEstado() {
		return facturaDetalleEstado;
	}

	/**
	 * @param facturaDetalleEstado establece el valor a la propiedad facturaDetalleEstado
	 */
	public void setFacturaDetalleEstado(
			FacturaDetalleEstadoImpDTO facturaDetalleEstado) {
		this.facturaDetalleEstado = facturaDetalleEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad factor
	 */
	

	/**
	 * @param factor establece el valor a la propiedad factor
	 */
	

	/**
	 * @return the codigoBienCapitalCatTip
	 */
	public Long getCodigoBienCapitalCatTip() {
		return codigoBienCapitalCatTip;
	}

	/**
	 * @param codigoBienCapitalCatTip the codigoBienCapitalCatTip to set
	 */
	public void setCodigoBienCapitalCatTip(Long codigoBienCapitalCatTip) {
		this.codigoBienCapitalCatTip = codigoBienCapitalCatTip;
	}

	/**
	 * @return the codigoBienCapitalCatVal
	 */
	public Long getCodigoBienCapitalCatVal() {
		return codigoBienCapitalCatVal;
	}

	/**
	 * @param codigoBienCapitalCatVal the codigoBienCapitalCatVal to set
	 */
	public void setCodigoBienCapitalCatVal(Long codigoBienCapitalCatVal) {
		this.codigoBienCapitalCatVal = codigoBienCapitalCatVal;
	}

	public Integer getValorUnidadManejo() {
		return valorUnidadManejo;
	}

	public void setValorUnidadManejo(Integer valorUnidadManejo) {
		this.valorUnidadManejo = valorUnidadManejo;
	}

	/**
	 * @return the costoComision
	 */
	public Double getCostoComision() {
		return costoComision;
	}

	/**
	 * @param costoComision the costoComision to set
	 */
	public void setCostoComision(Double costoComision) {
		this.costoComision = costoComision;
	}

	/**
	 * @return the costoEcuador
	 */
	public Double getCostoEcuador() {
		return costoEcuador;
	}

	/**
	 * @param costoEcuador the costoEcuador to set
	 */
	public void setCostoEcuador(Double costoEcuador) {
		this.costoEcuador = costoEcuador;
	}
	
	public Double getH37PrecioNeto() {
		return h37PrecioNeto;
	}

	public void setH37PrecioNeto(Double h37PrecioNeto) {
		this.h37PrecioNeto = h37PrecioNeto;
	}

	public Double getH27PagosIndirectos() {
		return h27PagosIndirectos;
	}

	public void setH27PagosIndirectos(Double h27PagosIndirectos) {
		this.h27PagosIndirectos = h27PagosIndirectos;
	}

	public Double getH28DescuentosRetroactivos() {
		return h28DescuentosRetroactivos;
	}

	public void setH28DescuentosRetroactivos(Double h28DescuentosRetroactivos) {
		this.h28DescuentosRetroactivos = h28DescuentosRetroactivos;
	}

	public Double getH29OtrosPagos() {
		return h29OtrosPagos;
	}

	public void setH29OtrosPagos(Double h29OtrosPagos) {
		this.h29OtrosPagos = h29OtrosPagos;
	}

	public Double getH24AdicionesDeducciones() {
		return h24AdicionesDeducciones;
	}

	public void setH24AdicionesDeducciones(Double h24AdicionesDeducciones) {
		this.h24AdicionesDeducciones = h24AdicionesDeducciones;
	}

	public Double getH26fobCantidad() {
		return h26fobCantidad;
	}

	public void setH26fobCantidad(Double h26fobCantidad) {
		this.h26fobCantidad = h26fobCantidad;
	}

	public Double getH25FobItem() {
		return h25FobItem;
	}

	public void setH25FobItem(Double h25FobItem) {
		this.h25FobItem = h25FobItem;
	}

	public Double getH23GastosTransporteItem() {
		return h23GastosTransporteItem;
	}

	public void setH23GastosTransporteItem(Double h23GastosTransporteItem) {
		this.h23GastosTransporteItem = h23GastosTransporteItem;
	}

	public Double getH30GastosSeguroItem() {
		return h30GastosSeguroItem;
	}

	public void setH30GastosSeguroItem(Double h30GastosSeguroItem) {
		this.h30GastosSeguroItem = h30GastosSeguroItem;
	}

	public Double getH31BaseImponibleItem() {
		return h31BaseImponibleItem;
	}

	public void setH31BaseImponibleItem(Double h31BaseImponibleItem) {
		this.h31BaseImponibleItem = h31BaseImponibleItem;
	}

	public Double getH38PagoTotaloPorPagar() {
		return h38PagoTotaloPorPagar;
	}

	public void setH38PagoTotaloPorPagar(Double h38PagoTotaloPorPagar) {
		this.h38PagoTotaloPorPagar = h38PagoTotaloPorPagar;
	}

	public Double getH29SeguroNacional() {
		return h29SeguroNacional;
	}

	public void setH29SeguroNacional(Double h29SeguroNacional) {
		this.h29SeguroNacional = h29SeguroNacional;
	}

	public Double getH29DiferenciaFletes() {
		return h29DiferenciaFletes;
	}

	public void setH29DiferenciaFletes(Double h29DiferenciaFletes) {
		this.h29DiferenciaFletes = h29DiferenciaFletes;
	}

	public Double getH24FleteInternacional() {
		return h24FleteInternacional;
	}

	public void setH24FleteInternacional(Double h24FleteInternacional) {
		this.h24FleteInternacional = h24FleteInternacional;
	}

	public Double getH24SeguroInternacional() {
		return h24SeguroInternacional;
	}

	public void setH24SeguroInternacional(Double h24SeguroInternacional) {
		this.h24SeguroInternacional = h24SeguroInternacional;
	}
	
	public Double getCostoMonedaOrigen() {
		return costoMonedaOrigen;
	}

	public void setCostoMonedaOrigen(Double costoMonedaOrigen) {
		this.costoMonedaOrigen = costoMonedaOrigen;
	}
	
	

}