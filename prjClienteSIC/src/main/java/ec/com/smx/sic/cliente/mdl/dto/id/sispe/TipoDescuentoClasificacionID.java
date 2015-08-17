/*
 * Creado el 19/09/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.smx.sic.cliente.common.SICConstantes;

/**
 * @author walvarez
 * @author osaransig
 *    
 */
@SuppressWarnings("serial")
@Embeddable
public class TipoDescuentoClasificacionID extends BaseID {

	
	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	@Column(name = "CODIGOTIPODESCUENTO")
	private String codigoTipoDescuento;

	@Column(name = "CODIGOCLASIFICACION")
	private String codigoClasificacion;

	public TipoDescuentoClasificacionID () {  }
	
	public TipoDescuentoClasificacionID (Boolean valor) {
		if(valor){
			this.codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			this.codigoTipoDescuento = SICConstantes.getInstancia().VALOR_INICIAL_ID;
			this.codigoClasificacion = SICConstantes.getInstancia().VALOR_INICIAL_ID;
		}
	}
	
	/**
	 * @return Devuelve codigoCompania.
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/**
	 * @param codigoCompania
	 *            El codigoCompania a establecer.
	 */
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/**
	 * @return Devuelve codigoClasificacion.
	 */
	public String getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * @param codigoClasificacion
	 *            El codigoClasificacion a establecer.
	 */
	public void setCodigoClasificacion(String codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * @return Devuelve codigoTipoDescuento.
	 */
	public String getCodigoTipoDescuento() {
		return codigoTipoDescuento;
	}

	/**
	 * @param codigoTipoDescuento
	 *            El codigoTipoDescuento a establecer.
	 */
	public void setCodigoTipoDescuento(String codigoTipoDescuento) {
		this.codigoTipoDescuento = codigoTipoDescuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((codigoClasificacion == null) ? 0 : codigoClasificacion
						.hashCode());
		result = prime * result
				+ ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime
				* result
				+ ((codigoTipoDescuento == null) ? 0 : codigoTipoDescuento
						.hashCode());
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
		TipoDescuentoClasificacionID other = (TipoDescuentoClasificacionID) obj;
		if (codigoClasificacion == null) {
			if (other.codigoClasificacion != null)
				return false;
		} else if (!codigoClasificacion.equals(other.codigoClasificacion))
			return false;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoTipoDescuento == null) {
			if (other.codigoTipoDescuento != null)
				return false;
		} else if (!codigoTipoDescuento.equals(other.codigoTipoDescuento))
			return false;
		return true;
	}
}
