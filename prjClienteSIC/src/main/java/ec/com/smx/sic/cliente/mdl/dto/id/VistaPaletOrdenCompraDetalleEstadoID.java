package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
@SuppressWarnings("serial")
@Embeddable
public class VistaPaletOrdenCompraDetalleEstadoID extends BaseID{
	private Integer codigoCompania;
	private Long codigoDetalleDatosTarea;
	
	/**
	 * @return the codigoCompania
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	/**
	 * @param codigoCompania the codigoCompania to set
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	/**
	 * @return the codigoDetalleDatosTarea
	 */
	public Long getCodigoDetalleDatosTarea() {
		return codigoDetalleDatosTarea;
	}
	/**
	 * @param codigoDetalleDatosTarea the codigoDetalleDatosTarea to set
	 */
	public void setCodigoDetalleDatosTarea(Long codigoDetalleDatosTarea) {
		this.codigoDetalleDatosTarea = codigoDetalleDatosTarea;
	}
	
}
