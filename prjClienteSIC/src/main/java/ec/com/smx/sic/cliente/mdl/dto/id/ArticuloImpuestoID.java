package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloImpuesto
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloImpuesto
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloImpuestoID implements Serializable {

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del artículo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	/**
	 * Secuencial del tipo de impuesto
	 */
	@Column(name = "CODIGOTIPOIMPUESTO", nullable = false)
	private Integer codigoTipoImpuesto;

	/**
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}

	/**
	 * Retorna valor de propiedad <code>codigoArticulo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoArticulo</code>
	 */
	public String getCodigoArticulo() {
		return this.codigoArticulo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoArticulo</code>.
	 * 
	 * @param codigoArticulo1
	 *            El valor a establecer para la propiedad <code>codigoArticulo</code>.
	 */
	public void setCodigoArticulo(String codigoArticulo1) {
		this.codigoArticulo = codigoArticulo1;

		if (codigoArticulo != null && codigoArticulo.length() > 20) {
			codigoArticulo = codigoArticulo.substring(0, 20);
		}

	}

	/**
	 * Retorna valor de propiedad <code>codigoTipoImpuesto</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoTipoImpuesto</code>
	 */
	public Integer getCodigoTipoImpuesto() {
		return this.codigoTipoImpuesto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoTipoImpuesto</code>.
	 * 
	 * @param codigoTipoImpuesto1
	 *            El valor a establecer para la propiedad <code>codigoTipoImpuesto</code>.
	 */
	public void setCodigoTipoImpuesto(Integer codigoTipoImpuesto1) {
		this.codigoTipoImpuesto = codigoTipoImpuesto1;

	}

}
