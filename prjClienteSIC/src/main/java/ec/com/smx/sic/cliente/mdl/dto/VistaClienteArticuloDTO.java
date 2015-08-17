
package ec.com.smx.sic.cliente.mdl.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import ec.com.kruger.utilitario.dao.commons.annotations.ComparatorTypeField;
import ec.com.smx.frameworkv2.base.dto.BaseDto;
import ec.com.smx.sic.cliente.mdl.dto.id.VistaClienteArticuloID;


/**
 * Permite gestionar la información correspondiente a VistaClienteArticulo
 *
 * @author mrivera
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SCARTVCLIART")
public class VistaClienteArticuloDTO extends BaseDto<VistaClienteArticuloID> {
	/**
	 * Código del cliente
	 */
	private Long codigoClientePedido;
	
	/**
	 * Código del articulo
	 */
	private String codigoArticulo;
	/**
	 * Código de barras del cupón
	 */
	@ComparatorTypeField
	private String codigoBarras;
	
	/**
	 * Código de la persona
	 */
	private Long codigoPersona;
	/**
	 * Número de documento: Cédula o pasaporte
	 */
	@ComparatorTypeField
	private String numeroDocumento;
	/**
	 * Nombre completo de la persona
	 */
	private String nombreCompleto;
	/**
	 * Nombre del archivo correspondiente a la imagen del cupón.
	 */
//	private String nombreArchivo;
	/**
	 * Valor del Tipo de agrupador del Articulo
	 */
	@ComparatorTypeField
	private String valorTipoAgrupador;
	/**
	 * Estado del registro cliente artículo
	 */
	@ComparatorTypeField
	private String estado ;
	
	/**
	 * Fecha en que el artículo (cupón) fue utilizado por el cliente en sus compras. 
	 */
	private Date fechaUso;
	/**
	 * Fecha de inicio de vigencia del artículo
	 */
//	private Date fechaInicioTemporada;

	/**
	 * Fecha de fin de vigencia del artículo
	 */
//	private Date fechaFinTemporada;
	/**
	 * Descripción de artículo relacionado al cupón
	 */
//	private String descripcionArticulo;
	
	/**
	 * Fecha registro del cupón en el cliente
	 */
	private Date fechaRegistro;
	/**
	 * Fecha última modificación del cupón en el cliente
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the fechaUso
	 */
	public Date getFechaUso() {
		return fechaUso;
	}
	/**
	 * @param fechaUso the fechaUso to set
	 */
	public void setFechaUso(Date fechaUso) {
		this.fechaUso = fechaUso;
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