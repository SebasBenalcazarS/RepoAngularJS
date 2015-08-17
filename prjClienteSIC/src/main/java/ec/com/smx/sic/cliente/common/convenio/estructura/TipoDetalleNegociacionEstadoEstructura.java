package ec.com.smx.sic.cliente.common.convenio.estructura;
/**
 * Estructura para   validar si son modificables los tipos de detalle de negociacion existentes
 * @author aquingaluisa
 *
 */
public class TipoDetalleNegociacionEstadoEstructura {
	private Boolean negociacionParticipacion;
	private Boolean negociacionParticipacionPrefacturada;
	private Boolean negociacionParticipacionRechazada;
	
	private Boolean negociacionVenta;
	private Boolean negociacionVentaPrefacturada;
	private Boolean negociacionVentaRechazada;
	
	private Boolean negociacionCosto;
	private Boolean negociacionCostoPrefacturada;
	private Boolean negociacionCostoRechazada;
	
	private Boolean negociacionOrdenCompra;
	private Boolean negociacionOrdenCompraPrefacturada;
	private Boolean negociacionOrdenCompraRechaza;
	
	public TipoDetalleNegociacionEstadoEstructura(){
		this.negociacionCosto = Boolean.FALSE;
		this.negociacionVenta = Boolean.FALSE;
		this.negociacionParticipacion = Boolean.FALSE;
		this.negociacionOrdenCompra = Boolean.FALSE;
				
	}
	
	public TipoDetalleNegociacionEstadoEstructura(Boolean negociacionCosto,Boolean negociacionVenta,Boolean negociacionParticipacion,Boolean negociacionOrdenCompra){
		this.negociacionCosto = negociacionCosto;
		this.negociacionVenta = negociacionVenta;
		this.negociacionParticipacion = negociacionParticipacion;
		this.negociacionOrdenCompra = negociacionOrdenCompra;
		
		this.negociacionParticipacionRechazada = Boolean.FALSE;
		this.negociacionVentaRechazada = Boolean.FALSE;
		this.negociacionCostoRechazada = Boolean.FALSE;
		this.negociacionOrdenCompraRechaza = Boolean.FALSE;
		
		this.negociacionParticipacionPrefacturada = Boolean.FALSE;
		this.negociacionVentaPrefacturada = Boolean.FALSE;
		this.negociacionCostoPrefacturada = Boolean.FALSE;
		this.negociacionOrdenCompraPrefacturada = Boolean.FALSE; 
				
	}
	public Boolean getNegociacionParticipacion() {
		return negociacionParticipacion;
	}
	
	public void setNegociacionParticipacion(Boolean negociacionParticipacion) {
		this.negociacionParticipacion = negociacionParticipacion;
	}
	
	public Boolean getNegociacionVenta() {
		return negociacionVenta;
	}
	
	public void setNegociacionVenta(Boolean negociacionVenta) {
		this.negociacionVenta = negociacionVenta;
	}
	
	public Boolean getNegociacionCosto() {
		return negociacionCosto;
	}
	
	public void setNegociacionCosto(Boolean negociacionCosto) {
		this.negociacionCosto = negociacionCosto;
	}
	
	public Boolean getNegociacionOrdenCompra() {
		return negociacionOrdenCompra;
	}
	
	public void setNegociacionOrdenCompra(Boolean negociacionOrdenCompra) {
		this.negociacionOrdenCompra = negociacionOrdenCompra;
	}

	public Boolean getNegociacionParticipacionRechazada() {
		return negociacionParticipacionRechazada;
	}

	public void setNegociacionParticipacionRechazada(Boolean negociacionParticipacionRechazada) {
		this.negociacionParticipacionRechazada = negociacionParticipacionRechazada;
	}

	public Boolean getNegociacionVentaRechazada() {
		return negociacionVentaRechazada;
	}

	public void setNegociacionVentaRechazada(Boolean negociacionVentaRechazada) {
		this.negociacionVentaRechazada = negociacionVentaRechazada;
	}

	public Boolean getNegociacionCostoRechazada() {
		return negociacionCostoRechazada;
	}

	public void setNegociacionCostoRechazada(Boolean negociacionCostoRechazada) {
		this.negociacionCostoRechazada = negociacionCostoRechazada;
	}

	public Boolean getNegociacionOrdenCompraRechaza() {
		return negociacionOrdenCompraRechaza;
	}

	public void setNegociacionOrdenCompraRechaza(Boolean negociacionOrdenCompraRechaza) {
		this.negociacionOrdenCompraRechaza = negociacionOrdenCompraRechaza;
	}

	public Boolean getNegociacionParticipacionPrefacturada() {
		return negociacionParticipacionPrefacturada;
	}

	public void setNegociacionParticipacionPrefacturada(Boolean negociacionParticipacionPrefacturada) {
		this.negociacionParticipacionPrefacturada = negociacionParticipacionPrefacturada;
	}

	public Boolean getNegociacionVentaPrefacturada() {
		return negociacionVentaPrefacturada;
	}

	public void setNegociacionVentaPrefacturada(Boolean negociacionVentaPrefacturada) {
		this.negociacionVentaPrefacturada = negociacionVentaPrefacturada;
	}

	public Boolean getNegociacionCostoPrefacturada() {
		return negociacionCostoPrefacturada;
	}

	public void setNegociacionCostoPrefacturada(Boolean negociacionCostoPrefacturada) {
		this.negociacionCostoPrefacturada = negociacionCostoPrefacturada;
	}

	public Boolean getNegociacionOrdenCompraPrefacturada() {
		return negociacionOrdenCompraPrefacturada;
	}

	public void setNegociacionOrdenCompraPrefacturada(Boolean negociacionOrdenCompraPrefacturada) {
		this.negociacionOrdenCompraPrefacturada = negociacionOrdenCompraPrefacturada;
	}
}
