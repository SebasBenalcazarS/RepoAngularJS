/** ec.com.smx.sic.cliente.mdl.dto.id
 * VistaSubBodegaProveedorID.java
 * @author srodriguez
 * 9/3/2015
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author srodriguez
 *
 */
@SuppressWarnings("serial")
@Embeddable
public class VistaSubBodegaProveedorID implements Serializable{
	
	/** Variable del tipo Integer VistaSubBodegaProveedorID.java
	 * @author srodriguez
	 * 9/3/2015
	 */
	private Integer codigoCompania;
	
	/** Variable del tipo String VistaSubBodegaProveedorID.java
	 * @author srodriguez
	 * 9/3/2015
	 */
	private String codigoBodega;

	/** Metodo que retorna codigoCompania del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @return Integer codigoCompania 
	 */
	public Integer getCodigoCompania() {
		return codigoCompania;
	}

	/** Metodo que asigna el valor codigoCompania en codigoCompania del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @param codigoCompania
	 */
	
	public void setCodigoCompania(Integer codigoCompania) {
		this.codigoCompania = codigoCompania;
	}

	/** Metodo que retorna codigoBodega del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @return String codigoBodega 
	 */
	public String getCodigoBodega() {
		return codigoBodega;
	}

	/** Metodo que asigna el valor codigoBodega en codigoBodega del objeto
	 * @author srodriguez
	 * 9/3/2015
	 * @param codigoBodega
	 */
	
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}

	/* Metodo de implementacion de hashCode de VistaSubBodegaProveedorID.java
	 * @author srodriguez
	 * 9/3/2015
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoBodega == null) ? 0 : codigoBodega.hashCode());
		result = prime * result + ((codigoCompania == null) ? 0 : codigoCompania.hashCode());
		return result;
	}

	/* Metodo de implementacion de equals de VistaSubBodegaProveedorID.java
	 * @author srodriguez
	 * 9/3/2015
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
		VistaSubBodegaProveedorID other = (VistaSubBodegaProveedorID) obj;
		if (codigoBodega == null) {
			if (other.codigoBodega != null)
				return false;
		} else if (!codigoBodega.equals(other.codigoBodega))
			return false;
		if (codigoCompania == null) {
			if (other.codigoCompania != null)
				return false;
		} else if (!codigoCompania.equals(other.codigoCompania))
			return false;
		return true;
	}
}
