package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;


@SuppressWarnings("serial")
public class ArticuloRelacionTransient extends SimpleAuditDTO {

	private Collection<ArticuloDTO> npArticuloCol;
	private Double npValorTotalIVA;
	private String npOrderBy;
	private String npNuevo;
	private Long npCantidadMaximaProducir;
	private String npErrorCantidadAProducir;
	private String npEstadoRecetaEspecial;
	private String npSecuencialEstadoPedido; 
	private String npCodigoTipoDescuento;
	private Long npCantidadTotalConsolidada;
	private Double npValorTotalConsolidado;
	private Boolean npVerificarSIC =Boolean.TRUE;
	private Integer cantidadMinimaMayoreo;
	private Long cantidadPrevioEstadoDescuento;	  
	private Double valorPrevioEstadoDescuento;
	private Double valorTotalEstadoDescuento;
	private Double valorTotalEstado;
	private Double valorTotalEstadoIVA;
	private Double valorTotalEstadoNeto;
	private Double valorTotalEstadoNetoIVA;
	private Collection npArticulos;

	//Indicar si el item de la receta tiene o no descuento
	private Double npValorPrevioEstadoDescuento;
	
	//precios reales de mayorista y de cajas
	private Double precioMayorista;
	private Double precioMayoristaIva;
	
	
	private Double precioCaja;
	private Double precioCajaIva;
	

	//precio unitario con el que se cotizo el item de la receta
	private Double precioUnitario;
	private Double precioUnitarioIva;
	
	//NPs SISPE
	private String npAplicaPrecioCaja;
	private String npAplicaPrecioMayorista;
	private String npCalcularBonos;

	public Collection<ArticuloDTO> getNpArticuloCol() {
		return npArticuloCol;
	}

	public void setNpArticuloCol(Collection<ArticuloDTO> npArticuloCol) {
		this.npArticuloCol = npArticuloCol;
	}

	public Double getNpValorTotalIVA() {
		return npValorTotalIVA;
	}

	public void setNpValorTotalIVA(Double npValorTotalIVA) {
		this.npValorTotalIVA = npValorTotalIVA;
	}

	public String getNpOrderBy() {
		return npOrderBy;
	}

	public void setNpOrderBy(String npOrderBy) {
		this.npOrderBy = npOrderBy;
	}

	public String getNpNuevo() {
		return npNuevo;
	}

	public void setNpNuevo(String npNuevo) {
		this.npNuevo = npNuevo;
	}

	public Long getNpCantidadMaximaProducir() {
		return npCantidadMaximaProducir;
	}

	public void setNpCantidadMaximaProducir(Long npCantidadMaximaProducir) {
		this.npCantidadMaximaProducir = npCantidadMaximaProducir;
	}

	public String getNpErrorCantidadAProducir() {
		return npErrorCantidadAProducir;
	}

	public void setNpErrorCantidadAProducir(String npErrorCantidadAProducir) {
		this.npErrorCantidadAProducir = npErrorCantidadAProducir;
	}

	public String getNpEstadoRecetaEspecial() {
		return npEstadoRecetaEspecial;
	}

	public void setNpEstadoRecetaEspecial(String npEstadoRecetaEspecial) {
		this.npEstadoRecetaEspecial = npEstadoRecetaEspecial;
	}

	public String getNpSecuencialEstadoPedido() {
		return npSecuencialEstadoPedido;
	}

	public void setNpSecuencialEstadoPedido(String npSecuencialEstadoPedido) {
		this.npSecuencialEstadoPedido = npSecuencialEstadoPedido;
	}

	public String getNpCodigoTipoDescuento() {
		return npCodigoTipoDescuento;
	}

	public void setNpCodigoTipoDescuento(String npCodigoTipoDescuento) {
		this.npCodigoTipoDescuento = npCodigoTipoDescuento;
	}

	public Long getNpCantidadTotalConsolidada() {
		return npCantidadTotalConsolidada;
	}

	public void setNpCantidadTotalConsolidada(Long npCantidadTotalConsolidada) {
		this.npCantidadTotalConsolidada = npCantidadTotalConsolidada;
	}

	public Double getNpValorTotalConsolidado() {
		return npValorTotalConsolidado;
	}

	public void setNpValorTotalConsolidado(Double npValorTotalConsolidado) {
		this.npValorTotalConsolidado = npValorTotalConsolidado;
	}

	public Boolean getNpVerificarSIC() {
		return npVerificarSIC;
	}

	public void setNpVerificarSIC(Boolean npVerificarSIC) {
		this.npVerificarSIC = npVerificarSIC;
	}

