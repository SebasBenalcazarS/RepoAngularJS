/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class SegmentoCreacionArticuloID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	@Column(name = "VALORPASOCREACION", nullable = false)
	private String valorPasoCreacion;
	
	@Column(name = "CODIGOPASOCREACION", nullable = false)
	private Integer codigoPasoCreacion;

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
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	/**
	 * @return the valorPasoCreacion
	 */
	public String getValorPasoCreacion() {
		return valorPasoCreacion;
	}

	/**
	 * @param valorPasoCreacion the valorPasoCreacion to set
	 */
	public void setValorPasoCreacion(String valorPasoCreacion) {
		this.valorPasoCreacion = valorPasoCreacion;
	}

	/**
	 * @return the codigoPasoCreacion
	 */
	public Integer getCodigoPasoCreacion() {
		return codigoPasoCreacion;
	}

	/**
	 * @param codigoPasoCreacion the codigoPasoCreacion to set
	 */
	public void setCodigoPasoCreacion(Integer codigoPasoCreacion) {
		this.codigoPasoCreacion = codigoPasoCreacion;
	}
}
