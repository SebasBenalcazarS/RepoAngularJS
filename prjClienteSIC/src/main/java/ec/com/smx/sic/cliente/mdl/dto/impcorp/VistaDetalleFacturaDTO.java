package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.VistaDetalleFacturaID;


/**
 * 
 * @author rhidalgo
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMVDETFAC")
public class VistaDetalleFacturaDTO extends SimpleAuditDTO {
	
	@EmbeddedId
	private VistaDetalleFacturaID id = new VistaDetalleFacturaID();
	
	
	
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
	
	@Column(name = "CODIGOARTPROARA")
	private Long codigoArtProAra;
	
	@Column(name = "NUMEROPARTIDA")
	private String numeroPartida;
	
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
	
		
	
	
	
	@ManyToOne(fetch = FetchType.LAZY  )
	@JoinColumns({
		@JoinColumn(name="CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name="CODIGOFACTURA", referencedColumnName = "CODIGOFACTURA", insertable = false, updatable = false),				
		@JoinColumn(name="CODIGOEMBARQUE", referencedColumnName = "CODIGOEMBARQUE",  insertable = false, updatable = false),
		@JoinColumn(name="CODIGOEMBARQUEESTADO", referencedColumnName = "CODIGOEMBARQUEESTADO",  insertable = false, updatable = false)		
	})
	private VistaEmbarqueFacturasDTO embarqueFacturas;





	public VistaDetalleFacturaID getId() {
		return id;
	}





	public void setId(VistaDetalleFacturaID id) {
		this.id = id;
	}





	public Integer getNumeroLinea() {
		return numeroLinea;
	}





	public void setNumeroLinea(Integer numeroLinea) {
		this.numeroLinea = numeroLinea;
	}





	public Double getCantidad() {
		return cantidad;
	}





	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}





	public Double getPrecio() {
		return precio;
	}





	public void setPrecio(Double precio) {
		this.precio = precio;
	}





	public Double getValorTotal() {
		return valorTotal;
	}





	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}





	public Double getPesoNetoTotal() {
		return pesoNetoTotal;
	}





	public void setPesoNetoTotal(Double pesoNetoTotal) {
		this.pesoNetoTotal = pesoNetoTotal;
	}





	public Double getPesoBrutoTotal() {
		return pesoBrutoTotal;
	}





	public void setPesoBrutoTotal(Double pesoBrutoTotal) {
		this.pesoBrutoTotal = pesoBrutoTotal;
	}





	public Long getCodigoArtProAra() {
		return codigoArtProAra;
	}





	public void setCodigoArtProAra(Long codigoArtProAra) {
		this.codigoArtProAra = codigoArtProAra;
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





	public Double getH29OtrosPagos() {
		return h29OtrosPagos;
	}





	public void setH29OtrosPagos(Double h29OtrosPagos) {
		this.h29OtrosPagos = h29OtrosPagos;
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





	public VistaEmbarqueFacturasDTO getEmbarqueFacturas() {
		return embarqueFacturas;
	}





	public void setEmbarqueFacturas(VistaEmbarqueFacturasDTO embarqueFacturas) {
		this.embarqueFacturas = embarqueFacturas;
	}





	public String getNumeroPartida() {
		return numeroPartida;
	}





	public void setNumeroPartida(String numeroPartida) {
		this.numeroPartida = numeroPartida;
	}
	
	


	
}
