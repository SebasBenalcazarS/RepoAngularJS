package ec.com.smx.sic.cliente.mdl.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaCuponRentabilidadID;

/**
 * Permite gestionar la informaci�n correspondiente a VistaCuponRentabilidad
 * 
 * @author fvallejo
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "SCARTVCUPREN")
public class VistaCuponRentabilidadDTO extends BaseDto<VistaCuponRentabilidadID> {

	/**
	 * Descripci�n del articulo (cup�n)
	 */
	private String descripcionArticulo;
	
	/**
	 * C�digo de tipo articulo
	 */
	@ComparatorTypeField
	private String codigoTipoArticulo;
	
	/**
	 * Valor actual del articulo (valor de descuento del cup�n si es de valor fijo)
	 */
	private Double valorActual;
	
	/**
	 * C�digo del articulo relacionado al cup�n
	 */
	@ComparatorTypeField
	private String codigoArticuloRelacionado;
	
	/**
	 * Valor actual del articulo relacionado al cup�n
	 */
	private String valorActualArticuloRelacionado;
	
	/**
	 * C�digo del tipo descuento
	 */
	@ComparatorTypeField
	private String codigoTipoDescuento;

	/**
	 * Porcentaje de descuento del cup�n
	 */
	private Double porcentajeDescuento;

	/**
	 * Valor de descuento del cup�n
	 */
	private Double valorDescuento;

	/**
	 * Porcentaje de rentabilidad del cup�n
	 */
	private Double porcentajeRentabilidad;

	/**
	 * 
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	/**
	 * 
	 * @param descripcionArticulo
	 *            the descripcionArticulo to set
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * 
	 * @return the porcentajeDescuento
	 */
	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * 
	 * @return the porcentajeRentabilidad
	 */
	public Double getPorcentajeRentabilidad() {
		return porcentajeRentabilidad;
	}

	/**
	 * 
	 * @param porcentajeRentabilidad the porcentajeRentabilidad to set
	 */
	public void setPorcentajeRentabilidad(Double porcentajeRentabilidad) {
		this.porcentajeRentabilidad = porcentajeRentabilidad;
	}

	/**
	 * 
	 * @param porcentajeDescuento
	 *            the porcentajeDescuento to set
	 */
	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	/**
	 * 
	 * @return the valorDescuento
	 */
	public Double getValorDescuento() {
		return valorDescuento;
	}

	/**
	 * 
	 * @param valorDescuento
	 *            the valorDescuento to set
	 */
	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	/**
	 * 
	 * @return the valorActual
	 */
	public Double getValorActual() {
		return valorActual;
	}

	/**
	 * 
	 * @param valorActual
	 *            the valorActual to set
	 */
	public void setValorActual(Double valorActual) {
		this.valorActual = valorActual;
	}

	/**
	 * 
	 * @return the codigoTipoArticulo
	 */
	public String getCodigoTipoArticulo() {
		return codigoTipoArticulo;
	}

	/**
	 * 
	 * @param codigoTipoArticulo the codigoTipoArticulo to set
	 */
	public void setCodigoTipoArticulo(String codigoTipoArticulo) {
		this.codigoTipoArticulo = codigoTipoArticulo;
	}

	/**
	 * 
	 * @return the codigoTipoDescuento
	 */
	public String getCodigoTipoDescuento() {
		return codigoTipoDescuento;
	}

	/**
	 * 
	 * @param codigoTipoDescuento the codigoTipoDescuento to set
	 */
	public void setCodigoTipoDescuento(String codigoTipoDescuento) {
		this.codigoTipoDescuento = codigoTipoDescuento;
	}

	/**
	 * 
	 * @return the codigoArticuloRelacionado
	 */
	public String getCodigoArticuloRelacionado() {
		return codigoArticuloRelacionado;
	}

	/**
	 * 
	 * @param codigoArticuloRelacionado the codigoArticuloRelacionado to set
	 */
	public void setCodigoArticuloRelacionado(String codigoArticuloRelacionado) {
		this.codigoArticuloRelacionado = codigoArticuloRelacionado;
	}

	/**
	 * 
	 * @return the valorActualArticuloRelacionado
	 */
	public String getValorActualArticuloRelacionado() {
		return valorActualArticuloRelacionado;
	}

	/**
	 * 
	 * @param valorActualArticuloRelacionado the valorActualArticuloRelacionado to set
	 */
	public void setValorActualArticuloRelacionado(String valorActualArticuloRelacionado) {
		this.valorActualArticuloRelacionado = valorActualArticuloRelacionado;
	}

}
