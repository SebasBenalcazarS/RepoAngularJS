/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author fmunoz
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoArticuloID implements Serializable{

    /**
     * Codigo de la compañía
     */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
    private Integer codigoCompania ;

    /**
     * Codigo que califica a la clase del articulo
     */
	@Column(name = "CODIGOTIPOARTICULO", nullable = false)
    private String codigoTipoArticulo ;

	public TipoArticuloID() {}
	public TipoArticuloID(Boolean initID) {
		if(initID){
			codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			codigoTipoArticulo = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
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
}
