/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.impcorp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.corpv2.dto.AuditoriaBaseDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.impcorp.EmbarqueLiquidacionImpID;

/**
 * @author jvillacis
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SISIMTEMBLIQ")
public class EmbarqueLiquidacionImpDTO extends AuditoriaBaseDTO<EmbarqueLiquidacionImpID>{
	@Column(name = "VALORADVALOREM")
	private Double valorAdvalorem;
	
	@Column(name = "VALORIVA")
	private Double valorIva;
	
	@Column(name = "VALORMULTAS")
	private Double valorMultas;
	
	@Column(name = "VALORFODIN")
	private Double valorFodin;
	
	@Column(name = "VALORTOTAL")
	private Double valorTotal;
	
	@Column(name = "NUMEROLIQUIDACION")
	private String numeroLiquidacion;
	
	@Column(name = "SOBRETASA")
	private Double sobreTasa;

	/**
	 * @return devuelve el valor de la propiedad valorAdvalorem
	 */
	public Double getValorAdvalorem() {
		return valorAdvalorem;
	}

	/**
	 * @param valorAdvalorem establece el valor a la propiedad valorAdvalorem
	 */
	public void setValorAdvalorem(Double valorAdvalorem) {
		this.valorAdvalorem = valorAdvalorem;
	}

	/**
	 * @return devuelve el valor de la propiedad valorMultas
	 */
	public Double getValorMultas() {
		return valorMultas;
	}

	/**
	 * @param valorMultas establece el valor a la propiedad valorMultas
	 */
	public void setValorMultas(Double valorMultas) {
		this.valorMultas = valorMultas;
	}

	/**
	 * @return devuelve el valor de la propiedad valorFodin
	 */
	public Double getValorFodin() {
		return valorFodin;
	}

	/**
	 * @param valorFodin establece el valor a la propiedad valorFodin
	 */
	public void setValorFodin(Double valorFodin) {
		this.valorFodin = valorFodin;
	}

	/**
	 * @return devuelve el valor de la propiedad valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param valorTotal establece el valor a la propiedad valorTotal
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	/**
	 * @return devuelve el valor de la propiedad valorIva
	 */
	public Double getValorIva() {
		return valorIva;
	}

	/**
	 * @param valorIva establece el valor a la propiedad valorIva
	 */
	public void setValorIva(Double valorIva) {
		this.valorIva = valorIva;
	}

	/**
	 * @return the numeroLiquidacion
	 */
	public String getNumeroLiquidacion() {
		return numeroLiquidacion;
	}

	/**
	 * @param numeroLiquidacion the numeroLiquidacion to set
	 */
	public void setNumeroLiquidacion(String numeroLiquidacion) {
		this.numeroLiquidacion = numeroLiquidacion;
	}

	/**
	 * @return the sobreTasa
	 */
	public Double getSobreTasa() {
		return sobreTasa;
	}

	/**
	 * @param sobreTasa the sobreTasa to set
	 */
	public void setSobreTasa(Double sobreTasa) {
		this.sobreTasa = sobreTasa;
	}


	
	
}
