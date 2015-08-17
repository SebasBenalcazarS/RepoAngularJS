package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloEtiquetaUso
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.ArticuloEtiquetaUso
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class ArticuloUsoID implements Serializable{

	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)	
	private Integer codigoCompania;

	/**
	 * Código de artículo, almacena el código secuencial de un artículo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;

	/**
	 * Valor del tipo de uso en el catálogo
	 */
	@Column(name = "VALORTIPOUSO", nullable = false)
	private String valorTipoUso;

	/**
	 * Código del tipo de uso en el catálogo
	 * 
	 */
	@Column(name = "CODIGOTIPOUSO", nullable = false)
	private Integer codigoTipoUso;

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

	/**
	 * @return the codigoTipoUso
	 */
	public Integer getCodigoTipoUso() {
		return codigoTipoUso;
	}

	/**
	 * @param codigoTipoUso the codigoTipoUso to set
	 */
	public void setCodigoTipoUso(Integer codigoTipoUso) {
		this.codigoTipoUso = codigoTipoUso;
	}


}
