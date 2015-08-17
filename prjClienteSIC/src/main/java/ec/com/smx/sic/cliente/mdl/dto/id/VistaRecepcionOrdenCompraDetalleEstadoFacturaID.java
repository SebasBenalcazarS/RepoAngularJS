package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaRecepcionOrdenCompraDetalleEstadoFacturaID extends BaseID {
	
	private Integer codigoCompania;
	private Long codigoProcesoLogistico;
	private Long codigoOrdenCompraDetalleEstadoENV;
	private Long codigoOrdenCompraDetalleEstadoPEN;
	private Long codigoDetalleFacturaEstado;
	
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
	 * @return the codigoProcesoLogistico
	 */
	public Long getCodigoProcesoLogistico() {
		return codigoProcesoLogistico;
	}

	/**
	 * @param codigoProcesoLogistico the codigoProcesoLogistico to set
	 */
	public void setCodigoProcesoLogistico(Long codigoProcesoLogistico) {
		this.codigoProcesoLogistico = codigoProcesoLogistico;
	}

	/**
	 * @return the codigoOrdenCompraDetalleEstadoENV
	 */
	public Long getCodigoOrdenCompraDetalleEstadoENV() {
		return codigoOrdenCompraDetalleEstadoENV;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstadoENV the codigoOrdenCompraDetalleEstadoENV to set
	 */
	public void setCodigoOrdenCompraDetalleEstadoENV(Long codigoOrdenCompraDetalleEstadoENV) {
		this.codigoOrdenCompraDetalleEstadoENV = codigoOrdenCompraDetalleEstadoENV;
	}

	/**
	 * @return the codigoOrdenCompraDetalleEstadoPEN
	 */
	public Long getCodigoOrdenCompraDetalleEstadoPEN() {
		return codigoOrdenCompraDetalleEstadoPEN;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstadoPEN the codigoOrdenCompraDetalleEstadoPEN to set
	 */
	public void setCodigoOrdenCompraDetalleEstadoPEN(Long codigoOrdenCompraDetalleEstadoPEN) {
		this.codigoOrdenCompraDetalleEstadoPEN = codigoOrdenCompraDetalleEstadoPEN;
	}

	/**
	 * @return the codigoDetalleFacturaEstado
	 */
	public Long getCodigoDetalleFacturaEstado() {
		return codigoDetalleFacturaEstado;
	}

	/**
	 * @param codigoDetalleFacturaEstado the codigoDetalleFacturaEstado to set
	 */
	public void setCodigoDetalleFacturaEstado(Long codigoDetalleFacturaEstado) {
		this.codigoDetalleFacturaEstado = codigoDetalleFacturaEstado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoProcesoLogistico == null) ? 0 : codigoProcesoLogistico.hashCode());
		result = prime * result + ((codigoOrdenCompraDetalleEstadoENV == null) ? 0 : codigoOrdenCompraDetalleEstadoENV.hashCode());
		result = prime * result + ((codigoOrdenCompraDetalleEstadoPEN == null) ? 0 : codigoOrdenCompraDetalleEstadoPEN.hashCode());
		result = prime * result + ((codigoDetalleFacturaEstado == null) ? 0 : codigoDetalleFacturaEstado.hashCode());
		
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
		
		VistaRecepcionOrdenCompraDetalleEstadoFacturaID other = (VistaRecepcionOrdenCompraDetalleEstadoFacturaID) obj;
		
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		
		if (codigoProcesoLogistico == null) {
			if (other.codigoProcesoLogistico != null)
				return false;
		} else if (!codigoProcesoLogistico.equals(other.codigoProcesoLogistico))
			return false;

		if (codigoOrdenCompraDetalleEstadoENV == null) {
			if (other.codigoOrdenCompraDetalleEstadoENV != null)
				return false;
		} else if (!codigoOrdenCompraDetalleEstadoENV.equals(other.codigoOrdenCompraDetalleEstadoENV))
			return false;
		
		if (codigoOrdenCompraDetalleEstadoPEN == null) {
			if (other.codigoOrdenCompraDetalleEstadoPEN != null)
				return false;
		} else if (!codigoOrdenCompraDetalleEstadoPEN.equals(other.codigoOrdenCompraDetalleEstadoPEN))
			return false;
		
		if (codigoDetalleFacturaEstado == null) {
			if (other.codigoDetalleFacturaEstado != null)
				return false;
		} else if (!codigoDetalleFacturaEstado.equals(other.codigoDetalleFacturaEstado))
			return false;
		
		
		return true;
	}

}
