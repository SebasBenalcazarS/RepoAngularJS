package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

@Entity
@SuppressWarnings("serial")
public class VistaArticuloOrdenCompraEstadoDTO extends SearchDTO {
	
	@EmbeddedId
	private ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloOrdenCompraEstadoID id = new ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloOrdenCompraEstadoID();
	
	/**
	 * Codigo de la orden compra estado
	 */
	private Long codigoOrdenCompraEstado;
	
	/**
	 * Codigo de la orden compra detalle estado padre
	 */
	private Long codigoOrdenCompraEstadoPadre;
	
	/**
	 * Codigo del articulo
	 */
	private String codigoArticulo;
	
	/**
	 * Codigo de la unidad de manejo por artículo
	 */
	private Long codigoUnidadManejo;
	
	/**
	 * Cantidad del articulo pedida para la entrega
	 */
	 private Integer cantidadPedida;
	 
	 /**
	 * Estado de la orden de compra
	 */
	 private String estadoOrdenCompraEstado;

	/**
	 * @return the id
	 */
	public ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloOrdenCompraEstadoID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloOrdenCompraEstadoID id) {
		this.id = id;
	}

	/**
	 * @return the codigoOrdenCompraEstado
	 */
	public Long getCodigoOrdenCompraEstado() {
		return codigoOrdenCompraEstado;
	}

	/**
	 * @param codigoOrdenCompraEstado the codigoOrdenCompraEstado to set
	 */
	public void setCodigoOrdenCompraEstado(Long codigoOrdenCompraEstado) {
		this.codigoOrdenCompraEstado = codigoOrdenCompraEstado;
	}

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
	 * @return the codigoUnidadManejo
	 */
	public Long getCodigoUnidadManejo() {
		return codigoUnidadManejo;
	}

	/**
	 * @param codigoUnidadManejo the codigoUnidadManejo to set
	 */
	public void setCodigoUnidadManejo(Long codigoUnidadManejo) {
		this.codigoUnidadManejo = codigoUnidadManejo;
	}

	/**
	 * @return the cantidadPedida
	 */
	public Integer getCantidadPedida() {
		return cantidadPedida;
	}

	/**
	 * @param cantidadPedida the cantidadPedida to set
	 */
	public void setCantidadPedida(Integer cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
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
	 * @return the estadoOrdenCompraEstado
	 */
	public String getEstadoOrdenCompraEstado() {
		return estadoOrdenCompraEstado;
	}

	/**
	 * @param estadoOrdenCompraEstado the estadoOrdenCompraEstado to set
	 */
	public void setEstadoOrdenCompraEstado(String estadoOrdenCompraEstado) {
		this.estadoOrdenCompraEstado = estadoOrdenCompraEstado;
	}
	
}
