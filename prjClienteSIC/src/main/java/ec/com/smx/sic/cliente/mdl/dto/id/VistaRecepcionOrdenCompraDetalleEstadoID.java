package ec.com.smx.sic.cliente.mdl.dto.id;

import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

@Embeddable
@SuppressWarnings("serial")
public class VistaRecepcionOrdenCompraDetalleEstadoID extends BaseID {
	
	private Integer codigoCompania;

	private Long codigoOrdenCompraDetalleEstado;
	
	private Long codigoProcesoLogistico;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoOrdenCompraDetalleEstado == null) ? 0 : codigoOrdenCompraDetalleEstado.hashCode());
		result = prime * result + ((codigoProcesoLogistico == null) ? 0 : codigoProcesoLogistico.hashCode());
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
		
		VistaRecepcionOrdenCompraDetalleEstadoID other = (VistaRecepcionOrdenCompraDetalleEstadoID) obj;
		
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		
		if (codigoOrdenCompraDetalleEstado == null) {
			if (other.codigoOrdenCompraDetalleEstado != null)
				return false;
		} else if (!codigoOrdenCompraDetalleEstado.equals(other.codigoOrdenCompraDetalleEstado))
			return false;
		
		if (codigoProcesoLogistico == null) {
			if (other.codigoProcesoLogistico != null)
				return false;
		} else if (!codigoProcesoLogistico.equals(other.codigoProcesoLogistico))
			return false;
		
		return true;
	}

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
	 * @return the codigoOrdenCompraDetalleEstado
	 */
	public Long getCodigoOrdenCompraDetalleEstado() {
		return codigoOrdenCompraDetalleEstado;
	}

	/**
	 * @param codigoOrdenCompraDetalleEstado the codigoOrdenCompraDetalleEstado to set
	 */
	public void setCodigoOrdenCompraDetalleEstado(Long codigoOrdenCompraDetalleEstado) {
		this.codigoOrdenCompraDetalleEstado = codigoOrdenCompraDetalleEstado;
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

}
