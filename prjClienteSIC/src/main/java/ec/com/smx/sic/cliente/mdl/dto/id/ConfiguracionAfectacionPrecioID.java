package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author cjara
 * 
 */
@Embeddable
@SuppressWarnings("serial")
public class ConfiguracionAfectacionPrecioID implements Serializable{
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOTIPOAFECTACION", nullable = false)
	private Integer codigoTipoAfectacion;
	
	@Column(name = "CODIGOTIPOVARIACION", nullable = false)
	private Integer codigoTipoVariacion;
	
	@Column(name = "VALORTIPOVARIACION", nullable = false)
	private String valorTipoVariacion;

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
	 * @return the codigoTipoVariacion
	 */
	public Integer getCodigoTipoVariacion() {
		return codigoTipoVariacion;
	}

	/**
	 * @param codigoTipoVariacion the codigoTipoVariacion to set
	 */
	public void setCodigoTipoVariacion(Integer codigoTipoVariacion) {
		this.codigoTipoVariacion = codigoTipoVariacion;
	}

	/**
	 * @return the valorTipoVariacion
	 */
	public String getValorTipoVariacion() {
		return valorTipoVariacion;
	}

	/**
	 * @param valorTipoVariacion the valorTipoVariacion to set
	 */
	public void setValorTipoVariacion(String valorTipoVariacion) {
		this.valorTipoVariacion = valorTipoVariacion;
	}
}