	public Integer getCantidadMinimaMayoreo() {
		return cantidadMinimaMayoreo;
	}

	public void setCantidadMinimaMayoreo(Integer cantidadMinimaMayoreo) {
		this.cantidadMinimaMayoreo = cantidadMinimaMayoreo;
	}

	public Long getCantidadPrevioEstadoDescuento() {
		return cantidadPrevioEstadoDescuento;
	}

	public void setCantidadPrevioEstadoDescuento(Long cantidadPrevioEstadoDescuento) {
		this.cantidadPrevioEstadoDescuento = cantidadPrevioEstadoDescuento;
	}

	public Double getValorPrevioEstadoDescuento() {
		return valorPrevioEstadoDescuento;
	}

	public void setValorPrevioEstadoDescuento(Double valorPrevioEstadoDescuento) {
		this.valorPrevioEstadoDescuento = valorPrevioEstadoDescuento;
	}

	public Double getValorTotalEstadoDescuento() {
		return valorTotalEstadoDescuento;
	}

	public void setValorTotalEstadoDescuento(Double valorTotalEstadoDescuento) {
		this.valorTotalEstadoDescuento = valorTotalEstadoDescuento;
	}

	public Double getValorTotalEstado() {
		return valorTotalEstado;
	}

	public void setValorTotalEstado(Double valorTotalEstado) {
		this.valorTotalEstado = valorTotalEstado;
	}

	public Double getValorTotalEstadoIVA() {
		return valorTotalEstadoIVA;
	}

	public void setValorTotalEstadoIVA(Double valorTotalEstadoIVA) {
		this.valorTotalEstadoIVA = valorTotalEstadoIVA;
	}

	public Double getValorTotalEstadoNeto() {
		return valorTotalEstadoNeto;
	}

	public void setValorTotalEstadoNeto(Double valorTotalEstadoNeto) {
		this.valorTotalEstadoNeto = valorTotalEstadoNeto;
	}

	public Double getValorTotalEstadoNetoIVA() {
		return valorTotalEstadoNetoIVA;
	}

	public void setValorTotalEstadoNetoIVA(Double valorTotalEstadoNetoIVA) {
		this.valorTotalEstadoNetoIVA = valorTotalEstadoNetoIVA;
	}

	public Collection getNpArticulos() {
		return npArticulos;
	}

	public void setNpArticulos(Collection npArticulos) {
		this.npArticulos = npArticulos;
	}

	public Double getNpValorPrevioEstadoDescuento() {
		return npValorPrevioEstadoDescuento;
	}

	public void setNpValorPrevioEstadoDescuento(Double npValorPrevioEstadoDescuento) {
		this.npValorPrevioEstadoDescuento = npValorPrevioEstadoDescuento;
	}

	public Double getPrecioMayorista() {
		return precioMayorista;
	}

	public void setPrecioMayorista(Double precioMayorista) {
		this.precioMayorista = precioMayorista;
	}

	public Double getPrecioMayoristaIva() {
		return precioMayoristaIva;
	}

	public void setPrecioMayoristaIva(Double precioMayoristaIva) {
		this.precioMayoristaIva = precioMayoristaIva;
	}

	public Double getPrecioCaja() {
		return precioCaja;
	}

	public void setPrecioCaja(Double precioCaja) {
		this.precioCaja = precioCaja;
	}

	public Double getPrecioCajaIva() {
		return precioCajaIva;
	}

	public void setPrecioCajaIva(Double precioCajaIva) {
		this.precioCajaIva = precioCajaIva;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public Double getPrecioUnitarioIva() {
		return precioUnitarioIva;
	}

	public void setPrecioUnitarioIva(Double precioUnitarioIva) {
		this.precioUnitarioIva = precioUnitarioIva;
	}

	public String getNpAplicaPrecioCaja() {
		return npAplicaPrecioCaja;
	}

	public void setNpAplicaPrecioCaja(String npAplicaPrecioCaja) {
		this.npAplicaPrecioCaja = npAplicaPrecioCaja;
	}

	public String getNpAplicaPrecioMayorista() {
		return npAplicaPrecioMayorista;
	}

	public void setNpAplicaPrecioMayorista(String npAplicaPrecioMayorista) {
		this.npAplicaPrecioMayorista = npAplicaPrecioMayorista;
	}

	public String getNpCalcularBonos() {
		return npCalcularBonos;
	}

	public void setNpCalcularBonos(String npCalcularBonos) {
		this.npCalcularBonos = npCalcularBonos;
	}	
	
}
