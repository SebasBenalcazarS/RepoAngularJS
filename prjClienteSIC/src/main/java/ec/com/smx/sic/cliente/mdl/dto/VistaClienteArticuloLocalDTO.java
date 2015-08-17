
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaClienteArticuloLocalID;


/**
 * Permite gestionar la informaci�n correspondiente a VistaClienteArticuloLocal
 *
 * @author mrivera
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTVCLIARTLOC")
public class VistaClienteArticuloLocalDTO extends BaseDto<VistaClienteArticuloLocalID> {

	/**
	 * C�digo del cliente
	 */
	private Long codigoClientePedido;
	
	/**
	 * C�digo del articulo
	 */
	private String codigoArticulo;
	
	/**
	 * C�digo del �rea de trabajo
	 */
	private Integer codigoAreaTrabajo ;
	
	/**
	 * C�digo de referencia al POS (c�digo de enlace)
	 */
	@ComparatorTypeField
	private String codigoReferencia;
	/**
	 * C�digo de la persona
	 */
	private Long codigoPersona;
	/**
	 * N�mero de documento: C�dula o pasaporte
	 */
	@ComparatorTypeField
	private String numeroDocumento;
	/**
	 * Nombre completo de la persona
	 */
	private String nombreCompleto;
	/**
	 * Fecha registro del cup�n en el cliente
	 */
	private Date fechaRegistro;
	/**
	 * Fecha �ltima modificaci�n del cup�n en el cliente
	 */
	private Date fechaModificacion;
	
	/**
	 * @return the codigoClientePedido
	 */
	public Long getCodigoClientePedido() {
		return codigoClientePedido;
	}
	
	/**
	 * @param codigoClientePedido the codigoClientePedido to set
	 */
	public void setCodigoClientePedido(Long codigoClientePedido) {
		this.codigoClientePedido = codigoClientePedido;
	}
	
	/**
	 * @return the codigoArticulo
	 */
	public String getCodigoArticulo() {
		return codigoArticulo;
	}
	
	/**
	 * @param codigoArticulo the codigoArticulo to set
	 */
	public void setCodigoArticulo(String codigoArticulo) {
		this.codigoArticulo = codigoArticulo;
	}
	
	/**
	 * @return the codigoAreaTrabajo
	 */
	public Integer getCodigoAreaTrabajo() {
		return codigoAreaTrabajo;
	}
	
	/**
	 * @param codigoAreaTrabajo the codigoAreaTrabajo to set
	 */
	public void setCodigoAreaTrabajo(Integer codigoAreaTrabajo) {
		this.codigoAreaTrabajo = codigoAreaTrabajo;
	}
	
	/**
	 * @return the codigoReferencia
	 */
	public String getCodigoReferencia() {
		return codigoReferencia;
	}
	/**
	 * @param codigoReferencia the codigoReferencia to set
	 */
	public void setCodigoReferencia(String codigoReferencia) {
		this.codigoReferencia = codigoReferencia;
	}
	/**
	 * @return the codigoPersona
	 */
	public Long getCodigoPersona() {
		return codigoPersona;
	}
	/**
	 * @param codigoPersona the codigoPersona to set
	 */
	public void setCodigoPersona(Long codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	/**
	 * @return the numeroDocumento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento the numeroDocumento to set
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	/**
	 * @return the fechaRegistro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}	
	
}