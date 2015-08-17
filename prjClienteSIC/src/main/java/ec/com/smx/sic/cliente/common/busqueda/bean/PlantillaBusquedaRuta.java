package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * 
 * @author cherrera
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaRuta extends BaseSearchTemplate{

	public PlantillaBusquedaRuta(Integer codigoCompania) {
		super(codigoCompania);
	}

	/**
	 * DECLARACION DE VARIABLES
	 */ 
	private SearchTemplateDTO<Integer> codigoAreaTrabajoOrigenFil; //Corresponde al codigo del area de trabajo origen
	private SearchTemplateDTO<String> descripcionAreaTrabajoOrigenFil; //Corresponde a la descripcion del area de trabajo origen
	private SearchTemplateDTO<Integer> codigoAreaTrabajoDestinoFil; // Corresponde al area de trabajo destino
	private Date fechaDesdeFil; //Corresponde a la fecha desde la cual se quiere realizar la consulta
	private Date fechaHastaFil; //Corresponde a la fecha hasta la cual se quiere realizar la consulta
	private SearchTemplateDTO<String> codigoFurgonFil; //Corresponde al numero de ruta
	private SearchTemplateDTO<String> cabezalFil; //Corresponde al cabezal
	private SearchTemplateDTO<String> tipoMovimientoFil; //Corresponde al tipo de contenedor
	private SearchTemplateDTO<String> estadoRutaFil; //Corresponde al estado en el que se encuentra el contenedor

	/**
	 * DECLARACION DE GETTERS Y SETTERS
	 */
	
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
	 * @return the codigoFurgonFil
	 */
	public SearchTemplateDTO<String> getCodigoFurgonFil() {
		return codigoFurgonFil;
	}
	
	/**
	 * @param codigoFurgonFil the codigoFurgonFil to set
	 */
	public void setCodigoFurgonFil(SearchTemplateDTO<String> codigoFurgonFil) {
		this.codigoFurgonFil = codigoFurgonFil;
	}
	
	/**
	 * @return the cabezalFil
	 */
	public SearchTemplateDTO<String> getCabezalFil() {
		return cabezalFil;
	}
	
	/**
	 * @param cabezalFil the cabezalFil to set
	 */
	public void setCabezalFil(SearchTemplateDTO<String> cabezalFil) {
		this.cabezalFil = cabezalFil;
	}
	
	/**
	 * @return the tipoMovimientoFil
	 */
	public SearchTemplateDTO<String> getTipoMovimientoFil() {
		return tipoMovimientoFil;
	}
	
	/**
	 * @param tipoMovimientoFil the tipoMovimientoFil to set
	 */
	public void setTipoMovimientoFil(SearchTemplateDTO<String> tipoMovimientoFil) {
		this.tipoMovimientoFil = tipoMovimientoFil;
	}
	
	/**
	 * @return the estadoRutaFil
	 */
	public SearchTemplateDTO<String> getEstadoRutaFil() {
		return estadoRutaFil;
	}
	
	/**
	 * @param estadoRutaFil the estadoRutaFil to set
	 */
	public void setEstadoRutaFil(SearchTemplateDTO<String> estadoRutaFil) {
		this.estadoRutaFil = estadoRutaFil;
	}

}
