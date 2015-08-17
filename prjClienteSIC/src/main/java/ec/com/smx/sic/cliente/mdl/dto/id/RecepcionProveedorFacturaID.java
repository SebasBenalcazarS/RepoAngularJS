package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@SuppressWarnings("serial")
@Embeddable
public class RecepcionProveedorFacturaID implements Serializable{
	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
		
	/**
	 * Secuencial de la tabla AsignacionProceso
	 *

	 */
	@Column(name = "CODIGORECEPCIONPROVEEDOR", nullable = false)
	private Long codigoRecepcionProveedor ;
	
	/**
	 * Especifica el codigo de la tarea
	 *
	 */
	@Column(name = "CODIGOFACTURA", nullable = false)
	private Long codigoFactura ;

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
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
}
