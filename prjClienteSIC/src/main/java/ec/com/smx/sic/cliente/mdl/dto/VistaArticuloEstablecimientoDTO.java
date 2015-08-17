
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaArticuloEstablecimientoID;


/**
 * Permite gestionar la información correspondiente a VistaArticuloEstablecimiento
 *
 * @author mrivera
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTVARTEST")
public class VistaArticuloEstablecimientoDTO extends BaseDto<VistaArticuloEstablecimientoID> {
	
	/**
	 * Código de barras del cupón
	 */
	@ComparatorTypeField
	private String codigoBarras;
	/**
	 * Código de barras del artículo relacionado al cupón
	 */
	@ComparatorTypeField
	private String codigoBarrasArticuloRelacionado;
	/**
	 * Descripción de artículo relacionado al cupón
	 */
	private String descripcionArticuloRelacionado;
	/**
	 * Fecha de creación del cupón
	 */
	private Date fechaCreacion;
	/**
	 * Fecha de última actualización del cupón
	 */
	private Date fechaUltimaActualizacion;
	/**
	 * Nombre del archivo correspondiente a la imagen del cupón.
	 */
	private String nombreArchivo;
	/**
	 * Valor del Tipo de agrupador del Articulo
	 */
	@ComparatorTypeField
	private String valorTipoAgrupador;
	/**
	 * Si el cupón debe anadirse enviar 01, si debe eliminarse se envia 02
	 */
	@ComparatorTypeField
	private String codigoEstado;
	/**
	 * Fecha en que se registró el estado actual del cupón
	 */
	private Date fechaRegistroEstado;
	
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	/**
	 * @return the codigoBarrasArticuloRelacionado
	 */
	public String getCodigoBarrasArticuloRelacionado() {
		return codigoBarrasArticuloRelacionado;
	}
	/**
	 * @param codigoBarrasArticuloRelacionado the codigoBarrasArticuloRelacionado to set
	 */
	public void setCodigoBarrasArticuloRelacionado(String codigoBarrasArticuloRelacionado) {
		this.codigoBarrasArticuloRelacionado = codigoBarrasArticuloRelacionado;
	}
	/**
	 * @return the descripcionArticulo
	 */
	public String getDescripcionArticuloRelacionado() {
		return descripcionArticuloRelacionado;
	}
	/**
	 * @param descripcionArticulo the descripcionArticulo to set
	 */
	public void setDescripcionArticuloRelacionado(String descripcionArticuloRelacionado) {
		this.descripcionArticuloRelacionado = descripcionArticuloRelacionado;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the fechaUltimaActualizacion
	 */
	public Date getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}
	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}
	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * @return the valorTipoAgrupador
	 */
	public String getValorTipoAgrupador() {
		return valorTipoAgrupador;
	}

	/**
	 * @param valorTipoAgrupador the valorTipoAgrupador to set
	 */
	public void setValorTipoAgrupador(String valorTipoAgrupador) {
		this.valorTipoAgrupador = valorTipoAgrupador;
	}
	/**
	 * @return the codigoEstado
	 */
	public String getCodigoEstado() {
		return codigoEstado;
	}
	/**
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	/**
	 * @return the fechaRegistroEstado
	 */
	public Date getFechaRegistroEstado() {
		return fechaRegistroEstado;
	}
	/**
	 * @param fechaRegistroEstado the fechaRegistroEstado to set
	 */
	public void setFechaRegistroEstado(Date fechaRegistroEstado) {
		this.fechaRegistroEstado = fechaRegistroEstado;
	}	
	
}