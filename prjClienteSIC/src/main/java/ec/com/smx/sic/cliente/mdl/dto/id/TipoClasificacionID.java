package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author rhidalgo
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class TipoClasificacionID implements Serializable{
	
	/**
     * Codigo de la compania
     */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;
    /**
     * Codigo que califica a la clase del articulo
     *
     */
	@Column(name = "CODIGOTIPOCLASIFICACION", nullable = false)
    private String codigoTipoClasificacion;
    
    
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
	 * @return the codigoTipoClasificacion
	 */
	public String getCodigoTipoClasificacion() {
		return codigoTipoClasificacion;
	}
	/**
	 * @param codigoTipoClasificacion the codigoTipoClasificacion to set
	 */
	public void setCodigoTipoClasificacion(String codigoTipoClasificacion) {
		this.codigoTipoClasificacion = codigoTipoClasificacion;
	}
    
    
    
	
}
