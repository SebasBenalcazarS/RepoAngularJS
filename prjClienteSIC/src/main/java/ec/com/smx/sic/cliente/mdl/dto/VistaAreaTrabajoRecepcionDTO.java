/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;

/**
 * @author wcaiza
 *
 */
@Entity
public class VistaAreaTrabajoRecepcionDTO {
	
	private Integer codigoAreaTrabajoCD;
	private Integer codigoAreaTrabajoBodega;
	private Integer codigoAreaTrabajoSubBodega;
	
	private String tipoAreaTrabajoValorCD;
	private String tipoAreaTrabajoValorBodega;
	private String tipoAreaTrabajoValorSubBodega;
	/**
	 * @return the codigoAreaTrabajoCD
	 */
	public Integer getCodigoAreaTrabajoCD() {
		return codigoAreaTrabajoCD;
	}
	/**
	 * @param codigoAreaTrabajoCD the codigoAreaTrabajoCD to set
	 */
	public void setCodigoAreaTrabajoCD(Integer codigoAreaTrabajoCD) {
		this.codigoAreaTrabajoCD = codigoAreaTrabajoCD;
	}
	/**
	 * @return the codigoAreaTrabajoBodega
	 */
	public Integer getCodigoAreaTrabajoBodega() {
		return codigoAreaTrabajoBodega;
	}
	/**
	 * @param codigoAreaTrabajoBodega the codigoAreaTrabajoBodega to set
	 */
	public void setCodigoAreaTrabajoBodega(Integer codigoAreaTrabajoBodega) {
		this.codigoAreaTrabajoBodega = codigoAreaTrabajoBodega;
	}
	/**
	 * @return the codigoAreaTrabajoSubBodega
	 */
	public Integer getCodigoAreaTrabajoSubBodega() {
		return codigoAreaTrabajoSubBodega;
	}
	/**
	 * @param codigoAreaTrabajoSubBodega the codigoAreaTrabajoSubBodega to set
	 */
	public void setCodigoAreaTrabajoSubBodega(Integer codigoAreaTrabajoSubBodega) {
		this.codigoAreaTrabajoSubBodega = codigoAreaTrabajoSubBodega;
	}
	/**
	 * @return the tipoAreaTrabajoValorCD
	 */
	public String getTipoAreaTrabajoValorCD() {
		return tipoAreaTrabajoValorCD;
	}
	/**
	 * @param tipoAreaTrabajoValorCD the tipoAreaTrabajoValorCD to set
	 */
	public void setTipoAreaTrabajoValorCD(String tipoAreaTrabajoValorCD) {
		this.tipoAreaTrabajoValorCD = tipoAreaTrabajoValorCD;
	}
	/**
	 * @return the tipoAreaTrabajoValorBodega
	 */
	public String getTipoAreaTrabajoValorBodega() {
		return tipoAreaTrabajoValorBodega;
	}
	/**
	 * @param tipoAreaTrabajoValorBodega the tipoAreaTrabajoValorBodega to set
	 */
	public void setTipoAreaTrabajoValorBodega(String tipoAreaTrabajoValorBodega) {
		this.tipoAreaTrabajoValorBodega = tipoAreaTrabajoValorBodega;
	}
	/**
	 * @return the tipoAreaTrabajoValorSubBodega
	 */
	public String getTipoAreaTrabajoValorSubBodega() {
		return tipoAreaTrabajoValorSubBodega;
	}
	/**
	 * @param tipoAreaTrabajoValorSubBodega the tipoAreaTrabajoValorSubBodega to set
	 */
	public void setTipoAreaTrabajoValorSubBodega(String tipoAreaTrabajoValorSubBodega) {
		this.tipoAreaTrabajoValorSubBodega = tipoAreaTrabajoValorSubBodega;
	}

}
