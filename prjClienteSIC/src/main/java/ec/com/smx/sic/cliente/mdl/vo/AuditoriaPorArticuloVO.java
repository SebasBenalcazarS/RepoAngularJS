package ec.com.smx.sic.cliente.mdl.vo;

import java.util.Date;
import java.util.HashMap;

import ec.com.kruger.utilitario.dao.commons.constants.BooleanClauseEnum;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.enumeration.ComparatorTypeEnum;
import ec.com.smx.frameworkv2.security.dto.UserDto;
import ec.com.smx.sic.cliente.common.busqueda.bean.PlantillaBusquedaBodega;

public class AuditoriaPorArticuloVO {
	private Date fechaInicio;
	private Date fechaFin;
	private String codigoBarrasArticulo;
	private String descripcionArticulo;
	private String estado;
	private HashMap<String, Object> filtrosMap;
	private Integer compania;
	private String codigoFuncionario;
	private UserDto userDTO;
	private Integer firstResult;
	private Integer maxResults;
	private PlantillaBusquedaBodega plantillaBusquedaBodega;
	private ComparatorTypeEnum competorTypeEnum;
	private Integer[] paremeterValues;
	private BooleanClauseEnum booleanClauseEnum;
	private SearchTemplateDTO<String> numeroPedidoAsisitidoFilTemplate;
	private SearchTemplateDTO<Integer> localesFilTemplate;
	private SearchTemplateDTO<String> nombreFuncionarioFilTemplate;
	private SearchTemplateDTO<String> nombreLocalesFilTemplate;
	private SearchTemplateDTO<String> idUsuarioTemplate;
	private String imageSort = "unsorted";
	private String sortBy;
	private Boolean ordenaTabla;
	private Boolean perfilLocal;
	private Integer codigoLocalDefault;
	
	public AuditoriaPorArticuloVO (){
		
	}	
	
	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the codigoBarrasArticulo
	 */
	public String getCodigoBarrasArticulo() {
		return codigoBarrasArticulo;
	}
	/**
	 * @param codigoBarrasArticulo the codigoBarrasArticulo to set
	 */
	public void setCodigoBarrasArticulo(String codigoBarrasArticulo) {
		this.codigoBarrasArticulo = codigoBarrasArticulo;
	}
	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}
	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
	public void setFiltrosMap(HashMap<String, Object> hashMap) {
		this.filtrosMap = hashMap;		
	}
	
	public HashMap<String, Object> getFiltrosMap() {
		return this.filtrosMap;
	}

	public Integer getCompania() {
		return this.compania;
	}
	
	public void setCompania(Integer compania) {
		this.compania = compania;
	}



	/**
	 * @return the codigoFuncionario
	 */
	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	/**
	 * @param codigoFuncionario the codigoFuncionario to set
	 */
	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public void setUserDTO(UserDto userDto) {
		this.userDTO = userDto;		
	}
	
	public UserDto getUserDTO (){
		return this.userDTO;
	}

	public Integer getFirstResult() {
		return this.firstResult;
	}

	public Integer getMaxResults() {
		return this.maxResults;
	}

	/**
	 * @param firstResult the firstResult to set
	 */
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}

	/**
	 * @param maxResults the maxResults to set
	 */
	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	
	public PlantillaBusquedaBodega getPlantillaBusquedaBodega() {
		return plantillaBusquedaBodega;
	}

	public void setPlantillaBusquedaBodega(PlantillaBusquedaBodega plantillaBusquedaBodega) {
		this.plantillaBusquedaBodega = plantillaBusquedaBodega;
	}

	public ComparatorTypeEnum getCompetorTypeEnum() {
		return competorTypeEnum;
	}

	public void setCompetorTypeEnum(ComparatorTypeEnum competorTypeEnum) {
		this.competorTypeEnum = competorTypeEnum;
	}

	public Integer[] getParemeterValues() {
		return paremeterValues;
	}

	public void setParemeterValues(Integer[]  paremeterValues) {
		this.paremeterValues = paremeterValues;
	}

	public BooleanClauseEnum isBooleanClauseEnum() {
		return booleanClauseEnum;
	}

	public void setBooleanClauseEnum(BooleanClauseEnum booleanClauseEnum) {
		this.booleanClauseEnum = booleanClauseEnum;
	}

	public SearchTemplateDTO<String> getNumeroPedidoAsisitidoFilTemplate() {
		return numeroPedidoAsisitidoFilTemplate;
	}

	public void setNumeroPedidoAsisitidoFilTemplate(SearchTemplateDTO<String> numeroPedidoAsisitidoFilTemplate) {
		this.numeroPedidoAsisitidoFilTemplate = numeroPedidoAsisitidoFilTemplate;
	}

	public SearchTemplateDTO<Integer> getLocalesFilTemplate() {
		return localesFilTemplate;
	}

	public void setLocalesFilTemplate(SearchTemplateDTO<Integer> localesFilTemplate) {
		this.localesFilTemplate = localesFilTemplate;
	}

	public SearchTemplateDTO<String> getNombreFuncionarioFilTemplate() {
		return nombreFuncionarioFilTemplate;
	}

	public void setNombreFuncionarioFilTemplate(SearchTemplateDTO<String> nombreFuncionarioFilTemplate) {
		this.nombreFuncionarioFilTemplate = nombreFuncionarioFilTemplate;
	}

	public SearchTemplateDTO<String> getNombreLocalesFilTemplate() {
		return nombreLocalesFilTemplate;
	}

	public void setNombreLocalesFilTemplate(SearchTemplateDTO<String> nombreLocalesFilTemplate) {
		this.nombreLocalesFilTemplate = nombreLocalesFilTemplate;
	}

	public BooleanClauseEnum getBooleanClauseEnum() {
		return booleanClauseEnum;
	}

	public SearchTemplateDTO<String> getIdUsuarioTemplate() {
		return idUsuarioTemplate;
	}

	public void setIdUsuarioTemplate(SearchTemplateDTO<String> idUsuarioTemplate) {
		this.idUsuarioTemplate = idUsuarioTemplate;
	}

	public String getImageSort() {
		return imageSort;
	}

	public void setImageSort(String imageSort) {
		this.imageSort = imageSort;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public Boolean getOrdenaTabla() {
		return ordenaTabla;
	}

	public void setOrdenaTabla(Boolean ordenaTabla) {
		this.ordenaTabla = ordenaTabla;
	}

	public Boolean getPerfilLocal() {
		return perfilLocal;
	}

	public void setPerfilLocal(Boolean perfilLocal) {
		this.perfilLocal = perfilLocal;
	}

	public Integer getCodigoLocalDefault() {
		return codigoLocalDefault;
	}

	public void setCodigoLocalDefault(Integer codigoLocalDefault) {
		this.codigoLocalDefault = codigoLocalDefault;
	}

}
