package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase GrupoImpuesto
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.GrupoImpuesto
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class GrupoImpuestoID implements Serializable {

	/**
	 * Codigo de la companía
	 */
	@Column(name="CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Código del grupo de impuesto, los valores podrían ser: [IVA] Impuesto al valor agregado, [ICE] Impuesto a los consumos especiales, ...
	 */
	@Column(name="CODIGOGRUPOIMPUESTO", nullable = false)
	private String codigoGrupoImpuesto;

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
	 * Retorna valor de propiedad <code>codigoGrupoImpuesto</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoGrupoImpuesto</code>
	 */
	public String getCodigoGrupoImpuesto() {
		return this.codigoGrupoImpuesto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoGrupoImpuesto</code>.
	 * 
	 * @param codigoGrupoImpuesto1
	 *            El valor a establecer para la propiedad <code>codigoGrupoImpuesto</code>.
	 */
	public void setCodigoGrupoImpuesto(String codigoGrupoImpuesto1) {
		this.codigoGrupoImpuesto = codigoGrupoImpuesto1;

		if (codigoGrupoImpuesto != null && codigoGrupoImpuesto.length() > 4) {
			codigoGrupoImpuesto = codigoGrupoImpuesto.substring(0, 4);
		}

	}


}
