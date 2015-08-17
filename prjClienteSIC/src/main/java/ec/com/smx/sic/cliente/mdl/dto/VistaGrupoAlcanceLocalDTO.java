/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaGrupoAlcanceLocalID;

/**
 * @author fmunoz
 *
 */

@SuppressWarnings("serial")
@Entity
@Table(name="SCSADVPROALCLOC")
public class VistaGrupoAlcanceLocalDTO extends SearchDTO{

	@EmbeddedId
	private VistaGrupoAlcanceLocalID id = new VistaGrupoAlcanceLocalID();
	
	@ComparatorTypeField
	private String areasTrabajo;

	/**
	 * @return the id
	 */
	public VistaGrupoAlcanceLocalID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(VistaGrupoAlcanceLocalID id) {
		this.id = id;
	}
	
	/**
	 * @return the areasTrabajo
	 */
	public String getAreasTrabajo() {
		return areasTrabajo;
	}
	/**
	 * @param areasTrabajo the areasTrabajo to set
	 */
	public void setAreasTrabajo(String areasTrabajo) {
		this.areasTrabajo = areasTrabajo;
	}
}
