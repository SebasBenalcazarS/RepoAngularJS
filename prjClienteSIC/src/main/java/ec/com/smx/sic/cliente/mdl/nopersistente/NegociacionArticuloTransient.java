/** ec.com.smx.sic.cliente.mdl.nopersistente
 * NegociacionArticuloTransient.java
 * @author srodriguez
 * 11/3/2015
 */
package ec.com.smx.sic.cliente.mdl.nopersistente;

import javax.persistence.Transient;

import ec.com.kruger.utilitario.dao.commons.dto.SearchDTO;

/**
 * @author srodriguez
 *
 */
@SuppressWarnings("serial")
public class NegociacionArticuloTransient extends SearchDTO{

	/** Variable del tipo Boolean SeleccionNegociacionOrdenCompraConvenios.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	@Transient
	private Boolean activoSubBodega;
	/** Variable del tipo Boolean SeleccionNegociacionOrdenCompraConvenios.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	@Transient
	private Boolean activoDepartamento;
	/** Variable del tipo Boolean SeleccionNegociacionOrdenCompraConvenios.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	@Transient
	private Boolean activoClasificacion;
	/** Variable del tipo Boolean SeleccionNegociacionOrdenCompraConvenios.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	@Transient
	private Boolean activoSubClasificacion;
	/** Variable del tipo Boolean SeleccionNegociacionOrdenCompraConvenios.java
	 * @author srodriguez
	 * 11/3/2015
	 */
	@Transient
	private Boolean activoArticulo;
	
	
	/** Variable del tipo Boolean activarMarca
	 * @author dbravo
	 * 17/3/2015
	 */
	@Transient
	private Boolean activoMarca;
	
	/**
	 * Variable del porcentajeCobro activado-desactivado
	 * @author dbravo
	 */
	@Transient
	private Boolean activoPorcentajeCobro;
	
	/**
	 * variable del activoMarcaComercial activo-desactivado
	 */
	@Transient
	private Boolean activoMarcaComercial;
	
	/** Metodo que retorna activoSubBodega del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @return Boolean activoSubBodega 
	 */
	public Boolean getActivoSubBodega() {
		return activoSubBodega;
	}
	/** Metodo que asigna el valor activoSubBodega en activoSubBodega del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @param activoSubBodega
	 */
	
	public void setActivoSubBodega(Boolean activoSubBodega) {
		this.activoSubBodega = activoSubBodega;
	}
	/** Metodo que retorna activoDepartamento del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @return Boolean activoDepartamento 
	 */
	public Boolean getActivoDepartamento() {
		return activoDepartamento;
	}
	/** Metodo que asigna el valor activoDepartamento en activoDepartamento del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @param activoDepartamento
	 */
	
	public void setActivoDepartamento(Boolean activoDepartamento) {
		this.activoDepartamento = activoDepartamento;
	}
	/** Metodo que retorna activoClasificacion del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @return Boolean activoClasificacion 
	 */
	public Boolean getActivoClasificacion() {
		return activoClasificacion;
	}
	/** Metodo que asigna el valor activoClasificacion en activoClasificacion del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @param activoClasificacion
	 */
	
	public void setActivoClasificacion(Boolean activoClasificacion) {
		this.activoClasificacion = activoClasificacion;
	}
	/** Metodo que retorna activoSubClasificacion del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @return Boolean activoSubClasificacion 
	 */
	public Boolean getActivoSubClasificacion() {
		return activoSubClasificacion;
	}
	/** Metodo que asigna el valor activoSubClasificacion en activoSubClasificacion del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @param activoSubClasificacion
	 */
	
	public void setActivoSubClasificacion(Boolean activoSubClasificacion) {
		this.activoSubClasificacion = activoSubClasificacion;
	}
	/** Metodo que retorna activoArticulo del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @return Boolean activoArticulo 
	 */
	public Boolean getActivoArticulo() {
		return activoArticulo;
	}
	/** Metodo que asigna el valor activoArticulo en activoArticulo del objeto
	 * @author srodriguez
	 * 11/3/2015
	 * @param activoArticulo
	 */
	
	public void setActivoArticulo(Boolean activoArticulo) {
		this.activoArticulo = activoArticulo;
	}
	/**
	 * Metodos asigna-retornan valor activoPorcentajeCobro
	 * @author dbravo
	 * @return
	 */
	public Boolean getActivoPorcentajeCobro() {
		return activoPorcentajeCobro;
	}
	public void setActivoPorcentajeCobro(Boolean activoPorcentajeCobro) {
		this.activoPorcentajeCobro = activoPorcentajeCobro;
	}
	/**
	 * @return the activoMarca
	 */
	public Boolean getActivoMarca() {
		return activoMarca;
	}
	/**
	 * @param activoMarca the activoMarca to set
	 */
	public void setActivoMarca(Boolean activoMarca) {
		this.activoMarca = activoMarca;
	}
	/**
	 * @return the activoMarcaComercial
	 */
	public Boolean getActivoMarcaComercial() {
		return activoMarcaComercial;
	}
	/**
	 * @param activoMarcaComercial the activoMarcaComercial to set
	 */
	public void setActivoMarcaComercial(Boolean activoMarcaComercial) {
		this.activoMarcaComercial = activoMarcaComercial;
	}
	
	
}
