/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import java.util.Collection;

import ec.com.smx.corpv2.dto.AreaSublugarTrabajoDTO;
import ec.com.smx.corpv2.dto.AreaTrabajoDTO;

/**
 * @author bsandoval
 *
 */
public class DatosBusquedaPedidoAsistidoWS {
	
	private Collection<AreaTrabajoDTO> cdsUsuarioCollection;
	private Collection<AreaSublugarTrabajoDTO> bodegasUsuarioCollection;
	private Collection<AreaSublugarTrabajoDTO> subbodegasUsuarioCollection;
	
	private AreaTrabajoDTO subbodegaSelect;
	private Integer cdDefault;
	

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
	public Integer getCdDefault() {
		return cdDefault;
	}
	public void setCdDefault(Integer cdDefault) {
		this.cdDefault = cdDefault;
	}
	

}
