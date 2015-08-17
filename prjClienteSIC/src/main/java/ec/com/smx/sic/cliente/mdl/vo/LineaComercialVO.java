package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.HashMap;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.DynamicCriteriaRestriction;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClasificacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialClienteImportacionDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaComercialFuncionarioDTO;

/**
 * 
 * @author fcollaguazo
 *
 */
@SuppressWarnings("serial")
public class LineaComercialVO extends BaseVO<LineaComercialDTO>{
	
	private Boolean contarSubLineas = Boolean.FALSE;
	private String estadoSubLineas;
	private Collection<LineaComercialDTO> lineaComercialCol;
	private String mensajeCabecera;
	private String mensajeConfirmacion;
	private String columnaLineaSublinea;
	private Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol;
	private Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioCol;
	private Collection<LineaComercialClienteImportacionDTO> lineaComercialClienteImportacionDTOCol;
	private Boolean busquedaSinFiltros = Boolean.FALSE;
	private String render;
	
	HashMap<String, DynamicCriteriaRestriction> hasMapCriteriaRestriction = null;

	/**
	 * @return the hasMapCriteriaRestriction
	 */
	public HashMap<String, DynamicCriteriaRestriction> getHasMapCriteriaRestriction() {
		return hasMapCriteriaRestriction;
	}

	/**
	 * @param hasMapCriteriaRestriction the hasMapCriteriaRestriction to set
	 */
	public void setHasMapCriteriaRestriction(HashMap<String, DynamicCriteriaRestriction> hasMapCriteriaRestriction) {
		this.hasMapCriteriaRestriction = hasMapCriteriaRestriction;
	}

	/**
	 * @return the contarSubLineas
	 */
	public Boolean getContarSubLineas() {
		return contarSubLineas;
	}

	/**
	 * @param contarSubLineas the contarSubLineas to set
	 */
	public void setContarSubLineas(Boolean contarSubLineas) {
		this.contarSubLineas = contarSubLineas;
	}

	/**
	 * @return the estadoSubLineas
	 */
	public String getEstadoSubLineas() {
		return estadoSubLineas;
	}

	/**
	 * @param estadoSubLineas the estadoSubLineas to set
	 */
	public void setEstadoSubLineas(String estadoSubLineas) {
		this.estadoSubLineas = estadoSubLineas;
	}

	/**
	 * @return the lineaComercialCol
	 */
	public Collection<LineaComercialDTO> getLineaComercialCol() {
		return lineaComercialCol;
	}

	/**
	 * @param lineaComercialCol the lineaComercialCol to set
	 */
	public void setLineaComercialCol(Collection<LineaComercialDTO> lineaComercialCol) {
		this.lineaComercialCol = lineaComercialCol;
	}

	/**
	 * @return the mensajeConfirmacion
	 */
	public String getMensajeConfirmacion() {
		return mensajeConfirmacion;
	}

	/**
	 * @param mensajeConfirmacion the mensajeConfirmacion to set
	 */
	public void setMensajeConfirmacion(String mensajeConfirmacion) {
		this.mensajeConfirmacion = mensajeConfirmacion;
	}

	/**
	 * @return the lineaComercialClasificacionCol
	 */
	public Collection<LineaComercialClasificacionDTO> getLineaComercialClasificacionCol() {
		return lineaComercialClasificacionCol;
	}

	/**
	 * @param lineaComercialClasificacionCol the lineaComercialClasificacionCol to set
	 */
	public void setLineaComercialClasificacionCol(Collection<LineaComercialClasificacionDTO> lineaComercialClasificacionCol) {
		this.lineaComercialClasificacionCol = lineaComercialClasificacionCol;
	}

	/**
	 * @return the mensajeCabecera
	 */
	public String getMensajeCabecera() {
		return mensajeCabecera;
	}

	/**
	 * @param mensajeCabecera the mensajeCabecera to set
	 */
	public void setMensajeCabecera(String mensajeCabecera) {
		this.mensajeCabecera = mensajeCabecera;
	}

	/**
	 * @return the busquedaSinFiltros
	 */
	public Boolean getBusquedaSinFiltros() {
		return busquedaSinFiltros;
	}

	/**
	 * @param busquedaSinFiltros the busquedaSinFiltros to set
	 */
	public void setBusquedaSinFiltros(Boolean busquedaSinFiltros) {
		this.busquedaSinFiltros = busquedaSinFiltros;
	}

	public String getColumnaLineaSublinea() {
		return columnaLineaSublinea;
	}

	public void setColumnaLineaSublinea(String columnaLineaSublinea) {
		this.columnaLineaSublinea = columnaLineaSublinea;
	}

	/**
	 * @return the lineaComercialFuncionarioCol
	 */
	public Collection<LineaComercialFuncionarioDTO> getLineaComercialFuncionarioCol() {
		return lineaComercialFuncionarioCol;
	}

	/**
	 * @param lineaComercialFuncionarioCol the lineaComercialFuncionarioCol to set
	 */
	public void setLineaComercialFuncionarioCol(Collection<LineaComercialFuncionarioDTO> lineaComercialFuncionarioCol) {
		this.lineaComercialFuncionarioCol = lineaComercialFuncionarioCol;
	}



	/**
	 * @return the lineaComercialClienteImportacionDTOCol
	 */
	public Collection<LineaComercialClienteImportacionDTO> getLineaComercialClienteImportacionDTOCol() {
		return lineaComercialClienteImportacionDTOCol;
	}

	/**
	 * @param lineaComercialClienteImportacionDTOCol the lineaComercialClienteImportacionDTOCol to set
	 */
	public void setLineaComercialClienteImportacionDTOCol(Collection<LineaComercialClienteImportacionDTO> lineaComercialClienteImportacionDTOCol) {
		this.lineaComercialClienteImportacionDTOCol = lineaComercialClienteImportacionDTOCol;
	}

	/**
	 * @return the render
	 */
	public String getRender() {
		return render;
	}

	/**
	 * @param render the render to set
	 */
	public void setRender(String render) {
		this.render = render;
	}
	
}
