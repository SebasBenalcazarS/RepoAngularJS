/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionTypeInfo;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.corpv2.dto.DivisionGeoPoliticaDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FacturaDetalleEstadoImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFACDETEST")
public class FacturaDetalleEstadoImpDTO extends AuditoriaBaseDTO<FacturaDetalleEstadoImpID>{
	@Column(name = "CODIGOFACTURADETALLE")
	private Long codigoFacturaDetalle;
	
	@Column(name = "NUMEROLINEA")
	private Integer numeroLinea;
	
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
	
	@Column(name = "CODIGOARTPROARA")
	private Long codigoArtProAra;
	
	@Column(name = "CODIGOBIECAPCATTIP")
	private Long codigoBienCapitalCatTip;
	
	@Column(name = "CODIGOBIECAPCATVAL")
	private Long codigoBienCapitalCatVal;
	
	@Column(name = "ANIO")
	private Integer anio;
	
	@Column(name = "CODIGOPAISORIGEN")
	private String codigoPaisOrigen;
	
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
	

	@Column(name="ARANCELVALIDADO")
	private String arancelValidado;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURADETALLE", referencedColumnName = "CODIGOFACTURADETALLE", insertable = false, updatable = false)
	})
	private FacturaDetalleImpDTO facturaDetalle;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTURAESTADO", referencedColumnName = "CODIGOFACTURAESTADO", insertable = false, updatable = false)
	})
	private FacturaEstadoImpDTO facturaEstado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOUNIDADCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOUNIDADCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO unidad;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBIECAPCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOBIECAPCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO bienCapital;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOPAISORIGEN", referencedColumnName = "CODIGODIVGEOPOL", insertable = false, updatable = false)
	})
	private DivisionGeoPoliticaDTO paisOrigen;
	
	
	@OneToMany(mappedBy = "facturaDetalleEstado")
	@CollectionTypeInfo(name="ec.com.kruger.utilitario.dao.commons.hibernate.usertype.ListCollectionType")
	private Collection<FacturaDetalleEstadoAdicionalDTO> facturaDetallesEstadoAdicional;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTPROARA", referencedColumnName = "CODIGOARTPROARA", insertable = false, updatable = false)
	})
	private ArticuloProveedorArancelDTO articuloProveedorArancel; 
	
	@Transient
	private FactorDTO factor;
	
	/**
	 * @return the articuloProveedorArancel
	 */
	public ArticuloProveedorArancelDTO getArticuloProveedorArancel() {
		return articuloProveedorArancel;
	}

	/**
	 * @param articuloProveedorArancel the articuloProveedorArancel to set
	 */
	public void setArticuloProveedorArancel(ArticuloProveedorArancelDTO articuloProveedorArancel) {
		this.articuloProveedorArancel = articuloProveedorArancel;
	}

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
	 * @return devuelve el valor de la propiedad codigoArtProAra
	 */
	public Long getCodigoArtProAra() {
		return codigoArtProAra;
	}

	/**
	 * @param codigoArtProAra establece el valor a la propiedad codigoArtProAra
	 */
	public void setCodigoArtProAra(Long codigoArtProAra) {
		this.codigoArtProAra = codigoArtProAra;
	}

	/**
	 * @return devuelve el valor de la propiedad articuloProveedorArancel
	 */
	

	/**
	 * @param articuloProveedorArancel establece el valor a la propiedad articuloProveedorArancel
	 */
	

	/**
	 * @return devuelve el valor de la propiedad codigoFacturaDetalle
	 */
	public Long getCodigoFacturaDetalle() {
		return codigoFacturaDetalle;
	}

	/**
	 * @param codigoFacturaDetalle establece el valor a la propiedad codigoFacturaDetalle
	 */
	public void setCodigoFacturaDetalle(Long codigoFacturaDetalle) {
		this.codigoFacturaDetalle = codigoFacturaDetalle;
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
	 * @return devuelve el valorTotal pero con comas
	 */
	public String getValorTotalComa() {
		return valorTotal.toString().replace(".", ",");
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
	 * @return devuelve el pesoBrutoTotal pero con comas
	 */
	public String getPesoBrutoTotalComa() {
		return pesoBrutoTotal.toString().replace(".", ",");
	}

	/**
	 * @param pesoBrutoTotal establece el valor a la propiedad pesoBrutoTotal
	 */
	public void setPesoBrutoTotal(Double pesoBrutoTotal) {
		this.pesoBrutoTotal = pesoBrutoTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad facturaDetalle
	 */
	public FacturaDetalleImpDTO getFacturaDetalle() {
		return facturaDetalle;
	}

	/**
	 * @param facturaDetalle establece el valor a la propiedad facturaDetalle
	 */
	public void setFacturaDetalle(FacturaDetalleImpDTO facturaDetalle) {
		this.facturaDetalle = facturaDetalle;
	}

	/**
	 * @return devuelve el valor de la propiedad facturaEstado
	 */
	public FacturaEstadoImpDTO getFacturaEstado() {
		return facturaEstado;
	}

	/**
	 * @param facturaEstado establece el valor a la propiedad facturaEstado
	 */
	public void setFacturaEstado(FacturaEstadoImpDTO facturaEstado) {
		this.facturaEstado = facturaEstado;
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
	 * @return devuelve el valor de la propiedad unidad
	 */
	public CatalogoValorImpDTO getUnidad() {
		return unidad;
	}

	/**
	 * @param unidad establece el valor a la propiedad unidad
	 */
	public void setUnidad(CatalogoValorImpDTO unidad) {
		this.unidad = unidad;
	}

	public String getDescripcion(){
		if(this.facturaDetalle.getArticuloProveedor() != null && SearchDTO.isLoaded(this.facturaDetalle.getArticuloProveedor())){
			if(this.facturaDetalle.getArticuloProveedor().getArticuloImportacion() != null && SearchDTO.isLoaded(this.facturaDetalle.getArticuloProveedor().getArticuloImportacion())){
				return this.facturaDetalle.getArticuloProveedor().getArticuloImportacion().getDescripcionArticulo();
			}else if(this.facturaDetalle.getArticuloProveedor().getArticulo() != null && SearchDTO.isLoaded(this.facturaDetalle.getArticuloProveedor().getArticulo())){
				return this.facturaDetalle.getArticuloProveedor().getArticulo().getDescripcionArticulo();
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	
	/**
	 * @return devuelve el valor de la propiedad facturaDetallesEstadoAdicional
	 */
	public Collection<FacturaDetalleEstadoAdicionalDTO> getFacturaDetallesEstadoAdicional() {
		return facturaDetallesEstadoAdicional;
	}

	/**
	 * @param facturaDetallesEstadoAdicional establece el valor a la propiedad facturaDetallesEstadoAdicional
	 */
	public void setFacturaDetallesEstadoAdicional(
			Collection<FacturaDetalleEstadoAdicionalDTO> facturaDetallesEstadoAdicional) {
		this.facturaDetallesEstadoAdicional = facturaDetallesEstadoAdicional;
	}

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

	/**
	 * @return the bienCapital
	 */
	public CatalogoValorImpDTO getBienCapital() {
		return bienCapital;
	}

	/**
	 * @param bienCapital the bienCapital to set
	 */
	public void setBienCapital(CatalogoValorImpDTO bienCapital) {
		this.bienCapital = bienCapital;
	}

	/**
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	/**
	 * @return the paisOrigen
	 */
	public DivisionGeoPoliticaDTO getPaisOrigen() {
		return paisOrigen;
	}

	/**
	 * @param paisOrigen the paisOrigen to set
	 */
	public void setPaisOrigen(DivisionGeoPoliticaDTO paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	/**
	 * @return the codigoPaisOrigen
	 */
	public String getCodigoPaisOrigen() {
		return codigoPaisOrigen;
	}

	/**
	 * @param codigoPaisOrigen the codigoPaisOrigen to set
	 */
	public void setCodigoPaisOrigen(String codigoPaisOrigen) {
		this.codigoPaisOrigen = codigoPaisOrigen;
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
	
	/**
	 * @return the arancelValidado
	 */
	public String getArancelValidado() {
		return arancelValidado;
	}

	/**
	 * @param arancelValidado the arancelValidado to set
	 */
	public void setArancelValidado(String arancelValidado) {
		this.arancelValidado = arancelValidado;
	}

	
	
}
