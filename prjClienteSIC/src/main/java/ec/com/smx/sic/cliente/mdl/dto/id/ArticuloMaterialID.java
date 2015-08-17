package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloDuracion
 * 
 * @see ec.com.smx.sic.adm.dto.ArticuloDuracion
 * 
 * @author acaiza
 */
@Embeddable
@SuppressWarnings("serial")
public class ArticuloMaterialID implements Serializable {
	/**
	 * Codigo de la companía
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código de artículo
	 */
	@Column(name = "CODIGOARTICULO", nullable = false)
	private String codigoArticulo;
	/**
	 * Código del tipo de Material
	 * 
	 */
	@Column(name = "CODIGOTIPOMATERIAL", nullable = false)
	private Integer codigoTipoMaterial;

	/**
	 * Valor del tipo de Material
	 * 
	 */
	@Column(name = "VALORTIPOMATERIAL", nullable = false)
	private String valorTipoMaterial;
	
	/**
	 * @return the codigoTipoMaterial
	 */
	public Integer getCodigoTipoMaterial() {
		return codigoTipoMaterial;
	}

	/**
	 * @param codigoTipoMaterial the codigoTipoMaterial to set
	 */
	public void setCodigoTipoMaterial(Integer codigoTipoMaterial) {
		this.codigoTipoMaterial = codigoTipoMaterial;
	}

	/**
	 * @return the valorTipoMaterial
	 */
	public String getValorTipoMaterial() {
		return valorTipoMaterial;
	}

	/**
	 * @param valorTipoMaterial the valorTipoMaterial to set
	 */
	public void setValorTipoMaterial(String valorTipoMaterial) {
		this.valorTipoMaterial = valorTipoMaterial;
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

	
}
