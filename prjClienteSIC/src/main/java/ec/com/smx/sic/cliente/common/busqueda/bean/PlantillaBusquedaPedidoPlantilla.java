package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;
import ec.com.smx.sic.cliente.mdl.dto.PedidoPlantillaDTO;
/**
 * 
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaPedidoPlantilla extends BaseSearchTemplate{

	private SearchTemplateDTO<Long> codPlantillaFil;
	private SearchTemplateDTO<Integer> areaTrabajoFil;
	private SearchTemplateDTO<Integer> codDiaSemanaFil;
	private PedidoPlantillaDTO pedidoPlantillaPlaBus= null;
	private PlantillaBusquedaBodega plantillaBusquedaBodega = null;
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoDiaSemana;
	
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
	
	/**
	 * @param codigoCompania
	 */
	public PlantillaBusquedaPedidoPlantilla(Integer codigoCompania) {
		super(codigoCompania);
	}
	
	public SearchTemplateDTO<Integer> getAreaTrabajoFil() {
		return areaTrabajoFil;
	}
	public void setAreaTrabajoFil(SearchTemplateDTO<Integer> areaTrabajoFil) {
		this.areaTrabajoFil = areaTrabajoFil;
	}
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

	/**
	 * @return the codPlantillaFil
	 */
	public SearchTemplateDTO<Long> getCodPlantillaFil() {
		return codPlantillaFil;
	}

	/**
	 * @param codPlantillaFil the codPlantillaFil to set
	 */
	public void setCodPlantillaFil(SearchTemplateDTO<Long> codPlantillaFil) {
		this.codPlantillaFil = codPlantillaFil;
	}

	/**
	 * @return the pedidoPlantillaPlaBus
	 */
	public PedidoPlantillaDTO getPedidoPlantillaPlaBus() {
		return pedidoPlantillaPlaBus;
	}

	/**
	 * @param pedidoPlantillaPlaBus the pedidoPlantillaPlaBus to set
	 */
	public void setPedidoPlantillaPlaBus(PedidoPlantillaDTO pedidoPlantillaPlaBus) {
		this.pedidoPlantillaPlaBus = pedidoPlantillaPlaBus;
	}

	/**
	 * @return the codDiaSemanaFil
	 */
	public SearchTemplateDTO<Integer> getCodDiaSemanaFil() {
		return codDiaSemanaFil;
	}

	/**
	 * @param codDiaSemanaFil the codDiaSemanaFil to set
	 */
	public void setCodDiaSemanaFil(SearchTemplateDTO<Integer> codDiaSemanaFil) {
		this.codDiaSemanaFil = codDiaSemanaFil;
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

	/**
	 * @return the codigoDiaSemana
	 */
	public BaseCriteriaRestriction getCodigoDiaSemana() {
		return codigoDiaSemana;
	}

	/**
	 * @param codigoDiaSemana the codigoDiaSemana to set
	 */
	public void setCodigoDiaSemana(BaseCriteriaRestriction codigoDiaSemana) {
		this.codigoDiaSemana = codigoDiaSemana;
	}
}
