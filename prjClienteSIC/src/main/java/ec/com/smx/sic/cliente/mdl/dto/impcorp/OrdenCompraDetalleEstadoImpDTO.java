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

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.OrdenCompraDetalleEstadoImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTORDCOMDETEST")
public class OrdenCompraDetalleEstadoImpDTO extends AuditoriaBaseDTO<OrdenCompraDetalleEstadoImpID>{
	@Column(name = "CODIGOORDENCOMPRADETALLE")
	private Long codigoOrdenCompraDetalle;
	
	@Column(name = "NUMEROLINEA")
	private Integer numeroLinea;
	
	@Column(name = "CANTIDAD")
	private Double cantidad;
	
	@Column(name = "PRECIO")
	private Double precio;
	
	@Column(name = "VALORTOTAL")
	private Double valorTotal;
	
	@Column(name = "VALORDESCUENTO")
	private Double valorDescuento;
	
	@Column(name = "PESOBRUTOTOTAL")
	private Double pesoBrutoTotal;
	
	@Column(name = "PESONETOTOTAL")
	private Double pesoNetoTotal;
	
	@Column(name = "CANTIDADCAJAS")
	private Integer cantidadCajas;
	
	@Column(name = "CODIGOUNIDADCATTIP")
	private Long codigoUnidadCatTip;
	
	@Column(name = "CODIGOUNIDADCATVAL")
	private Long codigoUnidadCatVal;
	
	@Column(name = "UNIDADMANEJO")
	private Integer unidadManejo;
	
	@Column(name = "CODIGOARTPROARA")
	private Long codigoArtProAra;
	
	@Column(name="ARANCELVALIDADO")	
	private String arancelValidado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOARTPROARA", referencedColumnName = "CODIGOARTPROARA", insertable = false, updatable = false)
	})
	private ArticuloProveedorArancelDTO articuloProveedorArancel;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRAESTADO", referencedColumnName = "CODIGOORDENCOMPRAESTADO", insertable = false, updatable = false)
	})
	private OrdenCompraEstadoImpDTO ordenCompraEstado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRA", referencedColumnName = "CODIGOORDENCOMPRA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOORDENCOMPRADETALLE", referencedColumnName = "CODIGOORDENCOMPRADETALLE", insertable = false, updatable = false)
	})
	private OrdenCompraDetalleImpDTO ordenCompraDetalle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOUNIDADCATTIP", referencedColumnName = "CODIGOCATALOGOTIPO", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOUNIDADCATVAL", referencedColumnName = "CODIGOCATALOGOVALOR", insertable = false, updatable = false)
	})
	private CatalogoValorImpDTO unidad;

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
	public ArticuloProveedorArancelDTO getArticuloProveedorArancel() {
		return articuloProveedorArancel;
	}

	/**
	 * @param articuloProveedorArancel establece el valor a la propiedad articuloProveedorArancel
	 */
	public void setArticuloProveedorArancel(
			ArticuloProveedorArancelDTO articuloProveedorArancel) {
		this.articuloProveedorArancel = articuloProveedorArancel;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoOrdenCompraDetalle
	 */
	public Long getCodigoOrdenCompraDetalle() {
		return codigoOrdenCompraDetalle;
	}

	/**
	 * @param codigoOrdenCompraDetalle establece el valor a la propiedad codigoOrdenCompraDetalle
	 */
	public void setCodigoOrdenCompraDetalle(Long codigoOrdenCompraDetalle) {
		this.codigoOrdenCompraDetalle = codigoOrdenCompraDetalle;
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

    public Double getCantidad() {
		return cantidad;
	} 
	 
	
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
	 * @return devuelve el valor de la propiedad valorDescuento
	 */
	public Double getValorDescuento() {
		return valorDescuento;
	}

	/**
	 * @param valorDescuento establece el valor a la propiedad valorDescuento
	 */
	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
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
	 * @return devuelve el valor de la propiedad ordenCompraEstado
	 */
	public OrdenCompraEstadoImpDTO getOrdenCompraEstado() {
		return ordenCompraEstado;
	}

	/**
	 * @param ordenCompraEstado establece el valor a la propiedad ordenCompraEstado
	 */
	public void setOrdenCompraEstado(OrdenCompraEstadoImpDTO ordenCompraEstado) {
		this.ordenCompraEstado = ordenCompraEstado;
	}

	/**
	 * @return devuelve el valor de la propiedad ordenCompraDetalle
	 */
	public OrdenCompraDetalleImpDTO getOrdenCompraDetalle() {
		return ordenCompraDetalle;
	}

	/**
	 * @param ordenCompraDetalle establece el valor a la propiedad ordenCompraDetalle
	 */
	public void setOrdenCompraDetalle(OrdenCompraDetalleImpDTO ordenCompraDetalle) {
		this.ordenCompraDetalle = ordenCompraDetalle;
	}

	/**
	 * @return devuelve el valor de la propiedad cantidadCajas
	 */
	public Integer getCantidadCajas() {
		return cantidadCajas;
	}

	/**
	 * @param cantidadCajas establece el valor a la propiedad cantidadCajas
	 */
	public void setCantidadCajas(Integer cantidadCajas) {
		this.cantidadCajas = cantidadCajas;
	}

	/**
	 * @return devuelve el valor de la propiedad unidadManejo
	 */
	public Integer getUnidadManejo() {
		return unidadManejo;
	}

	/**
	 * @param unidadManejo establece el valor a la propiedad unidadManejo
	 */
	public void setUnidadManejo(Integer unidadManejo) {
		this.unidadManejo = unidadManejo;
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
