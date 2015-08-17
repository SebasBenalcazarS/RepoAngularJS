package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase ArticuloUnidadManejo
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.UnidadManejoArticuloDTO
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class UnidadManejoArticuloID implements Serializable {

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
	 * Secuencial de la unidad de manejo por artículo
	 */
	@Column(name = "CODIGOUNIDADMANEJO", nullable = false)
	@SequenceDataBaseValue(descriptorClass=DescriptorSecuenciasSIC.class , name = "SCSADSARTUNIMAN")
	private Long codigoUnidadManejo;

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
	 * Retorna valor de propiedad <code>codigoUnidadManejo</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoUnidadManejo</code>
	 */
	public Long getCodigoUnidadManejo() {
		return this.codigoUnidadManejo;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoUnidadManejo</code>.
	 * 
	 * @param codigoUnidadManejo1
	 *            El valor a establecer para la propiedad <code>codigoUnidadManejo</code>.
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo1) {
		this.codigoUnidadManejo = codigoUnidadManejo1;

	}

}
