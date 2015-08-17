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
public class EstadoTipoArticuloID implements Serializable{

	/**
	 * Codigo de la compa&ntilde;ia
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;
	/**
	 * Código del estado
	 */
	@Column(name = "CODIGOESTADO", nullable = false)
	private String codigoEstado;
	/**
	 * Código del tipo de art&iacute;culo
	 */
	@Column(name = "CODIGOTIPOARTICULO", nullable = false)
	private String codigoTipoArticulo;
	
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
	 * @return the codigoEstado
	 */
	public String getCodigoEstado() {
		return codigoEstado;
	}
	/**
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	public String getCodigoTipoArticulo() {
		return codigoTipoArticulo;
	}
	public void setCodigoTipoArticulo(String codigoTipoArticulo) {
		this.codigoTipoArticulo = codigoTipoArticulo;
	}
}
