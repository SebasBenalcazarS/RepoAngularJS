package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase Concepto
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.Concepto
 * 
 * @author fmunoz
 */
@SuppressWarnings("serial")
@Embeddable
public class ConceptoID implements Serializable{

	/**
	 * Código de la compania
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * Identificador del concepto
	 */
	@Column(name = "CODIGOCONCEPTO", nullable = false)
	private String codigoConcepto;

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
	 * Retorna valor de propiedad <code>codigoConcepto</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoConcepto</code>
	 */
	public String getCodigoConcepto() {
		return this.codigoConcepto;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoConcepto</code>.
	 * 
	 * @param codigoConcepto1
	 *            El valor a establecer para la propiedad <code>codigoConcepto</code>.
	 */
	public void setCodigoConcepto(String codigoConcepto1) {
		this.codigoConcepto = codigoConcepto1;

	}

}
