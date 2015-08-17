package ec.com.smx.sic.cliente.mdl.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.CatalogoValorDTO;
import ec.com.smx.sic.cliente.mdl.dto.ArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueArticuloDTO;
import ec.com.smx.sic.cliente.mdl.dto.LineaEmpaqueDTO;

/**
 * @author Schubert Rodriguez
 */

@SuppressWarnings("serial")
public class ArticuloLineaEmpaqueVO extends BaseVO<LineaEmpaqueDTO> {
	private LineaEmpaqueDTO lineaEmpaqueDTO;
	private CatalogoValorDTO catalogovalorDTO;
	private LineaEmpaqueArticuloDTO lineaEmpaqueArticuloDTO;
	private Collection<LineaEmpaqueArticuloDTO> listaLineaEmpaqueArticuloDTO;
	private Collection<ArticuloDTO> listaArticuloDTO;
	private Collection<LineaEmpaqueDTO> lineasEmpaqueDisponibles;
	private Collection<LineaEmpaqueArticuloDTO> lineasEmpaqueArticuloAsignadas;
	private Collection<LineaEmpaqueArticuloDTO> listaLineasEmpaqueArticuloRelacionados;
	private Map<String, Collection<LineaEmpaqueArticuloDTO>> mapaArticuloLineas;
	/**
	 * Constructor Limpio del objeto
	 */
	public ArticuloLineaEmpaqueVO() {
		super();
		this.setLineaEmpaqueDTO(new LineaEmpaqueDTO());
		this.setLineaEmpaqueArticuloDTO(new LineaEmpaqueArticuloDTO());
		this.setListaArticuloDTO(new ArrayList<ArticuloDTO>());
		this.setListaLineaEmpaqueArticuloDTO(new ArrayList<LineaEmpaqueArticuloDTO>());
		this.setMapaArticuloLineas(new HashMap<String, Collection<LineaEmpaqueArticuloDTO>>());
		this.setListaLineasEmpaqueArticuloRelacionados(new ArrayList<LineaEmpaqueArticuloDTO>());
		this.setLineasEmpaqueDisponibles(new ArrayList<LineaEmpaqueDTO>());
		this.setLineasEmpaqueArticuloAsignadas(new ArrayList<LineaEmpaqueArticuloDTO>());
		this.setLineasEmpaqueDisponibles(new ArrayList<LineaEmpaqueDTO>());
	}
	
	/*
	 * Constructor Limpio del objeto linea empaque como parametro
	 */
	public ArticuloLineaEmpaqueVO(LineaEmpaqueDTO dto) {
		super();
		this.setLineaEmpaqueDTO(dto);
		this.setListaArticuloDTO(new ArrayList<ArticuloDTO>());
		this.setListaLineaEmpaqueArticuloDTO(new ArrayList<LineaEmpaqueArticuloDTO>());
	}
	
	


	/**
	 * Método Getter del campo lineaEmpaqueDTO
	 * 
	 * @return the lineaEmpaqueDTO
	 */
	public LineaEmpaqueDTO getLineaEmpaqueDTO() {
		return lineaEmpaqueDTO;
	}

	/**
	 * Método Setter the lineaEmpaqueDTO
	 * 
	 * @param lineaEmpaqueDTO
	 *            the lineaEmpaqueDTO to set
	 */
	public void setLineaEmpaqueDTO(LineaEmpaqueDTO lineaEmpaqueDTO) {
		this.lineaEmpaqueDTO = lineaEmpaqueDTO;
	}

	/**
	 * Método Getter del campo catalogovalorDTO
	 * 
	 * @return the catalogovalorDTO
	 */
	public CatalogoValorDTO getCatalogovalorDTO() {
		return catalogovalorDTO;
	}

	/**
	 * Método Setter the catalogovalorDTO
	 * 
	 * @param catalogovalorDTO
	 *            the catalogovalorDTO to set
	 */
	public void setCatalogovalorDTO(CatalogoValorDTO catalogovalorDTO) {
		this.catalogovalorDTO = catalogovalorDTO;
	}

	/**
	 * Método Getter del campo listaLineaEmpaqueArticuloDTO
	 * 
	 * @return the listaLineaEmpaqueArticuloDTO
	 */
	public Collection<LineaEmpaqueArticuloDTO> getListaLineaEmpaqueArticuloDTO() {
		return listaLineaEmpaqueArticuloDTO;
	}

