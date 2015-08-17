/**
 * 
 */
package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Collection;
import java.util.Map;

import ec.com.kruger.utilitario.dao.commons.dto.BaseVO;
import ec.com.smx.corpv2.dto.FuncionarioDTO;
import ec.com.smx.sic.cliente.mdl.dto.LogProcesosMigracionDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class AdminLogsProcesosMigracionVO extends BaseVO<LogProcesosMigracionDTO>{

	private LogProcesosMigracionDTO logProcesosMigracionPlantilla;

	//Opcion y sistema en el que se encuentra el usuario
	private String accessItemId;
	private String systemId;
	private FuncionarioDTO funcionario ;
	private Integer currentPage;
	private String vista;
	private String imageSort = "unsorted";
	private String sortBy;

	//Relaciones 
	private Collection<LogProcesosMigracionDTO> logProcesosMigracionDTOCol;
	
	//Si el valor de la consulta de orden de compra es diferente de nulo y mayor a cero, se vuelve a consultar.
	private Integer valorConsulta ;
	private Map<String, Object> filtrosMap ;

	
	/* GETTERS AND SETTERS */

	public LogProcesosMigracionDTO getLogProcesosMigracionPlantilla() {
		return logProcesosMigracionPlantilla;
	}

	public void setLogProcesosMigracionPlantilla(LogProcesosMigracionDTO logProcesosMigracionPlantilla) {
		this.logProcesosMigracionPlantilla = logProcesosMigracionPlantilla;
	}

	/**
	 * @return the currentPage
	 */
	public Integer getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the logProcesosMigracionDTOCol
	 */
	public Collection<LogProcesosMigracionDTO> getLogProcesosMigracionDTOCol() {
		return logProcesosMigracionDTOCol;
	}

	/**
	 * @param logProcesosMigracionDTOCol the logProcesosMigracionDTOCol to set
	 */
	public void setLogProcesosMigracionDTOCol(Collection<LogProcesosMigracionDTO> logProcesosMigracionDTOCol) {
		this.logProcesosMigracionDTOCol = logProcesosMigracionDTOCol;
	}

	/**
	 * @return the valorConsulta
	 */
	public Integer getValorConsulta() {
		return valorConsulta;
	}

	/**
	 * @param valorConsulta the valorConsulta to set
	 */
	public void setValorConsulta(Integer valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	/**
	 * @return the filtrosMap
	 */
	public Map<String, Object> getFiltrosMap() {
		return filtrosMap;
	}

	/**
	 * @param filtrosMap the filtrosMap to set
	 */
	public void setFiltrosMap(Map<String, Object> filtrosMap) {
		this.filtrosMap = filtrosMap;
	}

	/**
	 * @return the vista
	 */
	public String getVista() {
		return vista;
	}

	/**
	 * @param vista the vista to set
	 */
	public void setVista(String vista) {
		this.vista = vista;
	}

	/**
	 * @return the accessItemId
	 */
	public String getAccessItemId() {
		return accessItemId;
	}

	/**
	 * @param accessItemId the accessItemId to set
	 */
	public void setAccessItemId(String accessItemId) {
		this.accessItemId = accessItemId;
	}

	/**
	 * @return the systemId
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	/**
	 * @return the funcionario
	 */
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario the funcionario to set
	 */
	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the imageSort
	 */
	public String getImageSort() {
		return imageSort;
	}

	/**
	 * @param imageSort the imageSort to set
	 */
	public void setImageSort(String imageSort) {
		this.imageSort = imageSort;
	}

	/**
	 * @return the sortBy
	 */
	public String getSortBy() {
		return sortBy;
	}

	/**
	 * @param sortBy the sortBy to set
	 */
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	
}
