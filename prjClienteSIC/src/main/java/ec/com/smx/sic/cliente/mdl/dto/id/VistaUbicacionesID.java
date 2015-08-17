/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;

/**
 * @author jmontenegro
 *
 */
@SuppressWarnings("serial")
@Embeddable
@MappedSuperclass
public class VistaUbicacionesID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania ;
	
	
	@Column(name = "CODIGODETALLESECCIONUBICACION", nullable = false)
	private java.lang.Long codigoDetalleSeccionUbicacion ;


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
	 * @return the codigoDetalleSeccionUbicacion
	 */
	public java.lang.Long getCodigoDetalleSeccionUbicacion() {
		return codigoDetalleSeccionUbicacion;
	}


	/**
	 * @param codigoDetalleSeccionUbicacion the codigoDetalleSeccionUbicacion to set
	 */
	public void setCodigoDetalleSeccionUbicacion(java.lang.Long codigoDetalleSeccionUbicacion) {
		this.codigoDetalleSeccionUbicacion = codigoDetalleSeccionUbicacion;
	}





	
	
	
	
}
