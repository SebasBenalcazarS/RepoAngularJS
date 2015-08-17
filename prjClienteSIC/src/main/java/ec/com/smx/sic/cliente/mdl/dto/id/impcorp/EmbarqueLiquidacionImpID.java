/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.corpv2.dto.id.BaseID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class EmbarqueLiquidacionImpID extends BaseID{
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name = "CODIGOEMBARQUEESTADO")
	private Long codigoEmbarqueEstado;

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
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque establece el valor a la propiedad codigoEmbarque
	 */
	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoEmbarqueEstado
	 */
	public Long getCodigoEmbarqueEstado() {
		return codigoEmbarqueEstado;
	}

	/**
	 * @param codigoEmbarqueEstado establece el valor a la propiedad codigoEmbarqueEstado
	 */
	public void setCodigoEmbarqueEstado(Long codigoEmbarqueEstado) {
		this.codigoEmbarqueEstado = codigoEmbarqueEstado;
	}
	
}
