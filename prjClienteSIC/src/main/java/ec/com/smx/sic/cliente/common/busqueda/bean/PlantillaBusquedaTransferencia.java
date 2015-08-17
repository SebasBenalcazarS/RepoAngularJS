package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.Collection;
import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * 
 * @author cherrera
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaTransferencia extends BaseSearchTemplate{

	public PlantillaBusquedaTransferencia(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * DECLARACION DE VARIABLES
	 */ 
	
	private SearchTemplateDTO<String> numeroContenedorFil; // Corresponde al numero del contenedor
	private SearchTemplateDTO<String> numeroTransferenciaFil; // Corresponde al numero de transferencia
	private SearchTemplateDTO<String> codigoRutaFil; //Corresponde al numero de ruta
	private SearchTemplateDTO<Integer> codigoAreaTrabajoOrigenFil; //Corresponde al codigo del area de trabajo origen
	private SearchTemplateDTO<String> descripcionAreaTrabajoOrigenFil; //Corresponde a la descripcion del area de trabajo origen
	private SearchTemplateDTO<Integer> codigoAreaTrabajoDestinoFil; // Corresponde al area de trabajo destino
	private Date fechaDesdeFil; //Corresponde a la fecha desde la cual se quiere realizar la consulta
	private Date fechaHastaFil; //Corresponde a la fecha hasta la cual se quiere realizar la consulta
	//private SearchTemplateDTO<String> tipoContenedorFil; //Corresponde al tipo de contenedor
	private BaseCriteriaRestriction estadoContenedorFil; //Corresponde al estado en el que se encuentra el contenedor
	private SearchTemplateDTO<String> codigoDepartamentoFil; // Corresponde al departamento
	private Boolean estadoActualFil; //Corresponde al estado actual del contenedor
	//Nuevo, listado de estados
	public Collection<String> estadoTransferenciaDTOLista;
	/**
	 * DECLARACION DE GETTERS Y SETTERS
	 */

	/**
	 * @return the numeroContenedorFil
	 */
	public SearchTemplateDTO<String> getNumeroContenedorFil() {
		return numeroContenedorFil;
	}

	/**
	 * @param numeroContenedorFil the numeroContenedorFil to set
	 */
	public void setNumeroContenedorFil(SearchTemplateDTO<String> numeroContenedorFil) {
		this.numeroContenedorFil = numeroContenedorFil;
	}

	/**
	 * @return the codigoRutaFil
	 */
	public SearchTemplateDTO<String> getCodigoRutaFil() {
		return codigoRutaFil;
	}

	/**
	 * @param codigoRutaFil the codigoRutaFil to set
	 */
	public void setCodigoRutaFil(SearchTemplateDTO<String> codigoRutaFil) {
		this.codigoRutaFil = codigoRutaFil;
	}

	/**
	 * @return the codigoAreaTrabajoOrigenFil
	 */
	public SearchTemplateDTO<Integer> getCodigoAreaTrabajoOrigenFil() {
		return codigoAreaTrabajoOrigenFil;
	}

	/**
	 * @param codigoAreaTrabajoOrigenFil the codigoAreaTrabajoOrigenFil to set
	 */
	public void setCodigoAreaTrabajoOrigenFil(SearchTemplateDTO<Integer> codigoAreaTrabajoOrigenFil) {
		this.codigoAreaTrabajoOrigenFil = codigoAreaTrabajoOrigenFil;
	}

	/**
	 * @return the codigoAreaTrabajoDestinoFil
	 */
	public SearchTemplateDTO<Integer> getCodigoAreaTrabajoDestinoFil() {
		return codigoAreaTrabajoDestinoFil;
	}

	/**
	 * @param codigoAreaTrabajoDestinoFil the codigoAreaTrabajoDestinoFil to set
	 */
	public void setCodigoAreaTrabajoDestinoFil(SearchTemplateDTO<Integer> codigoAreaTrabajoDestinoFil) {
		this.codigoAreaTrabajoDestinoFil = codigoAreaTrabajoDestinoFil;
	}

	/**
	 * @return the tipoContenedorFil
	 */
	/*public SearchTemplateDTO<String> getTipoContenedorFil() {
		return tipoContenedorFil;
	}*/

	/**
	 * @param tipoContenedorFil the tipoContenedorFil to set
	 */
	/*public void setTipoContenedorFil(SearchTemplateDTO<String> tipoContenedorFil) {
		this.tipoContenedorFil = tipoContenedorFil;
	}*/

	/**
	 * @return the estadoContenedorFil
	 */
	public BaseCriteriaRestriction getEstadoContenedorFil() {
		return estadoContenedorFil;
	}

	/**
	 * @param estadoContenedorFil the estadoContenedorFil to set
	 */
	public void setEstadoContenedorFil(BaseCriteriaRestriction estadoContenedorFil) {
		this.estadoContenedorFil = estadoContenedorFil;
	}

	/**
	 * @return the fechaDesdeFil
	 */
	public Date getFechaDesdeFil() {
		return fechaDesdeFil;
	}

	/**
	 * @param fechaDesdeFil the fechaDesdeFil to set
	 */
	public void setFechaDesdeFil(Date fechaDesdeFil) {
		this.fechaDesdeFil = fechaDesdeFil;
	}

	/**
	 * @return the fechaHastaFil
	 */
	public Date getFechaHastaFil() {
		return fechaHastaFil;
	}

	/**
	 * @param fechaHastaFil the fechaHastaFil to set
	 */
	public void setFechaHastaFil(Date fechaHastaFil) {
		this.fechaHastaFil = fechaHastaFil;
	}

	/**
	 * @return the codigoDepartamentoFil
	 */
	public SearchTemplateDTO<String> getCodigoDepartamentoFil() {
		return codigoDepartamentoFil;
	}

	/**
	 * @param codigoDepartamentoFil the codigoDepartamentoFil to set
	 */
	public void setCodigoDepartamentoFil(SearchTemplateDTO<String> codigoDepartamentoFil) {
		this.codigoDepartamentoFil = codigoDepartamentoFil;
	}

	/**
	 * @return the estadoActualFil
	 */
	public Boolean getEstadoActualFil() {
		return estadoActualFil;
	}

	/**
	 * @param estadoActualFil the estadoActualFil to set
	 */
	public void setEstadoActualFil(Boolean estadoActualFil) {
		this.estadoActualFil = estadoActualFil;
	}
	
	/**
	 * @return the numeroTransferenciaFil
	 */
	public SearchTemplateDTO<String> getNumeroTransferenciaFil() {
		return numeroTransferenciaFil;
	}

	/**
	 * @param numeroTransferenciaFil the numeroTransferenciaFil to set
	 */
	public void setNumeroTransferenciaFil(SearchTemplateDTO<String> numeroTransferenciaFil) {
		this.numeroTransferenciaFil = numeroTransferenciaFil;
	}
	
	/**
	 * @return the descripcionAreaTrabajoOrigenFil
	 */
	public SearchTemplateDTO<String> getDescripcionAreaTrabajoOrigenFil() {
		return descripcionAreaTrabajoOrigenFil;
	}

	/**
	 * @param descripcionAreaTrabajoOrigenFil the descripcionAreaTrabajoOrigenFil to set
	 */
	public void setDescripcionAreaTrabajoOrigenFil(SearchTemplateDTO<String> descripcionAreaTrabajoOrigenFil) {
		this.descripcionAreaTrabajoOrigenFil = descripcionAreaTrabajoOrigenFil;
	}

	public Collection<String> getEstadoTransferenciaDTOLista() {
		return estadoTransferenciaDTOLista;
	}

	public void setEstadoTransferenciaDTOLista(Collection<String> estadoTransferenciaDTOLista) {
		this.estadoTransferenciaDTOLista = estadoTransferenciaDTOLista;
	}


}