	/**
	 * Método Setter the listaLineaEmpaqueArticuloDTO
	 * 
	 * @param listaLineaEmpaqueArticuloDTO
	 *            the listaLineaEmpaqueArticuloDTO to set
	 */
	public void setListaLineaEmpaqueArticuloDTO(Collection<LineaEmpaqueArticuloDTO> listaLineaEmpaqueArticuloDTO) {
		this.listaLineaEmpaqueArticuloDTO = listaLineaEmpaqueArticuloDTO;
	}

	/**
	 * Método Getter del campo listaArticuloDTO
	 * 
	 * @return the listaArticuloDTO
	 */
	public Collection<ArticuloDTO> getListaArticuloDTO() {
		return listaArticuloDTO;
	}

	/**
	 * Método Setter the listaArticuloDTO
	 * 
	 * @param listaArticuloDTO
	 *            the listaArticuloDTO to set
	 */
	public void setListaArticuloDTO(Collection<ArticuloDTO> listaArticuloDTO) {
		this.listaArticuloDTO = listaArticuloDTO;
	}

	/**
	 * Método Getter del campo lineaEmpaqueArticuloDTO
	 * @return the lineaEmpaqueArticuloDTO
	 */
	public LineaEmpaqueArticuloDTO getLineaEmpaqueArticuloDTO() {
		return lineaEmpaqueArticuloDTO;
	}

	/**
	 * Método Setter the lineaEmpaqueArticuloDTO
	 * @param lineaEmpaqueArticuloDTO the lineaEmpaqueArticuloDTO to set
	 */
	public void setLineaEmpaqueArticuloDTO(LineaEmpaqueArticuloDTO lineaEmpaqueArticuloDTO) {
		this.lineaEmpaqueArticuloDTO = lineaEmpaqueArticuloDTO;
	}

	/**
	 * Método Getter del campo listaLineasEmpaqueArticuloRelacionados
	 * @return the listaLineasEmpaqueArticuloRelacionados
	 */
	public Collection<LineaEmpaqueArticuloDTO> getListaLineasEmpaqueArticuloRelacionados() {
		return listaLineasEmpaqueArticuloRelacionados;
	}

	/**
	 * Método Setter the listaLineasEmpaqueArticuloRelacionados
	 * @param listaLineasEmpaqueArticuloRelacionados the listaLineasEmpaqueArticuloRelacionados to set
	 */
	public void setListaLineasEmpaqueArticuloRelacionados(Collection<LineaEmpaqueArticuloDTO> listaLineasEmpaqueArticuloRelacionados) {
		this.listaLineasEmpaqueArticuloRelacionados = listaLineasEmpaqueArticuloRelacionados;
	}

	/**
	 * Método Setter the lineasEmpaqueDisponibles
	 * @param lineasEmpaqueDisponibles the lineasEmpaqueDisponibles to set
	 */
	public void setLineasEmpaqueDisponibles(Collection<LineaEmpaqueDTO> lineasEmpaqueDisponibles) {
		this.lineasEmpaqueDisponibles = lineasEmpaqueDisponibles;
	}

	/**
	 * Método Getter del campo lineasEmpaqueArticuloAsignadas
	 * @return the lineasEmpaqueArticuloAsignadas
	 */
	public Collection<LineaEmpaqueArticuloDTO> getLineasEmpaqueArticuloAsignadas() {
		return lineasEmpaqueArticuloAsignadas;
	}

	/**
	 * Método Setter the lineasEmpaqueArticuloAsignadas
	 * @param lineasEmpaqueArticuloAsignadas the lineasEmpaqueArticuloAsignadas to set
	 */
	public void setLineasEmpaqueArticuloAsignadas(Collection<LineaEmpaqueArticuloDTO> lineasEmpaqueArticuloAsignadas) {
		this.lineasEmpaqueArticuloAsignadas = lineasEmpaqueArticuloAsignadas;
	}

	/**
	 * Método Getter del campo mapaArticuloLineas
	 * @return the mapaArticuloLineas
	 */
	public Map<String, Collection<LineaEmpaqueArticuloDTO>> getMapaArticuloLineas() {
		return mapaArticuloLineas;
	}

	/**
	 * Método Setter the mapaArticuloLineas
	 * @param mapaArticuloLineas the mapaArticuloLineas to set
	 */
	public void setMapaArticuloLineas(Map<String, Collection<LineaEmpaqueArticuloDTO>> mapaArticuloLineas) {
		this.mapaArticuloLineas = mapaArticuloLineas;
	}

	/**
	 * Método Getter del campo lineasEmpaqueDisponibles
	 * @return the lineasEmpaqueDisponibles
	 */
	public Collection<LineaEmpaqueDTO> getLineasEmpaqueDisponibles() {
		return lineasEmpaqueDisponibles;
	}

	

}
