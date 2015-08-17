package ec.com.smx.sic.cliente.mdl.dto.integracion;

import javax.persistence.Column;

import ec.com.smx.generadorexportacion.anotaciones.Format;
import ec.com.smx.integracion.batch.dto.IntTramaPosBaseInDTO;

/**
 * 
 * @author fvallejo
 * 
 */
public class MensajePushDTOIn extends IntTramaPosBaseInDTO{

	private static final long serialVersionUID = -2325044612214278976L;
	
	@Column(length=16)
	@Format(removefillCharacter = false)
	private String cedRuc;
	
	@Column(length = 8)
	@Format
	private Double totalDescuento;

	/**
	 * 
	 * @return the cedRuc
	 */
	public String getCedRuc() {
		return cedRuc;
	}

	/**
	 * 
	 * @param cedRuc the cedRuc to set
	 */
	public void setCedRuc(String cedRuc) {
		this.cedRuc = cedRuc;
	}

	/**
	 * 
	 * @return the totalDescuento
	 */
	public Double getTotalDescuento() {
		return totalDescuento;
	}

	/**
	 * 
	 * @param totalDescuento the totalDescuento to set
	 */
	public void setTotalDescuento(Double totalDescuento) {
		this.totalDescuento = totalDescuento;
	}

}
