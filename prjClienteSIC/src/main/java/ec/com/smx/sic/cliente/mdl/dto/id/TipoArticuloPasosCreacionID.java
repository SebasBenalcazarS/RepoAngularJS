/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
public class TipoArticuloPasosCreacionID implements Serializable{

	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
    /**
     * Codigo del tipo de art&iacute;culo
     */
	@Column(name = "CODIGOTIPOARTICULO", nullable = false)
    private String codigoTipoArticulo ;
	
    /**
     * Valor del paso de creaci&oacute;n
     */
	@Column(name = "VALORPASOCREACION", nullable = false)
    private String valorPasoCreacion ;
	
    /**
     * Codigo del paso de creaci&oacute;n
     */
	@Column(name = "CODIGOPASOCREACION", nullable = false)
    private Integer codigoPasoCreacion ;

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
	 * @return the codigoTipoArticulo
	 */
	public String getCodigoTipoArticulo() {
		return codigoTipoArticulo;
	}

	/**
	 * @param codigoTipoArticulo the codigoTipoArticulo to set
	 */
	public void setCodigoTipoArticulo(String codigoTipoArticulo) {
		this.codigoTipoArticulo = codigoTipoArticulo;
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
