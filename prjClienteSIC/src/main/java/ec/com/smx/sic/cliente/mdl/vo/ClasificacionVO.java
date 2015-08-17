package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.ClasificacionRelacionadaDTO;

@SuppressWarnings("serial")
public class ClasificacionVO extends BaseVO<ClasificacionDTO>{

	private ClasificacionDTO clasificacionPadreDTO;
	private Boolean mostrarBusqueda = Boolean.TRUE;
	private Boolean subClaSelected = Boolean.FALSE;
	private ClasificacionDTO clasificacionEstructuraCliente;
	private Collection<ClasificacionRelacionadaDTO> clasificacionEstructura;
	private String tipoEstructura;
	
	/**
	 * @return the clasificacionPadreDTO
	 */
	public ClasificacionDTO getClasificacionPadreDTO() {
		return clasificacionPadreDTO;
	}

	/**
	 * @param clasificacionPadreDTO the clasificacionPadreDTO to set
	 */
	public void setClasificacionPadreDTO(ClasificacionDTO clasificacionPadreDTO) {
		this.clasificacionPadreDTO = clasificacionPadreDTO;
	}

	/**
	 * @return the mostrarBusqueda
	 */
	public Boolean getMostrarBusqueda() {
		return mostrarBusqueda;
	}

	/**
	 * @param mostrarBusqueda the mostrarBusqueda to set
	 */
	public void setMostrarBusqueda(Boolean mostrarBusqueda) {
		this.mostrarBusqueda = mostrarBusqueda;
	}

	/**
	 * @return the subClaSelected
	 */
	public Boolean getSubClaSelected() {
		return subClaSelected;
	}

	/**
	 * @param subClaSelected the subClaSelected to set
	 */
	public void setSubClaSelected(Boolean subClaSelected) {
		this.subClaSelected = subClaSelected;
	}

	public ClasificacionDTO getClasificacionEstructuraCliente() {
		return clasificacionEstructuraCliente;
	}

	public void setClasificacionEstructuraCliente(ClasificacionDTO clasificacionEstructuraCliente) {
		this.clasificacionEstructuraCliente = clasificacionEstructuraCliente;
	}

	

	public Collection<ClasificacionRelacionadaDTO> getClasificacionEstructura() {
		return clasificacionEstructura;
	}

	public void setClasificacionEstructura(Collection<ClasificacionRelacionadaDTO> clasificacionEstructura) {
		this.clasificacionEstructura = clasificacionEstructura;
	}

	public String getTipoEstructura() {
		return tipoEstructura;
	}

	public void setTipoEstructura(String tipoEstructura) {
		this.tipoEstructura = tipoEstructura;
	}
	
	
	
}
