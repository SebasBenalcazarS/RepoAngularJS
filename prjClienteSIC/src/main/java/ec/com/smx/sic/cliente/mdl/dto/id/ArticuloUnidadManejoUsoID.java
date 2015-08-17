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
public class ArticuloUnidadManejoUsoID implements Serializable{

	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * Secuencial de la unidad de manejo por artículo
	 */
	@Column(name = "CODIGOUNIDADMANEJO", nullable = false)
	private Long codigoUnidadManejo;
	
	@Column(name = "VALORTIPOUSO", nullable = false)
	private String valorTipoUso;

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
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the valorTipoUso
	 */
	public String getValorTipoUso() {
		return valorTipoUso;
	}

	/**
	 * @param valorTipoUso the valorTipoUso to set
	 */
	public void setValorTipoUso(String valorTipoUso) {
		this.valorTipoUso = valorTipoUso;
	}
	
}
