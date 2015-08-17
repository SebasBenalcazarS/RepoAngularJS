/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class EmbarqueContenedorImpID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOEMBARQUE")
	private Integer codigoEmbarque;
	
	@Column(name = "CODIGOEMBARQUECONTENEDOR")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECEMBCON")
	private Integer codigoEmbarqueContenedor;

	/**
	 * @return devuelve el valor de la propiedad codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania establece el valor a la propiedad codigoCompania
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarque
	 */
	public Integer getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque establece el valor a la propiedad codigoEmbarque
	 */
	public void setCodigoEmbarque(Integer codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarqueContenedor
	 */
	public Integer getCodigoEmbarqueContenedor() {
		return codigoEmbarqueContenedor;
	}

	/**
	 * @param codigoEmbarqueContenedor establece el valor a la propiedad codigoEmbarqueContenedor
	 */
	public void setCodigoEmbarqueContenedor(Integer codigoEmbarqueContenedor) {
		this.codigoEmbarqueContenedor = codigoEmbarqueContenedor;
	}
	
}

