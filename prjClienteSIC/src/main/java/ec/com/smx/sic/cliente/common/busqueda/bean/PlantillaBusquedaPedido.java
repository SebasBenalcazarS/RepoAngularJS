package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.Calendar;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;
import ec.com.smx.sic.cliente.mdl.dto.PedidoDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaPedido extends BaseSearchTemplate{

	public PlantillaBusquedaPedido(Integer codigoCompania) {
		super(codigoCompania);
	}
	private SearchTemplateDTO<Long> numeroPedidoFil;
	private SearchTemplateDTO<String> numeroOrdComFil;
	private SearchTemplateDTO<Integer> areaTrabajoFil;
	private SearchTemplateDTO<String> tipoPedidoFil;
	private PedidoDTO pedidoPlaBus= null;
	private PlantillaBusquedaBodega plantillaBusquedaBodega = null;
		
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
	@ComparatorTypeField
	private Boolean filtarFechaEla;
	@ComparatorTypeField
	private Boolean filtarFechaEnt;
	@ComparatorTypeField
	private Boolean filtarFechaCad;
	
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
		calendar.setTime(fechaFinalC);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		fechaFinalC = calendar.getTime();
		return fechaFinalC;
	}
	public void setFechaFinalC(Date fechaFinalC) {
		this.fechaFinalC = fechaFinalC;
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
	/**
	 * @return the numeroPedidoFil
	 */
	public SearchTemplateDTO<Long> getNumeroPedidoFil() {
		return numeroPedidoFil;
	}
	/**
	 * @param numeroPedidoFil the numeroPedidoFil to set
	 */
	public void setNumeroPedidoFil(SearchTemplateDTO<Long> numeroPedidoFil) {
		this.numeroPedidoFil = numeroPedidoFil;
	}
	/**
	 * @return the tipoPedidoFil
	 */
	public SearchTemplateDTO<String> getTipoPedidoFil() {
		return tipoPedidoFil;
	}
	/**
	 * @param tipoPedidoFil the tipoPedidoFil to set
	 */
	public void setTipoPedidoFil(SearchTemplateDTO<String> tipoPedidoFil) {
		this.tipoPedidoFil = tipoPedidoFil;
	}
	/**
	 * @return the pedidoPlaBus
	 */
	public PedidoDTO getPedidoPlaBus() {
		return pedidoPlaBus;
	}
	/**
	 * @param pedidoPlaBus the pedidoPlaBus to set
	 */
	public void setPedidoPlaBus(PedidoDTO pedidoPlaBus) {
		this.pedidoPlaBus = pedidoPlaBus;
	}
	/**
	 * @return the numeroOrdComFil
	 */
	public SearchTemplateDTO<String> getNumeroOrdComFil() {
		return numeroOrdComFil;
	}
	/**
	 * @param numeroOrdComFil the numeroOrdComFil to set
	 */
	public void setNumeroOrdComFil(SearchTemplateDTO<String> numeroOrdComFil) {
		this.numeroOrdComFil = numeroOrdComFil;
	}
	/**
	 * @return the areaTrabajoFil
	 */
	public SearchTemplateDTO<Integer> getAreaTrabajoFil() {
		return areaTrabajoFil;
	}
	/**
	 * @param areaTrabajoFil the areaTrabajoFil to set
	 */
	public void setAreaTrabajoFil(SearchTemplateDTO<Integer> areaTrabajoFil) {
		this.areaTrabajoFil = areaTrabajoFil;
	}
	/**
	 * @return the plantillaBusquedaBodega
	 */
	public PlantillaBusquedaBodega getPlantillaBusquedaBodega() {
		return plantillaBusquedaBodega;
	}
	/**
	 * @param plantillaBusquedaBodega the plantillaBusquedaBodega to set
	 */
	public void setPlantillaBusquedaBodega(PlantillaBusquedaBodega plantillaBusquedaBodega) {
		this.plantillaBusquedaBodega = plantillaBusquedaBodega;
	}
}
