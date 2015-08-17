package ec.com.smx.sic.cliente.mdl.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ArticuloLocalAlcanceVO implements Serializable{
	
	private Integer codigoLocal;
	
	private String nombreLocal;
	
	private Integer codigoEstablecimiento;
	
	private String nombreEstablecimiento;
	
	private Boolean detalle = Boolean.FALSE;
	
	private Boolean seleccionado = Boolean.FALSE;
	
	/**
	 * @return the codigoLocal
	 */
	public Integer getCodigoLocal() {
		return codigoLocal;
	}

	/**
	 * @param codigoLocal the codigoLocal to set
	 */
	public void setCodigoLocal(Integer codigoLocal) {
		this.codigoLocal = codigoLocal;
	}

	/**
	 * @return the nombreLocal
	 */
	public String getNombreLocal() {
		return nombreLocal;
	}

	/**
	 * @param nombreLocal the nombreLocal to set
	 */
	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	/**
	 * @return the codigoEstablecimiento
	 */
	public Integer getCodigoEstablecimiento() {
		return codigoEstablecimiento;
	}

	/**
	 * @param codigoEstablecimiento the codigoEstablecimiento to set
	 */
	public void setCodigoEstablecimiento(Integer codigoEstablecimiento) {
		this.codigoEstablecimiento = codigoEstablecimiento;
	}

	/**
	 * @return the nombreEstablecimiento
	 */
	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	/**
	 * @param nombreEstablecimiento the nombreEstablecimiento to set
	 */
	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
	}

	/**
	 * @return the detalle
	 */
	public Boolean getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(Boolean detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}

	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
}
