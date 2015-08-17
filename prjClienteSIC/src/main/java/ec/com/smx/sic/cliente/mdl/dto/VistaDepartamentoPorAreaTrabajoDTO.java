package ec.com.smx.sic.cliente.mdl.dto;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

@SuppressWarnings("serial")
public class VistaDepartamentoPorAreaTrabajoDTO extends SearchDTO{
	private Integer codigoCompania;
	private String codigoClasificacion;
	private String descripcionClasificacion;
	
	public Integer getCodigoCompania() {
		return codigoCompania;
	}
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}
	public String getDescripcionClasificacion() {
		return descripcionClasificacion;
	}
	public void setDescripcionClasificacion(String descripcionClasificacion) {
		this.descripcionClasificacion = descripcionClasificacion;
	}
	
}
