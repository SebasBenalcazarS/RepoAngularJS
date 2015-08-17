/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto.id;

import ec.com.kruger.utilitario.dao.commons.dto.id.BaseID;

/**
 * @author wcaiza
 *
 */
@SuppressWarnings("serial")
public class VistaPalletsRecepcionPesoID extends BaseID {
	
	private Long codigoTarea;
	private Long codigoDatosTarea;
	
	/**
	 * @return the codigoTarea
	 */
	public Long getCodigoTarea() {
		return codigoTarea;
	}

	/**
	 * @param codigoTarea the codigoTarea to set
	 */
	public void setCodigoTarea(Long codigoTarea) {
		this.codigoTarea = codigoTarea;
	}

	/**
	 * @return the codigoDatosTarea
	 */
	public Long getCodigoDatosTarea() {
		return codigoDatosTarea;
	}

	/**
	 * @param codigoDatosTarea the codigoDatosTarea to set
	 */
	public void setCodigoDatosTarea(Long codigoDatosTarea) {
		this.codigoDatosTarea = codigoDatosTarea;
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
		VistaPalletsRecepcionPesoID other = (VistaPalletsRecepcionPesoID) obj;
		if (codigoDatosTarea == null) {
			if (other.codigoDatosTarea != null)
				return false;
		} else if (!codigoDatosTarea.equals(other.codigoDatosTarea))
			return false;
		if (codigoTarea == null) {
			if (other.codigoTarea != null)
				return false;
		} else if (!codigoTarea.equals(other.codigoTarea))
			return false;
		return true;
	}


}
