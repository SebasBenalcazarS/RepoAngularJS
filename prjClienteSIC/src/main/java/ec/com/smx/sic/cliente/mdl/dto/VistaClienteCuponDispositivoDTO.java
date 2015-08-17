package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaClienteCuponDispositivoID;

/**
 * 
 * @author dvillafuerte
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCARTVCLICUPDEV")
public class VistaClienteCuponDispositivoDTO extends BaseDto<VistaClienteCuponDispositivoID> {

	

	private Integer cupon;
	
	private Integer dispositivo;

	/**
	 * @return the cupon
	 */
	public Integer getCupon() {
		return cupon;
	}

	/**
	 * @param cupon the cupon to set
	 */
	public void setCupon(Integer cupon) {
		this.cupon = cupon;
	}

	/**
	 * @return the dispositivo
	 */
	public Integer getDispositivo() {
		return dispositivo;
	}

	/**
	 * @param dispositivo the dispositivo to set
	 */
	public void setDispositivo(Integer dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	
}
