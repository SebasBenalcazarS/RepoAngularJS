package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;
import java.util.Date;

public class SumatoriaUnidadManejoOrdenCompraVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long cantidadPedida;
	private Long codigoUnidadManejo;
	private String codigoArticulo;
	private Integer codigoCompania;
	private String codigoProveedor;
	private String origenProveedor;
	private Date fechaDespacho;
	
	public SumatoriaUnidadManejoOrdenCompraVO(Long cantidadPedida, String codigoArticulo, Integer codigoCompania, String codigoProveedor) {
		super();
		this.cantidadPedida = cantidadPedida;
		this.codigoArticulo = codigoArticulo;
		this.codigoCompania = codigoCompania;
		this.codigoProveedor = codigoProveedor;
	}



	public SumatoriaUnidadManejoOrdenCompraVO() {
	}



	/**
	 * @return the cantidadPedida
	 */
	public Long getCantidadPedida() {
		return cantidadPedida;
	}

	/**
	 * @param cantidadPedida
	 *            the cantidadPedida to set
	 */
	public void setCantidadPedida(Long cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
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
	 * @return the codigoProveedor
	 */
	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoArticulo == null) ? 0 : codigoArticulo.hashCode());
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result + ((codigoProveedor == null) ? 0 : codigoProveedor.hashCode());
		result = prime * result + ((codigoUnidadManejo == null) ? 0 : codigoUnidadManejo.hashCode());
		result = prime * result + ((fechaDespacho == null) ? 0 : fechaDespacho.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SumatoriaUnidadManejoOrdenCompraVO other = (SumatoriaUnidadManejoOrdenCompraVO) obj;
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
		if (codigoProveedor == null) {
			if (other.codigoProveedor != null)
				return false;
		} else if (!codigoProveedor.equals(other.codigoProveedor))
			return false;
		if (codigoUnidadManejo == null) {
			if (other.codigoUnidadManejo != null)
				return false;
		} else if (!codigoUnidadManejo.equals(other.codigoUnidadManejo))
			return false;
		if (fechaDespacho == null) {
			if (other.fechaDespacho != null)
				return false;
		} else if (!fechaDespacho.equals(other.fechaDespacho))
			return false;
		return true;
	}



	/**
	 * @return the fechaDespacho
	 */
	public Date getFechaDespacho() {
		return fechaDespacho;
	}



	/**
	 * @param fechaDespacho the fechaDespacho to set
	 */
	public void setFechaDespacho(Date fechaDespacho) {
		this.fechaDespacho = fechaDespacho;
	}



	/**
	 * @return the origenProveedor
	 */
	public String getOrigenProveedor() {
		return origenProveedor;
	}



	/**
	 * @param origenProveedor the origenProveedor to set
	 */
	public void setOrigenProveedor(String origenProveedor) {
		this.origenProveedor = origenProveedor;
	}

}
