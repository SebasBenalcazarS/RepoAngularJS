/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author jvasquez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class NovedadArticuloJustificacionProveedorID implements Serializable{
	
	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * Secuencial de la tabla NovedadArticuloJustificacionDTO
	 *
	 */
	@Column(name = "CODIGONOVEDADARTICULOJUSTIFICACION", nullable = false)
	private Long codigoNovedadArticuloJustificacion;
	/**
	 * Especifica el codigo de proveedor
	 */
	@Column(name = "CODIGOPROVEEDOR", nullable = false)
	private String codigoProveedor ;
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoNovedadArticuloJustificacion
	 */
	public Long getCodigoNovedadArticuloJustificacion() {
		return codigoNovedadArticuloJustificacion;
	}
	/**
	 * @param codigoNovedadArticuloJustificacion the codigoNovedadArticuloJustificacion to set
	 */
	public void setCodigoNovedadArticuloJustificacion(Long codigoNovedadArticuloJustificacion) {
		this.codigoNovedadArticuloJustificacion = codigoNovedadArticuloJustificacion;
	}
	/**
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}
	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}
	
	
}
