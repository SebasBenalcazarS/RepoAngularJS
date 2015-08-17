package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Busca todos los recipientes de la ultima fecha de entrega de un proveedor o por un numero de documento
 * @author amunoz
 *
 */
public class RecipienteCabeceraProveedorDocumentoTrasient {

	@Id
	private Long codigoControlRecipiente;
	private Long codigoRecepcionProveedor;
	private Long codigoFactura;
	private String numeroFactura;
	private String codigoProveedor;
	private String nombreProveedor;
	private Date fechaFactura;
	private String valorTipoDocumento;
	@Transient
	private Collection<RecipienteProveedorDocumentoTrasient> detallesRecipienteTrasientCol;
	
	
	public Long getCodigoControlRecipiente() {
		return codigoControlRecipiente;
	}
	public void setCodigoControlRecipiente(Long codigoControlRecipiente) {
		this.codigoControlRecipiente = codigoControlRecipiente;
	}
	public String getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
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
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public Collection<RecipienteProveedorDocumentoTrasient> getDetallesRecipienteTrasientCol() {
		return detallesRecipienteTrasientCol;
	}
	public void setDetallesRecipienteTrasientCol(Collection<RecipienteProveedorDocumentoTrasient> detallesRecipienteTrasientCol) {
		this.detallesRecipienteTrasientCol = detallesRecipienteTrasientCol;
	}
	public Long getCodigoRecepcionProveedor() {
		return codigoRecepcionProveedor;
	}
	public void setCodigoRecepcionProveedor(Long codigoRecepcionProveedor) {
		this.codigoRecepcionProveedor = codigoRecepcionProveedor;
	}
	public Long getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(Long codigoFactura) {
		this.codigoFactura = codigoFactura;
	}
	public String getValorTipoDocumento() {
		return valorTipoDocumento;
	}
	public void setValorTipoDocumento(String valorTipoDocumento) {
		this.valorTipoDocumento = valorTipoDocumento;
	}
	
	
}
