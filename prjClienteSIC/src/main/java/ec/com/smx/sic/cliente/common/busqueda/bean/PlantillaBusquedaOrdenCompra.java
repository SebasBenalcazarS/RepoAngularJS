package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;
import ec.com.smx.sic.cliente.mdl.dto.OrdenCompraEstadoDTO;
/**
 * 
 * @author amunoz
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaOrdenCompra extends BaseSearchTemplate{

	public PlantillaBusquedaOrdenCompra(Integer codigoCompania) {
		super(codigoCompania);
	}
	private SearchTemplateDTO<String> numeroOrdComFil;
	private SearchTemplateDTO<Integer> areaTrabajoFil;
	private SearchTemplateDTO<String> tipoOrdComFil;
	private SearchTemplateDTO<String> estadoOrdComFil;
	private OrdenCompraEstadoDTO ordenCompraEstadoPlaBus= null;
	private PlantillaBusquedaBodega plantillaBusquedaBodega = null;
	private SearchTemplateDTO<String> nombreFuncionarioFil;
	
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoEstadoOrdenCompra;
	
	//RELACIONES PEDIDO
	@ComparatorTypeField
	private Collection<String> codigoComprador;
	//@ComparatorTypeField
	//private String codigoBodega;
	/*@ComparatorTypeField
	private String codigoTipoCatVal;
	//ORDEN COMPRA ESTADO
	@ComparatorTypeField
	private String codigoEstadoCatVal;*/
	@ComparatorTypeField	 
	private Date fechaInicial;
	@ComparatorTypeField
	private Date fechaFinal;
	@ComparatorTypeField
	private Date fechaInicialE;
	@ComparatorTypeField
	private Date fechaFinalE;
	@ComparatorTypeField
	private Date fechaInicialC;
	@ComparatorTypeField
	private Date fechaFinalC;
	//@ComparatorTypeField
	private Boolean estadoActual;
	@ComparatorTypeField
	private Boolean filtarFechaEla;
	@ComparatorTypeField
	private Boolean filtarFechaEnt;
	@ComparatorTypeField
	private Boolean filtarFechaCad;
	
	public SearchTemplateDTO<String> getNumeroOrdComFil() {
		return numeroOrdComFil;
	}
	public void setNumeroOrdComFil(SearchTemplateDTO<String> numeroOrdComFil) {
		this.numeroOrdComFil = numeroOrdComFil;
	}
	public SearchTemplateDTO<Integer> getAreaTrabajoFil() {
		return areaTrabajoFil;
	}
	public void setAreaTrabajoFil(SearchTemplateDTO<Integer> areaTrabajoFil) {
		this.areaTrabajoFil = areaTrabajoFil;
	}
	public OrdenCompraEstadoDTO getOrdenCompraEstadoPlaBus() {
		return ordenCompraEstadoPlaBus;
	}
	public void setOrdenCompraEstadoPlaBus(
			OrdenCompraEstadoDTO ordenCompraEstadoPlaBus) {
		this.ordenCompraEstadoPlaBus = ordenCompraEstadoPlaBus;
	}
	/*
	public String getCodigoBodega() {
		return codigoBodega;
	}
	public void setCodigoBodega(String codigoBodega) {
		this.codigoBodega = codigoBodega;
	}
	public String getCodigoTipoCatVal() {
		return codigoTipoCatVal;
	}
	public void setCodigoTipoCatVal(String codigoTipoCatVal) {
		this.codigoTipoCatVal = codigoTipoCatVal;
	}
	public String getCodigoEstadoCatVal() {
		return codigoEstadoCatVal;
	}
	public void setCodigoEstadoCatVal(String codigoEstadoCatVal) {
		this.codigoEstadoCatVal = codigoEstadoCatVal;
	}*/
	public Date getFechaInicial() {
		return fechaInicial;
	}
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	public Date getFechaFinal() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaFinal);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		fechaFinal = calendar.getTime();
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public Date getFechaInicialE() {
		return fechaInicialE;
	}
	public void setFechaInicialE(Date fechaInicialE) {
		this.fechaInicialE = fechaInicialE;
	}
	public Date getFechaFinalE() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaFinalE);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		fechaFinalE = calendar.getTime();
		return fechaFinalE;
	}
	public void setFechaFinalE(Date fechaFinalE) {
		this.fechaFinalE = fechaFinalE;
	}
	public Date getFechaInicialC() {
		return fechaInicialC;
	}
	public void setFechaInicialC(Date fechaInicialC) {
		this.fechaInicialC = fechaInicialC;
	}
	public Date getFechaFinalC() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicialC);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		fechaInicialC = calendar.getTime();
		return fechaFinalC;
	}
	public void setFechaFinalC(Date fechaFinalC) {
		this.fechaFinalC = fechaFinalC;
	}
	public Boolean getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(Boolean estadoActual) {
		this.estadoActual = estadoActual;
	}
	public Boolean getFiltarFechaEla() {
		return filtarFechaEla;
	}
	public void setFiltarFechaEla(Boolean filtarFechaEla) {
		this.filtarFechaEla = filtarFechaEla;
	}
	public Boolean getFiltarFechaEnt() {
		return filtarFechaEnt;
	}
	public void setFiltarFechaEnt(Boolean filtarFechaEnt) {
		this.filtarFechaEnt = filtarFechaEnt;
	}
	public Boolean getFiltarFechaCad() {
		return filtarFechaCad;
	}
	public void setFiltarFechaCad(Boolean filtarFechaCad) {
		this.filtarFechaCad = filtarFechaCad;
	}
	public Collection<String> getCodigoComprador() {
		return codigoComprador;
	}
	public void setCodigoComprador(Collection<String> codigoComprador) {
		this.codigoComprador = codigoComprador;
	}
	public SearchTemplateDTO<String> getTipoOrdComFil() {
		return tipoOrdComFil;
	}
	public void setTipoOrdComFil(SearchTemplateDTO<String> tipoOrdComFil) {
		this.tipoOrdComFil = tipoOrdComFil;
	}
	public SearchTemplateDTO<String> getEstadoOrdComFil() {
		return estadoOrdComFil;
	}
	public void setEstadoOrdComFil(SearchTemplateDTO<String> estadoOrdComFil) {
		this.estadoOrdComFil = estadoOrdComFil;
	}
	public PlantillaBusquedaBodega getPlantillaBusquedaBodega() {
		return plantillaBusquedaBodega;
	}
	public void setPlantillaBusquedaBodega(PlantillaBusquedaBodega plantillaBusquedaBodega) {
		this.plantillaBusquedaBodega = plantillaBusquedaBodega;
	}
	public SearchTemplateDTO<String> getNombreFuncionarioFil() {
		return nombreFuncionarioFil;
	}
	public void setNombreFuncionarioFil(SearchTemplateDTO<String> nombreFuncionarioFil) {
		this.nombreFuncionarioFil = nombreFuncionarioFil;
	}
	/**
	 * @return the codigoEstadoOrdenCompra
	 */
	public BaseCriteriaRestriction getCodigoEstadoOrdenCompra() {
		return codigoEstadoOrdenCompra;
	}
	/**
	 * @param codigoEstadoOrdenCompra the codigoEstadoOrdenCompra to set
	 */
	public void setCodigoEstadoOrdenCompra(BaseCriteriaRestriction codigoEstadoOrdenCompra) {
		this.codigoEstadoOrdenCompra = codigoEstadoOrdenCompra;
	}	
}
