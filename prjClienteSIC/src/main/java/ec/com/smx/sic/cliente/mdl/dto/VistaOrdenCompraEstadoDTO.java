package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.smx.sic.cliente.mdl.dto.id.VistaOrdenCompraEstadoID;

@Entity
public class VistaOrdenCompraEstadoDTO {
	@EmbeddedId
	VistaOrdenCompraEstadoID id = new VistaOrdenCompraEstadoID();
	
	private Long codigoEntrega;
	
	private Long codigoOrdenCompraEstadoPadre;
	
	private String valorEstado;

	/**
	 * @return the id
	 */
	public VistaOrdenCompraEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(VistaOrdenCompraEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoEntrega
	 */
	public Long getCodigoEntrega() {
		return codigoEntrega;
	}

	/**
	 * @param codigoEntrega the codigoEntrega to set
	 */
	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	/**
	 * @return the codigoOrdenCompraEstadoPadre
	 */
	public Long getCodigoOrdenCompraEstadoPadre() {
		return codigoOrdenCompraEstadoPadre;
	}

	/**
	 * @param codigoOrdenCompraEstadoPadre the codigoOrdenCompraEstadoPadre to set
	 */
	public void setCodigoOrdenCompraEstadoPadre(Long codigoOrdenCompraEstadoPadre) {
		this.codigoOrdenCompraEstadoPadre = codigoOrdenCompraEstadoPadre;
	}

	/**
	 * @return the valorEstado
	 */
	public String getValorEstado() {
		return valorEstado;
	}

	/**
	 * @param valorEstado the valorEstado to set
	 */
	public void setValorEstado(String valorEstado) {
		this.valorEstado = valorEstado;
	}
		
}
