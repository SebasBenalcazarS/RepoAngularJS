package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class TipoAfectacionPrecioID implements Serializable {
	/**
	 * Código de la compania
	 *
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Código tipo afectación
	 */
	@Column(name = "CODIGOTIPOAFECTACION", nullable = false)
	private Integer codigoTipoAfectacion;

	/**
	 * @return the codigoTipoAfectacion
	 */
	public Integer getCodigoTipoAfectacion() {
		return codigoTipoAfectacion;
	}

	/**
	 * @param codigoTipoAfectacion the codigoTipoAfectacion to set
	 */
	public void setCodigoTipoAfectacion(Integer codigoTipoAfectacion) {
		this.codigoTipoAfectacion = codigoTipoAfectacion;
	}


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
}
