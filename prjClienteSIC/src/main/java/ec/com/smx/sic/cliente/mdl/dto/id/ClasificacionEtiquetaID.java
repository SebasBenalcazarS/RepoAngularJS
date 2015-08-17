package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ClasificacionEtiquetaID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false )
	private Integer codigoCompania;
	
	@Column(name = "CODIGOCLASIFICACIONETIQUETA", nullable = false )
	private Long codigoClasificacionEtiqueta;
	
	
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
	 * @return the codigoClasificacionEtiqueta
	 */
	public Long getCodigoClasificacionEtiqueta() {
		return codigoClasificacionEtiqueta;
	}
	/**
	 * @param codigoClasificacionEtiqueta the codigoClasificacionEtiqueta to set
	 */
	public void setCodigoClasificacionEtiqueta(Long codigoClasificacionEtiqueta) {
		this.codigoClasificacionEtiqueta = codigoClasificacionEtiqueta;
	}
}
