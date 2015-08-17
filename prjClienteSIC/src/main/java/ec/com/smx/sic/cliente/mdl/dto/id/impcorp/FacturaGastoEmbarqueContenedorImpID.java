package ec.com.smx.sic.cliente.mdl.dto.id.impcorp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.corpv2.dto.id.BaseID;
import ec.com.smx.sic.cliente.persistencia.secuencia.ImpcorpDescriptorSecuencias;

@SuppressWarnings("serial")
@Embeddable
public class FacturaGastoEmbarqueContenedorImpID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column(name = "CODIGOEMBARQUECONTENEDOR")
	private Long codigoEmbarqueContenedor;
		
	@Column(name = "CODIGOFACTURAGASTOCONTENEDOR")
	@SequenceDataBaseValue(descriptorClass = ImpcorpDescriptorSecuencias.class, name = "SISIMSECFACGASCON")
	private Long codigoFacturaGastoContenedor;

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
	 * @return the codigoEmbarque
	 */
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque the codigoEmbarque to set
	 */
	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return the codigoEmbarqueContenedor
	 */
	public Long getCodigoEmbarqueContenedor() {
		return codigoEmbarqueContenedor;
	}

	/**
	 * @param codigoEmbarqueContenedor the codigoEmbarqueContenedor to set
	 */
	public void setCodigoEmbarqueContenedor(Long codigoEmbarqueContenedor) {
		this.codigoEmbarqueContenedor = codigoEmbarqueContenedor;
	}

	/**
	 * @return the codigoFacturaGastoContenedor
	 */
	public Long getCodigoFacturaGastoContenedor() {
		return codigoFacturaGastoContenedor;
	}

	/**
	 * @param codigoFacturaGastoContenedor the codigoFacturaGastoContenedor to set
	 */
	public void setCodigoFacturaGastoContenedor(
			Long codigoFacturaGastoContenedor) {
		this.codigoFacturaGastoContenedor = codigoFacturaGastoContenedor;
	}
}