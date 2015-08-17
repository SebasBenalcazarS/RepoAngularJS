package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloRotuladoReporte
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloRotuladoReporteDTO
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloRotuladoReporteID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo ;
	
	@Column(name = "CODIGOVALORCONFIGURACIONPLANTILLA", nullable = false)
	private Integer codigoValorConfiguracionPlantilla;
	
	@Column(name = "CODIGODETALLEGRUPOCAMPOPLANTIL", nullable = false)
	private Integer codigoDetalleGrupoCampoPlantilla;
	
	@Column(name = "CODIGOCAMPOPLANTILLA", nullable = false)
	private Integer codigoCampoPlantilla;
	
	@Column(name = "IDUSUARIOREGISTRO", nullable = false)
	private String idUsuarioRegistro;
	
	

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

	/**
	 * @return the codigoCampoPlantilla
	 */
	public Integer getCodigoCampoPlantilla() {
		return codigoCampoPlantilla;
	}

	/**
	 * @param codigoCampoPlantilla the codigoCampoPlantilla to set
	 */
	public void setCodigoCampoPlantilla(Integer codigoCampoPlantilla) {
		this.codigoCampoPlantilla = codigoCampoPlantilla;
	}

	/**
	 * @return the idUsuarioRegistro
	 */
	public String getIdUsuarioRegistro() {
		return idUsuarioRegistro;
	}

	/**
	 * @param idUsuarioRegistro the idUsuarioRegistro to set
	 */
	public void setIdUsuarioRegistro(String idUsuarioRegistro) {
		this.idUsuarioRegistro = idUsuarioRegistro;
	}

	/**
	 * @return the codigoDetalleGrupoCampoPlantilla
	 */
	public Integer getCodigoDetalleGrupoCampoPlantilla() {
		return codigoDetalleGrupoCampoPlantilla;
	}

	/**
	 * @param codigoDetalleGrupoCampoPlantilla the codigoDetalleGrupoCampoPlantilla to set
	 */
	public void setCodigoDetalleGrupoCampoPlantilla(
			Integer codigoDetalleGrupoCampoPlantilla) {
		this.codigoDetalleGrupoCampoPlantilla = codigoDetalleGrupoCampoPlantilla;
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
