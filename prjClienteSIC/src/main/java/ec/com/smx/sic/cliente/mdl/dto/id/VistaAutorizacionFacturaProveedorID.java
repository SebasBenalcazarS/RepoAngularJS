package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
@SuppressWarnings("serial")
@Embeddable
public class VistaAutorizacionFacturaProveedorID extends BaseID{
	private Integer codigoCompania;
	private Integer codigoAutorizacion;	

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
	 * @return the codigoAutorizacion
	 */
	public Integer getCodigoAutorizacion() {
		return codigoAutorizacion;
	}
	/**
	 * @param codigoAutorizacion the codigoAutorizacion to set
	 */
	public void setCodigoAutorizacion(Integer codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	
}
