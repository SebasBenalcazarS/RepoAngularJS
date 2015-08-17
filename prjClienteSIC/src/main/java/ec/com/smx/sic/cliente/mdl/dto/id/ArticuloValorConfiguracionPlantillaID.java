package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloValorConfiguracionPlantilla
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloValorConfiguracionPlantillaDTO
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloValorConfiguracionPlantillaID implements Serializable {

	/**
	 * El código de la compañía
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	/**
	 * Id. del articulo
	 * 
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo ;
	
	/**
	 * Código de ValorConfiguracionPlantilla
	 * 
	 */
	@Column(name = "CODIGOVALORCONFIGURACIONPLANTILLA", nullable = false)
	private Integer codigoValorConfiguracionPlantilla;
	
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
	 * @return the codigoValorConfiguracionPlantilla
	 */
	public Integer getCodigoValorConfiguracionPlantilla() {
		return codigoValorConfiguracionPlantilla;
	}

	/**
	 * @param codigoValorConfiguracionPlantilla the codigoValorConfiguracionPlantilla to set
	 */
	public void setCodigoValorConfiguracionPlantilla(
			Integer codigoValorConfiguracionPlantilla) {
		this.codigoValorConfiguracionPlantilla = codigoValorConfiguracionPlantilla;
	}

}
