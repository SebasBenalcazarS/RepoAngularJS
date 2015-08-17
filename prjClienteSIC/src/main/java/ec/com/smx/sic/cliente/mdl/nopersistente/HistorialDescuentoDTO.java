/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author cgalarza
 *
 */
@SuppressWarnings("serial")
@Entity
public class HistorialDescuentoDTO implements Serializable{

	@Id
	private Long codigoPersona;
	private Double valorDescuento;
	private Double valorTotal;
	/**
	 * @return the codigoPersona
	 */
	public Long getCodigoPersona() {
		return codigoPersona;
	}
	/**
	 * @param codigoPersona the codigoPersona to set
	 */
	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	/**
	 * @return the valorDescuento
	 */
	public Double getValorDescuento() {
		return valorDescuento;
	}
	/**
	 * @param valorDescuento the valorDescuento to set
	 */
	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}
	/**
	 * @return the valorTotal
	 */
	public Double getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
