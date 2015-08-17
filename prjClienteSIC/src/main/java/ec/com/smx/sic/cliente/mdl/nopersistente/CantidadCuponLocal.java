/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author fmunoz
 * 
 */
@SuppressWarnings("serial")
@Entity
public class CantidadCuponLocal implements Serializable{

	@Id
	private Integer codigoLocal;
	private Long cantidadCupones;

	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	/**
	 * @return the cantidadCupones
	 */
	public Long getCantidadCupones() {
		return cantidadCupones;
	}

	/**
	 * @param cantidadCupones the cantidadCupones to set
	 */
	public void setCantidadCupones(Long cantidadCupones) {
		this.cantidadCupones = cantidadCupones;
	}
	

}
