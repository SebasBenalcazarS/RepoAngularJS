package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.Calendar;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;
import ec.com.smx.sic.cliente.mdl.dto.impcorp.EmbarqueEstadoImpDTO;

/**
 * @author aguato
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaEmbarque extends BaseSearchTemplate{

	public PlantillaBusquedaEmbarque(Integer codigoCompania) {
		super(codigoCompania);
	}
	private SearchTemplateDTO<String> numeroEmbarqueFil;
	private SearchTemplateDTO<String> numeroFacturaFil;
	private SearchTemplateDTO<String> numeroBLFil;
	private SearchTemplateDTO<String> referendoFil;
	private SearchTemplateDTO<String> manifiestoFil;
	private EmbarqueEstadoImpDTO embarquePlaBus= null;
	
	// filtro de numero de pedido
	private SearchTemplateDTO<String> numeroNotaPedidoFil;
			
	@ComparatorTypeField	 
	private Date fechaInicial;
	@ComparatorTypeField
	private Date fechaFinal;
	@ComparatorTypeField
	private Boolean filtarFechaEla;
		
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
	public Boolean getFiltarFechaEla() {
		return filtarFechaEla;
	}
	public void setFiltarFechaEla(Boolean filtarFechaEla) {
		this.filtarFechaEla = filtarFechaEla;
	}
	
	/*GETTERS AND SETTERS*/
	/**
	 * @return the embarquePlaBus
	 */
	public EmbarqueEstadoImpDTO getEmbarquePlaBus() {
		return embarquePlaBus;
	}
	/**
	 * @param embarquePlaBus the embarquePlaBus to set
	 */
	public void setEmbarquePlaBus(EmbarqueEstadoImpDTO embarquePlaBus) {
		this.embarquePlaBus = embarquePlaBus;
	}
	/**
	 * @return the numeroEmbarqueFil
	 */
	public SearchTemplateDTO<String> getNumeroEmbarqueFil() {
		return numeroEmbarqueFil;
	}
	/**
	 * @param numeroEmbarqueFil the numeroEmbarqueFil to set
	 */
	public void setNumeroEmbarqueFil(SearchTemplateDTO<String> numeroEmbarqueFil) {
		this.numeroEmbarqueFil = numeroEmbarqueFil;
	}
	/**
	 * @return the numeroFacturaFil
	 */
	public SearchTemplateDTO<String> getNumeroFacturaFil() {
		return numeroFacturaFil;
	}
	/**
	 * @param numeroFacturaFil the numeroFacturaFil to set
	 */
	public void setNumeroFacturaFil(SearchTemplateDTO<String> numeroFacturaFil) {
		this.numeroFacturaFil = numeroFacturaFil;
	}
	/**
	 * @return the numeroBLFil
	 */
	public SearchTemplateDTO<String> getNumeroBLFil() {
		return numeroBLFil;
	}
	/**
	 * @param numeroBLFil the numeroBLFil to set
	 */
	public void setNumeroBLFil(SearchTemplateDTO<String> numeroBLFil) {
		this.numeroBLFil = numeroBLFil;
	}
	/**
	 * @return the referendoFil
	 */
	public SearchTemplateDTO<String> getReferendoFil() {
		return referendoFil;
	}
	/**
	 * @param referendoFil the referendoFil to set
	 */
	public void setReferendoFil(SearchTemplateDTO<String> referendoFil) {
		this.referendoFil = referendoFil;
	}
	/**
	 * @return the manifiestoFil
	 */
	public SearchTemplateDTO<String> getManifiestoFil() {
		return manifiestoFil;
	}
	/**
	 * @param manifiestoFil the manifiestoFil to set
	 */
	
	
	public void setManifiestoFil(SearchTemplateDTO<String> manifiestoFil) {
		this.manifiestoFil = manifiestoFil;
	}
	public SearchTemplateDTO<String> getNumeroNotaPedidoFil() {
		return numeroNotaPedidoFil;
	}
	public void setNumeroNotaPedidoFil(SearchTemplateDTO<String> numeroNotaPedidoFil) {
		this.numeroNotaPedidoFil = numeroNotaPedidoFil;
	}
	
	
	
}
