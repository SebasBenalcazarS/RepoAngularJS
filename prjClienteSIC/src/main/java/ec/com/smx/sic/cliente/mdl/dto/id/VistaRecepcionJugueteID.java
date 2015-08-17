/*
 * Kruger 2014 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * <b> Id asociado a la estructura para la recepcion de juguetes. </b>
 * 
 * @author mchiliquinga, Date: 19/03/2014
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class VistaRecepcionJugueteID implements Serializable {
	
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;
	
	@Column(name = "CODIGOARTICULO")
	private String codigoArticulo;
	
	@Column(name = "CODIGOEMBARQUE")
	private Long codigoEmbarque;
	
	@Column (name = "CODIGOPROVEEDOR")
	private String codigoProveedor;
	
	@Column (name = "CODIGOORDENCOMPRADETALLEESTADO")
	private Long codigoOrdenCompraDetalleEstado;
	
	@Column (name = "CODIGOORDENCOMPRAESTADO")
	private Long codigoOrdenCompraEstado;
	
	public Long getCodigoEmbarque() {
		return codigoEmbarque;
	}

	public void setCodigoEmbarque(Long codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
	}

	public Long getCodigoOrdenCompraEstado() {
		return codigoOrdenCompraEstado;
	}

	public void setCodigoOrdenCompraEstado(Long codigoOrdenCompraEstado) {
		this.codigoOrdenCompraEstado = codigoOrdenCompraEstado;
	}

	public String getCodigoArticulo() {
		return codigoArticulo;
	}

	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoArticulo == null) ? 0 : codigoArticulo.hashCode());
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoEmbarque == null) ? 0 : codigoEmbarque.hashCode());
		result = prime * result + ((codigoOrdenCompraDetalleEstado == null) ? 0 : codigoOrdenCompraDetalleEstado.hashCode());
		result = prime * result + ((codigoOrdenCompraEstado == null) ? 0 : codigoOrdenCompraEstado.hashCode());
		result = prime * result + ((codigoProveedor == null) ? 0 : codigoProveedor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VistaRecepcionJugueteID other = (VistaRecepcionJugueteID) obj;
		if (codigoArticulo == null) {
			if (other.codigoArticulo != null)
				return false;
		} else if (!codigoArticulo.equals(other.codigoArticulo))
			return false;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoEmbarque == null) {
			if (other.codigoEmbarque != null)
				return false;
		} else if (!codigoEmbarque.equals(other.codigoEmbarque))
			return false;
		if (codigoOrdenCompraDetalleEstado == null) {
			if (other.codigoOrdenCompraDetalleEstado != null)
				return false;
		} else if (!codigoOrdenCompraDetalleEstado.equals(other.codigoOrdenCompraDetalleEstado))
			return false;
		if (codigoOrdenCompraEstado == null) {
			if (other.codigoOrdenCompraEstado != null)
				return false;
		} else if (!codigoOrdenCompraEstado.equals(other.codigoOrdenCompraEstado))
			return false;
		if (codigoProveedor == null) {
			if (other.codigoProveedor != null)
				return false;
		} else if (!codigoProveedor.equals(other.codigoProveedor))
			return false;
		return true;
	}

}
