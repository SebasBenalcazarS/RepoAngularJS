package ec.com.smx.sic.cliente.mdl.dto.impcorp;

/**
 * 
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.FactorDetalleID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTFCTDET")
public class FactorDetalleDTO extends AuditoriaBaseDTO<FactorDetalleID>{
	
	@Column(name = "CODIGOFACTOR")
	private Long codigoFactor;
	
	@Column(name = "CODIGOGASTOEMBARQUE")
	private Long codigoGastoEmbarque;
	
	@Column(name = "VALOR")
	private Double valor;
	
	@Column(name = "PORCENTAJE")
	private Double porcentaje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOFACTOR", referencedColumnName = "CODIGOFACTOR", insertable = false, updatable = false)
	})
	private FactorDTO factor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "CODIGOCOMPANIA", referencedColumnName = "CODIGOCOMPANIA", insertable = false, updatable = false),
		@JoinColumn(name = "CODIGOGASTOEMBARQUE", referencedColumnName = "CODIGOGASTOEMBARQUE", insertable = false, updatable = false)
	})
	private GastoEmbarqueDTO gastoEmbarque;

	/**
	 * @return devuelve el valor de la propiedad codigoFactor
	 */
	public Long getCodigoFactor() {
		return codigoFactor;
	}

	/**
	 * @param codigoFactor establece el valor a la propiedad codigoFactor
	 */
	public void setCodigoFactor(Long codigoFactor) {
		this.codigoFactor = codigoFactor;
	}

	/**
	 * @return devuelve el valor de la propiedad codigoGastoEmbarque
	 */
	public Long getCodigoGastoEmbarque() {
		return codigoGastoEmbarque;
	}

	/**
	 * @param codigoGastoEmbarque establece el valor a la propiedad codigoGastoEmbarque
	 */
	public void setCodigoGastoEmbarque(Long codigoGastoEmbarque) {
		this.codigoGastoEmbarque = codigoGastoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad valor
	 */
	public Double getValor() {
		return valor;
	}

	/**
	 * @param valor establece el valor a la propiedad valor
	 */
	public void setValor(Double valor) {
		this.valor = valor;
	}

	/**
	 * @return devuelve el valor de la propiedad porcentaje
	 */
	public Double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje establece el valor a la propiedad porcentaje
	 */
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * @return devuelve el valor de la propiedad gastoEmbarque
	 */
	public GastoEmbarqueDTO getGastoEmbarque() {
		return gastoEmbarque;
	}

	/**
	 * @param gastoEmbarque establece el valor a la propiedad gastoEmbarque
	 */
	public void setGastoEmbarque(GastoEmbarqueDTO gastoEmbarque) {
		this.gastoEmbarque = gastoEmbarque;
	}

	/**
	 * @return devuelve el valor de la propiedad factor
	 */
	public FactorDTO getFactor() {
		return factor;
	}

	/**
	 * @param factor establece el valor a la propiedad factor
	 */
	public void setFactor(FactorDTO factor) {
		this.factor = factor;
	}
	
}
