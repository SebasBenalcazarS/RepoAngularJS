package ec.com.smx.sic.cliente.mdl.nopersistente;

import javax.persistence.Entity;
import javax.persistence.Id;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;

/**
 * @author finga
 * 
 */
@SuppressWarnings("serial")
@Entity
public class ArticuloAnomaliaTrasient extends SimpleAuditDTO {

	@Id
	private Long codigoUnidadManejo;
	private String codigoArticulo;
	private Integer cantidadPedida;
	private Integer cantidadDespachada;

	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	public Integer getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public Integer getCantidadDespachada() {
		return cantidadDespachada;
	}

	public void setCantidadDespachada(Integer cantidadDespachada) {
		this.cantidadDespachada = cantidadDespachada;
	}

}
