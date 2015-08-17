/**
 * 
 */
package ec.com.smx.sic.cliente.common.busqueda.bean;

import java.util.Date;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.kruger.utilitario.dao.commons.dto.SearchTemplateDTO;
import ec.com.kruger.utilitario.dao.commons.hibernate.restriction.BaseCriteriaRestriction;
import ec.com.smx.sic.cliente.common.search.bean.BaseSearchTemplate;

/**
 * 
 * @author Luis Yacchirema
 *  
 * @author gnolivos
 *
 */
@SuppressWarnings("serial")
public class PlantillaBusquedaArticuloPrecios extends BaseSearchTemplate{

	private SearchTemplateDTO<String> codigoProveedor;
	private SearchTemplateDTO<String> codigoEstructuraLogistica;
	@ComparatorTypeField
	private BaseCriteriaRestriction codigosEstructuraComercial;	
	@ComparatorTypeField
	private BaseCriteriaRestriction codigoClaseArticulo;
	private String codigoFuncionario;
	private String codigoEmbarque;
	private Date fechaCreacionArticulos;
	private Boolean consultarDatosPreciosImportacion;


	public PlantillaBusquedaArticuloPrecios(Integer codigoCompania) {
		super(codigoCompania);
	}


	/**
	 * @return the codigoProveedor
	 */
	public SearchTemplateDTO<String> getCodigoProveedor() {
		return codigoProveedor;
	}

	/**
	 * @param codigoProveedor the codigoProveedor to set
	 */
	public void setCodigoProveedor(SearchTemplateDTO<String> codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	/**
	 * @return the codigoEstructuraLogistica
	 */
	public SearchTemplateDTO<String> getCodigoEstructuraLogistica() {
		return codigoEstructuraLogistica;
	}

	/**
	 * @param codigoEstructuraLogistica the codigoEstructuraLogistica to set
	 */
	public void setCodigoEstructuraLogistica(SearchTemplateDTO<String> codigoEstructuraLogistica) {
		this.codigoEstructuraLogistica = codigoEstructuraLogistica;
	}

	/**
	 * @return the codigosEstructuraComercial
	 */
	public BaseCriteriaRestriction getCodigosEstructuraComercial() {
		return codigosEstructuraComercial;
	}

	/**
	 * @param codigosEstructuraComercial the codigosEstructuraComercial to set
	 */
	public void setCodigosEstructuraComercial(BaseCriteriaRestriction codigosEstructuraComercial) {
		this.codigosEstructuraComercial = codigosEstructuraComercial;
	}

	/**
	 * @return the codigoClaseArticulo
	 */
	public BaseCriteriaRestriction getCodigoClaseArticulo() {
		return codigoClaseArticulo;
	}

	/**
	 * @param codigoClaseArticulo the codigoClaseArticulo to set
	 */
	public void setCodigoClaseArticulo(BaseCriteriaRestriction codigoClaseArticulo) {
		this.codigoClaseArticulo = codigoClaseArticulo;
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

	/**
	 * @return the codigoEmbarque
	 */
	public String getCodigoEmbarque() {
		return codigoEmbarque;
	}

	/**
	 * @param codigoEmbarque the codigoEmbarque to set
	 */
	public void setCodigoEmbarque(String codigoEmbarque) {
		this.codigoEmbarque = codigoEmbarque;
	}

	/**
	 * @return the fechaCreacionArticulos
	 */
	public Date getFechaCreacionArticulos() {
		return fechaCreacionArticulos;
	}

	/**
	 * @param fechaCreacionArticulos the fechaCreacionArticulos to set
	 */
	public void setFechaCreacionArticulos(Date fechaCreacionArticulos) {
		this.fechaCreacionArticulos = fechaCreacionArticulos;
	}

	/**
	 * @return the consultarDatosPreciosImportacion
	 */
	public Boolean getConsultarDatosPreciosImportacion() {
		return consultarDatosPreciosImportacion;
	}

	/**
	 * @param consultarDatosPreciosImportacion the consultarDatosPreciosImportacion to set
	 */
	public void setConsultarDatosPreciosImportacion(Boolean consultarDatosPreciosImportacion) {
		this.consultarDatosPreciosImportacion = consultarDatosPreciosImportacion;
	}

}
