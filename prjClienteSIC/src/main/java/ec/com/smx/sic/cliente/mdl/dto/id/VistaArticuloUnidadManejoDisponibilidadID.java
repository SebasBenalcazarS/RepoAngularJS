package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;
@SuppressWarnings("serial")
@Embeddable
public class VistaArticuloUnidadManejoDisponibilidadID extends BaseID{
	private Integer codigoCompania;
	private Long codigoRecepcion;
	private String codigoArticulo;
	private Long codigoUnidadManejo;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public Long getCodigoRecepcion() {
		return codigoRecepcion;
	}
	public void setCodigoRecepcion(Long codigoRecepcion) {
		this.codigoRecepcion = codigoRecepcion;
	}
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}
}
