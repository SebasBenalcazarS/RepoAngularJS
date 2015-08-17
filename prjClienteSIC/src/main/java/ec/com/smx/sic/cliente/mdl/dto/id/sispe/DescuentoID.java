/*
 * Creado el 15/06/2006
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de código - Plantillas de código
 */
package ec.com.smx.sic.cliente.mdl.dto.id.sispe;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import ec.com.kruger.utilitario.dao.commons.annotations.SequenceDataBaseValue;
import ec.com.smx.sic.cliente.common.SICConstantes;
import ec.com.smx.sic.cliente.persistencia.secuencia.DescriptorSecuenciasSIC;

/**
 * @author walvarez
 * 
 */
@SuppressWarnings("serial")
@Embeddable
public class DescuentoID extends BaseID {

	@Column(name = "CODIGOCOMPANIA")
	private Integer codigoCompania;

	@Column(name = "CODIGODESCUENTO")
	@SequenceDataBaseValue(name="SECDES",descriptorClass=DescriptorSecuenciasSIC.class)
	private String codigoDescuento;

	
	public DescuentoID() { }
	
	public DescuentoID (Boolean initID) {
		if(initID){
			this.codigoCompania = Integer.valueOf(SICConstantes.getInstancia().VALOR_INICIAL_ID);
			this.codigoDescuento = SICConstantes.getInstancia().VALOR_INICIAL_ID;
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
	 * @return Devuelve codigoDescuento.
	 */
	public String getCodigoDescuento() {
		return codigoDescuento;
	}

	/**
	 * @param codigoDescuento
	 *            El codigoDescuento a establecer.
	 */
	public void setCodigoDescuento(String codigoDescuento) {
		this.codigoDescuento = codigoDescuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		result = prime * result
				+ ((codigoDescuento == null) ? 0 : codigoDescuento.hashCode());
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
		DescuentoID other = (DescuentoID) obj;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		if (codigoDescuento == null) {
			if (other.codigoDescuento != null)
				return false;
		} else if (!codigoDescuento.equals(other.codigoDescuento))
			return false;
		return true;
	}
}
