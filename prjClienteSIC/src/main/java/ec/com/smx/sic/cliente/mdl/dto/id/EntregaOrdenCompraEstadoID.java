package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Clase que encapsula a las propiedades Identificadoras de la clase EntregaOrdenCompraEstadoDTO
 * 
 * @see ec.com.smx.sic.cliente.mdl.dto.EntregaOrdenCompraEstadoDTO
 * 
 * @author kruger
 */
@SuppressWarnings("serial")
@Embeddable
public class EntregaOrdenCompraEstadoID implements Serializable {

	/**
	 * Especifica el codigo de la compania
	 * 
	 */
	@Column(name = "CODIGOCOMPANIA", nullable = false)
	private Integer codigoCompania;

	/**
	 * representa el codigo de EntregaDTO
	 * 
	 */
	@Column(name = "CODIGOENTREGA", nullable = false)
	private Long codigoEntrega;

	/**
	 * codigo asignado a OrdenCompraEstado.
	 * 
	 */
	@Column(name = "CODIGOORDENCOMPRAESTADO", nullable = false)
	private Long codigoOrdenCompraEstado;
	
	
	
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
	 * Retorna valor de propiedad <code>codigoCompania</code>
	 * 
	 * @return Retorna valor de propiedad <code>codigoCompania</code>
	 */
	public Integer getCodigoCompania() {
		return this.codigoCompania;
	}

	/**
	 * Establece un nuevo valor para la propiedad <code>codigoCompania</code>.
	 * 
	 * @param codigoCompania1
	 *            El valor a establecer para la propiedad
	 *            <code>codigoCompania</code>.
	 */
	public void setCodigoCompania(Integer codigoCompania1) {
		this.codigoCompania = codigoCompania1;

	}
	

	

}
