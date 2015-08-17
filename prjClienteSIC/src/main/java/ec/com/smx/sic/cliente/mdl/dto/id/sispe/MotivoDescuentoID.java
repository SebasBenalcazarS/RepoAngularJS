/*
 * Creado el 16/06/2006
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
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class MotivoDescuentoID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	@Column(name = "CODIGOMOTIVODESCUENTO")
	private String codigoMotivoDescuento;

	
	
	public MotivoDescuentoID() {
		super();
	}

	
	public MotivoDescuentoID (Boolean initID) {
		if(initID){
			this.codigoCompania =  Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			this.codigoMotivoDescuento = SICConstantes.getInstancia().VALOR_INICIAL_ID;
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
	 * @return Devuelve codigoMotivoDescuento.
	 */
	public String getCodigoMotivoDescuento() {
		return codigoMotivoDescuento;
	}

	/**
	 * @param codigoMotivoDescuento
	 *            El codigoMotivoDescuento a establecer.
	 */
	public void setCodigoMotivoDescuento(String codigoMotivoDescuento) {
		this.codigoMotivoDescuento = codigoMotivoDescuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime
				* result
				+ ((codigoMotivoDescuento == null) ? 0 : codigoMotivoDescuento
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
		MotivoDescuentoID other = (MotivoDescuentoID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoMotivoDescuento == null) {
			if (other.codigoMotivoDescuento != null)
				return false;
		} else if (!codigoMotivoDescuento.equals(other.codigoMotivoDescuento))
			return false;
		return true;
	}
}
