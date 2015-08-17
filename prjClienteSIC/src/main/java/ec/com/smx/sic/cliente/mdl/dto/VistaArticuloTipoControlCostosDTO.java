package ec.com.smx.sic.cliente.mdl.dto;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloTipoControlCostosID;

@SuppressWarnings("serial")
@Entity
public class VistaArticuloTipoControlCostosDTO implements Serializable{
	@EmbeddedId
	VistaArticuloTipoControlCostosID id = new VistaArticuloTipoControlCostosID();
	
	private String codigoArticulo;
	private String valorTipoControlCosto;
	private Integer codigoTipoControlCosto;
		
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	/**
	 * @return the valorTipoControlCosto
	 */
	public String getValorTipoControlCosto() {
		return valorTipoControlCosto;
	}
	/**
	 * @param valorTipoControlCosto the valorTipoControlCosto to set
	 */
	public void setValorTipoControlCosto(String valorTipoControlCosto) {
		this.valorTipoControlCosto = valorTipoControlCosto;
	}
	/**
	 * @return the codigoTipoControlCosto
	 */
	public Integer getCodigoTipoControlCosto() {
		return codigoTipoControlCosto;
	}
	/**
	 * @param codigoTipoControlCosto the codigoTipoControlCosto to set
	 */
	public void setCodigoTipoControlCosto(Integer codigoTipoControlCosto) {
		this.codigoTipoControlCosto = codigoTipoControlCosto;
	}
	public VistaArticuloTipoControlCostosID getId() {
		return id;
	}
	public void setId(VistaArticuloTipoControlCostosID id) {
		this.id = id;
	}
	
}

