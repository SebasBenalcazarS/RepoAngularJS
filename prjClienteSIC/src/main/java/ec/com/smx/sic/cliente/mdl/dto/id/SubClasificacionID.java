/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author mbraganza
 *
 */
@Embeddable
@SuppressWarnings("serial")
public class SubClasificacionID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	@Column(name = "CODIGOCLASIFICACION", nullable = false)
	private String codigoClasificacion;
	@Column(name = "CODIGOSUBCLASIFICACION", nullable = false)
	private String codigoSubClasificacion;
	
	public SubClasificacionID() {}
	public SubClasificacionID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoSubClasificacion = SICConstantes.getInstancia().VALOR_INICIAL_ID;
			codigoClasificacion = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	/**
	 * @return el codigoClasificacion
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	/**
	 * @param codigoClasificacion el codigoClasificacion a establecer
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	/**
	 * @return el codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania el codigoCompania a establecer
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return el codigoSubClasificacion
	 */
	public String getCodigoSubClasificacion() {
		return codigoSubClasificacion;
	}
	/**
	 * @param codigoSubClasificacion el codigoSubClasificacion a establecer
	 */
	public void setCodigoSubClasificacion(String codigoSubClasificacion) {
		this.codigoSubClasificacion = codigoSubClasificacion;
	}
	
	
}
