package ec.com.smx.sic.cliente.mdl.nopersistente;

import ec.com.kruger.utilitario.dao.commons.dto.SimpleAuditDTO;
import ec.com.smx.sic.cliente.mdl.dto.BodegaDTO;

@SuppressWarnings("serial")
public class RecepcionProveedorTransientDTO extends SimpleAuditDTO {
	private BodegaDTO bodegaDTO; 
	private BodegaDTO subBodegaDTO;
	/**
	 * @return the bodegaDTO
	 */
	public BodegaDTO getBodegaDTO() {
		return bodegaDTO;
	}
	/**
	 * @param bodegaDTO the bodegaDTO to set
	 */
	public void setBodegaDTO(BodegaDTO bodegaDTO) {
		this.bodegaDTO = bodegaDTO;
	}
	/**
	 * @return the subBodegaDTO
	 */
	public BodegaDTO getSubBodegaDTO() {
		return subBodegaDTO;
	}
	/**
	 * @param subBodegaDTO the subBodegaDTO to set
	 */
	public void setSubBodegaDTO(BodegaDTO subBodegaDTO) {
		this.subBodegaDTO = subBodegaDTO;
	}
	
}
