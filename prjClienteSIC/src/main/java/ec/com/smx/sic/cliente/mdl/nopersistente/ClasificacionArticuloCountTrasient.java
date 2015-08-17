package ec.com.smx.sic.cliente.mdl.nopersistente;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

@SuppressWarnings("serial")
@Entity
public class ClasificacionArticuloCountTrasient extends SimpleAuditDTO {

	@Id
	private String codigoClasificacion;

	private String descripcionClasificacion;

	private Integer cantidadArticulos;

	private Integer cantidadArticulosRevisados;

	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	public Integer getCantidadArticulos() {
		return cantidadArticulos;
	}

	public void setCantidadArticulos(Integer cantidadArticulos) {
		this.cantidadArticulos = cantidadArticulos;
	}

	public String getDescripcionClasificacion() {
		return descripcionClasificacion;
	}

	public void setDescripcionClasificacion(String descripcionClasificacion) {
		this.descripcionClasificacion = descripcionClasificacion;
	}

	public Integer getCantidadArticulosRevisados() {
		return cantidadArticulosRevisados;
	}

	public void setCantidadArticulosRevisados(Integer cantidadArticulosRevisados) {
		this.cantidadArticulosRevisados = cantidadArticulosRevisados;
	}

}
