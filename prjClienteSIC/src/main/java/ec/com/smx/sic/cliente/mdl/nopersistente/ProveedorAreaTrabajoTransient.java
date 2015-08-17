package ec.com.smx.sic.cliente.mdl.nopersistente;

import ec.com.smx.sic.cliente.common.cambioprecios.beans.BaseComparator;

/**
 * 
 * @author ivasquez
 *
 */

@SuppressWarnings("serial")
public class ProveedorAreaTrabajoTransient extends BaseComparator {

	private Boolean seleccionar;

	
	/*
	 * GETTERS ANS SETTERS
	 */
	
	/**
	 * @return the seleccionar
	 */
	public Boolean getSeleccionar() {
		return seleccionar;
	}

	/**
	 * @param seleccionar the seleccionar to set
	 */
	public void setSeleccionar(Boolean seleccionar) {
		this.seleccionar = seleccionar;
	}
}