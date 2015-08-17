package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class ProcesoClaseID implements Serializable{

	/**
	 * Código de la compañía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Código que califica a la clase del artículo
	 */
	@Column(name = "CODIGOCLASEARTICULO", nullable = false)
	private String codigoClaseArticulo;
	
	/**
	 * Especifica el código del proceso especificada en la tabla de proceso
	 */
	@Column(name = "CODIGOPROCESO", nullable = false)
	private Long codigoProceso;

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
	 * @return the codigoClaseArticulo
	 */
	public String getCodigoClaseArticulo() {
		return codigoClaseArticulo;
	}

	/**
	 * @param codigoClaseArticulo the codigoClaseArticulo to set
	 */
	public void setCodigoClaseArticulo(String codigoClaseArticulo) {
		this.codigoClaseArticulo = codigoClaseArticulo;
	}

	/**
	 * @return the codigoProceso
	 */
	public Long getCodigoProceso() {
		return codigoProceso;
	}

	/**
	 * @param codigoProceso the codigoProceso to set
	 */
	public void setCodigoProceso(Long codigoProceso) {
		this.codigoProceso = codigoProceso;
	}
}
