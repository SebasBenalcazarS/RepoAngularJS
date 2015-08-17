package ec.com.smx.sic.cliente.mdl.nopersistente;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Busca todos los recipientes de la ultima fecha de entrega de un proveedor o por un numero de documento
 * @author cherrera
 *
 */
public class RecipienteCabeceraEntregaTrasient {

	@Id
	private Long codDetConRci;
	private String numeroFactura;
	private Long codigoFactura;
	private Long codigoControlRecipiente;
	private String codigoProveedor;
	private String nombreProveedor;
	private String codigoBarras;
	private String descripcionArticulo;
	private Integer cantidadRecibida;
	private Integer cantidadPorEntregar;
	@Transient
	private Long codigoRecepcionProveedor;
	private String codigoArticulo;
	//private Date fechaRegistro;
	
	public Long getCodDetConRci() {
		return codDetConRci;
	}
	public void setCodDetConRci(Long codDetConRci) {
		this.codDetConRci = codDetConRci;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public Long getCodigoControlRecipiente() {
		return codigoControlRecipiente;
	}
	public void setCodigoControlRecipiente(Long codigoControlRecipiente) {
		this.codigoControlRecipiente = codigoControlRecipiente;
	}
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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
	public Integer getCantidadRecibida() {
		return cantidadRecibida;
	}
	public void setCantidadRecibida(Integer cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}
	public Integer getCantidadPorEntregar() {
		return cantidadPorEntregar;
	}
	public void setCantidadPorEntregar(Integer cantidadPorEntregar) {
		this.cantidadPorEntregar = cantidadPorEntregar;
	}
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	

	
}
