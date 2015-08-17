/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;

/**
 * @author jvillacis
 *
 */
public class DatosBusquedaAreaTrabajoEST {
	
	private Collection<AreaTrabajoDTO> cdsUsuarioCollection;
	private Collection<AreaSublugarTrabajoDTO> bodegasUsuarioCollection;
	private Collection<AreaSublugarTrabajoDTO> subbodegasUsuarioCollection;
	
	private AreaTrabajoDTO centroDistribucionSelect;
	private AreaTrabajoDTO bodegaSelect;
	private AreaTrabajoDTO subbodegaSelect;
	private AreaTrabajoDTO localSelect;
	
	
	/**
	 * @return the cdsUsuarioCollection
	 */
	public Collection<AreaTrabajoDTO> getCdsUsuarioCollection() {
		return cdsUsuarioCollection;
	}
	/**
	 * @param cdsUsuarioCollection the cdsUsuarioCollection to set
	 */
	public void setCdsUsuarioCollection(Collection<AreaTrabajoDTO> cdsUsuarioCollection) {
		this.cdsUsuarioCollection = cdsUsuarioCollection;
	}
	/**
	 * @return the bodegasUsuarioCollection
	 */
	public Collection<AreaSublugarTrabajoDTO> getBodegasUsuarioCollection() {
		return bodegasUsuarioCollection;
	}
	/**
	 * @param bodegasUsuarioCollection the bodegasUsuarioCollection to set
	 */
	public void setBodegasUsuarioCollection(Collection<AreaSublugarTrabajoDTO> bodegasUsuarioCollection) {
		this.bodegasUsuarioCollection = bodegasUsuarioCollection;
	}
	/**
	 * @return the subbodegasUsuarioCollection
	 */
	public Collection<AreaSublugarTrabajoDTO> getSubbodegasUsuarioCollection() {
		return subbodegasUsuarioCollection;
	}
	/**
	 * @param subbodegasUsuarioCollection the subbodegasUsuarioCollection to set
	 */
	public void setSubbodegasUsuarioCollection(Collection<AreaSublugarTrabajoDTO> subbodegasUsuarioCollection) {
		this.subbodegasUsuarioCollection = subbodegasUsuarioCollection;
	}
	/**
	 * @return the centroDistribucionSelect
	 */
	public AreaTrabajoDTO getCentroDistribucionSelect() {
		return centroDistribucionSelect;
	}
	/**
	 * @param centroDistribucionSelect the centroDistribucionSelect to set
	 */
	public void setCentroDistribucionSelect(AreaTrabajoDTO centroDistribucionSelect) {
		this.centroDistribucionSelect = centroDistribucionSelect;
	}
	/**
	 * @return the bodegaSelect
	 */
	public AreaTrabajoDTO getBodegaSelect() {
		return bodegaSelect;
	}
	/**
	 * @param bodegaSelect the bodegaSelect to set
	 */
	public void setBodegaSelect(AreaTrabajoDTO bodegaSelect) {
		this.bodegaSelect = bodegaSelect;
	}
	/**
	 * @return the subbodegaSelect
	 */
	public AreaTrabajoDTO getSubbodegaSelect() {
		return subbodegaSelect;
	}
	/**
	 * @param subbodegaSelect the subbodegaSelect to set
	 */
	public void setSubbodegaSelect(AreaTrabajoDTO subbodegaSelect) {
		this.subbodegaSelect = subbodegaSelect;
	}
	/**
	 * @return the localSelect
	 */
	public AreaTrabajoDTO getLocalSelect() {
		return localSelect;
	}
	/**
	 * @param localSelect the localSelect to set
	 */
	public void setLocalSelect(AreaTrabajoDTO localSelect) {
		this.localSelect = localSelect;
	}

}
